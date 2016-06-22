package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UserIO {

	public boolean add(User user, String filepath) {
		try {
			File file = new File(filepath);
			PrintWriter out = new PrintWriter(new FileWriter(file, true));
			out.println(
			  user.getEmail() + "|" 
			+ user.getFirstName() + "|" 
			+ user.getLastName()+ "|"
		    + user.getPhoneNumber());

			out.close();
			return true;
		} catch (IOException e) {
			System.out.println(e);
			return false;
		}
	}

	public User getUser(String email, String filepath) {
		try {
			File file = new File(filepath);
			BufferedReader in = new BufferedReader(new FileReader(file));
			User user = new User();
			String line = in.readLine();
			while (line != null) {
				StringTokenizer t = new StringTokenizer(line, "|");
				if (t.countTokens() < 4) {
					return new User("No info", "No info", "No info", "No info");
				}
				String token = t.nextToken();
				if (token.equalsIgnoreCase(email)) {
					String firstName = t.nextToken();
					String lastName = t.nextToken();
					String phoneNumber = t.nextToken();
					user.setEmail(email);
					user.setFirstName(firstName);
					user.setLastName(lastName);
					user.setPhoneNumber(phoneNumber);
				}
				line = in.readLine();
			}
			in.close();
			return user;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
