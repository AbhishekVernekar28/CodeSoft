package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Studentdao;
@WebServlet("/fetchall")
public class Fetchall extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Studentdao studentdao =new Studentdao();

		req.setAttribute("list", studentdao.fetchAll());
		
		resp.getWriter().print("<h1>All Students Details</h1>");
		req.getRequestDispatcher("Fetchall.jsp").include(req, resp);
	}
}
