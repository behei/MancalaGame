 
import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RectangularShape;

public class SecondLayout implements MancalaLayout {
    
	
	public RectangularShape getShape() {
        return new Ellipse2D.Double();
    }

    
    public Color getBoardColor() 
    {
        return Color.BLACK;
    }
    
    
    public Color getMarbleColor() 
    {
        return Color.WHITE;
    }
}