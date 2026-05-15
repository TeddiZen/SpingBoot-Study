package org.example.tliastest.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.example.tliastest.mapper.EmpExprMapper;
import org.example.tliastest.mapper.EmpLogMapper;
import org.example.tliastest.mapper.EmpMapper;
import org.example.tliastest.pojo.*;
import org.example.tliastest.service.EmpLogService;
import org.example.tliastest.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.beans.Transient;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    EmpMapper empMapper;

    @Autowired
    EmpExprMapper empExprMapper;

    @Autowired
    EmpLogService empLogService;


    @Override
    public PageResult getEmp(EmpQueryParam emp){
        PageHelper.startPage(emp.getPage(), emp.getPageSize());
        List<Emp> emps = empMapper.selectAll(emp);
        PageInfo<Emp> pageInfo = new PageInfo<>(emps);
        PageResult res = new PageResult(pageInfo.getTotal(),pageInfo.getList());
        return res;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addEmp(Emp emp) {
        try {
            LocalDateTime date = LocalDateTime.now();
            emp.setCreateTime(date);
            emp.setUpdateTime(date);

            empMapper.insertEmp(emp);

            List<EmpExpr> exprList = emp.getExprList();
            if(!CollectionUtils.isEmpty(exprList)){
                exprList.forEach(expr -> expr.setEmpId(emp.getId()));
                empExprMapper.insertEmpExpr(exprList);
            }
        } finally {
            EmpLog log = new EmpLog(null, LocalDateTime.now(), "添加员工" + emp);
            empLogService.insertLog(log);
        }
    }

    @Override
    public void delEmp(String ids){
        List<Integer> iids = Arrays.stream(ids.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        empMapper.delEmp(iids);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Emp getIdEmp(Integer id){
        try {
            Emp emp = empMapper.getIdEmp(id);
            List<EmpExpr> exprList = empExprMapper.selectEmpExpr(id);
            emp.setExprList(exprList);
            return emp;
        } finally {
            EmpLog log = new EmpLog(null, LocalDateTime.now(), "查询员工" + id);
            empLogService.insertLog(log);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateEmp(Emp emp){
        try {
            LocalDateTime date = LocalDateTime.now();
            emp.setUpdateTime(date);
            empMapper.updateEmp(emp);
            if (!CollectionUtils.isEmpty(emp.getExprList())){
                empExprMapper.updateEmpExpr(emp.getExprList());
            }
        } finally {
            EmpLog log = new EmpLog(null, LocalDateTime.now(), "更新员工" + emp);
            empLogService.insertLog(log);
        }
    }
}
