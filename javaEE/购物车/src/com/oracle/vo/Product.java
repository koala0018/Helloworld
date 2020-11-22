package com.oracle.vo;

import org.apache.tomcat.util.http.Cookies;

public class Product {
		

		private int pid;
	
		private String pname;
		private String note;
		private double price;
		private int amount;
		public Product(){}
		public Product(int pid, String pname, String note, double price, int amount) {
			super();
			this.pid = pid;
			this.pname = pname;
			this.note = note;
			this.price = price;
			this.amount = amount;
		}
		public int getPid() {
			return pid;
		}
		public void setPid(int pid) {
			this.pid = pid;
		}
		public String getPname() {

			return pname;
			
		}
		public void setPname(String pname) {
			this.pname = pname;
		}
		public String getNote() {
			return note;
		}
		public void setNote(String note) {
			this.note = note;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public int getAmount() {
			return amount;
		
		}
		public void setAmount(int amount) {
			this.amount = amount;
		}
		@Override
		public String toString() {
			return "Product [pid=" + pid + ", pname=" + pname + ", noto=" + note + ", price=" + price + ", amount="
					+ amount + "]";
		}
		
		
}
