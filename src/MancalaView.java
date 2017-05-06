import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MancalaView extends JFrame
{
    
    private MancalaController controller;
    private final JPanel board;
    private final JLabel displayMessage = new JLabel();
    private final JButton undo;
    private final ButtonGroup buttonGroup;
    private final JRadioButton three;
    private final JRadioButton four;
    private MancalaLayout userInt = new SecondLayout();
    private final JButton newGame;
    
    
    public MancalaView() 
    {
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
            public void actionPerformed(ActionEvent e) 
            {
            	
                if (three.isSelected())
                {
                	controller.newGame(3);
                } 
                else 
                {
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

    
    public void display() {
    	
        board.removeAll(); //this is not removing the previous board, when you click a layout multiple times it does not go away
        board.revalidate();
        board.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        
        for (int i = 0; i < 14; i++) 
        {
            Pit pit;
            if (i == 0) {
                c.gridheight = 2;
                pit = new Pit(100,200 , controller.getMancala2());
                pit.setMinimumSize(new Dimension(200, 200));
                pit.setName("6");
            } else if(i == 13) {
                c.gridheight = 2;
                c.gridx = 7;
                c.gridy = 0;
                pit = new Pit(100, 200, controller.getMancala1());
                pit.setMinimumSize(new Dimension(200, 200));
                pit.setName("13");
            } else if (i > 6) {
                c.gridheight = 1;
                c.gridx = i - 6;
                c.gridy = 1 ;  
                pit = new Pit(100,100, controller.getPlayer1Marbles().get(i-7));
                pit.setMinimumSize(new Dimension(100,100));
                pit.setName(i + "");
            } else {
                c.gridheight = 1;
                c.gridx = i;
                c.gridy = 0;
                pit = new Pit(100, 100,  controller.getPlayer2Marble().get(i-1));
                pit.setMinimumSize(new Dimension(100,100));
                pit.setName((6-i) + "");
            }
            
            pit.addMouseListener(new MouseAdapter() { //here is the mouse listener, so we should check if move isValid
            										  //if true then move the pit that is selected
            										  //else we should check makeMove which see's which invalid move is made
                public void mouseClicked(MouseEvent e) 
                {
                	if (controller.checkWinState() == 4) 
                	{
                        
                        int state = controller.makeMove(Integer.parseInt(pit.getName()));
                        if(state == 0)	
                        {
                            String temp = displayMessage.getText();
                            displayMessage.setText(temp.split(": ")[0] + ": Invalid move! The macalas are not clickable");
                        }
                        else if(state == 1)	
                        {
                            String temp = displayMessage.getText();
                            displayMessage.setText(temp.split(": ")[0] + ": Invalid move! You can click on opponent's board");
                        }
                        else if(state == 2)	
                        {
                            String temp = displayMessage.getText();
                            displayMessage.setText(temp.split(":")[0] + ": Invalid move! The pit is empty");
                        }
                        
                        
                        undo.setEnabled(true);
                    }
                }      
            });
            
            pit.setLayout(userInt);
            board.add(pit, c);   
        }
    }

    void setData(MancalaController c) {
        this.controller = c;
        display();
    }
    
}