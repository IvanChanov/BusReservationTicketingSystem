package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class CheckRegisterTest {

	@Test
	public void testCheckPhoneNumber1() {
	
		CheckRegister checkRegister = new CheckRegister();
		String correct = "0877456987";
		boolean result = checkRegister.checkPhoneNumber(correct);
		assertEquals(false, result);
		
		
	}
	
	@Test
	public void testCheckPhoneNumber2() {
		
		CheckRegister checkRegister = new CheckRegister();
		String wrong = "0877s456987";
		boolean result =  checkRegister.checkPhoneNumber(wrong);
		assertEquals(true, result);
		
	}

	@Test
	public void testCheckEmailAddress1() {
		CheckRegister checkRegister = new CheckRegister();
		boolean result = false ;
		String arr[] = {"user@gmail.com" , 
						"user@gmail.gm.in" , 
						"user.name@gmail.com" ,
						"user_name@gmail.com" , 
						"user-name@gmail.com" ,
						"user9@gmail.com" , 
						"12user@gmail.com" } ; 
		
		for(String element : arr)
		{
			result = checkRegister.checkEmailAddress(element);
			if(result == true)
			{
				break ;
			}
		}
		
		assertEquals(false, result);
		
	}
	
	@Test
	public void testCheckEmailAddress2() {
		CheckRegister checkRegister = new CheckRegister();
		boolean result = false ;
		String arr[] = {"@yahoo.com" , 
						"user%@gmail.gm.in" , 
						"user@.name@gmail.com" ,
						"user&_name@gmail.com" , 
						"user!name@gmail.com" ,
						"user*@gmail.com" , 
						"user#@gmail.com" } ; 
		
		for(String element : arr)
		{
			result = checkRegister.checkEmailAddress(element);
			if(result == true)
			{
				break ;
			}
		}
		
		assertEquals(true, result);
		
	}

}
