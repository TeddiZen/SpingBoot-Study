package org.example.tliastest.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.tliastest.pojo.Emp;

import java.util.List;

@Mapper
public interface EmpMapper {
    @Select("SELECT e.*, d.name deptName " +
            "FROM emp e " +
            "LEFT JOIN dept d ON e.dept_id = d.id " +
            "LIMIT #{start}, #{pageSize}")
    List<Emp> selectAll();

    @Select("SELECT COUNT(*) FROM emp e LEFT JOIN dept d ON e.dept_id = d.id")
    Integer selectCount();
}
