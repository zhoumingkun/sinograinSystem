package com.toughguy.sinograin.util;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
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
//		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
//		style.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
//		style.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
//		style.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
//		style.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
		
//		style.setRightBorderColor(HSSFColor.BLACK.index);
//		style.setLeftBorderColor(HSSFColor.BLACK.index);
//		style.setTopBorderColor(HSSFColor.BLACK.index);
//		style.setBottomBorderColor(HSSFColor.BLACK.index);
//		// 设置边框颜色
//		style.setTopBorderColor(HSSFColor.BLACK.index);
//		style.setBottomBorderColor(HSSFColor.BLACK.index);
//		style.setLeftBorderColor(HSSFColor.BLACK.index);
//		style.setRightBorderColor(HSSFColor.BLACK.index);
		
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
		
		
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

			/**
			 * @return HSSFCellStyle
			 * @ 样式五  橘色背景  字体12
			 */
			public HSSFCellStyle Style1(HSSFWorkbook wb) {
				HSSFCellStyle style = Style(wb);
				HSSFFont fon = wb.createFont();
				fon.setFontName("黑体");
				fon.setFontHeightInPoints((short) 10);// 设置字体大小
				style.setWrapText(true); 
				 style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//居中
				style.setFont(fon);// 选择需要用到的字体格式
				return style;
			}
			
			
			public HSSFCellStyle Style2(HSSFWorkbook wb) {
				HSSFCellStyle style = Style(wb);
				HSSFFont fon = wb.createFont();
				fon.setFontName("黑体");
				fon.setFontHeightInPoints((short) 10);// 设置字体大小
				style.setWrapText(true); 
				style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//上下居中 
				style.setFont(fon);// 选择需要用到的字体格式
				return style;
			}
			//工作底稿导出样式
			public HSSFCellStyle Style3(HSSFWorkbook wb) {
				HSSFCellStyle style = wb.createCellStyle();
				HSSFFont fon = wb.createFont();
				fon.setFontName("宋体");
				fon.setFontHeightInPoints((short) 11);// 设置字体大小
				style.setFont(fon);// 选择需要用到的字体格式
				style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//居中
				style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//上下居中 
				style.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
	            HSSFDataFormat format2 = wb.createDataFormat();
	            style.setDataFormat(format2.getFormat("0.0"));//设置单元类型保留一位小数
				return style;
			}
			public HSSFCellStyle Style4(HSSFWorkbook wb) {
				HSSFCellStyle style = wb.createCellStyle();
				HSSFFont fon = wb.createFont();
				fon.setFontName("宋体");
				fon.setFontHeightInPoints((short) 11);// 设置字体大小
				style.setFont(fon);// 选择需要用到的字体格式
				style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//居中
				style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//上下居中 
				style.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
				style.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
				style.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
				style.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
	            HSSFDataFormat format2 = wb.createDataFormat();
	            style.setDataFormat(format2.getFormat("0.00"));//设置单元类型保留两位小数
				return style;
			}
			public HSSFCellStyle Style5(HSSFWorkbook wb) {
				HSSFCellStyle style = wb.createCellStyle();
				HSSFFont fon = wb.createFont();
				fon.setFontName("宋体");
				fon.setFontHeightInPoints((short) 11);// 设置字体大小
				style.setFont(fon);// 选择需要用到的字体格式
				style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//居中
				style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//上下居中 
				style.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
				style.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
				style.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
	            HSSFDataFormat format2 = wb.createDataFormat();
	            style.setDataFormat(format2.getFormat("0.00"));//设置单元类型保留两位小数
				return style;
			}
			/**
			* 导出样品交接单样式
			*/
			public HSSFCellStyle Style6(HSSFWorkbook wb) {
				HSSFCellStyle style = wb.createCellStyle();
				HSSFFont fon = wb.createFont();
				fon.setFontName("宋体");
				fon.setFontHeightInPoints((short) 11);// 设置字体大小
				style.setFont(fon);// 选择需要用到的字体格式
				style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//居中
				style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//上下居中 
				style.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
				style.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
				style.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
				style.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
				return style;
			}
			public HSSFCellStyle Style7(HSSFWorkbook wb) {
				HSSFCellStyle style = wb.createCellStyle();
				HSSFFont fon = wb.createFont();
				fon.setFontName("宋体");
				fon.setFontHeightInPoints((short) 11);// 设置字体大小
				style.setFont(fon);// 选择需要用到的字体格式
				style.setAlignment(HSSFCellStyle.ALIGN_RIGHT);//居右
				style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//上下居中 
				style.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
				style.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
				style.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
				style.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
				return style;
			}
			/**
			* 设置单元格边框（解决合并单元格显示部分边框问题）
			* @param sheet 
			* @param region
			* @param cs
			*/
			@SuppressWarnings("deprecation")
			public static void setRegionStyle(HSSFSheet sheet, Region region, HSSFCellStyle cs) {
			 for (int i = region.getRowFrom(); i <= region.getRowTo(); i++) {
			  HSSFRow row = HSSFCellUtil.getRow(i, sheet);
			  for (int j = region.getColumnFrom(); j <= region.getColumnTo(); j++) {
			   HSSFCell cell = HSSFCellUtil.getCell(row, (short) j);
			   cell.setCellStyle(cs);
			  }
			 }
			}
			
			/** 
			 * 样品登记薄样式
			 * @param wb
			 * @return
			 */
			public HSSFCellStyle StyleSamplePlace(HSSFWorkbook wb) {
				HSSFCellStyle style = Style(wb);
				HSSFFont fon = wb.createFont();
				fon.setFontName("宋体");
				fon.setFontHeightInPoints((short) 11);// 设置字体大小
				style.setWrapText(true); 
				style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//居中
				style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//上下居中 
				style.setFont(fon);// 选择需要用到的字体格式
				style.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
				style.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
				style.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
				style.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
				return style;
			}
			/**
			* 导出样品确认单样式
			*/
			public HSSFCellStyle Style8(HSSFWorkbook wb) {
				HSSFCellStyle style = wb.createCellStyle();
				HSSFFont fon = wb.createFont();
				fon.setFontName("宋体");
				fon.setFontHeightInPoints((short) 11);// 设置字体大小
				style.setFont(fon);// 选择需要用到的字体格式
				style.setAlignment(HSSFCellStyle.ALIGN_LEFT);//居左
				style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//上下居中 
				style.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
				style.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
				style.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
				style.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
				return style;
			}
			/**
			* 导出监督检查档案样式
			*/
			//字体加粗+上边框加粗+下边框加粗+左边框加粗
			public HSSFCellStyle Style9(HSSFWorkbook wb) {
				HSSFCellStyle style = wb.createCellStyle();
				HSSFFont fon = wb.createFont();
				fon.setFontName("宋体");
				fon.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体
				fon.setFontHeightInPoints((short) 11);// 设置字体大小
				style.setFont(fon);// 选择需要用到的字体格式
				style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//居中
				style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//上下居中
				style.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);//上边框加粗
				style.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
				style.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM); //下边框加粗
				style.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);//左边框加粗
				return style;
			}
			//上边框加粗
			public HSSFCellStyle Style10(HSSFWorkbook wb) {
				HSSFCellStyle style = wb.createCellStyle();
				HSSFFont fon = wb.createFont();
				fon.setFontName("宋体");
				fon.setFontHeightInPoints((short) 10);// 设置字体大小
				style.setFont(fon);// 选择需要用到的字体格式
				style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//居中
				style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//上下居中
				style.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);//上边框加粗
				style.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
				style.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
				style.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
				return style;
			}
			//换行+下边框加粗
			public HSSFCellStyle Style11(HSSFWorkbook wb) {
				HSSFCellStyle style = wb.createCellStyle();
				HSSFFont fon = wb.createFont();
				fon.setFontName("宋体");
				fon.setFontHeightInPoints((short) 10);// 设置字体大小
				style.setFont(fon);// 选择需要用到的字体格式
				style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//居中
				style.setWrapText(true);  //自动换行
				style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//上下居中
				style.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
				style.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
				style.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM); //下边框加粗
				style.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
				return style;
			}
			//右边框加粗+下边框加粗
			public HSSFCellStyle Style12(HSSFWorkbook wb) {
				HSSFCellStyle style = wb.createCellStyle();
				HSSFFont fon = wb.createFont();
				fon.setFontName("宋体");
				fon.setFontHeightInPoints((short) 10);// 设置字体大小
				style.setFont(fon);// 选择需要用到的字体格式
				style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//居中
				style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//上下居中
				style.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
				style.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);//右边框加粗
				style.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM); //下边框加粗
				style.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
				return style;
			}
			//上边框加粗+右边框加粗
			public HSSFCellStyle Style13(HSSFWorkbook wb) {
				HSSFCellStyle style = wb.createCellStyle();
				HSSFFont fon = wb.createFont();
				fon.setFontName("宋体");
				fon.setFontHeightInPoints((short) 10);// 设置字体大小
				style.setFont(fon);// 选择需要用到的字体格式
				style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//居中
				style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//上下居中
				style.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);//上边框加粗
				style.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);//右边框加粗
				style.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
				style.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
				return style;
			}
			//字体加粗+换行+上边框加粗+左边框加粗
			public HSSFCellStyle Style17(HSSFWorkbook wb) {
				HSSFCellStyle style = wb.createCellStyle();
				HSSFFont fon = wb.createFont();
				fon.setFontName("宋体");
				fon.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体
				fon.setFontHeightInPoints((short) 10);// 设置字体大小
				style.setFont(fon);// 选择需要用到的字体格式
				style.setWrapText(true);  //自动换行
				style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//居中
				style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//上下居中
				style.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);//上边框加粗
				style.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
				style.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
				style.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);//左边框加粗
				return style;
			}
			//字体加粗+下边框加粗+左边框加粗
			public HSSFCellStyle Style18(HSSFWorkbook wb) {
				HSSFCellStyle style = wb.createCellStyle();
				HSSFFont fon = wb.createFont();
				fon.setFontName("宋体");
				fon.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体
				fon.setFontHeightInPoints((short) 10);// 设置字体大小
				style.setFont(fon);// 选择需要用到的字体格式
				style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//居中
				style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//上下居中
				style.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
				style.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
				style.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM); //下边框加粗
				style.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);//左边框加粗
				return style;
			}
			//字体加粗+上边框加粗+下边框加粗
			public HSSFCellStyle Style19(HSSFWorkbook wb) {
				HSSFCellStyle style = wb.createCellStyle();
				HSSFFont fon = wb.createFont();
				fon.setFontName("宋体");
				fon.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体
				fon.setFontHeightInPoints((short) 10);// 设置字体大小
				style.setFont(fon);// 选择需要用到的字体格式
				style.setWrapText(true);  //自动换行
				style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//居中
				style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//上下居中
				style.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);//上边框加粗
				style.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
				style.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM); //下边框加粗
				style.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
				return style;
			}
			//换行+上下左右边框
			public HSSFCellStyle Style20(HSSFWorkbook wb) {
				HSSFCellStyle style = wb.createCellStyle();
				HSSFFont fon = wb.createFont();
				fon.setFontName("宋体");
				fon.setFontHeightInPoints((short) 10);// 设置字体大小
				style.setFont(fon);// 选择需要用到的字体格式
				style.setWrapText(true);  //自动换行
				style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//居中
				style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//上下居中
				style.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
				style.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
				style.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
				style.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
				return style;
			}
			//换行+上边框加粗+下边框加粗+右边框加粗
			public HSSFCellStyle Style21(HSSFWorkbook wb) {
				HSSFCellStyle style = wb.createCellStyle();
				HSSFFont fon = wb.createFont();
				fon.setFontName("宋体");
				fon.setFontHeightInPoints((short) 10);// 设置字体大小
				style.setFont(fon);// 选择需要用到的字体格式
				style.setWrapText(true);  //自动换行
				style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//居中
				style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//上下居中
				style.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);//上边框加粗
				style.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);//右边框加粗
				style.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM); //下边框加粗
				style.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
				return style;
			}
			//无边框基础样式
			public HSSFCellStyle Style22(HSSFWorkbook wb) {
				HSSFCellStyle style = wb.createCellStyle();
				HSSFFont fon = wb.createFont();
				fon.setFontName("宋体");
				fon.setFontHeightInPoints((short) 10);// 设置字体大小
				style.setFont(fon);// 选择需要用到的字体格式
				style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//居中
				style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//上下居中
				return style;
			}
			//边框加粗+等级的数字转换
			public HSSFCellStyle Style23(HSSFWorkbook wb) {
				HSSFCellStyle style = wb.createCellStyle();
				HSSFFont fon = wb.createFont();
				fon.setFontName("宋体");
				fon.setFontHeightInPoints((short) 10);// 设置字体大小
				style.setFont(fon);// 选择需要用到的字体格式
		        HSSFDataFormat format=wb.createDataFormat();
		        style.setDataFormat(format.getFormat("[DbNum1][$-804]0等"));
				style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//居中
				style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//上下居中
				style.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);//上边框加粗
				style.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
				style.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
				style.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
				return style;
			}
			//长宽高保留两位小数 
			public HSSFCellStyle Style24(HSSFWorkbook wb) {
				HSSFCellStyle style = wb.createCellStyle();
				HSSFFont fon = wb.createFont();
				fon.setFontName("宋体");
				fon.setFontHeightInPoints((short) 10);// 设置字体大小
				style.setFont(fon);// 选择需要用到的字体格式
				style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//居中
				style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//上下居中
				style.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
				style.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
				style.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
				style.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
				HSSFDataFormat format2 = wb.createDataFormat();
	            style.setDataFormat(format2.getFormat("0.00"));//设置单元类型保留两位小数
				return style;
			}
			//保留一位小数 
			public HSSFCellStyle Style25(HSSFWorkbook wb) {
				HSSFCellStyle style = wb.createCellStyle();
				HSSFFont fon = wb.createFont();
				fon.setFontName("宋体");
				fon.setFontHeightInPoints((short) 10);// 设置字体大小
				style.setFont(fon);// 选择需要用到的字体格式
				style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//居中
				style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//上下居中
				style.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
				style.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
				style.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
				style.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
				HSSFDataFormat format2 = wb.createDataFormat();
	            style.setDataFormat(format2.getFormat("0.0"));//设置单元类型保留一位小数
				return style;
			}
			//下边框加粗+保留一位
			public HSSFCellStyle Style26(HSSFWorkbook wb) {
				HSSFCellStyle style = wb.createCellStyle();
				HSSFFont fon = wb.createFont();
				fon.setFontName("宋体");
				fon.setFontHeightInPoints((short) 10);// 设置字体大小
				style.setFont(fon);// 选择需要用到的字体格式
				style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//居中
				style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//上下居中
				style.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
				style.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
				style.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM); //下边框加粗
				style.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
				HSSFDataFormat format2 = wb.createDataFormat();
				style.setDataFormat(format2.getFormat("0.0"));//设置单元类型保留一位小数
				return style;
			}
			/**
			 * @return HSSFCellStyle
			 * @ 导出总表保留小数样式
			 */
			public HSSFCellStyle Style14(HSSFWorkbook wb) {
				HSSFCellStyle style = Style(wb);
				HSSFFont fon = wb.createFont();
				fon.setFontName("黑体");
				fon.setFontHeightInPoints((short) 10);// 设置字体大小
				style.setWrapText(true); 
				 style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//居中
				style.setFont(fon);// 选择需要用到的字体格式
				HSSFDataFormat format2 = wb.createDataFormat();
	            style.setDataFormat(format2.getFormat("0.00"));//设置单元类型保留两位小数
				return style;
			}
			public HSSFCellStyle Style15(HSSFWorkbook wb) {
				HSSFCellStyle style = Style(wb);
				HSSFFont fon = wb.createFont();
				fon.setFontName("黑体");
				fon.setFontHeightInPoints((short) 10);// 设置字体大小
				style.setWrapText(true); 
				 style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//居中
				style.setFont(fon);// 选择需要用到的字体格式
				HSSFDataFormat format2 = wb.createDataFormat();
	            style.setDataFormat(format2.getFormat("0.0"));//设置单元类型保留一位小数
				return style;
			}
			public HSSFCellStyle Style16(HSSFWorkbook wb) {
				HSSFCellStyle style = Style(wb);
				HSSFFont fon = wb.createFont();
				fon.setFontName("黑体");
				fon.setFontHeightInPoints((short) 10);// 设置字体大小
				style.setWrapText(true); 
				 style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//居中
				style.setFont(fon);// 选择需要用到的字体格式
				HSSFDataFormat format2 = wb.createDataFormat();
	            style.setDataFormat(format2.getFormat("0"));//设置单元类型保留整数
				return style;
			}
			//总表的等级转换
			public HSSFCellStyle Style27(HSSFWorkbook wb) {
				HSSFCellStyle style = Style(wb);
				HSSFFont fon = wb.createFont();
				fon.setFontName("黑体");
				fon.setFontHeightInPoints((short) 10);// 设置字体大小
				HSSFDataFormat format=wb.createDataFormat();
		        style.setDataFormat(format.getFormat("[DbNum1][$-804]0等"));
				style.setWrapText(true); 
				style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//居中
				style.setFont(fon);// 选择需要用到的字体格式
				return style;
			}
			
}
