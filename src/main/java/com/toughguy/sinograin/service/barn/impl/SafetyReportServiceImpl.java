package com.toughguy.sinograin.service.barn.impl;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
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
	public void ExportSafetyReport() { 
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
			
			List<SafetyReport> ss = safetyReportService.findAll();
			System.out.println(ss.size());
			for(int j=1; j<ss.size(); j++) {
				HSSFSheet sh = workbook.getSheetAt(0);  
				HSSFRow row = sh.createRow(j+1);
				HSSFCell createCell = row.createCell(0);
				createCell.setCellStyle(utils.Style1(workbook));
				createCell.setCellValue(j);
				
				HSSFCell createCell2 = row.createCell(1);
				createCell2.setCellStyle(utils.Style1(workbook));
				createCell2.setCellValue(ss.get(j).getLibraryName());
				
				HSSFCell createCell3 = row.createCell(2);
				createCell3.setCellStyle(utils.Style1(workbook));
				createCell3.setCellValue(ss.get(j).getProblem());
				
				HSSFCell createCell4 = row.createCell(3);
				createCell4.setCellStyle(utils.Style1(workbook));
				createCell4.setCellValue(ss.get(j).getIsDeal());
				
				HSSFCell createCell5 = row.createCell(4);
				createCell5.setCellStyle(utils.Style1(workbook));
				createCell5.setCellValue(ss.get(j).getPosition());
				
				HSSFCell createCell6 = row.createCell(5);
				createCell6.setCellStyle(utils.Style1(workbook));
				createCell6.setCellValue(ss.get(j).getCreateTime());
			}
			FileOutputStream out = new FileOutputStream("E://监督检查报告.xls");  
			 workbook.write(out);
		} catch (Exception e) {
			e.printStackTrace();
		}  
	}

}
