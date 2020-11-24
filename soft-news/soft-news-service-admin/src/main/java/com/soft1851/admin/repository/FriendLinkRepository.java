package com.soft1851.admin.repository;

import com.soft1851.pojo.mo.FriendLinkMO;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FriendLinkRepository extends MongoRepository<FriendLinkMO,String> {

    /**
     * isdelete是否删除
     */
  List<FriendLinkMO> getAllByIsDelete(Integer isDelete);


}
