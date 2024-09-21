package com.chandan.service;

import com.chandan.entity.User;

public interface UserService {

	public User CreateUser(User user);

	public void removeSessionMessage();

}
