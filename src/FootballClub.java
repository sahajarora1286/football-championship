
public class FootballClub extends SportsClub {

	private int nWins;
	private int nDraws;
	private int nDefeats;
	private int nGoalsReceived;
	private int nGoalsScored;
	private int nPoints, nMatches;
	
	public FootballClub(String name, String location) {
		super(name, location);
		nWins = 0; nDraws = 0; nDefeats = 0; nGoalsReceived = 0;
		nGoalsScored = 0; nPoints = 0; nMatches = 0;
		
	}
	
	public void addMatch(){
		nMatches++;
	}
	
	public void addGoalsReceived(int goals){
		nGoalsReceived+= goals;
	}
	
	public void addGoalsScored(int goals){
		nGoalsScored += goals;
	}
	
	public void addWin(){
		nWins++;
		nPoints+= 3; //3 points awarded if won a match
	}
	
	public void addDraw(){
		nDraws++;
		nPoints++; //1 point awarded for a draw
	}
	
	public void addDefeats(){
		nDefeats++; 
		//No points for defeats
	}
	
	public int getnWins() {
		return nWins;
	}

	public int getnDraws() {
		return nDraws;
	}

	public int getnGoalsReceived() {
		return nGoalsReceived;
	}

	public int getnGoalsScored() {
		return nGoalsScored;
	}

	public void setnDefeats(int nDefeats) {
		this.nDefeats = nDefeats;
	}

	public int getPoints() {
		//number of matches played multiplied by number of points accumulated from wins and draws
		
		return nMatches * nPoints; 
	}

	public int getGoalsDifference(){
		return nGoalsScored - nGoalsReceived;
	}
	
	public int getnMatches() {
		return nMatches;
	}
	
	@Override
	public void displayStatistics(){
		System.out.println("");
		System.out.println("Club Name: " + super.getName());
		System.out.println("Club Location: " + super.getLocation());
		System.out.println("Points: " + nPoints);
		System.out.println("Wins: " + nWins);
		System.out.println("Draws: " + nDraws);
		System.out.println("Defeats: " + nDefeats);
		System.out.println("Goals scored: " + nGoalsScored);
		System.out.println("Goals received: " + nGoalsReceived);
		
	}
	
	
	@Override
	public String toString(){
		String temp = "";
		temp+= super.getName() + " (" + super.getLocation() + ")     Points: " + nPoints + "     Wins: " 
				+ nWins + "     Defeats: " + nDefeats + "     Goals Scored: " + nGoalsScored + "     Goals Received: "
				+ nGoalsReceived;
		return temp;
	}
	
}
