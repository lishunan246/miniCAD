package cad;

import java.awt.*;

/**
 * Created by Li Shunan on 2014/12/13.
 */
public class CADString extends Target {
    private String string;
    private String type="string";
    static int count=0;

    CADString(Point startPoint, Point endPoint, Color globalColor)
    {
        super(startPoint,endPoint,globalColor);
        count++;
        string=String.valueOf(count);
//        name=type+" "+string;
//        System.out.println(name);
    }

    CADString(Point startPoint,Point endPoint)
    {

        super(startPoint,endPoint,Color .black);
        count++;
        string=String.valueOf(count);
    }



    public void draw(Graphics g)
    {
        super.draw(g);
        g.drawString("??????",startPoint.x,startPoint.y);
    }


}
