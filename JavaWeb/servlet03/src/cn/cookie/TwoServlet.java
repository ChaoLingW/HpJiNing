package cn.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/two")
public class TwoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset-utf-8");
		PrintWriter out = response.getWriter();
		// getCookies() 从HTTP请求消息的Cookie请求字段中读取所有的Cookie
		Cookie[] cookies = request.getCookies();

		if (cookies != null && cookies.length > 0) {

			for (Cookie cookie : cookies) {
				// getName cookie名
				String name = cookie.getName();
				// getValue cookie值
				String value = cookie.getValue();
				out.write("cookieName" + name + ",cookieValue:" + value);

			}
		} else {
			// 创建Cookie
			Cookie cookie = new Cookie("name", "zhangsan");
			cookie.setMaxAge(20);
			// 将cookie发送给客户端浏览器 响应头：set-cookie头：name:zhangsan addCookie()
			response.addCookie(cookie);
		}
		

	}

}
