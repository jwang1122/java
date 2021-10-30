package sqlitedb;

import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test {
	static void insert() {
		Book book = new Book("Cooking Skills", "John Q", 12.99);
		DBHelper db = new DBHelper("/Users/12818/workspace/java/mydb.db");
		String sql = "INSERT INTO books values('" + book.get_id() + "','" + book.getTitle() + "','" + book.getAuthor()
				+ "'," + book.isRead() + "," + book.getPrice() + "," + book.getRating() + ")";
		db.execute(sql);
	}

	static void testBook() {
//		insert();
//		Book book = new Book("Klara and the Sun", "Kazuo Ishig", 14.99);
//		book.create();		
//		Book book = new Book("The Last Magician", "Simon and Schuster", 16.95);
//		book.create();		
		Book book = Book.retrive("c77df320-3ce0-4778-bbf5-cb002a0d3736");
		System.out.println(book);
		DBHelper db = new DBHelper("/Users/12818/workspace/java/mydb.db");
		String sql = "SELECT * FROM books";
		ArrayList<Book> books = new ArrayList<>();
		try {
			ResultSet rs = db.retrieve(sql);
			while (rs.next()) {
				book = new Book();
				book.set_id(rs.getString("_id"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setRead(rs.getBoolean("read"));
				book.setPrice(rs.getDouble("price"));
				book.setRating(rs.getInt("rating"));
				books.add(book);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println(books);
	}

	static void testProject() {
//		Project.createTable();
		try {
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
			Date begin = sd.parse("2021-09-20");
			Date end = sd.parse("2021-09-30");
			Project p = new Project("Build tool room", begin, end);
			p.create();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	static void testTask() {
//		Task.createTable();
		try {
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
			Date begin = sd.parse("2021-09-20");
			Date end = sd.parse("2021-09-30");
			Task t = new Task("Design", 10, "f37d137f-f600-4415-bba4-6d0300100ab5", begin, end);
			t.create();
			t = new Task("Buy materials", 8, "f37d137f-f600-4415-bba4-6d0300100ab5", begin, end);
			t.create();
			t = new Task("Build Room", 5, "f37d137f-f600-4415-bba4-6d0300100ab5", begin, end);
			t.create();
			t = new Task("Test", 5, "f37d137f-f600-4415-bba4-6d0300100ab5", begin, end);
			t.create();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	static void testMany2Many() {
//		Student.createTable();
//		Course.createTable();
		Course c = new Course(4012, "Pysics4012");
//		c.create();
		c = new Course(4368, "COSC 4368");
//		c.create();
//		c = new Course(4370, "COSC 4370");
//		c.create();
//		c = new Course(4372, "COSC 4372");
//		c.create();
//		c = new Course(4397, "COSC 4397");
//		c.create();
//		c = new Course(4398, "COSC 4398");
//		c.create();
		Student s1 = new Student(1111, "John Martine");
//		s1.create();
//		Student s2 = new Student(2222, "Charles Lee");
//		s2.create();
//		Student s3 = new Student(3333, "Lee Robertson");
//		s3.create();
//		Student s4 = new Student(4444, "Terry Miller");
//		s4.create();
//		s1.enroll(4368);
//		s1.enroll(4370);
//		s2.enroll(4368);
//		s3.enroll(4368);
//		s4.enroll(4398);
//		s4.enroll(4372);
		List<String> students = c.getStudents();
		System.out.println(students);
		List<String> courses = s1.getCourses();
		System.out.println(courses);
	}

	static void testPassenger() {
//		Passenger.createTable();
		Passenger p = new Passenger(1111, "John", "Male", 16);
//		p.writeToDB();
//		p.setTicket_id(1234);
//		p.updateToDB();
		p.retriveFromDB();
		Ticket t = p.getTicket();
		System.out.println(t);
	}
	
	static void testTicket() {
//		Ticket.createTable();
		Ticket t = new Ticket(1234);
//		t.setAirline("United Air");
//		t.setArrival("2021-11-02 09:13:00");
//		t.setDepature("2021-11-02 13:33:00");
//		t.setFlight("UA98");
//		t.setGate("C-11");
//		t.setPassenger_id(1111);
//		t.writeToDB();
		t.retriveFromDB();
		System.out.println(t);
		Passenger p = t.getPassenger();
		System.out.println(p);
	}
	
	static void insertTask() {
		try {
			Date begin = Project.sdf.parse("2021-11-02");
			Date end = Project.sdf.parse("2021-11-14");
			Task task1 = new Task("proj1111-t1",5,"6f52cc62-1465-4926-a7db-0225faad7dcf",begin,end);
			task1.create();
			begin = Project.sdf.parse("2021-11-10");
			end = Project.sdf.parse("2021-11-18");
			Task task2 = new Task("proj1111-t2",3,"6f52cc62-1465-4926-a7db-0225faad7dcf",begin,end);
			task2.create();
			begin = Project.sdf.parse("2021-11-19");
			end = Project.sdf.parse("2021-12-01");
			Task task3 = new Task("proj1111-t3",1,"6f52cc62-1465-4926-a7db-0225faad7dcf",begin,end);
			task3.create();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	
	static void insertProject() {
		try {
			Date begin = Project.sdf.parse("2021-11-02");
			Date end = Project.sdf.parse("2021-12-04");
			Project proj = new Project("proj1111",begin,end);
			proj.create();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	
	static Project loadProject() {
		Project proj = new Project("6f52cc62-1465-4926-a7db-0225faad7dcf");
		proj.load();
		return proj;
		
	}
	private static Task loadTask() {
		Task task = new Task("868aedac-c182-46b7-a110-999691a5d58f");
		task.load();
		return task;
	}
	
	public static void main(String[] args) {
//		testBook();
//		testProject();
//		testTask();
//		testMany2Many();
//		testTicket();
//		testPassenger();
//		Project.createTable();
//		Task.createTable();
//		insertProject();
//		insertTask();
		Project p = loadProject();
		System.out.println(p);
		System.out.println(p.getTaskList());
		Task task = loadTask();
		System.out.println(task);
		System.out.println(task.getProject());
		System.out.println("Done.");
	}

}
