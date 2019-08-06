
public class Ticket {
	
	private Customer myCustomer;
	private Film myFilm;
	
	Ticket(Customer myCustomer, Film myFilm)								//Constructor with inputs
	{
		this.myCustomer = myCustomer;
		this.myFilm = myFilm;
	}
	
	static double cost(Customer customer, Film movie)						//Method which calculates cost of ticket
	{
		double adultPrice = 10f;
		double childPrice = 7f;
			
		if(customer.getStudent() == true)									//If customer is a student
		{
			if(customer.getAge() >= 10 && customer.getAge() < 18) 
			{
				return(childPrice*0.85);
			}
			
			else if(customer.getAge() >= 18 && customer.getAge() <= 25) 
			{
				return(adultPrice*0.85);
			}
			
			else if(customer.getStudent() && customer.getAge() > 25) 
			{
				return(adultPrice*0.9);
			}
		}
		
		else if(customer.getStudent() == false)								//If customer is NOT a student
		{
			if(customer.getAge() < 18) 
			{
				return childPrice;
			}
			
			else if(customer.getAge() >= 18 && customer.getAge() <= 64)
			{
				return adultPrice;
			}
			
			else if(customer.getAge() > 64)
			{
				return(adultPrice*0.93);
			}
		}
		
		return 0;
	}
	
	public Customer getCustomer()											//Method to get customer details
	{
		return this.myCustomer;
	}
	
	public Film getFilm()													//Method to get film details
	{
		return this.myFilm;
	}	
	
	public String toString()						//Converts class variables to strings.
	{
			return "Your ticket is ready to be collected!"+System.lineSeparator()+
					"------------------------------------------------------------"+System.lineSeparator()
					+ "FILM TICKET for: "+myFilm.getTitle()+" rating: ("+myFilm.getRating()+")"+System.lineSeparator()+
					"CUSTOMER DETAILS: "+myCustomer.getName()+" Age: "+myCustomer.getAge()+" Student? "+myCustomer.getStudent()+System.lineSeparator()
					+"TOTAL COST: $"+Ticket.cost(myCustomer, myFilm)+System.lineSeparator()+
					"------------------------------------------------------------";
	}
}
