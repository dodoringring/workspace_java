/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.70
 * Generated at: 2023-02-15 08:29:53 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jEasyUI.dept;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class insertForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/jEasyUI/dept/../../common/easyUI_common.jsp", Long.valueOf(1676345271053L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>부서등록-다이얼로그</title>\r\n");

	StringBuilder path=new StringBuilder(request.getContextPath());//ë¬¼ë¦¬ì ì¸ ìì¹ë¥¼ ì°¾ìì£¼ëì ë¤.
	path.append("/");

      out.write("\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(path.toString() );
      out.write("themes/default/easyui.css\"/>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(path.toString() );
      out.write("themes/icon.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(path.toString() );
      out.write("demo/demo.css\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(path.toString() );
      out.write("js/jquery.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(path.toString() );
      out.write("js/jquery.easyui.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div style=\"margin:20px 0;\"></div>\r\n");
      out.write("<div style=\"margin:30px\">\r\n");
      out.write("        <form id=\"f_dept\" method=\"get\">\r\n");
      out.write("        <div style=\"margin-bottom:20px\">\r\n");
      out.write("            <input class=\"easyui-textbox\" name=\"deptno\" label=\"부서번호:\" labelPosition=\"top\" data-options=\"prompt:'Enter 부서번호...'\" style=\"width:200px;\">\r\n");
      out.write("        </div>\r\n");
      out.write("        <div style=\"margin-bottom:20px\">\r\n");
      out.write("            <input class=\"easyui-textbox\" name=\"dname\" label=\"부서명:\" labelPosition=\"top\" data-options=\"prompt:'Enter 부서명...'\" style=\"width:300px;\">\r\n");
      out.write("        </div>\r\n");
      out.write("        <div style=\"margin-bottom:20px\">\r\n");
      out.write("            <input class=\"easyui-textbox\" name=\"loc\" label=\"지역:\" labelPosition=\"top\" data-options=\"prompt:'Enter 지역...'\" style=\"width:300px;\">\r\n");
      out.write("        </div>\r\n");
      out.write("        <div style=\"margin-bottom:20px\">\r\n");
      out.write("            <input class=\"easyui-textbox\" label=\"너의 매력포인트:\" labelPosition=\"top\" data-options=\"prompt:'Enter 매력...'\" style=\"width:300px;\">\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("        <div style=\"text-align:center\">\r\n");
      out.write("            <a href=\"javascript:insertAction()\" class=\"easyui-linkbutton\" iconCls=\"icon-ok\" style=\"width:100%;height:32px\">등록</a>\r\n");
      out.write("        </div>\r\n");
      out.write("        </form>\r\n");
      out.write("</div>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("	const insertAction =()=>{\r\n");
      out.write("//		console.log(\"입력 호출 성공\")\r\n");
      out.write("		console.log($(\"#_easyui_textbox_input1\").val()+\",\"+$(\"#_easyui_textbox_input2\").val()+\",\"+$(\"#_easyui_textbox_input3\").val())\r\n");
      out.write("		const u_deptno=$(\"#_easyui_textbox_input1\").val()\r\n");
      out.write("		const u_dname=$(\"#_easyui_textbox_input2\").val()\r\n");
      out.write("		const u_loc=$(\"#_easyui_textbox_input3\").val()\r\n");
      out.write("		$.ajax({\r\n");
      out.write("			method:\"get\",\r\n");
      out.write("			url:\"/jEasyUI/dept/insertAction.do?deptno=\"+u_deptno+\"&dname=\"+u_dname+\"&loc=\"+u_loc,\r\n");
      out.write("			success:function(data){\r\n");
      out.write("				console.log(\"톰캣 서버에서 응답으로 보낸 값==>\"+data)\r\n");
      out.write("			}\r\n");
      out.write("		})\r\n");
      out.write("		\r\n");
      out.write("	}\r\n");
      out.write("	/* 서블릿이 되기위한 조건은 반드시 http서블릿을 상속 받아야 한다. */\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
