import java.awt.Color;
import java.awt.geom.RectangularShape;

/**
 * following Strategy pattern, the interface that will be implemented in
 * two concrete classes
 * @author Misha
 * @author Jordan
 * @author Misha
 * @version 0.0.1
 * @since 05/06/2017s
 */
public interface MancalaLayout {
    
	public RectangularShape getShape();
	
    public Color getBoardColor();
    
    public Color getMarbleColor();
}