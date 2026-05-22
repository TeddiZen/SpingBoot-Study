package org.example.tliastest.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.oss.AliyunOSSOperator;
import org.example.tliastest.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
public class UploadController {

    @Autowired
    AliyunOSSOperator ossOperator;

    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws Exception {
        try {
            log.info("上传文件: {}", file.getOriginalFilename());
            String url = ossOperator.upload(file.getBytes(), file.getOriginalFilename());
            log.info("上传成功: {}", url);
            return Result.success(url);
        } catch (Exception e) {
            return Result.error("上传失败");
        }
    }
}
