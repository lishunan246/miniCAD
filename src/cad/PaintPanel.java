package cad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

/**
 * It is a JPanel with an arrayList of Targets to be painted.
 * Created by li Shunan on 14-12-13.
 */
public class PaintPanel extends JPanel implements MouseListener,MouseMotionListener{

	private static final long serialVersionUID = 1L;
	public String globalString="text";
    public Mode mode = Mode.select;
    protected Point startPoint=new Point(0,0),endPoint=new Point(0,0);
    protected ArrayList<Target> arrayList = new ArrayList<>();
    protected boolean showCurrentRec=false;
    protected Color globalColor=Color.BLACK;
    //the selected target
    protected Target current;

    public void clear() {
        arrayList.clear();
        current=null;
        repaint();
    }

    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        for(Target target:arrayList)
        {
            target.draw(g);
        }

        if(current!=null)
            current.emphasize(g);

        if(showCurrentRec)
        {
            switch (mode) {
                case addString:
                    new CADString(startPoint,endPoint,globalColor,globalString).draw(g);
                    break;
                case addCircle:
                    new CADCircle(startPoint,endPoint,globalColor).draw(g);
                    break;
                case addRectangle:
                    new CADRectangle(startPoint, endPoint,globalColor).draw(g);
                    break;
                case addLine:
                    new CADLine(startPoint,endPoint,globalColor).draw(g);
                    break;
                case select:
                    break;
            }

        }


        this.addMouseListener(this);
        this.addMouseMotionListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

        startPoint = e.getPoint();
        showCurrentRec = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        endPoint = e.getPoint();

        switch (mode) {
            case addString:
                arrayList.add(new CADString(startPoint, endPoint, globalColor, globalString));
                break;
            case addCircle:
                arrayList.add(new CADCircle(startPoint, endPoint, globalColor));
                break;
            case addRectangle:
                arrayList.add(new CADRectangle(startPoint, endPoint, globalColor));
                break;
            case addLine:
                arrayList.add(new CADLine(startPoint, endPoint, globalColor));
                break;
            case select:
                break;
        }
        mode = Mode.select;
        showCurrentRec = false;
        repaint();

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        startPoint = e.getPoint();

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

        if (mode == Mode.select) {
            if (current == null)
                return;
            if (current.canBeMoved(e.getPoint())) {
                current.moveToPoint(e.getPoint());
            } else if (current.canChangeStartPoint(e.getPoint())) {
                current.changeStartPoint(e.getPoint());
            } else if (current.canChangeEndPoint(e.getPoint())) {
                current.changeEndPoint(e.getPoint());
            }

            repaint();
            return;
        }
        endPoint = e.getPoint();

        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

        for(Target target:arrayList)
        {
            if(target.pick(e.getPoint()))
            {
                current=target;
                break;
            }
        }

        repaint();
    }

    enum Mode {
        addString, addCircle, addRectangle, addLine, select
    }



}
