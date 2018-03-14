package com.toughguy.sinograin.util;

/**
 * 扦样编号工具类
 * @author BOBO
 *
 */
public class SamplingUtil {
		
	public String SampleNo(int libraryId,String sort,int ranStr)  {
	 String lastSampleNo;
	 String libraryName = String.format("%03d", libraryId);
	 String lib = String.format("%03d", ranStr);
			lastSampleNo = "60"+libraryName + sort + lib;		
			return lastSampleNo;
	}
	
	public String SampleWork(String libraryName,String sort,int ranStr){
		String lib = String.format("%03d", ranStr);
		return libraryName + "-" + sort + "-" + lib;
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
