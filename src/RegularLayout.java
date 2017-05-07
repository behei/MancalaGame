import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RectangularShape;


/**
 * the regular layout class that implements MancalaLayout
 * following the strategy pattern
 *
 * @author Misha
 * @author Jordan
 * @author Tyler
 * @version 0.0.1
 * @since 05/06/2017
 */
class RegularLayout implements MancalaLayout {

    /**
     * constructor that sets the shape of the pit
     *
     * @return the new shape
     */
    public RectangularShape getShape() {
        return new Ellipse2D.Double();
    }

    /**
     * @return the color of the board
     */
    public Color getBoardColor() {
        return Color.WHITE;
    }

    /**
     * @return the color of the marble
     */
    public Color getMarbleColor() {
        return Color.BLACK;
    }

}