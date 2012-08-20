import java.util.ArrayList;
import java.util.List;
/**
 * Travel agent is a class which represents the travel agency as a whole.
 * It can store customers and flights once initiated. Additionally it can
 * add objects to its lists with some methods such as crateBusinessFlight.
 * @author Alec
 *
 */

public class TravelAgent {
	String name;
	// these lists will hold all customer and flight objects
	public List<Customer> customerList = new ArrayList<Customer>();
	public List<BusinessFlight> businessFlightList = new ArrayList<BusinessFlight>();
	public List<EconomyFlight> economyFlightList = new ArrayList<EconomyFlight>();
	
	TravelAgent(String agentName){
	// Constructor - only needs a name
		name = agentName;
	}
	
	// getters
	public String getNamne(){
			return name;
		}
	//setters
	public void setName(String name){
		this.name = name;
	}
	
	//we can use these methods to add to the list if we like - used for test data
	public void createCustomer(Customer c){
		customerList.add(c);
	}
	
	public void createEconomyFlight(EconomyFlight e){
		economyFlightList.add(e);
	}
	
	public void createBusinessFlight(BusinessFlight b){
		businessFlightList.add(b);
	}
	
	public void createBusinessMovie(Movie m, BusinessFlight b){
		b.addMovie(m);
	}
	public void createEconomyMovie(Movie m, EconomyFlight e){
		e.addMovie(m);
	}
	
	
}
