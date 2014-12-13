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
        g.drawLine(0,0,50,50);
        g.drawString("bannwe",0,40);
    }

}
