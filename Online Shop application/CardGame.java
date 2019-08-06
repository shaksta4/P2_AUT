/**
 * This class extends the abstract Product class. It holds instance variables, 
 * a constructor for setting its initial values, and an override for the toString. 
 * @author Shakeel Khan
 * Date: 31/06/2016
 */

public class CardGame extends Product{

	private String edition;
	private String name;
	
	//Default Constructor
	public CardGame(String name, String edition, Integer pCode, double price)
	{
		this.name = name;
		this.edition = edition;
		super.setpCode(pCode);
		super.setPrice(price);
	}

	public String toString()
	{
		return this.name+", "+this.edition+" edition, "+super.toString();
	}
}
