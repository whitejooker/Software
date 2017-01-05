package az.payroll.constants;

import org.intellij.lang.annotations.Language;

public interface SQLs {
	@Language( "MySQL" )
	String GET_ACCOUNT_BY_ID = "SELECT * FROM account WHERE id = ?";
	@Language( "MySQL" )
	String GET_ACCOUNT_BY_LOGIN_AND_PASSWORD = "SELECT * FROM account WHERE login = ? AND password = ?";
	@Language( "MySQL" )
	String GET_EMPLOYEE_BY_ID = "SELECT * FROM employee WHERE id = ?";
}
