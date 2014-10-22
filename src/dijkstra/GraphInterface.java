package dijkstra;
import java.util.ArrayList;


public interface GraphInterface {

	//renvoie la liste de tous les vertices du graph	
	public ArrayList<VertexInterface> getAllVertices();
	
	//renvoie les vertices voisins du pivot
	public ArrayList<VertexInterface> getSucessors(VertexInterface vertex);
	
	//donne le poids d'une edge entre deux vertices (MAX_VALUE si l'edge n'existe pas)
	public int getWeight(VertexInterface src, VertexInterface dst);
}
