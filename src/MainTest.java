import maze.Maze;


public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Maze laby = new Maze();
		laby.initFromTextFile("data/labyrinthe.txt");
		laby.saveToTextFile("data/labyrinthe2.txt");
		
	}

}
