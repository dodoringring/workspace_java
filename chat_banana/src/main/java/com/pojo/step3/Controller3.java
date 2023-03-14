package com.pojo.step3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.pojo.step2.ActionServlet;

public interface Controller3 {
	
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
