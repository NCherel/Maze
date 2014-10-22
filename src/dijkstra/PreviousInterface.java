package dijkstra;
import java.util.ArrayList;


public interface PreviousInterface {

	//change le père du vertex	
	public void setValue(VertexInterface vertex, VertexInterface value);
	
	//donne le père du vertex
	public VertexInterface getValue(VertexInterface vertex);
	
	//renvoie le chemin en remontant les parents
	public ArrayList<VertexInterface> getShortestPathTo(VertexInterface vertex);
}
	