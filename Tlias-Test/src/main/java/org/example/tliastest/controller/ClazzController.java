package org.example.tliastest.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.tliastest.pojo.Clazz;
import org.example.tliastest.pojo.ClazzQueryParam;
import org.example.tliastest.pojo.PageResult;
import org.example.tliastest.pojo.Result;
import org.example.tliastest.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/clazzs")
public class ClazzController {

    @Autowired
    private ClazzService clazzService;

    @GetMapping
    public Result getClass(ClazzQueryParam clazzQueryParam) {
        log.info("接收到{}", clazzQueryParam);
        PageResult<Clazz> res = clazzService.getClassList(clazzQueryParam);
        log.info("查询到{}条班级", res.getTotal());
        return Result.success(res);
    }

    @DeleteMapping("/{id}")
    public Result delClass(@PathVariable Integer id) {
        log.info("删除班级{}", id);
        clazzService.delClass(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getClass(@PathVariable Integer id) {
        log.info("ID为{}的班级", id);
        Clazz clazz = clazzService.getClazz(id);
        return Result.success(clazz);
    }

    @PostMapping
    public Result addClass(@RequestBody Clazz clazz) {
        log.info("添加班级{}", clazz);
        clazzService.addClazz(clazz);
        return Result.success();
    }

    @PutMapping
    public Result updateClass(@RequestBody Clazz clazz) {
        log.info("更新班级{}", clazz);
        clazzService.updateClazz(clazz);
        return Result.success();
    }

    @GetMapping("/list")
    public Result getAllClass() {
        log.info("查询所有班级");
        List<Clazz> clazzList = clazzService.getAllClass();
        return Result.success(clazzList);
    }
}
