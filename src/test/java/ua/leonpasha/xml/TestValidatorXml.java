package ua.leonpasha.xml;

import org.junit.Test;

import java.io.*;

/**
 * Created by HP on 01.08.2017.
 */
public class TestValidatorXml {
    @Test
    public void testValidator(){
        InputStream xml = null;
        InputStream xsd = null;
        try {
            File initialFileXml = new File("C://xml_test//demo-1.xml");
            xml = new FileInputStream(initialFileXml);
            File initialFileXsd = new File("C://xml_test//demo-1.xsd");
            xsd = new FileInputStream(initialFileXsd);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        boolean res = ValidatorXml.validateAgainstXSD(xml, xsd);
        System.out.println("res = " + res);
    }

}
