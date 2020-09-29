package com.huaxia.swing;

public class StudentTest {

	public static void getInformation(GetInfo obj) {
		System.out.println("Information: ");
		System.out.println("Name: " + obj.getName());		
	}
	
	public static void main(String[] args) {
		Student s1 = new Student("John");
		getInformation(s1);
		
		Student1 s2 = new Student1("Jacobo");
		GetInfo info = new GetInfo() {
			public String getName(){
				return "some information about Jacobo.";
			}
		};
		s2.addGetInformation(info);
		s2.action();
		
		Student1 s3 = new Student1("Ethan");
		s3.addGetInformation(new GetInfo() {
			public String getName() {
				return "Ethan Williams";
			}
		});
		
		s3.action();
	}

}
