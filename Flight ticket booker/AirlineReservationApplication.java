/**
 * This program allows a user to interactively choose a flight company,
 * and view their available flights. It also allows the user to book a seat 
 * on the flight, in either economy or first class.
 * There is also an option to choose what kind of seat the user wishes to have (Window seat, Aisle seat, Middle seat)
 * The user should follow the console prompts accordingly to successfully book their flight.
 * 
 * @author Shakeel Khan
 * Date: 06/05/2016
 * Version 1.0
 *
 */

import java.util.*;

public class AirlineReservationApplication {

	private static Scanner keyboard = new Scanner(System.in);
	public static BoeingSeatMap Boeing747 = new BoeingSeatMap();
	public static AirBusSeatMap AirbusA380 = new AirBusSeatMap();

	public static Flight flight1 = new Flight("Wellington Airport", "Auckland Airport", "10:30h", "WGTNAKL747", Boeing747);
	public static Flight flight2 = new Flight("Christchurch Airport", "Wellington Airport", "13:30h", "CHCHWGTN380", AirbusA380);
	public static Flight flight3 = new Flight("Queenstown Airport", "Dunedin Airport", "21:30h", "QTNDND747", Boeing747);
	
	/**
	 * This method prompts the user to choose their flight company. 
	 * @return Airline company user wishes to use.
	 */
	private static Airline airlineOption()
	{
		int userInput;
		System.out.println("Which airline would you like to travel with?");
		System.out.println("1. FastAir Airlines\n2. JetSun Airlines");
		
		userInput = keyboard.nextInt(); // Choosing flight company

		if(userInput == 1) // fastair
		{
			FastAir myFlight = new FastAir();
			return myFlight;
		}
		else if(userInput == 2) // jetsun
		{
			JetSun myFlight = new JetSun();
			return myFlight;
		}
		return null;
	}
	
	/**
	 * This method prompts the user to choose which flight he/she wants to take. It has details about
	 * the flight such as flight starts and destinations.
	 * @return the flight the user chooses.
	 */
	private static Flight flightOption()
	{
		int userInput;
		System.out.println("Which flight would you like to reserve a seat on?");

		System.out.println("1."+flight1+"\n2."+flight2+"\n3."+flight3);
		userInput = keyboard.nextInt(); // Choosing which flight to take
		if(userInput == 1)
		{
			flight1.getFlightSeatMap().initialiseSeatMap();
			System.out.println("Booking seats for "+flight1);
			System.out.println(flight1.getFlightSeatMap());
			return flight1;
		}
		else if(userInput == 2)
		{
			flight2.getFlightSeatMap().initialiseSeatMap();
			System.out.println("Booking seats for "+flight2);
			System.out.println(flight2.getFlightSeatMap());
			return flight2;
		}
		else if(userInput == 3)
		{
			flight3.getFlightSeatMap().initialiseSeatMap();
			System.out.println("Booking seats for "+flight3);
			System.out.println(flight3.getFlightSeatMap());
			return flight3;
		}
		return null;
	}
	
	/**
	 * This method prompts a user to choose an option from the menu.
	 * The menu consists of reserving either a first class or economy seat, 
	 * viewing the seating map or exiting the application.
	 * @param myFlightOption
	 * @return an integer pertaining to the option the user chooses
	 */
	
	private static int menuOption(Flight myFlightOption)
	{
		int userInput = 0;

		System.out.println("1. Reserve first class\n2. Reserve economy class\n3. View seating map\n4. Exit");
		userInput = keyboard.nextInt();
		if(userInput == 1)
		{
			return 1;
		}
		else if(userInput == 2)
		{
			return 2;
		}
		else if(userInput == 3)
		{
			return 3;
		}
		else if(userInput == 4)
		{
			System.out.println("Thank you for using this Application. Goodbye");
			System.exit(0);
		}
		return userInput;
	}
	
	/**
	 * This method prompts the user to choose what type of seat they wish to have on the flight.
	 * It prints out the confirmation of the reservation as well as the updated seating map 
	 * for the user to view.
	 * 
	 * @param menuOption
	 * @param aCustomer
	 * @param flightOption
	 * @return the seat object which has been reserved
	 */
	
	private static Seat seatOption(int menuOption, Airline aCustomer, Flight flightOption)
	{
		int userInput = 0;
		Seat mySeat;
		if(menuOption != 3)
		{
			System.out.println("Which seat type?");
			System.out.println("1. WINDOW Seat\n2. AISLE Seat\n3. MIDDLE Seat");
			userInput = keyboard.nextInt(); // Choosing which seat type
		}
		
		if(menuOption == 1) // if First Class
		{
			if(userInput == 1)
			{
				mySeat = aCustomer.reserveFirstClass(flightOption, SeatType.WINDOW); 
				System.out.println(flightOption.getFlightSeatMap());
				System.out.println("Seat reservation: "+mySeat.longStringDescription());
				return mySeat;
			}
			else if(userInput == 2)
			{
				mySeat = aCustomer.reserveFirstClass(flightOption, SeatType.AISLE); 
				System.out.println(flightOption.getFlightSeatMap());
				System.out.println("Seat reservation: "+mySeat.longStringDescription());
				return mySeat;
			}
			else if(userInput == 3)
			{
				mySeat = aCustomer.reserveFirstClass(flightOption, SeatType.MIDDLE); 
				System.out.println(flightOption.getFlightSeatMap());
				System.out.println("Seat reservation: "+mySeat.longStringDescription());
				return mySeat;
			}
		}
		else if(menuOption == 2) // if Economy
		{
			System.out.println("Which seat type?");
			System.out.println("1. WINDOW Seat\n2. AISLE Seat\n3. MIDDLE Seat");
			
			if(userInput == 1)
			{
				mySeat = aCustomer.reserveEconomy(flightOption, SeatType.WINDOW);
				System.out.println(flightOption.getFlightSeatMap());
				System.out.println("Seat reservation: "+mySeat.longStringDescription());
				return mySeat;
			}
			else if(userInput == 2)
			{
				mySeat = aCustomer.reserveEconomy(flightOption, SeatType.AISLE);
				System.out.println(flightOption.getFlightSeatMap());
				System.out.println("Seat reservation: "+mySeat.longStringDescription());
				return mySeat;
			}
			else if(userInput == 3)
			{
				mySeat = aCustomer.reserveEconomy(flightOption, SeatType.MIDDLE);
				System.out.println(flightOption.getFlightSeatMap());
				System.out.println("Seat reservation: "+mySeat.longStringDescription());
				return mySeat;
			}
		}
		else if(menuOption == 3)
		{
			System.out.println(flightOption.getFlightSeatMap());
		}
		return null;
	}
	/**
	 * This main method is where all the earlier specified methods are used.
	 * @param args
	 */

	public static void main(String[] args) 
	{
		Airline airline = airlineOption();
		Flight myFlight;
		int myMenuOption;
		
		System.out.println("Welcome to the "+airline+" reservation system");

		if(airline.getAirlineName().contentEquals("FastAir")) // fastair
		{
			myFlight = flightOption();
			while(true)
			{
				myMenuOption = menuOption(myFlight);
				seatOption(myMenuOption, airline, myFlight);
			}
		}
		else if(airline.getAirlineName().contentEquals("JetSun")) // jetsun
		{
			myFlight = flightOption();
			while(true)
			{
				myMenuOption = menuOption(myFlight);
				seatOption(myMenuOption, airline, myFlight);
			}
		}
	}
}
