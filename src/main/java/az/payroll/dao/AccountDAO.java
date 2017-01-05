package az.payroll.dao;

import az.payroll.Database;
import az.payroll.constants.SQLs;
import az.payroll.model.Account;
import az.payroll.model.AccountType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class AccountDAO extends DAO< Account > {
	public static final String NAME = "name";
	public static final String SURNAME = "surname";
	public static final String LOGIN = "login";
	public static final String PASSWORD = "password";
	public static final String EMAIL = "email";
	public static final String TYPE = "type";
	public static final String REGISTRATION_TIME = "registration_time";

	@Override
	Account build( ResultSet source ) throws SQLException {
		Account account = new Account( );
		account.setId( source.getInt( ID ) );
		account.setLogin( source.getString( LOGIN ) );
		account.setPassword( source.getString( PASSWORD ) );
		account.setName( source.getString( NAME ) );
		account.setSurname( source.getString( SURNAME ) );
		account.setEmail( source.getString( EMAIL ) );
		account.setType( AccountType.buildAccountTypeFromString( source.getString( TYPE ) ) );
		account.setRegistrationDate( source.getLong( REGISTRATION_TIME ) );
		return account;
	}

	public Optional< Account > getAccountById( int id ) {
		Optional< Account > account = Optional.empty( );
		try( Database db = new Database( ) ){
			PreparedStatement statement = db.getConnection( ).prepareStatement( SQLs.GET_ACCOUNT_BY_ID );
			statement.setInt( 1, id );
			ResultSet result = statement.executeQuery( );
			if( result.next( ) ) account = Optional.of( build( result ) );
		} catch( SQLException e ){
			System.err.println( "Can't get account by id :(" + id );
			e.printStackTrace( );
		}
		return account;
	}

	public Optional< Account > getAccountByLoginPassword( String login, String password ) {
		Optional< Account > account = Optional.empty( );
		try( Database db = new Database( ) ){
			PreparedStatement statement = db.getConnection( ).prepareStatement( SQLs.GET_ACCOUNT_BY_LOGIN_AND_PASSWORD );
			statement.setString( 1, login );
			statement.setString( 2, password );
			ResultSet result = statement.executeQuery( );
			if( result.next( ) ) account = Optional.of( build( result ) );
		} catch( SQLException e ){
			System.err.println( "Can't get account by login and password :(" + login + " " + password );
			e.printStackTrace( );
		}
		return account;
	}
}