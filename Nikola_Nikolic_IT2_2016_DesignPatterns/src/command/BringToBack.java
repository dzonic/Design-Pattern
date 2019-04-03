package command;

import model.DrawingModel;
import shapes.Shape;

public class BringToBack implements Command {

	private DrawingModel model;
	private int indexOfShape;
	private Shape shape;

	
	public BringToBack(DrawingModel model,  Shape shape, int indexOfShape) {
		this.model = model;
		this.shape = shape;
		this.indexOfShape = indexOfShape;
	}

	@Override
	public void execute() {

		for (int j = indexOfShape - 1; j >= 0; j--) {
			Shape start = model.getAll().get(j);
			model.change(j + 1, start);
		}
		model.change(0, shape);
	}

	@Override
	public void unexecute() {
		Shape current = model.getAll().get(0);
		for (int j = 1; j < model.getAll().size(); j++) {
			if (j == indexOfShape) {
				Shape next = model.getAll().get(j);
				model.change(j - 1, next);
				model.change(indexOfShape, current);
				return;
			} else {
				Shape next = model.getAll().get(j);
				model.change(j - 1, next);
			}
		}

	}

}

