package com.soft1851.admin.service;

import com.soft1851.pojo.mo.FriendLinkMO;

import java.util.List;

public interface FriendLinkService {
    /**
     * 新增或者更新友情链接
     */
    void saveOrUpdateFriendLink(FriendLinkMO friendLinkMO);

    /**
     * 查询友情链接接口
     *
     */
    List<FriendLinkMO> queryAllFriendLinkList();

    /**
     * 删除
     */
    void  delete(String linkId);
}
