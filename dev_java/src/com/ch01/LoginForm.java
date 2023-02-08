package com.ch01;

public class LoginForm {
	public static String login(String id, String password) {
		System.out.println("로그인 호출 성공");
		String mem_name = null;// 변수 선언만 했다. 초기화는 안했다. 미정이다.
		mem_name="강감찬";//6번에서 선언한 변수의 초기화. 디폴트값이 강감찬
		//return "이순신";
//		return id;
		return mem_name;
	}

	//실행순서 14-15
	public static void main(String[] args) {
		login("tomato", "123");
		//inset here - 강감찬 힌트 대입 연산자
		System.out.println(login("tomato", "123"));
		
		String rmem_name=login("tomato", "123");
		System.out.println(rmem_name);
		System.out.println(login("tomato", "123"));

	}

}
