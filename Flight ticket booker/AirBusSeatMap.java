/**
 * This class extends the abstract seatmap class. It holds values and methods for the 
 * initialisation of the Airbus A380 seatmap. 
 * @author Shakeel Khan
 * Date: 06/05/2016
 *
 */

public class AirBusSeatMap extends SeatMap{

	// default constructor
	public AirBusSeatMap()
	{
		super.rows = 12;
		super.columns = 9;
		super.firstClassRows = 6;
		super.seatMap = new Seat[rows][columns];
	}
	
	/**
	 * This method initialises the seatmap according to its specifications.
	 * It sets each seat accordingly as a window/middle/aisle seat as well as
	 * if the seat is first class or not.
	 */
	@Override
	public void initialiseSeatMap() 
	{
		for(int rowNo = 0; rowNo < firstClassRows; rowNo++)
		{
			for(int colNo = 0; colNo < columns; colNo++)
			{
				SeatPosition newSeatPos = new SeatPosition(rowNo,colNo);
				if(colNo == 0 || colNo == columns-1)
				{
					super.seatMap[rowNo][colNo] = new Seat(false, true, SeatType.WINDOW, newSeatPos);
				}
				else if(colNo % 3 == 1)
				{
					super.seatMap[rowNo][colNo] = new Seat(false, true, SeatType.MIDDLE, newSeatPos);
				}
				else
				{
					super.seatMap[rowNo][colNo] = new Seat(false, true, SeatType.AISLE, newSeatPos);
				}
			}
		}
		
		for(int rowNo = firstClassRows; rowNo < rows; rowNo++)
		{
			for(int colNo = 0; colNo < columns; colNo++)
			{
				SeatPosition newSeatPos = new SeatPosition(rowNo,colNo);
				if(colNo == 0 || colNo == columns-1)
				{
					super.seatMap[rowNo][colNo] = new Seat(false, false, SeatType.WINDOW, newSeatPos);
				}
				else if(colNo % 3 == 1)
				{
					super.seatMap[rowNo][colNo] = new Seat(false, false, SeatType.MIDDLE, newSeatPos);
				}
				else
				{
					super.seatMap[rowNo][colNo] = new Seat(false, false, SeatType.AISLE, newSeatPos);
				}
			}
		}
	}
}
