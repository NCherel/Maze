import java.io.PrintWriter;


public abstract class MBox implements VertexInterface{
	
	private final Maze maze;
	private final int line;
	private final int column;
	
	
	public MBox(Maze maze, int line, int column) {
		this.maze = maze;
		this.line = line;
		this.column = column;
	}
	
	@Override
	public String getLabel() {
		return '('+Integer.toString(line)+','+Integer.toString(column)+')';
	}

	public final int getLine() {
		return line;
	}

	public final int getColumn() {
		return column;
	}
	
	public boolean isAccessible() {
		return true;
	}
	
	public abstract void writeCharTo(PrintWriter printer);
}
