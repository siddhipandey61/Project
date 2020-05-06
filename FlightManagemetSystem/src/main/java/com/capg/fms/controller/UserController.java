package com.capg.fms.controller;

import java.awt.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capg.fms.controller.UserController;
import com.capg.fms.model.User;
import com.capg.fms.exception.UserNotFoundException;
import com.capg.fms.service.IUserService;


@RestController
@RequestMapping("/User")
public class UserController {

	private static final Logger Log= LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private IUserService IUserService;
	
	
	
	
//  @GetMapping("/Login")
//  public String index(@RequestParam("userID") String userID,
//	      @RequestParam("userPassword")  StringPassword)
// {
//    String str="validuser";
//
//     {
//     
//     }
//     return str;
//
	
	
	@GetMapping("/AddingProducts")
	public User index(@Validated @RequestParam("userAge") int userAge, @RequestParam("userID") int  userID,
			@RequestParam("userName") String userName, @RequestParam("userPassword") String userPassword, @RequestParam("userPhone") long userPhone, @RequestParam("userEmail") String userEmail)
	{
		
	  User user = new User(userAge, userID, userName, userPassword, userPhone, userEmail);
	  
	  return IUserService.addUser(user);
	}
	
	@GetMapping("/DisplayingDetails")
	public List<User> viewUser(){
		return IUserService viewUser();
	}
	@GetMapping("/userByID")
	public Optional<User> findOne(@RequestParam("userID") UserNotFoundException)
			{
		Optional<User> b = IUserService.viewUserByID(userID);
			if (!b.isPresent())
				throw new UserNotFoundException("ID " + userID);
			return b;
			}
	
// @DeleteMapping("/user/{userID}")
// void deleteEmployee(@PathVariable int userID) {
// IUserService.deleteByID(userID);
//  }
	
	
	@GetMapping("/delete")
	 void delete(@RequestParam("userID") int userID) {
		IUserService.deleteUserByID(userID);
		
	}
	
	
	@PutMapping("/user"/{userID}")"
	public Optional<User> updateUser(@RequestBody User user, @PathVariable("userID") int userID) {
		return IUserService.updateByID(userID);
		
	}
		
	}
	  