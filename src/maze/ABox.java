package maze;
import java.io.PrintWriter;


public class ABox extends MBox {
	
	public ABox(Maze maze,int line, int column) {
		super(maze, line, column, "A");
	}

	@Override
	public void writeCharTo(PrintWriter printer) {
		printer.print('A');		
	}
	
	public boolean isFinish()
	{
		return true;
	}
}
