package sqlitedb;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Task extends DBSetting {
	private String id;
	private String name;
	private int priority;
	private String projectId;
	private Date beginDate;
	private Date endDate;
	private Project project;
	
	public Task(String name, int priority, String projectId, Date beginDate, Date endDate) {
		super();
		id = UUID.randomUUID().toString();
		this.name = name;
		this.priority = priority;
		this.projectId = projectId;
		this.beginDate = beginDate;
		this.endDate = endDate;
	}

	public Task(String id) {
		this.id = id;
	}

	public static void createTable() {
		String sql = "CREATE TABLE IF NOT EXISTS task(id text PRIMARY KEY, name text NOT NULL, priority integer, project_id text NOT NULL, begin_date text, end_date text)";
		db.execute(sql);
	}

	public void create() {
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		String begin = sd.format(beginDate);
		String end = sd.format(endDate);
		String sqlFormat = "INSERT INTO task VALUES('%s','%s', %d, '%s','%s','%s')";
		String sql = String.format(sqlFormat, id, name, priority, projectId, begin, end);
		db.execute(sql);
	}

	public void load() {
		String sql = "SELECT * FROM task WHERE id='" + this.id + "'"; // database retrieve
		ResultSet rs = db.retrieve(sql);
		try {
			this.setName(rs.getString("name"));
			this.setPriority(rs.getInt("priority"));
			this.setProjectId(rs.getString("project_id"));
			Date begin = Project.sdf.parse(rs.getString("begin_date"));
			setBeginDate(begin);
			Date end = Project.sdf.parse(rs.getString("end_date"));
			setEndDate(end);
			
			sql = "SELECT * FROM project WHERE id='" + this.projectId + "'";
			rs = db.retrieve(sql);
			while(rs.next()) {
				project = new Project(this.projectId);
				project.setName(rs.getString("name"));
				begin = Project.sdf.parse(rs.getString("begin_date"));
				end = Project.sdf.parse(rs.getString("end_date"));
				project.setBeginDate(begin);
				project.setEndDate(end);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
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

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Override
	public String toString() {
		return "Task [name=" + name + "]";
	}
}
