import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class RegularLayout implements BoardLayout
{
	public Shape pit()
	{
		return new Rectangle2D.Double(0,0,60,60);
	}

	public Shape mancala()
	{
		return new Rectangle2D.Double(0,0,60,400);
	}

}
