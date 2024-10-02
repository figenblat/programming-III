import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.LinkedList;
// interface (implemented with proposal)
import java.util.List;

interface BuildingLoaderInterface {
    public List<BuildingDataInterface> loadFile(String csvFilePath) throws FileNotFoundException;
   
}

// public class (implemented primarilly in final app week)

public class BuildingLoader implements BuildingLoaderInterface {

    @Override
    public List<BuildingDataInterface> loadFile(String csvFilePath) throws FileNotFoundException {
        File file = new File(csvFilePath);
	List<BuildingDataInterface> edges = new LinkedList<>();
	Scanner scnr = null;
	scnr = new Scanner(new File(fileName));
	int count = 0;
	int split = 0;
	int split2 = 0;
	while (scnr.hasNext()){
		String list = scnr.nextLine();
		for (int k =0;k<list.length;k++){
			if (list[k] = ","){
				count++;
				if (count => 1){
			split2 = k;		
			}
			else{
				split = k;
		}
		String start = list.substring(0,split);
		String end = list.substring(split,split2);
		double dist = Double.parseDouble(list.substring(split2));
		BuildingData edge = new BuildingData(start,end,dist);
		edges.add(edge);

	}	
        return edges;
    }

    
	}
    }

	
}

// placeholder(s) (implemented with proposal, and possibly added to later)
