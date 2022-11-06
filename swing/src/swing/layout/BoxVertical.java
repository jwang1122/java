package swing.layout;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class BoxVertical {
  public static void main(String args[]) {
    JFrame verticalFrame = new JFrame("Vertical");
    verticalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Box verticalBox = Box.createVerticalBox();
    verticalBox.add(new JLabel("Top"));
    verticalBox.add(new JTextField("Middle"));
    verticalBox.add(new JButton("Bottom"));
    verticalFrame.add(verticalBox, BorderLayout.CENTER);
    verticalFrame.setSize(150, 150);
    verticalFrame.setVisible(true);

  }
}