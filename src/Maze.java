import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


public class Maze implements GraphInterface{

	public static final int HEIGHT = 10;
	public static final int WIDTH = 10;
	
	private final MBox[][] boxes;
	
	public Maze() {
		boxes = new MBox[HEIGHT][WIDTH];
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
		
		try {
			BufferedReader buffer = new BufferedReader(new FileReader(fileName));
			
			for(int i=0; i < HEIGHT; i++)
			{
				String line = buffer.readLine();
				
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
					}
					
					System.out.print(line.charAt(j));
				}
				
				System.out.println("\n");
			}
			
			buffer.close();
	}
		
	catch(Exception e) {
		System.out.print("Fichier non trouvé");
		return;
		}
	}
	
}
