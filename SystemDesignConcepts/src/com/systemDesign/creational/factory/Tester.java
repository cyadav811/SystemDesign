package com.systemDesign.creational.factory;

public class Tester {
	
	public static void main(String[] args) throws Exception {		
		DataBaseConnection connection = DataBaseConnectionFactory.prepareConnection(DataBaseConnectionName.OracleBaseConnection);
}

}
