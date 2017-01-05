package az.payroll.model;

import java.util.Date;

public class Payment {
	private int id;
	private Date transactionDate;
	private Account payer;
	private Account receiver;
	private int amount;

	public int getId( ) { return id; }

	public void setId( int id ) { this.id = id; }

	public Date getTransactionDate( ) { return transactionDate; }

	public void setTransactionDate( long transactionTimeInSeconds ) {
		transactionDate = new Date( transactionTimeInSeconds );
	}

	public Account getPayer( ) { return payer; }

	public void setPayer( Account payer ) { this.payer = payer; }

	public Account getReceiver( ) { return receiver; }

	public void setReceiver( Account receiver ) { this.receiver = receiver; }

	public int getAmount( ) { return amount; }

	public void setAmount( int amount ) { this.amount = amount; }
}