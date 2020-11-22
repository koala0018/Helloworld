package com.oracle.demo2;

import java.util.List;

public interface BaseDao<T> {
//泛型T即不同的表内数据
	public abstract void insert(T t);
	public abstract void update(T t);
	public abstract void delete(T t);
	public abstract T selectById(T t);//只返回查出的一条数据，即表类型的对象
	public abstract List<T> selectAll();
}
