package com.huaxia.danceticket;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * MainFrame include menu system and dance party information. allow user to sell
 * tickets to student, and refund their money and more.
 * 
 * @author John
 *
 */
public class MainFrame extends AbstractFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private static final String PROP_FILE = "resources/danceticket.properties";
	static {
//		System.setProperty("java.util.logging.config.file", "/Users/12818/workspace/Rodney/java/john/conf/logging.properties");
		String path = MainFrame.class.getClassLoader().getResource("logging.properties").getFile();
		System.out.println(path);
		System.setProperty("java.util.logging.config.file", path);		
//		System.setProperty("java.util.logging.ConsoleHandler.level", "java.util.logging.Level.WARNING");
	}
	static Logger logger = Logger.getLogger("DANCE_TICKET");

	public enum TicketType {
		EARLY_BIRD, DOOR
	};

	private JMenu ticket, find, help;
	private JMenuItem earlyBird, door, refund, one, all, exit, about, content;
	private MainPanel mainPnl;
	private JTextField statusTxt;
	private Properties prop;

	public Properties getProp() {
		return prop;
	}

	@Override
	protected void init() {
		loadProperties();
		Container root = getContentPane();
		root.setLayout(new BorderLayout());

		buildTitlePanel();
		buildMainPanel();
		buildStatusPanel();
		buildMenu();
	}

	private void loadProperties() {
		prop = new Properties();
		InputStream in = MainFrame.class.getClassLoader().getResourceAsStream(PROP_FILE);
		try {
			// load a properties file
			prop.load(in);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private JMenuBar buildMenu() {
		ticket = new JMenu("Ticket");
		earlyBird = new JMenuItem("Early Bird");
		door = new JMenuItem("Door");
		refund = new JMenuItem("Refund");
		exit = new JMenuItem("Exit");

		find = new JMenu("Find");
		all = new JMenuItem("All");
		one = new JMenuItem("One");

		help = new JMenu("Help");
		content = new JMenuItem("Content");
		about = new JMenuItem("About");

		earlyBird.addActionListener(this);
		door.addActionListener(this);
		refund.addActionListener(this);
		exit.addActionListener(this);
		one.addActionListener(this);
		all.addActionListener(this);
		content.addActionListener(this);
		about.addActionListener(this);

		JMenuBar menuBar = new JMenuBar();
		menuBar.add(ticket);
		menuBar.add(find);
		menuBar.add(help);
		ticket.add(earlyBird);
		ticket.add(door);
		ticket.add(refund);
		ticket.add(all);
		ticket.addSeparator();
		ticket.add(exit);
		find.add(one);
		find.add(all);
		help.add(content);
		help.add(about);
		return menuBar;
	}

	private void buildTitlePanel() {
		JPanel titlePnl = new JPanel();
		JLabel titleLbl = new JLabel("School Dance Ticket Center");
		titleLbl.setFont(new Font("Curier New", Font.BOLD, 20));
		titleLbl.setForeground(Color.BLUE);
		titleLbl.setAlignmentX(CENTER_ALIGNMENT);
		titlePnl.add(titleLbl, BorderLayout.CENTER);
		JPanel northPnl = new JPanel();
		northPnl.setLayout(new BorderLayout());
		northPnl.add(buildMenu(), BorderLayout.NORTH);
		northPnl.add(titlePnl, BorderLayout.CENTER);
		add(northPnl, BorderLayout.NORTH);
	}

	private void buildMainPanel() {
		mainPnl = new MainPanel(this);
		add(mainPnl, BorderLayout.CENTER);
	}

	private void buildStatusPanel() {
		JPanel statusPnl = new JPanel();
		statusPnl.setLayout(new BorderLayout());
		JLabel statusLbl = new JLabel("Status: ");
		statusPnl.add(statusLbl, BorderLayout.WEST);
		statusTxt = new JTextField(20);
		statusTxt.setText("Welcome to School Dance party!");
		statusTxt.setForeground(Color.BLUE);
		statusTxt.setEditable(false);
		statusPnl.add(statusTxt, BorderLayout.CENTER);
		add(statusPnl, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String item = e.getActionCommand();
		JDialog dialog;
		switch (item) {
		case "Early Bird":
			dialog = new TicketDialog(TicketType.EARLY_BIRD, this);
			dialog.setVisible(true);
			break;
		case "Door":
			dialog = new TicketDialog(TicketType.DOOR, this);
			dialog.setVisible(true);
			break;
		case "Refund":
			dialog = new RefundDialog(this);
			dialog.setVisible(true);
			break;
		case "One":
			dialog = new DetailDialog(this);
			dialog.setVisible(true);
			break;
		case "All":
			displayAll();
			break;
		case "Exit":
			dispose();
		case "About":
			about();
			break;
		case "Content":
			content();
			break;
		default:
			return;
		}
	}

	private void content() {
		JOptionPane.showMessageDialog(this, "Help content will be coming soon...");
	}

	private void about() {
		JOptionPane.showMessageDialog(this, "This is a homework assigned by Mr. xxxxx\nIt is using Binary Tree to store student information.\n\n Version 1.0");
	}

	private void displayAll() {
		String[][] data = getStudentData();
		String[] columnNames = { "ID", "Name", "Early Bird", "Door Price" };
		JDialog displayDlg = new JDialog();
		displayDlg.setTitle("All Students");
		displayDlg.setSize(300, 400);
		displayDlg.setLocationRelativeTo(this);
		JTable studentTbl = new JTable(data, columnNames);
		JScrollPane sp = new JScrollPane(studentTbl);
		displayDlg.add(sp);
		displayDlg.setVisible(true);
	}

	private String[][] getStudentData() {
		Student.loadAll();
		List<Student> studentList = new ArrayList<Student>();
		traverseInOrder(Student.students.root, studentList);
		int count = studentList.size();
		String[][] data = new String[count][4];
		for (int i = 0; i < count; i++) {
			Student s = studentList.get(i);
			data[i][0] = "" + s.getId();
			data[i][1] = s.getName();
			data[i][2] = "" + s.getEarlyBirdTickets();
			data[i][3] = "" + s.getDoorTickets();
		}
		return data;
	}

	private void traverseInOrder(Node<Student> current, List<Student> list) {
		if (current != null) {
			traverseInOrder(current.left, list);
			list.add(current.student);
			traverseInOrder(current.right, list);
		}
	}

	public void setStatus(String status) {
		statusTxt.setText(status);
	}

	public static void main(String[] params) {
		MainFrame frame = new MainFrame();
		frame.setVisible(true);
	}

}
