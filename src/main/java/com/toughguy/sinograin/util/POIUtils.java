package com.toughguy.sinograin.util;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFCellUtil;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.hssf.util.Region;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;

public class POIUtils {

	HSSFWorkbook wb = new HSSFWorkbook(); // 创建工作簿

	/**
	 * @return HSSFSheet sheet 
	 * 
	 */
	public HSSFSheet sheet(String  title) {

		HSSFSheet sheet = wb.createSheet(title); // 工作簿名称

		return sheet;
	}
	
	/**
	 * @return Boolean 
	 * @ 在本地生成文件
	 */
	public boolean excel(){
		
		try {
			FileOutputStream out = new FileOutputStream("E://student2.xls");  
			wb.write(out);
			return true;
		} catch (IOException e) {
			return false;
		}  
	}
	
	private void setRegionStyle(HSSFSheet sheet, Region region , HSSFCellStyle cs) {
		int toprowNum = region.getRowFrom();
		for (int i = region.getRowFrom(); i <= region.getRowTo(); i ++) {
			HSSFRow row = HSSFCellUtil.getRow(i, sheet);
			for (int j = region.getColumnFrom(); j <= region.getColumnTo(); j++) {
				HSSFCell cell = HSSFCellUtil.getCell(row, (short)j);
				cell.setCellStyle(cs);
			}
		}
	}
	/**
	 * @return HSSFCellStyle Style
	 * @ 表头样式     总样式
	 */
	public HSSFCellStyle Style() {
		HSSFCellStyle style = wb.createCellStyle();
		// 设置边框
//		style.setBorderBottom(HSSFCellStyle.);
//		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
//		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
//		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		
		
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
		style.setBottomBorderColor(HSSFColor.BLACK.index);
		style.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
		style.setLeftBorderColor(HSSFColor.BLACK.index);
		style.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
		style.setRightBorderColor(HSSFColor.BLACK.index);
		style.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
		style.setTopBorderColor(HSSFColor.BLACK.index);
        
		// 设置边框颜色
		style.setTopBorderColor(HSSFColor.BLACK.index);
		style.setBottomBorderColor(HSSFColor.BLACK.index);
		style.setLeftBorderColor(HSSFColor.BLACK.index);
		style.setRightBorderColor(HSSFColor.BLACK.index);
		
		HSSFFont fon = wb.createFont();
		fon.setFontName("黑体");
		fon.setFontHeightInPoints((short) 16);// 设置字体大小
		fon.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 粗体显示
		
		style.setFont(fon);// 选择需要用到的字体格式
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//居中
		return style;
	}

//-----------------样式一------------------------------------------	
	
	/**
	 * @return HSSFCellStyle StyleOne
	 * @ 样式一  样式一  黄色背景  字体14
	 */
	public HSSFCellStyle StyleOne() {
		HSSFCellStyle style = Style();
		 //设置背景颜色
		style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
				
		HSSFFont fon = wb.createFont();
		fon.setFontName("黑体");
		fon.setFontHeightInPoints((short) 14);// 设置字体大小
		
		style.setFont(fon);// 选择需要用到的字体格式
		return style;
	}
	
	/**
	 * @return HSSFCellStyle StyleOne1
	 * @ 样式一  黄色背景  字体12
	 */
	public HSSFCellStyle StyleOne1() {
		HSSFCellStyle style = StyleOne();
		HSSFFont fon = wb.createFont();
		fon.setFontName("黑体");
		fon.setFontHeightInPoints((short) 12);// 设置字体大小
		style.setWrapText(true); 
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//上下居中 
		style.setFont(fon);// 选择需要用到的字体格式
		return style;
	}
	
//-----------------样式二------------------------------------------	
	
	/**
	 * @return HSSFCellStyle StyleTwo
	 * @ 样式二  橘色背景  字体14
	 */
	public HSSFCellStyle StyleTwo() {
		HSSFCellStyle style = Style();
		 //设置背景颜色
		style.setFillForegroundColor(IndexedColors.GOLD.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
				
		HSSFFont fon = wb.createFont();
		fon.setFontName("黑体");
		fon.setFontHeightInPoints((short) 14);// 设置字体大小
		
		style.setFont(fon);// 选择需要用到的字体格式
		return style;
	}
	
	
	/**
	 * @return HSSFCellStyle StyleTwo1
	 * @ 样式二  橘色背景  字体12
	 */
	public HSSFCellStyle StyleTwo1() {
		HSSFCellStyle style = StyleTwo();
		HSSFFont fon = wb.createFont();
		fon.setFontName("黑体");
		fon.setFontHeightInPoints((short) 12);// 设置字体大小
		style.setWrapText(true); 
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//上下居中 
		style.setFont(fon);// 选择需要用到的字体格式
		return style;
	}
	
//-----------------样式三------------------------------------------	
	
	/**
	 * @return HSSFCellStyle StyleThree
	 * @ 样式三  绿色背景  字体14
	 */
	public HSSFCellStyle StyleThree() {
		HSSFCellStyle style = Style();
		 //设置背景颜色
		style.setFillForegroundColor(IndexedColors.LIME.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
				
		HSSFFont fon = wb.createFont();
		fon.setFontName("黑体");
		fon.setFontHeightInPoints((short) 14);// 设置字体大小
		
		style.setFont(fon);// 选择需要用到的字体格式
		return style;
	}
	
	
	/**
	 * @return HSSFCellStyle StyleThree1
	 * @ 样式三  绿色背景  字体12
	 */
	public HSSFCellStyle StyleThree1() {
		HSSFCellStyle style = StyleThree();
		HSSFFont fon = wb.createFont();
		fon.setFontName("黑体");
		fon.setFontHeightInPoints((short) 12);// 设置字体大小
		style.setWrapText(true); 
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//上下居中 
		style.setFont(fon);// 选择需要用到的字体格式
		return style;
	}
	
	
	
//-----------------样式四------------------------------------------	
	/**
	 * @return HSSFCellStyle StyleFour
	 * @ 样式四  橘色背景  字体14
	 */
		public HSSFCellStyle StyleFour() {
			HSSFCellStyle style = Style();
			 //设置背景颜色
			style.setFillForegroundColor(IndexedColors.ROYAL_BLUE.getIndex());
			style.setFillPattern(CellStyle.SOLID_FOREGROUND);
					
			HSSFFont fon = wb.createFont();
			fon.setFontName("黑体");
			fon.setFontHeightInPoints((short) 14);// 设置字体大小
			
			style.setFont(fon);// 选择需要用到的字体格式
			return style;
		}
		
		
		
		/**
		 * @return HSSFCellStyle
		 * @ 样式四  橘色背景  字体12
		 */
		public HSSFCellStyle StyleFour1() {
			HSSFCellStyle style = StyleFour();
			HSSFFont fon = wb.createFont();
			fon.setFontName("黑体");
			fon.setFontHeightInPoints((short) 12);// 设置字体大小
			style.setWrapText(true);   //自动换行
			style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//上下居中 
			style.setFont(fon);// 选择需要用到的字体格式
			return style;
		}
}
