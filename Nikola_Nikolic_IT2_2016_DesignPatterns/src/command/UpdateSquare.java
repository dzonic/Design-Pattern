package command;

import square.Square;

public  class UpdateSquare implements Command {
	
	private Square oldState;
	private Square originalState;
	private Square newState;

	public UpdateSquare(Square oldState, Square newState) {
		this.oldState = oldState;
		this.newState = newState;
	}
	@Override
	public void execute() {
		
		originalState=oldState.clone();
		oldState.getUpperLeft().setX(newState.getUpperLeft().getX());
		oldState.getUpperLeft().setY(newState.getUpperLeft().getY());
		oldState.setSideLength(newState.getSideLength());
		
		oldState.setBorderColor(newState.getBorderColor());
		oldState.setClrInnerColor(newState.getClrInnerColor());
		
		
		oldState.setSelected(newState.isSelected());
		
		
	}

	@Override
	public void unexecute() {
		oldState.getUpperLeft().setX(originalState.getUpperLeft().getX());
		oldState.getUpperLeft().setY(originalState.getUpperLeft().getY());
		oldState.setSideLength(originalState.getSideLength());
		
		oldState.setBorderColor(originalState.getBorderColor());
		oldState.setClrInnerColor(originalState.getClrInnerColor());
		
		
		oldState.setSelected(originalState.isSelected());
		
	}

	

}
