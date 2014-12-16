package cad;

import java.awt.*;

/**
 * Created by Li Shunan on 2014/12/14.
 */
public class CADCircle extends Target {
    CADCircle(Point startPoint, Point endPoint, Color globalColor)
    {
        super(startPoint,endPoint,globalColor);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.drawOval(x,y,w,h );
    }
}
