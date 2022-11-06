package swing;

public class Student1 {
	private String name;
	private GetInfo info;

	public Student1(String name) {
		this.name = name;
	}

	public void addGetInformation(GetInfo info) {
		this.info = info;
	}

	public void action() {
		System.out.println(this.info.getName());
	}

	public String getName() {
		return name;
	}

}
