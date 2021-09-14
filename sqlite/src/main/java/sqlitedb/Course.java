package sqlitedb;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Course extends DBSetting {
	private int id;
	private String name;

	public Course(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public static void createTable() {
		String sql = "CREATE TABLE IF NOT EXISTS course(id int PRIMARY KEY, name text NOT NULL)";
		db.execute(sql);
	}

	public void create() {
		String sqlFormat = "INSERT INTO course values('%d','%s')";
		String sql = String.format(sqlFormat, id, name);
		db.execute(sql);
	}

	public List<String> getStudents() {
		String sql = "SELECT Student.name FROM Student JOIN Enrollment ON(Student.id=Enrollment.sid) JOIN Course ON(Enrollment.cid=Course.id) WHERE Course.name='" 
				+ name + "'";
		ResultSet rs = db.retrieve(sql);
		ArrayList<String> studentNames = new ArrayList<>();
		try {
			while (rs.next()) {
				studentNames.add(rs.getString(1));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return studentNames;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}

}
