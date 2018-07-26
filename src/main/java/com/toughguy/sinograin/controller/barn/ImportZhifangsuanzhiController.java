package com.toughguy.sinograin.controller.barn;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.toughguy.sinograin.dto.ImportZhifangsuanzhi;
import com.toughguy.sinograin.dto.ZhifangsuanzhiDTO;
import com.toughguy.sinograin.util.ImportUtil;

@Controller
@RequestMapping("/import")
public class ImportZhifangsuanzhiController {

//    @Autowired
//    ImportUtil util;
    
//    private static int totalRows = 0;// 总行数
//    private static int totalCells = 0;// 总列数
	
	/*@ResponseBody
	@RequestMapping(value = "/importExcel", method = RequestMethod.POST)
	public List<ZhifangsuanzhiDTO> importZhifangsuanzhi(MultipartHttpServletRequest muiltRequest, HttpServletRequest req) {
		try {
			
			String fileName = muiltRequest.getFileNames().next(); // 得到文件名（注意。是content-type
			// 中的name="file"，而不是真正的文件名）
			MultipartFile file = muiltRequest.getFile(fileName); // 得到该文件	
			
			//读取Excel文件
			ImportUtil util = new ImportUtil();
			Workbook wb = util.read(file);
			
			 *//** 得到第一个shell *//*
	        Sheet sheet = wb.getSheetAt(0);
	        
	        *//** 得到Excel的行数 *//*
	        totalRows = sheet.getPhysicalNumberOfRows();
			
	        *//** 得到Excel的列数 *//*
	        if (totalRows >= 1 && sheet.getRow(0) != null)
	        {
	            totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
	        }
	        
	        List<ZhifangsuanzhiDTO> rowLst = new ArrayList<ZhifangsuanzhiDTO>();
	        
	        *//** 循环Excel的行 *//*
	        for (int r = 5; r < totalRows; r++)
	        {
	            Row row = sheet.getRow(r);
	            if (row == null)
	            {
	                continue;
	            }
	            *//** 循环Excel的列 *//*
	            for (int c = 0; c < totalCells; c++)
	            {
	                
	                Cell cell = row.getCell(c);
	                ZhifangsuanzhiDTO zhifangsuanzhi = new ZhifangsuanzhiDTO();
                    switch (c)
                    {
                        case 0: 
                        	zhifangsuanzhi.setSampleNum((int) cell.getNumericCellValue());
                            break;
                        case 1:
                        	zhifangsuanzhi.setShiyangzhiliang(cell.getStringCellValue());
                            break;
                        case 2:
                        	zhifangsuanzhi.setShiyangshuifen(cell.getStringCellValue());
                            break;
                        case 3:
                        	zhifangsuanzhi.setKoh_rongyeyongliang_1(cell.getStringCellValue());
                            break;
                        case 4:
                        	zhifangsuanzhi.setKoh_rongyenongdu(cell.getStringCellValue());
                            break;
                        case 5:
                        	zhifangsuanzhi.setKongbai(cell.getStringCellValue());
                            break;
                        case 6:
                        	zhifangsuanzhi.setZhifangsuanzhi(cell.getStringCellValue());
                            break;
                        case 7:
                        	zhifangsuanzhi.setPingjunzhi(cell.getStringCellValue());
                            break;
                        case 8:
                        	zhifangsuanzhi.setBeizhu_1(cell.getStringCellValue());
                            break;
                        case 9:
                        	zhifangsuanzhi.setBeizhu_2(cell.getStringCellValue());
                            break;
                    }
                
	                rowLst.add(zhifangsuanzhi);
	            }
	            
	        }
			return rowLst;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}*/
    
    
    @ResponseBody
	@RequestMapping(value = "/importExcel", method = RequestMethod.POST)
	public List<ImportZhifangsuanzhi> importZhifangsuanzhi(MultipartHttpServletRequest muiltRequest, HttpServletRequest req) {
		int rowIndex = 0;    	//行数
    	int columnIndex = 0; 	//列数
    	ImportUtil util = new ImportUtil();
        try {
        	String fileName = muiltRequest.getFileNames().next(); // 得到文件名（注意。是content-type
			// 中的name="file"，而不是真正的文件名）
			MultipartFile file = muiltRequest.getFile(fileName); // 得到该文件	
			
			//读取Excel文件
			Workbook wb = util.read(file);
			
            Sheet sheet = wb.getSheetAt(0);    //获得第一个表单  
            
            //System.out.println("总行数:"+sheet.getLastRowNum());
            
            List<CellRangeAddress> cras = util.getCombineCell(sheet);
            //isMergedRegion(Sheet sheet,int row ,int column);判断是不是合并单元格\
            int count = sheet.getLastRowNum()+1;//总行数
           
            List<ImportZhifangsuanzhi> irs = new ArrayList<>();
            for(int i = 5; i < count;i++){
            	rowIndex = i;
            	Row row = sheet.getRow(i);
            	ImportZhifangsuanzhi ir = new ImportZhifangsuanzhi();
            	
            	ir.setSampleNum(util.getCellValue(row.getCell(0)));
            	ir.setPingjunzhi(util.getCellValue(row.getCell(7)));
            	ir.setBeizhu_1(util.getCellValue(row.getCell(8)));
            	ir.setBeizhu_2(util.getCellValue(row.getCell(9)));
            	
            	List<ZhifangsuanzhiDTO> items = new ArrayList<>();
            	if(util.isMergedRegion(sheet,i,0)){
            		int lastRow = util.getRowNum(cras,sheet.getRow(i).getCell(0),sheet);
        			
        			for(;i<=lastRow;i++){
        				row = sheet.getRow(i);
        				ZhifangsuanzhiDTO item = new ZhifangsuanzhiDTO();
        				item.setShiyangzhiliang(util.getCellValue(row.getCell(1)));
        				item.setShiyangshuifen(util.getCellValue(row.getCell(2)));
        				item.setKoh_rongyeyongliang_1(util.getCellValue(row.getCell(3)));
        				item.setKoh_rongyenongdu(util.getCellValue(row.getCell(4)));
        				item.setKongbai(util.getCellValue(row.getCell(5)));
        				item.setZhifangsuanzhi(util.getCellValue(row.getCell(6)));
        				items.add(item);
        			}
        			i--;
            	}else{
        			row = sheet.getRow(i);
        			ZhifangsuanzhiDTO item = new ZhifangsuanzhiDTO();
    				item.setShiyangzhiliang(util.getCellValue(row.getCell(1)));
    				item.setShiyangshuifen(util.getCellValue(row.getCell(2)));
    				item.setKoh_rongyeyongliang_1(util.getCellValue(row.getCell(3)));
    				item.setKoh_rongyenongdu(util.getCellValue(row.getCell(4)));
    				item.setKongbai(util.getCellValue(row.getCell(5)));
    				item.setZhifangsuanzhi(util.getCellValue(row.getCell(6)));
    				items.add(item);
            	}
            	ir.setItems(items);
            	irs.add(ir);
            	
            }
           
           return irs;
        } catch (Exception e) {  
            e.printStackTrace();
           return null;
        }
	}

}
