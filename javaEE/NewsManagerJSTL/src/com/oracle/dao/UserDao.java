package com.oracle.dao;

import java.util.List;

import com.oracle.tools.DBTools;
import com.oracle.vo.User;

public class UserDao implements BaseDao<User>{

	@Override
	public void insert(User t) {
		
	}

	@Override
	public void update(User t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User selectById(User t) {
		String sql = "select * from t_user1 where userid=?";
		User user = null;
		List<Object[]> objs = DBTools.executeQuery(sql, t.getUserid());
		if(objs!=null&&objs.size()>0){
			Object[] obj = objs.get(0);
			String userid = (String)obj[0];
			String password = (String)obj[1];
			String username = (String)obj[2];
			int flag = (Integer)obj[3];
			user = new User(userid, password, username, flag);
		}
		return user;
	}

	@Override
	public List<User> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
