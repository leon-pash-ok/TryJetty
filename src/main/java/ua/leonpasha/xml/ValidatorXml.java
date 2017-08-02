package ua.leonpasha.xml;





import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by LeonPasha on 01.08.2017.
 */
public class ValidatorXml {
    private String pathFile;
    public ValidatorXml(String pathFile) {
        this.pathFile = pathFile;
    }
    static boolean validateAgainstXSD(InputStream xml, InputStream xsd)
    {
        List<SAXParseException> exceptions = new LinkedList<SAXParseException>();
        LoggingErrorHandler errorHandler = new LoggingErrorHandler();
        try {
            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new StreamSource(xsd));
            Validator validator = schema.newValidator();
            validator.setErrorHandler(errorHandler);
            /*validator.setErrorHandler(new ErrorHandler() {
                @Override
                public void warning(SAXParseException exception) throws SAXException {
                    System.out.println("e");
                    exceptions.add(exception);
                }

                @Override
                public void fatalError(SAXParseException exception) throws SAXException {
                    System.out.println("e");
                    exceptions.add(exception);
                }

                @Override
                public void error(SAXParseException exception) throws SAXException {
                    System.out.println("e");
                    exceptions.add(exception);
                }
            });*/
            validator.validate(new StreamSource(xml));
            if (!errorHandler.isValid()) {
                System.out.println("not valid");
            }
            return true;

        } catch (SAXException e) {
            System.out.println("SAXException");
            System.out.println(e);
            System.out.println(exceptions.toString());
            return false;
   /*     }catch (SAXParseException e){
            System.out.println("SAXParseException");
            System.out.println(e);
            System.out.println(exceptions.toString());
            return false;*/
        }catch(Exception ex){
            System.out.println("Exception");
            System.out.println(ex);
            System.out.println(exceptions.toString());
            return false;
        }

        /*
        try {
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = factory.newSchema(new StreamSource(xsd));
        Validator validator = schema.newValidator();
        StreamSource xmlFile = new StreamSource(xml);
        validator.validate(xmlFile);


    } catch (IOException e) {
        e.printStackTrace();
    }
        * */
    }
    private static class MyErrorHandler extends DefaultHandler {
        public void warning(SAXParseException e) throws SAXException {
            System.out.println("Warning: ");
            printInfo(e);
        }
        public void error(SAXParseException e) throws SAXException {
            System.out.println("Error: ");
            printInfo(e);
        }
        public void fatalError(SAXParseException e) throws SAXException {
            System.out.println("Fattal error: ");
            printInfo(e);
        }
        private void printInfo(SAXParseException e) {
            System.out.println("   Public ID: "+e.getPublicId());
            System.out.println("   System ID: "+e.getSystemId());
            System.out.println("   Line number: "+e.getLineNumber());
            System.out.println("   Column number: "+e.getColumnNumber());
            System.out.println("   Message: "+e.getMessage());
        }
    }
}
