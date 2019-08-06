/**
 * This abstract class holds the name of the airline and holds abstract methods pertaining to
 * reserving seats in an airline's plane.
 * @author Shakeel Khan
 * Date: 06/05/2016
 */

abstract public class Airline {
	
	protected String airlineName;
	
	abstract public Seat reserveFirstClass(Flight aFlight, SeatType aSeatType);
	abstract public Seat reserveEconomy(Flight aFlight, SeatType aSeatType);
		
	//Get and set methods for the airline name.
	public String getAirlineName()
	{
		return this.airlineName;
	}
	
	public void setAirlineName(String name)
	{
		this.airlineName = name;
	}
	
	public String toString()
	{
		return airlineName+" Airlines";
	}
}
