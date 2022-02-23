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
import com.revature.save_the_date.models.Employee;
import com.revature.save_the_date.models.Wedding;
import com.revature.save_the_date.services.EmployeeService;

public class EmployeeServlet extends HttpServlet {

	private final EmployeeService employeeService;
	private final ObjectMapper mapper;

	public EmployeeServlet(EmployeeService employeeService, ObjectMapper mapper) {
		this.employeeService = employeeService;
		this.mapper = mapper;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setContentType("application/json");
		try {
			Employee newEmployee = mapper.readValue(req.getInputStream(), Employee.class);
			boolean wasRegistered = employeeService.addEmployee(newEmployee);
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
		resp.getWriter().write("<head><title>Save The Date !</title></head>" + "<div id=top>"
				+ "<h1>Save The Date !</h1>" + "<img src='./images/savethedate.png' alt='logos'/>"
				+ "<h3>You are loggen in as: Tom Nash " + "" + "" + "<h3> Your Schedule</h3>" + "<ul>"
				+ "<li> Frenchman's Cove Feb. 17, 2023</li>" + "<li> Blue Lagoon Feb. 28, 2023</li>" + "</ul>"
				+ "<button type ='button' class='collapsible'>Add Venue</button>"// venu
				+ "		<div class='content'>" + "<form method='post'>"
				+ "<label for'venue'>Name of venue:</label><input type='text' id='venue'  name='venue'/>"
				+ "<label for'location'>Location:</label><input type='text' id='location'  name='location'/>"
				+ "<label for'Capacity'>Capacity:</label><input type='text' id='capacity'  name='capacity'/>"
				+ "<label for'phone'>Phone no.:</label><input type='number' id='phone'  name='phone'/>" + "</form>"
				+ "		</div>"

				+ "<button type ='button' class='collapsible'>Add Caterer</button>"// caterer
				+ "		<div class='content'>" + "<form method='post'>"
				+ "<label for'caterer'>Name of Caterer:</label><input type='text' id='caterer'  name='caterer'/>"
				+ "<label for'cousine'>Cousine:</label><input type='text' id='cousine'  name='cousine'/>"
				+ "<label for'phone'>Phone:</label><input type='number' id='phone'  name='phone'/>" + "</form>"
				+ "		</div>" + "<button type ='button' class='collapsible'>Add Florist</button>"// florist
				+ "		<div class='content'>" + "<form method='post'>"
				+ "<label for'florist'>Name of Florist:</label><input type='text' id='florist'  name='florist'/>"
				+ "<label for'phone'>Phone:</label><input type='number' id='phone'  name='phone'/>" + "</form>"
				+ "		</div>" + "<button type ='button' class='collapsible'>Add Photographer</button>"// photographers
				+ "		<div class='content'>" + "<form method='post'>"
				+ "<label for'caterer'>Name of Photographer:</label><input type='text' id='photographer'  name='photographer'/>"
				+ "<label for'phone'>Phone:</label><input type='number' id='phone'  name='phone'/>" + "</form>"
				+ "		</div>" + "<button type ='button' class='collapsible'>Add Musician</button>"// musicians
				+ "		<div class='content'>" + "<form method='post'>"
				+ "<label for'musician'>Name of Musician:</label><input type='text' id='musician'  name='musician'/>"
				+ "<label for'Style'>Cousine:</label><input type='text' id='style'  name='style'/>"
				+ "<label for'phone'>Phone:</label><input type='number' id='phone'  name='phone'/>" + "</form>"
				+ "		</div>"

				+ "" + "</div>"

				+ ""// CSS
				+ "<style type=text/css>" + "h1{background-color:DarkCyan;text-align:center;}" + "#top {width:400px;}"
				+ "img {margin:10px;}" + ".collapsible {background-color: #eee;" + "color: #444;" + "  cursor: pointer;"
				+ "  padding: 18px;" + "	" + "  width: 100%;" + "  border: none;" + "  text-align: left;"
				+ "  outline: none;" + "  font-size: 15px;}" + ".active, .collapsible:hover {"
				+ "  background-color: #ccc;" + "}" + ".content {" + "  padding: 0 18px;" + "  display: flex;"
				+ "  overflow: hidden;" + "  background-color: #f1f1f1;" + "}"

				// js
				+ "<script>" + "var coll = document.getElementsByClassName('collapsible');" + "var i;"
				+ "for (i = 0; i < coll.length; i++) {" + "  coll[i].addEventListener('click', function() {"
				+ "    this.classList.toggle('active');" + "    var content = this.nextElementSibling;"
				+ "    if (content.style.display) {" + "      content.style.display = 'none';" + "    } else {"
				+ "      content.style.display = 'block' ;" + "    }" + "  });" + "}" + "</script>" + "");
	}

}
