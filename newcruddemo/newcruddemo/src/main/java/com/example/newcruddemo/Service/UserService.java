package com.example.newcruddemo.Service;

import java.util.List;

import com.example.newcruddemo.Dto.UserDto;

public interface UserService {

	List<UserDto> getAllUsers();
	
	UserDto createUser(UserDto userDto);
	
	void deleteUser(Integer id);
	
	UserDto updateUser(UserDto userDto, Integer id);
	
	UserDto getUserById(Integer id);
	
}
