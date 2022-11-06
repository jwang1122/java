package swing.pane;

import javax.swing.JEditorPane;  
import javax.swing.JFrame;  
  
public class EditorPaneExample {  
  
    public static void main(String[] a) {  
        (new EditorPaneExample()).test();  
    }  
  
    private void test() {  
        JFrame f = new JFrame("JEditorPane Test");  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        f.setSize(400, 200);  
        JEditorPane myPane = new JEditorPane();  
        myPane.setContentType("text/plain");  
        myPane.setText("Sleeping is necessary for a healthy body."  
                + " But sleeping in unnecessary times may spoil our health, wealth and studies."  
                + " Doctors advise that the sleeping at improper timings may lead for obesity during the students days.");  
        f.setContentPane(myPane);  
        f.setVisible(true);  
    }  
}  