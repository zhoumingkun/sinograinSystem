package com.toughguy.sinograin.service.barn.impl;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toughguy.sinograin.model.barn.Library;
import com.toughguy.sinograin.model.barn.Manuscript;
import com.toughguy.sinograin.model.barn.Sample;
import com.toughguy.sinograin.service.barn.prototype.ILibraryService;
import com.toughguy.sinograin.service.barn.prototype.IManuscriptService;
import com.toughguy.sinograin.service.impl.GenericServiceImpl;
import com.toughguy.sinograin.util.POIUtils;

@Service
public class ManuscriptServiceImpl extends GenericServiceImpl<Manuscript, Integer> implements IManuscriptService{

	@Autowired
	private ILibraryService libraryService;
	@Override
	public void expertExcel(HttpServletResponse response,Sample sample, Manuscript manuscript) throws Exception {
		 String storge = null ; 		//储存形式
		 String qualityGrade = null;  	//质量等级
		 String putWay = null;			//入仓方式
		 String isMatch = null;			//账实是否相符
		 
	        POIUtils utils = new POIUtils();
			try {
	        //传入的文件  
	        FileInputStream fileInput = new FileInputStream("upload/base/工作底稿(模板).xls");  
	        //poi包下的类读取excel文件  
	        POIFSFileSystem ts = new POIFSFileSystem(fileInput);  
	        // 创建一个webbook，对应一个Excel文件            
	        HSSFWorkbook workbook = new HSSFWorkbook(ts);  
	        //对应Excel文件中的sheet，0代表第一个             
	        HSSFSheet sh = workbook.getSheetAt(0);  
	        SimpleDateFormat dateFm = new SimpleDateFormat("yyyy年MM月dd日");
	        Library lib = libraryService.find(sample.getLibraryId());
	        sh.getRow(2).getCell(0).setCellValue("被检查企业（盖章）：" + lib.getpLibraryName()+"直属库有限公司");
	        sh.getRow(2).getCell(5).setCellValue("实际查库日 ： "+dateFm.format(manuscript.getRealCheckedTime())); //实际查库日
	        sh.getRow(3).getCell(1).setCellValue(sample.getPosition()); 	//货位号
	        sh.getRow(3).getCell(3).setCellValue(sample.getSort()); 		//品种
	        sh.getRow(3).getCell(7).setCellValue(sample.getQuality()); 		//性质
	        sh.getRow(4).getCell(1).setCellValue(sample.getLibraryName()); 	//所在库区
	        sh.getRow(4).getCell(7).setCellValue(manuscript.getBarnType());	//仓房类型
	        sh.getRow(5).getCell(1).setCellValue(sample.getGainTime()); 	//收货年度       
	        if(manuscript.getStorge() == 1){
	        	storge = "散存";
	        }else if(manuscript.getStorge() == 2){
	        	storge = "包装";
	        }else if(manuscript.getStorge() == 3){
	        	storge = "围包散存";
	        }else{
	        	storge = "未知";
	        }
	        sh.getRow(5).getCell(3).setCellValue(storge); 					//存储形式
	        sh.getRow(5).getCell(7).setCellValue(Double.parseDouble(sample.getAmount())*1000); 	//保管账数量        
	        if(manuscript.getQualityGrade() ==1){
	        	qualityGrade = "一等";
	        }else if(manuscript.getQualityGrade() ==2){
	        	qualityGrade = "二等";
	        }else{
	        	qualityGrade = "三等";
	        }
	        sh.getRow(6).getCell(1).setCellValue(qualityGrade);  			//质量等级
	        if(manuscript.getPutWay() == 1){
	        	putWay = "人工入仓□      机械入仓√";
	        }else {
	        	putWay = "人工入仓√      机械入仓□";
	        }
//	        HSSFCellStyle cellStyle = WorkBook.createCellStyle();
//            cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));
//            cell.setCellStyle(cellStyle);
            
            HSSFCellStyle cellStyle = workbook.createCellStyle();
            HSSFDataFormat format = workbook.createDataFormat();
            cellStyle.setDataFormat(format.getFormat("0.0"));//设置单元类型保留两位小数
            

	        sh.getRow(6).getCell(3).setCellValue(putWay);  					//入仓方式
	        
	        HSSFCell cell = sh.getRow(7).getCell(2);
	        cell.setCellStyle(cellStyle);
	        cell.setCellValue(manuscript.getStorageCapacity());  //容重 （入库）
	        
	        HSSFCell cell2 =sh.getRow(7).getCell(7);
	        cell2.setCellStyle(cellStyle);
	        cell2.setCellValue(manuscript.getRealCapacity());  	//容重 （实际）
	        
	        HSSFCell cell3 =sh.getRow(8).getCell(2);
	        cell3.setCellStyle(cellStyle);
	        cell3.setCellValue(manuscript.getStorageWater());		//水分（入库）
	        
	        HSSFCell cell4 =sh.getRow(8).getCell(7);
	        cell4.setCellStyle(cellStyle);
	        cell4.setCellValue(manuscript.getRealWater());  		//水分 （实际）
	        
	        HSSFCell cell5 =sh.getRow(9).getCell(2);
	        cell5.setCellStyle(cellStyle);
	        cell5.setCellValue(manuscript.getStorageImpurity()); 	//杂质（入库）
	        
	        HSSFCell cell6 =sh.getRow(9).getCell(7);
	        cell6.setCellStyle(cellStyle);
	        cell6.setCellValue(manuscript.getRealImpurity());  	//杂质 （实际）
	        
	        sh.getRow(12).getCell(2).setCellValue(manuscript.getDeductVolume());  	//扣除体积
	        
	        HSSFCellStyle cellStyle2 = workbook.createCellStyle();
            HSSFDataFormat format2 = workbook.createDataFormat();
            cellStyle2.setDataFormat(format2.getFormat("0.00"));//设置单元类型保留一位小数
            
            HSSFCell cell7 =sh.getRow(19).getCell(4);
            cell7.setCellStyle(cellStyle2);
            cell7.setCellValue(manuscript.getLength());  		//长度
            
            HSSFCell cell8 =sh.getRow(19).getCell(6);
            cell8.setCellStyle(cellStyle2);
            cell8.setCellValue(manuscript.getWide());  			//宽度
            
            HSSFCell cell9 =sh.getRow(19).getCell(8);
            cell9.setCellStyle(cellStyle2);
            cell9.setCellValue(manuscript.getHigh());  			//高度
            
	        sh.getRow(24).getCell(2).setCellValue(manuscript.getLossNature());		//保管自然损耗
	        if("是".equals(manuscript.getIsMatch())){
	        	isMatch = "是√   否□";
	        }else {
	        	isMatch = "是□   否√";
	        }
	        sh.getRow(24).getCell(7).setCellValue(isMatch);							//账实是否相符
	        sh.getRow(26).getCell(7).setCellValue(manuscript.getResult());			//不符原因
	        sh.getRow(27).getCell(2).setCellValue(manuscript.getRemark());			//备注
	        
	        sh.getRow(11).getCell(2).setCellValue(manuscript.getMeasuredVolume());	//测量体积（ 粮堆测量体积）
	        sh.getRow(13).getCell(2).setCellValue(manuscript.getRealVolume());		//真实体积（粮堆实际体积）
	        sh.getRow(15).getCell(2).setCellValue(manuscript.getRealCapacity());	//粮食容重（g/l）
	        sh.getRow(16).getCell(2).setCellValue(manuscript.getCorrectioFactor()); //修正后修正系数
	        sh.getRow(17).getCell(2).setCellValue(manuscript.getAveDensity());		//粮食平均密度（g/l）？
	        sh.getRow(22).getCell(2).setCellValue(manuscript.getUnQuality());		//测量计算数
	        sh.getRow(23).getCell(2).setCellValue(manuscript.getLossWater());		//水分减量
	        sh.getRow(25).getCell(2).setCellValue(manuscript.getLoss());			//合计
	        sh.getRow(26).getCell(2).setCellValue(manuscript.getCheckNum());		//检查计算数
	        sh.getRow(22).getCell(7).setCellValue(manuscript.getDifference());		//差数
	        sh.getRow(23).getCell(7).setCellValue(manuscript.getSlip());			//差率
	        sh.getRow(25).getCell(7).setCellValue(Double.parseDouble(sample.getAmount())*1000);	//粮食实际数量（kg）
	        //将修改后的文件写出到D:\\excel目录下  
	        //FileOutputStream output = new FileOutputStream("D:\\辅机1.xls");
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
		e.printStackTrace();
	}  

}

}
