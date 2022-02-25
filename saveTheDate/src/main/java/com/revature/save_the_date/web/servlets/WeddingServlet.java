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
		resp.getWriter().write("<head><title>Save The Date</title></head>" + "");
		resp.getWriter().write(" <img src='./images/savethedate.png' alt='logos'/>" + "");
		resp.getWriter().write("<h2>Wedding Registration</h2>");

		resp.getWriter().write("<ul>" + "<li>	 "
				+ "<form method='post'><label for'bride'>Please enter Bride's Name:</label><input type='text' id='bride'  name='bride'/></li>"
				+ "<li>	"
				+ "<label for'groom'>Please enter Groom's Name:</label><input type='text' id='groom'  name='groom'/></li>"

				// Venue selection

				+ "<li><p>Please choose a venue  <select name ='wedding_venue'> <option value='Hamptons Getaway'>Hampton's Getaway</option></p>"
				+ "<option value='St. Mark's Cathedral'>St. Mark's Cathedral</option>"
				+ "<option value='French Man's Cove'>French Man's Cove</option>"
				+ "<option value='Blue Lagoon'>Blue Lagoon</option></select></li>"
				+ "<li><p>Please choose a date </span><input type='date' name='wedding_date' id='wedding_date' '/>"
				+ "<li><label for'budget'>what is your budget ?</label><input type='number' id='budget' name='budget'/></li>"
				// Number of guests
				+ "<li><label for'guests'>How many Guests ?</label><input type='number' id='guests' guests='guests'/></li></ul>"
				+ "<h2> Available for Hire </h2>" + "<div id='hire'>"

				+ "<ul><li><span> Do you need a Florist ? </span><input type='radio' name='fl_response' id='Yes' value='Yes'/><label for 'Yes'>Yes</label>"
				+ "<input type='radio' name='fl_response' id='No' value='No'/><label for 'No'>No</label></li>"

				+ "<li><span> Do you need Musicians ? </span><input type='radio' name='M_response' id='Yes' value='Yes'/><label for 'Yes'>Yes</label>"
				+ "<input type='radio' name='M_response' id='No' value='No'/><label for 'No'>No</label></li>"
				

				+ "<li><span> Do you need Caterers ? </span><input type='radio' name='C_response' id='Yes' value='Yes'/><label for 'Yes'>Yes</label>"
				+ "<input type='radio' name='C_response' id='No' value='No'/><label for 'No'>No</label></li>"

				+ "<li><span> Do you need Photographers ? </span><input type='radio' name='P_response' id='Yes' value='Yes'/><label for 'Yes'>Yes</label>"
				+ "<input type='radio' name='P_response' id='No' value='No'/><label for 'No'>No</label></li>" + "</div>"

				+ "<div class='submit'><input type='submit' value='Register' id='submit'/></div>" + "</form>");

		resp.getWriter()
				.write("<select name='Food'> " + "<option value ='Fish'>Fish</option>"
						+ "<option value = 'Meat'>Meat</option>" + "<option value ='Vegetarian'>Vegetarian</option>"
						+ "</select>" + ""
						// css below
						+ "<style type=text/css>" + "*{ font-family: Arial,Verdana, sans-serif;" + "color: #665544;}"
						+ "#hire, li{border-bottom:1px solid #efefef;margin:10px;padding-bottom:10px;width: 400px;}"
						+ "h1{background-color:#efefef;margin-top: 20px;padding:10px 0px 5px 0px;width: 400px;}"
						+ "img.align-center {display:block;margin:0px auto;}" + "</style>" + "");
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
