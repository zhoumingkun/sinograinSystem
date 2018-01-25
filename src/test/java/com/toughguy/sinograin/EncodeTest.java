package com.toughguy.sinograin;

import java.io.File;
import java.util.HashMap;

import org.junit.Test;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.toughguy.sinograin.util.WriteBitMatricToFile;

public class EncodeTest {
//	BarcodeFormat.CODE_128; // 表示高密度数据， 字符串可变长，符号内含校验码  
//	BarcodeFormat.CODE_39;  
//	//BarcodeFormat.CODE_93;  
//	BarcodeFormat.CODABAR; // 可表示数字0 - 9，字符$、+、 -、还有只能用作起始/终止符的a,b,c d四个字符，可变长度，没有校验位  
//	BarcodeFormat.DATA_MATRIX; //二维码 
//	BarcodeFormat.EAN_8;  
//	BarcodeFormat.EAN_13;  
//	//BarcodeFormat.ITF;  
//	BarcodeFormat.PDF_417; // 二维码  
//	BarcodeFormat.QR_CODE; // 二维码  
//	//BarcodeFormat.RSS_EXPANDED;  
//	//BarcodeFormat.RSS_14;  
//	BarcodeFormat.UPC_E; // 统一产品代码E:7位数字,最后一位为校验位  
//	BarcodeFormat.UPC_A; // 统一产品代码A:12位数字,最后一位为校验位  
//	BarcodeFormat.UPC_EAN_EXTENSION;  

	@Test
	public void test() {
		int width = 400;  
        int height = 200;  
        // int width = 105;  
        // int height = 50;  
        // 条形码的输入是13位的数字  
         String text = "695013443-48";  
        // 二维码的输入是字符串  
        //String text = "testtesttest生成条形码图片";  
        String format = "png";  
        HashMap<EncodeHintType, String> hints = new HashMap<>();  
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        hints.put(EncodeHintType.MARGIN,"2");
        // 条形码的格式是 BarcodeFormat.EAN_13  
        // 二维码的格式是BarcodeFormat.QR_CODE  
        BitMatrix bm;
		try {
			//二维码
			//bm = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, hints);	
			//条形码
			bm = new MultiFormatWriter().encode(text,  
					BarcodeFormat.CODE_128, width, height, hints);
			// 生成条形码图片  
	        // File out = new File("ean3.png");  
			  File out = new File("new.png"); 
			  WriteBitMatricToFile.writeBitMatricToFile(bm, format, out);  
		} catch (WriterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
    }
	@Test
	public void testEncode(){
		
	}

}
