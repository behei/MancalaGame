import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MancalaGame 
{
	//private static Pit pits[] = new Pit[14];

	static JComboBox marbles;
	static JComboBox layout;
	static JFrame frame;
	//static JPanel panel;

	public static void main(String[] args) {
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

	
	//hide first frame and this is where the board is made
	static class afterSubmit implements ActionListener {

		public void actionPerformed(ActionEvent e) 
		{
			frame.setVisible(false); //hide frame
			
			if (marbles.getSelectedObjects().toString().equals("3"))
			{
				//3 marbles
				if (layout.getSelectedItem().toString().equals("Regualar"))
				{
					//boardlayout = regularlayout
				}
				else
				{
					//boardlayout = secondlayout
				}
			}
			else
			{
				//4 marbles
				if (layout.getSelectedItem().toString().equals("Regualar"))
				{
					//boardlayout = regularlayout
				}
				else
				{
					//boardlayout = secondlayout
				}
			}

		}

	}

	public void paint(Graphics g) {
		g.fillRect(100, 100, 400, 400);

	}
}
