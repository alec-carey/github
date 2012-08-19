// import java.io.BufferedWriter;
// import java.io.File;
// import java.io.FileWriter;
// import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Flight {
	
	int flightNumber;
	String origin;
	String destination;
	Date date;
	int etd;
	int eta;
	double basePrice;
	double concession;
	static List<Movie> flightMovies = new ArrayList<Movie>();
	
	Flight(String newOrigin, String newDestination, Date newDate, int newEtd, int newEta, double newBasePrice, double newConcession){
		//constructor
		flightNumber = generateFlightNumber();
		origin = newOrigin;
		destination = newDestination;
		date = newDate;
		etd = newEtd;
		eta = newEta;
		basePrice = newBasePrice;
		concession = newConcession;
		
	}
	
	private int generateFlightNumber() {
		/* generates a unique hash which is used for 'id' and is dependent the
		 * attributes of the flight
		 */
	    StringBuilder builder = new StringBuilder();
	    builder.append(origin);
	    builder.append(destination);
	    builder.append(date);
	    builder.append(etd);
	    builder.append(eta);
	    return (builder.toString().hashCode()) * -1;
	}
	
	public static void addMovie(Movie movie){
		flightMovies.add(movie);
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

