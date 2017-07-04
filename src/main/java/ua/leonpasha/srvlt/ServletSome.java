package ua.leonpasha.srvlt;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by HP on 04.07.2017.
 */
public class ServletSome extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(ServletSome.class);


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.debug("doPost");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.debug("doGet");
        PrintWriter out = response.getWriter();
        out.append("<html>\n" +
                "<body>\n" +
                "<h2>Hello World!</h2>\n" +
                "</body>\n" +
                "</html>");
        response.setStatus( HttpServletResponse.SC_OK );

    }
}
