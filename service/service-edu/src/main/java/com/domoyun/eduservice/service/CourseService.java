package com.domoyun.eduservice.service;

import com.domoyun.eduservice.entity.Course;
import com.baomidou.mybatisplus.extension.service.IService;
import com.domoyun.eduservice.entity.VO.CourseInfoForm;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author luozuanshi
 * @since 2021-05-18
 */
public interface CourseService extends IService<Course> {

    String saveCourseInfo(CourseInfoForm courseInfoForm);
}
