
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class PremierLeagueManager implements LeagueManager {
	private List<FootballClub> clubsInLeague;
	private int input;

	public PremierLeagueManager(){
		clubsInLeague = new ArrayList<FootballClub>();
		input = 0;
	}


	private void validateInput(int input){
		Scanner reader = new Scanner(System.in);

		switch(input){
		case 1:
			System.out.println("Create and add a football club to the Premier League.");
			System.out.println("Please enter the name of the football club: ");
			String name = reader.nextLine();
			System.out.println("Please enter the location of the club: ");
			String location = reader.nextLine();
			createFootballClub(name, location);
			displayMenu();
			break;

		case 2:
			System.out.println("Delete an existing football club from the Premier League.");
			System.out.println("Please enter the name of the football club: ");
			String nameDelete = reader.nextLine();
			deleteFootballClub(nameDelete);
			displayMenu();
			break;

		case 3:
			System.out.println("Enter the name of the club: ");
			displayClubStatistics(reader.nextLine());
			displayMenu();
			break;

		case 4:
			if (clubsInLeague.size()==0){
				System.out.println("There are currently no clubs in the Premier League. Please add one first.");
			} else {
				displayLeagueTable();
			}
			displayMenu();
			break;

		case 5:
			System.out.println("Add a match.");
			System.out.println("Enter the name of the first football club in the match: ");
			String firstClub = reader.nextLine();
			if (!clubAlreadyExists(firstClub)){
				System.out.println("There is no such club in the league.");
				displayMenu();
				break;
			}
			getClubByName(firstClub).addMatch();

			System.out.println("Enter the name of the second football club in the match: ");
			String secondClub = reader.nextLine();
			if (secondClub.equals(firstClub)){
				System.out.println("A club cannot play against itself. Please try again.");
				displayMenu();
				break;
			}
			if (!clubAlreadyExists(firstClub)){
				System.out.println("There is no such club in the league. Please try again.");
				displayMenu();
				break;
			}

			getClubByName(secondClub).addMatch();
			System.out.println("Was it a draw? (y/n): ");
			String draw = reader.next();
			if (draw.equals("y") || draw.equals("Y")){
				getClubByName(firstClub).addDraw();
				getClubByName(secondClub).addDraw();
			}else if(draw.equals("n") || draw.equals("N")){
				reader.nextLine();
				System.out.println("Please enter the name of the winning club: ");
				String winningClub = reader.nextLine();
				
				if (!clubAlreadyExists(winningClub)){
					System.out.println("There is no such club in the league. Please try again.");
					displayMenu();
					break;
				} else {
					getClubByName(winningClub).addWin();
				}

				if (firstClub.equals(winningClub)){
					getClubByName(secondClub).addDefeats();
				} else {
					getClubByName(firstClub).addDefeats();
				}
			} else {
				System.out.println("Please enter valid input (No spaces).");
				displayMenu();
				break;
			}
		
			
			System.out.println("Please enter the number of goals scored by " + firstClub + ": ");
			int goalsScoredFirst = reader.nextInt();
			getClubByName(firstClub).addGoalsScored(goalsScoredFirst);
			getClubByName(secondClub).addGoalsReceived(goalsScoredFirst);

			System.out.println("Please enter the number of goals received by " + firstClub + ": ");
			int goalsRecFirst = reader.nextInt();
			getClubByName(firstClub).addGoalsReceived(goalsRecFirst);
			getClubByName(secondClub).addGoalsScored(goalsRecFirst);
			
			System.out.println("Match added.");

			displayMenu();
			break;


		default:
			System.out.println("Invalid input. Please try again.");
			displayMenu();
			break;

		}
	}


	private FootballClub getClubByName(String name){
		for (FootballClub club: clubsInLeague){
			if (club.getName().equals(name)){

				return club;
			}
		}
		return null;
	}


	public void displayMenu(){
		Scanner s = new Scanner(System.in);
		System.out.println("");
		System.out.println("---------------------------------");
		System.out.println("Premier League Manager");
		System.out.println("1. Create a new football club and add it in the Premier League.");
		System.out.println("2. Delete an existing football club.");
		System.out.println("3. Display statistics of a club.");
		System.out.println("4. Display the Premier League Table.");
		System.out.println("5. Add a played match.");
		System.out.println("Please choose from the options above (1/2/3...): ");
		try{
			validateInput(s.nextInt());
		} catch (InputMismatchException e){
			System.out.println("Invalid Input. Please enter only an integer from the choices.");
			displayMenu();
		}
		//s.close();

	}

	public void deleteFootballClub(String nameDelete) {
		// TODO Auto-generated method stub
		if (clubAlreadyExists(nameDelete)){
			clubsInLeague.remove(getClubByName(nameDelete));
			System.out.println("The club " + nameDelete + " was removed from the Premier League.");
		} else {
			System.out.println("No such club exists in the Premier League. Please try again.");
		}

	}

	private boolean clubAlreadyExists(String name){
		boolean alreadyExists = false;
		for (FootballClub club: clubsInLeague){
			if (club.getName().equals(name)){
				alreadyExists = true;
			}
		}
		return alreadyExists;
	}

	public void createFootballClub(String name, String location) {

		if (clubAlreadyExists(name)){
			System.out.println("The club with that name already exists. Please try again.");
		} else {
			clubsInLeague.add(new FootballClub(name, location));
			System.out.println("The club " + name + " was added to the Premier League.");
		}

	}


	public void displayClubStatistics(String name) {
		if (clubAlreadyExists(name)){
			getClubByName(name).displayStatistics();
		} else {
			System.out.println("There is no such club in the Premier League. Please try again.");
		}
	}


	public void displayLeagueTable() {
		Collections.sort(clubsInLeague, new ClubsPointsComparator());

		for (int j=0; j<clubsInLeague.size()-1;j++){
			//if points of this club and the next one are equal
			if (clubsInLeague.get(j).getPoints()==clubsInLeague.get(j+1).getPoints()){
				//if goal difference is less than that of the next element
				if (clubsInLeague.get(j).getGoalsDifference()<clubsInLeague.get(j+1).getGoalsDifference()){
					//swap the elements
					FootballClub club = clubsInLeague.get(j);
					clubsInLeague.set(j, clubsInLeague.get(j+1));
					clubsInLeague.set(j+1, club);
				}
				
			}
		}
		
		int i=1;
		for (FootballClub club: clubsInLeague){
			System.out.println(i + ". " + club);
			i++;
		}

	}

}

