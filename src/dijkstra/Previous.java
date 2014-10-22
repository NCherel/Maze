package dijkstra;

import java.util.ArrayList;
import java.util.Hashtable;

public class Previous implements PreviousInterface {

	//table 2 dimensions qui contient le vertex et son père
	private Hashtable<VertexInterface, VertexInterface> table;
	
	//constructeur
	public Previous() {
		table = new Hashtable<VertexInterface,VertexInterface>();
	}
	
	@Override
	public void setValue(VertexInterface vertex, VertexInterface value) {
		table.put(vertex, value);	
	}

	@Override
	public VertexInterface getValue(VertexInterface vertex) {
		return table.get(vertex);
	}

	@Override
	public ArrayList<VertexInterface> getShortestPathTo(VertexInterface vertex) {
		
		ArrayList<VertexInterface> chemin = new ArrayList<VertexInterface>();
		VertexInterface current = vertex;
		
		while(getValue(current) != null)
		{
			chemin.add(current);
			current = getValue(current);			
		}
		
		return chemin;
	}

	
}
