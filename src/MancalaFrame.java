import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.event.*;



public class MancalaFrame extends JFrame implements ChangeListener {
	
	private BoardComponent board;
	private Mancala game;
	
	public MancalaFrame(BoardComponent board, Mancala game) {
		this.board = board;
		this.game = game;
//		board.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				// TODO Auto-generated method stub
//				double x = e.getX();
//				double y = e.getY();
//				Rectangle2D.Double[][] pits = b.mancalaLayout().getPits();
//				int player = game.whoGoing();
//				for(int i = 0; i < pits[player].length; i++){
//					if(pits[player][i].contains(x, y))
//						game.select(i);
//				}
//			}
//		});
		
		add(board);
		setSize(900,900);
		setTitle("Mancala Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
	}
	

	
	
	
	
	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		
	}
}
