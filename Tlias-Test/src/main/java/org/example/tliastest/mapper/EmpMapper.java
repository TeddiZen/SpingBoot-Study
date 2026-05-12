package org.example.tliastest.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.tliastest.pojo.Emp;
import org.example.tliastest.pojo.EmpQueryParam;

import java.util.List;

@Mapper
public interface EmpMapper {

    List<Emp> selectAll(EmpQueryParam emp);

    @Select("SELECT COUNT(*) FROM emp e LEFT JOIN dept d ON e.dept_id = d.id")
    Integer selectCount();
}
