package org.example.tliastest.service.impl;

import org.example.tliastest.mapper.EmpMapper;
import org.example.tliastest.pojo.Emp;
import org.example.tliastest.pojo.PageResult;
import org.example.tliastest.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    EmpMapper empMapper;

    @Override
    public PageResult getEmp(Integer page, Integer pageSize){
        Integer start = ( page - 1 ) * pageSize;
        List<Emp> emps = empMapper.selectAll(start, pageSize);
        Integer count = empMapper.selectCount();
        PageResult res = new PageResult(count, emps);
        return res;
    }
}
