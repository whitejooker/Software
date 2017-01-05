package az.payroll.model;

public enum AccountType {
	GOVERNMENT, EMPLOYER, EMPLOYEE;

	public static AccountType buildAccountTypeFromString( String name ) {
		for( AccountType type : AccountType.values( ) ){
			if( type.toString( ).equalsIgnoreCase( name ) ) return type;
		}
		return AccountType.EMPLOYER;
	}

	@Override
	public String toString( ) {
		return name( ).toLowerCase( );
	}
}