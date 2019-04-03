package mvc;

import java.awt.Graphics;
import java.util.Iterator;

import javax.swing.JPanel;

import model.DrawingModel;
import shapes.Shape;
import java.awt.Color;

public class DrawingView extends JPanel{
	
	private DrawingModel model;
	
	public DrawingView() {
		setBackground(Color.WHITE);
	}


	public DrawingModel getDrawingModel() {
		return model;
	}
	
	public void setModel(DrawingModel model) {
		this.model = model;

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (model != null) {
			Iterator<Shape> it = model.getAll().iterator();
			while (it.hasNext()) {
				it.next().draw(g);
			}
		}
		repaint();
	}
}
