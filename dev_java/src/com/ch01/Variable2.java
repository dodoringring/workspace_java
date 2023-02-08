package com.ch01;
//char<byte<short<int<long<float<double
//boolean
public class Variable2 {

	public static void main(String[] args) {
		int i = 2;
		int j = i;// j=2가 대입되었다
		System.out.println(j);
		System.out.println(i==j);//같니? true
		System.out.println(i!=j);// 다르니? false
		double d = 2.4;
		//대입 연산자 오른쪽에 더 큰 타입이 오는것은 안된다.
		//괄호가 변수명 앞에 오면 형전환 연산자- casting연산자
     	j=(int)d;
     	System.out.println(j);
     	//강제 형전환 소수점 떼버림 2만 남아
		boolean isOk=false;
//		j=(int)isOK; 정수형과 불리언은 강제 형 전환이 불가능 하다.
		
		
		
	}

}
