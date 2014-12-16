package cad;

import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import java.awt.*;

/**
 * The string class 
 * Created by Li Shunan on 2014/12/13.
 */
public class CADString extends Target {
    private String string;

    CADString(JsonObject jsonObject)
    {
        super(jsonObject);
        this.string=jsonObject.getString("string");
    }


    CADString(Point startPoint, Point endPoint, Color globalColor,String string)
    {
        super(startPoint,endPoint,globalColor);
        this.string=string;
    }

    public void draw(Graphics g)
    {
        super.draw(g);
        g.drawString(string,startPoint.x,startPoint.y);
    }

    @Override
    public JsonObjectBuilder getJsonObjectBuilder() {

        return super.getJsonObjectBuilder()
                .add("type","string")
                .add("string",string);
    }
}
