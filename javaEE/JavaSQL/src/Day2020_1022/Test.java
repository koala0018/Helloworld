package Day2020_1022;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
					
		try {
			Class.forName("Day2020_1021.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "root");
			String sql = "Select * from employees";
			ps = con.prepareStatement(sql);
			
			ps.executeQuery(sql);
			//statement.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(con!=null){
				con.close();
				}
			if(PreparedStatement!=null){
				PreparedStatement.close();
				}s
			
		}
		
		
	}

}
