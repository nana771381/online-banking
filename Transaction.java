package onlineBanking;
import java.util.*;
import java.util.ArrayList;
			
public class Transaction extends Account{
	
	private double balance;
	private Date date;
	private String target;
	private boolean status=false;
	private double amount;
	private double transferFee;
	
	//default constructor for initialization of the variables
	public Transaction () {
		target = "";
		balance = 5000.00;
		amount = 0;
	}

	//overloading constructors
	public Transaction ( String t,double a, double b,boolean f) {
		target = t;
		amount = a;
		balance = b;
		status = f;
	}
	
	//getters and setters
	
	public double getTransferFee() {
		return transferFee;
	}

	public void setTransferFee(double a) {
		this.transferFee = a*0.1;
		balance = balance - transferFee;
	}
	
	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getTarget() {
		return target;
	}


	public void setTarget(String target) {
		this.target = target;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void credit (double c) {
		balance = balance - c;
		
	}
	
	public void debit (double d) {
		balance = balance + d;
	}
	
	
	public void setStatus (boolean s) {
		status =s;
	}
	
	public boolean getStatus() {
		return status;
	}
	
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}



	private ArrayList<Transaction> transactions = new ArrayList<Transaction>();
	
	
	public void addTransaction (Transaction t) {
	    if (transactions.size() + 1 > 6)
	        transactions.remove(0); 

	    transactions.add(t);
	}
	
	public void displayTransactions(ArrayList<Transaction> arr) {
			
			for (Transaction list : arr) {
				String st = list.getStatus() == true?"-":"+";
				System.out.println("---------------------------");
				System.out.println("Date         : " + list.getDate() + "\n" +
						"Target       : " + list.getTarget () + "\n" +
						"Amount       : " + " RM "+ st + list.getAmount() + "\n" +
						"Transfer Fee : " + " RM "+ "-" + list.getTransferFee() + "\n" +
						"Balance      : " + " RM "+ list.getBalance());
			}
			
		}

}
