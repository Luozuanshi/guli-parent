package com.domoyun.eduservice.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.domoyun.eduservice.entity.Subject;
import com.domoyun.eduservice.entity.excel.ExcelSubjectData;
import com.domoyun.eduservice.listenner.SubjectExcelListener;
import com.domoyun.eduservice.mapper.SubjectMapper;
import com.domoyun.eduservice.service.SubjectService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements SubjectService  {


    @Override
    public void importSubjectData(MultipartFile file, SubjectService subjectService) {
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
            EasyExcel.read(inputStream, ExcelSubjectData.class,new SubjectExcelListener(subjectService)).sheet("用户管理").doRead();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
