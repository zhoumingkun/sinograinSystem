package com.toughguy.sinograin.util;

/**
 * 扦样编号工具类
 * @author BOBO
 *
 */
public class SamplingUtil {
	
	private static String lastSampleNo;
	public static String SampleNumber(String libraryName,String sort) {
		String ranStr;
		if( "".equals(lastSampleNo) ||lastSampleNo == null) {
			ranStr = String.format("%04d", 1);
		} else {
			String[] nums = lastSampleNo.split("-");
			int num = Integer.parseInt(nums[2]);
			ranStr = String.format("%04d", num+1);
		}
		lastSampleNo = libraryName + "-" + sort + "-" + ranStr;
		return lastSampleNo;
	}
}
