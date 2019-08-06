/**
 * This class defines what an airline seat is. It sets whether a seat is first class or economy, 
 * if the seat is reserved, what kind of seat it is as well as what the position of the seat is in the 
 * seatmap.
 * @author Shakeel Khan
 * Date: 06/05/2016
 */

public class Seat {
	
	private boolean isReserved;
	private boolean isFirstClass;
	private SeatType seatType;
	private SeatPosition seatPos;
	
	/**
	 * This is the constructor for a Seat object.
	 * @param isReserved
	 * @param isFirstClass
	 * @param seatType
	 * @param seatPos
	 */
	public Seat(boolean isReserved, boolean isFirstClass, SeatType seatType, SeatPosition seatPos)
	{
		this.setReserved(isReserved);
		this.setFirstClass(isFirstClass);
		this.setSeatType(seatType);
		this.setSeatPosition(seatPos);
	}
	
	public Seat()
	{
		this.setReserved(false);
		this.setFirstClass(false);
		this.setSeatType(SeatType.UNKNOWN);
	    this.seatPos = null;
	}

	// Get and set methods for checking if seat is reserved
	public boolean isReserved() 
	{
		return this.isReserved;
	}

	public void setReserved(boolean isReserved) 
	{
		this.isReserved = isReserved;
	}
	// Get and set methods for checking if seat is first class
	public boolean isFirstClass() 
	{
		return this.isFirstClass;
	}

	public void setFirstClass(boolean isFirstClass) 
	{
		this.isFirstClass = isFirstClass;
	}

	//Get and set methods for the seat type
	public SeatType getSeatType() 
	{
		return this.seatType;
	}

	public void setSeatType(SeatType seatType) 
	{
		this.seatType = seatType;
	}

	//Get and set methods for the seat position
	public SeatPosition getSeatPosition() 
	{
		return this.seatPos;
	}

	public void setSeatPosition(SeatPosition mySeatPosition) 
	{
		this.seatPos = mySeatPosition;
	}
	
	/**
	 * This method generates a longer, more descriptive string pertaining to the seat.
	 * @return a string output which is more descriptive than the toString override.
	 */
	public String longStringDescription()
	{
		String longReserved = null;
		String longFirstClass = null;
		String longSeatType = null;
				
		if(isReserved)
		{
			longReserved = " is reserved.";
		}
		else if(!isReserved)
		{
			longReserved = " is not reserved.";
		}
		
		if(isFirstClass)
		{
			longFirstClass = "First class";
		}
		else if(!isFirstClass)
		{
			longFirstClass = "Economy class";
		}
		
		if(getSeatType() == SeatType.WINDOW)
		{
			longSeatType = " WINDOW ";
		}
		else if(getSeatType() == SeatType.AISLE)
		{
			longSeatType = " AISLE ";
		}
		else if(getSeatType() == SeatType.MIDDLE)
		{
			longSeatType = " MIDDLE ";
		}
		return longFirstClass+longSeatType+"seat at:"+seatPos+longReserved;
	}
	
	public String toString()
	{
		String reserved = "_";
		String flightClassType = null;
		
		if(isReserved)
		{
			reserved = "X";
		}
		
		if(!isFirstClass)
		{
			flightClassType = this.seatType.toString().toLowerCase();
		}
		else
		{
			flightClassType = this.seatType.toString();
		}
		return flightClassType+"[ "+reserved+" ]";
	}
}
