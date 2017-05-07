
import java.awt.Dimension;
import java.util.ArrayList;

public class MancalaController {
	public int undo1;
	public int undo2;
	public MancalaModel data;
	public MancalaModel previousData;
	private MancalaView view;

	public MancalaController(int numOfMarbles, MancalaView v) {
		undo1 = 0;
		undo2 = 0;
		data = new MancalaModel(numOfMarbles);
		previousData = data;
		view = v;
	}

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

	public int makeMove(int pit) 
	{
		previousData = data.copy();
		if(pit == data.HOME_1 || pit == data.HOME_2) {
			return 0;
		}
		
		if(isValidMove(pit)) {
			return 1;
		}
		
		if(data.getMarble(pit) == 0) {
			return 2;
		}
		
		int endingIndex = data.move(pit);
		
		
		if(data.isPlayer1 && endingIndex == data.HOME_1)
		{
			data.isPlayer1 = true;
		} else if(!data.isPlayer1 && endingIndex == data.HOME_2)
		{
			data.isPlayer1 = false;
		} else {
			data.isPlayer1 = !data.isPlayer1;
		}
                view.display();
        return 3;
	}
	

	public void undo() {
		if (undo1 < 3) {
			undo1++;
			data = previousData;
			view.display();
		} 
		if (undo2 < 3) {
			undo2++;
			data = previousData;
			view.display();
		}
		if (undo1 >= 3) {
			System.out.println("Undo more than 3"); //testing purpose
		}
		if (undo2 >= 3) {
			System.out.println("Undo more than 3"); //testing purpose
		}
	}
	public int getUndo1() {
		return this.undo1;
	}
	public int getUndo2() {
		return this.undo2;
	}
	public int checkWinState() {
		if(data.checkWinState() != 0)
		{
			int home1 = getMancala1(); 
			int home2 = getMancala2(); 
			if(home1 > home2)
				return 1;
			else if(home2 > home1)
				return 2;
			else 
				return 3;
		}
		return 4;
	}

	public ArrayList<Integer> getPlayer1Marbles() {
		return data.getMarbles1();
	}

	public ArrayList<Integer> getPlayer2Marble() {
		return data.getMarbles2();
	}

	public int getMancala1() {
		return data.getMarble(data.HOME_1);
	}

	public int getMancala2() {
		return data.getMarble(data.HOME_2);
	}

	public boolean checkTurnPlayer1() {
		if (data.isPlayer1) {
			return true;
		} else {
			return false;
		}
	}

	private boolean isValidMove(int pitIndex) {
		if (data.isPlayer1 && pitIndex >= 0 && pitIndex <= 6)
			return true;
		if (!data.isPlayer1 && pitIndex >= 7 && pitIndex <= 12)
			return true;

		return false;
	}
}