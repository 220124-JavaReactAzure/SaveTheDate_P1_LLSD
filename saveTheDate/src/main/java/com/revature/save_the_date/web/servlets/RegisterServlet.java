package com.revature.save_the_date.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/register")
public class RegisterServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.getWriter().write("<head><title>Save The Date</title></head>" + "");
		resp.getWriter().write(" <img src='./images/savethedate.png' alt='logos'/>" + "");
		resp.getWriter().write("<h2>Wedding Registration</h2>");

		resp.getWriter().write("<ul>" + "<li>	 "
				+ "<form method='post><label for'bname'>Please enter Bride's Name:</label><input type='text' id='bname'  name='bname'/></li>"
				+ "<li>	"
				+ "<label for'gname'>Please enter Groom's Name:</label><input type='text' id='gname'  name='gname'/></li>"

				// Venue selection

				+ "<li><p>Please choose a venue  <select name ='venue'> <option value='Hamptons Getaway'>Hampton's Getaway</option></p>"
				+ "<option value='St. Mark's Cathedral'>St. Mark's Cathedral</option>"
				+ "<option value='French Man's Cove'>French Man's Cove</option>"
				+ "<option value='Blue Lagoon'>Blue Lagoon</option></select></li>"
				+ "<li><p>Please choose a date </span><input type='date' name='date' id='date' '/>"
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

}