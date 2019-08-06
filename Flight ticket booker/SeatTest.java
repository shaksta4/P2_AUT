import static org.junit.Assert.*;

import org.junit.Test;


public class SeatTest {

	@Test
	public void test() {

		SeatPosition mySeatPos = new SeatPosition(9 ,9);

		Seat mySeat = new Seat(true, true, SeatType.WINDOW, mySeatPos);
		
		System.out.println(mySeat);
	}

}
