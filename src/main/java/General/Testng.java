package General;

import org.testng.TestNG;
import org.testng.xml.Parser;
import org.testng.xml.XmlSuite;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;



/**
 * Created by Dmitriy on 9/13/2016.
 */


public class Testng {

    public static void main(String[] args) {

        TestNG testng = new TestNG();
        String xmlFileName = "testng.xml";
        List<XmlSuite> suite;
        try
        {
            suite = (List<XmlSuite>)(new Parser(xmlFileName).parse());
            testng.setXmlSuites(suite);
            testng.run();
        }
        catch (ParserConfigurationException e)
        {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
