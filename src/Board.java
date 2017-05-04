import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import javafx.scene.shape.Ellipse;

/*
 *  This class will be responsible for drawing the board and grabbing to model MVC Pattern
 *  I have started the code which is similar to the way I did HW3 but changed from text to ellipse
 */
public class Board extends JFrame implements ChangeListener {
	
	
	private ArrayList<Ellipse2D> list = new ArrayList<Ellipse2D>();
	private BoardLayout l;
	private int startingMarbles;

	//Board takes the layout
	public Board(BoardLayout l) 
	{
		JPanel leftgoal = new JPanel();
		JPanel rightgoal = new JPanel();
		JPanel middlepits = new JPanel();
		middlepits.setLayout(new GridLayout(2, 6));
		
		
		// creating middle pits
		PitPanel[] topPits = new PitPanel[6];
		
		for (int i = 0; i < 6; i++)
		{
			topPits[i] = new PitPanel(i, "top", l);
		}
		
		
		PitPanel[] botPits = new PitPanel[6];
		
		for (int i = 0; i < 6; i++)
		{
			botPits[i] = new PitPanel(i, "bot", l);
		}
		
		for (int i = 5; i >= 0; i--) // top is backwards so we can just count pits counterclockwise
		{
	          middlepits.add(topPits[i]);
		}
		
	    for (int i = 0; i < 6; i++)
	    {
	       middlepits.add(botPits[i]);   
	    }
	    
	    // creating manacala pits (the goals)
	    MancalaPanel left = new MancalaPanel("left", l);
	    MancalaPanel right = new MancalaPanel("right", l);
	    
	    left.setPreferredSize(new Dimension(150, 500));
	    right.setPreferredSize(new Dimension(150, 500));
	    middlepits.setPreferredSize(new Dimension(500, 500));
	    
	    
		//adding them to the frame
		setLayout(new BorderLayout());
		add(left, BorderLayout.WEST);
		add(right, BorderLayout.EAST);
		add(middlepits, BorderLayout.CENTER);
	}
	
	
	public void startGame(BoardLayout l, int marbles)
	{
		this.startingMarbles = marbles;
		setSize(800, 500);
		setTitle("Mancala");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setVisible(true);
	}

	public void stateChanged(ChangeEvent e) {
		
		
	}
}
