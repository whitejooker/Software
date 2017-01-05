package az.payroll;

import az.payroll.actions.Action;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( name = "Main", urlPatterns = "/asd" )
public class Controller extends HttpServlet {
	protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

	}

	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		ActionFactory factory = new ActionFactory( );
		factory.setUrl( request.getPathInfo( ) );
		Action action = factory.getAction( );
		action.execute( );
		final String page = action.getForwardPath( );
		System.out.println( request.getPathInfo( ) );
		request.getRequestDispatcher( page ).forward( request, response );
	}
}
