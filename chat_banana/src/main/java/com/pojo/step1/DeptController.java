package com.pojo.step1;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
//select deptno, dname, loc from dept 로 가져올거다.
public class DeptController implements Action {
	Logger logger=Logger.getLogger(DeptController.class);
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward af =new ActionForward();
		String upmu[]=(String[])req.getAttribute("upmu");
		DeptLogic deptLogic =new DeptLogic();
		String path=null;
		boolean isRedirect=false;
		//만약에 너 부서목록 조회 할거니?
		if("deptList".equals(upmu[1])) {
			List<Map<String,Object>> deptList=deptLogic.getDeptList();
			req.setAttribute("deptList", deptList);
			path="getDeptList.jsp";
			isRedirect=false;//false이면 forward이다-요청이 유지되낟.
		}
		//너 부서등록 하려고?
		else if("jsonDeptList".equals(upmu[1])) {
			//insert into dept(deptno, dname, loc) values(?,?,?)
			String jsonDoc = deptLogic.jsonDeptList();
		}
		//너 부서정보 수정해야돼?
		else if("deptUpdate".equals(upmu[1])) {
			int result = deptLogic.deptUpdate();
			
		}
		//너희부서 없어졌다.
		else if("deptDelete".equals(upmu[1]))
			int result = deptLogic.deptDelete();
		
		return af;//액션포워드 넘긴다.
	}
	af.setPath(Path);
	af.seRedirect(isREdirect);
	public ActionForward getDeptList() {
		//res.sendRedirect(); 
		//res없이는 페이지 이동을 못한다...
		//URL뒤에 .st1을 붙여야 FrontMVC1으로 들어갈수있다. 경유한다.
		//web.xml에 정해놨다. xml을 통해서 의존성을 주입한것이다.
		//xml이용하는 방식이 Maven방식이다.
		return null;
	}

}
