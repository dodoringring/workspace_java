<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
int x=0;//전역변수 선언하기
public String newsItem(int index, String[] news){
	StringBuilder sb= new StringBuilder();
	for(int i=0; i<news.length; i++){
		if(i==(x)){
	sb.append("<table width='500px' border='1px soild'>");
	sb.append("<tr><td>"+news[index]+ "</td><tr>");
	sb.append("</table>");
		}//end of if
	}//end of for
	String choice=sb.toString();
	return choice;
}
%>

<% 
//스크립틀릿-자바땅
	String news[]={"'도이치모터스 주가조작' 권오수 집유·벌금 3억원",
				"[튀르키예 강진] 끝모를 사망자수…야외 주차장이 시신 안치소로"
				,"K팝 시장 '메가톤급 폭풍'…하이브·SM 시너지 기대 속 우려"
				,"증빙 없는 해외송금 한도 이르면 6월부터 5만→10만달러 확대"
				,"美연준 인사 '물가 아직 높아…금리인상 기조 유지해야'"
				};
String data="";


switch(x){
case 0:
	data=newsItem(x,news);
	
	x++;
	break;
case 1:
	data=newsItem(x,news);
	x++;
	break;
case 2:
	data=newsItem(x,news);
		x++;
	break;
case 3:
	data=newsItem(x,news);
	x++;
	break;
case 4:
	data=newsItem(x,news);
	x=0;//다시 초기화해야 처음으로 돌아간다.
	
	break;
}//end of switch
//기존에 읽어온 기사 정보 지우기
	out.clear();
	out.print(data);

%>