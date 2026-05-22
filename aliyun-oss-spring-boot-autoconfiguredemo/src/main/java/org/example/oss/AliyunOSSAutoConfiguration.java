package org.example.oss;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(AliyunOSSProperties.class)
public class AliyunOSSAutoConfiguration {

    @Bean
    public  AliyunOSSOperator ossOperator(AliyunOSSProperties ossProperties)  {
        return new AliyunOSSOperator(ossProperties);
    }
}
