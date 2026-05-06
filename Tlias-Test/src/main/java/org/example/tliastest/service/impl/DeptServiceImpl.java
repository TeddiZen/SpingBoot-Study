package org.example.tliastest.service.impl;

import org.example.tliastest.mapper.DeptMapper;
import org.example.tliastest.pojo.Dept;
import org.example.tliastest.service.DeptService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }

    @Override
    public void delDept(int id) {
        deptMapper.delList(id);
    }

    @Override
    public void addDept(Dept dept){
        LocalDateTime dateNow = LocalDateTime.now();
        dept.setCreateTime(dateNow);
        dept.setUpdateTime(dateNow);
        deptMapper.addList(dept);
    }
}
