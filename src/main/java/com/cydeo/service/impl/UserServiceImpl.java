package com.cydeo.service.impl;

import com.cydeo.dto.UserDTO;
import com.cydeo.service.UserService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends AbstractMapService<UserDTO, String> implements UserService
{

  @Override
  public UserDTO save(UserDTO object)
  {
    return super.save(object.getUserName(), object);
  }

  @Override
  public List<UserDTO> findAll()
  {
    return super.findAll();
  }

  @Override
  public UserDTO findById(String username)
  {
    return super.findBy(username);
  }

  @Override
  public void deleteById(String username)
  {
    super.deleteById(username);
  }
}
