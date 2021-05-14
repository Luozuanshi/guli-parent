package com.domoyun.ossservice.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.domoyun.ossservice.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
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

    @Override
    public String upload(MultipartFile file) {
    // yourEndpoint填写Bucket所在地域对应的Endpoint。以华东1（杭州）为例，Endpoint填写为https://oss-cn-hangzhou.aliyuncs.com。
        String endpoint = "yourEndpoint";
    // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
        String accessKeyId = "yourAccessKeyId";
        String accessKeySecret = "yourAccessKeySecret";

    // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

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
        String fileName = path + uuid + originalFilename;
        // 填写Bucket名称和Object完整路径。Object完整路径中不能包含Bucket名称。
        ossClient.putObject("examplebucket", fileName, inputStream);

    // 关闭OSSClient。
        ossClient.shutdown();
        return null;
    }
}
