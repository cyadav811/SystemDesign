package com.systemDesign.creational.factory;

public class OracleDataBaseConnection implements DataBaseConnection{
	
 public final String name;
	 
	 public OracleDataBaseConnection() {
		 this.name = DataBaseConnectionName.OracleBaseConnection.toString();
	 }
 }
