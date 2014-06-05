package com.zzb.competence.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by zhaozb on 14-5-20.
 */
@Entity
@Table(name="Role")
public class Role {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column(name="role_num",length = 200)
    private String roleNum;

    @Column(name="role_name",length = 255)
    private String roleName;

    @Column(name="use_flag")
    private boolean useFlag;

    @Column(name="description",length = 255)
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

    public Role() {
    }

    public Role(String roleNum, String roleName, boolean useFlag, String description, User createUser, Date createTime, User updateUser, Date updateTime) {
        this.roleNum = roleNum;
        this.roleName = roleName;
        this.useFlag = useFlag;
        this.description = description;
        this.createUser = createUser;
        this.createTime = createTime;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setRoleNum(String roleNum) {
        this.roleNum = roleNum;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setUseFlag(boolean useFlag) {
        this.useFlag = useFlag;
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

    public long getId() {
        return id;
    }

    public String getRoleNum() {
        return roleNum;
    }

    public String getRoleName() {
        return roleName;
    }

    public boolean isUseFlag() {
        return useFlag;
    }

    public String getDescription() {
        return description;
    }
}
