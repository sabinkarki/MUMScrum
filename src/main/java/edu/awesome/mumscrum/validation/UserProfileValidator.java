/**
 * 
 */
package edu.awesome.mumscrum.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import edu.awesome.mumscrum.domain.User;

/**
 * @author sabin
 *
 */
public class UserProfileValidator extends UserValidator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return User.class.equals(arg0);
	}
	@Override
	public void validate(Object obj, Errors err) {
		User emp = (User) obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "password", "Password Should not be blank");
		if (!emp.getPassword().equals(emp.getRetypepassword())) {
			err.rejectValue("passwordConf", "valid.passwordConfDiff");
		}
	}
}
