import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class RegularLayout implements BoardLayout {
	public Shape pit() {
		return new Rectangle2D.Double(0, 65, 80, 80);
	}

	public Shape mancala() {
		return new Rectangle2D.Double(0, 20, 150, 400);
	}

	public Shape marble() {
		return new Rectangle2D.Double(0, 30, 30, 30);
	}
}
