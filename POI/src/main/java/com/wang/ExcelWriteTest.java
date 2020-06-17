package com.wang;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWriteTest {

    static String PATH = "D:/workspaces/SSMProject/POI/";

    /**
     * xls 03版
     * @throws IOException
     */
    @Test
    public void testWrite03() throws IOException {
        System.out.println("文件生成开始");

        //1.创建一个工作簿
        Workbook workbook = new HSSFWorkbook();
        //2.创建一个工作表
        Sheet sheet = workbook.createSheet("测试表");
        //3.创建一行
        Row row1 = sheet.createRow(0);
        //4.创建一个单元格
        Cell cell1 = row1.createCell(0);
        cell1.setCellValue("0,0");

        Cell cell2 = row1.createCell(1);
        cell2.setCellValue("0,1");

        Row row2 = sheet.createRow(1);

        Cell cell3 = row2.createCell(0);
        cell3.setCellValue(new DateTime().toString("yyyy-MM-dd HH:mm:ss"));

        //生成一张表
        FileOutputStream fileOutputStream = new FileOutputStream(PATH+"test.xls");
        workbook.write(fileOutputStream);

        //关闭流
        fileOutputStream.close();

        System.out.println("文件生成完毕");
    }
    /**
     * xlsx 07版
     * @throws IOException
     */
    @Test
    public void testWrite07() throws IOException {
        System.out.println("文件生成开始");

        //1.创建一个工作簿
        Workbook workbook = new XSSFWorkbook();
        //2.创建一个工作表
        Sheet sheet = workbook.createSheet("测试表");
        //3.创建一行
        Row row1 = sheet.createRow(0);
        //4.创建一个单元格
        Cell cell1 = row1.createCell(0);
        cell1.setCellValue("0,0");

        Cell cell2 = row1.createCell(1);
        cell2.setCellValue("0,1");

        Row row2 = sheet.createRow(1);

        Cell cell3 = row2.createCell(0);
        cell3.setCellValue(new DateTime().toString("yyyy-MM-dd HH:mm:ss"));

        //生成一张表
        FileOutputStream fileOutputStream = new FileOutputStream(PATH+"test.xlsx");
        workbook.write(fileOutputStream);

        //关闭流
        fileOutputStream.close();

        System.out.println("文件生成完毕");
    }

    /**
     * 大量数据测试 5860
     * @throws IOException
     */
    @Test
    public void testWrite03BigData() throws IOException {
        long begin = System.currentTimeMillis();
        //1.创建一个工作簿
        Workbook workbook = new HSSFWorkbook();
        //2.创建一个工作表
        Sheet sheet = workbook.createSheet("测试表");

        Row row = null;
        Cell cell = null;
        for (int rowNo = 0 ;rowNo < 65536 ; rowNo++){ //超过65536的异常Invalid row number (65536) outside allowable range (0..65535)
            row = sheet.createRow(rowNo);
            for (int cellNo = 0 ; cellNo<10 ;cellNo++){
                cell = row.createCell(cellNo);
                cell.setCellValue(rowNo+" "+cellNo);
            }
        }
        //生成一张表
        FileOutputStream fileOutputStream = new FileOutputStream(PATH+"bigdata03.xls");
        workbook.write(fileOutputStream);

        //关闭流
        fileOutputStream.close();
        long end = System.currentTimeMillis();
        System.out.println("文件生成完毕 时间："+(end-begin));
    }

    /**
     * 大量数据测试 43198
     * @throws IOException
     */
    @Test
    public void testWrite07BigData() throws IOException {
        long begin = System.currentTimeMillis();
        //1.创建一个工作簿
        Workbook workbook = new XSSFWorkbook();
        //2.创建一个工作表
        Sheet sheet = workbook.createSheet("测试表");

        Row row = null;
        Cell cell = null;
        for (int rowNo = 0 ;rowNo < 65536 ; rowNo++){ //超过65536的异常Invalid row number (65536) outside allowable range (0..65535)
            row = sheet.createRow(rowNo);
            for (int cellNo = 0 ; cellNo<10 ;cellNo++){
                cell = row.createCell(cellNo);
                cell.setCellValue(rowNo+" "+cellNo);
            }
        }
        //生成一张表
        FileOutputStream fileOutputStream = new FileOutputStream(PATH+"bigdata07.xlsx");
        workbook.write(fileOutputStream);

        //关闭流
        fileOutputStream.close();
        long end = System.currentTimeMillis();
        System.out.println("文件生成完毕 时间："+(end-begin));
    }

    /**
     * 大量数据测试 5619
     * @throws IOException
     */
    @Test
    public void testWrite07BigDatas() throws IOException {
        long begin = System.currentTimeMillis();
        //1.创建一个工作簿
        Workbook workbook = new ();
        //2.创建一个工作表
        Sheet sheet = workbook.createSheet("测试表");

        Row row = null;
        Cell cell = null;
        for (int rowNo = 0 ;rowNo < 65536 ; rowNo++){ //超过65536的异常Invalid row number (65536) outside allowable range (0..65535)
            row = sheet.createRow(rowNo);
            for (int cellNo = 0 ; celSXSSFWorkbooklNo<10 ;cellNo++){
                cell = row.createCell(cellNo);
                cell.setCellValue(rowNo+" "+cellNo);
            }
        }
        //生成一张表
        FileOutputStream fileOutputStream = new FileOutputStream(PATH+"bigdata07s.xlsx");
        workbook.write(fileOutputStream);

        //关闭流
        fileOutputStream.close();

        //清除临时文件
        ((SXSSFWorkbook)workbook).dispose();
        long end = System.currentTimeMillis();
        System.out.println("文件生成完毕 时间："+(end-begin));
    }

}
