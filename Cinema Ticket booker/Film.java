
public class Film {
	
	private String title;
	private RATING rating;
	
	Film(String title, RATING rating)        // Constructor with inputs 
	{
		this.title = title;
		this.rating = rating;
	}
	
	Film()                                 // Default constructor
	{
		this.title = "UNKNOWN";
		this.rating = RATING.U;
	}
	
	public String getTitle()						//Allows other classes to get info about title
	{
		return this.title;
	}
	
	public RATING getRating()							//Allows other classes to get info about rating
	{
		return this.rating;
	}
	
	public void setTitle(String myTitle)			//Allows other classes to modify the title
	{
		this.title = myTitle;
	}
	
	public void setRating(RATING p)			//Allows other classes to modify the rating
	{
		this.rating = p;
	}
	
	public String toString()						//Converts class variables to strings.
	{
		return this.title+" | rating: "+"("+this.rating+")";
	}

}
