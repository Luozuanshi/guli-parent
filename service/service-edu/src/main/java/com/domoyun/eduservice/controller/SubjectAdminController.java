package com.domoyun.eduservice.controller;

import com.domoyun.commonutils.R;
import com.domoyun.eduservice.entity.VO.OneSubjectVo;
import com.domoyun.eduservice.service.SubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Api(description="课程分类管理")
@CrossOrigin //跨域
@RestController
@RequestMapping("/eduservice/subject")
public class SubjectAdminController {

    @Autowired
    private SubjectService subjectService;

    //添加课程分类
    @ApiOperation(value = "Excel批量导入")
    @PostMapping("import")
    public R addSubject(MultipartFile file) {
        //1 获取上传的excel文件 MultipartFile
        //返回错误提示信息
        subjectService.importSubjectData(file,subjectService);
        //判断返回集合是否为空
        return R.ok();
    }

    @ApiOperation(value = "查询课程分类")
    @GetMapping
    public R getAllSubject(){
        List<OneSubjectVo> allSubject = subjectService.getAllSubject();
        return R.ok().data("allSubject",allSubject);
    }
}
