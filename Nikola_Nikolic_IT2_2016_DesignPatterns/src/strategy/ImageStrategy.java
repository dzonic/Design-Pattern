package strategy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import mvc.DrawingFrame;

public class ImageStrategy implements Strategy {
	private DrawingFrame frame;

	public ImageStrategy(DrawingFrame frame) {
		this.frame = frame;
	}

	@Override
	public void saveFile(File file) {
		try {
			FileOutputStream fileSave = new FileOutputStream(file);
			ObjectOutputStream out = new ObjectOutputStream(fileSave);

			out.writeObject(frame.getView().getDrawingModel().getAll());

			out.close();
			fileSave.close();
		} catch (IOException ex) {
			System.out.println("IOException is caught");
		}
	}

}
