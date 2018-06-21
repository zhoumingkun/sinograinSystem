package com.toughguy.sinograin.service.barn.impl;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toughguy.sinograin.dto.SamplingDTO;
import com.toughguy.sinograin.model.barn.Library;
import com.toughguy.sinograin.model.barn.Register;
import com.toughguy.sinograin.model.barn.Sample;
import com.toughguy.sinograin.persist.barn.prototype.ILibraryDao;
import com.toughguy.sinograin.persist.barn.prototype.IRegisterDao;
import com.toughguy.sinograin.persist.barn.prototype.ISampleDao;
import com.toughguy.sinograin.service.barn.prototype.IRegisterService;
import com.toughguy.sinograin.service.impl.GenericServiceImpl;
import com.toughguy.sinograin.util.POIUtils;

@Service
public class RegisterServiceImpl extends GenericServiceImpl<Register, Integer> implements IRegisterService {
	
	@Autowired
	private IRegisterDao registerDao;
	@Autowired
	private ILibraryDao libraryDao;
	@Autowired
	private ISampleDao sampleDao;
	
	@Override
	public List<Register> findByLibraryId(Map<String, Object> params) {
		List<Register> registers = registerDao.findByLibraryId(params);
		return registers;
	}

	@Override
	public void expertExcel(HttpServletResponse response,SamplingDTO dto) throws Exception {
		   
           POIUtils utils = new POIUtils();
	        //传入的文件  
	        FileInputStream fileInput = new FileInputStream("upload/base/扦样登记表.xls");  
	        //poi包下的类读取excel文件  
	        POIFSFileSystem ts = new POIFSFileSystem(fileInput);  
	        // 创建一个webbook，对应一个Excel文件            
	        HSSFWorkbook workbook = new HSSFWorkbook(ts);  
	        //对应Excel文件中的sheet，0代表第一个     
	        workbook.setSheetName(0, dto.getRegister().getLibraryName());			//设置簿名
	        HSSFSheet sh = workbook.getSheetAt(0);
	        // 生成一个样式
	        HSSFCellStyle style = workbook.createCellStyle();
	        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直居中  
	        HSSFFont font = workbook.createFont();  //设置字体
	   	 	font.setFontName("宋体");   
	   	 	font.setFontHeightInPoints((short) 11);//设置字体大小
	   	 	style.setFont(font);
	   	 	style.setBorderLeft(HSSFCellStyle.BORDER_THIN);	
	   	 	style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
	   	    style.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
			style.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
			style.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
			style.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
	   	 	style.setWrapText(true);				//自动换行
	   	 	
	        SimpleDateFormat dateBarn = new SimpleDateFormat("yyyy.MM");
	        SimpleDateFormat dateSample = new SimpleDateFormat("yyyy.MM.dd");
	        int pId = libraryDao.find(dto.getRegister().getLibraryId()).getpLibraryId();
	        if(pId!=-1){
	        	Library pLibrary = libraryDao.find(pId);
		        sh.getRow(1).getCell(0).setCellValue("单位名称(盖章)：中央储备粮"+pLibrary.getLibraryName()+"直属库有限公司");
	        }
	        int size = dto.getList().size();
	       if(size>10){
	        	sh.shiftRows(12, 15,size-10, true, false);				//插入单元格
	        }
	        List <Sample> list = dto.getList();
	        for(int i = 0; i<size ;i++ ){
	        		for(int j= 0 ;j<14;j++){
	        			if(i>8){
	        				sh.getRow(i+3).setHeight((short)(2.815*256));
	        				Cell cell = sh.getRow(i+3).createCell(j);
			        		cell.setCellStyle(style);
	        			}else{
	        				sh.getRow(i+3).getCell(j).setCellStyle(style);
	        			}
	        		}
	        	sh.getRow(i+3).getCell(0).setCellValue(i + 1);				//序号
	        	sh.getRow(i+3).getCell(1).setCellValue(list.get(i).getSampleWord());				//扦样编号
	        	sh.getRow(i+3).getCell(2).setCellValue(dto.getRegister().getLibraryName());			//被查库点
	        	sh.getRow(i+3).getCell(3).setCellValue(list.get(i).getPosition());					//货位号
	        	sh.getRow(i+3).getCell(4).setCellValue(list.get(i).getSort());						//品种
	        	sh.getRow(i+3).getCell(5).setCellValue(list.get(i).getQuality());					//性质
	        	sh.getRow(i+3).getCell(6).setCellValue(list.get(i).getAmount());					//代表数量
	        	sh.getRow(i+3).getCell(7).setCellValue(list.get(i).getOriginPlace());				//产地
	        	sh.getRow(i+3).getCell(8).setCellValue(list.get(i).getGainTime());					//收货年度
	        	if(list.get(i).getBarnTime()!=null&&!("".equals(list.get(i).getBarnTime()))){
	        	sh.getRow(i+3).getCell(9).setCellValue(dateBarn.format(list.get(i).getBarnTime()));	//入库时间
	        	}
	        	if(list.get(i).getSampleTime()!=null&&!("".equals(list.get(i).getSampleTime()))){
	        	sh.getRow(i+3).getCell(12).setCellValue(dateSample.format(list.get(i).getSampleTime())); //扦样日期
	        	}
	        	sh.getRow(i+3).getCell(13).setCellValue(list.get(i).getRemark());					//备注       	
	        }
	        OutputStream output = response.getOutputStream();
    		response.reset();
    		response.setHeader("Content-disposition", "attachment; filename=" + new Date().getTime() +".xls");
    		response.setContentType("application/vnd.ms-excel;charset=utf-8");
    		output.flush();
    		workbook.write(output);
	        //关闭流  
	        fileInput.close();  
	        output.close();  
	}



	@Override
	public void deleteRegisterAndSample(int id) {
		// TODO Auto-generated method stub
		registerDao.delete(id);
		sampleDao.deleteByPId(id);
	}
}
