package com.oracle.demo2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class EmpDao implements BaseDao<Emp>{
		
	@Override
	public void insert(Emp t) {
		String sql = "insert into emp(ename,job,sal,hiredate) values(?,?,?,?)";
		DBTools.executeUpdate(sql, t.getEname(),t.getJob(),t.getSal(),t.getHiredate());
	}
	public void insertWithId(Emp t) {
		String sql = "insert into emp(empid,ename,job,sal,hiredate) values(?,?,?,?,?)";
		DBTools.executeUpdate(sql, t.getEmpid(),t.getEname(),t.getJob(),t.getSal(),t.getHiredate());
	}

	@Override
	public void update(Emp t) {
		String sql = "update emp set ename=?,job=?,sal=?,hiredate=? where empid=?";
		DBTools.executeUpdate(sql, t.getEname(),t.getJob(),t.getSal(),t.getHiredate(),t.getEmpid());
	}

	@Override
	public void delete(Emp t) {
		String sql = "delete from emp where empid=?";
		DBTools.executeUpdate(sql, t.getEmpid());
	}

	@Override
	public Emp selectById(Emp t) {
		Emp emp = null;
		String sql = "select * from emp where empid=?";
		List<Object[]> list = DBTools.executeQuery(sql, t.getEmpid());
		if(list.size()>0){
			Object[] objs = list.get(0);
			int empid = (Integer)objs[0];
			String ename = (String)objs[1];
			String job = (String)objs[2];
			double sal = (Double)objs[3];
			Timestamp hd = (Timestamp)objs[4];
			emp = new Emp(empid,ename,job,sal, new java.util.Date(hd.getTime()));
		}
		return emp;
	}

	@Override
	public List<Emp> selectAll() {
		List<Emp> emps = new ArrayList<Emp>();
		String sql = "select * from emp";
		List<Object[]> list = DBTools.executeQuery(sql, null);
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				Object[] objs = list.get(i);
				int empid = (Integer)objs[0];
				String ename = (String)objs[1];
				String job = (String)objs[2];
				double sal = (Double)objs[3];
				Timestamp hd = (Timestamp)objs[4];
				Emp emp = new Emp(empid, ename, job, sal, new java.util.Date(hd.getTime()));
				emps.add(emp);
			}
		}
		return emps;
	}

}
