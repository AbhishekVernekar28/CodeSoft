package Controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/NumberGuessServlet")
public class NumberGuessServlet extends HttpServlet {
	    private static final long serialVersionUID = 1L;
	    
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	    {
	    	int MaxAttempts=5;
	        HttpSession session = request.getSession(true);

	        // Check if a new game or continue an existing one
	        if (session.getAttribute("targetNumber") == null) 
	        {
	            // Generate a random number between 1 and 100
	            int targetNumber = new Random().nextInt(100) + 1;
	            
	            
	            session.setAttribute("targetNumber", targetNumber);
	        }
	        
	        int attempts =1;
	     while(attempts<=MaxAttempts)
	     {

	            int guess = Integer.parseInt(request.getParameter("guess"));
	            int targetNumber =  (Integer) session.getAttribute("targetNumber");
//	            response.getWriter().print("<h1>RandomNumber is:"+targetNumber+"</h1>");
	            if (guess == targetNumber) 
	            {
	                session.removeAttribute("targetNumber");
	                response.getWriter().println("Congratulations! You guessed the number!");
	            } else if (guess < targetNumber) 
	            {
	                
	                response.getWriter().println("Try higher value, Attempts left: " + (MaxAttempts-attempts));
	                
	                attempts++;
	            } else 
	            {
	                response.getWriter().println("Try lower value, Attempts left: " + (MaxAttempts-attempts));
	                attempts++;
	            }
	            request.getRequestDispatcher("Guess.html").include(request, response);
//	            request.getRequestDispatcher("GuessNumber.html").include(request, response);
	           
	    }
       
	    }
	}


