package az.payroll;

import az.payroll.actions.Action;
import az.payroll.actions.GetLoginAction;

public class ActionFactory {
	private String url;

	private String parseUrl( ) {
		int lastOccurrence = url.lastIndexOf( '/' ) + 1;
		String actionName = "";
		if( lastOccurrence > 0 ) actionName = url.substring( lastOccurrence );
		return actionName;
	}

	public void setUrl( String url ) {
		this.url = url;
	}

	public Action getAction( ) {
		String actionName = parseUrl( );
		// ...
		Action action = new GetLoginAction( );
		return action;
	}
}
