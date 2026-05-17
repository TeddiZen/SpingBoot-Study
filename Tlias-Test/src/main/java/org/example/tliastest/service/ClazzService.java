package org.example.tliastest.service;

import org.example.tliastest.pojo.Clazz;
import org.example.tliastest.pojo.ClazzQueryParam;
import org.example.tliastest.pojo.PageResult;

import java.util.List;

public interface ClazzService {

    PageResult<Clazz> getClassList(ClazzQueryParam clazzQueryParam);

    void delClass(Integer id);

    Clazz getClazz(Integer id);

    void addClazz(Clazz clazz);

    void updateClazz(Clazz clazz);

    List<Clazz> getAllClass();
}
