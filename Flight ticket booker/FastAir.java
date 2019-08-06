/**
 * This class extends the abstract airline class. It holds methods which enable
 * seats to be reserved in the flight.
 * @author Shakeel Khan
 * Date: 06/05/2016
 */
public class FastAir extends Airline{

	public FastAir()
	{
		super.setAirlineName("FastAir");
	}
	
	/**
	 * See comments for reserveFirstClass in JetSun class
	 * This method takes in a flight and a seattype and returns a seat pertaining to the flight and seattype specified.
	 * If a seat according to the seat type cannot be found, it returns any first class seat
	 * If there are no first class seats, it returns any seat in economy and reserves the whole row for extra space.
	 *
	 * @param aFlight
	 * @param aSeatType
	 * @return seat according to the seattype and flight specified.
	 */
	@Override
	public Seat reserveFirstClass(Flight aFlight, SeatType aSeatType) 
	{
		Seat aSeat = new Seat();
		aSeat = aFlight.getFlightSeatMap().queryAvailableFirstClassSeat(aSeatType);
		
		if(aSeat == null)
		{
			aSeat = aFlight.getFlightSeatMap().queryAvailableEconomySeat();
			if(aSeat == null)
			{
				System.out.println("Sorry there are no available seats");
				return null;
			}
			SeatPosition aSeatPosition = aSeat.getSeatPosition();	
			for(int i = aSeatPosition.getColumn(); i < aFlight.getFlightSeatMap().getLastColumn(); i++) // check right
			{
				if(aFlight.getFlightSeatMap().getRight(aSeat).isReserved())
				{
					return null;
				}
				aFlight.getFlightSeatMap().getRight(aSeat).setReserved(true);
			}
			
			for(int i = 0; i < aSeatPosition.getColumn(); i++) // check left
			{
				if(aFlight.getFlightSeatMap().getLeft(aSeat).isReserved())
				{
					return null;
				}
				aFlight.getFlightSeatMap().getLeft(aSeat).setReserved(true);
			}
		}
		aSeat.setReserved(true);
		return aSeat;
	}
	

	/**
	 * See reserveEconomy for JetSun class
	 * @param aFlight
	 * @param aSeatType
	 * @return
	 */
	@Override
	public Seat reserveEconomy(Flight aFlight, SeatType aSeatType) 
	{
		Seat aSeat = new Seat();
		aSeat = aFlight.getFlightSeatMap().queryAvailableEconomySeat(aSeatType);
		
		if(aSeat == null)
		{
			aSeat = aFlight.getFlightSeatMap().queryAvailableFirstClassSeat();
			if(aSeat == null)
			{
				System.out.println("Sorry there are no available seats left.");
				return null;
			}
			aSeat.setReserved(true);
			return aSeat;
		}
		aSeat.setReserved(true);
		return aSeat;
	}
}
