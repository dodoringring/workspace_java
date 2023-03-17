package com.pojo.step3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.pojo.step2.ActionServlet;
//Contoller3을 implements하는 class가 여러개있다.
//Board3Controller(게시판), CommonController(우편번호), MemberController(회원관리)
public interface Controller3 {
	
	public Object login(HttpServletRequest req, HttpServletResponse res);
	public Object logout(HttpServletRequest req, HttpServletResponse res);
	public Object zipcodeList(HttpServletRequest req, HttpServletResponse res);
	public Object boardList(HttpServletRequest req, HttpServletResponse res);
	public Object boardDetail(HttpServletRequest req, HttpServletResponse res);
	public Object imageUpload(HttpServletRequest req, HttpServletResponse res);
	public Object imageDownload(HttpServletRequest req, HttpServletResponse res);
	public Object imageGet(HttpServletRequest req, HttpServletResponse res);
	public Object boardInsert(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException;
	public Object boardUpdate(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException;
	public Object boardDelete(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException;
	public Object jsonBoardList(HttpServletRequest req, HttpServletResponse res);
	
}
