package com.neeraj.ui;


import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import com.neeraj.entity.QuesOps;
import com.neeraj.entity.Question;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Quiz extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8175958472845118004L;
	private JPanel contentPane;
	private int index = 0;
	JLabel lblQues = new JLabel("");
	JRadioButton rdbtna = new JRadioButton("");
	JRadioButton rdbtnb = new JRadioButton("");
	JRadioButton rdbtnc = new JRadioButton("");
	JRadioButton rdbtnd = new JRadioButton("");
	JButton btnPrevious = new JButton("Previous");
	JButton btnNext = new JButton("Next");
	ButtonGroup bg= new ButtonGroup();
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Quiz frame = new Quiz();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Quiz() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		lblQues.setBounds(6, 55, 438, 16);
		contentPane.add(lblQues);
		
		
		rdbtna.setBounds(6, 96, 438, 23);
		contentPane.add(rdbtna);
		
		
		rdbtnb.setBounds(6, 131, 438, 23);
		contentPane.add(rdbtnb);
		

		rdbtnc.setBounds(6, 166, 438, 23);
		contentPane.add(rdbtnc);
		

		rdbtnd.setBounds(6, 201, 438, 23);
		contentPane.add(rdbtnd);
		
		
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prev();
			}
		});
		btnPrevious.setBounds(0, 243, 117, 29);
		contentPane.add(btnPrevious);
		
		
		btnNext.setBounds(327, 243, 117, 29);
		contentPane.add(btnNext);
		
		JButton btnEndTest = new JButton("End Test");
		btnEndTest.setBounds(327, 6, 117, 29);
		contentPane.add(btnEndTest);
		bg.add(rdbtna);
		bg.add(rdbtnb);
		bg.add(rdbtnc);
		bg.add(rdbtnd);	
		loadQuestions();
		printQuestion(index);
	}
	private void loadQuestions() {
	//	public Questions(String q,String a,String b,String c,String d,int rans);
		QuesOps qo = QuesOps.getInstance();
		Question q = new Question("Java is a ","Programming language","Slang for coffee","Script","None of this",'a');
		qo.addQuestion(q);
		q = new Question("Latest version of java is","java 1.4","java 1.8","java se 9","None of this",'c');
		qo.addQuestion(q);
		q = new Question("Original Author of java is","Dennis Ritchie","James Gosling","Brendan Eich","Linus Trovalds",'c');
		qo.addQuestion(q);
	}
	private void printQuestion(int i) {
		this.enableDisable();
		QuesOps qo = QuesOps.getInstance();
		int cindex=0;
		Question q1=new Question();
		for(Question q:qo.getQuestionsList()) {
			q1=q;
			if(cindex==i) {
				break;
			}
		}
		lblQues.setText(q1.getQuestion());
		String ans[]=q1.getAns();
		rdbtna.setText(ans[0]);
		rdbtnb.setText(ans[1]);
		rdbtnc.setText(ans[2]);
		rdbtnd.setText(ans[3]);
	}
	public void prev() {
		if(index>0) {
			this.index--;
			printQuestion(index);
		}
		
	}
	
	public void next() {
		if(index<2) {
			this.index++;
			printQuestion(index);
		}	
	}
	
	public void enableDisable() {
		boolean flag = this.index == 0 ? false:true;
		btnPrevious.setEnabled(flag);
		flag = this.index == 2 ?false:true;
		btnNext.setEnabled(flag);
	}
}

