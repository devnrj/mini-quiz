package com.neeraj.entity;

import java.util.HashSet;

public class QuesOps {
	private HashSet<Question> quesList;
	private static QuesOps qo;
	private QuesOps() {
		quesList = new HashSet<>();
	}
	
	public static QuesOps getInstance() {
		synchronized(QuesOps.class) {
			if(qo == null) {
				qo = new QuesOps();
			}
		}
		return qo;
	}
	
	public HashSet<Question> getQuestionsList() {
		return quesList;
	}
	public String addQuestion(Question ques) {
		quesList.add(ques);
		return "Question added!";
	}
	public int getSize() {
		return quesList.size();
	}
	

}
