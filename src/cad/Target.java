package cad;

import java.awt.*;

/**
 * Created by lishunan on 14-12-13.
 */
public class Target {
    protected Color color;
    protected int x=0;
    protected int y=0;
    protected String name;

    Target()
    {

    }

    public void draw(Graphics g)
    {
        g.drawLine(0,0,50,50);
    }


}
