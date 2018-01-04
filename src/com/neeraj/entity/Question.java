package com.neeraj.entity;

import java.util.Arrays;

public class Question {
	String question;
	String ans[];
	char rans;
	char uans;
	boolean visited;
	int status;
	public Question() {
		question="";
		ans = new String[4];
		ans[0]="";
		ans[1]="";
		ans[2]="";
		ans[3]="";
		this.rans='x';
		uans='x';
		visited=false;
		status=-1;
	}
	public Question(String q,String a,String b,String c,String d,char rans) {
		question=q;
		ans = new String[4];
		ans[0]=a;
		ans[1]=b;
		ans[2]=c;
		ans[3]=d;
		this.rans=rans;
		uans='x';
		visited=false;
		status=-1;
	}

	@Override
	public String toString() {
		return "Questions [question=" + question + ", ans=" + Arrays.toString(ans) + ", rans=" + rans + ", uans=" + uans
				+ ", visited=" + visited + ", status=" + status + "]";
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String[] getAns() {
		return ans;
	}

	public void setAns(String[] ans) {
		this.ans = ans;
	}

	public char getRans() {
		return rans;
	}

	public void setRans(char rans) {
		this.rans = rans;
	}

	public char getUans() {
		return uans;
	}

	public void setUans(char uans) {
		this.uans = uans;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public boolean equals(Object o) {
		if(o instanceof Question) {
			Question q = (Question)o;
			if(q.getQuestion().trim().equalsIgnoreCase(q.getQuestion())){
				return true;
			}
		}
		return false;
	}
	@Override
	public int hashCode() {
		return question.trim().length();
	}
	
}
