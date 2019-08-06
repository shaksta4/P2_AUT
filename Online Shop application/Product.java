/**
 * This is an abstract class which defines what a Product is. It implements the comparable interface.
 * It has instance variables, set and get methods for each instance variable and an override for the
 * compareTo method which compares products by their price. 
 * 
 * @author Shakeel Khan
 * Date: 31/06/2016
 */

public abstract class Product implements Comparable<Product>{

	private Integer pCode;
	private Double price;
		
	public Integer getpCode() 
	{
		return pCode;
	}
	
	public int compareTo(Product product) 
	{
		return this.price.compareTo(product.price);
	}
	
	public void setpCode(Integer pCode) 
	{
		this.pCode = pCode;
	}
	
	public double getPrice() 
	{
		return price;
	}
	
	public void setPrice(double price) 
	{
		this.price = price;
	}
	
	public String toString()
	{
		return "("+this.pCode+")"+" Price: $"+String.format("%.2f", this.price);
	}
}
