
/**
 * The movie class describes a simple object that has a name and 
 * run length. It is used in the flight class and added to an arrayList
 * when needed.
 * @author Alec
 *
 */
public class Movie {
	String name;
	int length;
	//constructor
	Movie(String newName, int newLength){
		name = newName;
		length = newLength;
	}
	
	public String getName(){
		return name;
	}
	
	public int getLength(){
		return length;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setLength(int length){
		this.length = length;
	}
}
