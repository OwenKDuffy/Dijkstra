import java.io.File;
import java.util.ArrayList;


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


	int speedA, speedB, speedC;
	private double[][] graph;
	private double[][] dist;
	private int[][] prev;

	CompetitionDijkstra (String filename, int sA, int sB, int sC) 
	{
		this.speedA = sA;
		this.speedB = sB;
		this.speedC = sC;
		File testFile= new File(filename);
		if (!testFile.exists())
		{
			//throw new FileNotFoundException("Could not find file: " + filename);
			return;
		}
		In file= new In(filename);
		String connections=file.readAll();
		String[] connectionsArray=connections.split("\n");

		int v = Integer.parseInt(connectionsArray[0]);
		graph = new double [v][v];
		for (int i = 0; i < graph.length; i++) 
		{
			for (int j = 0; j < graph[i].length; j++) 
			{
				graph[i][j] = -1;
			}
		}
		for(int i = 2; i < connectionsArray.length; i++)
		{
			String street = connectionsArray[i];
			String[] properties=street.split(" ");

			graph[Integer.parseInt(properties[0])][Integer.parseInt(properties[1])] = Double.parseDouble(properties[2]);
		}

		dist = new double [v][v];
		prev = new int [v][v];



		for (int source = 0; source < v ; source++) 
		{
			Dijkstra(source, graph, dist[source], prev[source]);

		}

	}
	private void Dijkstra(int source, double[][] graph, double[] dist, int[] prev)
	{
		ArrayList<Integer> queue = new ArrayList<Integer>();

		for (int j = 0; j < dist.length; j++) 
		{
			dist[j] = Double.MAX_VALUE;
			prev[j] = -1;				
			queue.add(j);
		}
		dist[source] = 0;
		while(!queue.isEmpty())
		{
			int u = minOf(queue, dist);

			int pos = queue.indexOf(u);
			if(pos >=0 && pos < queue.size())
				queue.remove(pos);

			for (int x = 0; x < dist.length ; x++) 
			{
				double lengthUX = graph[u][x];
				if(lengthUX >= 0) // if u is a neighbour of x
				{
					double alt = dist[u] + lengthUX;
					if(alt < dist[x])
					{
						dist[x] = alt;
						prev[x] = u;
					}
				}
			}
		}
	}


	private int minOf(ArrayList<Integer> queue, double[] lengthTo) {
		double minDist = Double.MAX_VALUE;
		int nearest = -1;
		for(int i : queue)
		{
			double distanceTo = lengthTo[i];
			if(distanceTo >=0 && distanceTo < minDist)
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
		for(double[] da: dist)
		{
			for (double d : da) 
			{
				if(d > longestPath)
				{
					longestPath = d;
				}
			}
		}
		int end = (int) (Math.ceil((longestPath*1000)/(Math.min(speedA, (Math.min(speedB, speedC))))));
		return end;

	}


}
