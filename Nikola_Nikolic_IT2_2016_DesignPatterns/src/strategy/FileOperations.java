package strategy;

import java.io.File;

public class FileOperations {
	
	private Strategy strategy;
	

	public void setFileOperations(Strategy strategy) {
		this.strategy = strategy;
	}


	public void saveFile(File file) {
			strategy.saveFile(file);
	}
}
