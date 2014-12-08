package maze;

import java.util.ArrayList;

import dijkstra.Dijkstra;
import dijkstra.VertexInterface;

import fr.enst.inf103.ui.MazeViewController;
import fr.enst.inf103.ui.MazeViewSource;

public class MazeController implements MazeViewController{
	
	private Maze maze;

	@Override
	public void calculateShortestPath() {
		
		MBox start = maze.getStart();
		MBox finish = maze.getFinish();
		ArrayList<VertexInterface> path = (Dijkstra.dijkstra(maze, start)).getShortestPathTo(finish);
		
		for(VertexInterface vertex : path)
		{
			MBox box = (MBox) vertex;
			
			// Question
			int line = box.getLine();
			int column = box.getColumn();
			
			maze.setSymbolForBox(line, column, "*");
			
			
			/* equivalent to :
			 * box.setSymbol("*");
			 */
		}
	}

	@Override
	public MazeViewSource getMazeViewSource() {
		return maze;
	}

	@Override
	public MazeViewSource newMaze() {
		maze = new Maze();
		return maze;
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
