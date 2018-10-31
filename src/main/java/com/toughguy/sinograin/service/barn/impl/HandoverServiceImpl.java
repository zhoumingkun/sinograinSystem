package com.toughguy.sinograin.service.barn.impl;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toughguy.sinograin.model.barn.Handover;
import com.toughguy.sinograin.model.barn.Sample;
import com.toughguy.sinograin.persist.barn.prototype.IHandoverDao;
import com.toughguy.sinograin.service.barn.prototype.IHandoverService;
import com.toughguy.sinograin.service.barn.prototype.ISampleService;
import com.toughguy.sinograin.service.impl.GenericServiceImpl;
import com.toughguy.sinograin.util.POIUtils;

import net.sf.ehcache.management.sampled.SampledMBeanRegistrationProvider;

@Service
public class HandoverServiceImpl extends GenericServiceImpl<Handover, Integer> implements IHandoverService {
	
	@Autowired
	ISampleService sampleService;
	@Override
	public void expotHandover(HttpServletResponse response,Handover handover,boolean isStorage) {
		// TODO Auto-generated method stub
		 FileInputStream fileInput;
		try {
			if(!isStorage) {
				//输入模板文件
				XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new FileInputStream("/base/交接单.xlsx"));
				SXSSFWorkbook workbook = new SXSSFWorkbook(xssfWorkbook, 1000);
				POIUtils utils = new POIUtils();
				//对应Excel文件中的sheet，0代表第一个             
				Sheet sheet = workbook.getSheetAt(0);  
				
				//第一行数据内容
				Row row = sheet.createRow(1);
				Region region1 = new Region(1, (short) 0, 1, (short) 7);
				Cell createCell = row.createCell(0);
				utils.setRegionStyle(sheet, region1, utils.Style6(workbook));
				sheet.addMergedRegion(new CellRangeAddress(1, (short) 0, 1, (short) 7));
//				createCell.setCellStyle(utils.Style6(workbook));
				createCell.setCellValue(handover.getName());
				//第二行数据内容
				Row row2 = sheet.createRow(2);
				Region region2 = new Region(2, (short) 0, 2, (short) 7);
				Cell createCell2 = row2.createCell(0);
				utils.setRegionStyle(sheet, region2, utils.Style7(workbook));
				sheet.addMergedRegion(new CellRangeAddress(2, (short) 0, 2, (short) 7));
//				createCell2.setCellStyle(utils.Style7(workbook));
				if(handover.getId() >10){
					createCell2.setCellValue("编号:"+handover.getId());
				}else{
					createCell2.setCellValue("编号:0"+handover.getId());   //------------------
				}
				
				//第二行数据内容
				Row row3 = sheet.createRow(3);
				
				Cell createCell3 = row3.createCell(0);
				createCell3.setCellStyle(utils.Style6(workbook));
				createCell3.setCellValue("检验项目");
				
				Cell create = row3.createCell(1);
				Region region3 = new Region(3, (short) 1, 3, (short) 7);
				utils.setRegionStyle(sheet, region3, utils.Style6(workbook));
				sheet.addMergedRegion(new CellRangeAddress(3, (short) 1, 3, (short) 7));
//				create.setCellStyle(utils.Style6(workbook));
				String[] split = handover.getCheckeds().split(",");
				String checked ="";
				for (int i = 0; i < split.length; i++) {
					if("1".equals(split[i])){
						checked += "容重,";
					}else if("2".equals(split[i])){
						checked += "水分,";
					}else if("3".equals(split[i])){
						checked += "杂质,";
					}else if("4".equals(split[i])){
						checked += "矿物质,";
					}else if("5".equals(split[i])){
						checked += "不完善粒,";
					}else if("6".equals(split[i])){
						checked += "生霉粒,";
					}else if("7".equals(split[i])){
						checked += "色泽气味(质量指标),";
					}else if("8".equals(split[i]) && handover.getSort().equals("小麦")){
						checked += "硬度指数,";
					}else if("9".equals(split[i]) && handover.getSort().equals("小麦")){
						checked += "面筋吸水量,";
					}else if("10".equals(split[i]) && handover.getSort().equals("玉米")){
						checked += "脂肪酸值,";
					}else if("11".equals(split[i])){
						checked += "品尝评分值,";
					}else if("12".equals(split[i])){
						checked += "色泽气味(储存品质指标),";
					}else if("13".equals(split[i]) && (!handover.getSort().equals("小麦"))){
						checked += "真菌毒素(黄曲霉毒素B1),";
					}else if("14".equals(split[i])){
						checked += "真菌毒素(脱氧雪腐镰刀菌烯醇),";
					}else if("15".equals(split[i]) && (!handover.getSort().equals("小麦"))){
						checked += "真菌毒素(玉米赤霉烯酮),";
					}else if("16".equals(split[i])){
						checked += "重金属(铅),";
					}else if("17".equals(split[i])){
						checked += "重金属(镉),";
					}else if("18".equals(split[i])){
						checked += "重金属(汞),";
					}else if("19".equals(split[i])){
						checked += "重金属(砷),";
					}
				}
				
				String substring = checked.substring(0,checked.length()-1);
				if(handover.getSort().equals("小麦")) {
	    			substring = substring.replace("容重,水分,杂质,矿物质,不完善粒,色泽气味(质量指标),硬度指数,面筋吸水量,品尝评分值,色泽气味(储存品质指标),真菌毒素(脱氧雪腐镰刀菌烯醇),重金属(铅),重金属(镉),重金属(汞),重金属(砷)", "全指标项目");
	    			substring = substring.replace("容重,水分,杂质,矿物质,不完善粒,生霉粒,色泽气味(质量指标),硬度指数", "质量指标全项目");
	    			substring = substring.replace("面筋吸水量,品尝评分值,色泽气味(储存品质指标)", "储存品质指标全项目");
	    			substring = substring.replace("真菌毒素(脱氧雪腐镰刀菌烯醇),重金属(铅),重金属(镉),重金属(汞),重金属(砷)", "食品卫生指标全项目");
	    		} else {
	    			substring = substring.replace("容重,水分,杂质,不完善粒,生霉粒,色泽气味(质量指标),脂肪酸值,品尝评分值,色泽气味(储存品质指标),真菌毒素(黄曲霉毒素B1),真菌毒素(脱氧雪腐镰刀菌烯醇),真菌毒素(玉米赤霉烯酮),重金属(铅),重金属(镉),重金属(汞),重金属(砷)", "全指标项目");
	    			substring = substring.replace("容重,水分,杂质,矿物质,不完善粒,生霉粒,色泽气味(质量指标)", "质量指标全项目");
	    			substring = substring.replace("脂肪酸值,品尝评分值,色泽气味(储存品质指标)", "储存品质指标全项目");
	    			substring = substring.replace("真菌毒素(黄曲霉毒素B1),真菌毒素(脱氧雪腐镰刀菌烯醇),真菌毒素(玉米赤霉烯酮),重金属(铅),重金属(镉),重金属(汞),重金属(砷)", "食品卫生指标全项目");
	    		}
				
				create.setCellValue(substring);
				
				//存储循环数据
				String[] sampleNums = handover.getSampleNums().split(",");
				//向上取整
				double ceil = Math.ceil(sampleNums.length/4.0);
				int number = (int)ceil;
				for (int j = 0; j < number; j++) {
					Row row5 = sheet.createRow(5+j);
					Cell createCell5 = row5.createCell(0);
					createCell5.setCellStyle(utils.Style6(workbook));
					createCell5.setCellValue(1+(j)*4); //序号
					Cell createCell6 = row5.createCell(1);
					createCell6.setCellStyle(utils.Style6(workbook));
					if(1+(j)*4-1 < sampleNums.length){
						createCell6.setCellValue("监"+sampleNums[1+(j)*4-1]);  //编号
					}else{
						createCell6.setCellValue("");
					}
					
					Cell createCell7 = row5.createCell(2);
					createCell7.setCellStyle(utils.Style6(workbook));
					createCell7.setCellValue(2+(j)*4); //序号
					Cell createCell8 = row5.createCell(3);
					createCell8.setCellStyle(utils.Style6(workbook));
					if(2+(j)*4-1 < sampleNums.length){
						createCell8.setCellValue("监"+sampleNums[2+(j)*4-1]);  //编号
					}else{
						createCell8.setCellValue("");
					}
					
					Cell createCell9 = row5.createCell(4);
					createCell9.setCellStyle(utils.Style6(workbook));
					createCell9.setCellValue(3+(j)*4); //序号
					Cell createCell10 = row5.createCell(5);
					createCell10.setCellStyle(utils.Style6(workbook));
					if(3+(j)*4-1 < sampleNums.length){
						createCell10.setCellValue("监"+sampleNums[3+(j)*4-1]);  //编号
					}else{
						createCell10.setCellValue("");
					}
					
					Cell createCell11 = row5.createCell(6);
					createCell11.setCellStyle(utils.Style6(workbook));
					createCell11.setCellValue(4+(j)*4); //序号
					Cell createCell12 = row5.createCell(7);
					createCell12.setCellStyle(utils.Style6(workbook));
					if(4+(j)*4-1 < sampleNums.length){
						createCell12.setCellValue("监"+sampleNums[4+(j)*4-1]);  //编号
					}else{
						createCell12.setCellValue("");
					}
				}
				Row rowCell = sheet.createRow(5+number);
				Region region = new Region(5+number, (short) 5, 5+number, (short) 7);
				
				Cell createCell4 = rowCell.createCell(0);
				createCell4.setCellStyle(utils.Style6(workbook));
				createCell4.setCellValue("领取人");
				
				Cell createCell5 = rowCell.createCell(1);
				createCell5.setCellStyle(utils.Style6(workbook));
				createCell5.setCellValue("");
				
				Cell createCell6 = rowCell.createCell(2);
				createCell6.setCellStyle(utils.Style6(workbook));
				createCell6.setCellValue("归还人");
				
				Cell createCell7 = rowCell.createCell(3);
				createCell7.setCellStyle(utils.Style6(workbook));
				createCell7.setCellValue("");
				
				Cell createCell8 = rowCell.createCell(4);
				createCell8.setCellStyle(utils.Style6(workbook));
				createCell8.setCellValue("备注");
				
				Cell createCell9 = rowCell.createCell(5);
				utils.setRegionStyle(sheet, region, utils.Style6(workbook));
				sheet.addMergedRegion(new CellRangeAddress(6+number, (short) 4, 6+number, (short) 7));
//				createCell9.setCellStyle(utils.Style6(workbook));
				createCell9.setCellValue(handover.getRemark());
				
				
				Row createRow = sheet.createRow(6+number);
				Region regio = new Region(6+number, (short) 4, 6+number, (short) 7);
				
				Cell createCell10 = createRow.createCell(0);
				createCell10.setCellStyle(utils.Style6(workbook));
				createCell10.setCellValue("领取日期");
				
				Cell createCell11 = createRow.createCell(1);
				createCell11.setCellStyle(utils.Style6(workbook));
				createCell11.setCellValue("");
				
				Cell createCell12 = createRow.createCell(2);
				createCell12.setCellStyle(utils.Style6(workbook));
				createCell12.setCellValue("归还日期");
				
				Cell createCell13 = createRow.createCell(3);
				createCell13.setCellStyle(utils.Style6(workbook));
				createCell13.setCellValue("");
				
				Cell createCell14 = createRow.createCell(4);
//				createCell14.setCellStyle(utils.Style6(workbook));
				utils.setRegionStyle(sheet, regio, utils.Style6(workbook));
				sheet.addMergedRegion(new CellRangeAddress(6+number, (short) 4, 6+number, (short) 7));
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd ");//设置日期格式
				String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
				createCell14.setCellValue("样品管理员："+handover.getSampleAdmin()+"     "+"时间："+date);
				
			
				OutputStream output = response.getOutputStream();
//				response.reset();
				response.setHeader("Content-disposition", "attachment; filename="+new Date().getTime()+".xls");
				response.setContentType("application/vnd.ms-excel;charset=utf-8");
				workbook.write(output);
				output.flush();  
		        //将Excel写出        
		        workbook.write(output);  
		        //关闭流  
		        output.close();  
			} else {
				System.out.println("嗯哼");
				fileInput = new FileInputStream("upload/base/带有存放位置的交接单.xls");
				//输入模板文件
				XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new FileInputStream("upload/base/中央事权粮油样品登记簿.xlsx"));
				SXSSFWorkbook workbook = new SXSSFWorkbook(xssfWorkbook, 1000);
				POIUtils utils = new POIUtils();
				//对应Excel文件中的sheet，0代表第一个             
				Sheet sheet = workbook.getSheetAt(0);  
				
				//第一行数据内容
				Row row = sheet.createRow(1);
				Region region1 = new Region(1, (short) 0, 1, (short) 11);
				Cell createCell = row.createCell(0);
				utils.setRegionStyle(sheet, region1, utils.Style6(workbook));
				sheet.addMergedRegion(new CellRangeAddress(1, (short) 0, 1, (short) 11));
//				createCell.setCellStyle(utils.Style6(workbook));
				createCell.setCellValue(handover.getName());
				//第二行数据内容
				Row row2 = sheet.createRow(2);
				Region region2 = new Region(2, (short) 0, 2, (short) 11);
				Cell createCell2 = row2.createCell(0);
				utils.setRegionStyle(sheet, region2, utils.Style7(workbook));
				sheet.addMergedRegion(new CellRangeAddress(2, (short) 0, 2, (short) 11));
//				createCell2.setCellStyle(utils.Style7(workbook));
				if(handover.getId() >10){
					createCell2.setCellValue("编号:"+handover.getId());
				}else{
					createCell2.setCellValue("编号:0"+handover.getId());   //------------------
				}
				
				//第二行数据内容
				Row row3 = sheet.createRow(3);
				
				Cell createCell3 = row3.createCell(0);
				createCell3.setCellStyle(utils.Style6(workbook));
				createCell3.setCellValue("检验项目");
				
				Cell create = row3.createCell(1);
				Region region3 = new Region(3, (short) 1, 3, (short) 11);
				utils.setRegionStyle(sheet, region3, utils.Style6(workbook));
				sheet.addMergedRegion(new CellRangeAddress(3, (short) 1, 3, (short) 11));
//				create.setCellStyle(utils.Style6(workbook));
				String[] split = handover.getCheckeds().split(",");
				String checked ="";
				for (int i = 0; i < split.length; i++) {
					if("1".equals(split[i])){
						checked += "容重,";
					}else if("2".equals(split[i])){
						checked += "水分,";
					}else if("3".equals(split[i])){
						checked += "杂质,";
					}else if("4".equals(split[i])){
						checked += "矿物质,";
					}else if("5".equals(split[i])){
						checked += "不完善粒,";
					}else if("6".equals(split[i])){
						checked += "生霉粒,";
					}else if("7".equals(split[i])){
						checked += "色泽气味(质量指标),";
					}else if("8".equals(split[i]) && handover.getSort().equals("小麦")){
						checked += "硬度指数,";
					}else if("9".equals(split[i]) && handover.getSort().equals("小麦")){
						checked += "面筋吸水量,";
					}else if("10".equals(split[i]) && handover.getSort().equals("玉米")){
						checked += "脂肪酸值,";
					}else if("11".equals(split[i])){
						checked += "品尝评分值,";
					}else if("12".equals(split[i])){
						checked += "色泽气味(储存品质指标),";
					}else if("13".equals(split[i]) && (!handover.getSort().equals("小麦"))){
						checked += "真菌毒素(黄曲霉毒素B1),";
					}else if("14".equals(split[i])){
						checked += "真菌毒素(脱氧雪腐镰刀菌烯醇),";
					}else if("15".equals(split[i]) && (!handover.getSort().equals("小麦"))){
						checked += "真菌毒素(玉米赤霉烯酮),";
					}else if("16".equals(split[i])){
						checked += "重金属(铅),";
					}else if("17".equals(split[i])){
						checked += "重金属(镉),";
					}else if("18".equals(split[i])){
						checked += "重金属(汞),";
					}else if("19".equals(split[i])){
						checked += "重金属(砷),";
					}
				}
				
				String substring = checked.substring(0,checked.length()-1);
				if(handover.getSort().equals("小麦")) {
	    			substring = substring.replace("容重,水分,杂质,矿物质,不完善粒,色泽气味(质量指标),硬度指数,面筋吸水量,品尝评分值,色泽气味(储存品质指标),真菌毒素(脱氧雪腐镰刀菌烯醇),重金属(铅),重金属(镉),重金属(汞),重金属(砷)", "全指标项目");
	    			substring = substring.replace("容重,水分,杂质,矿物质,不完善粒,生霉粒,色泽气味(质量指标),硬度指数", "质量指标全项目");
	    			substring = substring.replace("面筋吸水量,品尝评分值,色泽气味(储存品质指标)", "储存品质指标全项目");
	    			substring = substring.replace("真菌毒素(脱氧雪腐镰刀菌烯醇),重金属(铅),重金属(镉),重金属(汞),重金属(砷)", "食品卫生指标全项目");
	    		} else {
	    			substring = substring.replace("容重,水分,杂质,不完善粒,生霉粒,色泽气味(质量指标),脂肪酸值,品尝评分值,色泽气味(储存品质指标),真菌毒素(黄曲霉毒素B1),真菌毒素(脱氧雪腐镰刀菌烯醇),真菌毒素(玉米赤霉烯酮),重金属(铅),重金属(镉),重金属(汞),重金属(砷)", "全指标项目");
	    			substring = substring.replace("容重,水分,杂质,矿物质,不完善粒,生霉粒,色泽气味(质量指标)", "质量指标全项目");
	    			substring = substring.replace("脂肪酸值,品尝评分值,色泽气味(储存品质指标)", "储存品质指标全项目");
	    			substring = substring.replace("真菌毒素(黄曲霉毒素B1),真菌毒素(脱氧雪腐镰刀菌烯醇),真菌毒素(玉米赤霉烯酮),重金属(铅),重金属(镉),重金属(汞),重金属(砷)", "食品卫生指标全项目");
	    		}
				
				create.setCellValue(substring);
				
				//存储循环数据
				String[] sampleNums = handover.getSampleNums().split(",");
				//向上取整
				double ceil = Math.ceil(sampleNums.length/4.0);
				int number = (int)ceil;
				for (int j = 0; j < number; j++) {
					Row row5 = sheet.createRow(5+j);
					Cell createCell5 = row5.createCell(0);
					createCell5.setCellStyle(utils.Style6(workbook));
					createCell5.setCellValue(1+(j)*4); //序号
					Cell createCell6 = row5.createCell(1);
					createCell6.setCellStyle(utils.Style6(workbook));
					if(1+(j)*4-1 < sampleNums.length){
						createCell6.setCellValue("监"+sampleNums[1+(j)*4-1]);  //编号
					}else{
						createCell6.setCellValue("");
					}
					Cell createCell7 = row5.createCell(2);
					createCell7.setCellStyle(utils.Style6(workbook));
					if(1+(j)*4-1 < sampleNums.length){
						Sample s = sampleService.findBySampleNum(sampleNums[1+(j)*4-1]);
						s.setStorage(s.getDepot() + "--" + s.getCounter() + "--" + s.getPlace());
						System.out.println(s.getStorage());
						createCell7.setCellValue(s.getStorage());
					}else {
						createCell7.setCellValue("");
					}
					
					Cell createCell8 = row5.createCell(3);
					createCell8.setCellStyle(utils.Style6(workbook));
					createCell8.setCellValue(2+(j)*4); //序号
					Cell createCell9 = row5.createCell(4);
					createCell9.setCellStyle(utils.Style6(workbook));
					if(2+(j)*4-1 < sampleNums.length){
						createCell9.setCellValue("监"+sampleNums[2+(j)*4-1]);  //编号
					}else{
						createCell9.setCellValue("");
					}
					Cell createCell10 = row5.createCell(5);
					createCell10.setCellStyle(utils.Style6(workbook));
					if(2+(j)*4-1 < sampleNums.length){
						Sample s = sampleService.findBySampleNum(sampleNums[2+(j)*4-1]);
						s.setStorage(s.getDepot() + "--" + s.getCounter() + "--" + s.getPlace());
						createCell10.setCellValue(s.getStorage());
					}else{
						createCell10.setCellValue("");
					}
					Cell createCell11 = row5.createCell(6);
					createCell11.setCellStyle(utils.Style6(workbook));
					createCell11.setCellValue(3+(j)*4); //序号
					Cell createCell12 = row5.createCell(7);
					createCell12.setCellStyle(utils.Style6(workbook));
					if(3+(j)*4-1 < sampleNums.length){
						createCell12.setCellValue("监"+sampleNums[3+(j)*4-1]);  //编号
					}else{
						createCell12.setCellValue("");
					}
					Cell createCell13 = row5.createCell(8);
					createCell13.setCellStyle(utils.Style6(workbook));
					if(3+(j)*4-1 < sampleNums.length){
						Sample s = sampleService.findBySampleNum(sampleNums[3+(j)*4-1]);
						s.setStorage(s.getDepot() + "--" + s.getCounter() + "--" + s.getPlace());
						createCell13.setCellValue(s.getStorage());
					}else{
						createCell13.setCellValue("");
					}
					
					Cell createCell14 = row5.createCell(9);
					createCell14.setCellStyle(utils.Style6(workbook));
					createCell14.setCellValue(4+(j)*4); //序号
					Cell createCell15 = row5.createCell(10);
					createCell15.setCellStyle(utils.Style6(workbook));
					if(4+(j)*4-1 < sampleNums.length){
						createCell15.setCellValue("监"+sampleNums[4+(j)*4-1]);  //编号
					}else{
						createCell15.setCellValue("");
					}
					Cell createCell16 = row5.createCell(11);
					createCell16.setCellStyle(utils.Style6(workbook));
					if(4+(j)*4-1 < sampleNums.length){
						Sample s = sampleService.findBySampleNum(sampleNums[4+(j)*4-1]);
						s.setStorage(s.getDepot() + "--" + s.getCounter() + "--" + s.getPlace());
						createCell16.setCellValue(s.getStorage());
					}else{
						createCell16.setCellValue("");
					}
						
				}
				Row rowCell = sheet.createRow(5+number);
				Region region = new Region(5+number, (short) 5, 5+number, (short) 11);
				
				Cell createCell4 = rowCell.createCell(0);
				createCell4.setCellStyle(utils.Style6(workbook));
				createCell4.setCellValue("领取人");
				
				Cell createCell5 = rowCell.createCell(1);
				createCell5.setCellStyle(utils.Style6(workbook));
				createCell5.setCellValue("");
				
				Cell createCell6 = rowCell.createCell(2);
				createCell6.setCellStyle(utils.Style6(workbook));
				createCell6.setCellValue("归还人");
				
				Cell createCell7 = rowCell.createCell(3);
				createCell7.setCellStyle(utils.Style6(workbook));
				createCell7.setCellValue("");
				
				Cell createCell8 = rowCell.createCell(4);
				createCell8.setCellStyle(utils.Style6(workbook));
				createCell8.setCellValue("备注");
				
				Cell createCell9 = rowCell.createCell(5);
				utils.setRegionStyle(sheet, region, utils.Style6(workbook));
				sheet.addMergedRegion(new CellRangeAddress(6+number, (short) 4, 6+number, (short) 11));
//					createCell9.setCellStyle(utils.Style6(workbook));
				createCell9.setCellValue(handover.getRemark());
				
				
				Row createRow = sheet.createRow(6+number);
				Region regio = new Region(6+number, (short) 4, 6+number, (short) 11);
				
				Cell createCell10 = createRow.createCell(0);
				createCell10.setCellStyle(utils.Style6(workbook));
				createCell10.setCellValue("领取日期");
				
				Cell createCell11 = createRow.createCell(1);
				createCell11.setCellStyle(utils.Style6(workbook));
				createCell11.setCellValue("");
				
				Cell createCell12 = createRow.createCell(2);
				createCell12.setCellStyle(utils.Style6(workbook));
				createCell12.setCellValue("归还日期");
				
				Cell createCell13 = createRow.createCell(3);
				createCell13.setCellStyle(utils.Style6(workbook));
				createCell13.setCellValue("");
				
				Cell createCell14 = createRow.createCell(4);
//					createCell14.setCellStyle(utils.Style6(workbook));
				utils.setRegionStyle(sheet, regio, utils.Style6(workbook));
				sheet.addMergedRegion(new CellRangeAddress(6+number, (short) 4, 6+number, (short) 11));
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd ");//设置日期格式
				String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
				createCell14.setCellValue("样品管理员："+handover.getSampleAdmin()+"                  "+"时间："+date);
				
				
				OutputStream output = response.getOutputStream();
//					response.reset();
				response.setHeader("Content-disposition", "attachment; filename="+new Date().getTime()+".xls");
				response.setContentType("application/vnd.ms-excel;charset=utf-8");
				workbook.write(output);
				output.flush();  
				//将Excel写出        
				workbook.write(output);  
				//关闭流  
				fileInput.close();  
				output.close();  
			}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	}

	@Override
	public List<Sample> findSampleByCheckPoint(int checkPoint) {
		// TODO Auto-generated method stub
		return ((IHandoverDao)dao).findSampleByCheckPoint(checkPoint);
	}

	@Override
	public Handover findCheckedBySampleId(int sampleId) {
		// TODO Auto-generated method stub
		return ((IHandoverDao)dao).findCheckedBySampleId(sampleId);
	}
}
