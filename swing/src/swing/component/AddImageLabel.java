package swing.component;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class AddImageLabel {

    public AddImageLabel() {
        createAndShowUI();
    }

    private void createAndShowUI() {
        JFrame frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640, 480);

        initComponents(frame);

        frame.setResizable(true);
//        frame.pack();
        frame.setVisible(true);
    }

    private void initComponents(final JFrame frame) {

        final JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.yellow);
        JButton button = new JButton("Add label");
		URL url = getClass().getClassLoader().getResource("resources/diamond10.gif");
    	ImageIcon img = new ImageIcon(url);

        button.addActionListener(new ActionListener() {
            int count = 1;

            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel _lbl = new JLabel(img);//make label and assign text in 1 line
                
                panel.add(_lbl, 0);//add label we made
                _lbl.setLocation(count*30, 100);
                _lbl.setSize(125,170);

//                panel.revalidate();
                panel.repaint();
                count++;
            }
        });

        frame.add(panel, BorderLayout.CENTER);
        frame.add(button, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AddImageLabel();
            }
        });
    }
}