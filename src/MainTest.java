import fr.enst.inf103.ui.MazeWindow;
import maze.Maze;
import maze.MazeController;


public class MainTest {

	public static void main(String[] args) {
		MazeController controller = new MazeController();
		MazeWindow window = new MazeWindow("Notre labyrinthe", controller);
		
	}

}
