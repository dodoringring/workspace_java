package com.ch01;

public class Sonata { // 클래스 선언이다. 소나타라는 클래스를 정의 하였다. 왜? 재사용을 위해서

	public static void main(String[] args) {
		System.out.println("mian 메소드 호출 성공");//1
		methodA();// ;으로 끝났다. 호출이다ㅣ!
		login("tomato", "123");//호출은 메인 안에서
		//반드시 인스턴스화를 하고 호출해야한다. 
		//또는 methodA처럼 똑같이 static을 붙여서 선언한다.
		
		//메인 메소드는 자바에서 제공되는 메소드다. 그래서 리턴타입(void) 또는 파라미터 타입(String) 등을 바꿀수 없다. 컴파일에러가 발생한다.
		
		//변수 선언 -> 타입 변수 이름
		//int와 같이 나타내는 예약어가 있다-어디에? 자바 가상머신이 해줌->JDK11
		//이 안에는 예약어가 잔뜩 들어있다.
//		int i = 3; //변수 선언 및 초기화를 하였다.
		// 정수형을 담을수있는 타입이다
		//선언만 하고 싶다...어떡하지? 
//		int j; // 변수 선언만 하고 초기화는 안되어있다.
//		j = 5;//초기화를 하였다. 에러발생은 원인은 선언부에서는 선언과 초기화를 나누어 작성불가함 
		
//		double d = 3.14; // double d = 3.14; double이라는 타입에는 실수도 담는다.
	}///////////////////
		static void methodA() { // 메소드 안에서는 변수 선언과 초기화를 분리해서 작성할 수 있다.
			System.out.println("methodA 호출");//2
			
			int j;
			//지역변수. 메소드 안에서 선언한다. 메소드 밖에서는 접근이 불가하다.
			// 메소드 안에서 사용되고나면 사라진다.
			
			j = 5; // 정수형을 담을 수 있는 변수 J를 메소드 내부에서 선언 하였다. 19번에서 선언된 변수 안에 5라는 값을 담았다.  이것을 초기화라고 한다.
			
			// 메인 메소드가 있어야 exe파일로 만들수 있다. 코드 실행시 가장 먼저 호출되는 곳이다.
			}
		
		public static void login(String id, String pw) { //파라미터 자리는 선언하는 자리이다. 초기화를 할때는 대입연산자가 필요 = 
			
			System.out.println(id+","+pw);//변수 아이디를 출력 해 주세요()있으니까 메소드
			}////////////////////
		//메소드를 호출할때 세미콜론으로 끝내고 파라미터가 존재하면 파라미터도 고려해야하고 또한 타입도 고려되어야 한다.
		//결론 사용자 정의 메소드를 호출시 파라미터와 타입도 맞춰야 한다.
		
 }

//변수 이름 뒤에 괄호가 있으면 메소드라고 부른다. 괄호가 없으면 변수 메소드는 동사형이다. 기능을 담당함
	