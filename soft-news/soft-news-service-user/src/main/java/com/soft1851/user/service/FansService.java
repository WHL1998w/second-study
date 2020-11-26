package com.soft1851.user.service;

/**
 * @ClassName
 * @Description FansService接口
 * @Author wanghuanle
 * @Date
 **/
public interface FansService {

    /**
     * 查询当前用户是否关注作者
     * @param writerId
     * @param fanId
     * @return
     */
    boolean isMeFollowThisWriter(String writerId,String fanId);


    /**
     * 关注作者，成为粉丝
     * @param writerId
     * @param fanId
     */
    void follow(String writerId,String fanId);

    /**
     * 取消关注
     * @param writerId
     * @param fanId
     */
    void unfollow(String writerId,String fanId);
}
