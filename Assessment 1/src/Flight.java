// import java.io.BufferedWriter;
// import java.io.File;
// import java.io.FileWriter;
// import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * Flight is a superclass which helps define what a flight needs. It includes a generated id number.
 * a list of movies and details such as arrival and departure. The abstract method tells sub classes that
 * it must have a book method in order to be used.
 * @author Alec Carey
 *
 */
public abstract class Flight {
	
	final int flightNumber;
	String origin;
	String destination;
	Date date;
	int etd;
	int eta;
	double basePrice;
	double concession;
	List<Movie> flightMovies = new ArrayList<Movie>();
	static int c = 1; //used to increment id number
	
	Flight(String newOrigin, String newDestination, Date newDate, int newEtd, int newEta, double newBasePrice, double newConcession){
		//constructor
		flightNumber = c++;
		origin = newOrigin;
		destination = newDestination;
		date = newDate;
		etd = newEtd;
		eta = newEta;
		basePrice = newBasePrice;
		concession = newConcession;
		
	}
	/**
	 * adds a movie to the list of the flight. 
	 * @param movie	
	 */
	public void addMovie(Movie movie){
		flightMovies.add(movie);
	}
	public int getFlightNumber(){
		return flightNumber;
	}
	
	public abstract double book(Customer c);
	
/*	This stuff is for assessment 2 (as I didn't read that we didn't need to do this until later)
	public void writeFlightFile() throws IOException {
			/* Creates and writes flights.csv with formatting
			 * It creates the file if it doesn't exist, and puts
			 * in headings of each attribute. If the file exists
			 * it simply appends the next customer entry

			File flightTest = new File("flighttest.csv");
			if (flightTest.exists()) {
				flightTest.createNewFile();
				FileWriter fw = new FileWriter(flightTest, true);
				BufferedWriter out = new BufferedWriter(fw);
				out.append(String.valueOf(flightNumber));
				out.append(", ");
				out.append(origin);
				out.append(", ");
				out.append(destination);
				out.append(", ");
				out.append(String.valueOf(date));
				out.append(", ");
				out.append(String.valueOf(etd));
				out.append(", ");
				out.append(String.valueOf(eta));
				out.append(",");
				out.append(String.valueOf(basePrice));
				out.append(",");
				out.append(String.valueOf(concession));
				out.append("\n");
				out.close();
			} 
			else {
				FileWriter fw = new FileWriter(flightTest);
				BufferedWriter out = new BufferedWriter(fw);
				 // headers for csv file if it doesn't exist already
				out.write("Flight Number");
				out.write(", ");
				out.write("Origin");
				out.write(", ");
				out.write("Destination");
				out.write(", ");
				out.write("Date");
				out.write(", ");
				out.write("Estimated Departure");
				out.write(", ");
				out.write("Estimated Arrival");
				out.write(", ");
				out.write("Base Price");
				out.write(", ");
				out.write("Concession");
				out.write(", ");
				out.write("\n");
				out.append(String.valueOf(flightNumber));
				out.append(", ");
				out.append(origin);
				out.append(", ");
				out.append(destination);
				out.append(", ");
				out.append(String.valueOf(date));
				out.append(", ");
				out.append(String.valueOf(etd));
				out.append(", ");
				out.append(String.valueOf(eta));
				out.append(",");
				out.append(String.valueOf(basePrice));
				out.append(",");
				out.append(String.valueOf(concession));
				out.append("\n");
				out.close();
				
			}
	}
*/	

}

