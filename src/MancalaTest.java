
import java.awt.Dimension;

/**
 * Mancala is an ancient board game for 2 players.
 * The Rules of The Game:
 * The board consists of two rows of pits, each.
 * Three pieces of stones are placed in each of the 12 holes.
 * Each player has a large store called Mancala to the right side of the board.
 * One player starts the game by picking up all of the stones in any one of his own pits.
 * Moving counter-clock wise, the player places one in each pit starting with the next pit until the stones run out.
 * If you run into your own Mancala, place one stone in it.
 * If there are more stones to go past your own Mancala, continue placing them into the opponent's pits.
 * However, skip your opponent's Mancala.
 * If the last stone you drop is your own Mancala, you get a free turn .
 * If the last stone you drop is in an empty pit on your side, you get to take that stone and all of your opponents stones
 * that are in the opposite pit. Place all captured stones in your own Mancala.
 *
 * The game ends when all six pits on one side of the Mancala board are empty.
 * The player who still has stones on his side of the board when the game ends captures all of those pieces and place
 * them in his Mancala. The player who has the most stones in his Mancala wins.
 *
 * the main class that instantiates the vew
 * and the controller of the Mancala game
 * it sets the dimension of the Mancala View
 *
 * @author Tyler
 * @author Misha
 * @author Jordan
 * @version 0.0.1
 * @since 05/06/2017
 *
 * TEAM #6 - SPARTANS
 */
public class MancalaTest {

    /**
     * The main method of the entire project that gives a beginning to everything
     * @param args
     */
	public static void main(String[] args) {
		MancalaView MV = new MancalaView();
		MV.setSize(new Dimension(1000, 500));
		MancalaController c = new MancalaController(3, MV);
		MV.setData(c);
	}
}