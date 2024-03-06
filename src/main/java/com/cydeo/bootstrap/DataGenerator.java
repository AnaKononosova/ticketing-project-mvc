package com.cydeo.bootstrap;

import com.cydeo.dto.RoleDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import com.cydeo.utils.Gender;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner //Interface provided by Spring. Whenever application is started, this class is gonna be initiated
{

  RoleService roleService; //Always
  UserService userService;

  public DataGenerator(RoleService roleService, UserService userService)
  {
    this.roleService = roleService;
    this.userService = userService;
  }

  @Override
  public void run(String... args) throws Exception
  {
    RoleDTO adminRole = new RoleDTO(1L, "Admin");
    RoleDTO managerRole = new RoleDTO(2L, "Manager");
    RoleDTO employeeRole = new RoleDTO(3L, "Employee");
    RoleDTO directorRole = new RoleDTO(4L, "Director");

    roleService.save(adminRole);
    roleService.save(managerRole);
    roleService.save(employeeRole);
    roleService.save(directorRole);

    UserDTO user1 = new UserDTO("John", "Doe", "john@cydeo.com", "abc1", true, "75493629475", managerRole, Gender.MALE);
    UserDTO user2 = new UserDTO("Greg", "Smith", "geg@cydeo.com", "abc2", true, "75493620485", directorRole, Gender.MALE);
    UserDTO user3 = new UserDTO("Ana", "Doty", "ana@cydeo.com", "abc3", true, "20193629475", managerRole, Gender.FEMALE);
    UserDTO user4 = new UserDTO("Kai", "Lime", "kai@cydeo.com", "abc4", true, "750004629475", employeeRole, Gender.MALE);
    UserDTO user5 = new UserDTO("Mary", "Sore", "mary@cydeo.com", "abc5", true, "7503629475", employeeRole, Gender.FEMALE);

    userService.save(user1);
    userService.save(user2);
    userService.save(user3);
    userService.save(user4);
    userService.save(user5);
  }
}
