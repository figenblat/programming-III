// --== CS400 File Header Information ==--
// Name: Noa Figenblat
// Email: figenblat@wisc.edu
// Team: CP
//TA: Evan Wireman
// Lecturer: Florian Heimerl
// Notes to Grader: none
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.platform.console.ConsoleLauncher;
import java.lang.invoke.MethodHandles;
import java.util.NoSuchElementException;

/**
 * Tests the implementation of CS400Graph for the individual component of
 * Project Three: the implementation of Dijsktra's Shortest Path algorithm.
 */
public class GraphTest {

	private CS400Graph<String> graph;

	/**
	 * Instantiate graph from last week's shortest path activity.
	 * The node farthest away from starting node D is node B (used for #9 and #10
	 * in Test ShortestPath Calculation in project write up)(also used for 
	 * testPathCostDToB and TestPathDToB
	 */
	@BeforeEach
	public void createGraph() {
		graph = new CS400Graph<>();			
		// insert vertices A-F
		graph.insertVertex("A");
		graph.insertVertex("B");
		graph.insertVertex("C");
		graph.insertVertex("D");
		graph.insertVertex("E");
		graph.insertVertex("F");
		// insert edges from Week 11. Shortest Path Activity
		graph.insertEdge("A","B",6);
		graph.insertEdge("A","C",2);
		graph.insertEdge("A","D",5);
		graph.insertEdge("B","E",1);
		graph.insertEdge("B","C",2);
		graph.insertEdge("C","B",3);
		graph.insertEdge("C","F",1);
		graph.insertEdge("D","E",3);
		graph.insertEdge("E","A",4);
		graph.insertEdge("F","A",1);
		graph.insertEdge("F","D",1);
	}

	/**
	 * Checks the distance/total weight cost from the vertex A to F.
	 */
	@Test
	public void testPathCostAtoF() {
		assertTrue(graph.getPathCost("A", "F") == 3);
	}

	/**
	 * Checks the distance/total weight cost from the vertex A to D.
	 */
	@Test
	public void testPathCostAtoD() {
		assertTrue(graph.getPathCost("A", "D") == 4);
	}

	/**
	 * Checks the ordered sequence of data within vertices from the vertex 
	 * A to D.
	 */
	@Test
	public void testPathAtoD() {
		assertTrue(graph.shortestPath("A", "D").toString().equals(
				"[A, C, F, D]"
				));
	}

	/**
	 * Checks the ordered sequence of data within vertices from the vertex 
	 * A to F.
	 */
	@Test
	public void testPathAtoF() {
		assertTrue(graph.shortestPath("A", "F").toString().equals(
				"[A, C, F]"
				));
	}

	/*
	 * Checks the distance/total weight cost from the vertex D to B.
	 * Confirming the distance computed for this node (B) in last week's
	 * activity is correct
	 */
	@Test
	public void testPathCostDtoB() {
		assertTrue(graph.getPathCost("D", "B") == 12);
	}

	/*
	 * Checks the ordered sequence of data within vertices from the vertex D to B
	 * Confirming the sequence of nodes along the path from the source node (D) to 
	 * the same end node (B - the node farthest from the source node) is correct
	 */
	@Test
	public void testPathDToB() {
		assertTrue(graph.shortestPath("D", "B").toString().equals("[D, E, A, C, B]"));
	}

	/*
	 * Checks the distance/total weight cost from the vertex B to F.
	 * Confirms the path cost reported for question 2 of last week's 
	 * activity
	 */
	@Test
	public void testPathCostBToF() {
		assertTrue(graph.getPathCost("B", "F") == 3);
	}

	/*
	 * Checks the ordered sequence of data within vertices from the vertex F to B
	 * Confirming the predecessor reported for question 3 of last week's activity
	 * Done by confirming the sequence of nodes from the source node(F) to the 
	 * end node (B)
	 */
	@Test
	public void testPathFToB() {
		assertTrue(graph.shortestPath("F", "B").toString().equals("[F, A, C, B]"));
	}

	/*
	 * One more test method to convince myself of the correctness of my 
	 * implementation:
	 * Checks if throws a NoSuchElement exception when given start vertex does not exist
	 */
	
	@Test
	public void testException() {
		boolean thrown = false;
		try {
			graph.getPathCost("W", "B");
		}
		catch(NoSuchElementException e) {
			thrown = true;
		}

		assertTrue(thrown);
	}
	


	public static void main(String[] args) {
		String className = MethodHandles.lookup().lookupClass().getName();
		String classPath = System.getProperty("java.class.path").replace(" ", "\\ ");
		String[] arguments = new String[] {
				"-cp",
				classPath,
				"--include-classname=.*",
				"--select-class=" + className };
		ConsoleLauncher.main(arguments);
	}

}