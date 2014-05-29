package com.zzb.competence.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by zhaozb on 14-5-20.
 */
@Entity
@Table(name="Group_info")
public class GroupInfo {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column(name="group_num",length = 200)
    private String groupNum;

    @Column(name="group_name",length = 255)
    private String groupName;

    @Column(name="use_flag")
    private boolean useFlag;

    @Column(name="description",length = 255)
    private String description;

    @ManyToOne
    @JoinColumn(name="create_user")
    private User createUser;

    @Column(name="create_time")
    @Temporal(TemporalType.DATE)
    private Date createTime;

    @ManyToOne
    @JoinColumn(name="update_user")
    private User updateUser;

    @Column(name="update_time")
    @Temporal(TemporalType.DATE)
    private Date updateTime;

    public GroupInfo() {
    }

    public GroupInfo(String groupNum, String groupName, boolean useFlag, String description, User createUser, Date createTime, User updateUser, Date updateTime) {
        this.groupNum = groupNum;
        this.groupName = groupName;
        this.useFlag = useFlag;
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

    public String getGroupNum() {
        return groupNum;

    }

    public void setGroupNum(String groupNum) {
        this.groupNum = groupNum;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public boolean isUseFlag() {
        return useFlag;
    }

    public void setUseFlag(boolean useFlag) {
        this.useFlag = useFlag;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
