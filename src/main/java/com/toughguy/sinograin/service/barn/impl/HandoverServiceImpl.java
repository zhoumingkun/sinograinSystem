package com.toughguy.sinograin.service.barn.impl;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.Region;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.stereotype.Service;

import com.toughguy.sinograin.model.barn.Handover;
import com.toughguy.sinograin.service.barn.prototype.IHandoverService;
import com.toughguy.sinograin.service.impl.GenericServiceImpl;
import com.toughguy.sinograin.util.POIUtils;

@Service
public class HandoverServiceImpl extends GenericServiceImpl<Handover, Integer> implements IHandoverService {

	@Override
	public void expotHandover(HttpServletResponse response,Handover handover) {
		// TODO Auto-generated method stub
		 FileInputStream fileInput;
	     POIUtils utils = new POIUtils();
		try {
				fileInput = new FileInputStream("upload/base/交接单.xls");
				//poi包下的类读取excel文件  
				POIFSFileSystem ts = new POIFSFileSystem(fileInput);  
				// 创建一个webbook，对应一个Excel文件            
				HSSFWorkbook workbook = new HSSFWorkbook(ts);  
				//对应Excel文件中的sheet，0代表第一个             
				HSSFSheet sh = workbook.getSheetAt(0); 
				
				//第一行数据内容
				HSSFRow row = sh.createRow(1);
				HSSFCell createCell = row.createCell(0);
				createCell.setCellValue(handover.getName());
				//第二行数据内容
				HSSFRow row2 = sh.createRow(2);
				HSSFCell createCell2 = row2.createCell(0);
				createCell.setCellValue("编号:"+handover);   //------------------
				
				//第二行数据内容
				HSSFRow row3 = sh.createRow(3);
				HSSFCell createCell3 = row3.createCell(0);
				String[] split = handover.getCheckeds().split(",");
				String checked ="";
				for (int i = 0; i < split.length; i++) {
					if("1".equals(split[i])){
						checked += "";
					}else if("2".equals(split[i])){
						checked += "";
					}else if("3".equals(split[i])){
						checked += "";
					}else if("4".equals(split[i])){
						checked += "";
					}else if("5".equals(split[i])){
						checked += "";
					}else if("6".equals(split[i])){
						checked += "";
					}else if("7".equals(split[i])){
						checked += "";
					}
				}
				createCell3.setCellValue(checked);
				
				//存储循环数据
				String[] sampleNums = handover.getSampleNums().split(",");
				double ceil = Math.ceil(sampleNums.length/4);
				int number = (int)ceil;
				for (int j = 1; j < number; j++) {
						HSSFRow row5 = sh.createRow(4+j);
						HSSFCell createCell5 = row5.createCell(0);
						createCell5.setCellValue(1+(j-1)*4); //序号
						HSSFCell createCell6 = row5.createCell(1);
						if(1+(j-1)*4 > sampleNums.length){
							createCell6.setCellValue("");
						}else{
							createCell6.setCellValue(sampleNums[1+(j-1)*4-1]);  //编号
						}
						
			    		HSSFCell createCell7 = row5.createCell(2);
						createCell7.setCellValue(2+(j-1)*4); //序号
						HSSFCell createCell8 = row5.createCell(3);
						if(2+(j-1)*4 > sampleNums.length){
							createCell6.setCellValue("");
						}else{
						    createCell8.setCellValue(sampleNums[2+(j-1)*4-1]);  //编号
						}
						
						HSSFCell createCell9 = row5.createCell(4);
						createCell9.setCellValue(3+(j-1)*4); //序号
						HSSFCell createCell10 = row5.createCell(5);
						if(3+(j-1)*4 > sampleNums.length){
							createCell6.setCellValue("");
						}else{
						    createCell10.setCellValue(sampleNums[3+(j-1)*4-1]);  //编号
						}
						
						HSSFCell createCell11 = row5.createCell(6);
						createCell11.setCellValue(4+(j-1)*4); //序号
						HSSFCell createCell12 = row5.createCell(7);
						if(4+(j-1)*4 > sampleNums.length){
							createCell6.setCellValue("");
						}else{
						    createCell12.setCellValue(sampleNums[4+(j-1)*4-1]);  //编号
						}
				}
				
				HSSFRow rowCell = sh.createRow(5+number);
				Region region = new Region(5+number, (short) 5, 5+number, (short) 6);
				
				HSSFCell createCell4 = rowCell.createCell(0);
				createCell4.setCellValue("领取人");
				
				HSSFCell createCell5 = rowCell.createCell(1);
				createCell5.setCellValue("");
				
				HSSFCell createCell6 = rowCell.createCell(2);
				createCell6.setCellValue("归还人");
				
				HSSFCell createCell7 = rowCell.createCell(3);
				createCell7.setCellValue("");
				
				HSSFCell createCell8 = rowCell.createCell(4);
				createCell8.setCellValue("备注");
				
				HSSFCell createCell9 = rowCell.createCell(5);
				createCell9.setCellValue(handover.getRemark());
				
				
				HSSFRow createRow = sh.createRow(6+number);
				
				Region regio = new Region(6+number, (short) 4, 6+number, (short) 6);
				
				createRow.createCell(0);
				createCell4.setCellValue("领取日期");
				
				createRow.createCell(1);
				createCell5.setCellValue("");
				
				createRow.createCell(2);
				createCell6.setCellValue("归还日期");
				
				 createRow.createCell(3);
				createCell7.setCellValue("");
				
				createRow.createCell(4);
				createCell8.setCellValue("样品管理员："+handover+"时间：");
				
			
				OutputStream output = response.getOutputStream();
				response.reset();
				response.setHeader("Content-disposition", "attachment; filename="+new Date()+".xls");
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
