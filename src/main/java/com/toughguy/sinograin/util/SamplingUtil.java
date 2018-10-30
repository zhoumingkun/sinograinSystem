package com.toughguy.sinograin.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
	
	public static String sampleNum (String sort) throws Exception{
		 //SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		// String year = sdf.format(new Date());
		 int flag = 1 ;
		 String sortInt = null;
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
	        if(sort.equals("小麦")) {
	        	sortInt = "01";
	        } else if(sort.equals("玉米")){
	        	sortInt = "02";
	        } else if(sort.equals("食用油")) {
	        	sortInt = "03";
	        }
		return  year + sortInt + lib;
	}
	
	public static Map<String, Object> smallSampleNums(Sample sample){
		Map<String, Object> map = new HashMap<String, Object>();
		List<String> list = new ArrayList<String>();
		if(!StringUtils.isEmpty(sample.getSampleNum())&&!StringUtils.isEmpty(sample.getCheckeds())){
			String sampleNum = sample.getSampleNum();
			String [] checks = sample.getCheckeds().split(",");
			int smallSample1 = 0;
			int smallSample7 = 0;
			String checkPoint1 = "";
			String checkPoint3 = "";
			String checkPoint4 = "";
			String checkPoint5 = "";
			String checkPoint6 = "";
			String checkPoint7 = "";
			String checkPoint8 = "";
				for(String s : checks){
					if(s.equals("1")) {
						smallSample1 = 1;
						checkPoint1 += s + ",";
					} else if(s.equals("2")) {
						String check = String.format("%02d", 3);
						list.add(sampleNum + "-" + check);
						checkPoint3 = s + ",";
					} else if(s.equals("3")) {
						smallSample1 = 1;
						checkPoint1 += s + ",";
					} else if(s.equals("4")) {
						smallSample1 = 1;
						checkPoint1 += s + ",";
					} else if(s.equals("5")) {
						smallSample1 = 1;
						checkPoint1 += s + ",";
					} else if(s.equals("6")) {
						smallSample1 = 1;
						checkPoint1 += s + ",";
					} else if(s.equals("8")) {
						String check = String.format("%02d", 4);
						list.add(sampleNum + "-" + check);
						checkPoint4 += s + ",";
					} else if(s.equals("9")) {
						String check = String.format("%02d", 5);
						list.add(sampleNum + "-" + check);
						checkPoint5 += s + ",";
					} else if(s.equals("10")) {
						String check = String.format("%02d", 8);
						list.add(sampleNum + "-" + check);
						checkPoint8 += s + ",";
					} else if(s.equals("11")) {
						String check = String.format("%02d", 6);
						list.add(sampleNum + "-" + check);
						checkPoint6 += s + ",";
					} else if(s.equals("13") || s.equals("14") || s.equals("15") || s.equals("16") || s.equals("17") || s.equals("18") || s.equals("19")) {
						smallSample7 = 7;
						checkPoint7 += s + ",";
					}
				}
			if(smallSample1 != 0) {
				String check = String.format("%02d", smallSample1);
				list.add(sampleNum + "-" + check);
			}
			if(smallSample7 != 0) {
				String check = String.format("%02d", smallSample7);
				list.add(sampleNum + "-" + check);
			}
			map.put("list", list);
			if(checkPoint1.length() != 0) {
				map.put("checkPoint1", checkPoint1.substring(0, checkPoint1.length()-1));
			}
			if(checkPoint3.length() != 0) {
			map.put("checkPoint3", checkPoint3.substring(0, checkPoint3.length()-1));
			}
			if(checkPoint4.length() != 0) {
				map.put("checkPoint4", checkPoint4.substring(0, checkPoint4.length()-1));
			}
			if(checkPoint5.length() != 0) {
				map.put("checkPoint5", checkPoint5.substring(0, checkPoint5.length()-1));
			}
			if(checkPoint6.length() != 0) {
				map.put("checkPoint6", checkPoint6.substring(0, checkPoint6.length()-1));
			}
			if(checkPoint7.length() != 0) {
				map.put("checkPoint7", checkPoint7.substring(0, checkPoint7.length()-1));
			}
			if(checkPoint8.length() != 0) {
				map.put("checkPoint8", checkPoint8.substring(0, checkPoint8.length()-1));
			}
		}
		return map;
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
