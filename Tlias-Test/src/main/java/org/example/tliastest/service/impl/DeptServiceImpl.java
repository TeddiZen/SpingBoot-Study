package org.example.tliastest.service.impl;

import org.example.tliastest.mapper.DeptMapper;
import org.example.tliastest.pojo.Dept;
import org.example.tliastest.service.DeptService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }
}
