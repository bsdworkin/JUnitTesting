package test;

public class BankAccount
{
	// Starting balance
	private float balance = 0.0f;
	// Username and password
	private char[] username = null;
	private char[] password = null;

	public BankAccount(float balance, char[] user, char[] pass)
	{
		this.balance = balance;
		this.username = user;
		this.password = pass;	
	}
	
	
	/*
	 * In order to pass the BankAccount constructor we must make get methods for each
	 * parameter that we plan to inherit to JUnitTest
	 */
	public float getBalance()
	{
		return balance;
	}
	
	public char[] getUser(){
		return username;
	}
	
	public char[] getPass(){
		return password;
	}
	
	
	/*
	 * verify user login
	 */
	public boolean verify(char[] user, char[] pass)
	{
		boolean valid = false;
		if (username == user && password == pass)
			valid = true;
		return valid;
	}

	/*
	 * Add amount to the balance
	 * Needed to change void to float so I will be able to return a value added to the balance
	 * Needed to add balance to the parameter so we can have the existing balance 
	 */
	public float addToBalance(float deposit, float balance)
	{
		balance = balance + deposit;
		//Needed a return statement so I can return new value for balance 
		return balance;
	}

	/*
	 * Withdraw money
	 * Changed to a more practical method name
	 * Needed to add balance to the parameter so we can have the existing balance 
	 */
	public float takeFromBalance(float cash, float balance)
	{
		//Need statements to ensure withdraw isn't more than balance
		if(balance > cash){
			balance = balance - cash;
		}
		else if (balance <= cash ){
			balance = 0;
		}
		//Must return the new balance not the amount of the withdrawal
		return balance;
	}

	/*
	 * Merge two accounts.
	 */
	public BankAccount mergeAccounts(BankAccount account){
		if(account ==null)
			throw new NullPointerException();
		return new BankAccount(this.balance+account.getBalance(),
				this.username,this.password);
	}
	

	
}

