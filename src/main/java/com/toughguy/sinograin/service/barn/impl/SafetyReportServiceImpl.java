package com.toughguy.sinograin.service.barn.impl;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFPrintSetup;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toughguy.sinograin.model.barn.CornExaminingReport;
import com.toughguy.sinograin.model.barn.SafetyReport;
import com.toughguy.sinograin.service.barn.prototype.ISafetyReportService;
import com.toughguy.sinograin.service.impl.GenericServiceImpl;
import com.toughguy.sinograin.util.POIUtils;

@Service
public class SafetyReportServiceImpl extends GenericServiceImpl<SafetyReport, Integer> implements ISafetyReportService{
	@Autowired
	private ISafetyReportService safetyReportService;
	
	/*
	 * 导出监督检查报告
	 * 
	 */
	public void ExportSafetyReport(HttpServletResponse response,int[] ids) { 
		//传入的文件  
        FileInputStream fileInput;
        POIUtils utils = new POIUtils();
		try {
			fileInput = new FileInputStream("upload/base/监督检查报告.xls");
			//poi包下的类读取excel文件  
			POIFSFileSystem ts = new POIFSFileSystem(fileInput);  
			// 创建一个webbook，对应一个Excel文件            
			HSSFWorkbook workbook = new HSSFWorkbook(ts);  
			//对应Excel文件中的sheet，0代表第一个             

//			HSSFSheet sheet = workbook.createSheet();
//	        //打印设置
//	        HSSFPrintSetup ps = sheet.getPrintSetup();
//	        ps.setLandscape(false); //打印方向，true:横向，false:纵向
			
//			List<SafetyReport> ss = safetyReportService.find(ids);
			for(int j=0; j<ids.length; j++) {
				SafetyReport safetyReport = safetyReportService.find(ids[j]);
				HSSFSheet sh = workbook.getSheetAt(0);  
				HSSFRow row = sh.createRow(j+2);
				row.setHeight((short) 300);
				HSSFCell createCell = row.createCell(0);
				createCell.setCellStyle(utils.Style2(workbook));
				createCell.setCellValue(j+1);
				
				HSSFCell createCell2 = row.createCell(1);
				createCell2.setCellStyle(utils.Style1(workbook));
				createCell2.setCellValue(safetyReport.getpLibraryName()+"_" +safetyReport.getLibraryName());
				
				HSSFCell createCell3 = row.createCell(2);
				createCell3.setCellStyle(utils.Style2(workbook));
				createCell3.setCellValue(safetyReport.getProblem());
				
				HSSFCell createCell4 = row.createCell(3);
				createCell4.setCellStyle(utils.Style2(workbook));
				if(safetyReport.getIsDeal() == -1) {
					createCell4.setCellValue("待解决");
				} else {
					createCell4.setCellValue("已解决");
				}
				
				HSSFCell createCell5 = row.createCell(4);
				createCell5.setCellStyle(utils.Style2(workbook));
				createCell5.setCellValue(safetyReport.getPosition());
				
				HSSFCell createCell6 = row.createCell(5);
				createCell6.setCellStyle(utils.Style2(workbook));
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String res = simpleDateFormat.format(safetyReport.getCreateTime());
				createCell6.setCellValue(res);
			}
//			FileOutputStream out = new FileOutputStream("E://监督检查报告.xls");  
//			 workbook.write(out);
			OutputStream output = response.getOutputStream();
    		response.reset();
    		response.setHeader("Access-Control-Allow-Origin", "*");
    		response.setHeader("Content-disposition", "attachment; filename="+new String( "监督检查报告".getBytes("gb2312"), "ISO8859-1" )+".xls");
    		response.setContentType("application/vnd.ms-excel;charset=utf-8");
    		workbook.write(output);
    		output.flush();  
	        //将Excel写出        
	        workbook.write(output);  
	        //关闭流  
	        fileInput.close();  
	        output.close(); 
		} catch (Exception e) {
			e.printStackTrace();
		}  
	}

}
