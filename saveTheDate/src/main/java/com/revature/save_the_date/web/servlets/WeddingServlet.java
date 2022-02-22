package com.revature.save_the_date.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.save_the_date.models.Wedding;
import com.revature.save_the_date.services.WeddingService;

@WebServlet(value = "/wedding")
public class WeddingServlet extends HttpServlet {

	private final WeddingService weddingService;
	private final ObjectMapper mapper;

	public WeddingServlet(WeddingService weddingService, ObjectMapper mapper) {
		this.weddingService = weddingService;
		this.mapper = mapper;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("application/json");
		try {
			Wedding newWedding = mapper.readValue(req.getInputStream(), Wedding.class);
			boolean wasRegistered = weddingService.addWedding(newWedding);
			if (wasRegistered) {
				resp.setStatus(200);
			} else {
				resp.setStatus(500);
			}
		} catch (StreamReadException | DatabindException e) { // TODO: handle exception
			resp.setStatus(400);
			e.printStackTrace();
		} catch (Exception e) {
			resp.setStatus(500);
			e.printStackTrace();
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter()
				.write("<head><title>Save The Date !</title></head>"
						+ "<img src='./images/savethedate.png' alt='logos'/>" + "<body>" + "<h1> Home </h1>"
						+ "<div id='intro'> " + "<style type=text/css>" + "body {background-color: #79525C;}" + ""
						+ "</body>" + "</style>");
	}

}
