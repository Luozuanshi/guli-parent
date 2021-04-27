package com.domoyun.eduservice.controller;


import com.domoyun.eduservice.entity.Teacher;
import com.domoyun.eduservice.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author luozuanshi
 * @since 2021-04-27
 */
@Api(tags = "讲师管理")
@RestController
@RequestMapping("/eduservice/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    //查询讲师列表
    @ApiOperation(value = "讲师列表",notes = "讲师管理讲师列表")
    @GetMapping
    public List<Teacher> list(){
        List<Teacher> list = teacherService.list(null);
        return list;
    }

    //删除讲师
    @DeleteMapping("{id}")
    @ApiOperation("删除指定讲师")
    @ApiImplicitParams(@ApiImplicitParam(name = "id",value = "教师id",required = true,paramType ="form"))
    public Boolean del(@PathVariable String id){
        return teacherService.removeById(id);
    }


}

