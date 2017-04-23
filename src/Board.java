import java.awt.BorderLayout;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;


import javax.swing.JFrame;

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
	
	private Pit p;
	private ArrayList<Ellipse2D> list = new ArrayList<Ellipse2D>();

	//Board takes the layout
	public Board(BoardLayout l) {

		JTextField field = new JTextField();
		Ellipse el = new Ellipse(20,20);

	
		add(field, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void placeMarbles(int marbles)
	{
		//put marbles in pits
	}

	public void stateChanged(ChangeEvent e) {
		
		
	}
}
