package com.domoyun.ossservice.controller;


import com.domoyun.commonutils.R;
import com.domoyun.ossservice.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author luozuanshi
 * @since 2021-05-14
 */
@Api(tags="模拟用户登录")
@RestController
@RequestMapping("/oss")
@CrossOrigin
public class FileController {
    @Autowired
    FileService fileService;

    @ApiOperation("上传文件")
    @ApiImplicitParams(@ApiImplicitParam(name = "file",value = "文件",required = true,paramType ="form"))
    public R uploadFile(MultipartFile file){
        String url = fileService.upload(file);
        return R.ok().data("url",url);
    }
}

