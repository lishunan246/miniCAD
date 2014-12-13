package cad;

import java.awt.*;

/**
 * Created by lishunan on 14-12-13.
 */
public class Target {
    private Color color;
    private int x;
    private int y;
    Graphics g;

    Target(Graphics g)
    {
        this.g=g;
    }

    public void draw()
    {
        g.drawLine(0,0,50,50);
    }


}
