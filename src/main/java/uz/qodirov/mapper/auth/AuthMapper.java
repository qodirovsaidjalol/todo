package uz.qodirov.mapper.auth;

import org.mapstruct.Mapper;
import uz.qodirov.dto.auth.UserCreateDto;
import uz.qodirov.entity.auth.AuthUser;

@Mapper(componentModel = "spring")
public interface AuthMapper {
    AuthUser fromCreateDto(UserCreateDto dto);
}
