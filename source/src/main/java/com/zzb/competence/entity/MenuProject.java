package com.zzb.competence.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by zhaozb on 14-5-21.
 */
@Entity
@Table(name="Menu_project")
public class MenuProject {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column(name="project",length = 200)
    private String project;

    @Column(name="project_name",length = 200)
    private String projectName;

    @ManyToOne
    @JoinColumn(name="menu_id")
    private Menu menu;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "menuProject")
    private Set<MenuOp> menuOpSet;

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

    public MenuProject() {
    }

    public MenuProject(String project, String projectName, Menu menu, Set<MenuOp> menuOpSet, User createUser, Date createTime, User updateUser, Date updateTime) {
        this.project = project;
        this.projectName = projectName;
        this.menu = menu;
        this.menuOpSet = menuOpSet;
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

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Set<MenuOp> getMenuOpSet() {
        return menuOpSet;
    }

    public void setMenuOpSet(Set<MenuOp> menuOpSet) {
        this.menuOpSet = menuOpSet;
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
