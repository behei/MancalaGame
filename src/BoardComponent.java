import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.swing.JComponent;
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
public class BoardComponent extends JComponent {
	private BoardLayout layout;
	private Mancala game;
	
	public BoardComponent(BoardLayout layout, Mancala game) {
		this.layout = layout;
		this.game = game;
	}
	
//	public void paintComponent(Graphics g) {
//		layout.display(g, this, game);
//	}
	
	public BoardLayout getTheLayout() {
		return layout;
	}
}
