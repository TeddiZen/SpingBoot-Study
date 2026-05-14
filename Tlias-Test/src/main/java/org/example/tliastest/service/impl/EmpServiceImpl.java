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
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Date;
import java.util.List;

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
            EmpLog log = new EmpLog(null, LocalDateTime.now(), "添加员工成功,员工信息:" + emp);
            empLogService.insertLog(log);
        }
    }
}
