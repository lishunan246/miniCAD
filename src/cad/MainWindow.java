package cad;

import javax.swing.*;

/**
 * Created by lishunan on 14-12-13.
 */
public class MainWindow extends JFrame{
    MainWindow()
    {
        this.setTitle("MiniCAD");
        this.setSize(200,100);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.add(new PaintPanel());
    }

}
