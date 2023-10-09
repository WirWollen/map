package vtb.map.map.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vtb.map.map.entities.RoleEntity;
import vtb.map.map.enums.Role;

import javax.persistence.Column;
import javax.persistence.OneToOne;
import java.sql.Timestamp;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String login;
    private String password;
    private String lastName;
//    private Set<Role> roles;
    private Set<RoleEnum> roles;
    private Timestamp dateTime;
    private String name;
    private String surName;
    private String phone;
}

