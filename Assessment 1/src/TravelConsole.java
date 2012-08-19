import java.io.IOException;
import java.util.Scanner;
public class TravelConsole {
	// create a scanner for use in this class
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException{
		// user interface here
		TravelAgent agent = new TravelAgent(getAgentName());
		System.out.println(agent.name);
		int userChoice = mainMenu(agent);
		if (userChoice == 1) {
			addMenu(agent);
		}
		else if (userChoice == 2){
			listMenu(agent);
		}
		else if (userChoice == 3){
			deleteMenu(agent);
		}
		else if (userChoice == 4){
			bookMenu(agent);
		}
		
	}
	
	public static String getAgentName(){
		System.out.print("Please enter travel agent name to begin... >>: ");
		return input.nextLine();
	}
	public static int mainMenu(TravelAgent agent){
		int userChoice = 0;
		System.out.print("---- Travel Console - " + agent.name + " Main Menu ----" + "\n" +
						 "1) Add a new customer/flight/movie \n" +
						 "2) List a customer/flgiht/movie \n" +
						 "3) Delete a customer/flight/movie \n" +
						 "4) Book a flight for a customer \n" + 
						 "5) Quit \n" +
						 ">>: ");
		
		userChoice = input.nextInt();
		return userChoice;
		
	}
	
	public static int addMenu(TravelAgent agent){
		System.out.print("---- Travel Console - " + agent.name + " Add Menu ----" + "\n" +
						"1) Add a new customer \n" +
						"2) Add a new flight \n" +
						"3) Add a new movie \n" +
						"4) Return to main menu \n" +
						">>: ");
		int userChoice = input.nextInt();
		return userChoice;
	}
	public static int listMenu(TravelAgent agent){
		System.out.print("---- Travel Console - " + agent.name + " List Menu ----" + "\n" +
						"1) List customers \n" +
						"2) List flights \n" +
						"3) List movies \n" +
						"4) Return to main menu \n" +
						">>: ");
		int userChoice = input.nextInt();
		return userChoice;
	}
	public static int deleteMenu(TravelAgent agent){
		System.out.print("---- Travel Console - " + agent.name + " List Menu ----" + "\n" +
						"1) Delete customers \n" +
						"2) Delete flights \n" +
						"3) Delete movies \n" +
						"4) Return to main menu \n" + 
						">>: ");
		int userChoice = input.nextInt();
		return userChoice;
	}	
	
	public static int bookMenu(TravelAgent agent){
			System.out.print("---- Travel Console - " + agent.name + " Booking Menu ----" + "\n" +
					"1)  \n" +
					"2) List flights \n" +
					"3) List movies \n" +
					"4) Return to main menu \n" +
					">>: ");
			int userChoice = input.nextInt();
			return userChoice;
		}
	
}
	

