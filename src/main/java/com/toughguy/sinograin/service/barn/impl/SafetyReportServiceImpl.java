package com.toughguy.sinograin.service.barn.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.toughguy.sinograin.model.barn.SafetyReport;
import com.toughguy.sinograin.persist.barn.prototype.ISafetyReportDao;
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
		try {
			//输入模板文件
			XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new FileInputStream("upload/base/监督检查报告.xlsx"));
			SXSSFWorkbook workbook = new SXSSFWorkbook(xssfWorkbook, 1000);
			POIUtils utils = new POIUtils();       

//			HSSFSheet sheet = workbook.createSheet();
//	        //打印设置
//	        HSSFPrintSetup ps = sheet.getPrintSetup();
//	        ps.setLandscape(false); //打印方向，true:横向，false:纵向
			
//			List<SafetyReport> ss = safetyReportService.find(ids);
			for(int j=0; j<ids.length; j++) {
				SafetyReport safetyReport = safetyReportService.find(ids[j]);
				Sheet sh = workbook.getSheetAt(0);  
				Row row = sh.createRow(j+2);
//				row.setHeight((short) 600);
				row.setHeightInPoints(30);
				Cell createCell = row.createCell(0);
				createCell.setCellStyle(utils.Style2(workbook));
				createCell.setCellValue(j+1);
				
				Cell createCell2 = row.createCell(1);
				createCell2.setCellStyle(utils.Style1(workbook));
				createCell2.setCellValue(safetyReport.getpLibraryName()+"_" +safetyReport.getLibraryName());
				
				Cell createCell3 = row.createCell(2);
				createCell3.setCellStyle(utils.Style2(workbook));
				createCell3.setCellValue(safetyReport.getProblem());
				
				Cell createCell4 = row.createCell(3);
				createCell4.setCellStyle(utils.Style2(workbook));
				if(safetyReport.getIsDeal() == -1) {
					createCell4.setCellValue("待解决");
				} else {
					createCell4.setCellValue("已解决");
				}
				
				Cell createCell5 = row.createCell(4);
				createCell5.setCellStyle(utils.Style2(workbook));
				createCell5.setCellValue(safetyReport.getPosition());
				
				Cell createCell6 = row.createCell(5);
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
    		output.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<SafetyReport> findBySampleId(int sampleId) {
		// TODO Auto-generated method stub
		return ((ISafetyReportDao)dao).findBySampleId(sampleId);
	}

}
