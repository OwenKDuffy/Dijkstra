import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

/*
 * A Contest to Meet (ACM) is a reality TV contest that sets three contestants at three random
 * city intersections. In order to win, the three contestants need all to meet at any intersection
 * of the city as fast as possible.
 * It should be clear that the contestants may arrive at the intersections at different times, in
 * which case, the first to arrive can wait until the others arrive.
 * From an estimated walking speed for each one of the three contestants, ACM wants to determine the
 * minimum time that a live TV broadcast should last to cover their journey regardless of the contestants’
 * initial positions and the intersection they finally meet. You are hired to help ACM answer this question.
 * You may assume the following:
 *     Each contestant walks at a given estimated speed.
 *     The city is a collection of intersections in which some pairs are connected by one-way
 * streets that the contestants can use to traverse the city.
 *
 * This class implements the competition using Dijkstra's algorithm
 */

public class CompetitionDijkstra {

	/**
	 * @param filename: A filename containing the details of the city road network
	 * @param sA, sB, sC: speeds for 3 contestants
	 */

	Graph intersections;
	int speedA, speedB, speedC;
	DijkstraTable[] dta;
	private class DijkstraTable
	{
		double[] dist;
		double[] prev;
		DijkstraTable(int size)
		{
			dist = new double[size];
			prev = new double[size];

		}
	}

	CompetitionDijkstra (String filename, int sA, int sB, int sC) throws FileNotFoundException
	{
		this.speedA = sA;
		this.speedB = sB;
		this.speedC = sC;
		File testFile= new File(filename);
		if (!testFile.exists())
		{
			throw new FileNotFoundException("Could not find file: " + filename);
		}
		In file= new In(filename);
		String connections=file.readAll();
		String[] connectionsArray=connections.split("\n");

		int v = Integer.parseInt(connectionsArray[0]);
		intersections = new Graph(v);

		for (int i=2; i < connectionsArray.length; i++)
		{
			String street = connectionsArray[i];
			String[] properties=street.split(" ");

			intersections.addEdgeOneWay(Integer.parseInt(properties[0]), Integer.parseInt(properties[1]), Double.parseDouble(properties[2]));
		}
		dta = new DijkstraTable[v];
		for(int i = 0; i < v; i++)
		{
			dta[i] = new DijkstraTable(v);
		}
		for (int i = 0; i < intersections.V; i++) 
		{
			int source = i;
			ArrayList<Integer> queue = new ArrayList<Integer>();
			//			PriorityQueue<Integer> queue = new PriorityQueue<>(v, (a, b) -> a < b);
			double[] dist = new double[v];
			double[] prev = new double[v];
			for(int x = 0; x < v; x++)
			{
				dist[x] = Double.MAX_VALUE;
				prev[x] = -1;
				queue.add(x);
			}

			dist[source] = 0;

			while(!queue.isEmpty())
			{
				int u = minOf(queue, dist);
				queue.remove(queue.indexOf(u));

				ArrayList<Graph.Edge> neighbours = intersections.getNeighboursOf(u);

				for(Graph.Edge e: neighbours)
				{
					double alt = dist[u] + e.length;
					if (alt < dist[e.destinationEdge.myIndex])
					{
						dist[e.destinationEdge.myIndex] = alt;
						prev[e.destinationEdge.myIndex] = u;
					}
				}
			}
			dta[i].dist = dist;
			dta[i].prev = prev;
		}
	}


	private int minOf(ArrayList<Integer> queue, double[] dist) {
		double minDist = Double.MAX_VALUE;
		int nearest = -1;
		for(int i : queue)
		{
			double distanceTo = dist[i];
			if(distanceTo < minDist)
			{
				nearest = i;
				minDist = distanceTo;
			}
		}
		return nearest;
	}


	/**
	 * @return int: minimum minutes that will pass before the three contestants can meet
	 */
	public int timeRequiredforCompetition()
	{
		double longestPath = Double.MIN_VALUE;
		for(DijkstraTable dt : dta)
		{
			for(double dst : dt.dist)
			{
				if(dst > longestPath)
					longestPath = dst;
			}
		}
		return (int) (Math.ceil(longestPath*1000)/(Math.min(speedA, (Math.min(speedB, speedC)))));


	}


}
