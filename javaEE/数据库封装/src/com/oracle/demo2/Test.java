package com.oracle.demo2;

import java.util.Date;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		EmpDao dao = new EmpDao();
		
		List<Emp> emps = dao.selectAll();
		for(Emp e:emps){
			System.out.println(e);
		}
	}

}
