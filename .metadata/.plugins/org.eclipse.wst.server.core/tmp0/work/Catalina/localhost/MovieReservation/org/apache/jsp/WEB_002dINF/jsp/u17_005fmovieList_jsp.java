/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.39
 * Generated at: 2019-07-31 01:27:35 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import beans.UserMovieListBeans;

public final class u17_005fmovieList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("beans.UserMovieListBeans");
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

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>映画一覧</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/u17.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "./header/userHeader.jsp", out, false);
      out.write('\r');
      out.write('\n');
 	List<List<UserMovieListBeans>> oList = (List<List<UserMovieListBeans>>)request.getAttribute("oList");
	String[] dList = (String[])request.getAttribute("dList");
      out.write("\r\n");
      out.write("\r\n");
	String name = "";
	String theater = "";
	int index = 1;
      out.write("\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("\t<h2 class=\"mt-3 mb-3\">上映一覧</h2>\r\n");
      out.write("\t<form action=\"movieResavation\" method=\"GET\">\r\n");
      out.write("\r\n");
		if( oList != null){
      out.write("\r\n");
      out.write("\t\t\t<ul class=\"nav nav-pills ml-5\">\r\n");
      out.write("\t\t\t\t  <li class=\"nav-item\">\r\n");
      out.write("\t\t\t\t    <a href=\"#tab1\" class=\"nav-link active\" data-toggle=\"tab\">");
      out.print(dList[0]);
      out.write("</a>\r\n");
      out.write("\t\t\t\t  </li>\r\n");
      out.write("\t\t\t\t  <li class=\"nav-item\">\r\n");
      out.write("\t\t\t\t    <a href=\"#tab2\" class=\"nav-link\" data-toggle=\"tab\">");
      out.print(dList[1]);
      out.write("</a>\r\n");
      out.write("\t\t\t\t  </li>\r\n");
      out.write("\t\t\t\t  <li class=\"nav-item\">\r\n");
      out.write("\t\t\t\t    <a href=\"#tab3\" class=\"nav-link\" data-toggle=\"tab\">");
      out.print(dList[2]);
      out.write("</a>\r\n");
      out.write("\t\t\t\t  </li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t<div class=\"tab-content\">\r\n");
      out.write("\r\n");
			for(List<UserMovieListBeans> iList : oList){
      out.write("\r\n");
      out.write("\t\t\t\t<div id=\"tab");
      out.print(index );
      out.write("\" class=\"tab-pane");
if(index==1){
      out.write(" active");
}
      out.write(" ml-5\">\r\n");
      out.write("\t\t\t\t<h5 class=\"mt-3\">");
      out.print((iList.get(0)).getMovieName() );
      out.write("</h5>\r\n");
				name = (iList.get(0)).getMovieName();
				theater = (iList.get(0)).getTheaterCode();
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<ul class=\"list-group list-group-horizontal\">\r\n");
      out.write("\t\t\t\t\t<li class=\"list-group-item text-center mr-2 mb-1\">シアター<br>");
      out.print((iList.get(0)).getTheaterCode() );
      out.write("</li>\r\n");
				if( iList != null){
					for(UserMovieListBeans beans : iList){
      out.write("\r\n");
      out.write("\r\n");
 						if(!(beans.getMovieName().equals(name))){
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t<h5 class=\"mt-3\">");
      out.print( beans.getMovieName() );
      out.write("</h5>\r\n");
      out.write("\t\t\t\t\t\t\t<ul class=\"list-group list-group-horizontal\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<li class=\"list-group-item text-center mr-2 mb-1\">シアター<br>");
      out.print(beans.getTheaterCode() );
      out.write("</li>\r\n");
 						}else if(!(beans.getTheaterCode().equals(theater))){
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t\t<ul class=\"list-group list-group-horizontal\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<li class=\"list-group-item text-center mr-2 mb-1\">シアター<br>");
      out.print(beans.getTheaterCode() );
      out.write("</li>\r\n");
						} 
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<li class=\"list-group-item text-center mr-2 mb-1\">\r\n");
							if(beans.getSeatSpace() == 0){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"text-danger h4\">×</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t<br>");
      out.print(beans.getShowTime());
      out.write('\r');
      out.write('\n');
							} else{
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"movieReservation?showCode=");
      out.print(beans.getShowCode() );
      out.write("\">\r\n");
								if(beans.getSeatSpace() < 20){
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<span class=\"text-warning h4\">△</span>\r\n");
								}else{ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<span class=\"text-info h4\">○</span>\r\n");
								} 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<br>");
      out.print(beans.getShowTime());
      out.write("</a>\r\n");
							} 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\r\n");
						name = beans.getMovieName();
						theater = beans.getTheaterCode();
					}
				}
      out.write("\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t");
index++; 
      out.write('\r');
      out.write('\n');
			}
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
		}
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t</form>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\" integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>\r\n");
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
