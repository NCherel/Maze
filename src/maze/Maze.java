package maze;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import dijkstra.GraphInterface;
import dijkstra.VertexInterface;
import fr.enst.inf103.ui.MazeView;
import fr.enst.inf103.ui.MazeViewSource;


public class Maze implements GraphInterface, MazeViewSource{

	public static final int HEIGHT = 10;
	public static final int WIDTH = 10;
	
	private final MBox[][] boxes;
	
	public Maze() {
		boxes = new MBox[HEIGHT][WIDTH];
		
		for(int i=0; i < WIDTH; i ++)
		{
			for(int j=0; j < HEIGHT; j++)
			{
				if(i==0 || j ==0 || i == WIDTH -1 || j== HEIGHT -1)
					boxes[i][j] = new WBox(this, i, j);
				
				else
					boxes[i][j] = new EBox(this, i, j);
			}
		}
	}

	public final MBox getBoxes(int line, int column) {
		return boxes[line][column];
	}

	@Override
	public ArrayList<VertexInterface> getAllVertices() {
		
		ArrayList<VertexInterface> allVertices = new ArrayList<VertexInterface>();
		
		for(int i=0; i < HEIGHT; i++)
			for(int j=0; j < WIDTH; j++)
				allVertices.add(boxes[i][j]);
		
		return allVertices;
	}

	@Override
	public ArrayList<VertexInterface> getSucessors(VertexInterface vertex) {
		
		//cast de vertex en MBox
		MBox box = (MBox) vertex;
		int line = box.getLine();
		int column = box.getColumn();
		
		ArrayList<VertexInterface> successors = new ArrayList<VertexInterface>();
		
		
		if(line > 0)
			if(boxes[line-1][column].isAccessible())
				successors.add(boxes[line-1][column]);
		
		if(line < WIDTH - 1)
			if(boxes[line+1][column].isAccessible())
				successors.add(boxes[line+1][column]);
		

		if(column > 0)
			if(boxes[line][column-1].isAccessible())
				successors.add(boxes[line][column-1]);
		

		if(column < HEIGHT - 1)
			if(boxes[line][column+1].isAccessible())
				successors.add(boxes[line][column+1]);
		
		
		return successors;
	}

	@Override
	public int getWeight(VertexInterface src, VertexInterface dst) {
		return 1;
	}
	
	public final void initFromTextFile(String fileName) {
			
			BufferedReader buffer = null;
			FileReader fileReader = null;
			
			try {
				
				fileReader = new FileReader(fileName);
				buffer = new BufferedReader(fileReader);
				
				for(int i=0; i < HEIGHT; i++)
				{
					String line = buffer.readLine();
					
					if(line == null)
						throw new MazeReadingException(fileName, i, "Not enough lines");
					
					if(line.length() < WIDTH)
						throw new MazeReadingException(fileName, i, "Line too short");
					
					if(line.length() > WIDTH)
						throw new MazeReadingException(fileName, i, "Line too long");
					
					for(int j=0; j < WIDTH; j++)
					{
						switch(line.charAt(j))
						{
							case 'A' :
								boxes[i][j] = new ABox(this,i,j);
								break;
								
							case 'W' :
								boxes[i][j] = new WBox(this,i,j);
								break;
								
							case 'E' :
								boxes[i][j] = new EBox(this,i,j);
								break;
								
							case 'D' :
								boxes[i][j] = new DBox(this,i,j);
								break;
								
							default :
								throw new MazeReadingException(fileName, i, "Incorrect Character " + line.charAt(j) );
						}
					}
					
				}
			}
		
		catch(MazeReadingException e) {
			System.err.print(e.getMessage());
		}
			
		catch(FileNotFoundException e) {
			System.err.print("Error opening : "+ fileName);
		}
			
		catch(IOException e) {
			System.err.print("read error: "+ fileName);
		}
			
		catch(Exception e) {
			System.err.print("Unknown error");
			e.printStackTrace(System.err);
		}
	
		
		finally {
			if(buffer != null)
			{
				try
				{
					buffer.close();
				}
			
				catch(Exception e){};
			}
		}
	}
	
	
	public final void saveToTextFile(String fileName) {
		
		PrintWriter printer = null;
				
		try {
			printer = new PrintWriter(fileName);
			
			for(int i = 0; i < HEIGHT; i++)
			{				
				for(int j = 0; j < WIDTH; j++)
				{
					boxes[i][j].writeCharTo(printer);
				}
				
				printer.println();
			}
		}
		
		catch(FileNotFoundException e)
		{
			System.err.print("File not found : "+ fileName);
			return;
		}
		
		catch(SecurityException e)
		{
			System.err.print("Security exception for file : "+ fileName);
			return;
		}
		
		catch(Exception e)
		{
			System.err.print("Unknown error for file : "+ fileName);
			return;
		}
		
		finally {
			if(printer != null)
			{
				try {
					printer.close();
				}
				
				catch(Exception e) 
				{}
			}
		}
	}

	
	
	///// MAZE VIEW SOURCE ////
	@Override
	public boolean drawMaze(Graphics g, MazeView mazeView) {
		// TODO Auto-generated method stub
		return false;  // Utilise l'implémentation par défaut. //
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return HEIGHT ;
	}
	
	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return WIDTH ;
	}
	
	@Override
	public String getSymbolForBox(int row, int column) {
		// TODO Auto-generated method stub
		return boxes[row][column].getSymbol();
	}

	@Override
	public void setSymbolForBox(int row, int column, String symbol) {
		// TODO Auto-generated method stub
		setTypeForBox(symbol, row, column);
		
	}
	
	private void setTypeForBox (String symbol, int row, int column) {
		if(symbol != null)
		{
			switch(symbol.charAt(0))
			{
				case 'A' :
					boxes[row][column] = new ABox(this,row,column);
					break;
					
				case 'W' :
					boxes[row][column] = new WBox(this,row,column);
					break;
					
				case 'E' :
					boxes[row][column] = new EBox(this,row,column);
					break;
					
				case 'D' :
					boxes[row][column] = new DBox(this,row,column);
					break;
				
				case '*' :	
					boxes[row][column].setSymbol("*");
					break ;
					
				default :
					boxes[row][column] = new EBox(this, row, column);
			}
		}
		else
			boxes[row][column] = new EBox(this,row,column);
		
	}

	@Override
	public boolean handleClick(MouseEvent e, MazeView mazeView) {
		// TODO Auto-generated method stub
		return false;  // Utilise l'implémentation par défaut. //
	}

	@Override
	public boolean handleKey(KeyEvent e, MazeView mazeView) {
		// TODO Auto-generated method stub
		return false;  // Utilise l'implémentation par défaut. //
	}

	
	public MBox getStart()
	{
		for(MBox[] line : boxes)
		{
			for(MBox box : line)
			{
				if(box.isStart())
					return box;
			}
		}
		
		return null;
	}
	
	public MBox getFinish()
	{
		for(MBox[] line : boxes)
		{
			for(MBox box : line)
			{
				if(box.isFinish())
					return box;
			}
		}
		
		return null;
	}

	
	
}
