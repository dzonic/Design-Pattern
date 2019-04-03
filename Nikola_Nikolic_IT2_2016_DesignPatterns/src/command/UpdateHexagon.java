package command;

import hexagon.HexagonAdapter;
import line.Line;

public class UpdateHexagon implements Command {

	private HexagonAdapter oldState;
	private HexagonAdapter newState;
	private HexagonAdapter originalState;
	
	public UpdateHexagon(HexagonAdapter oldState,HexagonAdapter newState) {
		
		this.newState = newState;
		this.oldState = oldState;
	}

	
	
	@Override
	public void execute() {
		
		originalState = oldState.clone();
		oldState.getHexagon().setX(newState.getHexagon().getX());
		oldState.getHexagon().setY(newState.getHexagon().getY());
		oldState.getHexagon().setR(newState.getHexagon().getR());
		
		oldState.setBorderColor(newState.getBorderColor());
		oldState.setClrInnerColor(newState.getClrInnerColor());
		
		
		oldState.setSelected(newState.isSelected());
	}

	@Override
	public void unexecute() {
		oldState.getHexagon().setX(originalState.getHexagon().getX());
		oldState.getHexagon().setY(originalState.getHexagon().getY());
		oldState.getHexagon().setR(originalState.getHexagon().getR());
		
		oldState.setBorderColor(originalState.getBorderColor());
		oldState.setClrInnerColor(originalState.getClrInnerColor());
		
		
		oldState.setSelected(originalState.isSelected());
		
	}

}
