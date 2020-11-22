package com.oracle.dao;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.oracle.tools.DBTools;
import com.oracle.vo.User;

public class UserDao implements BaseDao<User> {

	@Override
	public void insert(User t) {
		String sql = "insert into t_user(userid,password,username) values(?,?,?)";
		DBTools.executeUpdate(sql,t.getUserid(),t.getPassword(),t.getUsername());
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
		User usre = null;
		String sql = "select * from t_user where userid=?";
		List<Object[]> objs = DBTools.executeQuery(sql,t.getUserid());
		if(objs.size()>0){
				Object[] obj = objs.get(0);
				String userid = (String)obj[0];
				String password = (String)obj[1];
				String username = (String)obj[2];
				usre = new User(userid, password, username);
			}
			return usre;
		}
		
	
	

	@Override
	public List<User> selectAll() {
		List<User> usres = null;
		String sql = "select * from t_user";
		List<Object[]> objs = DBTools.executeQuery(sql, null);
		if(objs.size()>0){
			usres = new ArrayList<User>();
			for(int i=0;i<objs.size();i++){
				Object[] obj = objs.get(i);
				String userid = (String)obj[0];
				String password = (String)obj[1];
				String username = (String)obj[2];
			
				User usre = new User(userid, password, username);
				usres.add(usre);
			}
		}
		return usres;
	}
	}


