package com.huaxia.swing.pane;

import javax.swing.JEditorPane;    
import javax.swing.JFrame;    
    
public class EditorPaneExample1 {    
    public static void main(String[] a) {    
        (new EditorPaneExample1()).test();    
    }    
    
    private void test() {    
        JFrame f = new JFrame("JEditorPane Test");    
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
        f.setSize(400, 200);    
        JEditorPane myPane = new JEditorPane();    
        myPane.setContentType("text/html");    
        myPane.setText("<h1>Sleeping</h1><p><b>Sleeping</b> is necessary for a healthy body."    
                + " But <b>sleeping</b> in unnecessary times may spoil our health, wealth and studies."    
                + " <font style=\"color:red\"><b>Doctors</b></font> advise that the <b>sleeping</b> at improper timings may lead for obesity during the students days.</p>");    
        f.setContentPane(myPane);    
        f.setVisible(true);    
    }    
}    
