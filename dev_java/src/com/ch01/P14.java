package com.ch01;

public class P14 {

	public static void main(String[] args) {
		float f=1.2f;
		//실수형 뒤에 d가 없으면 더블타입이다.생략가능함
		double d=3.5d;//d는 생략가능
		System.out.println(f);
		System.out.println(d);
//		f=d; 안됨 오른쪽에는 작은것만 와야한다.
		d=f;//괜찮음
		

	}

}
