package az.payroll.model;

import java.util.Date;
import java.util.List;

public class Account {
	protected int id;
	protected String login;
	protected String password;
	protected String name;
	protected String surname;
	protected String email;
	protected AccountType type;
	protected Date registrationDate;
	protected List< Payment > payments;

	public void setRegistrationDate( Date registrationDate ) { this.registrationDate = registrationDate; }

	public List< Payment > getPayments( ) { return payments; }

	public void setPayments( List< Payment > payments ) { this.payments = payments; }

	@Override
	public String toString( ) {
		return "Account{" +
				"id=" + id +
				", login='" + login + '\'' +
				", password='" + password + '\'' +
				", name='" + name + '\'' +
				", surname='" + surname + '\'' +
				", email='" + email + '\'' +
				", type=" + type +
				", registrationDate=" + registrationDate +
				'}';
	}

	public int getId( ) { return id; }

	public void setId( int id ) { this.id = id; }

	public String getLogin( ) { return login; }

	public void setLogin( String login ) { this.login = login; }

	public String getPassword( ) { return password; }

	public void setPassword( String password ) { this.password = password; }

	public String getName( ) { return name; }

	public void setName( String name ) { this.name = name; }

	public String getSurname( ) { return surname; }

	public void setSurname( String surname ) { this.surname = surname; }

	public String getEmail( ) { return email; }

	public void setEmail( String email ) { this.email = email; }

	public AccountType getType( ) { return type; }

	public void setType( AccountType type ) { this.type = type; }

	public Date getRegistrationDate( ) { return registrationDate; }

	public void setRegistrationDate( long registrationTimeInSeconds ) {
		registrationDate = new Date( registrationTimeInSeconds * 1000 );
	}
}