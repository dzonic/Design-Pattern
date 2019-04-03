package command;

import line.Line;
import point.Point;

public class UpdateLine implements Command{

	private Line oldState;
	private Line newState;
	private Line originalState;
	
	public UpdateLine(Line oldState,Line newState)
	{
		this.oldState=oldState;
		this.newState=newState;
	}
	@Override
	public void execute() {
		
		originalState = oldState.clone();
		oldState.getpStart().setX(newState.getpStart().getX());
		oldState.getpStart().setY(newState.getpStart().getY());
		oldState.getpEnd().setX(newState.getpEnd().getX());
		oldState.getpEnd().setY(newState.getpEnd().getY());
		oldState.setBorderColor(newState.getBorderColor());
		
		oldState.setSelected(newState.isSelected());
		
	}

	@Override
	public void unexecute() {
		
		oldState.getpStart().setX(originalState.getpStart().getX());
		oldState.getpStart().setY(originalState.getpStart().getY());
		oldState.getpEnd().setX(originalState.getpEnd().getX());
		oldState.getpEnd().setY(originalState.getpEnd().getY());
		oldState.setBorderColor(originalState.getBorderColor());
		
		oldState.setSelected(originalState.isSelected());
		
	}

}
