package sqlitedb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Many-to-many relationship.
 * 
 * !load courses while load student and load students while load courses <b>causes</b> infinite loop!!!
 * 
 * @author John
 *
 */
public class Student extends DBSetting {
	private int sid;
	private String name;
	private List<Course> courseList = new ArrayList<>();
	
	public Student(int sid, String name) {
		super();
		this.sid = sid;
		this.name = name;
	}

	public Student(int sid) {
		super();
		this.sid = sid;
		load();
	}

	public void load() {
		String sql = "SELECT * FROM student WHERE id="+sid;
		ResultSet rs = db.retrieve(sql);
		try {
			if(rs.next()) {
				this.name = rs.getString("name");
			}else {
				System.out.printf("The student with id=%d does NOT exist.\n", sid);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loadCourses();
	}
	public static void createTable() {
		String sql = "CREATE TABLE IF NOT EXISTS student(id int PRIMARY KEY, name text NOT NULL)";
		db.execute(sql);		
		sql = "CREATE TABLE IF NOT EXISTS enrollment(sid int, cid int, PRIMARY KEY (sid, cid))"; // composite primary key
		db.execute(sql);		
	}
	
	public void create() {
		String sqlFormat = "INSERT INTO student (id, name) values('%d','%s')";
		String sql = String.format(sqlFormat, sid, name);
		db.execute(sql);
	}

	public void enroll(int courseId) {
		String sqlFormat = "INSERT INTO enrollment values(%d, %d)";
		String sql = String.format(sqlFormat, sid, courseId);
		db.execute(sql);
	}
	
	public void loadCourses(){
		String sql = "SELECT Course.name, Course.id FROM Course JOIN Enrollment ON(Course.id=Enrollment.cid) JOIN Student ON(Enrollment.sid=Student.id) WHERE Student.id=" + sid;
		ResultSet rs = db.retrieve(sql);
		ArrayList<Course> courses = new ArrayList<>();
		try {
			int count = 0;
			while (rs.next()) {
				String courseName = rs.getString(1);
				int courseId = rs.getInt(2);
				courseList.add(new Course(courseId, courseName));
				count++;
			}
			System.out.println("total number of courses: " + count);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}


	public int getSid() {
		return sid;
	}


	public void setSid(int sid) {
		this.sid = sid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name + "]";
	}

	public List<Course> getCourseList() {
		return courseList;
	}
	
	
}
