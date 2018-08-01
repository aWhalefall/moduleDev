package com.component.network;


import com.component.constant.UrlConstans;
import com.component.model.ConfigBean;
import com.component.model.ImageHeaderEntiry;
import com.component.model.ItemListEntity;
import com.component.model.ListEntity;
import com.component.model.MembersBo;
import com.component.model.NoteBookEntity;
import com.component.model.NullEntity;
import com.component.model.SaltEntity;
import com.component.model.ShareNoteBo;
import com.component.model.UserEntity;
import com.component.model.db.ATypeListEntity;
import com.component.model.db.CategoryEntity;
import com.component.model.db.ListItemBO;
import io.reactivex.Observable;

import org.jetbrains.annotations.NotNull;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Author: weichyang
 * Date:   2018/6/2
 * Description: 请求协议定义
 * BaseURL 动态传递，主要为了解决多个域名问题
 */
public interface IAllRequest {


    /**
     * 密码盐-登录初始化
     */

    @GET(UrlConstans.REQUEST_SALT)
    Call<SaltEntity> initlogin(@Query("loginname") String name, @Query("type") String type);


    /**
     * 登录
     */
    @GET(UrlConstans.REQUEST_LOGIN)
    Call<UserEntity> dologin(@Query("loginname") String name,
                             @Query("loginpwd") String pwd);

    /**
     * 短信验证登录
     * @param name
     * @param pwd
     * @return
     */
    @GET(UrlConstans.REQUEST_ONSMSLOGIN)
    Call<UserEntity> smsLogin(@Query("loginname") String name,
                             @Query("mcode") String pwd);



    @GET(UrlConstans.REQUEST_BINDMOBILE)
    Call<NullEntity> bindPhoneRequest(@Query("mobile") String mobile,
                             @Query("mcode") String mcode);

    /**
     * 三方登录
     */
    @GET(UrlConstans.REQUEST_AUTHLOGIN)
    Call<UserEntity> authorLogin(@Query("openId") String openId,
                                 @Query("authToken") String authToken,
                                 @Query("platform") String platform,
                                 @Query("refreshToken") String refreshToken,
                                 @Query("unionId") String unionId);


    /**
     * 绑定微信账号
     */
    @GET(UrlConstans.REQUEST_BINDOPENUSER)
    Call<NullEntity> bindOpenUser(@Query("openId") String openId,
                                  @Query("authToken") String authToken,
                                  @Query("platform") String platform,
                                  @Query("refreshToken") String refreshToken,
                                  @Query("unionId") String unionId);


    /**
     * app获取短信验证码
     */
    @GET(UrlConstans.REQUEST_VERIFYSMS)
    Call<NullEntity> getmobilevcodewith(@Query("mobile") String mobile,
                                        @Query("type") String type
    );

    /**
     * 注册
     */
    @GET(UrlConstans.REQUEST_ONSIGN)
    Call<UserEntity> register(@Query("mobile") String mobileno,
                              @Query("password") String saltpwd,
                              @Query("salt") String salt,
                              @Query("mcode") String mvcode
    );

    /**
     * 发送邮件
     */
    @GET(UrlConstans.REQUEST_EXPORTMAIL)
    Call<NullEntity> sendMailToUser(@Query("aId") String aid,
                                    @Query("mailto") String mailto,
                                    @Query("start") String start,
                                    @Query("end") String end
    );


    /**
     * 得到用户信息
     */
    @GET(UrlConstans.REQUEST_USERINFO)
    Call<UserEntity> requestUserInfo();


    @GET()
    Call<ListEntity> addNoteBook(@Url String url,
                                 @Query("aType") int aType,
                                 @Query("aname") String aname);

    @GET()
    Call<ListEntity> updateNoteBook(@Url String url,
                                    @Query("aId") String aid,
                                    @Query("aname") String aname);

    /**
     * 添加类别
     */
    @GET()
    Call<CategoryEntity> addCategory(@Url String url,
                                     @Query("aId") String aId,
                                     @Query("rId") int rId,
                                     @Query("cName") String cName,
                                     @Query("color") String color,
                                     @Query("icon") String icon);


    @GET()
    Call<ItemListEntity> requestItems(@Url String url,

                                      @Query("aId") String name);

    //请求账本所有人
    @GET()
    Call<MembersBo> requestMembers(@Url String url,
                                   @Query("aId") String name);

    /**
     * 分享
     */
    @GET()
    Call<ShareNoteBo> shareNoteBook(@Url String url,
                                    @Query("aId") String name);

    /***
     *
     * @param url
     * @param name
     * @return
     */
    @GET()
    Call<NullEntity> exitNoteBook(@Url String url,
                                  @Query("aId") String name);

    /***
     *
     * @param url
     * @param itemId
     * @return
     */
    @GET()
    Call<NullEntity> requestDelItem(@Url String url,
                                    @Query("itemId") String itemId);


    /**
     * 修改账本
     *
     * @param url
     * @param name
     * @param uid
     * @param perm
     * @return
     */
    @GET()
    Call<NullEntity> modifyBookPer(@Url String url,
                                   @Query("aId") String name,
                                   @Query("uid") String uid,
                                   @Query("perm") int perm);

    /**
     * 删除账本
     *
     * @param url
     * @param aid
     * @return
     */
    @GET()
    Call<NullEntity> delNoteBook(@Url String url,
                                 @Query("aId") String aid);


    @GET()
    Call<NullEntity> quiteNoteBook(@Url String url,
                                   @Query("aId") String aid);


    /**
     * 忘记密码
     */
    @GET()
    Call<NullEntity> updatepwd(@Url String url,
                               @Query("loginname") String name,
                               @Query("mcode") String type,
                               @Query("newPwd") String saltpwd,
                               @Query(UrlConstans.SALT) String salt);

    /**
     * 修改密码
     */
    @GET()
    Call<NullEntity> modifyPwd(@Url String url,
                               @Query("loginname") String loginName,
                               @Query("oldPwd") String oldpwd,
                               @Query("newPwd") String newpwd,
                               @Query("salt") String salt
    );

    /**
     * 账本类别
     */
    @GET()
    Call<NoteBookEntity> requestNotebookCatagory(@Url String url,
                                                 @Query("aId") String aId);


    /**
     * 退出登录
     */

    @POST()
    Call<NullEntity> exitUserAccountRequest(@Url String url);


    @Multipart
    @POST()
    Call<ImageHeaderEntiry> undateImage(@Url String url, @Part MultipartBody.Part file);


    @FormUrlEncoded
    @POST()
    Call<NullEntity> modifyImageHeader(@Url String url,
                                       @Field("photo") String photo);


    /**
     * 查询排序类别
     *
     * @param url
     * @return
     */
    @POST()
    Call<ATypeListEntity> querySortCategoryList(@Url String url);


    /**
     * 保存排序
     *
     * @param url
     * @param
     * @param incomeSeq1
     * @param incomeSeq2
     * @param outgoSeq1
     * @param outgoSeq2
     * @return
     */
    @FormUrlEncoded
    @POST
    Call<ATypeListEntity> requestSortCategory(@Url String url,
                                              @Field("aId") int aId,
                                              @Field("incomeSeq1") String incomeSeq1,
                                              @Field("incomeSeq2") String incomeSeq2,
                                              @Field("outgoSeq1") String outgoSeq1,
                                              @Field("outgoSeq2") String outgoSeq2);

    /**
     * 添加item
     *
     * @param url
     * @param aId
     * @param cType
     * @param cId
     * @param aDate
     * @param amount
     * @param remark
     * @return
     */
    @GET
    Call<ListItemBO> addItem(@Url String url,
                             @Query("aId") String aId,
                             @Query("cType") int cType,
                             @Query("cId") int cId,
                             @Query("aDate") String aDate,
                             @Query("amount") String amount,
                             @Query("remark") String remark);

    @GET
    Call<ListItemBO> modifyItem(@Url String url,
                                @Query("itemId") String aId,
                                @Query("cType") int cType,
                                @Query("cId") int cId,
                                @Query("aDate") String aDate,
                                @Query("amount") String amount,
                                @Query("remark") String remark);


    /**
     * 修改昵称
     *
     * @param url
     * @param nickname
     * @return
     */

    @GET
    Call<NullEntity> requestModifyNick(@Url String url,
                                       @Query("nickname") String nickname);

    /**
     * 检查配置文件
     *
     * @param url
     * @return
     */
    @GET
    Call<NullEntity> checkConfig(@Url String url);

    /**
     * 检查更新
     *
     * @param url
     * @return
     */

    @GET
    Call<ConfigBean> checkUpgrade(@Url String url);




    //返利模块

    /**
     *
     * @param url
     * @return
     */
    @GET
    Call<NullEntity> addAlipayAccount(@Url String url, @Query("account") String account , @Query("alias") String alias);


}
