package command;

import model.DrawingModel;
import shapes.Shape;

public class SelectShape implements Command {

	private DrawingModel model;
	private Shape shape;
	
	public SelectShape(DrawingModel model, Shape shape) {
		this.model = model;
		this.shape = shape;
	}
	
	@Override
	public void execute() {
		model.select(shape);
	}

	@Override
	public void unexecute() {
		model.deselect(shape);
		
	}

}
