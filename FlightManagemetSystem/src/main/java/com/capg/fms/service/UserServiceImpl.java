package com.capg.fms.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import javax.xml.ws.ServiceMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.capg.fms.model.User;
import com.capg.fms.service.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	List<User> user=new ArrayList<>();
	@Autowired
	private UserRepository userRepository;
	
	@Override
	@Transactional
	public User addUser(@Validated User user) {
		
		return userRepository.save(user);
	}
	@Override
	@Transactional
	public List<User> viewUser() {
		
		return (List<User>) userRepository.findAll();
		
		
		
	
	@Override
	@Transactional
	public Optional<User> viewUserByID(int ID) {
		
		Optional<User> UserObj=userRepository).findByID(ID);
		
		return UserObj;
	}
	
	
	
	
	@Override
	@Transactional
	public boolean deleteUserByID(int userID) {
		userRepository.deleteByID(userID);
	}

	@Override
	@Transactional
	public void deleteUserByID(int userID) {
		UserRepository.deleteByID(userID);
		
	}
	@Override
	@Transactional
	public Optional<User> updateByID(@RequestBody User user, @PathVariable int userID) {
		
		return userRepository.findByID(userID)
				.map(users  ->  {
					users.setUserType(user.getUserType());
					users.setUserName(user.getUserName());
					users.setUserPassword(user.getUserPassword());
					users.setUserPhone(user.getUserPhone());
					users.setUserEmail(user.getUserEmail());
				
					
			return userRepository.save(user);
				}
	@Override
	public boolean updateUser(int ID) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void deleteUserByID(int userID) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Optional<User> updateByID(int userID) {
		// TODO Auto-generated method stub
		return null;
	}};
//for(int i=0;i< user.size();i++)
//(
//User userObj=user.get(i);
//if(userObj.getUserID()==(userID))
// {
//     users.set(i, user);
//      return;
//	}
// }

