/**
 * This abstract class contains method which are used to determine specific seats within the 
 * seatmap array.
 * @author Shakeel Khan
 * Date: 06/05/2016
 */

public abstract class SeatMap {
	
	protected Seat[][] seatMap;
	protected int rows;
	protected int columns;
	protected int firstClassRows;
	
	public abstract void initialiseSeatMap();
	
	//Get methods for the last row/column in the seatarray
	public int getLastRow()
	{
		return (rows);
	}
	
	public char getLastColumn()
	{
		return (char)((columns-1) + '0' + 17);
	}
	/**
	 * This method takes the row and column of a seat and returns the seat object
	 * at that position.
	 * @param row
	 * @param column
	 * @return a seat at a specified position
	 */
	public Seat getSeat(int row, char column)
	{
		int columnIndex = (int)((column)-65);
		
		if(columnIndex >= this.columns)
		{
			return null;
		}
		return this.seatMap[row-1][columnIndex];
	}
	/**
	 * This method calculates the position of the input seat, and returns the seat next to it.
	 * @param inputSeat
	 * @return a seat to the left of the input seat
	 */
	public Seat getLeft(Seat inputSeat)
	{
		if(inputSeat.getSeatPosition().getColumn() == 0)
		{
			return null;
		}
		
		Seat outputSeat = seatMap[inputSeat.getSeatPosition().getRow()][inputSeat.getSeatPosition().getColumn()-1];
		
		return outputSeat;
	}
	
	/**
	 * See above {@public Seat getLeft()}
	 * @param inputSeat
	 * @return a seat to the right of the input seat
	 */
	public Seat getRight(Seat inputSeat)
	{
		if(inputSeat.getSeatPosition().getColumn() == this.columns)
		{
			return null;
		}
		
		Seat outputSeat = this.seatMap[inputSeat.getSeatPosition().getRow()][inputSeat.getSeatPosition().getColumn()+1];
		
		return outputSeat;
	}
	
	/**
	 * This method takes in a seattype, find a seat pertaining to the seattype and returns it
	 * If it cannot find a seat of this type, it returns any other seat within economy.
	 * 
	 * @param mySeatType
	 * @return an available economy seat. If not available, any possible seat
	 */
	public Seat queryAvailableEconomySeat(SeatType mySeatType)
	{
		Seat aSeat = null;
		for(int i = this.firstClassRows; i < this.rows; i++)
		{
			for(int j = 0; j < this.columns; j++)
			{
				if(this.seatMap[i][j].getSeatType() == mySeatType && !(this.seatMap[i][j].isReserved()))
				{
					return aSeat = this.seatMap[i][j];
				}
			}
		}	
		for(int i = this.firstClassRows; i < this.rows; i++)
		{
			for(int j = 0; j < this.columns; j++)
			{
				if(!(this.seatMap[i][j].isReserved()))
				{
					return aSeat = this.seatMap[i][j];
				}
			}
		}
		return aSeat;
	}
	
	// returns ANY economy seat
	public Seat queryAvailableEconomySeat()							
	{
		Seat aSeat = null;
		for(int i = this.firstClassRows; i < this.rows; i++)
		{
			for(int j = 0; j < this.columns; j++)
			{
				if(!(this.seatMap[i][j].isReserved()))
				{
					return aSeat = this.seatMap[i][j];
				}
			}
		}
		return aSeat;
	}
	
	/**
	 * This method takes in a seat type and finds and returns a seat object, according to the
	 * seat type specified. If it cannot find a seat of that type, it returns any other seat within first class
	 * @param mySeatType
	 * @return
	 */
	public Seat queryAvailableFirstClassSeat(SeatType mySeatType) // searches array for seat of seattype specified which is not reserved and returns it.
	{															  // if cannot find specified, returns any free first class seat.
		Seat aSeat = null;
		for(int i = 0; i < (this.firstClassRows); i++)
		{
			for(int j = 0; j < this.columns; j++)
			{
				if(this.seatMap[i][j].getSeatType() == mySeatType && !(this.seatMap[i][j].isReserved()))
				{
					return aSeat = this.seatMap[i][j];
				}
			}
		}	
		for(int i = 0; i < (this.firstClassRows); i++)
		{
			for(int j = 0; j < this.columns; j++)
			{
				if(!(this.seatMap[i][j].isReserved()))
				{
					return aSeat = this.seatMap[i][j];
				}
			}
		}
		return aSeat;
	}
	
	// returns ANY seat from firstclass
	public Seat queryAvailableFirstClassSeat() 
	{
		Seat aSeat = null;
		
		for(int i = 0; i < (this.firstClassRows); i++)
		{
			for(int j =0; j < this.columns; j++)
			{
				if(!(this.seatMap[i][j].isReserved()))
				{
					return aSeat = this.seatMap[i][j];
				}
			}
		}
		return aSeat;
	}
	
	public String toString()
	{
		String seatMapDraw = "";

		for(int i = 0; i < this.columns; i++)
		{
			seatMapDraw += "      "+(char)(i + '0' + 17); // 4 spaces
		}
		seatMapDraw += "\n";
		
		for(int i = 0; i < this.rows; i++)
		{
			seatMapDraw += String.format("%2s ", i+1);
			
			for(int j = 0; j < this.columns; j++)
			{
				seatMapDraw += this.seatMap[i][j]+" ";
			}
			seatMapDraw += "\n";
		}
		return seatMapDraw;
	}
}