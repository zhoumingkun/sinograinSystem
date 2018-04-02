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

	/**
	 * @return HSSFCellStyle Style
	 * @ 表头样式     总样式
	 */
	public HSSFCellStyle Style(HSSFWorkbook wb) {
		HSSFCellStyle style = wb.createCellStyle();
		// 设置边框	
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
	public HSSFCellStyle StyleOne(HSSFWorkbook wb) {
		HSSFCellStyle style = Style(wb);
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
	public HSSFCellStyle StyleOne1(HSSFWorkbook wb) {
		HSSFCellStyle style = StyleOne(wb);
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
		public HSSFCellStyle StyleTwo(HSSFWorkbook wb) {
			HSSFCellStyle style = Style(wb);
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
		public HSSFCellStyle StyleTwo1(HSSFWorkbook wb) {
			HSSFCellStyle style = StyleTwo(wb);
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
		public HSSFCellStyle StyleThree(HSSFWorkbook wb) {
			HSSFCellStyle style = Style(wb);
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
		public HSSFCellStyle StyleThree1(HSSFWorkbook wb) {
			HSSFCellStyle style = StyleThree(wb);
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
			public HSSFCellStyle StyleFour(HSSFWorkbook wb) {
				HSSFCellStyle style = Style(wb);
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
			public HSSFCellStyle StyleFour1(HSSFWorkbook wb) {
				HSSFCellStyle style = StyleFour(wb);
				HSSFFont fon = wb.createFont();
				fon.setFontName("黑体");
				fon.setFontHeightInPoints((short) 12);// 设置字体大小
				style.setWrapText(true); 
				style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//上下居中 
				style.setFont(fon);// 选择需要用到的字体格式
		        return style;
			}


}
