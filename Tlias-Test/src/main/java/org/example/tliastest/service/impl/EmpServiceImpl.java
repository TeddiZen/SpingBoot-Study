package org.example.tliastest.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
        PageHelper.startPage(page, pageSize);
        List<Emp> emps = empMapper.selectAll();
        PageInfo<Emp> pageInfo = new PageInfo<>(emps);
        PageResult res = new PageResult(pageInfo.getTotal(),pageInfo.getList());
        return res;
    }
}
