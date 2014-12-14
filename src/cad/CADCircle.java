package cad;

import java.awt.*;

/**
 * Created by Li Shunan on 2014/12/14.
 */
public class CADCircle extends Target {
    CADCircle(Point startPoint,Point endPoint)
    {
        super(startPoint,endPoint);
    }

    @Override
    public void draw(Graphics g) {
        g.drawOval(x,y,w,h );
    }
}
