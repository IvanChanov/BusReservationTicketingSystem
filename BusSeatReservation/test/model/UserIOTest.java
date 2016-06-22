package model;

import static org.junit.Assert.*;

import java.io.File;
import org.junit.Test;

public class UserIOTest {

	UserIO userIo = new UserIO();
	
	@Test
	public void testAdd() {
		User user = new User("example@gmail.com", "first name", "last name", "0899 133 333");
		File file = new File("emails.txt");
		String path = file.getAbsolutePath();
		boolean result = userIo.add(user, path);
		assertEquals(true, result);

	}
	
	@Test
	public void testGetUser() {
	
		File file = new File("emails.txt");
		String path = file.getAbsolutePath();
		User user1 = new User("example@gmail.com", "first name", "last name", "0899 133 333");
		User user2 = userIo.getUser("example@gmail.com", path);
		boolean result = false ;
		
		if(user1.toString().equals(user2.toString()))
		{
			result = true ;
		}
		
		assertEquals(true, result);
	}
}
