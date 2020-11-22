package Dao;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Util.DBTools;
import vo.Emp;

public class EmpDao implements BaseDao<Emp>{

	@Override
	public void insert(Emp t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Emp t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Emp t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Emp selectById(Emp t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Emp> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Emp> selectByPage(int pageNumber,int num){
		List<Emp> list =new ArrayList<Emp>();
		Emp emp = null;
		String sql = "select * from emp limit ?,?";
		List<Object[]> objs = DBTools.executeQuery(sql, (pageNumber-1)*2,num);//limit的第一个？是数据库的下标，从0开始， (pageNumber-1)*2对应的才是下数据库的下标
		for(int i=0;i<objs.size();i++){
			Object[] obj = objs.get(i);
			int empid = (Integer) obj[0];
			String ename  = (String) obj[1];
			String job = (String)obj[2];
			double sal = (Double)obj[3];
			Timestamp time = (Timestamp)obj[4];
		//	Date hiredate = new Date(time.getTime());
			emp = new Emp(empid,ename,job,sal,new Date(time.getTime()));
			list.add(emp);
			
		}
		return list;
	}
	public int getCount(){
		List<Emp> list =new ArrayList<Emp>();
		Emp emp = null;
		String sql = "select count(*) from emp";
		List<Object[]> objs = DBTools.executeQuery(sql,null);
		int count = ((Long)objs.get(0)[0]).intValue();//objs.get(0)[0]找出来的是个long类型，不能直接转为integer
		return count;
	}
	
}
