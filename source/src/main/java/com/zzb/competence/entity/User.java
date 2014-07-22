package com.zzb.competence.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by zhaozb on 14-5-20.
 */
@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name",length = 200)
    private String name;

    @Column(name="login_name",length = 200)
    private String loginName;

    private String password;

    private Date birthday;

    @Column(name="sex",length = 2)
    private String sex;

    @Column(name="mail",length = 200)
    private String mail;

    private String address;

    @Column(name="phone",length = 20)
    private String phone;

    private String description;

    @Column(name="use_flag")
    private boolean useFlag;

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

    public User() {
    }

    public User(String name, String loginName, String password, Date birthday, String sex, String mail, String address, String phone, String description, boolean useFlag, User createUser, Date createTime, User updateUser, Date updateTime) {
        this.name = name;
        this.loginName = loginName;
        this.password = password;
        this.birthday = birthday;
        this.sex = sex;
        this.mail = mail;
        this.address = address;
        this.phone = phone;
        this.description = description;
        this.useFlag = useFlag;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isUseFlag() {
        return useFlag;
    }

    public void setUseFlag(boolean useFlag) {
        this.useFlag = useFlag;
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
