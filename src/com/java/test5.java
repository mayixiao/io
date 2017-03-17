package com.java;

import java.util.ArrayList;
import java.util.List;

public class test5 {
	//如果需要更改成背包算法，那么将ABS判断更改为不大于背包总量<br>

	public static void main(final String... args) {
			List<Integer> list = new ArrayList<Integer>();
			list.add(19);
			list.add(18);
			list.add(30);
			list.add(25);
			list.add(20);
			list.add(21);

			list.add(22);


			list.add(16);
		list.add(3);
		test5 k = new test5();
		List<Integer> result = new ArrayList<Integer>();
		
		k.near(list, result, 0, 22, true);
		System.out.println("最接近的值："+result);

		List<Integer> result2 = new ArrayList<Integer>();
		//k.near(list, result2, 0, 18);

		//System.out.println(result2);
	}

	public void near(List<Integer> list, List<Integer> result, int start, int capacity) {
		near(list, result, start, capacity, false);
	}
    //capacity需要比较的数
	public void near(List<Integer> list, List<Integer> result, int start, int capacity, boolean minShort) {

		// 不计算最短路径，那么得到相等之后立即跳出
		if (!minShort) {
			int count = count(result);//结果集合
			if (count == capacity) {
				return;
			}
		}

		if (start == list.size()) {
			return;
		}

		int num = 0;
		ArrayList<Integer> _result_temp = new ArrayList<Integer>();

		ArrayList<Integer> _result = new ArrayList<Integer>();
		// 计算所有的组合，去绝对值最小的那一个，这里代码可以更简洁，目前仅一个偏移计算，可以在多一个偏移变量进行递归，就不多写了
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i)>capacity) continue;
			num += list.get(i);//当前值
			_result_temp.add(list.get(i));
			System.out.println(_result_temp+"i="+i);
			for (int j = start + 1; j < list.size() && j != i; j++) {
				_result_temp.add(list.get(j));
				System.out.println(_result_temp+"i="+i+"j="+j);
				//8   3
				if(count(_result_temp)<=capacity){
					if (Math.abs(num - capacity) < Math.abs(count(_result_temp) - capacity)) {
						_result_temp.remove(list.get(j));
					} else {
						num = count(_result_temp);
					}
				}else{
					_result_temp.remove(list.get(j));
				}
				
			}
			num = 0;
			if (Math.abs(count(_result_temp) - capacity) < Math.abs(count(_result) - capacity)) {
				_result = (ArrayList<Integer>) _result_temp.clone();
			} else if (minShort && Math.abs(count(_result_temp) - capacity) == Math.abs(count(_result) - capacity)) {
				//取最短计算路径
				if (_result.size() > _result_temp.size()) {
					_result = (ArrayList<Integer>) _result_temp.clone();
				}
			}

			_result_temp = new ArrayList<Integer>();
		}

		if (Math.abs(count(result) - capacity) > Math.abs(count(_result) - capacity)) {
			fresh(result, _result);
		} else if (minShort && Math.abs(count(result) - capacity) == Math.abs(count(_result) - capacity)) {
			// 去最短计算路径
			if (result.size() > _result.size()) {
				fresh(result, _result);
			}
		}
		//near(list, result, ++start, capacity, minShort);

	}

	private void fresh(List<Integer> result, ArrayList<Integer> _result) {
		result.clear();
		for (int i = 0; i < _result.size(); i++) {
			result.add(_result.get(i).intValue());
		}
	}

	private int count(List<Integer> result) {
		int count = 0;
		for (Integer integer : result) {
			count += integer;
		}
		return count;
	}
}
