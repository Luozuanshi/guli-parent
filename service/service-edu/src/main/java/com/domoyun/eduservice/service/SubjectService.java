package com.domoyun.eduservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.domoyun.eduservice.entity.Subject;
import org.springframework.web.multipart.MultipartFile;

public interface SubjectService extends IService<Subject> {
    void importSubjectData(MultipartFile file, SubjectService subjectService);
}
