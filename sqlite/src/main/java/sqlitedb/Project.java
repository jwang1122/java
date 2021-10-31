package sqlitedb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.UUID;

public class Project extends DBSetting{
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private String id;
	private String name;
	private Date beginDate;
	private Date endDate;
	private List<Task> taskList = new ArrayList<>();
	
	public Project(String name, Date beginDate, Date endDate) {
		super();
		id = UUID.randomUUID().toString();
		this.name = name;
		this.beginDate = beginDate;
		this.endDate = endDate;
	}

	public Project(String id) {
		this.id = id;
	}

	public static void createTable() {
		String sql = "CREATE TABLE IF NOT EXISTS project(id text PRIMARY KEY, name text NOT NULL, begin_date text, end_date text)";
		db.execute(sql);
	}

	public void load() {
		String sql = "SELECT * FROM project WHERE id='" + this.id + "'"; // database retrieve
		ResultSet rs = db.retrieve(sql);
		try {
			this.setName(rs.getString("name"));
			Date begin = sdf.parse(rs.getString("begin_date"));
			setBeginDate(begin);
			Date end = sdf.parse(rs.getString("end_date"));
			setEndDate(end);
			
			sql = "SELECT * FROM task WHERE project_id='" + id + "'";
			rs = db.retrieve(sql);
			while(rs.next()) {
				String task_id = rs.getString("id");
				String task_name = rs.getString("name");
				int priority = rs.getInt("priority");
				begin = sdf.parse(rs.getString("begin_date"));
				end = sdf.parse(rs.getString("end_date"));
				Task task = new Task(task_name, priority, this.id, begin, end);
				task.setId(task_id);
				taskList.add(task);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void create() {
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		String begin = sd.format(beginDate);
		String end = sd.format(endDate);
		String sqlFormat = "INSERT INTO project VALUES('%s','%s','%s','%s')";
		String sql = String.format(sqlFormat, id, name, begin, end);
		db.execute(sql);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<Task> getTaskList() {
		return taskList;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdfUS = new SimpleDateFormat("MM/dd/yyyy");
		return "Project [name=" + name + ", begineDate=" + sdfUS.format(beginDate) + "]";
	}
	
	
}
