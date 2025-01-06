package com.systemDesign.creational.factory;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class DataBaseConnectionFactory {

	   
		private static HashMap<DataBaseConnectionName,DataBaseConnection> connectionFactory = null;
		
		
		public static DataBaseConnection prepareConnection(DataBaseConnectionName connectionName) throws Exception{ 
			
			
			
			if(connectionName==null) {
			throw new Exception("Invalid Connection Name");
		}
			
			if(connectionName.equals(DataBaseConnectionName.JDBCDataBaseConnection)) {
				return new JDBCDataBaseConnection();
			}
			if(connectionName.equals(DataBaseConnectionName.OracleBaseConnection)) {
				return new OracleDataBaseConnection();
			}
			
			return null;
//			connectionList();
//		if(connectionName==null) {
//				throw new Exception("Invalid Connection Name");
//			}
//			
//			System.out.println(connectionName.name());
//			return connectionFactory.get(connectionName);
//			
		}
			
		
//		
//		public static void connectionList() {
//		connectionFactory = new LinkedHashMap<>();
//		connectionFactory.put(DataBaseConnectionName.JDBCDataBaseConnection,new JDBCDataBaseConnection());
//		connectionFactory.put(DataBaseConnectionName.OracleBaseConnection,new OracleDataBaseConnection());
//			
//		}

}
