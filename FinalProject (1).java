/****************************************
*
* Student Name: Andrew Cart
* Date Due: 11/30/2023
* Date Submitted:11/19/2023
* Program Name: Simple Banking Application
* Program Description: Creates a simple banking application that allows the user to do things such as deposit, withdraw, transfer, and check the money in their bank account.
*
*
****************************************/
package FinalProject;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class FinalProject {

	public static void main(String[] args) {
		Scanner userinput = new Scanner(System.in);
		double bankaccountbalance = 0;
		int loop =1;
		do{System.out.println("--- Main Menu ---\n"
				+ "1. Deposit\n"
				+ "2. Withdraw\n"
				+ "3. Transfer\n"
				+ "4. Balance\n"
				+ "5. Exit");
		int userchoice = userinput.nextInt();
		
		switch(userchoice) {
		case 1:{
			int deposit = 0;
			do {
			System.out.println("--- Deposit ---\n"
					+ "a. Check\n"
					+ "b. Cash\n"
					+ "c. Main menu");
			char depositinput = userinput.next().charAt(0);
			switch(depositinput) {
			case 'a': bankaccountbalance +=Deposit("a Check");
			
					break;
			case 'b': bankaccountbalance+=Deposit("cash");
					  break;
			case 'c': break;
			
			default: {
				System.out.println("You did not enter a correct letter");
				deposit = 1;
			}
			
					
			}
			
		}while(deposit==1);
			break;
		}
		case 2:{
			int withdrawlnumber = 0;
			do {
			System.out.println("--- Withdraw ---\n"
				+ "a. 100\n"
				+ "b. 50\n"
				+ "c. 10\n"
				+ "d. Main menu");
				char withdraw = userinput.next().charAt(0);
				switch(withdraw) {
				case 'a': {bankaccountbalance -= 100;
							System.out.println("You withdrew $100 from your bank account");
							logTransaction("Withdrawl", 100);
							break;
				}
					
				case 'b': {bankaccountbalance -= 50;
				System.out.println("Your withdrew $50 from your bank account");
				logTransaction("Deposit", 50);
				break;
				}
					
				case 'c':{ bankaccountbalance-=10;
							System.out.println("You withdrew $10 from your bank account");
							logTransaction("Deposit", 10);
							break;
				
				}
					
				case 'd': break;
				
				default:{
					System.out.println("You did not enter a correct letter");
					withdrawlnumber = 1;
					
					
				}
					
				}
			
			
			
		}while(withdrawlnumber==1);
			break;
		}
		case 3:{
			int transfernumber = 0;
			do {
			
			System.out.println("--- Transfer ---\n"
				+ "a. Same Bank\n"
				+ "b. Different Bank\n"
				+ "c. Main menu");
		char transferinput = userinput.next().charAt(0);
		switch(transferinput) {
		case 'a':bankaccountbalance -= transfer("your bank");
			break;
		case 'b':bankaccountbalance -= transfer("a different bank");
			break;
		case 'c': break;
		
		default:{
			System.out.println("You did not enter a correct letter");
			transfernumber = 1;
			
		}
			
		}
		
			
			
			
		}while(transfernumber ==1);
			break;
		}
		
		case 4:System.out.println("Your bank account balance is " + bankaccountbalance);
				break;
			
		case 5:{System.out.println("Exitting program");
				System.exit(0);
				break;
		}
				
		default:{System.out.println("You did not enter a correct number;");
				break;
		}
		
		
		}
		}while(loop == 1);
		
	}

	public static double Deposit(String method){
		Scanner user = new Scanner(System.in);
		System.out.println("How much money are you depositing?");
		double depositamount = user.nextDouble();
		System.out.println("You deposited " + method + " worth " + depositamount + "$");
		logTransaction("Deposit", depositamount);
		return depositamount;
	}
	public static double transfer(String whichbank) {
		Scanner userinput = new Scanner(System.in);
		System.out.println("How much did you want to transfer to " + whichbank + " ?");
		double transferamount = userinput.nextDouble();
		System.out.println(transferamount + "$ transferred to " + whichbank);
		logTransaction("Transfer", transferamount);
		return transferamount;
		
		
		
	}
	
	private static void logTransaction(String event, double amount) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("log.txt", true))) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String timeStamp = dateFormat.format(new Date());
            writer.println(timeStamp + " " + event + " $" + amount);
        } catch (IOException e) {
            System.out.println("Error logging the transaction.");
            e.printStackTrace();
        }
    }
}
