package cad;

import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import java.awt.*;

/**
 * Created by Li Shunan on 2014/12/13.
 */
public class CADString extends Target {
    private String string;
    private String type="string";
    static int count=0;

    CADString(JsonObject jsonObject)
    {
        super(jsonObject);
    }


    CADString(Point startPoint, Point endPoint, Color globalColor)
    {
        super(startPoint,endPoint,globalColor);
        count++;
        string=String.valueOf(count);
//        name=type+" "+string;
//        System.out.println(name);
    }





    public void draw(Graphics g)
    {
        super.draw(g);
        g.drawString("??????",startPoint.x,startPoint.y);
    }

    @Override
    public JsonObjectBuilder getJsonObjectBuilder() {
        return super.getJsonObjectBuilder().add("type","string");
    }
}
