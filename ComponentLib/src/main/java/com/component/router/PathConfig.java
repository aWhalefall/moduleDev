package com.component.router;

/**
 * Created by alan on 2017/9/28.
 *
 * 路由路径配置， 路径需要注意的是至少需要有两级，/xx/xx
 *
 */

public class PathConfig {


    /**
     * 返利
     */
    private static final String GROUP_REBATE = "/rebate/";

    public static final String BILL_FRAGMENT_REBATE = GROUP_REBATE + "fragment_delegate";


    /**
     * activity 路径
     */

    /**
     * 登录
     */
    public static final String GROUP_LOGIN = "/login/";

    public static final String LOGIN_ACTIVITY = GROUP_LOGIN + "login_activity";



}
