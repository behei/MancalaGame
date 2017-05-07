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

	public void setMarbles(int numOfMarble) {
		for (int i = 0; i < SIZE; i++) {
			if (i == HOME_1 || i == HOME_2) {
				board.add(0);
			} else {
				board.add(numOfMarble);
			}
		}
	}

	public int move(int index) {
		int marbles = board.get(index);
		if(marbles > 0) {
			board.set(index, 0);
			index++;
			while(marbles != 0) {
				if(isPlayer1 && index == HOME_1) {
					board.set(index, board.get(index)+1);
					marbles--;
				}
				else if(!isPlayer1 && index == HOME_2) {
					board.set(index, board.get(index)+1);
					marbles--;
				}
				else {
					board.set(index,board.get(index)+1);
					marbles--;
				}
				index++;
			}
			return index - 1;
		}
		else return -1;
	}

	public int getMarble(int index) {
		return board.get(index);
	}

	public void removeAllMarbles(int index) {
		board.set(index, 0);
	}

	public ArrayList<Integer> getMarbles2() {
		ArrayList<Integer> two = new ArrayList<Integer>();
		for (int i = 5; i >= 0; i--) {
			two.add(board.get(i));
		}
		return two;
	}

	public ArrayList<Integer> getMarbles1() {
		ArrayList<Integer> one = new ArrayList<Integer>();
		for (int i = 7; i < 13; i++) {
			one.add(board.get(i));
		}
		return one;
	}

	public int checkWinState() {
		return 0;
	}

	public void addMarblesToMancala(int marble) {

	}
}