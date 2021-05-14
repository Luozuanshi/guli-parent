package com.domoyun.ossservice.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.domoyun.ossservice.config.ConstantPropertiesUtil;
import com.domoyun.ossservice.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * <p>
 * 文件上传 服务实现类
 * </p>
 *
 * @author luozuanshi
 * @since 2021-05-14
 */
@Slf4j
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private ConstantPropertiesUtil constantPropertiesUtil;
    @Override
    public String upload(MultipartFile file) {
    //获取阿里云存储相关常量
        String endPoint = ConstantPropertiesUtil.END_POINT;
        String accessKeyId = ConstantPropertiesUtil.ACCESS_KEY_ID;
        String accessKeySecret = ConstantPropertiesUtil.ACCESS_KEY_SECRET;
        String bucketName = ConstantPropertiesUtil.BUCKET_NAME;

    // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endPoint, accessKeyId, accessKeySecret);

    // 填写本地文件的完整路径。如果未指定本地路径，则默认从示例程序所属项目对应本地路径中上传文件流。
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
            log.error("获取文件流失败");
        }
        String uuid = UUID.randomUUID().toString();
        String originalFilename = file.getOriginalFilename();
        String path  = new DateTime().toString("yyyy/MM/dd");
        String fileName = path +"/"+ uuid + originalFilename;
        // 填写Bucket名称和Object完整路径。Object完整路径中不能包含Bucket名称。
        ossClient.putObject(bucketName, fileName, inputStream);
        // 关闭OSSClient。
        ossClient.shutdown();

        String url =  "https://" + bucketName + "." + endPoint + "/" + fileName;

        return url;
    }
}
