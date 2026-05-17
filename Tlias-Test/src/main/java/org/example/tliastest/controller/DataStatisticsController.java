package org.example.tliastest.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.tliastest.pojo.JobObjective;
import org.example.tliastest.pojo.Result;
import org.example.tliastest.service.EmpService;
import org.example.tliastest.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/report")
public class DataStatisticsController {

    @Autowired
    private EmpService empService;

    @Autowired
    private StudentsService studentsService;

    @RequestMapping("/empJobData")
    public Result empJobData(){
        log.info("获取员工岗位数据");
        JobObjective jobObjective = empService.getJobObjective();
        log.info("员工岗位数据: {}", jobObjective);
        return Result.success(jobObjective);
    }

    @GetMapping("/empGenderData")
    public Result empGenderData(){
        log.info("获取员工性别数据");
        log.info("员工性别数据: {}", empService.getEmpGenderData());
        return Result.success(empService.getEmpGenderData());
    }

    @GetMapping("/studentDegreeData")
    public Result studentDegreeData(){
        log.info("获取学生学历数据");
        log.info("学生学历数据: {}", studentsService.getStudentDegreeData());
        return Result.success(studentsService.getStudentDegreeData());
    }

    @GetMapping("/studentCountData")
    public Result studentCountData(){
        log.info("获取学生人数数据");
        log.info("学生人数数据: {}", studentsService.getStudentCountData());
        return Result.success(studentsService.getStudentCountData());
    }

}
