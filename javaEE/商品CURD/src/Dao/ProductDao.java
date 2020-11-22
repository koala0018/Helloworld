package Dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Util.DBTools;
import vo.Product;

public class ProductDao implements BaseDao<Product>{

	@Override
	public void insert(Product t) {
		// TODO Auto-generated method stub
		String sql = "insert into product (pid,pname,note,price,amount) values (?,?,?,?,?)";
		DBTools.executeUpdate(sql, t.getPid(),t.getPname(),t.getNote(),t.getPrice(),t.getAmount());
	}

	@Override
	public void update(Product t) {
		// TODO Auto-generated method stub
		String sql = "update product set pname=?,note=?,price=?,amount=? where pid=?";
		DBTools.executeUpdate(sql,t.getPname(),t.getNote(),t.getPrice(),t.getAmount(),t.getPid());
	}

	@Override
	public void delete(Product t) {
		// TODO Auto-generated method stub
		String sql = "delete from product where pid=?";
		DBTools.executeUpdate(sql, t.getPid());
	}

	@Override
	public Product selectById(Product t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Product> selectByPage(int pageNumber,int num){
		List<Product> list =new ArrayList<Product>();
		Product product = null;
		String sql = "select * from product limit ?,?";
		List<Object[]> objs = DBTools.executeQuery(sql, (pageNumber-1)*4,num);//limit的第一个？是数据库的下标，从0开始， (pageNumber-1)*2对应的才是下数据库的下标
		for(int i=0;i<objs.size();i++){
			Object[] obj = objs.get(i);
			int pid = (Integer) obj[0];
			String pname  = (String) obj[1];
			String note = (String)obj[2];
			double price = (Double)obj[3];
			int amount = (Integer)obj[4];
			product = new Product(pid,pname,note,price,amount);
			list.add(product);
			
		}
		return list;
	}
	public int Count (){
		String sql = "select count(*) from product";//count(*)查出来只有一条记录
		List<Object[]> objs =  DBTools.executeQuery(sql, null);
		int count = 0;
		if(objs!=null||objs.size()>0){
			count = ((Long)objs.get(0)[0]).intValue();		
		}
		return count;
		
	}
}
