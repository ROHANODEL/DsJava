package com.example.newcruddemo.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.newcruddemo.Dto.UserDto;
import com.example.newcruddemo.Repository.UserRepo;
import com.example.newcruddemo.Service.UserService;

@RestController
@RequestMapping("/api/data")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@GetMapping("/userdata")
	public ResponseEntity<List<UserDto>> getAllUsers()
	{
		return ResponseEntity.ok(this.userService.getAllUsers());	
	}
	
	@PostMapping("/userdata")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
		UserDto createUserDto = this.userService.createUser(userDto);
		return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
	}

	@DeleteMapping("/userdata/{id}")
	public String deleteUser(@PathVariable("id") Integer id) {
		this.userService.deleteUser(id);
		return "user deleted successfully";
	}
	
	@PutMapping("/userdata/{id}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable("id") Integer id){
		UserDto updateUser = this.userService.updateUser(userDto, id);
		return ResponseEntity.ok(updateUser);
	}
	
	@GetMapping("/userdata/{id}")
	public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer id){
		return ResponseEntity.ok(this.userService.getUserById(id));
	}
	
	
}

