package org.example.tliastest.service;

import org.example.tliastest.pojo.Emp;
import org.example.tliastest.pojo.EmpQueryParam;
import org.example.tliastest.pojo.PageResult;
import org.example.tliastest.pojo.Result;

import java.util.List;

public interface EmpService {

    public PageResult getEmp(EmpQueryParam empQueryParam);

    void addEmp(Emp emp);
}
