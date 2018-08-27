package com.toughguy.sinograin.controller.barn;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.Region;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.toughguy.sinograin.dto.BuwanshanliXM_DTO;
import com.toughguy.sinograin.dto.BuwanshanliYM_DTO;
import com.toughguy.sinograin.dto.ImportBuwanshanliXM;
import com.toughguy.sinograin.dto.ImportBuwanshanliYM;
import com.toughguy.sinograin.dto.ImportMianjinxishuiliang;
import com.toughguy.sinograin.dto.ImportShuifen;
import com.toughguy.sinograin.dto.ImportZhifangsuanzhi;
import com.toughguy.sinograin.dto.MianjinxishuiliangDTO;
import com.toughguy.sinograin.dto.RegisterDTO;
import com.toughguy.sinograin.dto.ShuifenDTO;
import com.toughguy.sinograin.dto.XMPresentation;
import com.toughguy.sinograin.dto.ZhifangsuanzhiDTO;
import com.toughguy.sinograin.model.barn.Handover;
import com.toughguy.sinograin.model.barn.Record;
import com.toughguy.sinograin.model.barn.SafetyReport;
import com.toughguy.sinograin.model.barn.Sample;
import com.toughguy.sinograin.model.barn.TestItem;
import com.toughguy.sinograin.model.barn.WarehouseCounterPlace;
import com.toughguy.sinograin.model.barn.WheatExaminingReport;
import com.toughguy.sinograin.persist.barn.prototype.IRecordDao;
import com.toughguy.sinograin.service.barn.prototype.ISafetyReportService;
import com.toughguy.sinograin.service.barn.prototype.ITestItemService;
import com.toughguy.sinograin.util.ImportUtil;
import com.toughguy.sinograin.util.POIUtils;
/**
 * 下载模板
 * @author zmk
 *
 */
@Controller
@RequestMapping("/ExportJDJCDA")

public class JiandujianchaController{
	@Autowired
	private ITestItemService testItemService;
	@Autowired
	private IRecordDao recordDao;
	@Autowired
	private ISafetyReportService safetyReportService;
	/*
	 *导出监督检查档案模板 (小麦)
	 */
	@RequestMapping(value="/ExportJiandujianchaXM/{params}")
	public void ExportJiandujianchaXM(HttpServletResponse response,@PathVariable String params) throws Exception{
		FileInputStream fileInput;
	      POIUtils utils = new POIUtils();
			try {
				fileInput = new FileInputStream("upload/base/监督检查档案模板.xls");
				//poi包下的类读取excel文件  
				POIFSFileSystem ts = new POIFSFileSystem(fileInput);  
				// 创建一个webbook，对应一个Excel文件            
				HSSFWorkbook workbook = new HSSFWorkbook(ts);  
				//对应Excel文件中的sheet，0代表第一个             
				HSSFSheet sh = workbook.getSheetAt(0);  
				
				ObjectMapper om = new ObjectMapper();
				Map<String, Object> map = new HashMap<String, Object>();
				if (!StringUtils.isEmpty(params)) {
					// 参数处理
					map = om.readValue(params, new TypeReference<Map<String, Object>>() {
					});
				}
				List<Record> record = recordDao.findRecord(map);
				String jianyanyuan1 = "";
				Date jianceTime = null;
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
				for(Record r:record) {
					//监督检测报告
					List<SafetyReport> safetyReports = safetyReportService.findBySampleId(r.getSampleId());
					String problemStr = "";
					String rummagerStr = "";
					Date jianduTime = null;
					for(SafetyReport s:safetyReports) {
						problemStr += s.getProblem() + ",";
						rummagerStr += s.getRummager() + ",";
						if(jianduTime == null) {
							jianduTime = s.getUpdateTime();
						} else if(jianduTime.getTime() < s.getUpdateTime().getTime()) {
							jianduTime = s.getUpdateTime();
						}
					}
					String[] problems = problemStr.substring(0, problemStr.length()-1).split(",");
					r.setProblem(problems);
					String[] rummager1 = (rummagerStr.substring(0,rummagerStr.length()-1)).split(",");
					List<String> rummagerList = new ArrayList<String>();
					String rummager2 = "";
					for(int i=0;i<rummager1.length;i++) {
						if(!rummagerList.contains(rummager1[i])) {
							rummagerList.add(rummager1[i]);
						}
					}
					for(int i=0;i<rummagerList.size();i++) {
						rummager2 += rummagerList.get(i) + ",";
					}
					r.setRummager(rummager2.substring(0,rummager2.length()-1));
					r.setJianduTime(jianduTime);
					//检验项目
					List<TestItem> testItems = testItemService.findResult(r.getSampleId());
					for(TestItem t:testItems) {
						if(t.getTestItem() == 1) {
							r.setRongzhong(t.getResult());
							jianyanyuan1 = t.getPrincipal() + ",";
							if(jianceTime == null) {
								jianceTime = t.getUpdateTime();
							} else if(jianceTime.getTime() < t.getUpdateTime().getTime()) {
								jianceTime = t.getUpdateTime();
							}
						} else if(t.getTestItem() == 2) {
							r.setShuifen(t.getResult());
							jianyanyuan1 = t.getPrincipal() + ",";
							if(jianceTime == null) {
								jianceTime = t.getUpdateTime();
							} else if(jianceTime.getTime() < t.getUpdateTime().getTime()) {
								jianceTime = t.getUpdateTime();
							}
						} else if(t.getTestItem() == 3) {
							r.setZazhi(t.getResult());
							jianyanyuan1 = t.getPrincipal() + ",";
							if(jianceTime == null) {
								jianceTime = t.getUpdateTime();
							} else if(jianceTime.getTime() < t.getUpdateTime().getTime()) {
								jianceTime = t.getUpdateTime();
							}
						} else if(t.getTestItem() == 4) {
							r.setKuangwuzhi(t.getResult());
							jianyanyuan1 = t.getPrincipal() + ",";
							if(jianceTime == null) {
								jianceTime = t.getUpdateTime();
							} else if(jianceTime.getTime() < t.getUpdateTime().getTime()) {
								jianceTime = t.getUpdateTime();
							}
						} else if(t.getTestItem() == 5) {
							r.setBuwanshanli(t.getResult());
							jianyanyuan1 = t.getPrincipal() + ",";
							if(jianceTime == null) {
								jianceTime = t.getUpdateTime();
							} else if(jianceTime.getTime() < t.getUpdateTime().getTime()) {
								jianceTime = t.getUpdateTime();
							}
						} else if(t.getTestItem() == 6) {
							r.setShengmeili(t.getResult());
							jianyanyuan1 = t.getPrincipal() + ",";
							if(jianceTime == null) {
								jianceTime = t.getUpdateTime();
							} else if(jianceTime.getTime() < t.getUpdateTime().getTime()) {
								jianceTime = t.getUpdateTime();
							}
						} else if(t.getTestItem() == 7) {
							r.setSezeqiwei1(t.getResult());
							jianyanyuan1 = t.getPrincipal() + ",";
							if(jianceTime == null) {
								jianceTime = t.getUpdateTime();
							} else if(jianceTime.getTime() < t.getUpdateTime().getTime()) {
								jianceTime = t.getUpdateTime();
							}
						} else if(t.getTestItem() == 8) {
							r.setYingduzhishu(t.getResult());
							jianyanyuan1 = t.getPrincipal() + ",";
							if(jianceTime == null) {
								jianceTime = t.getUpdateTime();
							} else if(jianceTime.getTime() < t.getUpdateTime().getTime()) {
								jianceTime = t.getUpdateTime();
							}
						} else if(t.getTestItem() == 9) {
							r.setMianjinxishuiliang(t.getResult());
							jianyanyuan1 = t.getPrincipal() + ",";
							if(jianceTime == null) {
								jianceTime = t.getUpdateTime();
							} else if(jianceTime.getTime() < t.getUpdateTime().getTime()) {
								jianceTime = t.getUpdateTime();
							}
						} else if(t.getTestItem() == 10) {
							r.setZhifangsuanzhi(t.getResult());
							jianyanyuan1 = t.getPrincipal() + ",";
							if(jianceTime == null) {
								jianceTime = t.getUpdateTime();
							} else if(jianceTime.getTime() < t.getUpdateTime().getTime()) {
								jianceTime = t.getUpdateTime();
							}
						} else if(t.getTestItem() == 11) {
							r.setPinchangpingfen(t.getResult());
							jianyanyuan1 = t.getPrincipal() + ",";
							if(jianceTime == null) {
								jianceTime = t.getUpdateTime();
							} else if(jianceTime.getTime() < t.getUpdateTime().getTime()) {
								jianceTime = t.getUpdateTime();
							}
						} else if(t.getTestItem() == 12) {
							r.setSezeqiwei2(t.getResult());
							jianyanyuan1 = t.getPrincipal() + ",";
							if(jianceTime == null) {
								jianceTime = t.getUpdateTime();
							} else if(jianceTime.getTime() < t.getUpdateTime().getTime()) {
								jianceTime = t.getUpdateTime();
							}
						}
						//检验员去重
						String[] jianyanyuan2 = (jianyanyuan1.substring(0,jianyanyuan1.length()-1)).split(",");
						List<String> list = new ArrayList<String>();
						String jianyanyuan3 = "";
						for(int i=0;i<jianyanyuan2.length;i++) {
							if(!list.contains(jianyanyuan2[i])) {
								list.add(jianyanyuan2[i]);
							}
						}
						for(int i=0;i<list.size();i++) {
							jianyanyuan3 = list.get(i) + ",";
						}
						r.setJianyanyuan(jianyanyuan3);
						r.setJianceTime(jianceTime);
						
					
						
					}
				HSSFRow row2 = sh.createRow(2);
				row2.setHeightInPoints(37);
				HSSFRow row3 = sh.createRow(3);
				row3.setHeightInPoints(37);
				Region region = new Region(2, (short) 0, 3, (short) 0);
				HSSFCell createCell0 = row2.createCell(0);
				createCell0.setCellValue("");//定义为空字符串，横向合并单元格显示边框
				HSSFCell createCell00 = row3.createCell(0); 
				createCell00.setCellValue("");
				utils.setRegionStyle(sh, region, utils.Style9(workbook));
				sh.addMergedRegion(region);
				createCell0.setCellValue("基本信息");
				
				HSSFCell createCell1 = row2.createCell(1);
				createCell1.setCellStyle(utils.Style10(workbook));
				createCell1.setCellValue("单位名称");
				
				//第三行数据内容
//				HSSFRow row2 = sh.createRow(2);
				Region region1 = new Region(2, (short) 2, 2, (short) 4);
				HSSFCell createCell = row2.createCell(2);
				utils.setRegionStyle(sh, region1, utils.Style10(workbook));
				sh.addMergedRegion(region1);
				createCell.setCellValue("中央储备粮"+r.getpLibraryName()+"直属库有限公司");
				
				HSSFCell createCell2 = row2.createCell(5);
				createCell2.setCellStyle(utils.Style10(workbook));
				createCell2.setCellValue("仓号");
				 
				Region region2 = new Region(2, (short) 6, 2, (short) 7);
				HSSFCell createCell3 = row2.createCell(6);
				utils.setRegionStyle(sh, region2, utils.Style10(workbook));
				sh.addMergedRegion(region2);
				createCell3.setCellValue(r.getPosition());
				
				HSSFCell createCell4 = row2.createCell(8);
				createCell4.setCellStyle(utils.Style10(workbook));
				createCell4.setCellValue("仓型");
           
                HSSFCell createCell5 = row2.createCell(9);
				createCell5.setCellStyle(utils.Style10(workbook));
				createCell5.setCellValue(r.getBarnType());
				
				HSSFCell createCell6 = row2.createCell(10);
				createCell6.setCellStyle(utils.Style10(workbook));
				createCell6.setCellValue("性质");
					
				Region region3 = new Region(2, (short) 11, 2, (short) 12);
				HSSFCell createCell7 = row2.createCell(11);
				utils.setRegionStyle(sh, region3, utils.Style10(workbook));
				sh.addMergedRegion(region3);
				createCell7.setCellValue(r.getQuality());
				
                HSSFCell createCell8 = row2.createCell(13);
                createCell8.setCellStyle(utils.Style10(workbook));
                createCell8.setCellValue("收获年度");
              
                HSSFCell createCell9 = row2.createCell(14);
                createCell9.setCellStyle(utils.Style10(workbook));
                createCell9.setCellValue(r.getGainTime());
				
                HSSFCell createCell10 = row2.createCell(15);
                createCell10.setCellStyle(utils.Style10(workbook));
                createCell10.setCellValue("主任");
              
                HSSFCell createCell11 = row2.createCell(16);
                createCell11.setCellStyle(utils.Style10(workbook));
                createCell11.setCellValue("贺顺平");
              
                HSSFCell createCell12 = row2.createCell(17);
                createCell12.setCellStyle(utils.Style10(workbook));
                createCell12.setCellValue("科长");
				
                HSSFCell createCell13 = row2.createCell(18);
                createCell13.setCellStyle(utils.Style13(workbook));
                createCell13.setCellValue("陈刚");
            
          //第四行数据内容   
				
				HSSFCell createCell14 = row3.createCell(1);
				createCell14.setCellStyle(utils.Style11(workbook));
				createCell14.setCellValue("存储库点");
				 
				Region region4 = new Region(3, (short) 2, 3, (short) 4);
				HSSFCell createCell15 = row3.createCell(2);
				utils.setRegionStyle(sh, region4, utils.Style11(workbook));
				sh.addMergedRegion(region4);
				createCell15.setCellValue(r.getLibraryName());
				
				HSSFCell createCell16 = row3.createCell(5);
				createCell16.setCellStyle(utils.Style11(workbook));
				createCell16.setCellValue("品种");
				 
				Region region5 = new Region(3, (short) 6, 3, (short) 7);
				HSSFCell createCell17 = row3.createCell(6);
				utils.setRegionStyle(sh, region5, utils.Style11(workbook));
				sh.addMergedRegion(region5);
				createCell17.setCellValue(r.getSort());
           
                HSSFCell createCell18 = row3.createCell(8);
                createCell18.setCellStyle(utils.Style11(workbook));
                createCell18.setCellValue("仓容");
				
			    HSSFCell createCell19 = row3.createCell(9);
			    createCell19.setCellStyle(utils.Style11(workbook));
			    createCell19.setCellValue(r.getCangrong());
				
				HSSFCell createCell20 = row3.createCell(10);
				createCell20.setCellStyle(utils.Style11(workbook));
				createCell20.setCellValue("数量");
				
				Region region6 = new Region(3, (short) 11, 3, (short) 12);
				HSSFCell createCell21 = row3.createCell(11);
				utils.setRegionStyle(sh, region6, utils.Style11(workbook));
				sh.addMergedRegion(region6);
				createCell21.setCellValue(r.getAmount());
				
				HSSFCell createCell22 = row3.createCell(13);
				createCell22.setCellStyle(utils.Style11(workbook));
				createCell22.setCellValue("入库时间");
              
                HSSFCell createCell23 = row3.createCell(14);
                createCell23.setCellStyle(utils.Style11(workbook));
                createCell23.setCellValue(r.getBarnTime().getDate());
				
                HSSFCell createCell24 = row3.createCell(15);
                createCell24.setCellStyle(utils.Style11(workbook));
                createCell24.setCellValue("分管主任");
              
                HSSFCell createCell25 = row3.createCell(16);
                createCell25.setCellStyle(utils.Style11(workbook));
                createCell25.setCellValue("姚理刚");
				
                HSSFCell createCell26 = row3.createCell(17);
                createCell26.setCellStyle(utils.Style11(workbook));
                createCell26.setCellValue("保管员监督员 ");
              
                HSSFCell createCell27 = row3.createCell(18);
                createCell27.setCellStyle(utils.Style12(workbook));
                createCell27.setCellValue(" ");
//				}
                //循环数据
                for (int i = 0; i < record.size(); i++) {
					//根据扦样编号查询样品
					HSSFRow row5 = sh.createRow(5+i*9);
					row5.setHeightInPoints(37); // 行高
					HSSFRow row6 = sh.createRow(6+i*9);
					row6.setHeightInPoints(37); // 行高
					
					Region region7 = new Region(5+i*9, (short) 0, 6+i*9, (short) 0);
					HSSFCell createCell28 = row5.createCell(0);
					createCell28.setCellValue("");//定义为空字符串，横向合并单元格显示边框
					HSSFCell createCell29 = row6.createCell(0); 
					createCell29.setCellValue("");
					utils.setRegionStyle(sh, region7, utils.Style17(workbook));
					sh.addMergedRegion(region7);
					createCell28.setCellValue("检查序号事项 ");
					
					HSSFRow row7 = sh.createRow(7+i*9);
					row7.setHeightInPoints(37); // 行高
					HSSFRow row8 = sh.createRow(8+i*9);
					row8.setHeightInPoints(37); // 行高
					HSSFRow row9 = sh.createRow(9+i*9);
					row9.setHeightInPoints(37); // 行高
					HSSFRow row10 = sh.createRow(10+i*9);
					row10.setHeightInPoints(37); // 行高
					HSSFRow row11 = sh.createRow(11+i*9);
					row11.setHeightInPoints(37); // 行高
					
					Region region8 = new Region(7+i*9, (short) 0, 11+i*9, (short) 0);
					HSSFCell createCell30 = row7.createCell(0);
					createCell30.setCellValue("");//定义为空字符串，横向合并单元格显示边框
					HSSFCell createCell31 = row8.createCell(0); 
					createCell31.setCellValue("");
					HSSFCell createCell32 = row9.createCell(0); 
					createCell32.setCellValue("");
					HSSFCell createCell33 = row10.createCell(0); 
					createCell33.setCellValue("");
					HSSFCell createCell34 = row11.createCell(0); 
					createCell34.setCellValue("");
					utils.setRegionStyle(sh, region8, utils.Style18(workbook));
					sh.addMergedRegion(region8);
					createCell30.setCellValue("NO."+i+1);
					
					Region region9 = new Region(5+i*9, (short) 1, 11+i*9, (short) 1);
					HSSFCell createCell35 = row5.createCell(1);
					createCell35.setCellValue("");//定义为空字符串，横向合并单元格显示边框
					HSSFCell createCell36 = row6.createCell(1); 
					createCell36.setCellValue("");
					HSSFCell createCell37 = row7.createCell(1); 
					createCell37.setCellValue("");
					HSSFCell createCell38 = row8.createCell(1); 
					createCell38.setCellValue("");
					HSSFCell createCell39 = row9.createCell(1); 
					createCell39.setCellValue("");
					HSSFCell createCell40 = row10.createCell(1); 
					createCell40.setCellValue("");
					HSSFCell createCell41 = row11.createCell(1); 
					createCell41.setCellValue("");
					utils.setRegionStyle(sh, region9, utils.Style19(workbook));
					sh.addMergedRegion(region9);
					createCell35.setCellValue("数量情况");
					//
					HSSFCell createCell42 = row5.createCell(2);
	                createCell42.setCellStyle(utils.Style10(workbook));
	                createCell42.setCellValue("形状");  //形状
	                
	                HSSFCell createCell43 = row6.createCell(2);
	                createCell43.setCellStyle(utils.Style20(workbook));
	                createCell43.setCellValue("长度");  //长度
	                
	                HSSFCell createCell44 = row7.createCell(2);
	                createCell44.setCellStyle(utils.Style20(workbook));
	                createCell44.setCellValue("宽度");  //宽度
	                
	                HSSFCell createCell45 = row8.createCell(2);
	                createCell45.setCellStyle(utils.Style20(workbook));
	                createCell45.setCellValue("平均高度");  //平均高度
	                
	                HSSFCell createCell46 = row9.createCell(2);
	                createCell46.setCellStyle(utils.Style20(workbook));
	                createCell46.setCellValue("测算体积");  //测算体积
	                
	                HSSFCell createCell47 = row10.createCell(2);
	                createCell47.setCellStyle(utils.Style20(workbook));
	                createCell47.setCellValue("扣除体积");  //扣除体积
					
	                HSSFCell createCell48 = row11.createCell(2);
	                createCell48.setCellStyle(utils.Style11(workbook));
	                createCell48.setCellValue("测算净体积");  //测算净体积
	                //
					HSSFCell createCell49 = row5.createCell(3);
					createCell49.setCellStyle(utils.Style10(workbook));
					createCell49.setCellValue(r.getShape());  //形状
	                
	                HSSFCell createCell50 = row6.createCell(3);
	                createCell50.setCellStyle(utils.Style20(workbook));
	                createCell50.setCellValue(r.getLength());  //长度
	                
	                HSSFCell createCell51 = row7.createCell(3);
	                createCell51.setCellStyle(utils.Style20(workbook));
	                createCell51.setCellValue(r.getWide());  //宽度
	                
	                HSSFCell createCell52 = row8.createCell(3);
	                createCell52.setCellStyle(utils.Style20(workbook));
	                createCell52.setCellValue(r.getHigh());  //平均高度
	                
	                HSSFCell createCell53 = row9.createCell(3);
	                createCell53.setCellStyle(utils.Style20(workbook));
	                createCell53.setCellValue(r.getMeasuredVolume());  //测算体积
	                
	                HSSFCell createCell54 = row10.createCell(3);
	                createCell54.setCellStyle(utils.Style20(workbook));
	                createCell54.setCellValue(r.getDeductVolume());  //扣除体积
					
	                HSSFCell createCell55 = row11.createCell(3);
	                createCell55.setCellStyle(utils.Style11(workbook));
	                createCell55.setCellValue(r.getRealVolume());  //测算净体积
	                //
	                HSSFCell createCell56 = row5.createCell(4);
	                createCell56.setCellStyle(utils.Style10(workbook));
	                createCell56.setCellValue("容重");  //容重
	                
	                HSSFCell createCell57 = row6.createCell(4);
	                createCell57.setCellStyle(utils.Style20(workbook));
	                createCell57.setCellValue("修正系数");  //修正系数
	                
	                HSSFCell createCell58 = row7.createCell(4);
	                createCell58.setCellStyle(utils.Style20(workbook));
	                createCell58.setCellValue("平均密度");  //平均密度
	                
	                HSSFCell createCell59 = row8.createCell(4);
	                createCell59.setCellStyle(utils.Style20(workbook));
	                createCell59.setCellValue("测量计算数");  //测量计算数
	                
	                HSSFCell createCell60 = row9.createCell(4);
	                createCell60.setCellStyle(utils.Style20(workbook));
	                createCell60.setCellValue("保管账面数");  //保管账面数
					
	                HSSFCell createCell61 = row10.createCell(4);
	                createCell61.setCellStyle(utils.Style20(workbook));
	                createCell61.setCellValue("差率");  //差率
	                
	                HSSFCell createCell62 = row11.createCell(4);
	                createCell62.setCellStyle(utils.Style11(workbook));
	                createCell62.setCellValue(" ");  //
	                //
	                Region region11 = new Region(5+i*9, (short) 5, 5+i*9, (short) 6);
					HSSFCell createCell63 = row5.createCell(5);
					utils.setRegionStyle(sh, region11, utils.Style10(workbook));
					sh.addMergedRegion(region11);
					createCell63.setCellValue(r.getRongzhong());//容重
					        
					Region region12 = new Region(6+i*9, (short) 5, 6+i*9, (short) 6);
					HSSFCell createCell64 = row6.createCell(5);
					utils.setRegionStyle(sh, region12, utils.Style20(workbook));
					sh.addMergedRegion(region12);
					createCell64.setCellValue(r.getCorrectioFactor());  //修正系数
        
					Region region13 = new Region(7+i*9, (short) 5,7+i*9, (short) 6);
					HSSFCell createCell65 = row7.createCell(5);
					utils.setRegionStyle(sh, region13, utils.Style20(workbook));
					sh.addMergedRegion(region13);
					createCell65.setCellValue(r.getAveDensity());  //平均密度

					Region region14 = new Region(8+i*9, (short) 5,8+i*9, (short) 6);
					HSSFCell createCell66 = row8.createCell(5);
					utils.setRegionStyle(sh, region14, utils.Style20(workbook));
					sh.addMergedRegion(region14);
					createCell66.setCellValue(r.getAveDensity());  //平均密度

					Region region15 = new Region(9+i*9, (short) 5,9+i*9, (short) 6);
					HSSFCell createCell67 = row9.createCell(5);
					utils.setRegionStyle(sh, region15, utils.Style20(workbook));
					sh.addMergedRegion(region15);
					createCell67.setCellValue(r.getGrainQuality());  //保管账面数

					Region region16 = new Region(10+i*9, (short) 5,10+i*9, (short) 6);
					HSSFCell createCell68 = row10.createCell(5);
					utils.setRegionStyle(sh, region16, utils.Style20(workbook));
					sh.addMergedRegion(region16);
					createCell68.setCellValue(r.getSlip());  //差率

					Region region17 = new Region(11+i*9, (short) 5,11+i*9, (short) 6);
					HSSFCell createCell69 = row11.createCell(5);
					utils.setRegionStyle(sh, region17, utils.Style11(workbook));
					sh.addMergedRegion(region17);
					createCell69.setCellValue(" ");  //

	                //
	                Region region10 = new Region(5+i*9, (short) 7, 11+i*9, (short) 7);
					HSSFCell createCell70 = row5.createCell(7);
//					createCell70.setCellValue("");//定义为空字符串，横向合并单元格显示边框
//					HSSFCell createCell71 = row6.createCell(7); 
//					createCell71.setCellValue("");
//					HSSFCell createCell72 = row7.createCell(7); 
//					createCell72.setCellValue("");
//					HSSFCell createCell73 = row8.createCell(7); 
//					createCell73.setCellValue("");
//					HSSFCell createCell74 = row9.createCell(7); 
//					createCell74.setCellValue("");
//					HSSFCell createCell75 = row10.createCell(7); 
//					createCell75.setCellValue("");
//					HSSFCell createCell76 = row11.createCell(7); 
//					createCell76.setCellValue("");
					utils.setRegionStyle(sh, region10, utils.Style19(workbook));
					sh.addMergedRegion(region9);
					createCell70.setCellValue("质量情况");
					//
					Region region18 = new Region(5+i*9, (short) 8,5+i*9, (short) 9);
					HSSFCell createCell77 = row5.createCell(8);
					utils.setRegionStyle(sh, region18, utils.Style10(workbook));
					sh.addMergedRegion(region18);
					createCell77.setCellValue("等级");  //等级

					Region region19 = new Region(6+i*9, (short) 8,6+i*9, (short) 9);
					HSSFCell createCell78 = row6.createCell(8);
					utils.setRegionStyle(sh, region19, utils.Style20(workbook));
					sh.addMergedRegion(region19);
					createCell78.setCellValue("容重");  //容重

					Region region20 = new Region(7+i*9, (short) 8,7+i*9, (short) 9);
					HSSFCell createCell79 = row7.createCell(8);
					utils.setRegionStyle(sh, region20, utils.Style20(workbook));
					sh.addMergedRegion(region20);
					createCell79.setCellValue("水分");  //水分
					
					Region region21 = new Region(8+i*9, (short) 8,9+i*9, (short) 8);
					HSSFCell createCell80 = row8.createCell(8);
					createCell80.setCellValue("");//定义为空字符串，横向合并单元格显示边框
					HSSFCell createCell81 = row9.createCell(8); 
					createCell81.setCellValue("");
					utils.setRegionStyle(sh, region21, utils.Style20(workbook));
					sh.addMergedRegion(region21);
					createCell80.setCellValue("杂质");  //杂质
					
					HSSFCell createCell82 = row8.createCell(9);
	                createCell82.setCellStyle(utils.Style20(workbook));
	                createCell82.setCellValue("总量 ");  //
	                
	                HSSFCell createCell83 = row9.createCell(9);
	                createCell83.setCellStyle(utils.Style20(workbook));
	                createCell83.setCellValue("其中：矿物质");  //
	                
	                Region region22 = new Region(10+i*9, (short) 8,10+i*9, (short) 9);
					HSSFCell createCell84 = row10.createCell(8);
					utils.setRegionStyle(sh, region22, utils.Style20(workbook));
					sh.addMergedRegion(region22);
					createCell84.setCellValue("不完善粒");  //水分
					
					Region region23 = new Region(11+i*9, (short) 8,11+i*9, (short) 9);
					HSSFCell createCell85 = row11.createCell(8);
					utils.setRegionStyle(sh, region23, utils.Style11(workbook));
					sh.addMergedRegion(region23);
					createCell85.setCellValue("色泽气味");  //色泽气味
					//
					HSSFCell createCell86 = row5.createCell(10);
					createCell86.setCellStyle(utils.Style10(workbook));
					createCell86.setCellValue(r.getQualityGrade());  //等级
	                
	                HSSFCell createCell87 = row6.createCell(10);
	                createCell87.setCellStyle(utils.Style20(workbook));
	                createCell87.setCellValue(r.getRongzhong());  //容重
	                
	                HSSFCell createCell88 = row7.createCell(10);
	                createCell88.setCellStyle(utils.Style20(workbook));
	                createCell88.setCellValue(r.getShuifen());  //水分
	                
	                HSSFCell createCell89 = row8.createCell(10);
	                createCell89.setCellStyle(utils.Style20(workbook));
	                createCell89.setCellValue(r.getZazhi());  //总量
	                
	                HSSFCell createCell90 = row9.createCell(10);
	                createCell90.setCellStyle(utils.Style20(workbook));
	                createCell90.setCellValue(r.getKuangwuzhi());  //矿物质
	                
	                HSSFCell createCell91 = row10.createCell(10);
	                createCell91.setCellStyle(utils.Style20(workbook));
	                createCell91.setCellValue(r.getBuwanshanli());  //不完善粒
					
	                HSSFCell createCell92 = row11.createCell(10);
	                createCell92.setCellStyle(utils.Style11(workbook));
	                createCell92.setCellValue(r.getSezeqiwei1());  //色泽气味
	                //
	                HSSFCell createCell93 = row5.createCell(11);
	                createCell93.setCellStyle(utils.Style10(workbook));
	                createCell93.setCellValue("硬度指数");  //硬度指数
	                
	                HSSFCell createCell94 = row6.createCell(11);
	                createCell94.setCellStyle(utils.Style20(workbook));
	                createCell94.setCellValue("面筋吸水量");  //面筋吸水量
	                
	                HSSFCell createCell95 = row7.createCell(11);
	                createCell95.setCellStyle(utils.Style20(workbook));
	                createCell95.setCellValue("品尝评分");  //品尝评分
					
	                HSSFCell createCell96 = row8.createCell(11);
	                createCell96.setCellStyle(utils.Style20(workbook));
	                createCell96.setCellValue("色泽气味");  //色泽气味
	                
	                HSSFCell createCell961 = row9.createCell(11);
	                createCell961.setCellStyle(utils.Style20(workbook));
	                createCell961.setCellValue(" ");  //
	                
	                HSSFCell createCell962 = row10.createCell(11);
	                createCell962.setCellStyle(utils.Style20(workbook));
	                createCell962.setCellValue(" ");  //
	                
	                HSSFCell createCell963 = row11.createCell(11);
	                createCell963.setCellStyle(utils.Style11(workbook));
	                createCell963.setCellValue(" ");  //
	                //
	                HSSFCell createCell97 = row5.createCell(12);
	                createCell97.setCellStyle(utils.Style10(workbook));
	                createCell97.setCellValue(r.getYingduzhishu());  //硬度指数
	                
	                HSSFCell createCell98 = row6.createCell(12);
	                createCell98.setCellStyle(utils.Style20(workbook));
	                createCell98.setCellValue(r.getMianjinxishuiliang());  //面筋吸水量
	                
	                HSSFCell createCell99 = row7.createCell(12);
	                createCell99.setCellStyle(utils.Style20(workbook));
	                createCell99.setCellValue(r.getPinchangpingfen());  //品尝评分
					
	                HSSFCell createCell100 = row8.createCell(12);
	                createCell100.setCellStyle(utils.Style20(workbook));
	                createCell100.setCellValue(r.getSezeqiwei2());  //色泽气味
	                
	                HSSFCell createCell1001 = row9.createCell(12);
	                createCell1001.setCellStyle(utils.Style20(workbook));
	                createCell1001.setCellValue(" ");  //
	                
	                HSSFCell createCell1002 = row10.createCell(12);
	                createCell1002.setCellStyle(utils.Style20(workbook));
	                createCell1002.setCellValue(" ");  //
	                
	                HSSFCell createCell1003 = row11.createCell(12);
	                createCell1003.setCellStyle(utils.Style11(workbook));
	                createCell1003.setCellValue(" ");  //
	                //
	                Region region24 = new Region(5+i*9, (short) 13, 11+i*9, (short) 13);
					HSSFCell createCell101 = row5.createCell(13);
//					createCell101.setCellValue("");//定义为空字符串，横向合并单元格显示边框
//					HSSFCell createCell102 = row6.createCell(13); 
//					createCell102.setCellValue("");
//					HSSFCell createCell103 = row7.createCell(13); 
//					createCell103.setCellValue("");
//					HSSFCell createCell104 = row8.createCell(13); 
//					createCell104.setCellValue("");
//					HSSFCell createCell105 = row9.createCell(13); 
//					createCell105.setCellValue("");
//					HSSFCell createCell106 = row10.createCell(13); 
//					createCell106.setCellValue("");
//					HSSFCell createCell107= row11.createCell(13); 
//					createCell107.setCellValue("");
					utils.setRegionStyle(sh, region24, utils.Style19(workbook));
					sh.addMergedRegion(region24);
					createCell101.setCellValue("主要存在问题");
					
					Region region25 = new Region(5+i*9, (short) 14,11+i*9, (short) 18);
					HSSFCell createCell108 = row11.createCell(14);
					createCell108.setCellValue("");//定义为空字符串，横向合并单元格显示边框
					HSSFCell createCell1081 = row5.createCell(14); 
					createCell1081.setCellValue("");
					HSSFCell createCell109 = row6.createCell(14); 
					createCell109.setCellValue("");
					HSSFCell createCell110 = row7.createCell(14); 
					createCell110.setCellValue("");
					HSSFCell createCell111 = row8.createCell(14); 
					createCell111.setCellValue("");
					HSSFCell createCell112 = row9.createCell(14); 
					createCell112.setCellValue("");
					utils.setRegionStyle(sh, region25, utils.Style21(workbook));
					sh.addMergedRegion(region25);
					String problem = "";
					for(int a=1;a<=r.getProblem().length;a++) {
						problem += "问题"+ a + ":" + r.getProblem()[a-1] + ",";
					}
					createCell1081.setCellValue(problem.substring(0, problem.length()-4));  //问题
					
					HSSFRow row13 = sh.createRow(13+i*9);
					row13.setHeightInPoints(37); // 行高
					Region region26 = new Region(13+i*9, (short) 1,13+i*9, (short) 3);
					HSSFCell createCell113 = row13.createCell(1);
					utils.setRegionStyle(sh, region26, utils.Style22(workbook));
					sh.addMergedRegion(region26);
					createCell113.setCellValue("检查人:"+r.getGzdgRummager());  //检查人
					
					Region region27 = new Region(13+i*9, (short) 4,13+i*9, (short) 5);
					HSSFCell createCell114 = row13.createCell(4);
					utils.setRegionStyle(sh, region27, utils.Style22(workbook));
					sh.addMergedRegion(region27);
					createCell114.setCellValue("时间:"+sdf.format(r.getJianduTime()));  //时间
					
					HSSFCell createCell115 = row13.createCell(7);
					createCell115.setCellStyle(utils.Style22(workbook));
					createCell115.setCellValue("检验员");  //检验员
	                
					Region region28 = new Region(13+i*9, (short) 8,13+i*9, (short) 10);
					HSSFCell createCell116 = row13.createCell(8);
					utils.setRegionStyle(sh, region28, utils.Style22(workbook));
					sh.addMergedRegion(region28);
					createCell116.setCellValue(r.getJianyanyuan().substring(0,r.getJianyanyuan().length()-1));  //检验员
					
					Region region29 = new Region(13+i*9, (short) 11,13+i*9, (short) 12);
					HSSFCell createCell117 = row13.createCell(11);
					utils.setRegionStyle(sh, region29, utils.Style22(workbook));
					sh.addMergedRegion(region29);
					createCell117.setCellValue("时间:"+sdf.format(r.getJianceTime()));  //时间
					
					HSSFCell createCell118 = row13.createCell(14);
					createCell118.setCellStyle(utils.Style22(workbook));
					createCell118.setCellValue("记录人"+r.getRummager());  //记录人
					
					HSSFCell createCell119 = row13.createCell(16);
					createCell119.setCellStyle(utils.Style22(workbook));
					createCell119.setCellValue("时间"+sdf.format(r.getJianduTime()));  //时间
			}

				String title = "中央事权粮检查（验）档案";
				OutputStream output = response.getOutputStream();
//				response.reset();
				response.setHeader("Content-disposition", "attachment; filename="+new String( title.getBytes("gb2312"), "ISO8859-1" )+".xls");
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
				e.printStackTrace();
			}  
		
	}
	
	
	/*
	 *导出监督检查档案模板 (玉米)
	 */
	@RequestMapping(value="/ExportJiandujianchaYM/{params}")
	public void ExportJiandujianchaYM(HttpServletResponse response,@PathVariable String params) throws Exception{
		FileInputStream fileInput;
	      POIUtils utils = new POIUtils();
			try {
				fileInput = new FileInputStream("upload/base/监督检查档案模板.xls");
				//poi包下的类读取excel文件  
				POIFSFileSystem ts = new POIFSFileSystem(fileInput);  
				// 创建一个webbook，对应一个Excel文件            
				HSSFWorkbook workbook = new HSSFWorkbook(ts);  
				//对应Excel文件中的sheet，0代表第一个             
				HSSFSheet sh = workbook.getSheetAt(0);  
				
				ObjectMapper om = new ObjectMapper();
				Map<String, Object> map = new HashMap<String, Object>();
				if (!StringUtils.isEmpty(params)) {
					// 参数处理
					map = om.readValue(params, new TypeReference<Map<String, Object>>() {
					});
				}
				List<Record> record = recordDao.findRecord(map);
				String jianyanyuan1 = "";
				Date jianceTime = null;
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
				for(Record r:record) {
					List<TestItem> testItems = testItemService.findResult(r.getSampleId());
					for(TestItem t:testItems) {
						if(t.getTestItem() == 1) {
							r.setRongzhong(t.getResult());
							jianyanyuan1 = t.getPrincipal() + ",";
							if(jianceTime == null) {
								jianceTime = t.getUpdateTime();
							} else if(jianceTime.getTime() < t.getUpdateTime().getTime()) {
								jianceTime = t.getUpdateTime();
							}
						} else if(t.getTestItem() == 2) {
							r.setShuifen(t.getResult());
							jianyanyuan1 = t.getPrincipal() + ",";
							if(jianceTime == null) {
								jianceTime = t.getUpdateTime();
							} else if(jianceTime.getTime() < t.getUpdateTime().getTime()) {
								jianceTime = t.getUpdateTime();
							}
						} else if(t.getTestItem() == 3) {
							r.setZazhi(t.getResult());
							jianyanyuan1 = t.getPrincipal() + ",";
							if(jianceTime == null) {
								jianceTime = t.getUpdateTime();
							} else if(jianceTime.getTime() < t.getUpdateTime().getTime()) {
								jianceTime = t.getUpdateTime();
							}
						} else if(t.getTestItem() == 4) {
							r.setKuangwuzhi(t.getResult());
							jianyanyuan1 = t.getPrincipal() + ",";
							if(jianceTime == null) {
								jianceTime = t.getUpdateTime();
							} else if(jianceTime.getTime() < t.getUpdateTime().getTime()) {
								jianceTime = t.getUpdateTime();
							}
						} else if(t.getTestItem() == 5) {
							r.setBuwanshanli(t.getResult());
							jianyanyuan1 = t.getPrincipal() + ",";
							if(jianceTime == null) {
								jianceTime = t.getUpdateTime();
							} else if(jianceTime.getTime() < t.getUpdateTime().getTime()) {
								jianceTime = t.getUpdateTime();
							}
						} else if(t.getTestItem() == 6) {
							r.setShengmeili(t.getResult());
							jianyanyuan1 = t.getPrincipal() + ",";
							if(jianceTime == null) {
								jianceTime = t.getUpdateTime();
							} else if(jianceTime.getTime() < t.getUpdateTime().getTime()) {
								jianceTime = t.getUpdateTime();
							}
						} else if(t.getTestItem() == 7) {
							r.setSezeqiwei1(t.getResult());
							jianyanyuan1 = t.getPrincipal() + ",";
							if(jianceTime == null) {
								jianceTime = t.getUpdateTime();
							} else if(jianceTime.getTime() < t.getUpdateTime().getTime()) {
								jianceTime = t.getUpdateTime();
							}
						} else if(t.getTestItem() == 8) {
							r.setYingduzhishu(t.getResult());
							jianyanyuan1 = t.getPrincipal() + ",";
							if(jianceTime == null) {
								jianceTime = t.getUpdateTime();
							} else if(jianceTime.getTime() < t.getUpdateTime().getTime()) {
								jianceTime = t.getUpdateTime();
							}
						} else if(t.getTestItem() == 9) {
							r.setMianjinxishuiliang(t.getResult());
							jianyanyuan1 = t.getPrincipal() + ",";
							if(jianceTime == null) {
								jianceTime = t.getUpdateTime();
							} else if(jianceTime.getTime() < t.getUpdateTime().getTime()) {
								jianceTime = t.getUpdateTime();
							}
						} else if(t.getTestItem() == 10) {
							r.setZhifangsuanzhi(t.getResult());
							jianyanyuan1 = t.getPrincipal() + ",";
							if(jianceTime == null) {
								jianceTime = t.getUpdateTime();
							} else if(jianceTime.getTime() < t.getUpdateTime().getTime()) {
								jianceTime = t.getUpdateTime();
							}
						} else if(t.getTestItem() == 11) {
							r.setPinchangpingfen(t.getResult());
							jianyanyuan1 = t.getPrincipal() + ",";
							if(jianceTime == null) {
								jianceTime = t.getUpdateTime();
							} else if(jianceTime.getTime() < t.getUpdateTime().getTime()) {
								jianceTime = t.getUpdateTime();
							}
						} else if(t.getTestItem() == 12) {
							r.setSezeqiwei2(t.getResult());
							jianyanyuan1 = t.getPrincipal() + ",";
							if(jianceTime == null) {
								jianceTime = t.getUpdateTime();
							} else if(jianceTime.getTime() < t.getUpdateTime().getTime()) {
								jianceTime = t.getUpdateTime();
							}
						}
						//检验员去重
						String[] jianyanyuan2 = (jianyanyuan1.substring(0,jianyanyuan1.length()-1)).split(",");
						List<String> list = new ArrayList<String>();
						String jianyanyuan3 = "";
						for(int i=0;i<jianyanyuan2.length;i++) {
							if(!list.contains(jianyanyuan2[i])) {
								list.add(jianyanyuan2[i]);
							}
						}
						for(int i=0;i<list.size();i++) {
							jianyanyuan3 = list.get(i) + ",";
						}
						r.setJianyanyuan(jianyanyuan3);
						r.setJianceTime(jianceTime);
						
					
						
					}
//				}
				
					
				HSSFRow row2 = sh.createRow(2);
				row2.setHeightInPoints(37);
				HSSFRow row3 = sh.createRow(3);
				row3.setHeightInPoints(37);
				Region region = new Region(2, (short) 0, 3, (short) 0);
				HSSFCell createCell0 = row2.createCell(0);
				createCell0.setCellValue("");//定义为空字符串，横向合并单元格显示边框
				HSSFCell createCell00 = row3.createCell(0); 
				createCell00.setCellValue("");
				utils.setRegionStyle(sh, region, utils.Style9(workbook));
				sh.addMergedRegion(region);
				createCell0.setCellValue("基本信息");
				
				HSSFCell createCell1 = row2.createCell(1);
				createCell1.setCellStyle(utils.Style10(workbook));
				createCell1.setCellValue("单位名称");
				
				//第三行数据内容
//				HSSFRow row2 = sh.createRow(2);
				Region region1 = new Region(2, (short) 2, 2, (short) 4);
				HSSFCell createCell = row2.createCell(2);
				utils.setRegionStyle(sh, region1, utils.Style10(workbook));
				sh.addMergedRegion(region1);
				createCell.setCellValue("中央储备粮"+r.getpLibraryName()+"直属库有限公司");
				
				HSSFCell createCell2 = row2.createCell(5);
				createCell2.setCellStyle(utils.Style10(workbook));
				createCell2.setCellValue("仓号");
				 
				Region region2 = new Region(2, (short) 6, 2, (short) 7);
				HSSFCell createCell3 = row2.createCell(6);
				utils.setRegionStyle(sh, region2, utils.Style10(workbook));
				sh.addMergedRegion(region2);
				createCell3.setCellValue(r.getPosition());
				
				HSSFCell createCell4 = row2.createCell(8);
				createCell4.setCellStyle(utils.Style10(workbook));
				createCell4.setCellValue("仓型");
           
                HSSFCell createCell5 = row2.createCell(9);
				createCell5.setCellStyle(utils.Style10(workbook));
				createCell5.setCellValue(r.getBarnType());
				
				HSSFCell createCell6 = row2.createCell(10);
				createCell6.setCellStyle(utils.Style10(workbook));
				createCell6.setCellValue("性质");
					
				Region region3 = new Region(2, (short) 11, 2, (short) 12);
				HSSFCell createCell7 = row2.createCell(11);
				utils.setRegionStyle(sh, region3, utils.Style10(workbook));
				sh.addMergedRegion(region3);
				createCell7.setCellValue(r.getQuality());
				
                HSSFCell createCell8 = row2.createCell(13);
                createCell8.setCellStyle(utils.Style10(workbook));
                createCell8.setCellValue("收获年度");
              
                HSSFCell createCell9 = row2.createCell(14);
                createCell9.setCellStyle(utils.Style10(workbook));
                createCell9.setCellValue(r.getGainTime());
				
                HSSFCell createCell10 = row2.createCell(15);
                createCell10.setCellStyle(utils.Style10(workbook));
                createCell10.setCellValue("主任");
              
                HSSFCell createCell11 = row2.createCell(16);
                createCell11.setCellStyle(utils.Style10(workbook));
                createCell11.setCellValue("贺顺平");
              
                HSSFCell createCell12 = row2.createCell(17);
                createCell12.setCellStyle(utils.Style10(workbook));
                createCell12.setCellValue("科长");
				
                HSSFCell createCell13 = row2.createCell(18);
                createCell13.setCellStyle(utils.Style13(workbook));
                createCell13.setCellValue("陈刚");
            
          //第四行数据内容   
				
				HSSFCell createCell14 = row3.createCell(1);
				createCell14.setCellStyle(utils.Style11(workbook));
				createCell14.setCellValue("存储库点");
				 
				Region region4 = new Region(3, (short) 2, 3, (short) 4);
				HSSFCell createCell15 = row3.createCell(2);
				utils.setRegionStyle(sh, region4, utils.Style11(workbook));
				sh.addMergedRegion(region4);
				createCell15.setCellValue(r.getLibraryName());
				
				HSSFCell createCell16 = row3.createCell(5);
				createCell16.setCellStyle(utils.Style11(workbook));
				createCell16.setCellValue("品种");
				 
				Region region5 = new Region(3, (short) 6, 3, (short) 7);
				HSSFCell createCell17 = row3.createCell(6);
				utils.setRegionStyle(sh, region5, utils.Style11(workbook));
				sh.addMergedRegion(region5);
				createCell17.setCellValue(r.getSort());
           
                HSSFCell createCell18 = row3.createCell(8);
                createCell18.setCellStyle(utils.Style11(workbook));
                createCell18.setCellValue("仓容");
				
			    HSSFCell createCell19 = row3.createCell(9);
			    createCell19.setCellStyle(utils.Style11(workbook));
			    createCell19.setCellValue(r.getCangrong());
				
				HSSFCell createCell20 = row3.createCell(10);
				createCell20.setCellStyle(utils.Style11(workbook));
				createCell20.setCellValue("数量");
				
				Region region6 = new Region(3, (short) 11, 3, (short) 12);
				HSSFCell createCell21 = row3.createCell(11);
				utils.setRegionStyle(sh, region6, utils.Style11(workbook));
				sh.addMergedRegion(region6);
				createCell21.setCellValue(r.getAmount());
				
				HSSFCell createCell22 = row3.createCell(13);
				createCell22.setCellStyle(utils.Style11(workbook));
				createCell22.setCellValue("入库时间");
              
                HSSFCell createCell23 = row3.createCell(14);
                createCell23.setCellStyle(utils.Style11(workbook));
                createCell23.setCellValue(r.getBarnTime().getTime());
				
                HSSFCell createCell24 = row3.createCell(15);
                createCell24.setCellStyle(utils.Style11(workbook));
                createCell24.setCellValue("分管主任");
              
                HSSFCell createCell25 = row3.createCell(16);
                createCell25.setCellStyle(utils.Style11(workbook));
                createCell25.setCellValue("姚理刚");
				
                HSSFCell createCell26 = row3.createCell(17);
                createCell26.setCellStyle(utils.Style11(workbook));
                createCell26.setCellValue("保管员监督员 ");
              
                HSSFCell createCell27 = row3.createCell(18);
                createCell27.setCellStyle(utils.Style12(workbook));
                createCell27.setCellValue(" ");
                
                
//				}
				
				//循环数据
                for (int i = 0; i < record.size(); i++) {
					//根据扦样编号查询样品
					HSSFRow row5 = sh.createRow(5+i*9);
					row5.setHeightInPoints(37); // 行高
					HSSFRow row6 = sh.createRow(6+i*9);
					row6.setHeightInPoints(37); // 行高
					
					Region region7 = new Region(5+i*9, (short) 0, 6+i*9, (short) 0);
					HSSFCell createCell28 = row5.createCell(0);
					createCell28.setCellValue("");//定义为空字符串，横向合并单元格显示边框
					HSSFCell createCell29 = row6.createCell(0); 
					createCell29.setCellValue("");
					utils.setRegionStyle(sh, region7, utils.Style9(workbook));
					sh.addMergedRegion(region7);
					createCell28.setCellValue("检查序号事项 ");
					
					HSSFRow row7 = sh.createRow(7+i*9);
					row7.setHeightInPoints(37); // 行高
					HSSFRow row8 = sh.createRow(8+i*9);
					row8.setHeightInPoints(37); // 行高
					HSSFRow row9 = sh.createRow(9+i*9);
					row9.setHeightInPoints(37); // 行高
					HSSFRow row10 = sh.createRow(10+i*9);
					row10.setHeightInPoints(37); // 行高
					HSSFRow row11 = sh.createRow(11+i*9);
					row11.setHeightInPoints(37); // 行高
					
					Region region8 = new Region(7+i*9, (short) 0, 11+i*9, (short) 0);
					HSSFCell createCell30 = row7.createCell(0);
					createCell30.setCellValue("");//定义为空字符串，横向合并单元格显示边框
					HSSFCell createCell31 = row8.createCell(0); 
					createCell31.setCellValue("");
					HSSFCell createCell32 = row9.createCell(0); 
					createCell32.setCellValue("");
					HSSFCell createCell33 = row10.createCell(0); 
					createCell33.setCellValue("");
					HSSFCell createCell34 = row11.createCell(0); 
					createCell34.setCellValue("");
					utils.setRegionStyle(sh, region8, utils.Style9(workbook));
					sh.addMergedRegion(region8);
					createCell30.setCellValue("NO."+i+1);
					
					Region region9 = new Region(5+i*9, (short) 1, 11+i*9, (short) 1);
					HSSFCell createCell35 = row5.createCell(1);
//					createCell35.setCellValue("");//定义为空字符串，横向合并单元格显示边框
//					HSSFCell createCell36 = row6.createCell(1); 
//					createCell36.setCellValue("");
//					HSSFCell createCell37 = row7.createCell(1); 
//					createCell37.setCellValue("");
//					HSSFCell createCell38 = row8.createCell(1); 
//					createCell38.setCellValue("");
//					HSSFCell createCell39 = row9.createCell(1); 
//					createCell39.setCellValue("");
//					HSSFCell createCell40 = row10.createCell(1); 
//					createCell40.setCellValue("");
//					HSSFCell createCell41 = row11.createCell(1); 
//					createCell41.setCellValue("");
					utils.setRegionStyle(sh, region9, utils.Style9(workbook));
					sh.addMergedRegion(region9);
					createCell35.setCellValue("数量情况");
					//
					HSSFCell createCell42 = row5.createCell(2);
	                createCell42.setCellStyle(utils.Style10(workbook));
	                createCell42.setCellValue("形状");  //形状
	                
	                HSSFCell createCell43 = row6.createCell(2);
	                createCell43.setCellStyle(utils.Style10(workbook));
	                createCell43.setCellValue("长度");  //长度
	                
	                HSSFCell createCell44 = row7.createCell(2);
	                createCell44.setCellStyle(utils.Style10(workbook));
	                createCell44.setCellValue("宽度");  //宽度
	                
	                HSSFCell createCell45 = row8.createCell(2);
	                createCell45.setCellStyle(utils.Style10(workbook));
	                createCell45.setCellValue("平均高度");  //平均高度
	                
	                HSSFCell createCell46 = row9.createCell(2);
	                createCell46.setCellStyle(utils.Style10(workbook));
	                createCell46.setCellValue("测算体积");  //测算体积
	                
	                HSSFCell createCell47 = row10.createCell(2);
	                createCell47.setCellStyle(utils.Style10(workbook));
	                createCell47.setCellValue("扣除体积");  //扣除体积
					
	                HSSFCell createCell48 = row11.createCell(2);
	                createCell48.setCellStyle(utils.Style10(workbook));
	                createCell48.setCellValue("测算净体积");  //测算净体积
	                //
					HSSFCell createCell49 = row5.createCell(3);
					createCell49.setCellStyle(utils.Style10(workbook));
					createCell49.setCellValue(r.getShape());  //形状
	                
	                HSSFCell createCell50 = row6.createCell(3);
	                createCell50.setCellStyle(utils.Style10(workbook));
	                createCell50.setCellValue(r.getLength());  //长度
	                
	                HSSFCell createCell51 = row7.createCell(3);
	                createCell51.setCellStyle(utils.Style10(workbook));
	                createCell51.setCellValue(r.getWide());  //宽度
	                
	                HSSFCell createCell52 = row8.createCell(3);
	                createCell52.setCellStyle(utils.Style10(workbook));
	                createCell52.setCellValue(r.getHigh());  //平均高度
	                
	                HSSFCell createCell53 = row9.createCell(3);
	                createCell53.setCellStyle(utils.Style10(workbook));
	                createCell53.setCellValue(r.getMeasuredVolume());  //测算体积
	                
	                HSSFCell createCell54 = row10.createCell(3);
	                createCell54.setCellStyle(utils.Style10(workbook));
	                createCell54.setCellValue(r.getDeductVolume());  //扣除体积
					
	                HSSFCell createCell55 = row11.createCell(3);
	                createCell55.setCellStyle(utils.Style10(workbook));
	                createCell55.setCellValue(r.getRealVolume());  //测算净体积
	                //
	                HSSFCell createCell56 = row5.createCell(4);
	                createCell56.setCellStyle(utils.Style10(workbook));
	                createCell56.setCellValue("容重");  //容重
	                
	                HSSFCell createCell57 = row6.createCell(4);
	                createCell57.setCellStyle(utils.Style10(workbook));
	                createCell57.setCellValue("修正系数");  //修正系数
	                
	                HSSFCell createCell58 = row7.createCell(4);
	                createCell58.setCellStyle(utils.Style10(workbook));
	                createCell58.setCellValue("平均密度");  //平均密度
	                
	                HSSFCell createCell59 = row8.createCell(4);
	                createCell59.setCellStyle(utils.Style10(workbook));
	                createCell59.setCellValue("测量计算数");  //测量计算数
	                
	                HSSFCell createCell60 = row9.createCell(4);
	                createCell60.setCellStyle(utils.Style10(workbook));
	                createCell60.setCellValue("保管账面数");  //保管账面数
					
	                HSSFCell createCell61 = row10.createCell(4);
	                createCell61.setCellStyle(utils.Style10(workbook));
	                createCell61.setCellValue("差率");  //差率
	                
	                HSSFCell createCell62 = row11.createCell(4);
	                createCell62.setCellStyle(utils.Style10(workbook));
	                createCell62.setCellValue(" ");  //
	                //
	                Region region11 = new Region(5+i*9, (short) 5, 5+i*9, (short) 6);
					HSSFCell createCell63 = row5.createCell(5);
					utils.setRegionStyle(sh, region11, utils.Style11(workbook));
					sh.addMergedRegion(region11);
					createCell63.setCellValue(r.getRongzhong());//容重
					        
					Region region12 = new Region(6+i*9, (short) 5, 6+i*9, (short) 6);
					HSSFCell createCell64 = row6.createCell(5);
					utils.setRegionStyle(sh, region12, utils.Style11(workbook));
					sh.addMergedRegion(region12);
					createCell64.setCellValue(r.getCorrectioFactor());  //修正系数
        
					Region region13 = new Region(7+i*9, (short) 5,7+i*9, (short) 6);
					HSSFCell createCell65 = row7.createCell(5);
					utils.setRegionStyle(sh, region13, utils.Style11(workbook));
					sh.addMergedRegion(region13);
					createCell65.setCellValue(r.getAveDensity());  //平均密度

					Region region14 = new Region(8+i*9, (short) 5,8+i*9, (short) 6);
					HSSFCell createCell66 = row8.createCell(5);
					utils.setRegionStyle(sh, region14, utils.Style11(workbook));
					sh.addMergedRegion(region14);
					createCell66.setCellValue(r.getAveDensity());  //平均密度

					Region region15 = new Region(9+i*9, (short) 5,9+i*9, (short) 6);
					HSSFCell createCell67 = row9.createCell(5);
					utils.setRegionStyle(sh, region15, utils.Style11(workbook));
					sh.addMergedRegion(region15);
					createCell67.setCellValue(r.getGrainQuality());  //保管账面数

					Region region16 = new Region(10+i*9, (short) 5,10+i*9, (short) 6);
					HSSFCell createCell68 = row10.createCell(5);
					utils.setRegionStyle(sh, region16, utils.Style11(workbook));
					sh.addMergedRegion(region16);
					createCell68.setCellValue(r.getSlip());  //差率

					Region region17 = new Region(11+i*9, (short) 5,11+i*9, (short) 6);
					HSSFCell createCell69 = row11.createCell(5);
					utils.setRegionStyle(sh, region17, utils.Style11(workbook));
					sh.addMergedRegion(region17);
					createCell69.setCellValue(" ");  //

	                //
	                Region region10 = new Region(5+i*9, (short) 7, 11+i*9, (short) 7);
					HSSFCell createCell70 = row5.createCell(7);
					createCell70.setCellValue("");//定义为空字符串，横向合并单元格显示边框
					HSSFCell createCell71 = row6.createCell(7); 
					createCell71.setCellValue("");
					HSSFCell createCell72 = row7.createCell(7); 
					createCell72.setCellValue("");
					HSSFCell createCell73 = row8.createCell(7); 
					createCell73.setCellValue("");
					HSSFCell createCell74 = row9.createCell(7); 
					createCell74.setCellValue("");
					HSSFCell createCell75 = row10.createCell(7); 
					createCell75.setCellValue("");
					HSSFCell createCell76 = row11.createCell(7); 
					createCell76.setCellValue("");
					utils.setRegionStyle(sh, region10, utils.Style9(workbook));
					sh.addMergedRegion(region9);
					createCell70.setCellValue("质量情况");
					//
					Region region18 = new Region(5+i*9, (short) 8,5+i*9, (short) 9);
					HSSFCell createCell77 = row5.createCell(8);
					utils.setRegionStyle(sh, region18, utils.Style11(workbook));
					sh.addMergedRegion(region18);
					createCell77.setCellValue("等级");  //等级

					Region region19 = new Region(6+i*9, (short) 8,6+i*9, (short) 9);
					HSSFCell createCell78 = row6.createCell(8);
					utils.setRegionStyle(sh, region19, utils.Style11(workbook));
					sh.addMergedRegion(region19);
					createCell78.setCellValue("容重");  //容重

					Region region20 = new Region(7+i*9, (short) 8,7+i*9, (short) 9);
					HSSFCell createCell79 = row7.createCell(8);
					utils.setRegionStyle(sh, region20, utils.Style11(workbook));
					sh.addMergedRegion(region20);
					createCell79.setCellValue("水分");  //水分
					
					Region region21 = new Region(8+i*9, (short) 8,9+i*9, (short) 8);
					HSSFCell createCell80 = row8.createCell(8);
					createCell80.setCellValue("");//定义为空字符串，横向合并单元格显示边框
					HSSFCell createCell81 = row9.createCell(8); 
					createCell81.setCellValue("");
					utils.setRegionStyle(sh, region21, utils.Style11(workbook));
					sh.addMergedRegion(region21);
					createCell80.setCellValue("杂质");  //杂质
					
					HSSFCell createCell82 = row8.createCell(9);
	                createCell82.setCellStyle(utils.Style10(workbook));
	                createCell82.setCellValue("总量 ");  //
	                
	                HSSFCell createCell83 = row9.createCell(9);
	                createCell83.setCellStyle(utils.Style10(workbook));
	                createCell83.setCellValue("其中：生霉粒");  //生霉粒
	                
	                Region region22 = new Region(10+i*9, (short) 8,10+i*9, (short) 9);
					HSSFCell createCell84 = row10.createCell(8);
					utils.setRegionStyle(sh, region22, utils.Style11(workbook));
					sh.addMergedRegion(region22);
					createCell84.setCellValue("不完善粒");  //水分
					
					Region region23 = new Region(11+i*9, (short) 8,11+i*9, (short) 9);
					HSSFCell createCell85 = row11.createCell(8);
					utils.setRegionStyle(sh, region23, utils.Style11(workbook));
					sh.addMergedRegion(region23);
					createCell85.setCellValue("色泽气味");  //色泽气味
					//
					HSSFCell createCell86 = row5.createCell(10);
					createCell86.setCellStyle(utils.Style10(workbook));
					createCell86.setCellValue(r.getQualityGrade());  //等级
	                
	                HSSFCell createCell87 = row6.createCell(10);
	                createCell87.setCellStyle(utils.Style10(workbook));
	                createCell87.setCellValue(r.getRongzhong());  //容重
	                
	                HSSFCell createCell88 = row7.createCell(10);
	                createCell88.setCellStyle(utils.Style10(workbook));
	                createCell88.setCellValue(r.getShuifen());  //水分
	                
	                HSSFCell createCell89 = row8.createCell(10);
	                createCell89.setCellStyle(utils.Style10(workbook));
	                createCell89.setCellValue(r.getZazhi());  //总量
	                
	                HSSFCell createCell90 = row9.createCell(10);
	                createCell90.setCellStyle(utils.Style10(workbook));
	                createCell90.setCellValue(r.getShengmeili());  //生霉粒
	                
	                HSSFCell createCell91 = row10.createCell(10);
	                createCell91.setCellStyle(utils.Style10(workbook));
	                createCell91.setCellValue(r.getBuwanshanli());  //不完善粒
					
	                HSSFCell createCell92 = row11.createCell(10);
	                createCell92.setCellStyle(utils.Style10(workbook));
	                createCell92.setCellValue(r.getSezeqiwei1());  //色泽气味
	                //
	                HSSFCell createCell93 = row8.createCell(11);
	                createCell93.setCellStyle(utils.Style10(workbook));
	                createCell93.setCellValue("硬度指数");  //硬度指数
	                
	                HSSFCell createCell94 = row9.createCell(11);
	                createCell94.setCellStyle(utils.Style10(workbook));
	                createCell94.setCellValue("面筋吸水量");  //面筋吸水量
	                
	                HSSFCell createCell95 = row10.createCell(11);
	                createCell95.setCellStyle(utils.Style10(workbook));
	                createCell95.setCellValue("品尝评分");  //品尝评分
					
	                HSSFCell createCell96 = row11.createCell(11);
	                createCell96.setCellStyle(utils.Style10(workbook));
	                createCell96.setCellValue("色泽气味");  //色泽气味
	                //
	                HSSFCell createCell97 = row8.createCell(12);
	                createCell97.setCellStyle(utils.Style10(workbook));
	                createCell97.setCellValue(r.getYingduzhishu());  //硬度指数
	                
	                HSSFCell createCell98 = row9.createCell(12);
	                createCell98.setCellStyle(utils.Style10(workbook));
	                createCell98.setCellValue(r.getMianjinxishuiliang());  //面筋吸水量
	                
	                HSSFCell createCell99 = row10.createCell(12);
	                createCell99.setCellStyle(utils.Style10(workbook));
	                createCell99.setCellValue(r.getPinchangpingfen());  //品尝评分
					
	                HSSFCell createCell100 = row11.createCell(12);
	                createCell100.setCellStyle(utils.Style10(workbook));
	                createCell100.setCellValue(r.getSezeqiwei2());  //色泽气味
	                
	                Region region24 = new Region(5+i*9, (short) 13, 11+i*9, (short) 13);
					HSSFCell createCell101 = row5.createCell(13);
					createCell101.setCellValue("");//定义为空字符串，横向合并单元格显示边框
					HSSFCell createCell102 = row6.createCell(13); 
					createCell102.setCellValue("");
					HSSFCell createCell103 = row7.createCell(13); 
					createCell103.setCellValue("");
					HSSFCell createCell104 = row8.createCell(13); 
					createCell104.setCellValue("");
					HSSFCell createCell105 = row9.createCell(13); 
					createCell105.setCellValue("");
					HSSFCell createCell106 = row10.createCell(13); 
					createCell106.setCellValue("");
					HSSFCell createCell107= row11.createCell(13); 
					createCell107.setCellValue("");
					utils.setRegionStyle(sh, region24, utils.Style9(workbook));
					sh.addMergedRegion(region24);
					createCell101.setCellValue("主要存在问题");
					
					Region region25 = new Region(5+i*9, (short) 14,11+i*9, (short) 18);
					HSSFCell createCell108 = row11.createCell(14);
					createCell108.setCellValue("");//定义为空字符串，横向合并单元格显示边框
					HSSFCell createCell1081 = row5.createCell(14); 
					createCell1081.setCellValue("");
					HSSFCell createCell109 = row6.createCell(14); 
					createCell109.setCellValue("");
					HSSFCell createCell110 = row7.createCell(14); 
					createCell110.setCellValue("");
					HSSFCell createCell111 = row8.createCell(14); 
					createCell111.setCellValue("");
					HSSFCell createCell112 = row9.createCell(14); 
					createCell112.setCellValue("");
					utils.setRegionStyle(sh, region25, utils.Style11(workbook));
					sh.addMergedRegion(region25);
					String problem = "";
					for(int a=1;a<=r.getProblem().length;a++) {
						problem += "问题"+ a + ":" + r.getProblem()[a-1] + ",";
					}
					createCell1081.setCellValue(problem.substring(0, problem.length()-1));  //问题
					
					HSSFRow row13 = sh.createRow(13+i*9);
					row13.setHeightInPoints(37); // 行高
					Region region26 = new Region(13+i*9, (short) 1,13+i*9, (short) 3);
					HSSFCell createCell113 = row13.createCell(1);
					utils.setRegionStyle(sh, region26, utils.Style22(workbook));
					sh.addMergedRegion(region26);
					createCell113.setCellValue("检查人:"+r.getGzdgRummager());  //检查人
					
					Region region27 = new Region(13+i*9, (short) 4,13+i*9, (short) 5);
					HSSFCell createCell114 = row13.createCell(4);
					utils.setRegionStyle(sh, region27, utils.Style22(workbook));
					sh.addMergedRegion(region27);
					createCell114.setCellValue("时间:"+sdf.format(r.getJianduTime()));  //时间
					
					HSSFCell createCell115 = row13.createCell(7);
					createCell115.setCellStyle(utils.Style22(workbook));
					createCell115.setCellValue("检验员");  //检验员
	                
					Region region28 = new Region(13+i*9, (short) 8,13+i*9, (short) 10);
					HSSFCell createCell116 = row13.createCell(8);
					utils.setRegionStyle(sh, region28, utils.Style22(workbook));
					sh.addMergedRegion(region28);
					createCell116.setCellValue(r.getJianyanyuan().substring(0,r.getJianyanyuan().length()-1));  //检验员
					
					Region region29 = new Region(13+i*9, (short) 11,13+i*9, (short) 12);
					HSSFCell createCell117 = row13.createCell(11);
					utils.setRegionStyle(sh, region29, utils.Style22(workbook));
					sh.addMergedRegion(region29);
					createCell117.setCellValue("时间:"+sdf.format(r.getJianceTime()));  //时间
					
					HSSFCell createCell118 = row13.createCell(14);
					createCell118.setCellStyle(utils.Style22(workbook));
					createCell118.setCellValue("记录人"+r.getRummager());  //记录人
					
					HSSFCell createCell119 = row13.createCell(16);
					createCell119.setCellStyle(utils.Style22(workbook));
					createCell119.setCellValue("时间"+sdf.format(r.getJianduTime()));  //时间
//					
//              }

				String title = "中央事权粮检查（验）档案";
				OutputStream output = response.getOutputStream();
//				response.reset();
				response.setHeader("Content-disposition", "attachment; filename="+new String( title.getBytes("gb2312"), "ISO8859-1" )+".xls");
				response.setContentType("application/vnd.ms-excel;charset=utf-8");
				workbook.write(output);
				output.flush();  
		        //将Excel写出        
		        workbook.write(output);  
		        //关闭流  
		        fileInput.close();  
		        output.close(); 
                }
				}
			} catch (Exception e) {
				e.printStackTrace();
			}  
		
	}
	
}
