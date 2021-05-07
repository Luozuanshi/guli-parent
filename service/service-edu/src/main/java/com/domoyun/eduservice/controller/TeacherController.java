package com.domoyun.eduservice.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.domoyun.commonutils.R;
import com.domoyun.eduservice.entity.Teacher;
import com.domoyun.eduservice.service.TeacherService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public R list(){
        List<Teacher> list = teacherService.list(null);
        return R.ok().data("items",list);
    }

    //删除讲师
    @DeleteMapping("{id}")
    @ApiOperation("删除指定讲师")
    @ApiImplicitParams(@ApiImplicitParam(name = "id",value = "教师id",required = true,paramType ="form"))
    public R del(@PathVariable String id){
        teacherService.removeById(id);
        return R.ok();
    }

    @ApiOperation("分页讲师列表")
    @GetMapping("/{page}/{limit}")
    public R pageList(@ApiParam(name = "page",value = "当前页码",required = true)
                      @PathVariable Long page,
                      @ApiParam(name = "limit",value = "每页记录数",required = true)
                      @PathVariable Long limit){
        Page<Teacher> pageParam = new Page<>(page,limit);
        teacherService.page(pageParam,null);
        List<Teacher> records = pageParam.getRecords();
        long total = pageParam.getTotal();

        Map<String,Object> pageMap = new HashMap();
        pageMap.put("total",total);
        pageMap.put("rows",records);
        return R.ok().data(pageMap);
    }

}

