package com.ch01;

public class P13 {

	public static void main(String[] args) {
		System.out.println(5+0.5);//상수 변하지않음 변수는 변함. 변수를 사용하지 않은 코드
	
		byte b=5;
		float f=0.5f;
//		byte+float=>float이다
//		byte-float=>float이다->int-float연산을 함
		System.out.println(b+f);//변수를 활용하였다.
		System.out.println(275);//변수를 활용하였다.
		System.out.println(275/3);//int/int=>int
		System.out.println(275/3.0);//int/double=>double
		System.out.println(275.0/3);//double/int=>double
		System.out.println(275.0/3.0);//double/double=>double
		
		int x=(int)3.0;//()없이는 안됨 왼쪽. 즉, 담기는 쪽의 타입을 적어 넣는다.
		System.out.println(x);//3
		System.out.println(x+1);//3
		System.out.println(x+1.0);//3
		

	}

}
