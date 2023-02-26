package kg.mega.naTV.entities.dto;

import lombok.Data;

@Data
public class UsersDto {
    private Long id;
    private String firstName;
    private String lastName;
    private int phoneNumber;
    private String email;

}
