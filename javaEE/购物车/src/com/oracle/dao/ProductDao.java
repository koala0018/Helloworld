package com.oracle.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.oracle.tools.DBTools;

import com.oracle.vo.Product;

public class ProductDao  implements BaseDao<Product>{

	public void insert(Product t) {
		String sql = "insert into product(pname,note,price,amount) values(?,?,?,?)";
		DBTools.executeUpdate(sql,t.getPname(),t.getNote(),t.getPrice(),t.getAmount());
	}

	@Override
	public void update(Product t) {
		String sql = "update product set pname=?,note=?,price=?,amount=? where pid=?";
		DBTools.executeUpdate(sql,t.getPname(),t.getNote(),t.getPrice(),t.getAmount(),t.getPid());
	}

	@Override
	public void delete(Product t) {
		String sql = "delete from product where pid=?";
		DBTools.executeUpdate(sql, t.getPid());
	}

	@Override
	public List<Product> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}
	//分页查询
	public List<Product> selectAll5(int pageNum ,int num) {
		List<Product> emps = null;
		String sql = "select * from product limit ?,?";
		List<Object[]> list = DBTools.executeQuery(sql, (pageNum-1)*num,num);
		if(list!=null&&list.size()>0){
			emps = new ArrayList<Product>();
			for(int i=0;i<list.size();i++){
				Object[] objs = list.get(i);
				int pid = (Integer)objs[0];
				String pname = (String)objs[1];
				String note = (String)objs[2];
				double price = (Double)objs[3];
				int amount = (Integer)objs[4];
				Product emp = new Product(pid, pname, note, price, amount);
				emps.add(emp);
			}
		}
		return emps;

	}
	@Override
	public Product selectById(Product t) {
		Product emp = null;
		String sql = "select * from product where pid=?";
		List<Object[]> list = DBTools.executeQuery(sql,t.getPid());
		if(list!=null&&list.size()>0){
			for(int i=0;i<list.size();i++){
				Object[] objs = list.get(i);
				int pid = (Integer)objs[0];
				String pname = (String)objs[1];
				String note = (String)objs[2];
				double price = (Double)objs[3];
				int amount = (Integer)objs[4];
			    emp = new Product(pid, pname, note, price, amount);
			}
		}
		return emp;
}
	public int getCount(){
		int count=0;
		String sql = "select count(*) from product ";
		List<Object[]> list = DBTools.executeQuery(sql, null);
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				Object[] objs = list.get(0);
				count = ((Long)objs[0]).intValue();
	}		
}
		return count;
}
	public List<Product> selectPname(int pageNum ,int num,String key) {
		List<Product> emps = null;
		String sql = "select * from product where pname like ? limit ?,?";
		List<Object[]> list = DBTools.executeQuery(sql, "%"+key+"%",(pageNum-1)*num,num);
		if(list!=null&&list.size()>0){
			emps = new ArrayList<Product>();
			for(int i=0;i<list.size();i++){
				Object[] objs = list.get(i);
				int pid = (Integer)objs[0];
				String pname = (String)objs[1];
				String note = (String)objs[2];
				double price = (Double)objs[3];
				int amount = (Integer)objs[4];
				Product emp = new Product(pid, pname, note, price, amount);
				emps.add(emp);
			}
		}
		return emps;

	}
	public int getPnameCount(String key){
		int count=0;
		String sql = "select count(*) from product  where pname like ?";
		List<Object[]> list = DBTools.executeQuery(sql, "%"+key+"%");
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				Object[] objs = list.get(0);
				count = ((Long)objs[0]).intValue();

	}
		
}
		return count;
}
	public List<Product> selectNote(int pageNum ,int num,String key) {
		List<Product> emps = null;
		String sql = "select * from product where note like ? limit ?,?";
		List<Object[]> list = DBTools.executeQuery(sql, "%"+key+"%",(pageNum-1)*num,num);
		if(list!=null&&list.size()>0){
			emps = new ArrayList<Product>();
			for(int i=0;i<list.size();i++){
				Object[] objs = list.get(i);
				int pid = (Integer)objs[0];
				String pname = (String)objs[1];
				String note = (String)objs[2];
				double price = (Double)objs[3];
				int amount = (Integer)objs[4];
				Product emp = new Product(pid, pname, note, price, amount);
				emps.add(emp);
			}
		}
		return emps;

	}
	public int getNoteCount(String key){
		int count=0;
		String sql = "select count(*) from product  where note like ?";
		List<Object[]> list = DBTools.executeQuery(sql, "%"+key+"%");
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				Object[] objs = list.get(0);
				count = ((Long)objs[0]).intValue();

	}
		
}
		return count;
}
}