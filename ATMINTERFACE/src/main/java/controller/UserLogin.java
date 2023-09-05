package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.UserDao;
import Dto.UserDto;

@WebServlet("/usererlogin")
public class UserLogin extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int userid = Integer.parseInt(req.getParameter("userid"));
		String pin = req.getParameter("pin");

		UserDao dao = new UserDao();
		
		UserDto userDto = dao.login(userid);
		if (userDto == null) {
			resp.getWriter().print("<h1>Invalid Customer Id</h1>");
			req.getRequestDispatcher("Login.html").include(req, resp);
		} else {
			if (userDto.getPin().equals(pin)) {
				req.getSession().setAttribute("userDto", userDto);
				resp.getWriter().print("<h1>Login Success</h1>");
				req.getRequestDispatcher("UserHome.html").include(req, resp);
			} else {
				resp.getWriter().print("<h1>Invalid Password</h1>");
				req.getRequestDispatcher("Login.html").include(req, resp);
			}
		}
	}
}
