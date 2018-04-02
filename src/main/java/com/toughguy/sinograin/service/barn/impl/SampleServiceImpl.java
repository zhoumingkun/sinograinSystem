package com.toughguy.sinograin.service.barn.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
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
	public Boolean result(String sampleNums,String smallSamples) {
		POIUtils utils = new POIUtils();
		HSSFWorkbook wb = new HSSFWorkbook(); // 创建工作簿
		HSSFSheet sheet = wb.createSheet("汇总表"); // 工作簿名称

		sheet.autoSizeColumn(0);    //自动换行
		// ----------------------------------------------
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 43));
		HSSFRow row = sheet.createRow(0);
		row.setHeight((short) 800); // 行高
		HSSFCell cell = row.createCell(0);
		cell.setCellStyle(utils.Style(wb));
		cell.setCellValue("中央储备粮轮换验收申请统计表（2016年度）");
		
		sheet.createFreezePane(10,0,10,0);//冻结
		// ----------创建第一行
		// 合并单元格
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 9));
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 10, 17));
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 18, 28));
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 29, 40));
		HSSFRow row1 = sheet.createRow(1);
		row1.setHeight((short) 600); // 行高
		HSSFCell cell1 = row1.createCell(0);
		cell1.setCellStyle(utils.StyleOne(wb));
		cell1.setCellValue("基本情况");

		HSSFCell cell2 = row1.createCell(10);
		cell2.setCellStyle(utils.StyleTwo(wb));
		cell2.setCellValue("扦样检查情况");

		HSSFCell cell3 = row1.createCell(18);
		cell3.setCellStyle(utils.StyleThree(wb));
		cell3.setCellValue("数量验收情况");

		HSSFCell cell4 = row1.createCell(29);
		cell4.setCellStyle(utils.StyleFour(wb));
		cell4.setCellValue("质量验收情况");

		// ----------创建列头
		sheet.autoSizeColumn(0);
		for (int i = 0; i < 29; i++) {
			if(i < 13){
				sheet.addMergedRegion(new CellRangeAddress(2, 5, i, i));
			}else if(i == 13){
				sheet.addMergedRegion(new CellRangeAddress(2, 5, i, i+3));
			}else{
				sheet.addMergedRegion(new CellRangeAddress(2, 5, i, i));
			}
		}
		
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 29, 36));
		sheet.addMergedRegion(new CellRangeAddress(3, 5, 29, 29));
		sheet.addMergedRegion(new CellRangeAddress(3, 3, 30, 35));
		sheet.addMergedRegion(new CellRangeAddress(4, 5, 30, 30));
		sheet.addMergedRegion(new CellRangeAddress(4, 5, 31, 31));
		sheet.addMergedRegion(new CellRangeAddress(4, 5, 32, 32));
		
		sheet.addMergedRegion(new CellRangeAddress(5, 5, 33, 33)); 
		sheet.addMergedRegion(new CellRangeAddress(5, 5, 34, 34));
		sheet.addMergedRegion(new CellRangeAddress(4,4, 33, 34));
//		sheet.addMergedRegion(new CellRangeAddress(5, 5, 32, 32)); 33
		sheet.addMergedRegion(new CellRangeAddress(4, 5, 35, 35));
		sheet.addMergedRegion(new CellRangeAddress(4, 5, 36, 36));
		
		sheet.addMergedRegion(new CellRangeAddress(3, 5, 36, 36));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 37, 40));
		sheet.addMergedRegion(new CellRangeAddress(3, 3, 37, 39));
		sheet.addMergedRegion(new CellRangeAddress(4, 5, 37, 37));
		sheet.addMergedRegion(new CellRangeAddress(4, 5, 38, 38));
		sheet.addMergedRegion(new CellRangeAddress(4, 5, 39, 39));
		sheet.addMergedRegion(new CellRangeAddress(3, 5, 40, 40));
		sheet.addMergedRegion(new CellRangeAddress(1, 5, 41, 41));
//		sheet.addMergedRegion(new CellRangeAddress(1, 1, 7, 7));
		
		HSSFRow row2 = sheet.createRow(2);
		row2.setHeight((short) 500); // 行高
		String[] column = {
			 "单位","序号","储存库点名称","检验编号","扦样编号","仓号","品种","数量","生产年份","入库时间",
			 "验收申请时间","任务下达时间","扦样时间","扦样人","备注",
			 "长度","宽度","高度","扣除体积","粮堆实际体积","容重","修正系数","平均密度","测量计算数","保管账数量","差率",
			 "质量情况"
		};
		for (int i = 0; i < 30; i++) {
			if(i < 10){
				HSSFCell row2cell1 = row2.createCell(i);
				row2cell1.setCellStyle(utils.StyleOne1(wb));
				row2cell1.setCellValue(column[i]);
			}
			else if(i < 14 && i > 9){
				HSSFCell row2cell1 = row2.createCell(i);
				row2cell1.setCellStyle(utils.StyleTwo1(wb));
				row2cell1.setCellValue(column[i]);
			}
			
			else if(i == 17){
				HSSFCell row2cell1 = row2.createCell(i);
				row2cell1.setCellStyle(utils.StyleTwo1(wb));
				row2cell1.setCellValue(column[i-3]);
			}
			else if(i < 29 && i > 17){
				HSSFCell row2cell1 = row2.createCell(i);
				row2cell1.setCellStyle(utils.StyleThree1(wb));
				row2cell1.setCellValue(column[i-3]);
			}
			else if(i == 29){
				HSSFCell row2cell1 = row2.createCell(i);
				row2cell1.setCellStyle(utils.StyleFour1(wb));
				row2cell1.setCellValue(column[i-3]);
			}
			
			
		}
		
		HSSFRow row3 = sheet.createRow(3);
		row3.setHeight((short) 500); // 行高
		HSSFCell row2cell28 = row3.createCell(29);
		row2cell28.setCellStyle(utils.StyleFour1(wb));
		row2cell28.setCellValue("等级");

		HSSFCell row2cell29 = row3.createCell(30);
		row2cell29.setCellStyle(utils.StyleFour1(wb));
		row2cell29.setCellValue("质量指标");

		HSSFRow row4 = sheet.createRow(4);
		row4.setHeight((short) 500); // 行高

		String[] ss ={"容重","水分","杂质"}; 
		for (int i = 30; i < 33; i++) {
			if(i < 33){
				HSSFCell row2cell30 = row4.createCell(i);
				row2cell30.setCellStyle(utils.StyleFour1(wb));
				row2cell30.setCellValue(ss[i-30]);
			}
			
		}

	
		HSSFRow row5 = sheet.createRow(5);
		row5.setHeight((short) 500); // 行高
		
		String[] vv = {"总量","其中：生霉粒"};
		for (int i = 33; i < 35; i++) {
			HSSFCell row2cell34 = row5.createCell(i);
			row2cell34.setCellStyle(utils.StyleFour1(wb));
			row2cell34.setCellValue(vv[i-33]);

		}
	
		HSSFCell row2cell35 = row4.createCell(33);
		row2cell35.setCellStyle(utils.StyleFour1(wb));
		row2cell35.setCellValue("不完善粒");
		
		
		HSSFCell row2cell36 = row4.createCell(35);
		row2cell36.setCellStyle(utils.StyleFour1(wb));
		row2cell36.setCellValue("色泽气味");
		
		/*String[] AA ={"不完善粒","色泽气味"};
		for (int i = 33; i < 36; i++) {
			HSSFCell row2cell35 = row4.createCell(i);
			row2cell35.setCellStyle(utils.StyleFour1());
			row2cell35.setCellValue(AA[i-34]);
		}*/

		HSSFCell row2cell38 = row3.createCell(36);
		row2cell38.setCellStyle(utils.StyleFour1(wb));
		row2cell38.setCellValue("结果判定");

		HSSFCell row2cell39 = row2.createCell(37);
		row2cell39.setCellStyle(utils.StyleFour1(wb));
		row2cell39.setCellValue("储存品质情况");
		// ---
		HSSFCell row2cell40 = row3.createCell(37);
		row2cell40.setCellStyle(utils.StyleFour1(wb));
		row2cell40.setCellValue("储存品质指标");

		HSSFCell row2cell41 = row4.createCell(37);
		row2cell41.setCellStyle(utils.StyleFour1(wb));
		row2cell41.setCellValue("脂肪酸值");

		HSSFCell row2cell42 = row4.createCell(38);
		row2cell42.setCellStyle(utils.StyleFour1(wb));
		row2cell42.setCellValue("品尝评分值");

		HSSFCell row2cell43 = row4.createCell(39);
		row2cell43.setCellStyle(utils.StyleFour1(wb));
		row2cell43.setCellValue("色泽气味");

//		HSSFCell row2cell44 = row4.createCell(41);
//		row2cell44.setCellStyle(utils.StyleFour1());
//		row2cell44.setCellValue("色泽气味");

		HSSFCell row2cell44 = row3.createCell(40);
		row2cell44.setCellStyle(utils.StyleFour1(wb));
		row2cell44.setCellValue("结果判定");

		HSSFCell row2cell46 = row1.createCell(41);
		row2cell46.setCellStyle(utils.StyleFour1(wb));
		row2cell46.setCellValue("备注");

		
		sheet.addMergedRegion(new CellRangeAddress(6, 6, 0, 6));
		HSSFRow row6 = sheet.createRow(6);
		row6.setHeight((short) 500); // 行高
		
		HSSFCell row2cell47 = row6.createCell(0);
		row2cell47.setCellStyle(utils.Style(wb));
		row2cell47.setCellValue("合计");
		
		sheet.addMergedRegion(new CellRangeAddress(6, 6, 8,8));
		HSSFCell row2cell48 = row6.createCell(6);
		
//		row2cell48.setCellValue("5");
		row2cell48.setCellType(HSSFCell.CELL_TYPE_FORMULA);
		row2cell48.setCellFormula("SUM(H8,H9) "); 
		
		HSSFRow row7 = sheet.createRow(7);
		String[] sampleNum = sampleNums.split(",");
		for (int i = 0; i < sampleNum.length; i++) {
			CornExaminingReport cornExaminingReport = icornExaminingReportDao.findReportAll(sampleNum[i]);
			row7.createCell(0).setCellValue(cornExaminingReport.getpLibraryName());
			row7.createCell(1).setCellValue(cornExaminingReport.getLibraryName());
			row7.createCell(2).setCellValue(cornExaminingReport.getSampleNum());
			row7.createCell(3).setCellValue(cornExaminingReport.getSampleNo());
			row7.createCell(4).setCellValue(cornExaminingReport.getPosition());
			row7.createCell(5).setCellValue(cornExaminingReport.getSort());
			row7.createCell(6).setCellValue(cornExaminingReport.getAmount());
			row7.createCell(7).setCellValue(cornExaminingReport.getGainTime());
			row7.createCell(8).setCellValue(cornExaminingReport.getStorageTime());
			row7.createCell(9).setCellValue(cornExaminingReport.getSampleTime());
			row7.createCell(10).setCellValue(cornExaminingReport.getLength());
			row7.createCell(11).setCellValue(cornExaminingReport.getWide());
			row7.createCell(12).setCellValue(cornExaminingReport.getHigh());
			row7.createCell(13).setCellValue(cornExaminingReport.getDeductVolume());
			row7.createCell(14).setCellValue(cornExaminingReport.getRealVolume());
			row7.createCell(15).setCellValue(cornExaminingReport.getRealCapacity());
			row7.createCell(16).setCellValue(cornExaminingReport.getCorrectioFactor());
			row7.createCell(17).setCellValue(cornExaminingReport.getAveDensity());
			row7.createCell(18).setCellValue(cornExaminingReport.getUnQuality());
			row7.createCell(19).setCellValue(cornExaminingReport.getGrainQuality());
			row7.createCell(20).setCellValue(cornExaminingReport.getSlip());
		}
		
		   
		   String[] smallSample = smallSamples.split(",");
		   for (int i = 0; i < smallSample.length; i++) {
			   CornExaminingReport cornExaminingReport = icornExaminingReportDao.findReportAllBysmall(smallSample[i]);
			row7.createCell(21).setCellValue(cornExaminingReport.getQualityGrade());
			row7.createCell(22).setCellValue(cornExaminingReport.getShuifen_pingjunzhi());
			row7.createCell(23).setCellValue(cornExaminingReport.getZazhizongliang_1());
			row7.createCell(24).setCellValue(cornExaminingReport.getBuwanshanlihanliang_pingjunzhi_1());
			row7.createCell(25).setCellValue(cornExaminingReport.getShengmeilihanliang_pingjunzhi());
			row7.createCell(26).setCellValue(cornExaminingReport.getSezeqiwei_pingjunzhi());
			row7.createCell(27).setCellValue(cornExaminingReport.getZhifangsuanzhi_pingjunzhi());
			row7.createCell(28).setCellValue(cornExaminingReport.getPinchangpingfenzhi());
			
		}
		   
		   try {
				FileOutputStream out = new FileOutputStream("E://student2.xls");  
				wb.write(out);
				return true;
			} catch (IOException e) {
				return false;
			}  
		

	}

	/*
	 * 导出小麦
	 * 
	 */
	@Override
	public void ExeclPOI(String sampleNums,String smallSampleNums) {
		POIUtils utils = new POIUtils();
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		HSSFWorkbook wb = new HSSFWorkbook(); // 创建工作簿
		HSSFSheet sheet =sheet(wb);
//------------0行--		
		HSSFRow row = sheet.createRow(0);
		row.setHeight((short) 800); // 行高
		
		HSSFCell cell = row.createCell(0);
		cell.setCellStyle(utils.Style(wb));
		cell.setCellValue(ParamUtils.heard);
// ----------1行------
		HSSFRow row1 = sheet.createRow(1);
		row1.setHeight((short) 600); // 行高
		
		HSSFCell cell1 = row1.createCell(0);
		cell1.setCellStyle(utils.StyleOne(wb));
		cell1.setCellValue(ParamUtils.heardText[0]);

		HSSFCell cell2 = row1.createCell(10);
		cell2.setCellStyle(utils.StyleTwo(wb));
		cell2.setCellValue(ParamUtils.heardText[1]);

		HSSFCell cell3 = row1.createCell(18);
		cell3.setCellStyle(utils.StyleThree(wb));
		cell3.setCellValue(ParamUtils.heardText[2]);

		HSSFCell cell4 = row1.createCell(29);
		cell4.setCellStyle(utils.StyleFour(wb));
		cell4.setCellValue(ParamUtils.heardText[3]);
//-------2行----
		HSSFRow row2 = sheet.createRow(2);
		row2.setHeight((short) 500); // 行高
		
		for (int i = 0; i < 30; i++) {
			if(i < 10){
				HSSFCell row2cell1 = row2.createCell(i);
				row2cell1.setCellStyle(utils.StyleOne1(wb));
				row2cell1.setCellValue(ParamUtils.column[i]);
			}
			else if(i < 14 && i > 9){
				HSSFCell row2cell1 = row2.createCell(i);
				row2cell1.setCellStyle(utils.StyleTwo1(wb));
				row2cell1.setCellValue(ParamUtils.column[i]);
			}
			else if(i == 17){
				HSSFCell row2cell1 = row2.createCell(i);
				row2cell1.setCellStyle(utils.StyleTwo1(wb));
				row2cell1.setCellValue(ParamUtils.column[i-3]);
			}
			else if(i < 29 && i > 17){
				HSSFCell row2cell1 = row2.createCell(i);
				row2cell1.setCellStyle(utils.StyleThree1(wb));
				row2cell1.setCellValue(ParamUtils.column[i-3]);
			}
			else if(i == 29){
				HSSFCell row2cell1 = row2.createCell(i);
				row2cell1.setCellStyle(utils.StyleFour1(wb));
				row2cell1.setCellValue(ParamUtils.column[i-3]);
			}
		}
//-------3行
		HSSFRow row3 = sheet.createRow(3);
		row3.setHeight((short) 500); // 行高
		
		HSSFRow row4 = sheet.createRow(4);
		row4.setHeight((short) 500); // 行高
		
		HSSFRow row5 = sheet.createRow(5);
		row5.setHeight((short) 500); // 行高
		
		HSSFRow row6 = sheet.createRow(6);
		
		HSSFRow row7 = sheet.createRow(7);
		
		for (int i = 29; i < 40; i++) {
			if(i < 31){
				HSSFCell  row2cell= row3.createCell(i);
				row2cell.setCellStyle(utils.StyleFour1(wb));
				row2cell.setCellValue(ParamUtils.content[i-29]);
			}
			else if( i > 30 && i < 34){
				HSSFCell row4cell = row4.createCell(i-1);
				row4cell.setCellStyle(utils.StyleFour1(wb));
				row4cell.setCellValue(ParamUtils.content[i-29]);
			}
			else if( i > 33 && i < 36){
				HSSFCell row2cell33 = row5.createCell(i-2);
				row2cell33.setCellStyle(utils.StyleFour1(wb));
				row2cell33.setCellValue(ParamUtils.content[i-29]);
			}
			else if(i > 35 && i < 39){
				HSSFCell row2cell35 = row4.createCell(i-2);
				row2cell35.setCellStyle(utils.StyleFour1(wb));
				row2cell35.setCellValue(ParamUtils.content[i-29]);
			}
		}
	
		HSSFCell row3cell38 = row3.createCell(37);
		row3cell38.setCellStyle(utils.StyleFour1(wb));
		row3cell38.setCellValue(ParamUtils.text[0]);

		HSSFCell row3cell39 = row2.createCell(38);
		row3cell39.setCellStyle(utils.StyleFour1(wb));
		row3cell39.setCellValue(ParamUtils.text[1]);
		// ---
		HSSFCell row3cell40 = row3.createCell(38);
		row3cell40.setCellStyle(utils.StyleFour1(wb));
		row3cell40.setCellValue(ParamUtils.text[2]);

		for (int i = 38; i < 42; i++) {
			HSSFCell row4cell = row4.createCell(i);
			row4cell.setCellStyle(utils.StyleFour1(wb));
			row4cell.setCellValue(ParamUtils.text[i-35]);
		}
		HSSFCell row2cell45 = row3.createCell(42);
		row2cell45.setCellStyle(utils.StyleFour1(wb));
		row2cell45.setCellValue(ParamUtils.text[7]);

		HSSFCell row2cell46 = row1.createCell(43);
		row2cell46.setCellStyle(utils.StyleFour1(wb));
		row2cell46.setCellValue(ParamUtils.text[8]);
		
		HSSFCell row6cell = row6.createCell(0);
		row6cell.setCellValue("合计");
		
		HSSFCell row6cell1 = row6.createCell(7);
		row6cell1.setCellType(HSSFCell.CELL_TYPE_FORMULA);
		row6cell1.setCellFormula("SUM(H8,H9,H10)");

		String[] sampleNum = sampleNums.split(",");
		for (int i = 0; i < sampleNum.length; i++) {
			//查询基本情况
			WheatExaminingReport Wobjiect = wheatExaminingReportDao.findBasicSituation(sampleNum[i]);
			row7.createCell(0).setCellValue(Wobjiect.getpLibraryName());
			row7.createCell(1).setCellValue(Wobjiect.getLibraryName());
			row7.createCell(2).setCellValue(Wobjiect.getSampleNum());
			row7.createCell(3).setCellValue(Wobjiect.getSampleNo());
			row7.createCell(4).setCellValue(Wobjiect.getPosition());
			row7.createCell(5).setCellValue(Wobjiect.getStorageTime());
			row7.createCell(6).setCellValue(Wobjiect.getAmount());
			row7.createCell(7).setCellValue(Wobjiect.getGainTime());
			row7.createCell(8).setCellValue(Wobjiect.getStorageTime());
			row7.createCell(9).setCellValue(Wobjiect.getSampleTime());
			row7.createCell(10).setCellValue(Wobjiect.getRemark());
			row7.createCell(11).setCellValue(Wobjiect.getLength());
			row7.createCell(12).setCellValue(Wobjiect.getWide());
			row7.createCell(13).setCellValue(Wobjiect.getHigh());
			row7.createCell(14).setCellValue(Wobjiect.getDeductVolume());
			row7.createCell(15).setCellValue(Wobjiect.getRealVolume());
			row7.createCell(16).setCellValue(Wobjiect.getRealCapacity());
			row7.createCell(17).setCellValue(Wobjiect.getCorrectioFactor());
			row7.createCell(18).setCellValue(Wobjiect.getAveDensity());
			row7.createCell(19).setCellValue(Wobjiect.getUnQuality());
			row7.createCell(20).setCellValue(Wobjiect.getGrainQuality());
			row7.createCell(21).setCellValue(Wobjiect.getSlip());
		}
		
		String[] smallSampleNum = smallSampleNums.split(",");
		for (int i = 0; i < smallSampleNum.length; i++) {
			//查询质量验收情况（根据小样编号
			WheatExaminingReport Wobjiect1 = wheatExaminingReportDao.findQualityAcceptance(sampleNum[i]);
			row7.createCell(22).setCellValue(Wobjiect1.getQualityGrade());
			row7.createCell(23).setCellValue(Wobjiect1.getShuifen_pingjunzhi());
			row7.createCell(24).setCellValue(Wobjiect1.getZazhizongliang_1());
			row7.createCell(25).setCellValue(Wobjiect1.getKuangwuzhihanliang_pingjunzhi());
			row7.createCell(26).setCellValue(Wobjiect1.getBuwanshanlihanliang_pingjunzhi_1());
			row7.createCell(27).setCellValue(Wobjiect1.getYingduzhishu_pingjunzhi());
			row7.createCell(28).setCellValue(Wobjiect1.getSezeqiwei_pingjunzhi());
			row7.createCell(29).setCellValue(Wobjiect1.getPingjunzhiganmianjinzhiliang());
			row7.createCell(30).setCellValue(Wobjiect1.getShimianjin_pingjunzhi());
			row7.createCell(31).setCellValue(Wobjiect1.getPinchangpingfenzhi());
		}
		try {
			FileOutputStream out = new FileOutputStream(ParamUtils.filePath);  
			wb.write(out);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param wb
	 * @return HSSFSheet sheet
	 * @  合并单元格
	 */
	public HSSFSheet sheet(HSSFWorkbook wb){
		HSSFSheet sheet = wb.createSheet(ParamUtils.title);
		sheet.autoSizeColumn(0);    //自动换行
		sheet.createFreezePane(10, 7, 10, 43);
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 43));
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 9));
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 10, 17));
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 18, 28));
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 29, 42));
		for (int i = 0; i < 29; i++) {
			if(i < 13){
				sheet.addMergedRegion(new CellRangeAddress(2, 5, i, i));
			}else if(i == 13){
				sheet.addMergedRegion(new CellRangeAddress(2, 5, i, i+3));
			}else{
				sheet.addMergedRegion(new CellRangeAddress(2, 5, i, i));
			}
		}
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 29, 37));
		sheet.addMergedRegion(new CellRangeAddress(3, 5, 29, 29));
		sheet.addMergedRegion(new CellRangeAddress(3, 3, 30, 36));
		sheet.addMergedRegion(new CellRangeAddress(4, 5, 30, 30));
		sheet.addMergedRegion(new CellRangeAddress(4, 5, 31, 31));
		sheet.addMergedRegion(new CellRangeAddress(4, 4, 32, 33));
		sheet.addMergedRegion(new CellRangeAddress(5, 5, 32, 32));
		sheet.addMergedRegion(new CellRangeAddress(5, 5, 33, 33));
		sheet.addMergedRegion(new CellRangeAddress(4, 5, 34, 34));
		sheet.addMergedRegion(new CellRangeAddress(4, 5, 35, 35));
		sheet.addMergedRegion(new CellRangeAddress(4, 5, 36, 36));
		sheet.addMergedRegion(new CellRangeAddress(3, 5, 37, 37));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 38, 42));
		sheet.addMergedRegion(new CellRangeAddress(3, 3, 38, 41));
		sheet.addMergedRegion(new CellRangeAddress(4, 5, 38, 38));
		sheet.addMergedRegion(new CellRangeAddress(4, 5, 39, 39));
		sheet.addMergedRegion(new CellRangeAddress(4, 5, 40, 40));
		sheet.addMergedRegion(new CellRangeAddress(4, 5, 41, 41));
		sheet.addMergedRegion(new CellRangeAddress(3, 5, 42, 42));
		sheet.addMergedRegion(new CellRangeAddress(1, 5, 43, 43));
		sheet.addMergedRegion(new CellRangeAddress(6, 6, 0, 6));
		return sheet;
	}
	



	
}



