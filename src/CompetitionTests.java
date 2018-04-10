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
	public void testDijkstraC()
	{
		//input-C.txt with speed = [5,1000,67] should return -1
		CompetitionDijkstra cd = new CompetitionDijkstra("input-C.txt", 5, 1000, 67);
		assertEquals("test input-C", -1, cd.timeRequiredforCompetition());
	}
	@Test
	public void testDijkstraD()
	{
		CompetitionDijkstra cd = new CompetitionDijkstra("input-D.txt", 50, 80, 60);
		assertEquals("test input-D", 38, cd.timeRequiredforCompetition());
	}
//	@Test
//	public void testDijkstraI()
//	{
//		CompetitionDijkstra cd = new CompetitionDijkstra("input-I.txt", 4, 7, 1);
//		assertEquals("test input-I", 1715, cd.timeRequiredforCompetition());
//	}
//	@Test
//	public void testDijkstraIpt2()
//	{
//		CompetitionDijkstra cd = new CompetitionDijkstra("input-I.txt", 3233, 7, 2368726);
//		assertEquals("test input-I", 1715, cd.timeRequiredforCompetition());
//	}
	@Test
	public void testDijkstraJ()
	{
		CompetitionDijkstra cd = new CompetitionDijkstra("input-J.txt", 4, 7, 1);
		assertEquals("test input-J", -1, cd.timeRequiredforCompetition());
	}
	//input-J.txt with speed = [9876,7,4293] should return -1
	@Test
	public void testDijkstraJpt2()
	{
		CompetitionDijkstra cd = new CompetitionDijkstra("input-J.txt", 9876,7,4293);
		assertEquals("test input-J", -1, cd.timeRequiredforCompetition());
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
	public void testFWNoFile()
	{
		CompetitionFloydWarshall cf = new CompetitionFloydWarshall("", 50, 80, 60);
		assertEquals("test No File", -1, cf.timeRequiredforCompetition());
	}
	public void testFWNoSpeeds()
	{
		CompetitionFloydWarshall cf = new CompetitionFloydWarshall("input-A.txt", 0, 0, 0);
		assertEquals("test input-A", -1, cf.timeRequiredforCompetition());
	}
	@Test
	public void testFWA()
	{
		CompetitionFloydWarshall cf = new CompetitionFloydWarshall("input-A.txt", 60, 50, 75);
		assertEquals("test input-A", -1, cf.timeRequiredforCompetition());
	}
	@Test
	public void testFWB()
	{
		CompetitionFloydWarshall cf = new CompetitionFloydWarshall("input-B.txt", 50, 80, 60);
		assertEquals("test input-B", 10000, cf.timeRequiredforCompetition());
	}
	@Test
	public void testFWC()
	{
		//input-C.txt with speed = [5,1000,67] should return -1
		CompetitionFloydWarshall cf = new CompetitionFloydWarshall("input-C.txt", 5, 1000, 67);
		assertEquals("test input-C", -1, cf.timeRequiredforCompetition());
	}
	@Test
	public void testFWD()
	{
		CompetitionFloydWarshall cf = new CompetitionFloydWarshall("input-D.txt", 50, 80, 60);
		assertEquals("test input-D", 38, cf.timeRequiredforCompetition());
	}
//	@Test
//	public void testFWI()
//	{
//		CompetitionFloydWarshall cf = new CompetitionFloydWarshall("input-I.txt", 4, 7, 1);
//		assertEquals("test input-I", 1715, cf.timeRequiredforCompetition());
//	}
//	@Test
//	//input-I.txt with speed = [3233,7, 2368726] should return 1715
//	public void testFWIpt2()
//	{
//		CompetitionFloydWarshall cf = new CompetitionFloydWarshall("input-I.txt", 3233, 7, 2368726);
//		assertEquals("test input-I", 1715, cf.timeRequiredforCompetition());
//	}
	@Test
	public void testFWJ()
	{
		CompetitionFloydWarshall cf = new CompetitionFloydWarshall("input-J.txt", 9876,7,4293);
		assertEquals("test input-J", -1, cf.timeRequiredforCompetition());
	}
	@Test
	public void testFWJ2()
	{
		CompetitionFloydWarshall cf = new CompetitionFloydWarshall("input-J.txt", 4,7,1);
		assertEquals("test input-J", -1, cf.timeRequiredforCompetition());
	}
	@Test
	public void testFWK()
	{
		CompetitionFloydWarshall cf = new CompetitionFloydWarshall("input-K.txt", 51, 7, 2266262);
		assertEquals("test input-K", 2286, cf.timeRequiredforCompetition());
	}
	
	/*

input-J.txt with speed = [9876,7,4293] should return -1 (2 occurrences)

input-J.txt with speed = [4,7,1] should return -1 (2 occurrences)
	 */

}
