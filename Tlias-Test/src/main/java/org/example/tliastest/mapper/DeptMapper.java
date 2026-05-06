package org.example.tliastest.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.jdbc.Null;
import org.example.tliastest.pojo.Dept;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface DeptMapper {

    @Select("select id,name,create_time,update_time from dept order by create_time desc")
    public List<Dept> findAll();

    // 删除id对应的部门数据
    @Delete("delete from dept where id = #{id}")
    public void delList(int id);

    @Insert("insert into dept (name, create_time, update_time) values (#{name}, #{createTime}, #{updateTime})")
    public void addList(Dept dept);
}
