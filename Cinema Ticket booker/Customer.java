
public class Customer {

	private String name;
	private int age;
	private boolean student;
	
	Customer(String name, int age, boolean student)		//Constructor with inputs
	{
		this.name = name;
		this.age = age;
		this.student = student;
	}
	
	Customer()											// Default constructor
	{
		this.name = "Unknown";
		this.age = 0;
		this.student = false;	
	}
	
	public String getName()								//Method to get customer name
	{
		return this.name;
	}
	
	public int getAge()									//Method to get customer age
	{
		return this.age;
	}
	
	public boolean getStudent()							//Method to check if customer is a student or not
	{
		return this.student;
	}
	
	public void setName(String name)					//Method to set customer name
	{
		
		this.name = name;
	}
	
	public void setAge(int age)							//Method to set customer age
	{
		this.age = age;
	}
	
	public void setStudent(char option)				    //Method to set if customer is student
	{
		if(option == 'Y' || option == 'y')
		{
			this.student = true;
		}
		
		else if(option == 'N' || option == 'n')
		{
			this.student = false;
		}
		
		else
		{
			System.out.println("Please enter either Y or N");
		}
	}
	
	public String toString()						//Converts class variables to strings.
	{
		return "Name: "+this.name+" Age: "+this.age+" Is Student?"+student;
	}

}
