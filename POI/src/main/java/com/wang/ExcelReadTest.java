package com.wang;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelReadTest {
    static String PATH = "D:/workspaces/SSMProject/POI/";

    /**
     * xls 03版
     * @throws IOException
     */
    @Test
    public void testRead03() throws IOException {
        System.out.println("文件读取开始");

        FileInputStream fileInputStream = new FileInputStream(PATH + "test.xls");

        //1.创建一个工作簿
        Workbook workbook = new HSSFWorkbook(fileInputStream);
        //2.获取一个工作表
        Sheet sheet = workbook.getSheetAt(0);
        //3.获取一个行
        Row row = sheet.getRow(0);
        //3.获取一个单元格
        Cell cell = row.getCell(0);

        System.out.println(cell.getStringCellValue());

        System.out.println("文件读取完毕");
    }

    /**
     * xlsx 07版
     * @throws IOException
     */
    @Test
    public void testRead07() throws IOException {
        System.out.println("文件读取开始");

        FileInputStream fileInputStream = new FileInputStream(PATH + "test.xlsx");

        //1.创建一个工作簿
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        //2.获取一个工作表
        Sheet sheet = workbook.getSheetAt(0);
        //3.获取一个行
        Row row = sheet.getRow(0);
        //3.获取一个单元格
        Cell cell = row.getCell(0);

        System.out.println(cell.getStringCellValue());

        System.out.println("文件读取完毕");
    }
}
