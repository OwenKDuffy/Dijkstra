import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.junit.Test;


public class CompetitionTests {

	@Test
	public void testDijkstraConstructor() 
	{
		CompetitionDijkstra cd = new CompetitionDijkstra("input-B.txt", 100, 75, 50);
	}
	@Test
	public void testDijkstraConstructorNoFiles() 
	{
		CompetitionDijkstra cd = new CompetitionDijkstra("", 100, 75, 50);
	}
	@Test
	public void testDijkstraNoSpeeds()
	{
		CompetitionDijkstra cd = new CompetitionDijkstra("input-A.txt", 0, 0, 0);
		assertEquals("test input-A", -1, cd.timeRequiredforCompetition());
	}
	@Test
	public void testDijkstraA()
	{
		CompetitionDijkstra cd = new CompetitionDijkstra("input-A.txt", 60, 50, 75);
		assertEquals("test input-A", -1, cd.timeRequiredforCompetition());
	}
	@Test
	public void testDijkstraB()
	{
		CompetitionDijkstra cd = new CompetitionDijkstra("input-B.txt", 50, 80, 60);
		assertEquals("test input-B", 10000, cd.timeRequiredforCompetition());
	}
	@Test
	public void testDijkstraD()
	{
		CompetitionDijkstra cd = new CompetitionDijkstra("input-D.txt", 50, 80, 60);
		assertEquals("test input-D", 38, cd.timeRequiredforCompetition());
	}
	@Test
	public void testDijkstraK()

	{
		CompetitionDijkstra cd = new CompetitionDijkstra("input-K.txt", 51, 7, 2266262);
		assertEquals("test input-K", 2286, cd.timeRequiredforCompetition());
	}

	@Test
	public void testFWConstructor() {
		CompetitionFloydWarshall cf = new CompetitionFloydWarshall("input-A.txt", 100, 75, 50);
	}
	@Test
	public void testFWD()
	{
		CompetitionFloydWarshall cf = new CompetitionFloydWarshall("input-D.txt", 50, 80, 60);
		assertEquals("test input-D", 38, cf.timeRequiredforCompetition());
	}

	@Test
	public void testFWNoFile()
	{
		CompetitionFloydWarshall cf = new CompetitionFloydWarshall("", 50, 80, 60);
		assertEquals("test No File", -1, cf.timeRequiredforCompetition());
	}

	//TODO - more tests

}
