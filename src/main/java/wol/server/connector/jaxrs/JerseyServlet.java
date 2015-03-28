package wol.server.connector.jaxrs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.glassfish.jersey.servlet.ServletContainer;

//import com.sun.jersey.spi.spring.container.servlet.SpringServlet;

@WebServlet( name="restServlet", displayName="Rest Servlet", urlPatterns = {"/rs/*"}, loadOnStartup=0)/*,
initParams = {
	    @WebInitParam(name = "com.sun.jersey.config.property.packages",
	            value = "wol.server.connector.jaxrs.resource")})*/
public class JerseyServlet extends HttpServlet{ //SpringServlet extends ServletContainer
	private static final long serialVersionUID = -5282823652881942473L;

	/*@Override
	public void init() throws ServletException {
		super.init();
	    System.out.println("Started");
	}*/
	
	 @Override
	    public void doGet(HttpServletRequest request,
	            HttpServletResponse response)
	            throws ServletException, IOException {

	        response.setContentType("text/html");
	        response.setBufferSize(8192);
	        PrintWriter out = response.getWriter();

	        // then write the data of the response
	        out.println("<html lang=\"en\">"
	                + "<head><title>Servlet Hello</title></head>");

	        // then write the data of the response
	        out.println("<body  bgcolor=\"#ffffff\">"
	            + "<img src=\"duke.waving.gif\" alt=\"Duke waving his hand\">"
	            + "<form method=\"get\">"
	            + "<h2>Hello, my name is Duke. What's yours?</h2>"
	            + "<input title=\"My name is: \"type=\"text\" "
	            + "name=\"username\" size=\"25\">"
	            + "<p></p>"
	            + "<input type=\"submit\" value=\"Submit\">"
	            + "<input type=\"reset\" value=\"Reset\">"
	            + "</form>");

	        String username = request.getParameter("username");
	        if (username != null && username.length() > 0) {
	            RequestDispatcher dispatcher =
	                    getServletContext().getRequestDispatcher("/response");

	            if (dispatcher != null) {
	                dispatcher.include(request, response);
	            }
	        }
	        out.println("</body></html>");
	        out.close();
	    }
}
