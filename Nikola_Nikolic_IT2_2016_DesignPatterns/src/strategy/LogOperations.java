package strategy;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import model.DrawingModel;
import mvc.DrawingFrame;

public class LogOperations implements Strategy {

	private DrawingFrame frame;
	public LogOperations(DrawingFrame frame) {
		this.frame = frame;
	}

	@Override
	public void saveFile(File file) {

		BufferedWriter buffer = null;

		try {
			buffer = new BufferedWriter(new FileWriter(file.getAbsolutePath()));

			String logString = "";
			int size = frame.getDlmList().getSize();

			for (int i = 0; i < size; i++) {
				logString = frame.getDlmList().get(i);
				buffer.write(logString);
				buffer.newLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				buffer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
