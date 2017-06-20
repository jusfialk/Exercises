package pl.connectis.cschool.hellowebcalculator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class HelloWebCalculator extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>"
				//form data ma method ='get' juz z ogory
				//samo do siebie
				+ "<form action = 'formdata' method ='post'>"
				+ "<td><input type = 'text' name = 'cyfra1' placeholder=0></td>"
				+ "<td><br><input type = radio name = 'operation' value='1'>Dodaj</br>"
				+ "<br><input type = radio name = 'operation' value='2'>Usun</br>"
				+ "<br><input type = radio name = 'operation' value='3'>Mnoz</br>"
				+ "<td><input type = 'text' name = 'cyfra2' placeholder=0></td>"
				+ "<td><br><button type = 'submit' name ='wynik'>=</br></td>"
				+ "</form>"
				+ "</body></html>");
				
		
		
		if(request.getParameter("operation") != null){
			
			Integer cyferka1 = Integer.parseInt(request.getParameter("cyfra1"));
			Integer cyferka2 = Integer.parseInt(request.getParameter("cyfra2"));
		  	double wynik = 0;
		  	
			switch(Integer.parseInt(request.getParameter("operation"))){
				//dodawanie
				case 1:
					wynik = cyferka1 + cyferka2;
				//odejmowanie	
				case 2:
					wynik = cyferka1 -cyferka2;
				break;
				//mnozenie
				case 3:
					wynik = cyferka1 * cyferka2;
				default:
					break;
			}
			
			Integer wyniczek = Integer.parseInt(request.getParameter("wynik"));
			
							
			out.println(wyniczek+"<html><body>");
	
	
	//zamykanie wlasnych strumieni
	out.close();		
		}
	}
}

