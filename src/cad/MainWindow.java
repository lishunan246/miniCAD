package cad;

import javax.swing.*;
import java.awt.*;

/**
 * Created by lishunan on 14-12-13.
 */
public class MainWindow extends JFrame{
    private CADMenuBar cadMenuBar;



    MainWindow()
    {
        this.setTitle("MiniCAD");
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PaintPanel paintPanel=new PaintPanel();
        this.add(paintPanel);

        cadMenuBar=new CADMenuBar(paintPanel);
        this.setJMenuBar(cadMenuBar);

        this.setVisible(true);
    }

}
