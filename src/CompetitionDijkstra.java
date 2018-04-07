import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;

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

		intersections = new Graph(Integer.parseInt(connectionsArray[0]));

		for (int i=2; i < connectionsArray.length; i++)
		{
			String street = connectionsArray[i];
			String[] properties=street.split(" ");

			intersections.addEdgeOneWay(Integer.parseInt(properties[0]), Integer.parseInt(properties[1]), Double.parseDouble(properties[2]));
		}

	}


	/**
	 * @return int: minimum minutes that will pass before the three contestants can meet
	 */
	public int timeRequiredforCompetition()
	{
		
		double shortestDistance = Double.MAX_VALUE;
		for(int i = 0; i < intersections.V; i++)
		{
			double dist = dijkstra(intersections, i);
			if (dist < shortestDistance)
			{
				shortestDistance = dist;
			}
			
		}
		return (int) Math.ceil(shortestDistance);
	}


	private double dijkstra(Graph intersections2, int i) {
		// TODO Auto-generated method stub
		return 0;
	}

}
