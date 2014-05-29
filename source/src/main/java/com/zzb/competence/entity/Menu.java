package com.zzb.competence.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

/**
 * Created by zhaozb on 14-5-20.
 */
@Entity
@Table(name="menu")
public class Menu {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column(name="menu_name",length = 100)
    private String menuName;

    @Column(name="menu_num",length = 200)
    private String menuNum;

//    @Column(name="parent_menu")
//    private long parentMenu;
    @ManyToOne
    @JoinColumn(name="parent_menu")
    private Menu pMenu;

    @OneToMany(cascade = {CascadeType.ALL},mappedBy = "parent_menu")
    private Set<Menu> cMenuList;

    @Column(name = "use_flag")
    private boolean useFlag;

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

    public Menu() {
    }

    public Menu(String menuName, String menuNum, Menu pMenu, Set<Menu> cMenuList, boolean useFlag, String description, User createUser, Date createTime, User updateUser, Date updateTime) {
        this.menuName = menuName;
        this.menuNum = menuNum;
        this.pMenu = pMenu;
        this.cMenuList = cMenuList;
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

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuNum() {
        return menuNum;
    }

    public void setMenuNum(String menuNum) {
        this.menuNum = menuNum;
    }

    public Menu getpMenu() {
        return pMenu;
    }

    public void setpMenu(Menu pMenu) {
        this.pMenu = pMenu;
    }

    public Set<Menu> getcMenuList() {
        return cMenuList;
    }

    public void setcMenuList(Set<Menu> cMenuList) {
        this.cMenuList = cMenuList;
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
