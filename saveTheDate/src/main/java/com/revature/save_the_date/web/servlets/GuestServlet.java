package com.revature.save_the_date.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.save_the_date.models.Employee;
import com.revature.save_the_date.models.Guest;
import com.revature.save_the_date.models.Wedding;
import com.revature.save_the_date.services.GuestService;

public class GuestServlet extends HttpServlet {

	private final org.apache.logging.log4j.Logger logger = LogManager.getLogger();

	
	private final GuestService guestService;
	private final ObjectMapper mapper;

	public GuestServlet(GuestService guestService, ObjectMapper mapper) {
		this.guestService = guestService;
		this.mapper = mapper;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		logger.info("Guest Servlet Running...");
		resp.getWriter().write("<head><title>Save The Date</title></head>" + "");
		resp.getWriter().write(" <img src='./images/savethedate.png' alt='logos'/>" + "");
		resp.getWriter().write("<h2>Guest Information</h2>");
		PrintWriter writer = resp.getWriter();
		String path = req.getPathInfo();
		if (path == null) 
			path = "";
		
		switch(path) {
		case "/ID":
		try {
			String idParam = req.getParameter("guest_id");
			if(idParam == null) {
				resp.setStatus(400);
				writer.write("Please include ?guest_id=# at the end of the url");
				return;
				}
		
			
			int guestId = Integer.valueOf(idParam);
			
		
			Guest guest = guestService.getGuestById(guestId);
			if(guest == null) {
				resp.setStatus(500);
				return;
			}
			String payload = mapper.writeValueAsString(guest);
			writer.write(payload);
			resp.setStatus(200);
		} catch (StreamReadException | DatabindException e) {
			resp.setStatus(400);
		}
		break;
	default:
		List<Guest> guests = guestService.getAllGuests();
		String payload = mapper.writeValueAsString(guests);
		writer.write(payload);
		resp.setStatus(200);
		break;
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("application/json");
		try {
			Guest newGuest = mapper.readValue(req.getInputStream(), Guest.class);
			boolean wasRegistered = guestService.addGuest(newGuest);
			if (wasRegistered) {
				resp.setStatus(200);
				resp.getWriter().write("Data persistsed");
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
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter writer = resp.getWriter();
		String path = req.getPathInfo();
		if (path == null)
			path = "";

		switch (path) {
		case "/ID":
			try {
				String idParam = req.getParameter("guest_id");
				if (idParam == null) {
					resp.setStatus(400);
					writer.write("Please include ?guest_id=# at the end of the url");
					return;
				}

				int guestId = Integer.valueOf(idParam);

				Guest guest = guestService.getGuestById(guestId);
				if (guest == null) {
					resp.setStatus(500);
					return;
				}

				Guest updatedGuest = mapper.readValue(req.getInputStream(), Guest.class);

				guestService.updateGuestWithSessionMethod(updatedGuest);

				resp.setStatus(204);
				String payload = mapper.writeValueAsString(updatedGuest);
				writer.write(payload);
				resp.getWriter().write("Guest has been updated");
			} catch (StreamReadException | DatabindException e) {
				resp.setStatus(400);
				resp.getWriter().write("JSON threw exception");
				e.printStackTrace();
			} catch (Exception e) {
				resp.setStatus(500);
				resp.getWriter().write("Some other random exception");
				e.printStackTrace();
			}

			break;
		default:

			break;
		}
	}

}