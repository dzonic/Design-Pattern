package command;

import circle.Circle;
import line.Line;

public class UpdateCircle implements Command {

	
	private Circle oldState;
	private Circle newState;
	private Circle originalState;
	
	public UpdateCircle(Circle oldState,Circle newState) {

		this.newState = newState;
		this.oldState=oldState;
	}


	
	@Override
	public void execute() {
		
		originalState = oldState.clone();
		oldState.getCenter().setX(newState.getCenter().getX());
		oldState.getCenter().setY(newState.getCenter().getY());
		oldState.setR(newState.getR());
		
		oldState.setBorderColor(newState.getBorderColor());
		oldState.setClrInnerColor(newState.getClrInnerColor());
		
		
		oldState.setSelected(newState.isSelected());
		
	}

	@Override
	public void unexecute() {
		oldState.getCenter().setX(originalState.getCenter().getX());
		oldState.getCenter().setY(originalState.getCenter().getY());
		oldState.setR(originalState.getR());
		
		oldState.setBorderColor(originalState.getBorderColor());
		oldState.setClrInnerColor(originalState.getClrInnerColor());
		
		
		oldState.setSelected(originalState.isSelected());
		
		
	}

}
