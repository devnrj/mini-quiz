package com.neeraj.entity;

import java.util.HashSet;

public class UsersOperations {
	private HashSet<Users> userList;
	private static UsersOperations uo;
	private UsersOperations() {
		userList = new HashSet<>();
	}
	public static UsersOperations getInstance() {
		synchronized(UsersOperations.class){
			if(uo==null) {
				uo = new UsersOperations();
			}
		}
		return uo;
	}
	public String registerUser(Users u) {
		if(userList.contains(u)) {
			return "Already Exists";
		}
		userList.add(u);
		return "User Added!";
	}
	
	public boolean loginUser(Users user) {
		boolean flag=false;
		for(Users u:userList) {
			flag=u.validate(user);
			if(flag) {
				return true;
			}
			else {
				flag=false;
			}
		}
		return false;
	}
	
	public HashSet<Users> getList(){
		return userList;
	}
	
}
