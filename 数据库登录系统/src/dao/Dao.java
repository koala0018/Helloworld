package dao;

import java.util.List;

public interface Dao <T>{
	public abstract void insert(T t);
	public abstract void update(T t);
	public abstract void delete(T t);
	public abstract T selectByname(T t);//只返回查出的一条数据，即表类型的对象
	public abstract List<T> selectAll();
}
