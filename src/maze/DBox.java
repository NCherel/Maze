package maze;
import java.io.PrintWriter;


public class DBox extends MBox {

	public DBox(Maze maze,int line, int column) {
		super(maze, line, column);
	}

	@Override
	public void writeCharTo(PrintWriter printer) {
		printer.print('D');
		
	}
	
	
}
