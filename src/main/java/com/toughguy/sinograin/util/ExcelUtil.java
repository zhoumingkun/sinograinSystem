package com.toughguy.sinograin.util;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;

import com.toughguy.sinograin.dto.ExcelDTO;

public class ExcelUtil<T>{
	
	/**
     * 这是一个通用的方法，利用了JAVA的反射机制，可以将放置在JAVA集合中并且符号一定条件的数据以EXCEL 的形式输出
     * ExcelDTO dto excel文件基本信息
     */
    public void exportExcel(ExcelDTO<T> dto) {
    	
        /*（一）表头--标题栏*/
        Map<Integer, String> headersNameMap = new HashMap<>();
        int key=0;
        for (int i = 0; i < dto.getHeadersName().size(); i++) {
            if (!dto.getHeadersName().get(i).equals(null)) {
                headersNameMap.put(key, (String) dto.getHeadersName().get(i));
                key++;
            }
        }
        /*（二）字段*/
        Map<Integer, String> titleFieldMap = new HashMap<>();
        int value = 0;
        for (int i = 0; i < dto.getHeadersId().size(); i++) {
            if (!dto.getHeadersId().get(i).equals(null)) {
                titleFieldMap.put(value, (String) dto.getHeadersId().get(i));
                value++;
            }
        }
        /* （三）声明一个工作薄：包括构建工作簿、表格、样式*/
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet(dto.getTitle());
        sheet.setDefaultColumnWidth((short)15); 
        // 生成一个样式
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        HSSFFont font = wb.createFont();  //设置字体
   	 	font.setFontName("仿宋_GB2312");   
        HSSFCell cell;
        Collection c = headersNameMap.values();//拿到表格所有标题的value的集合
        Iterator<String> it = c.iterator();//表格标题的迭代器
        /*（四）导出数据：包括导出标题栏以及内容栏*/
        HSSFRow row = sheet.createRow(0); 
        int zdRow =0;//行序号
        if(!"".equals(dto.getTableName())&&!StringUtils.isEmpty(dto.getTableName())){
    	 /*设置表名*/
        CellRangeAddress cra=new CellRangeAddress(0, 1, 0, dto.getHeadersId().size()-1); //合并单元格（第一列与第二列） (开始行数，结束行数，开始列，结束列)
        //在sheet里增加合并单元格  
        sheet.addMergedRegion(cra); 
    	 cell = row.createCell(0);
    	 cell.setCellValue(dto.getTableName());    //设置表名
    	//style.setFillForegroundColor((short) 13);// 设置背景色
    	 font.setFontHeightInPoints((short) 16);//设置字体大小
    	 font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); //粗体显示
    	 HSSFCellStyle style1 = wb.createCellStyle();
    	 style1.setFont(font);
    	 style1.setAlignment(HSSFCellStyle.ALIGN_CENTER);
    	 style1.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直居中  
    	 cell.setCellStyle(style1);
    	 zdRow = 2; //表头后移至第三行
        }
        if(zdRow != 0){
         row = sheet.createRow(zdRow); 
        }
        //根据选择的字段生成表头
        short size = 0;
        while (it.hasNext()) {
            cell = row.createCell(size);
            cell.setCellValue(it.next().toString());
            font.setFontHeightInPoints((short)10);//设置字体大小
       	 	font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
       	 	style.setFont(font);
       	 	if(!CollectionUtils.isEmpty(dto.getHeaderWidth())&&(int)dto.getHeaderWidth().get(size)!=0){
       	 	sheet.setColumnWidth(size, (int)((dto.getHeaderWidth().get(size)+0.71)*256)); //转化为标准Excel列宽
       	 	}
            cell.setCellStyle(style);
            size++;
        }
        //表格标题一行的字段(类属性)的集合
        Collection zdC = titleFieldMap.values();
        Iterator<T> labIt = dto.getDtoList().iterator();//总记录的迭代器
        while (labIt.hasNext()) {//记录的迭代器，遍历总记录
            int zdCell = 0;
            zdRow++;
            row = sheet.createRow(zdRow);
            T l = (T) labIt.next();
            // 利用反射，根据数组属性的先后顺序，动态调用getXxx()方法得到属性值
            Field[] fields = l.getClass().getDeclaredFields();//获得JavaBean全部属性
            /*for (short i = 0; i < fields.length; i++) {//遍历属性，比对
                Field field = fields[i];
                String fieldName = field.getName();//属性名*/
               Iterator<String> zdIt = zdC.iterator();//一条字段的集合的迭代器 
                while (zdIt.hasNext()) {//遍历要导出的字段集合
                 String header = (String)zdIt.next();
                	for (short i = 0; i < fields.length; i++) {//遍历属性，比对
                        Field field = fields[i];
                        String fieldName = field.getName();//属性名 
                        if (header.equals(fieldName)) {//比对JavaBean的属性名，一致就写入，不一致就丢弃
                        	String getMethodName = "get"
                                + fieldName.substring(0, 1).toUpperCase()
                                + fieldName.substring(1);//拿到属性的get方法
                        Class tCls = l.getClass();//拿到JavaBean对象
                        try {
                            Method getMethod = tCls.getMethod(getMethodName,
                                    new Class[] {});//通过JavaBean对象拿到该属性的get方法，从而进行操控
                            Object val = getMethod.invoke(l, new Object[] {});//操控该对象属性的get方法，从而拿到属性值
                            String textVal = null;
                            if (val!= null) {
                                textVal = String.valueOf(val);//转化成String
                            }else{
                                textVal = null;
                            }
                            HSSFCell cell1 = row.createCell((short) zdCell);
                            cell1.setCellValue(textVal);//写进excel对象
                            HSSFCellStyle style2 = wb.createCellStyle();
                            style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                            cell1.setCellStyle(style2);
                            zdCell++;
                        } catch (SecurityException e) {
                            e.printStackTrace();
                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        try {
            FileOutputStream exportXls = new FileOutputStream(dto.getFileName());
            wb.write(exportXls);
            exportXls.close();
            System.out.println("导出成功!");
        } catch (FileNotFoundException e) {
            System.out.println("导出失败!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("导出失败!");
            e.printStackTrace();
        }
    }
}
