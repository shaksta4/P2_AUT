/**
 * This enumerated object holds enum values for the type of seats available on the plane.
 * @author Shakeel Khan
 * Date: 06/05/2016
 */
public enum SeatType {
	WINDOW, AISLE, MIDDLE, UNKNOWN;
		
	public String toString()
	{
		return this.name().substring(0, 1);
	}
}
