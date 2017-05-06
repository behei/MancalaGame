import java.awt.Color;
import java.awt.geom.RectangularShape;

public interface MancalaLayout {
    
	public RectangularShape getShape();
	
    public Color getBoardColor();
    
    public Color getMarbleColor();
}