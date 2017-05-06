

import java.util.ArrayList;


public class MancalaController
{
	public int undo1; 
	public int undo2; 
	public MancalaModel data; 
	public MancalaModel prevoiusData;
	private MancalaView view;
	
	
	public int getundo1()
	{
		return undo1;
	}
	
	
	public int getundo2()
	{
		return undo2;
	}
	
	
	public MancalaController(int numOfMarbles, MancalaView v)
	{
		undo1 = 0;
		undo2 = 0; 
		data = new MancalaModel(numOfMarbles);
		prevoiusData = data;
        view = v;
	}
	
	
	public void newGame(int marbles)
	{
        data.numberOfMarbles = marbles;
		undo1 = 0;
		undo2 = 0;
		data = new MancalaModel(data.numberOfMarbles);
		prevoiusData = data;
		data.isPlayer1 = true;
        view.display();
	}
	
	
	public int makeMove(int index)
	{
		return 0;
	}
	
	public void undo()
	{
		
	}
	
	
	public int checkWinState()
	{
		return 0;
	}
	
	
	public ArrayList<Integer> getPlayer1Marbles() 
	{
		return data.getMarbles1();
	}
	
	
	public ArrayList<Integer> getPlayer2Marble() 
	{
		return data.getMarbles2();
	}
	
	
	public int getMancala1()
	{
		return data.getMarble(data.HOME_1);
	}
	
	
	public int getMancala2()
	{
		return data.getMarble(data.HOME_2);
	}
	
	
	public boolean checkTurnPlayer1() {
		if(data.isPlayer1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	private boolean isValidMove(int pitIndex)
	{
		if(data.isPlayer1 && pitIndex >=0 && pitIndex <=6 )
			return true;
		if(!data.isPlayer1 && pitIndex >=7 && pitIndex <=12 )
			return true;
		
		return false;
	}
	
	
	private void wasPitEmpty(int endingIndex) {
		
	}
	
}