package com.image.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.image.dto.UserImageDto;
import com.image.entity.UserImage;
import com.image.mapsturt.MapperSturt;
import com.image.repository.ImageRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserImageService {
	private final ImageRepository repository;
	private final MapperSturt mapperSturt;

	public UserImageService(ImageRepository repository, MapperSturt mapperSturt) {
		super();
		this.repository = repository;
		this.mapperSturt = mapperSturt;
	}

	public UserImageDto saveImage(UserImageDto dto, MultipartFile file) {
		try {
			UserImage image = mapperSturt.convertToUserImage(dto, file);
			image.setImage(file.getBytes());
			image = repository.saveAndFlush(image);
			dto = mapperSturt.convertToUserImageDto(image);
			return dto;
		} catch (Exception e) {
			log.error("image not save!", e.getMessage());
		}
		throw new NullPointerException();
	}

	public byte[] getImageById(Long imageNo) {
		Optional<UserImage> imagEntity = repository.findById(imageNo);
		if (imagEntity.isPresent()) {
			return imagEntity.get().getImage();

		}
		throw new NullPointerException();

	}
}
