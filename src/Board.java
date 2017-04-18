import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Board extends JPanel
{
	private int width;
	private int height;
	
	public Board(int width, int height)
	{
		this.width = width;
		this.height = height;
		
		Icon barIcon = new Icon() 
		{
			public int getIconWidth() 
			{
				return width;
			}

			public int getIconHeight() 
			{
				return height;
			}

			public void paintIcon(Component c, Graphics g, int x, int y) {
				Graphics2D g2 = (Graphics2D) g;

				g2.setColor(Color.GRAY);

				Rectangle2D rectangle = new Rectangle(width, height);
				g2.fill(rectangle);
				
			}
		};
		
		add(new JLabel(barIcon));
	}
	
}
