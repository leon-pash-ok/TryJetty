package ua.leonpasha.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.leonpasha.dao.SomeDao;
import ua.leonpasha.srvlt.ServletSome;
import ua.leonpasha.srvlt.SrvltCalculator;
import org.eclipse.jetty.server.Handler;
/**
 * Created by HP on 04.06.2017.
 */
public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) throws Exception {
        int port = 8088;
        Server server = new Server(port);

        ServletContextHandler context = new ServletContextHandler( ServletContextHandler.SESSIONS );
        context.setContextPath( "/" );

        // http://localhost:8080/func
        context.addServlet(new ServletHolder( new SrvltCalculator() ),"/func");
        context.addServlet(new ServletHolder( new ServletSome() ),"/hi");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[] { context });
        server.setHandler(handlers);

        try {
            server.start();
            System.out.println("Listening port : " + port );
            logger.info("Listening port : " + port);
            server.join();

        } catch (Exception e) {
            System.out.println("Error.");
            e.printStackTrace();
        }

   /*     Server server = new Server();

        Connector connector = new SelectChannelConnector();
        connector.setPort(8080);
        server.addConnector(connector);
*/
        /*ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[] {"spring/springConfig.xml"});
        SomeDao someDao = (SomeDao) applicationContext.getBean("SomeDao");
        System.out.println("name = " + someDao.getName());*/


        //logger.debug("some text");
    }
}
