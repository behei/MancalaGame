import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RectangularShape;
import javax.swing.JPanel;

public class Pit extends JPanel {

	private int width;
	private int height;
	private int numOfMarbles = 0;
	RectangularShape shape;
	Color boardColor;
	Color marbleColor;

	public boolean selected = false;

	public Pit(int w, int h, int marbles) {
		width = w;
		height = h;
		setPreferredSize(new Dimension(w, h));
		this.setLocation(0, 0);
		numOfMarbles = marbles;
	}
	
	public int getMarbles() {
		return this.numOfMarbles;
	}
	
	public Pit setMarbles(int marbles) {
		this.numOfMarbles = marbles;
		return this;
	}

	public void setLayout(MancalaLayout m) {
		shape = m.getShape();
		boardColor = m.getBoardColor();
		marbleColor = m.getMarbleColor();
	}

	public void paint(Graphics g) {
		final Graphics2D g2 = (Graphics2D) g;

		shape.setFrame(0, 0, width, height);
		g2.setColor(boardColor);
		g2.fill(shape);
		g2.setPaint(marbleColor);
		final Ellipse2D.Double marble = new Ellipse2D.Double(15, 50, 5, 5);
		for (int i = 0; i < numOfMarbles; i++) {
			if (i % 7 == 0) {
				marble.y += 10;
				marble.x = 10;
			} else {
				marble.x += 10;
			}

			g2.fill(marble);
			g2.draw(marble);
		}
	}
}