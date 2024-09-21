package com.chandan.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.chandan.entity.User;
import com.chandan.repository.UserRepo;
import com.chandan.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public User CreateUser(@Valid User user) {

		String password = passwordEncoder.encode(user.getPassword());
		user.setPassword(password);
		user.setRole("ROLE_USER");
		return userRepo.save(user);
	}

	@Override
	public void removeSessionMessage() {

		HttpSession session = ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest()
				.getSession();
		session.removeAttribute("msg");

	}

}
