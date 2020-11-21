package com.soft1851.files.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author xunmi
 * @ClassName 文件上传服务端口
 * @Description TODO
 * @Date 2020/11/19
 * @Version 1.0
 **/
public interface UploadService {

    /**
     * fsfs 上传
     *
     * @param file        文件
     * @param fileExtName 拓展名
     * @return url
     * @throws Exception 异常
     */
    String uploadFdfs(MultipartFile file, String fileExtName) throws Exception;

    /**
     * OSS 上传文件
     *
     * @param file
     * @param userId
     * @param fileExtName 拓展名
     * @return
     * @throws Exception
     */
    String uploadOSS(MultipartFile file, String userId, String fileExtName) throws Exception;
}
