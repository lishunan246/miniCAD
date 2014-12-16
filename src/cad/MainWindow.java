package cad;

import javax.json.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * This is the main JFrame of the program
 * Created by Li Shunan on 14-12-13.
 */
public class MainWindow extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
    protected PaintPanel paintPanel;
    private JMenuBar cadMenuBar;

    MainWindow()
    {
        this.setTitle("MiniCAD");
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //add paint panel

        paintPanel=new PaintPanel();
        this.add(paintPanel);

        //add MenuBar

        cadMenuBar=new JMenuBar();

        JMenu menu=new JMenu("FILE");
        cadMenuBar.add(menu);

        JMenuItem add=new JMenuItem("Open");
        add.setActionCommand("open");
        add.addActionListener(this);
        menu.add(add);

        add=new JMenuItem("Clear");
        add.setActionCommand("clear");
        add.addActionListener(this);
        menu.add(add);

        add=new JMenuItem("Save");
        add.setActionCommand("save");
        add.addActionListener(this);
        menu.add(add);

        add=new JMenuItem("Quit");
        add.setActionCommand("quit");
        add.addActionListener(this);
        menu.add(add);

        menu=new JMenu("ADD");
        cadMenuBar.add(menu);

        JMenuItem jMenuItem=new JMenuItem("String");
        jMenuItem.setActionCommand("addString");
        jMenuItem.addActionListener(this);
        menu.add(jMenuItem);

        jMenuItem =new JMenuItem("Line");
        jMenuItem.setActionCommand("addLine");
        jMenuItem.addActionListener(this);
        menu.add(jMenuItem);

        jMenuItem =new JMenuItem("Rectangle");
        jMenuItem.setActionCommand("addRectangle");
        jMenuItem.addActionListener(this);
        menu.add(jMenuItem);

        jMenuItem =new JMenuItem("Circle");
        jMenuItem.setActionCommand("addCircle");
        jMenuItem.addActionListener(this);
        menu.add(jMenuItem);

        menu=new JMenu("EDIT");
        jMenuItem=new JMenuItem("Select");
        jMenuItem.setActionCommand("select");
        jMenuItem.addActionListener(this);
        menu.add(jMenuItem);

        jMenuItem=new JMenuItem("Delete");
        jMenuItem.setActionCommand("delete");
        jMenuItem.addActionListener(this);
        menu.add(jMenuItem);

        jMenuItem=new JMenuItem("Choose color");
        jMenuItem.setActionCommand("chooseColor");
        jMenuItem.addActionListener(this);
        menu.add(jMenuItem);
        cadMenuBar.add(menu);

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
            String input= JOptionPane.showInputDialog(this,"Input text");
            if(input==null)
                return;

            paintPanel.globalString=input;

            paintPanel.mode=PaintPanel.Mode.addString;
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
        else if("select".equals(e.getActionCommand()))
        {
            paintPanel.mode= PaintPanel.Mode.select;
        }
        else if("chooseColor".equals(e.getActionCommand()))
        {
            Color color=JColorChooser.showDialog(this, "Choose a color", Color.BLACK);
            paintPanel.globalColor=color;
            if(paintPanel.current!=null)
                paintPanel.current.setColor(color);

            paintPanel.repaint();
        }
        else if("save".equals(e.getActionCommand()))
        {
            JFileChooser jFileChooser=new JFileChooser();

            if(jFileChooser.showSaveDialog(this)==JFileChooser.APPROVE_OPTION)
            {
                File file=new File(jFileChooser.getSelectedFile().toString());
                try {
                    PrintWriter printWriter=new PrintWriter(file);

                    JsonArrayBuilder jsonArrayBuilder=Json.createArrayBuilder();

                    for(Target target: paintPanel.arrayList)
                    {
                        jsonArrayBuilder.add(target.getJsonObjectBuilder());
                    }

                    JsonArray jsonArray=jsonArrayBuilder.build();

                    JsonObject jsonObject1 =
                            Json.createObjectBuilder()
                                    .add("target", jsonArray)
                                    .build();
                    printWriter.print(jsonObject1);

                    printWriter.close();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(this,"Fail saving to file");

                }

            }
        }
        else if("clear".equals(e.getActionCommand()))
        {
            paintPanel.clear();
        }
        else if("open".equals(e.getActionCommand()))
        {
            JFileChooser jFileChooser=new JFileChooser();
            if(jFileChooser.showOpenDialog(this)==JFileChooser.APPROVE_OPTION)
            {
                File file=new File(jFileChooser.getSelectedFile().toString());
                try {
                    InputStream inputStream=new FileInputStream(file);
                    JsonReader jsonReader=Json.createReader(inputStream);
                    JsonObject jsonObject=jsonReader.readObject();
                    JsonArray jsonArray= jsonObject.getJsonArray("target");

                    paintPanel.clear();

                    for(int i=0;i<jsonArray.size();i++)
                    {
                        JsonObject object=jsonArray.getJsonObject(i);
                        String type=object.getString("type");
                        switch (type)
                        {
                            case "circle":
                                paintPanel.arrayList.add(new CADCircle(object));
                                break;
                            case "line":
                                paintPanel.arrayList.add(new CADLine(object));
                                break;
                            case "rectangle":
                                paintPanel.arrayList.add(new CADRectangle(object));
                                break;
                            case "string":
                                paintPanel.arrayList.add(new CADString(object));
                                break;
                        }
                    }


                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(this, "unable to open file");
                }

            }
        }
        else if("delete".equals(e.getActionCommand()))
        {
            if(paintPanel.current==null)
                return;

            for (int i=0;i<paintPanel.arrayList.size();i++)
            {
                if (paintPanel.current==paintPanel.arrayList.get(i))
                {
                    paintPanel.arrayList.remove(i);
                    System.out.print("del");
                    paintPanel.current=null;
                    break;
                }
            }
            repaint();
        }
    }
}
