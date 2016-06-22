package model;

import javax.servlet.http.Cookie;

public class CookieUtil {

	public String cookieFinder(Cookie cookies[] , String name)
	{
		String value = ""; 
		
		for(Cookie c : cookies)
		{
			if(name.equals(c.getName()))
			{
				value = c.getValue();
			}
		}
		
		return value ;
	}
	
}
