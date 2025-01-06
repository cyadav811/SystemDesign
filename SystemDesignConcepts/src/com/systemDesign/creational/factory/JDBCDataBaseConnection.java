
package com.systemDesign.creational.factory;

public class JDBCDataBaseConnection implements DataBaseConnection{
	 public final String name;
	 
	 public JDBCDataBaseConnection() {
		 this.name = DataBaseConnectionName.JDBCDataBaseConnection.toString();
	 }
}