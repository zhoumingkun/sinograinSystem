package com.toughguy.sinograin.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

/**
 * 扦样编号工具类
 * @author BOBO
 *
 */
public class SamplingUtil {
		
	public String SampleNumber(int libraryId,String sort,String ranStr) throws IOException {
	 String lastSampleNo;	
	 String libraryName = String.format("%03d", libraryId);		
			lastSampleNo = "60"+libraryName + sort + ranStr;		
			return lastSampleNo;
	}
	
	public String SampleWork(String libraryName,String sort,String ranStr){
		return libraryName + "-" + sort + "-" + ranStr;
	}
	
	public String writeProperties() throws IOException{
		 String rootPath =getClass().getResource("/").getFile().toString();
		 String [] path = rootPath.split("/");
		 String p = null;
		 String ranStr = null;
		 String lastNo = null;
		 for(String s:path){
				if(StringUtils.isEmpty(p)){
					p = s+"/";
				}
				p = p+s+"/";
				if("target".equals(s)){
					break;
				}
			}
		InputStream	inStream = SamplingUtil.class.getClassLoader().getResourceAsStream("config/grain.properties"); 
			Properties prop = new Properties(); 
			prop.load(inStream);
			lastNo = prop.getProperty("grain.sampleNo");
			if("999".equals(lastNo)){
				ranStr = "1";
			}else{
				ranStr = (Integer.parseInt(lastNo.trim()) + 1) + "";
			}
			OutputStream out = new FileOutputStream(p+"classes/config/grain.properties");  
			prop.setProperty("grain.sampleNo", ranStr);
			prop.store(out,  null); 
			ranStr = String.format("%03d", Integer.parseInt(ranStr));	
			inStream.close();  
	        out.close();
		return ranStr;
	}
}
