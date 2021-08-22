import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Graph<T> {
	private ArrayList<ArrayList<T>> adjacency;
	private int vertexCount;
	private int edgeCount;

	public Graph() {
		adjacency = new ArrayList<ArrayList<T>>();
		edgeCount = 0;
		vertexCount = 0;
	}

	public int getVertexCount() {
		return vertexCount;
	}

	public int getEdgeCount() {
		return edgeCount;
	}

	public ArrayList<T> getVertex(int index) {
		return adjacency.get(index);
	}

	public int getVertexOfEdge(int source, T weight) {
		for (int i = 0; i < vertexCount; i++) {
			if (adjacency.get(source).get(i) != null) {
				if (adjacency.get(source).get(i).equals(weight)) {
					return i;
				}
			}
		}
		return -1;
	}

	public Map<Integer,T> getDestVertexFromVertex(int source) {
		Map<Integer,T> dest = new HashMap<Integer,T>();
		for (int i = 0; i < vertexCount; i++) {
			if (adjacency.get(source).get(i) != null) {
				dest.put(i, getEdge(source, i));
			}
		}
		return dest;
	}

	public T getEdge(int source, int dest) {
		return adjacency.get(source).get(dest);
	}

	public void addVertex() {
		for (int i = 0; i < vertexCount; i++) {
			adjacency.get(i).add(null);
		}
		vertexCount++;
		ArrayList<T> list = new ArrayList<T>();
		for (int j = 0; j < vertexCount; j++) {
			list.add(null);
		}
		adjacency.add(list);
	}

	public void removeVertex(int vertex) {
		if (vertex <= vertexCount) {
			for (int i = 0; i < vertexCount; i++) {
				adjacency.get(i).remove(vertex);
			}
			adjacency.remove(vertex);
			vertexCount--;
		}
	}

	public void addEdge(int source, int dest, T weight) {
		while (source >= vertexCount) {
			addVertex();
		}
		while (dest >= vertexCount) {
			addVertex();
		}
		adjacency.get(source).set(dest, weight);
		edgeCount++;
	}

	public void removeEdge(int source, int dest) {
		adjacency.get(source).set(dest, null);
		edgeCount--;
	}

	public void combineVertex(int u, int v) {
		ArrayList<T> vertex = this.getVertex(v);
		for (int i = 0; i < vertex.size(); i++) {
			T t = vertex.get(i);
			if (t != null) {
				adjacency.get(u).set(i, t);
			}
		}
		for (int j = 0; j < vertex.size(); j++) {
			Map<Integer,T> dest = this.getDestVertexFromVertex(j);
			if (dest.containsKey(v)) {
				adjacency.get(j).set(u, dest.get(v));
			}
		}
	}

}
