package org.example.tliastest;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class LogTestUnit {

    @Test
    void testLogLevel() {
        // 测试所有日志级别
        log.trace("【TRACE】级别日志");
        log.debug("【DEBUG】开发调试日志");
        log.info("【INFO】正常业务日志");
        log.warn("【WARN】警告日志");

        // 测试异常日志
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            log.error("【ERROR】测试出现异常", e);
        }

        // 测试占位符
        String name = "李四";
        int age = 22;
        log.info("单元测试用户：{}，年龄：{}", name, age);
    }
}