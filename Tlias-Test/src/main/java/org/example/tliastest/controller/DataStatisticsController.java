package org.example.tliastest.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.tliastest.pojo.JobObjective;
import org.example.tliastest.pojo.Result;
import org.example.tliastest.service.EmpService;
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

    @RequestMapping("/empJobData")
    public Result empJobData(){
        log.info("获取员工岗位数据");
        JobObjective jobObjective = empService.getJobObjective();
        log.info("员工岗位数据: {}", jobObjective);
        return Result.success(jobObjective);
    }

    @GetMapping("/empGenderData")
    public Result empGenderData(){
        return Result.success(empService.getEmpGenderData());
    }

}
