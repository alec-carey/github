import java.util.Date;


public class BusinessFlight extends Flight {

	BusinessFlight(String newOrigin, String newDestination, Date newDate, int newEtd, int newEta, double newBasePrice, double newConcession) {
		super(newOrigin, newDestination, newDate, newEtd, newEta, newBasePrice, newConcession);
	}
	double rate = 3.1;
	
	public double book(Customer c){
		/* This method calculates the price and updates the customer number of bookings and total cost
		 * 
		 */
		double price = (rate * c.adultSeats * this.basePrice) + (rate * c.childSeats * this.concession * this.basePrice);
		// adds one to flights for customer total and gets new cost
		int numFlights  = c.numFlights + 1;
		double newCost = c.getCost() + price;
		// updates customer values accordingly
		c.setCost(newCost);
		c.setNumFlight(numFlights);
		// return the price
		return price;	
	}
	

}