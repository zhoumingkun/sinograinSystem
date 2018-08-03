package com.toughguy.sinograin.service.barn.impl;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.set.SynchronizedSortedSet;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.Region;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toughguy.sinograin.model.barn.Sample;
import com.toughguy.sinograin.model.barn.TestItem;
import com.toughguy.sinograin.persist.barn.prototype.ILibraryDao;
import com.toughguy.sinograin.persist.barn.prototype.ITestItemDao;
import com.toughguy.sinograin.service.barn.prototype.ISampleService;
import com.toughguy.sinograin.service.barn.prototype.ITestItemService;
import com.toughguy.sinograin.service.impl.GenericServiceImpl;
import com.toughguy.sinograin.util.POIUtils;

@Service
public class TestItemServiceImpl extends GenericServiceImpl<TestItem, Integer> implements ITestItemService {

	@Autowired
	private ISampleService sampleService;
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
  	public void expotexpotTestItem(HttpServletResponse response,int sampleId){
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
			
			//根据样品id查询全部检验项目和检验编号
			Sample sample = sampleService.find(sampleId);
			//将样品编号放入excel中
			createCel.setCellValue(sample.getSampleNum());
			//将检验项目转为文字
			String checkedsNum1 = sample.getCheckeds();
			String[] checkedsNum2 = checkedsNum1.split(",");
			String checkedsWord1 = "";
			for(int i=0;i<checkedsNum2.length;i++) {
				if("1".equals(checkedsNum2[i])){
					checkedsWord1 += "容重,";
				}else if("2".equals(checkedsNum2[i])){
					checkedsWord1 += "水分,";
				}else if("3".equals(checkedsNum2[i])){
					checkedsWord1 += "杂质,矿物质,";
				}else if("4".equals(checkedsNum2[i])){
					checkedsWord1 += "不完善粒,生霉粒,";
				}else if("5".equals(checkedsNum2[i])){
					checkedsWord1 += "色泽气味(质量指标),";
				}else if("6".equals(checkedsNum2[i])){
					checkedsWord1 += "面筋吸水量,";
				}else if("7".equals(checkedsNum2[i])){
					checkedsWord1 += "脂肪酸值,";
				}else if("8".equals(checkedsNum2[i])){
					checkedsWord1 += "品尝评分值,";
				}else if("9".equals(checkedsNum2[i])){
					checkedsWord1 += "色泽气味(储存品质指标),";
				}else if("10".equals(checkedsNum2[i])){
					checkedsWord1 += "真菌毒素(黄曲霉毒素B1),真菌毒素(脱氧雪腐),真菌毒素(镰刀菌烯醇),真菌毒素(玉米赤霉烯酮),";
				}else if("11".equals(checkedsNum2[i])){
					checkedsWord1 += "重金属(铅),重金属(镉),重金属(汞),重金属(砷),";
				}
			}
			String checkedsWord2 = checkedsWord1.substring(0, checkedsWord1.length()-1);
			String[] checkedsWord3 = checkedsWord2.split(",");
			int ceil = (int)Math.ceil(checkedsWord3.length/3.0);
			//根据样品ID查询检测结果
			List<TestItem> result = ((ITestItemDao)dao).findResult(sampleId);
			//循环导出excel
			HSSFRow row3 = null;
			for(int b=0; b<ceil; b++) {
				row3 = sh.createRow(3+b);
				HSSFCell createCell2 = row3.createCell(0);
				createCell2.setCellStyle(utils.Style6(workbook));
				if((b)*3 < checkedsWord3.length){
					createCell2.setCellValue(checkedsWord3[(b)*3]); //检验项目
					for(int i=1;i<=result.size();i++) {
						double testItem = result.get(i-1).getTestItem();
						String testItem4 = "";
						if(1.0 == testItem) {
  							testItem4 += "容重";
  						}else if(2.0 == testItem){
  							testItem4 += "水分";
  						}else if(3.1 == testItem){
  							testItem4 += "杂质";
  						}else if(3.2 == testItem){
  							testItem4 += "矿物质";
  						}else if(4.1 == testItem){
  							testItem4 += "不完善粒";
  						}else if(4.2 == testItem){
  							testItem4 += "生霉粒";
  						}else if(5 == testItem){
  							testItem4 += "色泽气味(质量指标)";
  						}else if(6 == testItem){
  							testItem4 += "面筋吸水量";
  						}else if(7 == testItem){
  							testItem4 += "脂肪酸值";
  						}else if(8 == testItem){
  							testItem4 += "品尝评分值";
  						}else if(9 == testItem){
  							testItem4 += "色泽气味(储存品质指标)";
  						}else if(10.1 == testItem){
  							testItem4 += "真菌毒素(黄曲霉毒素B1)";
  						}else if(10.2 == testItem){
  							testItem4 += "真菌毒素(脱氧雪腐)";
  						}else if(10.3 == testItem){
  							testItem4 += "真菌毒素(镰刀菌烯醇)";
  						}else if(10.4 == testItem){
  							testItem4 += "真菌毒素(玉米赤霉烯酮)";
  						}else if(11.1 == testItem){
  							testItem4 += "重金属(铅)";
  						}else if(11.2 == testItem){
  							testItem4 += "重金属(镉)";
  						}else if(11.3 == testItem){
  							testItem4 += "重金属(汞)";
  						}else if(11.4 == testItem){
  							testItem4 += "重金属(砷)";
  						}
						if(checkedsWord3[(b)*3].equals(testItem4)) {
							HSSFCell createCell3 = row3.createCell(1);
							createCell3.setCellStyle(utils.Style6(workbook));
							createCell3.setCellValue(result.get(i-1).getResult());
							HSSFCell createCell4 = row3.createCell(2);
							createCell4.setCellStyle(utils.Style6(workbook));
							createCell4.setCellValue(result.get(i-1).getPrincipal());	
						}else {
							HSSFCell createCell3 = row3.createCell(1);
							createCell3.setCellStyle(utils.Style6(workbook));
							createCell3.setCellValue("");
							HSSFCell createCell4 = row3.createCell(2);
							createCell4.setCellStyle(utils.Style6(workbook));
							createCell4.setCellValue("");
						}
					}

				}else {
					createCell2.setCellValue("");
				}
				HSSFCell createCell6 = row3.createCell(3);
				createCell6.setCellStyle(utils.Style6(workbook));
				if(1+(b)*3 < checkedsWord3.length){
					createCell6.setCellValue(checkedsWord3[1+(b)*3]);  //检验项目
					for(int i=1;i<=result.size();i++) {
						double testItem = result.get(i-1).getTestItem();
						String testItem4 = "";
						if(1.0 == testItem) {
  							testItem4 += "容重";
  						}else if(2.0 == testItem){
  							testItem4 += "水分";
  						}else if(3.1 == testItem){
  							testItem4 += "杂质";
  						}else if(3.2 == testItem){
  							testItem4 += "矿物质";
  						}else if(4.1 == testItem){
  							testItem4 += "不完善粒";
  						}else if(4.2 == testItem){
  							testItem4 += "生霉粒";
  						}else if(5 == testItem){
  							testItem4 += "色泽气味(质量指标)";
  						}else if(6 == testItem){
  							testItem4 += "面筋吸水量";
  						}else if(7 == testItem){
  							testItem4 += "脂肪酸值";
  						}else if(8 == testItem){
  							testItem4 += "品尝评分值";
  						}else if(9 == testItem){
  							testItem4 += "色泽气味(储存品质指标)";
  						}else if(10.1 == testItem){
  							testItem4 += "真菌毒素(黄曲霉毒素B1)";
  						}else if(10.2 == testItem){
  							testItem4 += "真菌毒素(脱氧雪腐)";
  						}else if(10.3 == testItem){
  							testItem4 += "真菌毒素(镰刀菌烯醇)";
  						}else if(10.4 == testItem){
  							testItem4 += "真菌毒素(玉米赤霉烯酮)";
  						}else if(11.1 == testItem){
  							testItem4 += "重金属(铅)";
  						}else if(11.2 == testItem){
  							testItem4 += "重金属(镉)";
  						}else if(11.3 == testItem){
  							testItem4 += "重金属(汞)";
  						}else if(11.4 == testItem){
  							testItem4 += "重金属(砷)";
  						}
						if(checkedsWord3[1+(b)*3].equals(testItem4)) {
							HSSFCell createCell3 = row3.createCell(4);
							createCell3.setCellStyle(utils.Style6(workbook));
							createCell3.setCellValue(result.get(i-1).getResult());
							HSSFCell createCell4 = row3.createCell(5);
							createCell4.setCellStyle(utils.Style6(workbook));
							createCell4.setCellValue(result.get(i-1).getPrincipal());
						} else {
							HSSFCell createCell3 = row3.createCell(4);
							createCell3.setCellStyle(utils.Style6(workbook));
							createCell3.setCellValue("");
							HSSFCell createCell4 = row3.createCell(5);
							createCell4.setCellStyle(utils.Style6(workbook));
							createCell4.setCellValue("");
						}
					}
				}else{
					createCell6.setCellValue("");
				}
				HSSFCell createCell9 = row3.createCell(6);
				createCell9.setCellStyle(utils.Style6(workbook));
				if(2+(b)*3 < checkedsWord3.length){
					createCell9.setCellValue(checkedsWord3[2+(b)*3]);  //检验项目
					for(int i=1;i<=result.size();i++) {
						double testItem = result.get(i-1).getTestItem();
						String testItem4 = "";
						if(1.0 == testItem) {
  							testItem4 += "容重";
  						}else if(2.0 == testItem){
  							testItem4 += "水分";
  						}else if(3.1 == testItem){
  							testItem4 += "杂质";
  						}else if(3.2 == testItem){
  							testItem4 += "矿物质";
  						}else if(4.1 == testItem){
  							testItem4 += "不完善粒";
  						}else if(4.2 == testItem){
  							testItem4 += "生霉粒";
  						}else if(5 == testItem){
  							testItem4 += "色泽气味(质量指标)";
  						}else if(6 == testItem){
  							testItem4 += "面筋吸水量";
  						}else if(7 == testItem){
  							testItem4 += "脂肪酸值";
  						}else if(8 == testItem){
  							testItem4 += "品尝评分值";
  						}else if(9 == testItem){
  							testItem4 += "色泽气味(储存品质指标)";
  						}else if(10.1 == testItem){
  							testItem4 += "真菌毒素(黄曲霉毒素B1)";
  						}else if(10.2 == testItem){
  							testItem4 += "真菌毒素(脱氧雪腐)";
  						}else if(10.3 == testItem){
  							testItem4 += "真菌毒素(镰刀菌烯醇)";
  						}else if(10.4 == testItem){
  							testItem4 += "真菌毒素(玉米赤霉烯酮)";
  						}else if(11.1 == testItem){
  							testItem4 += "重金属(铅)";
  						}else if(11.2 == testItem){
  							testItem4 += "重金属(镉)";
  						}else if(11.3 == testItem){
  							testItem4 += "重金属(汞)";
  						}else if(11.4 == testItem){
  							testItem4 += "重金属(砷)";
  						}
						if(checkedsWord3[2+(b)*3].equals(testItem4)) {
							HSSFCell createCell3 = row3.createCell(7);
							createCell3.setCellStyle(utils.Style6(workbook));
							createCell3.setCellValue(result.get(i-1).getResult());
							HSSFCell createCell4 = row3.createCell(8);
							createCell4.setCellStyle(utils.Style6(workbook));
							createCell4.setCellValue(result.get(i-1).getPrincipal());
						} else {
							HSSFCell createCell3 = row3.createCell(7);
							createCell3.setCellStyle(utils.Style6(workbook));
							createCell3.setCellValue("");
							HSSFCell createCell4 = row3.createCell(8);
							createCell4.setCellStyle(utils.Style6(workbook));
							createCell4.setCellValue("");
						}
					}
				}else{
					createCell9.setCellValue("");
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



