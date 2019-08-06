/**
 * This class holds details about flights.
 * It also enables the flight details to be appropriately printed. 
 * @author Shakeel Khan
 * Date: 06/05/2016
 *  
 */
public class Flight {
	private String startCity;
	private String destCity;
	private String deptTime;
	private String flightNum;
	private SeatMap flightSeatMap;
	
	/**
	 * This is the constructor for a Flight object. It allows the initial values to be updated
	 * @param start
	 * @param destination
	 * @param deptTime
	 * @param flightNum
	 * @param flightSeatMap
	 */
	public Flight(String start, String destination, String deptTime, String flightNum, SeatMap flightSeatMap)
	{
		this.startCity = start;
		this.destCity = destination;
		this.deptTime = deptTime;
		this.flightNum = flightNum;
		this.setFlightSeatMap(flightSeatMap);
	}
	
	// Get and set methods for the starting city
	public String getStartCity() 
	{
		return startCity;
	}
	
	public void setStartCity(String startCity) 
	{
		this.startCity = startCity;
	}

	//Get and set methods for the destination
	public String getDestCity() 
	{
		return destCity;
	}

	public void setDestCity(String destCity) 
	{
		this.destCity = destCity;
	}

	//Get and set methods for the departure time
	public String getDeptTime() 
	{
		return deptTime;
	}

	public void setDeptTime(String deptTime) 
	{
		this.deptTime = deptTime;
	}

	//Get and set methods for the flight number
	public String getFlightNum() 
	{
		return flightNum;
	}

	public void setFlightNum(String flightNum) 
	{
		this.flightNum = flightNum;
	}

	//Get and set methods for the seatmap.
	public SeatMap getFlightSeatMap() 
	{
		return flightSeatMap;
	}

	public void setFlightSeatMap(SeatMap flightSeatMap) 
	{
		this.flightSeatMap = flightSeatMap;
	}
	
	public String toString()
	{
		return "flight: "+this.flightNum+" from "+this.startCity+" to "+this.destCity+". Departure time is: "+this.deptTime;
	}
}
