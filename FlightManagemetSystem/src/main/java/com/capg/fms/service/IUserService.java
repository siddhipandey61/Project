package com.capg.fms.service;

import java.util.List;
import java.util.Optional;

import javax.xml.ws.ServiceMode;

import com.capg.fms.model.User;

@ServiceMode
public interface IUserService {
	
	public User addUser(User user);
	public List<User> viewUser();
	public Optional<User> viewUserByID(int ID);
	
	public boolean updateUser(int ID);
	public void deleteUserByID(int userID);
	public Optional<User> updateByID(int userID);
}