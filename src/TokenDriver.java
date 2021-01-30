/********************************************************************************
// Program : Token Driver
// Name: C Tucker
// Purpose: To test student Token classes
//
// Students are not permitted to modify this program
// ********************************************************************************/


import java.util.Scanner;
import java.io.*;

public class TokenDriver
{
    
    public static void main (String[] args) throws IOException
    {
        /***********************************************************************
         * Declare Variables and display greeting.
         ***********************************************************************/
         
        Scanner fileScan, lineScan;
		String fileRecord = "";
		final String dashes = "------------------------------------";
		int recordNumber = 0;
		Token testPerson;	
		
		/*---------------------------------------------------------------------
		 *   Variables to hold data for a Token object
		 *---------------------------------------------------------------------*/
		String tokenID = "", tokenLastName = "", tokenFirstName = "";
		int tokenQuadrant = 0;
		double tokenBalance = 0.0;
		boolean[ ] alerts = {false, false, false};
		

	 	
       /***************************************************************************************
        * Create a Scanner object to read from a text file
	    **************************************************************************************/    
		 
		fileScan = new Scanner (new File("TokenTest.txt"));
   
       /***************************************************************************************
        * Display a greeting so that the use knows the purpose of the program (driver)
        **************************************************************************************/
       
        System.out.println("****  WELCOME TO THE TOKEN TEST PROGRAM *****\n");
        System.out.println("This program will test student Token classes\n");
  
        
        /***************************************************************************************
         *  A repetition structure is used to read records from a text file. 
		 *  Each record is used to instantiate and test some portion of the student's Token class.
		 
		 *  NOTE:  Input validation is one aspect of including security in software.  This is 
		 *         referred to as "secure coding".  Classes (like the Token class) should always
		 *         validate input.  For user defined classes, like the the Token class, this 
		 *         includes insuring the method parameters contain valid values.
		 *         Input validation should ALSO be included in program which use classes.  You 
		 *         should not pass invalid data to a class.  
		 
		 *         ONE EXCEPTION:  When testing your user-defined classes, like Token, you should
		 *                         test methods with invalid to make sure the user-defined class 
		 *                         appropriately handles all data.
		 *                         This TokenDriver program does both (uses valid and invalid data)
		 *                         to test student Token classes. 
		 **************************************************************************************/
		 
		 
        while (fileScan.hasNext())
        {
            /*---------------------------------------------------------------------------------
			 *  fileRecord is a Scanner object allowing input from a text file
			 *-------------------------------------------------------------------------------*/
			
			fileRecord = fileScan.nextLine();
 
            /*---------------------------------------------------------------------------------
			 *  lineScan is a Scanner object which holds one record from the text file.
			 *  Once created, lineScan, functions like an input buffer for a keyboard.  You
			 *  can read one item at a time from the record.  A comma is used as the delimiter 
			 *  to separate items in the record.
			 *-------------------------------------------------------------------------------*/
	
 
            lineScan = new Scanner(fileRecord);
            lineScan.useDelimiter(",");    

	        /*---------------------------------------------------------------------------------
			 *  Records are counted and lines of dashes are displayed.
			 * 
			 *  The following data is pulled from a record: ID, firstName, lastName, quadrant,
			 *  and balance.  Alerts are not stored in the data file.
			 *-------------------------------------------------------------------------------*/
			
            recordNumber++;
			System.out.println(dashes + dashes + dashes + dashes);
			
            tokenID = lineScan.next(); 
            tokenFirstName = lineScan.next();
            tokenLastName = lineScan.next();
            tokenQuadrant = lineScan.nextInt();
			tokenBalance = lineScan.nextDouble();
			
			/*---------------------------------------------------------------------------------
			 * Validate ID to be the correct length and all digits.  This is done to display 
			 * error(s) to the user.
			 *-------------------------------------------------------------------------------*/
			
			if (tokenID.length() > 5 || tokenID.length() < 5){
				System.out.print("Record # " + recordNumber);
				System.out.print("\t** Error:  ID length is not correct.  Must be 5 digits: ");
				System.out.println("\tID: " + tokenID);
			}
			
			else {
				boolean validID = true;		
				char[ ] testStringAsChar = tokenID.toCharArray();

				for (char c : testStringAsChar) {
					if (! Character.isDigit(c)) 	
						validID = false;
				}
				
				if (! validID){
				System.out.print("Record # " + recordNumber);
				System.out.print("\t** Error:  ID contains non-digits: ");
				System.out.println("\tID: " + tokenID);
				}
			}

			/*---------------------------------------------------------------------------------
			 * Validate quadrant to be between 1 and 14.  This is done to display 
			 * error(s) to the user.
			 *-------------------------------------------------------------------------------*/
			
			if (tokenQuadrant < 0 || tokenQuadrant > 15) {
				System.out.print("Record # " + recordNumber);
				System.out.print("\t** Error:  Error with Quadrant Number: ");
				System.out.println("\tQuadrant: " + tokenQuadrant);
				}
				
			/*---------------------------------------------------------------------------------
			 * Instantiate a Token object with data from the file. 
			 * NOTE:  All new Token objects are instantiated with a zero balance and alerts
			 *        set to true for zero balance alert, false for weather alert, and false
			 *        for the "need to check-in" alert
			 *-------------------------------------------------------------------------------*/
				
			testPerson = new Token(tokenID, tokenFirstName, tokenLastName, tokenQuadrant);
	
			/*---------------------------------------------------------------------------------
			 * A record balance from a file record is used to update the balance for a Token
			 * object.  Negative balances should not be allowed by the Token class method 
			 * addToBalance().
			 *-------------------------------------------------------------------------------*/
	
			if (tokenBalance < 0 ) {
				System.out.print("Record # " + recordNumber);
				System.out.print("\t** Error:  Invalid balance: ");
				System.out.println("\tBalance: " + tokenBalance);
			}	
			else
				testPerson.addToBalance(tokenBalance);

			/*---------------------------------------------------------------------------------
			 * Data from the new Token object is displayed.  This will test all of the accessors
			 * and verifies if the Token class constructor and addToBalance methods worked
			 * correctly.
			 *-------------------------------------------------------------------------------*/
			
			System.out.print("Record # " + recordNumber);
			System.out.println("\tData after instantiation and balance set: \n\t\t");
			System.out.printf("\t\tID: %5s\t %-10s %-10s %2d %10.2f \t %-5b %-5b %-5b \n",  testPerson.getID(), 
				testPerson.getFirstName(), testPerson.getLastName(), testPerson.getQuadrant(), testPerson.getBalance(), 
				testPerson.getAlert(0), testPerson.getAlert(1),testPerson.getAlert(2));
	           
        }
   			
		/********************************************************************************
		 * The next section of code tests the mutators (using last record in the file)
		 * Since the object was instantiated within a loop,
		 *******************************************************************************/     
 			System.out.println(dashes + dashes + dashes + dashes);
			System.out.println("\nTesting mutators on the last record:\n");
			
			testPerson = new Token(tokenID, tokenFirstName, tokenLastName, tokenQuadrant);
			testPerson.addToBalance(tokenBalance);
			
			testPerson.setFirstName("Cindy");
			testPerson.setLastName("Tucker");
			testPerson.setQuadrant(11);
			System.out.printf("\t\tID: %5s\t %-10s %-10s %2d %10.2f \t %-5b %-5b %-5b \n",  testPerson.getID(), 	
				testPerson.getFirstName(), testPerson.getLastName(), testPerson.getQuadrant(), testPerson.getBalance(), 
				testPerson.getAlert(0), testPerson.getAlert(1),testPerson.getAlert(2));		
			
		/********************************************************************************
		 * The next section tests helping methods
		 *
		 * This tests the addToBalance() and buyItem() methods.
		 * It also tests setting alerts.  
		 *
		 * NOTE:  The first alert (zero balance) should be set ONLY IF the balance is zero
		 * NOTE:  The first alert (zero balance) should not be cleared if the balance is zero
		 *******************************************************************************/     
 			System.out.println(dashes + dashes + dashes + dashes);
			System.out.println("\nTesting helping methods on the last record:\n");  

			System.out.printf("Current Balance: %5.2f \n",testPerson.getBalance());
			testPerson.addToBalance(20.00);
			System.out.printf("Adding $20 == New Balance: %5.2f \n",testPerson.getBalance());
			testPerson.buyItem(12.50);
			System.out.printf("Spent $12.50 == New Balance: %5.2f \n",testPerson.getBalance());
			testPerson.setAlert(0);
			testPerson.setAlert(1);
			testPerson.setAlert(2);
			System.out.printf("\nSet all 3 alerts:\t\t %-5b %-5b %-5b \n",  
				testPerson.getAlert(0), testPerson.getAlert(1),testPerson.getAlert(2));	
			testPerson.clearAlert(0);
			testPerson.clearAlert(1);
			testPerson.clearAlert(2);
	
			System.out.printf("Clear all 3 alerts:\t\t %-5b %-5b %-5b \n",  
				testPerson.getAlert(0), testPerson.getAlert(1),testPerson.getAlert(2));	

		/********************************************************************************
		 * The next section tests the toString() method (using the last record from file)
		 *******************************************************************************/ 		
		System.out.println(dashes + dashes + dashes + dashes);
		System.out.println("\nTesting the toString method on the last record\n");  
		System.out.println(testPerson);
		 
		 
		 
    }
}