/**
 * This class extends the abstract Product class. It holds instance variables, 
 * a constructor for setting its initial values, and an override for the toString. 
 * @author Shakeel Khan
 * Date: 31/06/2016
 */

public class PS4Game extends Product{

	private String title;
	private String edition;
	
	//Default Constructor
	public PS4Game(String title, String edition, Integer pCode, double price)
	{
		this.title = title;
		this.edition = edition;
		super.setpCode(pCode);
		super.setPrice(price);
	}

	public String toString()
	{
		return this.title+", "+this.edition+" edition, "+super.toString();
	}
}
