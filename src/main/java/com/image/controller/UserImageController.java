package com.image.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.image.dto.UserImageDto;
import com.image.service.UserImageService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin("*")
@Tag(name = "Image-API", description = "Image-API")
@RequestMapping("/ImageSave")
public class UserImageController {
	private final UserImageService service;

	public UserImageController(UserImageService service) {
		super();
		this.service = service;
	}

	@PostMapping(value = "/saveImage", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Save a new user image", description = """
			**Endpoint:** /saveImage

			**Method:** POST

			**Description:** Save a new user record identified by its usr id (userId).

			**Request Body:** `UserDto` object containing user details.

			**Output:** Response with the saved userd details.
			""")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "user  successfully saved"),
			@ApiResponse(responseCode = "400", description = "Invalid input data") })
	public ResponseEntity<Object> saveUserImage(@ModelAttribute UserImageDto dto,
			@RequestParam("file") MultipartFile file) {
		dto = service.saveImage(dto, file);
		if (file.isEmpty()) {
			return new ResponseEntity<>("file not found!", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(dto, HttpStatus.OK);

	}

	@GetMapping("/getImageById")
	@Operation(summary = "Save a new user image", description = """
			**Endpoint:** /getImageById

			**Method:** GET

			**Description:** Save a new user record identified by its usr id (imageNo).

			**Request Body:** `byte[]` object containing user details.

			**Output:** Response with the saved userd details.
			""")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "user  successfully saved"),
			@ApiResponse(responseCode = "400", description = "Invalid input data") })

	public ResponseEntity<byte[]> getImage(@RequestParam("imageNo") Long imageNo) {

		byte[] image = service.getImageById(imageNo);
		if (image != null) {
			return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"image.jpg\"")
					.contentType(MediaType.IMAGE_JPEG).body(image);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
