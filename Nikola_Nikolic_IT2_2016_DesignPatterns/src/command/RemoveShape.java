package command;

import model.DrawingModel;
import shapes.Shape;

public class RemoveShape implements Command {

	private DrawingModel model;
    private Shape shape;
    
	public RemoveShape(DrawingModel model, Shape shape) {
		this.model = model;
		this.shape = shape;
	}
	
	@Override
	public void execute() {
		model.remove(shape);
		
	}

	@Override
	public void unexecute() {
		model.add(shape);
		
	}
}
