package com.wesley.uploadingfiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Map;

import static com.wesley.uploadingfiles.DoPred.pred;

@Configuration
@PropertySource(value = { "classpath:config.properties"})
@Controller
public class UploadingController {
    @Autowired
    Environment env;


    public static String uploadingdir = null;
    public static String filePath = null;
    public static String py_interpreter_path = null;
    public static String py_script_path = null;

    //解题相关量
    public static String answer = "";
    public static String target_sentence = "";

    //导向主页
    @RequestMapping("/")
    public String uploading(Model model) {

        py_interpreter_path = env.getProperty("path.py_interpreter_path");
        py_script_path = env.getProperty("path.py_script_path");
        uploadingdir = env.getProperty("args.upload_dir");


        System.out.println("py_interpreter_path:" + py_interpreter_path);
        System.out.println("py_script_path:" + py_script_path);
        System.out.println("uploadingdir:" + uploadingdir);

        File file = new File(uploadingdir);
        model.addAttribute("files", file.listFiles());
        return "uploading";
    }

    //上传文件
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String uploadingPost(@RequestParam("uploadingFiles") MultipartFile[] uploadingFiles) throws IOException {
        for(MultipartFile uploadedFile : uploadingFiles) {
            filePath = uploadingdir + uploadedFile.getOriginalFilename();
            File file = new File(filePath);
            uploadedFile.transferTo(file);
        }

        return "redirect:/";
    }

    //调用python处理
    @RequestMapping(value = "/process", method = RequestMethod.GET)
    public String predict() throws IOException, InterruptedException {
        System.out.println(filePath);
        //此处调用python
        String[] result = pred(py_interpreter_path, py_script_path, filePath);
        answer = result[2];
        target_sentence = result[3];

        System.out.println("答案：" + answer);
        System.out.println("有关句：" + target_sentence);

        return "result_show";
    }

    //查询计算结果
    @RequestMapping(value = "/query")
    @ResponseBody
    public Ans query() {
        Ans ans = new Ans(filePath, answer, target_sentence);
        return ans;
    }

}
