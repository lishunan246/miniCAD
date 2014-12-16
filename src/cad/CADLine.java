package cad;

import javax.json.JsonObjectBuilder;
import java.awt.*;
/**
 * Created by Li Shunan on 2014/12/14.
 */
public class CADLine extends Target {

    CADLine(Point startPoint, Point endPoint, Color globalColor) {
        super(startPoint,endPoint,globalColor);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.drawLine(startPoint.x,startPoint.y,endPoint.x,endPoint.y);
    }

    @Override
    public JsonObjectBuilder getJsonObjectBuilder() {
        return super.getJsonObjectBuilder().add("type","line");
    }
}
