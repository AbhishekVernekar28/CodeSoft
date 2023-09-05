package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Studentdao;
import dto.Studentdto;

@WebServlet("/deletestudent")
public class DeleteStudent extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		resp.getWriter().print("<h1>Removed Successfully1</h1>");
		Studentdao studentdao=new Studentdao();
		resp.getWriter().print("<h1>Removed Successfully2</h1>");
		
		studentdao.delete(name);
		
		resp.getWriter().print("<h1>Removed Successfully</h1>");
		
		req.setAttribute("list", studentdao.fetch(name));
		req.getRequestDispatcher("Fetchall.jsp").include(req, resp);
		
		
	}
}
