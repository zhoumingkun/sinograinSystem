package com.toughguy.sinograin.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 扦样编号工具类
 * @author BOBO
 *
 */
public class SamplingUtil {
	
	
	public static String SampleNumber(String libraryName,String sort) {
	 String lastSampleNo;
	 String ranStr = null;
		try {
			InputStream inStream = SamplingUtil.class.getClassLoader().getResourceAsStream("config/grain.properties"); 
			Properties prop = new Properties(); 
			prop.load(inStream);
			lastSampleNo = prop.getProperty("grain.sampleNo");
			if("9999".equals(lastSampleNo)){
				ranStr = "1";
			}else{
				ranStr = (Integer.parseInt(lastSampleNo) + 1) + "";
			}
			ranStr = String.format("%04d", ranStr);
			prop.setProperty("grain.sampleNo", ranStr);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		lastSampleNo = libraryName + "-" + sort + "-" + ranStr;
		return lastSampleNo;
	}
}
