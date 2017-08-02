package ua.leonpasha.xml;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * Created by HP on 01.08.2017.
 */
public class LoggingErrorHandler implements ErrorHandler {

    private boolean isValid = true;

    public boolean isValid() {
        return this.isValid;
    }

    @Override
    public void warning(SAXParseException exc) {
        System.out.println("warning");
        this.isValid = false;
    }

    @Override
    public void error(SAXParseException exc) {
        System.out.println("error");
        this.isValid = false;
    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
        System.out.println("fatalError");
        this.isValid = false;
        // Bring things to a crashing halt
        System.out.println("**Parsing Fatal Error**" +
                "  Line:    " + exception.getLineNumber() +
                "  URI:     " + exception.getSystemId() +
                 "  Message: " + exception.getMessage());
        throw new SAXException("Fatal Error encountered");

    }
}
