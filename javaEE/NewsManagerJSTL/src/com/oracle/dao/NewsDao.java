package com.oracle.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.oracle.tools.DBTools;
import com.oracle.vo.News;

public class NewsDao implements BaseDao<News> {

	@Override
	public void insert(News t) {
		String sql = "insert into news(title,author,pubdate,content,lockflag) values(?,?,?,?,?)";
		DBTools.executeUpdate(sql, t.getTitle(),t.getAuthor(),t.getPubdate(),t.getContent(),t.getLockflag());
	}

	@Override
	public void update(News t) {
		String sql = "update news set title=?,author=?,pubdate=?,content=?,lockflag=? where nid=?";
		DBTools.executeUpdate(sql, t.getTitle(),t.getAuthor(),t.getPubdate(),t.getContent(),t.getLockflag(),t.getNid());
	}

	@Override
	public void delete(News t) {
		String sql = "delete from news where nid=?";
		DBTools.executeUpdate(sql, t.getNid());
	}

	@Override
	public News selectById(News t) {
		News n = null;
		String sql = "select * from news where nid=?";
		List<Object[]> objs = DBTools.executeQuery(sql, t.getNid());
		if(objs!=null&&objs.size()>0){
			Object[] obj = objs.get(0);
			int nid = (Integer)obj[0];
			String title = (String)obj[1];
			String author = (String)obj[2];
			
			Date pubdate = (Date)obj[3];
			String content = (String)obj[4];
			int lockflag = (Integer)obj[5];
			n = new News(nid, title, author, pubdate, content, lockflag);
		}
		return n;
	}

	@Override
	public List<News> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	public List<News> selectNewsByPageAdmin(int flag,int pageNum,int num){
		List<News> news = null;
		String sql = "select * from news limit ?,?";
		if(flag==1){//flag如果为1则代表是普通用户，普通用户只能查询lockflag=0的新闻
			sql = "select * from news where lockflag=0 limit ?,?";
			
		}
		List<Object[]> objs = DBTools.executeQuery(sql, (pageNum-1)*num,num);
		if(objs!=null&&objs.size()>0){
			news = new ArrayList<News>();
			for(int i=0;i<objs.size();i++){
				Object[] obj = objs.get(i);
				int nid = (Integer)obj[0];
				String title = (String)obj[1];
				String author = (String)obj[2];
				Date pubdate = (Date)obj[3];
				String content = (String)obj[4];
				int lockflag = (Integer)obj[5];
				News n = new News(nid, title, author, pubdate, content, lockflag);
				news.add(n);
			}
			
		}
		return news;
	}
	public int getCountAdmin(int flag){
		int count=0;
		String sql = "select count(*) from news ";
		if(flag==1){//flag如果为1则代表是普通用户，普通用户只能查询lockflag=0的新闻
			sql = "select count(*) from news where lockflag=0 ";
		}
		List<Object[]> objs = DBTools.executeQuery(sql, null);
		if(objs!=null&&objs.size()>0){
			Object[] obj = objs.get(0);
			count = ((Long)obj[0]).intValue();
				
		}
		return count;
		
	}

}
