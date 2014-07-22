package com.zzb.competence.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by zhaozb on 14-5-20.
 */
@Entity
@Table(name="Op_info")
public class Operator{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name="op_name",length = 100)
    private String opName;

    @Column(name="op_num",length = 200)
    private String opNum;

    private String description;

    @ManyToOne
    @JoinColumn(name="create_user")
    private User createUser;

    @Column(name="create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @ManyToOne
    @JoinColumn(name="update_user")
    private User updateUser;

    @Column(name="update_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    public Operator() {
    }

    public Operator(String opName, String opNum, String description, User createUser, Date createTime, User updateUser, Date updateTime) {
        this.opName = opName;
        this.opNum = opNum;
        this.description = description;
        this.createUser = createUser;
        this.createTime = createTime;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOpName() {
        return opName;
    }

    public void setOpName(String opName) {
        this.opName = opName;
    }

    public String getOpNum() {
        return opNum;
    }

    public void setOpNum(String opNum) {
        this.opNum = opNum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getCreateUser() {
        return createUser;
    }

    public void setCreateUser(User createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public User getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(User updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
