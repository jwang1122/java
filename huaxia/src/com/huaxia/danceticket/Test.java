package com.huaxia.danceticket;

public class Test {

	static BinaryTree testBinaryTreeAdd() {
		BinaryTree students = new BinaryTree();
		Student s = new Student(6, "John");
		students.add(s);
		s = new Student(4,"Rodney");
		students.add(s);
		s = new Student(8,"Alen");
		students.add(s);
		s = new Student(3,"Charles");
		students.add(s);
		s = new Student(5,"Bob");
		students.add(s);
		s = new Student(7,"Robert");
		students.add(s);
		s = new Student(9,"David");
		students.add(s);
		students.traverseInOrder(students.root);		
		System.out.println();
		return students;
	}
	
	static void testLoadAndSave() {
		Student.loadAll();
		Student.students.traverseInOrder(Student.students.root);
		Student.saveAll();		
	}
	
	static void testFind() {
		Student.loadAll();
		Student s = Student.students.find(12);
		System.out.println(s);
		s = Student.students.find(3);
		System.out.println(s);		
	}
	
	static void testInsert() {
		BinaryTree students = testBinaryTreeAdd();
		Student s = new Student(2, "Johnson");
		students.insert(students.root, s);
		students.traverseLevelOrder();
		
	}
	
	static void testRemove() {
		// remove 4 which has both left and right branches.
		BinaryTree students = testBinaryTreeAdd();
		students.traverseLevelOrder();
		System.out.println();
		Student s = new Student(4, "Rodney");
		students.remove(s);
		students.traverseLevelOrder();		
		System.out.println();
		
		// remove 5 which is a leaf
		students = testBinaryTreeAdd();
		students.traverseLevelOrder();
		System.out.println();
		s = new Student(5, "Bob");
		students.remove(s);
		students.traverseLevelOrder();	
		System.out.println();

		// remove 6 which is root
		students = testBinaryTreeAdd();
		students.traverseLevelOrder();
		System.out.println();
		s = new Student(6, "John");
		students.remove(s);
		students.traverseLevelOrder();		
	}
	
	public static void main(String[] args) {
//		testBinaryTreeAdd();
//		testLoadAndSave();
//		testFind();
//		testInsert();
		testRemove();
	}

}
