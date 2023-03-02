package com.pojo.step2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pojo.step1.ActionForward;

public interface Controller {
	
	public String execute(HttpServletRequest req, HttpServletResponse res) 
	throws Exception;
	
}
