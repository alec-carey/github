import java.util.Arrays;

public class House{
	int numRooms;
	int numBathrooms;
	boolean hasYard;
	String roofMaterial;
	double[] gpsCoords = new double[7];
	
	// Default house constructor with 3 bedrooms, 1 bath, tiled roof and yard
	House(){
		numRooms = 3;
		numBathrooms = 1;
		hasYard = true;
		roofMaterial = "tile";
	}
	
	// Constructor with user values
	House(int newRooms, int newBathrooms, boolean newHasYard, String newRoofMaterial, double[] newGpsCoords){
		numRooms = newRooms;
		numBathrooms = newBathrooms;
		hasYard = newHasYard;
		roofMaterial = newRoofMaterial;
		gpsCoords = newGpsCoords;
	}
	public double getDistance(double[] points){
		/* We're using the good ol' variant of the Pythagorean Theorem known as the distance formula
		 * without using the Point class. We could I guess, but I did that in the last subject and I 
		 * thought this would be fun!
		 */
		//line 1
		double x1 = points[0] ;
		double y1 = points[1];
		//line 2
		double x2 = points[2];
		double y2 = points[3];
		// find the distance here using Pythagoras
		double lineDistance = Math.sqrt((Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
		return lineDistance;
	}
	
	public double getPerimeter(){
		/* for this method we get the coords values out of the array given to us
		 * and use them as x and y coordinates. We then put them into a smaller array
		 * and ship them off to getDistance which should give us the distance between the
		 * two points. Then it's just a matter of finding the perimeter by adding them together
		 */
		// note that copyOfRange will copy up to n-1
		double[] line1 = Arrays.copyOfRange(gpsCoords, 0, 4);
		double[] line2 = Arrays.copyOfRange(gpsCoords, 2, 6);
		double[] line3 = Arrays.copyOfRange(gpsCoords, 4, 8);
		// this one was annoying because the points were not in order
		double[] line4 = {gpsCoords[0], gpsCoords[1], gpsCoords[6], gpsCoords[7]};
		// We use the getDistance method to find the distance between two points here for each line
		double distance1 = getDistance(line1);
		double distance2 = getDistance(line2);
		double distance3 = getDistance(line3);
		double distance4 = getDistance(line4);
		return distance1 + distance2 +distance3 + distance4;
	}
	public double getArea(){
		/* This finds the area of a any polygon given 4 (x, y) coordinates in an array (gpsCoord[])
		 *  It was done this way because most lots are irregular polygons. http://www.mathopenref.com/coordpolygonarea.html
		 *  is a good resource for finding an array given coordinates.
		 */
		double area = (((gpsCoords[0] * gpsCoords[3]) - (gpsCoords[1] * gpsCoords[2]))  + ((gpsCoords[2] * gpsCoords[5]) - (gpsCoords[3] *  gpsCoords[4])) + ((gpsCoords[4] * gpsCoords[7]) - (gpsCoords[5] *  gpsCoords[6])) + ((gpsCoords[6] * gpsCoords[1]) - (gpsCoords[7] *  gpsCoords[0]))) /2;
		if (area < 0)
			return area * -1;	
		else return area;
	}
	public double[] getLine1(){
		double[] line1 = {gpsCoords[0], gpsCoords[1], gpsCoords[6], gpsCoords[7]};
		return line1;
	}
	public double getCost(){
		double price = 2000000;
		if (hasYard = true)
			price = price + 14000;
		if (numRooms >= 3)
			price = price + (numRooms * 8000);
		if (numBathrooms >= 1)
			price = price + (numBathrooms * 7000);
		return price;
	}
}
