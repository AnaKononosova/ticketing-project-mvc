package com.cydeo.entity;

import com.cydeo.utils.Gender;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class User extends BaseEntity
{
  private String firstName;
  private String lastName;
  private String userName;
  private String password;
  private boolean enabled;
  private String phone;
  private Role role;
  private Gender gender;

  public User(Long id, LocalDateTime insertDateTime, Long insertUserId,
      LocalDateTime lastUpdatedDateTime, Long lastUpdatedUserId, String firstName,
      String lastName, String userName, String password, boolean enabled, String phone, Role role,
      Gender gender)
  {
    super(id, insertDateTime, insertUserId, lastUpdatedDateTime, lastUpdatedUserId);
    this.firstName = firstName;
    this.lastName = lastName;
    this.userName = userName;
    this.password = password;
    this.enabled = enabled;
    this.phone = phone;
    this.role = role;
    this.gender = gender;
  }

  public User(String firstName, String lastName, String userName, String password, boolean enabled,
      String phone, Role role, Gender gender)
  {
    this.firstName = firstName;
    this.lastName = lastName;
    this.userName = userName;
    this.password = password;
    this.enabled = enabled;
    this.phone = phone;
    this.role = role;
    this.gender = gender;
  }
}
