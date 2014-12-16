package cad;

import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import java.awt.*;

/**
 * Created by Li Shunan on 2014/12/14.
 */
public class CADCircle extends Target {
    CADCircle(JsonObject jsonObject)
    {
        super(jsonObject);
    }

    CADCircle(Point startPoint, Point endPoint, Color globalColor)
    {
        super(startPoint,endPoint,globalColor);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.drawOval(x,y,w,h );
    }

    @Override
    public JsonObjectBuilder getJsonObjectBuilder() {
        return super.getJsonObjectBuilder()
                .add("type","circle");
    }
}
