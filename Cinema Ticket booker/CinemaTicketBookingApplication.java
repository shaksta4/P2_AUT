import java.util.*;

public class CinemaTicketBookingApplication {
	
	private static final int NUM_OF_FILMS = 4;
	static Scanner keyboard = new Scanner(System.in);
	static Film[] myFilms = new Film[NUM_OF_FILMS];
	
	private static Customer customerDetailsInput()							//Method for user to input details
	{
		Customer customer = new Customer();
		
		System.out.println("Please enter your name: ");
		customer.setName(keyboard.next());
	
		System.out.println("Please enter your age: ");
		customer.setAge(keyboard.nextInt());
			
		System.out.println("Are you a student? (Y/N)");
		customer.setStudent(keyboard.next().charAt(0));
		
		return customer;
	}
	
	private static Film filmSelection()										//Method for user to select which film to book ticket.
	{
		int selection;
		
		System.out.println("Which film would you like to watch? ");
		
		for(int i = 0; i < 4; i++)
		{
			System.out.println((i+1)+". "+myFilms[i]);						//Prints out film titles and ratings
		}
				
		while(true)
		{
			selection = keyboard.nextInt();

			if(selection < 1 || selection > NUM_OF_FILMS)
			{
				System.out.println("Invalid! Please enter a number between 1 - "+NUM_OF_FILMS);
			}
			else if(selection == 1)
			{
				return myFilms[0];
			}
			else if(selection == 2)
			{
				return myFilms[1];
			}
			else if(selection == 3)
			{
				return myFilms[2];
			}
			else if(selection == 4)
			{
				return myFilms[3];
			}
		}
	}
	
	public static Ticket issueTicket(Customer aCustomer, Film aFilm)			//Method which issues the ticket if user is
	{																			//above correct age, else returns null.
		if(aCustomer.getAge() > aFilm.getRating().getAge())
		{
			Ticket newTicket = new Ticket(aCustomer, aFilm);
			
			return newTicket;
		}
		else
		{
			System.out.println("Sorry, cannot issue ticket for age restricted film");
			return null;
		}
	}
		
	public static void main(String[] args) 
	{
		char issueAnotherTicket;
		
		System.out.println("Welcome to the Cinema Ticket Booking Application!");
		while(true)
		{
			myFilms[0] = new Film("Batman Begins", RATING.P);						//Instantiates each index of Film array and
			myFilms[1] = new Film("Inside Out", RATING.G);							//sets film titles and ratings
			myFilms[2] = new Film("The Witch", RATING.M);
			myFilms[3] = new Film("Shrek 2", RATING.G);
		
			Customer myCustomer = customerDetailsInput();
			Film myFilm = filmSelection();
			
			if((issueTicket(myCustomer, myFilm) != null))							//If ticket is not null, 
			{																		//print ticket details and ask if user wishes
				System.out.println(issueTicket(myCustomer, myFilm));				//to book another film
				System.out.println(System.lineSeparator()+"Issue another ticket? (Y/N)");
				issueAnotherTicket = keyboard.next().charAt(0);
			}
			else																	//Else just ask if user wishes to book another
			{																		//film
				System.out.println(System.lineSeparator()+"Issue another ticket? (Y/N)");
				issueAnotherTicket = keyboard.next().charAt(0);
			}
			
			if(issueAnotherTicket == 'Y' || issueAnotherTicket == 'y')
			{
				continue;
			}
			else
			{
				System.out.println("Thank you for using this Application!");
				break;
			}
		}
	}
}
