package controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.UserDao;
import Dto.UserDto;


@WebServlet("/usersignup")
public class UserSignup extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDao dao = new UserDao();

//		String email = req.getParameter("email");
		long mobile = Long.parseLong(req.getParameter("mobile"));

		Date date = Date.valueOf(req.getParameter("dob"));

		int age = Period.between(date.toLocalDate(), LocalDate.now()).getYears();

		if (age < 18) {
			resp.getWriter().print("<h1>You have to be 18+ to create a bank account</h1>");
			req.getRequestDispatcher("Signup.html").include(req, resp);
		} else {
			if (dao.check(mobile).isEmpty() )// 1
			{
				UserDto userDto = new UserDto();
				userDto.setName(req.getParameter("name"));
				userDto.setGender(req.getParameter("gender"));
				userDto.setPin(req.getParameter("pin"));
				userDto.setDob(date);
				userDto.setMobile(mobile);
				dao.save(userDto);
				
				UserDto userDto2 = dao.check(mobile).get(0);

				resp.getWriter().print("<h1>Account Created Successfully</h1>");
				if (userDto2.getGender().equals("male"))
					resp.getWriter().print("<h1>Hello Sir</h1>");
				else
					resp.getWriter().print("<h1>Hello Mam</h1>");
				resp.getWriter().print("<h1>Your Customer Id is : " + userDto2.getUser_id() + "</h1>");
				req.getRequestDispatcher("Home.html").include(req, resp);

			} else {
				resp.getWriter().print("<h1>Email or Phone Number already Exists</h1>");
				req.getRequestDispatcher("Signup.html").include(req, resp);
			}
		}
	}
}
