package pl.connectis.cschool.helloweb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/formdata")
public class FormDataServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String imie = request.getParameter("imie");
		String nazwisko = request.getParameter("nazwisko");
		String rokurodzenia = request.getParameter("rokurodzenia");
	//	int rokurodzenia = Integer.parseInt(rok);

		String [] hobby = request.getParameterValues("hobby");
		String [] zamieszkanie = request.getParameterValues("zamieszkanie");
		
		PrintWriter out = response.getWriter();
		

		out.println("<html><body>"
				+ "<h3>Imie to: " +imie +"</h3>"
				+ "<h3>Nazwisko to: " +nazwisko +"</h3>"
				+ "<h3>Rok rodzenia to: " +rokurodzenia +"</h3>");
				out.println("<ul>");
				
				out.println("<br><h3>Twoje hobby:</h3></br>");
				for (String item : hobby){
					out.println("<li>" +item);
				}
				out.println("<br><h3>Miejsce zamieszkania:</h3></br>");
				for (String miasto : zamieszkanie){
					out.println("<li>" +miasto);
				}
				out.println("</ul>");
				out.println("</body></html>");

		
	}
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//jesli obsluga nie rozni sie niczym innym, to wystarczy wywolanie doGet.
			// w innym przypadku kopiuj-wklej
			doGet(request, response);
	}

}
