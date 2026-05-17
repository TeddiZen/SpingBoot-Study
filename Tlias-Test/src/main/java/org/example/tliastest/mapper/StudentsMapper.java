package org.example.tliastest.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.tliastest.pojo.Student;
import org.example.tliastest.pojo.StudentsQueryParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface StudentsMapper {

    public List<Student> selectAll(StudentsQueryParam studentsQueryParam);

    public void deleteByIds(List<Integer> ids);

    void insert(Student student);

    Student selectById(Integer id);

    void update(Student student);

    void violation(Integer id, Integer score, LocalDateTime updateTime);
}
