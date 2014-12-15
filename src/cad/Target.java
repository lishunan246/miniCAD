package cad;

import java.awt.*;

/**
 * Created by lishunan on 14-12-13.
 */
public class Target {
    protected Color color;
    protected Point startPoint,endPoint,centerPoint;
    protected int x,y,w,h;

    Target(Point startPoint,Point endPoint)
    {
        this.startPoint=startPoint;
        this.endPoint=endPoint;

        centerPoint=new Point((startPoint.x+endPoint.x)/2,(startPoint.y+endPoint.y)/2);

        updateXYWH();
        //System.out.println("created");
    }


    Target()
    {

    }

    private void updateXYWH()
    {
        if(startPoint.x<endPoint.x)
        {
            x=startPoint.x;
            w=endPoint.x-startPoint.x;
        }
        else
        {
            x=endPoint.x;
            w=startPoint.x-endPoint.x;
        }

        if(startPoint.y<endPoint.y)
        {
            y=startPoint.y;
            h=endPoint.y-startPoint.y;
        }
        else
        {
            y=endPoint.y;
            h=startPoint.y-endPoint.y;
        }
    }


    public void draw(Graphics g)
    {}

    public void emphasize(Graphics g)
    {
        emphasize(centerPoint,g);
        emphasize(startPoint,g);
        emphasize(endPoint,g);
    }

    private void emphasize(Point point,Graphics g)
    {
        int a=4;
        g.fillRect(point.x-a,point.y-a,2*a,2*a);
    }


    public boolean pick(Point point) {
        if(veryClose(point,endPoint)||veryClose(point,startPoint)||veryClose(centerPoint,point))
            return true;
        else
        {
            return false;
        }

    }

    private boolean veryClose(Point p1,Point p2)
    {
        return ((p1.x-p2.x)*(p1.x-p2.x)+(p1.y-p2.y)*(p1.y-p2.y))<500;
    }

    private boolean veryVeryClose(Point p1,Point p2)
    {
        return ((p1.x-p2.x)*(p1.x-p2.x)+(p1.y-p2.y)*(p1.y-p2.y))<100;
    }

    public boolean canBeMoved(Point point) {
        return veryVeryClose(point, centerPoint);
    }

    public void moveToPoint(Point point) {

        int x=point.x-centerPoint.x;
        int y=point.y-centerPoint.y;
        startPoint.y+=y;
        startPoint.x+=x;
        endPoint.y+=y;
        endPoint.x+=x;
        centerPoint=point;
        updateXYWH();
    }
}
