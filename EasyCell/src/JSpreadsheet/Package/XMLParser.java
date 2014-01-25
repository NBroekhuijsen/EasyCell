package JSpreadsheet.Package;


import java.io.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import org.xml.sax.*;


public class XMLParser {

	/**
	 * Method that reads a XML-file, and returns a Model that contains the
	 * information
	 * 
	 * @param file
	 * @return 
	 * @return
	 */
	
	public static Model readXML(String file) {
		// initialize table to be filled with content of XML file
		Model t = new Model();
		try {
			// Create file to be parsed by document parser
			File xmlfile = new File(file);
			// create parser
			DocumentBuilder parser = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder();
			// parse the file
			Document parsedfile = parser.parse(xmlfile);
			// normalize the parsed file (make it more user-friendly)
			parsedfile.getDocumentElement().normalize();
			
			NodeList cells = parsedfile.getElementsByTagName("CELL");
			for (int i = 0; i < cells.getLength(); i++) {
				// Get cell at list index i
				Node currentcell = cells.item(i);
				// read the elements "location" attributes row/column
				if (Node.ELEMENT_NODE == currentcell.getNodeType()) {
					Element cellinfo = (Element) currentcell;
					// get the row number from node attribute
					int row = Integer.parseInt(cellinfo.getAttribute("row")) - 1;
					// get the column number from the node attribute
					int col = Integer.parseInt(cellinfo
							.getAttribute("column")) -1;
					// get content from node
					String content = cellinfo.getTextContent();
					if (content != null) {
						content = content.replace("\n", "");
					}
					// Make the content an Integer (if it is a number), easier
					// for
					// using it later on
					// put content in table, with row/column inserted as x/y
					t.setContent(row, col, (String) content);
				}
			}

		} catch (ParserConfigurationException e) {
			System.out.println("Fileparser could not be made");
		} catch (IOException f) {
			System.out.println("File could not be parsed, did you enter the correct file name?");
		} catch (SAXException g) {
			System.out.println("Something went wrong in parsing the file");
		}
		return t;
	}

	/**
	 * Writes a table to a XML-file
	 * 
	 * @param t
	 *            - Output Model
	 * @param destination
	 *            - File Destination
	 */
	public static void writeXML(Model t, String destination) {

		try {
			// Create the XML document builder, and document that will be used
			DocumentBuilderFactory xmlBuilder = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder Builder = xmlBuilder.newDocumentBuilder();
			Document xmldoc = Builder.newDocument();

			// create Document node, and get it into the file
			Element Documentnode = xmldoc.createElement("SPREADSHEET");
			xmldoc.appendChild(Documentnode);

			// create element nodes, and their attributes (Cells, and row/column
			// data) and their content
			for (int row = 1; row < t.getRows(); row++) {
				for (int col = 1; col < t.getCols(col); col++) {
					Element cell = xmldoc.createElement("CELL");
					// set attributes
					cell.setAttribute("column", Integer.toString(col));
					cell.setAttribute("row", Integer.toString(col));
					// set content
						cell.appendChild(xmldoc.createTextNode((String) t
								.getContent(row, col)));
					// append node to document node
					Documentnode.appendChild(cell);
				}
			}
			// Creating a datastream for the DOM tree
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			// Indentation to make the XML file look better
			transformer.setOutputProperty(OutputKeys.METHOD, "xml");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			// remove the java version
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION,
					"yes");
			DOMSource stream = new DOMSource(xmldoc);
			StreamResult target = new StreamResult(new File(destination));
			// write the file
			transformer.transform(stream, target);

		} catch (ParserConfigurationException e) {
			System.out.println("Can't create the XML document builder");
		} catch (TransformerConfigurationException e) {
			System.out.println("Can't create transformer");
		} catch (TransformerException e) {
			System.out.println("Can't write to file");
		}
	}
}

