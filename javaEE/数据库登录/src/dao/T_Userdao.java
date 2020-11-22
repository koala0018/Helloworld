package dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import Util.DaoUtil;
import vo.T_User;



public class T_Userdao implements Dao<T_User>{
	
	@Override
	public void insert(T_User t) {
		// TODO Auto-generated method stub
		String sql = "insert into T_User(userName,pwd,email) values(?,?,?)";
		DaoUtil.executeUpdate(sql,t.getUserName(),t.getPwd(),t.getEmail());
	}

	@Override
	public void update(T_User t) {
		// TODO Auto-generated method stub
		String sql = "";
	}

	@Override
	public void delete(T_User t) {
		// TODO Auto-generated method stub
		String sql = "";
	}

	@Override
	public T_User selectByname(T_User t) {
		// TODO Auto-generated method stub
		String sql = "select * from T_User where userName = ?";
		
		List<Object[]> list = new ArrayList<Object[]>();
		list = DaoUtil.executeQuery(sql, t.getUserName());
		if(list.size()>0){
			Object[] objs = list.get(0);
			int id = (Integer)objs[0];
			String name = (String)objs[1];
			String pwd = (String)objs[2];
			String email = (String)objs[3];
			t = new T_User(id,name,pwd,email);
		}
		return t;
	}

	@Override
	public List<T_User> selectAll() {
		// TODO Auto-generated method stub
		List<T_User> user = new ArrayList<T_User>();
		String sql = "select * from T_User";
		List<Object[]> list = DaoUtil.executeQuery(sql, null);
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				Object[] objs = list.get(i);
				int id = (Integer)objs[0];
				String name = (String)objs[1];
				String password = (String)objs[2];
				String email = (String)objs[3];			
				T_User user1 = new T_User(id, name, password, email);
				user.add(user1);
			}
		}
		return user;
	}

	}




