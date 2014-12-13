package cad;

import java.awt.*;

/**
 * Created by Li Shunan on 2014/12/13.
 */
public class CADString extends Target {
    private String string;

    public void draw(Graphics g)
    {
        string="dssf";
        g.drawString(string,x,y);
        g.drawString("bannwe",0,40);
    }


}
