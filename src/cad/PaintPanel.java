package cad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Created by lishunan on 14-12-13.
 */
public class PaintPanel extends JPanel implements MouseListener,MouseMotionListener{

    enum Mode{
        addString,addCircle,addRectangle,addLine,select,edit;
    }
    protected Point startPoint,endPoint;
    protected ArrayList <Target> arrayList=new ArrayList<Target>();
    public Mode mode=Mode.select;
    protected boolean showCurrentRec=false;

    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        for(Target target:arrayList)
        {
            target.draw(g);
            target.emphasize(g);
        }

        if(showCurrentRec)
        {
            switch (mode) {
                case addString:
                    new CADString(startPoint,endPoint).draw(g);
                    break;
                case addCircle:
                    new CADCircle(startPoint,endPoint).draw(g);
                    break;
                case addRectangle:
                    new CADRectangle(startPoint, endPoint).draw(g);
                    break;
                case addLine:
                    new CADLine(startPoint,endPoint).draw(g);
                    break;
                case select:
                    break;
                case edit:
                    break;
            }

        }


        this.addMouseListener(this);
        this.addMouseMotionListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {


    }

    @Override
    public void mousePressed(MouseEvent e) {
        startPoint=e.getPoint();
        showCurrentRec=true;
//        System.out.print("start: ");
//        System.out.println(startPoint);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        endPoint=e.getPoint();
//        System.out.print("end: ");
//        System.out.println(endPoint);
        switch (mode) {
            case addString:
                arrayList.add(new CADString(startPoint,endPoint));
                break;
            case addCircle:
                arrayList.add(new CADCircle(startPoint,endPoint));
                break;
            case addRectangle:
                arrayList.add(new CADRectangle(startPoint,endPoint));
                break;
            case addLine:
                arrayList.add(new CADLine(startPoint,endPoint));
                break;
            case select:
                break;
            case edit:
                break;
        }
        showCurrentRec=false;
        repaint();

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        endPoint=e.getPoint();
        System.out.println(showCurrentRec);
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }



}
