import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;

import javax.swing.JPanel;

public class PitPanel extends JPanel
{
	private int pitnumber;
	private String side;
	private BoardLayout l;
	
	public PitPanel(int pitnumber, String side, BoardLayout l)
	{
		this.l = l;
		this.side = side;
		this.pitnumber = pitnumber;
	}
	
	public void paintComponent(Graphics g)
	   {
	      super.paintComponent(g);
	      Graphics2D g2 = (Graphics2D) g;
	      
	      g2.draw(l.pit());
	      g2.fill(l.pit());
	   }
}
