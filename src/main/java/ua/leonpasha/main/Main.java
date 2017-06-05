package ua.leonpasha.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.leonpasha.dao.SomeDao;

/**
 * Created by HP on 04.06.2017.
 */
public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) throws Exception {

   /*     Server server = new Server();

        Connector connector = new SelectChannelConnector();
        connector.setPort(8080);
        server.addConnector(connector);
*/
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[] {"spring/springConfig.xml"});
        SomeDao someDao = (SomeDao) applicationContext.getBean("SomeDao");
        System.out.println("name = " + someDao.getName());


        logger.debug("some text");
    }
}
