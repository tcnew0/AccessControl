package com.zzb.competence.util.common;

/**
 * Created by zhaozb on 14-6-3.
 */
public class Constants {

    /**
     * 暂时无用
     */
    public static interface INDEX_PAGES{
        /** 登陆页面 */
        public static final String INDEX = "login/login";

        /** 主页面 */
        public static final String MAIN = "index/main";

        /** 默认iframe */
        public static final String IFRAME = "index/frame";

    }

    /**
     * 部门 model view
     */
    public static interface GROUP_PAGES{

        /** 部门管理主页面　*/
        public static final String MANAGE = "group/group_manage";
    }

    /**
     * 人员 model view
     */
    public static interface USER_PAGES{

        /**人员管理主界面 */
        public static final String MANAGE = "user/user_manage";
    }

    /**
     * 角色 model view
     */
    public static interface ROLE_PAGES{

        /**角色管理主界面 */
        public static final String MANAGE = "role/role_manage";
    }

    public static interface PROJECT_INFO{

        /**base package */
        public static final String BASE_PAKAGE = "com.zzb.competence";
    }

    /**
     * 状态
     */
    public static interface STATUS{

        /**
         * 部门状态
         */
        public static interface GROUP{

            /** 可用 */
            public static final boolean ACTIVE = true;

            /** 不可用 */
            public static final boolean IN_ACTIVE = false;
        }
    }

}
