package maze;

import fr.enst.inf103.ui.MazeViewController;
import fr.enst.inf103.ui.MazeViewSource;

public class MazeController implements MazeViewController{
	
	private Maze maze;

	@Override
	public void calculateShortestPath() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MazeViewSource getMazeViewSource() {
		return maze;
	}

	@Override
	public MazeViewSource newMaze() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MazeViewSource openMaze(String fileName) {
		maze.initFromTextFile(fileName);
		return maze;
	}

	@Override
	public void saveMazeAs(String fileName) {	
		maze.saveToTextFile(fileName);
	}
	

}
