/**
 * This class extends the abstract airline class. It holds methods which enable
 * seats to be reserved in the flight.
 * @author Shakeel Khan
 * Date: 06/05/2016
 */
public class JetSun extends Airline{
	
	public JetSun()
	{
		super.setAirlineName("JetSun");
	}
	/**
	 * This method takes in a flight and a seattype and returns a seat pertaining to the flight and seattype specified.
	 * If a seat according to the seat type cannot be found, it returns any first class seat
	 * If there are no first class seats, it returns any seat in economy and reserves the seat next to it for extra space.
	 * 
	 * @param Flight
	 * @param SeatType
	 * @return seat according to the seattype and flight specified.
	 */
	@Override
	public Seat reserveFirstClass(Flight aFlight, SeatType aSeatType) 
	{
		Seat aSeat = new Seat();
		aSeat = aFlight.getFlightSeatMap().queryAvailableFirstClassSeat(aSeatType);
		
		// If no seat can be found.
		if(aSeat == null)
		{
			aSeat = aFlight.getFlightSeatMap().queryAvailableEconomySeat();
			Seat extraSeat = new Seat();
			if(aFlight.getFlightSeatMap().getLeft(aSeat) != null)
			{
				aSeat.setReserved(true);
				extraSeat = aFlight.getFlightSeatMap().getLeft(aSeat);
				extraSeat.setReserved(true);
				return aSeat;
			}
			else if(aFlight.getFlightSeatMap().getRight(aSeat) != null)
			{
				aSeat.setReserved(true);
				extraSeat = aFlight.getFlightSeatMap().getRight(aSeat);
				extraSeat.setReserved(true);
				return aSeat;
			}
			System.out.println("Sorry there are no available seats");
		}
		aSeat.setReserved(true);
		return aSeat;
	}

	/**
	 * This method does the same as reserveFirstClass(), except it only reserves within economy.
	 * If there are no seats in economy, then it finds and reserves any seat in first class.
	 * If there are no seats in first class, it returns null.
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
