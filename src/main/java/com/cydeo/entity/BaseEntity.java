package com.cydeo.entity;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BaseEntity
{
  private Long id;
  private LocalDateTime insertDateTime;
  private Long insertUserId;
  private LocalDateTime lastUpdatedDateTime;
  private Long lastUpdatedUserId;
}
