package kg.mega.naTV.mappers;

import kg.mega.naTV.entities.Users;
import kg.mega.naTV.entities.dto.UsersDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UsersMapper {
    public UsersDto toDto(Users user);
    public Users toEntity(UsersDto userDto);

    public List<UsersDto> ListToDto(List<Users> userList);
    public List<Users> ListToEntity(List<UsersDto> userDtoList);

}
