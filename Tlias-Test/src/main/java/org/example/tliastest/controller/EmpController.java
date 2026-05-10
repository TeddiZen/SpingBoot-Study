package org.example.tliastest.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.tliastest.mapper.EmpMapper;
import org.example.tliastest.pojo.Emp;
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
    public Result getEmp(@RequestParam(defaultValue = "1") Integer page,
                         @RequestParam(defaultValue = "10") Integer pageSize){
         log.info("分页查询：页码{}, 行数{}" ,page, pageSize);
         PageResult res = empService.getEmp(page, pageSize);
         log.info("分页查询完成");
         return Result.success(res);
    }
}
