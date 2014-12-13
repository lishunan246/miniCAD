package cad;

import javax.swing.*;
import java.awt.*;

/**
 * Created by lishunan on 14-12-13.
 */
public class PaintPanel extends JPanel {
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Target target=new Target(g);
        target.draw();

        g.drawString("bannwe",0,40);
    }

}
