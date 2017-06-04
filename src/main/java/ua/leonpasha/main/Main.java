package ua.leonpasha.main;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by HP on 04.06.2017.
 */
public class Main {

    public static void main(String[] args) throws Exception {

   /*     Server server = new Server();

        Connector connector = new SelectChannelConnector();
        connector.setPort(8080);
        server.addConnector(connector);
*/
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(new String[] {"config.xml"});


    }
}
