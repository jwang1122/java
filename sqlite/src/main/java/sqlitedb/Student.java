package sqlitedb;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Student extends DBSetting {
	private int sid;
	private String name;
	
	public Student(int sid, String name) {
		super();
		this.sid = sid;
		this.name = name;
	}

	public static void createTable() {
		String sql = "CREATE TABLE IF NOT EXISTS student(id int PRIMARY KEY, name text NOT NULL)";
		db.execute(sql);		
		sql = "CREATE TABLE IF NOT EXISTS enrollment(sid int, cid int, PRIMARY KEY (sid, cid)"; // composite primary key
		db.execute(sql);		
	}
	
	public void create() {
		String sqlFormat = "INSERT INTO student values('%d','%s')";
		String sql = String.format(sqlFormat, sid, name);
		db.execute(sql);
	}

	public void enroll(int courseId) {
		String sqlFormat = "INSERT INTO enrollment values(%d, %d)";
		String sql = String.format(sqlFormat, sid, courseId);
		db.execute(sql);
	}
	
	public List<String> getCourses(){
		String sql = "SELECT Course.name FROM Course JOIN Enrollment ON(Course.id=Enrollment.cid) JOIN Student ON(Enrollment.sid=Student.id) WHERE Student.id=" + sid;
		ResultSet rs = db.retrieve(sql);
		ArrayList<String> courseNames = new ArrayList<>();
		try {
			while (rs.next()) {
				courseNames.add(rs.getString(1));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return courseNames;
		
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
	
	
}
