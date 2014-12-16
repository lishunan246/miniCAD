package cad;

import java.awt.*;

/**
 * Created by Li Shunan on 2014/12/14.
 */
public class CADRectangle extends Target {

    CADRectangle(Point startPoint, Point endPoint, Color globalColor)
    {
        super(startPoint, endPoint,globalColor);
    }

    @Override
    public void draw(Graphics g) {

        super.draw(g);
        g.drawRect(x,y,w,h);
    }
}
