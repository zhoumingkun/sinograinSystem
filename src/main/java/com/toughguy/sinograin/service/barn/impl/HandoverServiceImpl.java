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
import org.springframework.stereotype.Service;

import com.toughguy.sinograin.model.barn.Handover;
import com.toughguy.sinograin.model.barn.Sample;
import com.toughguy.sinograin.persist.barn.prototype.IHandoverDao;
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
				Region region1 = new Region(1, (short) 0, 1, (short) 7);
				HSSFCell createCell = row.createCell(0);
				utils.setRegionStyle(sh, region1, utils.Style6(workbook));
				sh.addMergedRegion(region1);
//				createCell.setCellStyle(utils.Style6(workbook));
				createCell.setCellValue(handover.getName());
				//第二行数据内容
				HSSFRow row2 = sh.createRow(2);
				Region region2 = new Region(2, (short) 0, 2, (short) 7);
				HSSFCell createCell2 = row2.createCell(0);
				utils.setRegionStyle(sh, region2, utils.Style7(workbook));
				sh.addMergedRegion(region2);
//				createCell2.setCellStyle(utils.Style7(workbook));
				if(handover.getId() >10){
					createCell2.setCellValue("编号:"+handover.getId());
				}else{
					createCell2.setCellValue("编号:0"+handover.getId());   //------------------
				}
				
				//第二行数据内容
				HSSFRow row3 = sh.createRow(3);
				
				HSSFCell createCell3 = row3.createCell(0);
				createCell3.setCellStyle(utils.Style6(workbook));
				createCell3.setCellValue("检验项目");
				
				HSSFCell create = row3.createCell(1);
				Region region3 = new Region(3, (short) 1, 3, (short) 7);
				utils.setRegionStyle(sh, region3, utils.Style6(workbook));
				sh.addMergedRegion(region3);
//				create.setCellStyle(utils.Style6(workbook));
				String[] split = handover.getCheckeds().split(",");
				String checked ="";
				for (int i = 0; i < split.length; i++) {
					if("1".equals(split[i])){
						checked += "容重,";
					}else if("2".equals(split[i])){
						checked += "水分,";
					}else if("3".equals(split[i])){
						checked += "杂质(矿物质),";
					}else if("4".equals(split[i])){
						checked += "不完善粒(生霉粒),";
					}else if("5".equals(split[i])){
						checked += "色泽气味(质量指标),";
					}else if("6".equals(split[i])){
						checked += "面筋吸水量,";
					}else if("7".equals(split[i])){
						checked += "脂肪酸值,";
					}else if("8".equals(split[i])){
						checked += "品尝评分值,";
					}else if("9".equals(split[i])){
						checked += "色泽气味(储存品质指标),";
					}else if("10".equals(split[i])){
						checked += "真菌毒素(黄曲霉毒素B1、脱氧雪腐、镰刀菌烯醇、玉米赤霉烯酮),";
					}else if("11".equals(split[i])){
						checked += "重金属(铅、镉、汞、砷),";
					}
				}
				
				String substring = checked.substring(0,checked.length()-1);
				substring = substring.replace("容重,水分,杂质(矿物质),不完善粒(生霉粒),色泽气味(质量指标),面筋吸水量,品尝评分值,色泽气味(储存品质指标),真菌毒素(黄曲霉毒素B1、脱氧雪腐、镰刀菌烯醇、玉米赤霉烯酮),重金属(铅、镉、汞、砷)", "全指标项目");
				substring = substring.replace("容重,水分,杂质(矿物质),不完善粒(生霉粒),色泽气味(质量指标),脂肪酸值,品尝评分值,色泽气味(储存品质指标),真菌毒素(黄曲霉毒素B1、脱氧雪腐、镰刀菌烯醇、玉米赤霉烯酮),重金属(铅、镉、汞、砷)", "全指标项目");
				substring = substring.replace("容重,水分,杂质(矿物质),不完善粒(生霉粒),色泽气味(质量指标)", "质量指标全项目");
				substring = substring.replace("面筋吸水量,品尝评分值,色泽气味(储存品质指标)", "储存品质指标全项目");
				substring = substring.replace("脂肪酸值,品尝评分值,色泽气味(储存品质指标)", "储存品质指标全项目");
				substring = substring.replace("真菌毒素(黄曲霉毒素B1、脱氧雪腐、镰刀菌烯醇、玉米赤霉烯酮),重金属(铅、镉、汞、砷)", "食品卫生指标全项目");
				
				create.setCellValue(substring);
				
				//存储循环数据
				String[] sampleNums = handover.getSampleNums().split(",");
				//向上取整
				double ceil = Math.ceil(sampleNums.length/4.0);
				int number = (int)ceil;
				for (int j = 0; j < number; j++) {
						HSSFRow row5 = sh.createRow(5+j);
						HSSFCell createCell5 = row5.createCell(0);
						createCell5.setCellStyle(utils.Style6(workbook));
						createCell5.setCellValue(1+(j)*4); //序号
						HSSFCell createCell6 = row5.createCell(1);
						createCell6.setCellStyle(utils.Style6(workbook));
						if(1+(j)*4-1 < sampleNums.length){
							createCell6.setCellValue("监"+sampleNums[1+(j)*4-1]);  //编号
						}else{
							createCell6.setCellValue("");
						}
						
			    		HSSFCell createCell7 = row5.createCell(2);
			    		createCell7.setCellStyle(utils.Style6(workbook));
						createCell7.setCellValue(2+(j)*4); //序号
						HSSFCell createCell8 = row5.createCell(3);
						createCell8.setCellStyle(utils.Style6(workbook));
						if(2+(j)*4-1 < sampleNums.length){
							createCell8.setCellValue("监"+sampleNums[2+(j)*4-1]);  //编号
						}else{
							createCell8.setCellValue("");
						}
						
						HSSFCell createCell9 = row5.createCell(4);
						createCell9.setCellStyle(utils.Style6(workbook));
						createCell9.setCellValue(3+(j)*4); //序号
						HSSFCell createCell10 = row5.createCell(5);
						createCell10.setCellStyle(utils.Style6(workbook));
						if(3+(j)*4-1 < sampleNums.length){
							createCell10.setCellValue("监"+sampleNums[3+(j)*4-1]);  //编号
						}else{
							createCell10.setCellValue("");
						}
						
						HSSFCell createCell11 = row5.createCell(6);
						createCell11.setCellStyle(utils.Style6(workbook));
						createCell11.setCellValue(4+(j)*4); //序号
						HSSFCell createCell12 = row5.createCell(7);
						createCell12.setCellStyle(utils.Style6(workbook));
						if(4+(j)*4-1 < sampleNums.length){
							createCell12.setCellValue("监"+sampleNums[4+(j)*4-1]);  //编号
						}else{
							createCell12.setCellValue("");
						}
				}
				
				HSSFRow rowCell = sh.createRow(5+number);
				Region region = new Region(5+number, (short) 5, 5+number, (short) 7);
				
				HSSFCell createCell4 = rowCell.createCell(0);
				createCell4.setCellStyle(utils.Style6(workbook));
				createCell4.setCellValue("领取人");
				
				HSSFCell createCell5 = rowCell.createCell(1);
				createCell5.setCellStyle(utils.Style6(workbook));
				createCell5.setCellValue("");
				
				HSSFCell createCell6 = rowCell.createCell(2);
				createCell6.setCellStyle(utils.Style6(workbook));
				createCell6.setCellValue("归还人");
				
				HSSFCell createCell7 = rowCell.createCell(3);
				createCell7.setCellStyle(utils.Style6(workbook));
				createCell7.setCellValue("");
				
				HSSFCell createCell8 = rowCell.createCell(4);
				createCell8.setCellStyle(utils.Style6(workbook));
				createCell8.setCellValue("备注");
				
				HSSFCell createCell9 = rowCell.createCell(5);
				utils.setRegionStyle(sh, region, utils.Style6(workbook));
				sh.addMergedRegion(region);
//				createCell9.setCellStyle(utils.Style6(workbook));
				createCell9.setCellValue(handover.getRemark());
				
				
				HSSFRow createRow = sh.createRow(6+number);
				Region regio = new Region(6+number, (short) 4, 6+number, (short) 7);
				
				HSSFCell createCell10 = createRow.createCell(0);
				createCell10.setCellStyle(utils.Style6(workbook));
				createCell10.setCellValue("领取日期");
				
				HSSFCell createCell11 = createRow.createCell(1);
				createCell11.setCellStyle(utils.Style6(workbook));
				createCell11.setCellValue("");
				
				HSSFCell createCell12 = createRow.createCell(2);
				createCell12.setCellStyle(utils.Style6(workbook));
				createCell12.setCellValue("归还日期");
				
				HSSFCell createCell13 = createRow.createCell(3);
				createCell13.setCellStyle(utils.Style6(workbook));
				createCell13.setCellValue("");
				
				HSSFCell createCell14 = createRow.createCell(4);
//				createCell14.setCellStyle(utils.Style6(workbook));
				utils.setRegionStyle(sh, regio, utils.Style6(workbook));
				sh.addMergedRegion(regio);
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd ");//设置日期格式
				String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
				createCell14.setCellValue("样品管理员："+handover.getSampleAdmin()+"     "+"时间："+date);
				
			
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
