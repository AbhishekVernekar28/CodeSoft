package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/grade")
public class GradeCalculator extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int Sub1=Integer.parseInt(req.getParameter("sub1"));
		int Sub2=Integer.parseInt(req.getParameter("sub2"));
		int Sub3=Integer.parseInt(req.getParameter("sub3"));
		int Sub4=Integer.parseInt(req.getParameter("sub4"));
		int Sub5=Integer.parseInt(req.getParameter("sub5"));
		int Sub6=Integer.parseInt(req.getParameter("sub6"));
		
		resp.getWriter().println("<h1>Subject 1: "+Sub1+"</h1>");
		resp.getWriter().println("<h1>Subject 2: "+Sub2+"</h1>");
		resp.getWriter().println("<h1>Subject 3: "+Sub3+"</h1>");
		resp.getWriter().println("<h1>Subject 4: "+Sub4+"</h1>");
		resp.getWriter().println("<h1>Subject 5: "+Sub5+"</h1>");
		resp.getWriter().println("<h1>Subject 6: "+Sub6+"</h1>");
		
		int Total=Sub1+Sub2+Sub3+Sub4+Sub5+Sub6;
		resp.getWriter().println("<h1>Total Marks: "+Total+"</h1>");
		
		int percent=Total/6;
		resp.getWriter().println("<h1>Average Percentage: "+percent+"%</h1>");
		
		if(percent>=90 && percent<=100) 
			resp.getWriter().println("<h1>Grade: A+</h1>");
		else if(percent>=80 && percent<90)
		resp.getWriter().println("<h1>Grade: A</h1>");
		else if(percent>=70 && percent<80)
		resp.getWriter().println("<h1>Geade: B</h1>");
		else if(percent>=60 && percent<70)
		resp.getWriter().println("<h1>Geade: C</h1>");
		else if(percent>=50 && percent<60)
		resp.getWriter().println("<h1>Geade: D</h1>");
		else if(percent>=35 && percent<50)
		resp.getWriter().println("<h1>Geade: E</h1>");
		else 
		resp.getWriter().println("<h1>Geade: F</h1>");
	}

	
}
