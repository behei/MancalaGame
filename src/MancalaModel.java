import java.util.ArrayList;
import java.util.Collections;

public class MancalaModel {

	public ArrayList<Integer> board;
	public int SIZE = 14;
	public int HOME_1 = 13;
	public int HOME_2 = 6;
	public int numberOfMarbles;
	public boolean isPlayer1;

	public MancalaModel(int num) {
		board = new ArrayList<Integer>(SIZE);
		setMarbles(num);
		isPlayer1 = true;
		numberOfMarbles = num;
	}

	public MancalaModel() {
		board = new ArrayList<Integer>(14);
	}

	public MancalaModel copy() {
		MancalaModel tmp = new MancalaModel(numberOfMarbles);
		tmp.isPlayer1 = this.isPlayer1;
		Collections.copy(tmp.board, board);
		return tmp;
	}

	public void setMarbles(int marbles) {
		for (int i = 0; i < SIZE; i++) {
			if (i == HOME_1 || i == HOME_2) {
				board.add(0);
			} else {
				board.add(marbles);
			}
		}
	}

	public int move(int index) {
		int marbles = board.get(index);
		if (marbles > 0) {
			board.set(index, 0);
			index++;
			for (marbles = board.get(index); marbles != 0; marbles--) {
				if (isPlayer1 && index == HOME_1) {
					board.set(index, board.get(index) + 1);
					marbles--;
				} else if (!isPlayer1 && index == HOME_2) {
					board.set(index, board.get(index) + 1);
				} else {
					board.set(index, board.get(index) + 1);
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

	public int getMarble(int index) {
		return board.get(index);
	}

	public void removeAllMarbles(int index) {
		board.set(index, 0);
	}

	public ArrayList<Integer> getMarbles2() {
		ArrayList<Integer> two = new ArrayList<Integer>();
		int i = 5;
		while (i >= 0) {
			two.add(board.get(i));
			i--;
		}
		return two;
	}

	public ArrayList<Integer> getMarbles1() {
		ArrayList<Integer> one = new ArrayList<Integer>();
		int i = 7;
		while  (i < 13) {
			one.add(board.get(i));
			i++;
		}
		return one;
	}

	public int checkWinState() {
		return 0;
	}

	public void addMarblesToMancala(int marble) {

	}
}