package com.oracle.demo2;

import java.util.Date;

public class Emp {

	private int empid;
	private String ename;
	private String job;
	private double sal;
	private Date hiredate;
	public Emp(){}
	
	public Emp(int empid, String ename, String job, double sal, Date hiredate) {
		super();
		this.empid = empid;
		this.ename = ename;
		this.job = job;
		this.sal = sal;
		this.hiredate = hiredate;
	}

	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	@Override
	public String toString() {
		
		return "Emp [empid=" + empid + ", ename=" + ename + ", job=" + job + ", sal=" + sal + ", hiredate=" + hiredate
				+ "]";
	}
	
}
