package com.toughguy.sinograin.service.barn.impl;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.Region;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toughguy.sinograin.dto.NumberDTO;
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
	
	
	
	public void Export(HttpServletResponse response,String ids,String title) {
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
			
//			HSSFCell cell2 = row1.createCell(7);
//			cell2.setCellStyle(utils.Style1(workbook));
//			cell2.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//			cell2.setCellFormula("SUM(H9)");
			for (int i = 8; i < 42; i++) {
			HSSFCell createCell = row1.createCell(i);
			createCell.setCellStyle(utils.Style1(workbook));
			createCell.setCellValue("");
		}
			
			HSSFRow row2 = sheet.createRow(8);
			Region region2 = new Region(8, (short) 1, 8, (short) 6);
			
			HSSFCell cell3 = row2.createCell(1);
			utils.setRegionStyle(sheet, region2, utils.Style1(workbook));
			sheet.addMergedRegion(region2);
			cell3.setCellValue("小计");
			
			for (int i = 8; i < 42; i++) {
				HSSFCell createCell = row2.createCell(i);
				createCell.setCellStyle(utils.Style1(workbook));
				createCell.setCellValue("");
			}
			
			HSSFCell cell4 = row2.createCell(7);
			cell4.setCellStyle(utils.Style1(workbook));
			cell4.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell4.setCellFormula("SUM(AB9)");
			String pLibraryName = null;
			int startRow = 10;
			int endRow = 7;
			//是否合并
			boolean is = false;
			//是否是第一次
			boolean isFirst = false;
			//记录上一次的i值
			int oldI=0;
			String[] id = ids.split(",");
			//string[]转int[]
			int intId[] = new int[id.length];
			for(int i=0;i<id.length;i++) {
				intId[i] = Integer.parseInt(id[i]);
			}
			//冒泡排序
			for(int k=0;k<intId.length;k++) {
				for(int j=k + 1;j<intId.length;j++) {
					if(intId[k] > intId[j]) {
						int temp = intId[k];
						intId[k] = intId[j];
						intId[j] = temp;
					}
				}
			}
			for (int i = 0; i < intId.length; i++) {
				CornExaminingReport cornExaminingReport = icornExaminingReportDao.findBasicSituation(intId[i]);
				HSSFRow row3 =null;
				if(isFirst == true) {
					row3 = sheet.createRow(startRow + (i-oldI));
					row3.setHeight((short) 300); // 行高
				} else {
					row3 = sheet.createRow(startRow + (i-oldI-1));
					row3.setHeight((short) 300); // 行高
				}
				if(pLibraryName == null || pLibraryName.equals("")) {
					pLibraryName = cornExaminingReport.getpLibraryName();
					HSSFCell cellPLibraryName = row3.createCell(0);
					cellPLibraryName.setCellStyle(utils.Style1(workbook));
					cellPLibraryName.setCellValue(cornExaminingReport.getpLibraryName());
					if(i != intId.length-1) {
						CornExaminingReport newCornExaminingReport = icornExaminingReportDao.findBasicSituation(intId[i+1]);
							if(cornExaminingReport.getpLibraryName().equals(newCornExaminingReport.getpLibraryName())) {
								startRow = i+9;
								isFirst = true;
							} else {
								endRow = i+9;
								startRow=i+11;
							}
						}
				} else if(pLibraryName.equals(cornExaminingReport.getpLibraryName())){
					is = true;
					if(i == intId.length -1) {
						row3 = sheet.createRow(startRow + (i-oldI-1));
						row3.setHeight((short) 300); // 行高
						endRow = startRow + (i-oldI-1);
						if(is == true) {
							//合并直属库单元格
							Region region3 = new Region(startRow, (short) 0, endRow, (short) 0);
							HSSFCell cellPLibraryName = row3.createCell(0);
							utils.setRegionStyle(sheet, region3, utils.Style2(workbook));
							sheet.addMergedRegion(region3);
							cellPLibraryName.setCellStyle(utils.Style2(workbook));
							cellPLibraryName.setCellValue(pLibraryName);
						} else {
							HSSFCell cellPLibraryName = row3.createCell(0);
							cellPLibraryName.setCellStyle(utils.Style1(workbook));
							cellPLibraryName.setCellValue(pLibraryName);
						}
					} 
				} else {
					if(i != intId.length-1) {
						if(is == true) {
							//合并直属库单元格
							Region region3 = new Region(startRow, (short) 0, endRow, (short) 0);
							HSSFCell cellPLibraryName = row3.createCell(0);
							utils.setRegionStyle(sheet, region3, utils.Style1(workbook));
							sheet.addMergedRegion(region3);
							cellPLibraryName.setCellStyle(utils.Style2(workbook));
							cellPLibraryName.setCellValue(cornExaminingReport.getpLibraryName());
						} else {
							HSSFCell cellPLibraryName = row3.createCell(0);
							cellPLibraryName.setCellStyle(utils.Style1(workbook));
							cellPLibraryName.setCellValue(cornExaminingReport.getpLibraryName());
						}
						CornExaminingReport newCornExaminingReport = icornExaminingReportDao.findBasicSituation(intId[i+1]);
						if(cornExaminingReport.getpLibraryName().equals(newCornExaminingReport.getpLibraryName())) {
							Region regionXiaoJi = new Region(endRow+1, (short) 0, endRow+1, (short) 6);
							HSSFRow rowXiaoJi = sheet.createRow(endRow+1);
							HSSFCell cellXiaoJi = rowXiaoJi.createCell(0);
							utils.setRegionStyle(sheet, regionXiaoJi, utils.Style1(workbook));
							sheet.addMergedRegion(regionXiaoJi);
							cellXiaoJi.setCellValue("小计");
							endRow = startRow + (i-oldI-1);
							
							for (int j = 8; j < 42; j++) {
								HSSFCell createCell = rowXiaoJi.createCell(j);
								createCell.setCellStyle(utils.Style1(workbook));
								createCell.setCellValue("");
							}
							
						} else {
							Region regionXiaoJi = new Region(endRow+1, (short) 0, endRow+1, (short) 6);
							HSSFRow rowXiaoJi = sheet.createRow(endRow+1);
							HSSFCell cellXiaoJi = rowXiaoJi.createCell(0);
							utils.setRegionStyle(sheet, regionXiaoJi, utils.Style1(workbook));
							sheet.addMergedRegion(regionXiaoJi);
							cellXiaoJi.setCellValue("小计");
							endRow = startRow + (i-oldI-1);
							startRow = endRow+2;
							oldI = i;
							
							for (int j = 8; j < 42; j++) {
								HSSFCell createCell = rowXiaoJi.createCell(j);
								createCell.setCellStyle(utils.Style1(workbook));
								createCell.setCellValue("");
							}
						}
						
						
					} else {
						if(is == true) {
							endRow = startRow + (i-oldI-1);
						}
						Region regionXiaoJi = new Region(endRow+1, (short) 0, endRow+1, (short) 6);
						HSSFRow rowXiaoJi = sheet.createRow(endRow+1);
						HSSFCell cellXiaoJi = rowXiaoJi.createCell(0);
						utils.setRegionStyle(sheet, regionXiaoJi, utils.Style1(workbook));
						sheet.addMergedRegion(regionXiaoJi);
						cellXiaoJi.setCellValue("小计");
						row3 = sheet.createRow(startRow + (i-oldI)+1);
						row3.setHeight((short) 300); // 行高
						
						for (int j = 8; j < 42; j++) {
							HSSFCell createCell = rowXiaoJi.createCell(j);
							createCell.setCellStyle(utils.Style1(workbook));
							createCell.setCellValue("");
						}
						if(is == true) {
							//合并直属库单元格
							Region region3 = new Region(startRow, (short) 0, endRow, (short) 0);
							HSSFCell cellPLibraryName = row3.createCell(0);
							utils.setRegionStyle(sheet, region3, utils.Style1(workbook));
							sheet.addMergedRegion(region3);
							cellPLibraryName.setCellStyle(utils.Style1(workbook));
							cellPLibraryName.setCellStyle(utils.Style2(workbook));
							cellPLibraryName.setCellValue(cornExaminingReport.getpLibraryName());
						} else {
							HSSFCell cellPLibraryName = row3.createCell(0);
							cellPLibraryName.setCellStyle(utils.Style1(workbook));
							cellPLibraryName.setCellValue(cornExaminingReport.getpLibraryName());
						}
						
					}
					isFirst = false;
					is = false;
					pLibraryName = cornExaminingReport.getpLibraryName();
				}
				HSSFCell cell6 = row3.createCell(1);
				cell6.setCellStyle(utils.Style1(workbook));
				cell6.setCellValue(i+1);
				
				HSSFCell cell7 = row3.createCell(2);
				cell7.setCellStyle(utils.Style1(workbook));
				cell7.setCellValue(cornExaminingReport.getLibraryName());
				
				HSSFCell cell8 = row3.createCell(3);
				cell8.setCellStyle(utils.Style1(workbook));
				cell8.setCellValue("监"+cornExaminingReport.getSampleNum());
				
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
				
				Region region4 = new Region(row3.getRowNum(), (short) 13, row3.getRowNum(), (short) 16);
				HSSFCell celll = row3.createCell(13);
				utils.setRegionStyle(sheet, region4, utils.Style1(workbook));
				sheet.addMergedRegion(region4);
				celll.setCellStyle(utils.Style1(workbook));
				celll.setCellValue("");
				
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
				
				//没有的字段暂时为空
				HSSFCell cellNull = row3.createCell(33);
				cellNull.setCellStyle(utils.Style1(workbook));
//				cell32.setCellValue(cornExaminingReport1.get(j).getBuwanshanlihanliang_pingjunzhi_1());
				cellNull.setCellValue("");
				
				HSSFCell cell38 = row3.createCell(38);
				cell38.setCellStyle(utils.Style1(workbook));
				cell38.setCellValue("");
				
				HSSFCell cell39 = row3.createCell(39);
				cell39.setCellStyle(utils.Style1(workbook));
				cell39.setCellValue("");
				
				HSSFCell cell40 = row3.createCell(40);
				cell40.setCellStyle(utils.Style1(workbook));
				cell40.setCellValue("");
				
				HSSFCell cell41 = row3.createCell(41);
				cell41.setCellStyle(utils.Style1(workbook));
				cell41.setCellValue("");
				
				HSSFCell cell42 = row3.createCell(42);
				cell42.setCellStyle(utils.Style1(workbook));
				cell42.setCellValue("");
				List<CornExaminingReport> cornExaminingReport1 = icornExaminingReportDao.findQualityAcceptance(intId[i]);
				for(int j=1; j<cornExaminingReport1.size(); j++) {
					int newNum = Integer.parseInt(cornExaminingReport1.get(j).getSmallSampleNum().substring(9));
					HSSFCell createCell = row3.createCell(29);
					createCell.setCellStyle(utils.Style1(workbook));
					createCell.setCellValue(cornExaminingReport1.get(j).getQualityGrade());
					
					HSSFCell createCell2 = row3.createCell(30);
					createCell2.setCellStyle(utils.Style1(workbook));
					createCell2.setCellValue(cornExaminingReport1.get(j).getRealCapacity());
					if(newNum == 04) {
						HSSFCell cell30 = row3.createCell(31);
						cell30.setCellStyle(utils.Style1(workbook));
						cell30.setCellValue(cornExaminingReport1.get(j).getShuifen_pingjunzhi());
					}
					else if(newNum == 02) {
						HSSFCell cell31 = row3.createCell(32);
						cell31.setCellStyle(utils.Style1(workbook));
						cell31.setCellValue(cornExaminingReport1.get(j).getZazhizongliang_1());
						
						HSSFCell cell32 = row3.createCell(33);
						cell32.setCellStyle(utils.Style1(workbook));
						cell32.setCellValue(cornExaminingReport1.get(j).getBuwanshanlihanliang_pingjunzhi_1());
					}
//					else if(newNum == 01) {
//						HSSFCell cell32 = row3.createCell(33);
//						cell32.setCellStyle(utils.Style1(workbook));
//						cell32.setCellValue(cornExaminingReport1.get(j).getBuwanshanlihanliang_pingjunzhi_1());
//						cell32.setCellValue("");
//					}
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
				}
			}
			String Sum = "Sum(H10:H" + (id.length + 9) + ")";
			HSSFCell cell2 = row1.createCell(7);
			cell2.setCellStyle(utils.Style1(workbook));
			cell2.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell2.setCellFormula(Sum);
//			 FileOutputStream out = new FileOutputStream("E://玉米检测报表.xls");  
//			 workbook.write(out);
			
			
			//将修改后的文件写出到D:\\excel目录下  
	        //FileOutputStream output = new FileOutputStream("D:\\辅机1.xls");
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
			e.printStackTrace();
		}  
   
	}

	/*
	 * 导出小麦
	 * 
	 */
	@Override
	public void ExeclPOI(HttpServletResponse response,String ids,String title) {
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
			sheet.createFreezePane(10,7,10,7 ); //冻结行列
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
			for (int i = 8; i < 43; i++) {
				HSSFCell createCell = row1.createCell(i);
				createCell.setCellStyle(utils.Style1(workbook));
				createCell.setCellValue("");
			}
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
			for (int i = 8; i < 43; i++) {
				HSSFCell createCell = row2.createCell(i);
				createCell.setCellStyle(utils.Style1(workbook));
				createCell.setCellValue("");
			}
			HSSFCell cell4 = row2.createCell(7);
			cell4.setCellStyle(utils.Style1(workbook));
			cell4.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell4.setCellFormula("SUM(AB9)");
						
			String pLibraryName = null;
			int startRow = 10;
			int endRow = 7;
			//是否合并
			boolean is = false;
			//是否是第一次
			boolean isFirst = false;
			//记录上一次的i值
			int oldI=0;
			String[] id = ids.split(",");
			//string[]转int[]
			int intId[] = new int[id.length];
			for(int i=0;i<id.length;i++) {
				intId[i] = Integer.parseInt(id[i]);
			}
			//冒泡排序
			for(int k=0;k<intId.length;k++) {
				for(int j=k + 1;j<intId.length;j++) {
					if(intId[k] > intId[j]) {
						int temp = intId[k];
						intId[k] = intId[j];
						intId[j] = temp;
					}
				}
			}
			for (int i = 0; i < intId.length; i++) {
				HSSFRow row3 =null;
				if(isFirst == true) {
					row3 = sheet.createRow(startRow + (i-oldI));
					row3.setHeight((short) 300); // 行高
				} else {
					row3 = sheet.createRow(startRow + (i-oldI-1));
					row3.setHeight((short) 300); // 行高
				}
				//查询基本情况
				WheatExaminingReport Wobjiect = wheatExaminingReportDao.findBasicSituation(intId[i]);
				if(pLibraryName == null || pLibraryName.equals("")) {
					pLibraryName = Wobjiect.getpLibraryName();
					HSSFCell cellPLibraryName = row3.createCell(0);
					cellPLibraryName.setCellStyle(utils.Style1(workbook));
					cellPLibraryName.setCellValue(Wobjiect.getpLibraryName());
					if(i != intId.length-1) {
						WheatExaminingReport newWobjiect = wheatExaminingReportDao.findBasicSituation(intId[i + 1]);
							if(Wobjiect.getpLibraryName().equals(newWobjiect.getpLibraryName())) {
								startRow = i+9;
								isFirst = true;
							} else {
								endRow = i+9;
								startRow=i+11;
							}
						}
				} else if(pLibraryName.equals(Wobjiect.getpLibraryName())){
					is = true;
					if(i == intId.length -1) {
						row3 = sheet.createRow(startRow + (i-oldI-1));
						row3.setHeight((short) 300); // 行高
						endRow = startRow + (i-oldI-1);
						if(is == true) {
							//合并直属库单元格
							Region region3 = new Region(startRow, (short) 0, endRow, (short) 0);
							HSSFCell cellPLibraryName = row3.createCell(0);
							utils.setRegionStyle(sheet, region3, utils.Style1(workbook));
							sheet.addMergedRegion(region3);
							cellPLibraryName.setCellStyle(utils.Style2(workbook));
							cellPLibraryName.setCellValue(pLibraryName);
						} else {
							HSSFCell cellPLibraryName = row3.createCell(0);
							cellPLibraryName.setCellStyle(utils.Style1(workbook));
							cellPLibraryName.setCellValue(pLibraryName);
						}
					} 
				} else {
					if(i != intId.length-1) {
						if(is == true) {
							//合并直属库单元格
							Region region3 = new Region(startRow, (short) 0, endRow, (short) 0);
							HSSFCell cellPLibraryName = row3.createCell(0);
							utils.setRegionStyle(sheet, region3, utils.Style1(workbook));
							sheet.addMergedRegion(region3);
							cellPLibraryName.setCellStyle(utils.Style2(workbook));
							cellPLibraryName.setCellValue(Wobjiect.getpLibraryName());
						} else {
							HSSFCell cellPLibraryName = row3.createCell(0);
							cellPLibraryName.setCellStyle(utils.Style1(workbook));
							cellPLibraryName.setCellValue(Wobjiect.getpLibraryName());
						}
						WheatExaminingReport newWobjiect = wheatExaminingReportDao.findBasicSituation(intId[i + 1]);
						if(Wobjiect.getpLibraryName().equals(newWobjiect.getpLibraryName())) {
							Region regionXiaoJi = new Region(endRow+1, (short) 0, endRow+1, (short) 6);
							HSSFRow rowXiaoJi = sheet.createRow(endRow+1);
							HSSFCell cellXiaoJi = rowXiaoJi.createCell(0);
							utils.setRegionStyle(sheet, regionXiaoJi, utils.Style1(workbook));
							sheet.addMergedRegion(regionXiaoJi);
							cellXiaoJi.setCellValue("小计");
							endRow = startRow + (i-oldI-1);
							for (int j = 8; j < 43; j++) {
								HSSFCell createCell = rowXiaoJi.createCell(j);
								createCell.setCellStyle(utils.Style1(workbook));
								createCell.setCellValue("");
							}
						} else {
							Region regionXiaoJi = new Region(endRow+1, (short) 0, endRow+1, (short) 6);
							HSSFRow rowXiaoJi = sheet.createRow(endRow+1);
							HSSFCell cellXiaoJi = rowXiaoJi.createCell(0);
							utils.setRegionStyle(sheet, regionXiaoJi, utils.Style1(workbook));
							sheet.addMergedRegion(regionXiaoJi);
							cellXiaoJi.setCellValue("小计");
							endRow = startRow + (i-oldI-1);
							startRow = endRow+2;
							oldI = i;
							for (int j = 8; j < 43; j++) {
								HSSFCell createCell = rowXiaoJi.createCell(j);
								createCell.setCellStyle(utils.Style1(workbook));
								createCell.setCellValue("");
							}
						}
						
						
					} else {
						if(is == true) {
							endRow = startRow + (i-oldI-1);
						}
						Region regionXiaoJi = new Region(endRow+1, (short) 0, endRow+1, (short) 6);
						HSSFRow rowXiaoJi = sheet.createRow(endRow+1);
						HSSFCell cellXiaoJi = rowXiaoJi.createCell(0);
						utils.setRegionStyle(sheet, regionXiaoJi, utils.Style1(workbook));
						sheet.addMergedRegion(regionXiaoJi);
						cellXiaoJi.setCellValue("小计");
						row3 = sheet.createRow(startRow + (i-oldI)+1);
						row3.setHeight((short) 300); // 行高
						for (int j = 8; j < 43; j++) {
							HSSFCell createCell = rowXiaoJi.createCell(j);
							createCell.setCellStyle(utils.Style1(workbook));
							createCell.setCellValue("");
						}
						if(is == true) {
							//合并直属库单元格
							Region region3 = new Region(startRow, (short) 0, endRow, (short) 0);
							HSSFCell cellPLibraryName = row3.createCell(0);
							utils.setRegionStyle(sheet, region3, utils.Style1(workbook));
							sheet.addMergedRegion(region3);
							cellPLibraryName.setCellStyle(utils.Style2(workbook));
							cellPLibraryName.setCellValue(Wobjiect.getpLibraryName());
						} else {
							HSSFCell cellPLibraryName = row3.createCell(0);
							cellPLibraryName.setCellStyle(utils.Style1(workbook));
							cellPLibraryName.setCellValue(Wobjiect.getpLibraryName());
						}
						
					}
					isFirst = false;
					is = false;
					pLibraryName = Wobjiect.getpLibraryName();
				}
				HSSFCell cellsum = row3.createCell(1);
				cellsum.setCellStyle(utils.Style1(workbook));
				cellsum.setCellValue(i+1);
				
				HSSFCell cell6 = row3.createCell(2);
				cell6.setCellStyle(utils.Style1(workbook));
				cell6.setCellValue(Wobjiect.getLibraryName());
				
				HSSFCell cell7 = row3.createCell(3);
				cell7.setCellStyle(utils.Style1(workbook));
				cell7.setCellValue("监"+Wobjiect.getSampleNum());
				
				HSSFCell cell8 = row3.createCell(4);
				cell8.setCellStyle(utils.Style1(workbook));
				cell8.setCellValue(Wobjiect.getSampleNo());
				
				HSSFCell cell9 = row3.createCell(5);
				cell9.setCellStyle(utils.Style1(workbook));
				cell8.setCellValue(Wobjiect.getPosition());
				
				HSSFCell cell10 = row3.createCell(6);
				cell10.setCellStyle(utils.Style1(workbook));
				cell10.setCellValue(Wobjiect.getSort());
				
				HSSFCell cell11 = row3.createCell(7);
				cell11.setCellStyle(utils.Style1(workbook));
				cell11.setCellValue(Double.valueOf(Wobjiect.getAmount()));
				
				HSSFCell cell12 = row3.createCell(8);
				cell12.setCellStyle(utils.Style1(workbook));
				cell12.setCellValue(Wobjiect.getGainTime());
				
				HSSFCell cell13 = row3.createCell(9);
				cell13.setCellStyle(utils.Style1(workbook));
				cell13.setCellValue(Wobjiect.getStorageTime());
				
				HSSFCell createCell = row3.createCell(10);
				createCell.setCellStyle(utils.Style1(workbook));
				createCell.setCellValue(Wobjiect.getCheckApplyTime());
				
				HSSFCell createCell1 = row3.createCell(11);
				createCell1.setCellStyle(utils.Style1(workbook));
				createCell1.setCellValue(Wobjiect.getAssignMissionTime());
				
				HSSFCell cell14 = row3.createCell(12);
				cell14.setCellStyle(utils.Style1(workbook));
				cell14.setCellValue(Wobjiect.getSampleTime());
				
				Region region5 = new Region(row3.getRowNum(), (short) 13, row3.getRowNum(), (short) 15);
				HSSFCell createCell2 = row3.createCell(13);
				utils.setRegionStyle(sheet, region5, utils.Style1(workbook));
				sheet.addMergedRegion(region5);
				createCell2.setCellStyle(utils.Style1(workbook));
				createCell2.setCellValue("");
				
				HSSFCell cell15 = row3.createCell(16);
				cell15.setCellStyle(utils.Style1(workbook));
				cell15.setCellValue(Wobjiect.getRemark());
				
				HSSFCell cell16 = row3.createCell(17);
				cell16.setCellStyle(utils.Style1(workbook));
				cell16.setCellValue(Wobjiect.getLength());
				
				HSSFCell cell17 = row3.createCell(18);
				cell17.setCellStyle(utils.Style1(workbook));
				cell17.setCellValue(Wobjiect.getWide());
				
				HSSFCell cell18 = row3.createCell(19);
				cell18.setCellStyle(utils.Style1(workbook));
				cell18.setCellValue(Wobjiect.getHigh());
				
				HSSFCell cell19 = row3.createCell(20);
				cell19.setCellStyle(utils.Style1(workbook));
				cell19.setCellValue(Wobjiect.getDeductVolume());
				
				HSSFCell cell20 = row3.createCell(21);
				cell20.setCellStyle(utils.Style1(workbook));
				cell20.setCellValue(Wobjiect.getRealVolume());
				
				HSSFCell cell21 = row3.createCell(22);
				cell21.setCellStyle(utils.Style1(workbook));
				cell21.setCellValue(Wobjiect.getRealCapacity());
				
				HSSFCell cell22 = row3.createCell(23);
				cell22.setCellStyle(utils.Style1(workbook));
				cell22.setCellValue(Wobjiect.getCorrectioFactor());
				
				HSSFCell cell23 = row3.createCell(24);
				cell23.setCellStyle(utils.Style1(workbook));
				cell23.setCellValue(Wobjiect.getAveDensity());
				
				HSSFCell cell24 = row3.createCell(25);
				cell24.setCellStyle(utils.Style1(workbook));
				cell24.setCellValue(Wobjiect.getUnQuality());
				
				HSSFCell cell25 = row3.createCell(26);
				cell25.setCellStyle(utils.Style1(workbook));
				cell25.setCellValue(Wobjiect.getGrainQuality());
				
				HSSFCell cell26 = row3.createCell(27);
				cell26.setCellStyle(utils.Style1(workbook));
				cell26.setCellValue(Wobjiect.getSlip());
				
				HSSFCell cell39 = row3.createCell(39);
				cell39.setCellStyle(utils.Style1(workbook));
				cell39.setCellValue("");
				
				HSSFCell cell40 = row3.createCell(40);
				cell40.setCellStyle(utils.Style1(workbook));
				cell40.setCellValue("");
				
				HSSFCell cell41 = row3.createCell(41);
				cell41.setCellStyle(utils.Style1(workbook));
				cell41.setCellValue("");
				
				//查询质量验收情况（根据小样编号
				List<WheatExaminingReport> Wobjiect1 = wheatExaminingReportDao.findQualityAcceptance(intId[i]);
				for(int j=0; j<Wobjiect1.size(); j++) {
					int newNum = Integer.parseInt(Wobjiect1.get(j).getSmallSampleNum().substring(9));
					HSSFCell cell27 = row3.createCell(28);
					cell27.setCellStyle(utils.Style1(workbook));
					cell27.setCellValue(Wobjiect1.get(j).getQualityGrade());
					
					HSSFCell cell28 = row3.createCell(29);
					cell28.setCellStyle(utils.Style1(workbook));
					cell28.setCellValue(Wobjiect1.get(j).getRealCapacity());
					
					if(newNum == 4) {
						HSSFCell cell29 = row3.createCell(30);
						cell29.setCellStyle(utils.Style1(workbook));
						cell29.setCellValue(Wobjiect1.get(j).getShuifen_pingjunzhi());
					}
					else if(newNum == 2) {
						HSSFCell cell30 = row3.createCell(31);
						cell30.setCellStyle(utils.Style1(workbook));
						cell30.setCellValue(Wobjiect1.get(j).getZazhizongliang_1());
						
						HSSFCell cell31 = row3.createCell(32);
						cell31.setCellStyle(utils.Style1(workbook));
						cell31.setCellValue(Wobjiect1.get(j).getKuangwuzhihanliang_pingjunzhi());
						
						HSSFCell cell32 = row3.createCell(33);
						cell32.setCellStyle(utils.Style1(workbook));
						cell32.setCellValue(Wobjiect1.get(j).getBuwanshanlihanliang_pingjunzhi_1());
					}
					else if(newNum == 5) {
						HSSFCell cell33 = row3.createCell(34);
						cell33.setCellStyle(utils.Style1(workbook));
						cell33.setCellValue(Wobjiect1.get(j).getYingduzhishu_pingjunzhi());
						
						HSSFCell cell34 = row3.createCell(35);
						cell34.setCellStyle(utils.Style1(workbook));
						cell34.setCellValue(Wobjiect1.get(j).getSezeqiwei_pingjunzhi());
					}
					else if(newNum == 6) {
						HSSFCell cell35 = row3.createCell(36);
						cell35.setCellStyle(utils.Style1(workbook));
						cell35.setCellValue(Wobjiect1.get(j).getPingjunzhiganmianjinzhiliang());
					    
						HSSFCell cell36 = row3.createCell(37);
						cell36.setCellStyle(utils.Style1(workbook));
						cell36.setCellValue(Wobjiect1.get(j).getShimianjin_pingjunzhi());
					}
					else if(newNum == 7) {
						HSSFCell cell37 = row3.createCell(38);
						cell37.setCellStyle(utils.Style1(workbook));
						cell37.setCellValue(Wobjiect1.get(j).getPinchangpingfenzhi());
					}
				}
			}
			String Sum = "Sum(H10:H" + (id.length + 9) + ")";
			HSSFCell cellAA = row1.createCell(7);
			cellAA.setCellStyle(utils.Style1(workbook));
			cellAA.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cellAA.setCellFormula(Sum);
//			FileOutputStream out = new FileOutputStream("E://小麦检测报表.xls");  
//			workbook.write(out);
			
			//将修改后的文件写出到D:\\excel目录下  
	        //FileOutputStream output = new FileOutputStream("D:\\辅机1.xls");
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
			}catch (Exception e) {
				e.printStackTrace();
			}		
	}
	
	
	/*
	 * 导出小麦质量验收情况表
	 * 
	 */
	public  void ExportXMzhiliang(HttpServletResponse response,String ids,String title) { {
		//传入的文件  
        FileInputStream fileInput;
        POIUtils utils = new POIUtils();
		try {
			fileInput = new FileInputStream("upload/base/小麦质量验收情况表.xls");
			//poi包下的类读取excel文件  
			POIFSFileSystem ts = new POIFSFileSystem(fileInput);  
			// 创建一个webbook，对应一个Excel文件            
			HSSFWorkbook workbook = new HSSFWorkbook(ts);  
			//对应Excel文件中的sheet，0代表第一个             
			HSSFSheet sh = workbook.getSheetAt(0);  
//			 HSSFRow row = sh.createRow(8);
//			 row.createCell(0).setCellValue("bb");
//			 sh.getRow(9).getCell(2).setCellValue("xx");
//			 sh.getRow(9).getCell(3).setCellValue("xx");
//			 sh.getRow(9).getCell(4).setCellValue("x");
//			 sh.getRow(9).getCell(5).setCellValue("xx");
			 
			 List<WheatExaminingReport> Wobjiect1 = wheatExaminingReportDao.findQualityAcceptance(Integer.parseInt(ids));
				
				for(int j=0; j<Wobjiect1.size(); j++) {
				    HSSFRow row = sh.createRow(8+j);
				    row.setHeight((short) 300); // 行高
					int newNum = Integer.parseInt(Wobjiect1.get(j).getSmallSampleNum().substring(9));
					HSSFCell cell1 = row.createCell(0);
					cell1.setCellStyle(utils.Style1(workbook));
					cell1.setCellValue(Wobjiect1.get(j).getTaskName());
					
					HSSFCell cell2 = row.createCell(1);
					cell2.setCellStyle(utils.Style1(workbook));
					cell2.setCellValue("监" + Wobjiect1.get(j).getSampleNum());
					
					HSSFCell cell3 = row.createCell(2);
					cell3.setCellStyle(utils.Style1(workbook));
					cell3.setCellValue(Wobjiect1.get(j).getQualityGrade());
					
					HSSFCell cell4 = row.createCell(3);
					cell4.setCellStyle(utils.Style1(workbook));
					cell4.setCellValue(Wobjiect1.get(j).getRealCapacity());
					
					if(newNum == 4) {
						HSSFCell cell5 = row.createCell(4);
						cell5.setCellStyle(utils.Style1(workbook));
						cell5.setCellValue(Wobjiect1.get(j).getShuifen_pingjunzhi());
					}
					else if(newNum == 1) {
						HSSFCell cell6 = row.createCell(5);
						cell6.setCellStyle(utils.Style1(workbook));
						cell6.setCellValue(Wobjiect1.get(j).getZazhizongliang_1());
						
						HSSFCell cell7 = row.createCell(6);
						cell7.setCellStyle(utils.Style1(workbook));
						cell7.setCellValue(Wobjiect1.get(j).getKuangwuzhihanliang_pingjunzhi());
						
						HSSFCell cell8 = row.createCell(7);
						cell8.setCellStyle(utils.Style1(workbook));
						cell8.setCellValue(Wobjiect1.get(j).getBuwanshanlihanliang_pingjunzhi_1());
					}
					else if(newNum == 5) {
						HSSFCell cell9 = row.createCell(8);
						cell9.setCellStyle(utils.Style1(workbook));
						cell9.setCellValue(Wobjiect1.get(j).getYingduzhishu_pingjunzhi());
						
						HSSFCell cell10 = row.createCell(9);
						cell10.setCellStyle(utils.Style1(workbook));
						cell10.setCellValue(Wobjiect1.get(j).getSezeqiwei_pingjunzhi());
					}
					else if(newNum == 6) {
						HSSFCell cell12 = row.createCell(11);
						cell12.setCellStyle(utils.Style1(workbook));
						cell12.setCellValue(Wobjiect1.get(j).getPingjunzhiganmianjinzhiliang());
					    
						HSSFCell cell13 = row.createCell(12);
						cell13.setCellStyle(utils.Style1(workbook));
						cell13.setCellValue(Wobjiect1.get(j).getShimianjin_pingjunzhi());
					}
					else if(newNum == 7) {
						HSSFCell cell14 = row.createCell(13);
						cell14.setCellStyle(utils.Style1(workbook));
						cell14.setCellValue(Wobjiect1.get(j).getPinchangpingfenzhi());
					}
					HSSFCell cell11 = row.createCell(10);
					cell11.setCellStyle(utils.Style1(workbook));
					cell11.setCellValue("");
					
					HSSFCell cell15 = row.createCell(14);
					cell15.setCellStyle(utils.Style1(workbook));
					cell15.setCellValue("");
					
					HSSFCell cell16 = row.createCell(15);
					cell16.setCellStyle(utils.Style1(workbook));
					cell16.setCellValue("");
				}

//			 FileOutputStream out = new FileOutputStream("E://小麦质量.xls");  
//			 workbook.write(out);
			//将修改后的文件写出到D:\\excel目录下  
	        //FileOutputStream output = new FileOutputStream("D:\\辅机1.xls");
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
			e.printStackTrace();
		}  
   
	}
	}
	
	
	
	/*
	 * 导出玉米质量验收情况表
	 * 
	 */
	public  void ExportYMzhiliang(HttpServletResponse response,String ids,String title) { {
		//传入的文件  
        FileInputStream fileInput;
        POIUtils utils = new POIUtils();
		try {
			fileInput = new FileInputStream("upload/base/玉米质量验收情况表.xls");
			//poi包下的类读取excel文件  
			POIFSFileSystem ts = new POIFSFileSystem(fileInput);  
			// 创建一个webbook，对应一个Excel文件            
			HSSFWorkbook workbook = new HSSFWorkbook(ts);  
			//对应Excel文件中的sheet，0代表第一个             
			HSSFSheet sh = workbook.getSheetAt(0);  
//			 HSSFRow row = sh.createRow(8);
//			 row.createCell(0).setCellValue("bb");
//			 sh.getRow(9).getCell(2).setCellValue("xx");
//			 sh.getRow(9).getCell(3).setCellValue("xx");
//			 sh.getRow(9).getCell(4).setCellValue("x");
//			 sh.getRow(9).getCell(5).setCellValue("xx");
			 
		
		List<CornExaminingReport> cornExaminingReport1 = icornExaminingReportDao.findQualityAcceptance(Integer.parseInt(ids));
		for(int j=0; j<cornExaminingReport1.size(); j++) {
			HSSFRow row = sh.createRow(8+j);
			row.setHeight((short) 300); // 行高
			int newNum = Integer.parseInt(cornExaminingReport1.get(j).getSmallSampleNum().substring(9));
			HSSFCell createCell = row.createCell(0);
			createCell.setCellStyle(utils.Style1(workbook));
			createCell.setCellValue(cornExaminingReport1.get(j).getTaskName());
			
			HSSFCell createCell2 = row.createCell(1);
			createCell2.setCellStyle(utils.Style1(workbook));
			createCell2.setCellValue("监" + cornExaminingReport1.get(j).getSampleNum());
			
			HSSFCell createCell3 = row.createCell(2);
			createCell3.setCellStyle(utils.Style1(workbook));
			createCell3.setCellValue(cornExaminingReport1.get(j).getQualityGrade());
			
			HSSFCell createCell4 = row.createCell(3);
			createCell4.setCellStyle(utils.Style1(workbook));
			createCell4.setCellValue(cornExaminingReport1.get(j).getRealCapacity());
			if(newNum == 04) {
				HSSFCell cell1 = row.createCell(4);
				cell1.setCellStyle(utils.Style1(workbook));
				cell1.setCellValue(cornExaminingReport1.get(j).getShuifen_pingjunzhi());
			}
			else if(newNum == 02) {
				HSSFCell cell2 = row.createCell(5);
				cell2.setCellStyle(utils.Style1(workbook));
				cell2.setCellValue(cornExaminingReport1.get(j).getZazhizongliang_1());
			}
			else if(newNum == 01) {
				HSSFCell cell3 = row.createCell(6);
				cell3.setCellStyle(utils.Style1(workbook));
				cell3.setCellValue(cornExaminingReport1.get(j).getBuwanshanlihanliang_pingjunzhi_1());
				
			}
			else if(newNum == 03) {
				HSSFCell cell4 = row.createCell(7);
				cell4.setCellStyle(utils.Style1(workbook));
				cell4.setCellValue(cornExaminingReport1.get(j).getShengmeilihanliang_pingjunzhi());
			}
			else if(newNum == 05) {
				HSSFCell cell5 = row.createCell(8);
				cell5.setCellStyle(utils.Style1(workbook));
				cell5.setCellValue(cornExaminingReport1.get(j).getSezeqiwei_pingjunzhi());
			}
			else if(newNum == 06) {
				HSSFCell cell6 = row.createCell(10);
				cell6.setCellStyle(utils.Style1(workbook));
				cell6.setCellValue(cornExaminingReport1.get(j).getZhifangsuanzhi_pingjunzhi());
			}
			else if(newNum == 07) {
				HSSFCell cell7 = row.createCell(11);
				cell7.setCellStyle(utils.Style1(workbook));
				cell7.setCellValue(cornExaminingReport1.get(j).getPinchangpingfenzhi());
			}
			HSSFCell cell12 = row.createCell(9);
			cell12.setCellStyle(utils.Style1(workbook));
			cell12.setCellValue("");
			
			HSSFCell cell13 = row.createCell(12);
			cell13.setCellStyle(utils.Style1(workbook));
			cell13.setCellValue("");
			
			HSSFCell cell14 = row.createCell(13);
			cell14.setCellStyle(utils.Style1(workbook));
			cell14.setCellValue("");
		}
   
//		FileOutputStream out = new FileOutputStream("E://玉米质量.xls");  
//		 workbook.write(out);
		//将修改后的文件写出到D:\\excel目录下  
        //FileOutputStream output = new FileOutputStream("D:\\辅机1.xls");
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
		e.printStackTrace();
	}  
	}
	}

	@Override
	public NumberDTO findAllCereals() {
		// TODO Auto-generated method stub
		return ((ISampleDao)dao).findAllCereals();
	}
}




