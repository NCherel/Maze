package dijkstra;

import java.util.Hashtable;

public class Pi implements PiInterface {
	
	private Hashtable<VertexInterface, Integer> table;

	public Pi() {
		table = new Hashtable<VertexInterface, Integer>();
	}
	
	@Override
	public void setValue(VertexInterface vertex, int value) {
		table.put(vertex, new Integer(value));		
	}

	@Override
	public int getValue(VertexInterface vertex) {
		return table.get(vertex).intValue();
	}

}
