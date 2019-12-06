package com.ylzy56.diablo.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "waybill_log")
public class WaybillLog {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "CREATEDBY")
    private String createdby;

    @Column(name = "CREATEDTIME")
    private Date createdtime;

    @Column(name = "MATTER")
    private String matter;

    @Column(name = "DESCRIBE")
    private String describe;

    /**
     * @return ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return CREATEDBY
     */
    public String getCreatedby() {
        return createdby;
    }

    /**
     * @param createdby
     */
    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    /**
     * @return CREATEDTIME
     */
    public Date getCreatedtime() {
        return createdtime;
    }

    /**
     * @param createdtime
     */
    public void setCreatedtime(Date createdtime) {
        this.createdtime = createdtime;
    }

    /**
     * @return MATTER
     */
    public String getMatter() {
        return matter;
    }

    /**
     * @param matter
     */
    public void setMatter(String matter) {
        this.matter = matter;
    }

    /**
     * @return DESCRIBE
     */
    public String getDescribe() {
        return describe;
    }

    /**
     * @param describe
     */
    public void setDescribe(String describe) {
        this.describe = describe;
    }
}