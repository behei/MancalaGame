import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class Mancala extends JComponent
{
	private int marbles;
	private BoardLayout l;
	
	public Mancala(int marbles, BoardLayout l)
	{
		this.marbles = marbles;
		this.l = l;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
	}
}
