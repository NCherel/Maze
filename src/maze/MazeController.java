package maze;

import java.util.ArrayList;

import dijkstra.Dijkstra;
import dijkstra.VertexInterface;

import fr.enst.inf103.ui.MazeViewController;
import fr.enst.inf103.ui.MazeViewSource;

public class MazeController implements MazeViewController{
	
	private Maze maze;
	
	

	public MazeController() {
		maze = new Maze();
	}

	@Override
	public void calculateShortestPath() {
		
		MBox start = maze.getStart();
		MBox finish = maze.getFinish();

		ArrayList<VertexInterface> path = (Dijkstra.dijkstra(maze, start)).getShortestPathTo(finish);
			
		for(int i=1; i < path.size(); i++)
		{
			MBox box = (MBox) path.get(i);				
			box.setSymbol("*");
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
