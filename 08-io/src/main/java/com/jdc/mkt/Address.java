 package com.jdc.mkt;

class Address{
 	
	private String street;
	private String township;
	private String city;

	//setValues with Constructor
	Address(String street,String township,String city){
		this.street = street;
		this.township = township ;
		this.city = city ;
	}
	//getValues for each fields;
	String getStreet(){
		return street;
	}

	String getTownship(){
		return township ;
	}

	String getCity(){
		return city;
	}
}