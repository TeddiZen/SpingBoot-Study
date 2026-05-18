package org.example.tliastest.service;

import org.example.tliastest.pojo.*;

import java.util.List;
import java.util.Map;

public interface EmpService {

    public PageResult getEmp(EmpQueryParam empQueryParam);

    void addEmp(Emp emp);

    void delEmp(String ids);

    Emp getIdEmp(Integer id);

    void updateEmp(Emp emp);

    JobObjective getJobObjective();

    List<Map<String, Object>> getEmpGenderData();

    List<Emp> getEmpList();

    LoginObjective login(Emp emp);
}
