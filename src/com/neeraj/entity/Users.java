package com.neeraj.entity;


public class Users {
	private String uname;
	private String pass;
	public Users(String u,String p) {
		uname=u;
		pass=p;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "User [uname=" + uname + ", pass=" + pass + "]";
	}
	@Override
	public int hashCode() {
		return uname.trim().length();
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Users) {
			Users u = (Users)obj;
			if(this==u) {
				return true;
			}
			if(this.uname.equals(u.getUname())) {
				return true;
			}
			
		}
		return false;
	}
	public boolean validate(Users obj) {
		if(this.equals(obj)) {
			if(this.pass.equals(obj.pass)) {
				return true;
			}
		}
		return false;
	}
}
