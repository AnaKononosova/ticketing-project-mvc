package com.cydeo.controller;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.service.ProjectService;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/project")
public class ProjectController
{

  ProjectService projectService;
  UserService userService;
  RoleService roleService;

  public ProjectController(ProjectService projectService, UserService userService,
      RoleService roleService)
  {
    this.projectService = projectService;
    this.userService = userService;
    this.roleService = roleService;
  }

  @GetMapping("/create")
  public String createProject(Model model)
  {
    model.addAttribute("project", new ProjectDTO());
    model.addAttribute("projects", projectService.findAll());
    model.addAttribute("managers", userService.findManagers());
    return "project/create";
  }

  @PostMapping("/create")
  public String createNewProject(ProjectDTO projectDTO)
  {
    projectService.save(projectDTO);
    return "redirect:/project/create";
  }

  @GetMapping("/delete/{projectCode}")
  public String deleteProject(@PathVariable("projectCode") String projectCode)
  {
    projectService.deleteById(projectCode);
    return "redirect:/project/create";
  }

  @GetMapping("/complete/{projectCode}")
  public String completeProject(@PathVariable("projectCode") String projectCode)
  {
    projectService.complete(projectService.findById(projectCode));
    return "redirect:/project/create";
  }

  @GetMapping("/update/{projectCode}")
  public String updateProject(@PathVariable("projectCode")String projectCode, Model model)
  {
    model.addAttribute("project", projectService.findById(projectCode));
    model.addAttribute("projects", projectService.findAll());
    model.addAttribute("managers", userService.findManagers());
    return "project/update";
  }

  @PostMapping("/update")
  public String updateProjectPost(ProjectDTO projectDTO)
  {
    projectService.update(projectDTO);
    return "redirect:/project/create";
  }


}
