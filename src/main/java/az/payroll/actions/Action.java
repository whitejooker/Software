package az.payroll.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Action {
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected String forwardPath;

	public String getForwardPath( ) {
		return forwardPath;
	}

	public void setRequest( HttpServletRequest request ) {
		this.request = request;
	}

	public void setResponse( HttpServletResponse response ) {
		this.response = response;
	}

	public abstract void execute( );
}