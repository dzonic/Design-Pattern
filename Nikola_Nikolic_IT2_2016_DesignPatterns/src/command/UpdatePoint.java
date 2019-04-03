package command;

import point.Point;

public class UpdatePoint implements Command {

	private Point oldState;
	private Point newState;
	private Point originalState;
	
	public UpdatePoint(Point oldState,Point newState)
	{
		this.oldState=oldState;
		this.newState=newState;
	}
	
	@Override
	public void execute() {
		originalState = oldState.clone();
		oldState.setX(newState.getX());
		oldState.setY(newState.getY());
		oldState.setBorderColor(newState.getBorderColor());
		
		oldState.setSelected(true);
	}

	@Override
	public void unexecute() {
		oldState.setX(originalState.getX());
		oldState.setY(originalState.getY());
		oldState.setBorderColor(originalState.getBorderColor());
		
		oldState.setSelected(originalState.isSelected());
	}
}
