package az.payroll.model;

import java.util.Date;

public class GovernmentInstitution extends Account {
	private int money;
	private Date lastReceivedPaymentDate;

	public int getMoney( ) { return money; }

	public void setMoney( int money ) { this.money = money; }

	public Date getLastReceivedPaymentDate( ) { return lastReceivedPaymentDate; }

	public void setLastReceivedPaymentDate( long lastReceivedPaymentDateInSeconds ) {
		lastReceivedPaymentDate = new Date( lastReceivedPaymentDateInSeconds * 1000 );
	}
}
