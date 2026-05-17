package org.example.tliastest.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.example.tliastest.mapper.StudentsMapper;
import org.example.tliastest.pojo.PageResult;
import org.example.tliastest.pojo.Student;
import org.example.tliastest.pojo.StudentCountObject;
import org.example.tliastest.pojo.StudentsQueryParam;
import org.example.tliastest.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

@Service
public class StudentsServiceImpl implements StudentsService {

    @Autowired
    StudentsMapper studentsMapper;

    @Override
    public PageResult<Student> selectAll(StudentsQueryParam studentsQueryParam) {
        PageHelper.startPage(studentsQueryParam.getPage(), studentsQueryParam.getPageSize());
        List<Student> students = studentsMapper.selectAll(studentsQueryParam);
        PageInfo<Student> pageInfo = new PageInfo<>(students);
        PageResult<Student> res = new PageResult<>(pageInfo.getTotal(),pageInfo.getList());
        return res;
    }

    @Override
    public void deleteByIds(String ids) {
        List<Integer> idList = Arrays.stream(ids.split(","))
                .map(Integer::valueOf)
                .toList();
        studentsMapper.deleteByIds(idList);
    }

    @Override
    public void addStudent(Student student) {
        LocalDateTime now = LocalDateTime.now();
        student.setCreateTime(now);
        student.setUpdateTime(now);
        studentsMapper.insert(student);
    }

    @Override
    public Student selectById(Integer id) {
        Student student = studentsMapper.selectById(id);
        return student;
    }

    @Override
    public void updateStudent(Student student) {
        LocalDateTime now = LocalDateTime.now();
        student.setUpdateTime(now);
        studentsMapper.update(student);
    }

    @Override
    public void violation(Integer id, Integer score) {
        LocalDateTime now = LocalDateTime.now();
        studentsMapper.violation(id, score, now);
    }

    @Override
    public List<Map<String, Object>> getStudentDegreeData() {
        return studentsMapper.getStudentDegreeData();
    }

    @Override
    public StudentCountObject getStudentCountData() {
        List<Map<String, Object>> studentCountData = studentsMapper.getStudentCountData();
        StudentCountObject studentCountObject = new StudentCountObject();
        studentCountObject.setClazzList(studentCountData.stream().map(map -> map.get("clazzName")).toList());
        studentCountObject.setDataList(studentCountData.stream().map(map -> map.get("count")).toList());
        return studentCountObject;
    }
}
