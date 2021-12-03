package sqlitedb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Course extends DBSetting {
	private int id;
	private String name;
	List<Student> studentList = new ArrayList<Student>();

	public Course(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Course(int id) {
		super();
		this.id = id;
		load();
	}

	public void load() {
		String sql = "SELECT * FROM course WHERE id="+id;
		ResultSet rs = db.retrieve(sql);
		try {
			if(rs.next()) {
				this.name = rs.getString("name");
			}else {
				System.out.printf("The course with id=%d does NOT exist.\n", id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loadStudents();
	}
	
	private void loadStudents() {
		String sql = "SELECT Student.name, Student.id FROM Course JOIN Enrollment ON(Course.id=Enrollment.cid) JOIN Student ON(Enrollment.sid=Student.id) WHERE Course.id=" + id;
		ResultSet rs = db.retrieve(sql);
		try {
			int count = 0;
			while (rs.next()) {
				String studentName = rs.getString(1);
				int studentId = rs.getInt(2);
				studentList.add(new Student(studentId, studentName));
				count++;
			}
			System.out.println("total number of students: " + count);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
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
		ArrayList<String> studentNames = new ArrayList<String>();
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

	public List<Student> getStudentList() {
		return studentList;
	}

}
