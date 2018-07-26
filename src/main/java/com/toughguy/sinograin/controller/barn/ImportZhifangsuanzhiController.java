package com.toughguy.sinograin.controller.barn;

import java.io.IOException;
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

import com.toughguy.sinograin.dto.BuwanshanliDTO;
import com.toughguy.sinograin.dto.ImportBuwanshanli;
import com.toughguy.sinograin.dto.ImportMianjinxishui;
import com.toughguy.sinograin.dto.ImportShuifen;
import com.toughguy.sinograin.dto.ImportZhifangsuanzhi;
import com.toughguy.sinograin.dto.ZhifangsuanzhiDTO;
import com.toughguy.sinograin.util.ImportUtil;

@Controller
@RequestMapping("/import")
public class ImportZhifangsuanzhiController {

    
	 private static int rowIndex = 0;    	//行数
	 private static int columnIndex = 0; 	//列数
	 private static ImportUtil util = new ImportUtil();
	
	
    /**
     * 导入脂肪酸值
     * @param muiltRequest
     * @param req
     * @return
     */
    @ResponseBody
	@RequestMapping(value = "/importExcelZFSZ", method = RequestMethod.POST)
	public List<ImportZhifangsuanzhi> importZhifangsuanzhi(MultipartHttpServletRequest muiltRequest, HttpServletRequest req) {
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
            for(int i = 2; i < count;i++){
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

    /**
     * 导入不完善粒计算公式
     * @param muiltRequest
     * @param req
     * @return
     */
    @ResponseBody
	@RequestMapping(value = "/importExcelBWSL", method = RequestMethod.POST)
    public List<ImportBuwanshanli> importBuwanshanli(MultipartHttpServletRequest muiltRequest, HttpServletRequest req){
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
           
            List<ImportBuwanshanli> irs = new ArrayList<>();
            for(int i = 2; i < count;i++){
            	rowIndex = i;
            	Row row = sheet.getRow(i);
            	ImportBuwanshanli ir = new ImportBuwanshanli();
            	ir.setSampleNum(util.getCellValue(row.getCell(0)));
            	ir.setDaza_pingjunzhi(util.getCellValue(row.getCell(5)));
            	ir.setXiaoza_pingjunzhi(util.getCellValue(row.getCell(9)));
            	ir.setZazhizongliang__pingjunzhi(util.getCellValue(row.getCell(11)));
            	ir.setBuwanshanli_pingjunzhi(util.getCellValue(row.getCell(14)));
            	ir.setShengmeili_pingjunzhi(util.getCellValue(row.getCell(17)));
            	ir.setSeze_qiwei(util.getCellValue(row.getCell(18)));
            	ir.setRongzhong_pingjunzhi(util.getCellValue(row.getCell(20)));
            	ir.setJianceren(util.getCellValue(row.getCell(21)));
            	ir.setBeizhu_1(util.getCellValue(row.getCell(22)));
            	ir.setBeizhu_2(util.getCellValue(row.getCell(23)));
            	
            	
            	List<BuwanshanliDTO> items = new ArrayList<>();
            	if(util.isMergedRegion(sheet,i,0)){
            		int lastRow = util.getRowNum(cras,sheet.getRow(i).getCell(0),sheet);
        			
        			for(;i<=lastRow;i++){
        				row = sheet.getRow(i);
        				BuwanshanliDTO item = new BuwanshanliDTO();
        			
        				item.setShiyanghao(util.getCellValue(row.getCell(1)));
        				item.setDayangzhiliang(util.getCellValue(row.getCell(2)));
        				item.setDazazhilaing(util.getCellValue(row.getCell(3)));
        				item.setDaza_cedingzhi(util.getCellValue(row.getCell(4)));
        				item.setXiaoyangzhiliang(util.getCellValue(row.getCell(6)));
        				item.setXiaozazhiliang(util.getCellValue(row.getCell(7)));
        				item.setXiaoza_cedingzhi(util.getCellValue(row.getCell(8)));
        				item.setZazhizongliang_cedingzhi(util.getCellValue(row.getCell(10)));
        				item.setBuwanshanli(util.getCellValue(row.getCell(12)));
        				item.setBuwanshanli_cedingzhi(util.getCellValue(row.getCell(13)));
        				item.setShengmeili(util.getCellValue(row.getCell(15)));
        				item.setShengmeili_cedingzhi(util.getCellValue(row.getCell(16)));
        				item.setRongzhong_cedingzhi(util.getCellValue(row.getCell(19)));
        				
        				items.add(item);
        			}
        			i--;
            	}else{
        			row = sheet.getRow(i);
        			BuwanshanliDTO item = new BuwanshanliDTO();
        			
        			item.setShiyanghao(util.getCellValue(row.getCell(1)));
    				item.setDayangzhiliang(util.getCellValue(row.getCell(2)));
    				item.setDazazhilaing(util.getCellValue(row.getCell(3)));
    				item.setDaza_cedingzhi(util.getCellValue(row.getCell(4)));
    				item.setXiaoyangzhiliang(util.getCellValue(row.getCell(6)));
    				item.setXiaozazhiliang(util.getCellValue(row.getCell(7)));
    				item.setXiaoza_cedingzhi(util.getCellValue(row.getCell(8)));
    				item.setZazhizongliang_cedingzhi(util.getCellValue(row.getCell(10)));
    				item.setBuwanshanli(util.getCellValue(row.getCell(12)));
    				item.setBuwanshanli_cedingzhi(util.getCellValue(row.getCell(13)));
    				item.setShengmeili(util.getCellValue(row.getCell(15)));
    				item.setShengmeili_cedingzhi(util.getCellValue(row.getCell(16)));
    				item.setRongzhong_cedingzhi(util.getCellValue(row.getCell(19)));
    				
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
    
    
    /**
     * 导入面筋吸水
     * @param muiltRequest
     * @param req
     * @return List<ImportMianjinxishui>
     */
    @ResponseBody
	@RequestMapping(value = "/importExcelMJXS", method = RequestMethod.POST)
    public List<ImportMianjinxishui> importMianjinxishui(MultipartHttpServletRequest muiltRequest, HttpServletRequest req){
    	try {
	    	String fileName = muiltRequest.getFileNames().next(); // 得到文件名（注意。是content-type
			// 中的name="file"，而不是真正的文件名）
			MultipartFile file = muiltRequest.getFile(fileName); // 得到该文件	
			
			//读取Excel文件
			Workbook wb;
				wb = util.read(file);
			
	        Sheet sheet = wb.getSheetAt(0);    //获得第一个表单  
	        
	        //System.out.println("总行数:"+sheet.getLastRowNum());
	        
	        List<CellRangeAddress> cras = util.getCombineCell(sheet);
	        //isMergedRegion(Sheet sheet,int row ,int column);判断是不是合并单元格\
	        int count = sheet.getLastRowNum()+1;//总行数
	    	
	        List<ImportMianjinxishui> irs = new ArrayList<>();
	        
	        return null;
    	} catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    		return null;
    	}
    }
    
    
    /**
     * 导入水分
     * @param muiltRequest
     * @param req
     * @return List<ImportShuifen>
     */
    @ResponseBody
	@RequestMapping(value = "/importExcelSF", method = RequestMethod.POST)
    public List<ImportShuifen> importShuifen(MultipartHttpServletRequest muiltRequest, HttpServletRequest req){
    	try {
	    	String fileName = muiltRequest.getFileNames().next(); // 得到文件名（注意。是content-type
			// 中的name="file"，而不是真正的文件名）
			MultipartFile file = muiltRequest.getFile(fileName); // 得到该文件	
			
			//读取Excel文件
			Workbook wb;
				wb = util.read(file);
			
	        Sheet sheet = wb.getSheetAt(0);    //获得第一个表单  
	        
	        //System.out.println("总行数:"+sheet.getLastRowNum());
	        
	        List<CellRangeAddress> cras = util.getCombineCell(sheet);
	        //isMergedRegion(Sheet sheet,int row ,int column);判断是不是合并单元格\
	        int count = sheet.getLastRowNum()+1;//总行数
	    	
	        List<ImportShuifen> irs = new ArrayList<>();
	        
	        return null;
    	} catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    		return null;
    	}
    }
}
