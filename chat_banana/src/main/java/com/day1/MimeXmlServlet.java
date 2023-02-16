package com.day1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//서블릿은 java인데 브라우저에 출력할 수 있다 - 화면의 역할 ~ 화면을 그리는데에 서블릿 사용 - 가능해? ㅇㅇ Mime타입 때문에
@WebServlet("/xml2.do")//웹에서 접근 가능한 맵핑 주소 설정
public class MimeXmlServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
	throws ServletException, IOException
	{
		res.setContentType("text/xml;charset=UTF-8");
		//메소드를 통해서 객체 생성하는 코드 - 고급
		PrintWriter out = res.getWriter();
		StringBuilder sb=new StringBuilder();
		sb.append("<records>");
		sb.append("<record>");
		sb.append("<mem_id>tomato</mem_id>");
		sb.append("<mem_pw>123</mem_pw>");
		sb.append("<mem_name>토토</mem_name>");
		sb.append("</record>");
		
		sb.append("<record>");
		sb.append("<mem_id>kiwi</mem_id>");
		sb.append("<mem_pw>123</mem_pw>");
		sb.append("<mem_name>위위</mem_name>");
		sb.append("</record>");
		
		sb.append("<record>");
		sb.append("<mem_id>banana</mem_id>");
		sb.append("<mem_pw>123</mem_pw>");
		sb.append("<mem_name>나나</mem_name>");
		sb.append("</record>");
		sb.append("</records>");
		out.print(sb.toString());//스트링 빌더를 출력하려면 스트링으로 뽑는다. toString은 스트링으로 가져오는 애다.
	}
			
}