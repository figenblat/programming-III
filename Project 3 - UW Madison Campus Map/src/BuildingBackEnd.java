import java.util.List;

interface BuildingBackEndInterface {
    public boolean insertVertex(String data);
    public boolean insertEdge(String source, String target, int weight);
    //Finds the shortest path between the starting point and the destination        
    public List<String> shortestPath(String start, String end);
    //Calculates the distance between the starting point and the destination        
    public int getPathCost(String start, String end);
    //Calculates the travel time based on the distance
    public int getTravelTime(int distance, int time);
}

public class BuildingBackEnd implements BuildingBackEndInterface {

    /**
     * Data holding buildings and paths information.
     */
    public CS400Graph<String> building;

    /**
     * Runs a method called BuildingLoader that loads data from a file into the graph.
     */
    public BuildingBackEnd() {
        building = new CS400Graph<>();
    }

    /**
     * Takes graph as parameter and initializes it.
     *
     * @param building Graph to be used.
     */
    public BuildingBackEnd(CS400Graph<String> building) {
        this.building = building;
    }

    /**
     * Add a vertex to the graph that will be loaded and used for this project.
     *
     * @param data the data item stored in the new vertex
     * @return true if the data can be inserted as a new vertex, false if it is
     * already in the graph
     * @throws NullPointerException if data is null
     */
    @Override
    public boolean insertVertex(String data) {
        return building.insertVertex(data);
    }

    /**
     * Insert a new directed edge with a positive edge weight into the graph.
     *
     * @param source the data item contained in the source vertex for the edge
     * @param target the data item contained in the target vertex for the edge
     * @param weight the weight for the edge (has to be a positive integer)
     * @return true if the edge could be inserted or its weight updated, false
     * if the edge with the same weight was already in the graph
     * @throws IllegalArgumentException if either source or target or both are not in the graph,
     *                                  or if its weight is < 0
     * @throws NullPointerException     if either source or target or both are null
     */
    @Override
    public boolean insertEdge(String source, String target, int weight) {
        return building.insertEdge(source,target,weight);
    }

    /**
     * Returns the shortest path between start and end.
     * Uses Dijkstra's shortest path algorithm to find the shortest path.
     *
     * @param start the data item in the starting vertex for the path
     * @param end   the data item in the destination vertex for the path
     * @return list of data item in vertices in order on the shortest path between vertex
     * with data item start and vertex with data item end, including both start and end
     * @throws NoSuchElementException when no path from start to end can be found
     *                                including when no vertex containing start or end can be found
     */
    @Override
    public List<String> shortestPath(String start, String end) {
        return building.shortestPath(start,end);
    }

    /**
     * Returns the cost of the path (sum over edge weights) between start and end.
     * Uses Dijkstra's shortest path algorithm to find the shortest path.
     *
     * @param start the data item in the starting vertex for the path
     * @param end   the data item in the end vertex for the path
     * @return the cost of the shortest path between vertex with data item start
     * and vertex with data item end, including all edges between start and end
     * @throws NoSuchElementException when no path from start to end can be found
     *                                including when no vertex containing start or end can be found
     */
    @Override
    public int getPathCost(String start, String end) {
        return building.getPathCost(start,end);
    }

    /**
     * Calculates the expected travel time by walking of the trip.
     *
     * @param distance the total distance between buildings
     * @param time     the expected average speed while walking. (1~4 miles per hour)
     * @return the value of the expected time.
     * @throws IllegalArgumentException if the entered distance is invalid such as negative distance
     */
    public int getTravelTime(int distance, int time) {
        if (distance < 0 || time <= 0) {
            throw new IllegalArgumentException("ERROR: Distance or time is not valid");
        }
        return (int)Math.round(distance/time);
    }
}
