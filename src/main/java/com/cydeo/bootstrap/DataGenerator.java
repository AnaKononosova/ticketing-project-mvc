package com.cydeo.bootstrap;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.RoleDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.service.ProjectService;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import com.cydeo.utils.Gender;
import com.cydeo.utils.Status;
import java.time.LocalDate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner //Interface provided by Spring. Whenever application is started, this class is gonna be initiated
{

  RoleService roleService; //Always
  UserService userService;
  ProjectService projectService;

  public DataGenerator(RoleService roleService, UserService userService, ProjectService projectService)
  {
    this.roleService = roleService;
    this.userService = userService;
    this.projectService = projectService;
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
    UserDTO user6 = new UserDTO("Alice", "Sory", "alice@cydeo.com", "ab678", true, "7500989475", managerRole, Gender.FEMALE);


    userService.save(user1);
    userService.save(user2);
    userService.save(user3);
    userService.save(user4);
    userService.save(user5);

    ProjectDTO project1 = new ProjectDTO("Chugger", "123", user1, LocalDate.now(), LocalDate.now().plusDays(25), "ETL tool", Status.IN_PROGRESS);
    ProjectDTO project2 = new ProjectDTO("Spring ORM", "123RD", user3, LocalDate.now(), LocalDate.now().plusDays(10), "Database Creation", Status.COMPLETE);
    ProjectDTO project3 = new ProjectDTO("Chugger- 2", "123", user6, LocalDate.now().plusDays(10), LocalDate.now().plusDays(43), "ETL tool", Status.OPEN);
    ProjectDTO project4 = new ProjectDTO("Spring ORM", "1265", user1, LocalDate.now(), LocalDate.now().plusDays(15), "ETL tool", Status.IN_PROGRESS);
    ProjectDTO project5 = new ProjectDTO("Spring MVC", "120RD", user3, LocalDate.now(), LocalDate.now().plusDays(100), "Database Cleanup", Status.IN_PROGRESS);
    ProjectDTO project6 = new ProjectDTO("Chugger- 3", "12IU", user6, LocalDate.now().plusDays(10), LocalDate.now().plusDays(403), "ETL tool", Status.COMPLETE);

    projectService.save(project1);
    projectService.save(project2);
    projectService.save(project3);
    projectService.save(project4);
    projectService.save(project5);
    projectService.save(project6);

  }
}
