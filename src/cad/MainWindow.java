package cad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by lishunan on 14-12-13.
 */
public class MainWindow extends JFrame implements ActionListener{
    private JMenuBar cadMenuBar;
    protected PaintPanel paintPanel;

    MainWindow()
    {
        this.setTitle("MiniCAD");
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //add paint panel

        paintPanel=new PaintPanel();
        this.add(paintPanel);

        //add MenuBar

        cadMenuBar=new JMenuBar();

            JMenu fileMenu=new JMenu("FILE");
            cadMenuBar.add(fileMenu);

                JMenuItem add=new JMenuItem("Quit");
                add.setActionCommand("quit");
                add.addActionListener(this);
                fileMenu.add(add);

            JMenu addMenu=new JMenu("Add");
            cadMenuBar.add(addMenu);

                JMenuItem jMenuItem=new JMenuItem("String");
                jMenuItem.setActionCommand("addString");
                //jMenuItem.addActionListener(paintPanel);
                jMenuItem.addActionListener(this);
                addMenu.add(jMenuItem);

                jMenuItem =new JMenuItem("Line");
                jMenuItem.setActionCommand("addLine");
                jMenuItem.addActionListener(this);
                addMenu.add(jMenuItem);

                jMenuItem =new JMenuItem("Rectangle");
                jMenuItem.setActionCommand("addRectangle");
                jMenuItem.addActionListener(this);
                addMenu.add(jMenuItem);

                jMenuItem =new JMenuItem("Circle");
                jMenuItem.setActionCommand("addCircle");
                jMenuItem.addActionListener(this);
                addMenu.add(jMenuItem);


        cadMenuBar.setVisible(true);


        this.setJMenuBar(cadMenuBar);

        //finally

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if("quit".equals(e.getActionCommand()))
        {
            System.exit(0);
        }
        else if("addString".equals(e.getActionCommand()))
        {
            System.out.print("dd");
            JDialog jDialog=new JDialog(this,"New String");
            jDialog.setSize(100,200);
            jDialog.setLocationRelativeTo(this);

            JTextField jTextField=new JTextField("",2);
            jDialog.add(jTextField);
            //jDialog.add(paintPanel);
            jDialog.setVisible(true);
            paintPanel.mode=paintPanel.mode.addString;
        }
        else if("addCircle".equals(e.getActionCommand()))
        {
            paintPanel.mode= PaintPanel.Mode.addCircle;
        }
        else if("addRectangle".equals(e.getActionCommand()))
        {
            paintPanel.mode=PaintPanel.Mode.addRectangle;
        }
        else if("addLine".equals(e.getActionCommand()))
        {
            paintPanel.mode= PaintPanel.Mode.addLine;
        }
    }
}
