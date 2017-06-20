package pl.connectis.cschool.helloweb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	PrintWriter out = response.getWriter();
	
	out.println("<html><body><h1>Wype³nij formularz!</h1>"
			+ "Fill <a href='form'>  a form </a>"
			+ "</body></html>");
	//zamykanie wlasnych strumieni
	out.close();		
	}
}
