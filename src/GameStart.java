import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class GameStart extends JFrame {
	private int numberOfMarbles;
	private BoardLayout layout;
	private JComboBox marbles;
	private JComboBox selectLayout;
	private JFrame frame;

	public GameStart() {
		frame = new JFrame("Mancala");
		frame.setSize(500, 300);
		frame.setLayout(new FlowLayout());

		marbles = new JComboBox();
		selectLayout = new JComboBox();

		JButton submit = new JButton("Submit");
		JLabel message = new JLabel("Please select number of marbles and a layout");
		JPanel panel = new JPanel();

		marbles.addItem("3");
		marbles.addItem("4");
		selectLayout.addItem("Regular");
		selectLayout.addItem("Second");

		panel.add(marbles);
		panel.add(selectLayout);

		submit.addActionListener(new afterSubmit());

		frame.add(message, BorderLayout.NORTH);
		frame.add(panel, BorderLayout.CENTER);
		frame.add(submit, BorderLayout.SOUTH);

		frame.setVisible(true);
	}

	class afterSubmit implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false); // hide frame

			RegularLayout r = new RegularLayout();
			SecondLayout s = new SecondLayout();

			if (selectLayout.getSelectedObjects().toString().equals("Regular")) {
				BoardComponent game = new BoardComponent(r, new Mancala());
				if (marbles.getSelectedItem().toString().equals("3")) {
					// game.startGame(r,3);
				} else {
					// game.startGame(r, 4);
				}
			} else {
				BoardComponent game = new BoardComponent(s, new Mancala());
				if (selectLayout.getSelectedItem().toString().equals("3")) {
					// game.startGame(s, 3);
				} else {
					// game.startGame(s, 4);
				}
			}

		}
	}
}
