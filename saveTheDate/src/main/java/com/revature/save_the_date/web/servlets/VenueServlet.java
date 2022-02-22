package com.revature.save_the_date.web.servlets;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.save_the_date.models.Venue;
import com.revature.save_the_date.services.VenueService;

@WebServlet(value="/venue")
public class VenueServlet extends HttpServlet {
	/*
	 * private final VenueService venueService; private final ObjectMapper mapper;
	 * 
	 * public VenueServlet(VenueService venueService, ObjectMapper mapper) {
	 * this.mapper = mapper; this.venueService = venueService; }
	 * 
	 * @Override protected void doPost(HttpServletRequest req, HttpServletResponse
	 * resp) throws ServletException, IOException {
	 * 
	 * resp.setContentType("application/json"); try { Venue newVenue =
	 * mapper.readValue(req.getInputStream(), Venue.class); boolean wasRegistered =
	 * venueService.addVenue(newVenue); if (wasRegistered) { resp.setStatus(200); }
	 * else { resp.setStatus(500); } } catch (StreamReadException |
	 * DatabindException e) { // TODO: handle exception resp.setStatus(400);
	 * e.printStackTrace(); } catch (Exception e) { resp.setStatus(500);
	 * e.printStackTrace(); }
	 * 
	 * }
	 */
	String test = "hhdhdhdh";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException,ServletException {
		Random r = new Random();
		int id = r.nextInt(99999999);
		
		String venue_name = req.getParameter("venue_name");
		
		
		resp.getWriter().write("<head><title>Save The Date</title></head>" + "");
		resp.getWriter().write(" <img src='./images/savethedate.png' alt='logos'/>" + "");
		resp.getWriter().write("<h2>Venue Registration</h2>"
				+ "<p>Venue ID:</p> "
				+ "<form action='request.getContextPath() %>/venue', method='post'>"
				+ "Venue Name: <input type='text' name='VenueName'><br><br>"
				+ "<input type='submit' value='register'</form>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		String test = req.getParameter("VenueName");
		System.out.println(test);
	}
}
