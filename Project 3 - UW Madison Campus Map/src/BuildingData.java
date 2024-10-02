interface BuildingDataInterface {
    public double getDistance();
    public String getendLocation();
    public String getstartLocation(); 
}

// public class (implemented primarilly in final app week)

public class BuildingData implements BuildingDataInterface {
	private double Distance;
	public String endLocation;
        public String startLocation;

    public BuildingData(String startLocation,double Distance,String endLocation){
	   startLocation = startLocation;
	    Distance = Distance;
	    endLocation = endLocation;
    }

    @Override
    public double getDistance() {
       
        return Distance;
    
    }
    @Override
    public String getendLocation() {
        return endLocation;
    }
    @Override
    public String getstartLocation(){
	    return startLocation;
    }  

}

// placeholder(s) (implemented with proposal, and possibly added to later)
class BuildingDataPlaceholderA implements BuildingDataInterface {
    public double getDistance() { return 5.5; }
    public String getendLocation() { return "Ogg Hall"; }
    public String getstartLocation() { return "Engineering Hall"; }
}
class BuildingDataPlaceholderB implements BuildingDataInterface {
    public double getDistance() { return 3.2; }
    public String getendLocation() { return "Gordon Dining"; }
    public String getstartLocation() { return "Ogg"; }
}
