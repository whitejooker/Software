package az.payroll;

import az.payroll.constants.General;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.Closeable;
import java.sql.Connection;
import java.sql.SQLException;

public class Database implements Closeable {

	private Connection connection;

	public Database( ) {
		try{
			getConnection( );
		} catch( SQLException e ){
			System.err.println( "Can't create a Database object" );
			e.printStackTrace( );
		}
	}

	// getters and setters
	public synchronized Connection getConnection( ) throws SQLException {
		if( connection == null || connection.isClosed( ) ){
			try{
				Context context = new InitialContext( );
				DataSource dataSource = ( DataSource ) context.lookup( General.JDBC_URI );
				connection = dataSource.getConnection( );
				connection.setAutoCommit( false );
			} catch( NamingException e ){
				System.err.println( "Can't get a connection" );
				e.printStackTrace( );
			}
		}
		return connection;
	}

	public void close( ) {
		try{
			if( connection != null && !connection.isClosed( ) ){
				connection.commit( );
				connection.close( );
			}
		} catch( SQLException e ){
			System.err.println( "Can't close connection" );
			e.printStackTrace( );
		}
	}
}