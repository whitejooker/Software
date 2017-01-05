package az.payroll.model;

import java.util.Date;

public class Employee extends Account {
	private int money;
	private double salaryRate;
	private Date lastReceivedPaymentDate;

	@Override
	public String toString( ) {
		return "Employee{" +
				"money=" + money +
				", salaryRate=" + salaryRate +
				", lastReceivedPaymentDate=" + lastReceivedPaymentDate +
				'}';
	}

	public int getMoney( ) { return money; }

	public void setMoney( int money ) { this.money = money; }

	public double getSalaryRate( ) { return salaryRate; }

	public void setSalaryRate( double salaryRate ) { this.salaryRate = salaryRate; }

	public Date getLastReceivedPaymentDate( ) { return lastReceivedPaymentDate; }

	public void setLastReceivedPaymentDate( long lastPaymentDateInSeconds ) {
		lastReceivedPaymentDate = new Date( lastPaymentDateInSeconds*1000 );
	}
}
