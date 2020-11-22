package Dao;

import java.util.ArrayList;
import java.util.List;

import Util.DBTools;
import vo.T_user;

public class T_userDao implements BaseDao<T_user>{
		
	@Override
	public void insert(T_user t) {
		String sql = "insert into t_user(password,username) values(?,?)";
		DBTools.executeUpdate(sql,t.getPassword(),t.getUsername());
	}
	public void insertWithId(T_user t) {
		String sql = "insert into t_user(userid,password,username) values(?,?,?)";
		DBTools.executeUpdate(sql, t.getUserid(),t.getPassword(),t.getUsername());	}

	@Override
	public void update(T_user t) {
		String sql = "";
		DBTools.executeUpdate(sql, t.getUserid(),t.getPassword(),t.getUsername());
	}

	@Override
	public void delete(T_user t) {
		String sql = "";
		DBTools.executeUpdate(sql, t.getUserid());
	}

	@Override
	public T_user selectById(T_user t) {
		T_user user = null;
		String sql = "select * from t_user where userid=?";
		List<Object[]> list = DBTools.executeQuery(sql, t.getUserid());
		if(list.size()>0){
			Object[] objs = list.get(0);
			String userid = (String)objs[0];
			String password = (String)objs[1];
			String username = (String)objs[2];
			user = new T_user(userid,password,username);
		}
		return user;
	}

	@Override
	public List<T_user> selectAll() {
		List<T_user> users = new ArrayList<T_user>();
		String sql = "select * from t_user";
		List<Object[]> list = DBTools.executeQuery(sql, null);
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				Object[] objs = list.get(i);
				String userid = (String)objs[0];
				String password = (String)objs[1];
				String username = (String)objs[2];
				T_user user = new T_user(userid,password,username);
				users.add(user);
			}
		}
		return users;
	}

}
