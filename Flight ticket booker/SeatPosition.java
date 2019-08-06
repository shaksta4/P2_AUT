/**
 * This class holds data pertaining to the position of a seat within the Seatmap array.
 * @author Shakeel Khan
 * Date: 06/05/2016
 */
public class SeatPosition {

	int row;
	int column;
	
	//Constructor
	public SeatPosition(int row, int column)
	{
		this.setRow(row);
		this.setColumn(column);
	}
	
	//Get and set methods for the seat row
	public int getRow()
	{
		return this.row;
	}
	
	public void setRow(int row)
	{
		this.row = row;
	}
	//Get and set methods for the seat column
	public int getColumn()
	{
		return this.column;
	}
	
	public void setColumn(int column)
	{
		this.column = column;
	}
	
	public String toString()
	{
		return " "+(row+1)+(char)(column + '0' + 17);
	}
}
