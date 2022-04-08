package knowledgebase;

public class PassByReference {

	public static void swap(String s1, String s2) {
		System.out.println(s1.hashCode() + ","+s2.hashCode());
		String hold = s1;
		s1 = s2;
		s2 = hold;
		System.out.println(s1.hashCode() + ","+s2.hashCode());
		s2 = s2.replace('e', 'E');
		System.out.println(s1 +','+s2);
	}
	
	public static void swap(int x, int y) {
		int tmp = x;
		x = y;
		y = tmp;
		System.out.println(String.format("x=%d, y=%d", x,y));		
	}
	
	public static void changeName(Student s, String newName) {
		s.setName(newName);
	}
	
	/**
	 * Swap two students by reset all it attributes
	 * @param s1
	 * @param s2
	 */
	public static void swap(Student s1, Student s2) {
		PassByReference pbr = new PassByReference();
		
		Student tmp = pbr.new Student(s1.getName(), s1.getAge());// protect name, age of s1
		s1.setName(s2.getName());
		s1.setAge(s2.getAge());
		s2.setName(tmp.getName());
		s2.setAge(tmp.getAge());
	}
	
	public static void main(String[] args) {
		String animal1 = "elephant";
		String animal2 = "lion";
		System.out.println(animal1.hashCode() + "," +animal2.hashCode());
		swap(animal1, animal2);
		animal1.toUpperCase();
		animal2.toUpperCase();
		System.out.println(animal1 + " " + animal2);
		
		int x = 5;
		int y = 6;
		swap(x, y);
		System.out.println(String.format("x=%d, y=%d", x,y));
		
		float x1 = 12.3f;
		float y1 = x1 + x;
		
		PassByReference pbr = new PassByReference();
		Student s1 = pbr.new Student("John", 12);
		System.out.println("Before Change Name: " + s1);
		changeName(s1, "Wang");
		System.out.println(s1);
		Student s2 = pbr.new Student("Bob", 14);
		System.out.println(s1 + "; " + s2);
		swap(s1, s2);
		System.out.println(s1 + "; " + s2);		
	}
	
	class Student{
		String name;
		int age;
		public Student(String name, int age) {
			super();
			this.name = name;
			this.age = age;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		@Override
		public String toString() {
			return "Student [name=" + name + ", age=" + age + "]";
		}
		
	}
}
