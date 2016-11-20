/**
 * 
 */
package edu.awesome.mumscrum.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import edu.awesome.mumscrum.domain.User;

/**
 * @author sabin
 *
 */
@Component
public class UserValidator implements Validator {
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final String SSN_PATTERN = "^(?!000|666)[0-8][0-9]{2}-(?!00)[0-9]{2}-(?!0000)[0-9]{4}$";

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return User.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors err) {
		User user = (User) obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "name", "user.name.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "username", "user.username.empty");
		if (!user.getEmail().matches(EMAIL_PATTERN)) {
			err.rejectValue("email", "user.email.Notmatched");
		}
		if (!user.getSsn().matches(SSN_PATTERN)) {
			err.rejectValue("ssn", "user.ssn.Notmatched");
		}
	}

}
