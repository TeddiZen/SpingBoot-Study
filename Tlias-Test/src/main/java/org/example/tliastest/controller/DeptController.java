package org.example.tliastest.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.tliastest.pojo.Dept;
import org.example.tliastest.pojo.Result;
import org.example.tliastest.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    @RequestMapping(value = "/depts", method = RequestMethod.GET)
    public Result list() {
        System.out.println("查询所有部门数据");
        List<Dept> depts = deptService.findAll();
        return Result.success(depts);
    }

    @DeleteMapping("/depts")
    public Result delList(HttpServletRequest request){
        String strId = request.getParameter("id");
        int id = Integer.parseInt(strId);
        deptService.delDept(id);
        System.out.println("删除id为" + id + "的部门");
        return Result.success();
    }
}
