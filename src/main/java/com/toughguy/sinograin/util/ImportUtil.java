package com.toughguy.sinograin.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

/**
 * POI导入
 * @author  YAO
 * @date:   2018年7月21日 下午3:03:21
 */
public class ImportUtil {

    Workbook wb = null;
    FormulaEvaluator formulaEvaluator = null;
    /**
     * 
     * 根据流读取Excel文件
     * 
     * 
     * @param inputStream
     * @param isExcel2003
     * @return
     * @see [类、类#方法、类#成员]
     */
    public Workbook read(MultipartFile file)
        throws IOException
    {
        
//        String fileName = file.getName();
//        String type = fileName.substring(fileName.lastIndexOf(".")+1);
        InputStream inputStream = file.getInputStream();
//        if ("xls".equals(type))
//        {
            wb = new HSSFWorkbook(inputStream);
//        }else{
//        	wb = new XSSFWorkbook(inputStream);
//        }
        
        return wb;
    }
    
    
    
    /**   
	* 获取单元格的值   
	* @param cell   
	* @return   
	*/    
	public  String getCellValue(Cell cell){    
	    if(cell == null) return "";    
	    if(cell.getCellType() == Cell.CELL_TYPE_STRING){    
	        return cell.getStringCellValue();    
	    }else if(cell.getCellType() == Cell.CELL_TYPE_BOOLEAN){    
	        return String.valueOf(cell.getBooleanCellValue());    
	    }else if(cell.getCellType() == Cell.CELL_TYPE_FORMULA){ 
	    	return String.valueOf(cell.getCellFormula());
//	        return cell.getCellFormula() ;    
	    }else if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){    
	        return String.valueOf(cell.getNumericCellValue());    
	    }
	    return "";    
	}
    
    
    
//    public  String getCellValue(Cell cell) {
//		int cellType = cell.getCellType();
//		String cellValue = "";
//		switch (cellType) {
//		case HSSFCell.CELL_TYPE_NUMERIC:
//			cellValue = String.valueOf(cell.getNumericCellValue());
//			break;
// 
//		case HSSFCell.CELL_TYPE_FORMULA:
//			try {
//				cellValue = cell.getStringCellValue();
//			} catch (IllegalStateException e) {
//				cellValue = String.valueOf(cell.getNumericCellValue());
//			}
//			break;
// 
//		default:
//			cellValue = cell.getStringCellValue();
//		}
// 
//		return cellValue.trim();
//	}

//	 public String getCellValue(Cell cell) {
//		          String value = null;
//		          if (cell != null) {
//		             switch (cell.getCellType()) {
//		              case HSSFCell.CELL_TYPE_FORMULA:
//		                  // cell.getCellFormula();
//		                  try {
//		                      value = String.valueOf(cell.getNumericCellValue());
//		                  } catch (IllegalStateException e) {
//		                      value = String.valueOf(cell.getRichStringCellValue());
//		                  }
//		                  break;
//		              case HSSFCell.CELL_TYPE_NUMERIC:
//		                 value = String.valueOf(cell.getNumericCellValue());
//		                  break;
//		              case HSSFCell.CELL_TYPE_STRING:
//		                  value = String.valueOf(cell.getRichStringCellValue());
//		                  break;
//		              }
//		          }
//				return value;
//	 }
//    public  String getCellValue(Cell cell) {// 获取单元格数据内容为字符串类型的数据
//        String strCell = "";
//        if (cell == null) {
//            return "";
//        }
//        switch (cell.getCellType()) {
//        case HSSFCell.CELL_TYPE_FORMULA:
//        	try {
//        	       strCell = String.valueOf(cell.getNumericCellValue());
//
//        	} catch (IllegalStateException e) {
//        	       strCell = String.valueOf(cell.getRichStringCellValue());
//
//        	}
//        	break;
//        }
//        return strCell;
//    }
		          




	/** 
	    * 合并单元格处理,获取合并行 
	    * @param sheet 
	    * @return List<CellRangeAddress> 
		*/  
	    public List<CellRangeAddress> getCombineCell(Sheet sheet)  
	    {  
	        List<CellRangeAddress> list = new ArrayList<CellRangeAddress>();  
	        //获得一个 sheet 中合并单元格的数量  
	        int sheetmergerCount = sheet.getNumMergedRegions();  
	        //遍历所有的合并单元格  
	        for(int i = 0; i<sheetmergerCount;i++)   
	        {  
	            //获得合并单元格保存进list中  
	            CellRangeAddress ca = sheet.getMergedRegion(i);  
	            list.add(ca);  
	        }  
	        return list;  
	    }
	    
	    public int getRowNum(List<CellRangeAddress> listCombineCell,Cell cell,Sheet sheet){
	    	int xr = 0;
	    	int firstC = 0;  
	        int lastC = 0;  
	        int firstR = 0;  
	        int lastR = 0;  
	    	for(CellRangeAddress ca:listCombineCell)  
	        {
	            //获得合并单元格的起始行, 结束行, 起始列, 结束列  
	            firstC = ca.getFirstColumn();  
	            lastC = ca.getLastColumn();  
	            firstR = ca.getFirstRow();  
	            lastR = ca.getLastRow();  
	            if(cell.getRowIndex() >= firstR && cell.getRowIndex() <= lastR)   
	            {  
	                if(cell.getColumnIndex() >= firstC && cell.getColumnIndex() <= lastC)   
	                {  
	                	xr = lastR;
	                } 
	            }  
	            
	        }
	    	return xr;
	    	
	    }
	    /** 
	     * 判断单元格是否为合并单元格，是的话则将单元格的值返回 
	     * @param listCombineCell 存放合并单元格的list 
	     * @param cell 需要判断的单元格 
	     * @param sheet sheet 
	     * @return 
	     */ 
	     public String isCombineCell(List<CellRangeAddress> listCombineCell,Cell cell,Sheet sheet)
	     throws Exception{ 
	         int firstC = 0;  
	         int lastC = 0;  
	         int firstR = 0;  
	         int lastR = 0;  
	         String cellValue = null;  
	         for(CellRangeAddress ca:listCombineCell)  
	         {
	             //获得合并单元格的起始行, 结束行, 起始列, 结束列  
	             firstC = ca.getFirstColumn();  
	             lastC = ca.getLastColumn();  
	             firstR = ca.getFirstRow();  
	             lastR = ca.getLastRow();  
	             if(cell.getRowIndex() >= firstR && cell.getRowIndex() <= lastR)   
	             {  
	                 if(cell.getColumnIndex() >= firstC && cell.getColumnIndex() <= lastC)   
	                 {  
	                     Row fRow = sheet.getRow(firstR);  
	                     Cell fCell = fRow.getCell(firstC);  
	                     cellValue = getCellValue(fCell);  
	                     break;  
	                 } 
	             }  
	             else  
	             {  
	                 cellValue = "";  
	             }  
	         }  
	         return cellValue;  
	     }
		
		/**   
		* 获取合并单元格的值   
		* @param sheet   
		* @param row   
		* @param column   
		* @return   
		*/    
		public String getMergedRegionValue(Sheet sheet ,int row , int column){    
		    int sheetMergeCount = sheet.getNumMergedRegions();    
		        
		    for(int i = 0 ; i < sheetMergeCount ; i++){    
		        CellRangeAddress ca = sheet.getMergedRegion(i);    
		        int firstColumn = ca.getFirstColumn();    
		        int lastColumn = ca.getLastColumn();    
		        int firstRow = ca.getFirstRow();    
		        int lastRow = ca.getLastRow();    
		            
		        if(row >= firstRow && row <= lastRow){    
		            if(column >= firstColumn && column <= lastColumn){    
		                Row fRow = sheet.getRow(firstRow);    
		                Cell fCell = fRow.getCell(firstColumn);    
		                return getCellValue(fCell) ;    
		            }    
		        }    
		    }    
		        
		    return null ;    
		}
		
		
		/**  
		* 判断指定的单元格是否是合并单元格  
		* @param sheet   
		* @param row 行下标  
		* @param column 列下标  
		* @return  
		*/  
		public boolean isMergedRegion(Sheet sheet,int row ,int column) {  
		  int sheetMergeCount = sheet.getNumMergedRegions();  
		  for (int i = 0; i < sheetMergeCount; i++) {  
			CellRangeAddress range = sheet.getMergedRegion(i);  
			int firstColumn = range.getFirstColumn();  
			int lastColumn = range.getLastColumn();  
			int firstRow = range.getFirstRow();  
			int lastRow = range.getLastRow();  
			if(row >= firstRow && row <= lastRow){  
				if(column >= firstColumn && column <= lastColumn){  
					return true;  
				}  
			}
		  }  
		  return false;  
		}

}
