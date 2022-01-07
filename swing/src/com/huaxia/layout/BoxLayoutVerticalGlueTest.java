package com.huaxia.swing.layout;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.LayoutManager;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BoxLayoutVerticalGlueTest {

  public static void main(String[] args) {
    JFrame f = new JFrame("Vertical BoxLayout-managed container");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container pane = new BoxPanel();
    f.setContentPane(pane);
    pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
    for (float align = 0.0f; align <= 1.0f; align += 0.25f) {
      JButton button = new JButton("X Alignment = " + align);
      button.setAlignmentX(align);
      pane.add(button);
      pane.add(Box.createVerticalGlue());
    }
    f.setSize(400, 300);
    f.setVisible(true);
  }

}

class BoxPanel extends JPanel {

  public void paintChildren(Graphics g) {
    super.paintChildren(g);
    Dimension size = getSize();
    LayoutManager manager = getLayout();
    if ((manager != null) && (manager instanceof BoxLayout)) {
      BoxLayout layout = (BoxLayout) manager;
      boolean vertical = true;
      if (vertical) {
        int axis = (int) (layout.getLayoutAlignmentX(this) * size.width);
        g.fillRect(axis - 1, 0, 3, size.height);
      } else {
        int axis = (int) (layout.getLayoutAlignmentY(this) * size.height);
        g.fillRect(0, axis - 1, size.width, 3);
      }
    }
  }

}