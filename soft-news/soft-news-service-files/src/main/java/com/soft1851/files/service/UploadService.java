package com.soft1851.files.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author wanghuanle
 * @date 2020/11/19 14:05
 * @description 创建文件上传服务
 */
public interface UploadService {
    /**
     * fdfs上传
     * @param file
     * @param fileExtName
     * @return
     * @throws Exception
     */
    String uploadFdfs(MultipartFile file, String fileExtName) throws Exception;

    /**
     * OSS上传文件
     * @param file
     * @param userId
     * @param fileExtName
     * @return
     * @throws Exception
     */
    public String uploadOSS(MultipartFile file, String userId, String fileExtName) throws Exception;
}
