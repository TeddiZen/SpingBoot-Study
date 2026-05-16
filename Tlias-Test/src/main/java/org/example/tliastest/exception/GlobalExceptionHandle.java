package org.example.tliastest.exception;

import lombok.extern.slf4j.Slf4j;
import org.example.tliastest.pojo.Result;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandle {

    @ExceptionHandler
    public Result handleException(Exception e){
        log.error("全局异常处理",e);
        return Result.error("出错，请联系管理员！");
    }

    @ExceptionHandler
    public Result handleException(DuplicateKeyException e){
        log.error("全局异常处理",e);
        String msg = e.getMessage();
        int index = msg.indexOf("Duplicate entry");
        msg = msg.substring(index);
        String[] arr = msg.split(" ");
        return Result.error(arr[2] + "已存在！");
    }
}
