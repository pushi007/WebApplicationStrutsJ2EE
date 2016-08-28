package com.tvm.ilp.t154.cao.controllers.logging;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import org.apache.log4j.PropertyConfigurator;

/**
 * Servlet implementation class LoggingServlet
 */
public class LoggingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {
		// Get Fully Qualified Path to Properties File
		String config = "C:/Temp/logs/t154-log4j.log";

		// getServletContext().getRealPath("/")
		// + getInitParameter("log4jconfig");
		System.out.println("*** LoggingServlet Initialized using file :" + config);

		// Initialize Properties for All Servlets
		PropertyConfigurator.configure(config);
	}
}
