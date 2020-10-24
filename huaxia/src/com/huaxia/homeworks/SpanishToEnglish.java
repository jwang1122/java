package com.huaxia.homeworks;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
public class SpanishToEnglish {
	private Map<String, String> spanEnglishMap=new TreeMap<String,String>();
	
	public Map<String,  String> getMap() {
		return spanEnglishMap;
	}
	
	public void loadDictory() {
	
	System.out.println("Enter in the number of words in dictionary");
	 Scanner input=new Scanner(System.in);
	 int num=input.nextInt();
	 int count=0;
	 System.out.println("Enter in the spanish word and english word");
	 //	String line = input.nextLine();
	 while (input.hasNext()&&count<num ) {
		String line=input.nextLine();
			String[] items = line.split(" ");
			String spa = items[0];
			String eng=items[1];
			
			System.out.println(line);
			if (!spanEnglishMap.containsKey(spa)) {
				spanEnglishMap.put(spa,spanEnglishMap.get(spa));
}
 
	 count++;
	 }
	System.out.println("Enter in the number of phrases to translate");
	int linenum=input.nextInt();
	int count2=1;
	ArrayList<String>pha=new ArrayList<String>();
	while(input.hasNext()&&count2<=linenum) {
		String phase=input.nextLine();
		String[] s=phase.split(" ");
		for(int i=0;i<s.length;i++) {
			if(spanEnglishMap.containsKey(i))
			pha.add(	spanEnglishMap.get(i));
			
		}
		System.out.println(pha);
	}
			
	}	
	
}