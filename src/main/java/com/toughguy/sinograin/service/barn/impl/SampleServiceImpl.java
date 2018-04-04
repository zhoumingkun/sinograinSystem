package com.toughguy.sinograin.service.barn.impl;

import static org.mockito.Matchers.doubleThat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.Region;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toughguy.sinograin.model.barn.CornExaminingReport;
import com.toughguy.sinograin.model.barn.Sample;
import com.toughguy.sinograin.model.barn.WheatExaminingReport;
import com.toughguy.sinograin.pagination.PagerModel;
import com.toughguy.sinograin.persist.barn.prototype.ICornExaminingReportDao;
import com.toughguy.sinograin.persist.barn.prototype.ISampleDao;
import com.toughguy.sinograin.persist.barn.prototype.IWheatExaminingReportDao;
import com.toughguy.sinograin.service.barn.prototype.ISampleService;
import com.toughguy.sinograin.service.impl.GenericServiceImpl;
import com.toughguy.sinograin.util.POIUtils;
import com.toughguy.sinograin.util.ParamUtils;

@Service
public class SampleServiceImpl extends GenericServiceImpl<Sample, Integer> implements ISampleService {
	
	@Autowired
	IWheatExaminingReportDao wheatExaminingReportDao;

	@Autowired
	ICornExaminingReportDao icornExaminingReportDao;
	
	@Override
	public PagerModel<Sample> findPaginatedMobile(Map<String, Object> params) {	
		return  ((ISampleDao)dao).findPaginatedMobile(params);
	}

	@Override
	public Sample findBySampleNo(String sampleNo) {
		return ((ISampleDao)dao).findBySampleNo(sampleNo);	
	}

	@Override
	public void deleteByPId(int pId) {
		// TODO Auto-generated method stub
		((ISampleDao)dao).deleteByPId(pId);
	}

	@Override
	public Sample findBySampleNum(String sampleNo) {
		// TODO Auto-generated method stub
		return ((ISampleDao)dao).findBySampleNum(sampleNo);	
	}
	
	@Override
	public List<Sample> findSamplesByTask(String taskName) {
		// TODO Auto-generated method stub
		return ((ISampleDao)dao).findSamplesByTask(taskName);	
	}
	
	
	
	public void Export(String ids,String title) {
		//传入的文件  
        FileInputStream fileInput;
        POIUtils utils = new POIUtils();
		try {
			fileInput = new FileInputStream("upload/base/玉米验收情况汇总表.xls");
			//poi包下的类读取excel文件  
			POIFSFileSystem ts = new POIFSFileSystem(fileInput);  
			// 创建一个webbook，对应一个Excel文件            
			HSSFWorkbook workbook = new HSSFWorkbook(ts);  
			//对应Excel文件中的sheet，0代表第一个             
			HSSFSheet sheet = workbook.getSheetAt(0);
			
			HSSFRow row = sheet.createRow(0);
			Region region = new Region(0, (short) 0, 1, (short) 41);
			 
			HSSFCell cell = row.createCell(0);
			utils.setRegionStyle(sheet, region, utils.Style(workbook));
			sheet.addMergedRegion(region);
			cell.setCellValue(title);
			 
			HSSFRow row1 = sheet.createRow(7);
			Region region1 = new Region(7, (short) 0, 7, (short) 6);
			 
			HSSFCell cell1 = row1.createCell(0);
			utils.setRegionStyle(sheet, region1, utils.Style1(workbook));
			sheet.addMergedRegion(region1);
			cell1.setCellValue("合计");
			
			HSSFCell cell2 = row1.createCell(7);
			cell2.setCellStyle(utils.Style1(workbook));
			cell2.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell2.setCellFormula("SUM(H9)");
			
			
			HSSFRow row2 = sheet.createRow(8);
			Region region2 = new Region(8, (short) 1, 8, (short) 6);
			
			HSSFCell cell3 = row2.createCell(1);
			utils.setRegionStyle(sheet, region2, utils.Style1(workbook));
			sheet.addMergedRegion(region2);
			cell3.setCellValue("小计");
			
			HSSFCell cell4 = row2.createCell(7);
			cell4.setCellStyle(utils.Style1(workbook));
			cell4.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell4.setCellFormula("SUM(AB9)");

			String[] id = ids.split(",");
			for (int i = 0; i < id.length; i++) {
				CornExaminingReport cornExaminingReport = icornExaminingReportDao.findBasicSituation(Integer.parseInt(id[i]));
				HSSFRow row3 = sheet.createRow(i+9);
				row3.setHeight((short) 300); // 行高
				HSSFCell cell5 = row3.createCell(0);
				cell5.setCellStyle(utils.Style1(workbook));
				cell5.setCellValue(cornExaminingReport.getpLibraryName());
				
				HSSFCell cell6 = row3.createCell(1);
				cell6.setCellStyle(utils.Style1(workbook));
				cell6.setCellValue(i+1);
				
				HSSFCell cell7 = row3.createCell(2);
				cell7.setCellStyle(utils.Style1(workbook));
				cell7.setCellValue(cornExaminingReport.getLibraryName());
				
				HSSFCell cell8 = row3.createCell(3);
				cell8.setCellStyle(utils.Style1(workbook));
				cell8.setCellValue(cornExaminingReport.getSampleNum());
				
				HSSFCell cell9 = row3.createCell(4);
				cell9.setCellStyle(utils.Style1(workbook));
				cell9.setCellValue(cornExaminingReport.getSampleNo());
				
				
				HSSFCell cell10 = row3.createCell(5);
				cell10.setCellStyle(utils.Style1(workbook));
				cell10.setCellValue(cornExaminingReport.getPosition());
				
				
				HSSFCell cell11 = row3.createCell(6);
				cell11.setCellStyle(utils.Style1(workbook));
				cell11.setCellValue(cornExaminingReport.getSort());
				
				HSSFCell cell12 = row3.createCell(7);
				cell12.setCellStyle(utils.Style1(workbook));
				cell12.setCellValue(Double.valueOf(cornExaminingReport.getAmount()));
				
				HSSFCell cell13 = row3.createCell(8);
				cell13.setCellStyle(utils.Style1(workbook));
				cell13.setCellValue(cornExaminingReport.getGainTime());
				
				HSSFCell cell14 = row3.createCell(9);
				cell14.setCellStyle(utils.Style1(workbook));
				cell14.setCellValue(cornExaminingReport.getStorageTime());
				
				HSSFCell cell15 = row3.createCell(10);
				cell15.setCellStyle(utils.Style1(workbook));
				cell15.setCellValue(cornExaminingReport.getCheckApplyTime());//
				
				HSSFCell cell16 = row3.createCell(11);
				cell16.setCellStyle(utils.Style1(workbook));
				cell16.setCellValue(cornExaminingReport.getAssignMissionTime());//
				
				HSSFCell cell17 = row3.createCell(12);
				cell17.setCellStyle(utils.Style1(workbook));
				cell17.setCellValue(cornExaminingReport.getSampleTime());
				
				HSSFCell cell18 = row3.createCell(17);
				cell18.setCellStyle(utils.Style1(workbook));
				cell18.setCellValue(cornExaminingReport.getRemark());//
				
				HSSFCell cell19 = row3.createCell(18);
				cell19.setCellStyle(utils.Style1(workbook));
				cell19.setCellValue(cornExaminingReport.getLength());
				
				HSSFCell cell20 = row3.createCell(19);
				cell20.setCellStyle(utils.Style1(workbook));
				cell20.setCellValue(cornExaminingReport.getWide());
				
				HSSFCell cell21 = row3.createCell(20);
				cell21.setCellStyle(utils.Style1(workbook));
				cell21.setCellValue(cornExaminingReport.getHigh());
				
				HSSFCell cell22 = row3.createCell(21);
				cell22.setCellStyle(utils.Style1(workbook));
				cell22.setCellValue(cornExaminingReport.getDeductVolume());
				
				HSSFCell cell23 = row3.createCell(22);
				cell23.setCellStyle(utils.Style1(workbook));
				cell23.setCellValue(cornExaminingReport.getRealVolume());
				
				HSSFCell cell24 = row3.createCell(23);
				cell24.setCellStyle(utils.Style1(workbook));
				cell24.setCellValue(cornExaminingReport.getRealCapacity());
				
				HSSFCell cell25 = row3.createCell(24);
				cell25.setCellStyle(utils.Style1(workbook));
				cell25.setCellValue(cornExaminingReport.getCorrectioFactor());
				
				HSSFCell cell26 = row3.createCell(25);
				cell26.setCellStyle(utils.Style1(workbook));
				cell26.setCellValue(cornExaminingReport.getAveDensity());
				
				HSSFCell cell27 = row3.createCell(26);
				cell27.setCellStyle(utils.Style1(workbook));
				cell27.setCellValue(cornExaminingReport.getUnQuality());
				
				HSSFCell cell28 = row3.createCell(27);
				cell28.setCellStyle(utils.Style1(workbook));
				cell28.setCellValue(cornExaminingReport.getGrainQuality());
				
				HSSFCell cell29 = row3.createCell(28);
				cell29.setCellStyle(utils.Style1(workbook));
				cell29.setCellValue(cornExaminingReport.getSlip());
				
				List<CornExaminingReport> cornExaminingReport1 = icornExaminingReportDao.findQualityAcceptance(Integer.parseInt(id[i]));
				for(int j=1; j<cornExaminingReport1.size(); j++) {
					int newNum = Integer.parseInt(cornExaminingReport1.get(j).getSmallSampleNum().substring(9));
					row3.createCell(29).setCellValue(cornExaminingReport1.get(j).getQualityGrade());
					row3.createCell(30).setCellValue(cornExaminingReport1.get(j).getRealCapacity());
					if(newNum == 04) {
						HSSFCell cell30 = row3.createCell(31);
						cell30.setCellStyle(utils.Style1(workbook));
						cell30.setCellValue(cornExaminingReport1.get(j).getShuifen_pingjunzhi());
					}
					else if(newNum == 02) {
						HSSFCell cell31 = row3.createCell(32);
						cell31.setCellStyle(utils.Style1(workbook));
						cell31.setCellValue(cornExaminingReport1.get(j).getZazhizongliang_1());
					}
					else if(newNum == 01) {
						HSSFCell cell32 = row3.createCell(33);
						cell32.setCellStyle(utils.Style1(workbook));
						cell32.setCellValue(cornExaminingReport1.get(j).getBuwanshanlihanliang_pingjunzhi_1());
						
					}
					else if(newNum == 03) {
						HSSFCell cell33 = row3.createCell(34);
						cell33.setCellStyle(utils.Style1(workbook));
						cell33.setCellValue(cornExaminingReport1.get(j).getShengmeilihanliang_pingjunzhi());
					}
					else if(newNum == 05) {
						HSSFCell cell34 = row3.createCell(35);
						cell34.setCellStyle(utils.Style1(workbook));
						cell34.setCellValue(cornExaminingReport1.get(j).getSezeqiwei_pingjunzhi());
					}
					else if(newNum == 06) {
						HSSFCell cell35 = row3.createCell(36);
						cell35.setCellStyle(utils.Style1(workbook));
						cell35.setCellValue(cornExaminingReport1.get(j).getZhifangsuanzhi_pingjunzhi());
					}
					else if(newNum == 07) {
						HSSFCell cell36 = row3.createCell(37);
						cell36.setCellStyle(utils.Style1(workbook));
						cell36.setCellValue(cornExaminingReport1.get(j).getPinchangpingfenzhi());
					}
					System.out.println(newNum);
				}
			}
			 FileOutputStream out = new FileOutputStream("E://玉米检测报表.xls");  
			 workbook.write(out);
		} catch (Exception e) {
			e.printStackTrace();
		}  
   
	}

	/*
	 * 导出小麦
	 * 
	 */
	@Override
	public void ExeclPOI(String ids,String title) {
		POIUtils utils = new POIUtils();
		//传入的文件  
        FileInputStream fileInput;
        try {
        	fileInput = new FileInputStream("upload/base/小麦验收情况汇总表.xls");
			//poi包下的类读取excel文件  
			POIFSFileSystem ts = new POIFSFileSystem(fileInput);  
			// 创建一个webbook，对应一个Excel文件            
			HSSFWorkbook workbook = new HSSFWorkbook(ts);  
			//对应Excel文件中的sheet，0代表第一个             
			HSSFSheet sheet = workbook.getSheetAt(0);
			
			HSSFRow row = sheet.createRow(0);
			Region region = new Region(0, (short) 0, 1, (short) 41);
			 
			HSSFCell cell = row.createCell(0);
			utils.setRegionStyle(sheet, region, utils.Style(workbook));
			sheet.addMergedRegion(region);
			cell.setCellValue(title);
			 
			HSSFRow row1 = sheet.createRow(7);
			Region region1 = new Region(7, (short) 0, 7, (short) 6);
			 
			HSSFCell cell1 = row1.createCell(0);
			utils.setRegionStyle(sheet, region1, utils.Style1(workbook));
			sheet.addMergedRegion(region1);
			cell1.setCellValue("合计");
			
			HSSFCell cell2 = row1.createCell(7);
			cell2.setCellStyle(utils.Style1(workbook));
			cell2.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell2.setCellFormula("SUM(H9)");		
			
			HSSFRow row2 = sheet.createRow(8);
			Region region2 = new Region(8, (short) 1, 8, (short) 6);
			
			HSSFCell cell3 = row2.createCell(1);
			utils.setRegionStyle(sheet, region2, utils.Style1(workbook));
			sheet.addMergedRegion(region2);
			cell3.setCellValue("小计");
			
			HSSFCell cell4 = row2.createCell(7);
			cell4.setCellStyle(utils.Style1(workbook));
			cell4.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell4.setCellFormula("SUM(AB9)");

			String[] id = ids.split(",");
			for (int i = 0; i < id.length; i++) {
				HSSFRow row3 = sheet.createRow(i+9);
				row3.setHeight((short) 300); // 行高
				//查询基本情况
				WheatExaminingReport Wobjiect = wheatExaminingReportDao.findBasicSituation(Integer.parseInt(id[i]));
				HSSFCell cell5 = row3.createCell(0);
				cell5.setCellStyle(utils.Style1(workbook));
				cell5.setCellValue(Wobjiect.getpLibraryName());
				
				HSSFCell cell6 = row3.createCell(2);
				cell6.setCellStyle(utils.Style1(workbook));
				cell6.setCellValue(Wobjiect.getLibraryName());
				
				HSSFCell cell7 = row3.createCell(3);
				cell7.setCellStyle(utils.Style1(workbook));
				cell7.setCellValue(Wobjiect.getSampleNum());
				
				HSSFCell cell8 = row3.createCell(4);
				cell8.setCellStyle(utils.Style1(workbook));
				cell8.setCellValue(Wobjiect.getSampleNo());
				
				HSSFCell cell9 = row3.createCell(5);
				cell9.setCellStyle(utils.Style1(workbook));
				cell8.setCellValue(Wobjiect.getPosition());
				
				HSSFCell cell10 = row3.createCell(6);
				cell10.setCellStyle(utils.Style1(workbook));
				cell10.setCellValue(Wobjiect.getStorageTime());
				
				HSSFCell cell11 = row3.createCell(7);
				cell11.setCellStyle(utils.Style1(workbook));
				cell11.setCellValue(Double.valueOf(Wobjiect.getAmount()));
				
				HSSFCell cell12 = row3.createCell(8);
				cell12.setCellStyle(utils.Style1(workbook));
				cell12.setCellValue(Wobjiect.getGainTime());
				
				HSSFCell cell13 = row3.createCell(9);
				cell13.setCellStyle(utils.Style1(workbook));
				cell13.setCellValue(Wobjiect.getStorageTime());
				
				HSSFCell cell14 = row3.createCell(12);
				cell14.setCellStyle(utils.Style1(workbook));
				cell14.setCellValue(Wobjiect.getSampleTime());
				
				HSSFCell cell15 = row3.createCell(17);
				cell15.setCellStyle(utils.Style1(workbook));
				cell15.setCellValue(Wobjiect.getRemark());
				
				HSSFCell cell16 = row3.createCell(18);
				cell16.setCellStyle(utils.Style1(workbook));
				cell16.setCellValue(Wobjiect.getLength());
				
				HSSFCell cell17 = row3.createCell(19);
				cell17.setCellStyle(utils.Style1(workbook));
				cell17.setCellValue(Wobjiect.getWide());
				
				HSSFCell cell18 = row3.createCell(20);
				cell18.setCellStyle(utils.Style1(workbook));
				cell18.setCellValue(Wobjiect.getHigh());
				
				HSSFCell cell19 = row3.createCell(21);
				cell19.setCellStyle(utils.Style1(workbook));
				cell19.setCellValue(Wobjiect.getDeductVolume());
				
				HSSFCell cell20 = row3.createCell(22);
				cell20.setCellStyle(utils.Style1(workbook));
				cell20.setCellValue(Wobjiect.getRealVolume());
				
				HSSFCell cell21 = row3.createCell(23);
				cell21.setCellStyle(utils.Style1(workbook));
				cell21.setCellValue(Wobjiect.getRealCapacity());
				
				HSSFCell cell22 = row3.createCell(24);
				cell22.setCellStyle(utils.Style1(workbook));
				cell22.setCellValue(Wobjiect.getCorrectioFactor());
				
				HSSFCell cell23 = row3.createCell(25);
				cell23.setCellStyle(utils.Style1(workbook));
				cell23.setCellValue(Wobjiect.getAveDensity());
				
				HSSFCell cell24 = row3.createCell(26);
				cell24.setCellStyle(utils.Style1(workbook));
				cell24.setCellValue(Wobjiect.getUnQuality());
				
				HSSFCell cell25 = row3.createCell(27);
				cell25.setCellStyle(utils.Style1(workbook));
				cell25.setCellValue(Wobjiect.getGrainQuality());
				
				HSSFCell cell26 = row3.createCell(28);
				cell26.setCellStyle(utils.Style1(workbook));
				cell26.setCellValue(Wobjiect.getSlip());
				//查询质量验收情况（根据小样编号
				List<WheatExaminingReport> Wobjiect1 = wheatExaminingReportDao.findQualityAcceptance(Integer.parseInt(id[i]));
				
				for(int j=1; j<Wobjiect1.size(); j++) {
					int newNum = Integer.parseInt(Wobjiect1.get(j).getSmallSampleNum().substring(9));
					HSSFCell cell27 = row3.createCell(29);
					cell27.setCellStyle(utils.Style1(workbook));
					cell27.setCellValue(Wobjiect1.get(j).getQualityGrade());
					
					HSSFCell cell28 = row3.createCell(30);
					cell28.setCellStyle(utils.Style1(workbook));
					cell28.setCellValue(Wobjiect1.get(j).getRealCapacity());
					
					if(newNum == 04) {
						HSSFCell cell29 = row3.createCell(31);
						cell29.setCellStyle(utils.Style1(workbook));
						cell29.setCellValue(Wobjiect1.get(j).getShuifen_pingjunzhi());
					}
					else if(newNum == 01) {
						HSSFCell cell30 = row3.createCell(32);
						cell30.setCellStyle(utils.Style1(workbook));
						cell30.setCellValue(Wobjiect1.get(j).getZazhizongliang_1());
						
						HSSFCell cell31 = row3.createCell(33);
						cell31.setCellStyle(utils.Style1(workbook));
						cell31.setCellValue(Wobjiect1.get(j).getKuangwuzhihanliang_pingjunzhi());
						
						HSSFCell cell32 = row3.createCell(34);
						cell32.setCellStyle(utils.Style1(workbook));
						cell32.setCellValue(Wobjiect1.get(j).getBuwanshanlihanliang_pingjunzhi_1());
					}
					else if(newNum == 05) {
						HSSFCell cell33 = row3.createCell(35);
						cell33.setCellStyle(utils.Style1(workbook));
						cell33.setCellValue(Wobjiect1.get(j).getYingduzhishu_pingjunzhi());
						
						HSSFCell cell34 = row3.createCell(36);
						cell34.setCellStyle(utils.Style1(workbook));
						cell34.setCellValue(Wobjiect1.get(j).getSezeqiwei_pingjunzhi());
					}
					else if(newNum == 06) {
						HSSFCell cell35 = row3.createCell(37);
						cell35.setCellStyle(utils.Style1(workbook));
						cell35.setCellValue(Wobjiect1.get(j).getPingjunzhiganmianjinzhiliang());
					    
						HSSFCell cell36 = row3.createCell(38);
						cell36.setCellStyle(utils.Style1(workbook));
						cell36.setCellValue(Wobjiect1.get(j).getShimianjin_pingjunzhi());
					}
					else if(newNum == 07) {
						HSSFCell cell37 = row3.createCell(39);
						cell37.setCellStyle(utils.Style1(workbook));
						cell37.setCellValue(Wobjiect1.get(j).getPinchangpingfenzhi());
					}
					System.out.println(newNum);
				}
			}
			FileOutputStream out = new FileOutputStream("E://小麦检测报表.xls");  
			workbook.write(out);
			}catch (Exception e) {
				// TODO: handle exception
			}		
	}

	
}



