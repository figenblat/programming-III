import java.io.FileNotFoundException;
import java.util.List;

public class UWCampusMapApp {

	public static void main(String[] args) throws Exception {
		System.out.println("Welcome to UW Campus Map!");
        List<BuildingData> buildings = new BuildingLoader().loadFile("Building.csv");
        BuildingBackEnd engine = new BuildingBackEnd();
        for(BuildingData building : buildings) {
        	engine.insertVertex(building.location);
        	engine.insertEdge(building.location, building.location, building.getDistance());
        }
        BuildingFrontEnd ui = new BuildingFrontEnd();
        ui.run(engine);




	}




}
