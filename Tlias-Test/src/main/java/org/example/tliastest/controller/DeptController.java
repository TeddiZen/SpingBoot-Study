package org.example.tliastest.controller;

import org.example.tliastest.mapper.DeptMapper;
import org.example.tliastest.pojo.Dept;
import org.example.tliastest.pojo.Result;
import org.example.tliastest.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    @GetMapping("/depts")
    public Result list() {
        System.out.println("查询所有部门数据");
        List<Dept> depts = deptService.findAll();
        return Result.success(depts);
    }
}
