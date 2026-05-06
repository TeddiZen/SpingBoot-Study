package org.example.tliastest.service;

import org.example.tliastest.pojo.Dept;
import org.example.tliastest.pojo.Result;

import java.util.List;

public interface DeptService {
    public List<Dept> findAll();
    public void delDept(int id);
}
