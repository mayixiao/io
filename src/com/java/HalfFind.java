package com.java;


/**
 * 二分法查找 折半查找
 * @创建日期：2017年03月05日
 *
 * @修改记录（修改时间、作者、原因）：
 *
 */
public class HalfFind {

	public static void main(String[] args) {
		//前提是数组得是有序的
		int[] arr = {1,3,4,7,9,30,80};
		int min = 0;
		int max = arr.length-1;
		//需要找的数
		int num =0;
		//需要查找的下标
		int index  = -1; //默认为-1，查不到也返回-1
		while(min <= max){
			int mid = (min+max)/2;
			if(arr[mid]==num){
				index = mid;
				break;
			}else if(arr[mid]>num){//范围在左半侧
				max = mid -1;
			}else{//范围在右半侧
				min = mid +1;
			}
		}
		System.out.println("你要查找的"+num +"所在的下标位置为："+index);
	}
}
