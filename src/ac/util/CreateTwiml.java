package ac.util;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.MessageFormat;
import java.util.Properties;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.apache.log4j.Logger;

public class CreateTwiml {
	private static final Logger logger = Logger
			.getLogger(CreateTwiml.class);
	
	public Boolean CreateTwimlXML(String sId){
		logger.info("Entered CreateTwimlXML method of CreateTwiml");
		Boolean twimlCreated = false;
	    OutputStream out1 = null;
	    InputStream filecontent = null;
        Properties prop1 = new Properties();
        InputStream resourceAsStream1 = Thread.currentThread().getContextClassLoader().getResourceAsStream("ac/resources/Path.properties");
        try {
			prop1.load(resourceAsStream1);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("Response");
			doc.appendChild(rootElement);
			
			
			// Dial element
			Element staff = doc.createElement("Dial");
			rootElement.appendChild(staff);
			
			// Conference element
			Element Conference = doc.createElement("Conference");
			
			Conference.appendChild(doc.createTextNode("Room " + sId));
			staff.appendChild(Conference);
			
			// set attribute to Conference element
			Attr attr = doc.createAttribute("beep");
			attr.setValue("false");
			Conference.setAttributeNode(attr);
			// set attribute to Conference element
			Attr attr1 = doc.createAttribute("startConferenceOnEnter");
			attr1.setValue("true");
			Conference.setAttributeNode(attr1);			// set attribute to Conference element
			Attr attr2 = doc.createAttribute("endConferenceOnExit");
			attr2.setValue("true");
			Conference.setAttributeNode(attr2);
			Attr attr3 = doc.createAttribute("record");
			attr3.setValue("record-from-start");
			Conference.setAttributeNode(attr3);
			Attr attr4 = doc.createAttribute("eventCallbackUrl");
			attr4.setValue("https://www.advisorcircuit.com/Demo/RecordingController");
			Conference.setAttributeNode(attr4);
			   File file = new File(MessageFormat.format(prop1.getProperty("TWIML"), sId));
	              if (!file.exists()) {
	             file.mkdirs();
	             }
	                out1 = new FileOutputStream(new File(MessageFormat.format(prop1.getProperty("TWIML"), sId) + File.separator
	                        + "twiml.xml"));
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(MessageFormat.format(prop1.getProperty("TWIML"), sId) + File.separator+ "twiml.xml");

			// Output to console for testing
			// StreamResult result = new StreamResult(System.out);

			transformer.transform(source, result);

			System.out.println("Twiml Created & Saved");
			twimlCreated = true;
			
		} catch (ParserConfigurationException e) {
			logger.error("CreateTwimlXML method of CreateTwiml threw error:"+ e.getMessage());
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			logger.error("CreateTwimlXML method of CreateTwiml threw error:"+ e.getMessage());
			e.printStackTrace();
		} catch (TransformerException e) {
			logger.error("CreateTwimlXML method of CreateTwiml threw error:"+ e.getMessage());
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		      if (out1 != null) {
		          try {
						out1.close();
					} catch (IOException e) {
						logger.error("putCV method of SetCV threw error:"+e.getMessage());
						e.printStackTrace();
					}
		      }

		}

		
		
		
		logger.info("Entered CreateTwimlXML method of CreateTwiml");
		return twimlCreated;
		
	}
	
}
