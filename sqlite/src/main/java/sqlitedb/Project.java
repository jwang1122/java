package sqlitedb;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.UUID;

public class Project extends DBSetting{
	private String id;
	private String name;
	private Date beginDate;
	private Date endDate;
	
	public Project(String name, Date begineDate, Date endDate) {
		super();
		id = UUID.randomUUID().toString();
		this.name = name;
		this.beginDate = begineDate;
		this.endDate = endDate;
	}

	public static void createTable() {
		String sql = "CREATE TABLE IF NOT EXISTS project(id text PRIMARY KEY, name text NOT NULL, begin_date text, end_date text)";
		db.execute(sql);
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

	public Date getBegineDate() {
		return beginDate;
	}

	public void setBegineDate(Date begineDate) {
		this.beginDate = begineDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Project [name=" + name + ", begineDate=" + beginDate + "]";
	}
	
	
}
