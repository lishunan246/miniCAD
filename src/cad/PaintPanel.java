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

    //the selected target
    protected Target current;

    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        for(Target target:arrayList)
        {
            target.draw(g);
            //target.emphasize(g);
        }

        if(current!=null)
            current.emphasize(g);

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

        if(current==null)
            return;
        current.moveToPoint(e.getPoint());
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(mode==Mode.select)
        {
            if(current==null)
                return;
            if(current.canBeMoved(e.getPoint()))
            {
               // startPoint=current.startPoint;
                //endPoint=current.endPoint;
            }
            return;
        }
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
                System.out.println(arrayList.size());
                break;
            case addLine:
                arrayList.add(new CADLine(startPoint,endPoint));
                break;
            case select:
                break;
            case edit:
                break;
        }
        mode=Mode.select;
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
//        System.out.print("dragging");
//        System.out.println(showCurrentRec);
        if(mode==Mode.select)
        {
            if(current==null)
                return;
            current.moveToPoint(e.getPoint());

            repaint();
            return;
        }
        endPoint=e.getPoint();

        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        for(int i=0;i<arrayList.size();i++)
        {
            if(arrayList.get(i).pick(e.getPoint()))
            {
                current=arrayList.get(i);
                break;
            }
        }
//        for(Target target:arrayList)
//        {
//            if(target.pick(e.getPoint()))
//            {
//                current=target;
//                break;
//            }
//        }
//        System.out.print("moving");
//        System.out.println(showCurrentRec);
        repaint();
    }



}
