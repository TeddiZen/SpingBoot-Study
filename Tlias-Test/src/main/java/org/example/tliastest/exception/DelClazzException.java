package org.example.tliastest.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DelClazzException extends RuntimeException {
    public DelClazzException(String msg){
        super(msg);
        log.error(msg);
    }
}