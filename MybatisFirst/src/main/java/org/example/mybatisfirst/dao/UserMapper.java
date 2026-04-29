package org.example.mybatisfirst.dao;

import org.apache.ibatis.annotations.*;
import org.example.mybatisfirst.pojo.User;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from employee where age < 30 and education = '本科' and name like '张%' and gender = '男' order by age desc")
    List<User> getUserList();

    @Insert("insert into employee(id, name, age, gender, department, position, education, hire_date, join_time, phone) values (#{id}, #{name}, #{age}, #{gender}, #{department}, #{position}, #{education}, #{hireDate}, #{joinTime}, #{phone})")
    void add(User user);

    @Update("update employee set department=#{department}, position=#{position}, join_time=#{joinTime} where id=#{id}")
    void update(@Param("id") String id, @Param("department") String department, @Param("position") String position, @Param("joinTime") String joinTime);

    @Delete("delete from employee where id = #{id}")
    int del(String id);

    @Select("select * from employee where id = #{id}")
    User getUser(@Param("id") String id);

    User searchById(@Param("id") String id);

    void addUser(User user);
}
