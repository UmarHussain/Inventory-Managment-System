package com.okta.developer.ims.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.okta.developer.ims.model.base.BaseEntity;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor
@Table(name = "user_role")
public class UserRole extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", insertable = false, nullable = false,columnDefinition = "INTEGER(11)")
  private Integer id;

  @Column(name = "user_role", nullable = false)
  private String userRole;

  @Column(name = "enabled", nullable = false, columnDefinition = "BIT(1)")
  private Integer enabled;

}