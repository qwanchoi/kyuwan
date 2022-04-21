package com.proj.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// DB연결처리, 연결해제
public class DAO {
//  DriverManager
	Connection conn;
	Statement stmt;
	ResultSet rs;
	PreparedStatement psmt;

	public Connection getConnect() {
//		System.out.println("DB 연결중...");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
//			conn = DriverManager.getConnection( //
////					"jdbc:oracle:thin:@121.181.97.69:1521:xe", 
////					"jdbc:oracle:thin:@192.168.0.7:1521:xe",
//					"jdbc:oracle:thin:@localhost:1521:xe",
//					"hr", 
//					"hr");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@qwanoracledb_high?TNS_ADMIN=C:/Dev/db_wallet",
//					"jdbc:oracle:thin:@(description= (retry_count=20)(retry_delay=3)(address=(protocol=tcps)(port=1522)(host=adb.ap-seoul-1.oraclecloud.com))(connect_data=(service_name=g834ece8cc067ed_qwanoracledb_low.adb.oraclecloud.com))(security=(ssl_server_cert_dn=\"CN=adb.ap-seoul-1.oraclecloud.com, OU=Oracle ADB SEOUL, O=Oracle Corporation, L=Redwood City, ST=California, C=US\")))",
//					"jdbc:oracle:thin:@qwanoracledb_high?TNS_ADMIN=./db_wallet",
					"hr",
					"Yd0534212460");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
//		System.out.println("연결성공!!");
		return conn;
	}
	
	public void disconnect() {
		try {
		    if (rs != null) 	rs.close();
		    if (stmt != null) 	stmt.close();
		    if (psmt != null)	psmt.close();
		    if (conn != null) 	conn.close();
		} catch (SQLException e) {
		    e.printStackTrace();
		}
//		System.out.println("disconnected...");
	}
}
