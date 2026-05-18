package org.example.tliastest.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.example.tliastest.exception.DelClazzException;
import org.example.tliastest.mapper.ClazzMapper;
import org.example.tliastest.mapper.StudentsMapper;
import org.example.tliastest.pojo.Clazz;
import org.example.tliastest.pojo.ClazzQueryParam;
import org.example.tliastest.pojo.EmpLog;
import org.example.tliastest.pojo.PageResult;
import org.example.tliastest.service.ClazzService;
import org.example.tliastest.service.EmpLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    ClazzMapper clazzMapper;

    @Autowired
    StudentsMapper studentsMapper;

    @Autowired
    EmpLogService empLogService;

    @Override
    public PageResult<Clazz> getClassList(ClazzQueryParam clazzQueryParam) {
        PageHelper pageHelper = new PageHelper();
        pageHelper.startPage(clazzQueryParam.getPage(), clazzQueryParam.getPageSize());
        List<Clazz> clazzList = clazzMapper.selectByQueryParam(clazzQueryParam);
        LocalDate dateTime = LocalDate.now();
        clazzList.stream().forEach(clazz -> {
            if (dateTime.isAfter(clazz.getEndDate())) {
                clazz.setStatus("已结束");
            } else if (dateTime.isBefore(clazz.getBeginDate())) {
                clazz.setStatus("未开班");
            } else {
                clazz.setStatus("在读中");
            }
        });
        PageInfo<Clazz> pageInfo = new PageInfo<>(clazzList);
        PageResult<Clazz> pageResult = new PageResult<>(pageInfo.getTotal(), pageInfo.getList());
        return pageResult;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delClass(Integer id) {
        String logInfo = "删除班级" + id;
        try {
            Integer count = studentsMapper.selectByClazzId(id);
            if (count > 0) {
                throw new DelClazzException("id为" + id + "的班级下有" + count + "个学生，无法删除");
            }
            clazzMapper.deleteByPrimaryKey(id);
        } catch (DelClazzException e) {
            throw e;
        } finally {
            empLogService.insertLog(new EmpLog(null, LocalDateTime.now(), logInfo));
        }
    }

    @Override
    public Clazz getClazz(Integer id) {
        return clazzMapper.selectByPrimaryKey(id);
    }

    @Override
    public void addClazz(Clazz clazz) {
        LocalDateTime dateTime = LocalDateTime.now();
        clazz.setCreateTime(dateTime);
        clazz.setUpdateTime(dateTime);
        clazzMapper.addClazz(clazz);
    }

    @Override
    public void updateClazz(Clazz clazz) {
        LocalDateTime dateTime = LocalDateTime.now();
        clazz.setUpdateTime(dateTime);
        clazzMapper.updateClazz(clazz);
    }

    @Override
    public List<Clazz> getAllClass() {
        return clazzMapper.selectAll();
    }
}
