package command;

import model.DrawingModel;
import shapes.Shape;

public class BringToFront implements Command {

	private DrawingModel model;
	private Shape shape;
	private int indexOfShape;

	public BringToFront(DrawingModel model, Shape shape, int indexOfShape) {
		super();
		this.model = model;
		this.shape = shape;
		this.indexOfShape = indexOfShape;
	}

	@Override
	public void execute() {
		for (int j = indexOfShape + 1; j < model.getAll().size(); j++) {
			Shape start = model.getAll().get(j);
			model.change(j - 1, start);
		}
		model.change(model.getAll().size() - 1, shape);
	}

	@Override
	public void unexecute() {

		int size = model.getAll().size() - 1;
		Shape current = model.getAll().get(size);
		for (int j = size - 1; j >= 0; j--) {
			if (j == indexOfShape) {
				Shape next = model.getAll().get(j);
				model.change(j + 1, next);
				model.change(indexOfShape, current);
				return;
			} else {
				Shape next = model.getAll().get(j);
				model.change(j + 1, next);
			}
		}
	}

}
