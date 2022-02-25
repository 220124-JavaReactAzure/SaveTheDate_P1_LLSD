package com.revature.save_the_date.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.save_the_date.models.Guest;
import com.revature.save_the_date.services.GuestService;

public class GuestServlet extends HttpServlet {

	private final GuestService guestService;
	private final ObjectMapper mapper;

	public GuestServlet(GuestService guestService, ObjectMapper mapper) {
		super();
		this.guestService = guestService;
		this.mapper = mapper;
	}
	
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		//resp.setContentType("application/json");
		
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		String json = new JSONObject()
				.put("fname",fname)
				.put("lname",lname)
				.put("email",email)
				.put("password", password)
				.toString();
		
		try {
			Guest newGuest = mapper.readValue(json, Guest.class);
			boolean wasRegistered = guestService.addGuest(newGuest);
			if (wasRegistered) {
				resp.setStatus(200);
				resp.getWriter().write("data persisted succesfully inte guest table");
			} else {
				resp.setStatus(500);
			}
		} catch (StreamReadException | DatabindException e) { // TODO: handle exception resp.setStatus(400);
			e.printStackTrace();
		} catch (Exception e) {
			resp.setStatus(500);
			e.printStackTrace();
		}

	}
	
	

}
