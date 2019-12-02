package com.ylzy56.diablo.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "e_user")
public class UserInfo {
    /**
     * ��ҵ�û�id
     */
    @Id
    @Column(name = "user_id")
    private Integer userId;

    /**
     * �û�����
     */
    private String username;

    /**
     * ����
     */
    private String password;

    /**
     * �ֻ���
     */
    private String mobile;

    /**
     * ��ҵid
     */
    @Column(name = "enterprise_id")
    private Integer enterpriseId;

    /**
     * �˺ż���(0:ĸ�˺�)
     */
    private String level;

    /**
     * ʹ��״̬(0:����,1:�쳣)
     */
    private String status;

    /**
     * �Ƿ�ɾ��(0:δɾ��,1:ɾ��)
     */
    @Column(name = "is_del")
    private String isDel;
/*@JoinTable(name = "parties_contents", joinColumns = {@JoinColumn(name = "party_id",referencedColumnName = "party_id")}, inverseJoinColumns = {@JoinColumn(name = "content_id",referencedColumnName = "content_id")})*/

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_role" , joinColumns = {@JoinColumn(name = "user_id",referencedColumnName = "user_id")},inverseJoinColumns = {@JoinColumn(name ="role_id",referencedColumnName = "role_id")})
    private List<Role> roles;



}