package org.example.tliastest.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.tliastest.pojo.Dept;
import org.example.tliastest.pojo.Result;
import org.example.tliastest.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.naming.Name;
import java.util.List;

@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    /**
     * 查询所有部门数据
     */
    @GetMapping("/depts")
    @RequestMapping(value = "/depts", method = RequestMethod.GET)
    public Result list() {
        System.out.println("查询所有部门数据");
        List<Dept> depts = deptService.findAll();
        return Result.success(depts);
    }

    /**
     * 删除id对应的部门数据
     */
    @DeleteMapping("/depts")
    public Result delList(@RequestParam("id") int id){
        deptService.delDept(id);
        System.out.println("删除id为" + id + "的部门");
        return Result.success();
    }

    /**
     * 添加部门数据
     */
    @PostMapping("depts")
    public Result addList(@RequestBody Dept dept){
        deptService.addDept(dept);
        return Result.success();
    }

    /**
     * 请求回显 部门数据
     */
    @GetMapping("depts/{id}")
    public Result getList(@PathVariable int id){
        Dept dept = deptService.getDept(id);
        return Result.success(dept);
    }
}
