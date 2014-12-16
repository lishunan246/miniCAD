package cad;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import java.awt.*;

/**
 * Created by lishunan on 14-12-13.
 */
public class Target {
    protected Color color=Color.red;
    protected Point startPoint,endPoint,centerPoint;
    protected int x,y,w,h;

    Target(JsonObject jsonObject)
    {
        startPoint=new Point(jsonObject.getInt("startPoint.x"),jsonObject.getInt("startPoint.y"));
        endPoint=new Point(jsonObject.getInt("endPoint.x"),jsonObject.getInt("endPoint.y"));
        int c=jsonObject.getInt("color");
        color=new Color(c);
        updateXYWH();
    }


    Target(Point startPoint,Point endPoint,Color color)
    {
        this.startPoint=startPoint;
        this.endPoint=endPoint;
        this.color=color;

        updateXYWH();
        //System.out.println("created");
    }

    private void updateXYWH()
    {
        if(startPoint==null||endPoint==null)return;
        this.centerPoint=new Point((startPoint.x+endPoint.x)/2,(startPoint.y+endPoint.y)/2);

        if(startPoint.x<endPoint.x)
        {
            x=startPoint.x;
            w=endPoint.x-startPoint.x;
        }
        else
        {
            x=endPoint.x;
            w=startPoint.x-endPoint.x;
        }

        if(startPoint.y<endPoint.y)
        {
            y=startPoint.y;
            h=endPoint.y-startPoint.y;
        }
        else
        {
            y=endPoint.y;
            h=startPoint.y-endPoint.y;
        }
    }


    public void draw(Graphics g)
    {
        g.setColor(color);
    }

    public void emphasize(Graphics g)
    {
        emphasize(centerPoint,g);
        emphasize(startPoint,g);
        emphasize(endPoint,g);
    }

    private void emphasize(Point point,Graphics g)
    {
        int a=4;
        g.setColor(color);
        g.fillRect(point.x-a,point.y-a,2*a,2*a);
    }


    public boolean pick(Point point) {
        if(veryClose(point,endPoint)||veryClose(point,startPoint)||veryClose(centerPoint,point))
            return true;
        else
        {
            return false;
        }

    }

    private boolean veryClose(Point p1,Point p2)
    {
        return ((p1.x-p2.x)*(p1.x-p2.x)+(p1.y-p2.y)*(p1.y-p2.y))<500;
    }

    private boolean veryVeryClose(Point p1,Point p2)
    {
        return ((p1.x-p2.x)*(p1.x-p2.x)+(p1.y-p2.y)*(p1.y-p2.y))<100;
    }

    public boolean canBeMoved(Point point) {
        return veryVeryClose(point, centerPoint);
    }

    public void moveToPoint(Point point) {

        int x=point.x-centerPoint.x;
        int y=point.y-centerPoint.y;
        startPoint.y+=y;
        startPoint.x+=x;
        endPoint.y+=y;
        endPoint.x+=x;

        updateXYWH();
    }

    public void changeStartPoint(Point point) {
        startPoint=point;

        updateXYWH();
    }

    public boolean canChangeStartPoint(Point point) {
        return veryVeryClose(point,startPoint);
    }

    public boolean canChangeEndPoint(Point point) {
        return veryVeryClose(point,endPoint);
    }

    public void changeEndPoint(Point point) {
        endPoint=point;
        updateXYWH();
    }

    public void setColor(Color color) {
        this.color=color;
    }


    public JsonObjectBuilder getJsonObjectBuilder() {
        JsonObjectBuilder jsonObjectBuilder= Json.createObjectBuilder()
                .add("startPoint.x", startPoint.x)
                .add("startPoint.y",startPoint.y)
                .add("endPoint.x",endPoint.x)
                .add("endPoint.y",endPoint.y)
                .add("color",color.getRGB());
        return  jsonObjectBuilder;
    }
}
