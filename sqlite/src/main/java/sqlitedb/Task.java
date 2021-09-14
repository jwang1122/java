package sqlitedb;

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
	
	public Task(String name, int priority, String projectId, Date beginDate, Date endDate) {
		super();
		id = UUID.randomUUID().toString();
		this.name = name;
		this.priority = priority;
		this.projectId = projectId;
		this.beginDate = beginDate;
		this.endDate = endDate;
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

	@Override
	public String toString() {
		return "Task [name=" + name + "]";
	}
}
