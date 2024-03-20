package com.cydeo.controller;

import com.cydeo.bootstrap.DataGenerator;
import com.cydeo.dto.UserDTO;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController
{

  RoleService roleService;
  UserService userService;

  public UserController(RoleService roleService, UserService userService)
  {
    this.roleService = roleService;
    this.userService = userService;
  }

  @GetMapping("/create")
  public String createUser(Model model)
  {
    model.addAttribute("user", new UserDTO());
    model.addAttribute("roles", roleService.findAll()); //coming from DataBase/ Data Generator
    model.addAttribute("users", userService.findAll());

    return "/user/create";
  }

  @PostMapping("/create")
  public String insertUser(@ModelAttribute("user")UserDTO user, //passes User Object from createUser method
      Model model)
  {
    userService.save(user); // Object from method parameter
    return "redirect:/user/create"; //redirects to the same endpoint
  }

  @GetMapping("/update/{username}")
  public String editUser(@PathVariable("username")String username, Model model)
  {
    model.addAttribute("user", userService.findById(username));
    model.addAttribute("roles", roleService.findAll());
    model.addAttribute("users", userService.findAll());
    return "user/update";
  }

  @PostMapping("/update")
  public String updateUser(UserDTO user)
  {
    userService.update(user);
    return "redirect:/user/create";
  }
}
