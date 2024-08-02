package com.image.mapsturt;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.web.multipart.MultipartFile;

import com.image.dto.UserDto;
import com.image.dto.UserImageDto;
import com.image.entity.UserEntity;
import com.image.entity.UserImage;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface MapperSturt {

	UserDto convertToDto(UserEntity entity);

	UserEntity convertToEntity(UserDto dto);

	List<UserDto> convertToList(List<UserEntity> dtossDtos);

	UserImage convertToUserImage(UserImageDto dto, MultipartFile file);

	UserImageDto convertToUserImageDto(UserImage image);

}
