package mvc;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;

import observer.ButtonObserver;
import model.DrawingModel;

public class DrawingApp {

	public static void main(String[] args) {

		DrawingModel model = new DrawingModel();
		DrawingFrame frame = new DrawingFrame();
		frame.getView().setModel(model);
		DrawingController controller = new DrawingController(model, frame);
		frame.setController(controller);

		frame.setTitle("Nikola Nikoliæ IT2/2016");
		frame.setSize(600, 750);
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		//frame.setUndecorated(true);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
	    //device.setFullScreenWindow(frame);

		ButtonObserver buttonObserver = new ButtonObserver(frame);
		model.addObserver(buttonObserver);

	}
}
