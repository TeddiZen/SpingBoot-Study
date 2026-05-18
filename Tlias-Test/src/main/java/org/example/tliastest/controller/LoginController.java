package org.example.tliastest.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.tliastest.pojo.Emp;
import org.example.tliastest.pojo.LoginObjective;
import org.example.tliastest.pojo.Result;
import org.example.tliastest.pojo.Student;
import org.example.tliastest.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private EmpService empService;

    @PostMapping
    public Result login(@RequestBody Emp emp) {
        log.info("登录请求: {}, {}", emp.getUsername(), emp.getPassword());
        LoginObjective loginObjective = empService.login(emp);
        if (loginObjective == null) {
            return Result.error("用户名或密码错误");
        } else {
            return Result.success(loginObjective);
        }
    }
}
