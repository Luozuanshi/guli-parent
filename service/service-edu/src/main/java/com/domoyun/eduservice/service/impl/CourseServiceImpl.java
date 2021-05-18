package com.domoyun.eduservice.service.impl;

import com.domoyun.eduservice.entity.Course;
import com.domoyun.eduservice.entity.CourseDescription;
import com.domoyun.eduservice.entity.VO.CourseInfoForm;
import com.domoyun.eduservice.mapper.CourseMapper;
import com.domoyun.eduservice.service.CourseDescriptionService;
import com.domoyun.eduservice.service.CourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.domoyun.servicebase.handler.GuliException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author luozuanshi
 * @since 2021-05-18
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    @Autowired
    private CourseDescriptionService courseDescriptionService;

    @Override
    public String saveCourseInfo(CourseInfoForm courseInfoForm) {

        //保存课程基本信息
        Course course = new Course();
        course.setStatus(Course.COURSE_DRAFT);
        BeanUtils.copyProperties(courseInfoForm, course);
        boolean resultCourseInfo = this.save(course);
        if(!resultCourseInfo){
            throw new GuliException(20001, "课程信息保存失败");
        }

        //保存课程详情信息
        CourseDescription courseDescription = new CourseDescription();
        courseDescription.setDescription(courseInfoForm.getDescription());
        courseDescription.setId(course.getId());
        boolean resultDescription = courseDescriptionService.save(courseDescription);
        if(!resultDescription){
            throw new GuliException(20001, "课程详情信息保存失败");
        }

        return course.getId();
    }
}
