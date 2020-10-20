package com.huaxia.swing;

public class StudentTest {
	
	public static void getInformation(GetInfo obj) {
		System.out.println("Information: ");
		System.out.println(obj.getName());		
	}
	
	public static void main(String[] args) {
//		Student s1 = new Student("John");
//		getInformation(s1);
//		
//		Teacher t1 = new Teacher("Wang");
//		getInformation(t1);
		
				
		Student1 s2 = new Student1("Jacob");
		GetInfo info = new JacobInfo();  // named class
		s2.addGetInformation(info);
		s2.action();
		
//		Student1 s3 = new Student1("Ethan");
//		s3.addGetInformation(new GetInfo() {  // anonymous class means no object name defined
//			public String getName() {
//				return "Ethan Williams";
//			}
//		});
//		s3.action();
	}
	
}

class JacobInfo implements GetInfo{
	@Override
	public String getName() {
		return "some information about Jacob.";
	}
	
}
