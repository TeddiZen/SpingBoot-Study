package org.example.tliastest.mapper;

import org.apache.ibatis.annotations.*;
import org.example.tliastest.pojo.Emp;
import org.example.tliastest.pojo.EmpQueryParam;

import java.util.List;

@Mapper
public interface EmpMapper {

    List<Emp> selectAll(EmpQueryParam emp);

    @Select("SELECT COUNT(*) FROM emp e LEFT JOIN dept d ON e.dept_id = d.id")
    Integer selectCount();

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("INSERT INTO emp (username, password, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time) " +
            "VALUES (#{username}, #{password}, #{name}, #{gender}, #{phone}, #{job}, #{salary}, #{image}, #{entryDate}, #{deptId}, #{createTime}, #{updateTime})")
    void insertEmp(Emp emp);

    void delEmp(List<Integer> ids);

    @Select("select e.*, d.name as deptName from emp e left join dept d on e.dept_id = d.id where e.id = #{id}")
    Emp getIdEmp(Integer id);

    @Update("update emp set username = #{username},password = #{password}, name = #{name}, gender = #{gender}, phone = #{phone}, job = #{job}, salary = #{salary}, image = #{image}, entry_date = #{entryDate}, dept_id = #{deptId}, update_time = #{updateTime} where id = #{id}")
    void updateEmp(Emp emp);
}
