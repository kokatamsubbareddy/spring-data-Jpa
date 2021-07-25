package com.javatechie.spring.data.jpa.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.spring.data.jpa.api.model.User;
import com.javatechie.spring.data.jpa.api.service.UserService;

@RestController
@RequestMapping("/spring-data-jpa")
public class UserController {
	@Autowired
	private UserService service;
//http://localhost:9092/spring-data-jpa/getUsers
	@GetMapping("/getUsers")
	public List<User> getAllUsers() {
		return service.getUsers();
	}
//http://localhost:9092/spring-data-jpa/getUserByProfession/IT
	@GetMapping("/getUserByProfession/{profession}")
	public List<User> getUserByProfession(@PathVariable String profession) {
		return service.getUserByProfession(profession);
	}
//http://localhost:9092/spring-data-jpa/getUserCount/23
	@GetMapping("/getUserCount/{age}")
	public String getCountByAge(@PathVariable int age) {
		long count = service.getCounts(age);
		return "total no of records : " + count;
	}
//http://localhost:9092/spring-data-jpa/delete/q
	@DeleteMapping("/delete/{name}")
	public List<User> deleteUser(@PathVariable String name) {
		return service.deleteUser(name);
	}
//http://localhost:9092/spring-data-jpa/findMultiCondition/IT/23
	@GetMapping("/findMultiCondition/{profession}/{age}")
	public List<User> getUsersByProfessionAndAge(@PathVariable String profession, @PathVariable int age) {
		return service.findByMultiCondition(profession, age);
	}

	@GetMapping("/getUsersIgnoreCase")
	public List<User> getUsersByprofession(@RequestParam("profession") String profession) {
		return service.getUsersIgnoreCase(profession);
	}
//http://localhost:9092/spring-data-jpa/getSort/id
	@GetMapping("/getSort/{field}")
	public List<User> getSortedUsers(@PathVariable String field) {
		return service.getUserSort(field);
	}
//http://localhost:9092/spring-data-jpa/getPaginatedData
	@GetMapping("/getPaginatedData")
	public Page<User> getPaginatedRecords() {
		return service.getPaginatedUser();
	}
//http://localhost:9092/spring-data-jpa/getRecordsByCustomQuery
	@GetMapping("/getRecordsByCustomQuery")
	public List<User> getUsersByCustomQuery() {
		return service.getUsersCustomQuery();
	}
}
