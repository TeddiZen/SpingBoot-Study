package org.example.tliastest.service;

import org.example.tliastest.pojo.PageResult;
import org.example.tliastest.pojo.Student;
import org.example.tliastest.pojo.StudentCountObject;
import org.example.tliastest.pojo.StudentsQueryParam;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface StudentsService {

    PageResult<Student> selectAll(StudentsQueryParam studentsQueryParam);

    void deleteByIds(String ids);

    void addStudent(Student student);

    Student selectById(Integer id);

    void updateStudent(Student student);

    void violation(Integer id, Integer score);

    List<Map<String, Object>> getStudentDegreeData();

    StudentCountObject getStudentCountData();
}
