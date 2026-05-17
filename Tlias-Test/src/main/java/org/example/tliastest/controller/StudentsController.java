package org.example.tliastest.controller;

import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.util.AddAliasesVisitor;
import org.example.tliastest.pojo.PageResult;
import org.example.tliastest.pojo.Result;
import org.example.tliastest.pojo.Student;
import org.example.tliastest.pojo.StudentsQueryParam;
import org.example.tliastest.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/students")
public class StudentsController {

    @Autowired
    StudentsService studentsService;

    @GetMapping
    public Result selectAll(StudentsQueryParam studentsQueryParam) {
        log.info("查询所有学生: {}", studentsQueryParam);
        PageResult<Student> students = studentsService.selectAll(studentsQueryParam);
        return Result.success(students);
    }

    @DeleteMapping("/{ids}")
    public Result deleteById(@PathVariable String ids) {
        log.info("删除学生{}", ids);
        studentsService.deleteByIds(ids);
        return Result.success();
    }

    @PostMapping
    public Result addStudent(@RequestBody Student student) {
        log.info("添加学生{}", student);
        studentsService.addStudent(student);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id) {
        log.info("查询学生{}", id);
        Student student = studentsService.selectById(id);
        return Result.success(student);
    }

    @PutMapping
    public Result updateStudent(@RequestBody Student student) {
        log.info("更新学生{}", student);
        studentsService.updateStudent(student);
        return Result.success();
    }

    @PutMapping("/violation/{id}/{score}")
    public Result violation(@PathVariable Integer id, @PathVariable Integer score) {
        log.info("学生{}违规{}分", id, score);
        studentsService.violation(id, score);
        return Result.success();
    }
}
