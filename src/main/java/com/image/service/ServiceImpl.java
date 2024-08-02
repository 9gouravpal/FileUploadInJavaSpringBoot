package com.image.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.image.dto.UserDto;
import com.image.entity.UserEntity;
import com.image.mapsturt.MapperSturt;
import com.image.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ServiceImpl {

	private final UserRepository repository;
	private final MapperSturt mapper;

	public ServiceImpl(UserRepository repository, MapperSturt mapper) {
		super();
		this.repository = repository;
		this.mapper = mapper;
	}

	public UserDto saveDetail(UserDto dto) {
		try {
			UserEntity userdEntity = mapper.convertToEntity(dto);
			userdEntity = repository.saveAndFlush(userdEntity);
			UserDto dto2 = mapper.convertToDto(userdEntity);
			return dto2;
		} catch (Exception e) {
			log.error("detail not save!", e.getMessage());

		}
		throw new NullPointerException();
	}

	public List<UserDto> getAllUser() {
		List<UserEntity> dtossDtos = new ArrayList<>();
		try {
			dtossDtos = repository.findAll();
			if (dtossDtos == null) {
				log.error("All Users not found!");
			}
			List<UserDto> dtos = mapper.convertToList(dtossDtos);
			return dtos;
		} catch (Exception e) {
			log.error("user not found!", e.getMessage());

		}

		throw new NullPointerException();

	}

	public UserDto getUserById(Long id) {
		Optional<UserEntity> getbyidOptional = repository.findById(id);
		if (getbyidOptional.isPresent()) {
			UserEntity entity = getbyidOptional.get();
			UserDto dtouserDto = mapper.convertToDto(entity);
			return dtouserDto;
		} else {
			log.error("id not found!");
		}
		return null;
	}

	public UserDto updateUser(UserDto dto) {
		UserEntity entity = mapper.convertToEntity(dto);
		Optional<UserEntity> userOptional = repository.findById(dto.getId());
		if (userOptional.isPresent()) {
			UserEntity entity1 = userOptional.get();
			entity1 = repository.save(entity);
			UserDto dto1 = mapper.convertToDto(entity1);
			return dto1;
		}
		return null;
	}

	public void deleteById(Long id) {
		Optional<UserEntity> findUser = repository.findById(id);
		if (findUser.isPresent()) {
			repository.deleteById(id);

		} else {
			throw new RuntimeException("User not found with id: " + id);
		}
	}
//
//	public UserDto getByEmail(String email) {
//		Optional<UserEntity> emailOptional = repository.findByEmail(email);
//		if (emailOptional.isPresent()) {
//			UserEntity emailEntity = emailOptional.get();
//			UserDto dtoemaiDto = mapper.convertToDto(emailEntity);
//			return dtoemaiDto;
//		} else {
//			throw new RuntimeException("User not found with Email: " + email);
//		}
//	}

//	public UserDto getByName(String name) {
//		Optional<UserEntity> emailOptional = repository.findByEmail(name);
//		if (emailOptional.isPresent()) {
//			UserEntity emailEntity = emailOptional.get();
//			UserDto dtoemaiDto = mapper.convertToDto(emailEntity);
//			return dtoemaiDto;
//		} else {
//			throw new RuntimeException("User not found with Email: " + name);
//		}
//	}

//	public UserDto getUserByEmailAndName(String name, String email) {
//		Optional<UserEntity> findUserOptional = repository.findByNameAndEmail(name, email);
//		if (findUserOptional.isPresent()) {
//			UserEntity entity = findUserOptional.get();
//			UserDto dUserDto = mapper.convertToDto(entity);
//			return dUserDto;
//
//		} else {
//			throw new RuntimeException("User not found with name and Email: " + name + "or " + email);
//
//		}
//
//	}

	public UserDto getUserByNameEmAndEmail(String name, String email) {

		if (name != null && email != null) {

			UserEntity entity = repository.findByNameAndEmail(name, email);
			if (entity.getEmail().equals(email) && entity.getName().equals(name)) {
				UserDto dto = mapper.convertToDto(entity);

				return dto;
			}
			return null;
		} else if (name != null && email != null) {

			UserEntity entity = repository.findByNameAndEmail(name, email);
//			if ((entity.getEmail().equals(email)) || (entity.getName().equals(name))) 
			if (entity.getEmail().equalsIgnoreCase(email) || entity.getName().equalsIgnoreCase(name)) {
				UserDto dto = mapper.convertToDto(entity);

				return dto;
			}
			return null;
		} else if (name != null) {
			UserEntity entity = repository.findByName(name);
			if (entity.getName().equals(name)) {
				UserDto dto = mapper.convertToDto(entity);
				return dto;
			}
			return null;
		}

		else if (email != null) {
			UserEntity entity = repository.findByEmail(email);
			if (entity.getEmail().equals(email)) {
				UserDto dto = mapper.convertToDto(entity);
				return dto;
			}

			return null;
		} else {
			throw new RuntimeException("User not found with name and Email: " + name + "or " + email);
		}

	}

//		Optional<UserEntity> entiy1 = repository.findByNameAndEmail(name, email);
//
//		if (((email == null || name == null) || (email != null || name != null)) && entiy1.isPresent()) {
//			UserEntity findUserOptional = repository.findByNameOrEmail(name, email);
//			UserDto dto = mapper.convertToDto(findUserOptional);
//			return dto;
//
//		}
//
//		else {
//			throw new RuntimeException("User not found with name and Email: " + name + "or " + email);
//
//		}
}
//	old method of convert to entity to dto
//	private UserEntity convertoEntity(UserDto dto) {
//		try {
//			UserEntity entiy = new UserEntity();
//			entiy.setEmail(dto.getEmail());
//			entiy.setPassword(dto.getPassword());
//			entiy.setName(dto.getName());
//			entiy = repository.saveAndFlush(entiy);
//			return entiy;
//		} catch (Exception e) {
//			log.error("detail not found !", e.getMessage());
//
//		}
//
//		throw new NullPointerException();
//	}
//
//	private UserDto convertoDto(UserEntity entity1) {
//		try {
//			UserDto dto = new UserDto();
//			dto.setEmail(entity1.getEmail());
//			dto.setPassword(entity1.getPassword());
//			dto.setName(entity1.getName());
//			return dto;
//		} catch (Exception e) {
//			log.error("detail not found !", e.getMessage());
//
//		}
//
//		throw new NullPointerException();
//	}
//
//	private List<UserDto> convertToList(UserDto dto) {
//		List<UserDto> listsDtos = new ArrayList<>();
//		listsDtos.add(dto);
//
//		return listsDtos;
//	}
//
//	private List<UserEntity> convertToenList(UserEntity entity) {
//		List<UserEntity> listsDtos = new ArrayList<>();
//		listsDtos.add(entity);
//
//		return listsDtos;
//	}
