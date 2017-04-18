import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JButton;

import javafx.scene.shape.Ellipse;

public class Pit extends JButton implements ActionListener
{
	
	int num = 0;
	public Pit()
	{
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent arg0) 
	{
		Ellipse cir = new Ellipse();
		if (num == 0)
		{
			cir.resize(20, 60);
		}
		else
		{
			cir.resize(20, 20);
		}
		num++;
	}
}
