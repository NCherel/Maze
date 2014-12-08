package maze;
import java.io.PrintWriter;


public class EBox extends MBox {

	public EBox(Maze maze,int line, int column) {
		super(maze, line, column,"E");
	}

	@Override
	public void writeCharTo(PrintWriter printer) {
		printer.print('E');
		
	}
	
	
	
}
