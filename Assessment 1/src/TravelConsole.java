import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
/**
 * TravelConsole is a somewhat cumbersome class which displays console
 * output and accepts console input for the Travel Agent booking system.
 * You can maintain lists of customers, business flight, economy flights
 * and movies from this interface. You can also book flights, which calculates
 * the cost of a flight for a customer. It uses prompts to move from menu to
 * menu.
 * 
 * @author Alec Carey
 * @version 1.0
 * 
 */
public class TravelConsole {
	// create a scanner for use in this class. This is gonna get a floggin.
	static Scanner input = new Scanner(System.in);
	
	/**
	 * Main method which creates a new TravelAgent, creates some test data and calls mainMenu to initiate the mainMenu
	 * with TravelAgent object.
	 * 
	 * @param args
	 * @throws IOException
	 * @throws ParseException
	 */
	
	public static void main(String[] args) throws IOException, ParseException{
		System.out.print("Please enter travel agent name to begin... >>: ");
		TravelAgent agent = new TravelAgent(input.nextLine());
		// Test data starts here
		agent.createCustomer(new Customer("Alec Carey", 3, 2));
		agent.createCustomer(new Customer("Mr Bean   ", 1, 0));
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		BusinessFlight b = new BusinessFlight("Australia", "New Zealand", sdf.parse("14/05/2012"), 940, 1050, 1500, 0.50);
		EconomyFlight e = new EconomyFlight("Australia", "USA", sdf.parse("12/06/2012"), 630, 2250, 8500, 0.40);
		agent.createBusinessFlight(b);
		agent.createEconomyFlight(e);
		b.addMovie(new Movie("Superman 5", 130));
		e.addMovie(new Movie("The Matrix", 145));
		//test data ends here. 
		mainMenu(agent);		//calls main menu
	}
	/**
	 * mainMenu method is the main menu which connects all other
	 * methods in this class. It lists the options you can choose from
	 * and entering the corresponding number will perform that action
	 * @param agent
	 * 
	 */
	public static void mainMenu(TravelAgent agent){
		int userChoice = 0;
		System.out.print("---- Travel Console - " + agent.name + " - Main Menu ----" + "\n" +
						 "1) Add a new customer/flight/movie \n" +
						 "2) List a customer/flight/movie \n" +
						 "3) Delete a customer/flight/movie \n" +
						 "4) Book a flight for a customer \n" + 
						 "5) Quit \n" +
						 ">>: ");
		
		userChoice = input.nextInt();
		// if statement for menu choices
		if (userChoice == 1) {
			addMenu(agent);		//go to add object sub menu
		}
		else if (userChoice == 2){
			listMenu(agent);	// go to list object sub menu
		}
		else if (userChoice == 3){
			deleteMenu(agent);	// go to delete object sub menu
		}
		else if (userChoice == 4){
			bookMenu(agent);	// go to booking menu
		}
		else if (userChoice == 5){
			System.exit(0);		// quit system
		}
		
	}
	/**
	 * addMenu is a sub menu that will take the user to the appropriate add method.
	 * @param agent
	 * 
	 */
	public static void addMenu(TravelAgent agent){
		System.out.println("---- Travel Console - " + agent.name + " - Add Menu ----" + "\n" +
						"1) Add a new customer \n" +
						"2) Add a new flight \n" +
						"3) Add a new movie \n" +
						"4) Return to main menu \n" +
						">>: ");
		int userChoice = input.nextInt();
		if (userChoice == 1) {
			addCustomer(agent);		
		}
		else if (userChoice == 2){
			addFlight(agent);
		}
		else if (userChoice == 3){
			addMovie(agent);
		}
		else if (userChoice == 4){
			mainMenu(agent);
		}
	}
	/**
	 * addCustomer allows the user to add a customer to a TravelAgent's customer list
	 * @param agent
	 */
	public static void addCustomer(TravelAgent agent){
		System.out.println(" ---- Add Customer ---- \n" +
						"Please enter in customer name >>: ");
		input.nextLine();
		String name = input.nextLine();
		System.out.print("Please enter the number of child seats >>: ");
		int numChildSeats = input.nextInt();
		System.out.print("Please enter the number of adult seats >>: ");
		int numAdultSeats = input.nextInt();
		// create new customer from input to new customer object
		Customer customer = new Customer(name, numChildSeats, numAdultSeats);
		// calls the method to add the newly created customer to current list
		agent.createCustomer(customer);
		// output confirmation
		System.out.println("Added customer " + customer.name + " to list. Return to menu...");
		System.out.println();
		// back to add menu
		addMenu(agent);
		
	}
	/**
	 * addFlight allows the user to add either a business flight or a economy flight to a trvaelAgent's flight list.
	 * It uses SimpleDateFormat to format user input and passes through all details of a flight to either a business list
	 * or a economy list
	 * @param agent
	 */
	public static void addFlight(TravelAgent agent){
		System.out.print(" ---- Add Flight ---- \n" + 
						"1) Add a Business Flight \n" +
						"2) Add a Economy Flight \n" +
						">>:");
		int menuChoice = input.nextInt();
		// inputs for flight here
		System.out.print("Please enter in the flight's origin >>: ");
		input.nextLine();
		String origin = input.nextLine();
		System.out.print("Please enter in the flight's destination >>: ");
		String destination = input.nextLine();
		System.out.print("Please enter in the date in dd/mm/yyyy format >>: ");
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		try {
			date = sdf.parse(input.nextLine());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.print("Please enter in etd: (eg: 930 for 9:30 AM >>: ");
		int etd = input.nextInt();
		System.out.print("Please enter in eta: (eg: 1700 for 5:00 PM >>: ");
		int eta = input.nextInt();
		System.out.print("Please enter in the base price for this flight >>: ");
		double basePrice = input.nextDouble();
		System.out.print("Please enter in the concession rate (eg: 0.50 for 50%) >>: ");
		double concession = input.nextDouble();
		// this will create the corresponding flight depending on the menu choice above
		if (menuChoice == 1){
			BusinessFlight flight = new BusinessFlight(origin, destination, date, etd, eta, basePrice, concession);
			agent.createBusinessFlight(flight);			//calls method to add to list
			System.out.print("Added flight number " + flight.flightNumber + " to system");
		}
		if (menuChoice == 2){
			EconomyFlight flight = new EconomyFlight(origin, destination, date, etd, eta, basePrice, concession);
			agent.createEconomyFlight(flight);			// calls method to add to list
			System.out.print("Added flight number " + flight.flightNumber + " to system");
		}
		System.out.println();
		addMenu(agent);
			
	}
	/**
	 * addMovie allows users to add a movie to a flight, as long as there is at least one flight in the system.
	 * The user enters the name and length, and chooses the flight number to attach the movie to. A flight can
	 * have as many movies as required and is maintained in the flight classes.
	 * @param agent
	 */
	public static void addMovie(TravelAgent agent){
		System.out.print("Plese enter in movie name: ");
		input.nextLine();
		String name = input.nextLine();
		System.out.print("Please enter in movie running time in minutes: ");
		int length = input.nextInt();
		// create a movie object that can be added to a flight
		Movie m = new Movie(name, length);
		// tests if there is any flights and alerts if there isn't
		if (agent.economyFlightList.isEmpty() && agent.businessFlightList.isEmpty()){
			System.out.println("Sorry - No Flights available to add, please add a flight to continue...");
			addFlight(agent);
		}
		System.out.print("Please enter in the flight ID to add this movie to the flight : ");
		int id = input.nextInt();
		// for every business flight within the Travel Agent add the created movie object into the matching flight
		for (BusinessFlight b: agent.businessFlightList){
			if(b.getFlightNumber() == id){
				b.addMovie(m);
				System.out.print("Added to Business Flight " + id);
			}
		}
		// we must repeat for the economy class as well to check for both
		for (EconomyFlight e: agent.economyFlightList){
			if(e.getFlightNumber() == id){
				e.addMovie(m);
				System.out.print("Added to Economy Flight " + id);
			}
		}
		System.out.println();
		addMenu(agent);
	}
	/**
	 * List menu for listing all the objects. User enters in the choice and the
	 * corresponding method will display what the user chooses 
	 * @param agent
	 * @return
	 */
	public static int listMenu(TravelAgent agent){
		System.out.print("---- Travel Console - " + agent.name + " - List Menu ----" + "\n" +
						"1) List customers \n" +
						"2) List flights \n" +
						"3) List movies \n" +
						"4) Return to main menu \n" +
						">>: ");
		int userChoice = input.nextInt();
		if (userChoice == 1) {
			listCustomers(agent);
		}
		else if (userChoice == 2){
			listFlights(agent);
		}
		else if (userChoice == 3){
			listMovies(agent);
		}
		else if (userChoice == 4){
			mainMenu(agent);
		}
		return userChoice;
	}
	/**
	 * listCusomters iterates over the customer list within the TravelAgent object and
	 * prints them out for the user in a somewhat crappy spaced out fashion
	 * @param agent
	 */
	private static void listCustomers(TravelAgent agent) {
		System.out.println("Listing customers...");
		System.out.println("ID: \t Name: \t Child Seats: \t Adult Seats: \t Cost:");
		// for every element of the list print them out here
		for (Customer c: agent.customerList){
			System.out.println(c.getId() + "\t" + c.getName() + "\t" + c.getChildSeats() + "\t\t" + c.getAdultSeats() + "\t\t" + c.getCost());
		}
		listMenu(agent);
	}
	/**
	 * listMovies lists all movies for business and economy flights. It goes over both
	 * types of flights using for loops in sequence. 
	 * @param agent
	 */
	private static void listMovies(TravelAgent agent) {
		System.out.println("Listing movies...");
		System.out.println("Flight Id \t Name \t\t Run Length");
		for (BusinessFlight b: agent.businessFlightList){
			System.out.print(b.flightNumber + "\t");
			for (Movie m: b.flightMovies){
				System.out.print(m.name + "\t" + m.length + "\n");			// outputs the movie
			}
		}
		for (EconomyFlight e: agent.economyFlightList){
			System.out.print(e.flightNumber + "\t");
			for (Movie m: e.flightMovies){
				System.out.print(m.name + "\t" + m.length + "\n");			// outputs the movie
			}
		}
		System.out.println();
		listMenu(agent);
		
	}
	/**
	 * listFlights is similar to movies except that it lists the attributes of the flight itself.
	 * It goes through two for loops, one for each flight type.
	 * @param agent
	 */
	private static void listFlights(TravelAgent agent) {
		System.out.println("Listing flights:");
		// business flight loop
		for (BusinessFlight b : agent.businessFlightList){
			System.out.println(b.flightNumber + "\t" + b.origin + "\t" + b.destination + "\t" + b.etd + "\t" + b.eta + "\t" + b.basePrice + "\t" + b.concession + "\t Business Flight");
		}
		// economy flight loop
		for (EconomyFlight e : agent.economyFlightList){
			System.out.println( e.flightNumber + "\t" + e.origin + "\t" + e.destination + "\t" + e.etd + "\t" + e.eta + "\t" + e.basePrice + "\t" + e.concession + "\t Economy Flight" );
		}
		listMenu(agent);
	}
	/**
	 * Delete menu manages all delete actions a user can perform. The menu asks for an option 
	 * and the rest of the users choice is done under the corresponding if statement.
	 * @param agent
	 */
	public static void deleteMenu(TravelAgent agent){
		System.out.print("---- Travel Console - " + agent.name + " - Delete Menu ----" + "\n" +
						"1) Delete customers \n" +
						"2) Delete flights \n" +
						"3) Delete movies \n" +
						"4) Return to main menu \n" + 
						">>: ");
		int userChoice = input.nextInt();
		//delete customers statements here
		if (userChoice == 1){
			System.out.print("Please enter in customer ID to delete: >>:  ");
			int deleteID = input.nextInt();
			for (Customer c : agent.customerList){
				if (deleteID == c.getId()){
					Customer customer = c;											//gets customer id from list for deletion
					System.out.println("Record found!");
					System.out.println(customer.getId() + "\t" + customer.getName() + "\t" + customer.getChildSeats() + "\t" + customer.getAdultSeats() + "\t" + customer.getCost());
					System.out.print("Do you wish to delete? y for yes: >>: ");		//prompts user to delete
					String delChoice = input.next();
					if (delChoice.equalsIgnoreCase("y")){
						agent.customerList.remove(customer);						//removes selected customer here
						System.out.println("Deleted...");
						deleteMenu(agent);
					}
					else mainMenu(agent);
				}
				else System.out.println("No record found.");
				deleteMenu(agent);
			}
		}
		//delete flights here
		else if (userChoice == 2){
			System.out.print("Please enter in Flight number to delete >>: ");
			int deleteID = input.nextInt();
			//need to check both business and economy again. Business is here.
			for (BusinessFlight b : agent.businessFlightList){
				if (deleteID == b.getFlightNumber()){
					BusinessFlight business = b;
					System.out.println("Records Found!");
					System.out.println(business.flightNumber + "\t" + business.origin + "\t" + business.destination);	//prints out flights details to verify
					System.out.println("This flight has " + business.flightMovies.size() + " movies. Do you wish to delete? y for yes: >>: ");	//asks for verification
					String delChoice = input.next();
					if (delChoice.equalsIgnoreCase("y")){
						agent.businessFlightList.remove(business);	//deletes here
						System.out.println("Deleted...");
						deleteMenu(agent);
					}
					else mainMenu(agent);
				}
			}
			//economy deletion here
			for (EconomyFlight e : agent.economyFlightList){
				if (deleteID == e.getFlightNumber()){
					EconomyFlight economy = e;
					System.out.println("Records Found!");
					System.out.println(economy.flightNumber + "\t" + economy.origin + "\t" + economy.destination);
					System.out.println("This flight has " + economy.flightMovies.size() + " movies. Do you wish to delete? y for yes: >>: ");
					String delChoice = input.next();
					if (delChoice.equalsIgnoreCase("y")){
						agent.economyFlightList.remove(economy);		//delete flight here
						System.out.println("Deleted...");
						deleteMenu(agent);
					}
					else mainMenu(agent);
				}
			}
		}
		// movie deletion here
		else if (userChoice == 3){
			System.out.print("Please enter in the name of the Movie to delete >>: ");
			input.nextLine();
			String delName = input.nextLine();
			// we need two for loops here, one to iterate business flights in agent, and one to iterate movies in business flights 
			for (BusinessFlight b: agent.businessFlightList){
				for (Movie m: b.flightMovies){
					Movie movie = m;
					if (delName.equalsIgnoreCase(m.getName())){
						System.out.print(m.name + "\t" + m.length + "\n");
						System.out.print("Do you wish to delete? y for yes:>> ");
						String delChoice = input.next();
						if (delChoice.equalsIgnoreCase("y")){
							b.flightMovies.remove(movie);		//deletion here
							System.out.println("Deleted...");
							deleteMenu(agent);
						}
					}	
				}
			}
			// same as above but economy
			for (EconomyFlight e: agent.economyFlightList){
				for (Movie m: e.flightMovies){
					Movie movie = m;
					if (delName.equalsIgnoreCase(m.getName())){
						System.out.print(m.name + "\t" + m.length + "\n");
						System.out.print("Do you wish to delete? y for yes:>> ");
						String delChoice = input.next();
						if (delChoice.equalsIgnoreCase("y")){
							e.flightMovies.remove(movie);
							System.out.println("Deleted...");
							deleteMenu(agent);
							
						}
						else deleteMenu(agent);
					}
				}
			}
		}
		else if (userChoice == 4){
			mainMenu(agent);
		}
	}	
	/**
	 * Book menu allows the user to book a flight by running the book method of an economy flight or
	 * a business flight. the book function calculates prices differently.
	 * @param agent
	 */
	public static void bookMenu(TravelAgent agent){
		//print out menu - 2 goes back to main
		System.out.print("---- Travel Console - " + agent.name + " -  Booking Menu ----" + "\n" +
						"1) Book a customer to a flight \n" +
						"2) Return to main menu \n" +
						">>: ");
		if (input.nextInt() == 2){
			mainMenu(agent);
		}
		System.out.print("Please enter in a customer ID >>: ");
		int customerId = input.nextInt();
		// this part searches for a customer in customer list and prints it out.
		for (Customer c : agent.customerList){
			if (customerId == c.getId()){
				Customer customerToBook = c;		//this is the customer object we need to book
				System.out.println("Customer chosen:\n" + c.getId() + "\t" + c.getName() + "\t" + c.getChildSeats() + "\t\t" + c.getAdultSeats() + "\t\t" + c.getCost());
				System.out.print("2) Please choose a flight ID >>:");
				int flightId = input.nextInt();
				//if the flight is business type this, otherwise it goes to economy loop below
				for (BusinessFlight b: agent.businessFlightList){
					if (flightId == b.getFlightNumber()){
						System.out.println("Flight chosen: \n" + b.flightNumber + "\t" + b.origin + "\t" + b.destination + "\t" + b.etd + "\t" + b.eta + "\t" + b.basePrice + "\t" + b.concession + "\t Business Flight");
						System.out.print("Is this correct? (y to book!) >>:");
						if (input.next().equalsIgnoreCase("y")){
							b.book(customerToBook);			//runs book method here
							System.out.println("Booked!!");
							mainMenu(agent);
						}
					
					}
				}
				// same as above but for economy
				for (EconomyFlight e : agent.economyFlightList){
					if (flightId == e.getFlightNumber()){
						System.out.println( "Flight chosen: \n " + e.flightNumber + "\t" + e.origin + "\t" + e.destination + "\t" + e.etd + "\t" + e.eta + "\t" + e.basePrice + "\t" + e.concession + "\t Economy Flight" );
						System.out.print("Is this correct? (y to book!) >>:");
						if (input.next().equalsIgnoreCase("y")){
							e.book(customerToBook);
							System.out.println("Booked!!");
							mainMenu(agent);
						}	
					}	
				}
			}
		}
		bookMenu(agent);
	}
}
	

