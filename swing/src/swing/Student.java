package swing;

public class Student implements GetInfo {
	private String name;
	
	public Student(String name) {
		this.name = name;
	}
	@Override
	public String getName() {
		return name;
	}

}
