import java.io.FileNotFoundException;

import org.junit.Test;

public class CompetitionTests {

    @Test
    public void testDijkstraConstructor() 
    {
    	try {
			CompetitionDijkstra cd = new CompetitionDijkstra("src/input-B.txt", 100, 75, 50);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //TODO
    }

    @Test
    public void testFWConstructor() {
        //TODO
    }

    //TODO - more tests
    
}
