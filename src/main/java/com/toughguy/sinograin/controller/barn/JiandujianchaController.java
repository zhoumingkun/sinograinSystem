package com.toughguy.sinograin.controller.barn;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
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
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
import com.toughguy.sinograin.model.barn.Sample;
import com.toughguy.sinograin.model.barn.WarehouseCounterPlace;
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
	
	/*
	 *导出监督检查档案模板 
	 */
	@RequestMapping(value="ExportJiandujiancha")
	public void ExportJiandujiancha(HttpServletResponse response) throws Exception{
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
				createCell.setCellValue("硬汉科技");
				
				HSSFCell createCell2 = row2.createCell(5);
				createCell2.setCellStyle(utils.Style10(workbook));
				createCell2.setCellValue("仓号");
				 
				Region region2 = new Region(2, (short) 6, 2, (short) 7);
				HSSFCell createCell3 = row2.createCell(6);
				utils.setRegionStyle(sh, region2, utils.Style10(workbook));
				sh.addMergedRegion(region2);
				createCell3.setCellValue("仓号1");
				
				HSSFCell createCell4 = row2.createCell(8);
				createCell4.setCellStyle(utils.Style10(workbook));
				createCell4.setCellValue("仓型");
           
                HSSFCell createCell5 = row2.createCell(9);
				createCell5.setCellStyle(utils.Style10(workbook));
				createCell5.setCellValue("平房仓");
				
				HSSFCell createCell6 = row2.createCell(10);
				createCell6.setCellStyle(utils.Style10(workbook));
				createCell6.setCellValue("性质");
					
				Region region3 = new Region(2, (short) 11, 2, (short) 12);
				HSSFCell createCell7 = row2.createCell(11);
				utils.setRegionStyle(sh, region3, utils.Style10(workbook));
				sh.addMergedRegion(region3);
				createCell7.setCellValue("zc");
				
                HSSFCell createCell8 = row2.createCell(13);
                createCell8.setCellStyle(utils.Style10(workbook));
                createCell8.setCellValue("收获年度");
              
                HSSFCell createCell9 = row2.createCell(14);
                createCell9.setCellStyle(utils.Style10(workbook));
                createCell9.setCellValue("2018年");
				
                HSSFCell createCell10 = row2.createCell(15);
                createCell10.setCellStyle(utils.Style10(workbook));
                createCell10.setCellValue("主任");
              
                HSSFCell createCell11 = row2.createCell(16);
                createCell11.setCellStyle(utils.Style10(workbook));
                createCell11.setCellValue("郑龙");
              
                HSSFCell createCell12 = row2.createCell(17);
                createCell12.setCellStyle(utils.Style10(workbook));
                createCell12.setCellValue("科长");
				
                HSSFCell createCell13 = row2.createCell(18);
                createCell13.setCellStyle(utils.Style13(workbook));
                createCell13.setCellValue("郑龙龙");
            
          //第四行数据内容   
				
				HSSFCell createCell14 = row3.createCell(1);
				createCell14.setCellStyle(utils.Style11(workbook));
				createCell14.setCellValue("存储库点");
				 
				Region region4 = new Region(3, (short) 2, 3, (short) 4);
				HSSFCell createCell15 = row3.createCell(2);
				utils.setRegionStyle(sh, region4, utils.Style11(workbook));
				sh.addMergedRegion(region4);
				createCell15.setCellValue("1库");
				
				HSSFCell createCell16 = row3.createCell(5);
				createCell16.setCellStyle(utils.Style11(workbook));
				createCell16.setCellValue("品种");
				 
				Region region5 = new Region(3, (short) 6, 3, (short) 7);
				HSSFCell createCell17 = row3.createCell(6);
				utils.setRegionStyle(sh, region5, utils.Style11(workbook));
				sh.addMergedRegion(region5);
				createCell17.setCellValue("小麦");
           
                HSSFCell createCell18 = row3.createCell(8);
                createCell18.setCellStyle(utils.Style11(workbook));
                createCell18.setCellValue("仓容");
				
			    HSSFCell createCell19 = row3.createCell(9);
			    createCell19.setCellStyle(utils.Style11(workbook));
			    createCell19.setCellValue("100吨");
				
				HSSFCell createCell20 = row3.createCell(10);
				createCell20.setCellStyle(utils.Style11(workbook));
				createCell20.setCellValue("数量");
				
				Region region6 = new Region(3, (short) 11, 3, (short) 12);
				HSSFCell createCell21 = row3.createCell(11);
				utils.setRegionStyle(sh, region6, utils.Style11(workbook));
				sh.addMergedRegion(region6);
				createCell21.setCellValue("100吨");
				
				HSSFCell createCell22 = row3.createCell(13);
				createCell22.setCellStyle(utils.Style11(workbook));
				createCell22.setCellValue("入库时间");
              
                HSSFCell createCell23 = row3.createCell(14);
                createCell23.setCellStyle(utils.Style11(workbook));
                createCell23.setCellValue("2017.2");
				
                HSSFCell createCell24 = row3.createCell(15);
                createCell24.setCellStyle(utils.Style11(workbook));
                createCell24.setCellValue("分管主任");
              
                HSSFCell createCell25 = row3.createCell(16);
                createCell25.setCellStyle(utils.Style11(workbook));
                createCell25.setCellValue("张海");
				
                HSSFCell createCell26 = row3.createCell(17);
                createCell26.setCellStyle(utils.Style11(workbook));
                createCell26.setCellValue("保管员监督员 ");
              
                HSSFCell createCell27 = row3.createCell(18);
                createCell27.setCellStyle(utils.Style12(workbook));
                createCell27.setCellValue("张海行 ");
				

				String title = "中央事权粮检查（验）档案";
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
