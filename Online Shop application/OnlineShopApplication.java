/**
 * This class holds the main functionality of the program. It holds methods for each part of the user interactions.
 * The code is checked for incorrect inputs and messages are displayed to the user accordingly. This program 
 * allows a user to look through the online menu, and add products to their cart. It then calculates the total
 * cost and if the transaction proceeds, recommends products the user may wish to purchase, based on their
 * purchases.
 * 
 * @author Shakeel Khan
 * Date: 31/06/2016
 * Version 2.01
 */

import java.io.*;
import java.util.*;

public class OnlineShopApplication {
	
	static OnlineShop myShop = new OnlineShop();
	static Scanner keyboard = new Scanner(System.in);
	static ProductDatabase database = generateSampleDatabase();

	/**
	 * This method adds new products with initialised values to a ProductDatabase and returns it
	 * @return
	 */
	private static ProductDatabase generateSampleDatabase()
	{
		ProductDatabase pd = new ProductDatabase();
		pd.addProduct(new XboxGame("Halo 4", "Standard", 865, 119.99));
		pd.addProduct(new PcGame("Doom", "Original", 199, 44.99));
		pd.addProduct(new PS4Game("Destiny", "The Taken King", 200, 69.99));
		pd.addProduct(new CardGame("Uno", "Deluxe", 123, 4.99));
		pd.addProduct(new BoardGame("Snakes n Ladders", "Standard", 187, 25.99));

		return pd;
	}
	
	/**
	 * This method reads in a file "purchase-history.txt" and stores any meaningful data in an ArrayList.
	 * Data from the Arraylist is then passed into the PurchaseHistory class which is then instantiated.
	 * The purchaseHistory class is then returned. 
	 * It throws an IOException if the file cannot be found or a NumberFormatException if the file format
	 * is incorrect.
	 * 
	 * 
	 * @param pb
	 * @param filename
	 * @return
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	private static HashSet<PurchaseHistory> readPurchaseHistoryData(ProductDatabase pb, String filename) 
			throws /*ProductNotFoundException,*/ IOException, NumberFormatException
	{
		System.out.println("Reading purchase transcript: purchase-history.txt..................");
		HashSet<PurchaseHistory> ph = new HashSet<PurchaseHistory>();
		FileReader fr = null;
		BufferedReader br = null;
		try
		{
			fr = new FileReader(filename);
			br = new BufferedReader(fr);
			String line = null;
			while((line = br.readLine()) != null)
			{
				ArrayList<Product> purchases = new ArrayList<Product>();
				int numPurchases = new Integer(line);
				for(int i = 1; i <= numPurchases; i++)
				{
					Integer code = new Integer(br.readLine());
					if(pb.getDatabaseProducts().contains(code))
					{
						purchases.add(pb.getDatabaseProducts().get(code));
					}
				}
				PurchaseHistory phistory = new PurchaseHistory(purchases);				
				ph.add(phistory);		
			}
		}
		catch(IOException e)
		{
			System.err.println("File not found!");
			System.exit(0);
		}
		catch(NumberFormatException e)
		{
			System.err.println("The file format is incorrect!");
			System.exit(0);
		}
		finally
		{
			fr.close();
			br.close();
		}
		return ph;
	}
	
	/**
	 * This method provides user interactivity for adding a product to the cart. It also prints out the menu 
	 * in an appropriate format.
	 */
	public static void addProductToCart() throws IndexOutOfBoundsException, InputMismatchException
	{
		System.out.println("Please select a product from the menu");
		System.out.println(arrayFormat(database.getDatabaseProducts()));
		try
		{
			int productInput = keyboard.nextInt();
			System.out.println("Adding "+database.getDatabaseProducts().get((productInput)-1).toString());
			myShop.addToCart(database.getDatabaseProducts().get((productInput)-1));
		}
		catch(IndexOutOfBoundsException e)
		{
			System.out.println("Invalid! Please select your item using its number in the menu");
		}
		catch(InputMismatchException e)
		{
			System.out.println("Invalid! Please select your item using its number in the menu");
		}
	}
	
	/**
	 * This method formats the arrayList into a presentable format to be printed.
	 * @param a
	 * @return
	 */
	public static String arrayFormat(ArrayList<Product> a) // COMPLETED
	{
		String str = "";
		for(int i = 1 ; i < a.size()+1; i++)
		{
			str+=i+". "+a.get(i-1)+"\n";
		}
		return str;
	}
	
	/**
	 * This method provides user interactivity for viewing the current shopping cart. 
	 * If the cart is empty, it provides an appropriate message to the user.
	 */
	public static void viewShoppingCart() // COMPLETED
	{
		//If not empty
		if(!myShop.getShopCart().isEmpty())
		{
			System.out.println("Contents of your cart (sorted by price)");
			System.out.println(arrayFormat(myShop.getShopCart()));
		}
		//If empty
		if(myShop.getShopCart().isEmpty())
		{
			System.out.println("Your shopping cart is empty!");
		}
	}
	
	/**
	 * This method prints out the total cost for products in the user's cart. 
	 * It also asks the user if it wants to pay. If Yes, then completes the transaction and clears the cart.
	 * If No, it returns to the main menu with all items intact in the cart.
	 * If the cart is empty, it provides an appropriate message to the user.
	 */
	public static void finalisePurchase() throws InputMismatchException // COMPLETED
	{
		//If not empty
		if(!myShop.getShopCart().isEmpty())
		{
			try
			{
				System.out.println("Your total is: $"+String.format("%.2f", myShop.amountOwing()));
				System.out.println("Pay ? (Y/N)");
				char choice = keyboard.next().charAt(0);
				if(choice == 'Y' || choice == 'y')
				{
					myShop.completeTransaction();
					System.out.println("Thank you for using the online shop! Enjoy your items!");
				}
				else if(choice == 'N' || choice == 'n')
				{
					System.out.println("Returning to main menu!");
				}
				else
				{
					throw new InputMismatchException();
				}
			}
			catch(InputMismatchException e)
			{
				System.out.println("Please only use Y or N");
			}
		}
		//If empty
		else if(myShop.getShopCart().isEmpty())
		{
			System.out.println("Your shopping cart is empty! Please add something to your cart before attempting to finalise purchases!");
		}
	}
	
	/**
	 * This method checks whether the user has anything in its cart. If there is nothing, it provides a suitable message to the user and exits the
	 * application. If there is an item in the cart, It asks the user if it is sure it wants to quit. If yes, then it does not purchase the items
	 * and quits the application. If no, then it returns to the menu.
	 */
	public static void quitFunction() throws InputMismatchException // COMPLETED
	{
		//If not empty
		if(!myShop.getShopCart().isEmpty())
		{
			System.out.println("Are you sure you want to quit? You have unpaid items in your cart. These items will not be purchased if you quit.(Y/N)");
			
			try
			{
				char choice = keyboard.next().charAt(0);
				if(choice == 'Y' || choice == 'y')
				{
					System.out.println("Thank you for using the online shop! Have a good day");
					System.exit(0);
				}
				else if(choice == 'N' || choice == 'n')
				{
					System.out.println("Returning to menu!");
				}
				else
				{
					throw new InputMismatchException();
				}
			}
			catch(InputMismatchException e)
			{
				System.out.println("Please only use Y or N");
			}
		}
		//If empty
		else if(myShop.getShopCart().isEmpty())
		{
			System.out.println("Thank you for using the online shop! Have a good day");
			System.exit(0);
		}
	}
	
	/**
	 * This is the main method. It comprises of all the functions defined earlier. It holds the main menu functions
	 * for the user. It also handles exceptions. If there is an incorrect input by the user, it will present
	 * an appropriate message and bring the user back to the menu.
	 * 
	 * @param args
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException, InputMismatchException
	{
		int menuInput = 0;
		System.out.println("Welcome to the Online Gaming shop!!");
		readPurchaseHistoryData(database, "purchase-history.txt");
		while(true)
		{
			System.out.println("----------------");
			System.out.println("Online shop menu");
			System.out.println("----------------");
			System.out.println("1. Add product to cart");
			System.out.println("2. View your shopping cart");
			System.out.println("3. Finalise purchases");
			System.out.println("4. Quit");
			try
			{
				menuInput = keyboard.nextInt();
				if(menuInput == 1)
				{
					addProductToCart();
				}
				else if(menuInput == 2)
				{
					viewShoppingCart();
				}
				else if(menuInput == 3)
				{
					finalisePurchase();
				}
				else if(menuInput == 4)
				{
					quitFunction();
				}
			}
			catch(InputMismatchException e)
			{
				System.out.println("That was not a correct input. Please use numbers 1-4 for the menu options.");
				keyboard.next();
			}
		}
	}
}
