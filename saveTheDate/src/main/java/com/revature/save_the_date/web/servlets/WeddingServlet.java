package com.revature.save_the_date.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class WeddingServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.getWriter().write("<head><title>Save The Date !</title></head>"
				+ "<img src='./images/savethedate.png' alt='logos'/>"
				+ "<body>"
				+ "<h1> Home </h1>"
				+ "<div id='intro'> "
				+ ""
				+ ""
				+ ""
				+ ""
				+ ""
				+ ""
				+ ""
				+ ""
				+ ""
				+ ""
				+ ""
				
				// CSS
				
				+ "<style type=text/css>"
				+ "body {background-color: #79525C;}"
				+ ""
				+ "</body>"
				+ "</style>");
	}

}
