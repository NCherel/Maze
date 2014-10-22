package dijkstra;
import java.util.ArrayList;


public class Dijkstra {

	private	PreviousInterface dijkstra(GraphInterface g, VertexInterface r, ASetInterface a, PiInterface pi, PreviousInterface previous) {
		
		ArrayList<VertexInterface> allVertices = g.getAllVertices();
		int n = allVertices.size();
		
		//ajout de la racine
		a.add(r);
		
		//initialisation des poids		
		for(VertexInterface vertex : allVertices)
			pi.setValue(vertex, Integer.MAX_VALUE);
		pi.setValue(r, 0);
		
		//initialisation du pivot		
		VertexInterface pivot = r;
		int piPivot = pi.getValue(pivot);
		
		//boucle principale			
		for(int i=0; i < n; i++)
		{
			ArrayList<VertexInterface> successors = g.getSucessors(pivot);
			
			//Mise à jour du pi des voisins du pivot			
			for(VertexInterface vertex : successors)
			{
				if(!a.contains(vertex))
				{
					int weight = g.getWeight(pivot, vertex);
					
					if(piPivot + weight < pi.getValue(vertex))
					{
						pi.setValue(vertex, piPivot + weight);
						previous.setValue(vertex, pivot);
					}	
				}
			}
			
			
			//Recherche du pivot parmi tous les points n'appartenant pas à A
			VertexInterface newPivot = null;
			int piNewPivot = Integer.MAX_VALUE;
			
			for(VertexInterface vertex : allVertices)
			{
				if(!a.contains(vertex))
				{
					if(pi.getValue(vertex) < piPivot)
					{
						pivot = vertex;
						piPivot = pi.getValue(vertex);
					}
				}
			}
			
			
			//S'il n'y a pas de nouveau pivot, on a fini			
			if(newPivot == null)
				return previous;
			
			//sinon on rajoute le nouveau pivot et on change de pivot			
			a.add(newPivot);
			pivot = newPivot;
			piPivot = piNewPivot;
			
		}
	}
}
