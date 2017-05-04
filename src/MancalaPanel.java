import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class MancalaPanel extends JPanel
{
	
	private BoardLayout l;
	private String side;
	
	public MancalaPanel(String side, BoardLayout l)
	{
		this.l = l;
		this.side = side;
	}
	
	public void paintComponent(Graphics g)
	   {
	      super.paintComponent(g);
	      Graphics2D g2 = (Graphics2D) g;
	      
	      g2.draw(l.mancala());
	     
	   }

}
