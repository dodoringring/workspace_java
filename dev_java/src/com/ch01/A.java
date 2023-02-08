package com.ch01;

public class A {
	double pi = 3.14;//전변

	public static void main(String[] args) {
		double pi = 5.1;//지변
		//insert here - 전역변수 출력해주세요 인스턴스화 : A a = new A(); 
	    A a = new A();
	    System.out.println(pi);//5.1이 출력된다. 이건 전변이 아니잖아. 어떻게 하면 전역변수 호출할수있나?
	    System.out.println(a.pi);
	    

	}

}
