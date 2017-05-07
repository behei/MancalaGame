import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * The Mancala View class that handles the GUI logic
 * @author Jordan
 * @author Tyler
 * @author Misha
 * @version 0.0.1
 * @since 05/06/2017
 */
public class MancalaView extends JFrame {

    private MancalaController controller;
    private final JPanel board;
    private final JLabel displayMessage = new JLabel();
    private final JButton undo;
    private final ButtonGroup buttonGroup;
    private final JRadioButton three;
    private final JRadioButton four;
    private MancalaLayout userInt = new RegularLayout();
    private final JButton newGame;

    /**
     * the constructs that creates an initial screen
     * and adds all the GUI parts on it
     */
    public MancalaView() {
        setLayout(new BorderLayout());
        board = new JPanel();

        add(board, BorderLayout.CENTER);
        displayMessage.setText("Player 1");
        add(displayMessage, BorderLayout.SOUTH);

        JPanel buttons = new JPanel();
        JPanel temp = new JPanel(new BorderLayout());

        undo = new JButton("Undo");
        undo.setBackground(Color.LIGHT_GRAY);
        undo.setEnabled(false);
        undo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.undo();
                undo.setEnabled(false);

            }
        });
        temp.add(undo, BorderLayout.EAST);


        newGame = new JButton("New Game");
        newGame.setForeground(Color.BLACK);

        newGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (three.isSelected()) {
                    controller.newGame(3);
                } else {
                    controller.newGame(4);
                }
                undo.setEnabled(false);
            }
        });

        JLabel numOfMarbles = new JLabel("Number of marbles: ");
        buttonGroup = new ButtonGroup();
        three = new JRadioButton("3");
        three.setSelected(true);
        four = new JRadioButton("4");
        buttonGroup.add(three);
        buttonGroup.add(four);
        buttons.add(numOfMarbles);
        buttons.add(three);
        buttons.add(four);


        JButton second = new JButton("Second Layout");
        second.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                userInt = new SecondLayout();
                display(); //when a button is clicked multiple times the layouts overlap
            }
        });

        buttons.add(second);
        JButton regular = new JButton("Regular Layout");
        regular.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                userInt = new RegularLayout();
                display(); //when a button is clicked multiple times the layouts overlap
            }
        });
        buttons.add(regular);
        buttons.add(newGame);
        temp.add(buttons, BorderLayout.CENTER);
        add(temp, BorderLayout.NORTH);


        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    /**
     * the method that is used to render the pits
     * and also holds all the listener that are used
     * in a game logic
     */
    public void display() {

        board.removeAll(); //this is not removing the previous board, when you click a layout multiple times it does not go away
        board.revalidate();
        board.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        int i = 0;
        while (i < 14) 
        {
            Pit pit;
            if (i == 0) {
                c.gridheight = 2;
                pit = new Pit(100, 200, controller.getMancala2());
                pit.setMinimumSize(new Dimension(200, 200));
                pit.setName("6");
            } else if (i == 13) {
                c.gridheight = 2;
                c.gridx = 7;
                c.gridy = 0;
                pit = new Pit(100, 200, controller.getMancala1());
                pit.setMinimumSize(new Dimension(200, 200));
                pit.setName("13");
            } else if (i > 6) {
                c.gridheight = 1;
                c.gridx = i - 6;
                c.gridy = 1;
                pit = new Pit(100, 100, controller.getPlayer1Marbles().get(i - 7));
                pit.setMinimumSize(new Dimension(100, 100));
                pit.setName(i + "");
            } else {
                c.gridheight = 1;
                c.gridx = i;
                c.gridy = 0;
                pit = new Pit(100, 100, controller.getPlayer2Marble().get(i - 1));
                pit.setMinimumSize(new Dimension(100, 100));
                pit.setName((7 - i) + "");
                //System.out.println(pit.getName());
            }
            i++;

            pit.addMouseListener(new MouseAdapter() {
                /**
                 * a mouse listener that checks the move of the player, if it is valid or no
                 * @param e as a mouse event
                 */
                public void mouseClicked(MouseEvent e) {
                    if (controller.checkWinState() == 0) {

                        int state = controller.makeMove(parsePit(pit));
                        
                        if (state == 1) {
                            displayMessage.setText("Invalid move! You can click on opponent's board");
                        } 
                        else if (state == 0) {
                            displayMessage.setText("Invalid move! The mancalas are not clickable");
                        } 
                        else if (state == 2) {
                            displayMessage.setText("Invalid move! The pit is empty");
                        }

                        undo.setEnabled(true);
                    }
                }
            });

            pit.setLayout(userInt);
            board.add(pit, c);
        }
        if (controller.checkTurnPlayer1()) {
        	displayMessage.setText("Player 1");
        }
        else {
        	displayMessage.setText("Player 2");
        }
        if (controller.checkWinState() == 3) {
            JOptionPane.showMessageDialog(board, "Draw");
        }
        else if (controller.checkWinState() == 2) {
            JOptionPane.showMessageDialog(board, "Player 2 wins");
        } 
        else if (controller.checkWinState() == 1) {
            
            JOptionPane.showMessageDialog(board, "Player 1 wins");
        } 
        

        board.repaint();
    }

    /**
     * sets the data from the mancala controller
     * @param c as a current mancala controller
     */
    void setData(MancalaController c) {
        this.controller = c;
        display();
    }

    /**
     * method that converts a name of a pit from string to int
     * @param pit as a pit whose name to convert
     * @return an integer value of a pit name
     */
    private int parsePit(Pit pit) {
    	return Integer.parseInt(pit.getName());
    }
}