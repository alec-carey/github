import java.util.Date;


public class BusinessFlight extends Flight {

	BusinessFlight(String newOrigin, String newDestination, Date newDate, int newEtd, int newEta, double newBasePrice, double newConcession) {
		super(newOrigin, newDestination, newDate, newEtd, newEta, newBasePrice, newConcession);
	}
	double rate = 3.1;		//sstandard rate here
	/**
	 * This method calculates and returns the price of a customer 'c'.
	 */
	public double book(Customer c){
		double price = (rate * c.adultSeats * this.basePrice) + (rate * c.childSeats * this.concession * this.basePrice); //Formula used to calculate price
		// adds one to flights for customer total and gets new cost
		int numFlights  = c.numFlights + 1;		//tells how many flights a customer has taken
		double newCost = c.getCost() + price;
		// updates customer values accordingly
		c.setCost(newCost);
		c.setNumFlight(numFlights);
		// return the price
		return price;	
	}
	

}