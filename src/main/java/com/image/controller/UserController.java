package com.image.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.image.dto.UserDto;
import com.image.service.ServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@RestController
@Tag(name = "This api is related to the user details", description = "User API")
@RequestMapping("/userDetail")
@CrossOrigin("*")
@Slf4j
public class UserController {

	private final ServiceImpl service;

	public UserController(ServiceImpl service) {
		super();
		this.service = service;
	}

	@PostMapping("/save")
	@Operation(summary = "Save a new user", description = """
			**Endpoint:** /save

			**Method:** POST

			**Description:** Save a new user record identified by its usr id (userId).

			**Request Body:** `UserDto` object containing user details.

			**Output:** Response with the saved userd details.
			""")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "user  successfully saved"),
			@ApiResponse(responseCode = "400", description = "Invalid input data") })
	public ResponseEntity<Object> saveDetail(@RequestBody UserDto dto) {

		UserDto dto2 = service.saveDetail(dto);

		return new ResponseEntity<>(dto2, HttpStatus.OK);
	}

	@GetMapping("/getAllUser")
	@Operation(summary = "Get user by user id", description = """
			**Endpoint:** /getAllUser

			**Method:** GET

			**Description:** GET user by his userID record identified by its user (userId).

			**Request Body:** `UserDto` object containing user details.

			**Output:** Response with the saved userDto details.
			""")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "get successfully saved"),
			@ApiResponse(responseCode = "400", description = "Invalid input data") })
	public ResponseEntity<List<UserDto>> getAllUser() {
		List<UserDto> listdtoList = service.getAllUser();
		return new ResponseEntity<>(listdtoList, HttpStatus.FOUND);
	}

//	@GetMapping("/getByID/{userid}") it is worked on path variable
	@GetMapping("/getByID")
	@Operation(summary = "Get user by user id", description = """
			**Endpoint:** /getByID/{id}

			**Method:** GET

			**Description:** GET user by his userID record identified by its user (id).

			**Request Body:** `UserDto` object containing user details.

			**Output:** Response with the saved userDto details.
			""")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "get successfully saved"),
			@ApiResponse(responseCode = "400", description = "Invalid input data") })
	public ResponseEntity<Object> getById(@RequestParam("userid") Long id) {
		try {
			UserDto dtouserDto = service.getUserById(id);
			return new ResponseEntity<>(dtouserDto, HttpStatus.OK);

		} catch (RuntimeException e) {
			e.getMessage();
		}
		return new ResponseEntity<>("Id not found!", HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/updateUser")
	@Operation(summary = "update  user by user id", description = """
			**Endpoint:** /updateUser

			**Method:** PUT

			**Description:** update user by his userID record identified by its user (id).

			**Request Body:** `UserDto` object containing user details.

			**Output:** Response with the saved userDto details.
			""")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Update successfully saved"),
			@ApiResponse(responseCode = "400", description = "Invalid input data") })
	public ResponseEntity<UserDto> updteUser(@RequestBody UserDto dto) {
		try {
			dto = service.updateUser(dto);
			return new ResponseEntity<>(dto, HttpStatus.OK);
		} catch (RuntimeException e) {
			log.error("user not update !", e.getMessage());
		}
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

//	@DeleteMapping("/delete/{id}") it is worked on pathvariable
	@DeleteMapping("/delete")
	@Operation(summary = "update  user by user id", description = """
			**Endpoint:** /delete/{id}

			**Method:** DELETE

			**Description:** Delete user by his userID record identified by its user (id).

			**Request Body:** `UserDto` object containing user details.

			**Output:** Response with the delete userDto details.
			""")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Delete successfully !"),
			@ApiResponse(responseCode = "400", description = "Invalid input data") })
	public ResponseEntity<String> deleteById(@RequestParam("id") Long id) {
		try {
			service.deleteById(id);
			return new ResponseEntity<>("user deleted succesfully!", HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

//	@GetMapping("/getByEmail")
//	@Operation(summary = "GET  user by user email", description = """
//			**Endpoint:** /delete/{id}
//
//			**Method:** GET
//
//			**Description:** find user by his userID record identified by its user (email).
//
//			**Request Body:** `UserDto` object containing user details.
//
//			**Output:** Response with the find userDto details.
//			""")
//	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "find user successfully !"),
//			@ApiResponse(responseCode = "400", description = "Invalid input data") })
//	public ResponseEntity<Object> getMethodName(@RequestParam("email") String email) {
//		try {
//			UserDto dtoEmail = service.getByEmail(email);
//			return new ResponseEntity<>(dtoEmail, HttpStatus.OK);
//		} catch (RuntimeException e) {
//			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
//		}
//
//	}

//	@GetMapping("/getBynameAndEmail")
//	@Operation(summary = "GET  user by user email and name", description = """
//			**Endpoint:** /getBynameAndEmail
//
//			**Method:** GET
//
//			**Description:** find user by his userID record identified by its user (email,name).
//
//			**Request Body:** `UserDto` object containing user details.
//
//			**Output:** Response with the find userDto details.
//			""")
//	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "find user successfully !"),
//			@ApiResponse(responseCode = "400", description = "Invalid input data") })
//	public ResponseEntity<Object> getMethodName(@RequestParam("name") String name,
//			@RequestParam("email") String email) {
//		try {
//			UserDto dto = service.getUserByEmailAndName(name, email);
//			return new ResponseEntity<>(dto, HttpStatus.OK);
//		} catch (RuntimeException e) {
//			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
//		}
//
//	}

	@GetMapping("/getByNameorEmail")
	@Operation(summary = "GET  user by user email and name", description = """
			**Endpoint:** /getBynameAndEmail

			**Method:** GET

			**Description:** find user by his userID record identified by its user (email,name).

			**Request Body:** `UserDto` object containing user details.

			**Output:** Response with the find userDto details.
			""")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "find user successfully !"),
			@ApiResponse(responseCode = "400", description = "Invalid input data") })
	public ResponseEntity<Object> getMethodNameOrEmail(@RequestParam(required = false, value = "name") String name,
			@RequestParam(required = false, value = "email") String email) {
		try {

			UserDto dto = service.getUserByNameEmAndEmail(name, email);

			return new ResponseEntity<>(dto, HttpStatus.OK);
		} catch (NullPointerException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

}
