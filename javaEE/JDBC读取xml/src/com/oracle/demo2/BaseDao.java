package com.oracle.demo2;

import java.util.List;

public interface BaseDao<T> {

	public abstract void insert(T t);
	public abstract void update(T t);
	public abstract void delete(T t);
	public abstract T selectById(T t);
	public abstract List<T> selectAll();
}
