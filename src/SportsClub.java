
public abstract class SportsClub {
	private String name;
	private String location;
	
	public SportsClub(String name, String location){
		this.name = name;
		this.location = location;
	}
	
	public String getName(){
		return name;
	}
	
	public String getLocation(){
		return location;
	}
	
	public void displayStatistics(){}
}
