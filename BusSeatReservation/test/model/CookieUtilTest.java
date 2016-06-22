package model;

import static org.junit.Assert.*;

import javax.servlet.http.Cookie;

import org.junit.Test;

public class CookieUtilTest {

	@Test
	public void testCookieFinder() {

		CookieUtil cookieUtil = new CookieUtil();
		
		Cookie cookie1 = new Cookie("emailCookie1" , "emailExample1@gmail.com");
		Cookie cookie2 = new Cookie("emailCookie2" , "emailExample2@gmail.com");
		Cookie cookie3 = new Cookie("emailCookie3" , "emailExample3@gmail.com");
		Cookie cookie4 = new Cookie("emailCookie4" , "emailExample4@gmail.com");
		
		Cookie cookies[] = {cookie3 ,cookie1 , cookie2 , cookie4};
	
		String cookieName = cookieUtil.cookieFinder(cookies, "emailCookie3");
		assertEquals("emailExample3@gmail.com", cookieName);
		
	}

}
