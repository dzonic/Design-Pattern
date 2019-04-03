package command;

import rectangle.Rectangle;

public class UpdateRectangle implements Command {

	private Rectangle oldState;
	private Rectangle originalState;
	private Rectangle newState;
	
	public UpdateRectangle (Rectangle oldState, Rectangle newState)
	{
		this.oldState=oldState;
		this.newState= newState;
	}
	@Override
	
	public void execute() {
		originalState=oldState.clone();
		
		oldState.getUpperLeft().setX(newState.getUpperLeft().getX());
		oldState.getUpperLeft().setY(newState.getUpperLeft().getY());
		oldState.setSideLength(newState.getSideLength());
		oldState.setWidth(newState.getWidth());
		oldState.setBorderColor(newState.getBorderColor());
		oldState.setClrInnerColor(newState.getClrInnerColor());
		
		
		oldState.setSelected(newState.isSelected());
		
	}

	@Override
	public void unexecute() {
		oldState.getUpperLeft().setX(originalState.getUpperLeft().getX());
		oldState.getUpperLeft().setY(originalState.getUpperLeft().getY());
		oldState.setSideLength(originalState.getSideLength());
		oldState.setWidth(originalState.getWidth());
		oldState.setBorderColor(originalState.getBorderColor());
		oldState.setClrInnerColor(originalState.getClrInnerColor());
		
		
		originalState.setSelected(originalState.isSelected());
	}

	
}
