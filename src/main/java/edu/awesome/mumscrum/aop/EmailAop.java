/**
 * 
 */
package edu.awesome.mumscrum.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import edu.awesome.mumscrum.domain.User;
import edu.awesome.mumscrum.email.Email;

/**
 * @author sabin
 *
 */
@Aspect
@Component
public class EmailAop {
	@Autowired
	private Email email;

	@After("execution(* edu.awesome.mumscrum.service.UserServiceImpl.save(..))")
	public void aopEmail(JoinPoint jp) {
		User user = (User) jp.getArgs()[0];
		email.sendEmail(user.getEmail(), "Success",
				"UserName:" + user.getUsername() + " " + "Password:" + user.getPassword());
	}

}
