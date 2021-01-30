//************************************************************************
//	Token -- Represents a Token for the Homeless
//  
//  Student Name: Jimmy N Smith
//  Date: 01/14/21
//  Description of class: CIT 249 (4206_19Z1)
//	Known issues with code: no known issues
//
//************************************************************************

//*******************************************
//
//DOCUMENT CODED METHODS BEFORE TURNING IN
//
//*******************************************

import java.util.Random;

public class Token
{

	//***********************************************************************************
	//  Instance variables
	//		cardName	Description of card
	//	    cardRank	Rank of card
	//***********************************************************************************

	private String ID = "";
	private String firstName = "", lastName = "";
	private int quadrant = 0;
	private double balance = 0.0;	
	private boolean alerts[] = {false, false, false};
	

	//***********************************************************************************
	//  Constructor
	//***********************************************************************************

	public Token(String ID, String firstName, String lastName, int quadrant)
	{
		String defaultID = Integer.toString(99999);
		
		if (ID.length() == 5 && isAllDigits(ID) == true)
		{
			this.ID = ID;
		}
		else ID = defaultID;
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.quadrant = quadrant;
		
		balance = 0.0;
		alerts[0] = true;
	}


	//***********************************************************************************
	//  Accessors for ID, lastName, firstName, quadrant, balance, alerts
	//***********************************************************************************

	public String getID()
	{	
		return ID;
	}

	public String getLastName()
	{	
		return lastName;
	}

	public String getFirstName()
	{	
		return firstName;
	}		
	
	public int getQuadrant() 
	{	
		return quadrant;
	}
		
	public double getBalance() 
	{	
		return balance;
	}
		
	/******************************
	 * 
	 * only returns singleAlert if
	 * it is equal to the
	 * size of the alerts array
	 * 
	 ******************************
	 */
	
	public boolean getAlert(int singleAlert) 
	{	
		if (singleAlert >= 0 && singleAlert < 3)
		{
			return alerts[singleAlert];
		}
		else return false;
	}	
	
	//***********************************************************************************
	//  Mutators for lastName, firstName, and quadrant
	//***********************************************************************************

	/************************************************
	 * 
	 * only sets lastName if the length is 
	 * greater than zero
	 * 
	 * **********************************************
	 */
	
	public void setLastName(String lastName) 
	{
		if (lastName.length() > 0) 
		{ 
			this.lastName = lastName;
		}
		else lastName = "";
	}
		
	/**************************************************
	 * 
	 * only sets firstName if length greater than zero
	 * 
	 **************************************************
	 */
	
	public void setFirstName(String firstName) 
	{
		if (firstName.length() > 0) 
		{ 
			this.firstName = firstName;
		}
		else firstName = "";
	}
		
	
	/*****************************************************
	 * 
	 * only sets quadrant if it is greater than
	 * zero and less than or equal to the max size of 15
	 * 
	 *****************************************************
	 */
	
	public void setQuadrant(int quadrant) 
	{
		if (quadrant > 0 && quadrant <= 15)
		{ 
			this.quadrant = quadrant;
		}
		else quadrant = 0;
	}


	//***********************************************************************************
	//  Helping methods
	//***********************************************************************************
	
	/****************************************************
	 * sets balance equal to balance plus the donation.
	 * 
	 * doesn't return true if the donation is zero
	 * 
	 *****************************************************
	 */
	
	public boolean addToBalance(double donation)
	{
		balance = balance + donation;
		
		if (donation == 0) 
		{
			return false;
		}
		else return true;
	}
	
	/*******************************************
	 * first runs a check to see if token can
	 * afford purchase.
	 * 
	 * only sends true if purchase amount is
	 * greater than zero
	 * 
	 *******************************************
	 */
	
	public boolean buyItem(double purchaseAmount)
	{
		if( balance > 0)
		{
			balance = balance - purchaseAmount;
		}
		
		if (purchaseAmount <= 0)
		{
			return false;
		}
		else return true;
	}
	
	/*****************************
	 * 
	 * set alert in array location
	 * equal to singleAlert to true
	 * 
	 ******************************
	 */
	
	public void setAlert(int singleAlert) 	
	{
		alerts[singleAlert] = true;
	}
	
	/*****************************
	 * 
	 * set alert in array location
	 * equal to singleAlert to false
	 * 
	 ******************************
	 */
	
	public void clearAlert(int singleAlert)	
	{
		alerts[singleAlert] = false;
	}		
		
	public boolean isAllDigits (String testString)	
	{	/*------------------------------------------------------------------------------
		 *  isAllDigits() verifies that each character in a string is a numeric digit
		 *
		 *  The method returns a true value if all characters are digits and returns
		 *  a false value if any of the characters is not a digit.
		 * ----------------------------------------------------------------------------*/
		
		char[ ] testStringAsChar = testString.toCharArray();
		for (char c : testStringAsChar) {
			if (! Character.isDigit(c)) 	
				return false;
		}
		return true;
	}
	

	//***********************************************************************************
	//  toString() Method returns a String (DOES NOT DISPLAY ANYTHING)
	//  
	//  The string returned should contain all of the instance data items in a pleasing
	//  format.
	//***********************************************************************************

 	public String toString()
	{	
 		String tokenSummary;
 		tokenSummary = "This Token Belongs To " + firstName + " " + lastName + "." + "\n" + "User ID: " + ID + "\n" 
 				+ "Balance: " + balance + "\n" + "Last Known Quadrant: " + quadrant + "\n" + "Current Alerts Status: " 
 				+ alerts[0] + ", " + alerts[1] + ", " + alerts[2];
 		return tokenSummary;
	}
}

