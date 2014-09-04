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

        /** 部门管理列表页面　*/
        public static final String FRAME = "group/group_list_frame";
    }

    /**
     * 人员 model view
     */
    public static interface USER_PAGES{

        /**人员管理主界面 */
        public static final String MANAGE = "user/user_manage";

        /** 人员列表页面　*/
        public static final String FRAME = "user/user_list_frame";
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

    /**
     * 分页常量
     */
    public static interface PAGE_INFO{
        /** 页 */
        public static final String CUR_PAGE = "curPage";

        /** 尺寸 */
        public static final String PAGE_SIZE = "pageSize";

        /** 总数 */
        public static final String TOTAL = "pageTotal";

        /** 默认当前页 */
        public static final int DEFAULT_CUR_PAGE = 1;

        /** 默认尺寸 */
        public static final int DEFAULT_PAGE_SIZE = 6;

        /** 页数 */
        public static final int DEFAULT_PAGE_CNT = 5;
    }

    /**
     * 数据库相关常量
     */
    public static interface SQL_CONSTANTS{

        /** escape */
        public static final String ESCAPE = "|";
    }

    public static interface DATE_FORMAT{

        /** yyyy-MM-dd */
        public static final String DF_yyyy$MM$dd = "yyyy-MM-dd";

        /** yyyy-MM-dd 24小时*/
        public static final String DF_yyyy$MM$dd$HH$mm$ss = "yyyy-MM-dd HH:mm:ss";

        /** yyyy-MM-dd 12小时*/
        public static final String DF_yyyy$MM$dd$hh$mm$ss = "yyyy-MM-dd hh:mm:ss";
    }
}
