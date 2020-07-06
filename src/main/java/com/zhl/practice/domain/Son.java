package com.zhl.practice.domain;

import org.apache.commons.io.FileUtils;
import org.apache.http.entity.ContentType;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Son extends Person{
    
    public static int age = 28;

    private int leila;

    public Class a ;

    public String name = "holley";
    public String text;

    public Son(String text) {
        this.text =  text;
    }

    public Son() {

    }

    @Override
    public void drink(){
        System.out.println(text);
    }

    @Override
    public void eat(){
        System.out.print(age);
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String getName() {
        return name;
    }

    private void privateMoth(){}

    public static void main(String[] aa){
//        S s = new S();
        Son son = new Son("test");
        son.drink();
        System.out.println(son.name);
        File file = new File("C:\\资源\\mongodb.png");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            MultipartFile multipartFile = new MockMultipartFile(file.getName(), file.getName(),
                    ContentType.APPLICATION_OCTET_STREAM.toString(), fileInputStream);
            System.out.println(multipartFile.getOriginalFilename());
        } catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(~6);
    }
}
