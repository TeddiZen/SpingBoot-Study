package org.example.tliastest.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.tliastest.mapper.EmpMapper;
import org.example.tliastest.pojo.Emp;
import org.example.tliastest.pojo.EmpQueryParam;
import org.example.tliastest.pojo.PageResult;
import org.example.tliastest.pojo.Result;
import org.example.tliastest.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    EmpService empService;

    /**
     * 分页查询员工列表
     * @param page
     * @param pageSize
     */
    @GetMapping
    public Result getEmp(EmpQueryParam empQueryParam){
         log.info("分页查询" , empQueryParam);
         PageResult res = empService.getEmp(empQueryParam);
         log.info("分页查询完成");
         return Result.success(res);
    }
}
