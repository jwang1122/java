package sqlitedb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class Passenger extends DBSetting{
	private int id;
	private String name;
	private String gender;
	private int age;
	private int ticket_id;
	
	public Passenger(int id, String name, String gender, int age) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
	
	public Passenger(int passenger_id) {
		this.id = passenger_id;
	}

	public Ticket getTicket() {
		Ticket t = new Ticket(ticket_id);
		t.retriveFromDB();
		return t;
	}


	public void retriveFromDB() {
		String sql = "SELECT * FROM passengers WHERE id='"+id+"'";
		
		try {
			ResultSet rs = db.retrieve(sql);
			setName(rs.getString("name"));
			setGender(rs.getString("gender"));
			setAge(rs.getInt("age"));
			setTicket_id(rs.getInt("ticket_id"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void writeToDB() {
		String sql = "INSERT INTO passengers values(?,?,?,?,?)";
		HashMap<Integer, Object> values = new HashMap<Integer, Object> ();
		values.put(1, id);
		values.put(2, name);
		values.put(3, gender);
		values.put(4, age);
		values.put(5, ticket_id);
		db.writeToDB(sql, values);;
	}
	
	public void updateToDB() {
		String sql = "UPDATE passengers SET name=?, gender=?, age=?, ticket_id=? WHERE id='" + id +"'";
		HashMap<Integer, Object> values = new HashMap<Integer, Object>();
		values.put(1, name);
		values.put(2, gender);
		values.put(3, age);
		values.put(4, ticket_id);
		db.writeToDB(sql, values);
	}
	
	public static void createTable() {
		String sql = "CREATE TABLE IF NOT EXISTS passengers ("
				+ "id int PRIMARY KEY, "
				+ "name text NOT NULL,"
				+ "gender text,"
				+ "age integer,"
				+ "ticket_id integer"
				+ ")";
		db.execute(sql);		
	}
	
	@Override
	public String toString() {
		return String.format("Passenger: (%s, %d, %d)", name, id, ticket_id);
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getTicket_id() {
		return ticket_id;
	}

	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}



}
