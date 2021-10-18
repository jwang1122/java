package sqlitedb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class Ticket extends DBSetting{
	private int id;
	private String flight;
	private String depature;
	private String arrival;
	private String gate;
	private String airline;
	private int passenger_id;
	
	public Ticket(int id) {
		super();
		this.id = id;
	}

	public Passenger getPassenger() {
		Passenger p = new Passenger(passenger_id);
		p.retriveFromDB();
		return p;
	}

	public void retriveFromDB() {
		String sql = "SELECT * FROM tickets WHERE id='"+id+"'";
		
		try {
			ResultSet rs = db.retrieve(sql);
			setFlight(rs.getString("flight"));
			setDepature(rs.getString("depature"));
			setDepature(rs.getString("arrival"));
			setDepature(rs.getString("gate"));
			setDepature(rs.getString("airline"));
			setPassenger_id(rs.getInt("passenger_id"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void writeToDB() {
		String sql = "INSERT INTO tickets values (?,?,?,?,?,?,?)";
		HashMap<Integer, Object> values = new HashMap<>();
		values.put(1, id);
		values.put(2, flight);
		values.put(3, depature);
		values.put(4, arrival);
		values.put(5, gate);
		values.put(6, airline);
		values.put(7, passenger_id);
		db.writeToDB(sql, values);
	}

	public static void createTable() {
		String sql = "CREATE TABLE IF NOT EXISTS tickets ("
				+ "id int PRIMARY KEY, "
				+ "flight text NOT NULL,"
				+ "depature text,"
				+ "arrival text,"
				+ "gate text,"
				+ "airline text,"
				+ "passenger_id integer"
				+ ")";
		db.execute(sql);		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFlight() {
		return flight;
	}

	public void setFlight(String flight) {
		this.flight = flight;
	}

	public String getDepature() {
		return depature;
	}

	public void setDepature(String depature) {
		this.depature = depature;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public String getGate() {
		return gate;
	}

	public void setGate(String gate) {
		this.gate = gate;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public int getPassenger_id() {
		return passenger_id;
	}

	public void setPassenger_id(int passenger_id) {
		this.passenger_id = passenger_id;
	}

	@Override
	public String toString() {
		return String.format("Ticket: (%s, %d, %d)", flight, id, passenger_id);
	}

	
	
}
