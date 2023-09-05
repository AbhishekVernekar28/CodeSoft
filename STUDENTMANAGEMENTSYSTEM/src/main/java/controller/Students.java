package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Studentdao;
import dto.Studentdto;

@WebServlet("/addstudents")
public class Students extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Studentdao studentdao=new Studentdao();
		Studentdto studentdto=new Studentdto();
		
		studentdto.setRollnumber(Integer.parseInt(req.getParameter("roll")));
		studentdto.setName(req.getParameter("name"));
		studentdto.setGrade(req.getParameter("grade"));
		
		studentdao.save(studentdto);
		resp.getWriter().print("<h1>Added Successfully</h1>");
		req.getRequestDispatcher("AddData.html").include(req, resp);
	}
}
