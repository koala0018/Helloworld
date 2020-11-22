package Day2020_1105;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBTools {

	//定义一个全局的常量代表数据库URL地址
	private static final String URL="jdbc:mysql://localhost:3306/java11";
	//定义一个全局的常量代表数据库的用户名
	private static final String USER="root";
	//定义一个全局的常量代表数据库的密码
	private static final String PASSWORD="root";
	//定义一个静态属性，代表Connection对象
	private static Connection conn = null;
	//定义一个静态属性，代表PreparedStatement对象
	private static PreparedStatement pstat = null;
	//定义一个静态属性，代表ResultSet对象
	private static ResultSet rs = null;
	//编写一个静态块加载驱动
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//编写一个静态方法初始化Connection对象
	public static Connection getConnection(){
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
	//编写一个静态的方法用来执行insert、update、delete
	public static  void executeUpdate(String sql,Object...objs){
		//获取Connection对象
		conn = getConnection();
		//获取PreparedStatement
		try {
			pstat = conn.prepareStatement(sql);
			if(objs!=null&&objs.length>0){
				for(int i=0;i<objs.length;i++){
					pstat.setObject(i+1, objs[i]);
				}
			}
			pstat.executeUpdate();
			commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rollback();
		}finally {
			close();
		}
	}
	
	//编写一个静态方法，用来执行查询
	public static List<Object[]> executeQuery(String sql,Object...objs){
		List<Object[]> list= new ArrayList<Object[]>();
		conn = getConnection();
		try {
			pstat = conn.prepareStatement(sql);
			if(objs!=null&&objs.length>0){
				for(int i=0;i<objs.length;i++){
					pstat.setObject(i+1, objs[i]);
				}
			}
			rs = pstat.executeQuery();
			while(rs.next()){
				//创建一个Object数组用来存放查询的这一列的数据
				Object[] datas = new Object[rs.getMetaData().getColumnCount()];
				for(int i=0;i<datas.length;i++){
					datas[i] = rs.getObject(i+1);
				}
				list.add(datas);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
		return list;
	}
	//编写一个静态方法，用来提交数据
	public static void commit(){
		if(conn!=null){
			try {
				conn.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//编写一个静态方法，用来回滚
	public static void rollback(){
		if(conn!=null){
			try {
				conn.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//编写一个静态方法关闭资源
	public static void close(){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(pstat!=null){
			try {
				pstat.close();
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
