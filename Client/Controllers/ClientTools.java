package client.controllers;

import java.util.regex.Pattern;

public class ClientTools {

	
	/**
	 * validatePhoneNumber returns if phone number is correct
	 * 
	 * @param phoneNo phone number of specific subscriber
	 * @return boolean
	 */
	public static boolean validatePhoneNumber(String phoneNo) {// checks phone number input
		// validate phone numbers of format "1234567890"
		if (phoneNo.matches("\\d{10}"))
			return true;
		// validating phone number with -, . or spaces
		else if (phoneNo.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}"))
			return true;
		// validating phone number with extension length from 3 to 5
		else if (phoneNo.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}"))
			return true;
		// validating phone number where area code is in braces ()
		else if (phoneNo.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}"))
			return true;
		// return false if nothing matches the input
		else
			return false;

	}
	
	
	/**
	 * isValidEmail returns if an email is correct
	 * 
	 * @param email email of specific subscriber
	 * @return boolean
	 */
	public static boolean isValidEmail(String email) { // checks if an email address is valid
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}
	
	public static void swapScreen(String fxml) {
		
	}
}
