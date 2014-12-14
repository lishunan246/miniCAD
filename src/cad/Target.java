package cad;

import java.awt.*;

/**
 * Created by lishunan on 14-12-13.
 */
public class Target {
    protected Color color;
    protected Point startPoint,endPoint;
    protected int x,y,w,h;

    Target(Point startPoint,Point endPoint)
    {
        this.startPoint=startPoint;
        this.endPoint=endPoint;

        if(startPoint.x<endPoint.x)
        {
            x=startPoint.x;
            w=endPoint.x-startPoint.x;
        }
        else
        {
            x=endPoint.x;
            w=startPoint.x-startPoint.y;
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


    Target()
    {

    }

    public void draw(Graphics g)
    {
        g.drawLine(0,0,50,50);
    }


}
