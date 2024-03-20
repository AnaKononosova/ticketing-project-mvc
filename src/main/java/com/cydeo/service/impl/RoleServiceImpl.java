package com.cydeo.service.impl;

import com.cydeo.dto.RoleDTO;
import com.cydeo.service.RoleService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends AbstractMapService<RoleDTO, Long> implements RoleService
{

  @Override
  public RoleDTO save(RoleDTO object)
  {
    return super.save(object.getId(), object);
  }

  @Override
  public List<RoleDTO> findAll()
  {
    return super.findAll();
  }

  @Override
  public RoleDTO findById(Long id)
  {
    return super.findBy(id);
  }

  @Override
  public void deleteById(Long id)
  {
    super.deleteById(id);
  }

  @Override
  public void update(RoleDTO object)
  {
    super.update(object.getId(), object);
  }
}
