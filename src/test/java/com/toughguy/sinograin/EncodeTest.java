package com.toughguy.sinograin;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.tools.UnitConv;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.toughguy.sinograin.util.BarCodeUtil;
import com.toughguy.sinograin.util.SamplingUtil;
import com.toughguy.sinograin.util.WriteBitMatricToFile;

@RunWith(SpringJUnit4ClassRunner.class)
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
	public void testEncode1() {
		int width = 400;  
        int height = 200;  
        // int width = 105;  
        // int height = 50;  
        // 条形码的输入是13位的数字  
         String text = "6923450657712232342353";  
        // 二维码的输入是字符串  
        //String text = "testtesttest生成条形码图片";  
        String format = "png";  
        HashMap<EncodeHintType, String> hints = new HashMap<>();  
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        //hints.put(EncodeHintType.MARGIN,"2");
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
			e.printStackTrace();
		}  
    }
	@Test
	public void testEncode(){
		SamplingUtil s = new SamplingUtil();
		try {
			String a = s.SampleNumber(11, "33");
			String a1 = s.SampleNumber(1111, "玉米");
			System.out.println(a1);
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
	}
	/*@Test
	 * jBarcode 条形码生成
	 * Maven中央仓库中无对应jar包
	 * 需自己下载装到私服中 
	public void test() throws WriterException{
		JBarcodeBean jBarcodeBean = new JBarcodeBean();
		        // 条形码类型
		        //jBarcodeBean.setCodeType(new Ean13());
		        jBarcodeBean.setCodeType(new Code128());
		
		        //jBarcodeBean.setCodeType(new Code39());
		        jBarcodeBean.setBarcodeHeight(70);
		        // 在条形码下面显示文字
		
		        jBarcodeBean.setLabelPosition(JBarcodeBean.LABEL_BOTTOM);
		        OutputStream out;
		        try {
		
		            out = new FileOutputStream("a.png");
		
		            jBarcodeBean.setCode("692250700503-3111111");
		
		            BufferedImage image = new BufferedImage(200, 100,
		
		                    BufferedImage.TYPE_INT_RGB);
	
		            image = jBarcodeBean.draw(image);
		
		            ImageIO.write(image, "png", out);
		
		        } catch (FileNotFoundException e) {
		
		            e.printStackTrace();
		
		        }
		        // 设置条形码的值
		
		        catch (IOException e) {
		
		            e.printStackTrace();	
		    }
	}*/
	@Test
	public void testJBar4j() throws IOException{
		BarCodeUtil.generateFile("112334-2324", "code1.png");
	}
	@Test
	public void testPath(){
		String path = System.getProperty("user.dir");
		System.out.println(path);
	}
}
