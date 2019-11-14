package com.lp.ssm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.UUID;

@Controller
@RequestMapping("upload")
public class UploadController {

    //商品图片上传
    @RequestMapping("itemspic")
    public void itemspic(HttpServletRequest request,PrintWriter writer) throws Exception{

        //1.获取文件数据
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
        MultipartFile originalFileName = multipartHttpServletRequest.getFile("itemsPic");
//        System.out.println("上传文件大小为：" + originalFileName.getSize());

        //2.保存文件
        String uploadPath = request.getServletContext().getRealPath("/upload");
        File file = new File(uploadPath);
        if (!file.exists()){
            file.mkdirs();
        }
        String suffix = originalFileName.getOriginalFilename().split("\\.")[1];
        String fileName = UUID.randomUUID().toString().replace("-", "") + "." + suffix;
        String totalUploadPath = uploadPath + "\\" + fileName;
        System.out.println(totalUploadPath);
        FileCopyUtils.copy(originalFileName.getInputStream(),new FileOutputStream(new File(totalUploadPath)));

        //3.返回到客户端
        String imgURL = "http://localhost:8080/upload/" + fileName;
//        System.out.println(imgURL);
        String responseJson = "{\"imgUrl\":\"" + imgURL + "\"}";
        writer.write(responseJson);
    }
}
