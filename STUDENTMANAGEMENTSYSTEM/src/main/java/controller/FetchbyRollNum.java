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

@WebServlet("/fetchbyroll")
public class FetchbyRollNum extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int Num=Integer.parseInt(req.getParameter("num"));
		
		Studentdao studentdao=new Studentdao();
		
		List<Studentdto> studentdto=studentdao.fetch(Num);
		
		req.setAttribute("list", studentdao.fetch(Num));
		req.getRequestDispatcher("Fetchall.jsp").include(req, resp);
	}
}
