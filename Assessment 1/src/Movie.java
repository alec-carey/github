
public class Movie {
	String name;
	int length;
	
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
