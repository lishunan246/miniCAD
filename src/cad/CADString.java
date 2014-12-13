package cad;

import java.awt.*;

/**
 * Created by Li Shunan on 2014/12/13.
 */
public class CADString extends Target {
    private String string;
    private String type="string";
    static int count=0;

    CADString()
    {
        count++;
        string=String.valueOf(count);
        name=type+" "+string;
        System.out.println(name);
    }


    public void draw(Graphics g)
    {
        g.drawString(string,0,40);
    }


}
