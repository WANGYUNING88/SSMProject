package com.wang;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

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
        fileInputStream.close();
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
        fileInputStream.close();
        System.out.println("文件读取完毕");
    }

    /**
     * 获取excel的类型
     *
     * @throws IOException
     */
    @Test
    public void testCellType() throws IOException {
        System.out.println("文件读取begin");

        FileInputStream fileInputStream = new FileInputStream(PATH + "test.xls");

        //1.创建一个工作簿
        Workbook workbook = new HSSFWorkbook(fileInputStream);
        //2.获取一个工作表
        Sheet sheet = workbook.getSheetAt(0);
        //获取公式
        FormulaEvaluator evaluator = new HSSFFormulaEvaluator((HSSFWorkbook) workbook);
        //3.获取标题行
        Row rowTitle = sheet.getRow(0);
        if (rowTitle!=null){
            int number = rowTitle.getPhysicalNumberOfCells();
            for (int cellNo = 0;cellNo<number;cellNo++){
                Cell cell = rowTitle.getCell(cellNo);
                if (cell!=null){
                    int cellType = cell.getCellType();
                    System.out.print(cell.getStringCellValue()+" | ");
                }
            }
            System.out.println();
        }
        int rowCount = sheet.getPhysicalNumberOfRows();
        for (int rowNum = 1 ;rowNum<rowCount;rowNum++){
            Row row = sheet.getRow(rowNum);
            if (row!=null){
                int number = rowTitle.getPhysicalNumberOfCells();
                for (int cellNo = 0;cellNo<number;cellNo++){
                    Cell cell = row.getCell(cellNo);
                    if (cell!=null){
                        //匹配类型
                        int cellType = cell.getCellType();
                        String cellValue = "";
                        switch (cellType){
                            case HSSFCell.CELL_TYPE_STRING://字符串类型
                                System.out.print("【String】");
                                cellValue = (cell.getStringCellValue());
                                break;
                            case HSSFCell.CELL_TYPE_BOOLEAN://布尔
                                System.out.print("【BOOLEAN】");
                                cellValue=(String.valueOf(cell.getBooleanCellValue()));
                                break;
                            case HSSFCell.CELL_TYPE_NUMERIC://数字{数值，日期}
                                System.out.print("【NUMERIC】");
                                if (HSSFDateUtil.isCellDateFormatted(cell)){
                                    System.out.print("【日期】");
                                    Date date = cell.getDateCellValue();
                                    cellValue = new DateTime(date).toString("yyyy-MM-dd HH:mm:ss");
                                }else {
                                    //不是日期格式，防止数字过长！
                                    System.out.print("【数字】");
                                    cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                                    cellValue=(cell.toString());
                                }
                                break;
                            case HSSFCell.CELL_TYPE_FORMULA://公式
                                System.out.print("【FORMULA】");
                                String cellFormula = cell.getCellFormula();
                                System.out.print("【cellFormula】");
                                //计算
                                CellValue evaluate = evaluator.evaluate(cell);
                                System.out.println(evaluate.formatAsString());
                                break;
                            case HSSFCell.CELL_TYPE_ERROR://错误
                                System.out.print("【ERROR】");
                                break;
                        }
                    System.out.print(cellValue+" | ");
                    }
                }
                System.out.println();
            }
        }
        fileInputStream.close();
        System.out.println("文件读取end");
    }
}
