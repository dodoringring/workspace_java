package com.ch01;
//A는 B이다
//자동차는 소나타이다
//소나타는 자동차이다
//상속관계로 처리한다
public class Hapexam4 extends Object{

	public static void main(String[] args) {
		//1부터 3까지 세는 숫자를 담는 변수 선언
		int count=1;//디폴트 값은 1이다.
		
		//1부터 3까지의 누적된 합을 담는 변수 선언
		int dap =2;
		dap=count+dap;//3=1+2
		count=count+1;//2
		dap=count+dap;
		count=count+1;
		dap=count+dap;
		System.out.println(dap);
		
	}

}
