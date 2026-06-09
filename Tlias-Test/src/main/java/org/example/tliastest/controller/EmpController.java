package org.example.tliastest.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.example.tliastest.pojo.Emp;
import org.example.tliastest.pojo.EmpQueryParam;
import org.example.tliastest.pojo.PageResult;
import org.example.tliastest.pojo.Result;
import org.example.tliastest.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    EmpService empService;

    /**
     * 分页查询员工列表
     * @param empQueryParam
     * @return
     */
    @GetMapping
    public Result getEmp(EmpQueryParam empQueryParam){
         log.info("分页查询" , empQueryParam);
         PageResult res = empService.getEmp(empQueryParam);
         log.info("分页查询完成");
         return Result.success(res);
    }

    @PostMapping
    public Result addEmp(@RequestBody Emp emp){
        log.info("添加员工：{}", emp);
        empService.addEmp(emp);
        return Result.success();
    }

    @DeleteMapping
    public Result delEmp(String ids){
        empService.delEmp(ids);
        log.info("删除员工的id列表：{}", ids);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getIdEmp(@PathVariable("id") Integer id){
        log.info("查询员工的id列表：{}", id);
        Emp emp = empService.getIdEmp(id);
        log.info("查询出来的员工的列表：{}", emp);
        return Result.success(emp);
    }

    @PutMapping
    public Result updateEmp(@RequestBody Emp emp){
        empService.updateEmp(emp);
        log.info("更新员工：{}", emp);
        return Result.success();
    }

    /**
     * 查询所有员工
     * @return
     */
    @GetMapping("/list")
    public Result getEmpList(){
        List<Emp> emps = empService.getEmpList();
        log.info("查询所有员工：{}", emps);
        return Result.success(emps);
    }
}
