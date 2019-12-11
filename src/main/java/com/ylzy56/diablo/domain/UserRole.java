package com.ylzy56.diablo.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "user_role")
public class UserRole {
    @Id
    @Column(name = "user_id")
    private String userId;

    @Id
    @Column(name = "role_id")
    private String roleId;

}