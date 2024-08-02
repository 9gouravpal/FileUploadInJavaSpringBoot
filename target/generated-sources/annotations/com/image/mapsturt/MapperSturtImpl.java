package com.image.mapsturt;

import com.image.dto.UserDto;
import com.image.dto.UserImageDto;
import com.image.entity.UserEntity;
import com.image.entity.UserImage;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-02T15:32:52+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.3 (Eclipse Adoptium)"
)
@Component
public class MapperSturtImpl implements MapperSturt {

    @Override
    public UserDto convertToDto(UserEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( entity.getId() );
        userDto.setName( entity.getName() );
        userDto.setEmail( entity.getEmail() );
        userDto.setPassword( entity.getPassword() );
        userDto.setPhoneNo( entity.getPhoneNo() );

        return userDto;
    }

    @Override
    public UserEntity convertToEntity(UserDto dto) {
        if ( dto == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( dto.getId() );
        userEntity.setName( dto.getName() );
        userEntity.setEmail( dto.getEmail() );
        userEntity.setPassword( dto.getPassword() );
        userEntity.setPhoneNo( dto.getPhoneNo() );

        return userEntity;
    }

    @Override
    public List<UserDto> convertToList(List<UserEntity> dtossDtos) {
        if ( dtossDtos == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( dtossDtos.size() );
        for ( UserEntity userEntity : dtossDtos ) {
            list.add( convertToDto( userEntity ) );
        }

        return list;
    }

    @Override
    public UserImage convertToUserImage(UserImageDto dto, MultipartFile file) {
        if ( dto == null && file == null ) {
            return null;
        }

        UserImage userImage = new UserImage();

        if ( dto != null ) {
            userImage.setImageNo( dto.getImageNo() );
        }

        return userImage;
    }

    @Override
    public UserImageDto convertToUserImageDto(UserImage image) {
        if ( image == null ) {
            return null;
        }

        UserImageDto userImageDto = new UserImageDto();

        userImageDto.setImageNo( image.getImageNo() );

        return userImageDto;
    }
}
