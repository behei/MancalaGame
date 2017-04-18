import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public class RegularLayout implements BoardLayout
{
	public Shape getPits() 
	{
		return new Ellipse2D.Double(0,0,60,60);
	}

	public Shape getGoals() 
	{
		return new Ellipse2D.Double(0,0,60,400);
	}

}
