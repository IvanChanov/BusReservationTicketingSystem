package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckRegister {

	
	public String checkUser(HttpServletRequest request, HttpServletResponse response) {
		
		final Object lock = request.getSession().getId().intern();
		HttpSession session = request.getSession();
		ServletContext sc = request.getServletContext();
		User user = (User) session.getAttribute("user");
		CookieUtil cookieUtil = new CookieUtil();
		UserIO userIo = new UserIO();
		
		String url;
		String emailAddress;
		
		if(user == null)
		{
			Cookie[] cookies = request.getCookies();
			emailAddress = cookieUtil.cookieFinder(cookies, "emailCookie");
			
			if(emailAddress == null || emailAddress.equals(""))
			{
				url="/register.jsp";
			}
			
			else
			{
				String path = sc.getRealPath("/WEB-INF/emailFile/emails.txt");
				synchronized(lock)
				{
					user = userIo.getUser(emailAddress , path);
					session.setAttribute("user", user);
				}
				url = "/reserveATicket.jsp";
			}
		}
		else
		{
			url = "/reserveATicket.jsp";
		}
		return url ;
	}
	

	public String registerUser(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		final Object lock = request.getSession().getId().intern();
		UserIO userIo = new UserIO();
		String email = request.getParameter("email");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String phoneNumber = request.getParameter("phoneNumber");	
		String errorMessageRegistration = "";
		String url = "/reserveATicket.jsp";
		
		if(firstName == null || lastName == null || email == null || phoneNumber == null ||
		   firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || 
		   phoneNumber.isEmpty())
		{
			errorMessageRegistration = "Please fill all text forms";
			request.setAttribute("errorMessageRegistration", errorMessageRegistration);
			return url="/register.jsp";
		}
		
		else if(checkPhoneNumber(phoneNumber))
		{
			errorMessageRegistration = "Phone number is incorrent , need to contain only digits";
			request.setAttribute("errorMessageRegistration", errorMessageRegistration);
			return url="/register.jsp";
		}
		
		else if(checkEmailAddress(email))
		{
			errorMessageRegistration = "Email is incorrect , in user name You can use only these special characters '-','.','_'";
			request.setAttribute("errorMessageRegistration", errorMessageRegistration);
			return url="/register.jsp";
		}
		
		
		else
		{
		User user = new User(email , firstName , lastName , phoneNumber);
		
		ServletContext sc = request.getServletContext();
		String path = sc.getRealPath("/WEB-INF/emailFile/emails.txt");
		
		
		synchronized(lock)
		{
			userIo.add(user , path);
			session.setAttribute("user", user);
		}
		
		Cookie cookie = new Cookie("emailCookie" , email);
		cookie.setMaxAge(60 * 60 * 24 * 365 * 2);
		cookie.setPath("/");
		response.addCookie(cookie);
		
	
		url = "/reserveATicket.jsp";
		return url ;
		}
	}
	
	public boolean checkPhoneNumber(String phoneNumber)
	{
		boolean error = false ;
		
		try
		{
		Integer.parseInt(phoneNumber);
		} catch(NumberFormatException e)
		{
			error = true ;
		}
		
		return error ;
	}
	
	public boolean checkEmailAddress(String email)
	{
		boolean error = false ;
		
		String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		if(!matcher.matches())
		{
			error = true ;
		}
		return error ;
	}
	
	
	
}
