package com.ch01;

public class LoginForm1 {
	public static String login(String id, String password) {
		System.out.println("로그인 호출 성공");
		String mem_name = null;// 변수 선언만 했다. 초기화는 안했다. 미정이다.
		mem_name="강감찬";//6번에서 선언한 변수의 초기화. 디폴트값이 강감찬
		return mem_name;
	}
	 void methodA() {
		login("tomato", "123");
	}
	public static void main(String[] args) {
		//static영역안에서 non-static 영역 안에서는 호출이 불가능 하다.
		LoginForm1 loginForm1 = new LoginForm1();//생성자 인스턴스화
		String rmem_name=loginForm1.login("tomato", "123");
		System.out.println(rmem_name);
		

	}

}
