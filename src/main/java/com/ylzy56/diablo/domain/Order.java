package com.ylzy56.diablo.domain;

import java.util.Date;
import javax.persistence.*;

public class Order {
    /**
     * 订单编号
     */
    @Id
    @Column(name = "order_id")
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

    /**
     * 获取订单编号
     *
     * @return order_id - 订单编号
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 设置订单编号
     *
     * @param orderId 订单编号
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取客户id
     *
     * @return customer_id - 客户id
     */
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     * 设置客户id
     *
     * @param customerId 客户id
     */
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    /**
     * 获取货物类型
     *
     * @return cargo_type - 货物类型
     */
    public String getCargoType() {
        return cargoType;
    }

    /**
     * 设置货物类型
     *
     * @param cargoType 货物类型
     */
    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }

    /**
     * 获取预计重量(吨)
     *
     * @return predict_weight - 预计重量(吨)
     */
    public String getPredictWeight() {
        return predictWeight;
    }

    /**
     * 设置预计重量(吨)
     *
     * @param predictWeight 预计重量(吨)
     */
    public void setPredictWeight(String predictWeight) {
        this.predictWeight = predictWeight;
    }

    /**
     * 获取预计体积(方)
     *
     * @return predict_volume - 预计体积(方)
     */
    public String getPredictVolume() {
        return predictVolume;
    }

    /**
     * 设置预计体积(方)
     *
     * @param predictVolume 预计体积(方)
     */
    public void setPredictVolume(String predictVolume) {
        this.predictVolume = predictVolume;
    }

    /**
     * 获取预计运费(元)
     *
     * @return predict_freight - 预计运费(元)
     */
    public String getPredictFreight() {
        return predictFreight;
    }

    /**
     * 设置预计运费(元)
     *
     * @param predictFreight 预计运费(元)
     */
    public void setPredictFreight(String predictFreight) {
        this.predictFreight = predictFreight;
    }

    /**
     * 获取预计提货时间
     *
     * @return predict_pickup_time - 预计提货时间
     */
    public Date getPredictPickupTime() {
        return predictPickupTime;
    }

    /**
     * 设置预计提货时间
     *
     * @param predictPickupTime 预计提货时间
     */
    public void setPredictPickupTime(Date predictPickupTime) {
        this.predictPickupTime = predictPickupTime;
    }

    /**
     * 获取预计卸货时间
     *
     * @return predict_unload_time - 预计卸货时间
     */
    public Date getPredictUnloadTime() {
        return predictUnloadTime;
    }

    /**
     * 设置预计卸货时间
     *
     * @param predictUnloadTime 预计卸货时间
     */
    public void setPredictUnloadTime(Date predictUnloadTime) {
        this.predictUnloadTime = predictUnloadTime;
    }

    /**
     * 获取已转运单数
     *
     * @return conversion_waybill - 已转运单数
     */
    public Integer getConversionWaybill() {
        return conversionWaybill;
    }

    /**
     * 设置已转运单数
     *
     * @param conversionWaybill 已转运单数
     */
    public void setConversionWaybill(Integer conversionWaybill) {
        this.conversionWaybill = conversionWaybill;
    }

    /**
     * 获取未转运重量(吨)
     *
     * @return residual_weight - 未转运重量(吨)
     */
    public String getResidualWeight() {
        return residualWeight;
    }

    /**
     * 设置未转运重量(吨)
     *
     * @param residualWeight 未转运重量(吨)
     */
    public void setResidualWeight(String residualWeight) {
        this.residualWeight = residualWeight;
    }

    /**
     * 获取未转运体积(方)
     *
     * @return residual_volume - 未转运体积(方)
     */
    public String getResidualVolume() {
        return residualVolume;
    }

    /**
     * 设置未转运体积(方)
     *
     * @param residualVolume 未转运体积(方)
     */
    public void setResidualVolume(String residualVolume) {
        this.residualVolume = residualVolume;
    }

    /**
     * 获取创建人
     *
     * @return creator - 创建人
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 设置创建人
     *
     * @param creator 创建人
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改人
     *
     * @return last_modifier - 修改人
     */
    public String getLastModifier() {
        return lastModifier;
    }

    /**
     * 设置修改人
     *
     * @param lastModifier 修改人
     */
    public void setLastModifier(String lastModifier) {
        this.lastModifier = lastModifier;
    }

    /**
     * 获取修改时间
     *
     * @return last_modify_time - 修改时间
     */
    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    /**
     * 设置修改时间
     *
     * @param lastModifyTime 修改时间
     */
    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    /**
     * 获取备注
     *
     * @return notes - 备注
     */
    public String getNotes() {
        return notes;
    }

    /**
     * 设置备注
     *
     * @param notes 备注
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * 获取是否删除(0:未删除,1:删除)
     *
     * @return is_del - 是否删除(0:未删除,1:删除)
     */
    public String getIsDel() {
        return isDel;
    }

    /**
     * 设置是否删除(0:未删除,1:删除)
     *
     * @param isDel 是否删除(0:未删除,1:删除)
     */
    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }
}