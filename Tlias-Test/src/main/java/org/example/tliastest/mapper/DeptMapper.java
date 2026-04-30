package org.example.tliastest.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.tliastest.pojo.Dept;

import java.util.List;

@Mapper
public interface DeptMapper {

    @Select("select id,name,create_time,update_time from dept order by create_time desc")
    public List<Dept> findAll();
}
