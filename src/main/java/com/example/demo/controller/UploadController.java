package com.example.demo.controller;

import com.example.demo.component.Upload;
import com.example.demo.utils.RestResult;
import com.example.demo.utils.StringUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @ClassName UploadController
 * @Description TODO
 * @Author feroctiy
 * @Date 2019/9/3 12:14
 * @Version 1.0
 */
@RestController
public class UploadController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private List<String> acceptFile;

    @RequestMapping(value = "/upload")
    public RestResult upload(@RequestBody MultipartFile file) {
        logger.info("-------------------");
        RestResult restResult = new RestResult();
        String fileName =file.getOriginalFilename(),suffix,dateFolderName,saveFolderName,newFileName;
        if (StringUtils.isEmpty(fileName) || !fileName.contains(".")) {
            restResult.setStatus(400);
            restResult.setMessage("文件名格式错误");
            return restResult;
        }
        acceptFile= Arrays.asList(Upload.instance.getAcceptType().split(";"));

        //文件后缀
        suffix = fileName.substring(fileName.lastIndexOf(".")).toLowerCase();
        if (!acceptFile.contains(suffix)){
            restResult.setStatus(400);
            restResult.setMessage("文件格式不支持");
            return restResult;
        }
        dateFolderName = (new SimpleDateFormat("yyyyMMdd")).format(new Date());
        saveFolderName = Upload.instance.getSavePath() + FileSystems.getDefault().getSeparator() + dateFolderName;
        createFolder(saveFolderName);
        newFileName = UUID.randomUUID().toString().replace("-", "") + suffix;
        File targetFile = new File(saveFolderName + File.separator + newFileName);
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(targetFile);
            IOUtils.copy(file.getInputStream(), fileOutputStream);
        } catch (IOException e) {
            restResult.setStatus(400);
            restResult.setMessage("上传图片异常");
            return restResult;
        }finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
            }
        }
        restResult.setStatus(200);
        restResult.setMessage("上传成功");
        restResult.setData(dateFolderName+File.separator+newFileName);
        return restResult;
    }



    /**
     * 创建文件夹
     *
     * @param folderName
     */
    private void createFolder(String folderName) {
        Path folderPath = FileSystems.getDefault().getPath(folderName);
        try {
            if (Files.notExists(folderPath)) {
                Files.createDirectory(folderPath);
                logger.info("CreatePath:" + folderPath.toString());
            }
        } catch (Exception e) {
            logger.info("创建目录失败", e);
        }
    }
}
