import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javafx.scene.paint.Color;

public class MancalaGame
{
	private static Pit pits[] = new Pit[14]; //14 pits
	static JPanel panel = new JPanel();
	
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		frame.setSize(850,450);
		//frame.setLayout(new GridLayout());
		Board board = new Board(800,400);
		frame.add(board);
		
		//frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public void paint(Graphics g)
	{
		g.fillRect(100, 100, 400, 400);
		
	}
}
