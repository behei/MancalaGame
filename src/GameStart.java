import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameStart extends JFrame {
	
	private JComboBox marbles;
	private JComboBox layout;
	private JFrame frame;
	
	public GameStart() {
		frame = new JFrame("Mancala");
		frame.setSize(500, 300);
		frame.setLayout(new FlowLayout());
		marbles = new JComboBox();
		layout = new JComboBox();
		JButton submit = new JButton("Submit");
		JLabel message = new JLabel("Please select the number of marbles and the layout.");
		JPanel panel = new JPanel();

		marbles.addItem("3");
		marbles.addItem("4");
		layout.addItem("Regular");
		layout.addItem("Second");

		panel.add(layout);
		panel.add(marbles);

		submit.addActionListener(new afterSubmit());

		frame.add(message, BorderLayout.NORTH);
		frame.add(panel, BorderLayout.CENTER);
		frame.add(submit, BorderLayout.SOUTH);

		frame.setVisible(true);
	}
	
	class afterSubmit implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
			frame.setVisible(false); //hide frame
			
			
			RegularLayout r = new RegularLayout();
			SecondLayout s = new SecondLayout();
			
			
			if (layout.getSelectedObjects().toString().equals("Regular"))
			{
				Board game = new Board(r);
				if (marbles.getSelectedItem().toString().equals("3"))
				{
					game.startGame(r,3);
				}
				else
				{
					game.startGame(r, 4);
				}
			}
			else
			{
				Board game = new Board(s);
				if (layout.getSelectedItem().toString().equals("3"))
				{
					game.startGame(s, 3);
				}
				else
				{
					game.startGame(s, 4);
				}
			}

		}

	}
}
