import java.util.ArrayList;
import java.util.Collections;

/**
 * a Mancala model class that sets the marbles
 * and initiates the move
 * @author Tyler
 * @author Jordan
 * @author Misha
 * @version 0.0.1
 * @since 05/06/2017
 */
public class MancalaModel {

	public ArrayList<Integer> board;
	public int SIZE = 14;
	public int HOME_1 = 13;
	public int HOME_2 = 6;
	public int numberOfMarbles;
	public boolean isPlayer1;

    /**
     * constructor that sets the board
     * and sets the current player to player
     * with a corresponding chosen number of marbles
     * @param num as how many marbles will be used
     */
	public MancalaModel(int num) {
		board = new ArrayList<Integer>(SIZE);
		setMarbles(num);
		isPlayer1 = true;
		numberOfMarbles = num;
	}

    /**
     * a constructor that assigns a board as an arraylist of integer
     * with 14 pits
     */
	public MancalaModel() {
		board = new ArrayList<Integer>(14);
	}

    /**
     * creates a copy of current's board state
     * @return the copy of the model
     */
	public MancalaModel copy() {
		MancalaModel tmp = new MancalaModel(numberOfMarbles);
		tmp.isPlayer1 = this.isPlayer1;
		Collections.copy(tmp.board, board);
		return tmp;
	}

    /**
     * adds the marbles to the board ArrayList
     * @param marbles that will be put in a board
     */
	public void setMarbles(int marbles) {
		int i = 0;
		while (i < SIZE) {
			if (i == HOME_1 || i == HOME_2) {
				board.add(0);
				i++;
			} else {
				board.add(marbles);
				i++;
			}
		}
	}

    /**
     * handles the move logic
     * @param index as on which pit the move will be made
     * @return the index of the ending pit
     */
	public int move(int index) {
		int marbles = board.get(index);
		if (marbles > 0) {
			board.set(index, 0);
			index++;
			for (marbles = marbles; marbles > 0; marbles--) {
				if (isPlayer1 && index == HOME_1) {
					board.set(index, board.get(index)+1);
					
				} else if (!isPlayer1 && index == HOME_2) {
					board.set(index, board.get(index)+1);
				} else {
					board.set(index, board.get(index)+1);
				}

				if (index == 13) {
					if (marbles == 0 && isPlayer1) {
						return 13;
					}
					index = -1;
				}
				index++;
			}
			return index - 1;
		} 
		else
			return -1;
	}

    /**
     * returns the marble from the board
     * @param index as the marble from the board
     * @return the marble
     */
	public int getMarble(int index) {
		return board.get(index);
	}

    /**
     * deletes all marbles in a pit
     * @param index in which pit to delete
     */
	public void removeAllMarbles(int index) {
		board.set(index, 0);
	}

    /**
     * @return the marbles of user 2
     */
	public ArrayList<Integer> getMarbles2() {
		ArrayList<Integer> two = new ArrayList<Integer>();
		int i = 5;
		while (i >= 0) {
			two.add(board.get(i));
			i--;
		}
		return two;
	}

    /**
     * @return the marbles of user 1
     */
	public ArrayList<Integer> getMarbles1() {
		ArrayList<Integer> one = new ArrayList<Integer>();
		int i = 7;
		while  (i < 13) {
			one.add(board.get(i));
			i++;
		}
		return one;
	}

    /**
     * @return the win state
     */
	public int checkWinState() {
		return 0;
	}
    /*
	public void addMarblesToMancala(int marble) {

	}
	*/
}