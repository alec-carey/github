// import java.io.*
/**
 * Customer is a class that can hold a customer's details including the name
 * and the amount of seats they hold. There is not much to process here, just
 * values which are used in other classes.
 * @author Alec
 *
 */
public class Customer {
	final int id;
	String name;
	int childSeats;
	int adultSeats;
	int numFlights;
	double cost;
	static int c = 1;
	

	Customer(String newName, int newChildSeats, int newAdultSeats){
		// constructor 
		name = newName;
		childSeats = newChildSeats;
		adultSeats = newAdultSeats;
		id =c++;
	}
	
	//setters
	public void setNumFlight(int numFlights){
		this.numFlights = numFlights;
	}
	public void setCost(double newCost){
		this.cost = cost + newCost;
	}
	public void setChildSeats(int childSeats){
		this.childSeats = childSeats;
	}
	public void setAdultSeats(int adultSeats){
		this.adultSeats = adultSeats;
	}
	
	//getters
	public String getName(){
		return name;
	}
	public int getId(){
		return id;
	}
	public int getNumFlight(){
		return numFlights;
	}
	public double getCost(){
		return cost;
	}
	public int getChildSeats(){
		return childSeats;
	}
	public int getAdultSeats(){
		return adultSeats;
	}
/*	This stuff is for assessment 2 (as I didn't read that we didn't need to do this until later)
	public void writeCustomerFile() throws IOException {
		/* Creates and writes customer.csv with formatting
		 * It creates the file if it doesn't exist, and puts
		 * in headings of each attribute. If the file exists
		 * it simply appends the next customer entry
		 
		File customertest = new File("customertest.csv");
		if (customertest.exists()) {
			customertest.createNewFile();
			FileWriter fw = new FileWriter(customertest, true);
			BufferedWriter out = new BufferedWriter(fw);
			out.append(name);
			out.append(", ");
			out.append(String.valueOf(childSeats));
			out.append(", ");
			out.append(String.valueOf(adultSeats));
			out.append(", ");
			out.append(String.valueOf(numFlights));
			out.append(", ");
			out.append(String.valueOf(cost));
			out.append(", ");
			out.append(String.valueOf(id));
			out.append(",");
			out.append("\n");
			out.close();
		} 
		else {
			FileWriter fw = new FileWriter(customertest);
			BufferedWriter out = new BufferedWriter(fw);
			 // headers for csv file if it doesn't exist already
			out.write("Customer Name");
			out.write(", ");
			out.write("Child Seats");
			out.write(", ");
			out.write("Adults Seats");
			out.write(", ");
			out.write("Number of Flights");
			out.write(", ");
			out.write("Cost");
			out.write(", ");
			out.write("Customer ID");
			out.write(", ");
			out.write("\n");
			out.write(name);
			out.write(", ");
			out.write(String.valueOf(childSeats));
			out.write(", ");
			out.write(String.valueOf(adultSeats));
			out.write(", ");
			out.write(String.valueOf(numFlights));
			out.write(", ");
			out.write(String.valueOf(cost));
			out.write(", ");
			out.write(String.valueOf(id));
			out.write(",");
			out.write("\n");
			out.close();
			
		}
	}
*/
}
