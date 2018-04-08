import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.junit.Test;


public class CompetitionTests {

    @Test
    public void testDijkstraConstructor() 
    {

			CompetitionDijkstra cd = new CompetitionDijkstra("input-B.txt", 100, 75, 50);
		
        //TODO
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

    //TODO - more tests
    
}
