package command;

import model.DrawingModel;
import shapes.Shape;

public class SendToBack implements Command {

	private DrawingModel model;

	public SendToBack(DrawingModel model) {
		this.model = model;
	}

	@Override
	public void execute() {

		int length = model.getAll().size();
		if (length > 1) {
			for (int i = length - 1; i >= 0; i--) {
				if (model.getAll().get(i).isSelected() && i != 0) {
					if (i - 1 >= 0) {
						Shape current = model.getAll().get(i);
						Shape next = model.getAll().get(i - 1);
						model.change(i, next);
						model.change(i - 1, current);
					    return;
					}
				}
			}
		}
	}

	@Override
	public void unexecute() {
		int length = model.getAll().size();
		if (length > 1) {
			for (int i = 0; i < length; i++) {
				if (model.getAll().get(i).isSelected()) {
					if (i + 1 < length) {
						Shape current = model.getAll().get(i);
						Shape next = model.getAll().get(i + 1);
						model.change(i, next);
						model.change(i + 1, current);

					}
				}
			}
		}
	}

}
