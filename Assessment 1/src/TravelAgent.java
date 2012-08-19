import java.util.ArrayList;
import java.util.List;


public class TravelAgent {
	String name;
	List<Customer> customerList = new ArrayList<Customer>();
	List<BusinessFlight> businessFlightList = new ArrayList<BusinessFlight>();
	List<EconomyFlight> economyFlightList = new ArrayList<EconomyFlight>();
	
	TravelAgent(String agentName){
	//Constructor
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
	
	//lets create stuff
	public void createCustomer(Customer c){
		customerList.add(c);
	}
	
	public void createEconomyFlight(EconomyFlight e){
		economyFlightList.add(e);
	}
	
	public void createBusinessFlight(BusinessFlight b){
		businessFlightList.add(b);
	}
	
	public void createMovie(Movie m){
		Flight.addMovie(m);
	}
	
	// lets remove stuff
	public void removeCustomer(Customer c){
		customerList.remove(c);
	}
	
	public void removeEconomyFlight(EconomyFlight e){
		economyFlightList.remove(e);
	}
	
	public void removeBusinessFlight(BusinessFlight b){
		businessFlightList.remove(b);
	}
	
}
