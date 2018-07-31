package com.toughguy.sinograin.service.barn.impl;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.Region;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.stereotype.Service;

import com.toughguy.sinograin.model.barn.Sample;
import com.toughguy.sinograin.model.barn.TestItem;
import com.toughguy.sinograin.persist.barn.prototype.ITestItemDao;
import com.toughguy.sinograin.service.barn.prototype.ITestItemService;
import com.toughguy.sinograin.service.impl.GenericServiceImpl;
import com.toughguy.sinograin.util.POIUtils;

@Service
public class TestItemServiceImpl extends GenericServiceImpl<TestItem, Integer> implements ITestItemService {

	@Override
	public List<TestItem> findResult(int sampleId) {
		// TODO Auto-generated method stub
		return ((ITestItemDao)dao).findResult(sampleId);
	}

	@Override
	public List<Sample> getSampleBySortAndTestItem(TestItem testItem) {
		// TODO Auto-generated method stub
		return ((ITestItemDao)dao).getSampleBySortAndTestItem(testItem);
	}
	@Override
	public List<Sample> getAllSampleBySortAndTestItem(TestItem testItem) {
		// TODO Auto-generated method stub
		return ((ITestItemDao)dao).getAllSampleBySortAndTestItem(testItem);
	}
	//样品确认单导出
  	@Override
  	public	void expotexpotTestItem(HttpServletResponse response,int sampleId){
  		// TODO Auto-generated method stub
  			 FileInputStream fileInput; 
  		     POIUtils utils = new POIUtils();
  			try {
  					fileInput = new FileInputStream("upload/base/样品确认单.xls");
  					//poi包下的类读取excel文件  
  					POIFSFileSystem ts = new POIFSFileSystem(fileInput);  
  					// 创建一个webbook，对应一个Excel文件            
  					HSSFWorkbook workbook = new HSSFWorkbook(ts);  
  					//对应Excel文件中的sheet，0代表第一个             
  					HSSFSheet sh = workbook.getSheetAt(0); 
  					
  					//第一行数据内容
  					HSSFRow row = sh.createRow(0);
  					Region region1 = new Region(0, (short) 0, 0, (short) 8);
  					HSSFCell createCell = row.createCell(0);
  					utils.setRegionStyle(sh, region1, utils.Style6(workbook));
  					sh.addMergedRegion(region1);
  					createCell.setCellValue("样品确认单");//名字要居中
  					
  					
  					//第二行数据内容
  					HSSFRow row1 = sh.createRow(1);
  					
  					HSSFCell createCell1 = row1.createCell(0);
  					createCell1.setCellStyle(utils.Style6(workbook));
  					createCell1.setCellValue("检验编号");
  					
  					HSSFCell createCel = row1.createCell(1);
  					Region region2 = new Region(1, (short) 1, 1, (short) 8);//要居左
  					utils.setRegionStyle(sh, region2, utils.Style8(workbook));
  					sh.addMergedRegion(region2);
  					
  					List<TestItem> result = ((ITestItemDao)dao).findResult(sampleId);
  					System.out.println(result);
  					for(int r=0; r<result.size(); r++) {
  					String sampleNum=result.get(r).getSampleNum();
  					createCel.setCellValue(sampleNum);//检验编号
  					
  					String checkeds1 = result.get(r).getCheckeds();
  					String[] checkeds2 = checkeds1.split(",");
  					String checkeds3 = null;
  					for(int i=0;i<checkeds2.length;i++) {
  						if("1".equals(checkeds2[i])){
  							checkeds3 += "容重,";
  						}else if("2".equals(checkeds2[i])){
  							checkeds3 += "水分,";
  						}else if("3".equals(checkeds2[i])){
  							checkeds3 += "杂质(矿物质),";
  						}else if("4".equals(checkeds2[i])){
  							checkeds3 += "不完善粒(生霉粒),";
  						}else if("5".equals(checkeds2[i])){
  							checkeds3 += "色泽气味(质量指标),";
  						}else if("6".equals(checkeds2[i])){
  							checkeds3 += "面筋吸水量,";
  						}else if("7".equals(checkeds2[i])){
  							checkeds3 += "脂肪酸值,";
  						}else if("8".equals(checkeds2[i])){
  							checkeds3 += "品尝评分值,";
  						}else if("9".equals(checkeds2[i])){
  							checkeds3 += "色泽气味(储存品质指标),";
  						}else if("10".equals(checkeds2[i])){
  							checkeds3 += "真菌毒素(黄曲霉毒素B1、脱氧雪腐、镰刀菌烯醇、玉米赤霉烯酮),";
  						}else if("11".equals(checkeds2[i])){
  							checkeds3 += "重金属(铅、镉、汞、砷),";
  						}
  						double ceil = Math.ceil(checkeds2.length/3.0);
  						int number = (int)ceil;
  						String[] principals = new String[checkeds2.length];
  						for (int j = 0; j < number; j++) {
  	  						String principal1 = result.get(r).getPrincipal();
  	  						principals[j] = principal1; 
  	  						for (int s = 0; s < number; s++) {
  	  							HSSFRow row3 = sh.createRow(3+j);
  	  							HSSFCell createCell2 = row3.createCell(0);
  	  							createCell2.setCellStyle(utils.Style6(workbook));
  	  							if(1+(j)*3-1 < checkeds2.length){
  	  							createCell2.setCellValue(checkeds2[1+(j)*3-1]);  //检验项目
  	  							}else{
  	  								createCell2.setCellValue("");
  	  							}
  	  								
//  	  								HSSFCell createCell3 = row3.createCell(1);
//  	  								createCell3.setCellStyle(utils.Style6(workbook));
//  	  								createCell3.setCellValue(result.get(r).getResult()); //检测结果
  	  								
  	  								//存储循环数据
//  	  								HSSFCell createCell4 = row3.createCell(2);
//  	  								createCell4.setCellStyle(utils.Style6(workbook));
//  	  								if(1+(i)*3-1 < principal.length){
//  	  								createCell4.setCellValue(principal[1+(i)*3-1]); //负责人
//  	  								}else{
//  	  									createCell4.setCellValue("");
//  	  								}
  	  							
//  	  							HSSFCell createCell5 = row3.createCell(3);
//  	  							createCell5.setCellStyle(utils.Style6(workbook));
//  	  							if(2+(j)*3-1 < testItem3.length){
//  	  							createCell5.setCellValue(testItem3[2+(j)*3-1]);  //检验项目
//  	  							}else{
//  	  								createCell5.setCellValue("");
//  	  							}
//  	  								
//  	  								HSSFCell createCell6 = row3.createCell(4);
//  	  								createCell6.setCellStyle(utils.Style6(workbook));
//  	  								createCell6.setCellValue(result.get(r).getResult()); //检测结果
//  	  								
//  	  								HSSFCell createCell7 = row3.createCell(5);
//  	  								createCell7.setCellStyle(utils.Style6(workbook));
//  	  								if(2+(i)*3-1 < principal.length){
//  	  								createCell7.setCellValue(principal[2+(i)*3-1]); //负责人
//  	  								}else{
//  	  									createCell7.setCellValue("");
//  	  								}
  	//
//  	  							HSSFCell createCell8 = row3.createCell(6);
//  	  							createCell8.setCellStyle(utils.Style6(workbook));
//  	  							if(3+(j)*3-1 < testItem3.length){
//  	  								createCell8.setCellValue(testItem3[3+(j)*3-1]);  //检验项目
//  	  							}else{
//  	  								createCell8.setCellValue("");
//  	  							}
//  	  								
//  	  								HSSFCell createCell9 = row3.createCell(7);
//  	  								createCell9.setCellStyle(utils.Style6(workbook));
//  	  								createCell9.setCellValue(result.get(r).getResult()); //检测结果
//  	  								
//  	  								HSSFCell createCell10 = row3.createCell(8);
//  	  								createCell10.setCellStyle(utils.Style6(workbook));
//  	  								if(3+(i)*3-1 < principal.length){
//  	  								createCell10.setCellValue(principal[3+(i)*3-1]); //负责人
//  	  							}else{
//  	  								createCell10.setCellValue("");
  	  							}
  	  					}
  					}
  	}

  					
  					
  					OutputStream output = response.getOutputStream();
  					response.reset();
  					response.setHeader("Content-disposition", "attachment; filename="+new Date().getTime()+".xls");
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



