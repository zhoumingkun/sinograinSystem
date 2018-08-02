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

import com.toughguy.sinograin.dto.BuwanshanliXM_DTO;
import com.toughguy.sinograin.dto.BuwanshanliYM_DTO;
import com.toughguy.sinograin.dto.ImportBuwanshanliXM;
import com.toughguy.sinograin.dto.ImportBuwanshanliYM;
import com.toughguy.sinograin.dto.ImportMianjinxishuiliang;
import com.toughguy.sinograin.dto.ImportRegister;
import com.toughguy.sinograin.dto.ImportShuifen;
import com.toughguy.sinograin.dto.ImportZhifangsuanzhi;
import com.toughguy.sinograin.dto.MianjinxishuiliangDTO;
import com.toughguy.sinograin.dto.RegisterDTO;
import com.toughguy.sinograin.dto.ShuifenDTO;
import com.toughguy.sinograin.dto.ZhifangsuanzhiDTO;
import com.toughguy.sinograin.util.ImportUtil;

@Controller
@RequestMapping("/import")
public class ImportExcelController {

    
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
	public List<ImportZhifangsuanzhi> importExcelZFSZ(MultipartHttpServletRequest muiltRequest, HttpServletRequest req) {
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
     * 导入不完善粒(玉米)计算公式
     * @param muiltRequest
     * @param req
     * @return
     */
    @ResponseBody
	@RequestMapping(value = "/importExcelBWSLYM", method = RequestMethod.POST)
    public List<ImportBuwanshanliYM> importExcelBWSLYM(MultipartHttpServletRequest muiltRequest, HttpServletRequest req){
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
           
            List<ImportBuwanshanliYM> irs = new ArrayList<>();
            for(int i = 3; i < count;i++){
            	rowIndex = i;
            	Row row = sheet.getRow(i);
            	ImportBuwanshanliYM ir = new ImportBuwanshanliYM();
            	ir.setSampleNum(util.getCellValue(row.getCell(0)));
            	ir.setDaza_pingjunzhi(util.getCellValue(row.getCell(5)));
            	ir.setXiaoza_pingjunzhi(util.getCellValue(row.getCell(9)));
            	ir.setZazhizongliang_pingjunzhi(util.getCellValue(row.getCell(11)));
            	ir.setYizhongliang_pingjunzhi(util.getCellValue(row.getCell(14)));
            	ir.setBuwanshanli_pingjunzhi(util.getCellValue(row.getCell(17)));
            	ir.setShengmeili_pingjunzhi(util.getCellValue(row.getCell(20)));
            	ir.setSeze_qiwei(util.getCellValue(row.getCell(21)));
            	ir.setRongzhong_pingjunzhi(util.getCellValue(row.getCell(23)));
            	ir.setJianceren(util.getCellValue(row.getCell(24)));
            	ir.setBeizhu_1(util.getCellValue(row.getCell(25)));
            	ir.setBeizhu_2(util.getCellValue(row.getCell(26)));
            	
            	
            	List<BuwanshanliYM_DTO> items = new ArrayList<>();
            	if(util.isMergedRegion(sheet,i,0)){
            		int lastRow = util.getRowNum(cras,sheet.getRow(i).getCell(0),sheet);
        			
        			for(;i<=lastRow;i++){
        				row = sheet.getRow(i);
        				BuwanshanliYM_DTO item = new BuwanshanliYM_DTO();
        			
        				item.setShiyanghao(util.getCellValue(row.getCell(1)));
        				item.setDayangzhiliang(util.getCellValue(row.getCell(2)));
        				item.setDazazhilaing(util.getCellValue(row.getCell(3)));
        				item.setDaza_cedingzhi(util.getCellValue(row.getCell(4)));
        				item.setXiaoyangzhiliang(util.getCellValue(row.getCell(6)));
        				item.setXiaozazhiliang(util.getCellValue(row.getCell(7)));
        				item.setXiaoza_cedingzhi(util.getCellValue(row.getCell(8)));
        				item.setZazhizongliang_cedingzhi(util.getCellValue(row.getCell(10)));
        				item.setYizhongliang(util.getCellValue(row.getCell(12)));
        				item.setYizhongliang_cedingzhi(util.getCellValue(row.getCell(13)));
        				item.setBuwanshanli(util.getCellValue(row.getCell(15)));
        				item.setBuwanshanli_cedingzhi(util.getCellValue(row.getCell(16)));
        				item.setShengmeili(util.getCellValue(row.getCell(18)));
        				item.setShengmeili_cedingzhi(util.getCellValue(row.getCell(19)));
        				item.setRongzhong_cedingzhi(util.getCellValue(row.getCell(22)));
        				
        				items.add(item);
        			}
        			i--;
            	}else{
        			row = sheet.getRow(i);
        			BuwanshanliYM_DTO item = new BuwanshanliYM_DTO();
        			
        			item.setShiyanghao(util.getCellValue(row.getCell(1)));
    				item.setDayangzhiliang(util.getCellValue(row.getCell(2)));
    				item.setDazazhilaing(util.getCellValue(row.getCell(3)));
    				item.setDaza_cedingzhi(util.getCellValue(row.getCell(4)));
    				item.setXiaoyangzhiliang(util.getCellValue(row.getCell(6)));
    				item.setXiaozazhiliang(util.getCellValue(row.getCell(7)));
    				item.setXiaoza_cedingzhi(util.getCellValue(row.getCell(8)));
    				item.setZazhizongliang_cedingzhi(util.getCellValue(row.getCell(10)));
    				item.setYizhongliang(util.getCellValue(row.getCell(12)));
    				item.setYizhongliang_cedingzhi(util.getCellValue(row.getCell(13)));
    				item.setBuwanshanli(util.getCellValue(row.getCell(15)));
    				item.setBuwanshanli_cedingzhi(util.getCellValue(row.getCell(16)));
    				item.setShengmeili(util.getCellValue(row.getCell(18)));
    				item.setShengmeili_cedingzhi(util.getCellValue(row.getCell(19)));
    				item.setRongzhong_cedingzhi(util.getCellValue(row.getCell(22)));
    				
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
    public List<ImportMianjinxishuiliang> importExcelMJXS(MultipartHttpServletRequest muiltRequest, HttpServletRequest req){
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
	    	
	        List<ImportMianjinxishuiliang> irs = new ArrayList<>();
	        for(int i = 2; i < count;i++){
            	rowIndex = i;
            	Row row = sheet.getRow(i);
            	ImportMianjinxishuiliang ir = new ImportMianjinxishuiliang();
            	
            	ir.setSampleNum(util.getCellValue(row.getCell(0)));
            	ir.setPingjunzhi_ganmianjinzhiliang(util.getCellValue(row.getCell(5)));
            	ir.setBeizhu_1(util.getCellValue(row.getCell(6)));
            	ir.setBeizhu_2(util.getCellValue(row.getCell(7)));
            	
            	List<MianjinxishuiliangDTO> items = new ArrayList<>();
            	if(util.isMergedRegion(sheet,i,0)){
            		int lastRow = util.getRowNum(cras,sheet.getRow(i).getCell(0),sheet);
        			
        			for(;i<=lastRow;i++){
        				row = sheet.getRow(i);
        				MianjinxishuiliangDTO item = new MianjinxishuiliangDTO();
        				item.setShiyangzhiliang(util.getCellValue(row.getCell(1)));
        				item.setShimianjinzhiliang(util.getCellValue(row.getCell(2)));
        				item.setGanmianjinzhiliang(util.getCellValue(row.getCell(3)));
        				item.setMianjinxishuiliang(util.getCellValue(row.getCell(4)));
        				items.add(item);
        			}
        			i--;
            	}else{
        			row = sheet.getRow(i);
        			MianjinxishuiliangDTO item = new MianjinxishuiliangDTO();
    				item.setShiyangzhiliang(util.getCellValue(row.getCell(1)));
    				item.setShimianjinzhiliang(util.getCellValue(row.getCell(2)));
    				item.setGanmianjinzhiliang(util.getCellValue(row.getCell(3)));
    				item.setMianjinxishuiliang(util.getCellValue(row.getCell(4)));
    				items.add(item);
            	}
            	ir.setItems(items);
            	irs.add(ir);
            	
            }
           
           return irs;

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
    public List<ImportShuifen> importExcelSF(MultipartHttpServletRequest muiltRequest, HttpServletRequest req){
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
	        for(int i = 2; i < count;i++){
            	rowIndex = i;
            	Row row = sheet.getRow(i);
            	ImportShuifen ir = new ImportShuifen();
            	
            	ir.setSampleNum(util.getCellValue(row.getCell(0)));
            	ir.setPingjunzhi(util.getCellValue(row.getCell(6)));
            	ir.setBeizhu_1(util.getCellValue(row.getCell(7)));
            	ir.setBeizhu_2(util.getCellValue(row.getCell(8)));
            	
            	List<ShuifenDTO> items = new ArrayList<>();
            	if(util.isMergedRegion(sheet,i,0)){
            		int lastRow = util.getRowNum(cras,sheet.getRow(i).getCell(0),sheet);
        			
        			for(;i<=lastRow;i++){
        				row = sheet.getRow(i);
        				ShuifenDTO item = new ShuifenDTO();
        				item.setQimin(util.getCellValue(row.getCell(1)));
        				item.setHongqianqiminzhiliang(util.getCellValue(row.getCell(2)));
        				item.setShiyangzhiliang(util.getCellValue(row.getCell(3)));
        				item.setHengzhongqiminj_shiyangzhiliang(util.getCellValue(row.getCell(4)));
        				item.setShuifenhanliang(util.getCellValue(row.getCell(5)));
        				
        				items.add(item);
        			}
        			i--;
            	}else{
        			row = sheet.getRow(i);
        			ShuifenDTO item = new ShuifenDTO();
        			item.setQimin(util.getCellValue(row.getCell(1)));
    				item.setHongqianqiminzhiliang(util.getCellValue(row.getCell(2)));
    				item.setShiyangzhiliang(util.getCellValue(row.getCell(3)));
    				item.setHengzhongqiminj_shiyangzhiliang(util.getCellValue(row.getCell(4)));
    				item.setShuifenhanliang(util.getCellValue(row.getCell(5)));
    				items.add(item);
            	}
            	ir.setItems(items);
            	irs.add(ir);
            	
            }
           
           return irs;

    	} catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    		return null;
    	}
    }
    
    /**
     * 导入不完善粒(小麦)计算公式
     * @param muiltRequest
     * @param req
     * @return
     */
    @ResponseBody
	@RequestMapping(value = "/importExcelBWSLXM", method = RequestMethod.POST)
    public List<ImportBuwanshanliXM> importExcelBWSLXM(MultipartHttpServletRequest muiltRequest, HttpServletRequest req){
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
           
            List<ImportBuwanshanliXM> irs = new ArrayList<>();
            for(int i = 3; i < count;i++){
            	rowIndex = i;
            	Row row = sheet.getRow(i);
            	ImportBuwanshanliXM ir = new ImportBuwanshanliXM();
            	ir.setSampleNum(util.getCellValue(row.getCell(0)));
            	ir.setDaza_pingjunzhi(util.getCellValue(row.getCell(5)));
            	ir.setXiaoza_pingjunzhi(util.getCellValue(row.getCell(9)));
            	ir.setZazhizongliang_pingjunzhi(util.getCellValue(row.getCell(11)));
            	ir.setKuangwuzhizongliang_pingjunzhi(util.getCellValue(row.getCell(14)));
            	ir.setYizhongliang_pingjunzhi(util.getCellValue(row.getCell(17)));
            	ir.setBuwanshanli_pingjunzhi(util.getCellValue(row.getCell(20)));
            	ir.setSeze_qiwei(util.getCellValue(row.getCell(21)));
            	ir.setRongzhong_pingjunzhi(util.getCellValue(row.getCell(23)));
            	ir.setJianceren(util.getCellValue(row.getCell(24)));
            	ir.setBeizhu_1(util.getCellValue(row.getCell(25)));
            	ir.setBeizhu_2(util.getCellValue(row.getCell(26)));
            	ir.setBeizhu_3(util.getCellValue(row.getCell(27)));
            	
            	
            	List<BuwanshanliXM_DTO> items = new ArrayList<>();
            	if(util.isMergedRegion(sheet,i,0)){
            		int lastRow = util.getRowNum(cras,sheet.getRow(i).getCell(0),sheet);
        			
        			for(;i<=lastRow;i++){
        				row = sheet.getRow(i);
        				BuwanshanliXM_DTO item = new BuwanshanliXM_DTO();
        			
        				item.setShiyanghao(util.getCellValue(row.getCell(1)));
        				item.setDayangzhiliang(util.getCellValue(row.getCell(2)));
        				item.setDazazhilaing(util.getCellValue(row.getCell(3)));
        				item.setDaza_cedingzhi(util.getCellValue(row.getCell(4)));
        				item.setXiaoyangzhiliang(util.getCellValue(row.getCell(6)));
        				item.setXiaozazhiliang(util.getCellValue(row.getCell(7)));
        				item.setXiaoza_cedingzhi(util.getCellValue(row.getCell(8)));
        				item.setZazhizongliang_cedingzhi(util.getCellValue(row.getCell(10)));
        				item.setKuangwuzhi(util.getCellValue(row.getCell(12)));
        				item.setKuangwuzhizongliang_cedingzhi(util.getCellValue(row.getCell(13)));
        				item.setYizhongliang(util.getCellValue(row.getCell(15)));
        				item.setYizhongliang_cedingzhi(util.getCellValue(row.getCell(16)));
        				item.setBuwanshanli(util.getCellValue(row.getCell(18)));
        				item.setBuwanshanli_cedingzhi(util.getCellValue(row.getCell(19)));
        				item.setRongzhong_cedingzhi(util.getCellValue(row.getCell(22)));
        				
        				items.add(item);
        			}
        			i--;
            	}else{
        			row = sheet.getRow(i);
        			BuwanshanliXM_DTO item = new BuwanshanliXM_DTO();
        			
        			item.setShiyanghao(util.getCellValue(row.getCell(1)));
    				item.setDayangzhiliang(util.getCellValue(row.getCell(2)));
    				item.setDazazhilaing(util.getCellValue(row.getCell(3)));
    				item.setDaza_cedingzhi(util.getCellValue(row.getCell(4)));
    				item.setXiaoyangzhiliang(util.getCellValue(row.getCell(6)));
    				item.setXiaozazhiliang(util.getCellValue(row.getCell(7)));
    				item.setXiaoza_cedingzhi(util.getCellValue(row.getCell(8)));
    				item.setZazhizongliang_cedingzhi(util.getCellValue(row.getCell(10)));
    				item.setKuangwuzhi(util.getCellValue(row.getCell(12)));
    				item.setKuangwuzhizongliang_cedingzhi(util.getCellValue(row.getCell(13)));
    				item.setYizhongliang(util.getCellValue(row.getCell(15)));
    				item.setYizhongliang_cedingzhi(util.getCellValue(row.getCell(16)));
    				item.setBuwanshanli(util.getCellValue(row.getCell(18)));
    				item.setBuwanshanli_cedingzhi(util.getCellValue(row.getCell(19)));
    				item.setRongzhong_cedingzhi(util.getCellValue(row.getCell(22)));
    				
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
     * 导入扦样登记表
     * @param muiltRequest
     * @param req
     * @return     (int)cell.getNumericCellValue()
     */
    @ResponseBody
	@RequestMapping(value = "/importExcelRegister", method = RequestMethod.POST)
    public List<RegisterDTO> importExcelRegister(MultipartHttpServletRequest muiltRequest, HttpServletRequest req){
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
           	
            List<RegisterDTO> irs = new ArrayList<>();
            for(int i = 3; i < count;i++){
            	rowIndex = i;
            	Row row = sheet.getRow(i);
            	RegisterDTO ir = new RegisterDTO();
            	ir.setId(util.getCellValue(row.getCell(0)));
            	ir.setSampleNo(util.getCellValue(row.getCell(1)));
            	ir.setLibraryName(util.getCellValue(row.getCell(2)));
            	ir.setPosition(util.getCellValue(row.getCell(3)));
            	ir.setSort(util.getCellValue(row.getCell(4)));
            	ir.setQuality(util.getCellValue(row.getCell(5)));
            	ir.setAmount(util.getCellValue(row.getCell(6)));
            	ir.setOriginPlace(util.getCellValue(row.getCell(7)));
            	ir.setGainTime(util.getCellValue(row.getCell(8)));
            	ir.setBarnTime(util.getCellValue(row.getCell(9)));
            	ir.setAutograph(util.getCellValue(row.getCell(10)));
            	ir.setPeitongrenSign(util.getCellValue(row.getCell(11)));
            	ir.setSampleTime(util.getCellValue(row.getCell(12)));
            	ir.setRemark(util.getCellValue(row.getCell(13)));
            	
            	irs.add(ir);
            }
           return irs;
        } catch (Exception e) {  
            e.printStackTrace();
           return null;
        }
        
    }	
//方法二
//    List<RegisterDTO> items = new ArrayList<>();
//    for(int i = 3; i < count;i++){
//    	rowIndex = i;
//    	Row row = sheet.getRow(i);
//    	RegisterDTO ir = new RegisterDTO();
//    	
//    	if(util.isMergedRegion(sheet,i,0)){
//    		int lastRow = util.getRowNum(cras,sheet.getRow(i).getCell(0),sheet);
//			
//			for(;i<=lastRow;i++){
//				row = sheet.getRow(i);
//				RegisterDTO item = new RegisterDTO();
//			
//				item.setId(util.getCellValue(row.getCell(0)));
//				item.setSampleNo(util.getCellValue(row.getCell(1)));
//				item.setLibraryName(util.getCellValue(row.getCell(2)));
//				item.setPosition(util.getCellValue(row.getCell(3)));
//				item.setSort(util.getCellValue(row.getCell(4)));
//				item.setQuality(util.getCellValue(row.getCell(5)));
//				item.setAmount(util.getCellValue(row.getCell(6)));
//				item.setOriginPlace(util.getCellValue(row.getCell(7)));
//				item.setGainTime(util.getCellValue(row.getCell(8)));
//				item.setBarnTime(util.getCellValue(row.getCell(9)));
//				item.setAutograph(util.getCellValue(row.getCell(10)));
//				item.setPeitongrenSign(util.getCellValue(row.getCell(11)));
//				item.setSampleTime(util.getCellValue(row.getCell(12)));
//				item.setRemark(util.getCellValue(row.getCell(13)));
//				
//				items.add(item);
//			}
//			i--;
//    	}else{
//			row = sheet.getRow(i);
//			RegisterDTO item = new RegisterDTO();
//			
//			item.setId(util.getCellValue(row.getCell(0)));
//			item.setSampleNo(util.getCellValue(row.getCell(1)));
//			item.setLibraryName(util.getCellValue(row.getCell(2)));
//			item.setPosition(util.getCellValue(row.getCell(3)));
//			item.setSort(util.getCellValue(row.getCell(4)));
//			item.setQuality(util.getCellValue(row.getCell(5)));
//			item.setAmount(util.getCellValue(row.getCell(6)));
//			item.setOriginPlace(util.getCellValue(row.getCell(7)));
//			item.setGainTime(util.getCellValue(row.getCell(8)));
//			item.setBarnTime(util.getCellValue(row.getCell(9)));
//			item.setAutograph(util.getCellValue(row.getCell(10)));
//			item.setPeitongrenSign(util.getCellValue(row.getCell(11)));
//			item.setSampleTime(util.getCellValue(row.getCell(12)));
//			item.setRemark(util.getCellValue(row.getCell(13)));
//
//			items.add(item);
//    	}         	
//    }
//   return items;
//}
}
