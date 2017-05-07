import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RectangularShape;



class RegularLayout implements MancalaLayout {

    
    public RectangularShape getShape() {
        return new Ellipse2D.Double();
    }

    
    public Color getBoardColor() {
        return Color.WHITE;
    }  
    
    
    public Color getMarbleColor() {
        return  Color.BLACK;
    }  
    
}