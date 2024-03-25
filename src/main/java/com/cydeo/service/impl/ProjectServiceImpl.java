package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.service.ProjectService;
import com.cydeo.utils.Status;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl extends AbstractMapService<ProjectDTO, String> implements
    ProjectService
{

  @Override
  public ProjectDTO save(ProjectDTO object)
  {
    if(object.getProjectStatus() == null){
      object.setProjectStatus(Status.OPEN);
    }
    return super.save(object.getProjectCode(), object);
  }

  @Override
  public List<ProjectDTO> findAll()
  {
    return super.findAll();
  }

  @Override
  public ProjectDTO findById(String s)
  {
    return super.findBy(s);
  }

  @Override
  public void deleteById(String s)
  {
    super.deleteById(s);
  }

  @Override
  public void update(ProjectDTO object)
  {
    ProjectDTO projectDTO = findById(object.getProjectCode());

    if(object.getProjectStatus()==null)
    {
      object.setProjectCode(projectDTO.getProjectCode());
    }
    super.update(object.getProjectCode(), object);
  }

  @Override
  public void complete(ProjectDTO projectDTO)
  {
   projectDTO.setProjectStatus(Status.COMPLETE);
  }
}
