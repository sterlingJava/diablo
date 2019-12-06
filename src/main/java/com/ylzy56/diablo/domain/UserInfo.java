package com.ylzy56.diablo.domain;

import lombok.Data;


import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Data
@Table(name = "e_user")
public class UserInfo {
    /**
<<<<<<< HEAD
     * 企业用户id
=======
     * ��ҵ�û�id
>>>>>>> 7a9f05780b6d9ac6935fffc1399eb15440c396cf
     */
    @Id
    @Column(name = "user_id")
    private Integer userId;

    /**
<<<<<<< HEAD
     * 用户姓名
=======
     * �û�����
>>>>>>> 7a9f05780b6d9ac6935fffc1399eb15440c396cf
     */
    private String username;

    /**
<<<<<<< HEAD
     * 密码
=======
     * ����
>>>>>>> 7a9f05780b6d9ac6935fffc1399eb15440c396cf
     */
    private String password;

    /**
<<<<<<< HEAD
     * 手机号
=======
     * �ֻ���
>>>>>>> 7a9f05780b6d9ac6935fffc1399eb15440c396cf
     */
    private String mobile;

    /**
<<<<<<< HEAD
     * 企业id
=======
     * ��ҵid
>>>>>>> 7a9f05780b6d9ac6935fffc1399eb15440c396cf
     */
    @Column(name = "enterprise_id")
    private Integer enterpriseId;

    /**
<<<<<<< HEAD
     * 账号级别(0:母账号)
=======
     * �˺ż���(0:ĸ�˺�)
>>>>>>> 7a9f05780b6d9ac6935fffc1399eb15440c396cf
     */
    private String level;

    /**
<<<<<<< HEAD
     * 使用状态(0:正常,1:异常)
=======
     * ʹ��״̬(0:����,1:�쳣)
>>>>>>> 7a9f05780b6d9ac6935fffc1399eb15440c396cf
     */
    private String status;

    /**
<<<<<<< HEAD
     * 创建人
     */
    private String creator;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改人
     */
    @Column(name = "last_modifier")
    private String lastModifier;

    /**
     * 修改时间
     */
    @Column(name = "last_modify_time")
    private Date lastModifyTime;

    /**
     * 异常原因备注
     */
    private String notes;

    /**
     * 是否删除(0:未删除,1:删除)
     */
    @Column(name = "is_del")
    private String isDel;

    private List<Role> roles;
=======
     * �Ƿ�ɾ��(0:δɾ��,1:ɾ��)
     */
    @Column(name = "is_del")
    private String isDel;
/*@JoinTable(name = "parties_contents", joinColumns = {@JoinColumn(name = "party_id",referencedColumnName = "party_id")}, inverseJoinColumns = {@JoinColumn(name = "content_id",referencedColumnName = "content_id")})*/

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_role" , joinColumns = {@JoinColumn(name = "user_id",referencedColumnName = "user_id")},inverseJoinColumns = {@JoinColumn(name ="role_id",referencedColumnName = "role_id")})
    private List<Role> roles;



>>>>>>> 7a9f05780b6d9ac6935fffc1399eb15440c396cf
}