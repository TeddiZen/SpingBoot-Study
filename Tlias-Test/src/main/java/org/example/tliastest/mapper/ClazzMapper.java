package org.example.tliastest.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.tliastest.pojo.Clazz;
import org.example.tliastest.pojo.ClazzQueryParam;

import java.util.List;

@Mapper
public interface ClazzMapper {
    List<Clazz> selectByQueryParam(ClazzQueryParam clazzQueryParam);

    void deleteByPrimaryKey(int id);

    Clazz selectByPrimaryKey(int id);

    void addClazz(Clazz clazz);

    void updateClazz(Clazz clazz);

    List<Clazz> selectAll();
}
