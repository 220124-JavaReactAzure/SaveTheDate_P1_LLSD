package com.revature.save_the_date.web.servlets;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.save_the_date.models.Venue;
import com.revature.save_the_date.services.VenueService;

public class VenueServlet extends HttpServlet {

	private final VenueService venueService;
	private final ObjectMapper mapper;

	public VenueServlet(VenueService venueService, ObjectMapper mapper) {
		this.mapper = mapper;
		this.venueService = venueService;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		//String venue_name = req.getParameter("venue_name");
		//String phone = req.getParameter("phone_no");

		resp.getWriter().write("<head><title>Save The Date</title></head>" + "");
		resp.getWriter().write(" <img src='./images/savethedate.png' alt='logos'/>" + "");
		resp.getWriter().write("<h2>Venue Registration</h2>" + "<p>Venue ID:</p> "

				+ "<form action='http://localhost:8080/saveTheDate/venue/' method='post'>"
				+ "venue_name: <input type='text' name='venue_name'><br><br>"
				+ "phone_no: <input type='number' name='phone_no'>"
				+ "capacity: <input type='number' name='capacity'>" + "address: <input type='text' name='address'>"
				+ "<input type='submit' value='Submit'</form>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("venue_id");
		String name = req.getParameter("venue_name");
		String capacity = req.getParameter("capacity");
		String phone_no = req.getParameter("phone_no");
		String address = req.getParameter("address");


		String json = new JSONObject().put("venue_id", id).put("venue_name", name).put("phone_no", phone_no)
				.put("capacity", capacity)
				.put("address",address)
				.toString();
		try{
			Venue newVenue = mapper.readValue(req.getInputStream(), Venue.class);
			boolean wasRegistered = venueService.addVenue(newVenue);
			if (wasRegistered) {
				resp.setStatus(200);
				resp.getWriter().write("data persisted succesfully");
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
