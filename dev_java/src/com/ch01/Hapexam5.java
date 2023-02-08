package com.ch01;
//A는 B이다
//자동차는 소나타이다
//소나타는 자동차이다
//상속관계로 처리한다
public class Hapexam5 extends Object{

	public static void main(String[] args) {
		//1부터 5까지 짝수의 합 혹은 홀수의 합을 구하는 프로그램을 작성하시오
//		//짝수
//        int count=2;//디폴트 값은 1이다.
//		
//		//1부터 3까지의 누적된 합을 담는 변수 선언
//		int dap =0;
//		dap=count+dap;//2=2+0
//		count=count+2;//2
//		dap=count+dap;//6=4+2
//		count=count+2;//count:6---5를 넘어섬 멈추기
//	
//		System.out.println(dap);
		
		//홀수
		//1부터 5까지의 합을 구할때는 세번 반복해야된다.
		// 만일 짝수의 합을 구하는 거라면 연산은 2번만 반복하면 됨.
		//우리가 if문을 배워야 하는 이유이다.
        int count=1;//디폴트 값은 1이다.
		
		//1부터 3까지의 누적된 합을 담는 변수 선언
		int dap =0;
		dap=count+dap;//1=1+0
		count=count+2;//3
		dap=count+dap;//4=3+1
		count=count+2;//count:5
		dap=count+dap; //9=5+4
		count=count+2;//count:7
		//만약에 count가 5보다 크면 연산하지 말것. 더이상 합을 구할 필요가 없다.
				if(count>5) {
				    System.out.println("여기로 들어오면 [count가 5보다 크면]출력됨===>"+count);
					return; // 이조건을 만족하면 메인 메소드를 빠져 나가라.
				}
		dap=count+dap; //16=7+9
	
		System.out.println(dap);
	}

}
