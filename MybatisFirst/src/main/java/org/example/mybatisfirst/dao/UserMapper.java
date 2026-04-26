package org.example.mybatisfirst.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.mybatisfirst.pojo.User;

import java.util.List;

@Mapper
public interface UserMapper {
    // 查询年龄小于30岁的员工筛选学历本科的员工，年龄从大到小排序，姓名以张开头的员工
    @Select("select * from employee where age < 30 and education = '本科' and name like '张%' and gender = '男' order by age desc")
    List<User> getUserList();
}
