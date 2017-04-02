package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;



public class JUnitTest
{
	BankAccount ba = null;
	float bal = 450.0f;
	char[] user = {'b','e','n','d','w','o','r','k','i','n'};
	char[] pass = {'i','c','o','d','e'};
	
	
	@Before
	public void intialize(){
		ba = new BankAccount(bal, user, pass);
	}
	
	
	@Test
	public void testCreateAccount(){
		assertEquals(bal, ba.getBalance(),0);
		assertEquals(user, ba.getUser());
		assertEquals(pass, ba.getPass());
	}
	
	@Test
	public void testVerifyAccount(){
		assertTrue(ba.verify(user, pass));
	}
	
	@Ignore
	@Test 
	public void testDeposit(){
		float deposit = 100.50f;
		assertEquals(550.50f, ba.addToBalance(deposit, bal),0);
	}
	
	@Ignore
	@Test 
	public void testWithdrawal(){
		float withDraw1 = 200.0f;
		float withDraw2 = 500.0f;
		assertEquals(250.0f, ba.takeFromBalance(withDraw1, bal),0);
		assertEquals(0.0f, ba.takeFromBalance(withDraw2, bal),0);
	}
	
	@Test 
	public void testMerge(){
		float otherBal = 300.0f;
		BankAccount acc = new BankAccount(otherBal, user, pass);
		assertEquals(750.0f, ba.mergeAccounts(acc).getBalance(),0);
	}
	
	@After
	public void cleanUp(){
		ba = null;
		assertNull(ba);
	}
}





