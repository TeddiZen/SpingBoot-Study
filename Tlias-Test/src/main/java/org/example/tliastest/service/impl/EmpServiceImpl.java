package org.example.tliastest.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.example.tliastest.mapper.EmpExprMapper;
import org.example.tliastest.mapper.EmpMapper;
import org.example.tliastest.pojo.*;
import org.example.tliastest.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    EmpMapper empMapper;
    @Autowired
    EmpExprMapper empExprMapper;

    @Override
    public PageResult getEmp(EmpQueryParam emp){
        PageHelper.startPage(emp.getPage(), emp.getPageSize());
        List<Emp> emps = empMapper.selectAll(emp);
        PageInfo<Emp> pageInfo = new PageInfo<>(emps);
        PageResult res = new PageResult(pageInfo.getTotal(),pageInfo.getList());
        return res;
    }

    @Override
    public void addEmp(Emp emp) {
        LocalDateTime date = LocalDateTime.now();
        emp.setCreateTime(date);
        emp.setUpdateTime(date);

        empMapper.insertEmp(emp);

        List<EmpExpr> exprList = emp.getExprList();
        exprList.forEach(expr -> {
            empExprMapper.insertEmpExpr(expr);
        });
    }
}
