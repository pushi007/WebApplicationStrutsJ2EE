package com.tvm.ilp.t154.cao.controllers;

import static com.tvm.ilp.t154.cao.constants.CAOConstants.*;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.tvm.ilp.t154.cao.exceptions.CommercialCustRegException;
import com.tvm.ilp.t154.cao.model.Employee;
import com.tvm.ilp.t154.cao.services.EmployeeManagementService;
import com.tvm.ilp.t154.cao.services.LoginService;
import com.tvm.ilp.t154.cao.controllers.logging.LoggingServlet;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(LoginServlet.class);

	private LoginService loginSer = new LoginService();
	private Employee emp = new Employee();
	private EmployeeManagementService empSer = new EmployeeManagementService();
	// HttpSession session;
	int back = 1;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = null;
		// ServletConfig config = getServletConfig();

		// HttpSession session = request.getSession(false);

		response.setHeader("Cache-Control", "no-cache"); // Forces caches to
		// obtain a new copy
		// of the page from
		// the origin server
		response.setHeader("Cache-Control", "no-store"); // Directs caches not
		// to store the page
		// under any
		// circumstance
		response.setDateHeader("Expires", 0); // Causes the proxy cache to see
		// the page as "stale"
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0 backward
		// compatibility

		String action = request.getParameter(ACTION);
		boolean flag = false;
		int empId = 0;

		// Login
		if (LOGIN.equals(action)) {
			logger.info("Entry into Login servlet");
			logger.info("Session created");

			session = request.getSession();
			String route = "route0";
			session.setAttribute("route", route);

			if (request.getParameter("UID") != ""
					&& request.getParameter("pwd") != "") {

				logger.warn("Request Username and Password ");
				
				empId = Integer.parseInt(request.getParameter("UID"));
				String passwd = request.getParameter("pwd");
			
				String designation = null;

				try {
					
					emp = loginSer.getEmpDetails(empId);
					
				} catch (CommercialCustRegException e) {
					request.setAttribute("errMsg", e.getMessage());
					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/CCRErrorPage.jsp");
					rd.forward(request, response);
				}

				// validate login

				if (emp != null) {
					if (empId == emp.getEmpId()
							&& passwd.equals(emp.getPassword())) {

						logger.info("Login Successful");
						session = request.getSession(true);
						session.setAttribute("UID", emp.getEmpId());
						session.setAttribute("pwd", emp.getPassword());
						session.setAttribute("role", emp.getDesignation());
						session.setAttribute("usernm", emp.getFirstNm());
						designation = emp.getDesignation();
						flag = true;

					} else {
						flag = false;
						logger.error("Invalid Username/Password");
					}
				}

				if (flag) {
					if (designation.equalsIgnoreCase("Admin")) {
						session = request.getSession();
						String language = (String) session.getAttribute("lang");
						if ("English".equals(language)|| language==null) {

							Locale locale = new Locale("en", "US");
							ResourceBundle rb = ResourceBundle
									.getBundle(
											"com.tvm.ilp.t154.cao.properties.MessagesBundle",
											locale);
						
							//session.setAttribute("lang", language);
							String keyATMServiceswa=rb.getString("keyATMServiceswa");
							String keyDebitCardwa=rb.getString("keyDebitCardwa");
							String keyInternetBankingServicewa=rb.getString("keyInternetBankingServicewa");
							String keyMobileBankingServicewa=rb.getString("keyMobileBankingServicewa");
							String keyEmployeewa  = rb.getString("keyEmployeewa");
							String keyRegisterLinkwa= rb.getString("keyRegisterLinkwa");
							String keyViewEmployeewa  = rb.getString("keyViewEmployeewa");
							String keyProductwa  = rb.getString("keyProductwa");
							
							String keyAddProductswa = rb.getString("keyAddProductswa");
							String keyViewProductswa  = rb.getString("keyViewProductswa");
							String keyProductReportwa = rb.getString("keyProductReportwa");
							String keyadditionalProductswa  = rb.getString("keyadditionalProductswa");
							String keyAddAdditionalProductwa  = rb.getString("keyAddAdditionalProductwa");
							String keyUpdateDeleteAdditionalProductwa  = rb.getString("keyUpdateDeleteAdditionalProductwa");
							String keyAdditionalProductReportwa = rb.getString("keyAdditionalProductReportwa");
							
							String keychart = rb.getString("keychart");
							String keyPie = rb.getString("keyPie");
							String keyvchart = rb.getString("keyvchart");
							String keyPasswordManagementwa = rb.getString("keyPasswordManagementwa");
							String keyChangePasswordwa = rb.getString("keyChangePasswordwa");
							
							String keyWelcomeAdministratorwa = rb.getString("keyWelcomeAdministratorwa");

							String keyasAnAdministratorHwa = rb.getString("keyasAnAdministratorHwa");
							String keyasAnAdministratorL1wa = rb.getString("keyasAnAdministratorL1wa");
							String keyasAnAdministratorL2wa = rb.getString("keyasAnAdministratorL2wa");
							String keyasAnAdministratorL3wa = rb.getString("keyasAnAdministratorL3wa");
							String keyasAnAdministratorL4wa = rb.getString("keyasAnAdministratorL4wa");
							String keyasAnAdministratorL5wa = rb.getString("keyasAnAdministratorL5wa");
							String keyasAnAdministratorL6wa = rb.getString("keyasAnAdministratorL6wa");
							String keyasAnAdministratorL7wa = rb.getString("keyasAnAdministratorL7wa");
							String keyasAnAdministratorL8wa = rb.getString("keyasAnAdministratorL8wa");
							String keyasAnAdministratorL9wa = rb.getString("keyasAnAdministratorL9wa");
							String keyasAnAdministratorL10wa = rb.getString("keyasAnAdministratorL10wa");
							String keyasAnAdministratorL11wa = rb.getString("keyasAnAdministratorL11wa");

							session.setAttribute("keyATMServiceswa",keyATMServiceswa );
							session.setAttribute("keyDebitCardwa",keyDebitCardwa );
							session.setAttribute("keyInternetBankingServicewa",keyInternetBankingServicewa );
							session.setAttribute("keyMobileBankingServicewa",keyMobileBankingServicewa );
							session.setAttribute("keyEmployeewa", keyEmployeewa);
							session.setAttribute("keyRegisterLinkwa",keyRegisterLinkwa );
							session.setAttribute("keyViewEmployeewa",keyViewEmployeewa );
							session.setAttribute("keyProductwa",keyProductwa );
							session.setAttribute("keyAddProductswa",keyAddProductswa );
							session.setAttribute("keyViewProductswa",keyViewProductswa );
							session.setAttribute("keyProductReportwa",keyProductReportwa );
							session.setAttribute("keyadditionalProductswa",keyadditionalProductswa );
							session.setAttribute("keyAddAdditionalProductwa", keyAddAdditionalProductwa);
							session.setAttribute("keyUpdateDeleteAdditionalProductwa",keyUpdateDeleteAdditionalProductwa );
							
							session.setAttribute("keychart",keychart );
							session.setAttribute("keyPie",keyPie );
							session.setAttribute("keyvchart",keyvchart );
							session.setAttribute("keyAdditionalProductReportwa",keyAdditionalProductReportwa );
							session.setAttribute("keyPasswordManagementwa",keyPasswordManagementwa );
							session.setAttribute("keyChangePasswordwa",keyChangePasswordwa );
							session.setAttribute("keyWelcomeAdministratorwa",keyWelcomeAdministratorwa );

							session.setAttribute("keyasAnAdministratorHwa",keyasAnAdministratorHwa );
							session.setAttribute("keyasAnAdministratorL1wa",keyasAnAdministratorL1wa );
							session.setAttribute("keyasAnAdministratorL2wa",keyasAnAdministratorL2wa );
							session.setAttribute("keyasAnAdministratorL3wa",keyasAnAdministratorL3wa );
							session.setAttribute("keyasAnAdministratorL4wa",keyasAnAdministratorL4wa );
							session.setAttribute("keyasAnAdministratorL5wa",keyasAnAdministratorL5wa );
							session.setAttribute("keyasAnAdministratorL6wa",keyasAnAdministratorL6wa );
							session.setAttribute("keyasAnAdministratorL7wa",keyasAnAdministratorL7wa );
							session.setAttribute("keyasAnAdministratorL8wa",keyasAnAdministratorL8wa );
							session.setAttribute("keyasAnAdministratorL9wa",keyasAnAdministratorL9wa );
							session.setAttribute("keyasAnAdministratorL10wa",keyasAnAdministratorL10wa );
							session.setAttribute("keyasAnAdministratorL11wa",keyasAnAdministratorL11wa );
						
							RequestDispatcher rd = request
									.getRequestDispatcher("/jsp/EmployeePortal.jsp");
							rd.forward(request, response);

						}

						else if ("French".equals(language)) {
							Locale locale = new Locale("fr", "FR");
							ResourceBundle rb = ResourceBundle
									.getBundle(
											"com.tvm.ilp.t154.cao.properties.MessagesBundle",
											locale);
							
							session.setAttribute("lang", language);
							String keyATMServiceswa=rb.getString("keyATMServiceswa");
							String keyDebitCardwa=rb.getString("keyDebitCardwa");
							String keyInternetBankingServicewa=rb.getString("keyInternetBankingServicewa");
							String keyMobileBankingServicewa=rb.getString("keyMobileBankingServicewa");
							String keyEmployeewa  = rb.getString("keyEmployeewa");
							String keyRegisterLinkwa= rb.getString("keyRegisterLinkwa");
							String keyViewEmployeewa  = rb.getString("keyViewEmployeewa");
							String keyProductwa  = rb.getString("keyProductwa");
							String keyAddProductswa = rb.getString("keyAddProductswa");
							String keyViewProductswa  = rb.getString("keyViewProductswa");
							String keyProductReportwa = rb.getString("keyProductReportwa");
							String keyadditionalProductswa  = rb.getString("keyadditionalProductswa");
							String keyAddAdditionalProductwa  = rb.getString("keyAddAdditionalProductwa");
							String keyUpdateDeleteAdditionalProductwa  = rb.getString("keyUpdateDeleteAdditionalProductwa");
							String keyAdditionalProductReportwa = rb.getString("keyAdditionalProductReportwa");
							
							String keychart = rb.getString("keychart");
							String keyPie = rb.getString("keyPie");
							String keyvchart = rb.getString("keyvchart");
							String keyPasswordManagementwa = rb.getString("keyPasswordManagementwa");
							String keyChangePasswordwa = rb.getString("keyChangePasswordwa");
							String keyWelcomeAdministratorwa = rb.getString("keyWelcomeAdministratorwa");

							String keyasAnAdministratorHwa = rb.getString("keyasAnAdministratorHwa");
							String keyasAnAdministratorL1wa = rb.getString("keyasAnAdministratorL1wa");
							String keyasAnAdministratorL2wa = rb.getString("keyasAnAdministratorL2wa");
							String keyasAnAdministratorL3wa = rb.getString("keyasAnAdministratorL3wa");
							String keyasAnAdministratorL4wa = rb.getString("keyasAnAdministratorL4wa");
							String keyasAnAdministratorL5wa = rb.getString("keyasAnAdministratorL5wa");
							String keyasAnAdministratorL6wa = rb.getString("keyasAnAdministratorL6wa");
							String keyasAnAdministratorL7wa = rb.getString("keyasAnAdministratorL7wa");
							String keyasAnAdministratorL8wa = rb.getString("keyasAnAdministratorL8wa");
							String keyasAnAdministratorL9wa = rb.getString("keyasAnAdministratorL9wa");
							String keyasAnAdministratorL10wa = rb.getString("keyasAnAdministratorL10wa");
							String keyasAnAdministratorL11wa = rb.getString("keyasAnAdministratorL11wa");

							session.setAttribute("keyATMServiceswa",keyATMServiceswa );
							session.setAttribute("keyDebitCardwa",keyDebitCardwa );
							session.setAttribute("keyInternetBankingServicewa",keyInternetBankingServicewa );
							session.setAttribute("keyMobileBankingServicewa",keyMobileBankingServicewa );
							session.setAttribute("keyEmployeewa", keyEmployeewa);
							session.setAttribute("keyRegisterLinkwa",keyRegisterLinkwa );
							session.setAttribute("keyViewEmployeewa",keyViewEmployeewa );
							session.setAttribute("keyProductwa",keyProductwa );
							
							
							session.setAttribute("keyAddProductswa",keyAddProductswa );
							session.setAttribute("keyViewProductswa",keyViewProductswa );
							session.setAttribute("keyProductReportwa",keyProductReportwa );
							session.setAttribute("keyadditionalProductswa",keyadditionalProductswa );
							session.setAttribute("keyAddAdditionalProductwa", keyAddAdditionalProductwa);
							session.setAttribute("keyUpdateDeleteAdditionalProductwa",keyUpdateDeleteAdditionalProductwa );
							session.setAttribute("keyAdditionalProductReportwa",keyAdditionalProductReportwa );

							session.setAttribute("keychart",keychart );
							session.setAttribute("keyPie",keyPie );
							session.setAttribute("keyvchart",keyvchart );
							session.setAttribute("keyPasswordManagementwa",keyPasswordManagementwa );
							session.setAttribute("keyChangePasswordwa",keyChangePasswordwa );
							session.setAttribute("keyWelcomeAdministratorwa",keyWelcomeAdministratorwa );

							
							session.setAttribute("keyasAnAdministratorHwa",keyasAnAdministratorHwa );
							session.setAttribute("keyasAnAdministratorL1wa",keyasAnAdministratorL1wa );
							session.setAttribute("keyasAnAdministratorL2wa",keyasAnAdministratorL2wa );
							session.setAttribute("keyasAnAdministratorL3wa",keyasAnAdministratorL3wa );
							session.setAttribute("keyasAnAdministratorL4wa",keyasAnAdministratorL4wa );
							session.setAttribute("keyasAnAdministratorL5wa",keyasAnAdministratorL5wa );
							session.setAttribute("keyasAnAdministratorL6wa",keyasAnAdministratorL6wa );
							session.setAttribute("keyasAnAdministratorL7wa",keyasAnAdministratorL7wa );
							session.setAttribute("keyasAnAdministratorL8wa",keyasAnAdministratorL8wa );
							session.setAttribute("keyasAnAdministratorL9wa",keyasAnAdministratorL9wa );
							session.setAttribute("keyasAnAdministratorL10wa",keyasAnAdministratorL10wa );
							session.setAttribute("keyasAnAdministratorL11wa",keyasAnAdministratorL11wa );
							
							RequestDispatcher rd = request
									.getRequestDispatcher("/jsp/EmployeePortal.jsp");
							rd.forward(request, response);

						} else if ("Spanish".equals(language)) {
							Locale locale = new Locale("es", "ES");
							ResourceBundle rb = ResourceBundle
									.getBundle(
											"com.tvm.ilp.t154.cao.properties.MessagesBundle",
											locale);

							session.setAttribute("lang", language);
							String keyATMServiceswa=rb.getString("keyATMServiceswa");
							String keyDebitCardwa=rb.getString("keyDebitCardwa");
							String keyInternetBankingServicewa=rb.getString("keyInternetBankingServicewa");
							String keyMobileBankingServicewa=rb.getString("keyMobileBankingServicewa");
							String keyEmployeewa  = rb.getString("keyEmployeewa");
							String keyRegisterLinkwa= rb.getString("keyRegisterLinkwa");
							String keyViewEmployeewa  = rb.getString("keyViewEmployeewa");
							String keyProductwa  = rb.getString("keyProductwa");
							
							String keyAddProductswa = rb.getString("keyAddProductswa");
							String keyViewProductswa  = rb.getString("keyViewProductswa");
							String keyProductReportwa = rb.getString("keyProductReportwa");
							String keyadditionalProductswa  = rb.getString("keyadditionalProductswa");
							String keyAddAdditionalProductwa  = rb.getString("keyAddAdditionalProductwa");
							String keyUpdateDeleteAdditionalProductwa  = rb.getString("keyUpdateDeleteAdditionalProductwa");
							
							String keychart = rb.getString("keychart");
							String keyPie = rb.getString("keyPie");
							String keyvchart = rb.getString("keyvchart");
							String keyAdditionalProductReportwa = rb.getString("keyAdditionalProductReportwa");
							String keyPasswordManagementwa = rb.getString("keyPasswordManagementwa");
							String keyChangePasswordwa = rb.getString("keyChangePasswordwa");
							String keyWelcomeAdministratorwa = rb.getString("keyWelcomeAdministratorwa");

							String keyasAnAdministratorHwa = rb.getString("keyasAnAdministratorHwa");
							String keyasAnAdministratorL1wa = rb.getString("keyasAnAdministratorL1wa");
							String keyasAnAdministratorL2wa = rb.getString("keyasAnAdministratorL2wa");
							String keyasAnAdministratorL3wa = rb.getString("keyasAnAdministratorL3wa");
							String keyasAnAdministratorL4wa = rb.getString("keyasAnAdministratorL4wa");
							String keyasAnAdministratorL5wa = rb.getString("keyasAnAdministratorL5wa");
							String keyasAnAdministratorL6wa = rb.getString("keyasAnAdministratorL6wa");
							String keyasAnAdministratorL7wa = rb.getString("keyasAnAdministratorL7wa");
							String keyasAnAdministratorL8wa = rb.getString("keyasAnAdministratorL8wa");
							String keyasAnAdministratorL9wa = rb.getString("keyasAnAdministratorL9wa");
							String keyasAnAdministratorL10wa = rb.getString("keyasAnAdministratorL10wa");
							String keyasAnAdministratorL11wa = rb.getString("keyasAnAdministratorL11wa");

							session.setAttribute("keyATMServiceswa",keyATMServiceswa );
							session.setAttribute("keyDebitCardwa",keyDebitCardwa );
							session.setAttribute("keyInternetBankingServicewa",keyInternetBankingServicewa );
							session.setAttribute("keyMobileBankingServicewa",keyMobileBankingServicewa );
							session.setAttribute("keyEmployeewa", keyEmployeewa);
							session.setAttribute("keyRegisterLinkwa",keyRegisterLinkwa );
							session.setAttribute("keyViewEmployeewa",keyViewEmployeewa );
							session.setAttribute("keyProductwa",keyProductwa );
						
							
							session.setAttribute("keyAddProductswa",keyAddProductswa );
							session.setAttribute("keyViewProductswa",keyViewProductswa );
							session.setAttribute("keyProductReportwa",keyProductReportwa );
							session.setAttribute("keyadditionalProductswa",keyadditionalProductswa );
							session.setAttribute("keyAddAdditionalProductwa", keyAddAdditionalProductwa);
							session.setAttribute("keyUpdateDeleteAdditionalProductwa",keyUpdateDeleteAdditionalProductwa );
							session.setAttribute("keyAdditionalProductReportwa",keyAdditionalProductReportwa );
							session.setAttribute("keychart",keychart );
							session.setAttribute("keyPie",keyPie );
							session.setAttribute("keyvchart",keyvchart );
							session.setAttribute("keyPasswordManagementwa",keyPasswordManagementwa );
							session.setAttribute("keyChangePasswordwa",keyChangePasswordwa );
							session.setAttribute("keyWelcomeAdministratorwa",keyWelcomeAdministratorwa );

							session.setAttribute("keyasAnAdministratorHwa",keyasAnAdministratorHwa );
							session.setAttribute("keyasAnAdministratorL1wa",keyasAnAdministratorL1wa );
							session.setAttribute("keyasAnAdministratorL2wa",keyasAnAdministratorL2wa );
							session.setAttribute("keyasAnAdministratorL3wa",keyasAnAdministratorL3wa );
							session.setAttribute("keyasAnAdministratorL4wa",keyasAnAdministratorL4wa );
							session.setAttribute("keyasAnAdministratorL5wa",keyasAnAdministratorL5wa );
							session.setAttribute("keyasAnAdministratorL6wa",keyasAnAdministratorL6wa );
							session.setAttribute("keyasAnAdministratorL7wa",keyasAnAdministratorL7wa );
							session.setAttribute("keyasAnAdministratorL8wa",keyasAnAdministratorL8wa );
							session.setAttribute("keyasAnAdministratorL9wa",keyasAnAdministratorL9wa );
							session.setAttribute("keyasAnAdministratorL10wa",keyasAnAdministratorL10wa );
							session.setAttribute("keyasAnAdministratorL11wa",keyasAnAdministratorL11wa );
							RequestDispatcher rd = request
									.getRequestDispatcher("/jsp/EmployeePortal.jsp");
							rd.forward(request, response);

						} else if ("German".equals(language)) {
							Locale locale = new Locale("de", "DE");
							ResourceBundle rb = ResourceBundle
									.getBundle(
											"com.tvm.ilp.t154.cao.properties.MessagesBundle",
											locale);

							session.setAttribute("lang", language);
							String keyATMServiceswa=rb.getString("keyATMServiceswa");
							String keyDebitCardwa=rb.getString("keyDebitCardwa");
							String keyInternetBankingServicewa=rb.getString("keyInternetBankingServicewa");
							String keyMobileBankingServicewa=rb.getString("keyMobileBankingServicewa");
							String keyEmployeewa  = rb.getString("keyEmployeewa");
							String keyRegisterLinkwa= rb.getString("keyRegisterLinkwa");
							String keyViewEmployeewa  = rb.getString("keyViewEmployeewa");
							String keyProductwa  = rb.getString("keyProductwa");
						
							String keyAddProductswa = rb.getString("keyAddProductswa");
							String keyViewProductswa  = rb.getString("keyViewProductswa");
							String keyProductReportwa = rb.getString("keyProductReportwa");
							String keyadditionalProductswa  = rb.getString("keyadditionalProductswa");
							String keyAddAdditionalProductwa  = rb.getString("keyAddAdditionalProductwa");
							String keyUpdateDeleteAdditionalProductwa  = rb.getString("keyUpdateDeleteAdditionalProductwa");
							String keychart = rb.getString("keychart");
							String keyPie = rb.getString("keyPie");
							String keyvchart = rb.getString("keyvchart");
							
							String keyAdditionalProductReportwa = rb.getString("keyAdditionalProductReportwa");
							String keyPasswordManagementwa = rb.getString("keyPasswordManagementwa");
							String keyChangePasswordwa = rb.getString("keyChangePasswordwa");
							String keyWelcomeAdministratorwa = rb.getString("keyWelcomeAdministratorwa");

							String keyasAnAdministratorHwa = rb.getString("keyasAnAdministratorHwa");
							String keyasAnAdministratorL1wa = rb.getString("keyasAnAdministratorL1wa");
							String keyasAnAdministratorL2wa = rb.getString("keyasAnAdministratorL2wa");
							String keyasAnAdministratorL3wa = rb.getString("keyasAnAdministratorL3wa");
							String keyasAnAdministratorL4wa = rb.getString("keyasAnAdministratorL4wa");
							String keyasAnAdministratorL5wa = rb.getString("keyasAnAdministratorL5wa");
							String keyasAnAdministratorL6wa = rb.getString("keyasAnAdministratorL6wa");
							String keyasAnAdministratorL7wa = rb.getString("keyasAnAdministratorL7wa");
							String keyasAnAdministratorL8wa = rb.getString("keyasAnAdministratorL8wa");
							String keyasAnAdministratorL9wa = rb.getString("keyasAnAdministratorL9wa");
							String keyasAnAdministratorL10wa = rb.getString("keyasAnAdministratorL10wa");
							String keyasAnAdministratorL11wa = rb.getString("keyasAnAdministratorL11wa");

							session.setAttribute("keyATMServiceswa",keyATMServiceswa );
							session.setAttribute("keyDebitCardwa",keyDebitCardwa );
							session.setAttribute("keyInternetBankingServicewa",keyInternetBankingServicewa );
							session.setAttribute("keyMobileBankingServicewa",keyMobileBankingServicewa );
							session.setAttribute("keyEmployeewa", keyEmployeewa);
							session.setAttribute("keyRegisterLinkwa",keyRegisterLinkwa );
							session.setAttribute("keyViewEmployeewa",keyViewEmployeewa );
							session.setAttribute("keyProductwa",keyProductwa );
							
						
							session.setAttribute("keyAddProductswa",keyAddProductswa );
							session.setAttribute("keyViewProductswa",keyViewProductswa );
							session.setAttribute("keyProductReportwa",keyProductReportwa );
							session.setAttribute("keyadditionalProductswa",keyadditionalProductswa );
							session.setAttribute("keyAddAdditionalProductwa", keyAddAdditionalProductwa);
							session.setAttribute("keyUpdateDeleteAdditionalProductwa",keyUpdateDeleteAdditionalProductwa );
							session.setAttribute("keyAdditionalProductReportwa",keyAdditionalProductReportwa );
							
							session.setAttribute("keychart",keychart );
							session.setAttribute("keyPie",keyPie );
							session.setAttribute("keyvchart",keyvchart );
							session.setAttribute("keyPasswordManagementwa",keyPasswordManagementwa );
							session.setAttribute("keyChangePasswordwa",keyChangePasswordwa );
							session.setAttribute("keyWelcomeAdministratorwa",keyWelcomeAdministratorwa );

							session.setAttribute("keyasAnAdministratorHwa",keyasAnAdministratorHwa );
							session.setAttribute("keyasAnAdministratorL1wa",keyasAnAdministratorL1wa );
							session.setAttribute("keyasAnAdministratorL2wa",keyasAnAdministratorL2wa );
							session.setAttribute("keyasAnAdministratorL3wa",keyasAnAdministratorL3wa );
							session.setAttribute("keyasAnAdministratorL4wa",keyasAnAdministratorL4wa );
							session.setAttribute("keyasAnAdministratorL5wa",keyasAnAdministratorL5wa );
							session.setAttribute("keyasAnAdministratorL6wa",keyasAnAdministratorL6wa );
							session.setAttribute("keyasAnAdministratorL7wa",keyasAnAdministratorL7wa );
							session.setAttribute("keyasAnAdministratorL8wa",keyasAnAdministratorL8wa );
							session.setAttribute("keyasAnAdministratorL9wa",keyasAnAdministratorL9wa );
							session.setAttribute("keyasAnAdministratorL10wa",keyasAnAdministratorL10wa );
							session.setAttribute("keyasAnAdministratorL11wa",keyasAnAdministratorL11wa );
							RequestDispatcher rd = request
									.getRequestDispatcher("/jsp/EmployeePortal.jsp");
							rd.forward(request, response);

						}

						
					} 
					
					
					else if (designation
							.equalsIgnoreCase("Commercial Account Opener")) {
						session = request.getSession();
						String language = (String) session.getAttribute("lang");

						if ("English".equals(language)||language==null) {

							Locale locale = new Locale("en", "US");
							ResourceBundle rb = ResourceBundle
									.getBundle(
											"com.tvm.ilp.t154.cao.properties.MessagesBundle",
											locale);

							//ACCOUNT OPENER PORTAL
							// menu
							String keyFindBusiness=rb.getString("keyFindBusiness");
							String keyComAccOpening=rb.getString("keyComAccOpening");
							String keyOpenAcc =rb.getString("keyOpenAcc");
							String keyAssignRelMgr=rb.getString("keyAssignRelMgr");
							String keyPie=rb.getString("keyPie");
							String keyBar=rb.getString("keyBar");
							String keyChangePasswordwa=rb.getString("keyChangePasswordwa");
							String keyPasswordManagementwa=rb.getString("keyPasswordManagementwa");
							String keychart=rb.getString("keychart");
							String keyvchart=rb.getString("keyvchart");
							//body
							String keyATMServiceswa=rb.getString("keyATMServiceswa");
							String keyDebitCardwa=rb.getString("keyDebitCardwa");
							String keyInternetBankingServicewa=rb.getString("keyInternetBankingServicewa");
							String keyMobileBankingServicewa=rb.getString("keyMobileBankingServicewa");
							String keyWelcomeAC=rb.getString("keyWelcomeAC");
							String keydeshead=rb.getString("keydeshead");
							String keydesl1=rb.getString("keydesl1");
							String keydesl2=rb.getString("keydesl2");
							String keydesl3=rb.getString("keydesl3");
							String keydesl4=rb.getString("keydesl4");
							String keydesl5=rb.getString("keydesl5");
							String keydesl6=rb.getString("keydesl6");
							String keydesl7=rb.getString("keydesl7");
							String keydesl8=rb.getString("keydesl8");
							String keydesl9=rb.getString("keydesl9");
							
							session = request.getSession();
							//menu
							session.setAttribute("keyFindBusiness",keyFindBusiness);
							session.setAttribute("keyComAccOpening",keyComAccOpening);
							session.setAttribute("keyOpenAcc",keyOpenAcc);
							session.setAttribute("keyAssignRelMgr",keyAssignRelMgr);
							session.setAttribute("keyPie",keyPie);
							session.setAttribute("keyBar",keyBar);
							session.setAttribute("keychart",keychart);
							session.setAttribute("keyvchart",keyvchart);
							session.setAttribute("keyChangePasswordwa",keyChangePasswordwa);
							session.setAttribute("keyPasswordManagementwa",keyPasswordManagementwa);
							//body
							session.setAttribute("keyATMServiceswa",keyATMServiceswa );
							session.setAttribute("keyDebitCardwa",keyDebitCardwa );
							session.setAttribute("keyInternetBankingServicewa",keyInternetBankingServicewa );
							session.setAttribute("keyMobileBankingServicewa",keyMobileBankingServicewa );
							session.setAttribute("keyWelcomeAC",keyWelcomeAC);
							session.setAttribute("keydeshead",keydeshead);
							session.setAttribute("keydesl1",keydesl1);
							session.setAttribute("keydesl2",keydesl2);
							session.setAttribute("keydesl3",keydesl3);
							session.setAttribute("keydesl4",keydesl4);
							session.setAttribute("keydesl5",keydesl5);
							session.setAttribute("keydesl6",keydesl6);
							session.setAttribute("keydesl7",keydesl7);
							session.setAttribute("keydesl8",keydesl8);
							session.setAttribute("keydesl9",keydesl9);
							
							
							//AssignRelationshipManager
							String keySearchforBusinessCustomersDetails=rb.getString("keySearchforBusinessCustomersDetails");
							String keyfieldsmarkedwith=rb.getString("keyfieldsmarkedwith");
							String keyaremandatory=rb.getString("keyaremandatory");
							String keyEnterBusinessName=rb.getString("keyEnterBusinessName");
							String keysearchbutton =rb.getString("keysearchbutton");
							String keyCommercial=rb.getString("keyCommercial");
							String keyMyPortal=rb.getString("keyMyPortal");
							String keyOR=rb.getString("keyOR");
							String keyEnterTradingName=rb.getString("keyEnterTradingName");
							
							session=request.getSession();
							session.setAttribute("keySearchforBusinessCustomersDetails", keySearchforBusinessCustomersDetails);
							session.setAttribute("keyfieldsmarkedwith", keyfieldsmarkedwith);
							session.setAttribute("keyaremandatory", keyaremandatory);
							session.setAttribute("keyEnterBusinessName", keyEnterBusinessName);
							session.setAttribute("keyEnterTradingName", keyEnterTradingName);
							session.setAttribute("keyCommercial", keyCommercial);
							session.setAttribute("keysearchbutton",keysearchbutton);
							session.setAttribute("keyOR",keyOR);
							session.setAttribute("keyMyPortal",keyMyPortal);
						
							
							
							RequestDispatcher rd = request
									.getRequestDispatcher("/jsp/RegistrationPortal.jsp");
							rd.forward(request, response);

						}

						else if ("French".equals(language)) {
							Locale locale = new Locale("fr", "FR");
							ResourceBundle rb = ResourceBundle
									.getBundle(
											"com.tvm.ilp.t154.cao.properties.MessagesBundle",
											locale);
							//ACCOUNT OPENER PORTAL
							// menu
							String keyFindBusiness=rb.getString("keyFindBusiness");
							String keyComAccOpening=rb.getString("keyComAccOpening");
							String keyOpenAcc =rb.getString("keyOpenAcc");
							String keyAssignRelMgr=rb.getString("keyAssignRelMgr");
							String keyPie=rb.getString("keyPie");
							String keyBar=rb.getString("keyBar");
							String keyChangePasswordwa=rb.getString("keyChangePasswordwa");
							String keyPasswordManagementwa=rb.getString("keyPasswordManagementwa");
							String keychart=rb.getString("keychart");
							String keyvchart=rb.getString("keyvchart");
							//body
							String keyATMServiceswa=rb.getString("keyATMServiceswa");
							String keyDebitCardwa=rb.getString("keyDebitCardwa");
							String keyInternetBankingServicewa=rb.getString("keyInternetBankingServicewa");
							String keyMobileBankingServicewa=rb.getString("keyMobileBankingServicewa");
							String keyWelcomeAC=rb.getString("keyWelcomeAC");
							String keydeshead=rb.getString("keydeshead");
							String keydesl1=rb.getString("keydesl1");
							String keydesl2=rb.getString("keydesl2");
							String keydesl3=rb.getString("keydesl3");
							String keydesl4=rb.getString("keydesl4");
							String keydesl5=rb.getString("keydesl5");
							String keydesl6=rb.getString("keydesl6");
							String keydesl7=rb.getString("keydesl7");
							String keydesl8=rb.getString("keydesl8");
							String keydesl9=rb.getString("keydesl9");
							
							session = request.getSession();
							//menu
							session.setAttribute("keyFindBusiness",keyFindBusiness);
							session.setAttribute("keyComAccOpening",keyComAccOpening);
							session.setAttribute("keyOpenAcc",keyOpenAcc);
							session.setAttribute("keyAssignRelMgr",keyAssignRelMgr);
							session.setAttribute("keyPie",keyPie);
							session.setAttribute("keyBar",keyBar);
							session.setAttribute("keychart",keychart);
							session.setAttribute("keyvchart",keyvchart);
							session.setAttribute("keyChangePasswordwa",keyChangePasswordwa);
							session.setAttribute("keyPasswordManagementwa",keyPasswordManagementwa);
							//body
							session.setAttribute("keyATMServiceswa",keyATMServiceswa );
							session.setAttribute("keyDebitCardwa",keyDebitCardwa );
							session.setAttribute("keyInternetBankingServicewa",keyInternetBankingServicewa );
							session.setAttribute("keyMobileBankingServicewa",keyMobileBankingServicewa );
							session.setAttribute("keyWelcomeAC",keyWelcomeAC);
							session.setAttribute("keydeshead",keydeshead);
							session.setAttribute("keydesl1",keydesl1);
							session.setAttribute("keydesl2",keydesl2);
							session.setAttribute("keydesl3",keydesl3);
							session.setAttribute("keydesl4",keydesl4);
							session.setAttribute("keydesl5",keydesl5);
							session.setAttribute("keydesl6",keydesl6);
							session.setAttribute("keydesl7",keydesl7);
							session.setAttribute("keydesl8",keydesl8);
							session.setAttribute("keydesl9",keydesl9);
							
							//AssignRelationshipManager
							String keySearchforBusinessCustomersDetails=rb.getString("keySearchforBusinessCustomersDetails");
							String keyfieldsmarkedwith=rb.getString("keyfieldsmarkedwith");
							String keyaremandatory=rb.getString("keyaremandatory");
							String keyEnterBusinessName=rb.getString("keyEnterBusinessName");
							String keysearchbutton =rb.getString("keysearchbutton");
							String keyCommercial=rb.getString("keyCommercial");
							String keyMyPortal=rb.getString("keyMyPortal");
							String keyOR=rb.getString("keyOR");
							String keyEnterTradingName=rb.getString("keyEnterTradingName");
							
							session=request.getSession();
							session.setAttribute("keySearchforBusinessCustomersDetails", keySearchforBusinessCustomersDetails);
							session.setAttribute("keyfieldsmarkedwith", keyfieldsmarkedwith);
							session.setAttribute("keyaremandatory", keyaremandatory);
							session.setAttribute("keyEnterBusinessName", keyEnterBusinessName);
							session.setAttribute("keyEnterTradingName", keyEnterTradingName);
							session.setAttribute("keyCommercial", keyCommercial);
							session.setAttribute("keysearchbutton",keysearchbutton);
							session.setAttribute("keyOR",keyOR);
							session.setAttribute("keyMyPortal",keyMyPortal);
							RequestDispatcher rd = request
									.getRequestDispatcher("/jsp/RegistrationPortal.jsp");
							rd.forward(request, response);

						} else if ("Spanish".equals(language)) {
							Locale locale = new Locale("es", "ES");
							ResourceBundle rb = ResourceBundle
									.getBundle(
											"com.tvm.ilp.t154.cao.properties.MessagesBundle",
											locale);

							//ACCOUNT OPENER PORTAL
							// menu
							String keyFindBusiness=rb.getString("keyFindBusiness");
							String keyComAccOpening=rb.getString("keyComAccOpening");
							String keyOpenAcc =rb.getString("keyOpenAcc");
							String keyAssignRelMgr=rb.getString("keyAssignRelMgr");
							String keyPie=rb.getString("keyPie");
							String keyBar=rb.getString("keyBar");
							String keyChangePasswordwa=rb.getString("keyChangePasswordwa");
							String keyPasswordManagementwa=rb.getString("keyPasswordManagementwa");
							String keychart=rb.getString("keychart");
							String keyvchart=rb.getString("keyvchart");
							//body
							String keyATMServiceswa=rb.getString("keyATMServiceswa");
							String keyDebitCardwa=rb.getString("keyDebitCardwa");
							String keyInternetBankingServicewa=rb.getString("keyInternetBankingServicewa");
							String keyMobileBankingServicewa=rb.getString("keyMobileBankingServicewa");
							String keyWelcomeAC=rb.getString("keyWelcomeAC");
							String keydeshead=rb.getString("keydeshead");
							String keydesl1=rb.getString("keydesl1");
							String keydesl2=rb.getString("keydesl2");
							String keydesl3=rb.getString("keydesl3");
							String keydesl4=rb.getString("keydesl4");
							String keydesl5=rb.getString("keydesl5");
							String keydesl6=rb.getString("keydesl6");
							String keydesl7=rb.getString("keydesl7");
							String keydesl8=rb.getString("keydesl8");
							String keydesl9=rb.getString("keydesl9");
							
							session = request.getSession();
							//menu
							session.setAttribute("keyFindBusiness",keyFindBusiness);
							session.setAttribute("keyComAccOpening",keyComAccOpening);
							session.setAttribute("keyOpenAcc",keyOpenAcc);
							session.setAttribute("keyAssignRelMgr",keyAssignRelMgr);
							session.setAttribute("keyPie",keyPie);
							session.setAttribute("keyBar",keyBar);
							session.setAttribute("keychart",keychart);
							session.setAttribute("keyvchart",keyvchart);
							session.setAttribute("keyChangePasswordwa",keyChangePasswordwa);
							session.setAttribute("keyPasswordManagementwa",keyPasswordManagementwa);
							//body
							session.setAttribute("keyATMServiceswa",keyATMServiceswa );
							session.setAttribute("keyDebitCardwa",keyDebitCardwa );
							session.setAttribute("keyInternetBankingServicewa",keyInternetBankingServicewa );
							session.setAttribute("keyMobileBankingServicewa",keyMobileBankingServicewa );
							session.setAttribute("keyWelcomeAC",keyWelcomeAC);
							session.setAttribute("keydeshead",keydeshead);
							session.setAttribute("keydesl1",keydesl1);
							session.setAttribute("keydesl2",keydesl2);
							session.setAttribute("keydesl3",keydesl3);
							session.setAttribute("keydesl4",keydesl4);
							session.setAttribute("keydesl5",keydesl5);
							session.setAttribute("keydesl6",keydesl6);
							session.setAttribute("keydesl7",keydesl7);
							session.setAttribute("keydesl8",keydesl8);
							session.setAttribute("keydesl9",keydesl9);
							
							//AssignRelationshipManager
							String keySearchforBusinessCustomersDetails=rb.getString("keySearchforBusinessCustomersDetails");
							String keyfieldsmarkedwith=rb.getString("keyfieldsmarkedwith");
							String keyaremandatory=rb.getString("keyaremandatory");
							String keyEnterBusinessName=rb.getString("keyEnterBusinessName");
							String keysearchbutton =rb.getString("keysearchbutton");
							String keyCommercial=rb.getString("keyCommercial");
							String keyMyPortal=rb.getString("keyMyPortal");
							String keyOR=rb.getString("keyOR");
							String keyEnterTradingName=rb.getString("keyEnterTradingName");
							
							session=request.getSession();
							session.setAttribute("keySearchforBusinessCustomersDetails", keySearchforBusinessCustomersDetails);
							session.setAttribute("keyfieldsmarkedwith", keyfieldsmarkedwith);
							session.setAttribute("keyaremandatory", keyaremandatory);
							session.setAttribute("keyEnterBusinessName", keyEnterBusinessName);
							session.setAttribute("keyEnterTradingName", keyEnterTradingName);
							session.setAttribute("keyCommercial", keyCommercial);
							session.setAttribute("keysearchbutton",keysearchbutton);
							session.setAttribute("keyOR",keyOR);
							session.setAttribute("keyMyPortal",keyMyPortal);
							RequestDispatcher rd = request
									.getRequestDispatcher("/jsp/RegistrationPortal.jsp");
							rd.forward(request, response);

						}else if ("German".equals(language)) {
							Locale locale = new Locale("de", "DE");
							ResourceBundle rb = ResourceBundle
									.getBundle(
											"com.tvm.ilp.t154.cao.properties.MessagesBundle",
											locale);

							//ACCOUNT OPENER PORTAL
							// menu
							String keyFindBusiness=rb.getString("keyFindBusiness");
							String keyComAccOpening=rb.getString("keyComAccOpening");
							String keyOpenAcc =rb.getString("keyOpenAcc");
							String keyAssignRelMgr=rb.getString("keyAssignRelMgr");
							String keyPie=rb.getString("keyPie");
							String keyBar=rb.getString("keyBar");
							String keyChangePasswordwa=rb.getString("keyChangePasswordwa");
							String keyPasswordManagementwa=rb.getString("keyPasswordManagementwa");
							String keychart=rb.getString("keychart");
							String keyvchart=rb.getString("keyvchart");
							//body
							String keyATMServiceswa=rb.getString("keyATMServiceswa");
							String keyDebitCardwa=rb.getString("keyDebitCardwa");
							String keyInternetBankingServicewa=rb.getString("keyInternetBankingServicewa");
							String keyMobileBankingServicewa=rb.getString("keyMobileBankingServicewa");
							String keyWelcomeAC=rb.getString("keyWelcomeAC");
							String keydeshead=rb.getString("keydeshead");
							String keydesl1=rb.getString("keydesl1");
							String keydesl2=rb.getString("keydesl2");
							String keydesl3=rb.getString("keydesl3");
							String keydesl4=rb.getString("keydesl4");
							String keydesl5=rb.getString("keydesl5");
							String keydesl6=rb.getString("keydesl6");
							String keydesl7=rb.getString("keydesl7");
							String keydesl8=rb.getString("keydesl8");
							String keydesl9=rb.getString("keydesl9");
							
							session = request.getSession();
							//menu
							session.setAttribute("keyFindBusiness",keyFindBusiness);
							session.setAttribute("keyComAccOpening",keyComAccOpening);
							session.setAttribute("keyOpenAcc",keyOpenAcc);
							session.setAttribute("keyAssignRelMgr",keyAssignRelMgr);
							session.setAttribute("keyPie",keyPie);
							session.setAttribute("keyBar",keyBar);
							session.setAttribute("keychart",keychart);
							session.setAttribute("keyvchart",keyvchart);
							session.setAttribute("keyChangePasswordwa",keyChangePasswordwa);
							session.setAttribute("keyPasswordManagementwa",keyPasswordManagementwa);
							//body
							session.setAttribute("keyATMServiceswa",keyATMServiceswa );
							session.setAttribute("keyDebitCardwa",keyDebitCardwa );
							session.setAttribute("keyInternetBankingServicewa",keyInternetBankingServicewa );
							session.setAttribute("keyMobileBankingServicewa",keyMobileBankingServicewa );
							session.setAttribute("keyWelcomeAC",keyWelcomeAC);
							session.setAttribute("keydeshead",keydeshead);
							session.setAttribute("keydesl1",keydesl1);
							session.setAttribute("keydesl2",keydesl2);
							session.setAttribute("keydesl3",keydesl3);
							session.setAttribute("keydesl4",keydesl4);
							session.setAttribute("keydesl5",keydesl5);
							session.setAttribute("keydesl6",keydesl6);
							session.setAttribute("keydesl7",keydesl7);
							session.setAttribute("keydesl8",keydesl8);
							session.setAttribute("keydesl9",keydesl9);
							
							
							//AssignRelationshipManager
							String keySearchforBusinessCustomersDetails=rb.getString("keySearchforBusinessCustomersDetails");
							String keyfieldsmarkedwith=rb.getString("keyfieldsmarkedwith");
							String keyaremandatory=rb.getString("keyaremandatory");
							String keyEnterBusinessName=rb.getString("keyEnterBusinessName");
							String keysearchbutton =rb.getString("keysearchbutton");
							String keyCommercial=rb.getString("keyCommercial");
							String keyMyPortal=rb.getString("keyMyPortal");
							String keyOR=rb.getString("keyOR");
							String keyEnterTradingName=rb.getString("keyEnterTradingName");
							
							session=request.getSession();
							session.setAttribute("keySearchforBusinessCustomersDetails", keySearchforBusinessCustomersDetails);
							session.setAttribute("keyfieldsmarkedwith", keyfieldsmarkedwith);
							session.setAttribute("keyaremandatory", keyaremandatory);
							session.setAttribute("keyEnterBusinessName", keyEnterBusinessName);
							session.setAttribute("keyEnterTradingName", keyEnterTradingName);
							session.setAttribute("keyCommercial", keyCommercial);
							session.setAttribute("keysearchbutton",keysearchbutton);
							session.setAttribute("keyOR",keyOR);
							session.setAttribute("keyMyPortal",keyMyPortal);
							
							RequestDispatcher rd = request
									.getRequestDispatcher("/jsp/RegistrationPortal.jsp");
							rd.forward(request, response);

						}

						
					} else if (designation
							.equalsIgnoreCase("Back Office Employee")) {
						response.sendRedirect(request.getContextPath()
								+ "/jsp/UnauthorizedLogin.jsp");
					} else if (designation
							.equalsIgnoreCase("Relationship Manager")) {
						response.sendRedirect(request.getContextPath()
								+ "/jsp/UnauthorizedLogin.jsp");
					} else if (designation
							.equalsIgnoreCase("Help Desk Employee")) {
						response.sendRedirect(request.getContextPath()
								+ "/jsp/UnauthorizedLogin.jsp");
					}
				}

				else {

					response
							.sendRedirect(request.getContextPath()
									+ "/jsp/HomeLogin.jsp?msg=Invalid Username/Password");

				}

			} else {
				logger.error("Please enter Username and Password");
				response
						.sendRedirect(request.getContextPath()
								+ "/jsp/HomeLogin.jsp?msg=Please enter Username and Password");

			}

		}

		// Logout
		else if (LOGOUT.equalsIgnoreCase(action)) { // back=0;
			session = request.getSession();
			session.invalidate();
			response.sendRedirect(request.getContextPath()
					+ "/jsp/HomeLogin.jsp");
			logger.info("Logout");
			logger.info("Exit from Login Servlet");
			return;

		}

		// Forgot password
		else if (FORGOTPWD.equalsIgnoreCase(action)) {
			logger.info("Entry into Forgot Password");
			response.sendRedirect(request.getContextPath()
					+ "/jsp/ForgotPwd.jsp");
		}

		// Access Question
		else if (FORGOTPWDQ.equalsIgnoreCase(action)) {

			empId = Integer.parseInt(request.getParameter("empId"));
			try {

				emp = loginSer.accessSecuQues(empId);

			} catch (CommercialCustRegException e) {
				e.printStackTrace();
				request.setAttribute("errMsg", e.getMessage());
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/CCRErrorPage.jsp");
				rd.forward(request, response);
			}
			if (emp != null) {
				session = request.getSession();
				session.setAttribute("emp", emp);
				if (emp.getAnswer() == null) {
					session.invalidate();
					response
							.sendRedirect(request.getContextPath()
									+ "/jsp/HomeLogin.jsp?msg=Please Login with your Default Password");
				} else {
					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/ForgotPwdReset.jsp");
					rd.forward(request, response);
				}
			} else {
				logger.info("Employee does not exist");
				String msg = "Employee Id not found";
				request.setAttribute("msg", msg);
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/ForgotPwd.jsp");
				rd.forward(request, response);
			}

		}

		else if (LANG.equals(action) || action == null)

		{

			String language = request.getParameter("language");
			if ("English".equals(language)||language==null) {

				Locale locale = new Locale("en", "US");
				ResourceBundle rb = ResourceBundle.getBundle(
						"com.tvm.ilp.t154.cao.properties.MessagesBundle",
						locale);

				String homeHeader = rb.getString("keyhomeheader");
				String aboutusHeader = rb.getString("keyAboutUsheader");
				String contactsHeader = rb.getString("keyContactusheader");
				String helpHeader = rb.getString("keyHelpheader");
				String tagLinehl = rb.getString("keyTaglinehl");
				// menu bar
				String loginHeading = rb.getString("keyLoginheadinghl");
				String userName = rb.getString("keyUserNamehl");
				String passWord = rb.getString("keyPassWordhl");
				String loginButton = rb.getString("keyLoginButtonhl");
				String forgotaPassword = rb.getString("keyForgotPasswordhl");
				String newsAndUpdates = rb.getString("keyNewsAndUpdateshl");
				String importantUpdates = rb.getString("keyImportantUpdateshl");
				String update1 = rb.getString("keynews1hl");
				String update2 = rb.getString("keynews2hl");
				String update3 = rb.getString("keynews3hl");
				// body
				String messageContent = rb.getString("keyContentMessagehl");
				String messageAbout = rb.getString("keyContentAbouthl");

				// footer
				String homeFooter = rb.getString("keyhomefooter");
				String aboutusFooter = rb.getString("keyAboutUsfooter");
				String contactusFooter = rb.getString("keyContactusfooter");
				String helpFooter = rb.getString("keyHelpfooter");
				String copyrights = rb.getString("keyCopyRightsfooter");
				String designedBy = rb.getString("keyDesignedByfooter");

				session = request.getSession();
				// header
				session.setAttribute("homeaheader", homeHeader);
				session.setAttribute("aboutusHeader", aboutusHeader);
				session.setAttribute("contactsHeader", contactsHeader);
				session.setAttribute("helpHeader", helpHeader);
				session.setAttribute("tagLinehl", tagLinehl);
				// menubar
				session.setAttribute("loginHeading", loginHeading);
				session.setAttribute("userName", userName);
				session.setAttribute("passWord", passWord);
				session.setAttribute("loginButton", loginButton);
				session.setAttribute("forgotaPassword", forgotaPassword);
				session.setAttribute("newsAndUpdates", newsAndUpdates);
				session.setAttribute("importantUpdates", importantUpdates);
				session.setAttribute("update1", update1);
				session.setAttribute("update2", update2);
				session.setAttribute("update3", update3);
				// body
				session.setAttribute("messageContent", messageContent);
				session.setAttribute("messageAbout", messageAbout);
				// footer
				session.setAttribute("homeFooter", homeFooter);
				session.setAttribute("aboutusFooter", aboutusFooter);
				session.setAttribute("contactusFooter", contactusFooter);
				session.setAttribute("helpFooter", helpFooter);
				session.setAttribute("copyrights", copyrights);
				session.setAttribute("designedBy", designedBy);
				session.setAttribute("lang", language);
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/HomeLogin.jsp");
				rd.forward(request, response);

			}

			else if (language.equals("French")) {
				Locale locale = new Locale("fr", "FR");
				ResourceBundle rb = ResourceBundle.getBundle(
						"com.tvm.ilp.t154.cao.properties.MessagesBundle",
						locale);

				String homeHeader = rb.getString("keyhomeheader");
				String aboutusHeader = rb.getString("keyAboutUsheader");
				String contactsHeader = rb.getString("keyContactusheader");
				String helpHeader = rb.getString("keyHelpheader");
				String tagLinehl = rb.getString("keyTaglinehl");
				// menu bar
				String loginHeading = rb.getString("keyLoginheadinghl");
				String userName = rb.getString("keyUserNamehl");
				String passWord = rb.getString("keyPassWordhl");
				String loginButton = rb.getString("keyLoginButtonhl");
				String forgotaPassword = rb.getString("keyForgotPasswordhl");
				String newsAndUpdates = rb.getString("keyNewsAndUpdateshl");
				String importantUpdates = rb.getString("keyImportantUpdateshl");
				String update1 = rb.getString("keynews1hl");
				String update2 = rb.getString("keynews2hl");
				String update3 = rb.getString("keynews3hl");
				// body
				String messageContent = rb.getString("keyContentMessagehl");
				String messageAbout = rb.getString("keyContentAbouthl");

				// footer
				String homeFooter = rb.getString("keyhomefooter");
				String aboutusFooter = rb.getString("keyAboutUsfooter");
				String contactusFooter = rb.getString("keyContactusfooter");
				String helpFooter = rb.getString("keyHelpfooter");
				String copyrights = rb.getString("keyCopyRightsfooter");
				String designedBy = rb.getString("keyDesignedByfooter");

				session = request.getSession();
				// header
				session.setAttribute("homeaheader", homeHeader);
				session.setAttribute("aboutusHeader", aboutusHeader);
				session.setAttribute("contactsHeader", contactsHeader);
				session.setAttribute("helpHeader", helpHeader);
				session.setAttribute("tagLinehl", tagLinehl);
				// menubar
				session.setAttribute("loginHeading", loginHeading);
				session.setAttribute("userName", userName);
				session.setAttribute("passWord", passWord);
				session.setAttribute("loginButton", loginButton);
				session.setAttribute("forgotaPassword", forgotaPassword);
				session.setAttribute("newsAndUpdates", newsAndUpdates);
				session.setAttribute("importantUpdates", importantUpdates);
				session.setAttribute("update1", update1);
				session.setAttribute("update2", update2);
				session.setAttribute("update3", update3);
				// body
				session.setAttribute("messageContent", messageContent);
				session.setAttribute("messageAbout", messageAbout);
				// footer
				session.setAttribute("homeFooter", homeFooter);
				session.setAttribute("aboutusFooter", aboutusFooter);
				session.setAttribute(" contactusFooter", contactusFooter);
				session.setAttribute("helpFooter", helpFooter);
				session.setAttribute("copyrights", copyrights);
				session.setAttribute("designedBy", designedBy);
				session.setAttribute("lang", language);
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/HomeLogin.jsp");
				rd.forward(request, response);

			} else if (language.equals("Spanish")) {
				Locale locale = new Locale("es", "ES");
				ResourceBundle rb = ResourceBundle.getBundle(
						"com.tvm.ilp.t154.cao.properties.MessagesBundle",
						locale);

				String homeHeader = rb.getString("keyhomeheader");
				String aboutusHeader = rb.getString("keyAboutUsheader");
				String contactsHeader = rb.getString("keyContactusheader");
				String helpHeader = rb.getString("keyHelpheader");
				String tagLinehl = rb.getString("keyTaglinehl");
				// menu bar
				String loginHeading = rb.getString("keyLoginheadinghl");
				String userName = rb.getString("keyUserNamehl");
				String passWord = rb.getString("keyPassWordhl");
				String loginButton = rb.getString("keyLoginButtonhl");
				String forgotaPassword = rb.getString("keyForgotPasswordhl");
				String newsAndUpdates = rb.getString("keyNewsAndUpdateshl");
				String importantUpdates = rb.getString("keyImportantUpdateshl");
				String update1 = rb.getString("keynews1hl");
				String update2 = rb.getString("keynews2hl");
				String update3 = rb.getString("keynews3hl");
				// body
				String messageContent = rb.getString("keyContentMessagehl");
				String messageAbout = rb.getString("keyContentAbouthl");

				// footer
				String homeFooter = rb.getString("keyhomefooter");
				String aboutusFooter = rb.getString("keyAboutUsfooter");
				String contactusFooter = rb.getString("keyContactusfooter");
				String helpFooter = rb.getString("keyHelpfooter");
				String copyrights = rb.getString("keyCopyRightsfooter");
				String designedBy = rb.getString("keyDesignedByfooter");

				session = request.getSession();
				// header
				session.setAttribute("homeaheader", homeHeader);
				session.setAttribute("aboutusHeader", aboutusHeader);
				session.setAttribute("contactsHeader", contactsHeader);
				session.setAttribute("helpHeader", helpHeader);
				session.setAttribute("tagLinehl", tagLinehl);
				// menubar
				session.setAttribute("loginHeading", loginHeading);
				session.setAttribute("userName", userName);
				session.setAttribute("passWord", passWord);
				session.setAttribute("loginButton", loginButton);
				session.setAttribute("forgotaPassword", forgotaPassword);
				session.setAttribute("newsAndUpdates", newsAndUpdates);
				session.setAttribute("importantUpdates", importantUpdates);
				session.setAttribute("update1", update1);
				session.setAttribute("update2", update2);
				session.setAttribute("update3", update3);
				// body
				session.setAttribute("messageContent", messageContent);
				session.setAttribute("messageAbout", messageAbout);
				// footer
				session.setAttribute("homeFooter", homeFooter);
				session.setAttribute("aboutusFooter", aboutusFooter);
				session.setAttribute("contactusFooter", contactusFooter);
				session.setAttribute("helpFooter", helpFooter);
				session.setAttribute("copyrights", copyrights);
				session.setAttribute("designedBy", designedBy);
				session.setAttribute("lang", language);
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/HomeLogin.jsp");
				rd.forward(request, response);

			} else if (language.equals("German")) {
				Locale locale = new Locale("de", "DE");
				ResourceBundle rb = ResourceBundle.getBundle(
						"com.tvm.ilp.t154.cao.properties.MessagesBundle",
						locale);

				String homeHeader = rb.getString("keyhomeheader");
				String aboutusHeader = rb.getString("keyAboutUsheader");
				String contactsHeader = rb.getString("keyContactusheader");
				String helpHeader = rb.getString("keyHelpheader");
				String tagLinehl = rb.getString("keyTaglinehl");
				// menu bar
				String loginHeading = rb.getString("keyLoginheadinghl");
				String userName = rb.getString("keyUserNamehl");
				String passWord = rb.getString("keyPassWordhl");
				String loginButton = rb.getString("keyLoginButtonhl");
				String forgotaPassword = rb.getString("keyForgotPasswordhl");
				String newsAndUpdates = rb.getString("keyNewsAndUpdateshl");
				String importantUpdates = rb.getString("keyImportantUpdateshl");
				String update1 = rb.getString("keynews1hl");
				String update2 = rb.getString("keynews2hl");
				String update3 = rb.getString("keynews3hl");
				// body
				String messageContent = rb.getString("keyContentMessagehl");
				String messageAbout = rb.getString("keyContentAbouthl");

				// footer
				String homeFooter = rb.getString("keyhomefooter");
				String aboutusFooter = rb.getString("keyAboutUsfooter");
				String contactusFooter = rb.getString("keyContactusfooter");
				String helpFooter = rb.getString("keyHelpfooter");
				String copyrights = rb.getString("keyCopyRightsfooter");
				String designedBy = rb.getString("keyDesignedByfooter");

				session = request.getSession();
				// header
				session.setAttribute("homeaheader", homeHeader);
				session.setAttribute("aboutusHeader", aboutusHeader);
				session.setAttribute("contactsHeader", contactsHeader);
				session.setAttribute("helpHeader", helpHeader);
				session.setAttribute("tagLinehl", tagLinehl);
				// menubar
				session.setAttribute("loginHeading", loginHeading);
				session.setAttribute("userName", userName);
				session.setAttribute("passWord", passWord);
				session.setAttribute("loginButton", loginButton);
				session.setAttribute("forgotaPassword", forgotaPassword);
				session.setAttribute("newsAndUpdates", newsAndUpdates);
				session.setAttribute("importantUpdates", importantUpdates);
				session.setAttribute("update1", update1);
				session.setAttribute("update2", update2);
				session.setAttribute("update3", update3);
				// body
				session.setAttribute("messageContent", messageContent);
				session.setAttribute("messageAbout", messageAbout);
				// footer
				session.setAttribute("homeFooter", homeFooter);
				session.setAttribute("aboutusFooter", aboutusFooter);
				session.setAttribute("contactusFooter", contactusFooter);
				session.setAttribute("helpFooter", helpFooter);
				session.setAttribute("copyrights", copyrights);
				session.setAttribute("designedBy", designedBy);
				session.setAttribute("lang", language);
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/HomeLogin.jsp");
				rd.forward(request, response);

			}

			else if (language.equals("unselected")) {
			response.sendRedirect(request.getContextPath()+"/jsp/HomeLogin.jsp");
			}
		}

		// reset password
		else if (RESETPWD.equalsIgnoreCase(action)) {
			logger.info("Entry into Reset Password");
			session = request.getSession();
			emp = (Employee) session.getAttribute("emp");
			String answer = request.getParameter("ans");

			if (emp.getAnswer().equalsIgnoreCase(answer)) {
				try {
					flag = empSer.resetPassword(emp);
				} catch (CommercialCustRegException e) {
					e.printStackTrace();
					request.setAttribute("errMsg", e.getMessage());
					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/CCRErrorPage.jsp");
					rd.forward(request, response);
				}
			}
			if (flag) {
				session.invalidate();
				logger.info("Password reset successful");
				response.sendRedirect(request.getContextPath()
						+ "/jsp/HomeLogin.jsp?msg=Password reset Successful");
			} else {
				session.invalidate();
				logger.info("Password reset failed");
				response.sendRedirect(request.getContextPath()
						+ "/jsp/HomeLogin.jsp?msg=Password reset failed");
			}
			logger.info("Exit from Reset Password");
			logger.info("Exit from Forgot Password");
		}

		// Change Password
		else if (action.equals("changePwd")) {
			logger.info("Entry into Change Password");
			String currPwd = null;
			session = request.getSession();
			empId = (Integer) session.getAttribute("UID");

			String password = (String) session.getAttribute("pwd");
			if (request.getParameter("currPwd") != null) {
				currPwd = request.getParameter("currPwd");
			}
			if (password.equals(currPwd)) {
				emp.setEmpId(empId);
				emp.setPassword(request.getParameter("newPwd"));
				emp.setSecurityQues(request.getParameter("securityQues"));
				emp.setAnswer(request.getParameter("answer"));
				try {
					flag = empSer.changePwd(emp);
				} catch (CommercialCustRegException e) {

					request.setAttribute("errMsg", e.getMessage());
					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/CCRErrorPage.jsp");
					rd.forward(request, response);
				}

				if (flag) {
					session.invalidate();
					logger.info("Password change Successful");
					response
							.sendRedirect(request.getContextPath()
									+ "/jsp/HomeLogin.jsp?msg=Password change Successful");
				} else {
					session.invalidate();
					logger
							.info("Password change failed due to wrong security answer");
					response.sendRedirect(request.getContextPath()
							+ "/jsp/HomeLogin.jsp?msg=Password change failed");
				}
			} else {
				session.invalidate();
				logger
						.info("Password change failed due to wrong current password");
				response.sendRedirect(request.getContextPath()
						+ "/jsp/HomeLogin.jsp?msg=Password change failed");
			}
			logger.info("Exit from Change Password");
		}
	}
}