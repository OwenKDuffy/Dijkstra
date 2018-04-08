import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {
	class Node
	{
		ArrayList<Edge> connectedEdges;
		int myIndex;
		public Node(int index)
		{
			myIndex = index;
			connectedEdges = new ArrayList<Edge>();
		}
		public void addEdge(Node destination, double distance)
		{
			connectedEdges.add(new Edge(destination, distance));
		}
	}
	
	class Edge
	{
		double length;
		Node destinationEdge;
		
		public Edge(Node destination, double distance) {
			this.destinationEdge = destination;
			this.length = distance;
		}
	}
	int V;
	private Node[] Nodes;

	public Graph(int v)
	{
		this.V = v;
		Nodes = new Node[v];
		for (int i = 0; i < v; i++) 
		{
			Nodes[i] = new Node(i);
		}
	}


	public void addEdgeOneWay(int index1, int index2, double distance) 
	{
		Nodes[index1].addEdge(Nodes[index2], distance);
	}


	public ArrayList<Edge> getNeighboursOf(int u) {
		return Nodes[u].connectedEdges;
	}


	
	
}


