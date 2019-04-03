package command;

import model.DrawingModel;
import shapes.Shape;

public class AddShape implements Command{

	private DrawingModel model;
    private Shape shape;
    
	public AddShape(DrawingModel model, Shape shape) {
		this.model = model;
		this.shape = shape;
	}
	
	@Override
	public void execute() {
		model.add(shape);
		
	}

	@Override
	public void unexecute() {
		model.remove(shape);
		
	}

	
}
