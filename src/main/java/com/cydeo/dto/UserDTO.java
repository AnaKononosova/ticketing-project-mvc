package com.cydeo.dto;

import com.cydeo.utils.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO
{
  private String firstName;
  private String lastName;
  private String userName;
  private String password;
  private boolean enabled;
  private String phone;
  private RoleDTO role;
  private Gender gender;
}
