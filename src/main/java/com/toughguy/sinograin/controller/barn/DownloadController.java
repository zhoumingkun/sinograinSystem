package com.toughguy.sinograin.controller.barn;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.Region;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
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
import com.toughguy.sinograin.dto.ImportShuifen;
import com.toughguy.sinograin.dto.ImportZhifangsuanzhi;
import com.toughguy.sinograin.dto.MianjinxishuiliangDTO;
import com.toughguy.sinograin.dto.RegisterDTO;
import com.toughguy.sinograin.dto.ShuifenDTO;
import com.toughguy.sinograin.dto.XMPresentation;
import com.toughguy.sinograin.dto.ZhifangsuanzhiDTO;
import com.toughguy.sinograin.model.barn.Handover;
import com.toughguy.sinograin.util.ImportUtil;
import com.toughguy.sinograin.util.POIUtils;
/**
 * 下载模板
 * @author zmk
 *
 */
@Controller
@RequestMapping("/download")

public class DownloadController{
	/**
     * POI水分模板下载
     * @throws Exception
     */
	@RequestMapping(value="downloadTemplateSF")
    public void downloadTemplateSF(HttpServletResponse response) throws Exception {
	 FileInputStream fileInput;
     POIUtils utils = new POIUtils();
     
	try {
			fileInput = new FileInputStream("upload/base/水分模板.xls");
			//poi包下的类读取excel文件  
			POIFSFileSystem ts = new POIFSFileSystem(fileInput);  
			// 创建一个webbook，对应一个Excel文件            
			HSSFWorkbook workbook = new HSSFWorkbook(ts);  
			//对应Excel文件中的sheet，0代表第一个             
			HSSFSheet sh = workbook.getSheetAt(0);
			
			String title = "水分模板";
			OutputStream output = response.getOutputStream();
			response.reset();
			response.setHeader("Content-disposition", "attachment; filename="+new String( title.getBytes("gb2312"), "ISO8859-1" )+".xls");
			response.setContentType("application/vnd.ms-excel;charset=utf-8");
			workbook.write(output);
			output.flush();  
	        //将Excel写出        
	        workbook.write(output);  
	        //关闭流  
	        fileInput.close();  
	        output.close();  
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
}
	
	
	/**
     * POI不完善粒（玉米）模板下载
     * @throws Exception
     */
	@RequestMapping(value="downloadTemplateBWSLYM")
    public void downloadTemplateBWSLYM(HttpServletResponse response) throws Exception {
	 FileInputStream fileInput;
     POIUtils utils = new POIUtils();
     
	try {
			fileInput = new FileInputStream("upload/base/不完善粒（玉米）模板.xls");
			//poi包下的类读取excel文件  
			POIFSFileSystem ts = new POIFSFileSystem(fileInput);  
			// 创建一个webbook，对应一个Excel文件            
			HSSFWorkbook workbook = new HSSFWorkbook(ts);  
			//对应Excel文件中的sheet，0代表第一个             
			HSSFSheet sh = workbook.getSheetAt(0);
			
			String title = "不完善粒（玉米）模板";
			OutputStream output = response.getOutputStream();
			response.reset();
			response.setHeader("Content-disposition", "attachment; filename="+new String( title.getBytes("gb2312"), "ISO8859-1" )+".xls");
			response.setContentType("application/vnd.ms-excel;charset=utf-8");
			workbook.write(output);
			output.flush();  
	        //将Excel写出        
	        workbook.write(output);  
	        //关闭流  
	        fileInput.close();  
	        output.close();  
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
}
	
	
	/**
     * POI不完善粒（小麦）模板下载
     * @throws Exception
     */
	@RequestMapping(value="downloadTemplateBWSLXM")
    public void downloadTemplateBWSLXM(HttpServletResponse response) throws Exception {
	 FileInputStream fileInput;
     POIUtils utils = new POIUtils();
     
	try {
			fileInput = new FileInputStream("upload/base/不完善粒（小麦）模板.xls");
			//poi包下的类读取excel文件  
			POIFSFileSystem ts = new POIFSFileSystem(fileInput);  
			// 创建一个webbook，对应一个Excel文件            
			HSSFWorkbook workbook = new HSSFWorkbook(ts);  
			//对应Excel文件中的sheet，0代表第一个             
			HSSFSheet sh = workbook.getSheetAt(0);
			
			String title = "不完善粒（小麦）模板";
			OutputStream output = response.getOutputStream();
			response.reset();
			response.setHeader("Content-disposition", "attachment; filename="+new String( title.getBytes("gb2312"), "ISO8859-1" )+".xls");
			response.setContentType("application/vnd.ms-excel;charset=utf-8");
			workbook.write(output);
			output.flush();  
	        //将Excel写出        
	        workbook.write(output);  
	        //关闭流  
	        fileInput.close();  
	        output.close();  
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
}
	
	
	/**
     * POI脂肪酸值模板下载
     * @throws Exception
     */
	@RequestMapping(value="downloadTemplateZFSZ")
    public void downloadTemplateZFSZ(HttpServletResponse response) throws Exception {
	 FileInputStream fileInput;
     POIUtils utils = new POIUtils();
     
	try {
			fileInput = new FileInputStream("upload/base/脂肪酸值模板.xls");
			//poi包下的类读取excel文件  
			POIFSFileSystem ts = new POIFSFileSystem(fileInput);  
			// 创建一个webbook，对应一个Excel文件            
			HSSFWorkbook workbook = new HSSFWorkbook(ts);  
			//对应Excel文件中的sheet，0代表第一个             
			HSSFSheet sh = workbook.getSheetAt(0);
			
			String title = "脂肪酸值模板";
			OutputStream output = response.getOutputStream();
			response.reset();
			response.setHeader("Content-disposition", "attachment; filename="+new String( title.getBytes("gb2312"), "ISO8859-1" )+".xls");
			response.setContentType("application/vnd.ms-excel;charset=utf-8");
			workbook.write(output);
			output.flush();  
	        //将Excel写出        
	        workbook.write(output);  
	        //关闭流  
	        fileInput.close();  
	        output.close();  
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
}
	
	
	/**
     * POI面筋吸水量模板下载
     * @throws Exception
     */
	@RequestMapping(value="downloadTemplateMJXSL")
    public void downloadTemplateMJXSL(HttpServletResponse response) throws Exception {
	 FileInputStream fileInput;
     POIUtils utils = new POIUtils();
     
	try {
			fileInput = new FileInputStream("upload/base/面筋吸水量模板.xls");
			//poi包下的类读取excel文件  
			POIFSFileSystem ts = new POIFSFileSystem(fileInput);  
			// 创建一个webbook，对应一个Excel文件            
			HSSFWorkbook workbook = new HSSFWorkbook(ts);  
			//对应Excel文件中的sheet，0代表第一个             
			HSSFSheet sh = workbook.getSheetAt(0);
			
			String title = "面筋吸水量模板";
			OutputStream output = response.getOutputStream();
			response.reset();
			response.setHeader("Content-disposition", "attachment; filename="+new String( title.getBytes("gb2312"), "ISO8859-1" )+".xls");
			response.setContentType("application/vnd.ms-excel;charset=utf-8");
			workbook.write(output);
			output.flush();  
	        //将Excel写出        
	        workbook.write(output);  
	        //关闭流  
	        fileInput.close();  
	        output.close();  
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
}
	
	/**
     * POI扦样登记表模板下载
     * @throws Exception
     */
	@RequestMapping(value="downloadTemplateRegister")
    public void downloadTemplateRegister(HttpServletResponse response) throws Exception {
	 FileInputStream fileInput;
     POIUtils utils = new POIUtils();
     
	try {
			fileInput = new FileInputStream("upload/base/扦样登记表.xls");
			//poi包下的类读取excel文件  
			POIFSFileSystem ts = new POIFSFileSystem(fileInput);  
			// 创建一个webbook，对应一个Excel文件            
			HSSFWorkbook workbook = new HSSFWorkbook(ts);  
			//对应Excel文件中的sheet，0代表第一个             
			HSSFSheet sh = workbook.getSheetAt(0);
			
			String title = "扦样登记表模板";
			OutputStream output = response.getOutputStream();
			response.reset();
			response.setHeader("Content-disposition", "attachment; filename="+new String( title.getBytes("gb2312"), "ISO8859-1" )+".xls");
			response.setContentType("application/vnd.ms-excel;charset=utf-8");
			workbook.write(output);
			output.flush();  
	        //将Excel写出        
	        workbook.write(output);  
	        //关闭流  
	        fileInput.close();  
	        output.close();  
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
}
	
}
