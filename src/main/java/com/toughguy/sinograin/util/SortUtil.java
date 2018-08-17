package com.toughguy.sinograin.util;

/**
 * 排序工具类
 * @author BOBO
 *
 */
public class SortUtil {
	
	/**
	 * 冒泡排序
	 * @return
	 */
	public static int[] bubbleSort(int[] arr) {
		for(int i=0;i<arr.length-1;i++){//外层循环控制排序趟数
			for(int j=0;j<arr.length-1-i;j++){//内层循环控制每一趟排序多少次
				if(arr[j]>arr[j+1]){
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		return arr;
	}

}
