package pl.connectis.cschool.helloweb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form")
public class PersonDataServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		PrintWriter out = response.getWriter();
		out.println("<html><body>"
				//form data ma method ='get' juz z ogory
				+ "<form action = 'formdata' method ='post'>"
				+ "Podaj imie: "
				+ "<br><input type = 'text' name = 'imie' value ='Twoje imie'></br>"
				+ "Podaj nazwisko: "
				+ "<br><input type = 'text' surname = 'nazwisko' value ='Twoje nazwisko'></br>"
				
				+ "Podaj rok urodzenia: "
				+ "<br><input type = 'text' data = 'rokurodzenia' value ='Twoj rok urodzenia'></br>"
				
				+ "<br>Jakie masz hobby?</br>"
				+ "<input type='checkbox' name='hobby' value='muzyka' />Muzyka<br />"
			    + "<input type='checkbox' name='hobby' value='taniec' />Taniec<br />"
				+ "<input type='checkbox' name='hobby' value='plywanie' />Plywanie<br />"
				+ "<input type='checkbox' name='hobby' value='spiew' />Spiew<br/>"
				+ "<input type='checkbox' name='hobby' value='zabawa' />Zabawa<br />"
				
				+ "<br>Gdzie mieszkasz?</br>"
				+ "<select name='zamieszkanie' multiple='multiple' size='4'>"
				+ "<option selected='selected'>Miasto >500 tys mieszkancow</option>"
				+ "<option>Miasto >100 tys mieszkancow</option>"
				+ "<option>Miasto <100 tys mieszkancow</option>"
				+ "<option>Wies</option>"
			    + " </select>"
				
				+ "<button type = 'submit'>OK</button><br></br>"
				+ "</form>"
				+ "Go back and change <a href='hello'> a form </a>"
				+ "</body></html>");
	
	}
	
	
	
	
	

}
