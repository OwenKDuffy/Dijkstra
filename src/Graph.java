import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {
	private class Node
	{
		ArrayList<Edge> connectedEdges;
		public Node()
		{
			connectedEdges = new ArrayList<Edge>();
		}
		public void addEdge(Node destination, double distance)
		{
			connectedEdges.add(new Edge(destination, distance));
		}
	}
	
	private class Edge
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
		for (Node n : Nodes) 
		{
			n = new Node();
		}
	}


	public void addEdgeOneWay(int index1, int index2, double distance) 
	{
		Nodes[index1].addEdge(Nodes[2], distance);
	}
	public void addEdgeTwoWay(int index1, int index2, double distance) 
	{
		Nodes[index1].addEdge(Nodes[2], distance);
		Nodes[index2].addEdge(Nodes[1], distance);

	}
	
}


