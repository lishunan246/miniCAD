package cad;

import java.awt.*;

/**
 * Created by Li Shunan on 2014/12/14.
 */
public class CADRectangle extends Target {

    CADRectangle(Point startPoint,Point endPoint)
    {
        super(startPoint, endPoint);
    }

    @Override
    public void draw(Graphics g) {
        g.drawRect(x,y,w,h);
    }
}
