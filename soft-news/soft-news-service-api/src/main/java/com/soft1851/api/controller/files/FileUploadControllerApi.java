package com.soft1851.api.controller.files;

import com.soft1851.result.GraceResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author
 * @ClassName FileUploadControllerApi
 * @Description 文件上传Api接口
 * @Date 2020/11/19
 * @Version 1.0
 **/
@Api(value = "文件上传 controller", tags = {"文件上传 controller"})
@RequestMapping("fs")
public interface FileUploadControllerApi {

    /**
     * 上传用户头像
     *
     * @param userId
     * @param file   文件对象
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "上传用户头像", notes = "上传用户头像", httpMethod = "POST")
    @PostMapping("/uploadFace")
    GraceResult uploadFace(@RequestParam String userId, MultipartFile file) throws Exception;

    /**
     * 上传多个文件
     *
     * @param userId
     * @param files
     * @return
     * @throws Exception
     */
    @PostMapping("/uploadSomeFiles")
    GraceResult uploadSomeFile(@RequestParam String userId, MultipartFile[] files) throws Exception;

    /**
     * 管理员人脸入库
     * @param username
     * @param multipartFile
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "管理员人脸入库", notes = "管理员人脸入库", httpMethod = "POST")
    @PostMapping("/uploadToGridFS")
    GraceResult uploadToGridFS(@RequestParam String username,@RequestParam(value = "file") MultipartFile multipartFile) throws Exception;

    /**
     * 从gridFS中读取文件
     * @param faceId
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "从gridFS中读取文件",notes = "从gridFS中读取文件", httpMethod = "GET")
    @GetMapping("readInGridFS")
    GraceResult readInGridFs(@RequestParam String faceId, HttpServletRequest request,
                      HttpServletResponse response) throws Exception;

    /**
     * 从gridFS中读取图片内容
     * @param faceId
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @GetMapping("/readFace64")
    GraceResult readFace64(@RequestParam String faceId, HttpServletRequest request
    ,HttpServletResponse response) throws Exception;
}

