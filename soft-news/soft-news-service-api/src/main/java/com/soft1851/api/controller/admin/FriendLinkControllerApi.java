package com.soft1851.api.controller.admin;


import com.soft1851.pojo.mo.SaveFriendLinkBO;
import com.soft1851.result.GraceResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Api(value = "首页友情链接维护",tags = {"首页友情链接维护controller"})
@RequestMapping("friendLink")
public interface FriendLinkControllerApi {

    /**
     *新增修改友情链接
     * @param
     * @param
     * @param
     * @return
     */
    @ApiOperation(value = "新增修改友情链接",notes = "新增修改友情链接",httpMethod = "POST")
    @PostMapping("saveOrUpdateFriendLink")
    GraceResult saveOrUpdateFriendLink(@RequestBody @Valid SaveFriendLinkBO saveFriendLinkBO, BindingResult result);

    @PostMapping("getFriendLinkList")
    @ApiOperation(value = "查询友情链接列表",notes = "查询友情链接列表",httpMethod = "POST")
    GraceResult getFriendLinkList();


    @PostMapping("delete")
    @ApiOperation(value = "删除友情链接",notes = "删除友情链接",httpMethod = "POST")
    GraceResult delete(@RequestParam String linkId);

}
