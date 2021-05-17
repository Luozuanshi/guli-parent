package com.domoyun.eduservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.domoyun.eduservice.entity.Subject;
import com.domoyun.eduservice.entity.VO.OneSubjectVo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface SubjectService extends IService<Subject> {
    void importSubjectData(MultipartFile file, SubjectService subjectService);

    List<OneSubjectVo> getAllSubject();
}
