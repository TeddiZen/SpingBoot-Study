package org.example.tliastest.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.tliastest.pojo.EmpExpr;

import java.util.List;

@Mapper
public interface EmpExprMapper {
    void insertEmpExpr(List<EmpExpr> exprList);
    List<EmpExpr> selectEmpExpr(Integer id);
    void delEmpExpr(List<Integer> iids);
}
