package com.zzb.competence.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by zhaozb on 14-5-21.
 */
@Entity
@Table(name="Menu_op")
public class MenuOp {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name="use_flag")
    private boolean useFlag;

    @ManyToOne
    @JoinColumn(name="menu_id")
    private Menu menu;

    @ManyToOne
    @JoinColumn(name="operator_id")
    private Operator operator;

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

    public MenuOp() {
    }

    public MenuOp(boolean useFlag, Menu menu, Operator operator, MenuProject menuProject, User createUser, Date createTime, User updateUser, Date updateTime) {
        this.useFlag = useFlag;
        this.menu = menu;
        this.operator = operator;
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

    public boolean isUseFlag() {
        return useFlag;
    }

    public void setUseFlag(boolean useFlag) {
        this.useFlag = useFlag;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
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
