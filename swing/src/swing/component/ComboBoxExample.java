package swing.component;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class ComboBoxExample {
	ComboBoxExample() {
		JFrame f = new JFrame("ComboBox Example");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = f.getContentPane();
		c.setLayout(new BorderLayout());
		String country[] = { "China","India", "Aus", "U.S.A", "England", "Newzealand" };
		JComboBox<String> cb = new JComboBox<>(country);
		f.add(cb, BorderLayout.NORTH);
		f.setSize(400, 500);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new ComboBoxExample();
	}
}
