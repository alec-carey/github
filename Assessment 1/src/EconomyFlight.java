import java.util.Date;


public class EconomyFlight extends Flight{
	EconomyFlight(String newOrigin, String newDestination, Date newDate, int newEtd, int newEta, double newBasePrice, double newConcession) {
		super(newOrigin, newDestination, newDate, newEtd, newEta, newBasePrice, newConcession);
		// TODO Auto-generated constructor stub
	}

	
	final double groupDiscount = 0.80; 		// this is the discount applied to customers who book more than 4 seats
	
	public double book(Customer c){
		
		double price;
		// get the total of seats from customer object
		int totalSeats = c.getAdultSeats() + c.getChildSeats();
		// this will calculate the total with discount if more than 4 seats are booked
		if (totalSeats > 4){
			price = (totalSeats * basePrice) + ((totalSeats - 4) * basePrice * groupDiscount);
		}
		// without discount
		else price = totalSeats * basePrice;
		// add the number of flights and new cost to customer object
		int numFlights  = c.numFlights + 1;
		double newCost = c.getCost() + price;
		// updates customer values accordingly
		c.setCost(newCost);
		c.setNumFlight(numFlights);
		return price;
	}
}
