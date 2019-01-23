package com.okta.developer.ims.model;

import javax.persistence.*;

import com.okta.developer.ims.model.base.BaseEntity;
import lombok.Data;

import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "user")
public class ApplcationUser extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, nullable = false, columnDefinition = "INTEGER(11)")
    private Integer id;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "enabled", nullable = false, columnDefinition = "BIT(1)")
    private Integer enabled;

    @JoinColumn(name = "user_role_id", referencedColumnName = "ID")
    @ManyToOne
    private UserRole userRole;

}