package az.payroll.dao;

import az.payroll.Database;
import az.payroll.constants.SQLs;
import az.payroll.model.Account;
import az.payroll.model.Employee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAO extends DAO< Employee > {
	public static final String MONEY = "money";
	public static final String SALARY_RATE = "salary_rate";
	public static final String MONEY_UPDATE_TIME = "salary_rate";

	@Override
	Employee build( ResultSet source ) throws SQLException {
		Employee employee = new Employee( );
		employee.setMoney( source.getInt( MONEY ) );
		employee.setSalaryRate( source.getDouble( SALARY_RATE ) );
		employee.setLastReceivedPaymentDate( source.getLong( MONEY_UPDATE_TIME ) );
		return employee;
	}

	public Employee fillEmployee( Account account ) {
		try( Database db = new Database( ) ){
			PreparedStatement statement = db.getConnection( ).prepareStatement( SQLs.GET_EMPLOYEE_BY_ID );
			statement.setInt( 1, account.getId( ) );
			ResultSet result = statement.executeQuery( );
			if( result.next( ) ) return build( result );
		} catch( SQLException e ){
			System.err.println( "Can't get employee by id :(" );
			e.printStackTrace( );
		}
		return null;
	}
}
