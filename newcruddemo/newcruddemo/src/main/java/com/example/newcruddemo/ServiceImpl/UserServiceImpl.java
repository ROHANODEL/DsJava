package com.example.newcruddemo.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.newcruddemo.Dto.UserDto;
import com.example.newcruddemo.Exception.ResourceNotFoundException;
import com.example.newcruddemo.Model.EducationEntity;
import com.example.newcruddemo.Model.UserEntity;
import com.example.newcruddemo.Repository.UserRepo;
import com.example.newcruddemo.Service.UserService;

@Service
public class UserServiceImpl implements UserService  {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<UserDto> getAllUsers() {
		List<UserEntity> users = this.userRepo.findAll();
		List<UserDto> userDtos = users.stream().map(user->this.entityToDto(user)).collect(Collectors.toList());
		return userDtos;	
	}

	@Override
	public UserDto createUser(UserDto userDto) {
		System.out.println("//////////////");
		System.out.println(userDto.getId());
		
		UserEntity user = this.dtoToEntity(userDto);
		UserEntity saveUser = this.userRepo.save(user);
		return this.entityToDto(saveUser);
	}
	
	@Override
	public void deleteUser(Integer id) {
		UserEntity user = this.userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("user", "id", id));
		this.userRepo.delete(user);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer id) {
		UserEntity user1 = this.userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("user", "id", id));
		user1.setId(userDto.getId());
		user1.setName(userDto.getName());
		user1.setSurname(userDto.getSurname());
		user1.setEmail(userDto.getEmail());
		
		UserEntity updateUser = this.userRepo.save(user1);
		UserDto userDto1 = this.entityToDto(updateUser);
		return userDto1;
	}

	@Override
	public UserDto getUserById(Integer id) {
		UserEntity user = this.userRepo.findById(id).orElseThrow();
		return this.entityToDto(user);
	}
	
	
	
	
	public UserDto entityToDto(UserEntity userEntity)
	{
		UserDto userDto = this.modelMapper.map(userEntity, UserDto.class);
		return userDto;
//		UserDto userDto = new UserDto();
//		userDto.setId(user.getId());
//		userDto.setName(user.getName());
//		userDto.setSurname(user.getSurname());
//		userDto.setEmail(user.getEmail());
//		userDto.setAbout(user.getAbout());
//		return userDto;
	}
	
	private UserEntity dtoToEntity(UserDto userDto) {
		UserEntity user = this.modelMapper.map(userDto, UserEntity.class);
		
		for(EducationEntity edu: user.getEducations()) {
			edu.setUserEntity(user);
		}
		
		//	for(EducationEntities edu: user.getEducations()) {
		//		edu.setUserEntities(user);
		//	}
		
		return user;
//		User user = new User();
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setAbout(userDto.getAbout());
//		user.setPassword(userDto.getPassword());
//		return user;
	}
	
}




