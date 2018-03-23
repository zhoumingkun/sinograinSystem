package com.toughguy.sinograin.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

import com.toughguy.sinograin.model.barn.Sample;

/**
 * 扦样编号工具类
 * @author BOBO
 *
 */
public class SamplingUtil {
		
	public static String sampleNo(int libraryId,String sort,int ranStr)  {
	 String lastSampleNo;
	 String libraryName = String.format("%03d", libraryId);
	 String lib = String.format("%03d", ranStr);
			lastSampleNo = "60"+libraryName + sort + lib;		
			return lastSampleNo;
	}
	
	public static String sampleWork(String libraryName,String sort,int ranStr){
		String lib = String.format("%03d", ranStr);
		return libraryName + "-" + sort + "-" + lib;
	}
	
	public static String sampleNum () throws Exception{
		 //SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		// String year = sdf.format(new Date());
		 int flag = 1 ;
		 Calendar date = Calendar.getInstance();
	     String year = String.valueOf(date.get(Calendar.YEAR));
		 //String year = "2019";
	     FileInputStream fileInput = new FileInputStream("C:/java/sinograin/grain.properties");
	     Properties prop = new Properties(); 
	     prop.load(fileInput);
	     //判断该字段文件中是否存在
	     Iterator itr = prop.entrySet().iterator();
	        while (itr.hasNext()){
	            Entry<String,String> e = (Entry)itr.next();
	            System.out.println(e.getKey() + ": " + e.getValue());
	            if (e.getKey().indexOf("grain."+year) >= 0 ) {
	            	flag = 2;
	                break;
	            }else{
	            	flag = 1;
	            }
	        } 
	        if(flag == 1){
	        	prop.setProperty("grain."+year, "1");
	        }
	    	String s = prop.getProperty("grain."+year).trim();
	     String lib = String.format("%04d", Integer.parseInt(s));
	     OutputStream out = new FileOutputStream("C:/java/sinograin/grain.properties");  
			prop.setProperty("grain."+year, (Integer.parseInt(s) + 1)+"");
			prop.store(out,  null);
			fileInput.close();  
	        out.close();
		return  year + lib;
	}
	
	public static List<String> smallSampleNums(Sample sample){
		List <String> list = new ArrayList<String>();
		if(!StringUtils.isEmpty(sample.getSampleNum())&&!StringUtils.isEmpty(sample.getCheckeds())){
			String sampleNum = sample.getSampleNum().substring(1);
			String [] checks = sample.getCheckeds().split(",");
			for(String s : checks){
				String check = String.format("%02d", Integer.parseInt(s));
				list.add(sampleNum + "-" + check);
			}
		}
		return list;
	}
/*	public String writeProperties() throws IOException{
		 String ranStr = null;
		 String lastNo = null;
		 	FileInputStream fileInput = new FileInputStream("C:/java/sinograin/grain.properties"); 
		 	//InputStream	inStream = SamplingUtil.class.getClassLoader().getResourceAsStream("config/grain.properties"); 
			Properties prop = new Properties(); 
			prop.load(fileInput);
			lastNo = prop.getProperty("grain.sampleNo");
			if("999".equals(lastNo)){
				ranStr = "1";
			}else{
				ranStr = (Integer.parseInt(lastNo.trim()) + 1) + "";
			}
			OutputStream out = new FileOutputStream("C:/java/sinograin/grain.properties");  
			prop.setProperty("grain.sampleNo", ranStr);
			prop.store(out,  null); 
			ranStr = String.format("%03d", Integer.parseInt(ranStr));	
			fileInput.close();  
	        out.close();
		return ranStr;
	}*/
}
