package com.domoyun.ossservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author luozuanshi
 * @since 2021-05-14
 */
public interface FileService {

    String upload(MultipartFile file);
}
