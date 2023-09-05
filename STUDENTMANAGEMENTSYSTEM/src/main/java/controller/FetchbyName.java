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

@WebServlet("/fetchbyname")
public class FetchbyName extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		
		Studentdao studentdao=new Studentdao();
		
		List<Studentdto> studentdto=studentdao.fetch(name);
		
		req.setAttribute("list", studentdao.fetch(name));
		req.getRequestDispatcher("Fetchall.jsp").include(req, resp);
	}
}
