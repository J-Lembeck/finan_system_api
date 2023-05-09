package com.project.pac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.pac.bean.UserBean;
import com.project.pac.service.UserService;

@RestController
@RequestMapping(value="/user")
public class UserContoller {

	@Autowired
	UserService userService;
	
	@GetMapping(path="/findAll")
	public List<UserBean> findAll(){
		return userService.findAll();
	}
	
	@GetMapping(path="/find")
	public UserBean findById(@RequestParam("id") Long id){
		return userService.findById(id);
	}
	
	@PostMapping(path="/login")
	public Boolean login(@RequestBody UserBean user) {
		return userService.login(user);
	}
}
