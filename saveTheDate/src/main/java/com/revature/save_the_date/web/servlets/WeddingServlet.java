package com.revature.save_the_date.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.json.JSONObject;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.save_the_date.models.Wedding;
import com.revature.save_the_date.services.WeddingService;

public class WeddingServlet extends HttpServlet {
	
	private final org.apache.logging.log4j.Logger logger = LogManager.getLogger();
	private final WeddingService weddingService;
	private final ObjectMapper mapper;

	
	
	
	public WeddingServlet(WeddingService weddingService, ObjectMapper mapper) {
		super();
		this.weddingService = weddingService;
		this.mapper = mapper;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		//resp.setContentType("application/json");
		logger.info("Register Servlet Running");
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String date = req.getParameter("wedding_date");
		String venue = req.getParameter("wedding_venue");
		String id = req.getParameter("wedding_id");
		String bride = req.getParameter("bride");
		String groom = req.getParameter("groom");
		String party_size = req.getParameter("party_size");
		String budget = req.getParameter("budget");
		String caterer = req.getParameter("caterer");
		String florist = req.getParameter("florist");
		String photographer = req.getParameter("photographer");
		String musician = req.getParameter("musician");



		String json = new JSONObject().put("wedding_date", date)
				.put("wedding_venue", venue).put("wedding_id", id)
				.put("bride", bride)
				.put("groom", groom)
				.put("party_size", party_size)
				.put("budget", budget)
				.put("caterer", caterer)
				.put("florist", florist)
				.put("photographer", photographer)
				.put("musician", musician)
				.toString();

		try {
			Wedding newWedding = mapper.readValue(json, Wedding.class);
			boolean wasRegistered = weddingService.addWedding(newWedding);
			if (wasRegistered) {
				resp.setStatus(200);
				resp.getWriter().write("data persisted succesfully");
				logger.info("Data persisted and now goes back to previous web page");

				resp.sendRedirect("http://localhost:8080/saveTheDate/espoused.html");
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
