
import java.awt.Dimension;
import java.util.ArrayList;

/**
 * the Mancala Controller class that makes moves and checks their validity
 * 
 * @author Jordan
 * @author Tyler
 * @author Misha
 * @version 0.0.1
 * @since 05/06/2017
 */
public class MancalaController {
	public int undo1;
	public int undo2;
	public MancalaModel data;
	public MancalaModel previousData;
	private MancalaView view;

	/**
	 * the constructor of Controller that sets the undos and data, also stores a
	 * previous data for undo
	 * 
	 * @param numOfMarbles
	 *            holds how many marbles the pit has, 3 or 4
	 * @param v
	 *            as a current Mancala View
	 */
	public MancalaController(int numOfMarbles, MancalaView v) {
		undo1 = 0;
		undo2 = 0;
		data = new MancalaModel(numOfMarbles);
		previousData = data;
		view = v;
	}

	/**
	 * method that create a new game after the game is started or 'New Game'
	 * button is clicked
	 * 
	 * @param marbles
	 *            holds how many marbles the pit
	 */
	public void newGame(int marbles) {
		view.dispose();
		view = new MancalaView();
		view.setSize(new Dimension(1000, 500));
		MancalaController c = new MancalaController(marbles, view);
		view.setData(c);

		data.numberOfMarbles = marbles;
		undo1 = 0;
		undo2 = 0;
		data = new MancalaModel(data.numberOfMarbles);
		previousData = data;
		data.isPlayer1 = true;
		view.display();
	}

	/**
	 * method that makes the move and renders the view accordingly
	 * 
	 * @param pit
	 *            , on which the move is done
	 * @return the status of the move
	 */
	public int makeMove(int pit) {
		previousData = data.copy();
		if (pit == data.HOME_1) {
			return 0;
		}
		if(pit == data.HOME_2) {
			return 0;
		}

		if (isValidMove(pit)) {
			return 1;
		}

		if (data.getMarble(pit) == 0) {
			return 2;
		}

		int endingIndex = data.move(pit);

		if (data.isPlayer1 && endingIndex == data.HOME_1) {
			data.isPlayer1 = true;
		} else if (!data.isPlayer1 && endingIndex == data.HOME_2) {
			data.isPlayer1 = false;
		} else {
			data.isPlayer1 = !data.isPlayer1;
		}
		view.display();
		return 3;
	}

	/**
	 * handles the undo logic
	 */
	public void undo() {
		if (undo1 < 3) {
			undo1++;
			data = previousData;
			view.display();
		}
		
		else if (undo2 < 3) {
			undo2++;
			data = previousData;
			view.display();
		}
		else {
			return;
		}
	}

	/**
	 * @return the undo of first player
	 */
	public int getUndo1() {
		return this.undo1;
	}

	/**
	 * @return the undo of second player
	 */
	public int getUndo2() {
		return this.undo2;
	}

	/**
	 * checks if the game came to the end
	 * 
	 * @return the status of the game
	 */
	public int checkWinState() {
		if (data.checkWinState() != 0) {
			int home1 = getMancala1();
			int home2 = getMancala2();
			if (home1 > home2) {
				return 1;
			}
			if (home2 > home1) {
				return 2;
			}
			else {
				return 3;
			}
		}
		return 0;
	}

	/**
	 * @return the arraylist of the marbles for the player 1
	 */
	public ArrayList<Integer> getPlayer1Marbles() {
		return data.getMarbles1();
	}

	/**
	 * @return the arraylist of the marbles for the player 2
	 */
	public ArrayList<Integer> getPlayer2Marble() {
		return data.getMarbles2();
	}

	/**
	 * @return the marble of player 1
	 */
	public int getMancala1() {
		return data.getMarble(data.HOME_1);
	}

	/**
	 * @return the marble of player 2
	 */
	public int getMancala2() {
		return data.getMarble(data.HOME_2);
	}

	/**
	 * check's if it is first user turn if not, second player's
	 * 
	 * @return true if it is a turn of first user
	 */
	public boolean checkTurnPlayer1() {
		if (!data.isPlayer1) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * checks if the move by player is valid
	 * 
	 * @param pitIndex
	 *            as the index of pit that user tries to make a move on
	 * @return true if is valid, false otherwise
	 */
	private boolean isValidMove(int pitIndex) {
		if (!data.isPlayer1 && pitIndex >= 0 && pitIndex <= 6 || data.isPlayer1 && pitIndex >= 7 && pitIndex <= 12) {
			return false;
		}
		else {
			return true;
		}
	}
}