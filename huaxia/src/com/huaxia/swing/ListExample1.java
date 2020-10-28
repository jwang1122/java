package com.huaxia.swing;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener; 

//java Program to create a list and add itemListener to it 
//(program to select your birthday using lists) . 
class ListExample1 extends JFrame implements ListSelectionListener 
{ 

	private static final long serialVersionUID = 1L;

	//frame 
	static JFrame f; 
	
	//lists 
	static JList<String> b,b1,b2; 
	
	//label 
	static JLabel l1; 


	//main class 
	public static void main(String[] args) 
	{ 
		//create a new frame 
		f = new JFrame("frame"); 
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//create a object 
		ListExample1 s=new ListExample1(); 
		
		//create a panel 
		JPanel p =new JPanel(); 
		
		//create a new label 
		JLabel l= new JLabel("select your bithday"); 
		l1= new JLabel(); 

		//String array to store weekdays 
		String month[]= { "January", "February", "March", 
		"April", "May", "June", "July", "August", 
		"September", "October", "November", "December"}; 
		
		//create a array for months and year 
		String date[]=new String[31],year[]=new String[31]; 
		
		//add month number and year to list 
		for(int i=0;i<31;i++) 
		{ 
			date[i]=""+(int)(i+1); 
			year[i]=""+(int)(2018-i); 
		} 
		
		//create lists 
		b= new JList<String>(date); 
		b1= new JList<String>(month); 
		b2= new JList<String>(year); 
		
		//set a selected index 
		b.setSelectedIndex(2); 
		b1.setSelectedIndex(1); 
		b2.setSelectedIndex(2); 
		
		l1.setText(b.getSelectedValue()+" "+b1.getSelectedValue() 
							+" "+b2.getSelectedValue()); 
		
		//add item listener 
		b.addListSelectionListener(s); 
		b1.addListSelectionListener(s); 
		b2.addListSelectionListener(s); 
		
		//add list to panel 
		p.add(l); 
		p.add(b); 
		p.add(b1); 
		p.add(b2); 
		p.add(l1); 

		f.add(p); 
		
		//set the size of frame 
		f.setSize(500,600); 
		
		f.setVisible(true); 
	} 
	public void valueChanged(ListSelectionEvent e) 
	{ 
		//set the text of the label to the selected value of lists 
		l1.setText(b.getSelectedValue()+" "+b1.getSelectedValue() 
							+" "+b2.getSelectedValue()); 
		
	} 
	
	
} 
