package observer;
import model.DrawingModel;
import mvc.DrawingFrame;

public class ButtonObserver implements Observer{

	DrawingFrame frame = new DrawingFrame();
	
	public ButtonObserver(DrawingFrame frame) {
		this.frame = frame;
	}

	@Override
	public void ObserveButtons(int number,int size,int lastSelected) {
		
		if(size==0) {
			frame.getBtnSave().setEnabled(false);
		}
		else if(size>0) {
			frame.getBtnSave().setEnabled(true);
		}

		if(number==0) {
			frame.getBtnModify().setEnabled(false);
			frame.getBtnDelete().setEnabled(false);
			frame.getBtnBringToBack().setEnabled(false);
			frame.getBtnBringToFront().setEnabled(false);
			frame.getBtnSendToFront().setEnabled(false);
			frame.getBtnSendToBack().setEnabled(false);
		}
		else if(number==1 ) {
			frame.getBtnModify().setEnabled(true);
			frame.getBtnDelete().setEnabled(true);
			if(size==1 ) {
				frame.getBtnBringToBack().setEnabled(false);
				frame.getBtnSendToBack().setEnabled(false);
				frame.getBtnBringToFront().setEnabled(false);
				frame.getBtnSendToFront().setEnabled(false);
			}
			else if(size>1 && lastSelected==2) {
				frame.getBtnBringToBack().setEnabled(true);
				frame.getBtnSendToBack().setEnabled(true);
				frame.getBtnBringToFront().setEnabled(false);
				frame.getBtnSendToFront().setEnabled(false);
			}
			else if(size>1 && lastSelected==1) {
				frame.getBtnBringToBack().setEnabled(false);
				frame.getBtnSendToBack().setEnabled(false);
				frame.getBtnBringToFront().setEnabled(true);
				frame.getBtnSendToFront().setEnabled(true);
			}
			else {
			frame.getBtnBringToBack().setEnabled(true);
				frame.getBtnSendToBack().setEnabled(true);
				frame.getBtnBringToFront().setEnabled(true);
				frame.getBtnSendToFront().setEnabled(true);
			}
		}
		else {
			frame.getBtnModify().setEnabled(false);
			frame.getBtnDelete().setEnabled(true);
			frame.getBtnBringToBack().setEnabled(false);
			frame.getBtnBringToFront().setEnabled(false);
			frame.getBtnSendToFront().setEnabled(false);
			frame.getBtnSendToBack().setEnabled(false);

		}
		if (!frame.getController().getUndo().isEmpty()) {
			frame.getBtnUndo().setEnabled(true);
		}
		else {
			frame.getBtnUndo().setEnabled(false);
		}
	}

}
