package com.java;

import java.util.ArrayList;
import java.util.List;

public class test5 {
	//�����Ҫ���ĳɱ����㷨����ô��ABS�жϸ���Ϊ�����ڱ�������<br>

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
		System.out.println("��ӽ���ֵ��"+result);

		List<Integer> result2 = new ArrayList<Integer>();
		//k.near(list, result2, 0, 18);

		//System.out.println(result2);
	}

	public void near(List<Integer> list, List<Integer> result, int start, int capacity) {
		near(list, result, start, capacity, false);
	}
    //capacity��Ҫ�Ƚϵ���
	public void near(List<Integer> list, List<Integer> result, int start, int capacity, boolean minShort) {

		// ���������·������ô�õ����֮����������
		if (!minShort) {
			int count = count(result);//�������
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
		// �������е���ϣ�ȥ����ֵ��С����һ�������������Ը���࣬Ŀǰ��һ��ƫ�Ƽ��㣬�����ڶ�һ��ƫ�Ʊ������еݹ飬�Ͳ���д��
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i)>capacity) continue;
			num += list.get(i);//��ǰֵ
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
				//ȡ��̼���·��
				if (_result.size() > _result_temp.size()) {
					_result = (ArrayList<Integer>) _result_temp.clone();
				}
			}

			_result_temp = new ArrayList<Integer>();
		}

		if (Math.abs(count(result) - capacity) > Math.abs(count(_result) - capacity)) {
			fresh(result, _result);
		} else if (minShort && Math.abs(count(result) - capacity) == Math.abs(count(_result) - capacity)) {
			// ȥ��̼���·��
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
