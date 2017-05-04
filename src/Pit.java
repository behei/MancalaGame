public class Pit 
{
	private int stones;

	public Pit(int startingStones) 
	{
		stones = startingStones;
	}

	public void add() 
	{
		stones++;
	}

	public void setStones(int stones) 
	{
		this.stones = stones;
	}


	public int getAmount() {
		return stones;
	}
}