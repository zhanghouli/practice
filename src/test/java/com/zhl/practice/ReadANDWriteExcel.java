package com.zhl.practice;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Holley
 * @Description 请输入一句话进行描述
 * @create 2018-08-03 16:53
 **/
public class ReadANDWriteExcel {

    public static void main(String[]args){
        try{
            List<String> list = new ArrayList<String>();
            File file = new File("C:\\Users\\shiqi\\Documents\\WeChat Files\\hnpc110\\Files\\朱凯店行政村.xls");
            // 创建输入流，读取Excel
            HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(file));
            HSSFSheet sheet = wb.getSheetAt(0);
            String id = null;
            for(Row r : sheet){
                if(r.getCell(0).getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                    id = String.valueOf(r.getCell(0).getNumericCellValue());
                }else{
                    id = r.getCell(0).getStringCellValue();
                }
                list.add(id);
            }
            List<String> list2 = new ArrayList<String>();
            File file2 = new File("C:\\Users\\shiqi\\Documents\\WeChat Files\\hnpc110\\Files\\竹凯店行政村部分.xls");
            // 创建输入流，读取Excel
            HSSFWorkbook wb2 = new HSSFWorkbook(new FileInputStream(file2));
            HSSFSheet sheet2 = wb2.getSheetAt(0);
            for(Row r : sheet2){
                if(r.getCell(0).getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                    id = String.valueOf(r.getCell(0).getNumericCellValue());
                }else{
                    id = r.getCell(0).getStringCellValue();
                }
                list2.add(id);
            }
            HSSFWorkbook wb3 = new HSSFWorkbook();
            HSSFSheet sh = wb3.createSheet();
            int i = 0;
            HSSFRow rw = null;
            HSSFCell cell=null;
            for(String s:list2){
                if(!list.contains(s)){
                    //System.out.println(s);
                    rw = sh.createRow(i);
                    cell = rw.createCell(0);
                    cell.setCellValue(s);
                    i++;
                    System.out.println(s);
                }
            }
            //创建excel文件
            File file3=new File("C:\\Users\\shiqi\\Desktop\\竹凯店.xls");
            file3.createNewFile();
            //将excel写入
            FileOutputStream stream= FileUtils.openOutputStream(file3);
            wb3.write(stream);
            stream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
