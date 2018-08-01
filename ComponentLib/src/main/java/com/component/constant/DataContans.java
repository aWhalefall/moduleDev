package com.component.constant;

import com.acmenxd.frame.basis.impl.IFrameStart;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

//import cn.ftoutiao.account.android.activity.login.LoginActivity;

import com.component.model.ListEntity;
import com.component.model.UserEntity;
import com.component.router.ArouterHelper;
import com.component.router.PathConfig;
import com.component.util.StringUtil;

/**
 *
 */
public class DataContans {
    /**
     * 是否登录
     */
    public static boolean isLogin = false;

    public static UserEntity userEntity = new UserEntity();
    private static Map<String, Integer> billTypeMap;

    public static boolean isLogin() {
        return isLogin && userEntity != null;
    }

    /**
     * 检查是否登录,如未登录->打开登录页面
     */
    public static boolean checkLogin(IFrameStart pContext) {
        if (!isLogin) {
            ArouterHelper.startActivity(PathConfig.LOGIN_ACTIVITY);
        }
        return isLogin;
    }

    /**
     * 设置用户信息, 同时设置登录态
     */
    public static void setUserEntity(UserEntity pUserEntity) {
        if (pUserEntity == null) {
            DataContans.isLogin = false;
            userEntity = null;
        } else {
            DataContans.isLogin = true;
            userEntity = pUserEntity;
        }
    }

    /**
     * 获取账本类型通过账本id 可变
     *
     * @param aid
     * @return
     */
    public static int getAtypeByAid(String aid) {
        if (StringUtil.isEmpty(aid)) {
            throw new RuntimeException("bill id is empty ,please check aid is null");
        }
        if (billTypeMap == null) {
            billTypeMap = new HashMap<>();
            if (isLogin) {
                for (ListEntity entity : userEntity.data.list) {
                    billTypeMap.put(entity.aId, entity.aType);
                }

            }
        }
        return billTypeMap.get(aid);
    }

    public static String getBookNameByAid(String aid) {
        if (StringUtil.isEmpty(aid)) {
            throw new RuntimeException("bill id is empty ,please check aid is null");
        }
        if (billTypeMap == null) {
            if (isLogin) {
                for (ListEntity entity : userEntity.data.list) {
                    if (entity.aId.equals(aid)) {
                        return entity.aname;
                    }
                }

            }
        }
        return "";
    }


    /**
     * 是否是管理员
     *
     * @param uid
     * @return
     */
    public static boolean isOwenr(String uid) {

        return userEntity != null && userEntity.uid.equals(uid);
    }

    public static boolean isAccountLogin() {
        return isLogin() && DataContans.userEntity.data != null &&
                DataContans.userEntity.data.platform != null &&
                DataContans.userEntity.data.platform.equals("phone");

    }

    public static int getLoginType() {
        int type = -1;
        if (isLogin() && DataContans.userEntity.data != null &&
                DataContans.userEntity.data.platform != null) {
            if (DataContans.userEntity.data.platform.equals("phone")) {
                type = ConstanPool.PHONE_LOGIN;
            } else if (DataContans.userEntity.data.platform.equals("weixin")) {
                type = ConstanPool.WEIXIN_LOGIN;
            } else if (DataContans.userEntity.data.platform.equals("qq")) {
                type = ConstanPool.QQ_LOGIN;
            } else if (DataContans.userEntity.data.platform.equals("sina")) {
                type = ConstanPool.SINA_LOGIN;
            } else {
                type = -1;
            }
        }
        return type;
    }

}
