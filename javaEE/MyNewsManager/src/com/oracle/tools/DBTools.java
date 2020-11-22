package com.oracle.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBTools {

	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static Connection conn = null;
	private static final String URL="jdbc:mysql://localhost:3306/java11?useUnicode=true&characterEncoding=UTF-8";
	private static final String USER="root";
	private static final String PASSWORD="root";
	private static PreparedStatement pstat = null;
	private static ResultSet rs = null;
	public static Connection getConn(){
		if(conn==null){
			try {
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
				conn.setAutoCommit(false);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return conn;
	}
	public static void executeUpdate(String sql,Object...objs){
		conn = getConn();
		try {
			pstat = conn.prepareStatement(sql);
			if(objs!=null&&objs.length>0){
				for(int i=0;i<objs.length;i++){
					pstat.setObject(i+1, objs[i]);
				}
			}
			pstat.execute();
			commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rollback();
		}
		
		
	}
	
	public static List<Object[]> executeQuery(String sql,Object...objs){
		List<Object[]> list = new ArrayList<Object[]>();
		conn = getConn();
		try {
			pstat = conn.prepareStatement(sql);
			if(objs!=null&&objs.length>0){
				for(int i=0;i<objs.length;i++){
					pstat.setObject(i+1, objs[i]);
				}
			}
			rs = pstat.executeQuery();
			while(rs.next()){
				Object[] obj = new Object[rs.getMetaData().getColumnCount()];
				for(int i=0;i<obj.length;i++){
					obj[i] = rs.getObject(i+1);
				}
				list.add(obj);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return list;
	}
	public static void commit(){
		if(conn!=null){
			try {
				conn.commit();
				close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void rollback(){
		if(conn!=null){
			try {
				conn.rollback();
				close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public static void close(){
		if(rs!=null){
			try {
				rs.close();
				rs=null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(pstat!=null){
			try {
				pstat.close();
				pstat=null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
				conn=null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
