import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import javafx.scene.shape.Ellipse;

/*
 * This class will be the class with the listeners for the pits 
 */
public class Pit 
{
	ArrayList<ChangeListener> listeners;
	private ArrayList<Ellipse> list;

	
	public Pit(ArrayList<Ellipse> list) {
		this.list = list;
		listeners = new ArrayList<ChangeListener>();
	}

	
	public void attach(ChangeListener l) {
		listeners.add(l);
	}

	
	public ArrayList<Ellipse> getList() {
		return list;
	}

	
	public void add(Ellipse e) {
		list.add(e);
		for (ChangeListener a : listeners) {
			a.stateChanged(new ChangeEvent(this));
		}
	}
}
