package swing.pane;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

public class SplitPaneExample1 implements ActionListener{
	final String[] option1 = { "A", "B", "C", "D", "E" };
	final String[] option2 = { "1111", "2222", "3333", "4444", "5555" };
	JComboBox<String> box2;
	JTextArea ta = new JTextArea(20,20);
	JLabel label = new JLabel();
	JFrame frame;
	boolean togle = true;
	SplitPaneExample1() {
		// Create and set up the window.
		frame = new JFrame("JSplitPane Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// set flow layout for the frame
		frame.getContentPane().setLayout(new FlowLayout());
		JComboBox<String> box1 = new JComboBox<>(option1);
		box2 = new JComboBox<>(option2);
		Panel panel1 = new Panel();
		panel1.setLayout(new BorderLayout());
		panel1.add(box1, BorderLayout.NORTH);
		panel1.add(ta);
		Panel panel2 = new Panel();
		panel2.setLayout(new BorderLayout());
		panel2.add(box2, BorderLayout.NORTH);
		JButton jb = new JButton("add text");
		panel2.add(label, BorderLayout.CENTER);
		jb.addActionListener(this);
		panel2.add(jb, BorderLayout.SOUTH);
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panel1, panel2);
		// JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
		// panel1, panel2);
		frame.getContentPane().add(splitPane);
		frame.setSize(340, 400);
		// Display the window.
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new SplitPaneExample1();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String t = (String)box2.getSelectedItem();
		
		label.setText(t + " is selected");
		Dimension d = frame.getSize();
		if(d.width==340) {
			d.width = 341;
			frame.setSize(d);
		}else{
			d.width = 340;
			frame.setSize(d);
		};
	}
}
