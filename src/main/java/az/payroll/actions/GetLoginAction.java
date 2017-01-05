package az.payroll.actions;

import az.payroll.constants.Attributes;

import java.util.List;

public class GetLoginAction extends Action{
	public static final String INDEX_PAGE = "index.jsp";
	public List< String > errors = null;
	@Override
	public void execute( ) {
		if( errors != null ) request.setAttribute( Attributes.REQUEST_ERRORS, errors );
		forwardPath = INDEX_PAGE;
	}
}
