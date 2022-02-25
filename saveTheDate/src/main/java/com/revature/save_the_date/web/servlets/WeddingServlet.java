package com.revature.save_the_date.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.save_the_date.models.Guest;
import com.revature.save_the_date.models.Wedding;
import com.revature.save_the_date.services.WeddingService;
import com.revature.save_the_date.web.util.ContextLoaderListener;

public class WeddingServlet extends HttpServlet {

	private final WeddingService weddingService;
	private final ObjectMapper mapper;

	public WeddingServlet(WeddingService weddingService, ObjectMapper mapper) {
		this.weddingService = weddingService;
		this.mapper = mapper;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter()
				.write("<head><title>Save The Date !</title></head>"
						+ "<img src='./images/savethedate.png' alt='logos'/>" + "<body>" + "<h1> Home </h1>"
						+ "<div id='intro'> " + "<style type=text/css>" + "body {background-color: #79525C;}" + ""
						+ "</body>" + "</style>");

		PrintWriter writer = resp.getWriter();
		String path = req.getPathInfo();
		if (path == null)
			path = "";

		switch (path) {
		case "/ID":
			try {
				String idParam = req.getParameter("wedding_id");
				if (idParam == null) {
					resp.setStatus(400);
					writer.write("Please include ?wedding_id=# at the end of the url");
					return;
				}

				int weddingId = Integer.valueOf(idParam);

				Wedding wedding = weddingService.getWeddingById(weddingId);
				if (wedding == null) {
					resp.setStatus(500);
					return;
				}
				String payload = mapper.writeValueAsString(wedding);
				writer.write(payload);
				resp.setStatus(200);
			} catch (StreamReadException | DatabindException e) {
				resp.setStatus(400);
			}
			break;
		default:
			List<Wedding> weddings = weddingService.getAllWeddings();
			String payload = mapper.writeValueAsString(weddings);
			writer.write(payload);
			resp.setStatus(200);
			break;
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("application/json");
		try {
			Wedding newWedding = mapper.readValue(req.getInputStream(), Wedding.class);
			boolean wasRegistered = weddingService.addWedding(newWedding);
			if (wasRegistered) {
				resp.setStatus(200);
				resp.getWriter().write("Data Persisted");
			} else {
				resp.setStatus(500);
				resp.getWriter().write("data did not persist");
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
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter writer = resp.getWriter();
		String path = req.getPathInfo();
		if (path == null)
			path = "";

		switch (path) {
		case "/ID":
			try {
				String idParam = req.getParameter("wedding_id");
				if (idParam == null) {
					resp.setStatus(400);
					writer.write("Please include ?wedding_id=# at the end of the url");
					return;
				}

				int weddingId = Integer.valueOf(idParam);

				Wedding wedding = weddingService.getWeddingById(weddingId);
				if (wedding == null) {
					resp.setStatus(500);
					return;
				}

				Wedding updatedWedding = mapper.readValue(req.getInputStream(), Wedding.class);

				weddingService.updateWeddingWithSessionMethod(updatedWedding);

				resp.setStatus(204);
				String payload = mapper.writeValueAsString(updatedWedding);
				writer.write(payload);
				resp.getWriter().write("Wedding has been updated");
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

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter writer = resp.getWriter();
		String path = req.getPathInfo();
		if (path == null)
			path = "";

		switch (path) {
		case "/ID":
			try {
				String idParam = req.getParameter("wedding_id");
				if (idParam == null) {
					resp.setStatus(400);
					writer.write("Please include ?wedding_id=# at the end of the url");
					return;
				}

				int weddingId = Integer.valueOf(idParam);

				Wedding wedding = weddingService.getWeddingById(weddingId);
				if (wedding == null) {
					resp.setStatus(500);
					return;
				}
				Wedding removeWedding = mapper.readValue(req.getInputStream(), Wedding.class);

				weddingService.removeWedding(removeWedding);
				resp.setStatus(200);
				
			}catch (Exception e) {
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
