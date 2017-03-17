package com.java;
/**
 * 100钱买100鸡
 * 公鸡：5/只
 * 母鸡:3/只
 * 小鸡：1/3只
 * 
 * 100 买100只鸡 有多少可能
 * 
 * @创建日期：2017年03月07日
 *
 * @修改记录（修改时间、作者、原因）：
 *
 */
public class BuyChick {

	/**
	 * @创建日期: 2017年03月07日11:44:14 PM
	 *
	 * @参数:
	 * @返回值:
	 *
	 * @修改记录（修改时间、作者、原因）：
	 */
	public static void main(String[] args) {
		
		//公鸡
		for(int i = 0;i<100/5;i++){
			for(int j = 0;j<100/3;j++){
				for(int k = 0;k<100;k=k+3){
					int monery = i*5+ j*3+(k/3);
					int count = i+k+j;
					if(monery ==100&&count==100){
						System.out.println("公鸡："+i+",母鸡："+j+",小鸡:"+k);
					}
				}
			}
		}
		
	}

}
