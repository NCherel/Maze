
public class Maze {

	public static final int HEIGHT = 10;
	public static final int WIDTH = 10;
	
	private final MBox[][] boxes;
	
	public Maze() {
		boxes = new MBox[HEIGHT][WIDTH];
	}

	public final MBox getBoxes(int line, int column) {
		return boxes[line][column];
	}
	
}
