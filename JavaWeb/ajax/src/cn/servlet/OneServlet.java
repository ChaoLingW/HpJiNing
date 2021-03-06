package cn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/one")
public class OneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("test/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		//调用service--dao查询由此用户名的用户
		if(username != null && "admin".equals(username)) {
			//此用户已存在
			out.write("{\"flag\":1}");
		} else {
			//此用户不存在
			out.write("{\"flag\":0}");
		}
	}

}
