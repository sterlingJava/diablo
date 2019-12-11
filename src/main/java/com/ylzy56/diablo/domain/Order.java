package com.ylzy56.diablo.domain;

import com.ylzy56.diablo.domain.entity.UUIdGenId;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import java.util.Date;
import javax.persistence.*;

@Data
public class Order {
    /**
     * 订单编号
     */
    @Id
    @Column(name = "order_id")
    @KeySql(genId = UUIdGenId.class)
    private String orderId;

    /**
     * 客户id
     */
    @Column(name = "customer_id")
    private Integer customerId;

    /**
     * 货物类型
     */
    @Column(name = "cargo_type")
    private String cargoType;

    /**
     * 预计重量(吨)
     */
    @Column(name = "predict_weight")
    private String predictWeight;

    /**
     * 预计体积(方)
     */
    @Column(name = "predict_volume")
    private String predictVolume;

    /**
     * 预计运费(元)
     */
    @Column(name = "predict_freight")
    private String predictFreight;

    /**
     * 预计提货时间
     */
    @Column(name = "predict_pickup_time")
    private Date predictPickupTime;

    /**
     * 预计卸货时间
     */
    @Column(name = "predict_unload_time")
    private Date predictUnloadTime;

    /**
     * 已转运单数
     */
    @Column(name = "conversion_waybill")
    private Integer conversionWaybill;

    /**
     * 未转运重量(吨)
     */
    @Column(name = "residual_weight")
    private String residualWeight;

    /**
     * 未转运体积(方)
     */
    @Column(name = "residual_volume")
    private String residualVolume;

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