package onlineBanking;
import java.util.*;


public class Banking {
	
	static void menu() {
		System.out.println("--------------------------------------");
		System.out.println("Select the feature you want to access:");
		System.out.println("1 - Check Balance & Transaction Information");
		System.out.println("2 - Online Biling");
		System.out.println("3 - Balance Transfer");
		System.out.println("4 - Update Profile");
		System.out.println("5 - Logout");
		System.out.print("Choice: ");
		
	}
	

	public static void main(String[] args) {
	
		int choice; 
		int choice1;
		int choice2;
		int username;
		String password;
		int count = 1;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome to Nana Online Banking System!");
		
		Account acc = new Account();
		
		ArrayList<Transaction> transactions = new ArrayList<Transaction>();
		Transaction t1 = new Transaction();
		
		Date date2 = new Date();
		t1.setDate(date2);
		t1.setTarget("Company");
		t1.setBalance(5000.00);
		t1.setAmount(0);
		t1.setStatus(false);
		
		transactions.add(t1);
		
		
		System.out.println("---------Please login to your account---------");
		
		
		    
		do {
			username = 999;
			try {
				System.out.print("Please enter your User ID : ");
				username = input.nextInt();	
				if(username!=acc.getUserId()) {
				System.out.println("***Wrong User ID!***");
				}
			}
			catch(Exception e) {
				System.out.println("***Invalid input!***");
				System.out.println("");
				input.nextLine();
			}
		
		} while (username!=acc.getUserId());
		
		
		do {
			password = "lalala";
			try {
				
				System.out.print("Please enter your password: ");
				password = input.next();
				
				if(!password.equals(acc.getPassword())) {
					System.out.println("***Wrong Password!***");
				}
				
			}
			catch(Exception e){
				System.out.println("***Invalid input!***");
				input.nextLine();
			}
			
			
		} while (!password.equals(acc.getPassword()));
		
		
		System.out.println("--------------------------------------");
		System.out.println("You are logged in!");
		
		
		do {
			Transaction trans = new Transaction();
			menu();
			choice = input.nextInt();
			
			switch (choice) {
			
			case 1:
				//Check Balance & Transaction Information
				trans.displayTransactions(transactions);
				
			    break;
				
			case 2:
				//Online Biling
				Date date = new Date();
				
				trans.setDate(date);
				System.out.print("Enter Target : ");
				String t = input.next();
				trans.setTarget(t);
				System.out.print("Enter Amount : RM ");
				double a =input.nextDouble();
				
				Transaction x = transactions.get(count-1);
				trans.setBalance(x.getBalance());
				trans.credit(a);
				trans.setAmount(a);
				trans.setTransferFee(a);
				
				//Since biling is always credit, status is always true
				trans.setStatus(true);
				
				trans.addTransaction(trans);
				transactions.add(trans);
				
				count++;

				break;
			    
			    
			case 3:
				//Balance Transfer
				Date date1 = new Date();
				trans.setDate(date1);
				
				System.out.print("Enter Target : ");
				String ta = input.next();
				trans.setTarget(ta);
				
				System.out.println("Credit or Debit?");
				System.out.println("0-- Credit");
				System.out.println("1-- Debit");
				
				choice1 = input.nextInt();
				
				if(choice1==0) {
					trans.setStatus(true);
					System.out.print("Enter Amount : RM ");
					double p = input.nextDouble();
					Transaction y = transactions.get(count-1);
					trans.setBalance(y.getBalance());
					trans.credit(p);
					trans.setAmount(p);
					trans.setTransferFee(p);

					


				}
				
				else if (choice1==1) {	
					trans.setStatus(false);
					System.out.print("Enter Amount : RM ");
					
					double q = input.nextDouble();
					Transaction z= transactions.get(count-1);
					trans.setBalance(z.getBalance());
					trans.debit(q);
					trans.setAmount(q);
					trans.setTransferFee(q);

					
				}
				
				else {
					System.out.println("Invalid option!");
				}
				trans.addTransaction(trans);
				transactions.add(trans);
				
				count++;
				
				break;
				
			case 4:
				//Update Profile
				
				do {
					System.out.println("--------------------------------------");
					System.out.println("Select the feature you want to access:");
					System.out.println("1 - View Profile");
					System.out.println("2 - Change User ID");
					System.out.println("3 - Change password");
					System.out.println("4 - Exit");
					System.out.print("Choice: ");
					
					choice2 = input.nextInt();
					
					switch(choice2) {
					case 1:
						//view profile
						System.out.println("--------------------------------------");
						System.out.println("This is your profile: ");
						System.out.println("Name     : Lo Yen Xuan");
						System.out.println("User ID  : " + acc.getUserId());
						System.out.println("Password : " + acc.getPassword());
						break;
						
					case 2:
						//Change UserId
						System.out.println("Enter your new User ID: ");
						int v = input.nextInt();
						acc.setUserId(v);
						break;
						
					case 3:
						System.out.println("Enter your new password: ");
						String n= input.next();
						acc.setPassword(n);
						break;
						
					}
										
				}while(choice2 != 4);
				
				break;
			
		
			}
		}while (choice!= 5);
		System.out.println("Logout Successful!");
		System.out.println("Thank You For Using Nana Online Banking System!");
	}

	

}
