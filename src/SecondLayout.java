/**
 * Created by mishabehey on 4/20/17.
 */

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 * follow Strategy pattern and create a second layout
 * remark: changed the shape of the pit for now
 */
public class SecondLayout implements BoardLayout
{
    public Shape pit()
    {
        return new Ellipse2D.Double(0,0,60,60);
    }

    public Shape Mancala()
    {
        return new Ellipse2D.Double(0,0,60,400);
    }


}
