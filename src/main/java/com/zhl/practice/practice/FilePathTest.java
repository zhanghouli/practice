package com.zhl.practice.practice;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.*;

/**
 * @author Holley
 * @description 请输入一句话进行描述
 * @create 2020-08-31 20:39
 **/
public class FilePathTest {

    public static void main (String[] args) {
        Reader reader = null;
        try {
            // 方法一：通过文件全路径获取文件
            String path = Thread.currentThread().getContextClassLoader().getResource("static/test.txt").getFile();
//            String path = ResourceUtils.getURL(ResourceUtils.CLASSPATH_URL_PREFIX +"static/test.txt").getPath();
//            String path = ResourceUtils.getURL("classpath:static/test.txt").getPath();
//          // 输出结果  /C:/projects/practice/target/classes/static/test.txt
            System.out.println(path);
//            File file = new File(path);
            //  方法二：通过相对路径直接获取文件
//            File file = ResourceUtils.getFile("classpath:static/test.txt");
//            ClassPathResource resource = new ClassPathResource("static/test.txt");
//            File file = resource.getFile();
//            reader = new FileReader(file);
            InputStream inputStream = new FilePathTest().getClass().getClassLoader().getResourceAsStream("static/test.txt");
            reader = new InputStreamReader(inputStream);
            char[] bytes = new char[21704];
            reader.read(bytes);
            StringBuffer sb = new StringBuffer();
            sb.append(bytes);
            // 输出结果  哈哈，这是一个测试文件
            System.out.println(sb.toString());
//            String content = new String(bytes);
//            // 输出结果  哈哈，这是一个测试文件
//            System.out.println(content);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (reader != null) {
                try {
                    reader.close();
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
