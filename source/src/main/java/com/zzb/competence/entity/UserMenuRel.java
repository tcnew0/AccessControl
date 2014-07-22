package com.zzb.competence.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by zhaozb on 14-5-21.
 */
@Entity
@Table(name="user_menu")
public class UserMenuRel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private String description;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="menu_id")
    private Menu menu;

    @ManyToOne
    @JoinColumn(name="project_id")
    private MenuProject menuProject;

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

    public UserMenuRel() {
    }

    public UserMenuRel(String description, User user, Menu menu, MenuProject menuProject, User createUser, Date createTime, User updateUser, Date updateTime) {
        this.description = description;
        this.user = user;
        this.menu = menu;
        this.menuProject = menuProject;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public MenuProject getMenuProject() {
        return menuProject;
    }

    public void setMenuProject(MenuProject menuProject) {
        this.menuProject = menuProject;
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
