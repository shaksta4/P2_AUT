/**
 * This class implements the PaymentSystem interface. It has a constructor initialising it
 * with starting values. It holds functionality for adding and viewing products to the cart, and caluclating the amount
 * owed as well as completing the transaction. 
 * @author Shakeel Khan
 */

import java.util.*;

public class OnlineShop implements PaymentSystem{
	
	private ProductDatabase p1;
	private RecommenderSystem r1;
	private ArrayList<Product> shopCart;
	
	//Default constructor
	public OnlineShop()
	{
		p1 = new ProductDatabase();
		//r1 = new RecommenderSystem();
		shopCart = new ArrayList<Product>();
	}
	
	/**
	 * This method takes in a product and adds it to the shopcart. If the item is already in the cart,
	 * it prints out "You already have that product in your cart." 
	 * @param p
	 */
	void addToCart(Product p)
	{
		if(!shopCart.contains(p))
		{
			shopCart.add(p);
		}
		else
		{
			System.out.println("You already have that product in your cart");
		}
	}
	
	/**
	 * This method sorts the shopcart according to the compareTo method (according to price) and 
	 * returns it. 
	 * @return
	 */
	public ArrayList<Product> getShopCart()
	{
		Collections.sort(this.shopCart);
		return this.shopCart;
	}
	
	/**
	 * This method overrides the method signature in the PaymentSystem interface. It calculates the cost
	 * of all products in the shopcart and returns it. 
	 */
	@Override
	public Double amountOwing() 
	{
		double myAmount = 0;
		
		for(int i = 0; i < this.shopCart.size(); i++)
		{
			myAmount += this.shopCart.get(i).getPrice();
		}
	
		return myAmount;
	}
	
	/**
	 * This method overrides the method signature in PaymentSystem interface. It simply clears the cart
	 * when called. 	
	 */
	@Override
	public void completeTransaction() 
	{
		this.shopCart.clear();
	}

}
