package com.java;
/**
 * 100Ǯ��100��
 * ������5/ֻ
 * ĸ��:3/ֻ
 * С����1/3ֻ
 * 
 * 100 ��100ֻ�� �ж��ٿ���
 * 
 * @�������ڣ�2017��03��07��
 *
 * @�޸ļ�¼���޸�ʱ�䡢���ߡ�ԭ�򣩣�
 *
 */
public class BuyChick {

	/**
	 * @��������: 2017��03��07��11:44:14 PM
	 *
	 * @����:
	 * @����ֵ:
	 *
	 * @�޸ļ�¼���޸�ʱ�䡢���ߡ�ԭ�򣩣�
	 */
	public static void main(String[] args) {
		
		//����
		for(int i = 0;i<100/5;i++){
			for(int j = 0;j<100/3;j++){
				for(int k = 0;k<100;k=k+3){
					int monery = i*5+ j*3+(k/3);
					int count = i+k+j;
					if(monery ==100&&count==100){
						System.out.println("������"+i+",ĸ����"+j+",С��:"+k);
					}
				}
			}
		}
		
	}

}
