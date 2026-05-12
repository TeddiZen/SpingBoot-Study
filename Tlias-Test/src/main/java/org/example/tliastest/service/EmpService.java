package org.example.tliastest.service;

import org.example.tliastest.pojo.Emp;
import org.example.tliastest.pojo.EmpQueryParam;
import org.example.tliastest.pojo.PageResult;

import java.util.List;

public interface EmpService {

    public PageResult getEmp(EmpQueryParam empQueryParam);
}
