package com.mi;
//�����࣬�ͳ����޹�
public class test {

	public static void main(String[] args) {
	String a = "qwejhkhkjni�ٶ����Ұ��۷�f13216511&��ǰ�Ǵ���qw151515&dwddqqbwebqbb����ȥ���ȥ����vq4441";
	char [] c = a.toCharArray();
	char shut = '&';
	char [] x = new char[50];
	char [] y =new char[50];
	int p =0;
		for(int i=0,j=0;i<c.length;i++){
			if(shut != c[i]&&j==0){
				x[i] = c[i];
				System.out.print(x[i]);
			}else if(j>0){
				y[i] = c[i];
				System.out.print(y[i]);
			}else{
				j++;
				System.out.println();
				p=i;
				continue;
			}
		}
		String sx =x.toString();
		String sy = y.toString();
		/*System.out.println(sx);
		System.out.println(sy);*/
	}
}
