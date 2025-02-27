package com;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import oracle.jdbc.OracleDriver;

public class ResultSetTypes {

	public static void main(String[] args) {

		try {

			Properties props = new Properties();
			FileInputStream fis = new FileInputStream("src/data.properties");

			props.load(fis);

			Class.forName(props.getProperty("driverClass"));

			Connection con = DriverManager.getConnection(props.getProperty("url"), props.getProperty("userName"),
					props.getProperty("password"));

		
			String qry="select * from product";
			
			Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			
			ResultSet rs=stmt.executeQuery(qry);
			
			//stmt.close();
			
		
			rs.absolute(3);
			rs.updateString(2, "Mobile");
			rs.updateRow();
			
			
			System.out.println(rs.getString(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			
			/*while(rs.next()) {
				
				System.out.println("---------------------");
			}*/
			
			
			
			
			

		} catch (Exception e) {
			System.out.println("--- Failed due to " + e);
		}

	}

}
