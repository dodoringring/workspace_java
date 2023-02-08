package com.ch01;

public class Variable3 {

	public static void main(String[] args) {
		//srting은 원시타입인가 참조형 타입인가
		//String은 참조형 타입이지만 예외적으로 값이 출력된다.
		String name = "이순신";
		System.out.println(name);
//		int i=(int)name; // 강제 형 전환 불가능하다
		int age = 30; //같은 이름의 변수는 다르게 선언 불가능
		String s_age="30";
		System.out.println(age+1);
		System.out.println(s_age+1);//31인지 301인지? 붙여쓴다
		System.out.println(10+1);//11
		System.out.println(10+"1");//101
		
		}

}
