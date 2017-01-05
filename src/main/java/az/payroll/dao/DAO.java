package az.payroll.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class DAO< T > {
	public static final String ID = "id";

	abstract T build( ResultSet source ) throws SQLException;
}
