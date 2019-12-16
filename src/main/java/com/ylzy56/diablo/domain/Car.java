package com.ylzy56.diablo.domain;

import com.ylzy56.diablo.domain.entity.UUIdGenId;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import java.util.Date;
import javax.persistence.*;

@Data
@Entity
public class Car {
    @Id
    @Column(name = "car_id")
    @KeySql(genId = UUIdGenId.class)
    private String carId;

    /**
     * 车牌
     */
    @Column(name = "PLATE_NUMBER")
    private String plateNumber;

    /**
     * 车主姓名
     */
    @Column(name = "NAME")
    private String name;

    /**
     * 手机号码
     */
    @Column(name = "PHONE")
    private String phone;

    /**
     * 车辆属性
     */
    @Column(name = "CAR_PROPERTIES")
    private String carProperties;

    /**
     * 车板类型
     */
    @Column(name = "PLATE_TYPE")
    private String plateType;

    /**
     * 车板长/宽/高
     */
    @Column(name = "PLATE_PROPERTIES")
    private String plateProperties;

    /**
     * 最大载重（吨）
     */
    @Column(name = "LOAD_MAX")
    private String loadMax;

    /**
     * 最大体积（方）
     */
    @Column(name = "VOLUME_MAX")
    private String volumeMax;

    /**
     * 当前司机
     */
    @Column(name = "CURRENT_DRIVER")
    private String currentDriver;

    /**
     * 当前司机手机号码
     */
    @Column(name = "CURRENT_DRIVER_PHONE")
    private String currentDriverPhone;

    /**
     * 来源
     */
    @Column(name = "SOURCE")
    private String source;

    /**
     * 企业id
     */
    @Column(name = "enterprise_id")
    private String enterpriseId;

    /**
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
     * 备注
     */
    private String notes;

    /**
     * 是否删除(0:未删除,1:删除)
     */
    @Column(name = "is_del")
    private String isDel;

   }