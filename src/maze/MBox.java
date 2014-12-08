package maze;

import java.io.PrintWriter;

import dijkstra.VertexInterface;


public abstract class MBox implements VertexInterface{
	
	private final Maze maze;
	private final int line;
	private final int column;
	private String symbol;  
	
	
	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public MBox(Maze maze, int line, int column, String symbol) {
		this.maze = maze;
		this.line = line;
		this.column = column;
		this.symbol = symbol;
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
	
	public boolean isStart(){
		return symbol=="D";
	}
	
	public boolean isFinish(){
		return symbol=="A";
	}
}
