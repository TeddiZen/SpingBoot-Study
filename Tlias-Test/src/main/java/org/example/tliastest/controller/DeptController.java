package org.example.tliastest.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.tliastest.pojo.Dept;
import org.example.tliastest.pojo.Result;
import org.example.tliastest.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    /**
     * 查询所有部门数据
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Result list() {
        log.info("查询所有部门数据");
        List<Dept> depts = deptService.findAll();
        log.info("查询所有部门数据成功");
        return Result.success(depts);
    }

    /**
     * 删除id对应的部门数据
     */
    @DeleteMapping("")
    public Result delList(@RequestParam("id") int id){
        deptService.delDept(id);
        log.info("删除id为{}的部门成功", id);
        return Result.success();
    }

    /**
     * 添加部门数据
     */
    @PostMapping("")
    public Result addList(@RequestBody Dept dept){
        deptService.addDept(dept);
        log.info("添加部门成功");
        return Result.success();
    }

    /**
     * 请求回显 部门数据
     */
    @GetMapping("/{id}")
    public Result getList(@PathVariable int id){
        Dept dept = deptService.getDept(id);
        log.info("查询id为{}的部门数据成功", id);
        return Result.success(dept);
    }

    /**
     * 修改部门数据
     */
    @PutMapping("")
    public Result putList(@RequestBody Dept dept){
        deptService.putDept(dept);
        log.info("修改部门数据成功");
        return Result.success();
    }
}
