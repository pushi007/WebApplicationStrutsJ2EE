package com.tvm.ilp.t154.cao.controllers;

import static com.tvm.ilp.t154.cao.constants.CAOConstants.ABOUTUS;
import static com.tvm.ilp.t154.cao.constants.CAOConstants.ACTION;
import static com.tvm.ilp.t154.cao.constants.CAOConstants.ACTIVATE;
import static com.tvm.ilp.t154.cao.constants.CAOConstants.CANCEL;
import static com.tvm.ilp.t154.cao.constants.CAOConstants.CANCELREG;
import static com.tvm.ilp.t154.cao.constants.CAOConstants.CANCELVIEW;
import static com.tvm.ilp.t154.cao.constants.CAOConstants.CONFIRM;
import static com.tvm.ilp.t154.cao.constants.CAOConstants.CONFIRMUPDATE;
import static com.tvm.ilp.t154.cao.constants.CAOConstants.DEACTIVATE;
import static com.tvm.ilp.t154.cao.constants.CAOConstants.DEACTIVATEEMP;
import static com.tvm.ilp.t154.cao.constants.CAOConstants.EMPREGISTER;
import static com.tvm.ilp.t154.cao.constants.CAOConstants.HELP;
import static com.tvm.ilp.t154.cao.constants.CAOConstants.HOME;
import static com.tvm.ilp.t154.cao.constants.CAOConstants.REGISTER;
import static com.tvm.ilp.t154.cao.constants.CAOConstants.UPDATE;
import static com.tvm.ilp.t154.cao.constants.CAOConstants.UPDATEMP;
import static com.tvm.ilp.t154.cao.constants.CAOConstants.UPDATEREG;
import static com.tvm.ilp.t154.cao.constants.CAOConstants.VIEW;
import static com.tvm.ilp.t154.cao.constants.CAOConstants.VIEWDETAILS;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.tvm.ilp.t154.cao.exceptions.CommercialCustRegException;
import com.tvm.ilp.t154.cao.model.Employee;
import com.tvm.ilp.t154.cao.model.NonPersonalAccount;
import com.tvm.ilp.t154.cao.model.NonPersonalCustomer;
import com.tvm.ilp.t154.cao.services.AccountServices;
import com.tvm.ilp.t154.cao.services.EmployeeManagementService;

/**
 * Servlet implementation class EmployeeManagementServlet
 */
public class EmployeeManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger
			.getLogger(EmployeeManagementServlet.class);

	private Employee emp = new Employee();
	private EmployeeManagementService empSer = new EmployeeManagementService();
	HttpSession session;
	private String msg;

	boolean flag = false;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeManagementServlet() {
		super();
		// TODO Auto-generated constructor stub
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
		String action = request.getParameter(ACTION);

		if (action.equals(null) || HOME.equals(action)) {

			// Session variables close
			request.getSession().removeAttribute("AccountType");
			request.getSession().removeAttribute("businessCust");
			request.getSession().removeAttribute("ProductList");
			request.getSession().removeAttribute("bc");
			request.getSession().removeAttribute("assignRM");
			request.getSession().removeAttribute("branch");
			request.getSession().removeAttribute("route");
			request.getSession().removeAttribute("managername");
			request.getSession().removeAttribute("pName");
			request.getSession().removeAttribute("npaList");

			if (request.getParameter("role") != null) {
				String role = request.getParameter("role");
				if (role.equals("Admin"))
					response.sendRedirect(request.getContextPath()
							+ "/jsp/EmployeePortal.jsp");

				else if (role.equals("Commercial Account Opener"))
					response.sendRedirect(request.getContextPath()
							+ "/jsp/RegistrationPortal.jsp");

				else if (role.equals("null"))
					response.sendRedirect(request.getContextPath()
							+ "/jsp/HomeLogin.jsp");

			}

		}
		// About Us
		else if (ABOUTUS.equals(action)) {

			session = request.getSession();
			String language = (String) session.getAttribute("lang");
			if ("English".equals(language) || language == null) {

				Locale locale = new Locale("en", "US");
				ResourceBundle rb = ResourceBundle.getBundle(
						"com.tvm.ilp.t154.cao.properties.MessagesBundle",
						locale);

				String keyAboutUsau = rb.getString("keyAboutUsau");
				String keyAboutUsP1au = rb.getString("keyAboutUsP1au");
				String keyAboutUsP2au = rb.getString("keyAboutUsP2au");

				session.setAttribute("keyAboutUsau", keyAboutUsau);
				session.setAttribute("keyAboutUsP1au", keyAboutUsP1au);
				session.setAttribute("keyAboutUsP2au", keyAboutUsP1au);

				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/AboutUs.jsp");
				rd.forward(request, response);

			}

			else if ("French".equals(language)) {
				Locale locale = new Locale("fr", "FR");
				ResourceBundle rb = ResourceBundle.getBundle(
						"com.tvm.ilp.t154.cao.properties.MessagesBundle",
						locale);
				String keyAboutUsau = rb.getString("keyAboutUsau");
				String keyAboutUsP1au = rb.getString("keyAboutUsP1au");
				String keyAboutUsP2au = rb.getString("keyAboutUsP2au");

				session.setAttribute("keyAboutUsau", keyAboutUsau);
				session.setAttribute("keyAboutUsP1au", keyAboutUsP1au);
				session.setAttribute("keyAboutUsP2au", keyAboutUsP1au);

				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/AboutUs.jsp");
				rd.forward(request, response);

			} else if ("Spanish".equals(language)) {
				Locale locale = new Locale("es", "ES");
				ResourceBundle rb = ResourceBundle.getBundle(
						"com.tvm.ilp.t154.cao.properties.MessagesBundle",
						locale);
				String keyAboutUsau = rb.getString("keyAboutUsau");
				String keyAboutUsP1au = rb.getString("keyAboutUsP1au");
				String keyAboutUsP2au = rb.getString("keyAboutUsP2au");

				session.setAttribute("keyAboutUsau", keyAboutUsau);
				session.setAttribute("keyAboutUsP1au", keyAboutUsP1au);
				session.setAttribute("keyAboutUsP2au", keyAboutUsP2au);

				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/AboutUs.jsp");
				rd.forward(request, response);

			} else if ("German".equals(language)) {
				Locale locale = new Locale("de", "DE");
				ResourceBundle rb = ResourceBundle.getBundle(
						"com.tvm.ilp.t154.cao.properties.MessagesBundle",
						locale);
				String keyAboutUsau = rb.getString("keyAboutUsau");
				String keyAboutUsP1au = rb.getString("keyAboutUsP1au");
				String keyAboutUsP2au = rb.getString("keyAboutUsP2au");

				session.setAttribute("keyAboutUsau", keyAboutUsau);
				session.setAttribute("keyAboutUsP1au", keyAboutUsP1au);
				session.setAttribute("keyAboutUsP2au", keyAboutUsP1au);

				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/AboutUs.jsp");
				rd.forward(request, response);

			}

		}

		// Contact Us
		else if (action.equals("contactUs")) {
			response.sendRedirect(request.getContextPath()
					+ "/jsp/contact-us.jsp");
		}

		// Help
		else if (HELP.equals(action)) {
			session = request.getSession();
			String language = (String) session.getAttribute("lang");
			if ("English".equals(language) || language == null) {

				Locale locale = new Locale("en", "US");
				ResourceBundle rb = ResourceBundle.getBundle(
						"com.tvm.ilp.t154.cao.properties.MessagesBundle",
						locale);

				String keyHelp = rb.getString("keyHelp");
				String keyTop5questions = rb.getString("keyTop5questions");
				String keyQuestion1 = rb.getString("keyQuestion1");
				String keyAnswer1 = rb.getString("keyAnswer1");
				String keyQuestion2 = rb.getString("keyQuestion2");
				String keyAnswer2 = rb.getString("keyAnswer2");
				String keyQuestion3 = rb.getString("keyQuestion3");
				String keyAnswer3 = rb.getString("keyAnswer3");
				String keyQuestion4 = rb.getString("keyQuestion4");
				String keyAnswer4 = rb.getString("keyAnswer4");
				String keyQuestion5 = rb.getString("keyQuestion5");
				String keyAnswer5 = rb.getString("keyAnswer5");
				String keyQuestion6 = rb.getString("keyQuestion6");
				String keyAnswer6 = rb.getString("keyAnswer6");
				String keyQuestion7 = rb.getString("keyQuestion7");
				String keyAnswer7 = rb.getString("keyAnswer7");
				String keyQuestion8 = rb.getString("keyQuestion8");
				String keyAnswer8 = rb.getString("keyAnswer8");
				String keybottomline = rb.getString("keybottomline");

				session.setAttribute("keyHelp", keyHelp);
				session.setAttribute("keyTop5questions", keyTop5questions);
				session.setAttribute("keyQuestion1", keyQuestion1);
				session.setAttribute("keyAnswer1", keyAnswer1);
				session.setAttribute("keyQuestion2", keyQuestion2);
				session.setAttribute("keyAnswer2", keyAnswer2);
				session.setAttribute("keyQuestion3", keyQuestion3);
				session.setAttribute("keyAnswer3", keyAnswer3);
				session.setAttribute("keyQuestion4", keyQuestion4);
				session.setAttribute("keyAnswer4", keyAnswer4);
				session.setAttribute("keyQuestion5", keyQuestion5);
				session.setAttribute("keyAnswer5", keyAnswer5);
				session.setAttribute("keyQuestion6", keyQuestion6);
				session.setAttribute("keyAnswer6", keyAnswer6);
				session.setAttribute("keyQuestion7", keyQuestion7);
				session.setAttribute("keyAnswer7", keyAnswer7);
				session.setAttribute("keyQuestion8", keyQuestion8);
				session.setAttribute("keyAnswer8", keyAnswer8);
				session.setAttribute("keybottomline", keybottomline);
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/Help.jsp");
				rd.forward(request, response);

			}

			else if ("French".equals(language)) {
				Locale locale = new Locale("fr", "FR");
				ResourceBundle rb = ResourceBundle.getBundle(
						"com.tvm.ilp.t154.cao.properties.MessagesBundle",
						locale);
				String keyHelp = rb.getString("keyHelp");
				String keyTop5questions = rb.getString("keyTop5questions");
				String keyQuestion1 = rb.getString("keyQuestion1");
				String keyAnswer1 = rb.getString("keyAnswer1");
				String keyQuestion2 = rb.getString("keyQuestion2");
				String keyAnswer2 = rb.getString("keyAnswer2");
				String keyQuestion3 = rb.getString("keyQuestion3");
				String keyAnswer3 = rb.getString("keyAnswer3");
				String keyQuestion4 = rb.getString("keyQuestion4");
				String keyAnswer4 = rb.getString("keyAnswer4");
				String keyQuestion5 = rb.getString("keyQuestion5");
				String keyAnswer5 = rb.getString("keyAnswer5");
				String keyQuestion6 = rb.getString("keyQuestion6");
				String keyAnswer6 = rb.getString("keyAnswer6");
				String keyQuestion7 = rb.getString("keyQuestion7");
				String keyAnswer7 = rb.getString("keyAnswer7");
				String keyQuestion8 = rb.getString("keyQuestion8");
				String keyAnswer8 = rb.getString("keyAnswer8");
				String keybottomline = rb.getString("keybottomline");

				session.setAttribute("keyHelp", keyHelp);
				session.setAttribute("keyTop5questions", keyTop5questions);
				session.setAttribute("keyQuestion1", keyQuestion1);
				session.setAttribute("keyAnswer1", keyAnswer1);
				session.setAttribute("keyQuestion2", keyQuestion2);
				session.setAttribute("keyAnswer2", keyAnswer2);
				session.setAttribute("keyQuestion3", keyQuestion3);
				session.setAttribute("keyAnswer3", keyAnswer3);
				session.setAttribute("keyQuestion4", keyQuestion4);
				session.setAttribute("keyAnswer4", keyAnswer4);
				session.setAttribute("keyQuestion5", keyQuestion5);
				session.setAttribute("keyAnswer5", keyAnswer5);
				session.setAttribute("keyQuestion6", keyQuestion6);
				session.setAttribute("keyAnswer6", keyAnswer6);
				session.setAttribute("keyQuestion7", keyQuestion7);
				session.setAttribute("keyAnswer7", keyAnswer7);
				session.setAttribute("keyQuestion8", keyQuestion8);
				session.setAttribute("keyAnswer8", keyAnswer8);
				session.setAttribute("keybottomline", keybottomline);

				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/Help.jsp");
				rd.forward(request, response);

			} else if ("Spanish".equals(language)) {
				Locale locale = new Locale("es", "ES");
				ResourceBundle rb = ResourceBundle.getBundle(
						"com.tvm.ilp.t154.cao.properties.MessagesBundle",
						locale);
				String keyHelp = rb.getString("keyHelp");
				String keyTop5questions = rb.getString("keyTop5questions");
				String keyQuestion1 = rb.getString("keyQuestion1");
				String keyAnswer1 = rb.getString("keyAnswer1");
				String keyQuestion2 = rb.getString("keyQuestion2");
				String keyAnswer2 = rb.getString("keyAnswer2");
				String keyQuestion3 = rb.getString("keyQuestion3");
				String keyAnswer3 = rb.getString("keyAnswer3");
				String keyQuestion4 = rb.getString("keyQuestion4");
				String keyAnswer4 = rb.getString("keyAnswer4");
				String keyQuestion5 = rb.getString("keyQuestion5");
				String keyAnswer5 = rb.getString("keyAnswer5");
				String keyQuestion6 = rb.getString("keyQuestion6");
				String keyAnswer6 = rb.getString("keyAnswer6");
				String keyQuestion7 = rb.getString("keyQuestion7");
				String keyAnswer7 = rb.getString("keyAnswer7");
				String keyQuestion8 = rb.getString("keyQuestion8");
				String keyAnswer8 = rb.getString("keyAnswer8");
				String keybottomline = rb.getString("keybottomline");

				session.setAttribute("keyHelp", keyHelp);
				session.setAttribute("keyTop5questions", keyTop5questions);
				session.setAttribute("keyQuestion1", keyQuestion1);
				session.setAttribute("keyAnswer1", keyAnswer1);
				session.setAttribute("keyQuestion2", keyQuestion2);
				session.setAttribute("keyAnswer2", keyAnswer2);
				session.setAttribute("keyQuestion3", keyQuestion3);
				session.setAttribute("keyAnswer3", keyAnswer3);
				session.setAttribute("keyQuestion4", keyQuestion4);
				session.setAttribute("keyAnswer4", keyAnswer4);
				session.setAttribute("keyQuestion5", keyQuestion5);
				session.setAttribute("keyAnswer5", keyAnswer5);
				session.setAttribute("keyQuestion6", keyQuestion6);
				session.setAttribute("keyAnswer6", keyAnswer6);
				session.setAttribute("keyQuestion7", keyQuestion7);
				session.setAttribute("keyAnswer7", keyAnswer7);
				session.setAttribute("keyQuestion8", keyQuestion8);
				session.setAttribute("keyAnswer8", keyAnswer8);
				session.setAttribute("keybottomline", keybottomline);

				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/Help.jsp");
				rd.forward(request, response);

			} else if ("German".equals(language)) {
				Locale locale = new Locale("de", "DE");
				ResourceBundle rb = ResourceBundle.getBundle(
						"com.tvm.ilp.t154.cao.properties.MessagesBundle",
						locale);
				String keyHelp = rb.getString("keyHelp");
				String keyTop5questions = rb.getString("keyTop5questions");
				String keyQuestion1 = rb.getString("keyQuestion1");
				String keyAnswer1 = rb.getString("keyAnswer1");
				String keyQuestion2 = rb.getString("keyQuestion2");
				String keyAnswer2 = rb.getString("keyAnswer2");
				String keyQuestion3 = rb.getString("keyQuestion3");
				String keyAnswer3 = rb.getString("keyAnswer3");
				String keyQuestion4 = rb.getString("keyQuestion4");
				String keyAnswer4 = rb.getString("keyAnswer4");
				String keyQuestion5 = rb.getString("keyQuestion5");
				String keyAnswer5 = rb.getString("keyAnswer5");
				String keyQuestion6 = rb.getString("keyQuestion6");
				String keyAnswer6 = rb.getString("keyAnswer6");
				String keyQuestion7 = rb.getString("keyQuestion7");
				String keyAnswer7 = rb.getString("keyAnswer7");
				String keyQuestion8 = rb.getString("keyQuestion8");
				String keyAnswer8 = rb.getString("keyAnswer8");
				String keybottomline = rb.getString("keybottomline");

				session.setAttribute("keyHelp", keyHelp);
				session.setAttribute("keyTop5questions", keyTop5questions);
				session.setAttribute("keyQuestion1", keyQuestion1);
				session.setAttribute("keyAnswer1", keyAnswer1);
				session.setAttribute("keyQuestion2", keyQuestion2);
				session.setAttribute("keyAnswer2", keyAnswer2);
				session.setAttribute("keyQuestion3", keyQuestion3);
				session.setAttribute("keyAnswer3", keyAnswer3);
				session.setAttribute("keyQuestion4", keyQuestion4);
				session.setAttribute("keyAnswer4", keyAnswer4);
				session.setAttribute("keyQuestion5", keyQuestion5);
				session.setAttribute("keyAnswer5", keyAnswer5);
				session.setAttribute("keyQuestion6", keyQuestion6);
				session.setAttribute("keyAnswer6", keyAnswer6);
				session.setAttribute("keyQuestion7", keyQuestion7);
				session.setAttribute("keyAnswer7", keyAnswer7);
				session.setAttribute("keyQuestion8", keyQuestion8);
				session.setAttribute("keyAnswer8", keyAnswer8);
				session.setAttribute("keybottomline", keybottomline);

				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/Help.jsp");
				rd.forward(request, response);
			}
		}

		// Register Employee page
		else if (REGISTER.equals(action)) {
			logger.info("Entry into Register Employee");
			List<String> desigList = new ArrayList<String>();
			List<String> branchList = new ArrayList<String>();
			try {
				desigList = empSer.getDesignation();
				branchList = empSer.getBranchNames();

				request.setAttribute("branchList", branchList);
				request.setAttribute("desigList", desigList);
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/RegisterEmployee.jsp");
				rd.forward(request, response);
			} catch (CommercialCustRegException e) {
				request.setAttribute("errMsg", e.getMessage());
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/CCRErrorPage.jsp");
				rd.forward(request, response);
			}

		} else if (action.equals("closeSession")) {
			response.sendRedirect(request.getContextPath()
					+ "/jsp/EmployeePortal.jsp");
		} else if (action.equals("closingSession")) {
			request.getSession().removeAttribute("emp");
			response.sendRedirect(request.getContextPath()
					+ "/jsp/EmployeePortal.jsp");
		}

		// Employee Registration
		else if (EMPREGISTER.equalsIgnoreCase(action)) {

			List<String> grpList = new ArrayList<String>();

			emp.setTitle(request.getParameter("title"));
			emp.setFirstNm(request.getParameter("firstnm"));
			emp.setMiddleNm(request.getParameter("middlenm"));
			emp.setLastNm(request.getParameter("lastnm"));
			emp.setDateOfBirth(request.getParameter("dob"));
			emp.setAddress(request.getParameter("address"));
			emp.setContactno(Long.parseLong(request.getParameter("contactno")));

			if (request.getParameter("altcontactno") != null
					&& request.getParameter("altcontactno").length() > 0) {
				emp.setAltContactNo(Long.parseLong(request
						.getParameter("altcontactno")));
			}
			emp.setEmailId(request.getParameter("email"));
			emp.setDateOfJoin(request.getParameter("doj"));
			emp.setDesignation(request.getParameter("designation"));
			emp.setStatus("working");
			emp.setBranchName(request.getParameter("branch_nm"));

			String[] groups = request.getParameterValues("groups");

			for (int i = 0; i < groups.length; i++) {
				grpList.add(groups[i]);
			}
			emp.setGroups(grpList);
			session = request.getSession();
			session.setAttribute("emp", emp);

			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/ViewSummary.jsp");
			rd.forward(request, response);

		}

		// View All Employee Details
		else if (VIEW.equalsIgnoreCase(action)) {
			logger.info("Entry into View Employees");
			List<Employee> empList = new ArrayList<Employee>();
			try {
				empList = empSer.viewEmployees();

				request.setAttribute("empList", empList);
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/ViewEmployees.jsp");
				rd.forward(request, response);
			} catch (CommercialCustRegException e) {

				request.setAttribute("errMsg", e.getMessage());
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/CCRErrorPage.jsp");
				rd.forward(request, response);
			}
			logger.info("Exit from View Employees");
		}

		// View Employee details
		else if (VIEWDETAILS.equals(action)) {
			logger.info("Entry into View Employee Details");
			if (request.getParameter("empId") != null) {
				int empId = Integer.parseInt(request.getParameter("empId"));

				try {
					emp = empSer.searchEmpDetails(empId);
				} catch (CommercialCustRegException e) {
					request.setAttribute("errMsg", e.getMessage());
					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/CCRErrorPage.jsp");
					rd.forward(request, response);
				}

				if (emp.getStatus().equalsIgnoreCase("suspended")) {
					msg = "suspended";
				} else if (emp.getStatus().equalsIgnoreCase("leave"))
					msg = "leave";
				else if (emp.getStatus().equalsIgnoreCase("working"))
					msg = "working";
				else
					msg = "other";

				request.setAttribute("status", msg);
				request.setAttribute("emp", emp);
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/ViewDetails.jsp");
				rd.forward(request, response);
			}
			logger.info("Exit from View Employee Details");
		}

		// Update Employee Page
		else if (UPDATE.equals(action)) {
			logger.info("Entry into Update Employee");
			List<String> desigList = new ArrayList<String>();

			List<String> branchList = new ArrayList<String>();
			try {
				desigList = empSer.getDesignation();
				branchList = empSer.getBranchNames();
			} catch (CommercialCustRegException e) {
				request.setAttribute("errMsg", e.getMessage());
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/CCRErrPage.jsp");
				rd.forward(request, response);
			}

			request.setAttribute("branchList", branchList);
			request.setAttribute("desigList", desigList);

			session = request.getSession();
			if (request.getParameter("empId") != null) {
				int empId = Integer.valueOf(request.getParameter("empId"));
				request.setAttribute("empId", empId);

				try {
					emp = empSer.searchEmpDetails(empId);
				} catch (CommercialCustRegException e) {
					request.setAttribute("errMsg", e.getMessage());
					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/CCRErrorPage.jsp");
					rd.forward(request, response);
				}
			}
			session = request.getSession();
			session.setAttribute("emp", emp);
			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/UpdateEmployee.jsp");
			rd.forward(request, response);
		}

		// Store Updated Employee details to database
		else if (UPDATEMP.equals(action)) {
			Employee emp1 = (Employee) session.getAttribute("emp");
			Employee emp = new Employee();
			List<String> grpList = new ArrayList<String>();

			emp.setEmpId(Integer.valueOf(request.getParameter("empId")));
			emp.setTitle(request.getParameter("title"));
			emp.setFirstNm(request.getParameter("firstnm"));
			emp.setMiddleNm(request.getParameter("middlenm"));
			emp.setLastNm(request.getParameter("lastnm"));
			emp.setDateOfBirth(request.getParameter("dob"));
			emp.setAddress(request.getParameter("address"));
			emp.setContactno(Long.parseLong(request.getParameter("contactno")));
			if (request.getParameter("altcontactno") != null
					&& request.getParameter("altcontactno").length() > 0) {
				emp.setAltContactNo(Long.parseLong(request
						.getParameter("altcontactno")));

			}

			emp.setEmailId(request.getParameter("email"));
			emp.setDateOfJoin(request.getParameter("doj"));
			emp.setDesignation(request.getParameter("designation"));
			emp.setStatus("working");
			emp.setBranchName(request.getParameter("branch_nm"));

			String[] groups = request.getParameterValues("groups");

			for (int i = 0; i < groups.length; i++) {
				grpList.add(groups[i]);
			}
			emp.setGroups(grpList);

			if ((emp.getTitle().equals(emp1.getTitle()))
					&& (emp.getFirstNm().equals(emp1.getFirstNm()))
					&& (emp.getLastNm().equals(emp1.getLastNm()))
					&& (emp.getMiddleNm().equals(emp1.getMiddleNm()))
					&& (emp.getAddress().equals(emp1.getAddress()))
					&& (emp.getDateOfBirth().equals(emp1.getDateOfBirth()))
					&& (emp.getContactno() == (emp1.getContactno()))
					&& (emp.getAltContactNo() == emp1.getAltContactNo())
					&& (emp.getEmailId().equals(emp1.getEmailId()))
					&& (emp.getDesignation().equals(emp1.getDesignation()))
					&& (emp.getStatus().equals(emp1.getStatus()))
					&& (emp.getGroups().equals(emp1.getGroups()))
					&& (emp.getBranchName().equals(emp1.getBranchName()))
					&& (emp.getDateOfJoin().equals(emp1.getDateOfJoin()))) {
				session = request.getSession();
				session.setAttribute("emp", emp);
				logger.info("No changes have been done.");
				msg = "No changes have been made to update.";
				System.out.println(msg);
				request.setAttribute("msg", msg);
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/ViewUpdateSummary.jsp");
				rd.forward(request, response);

			} else {

				session = request.getSession();
				session.setAttribute("emp", emp);

				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/ViewUpdateSummary.jsp");
				rd.forward(request, response);
				logger.info("Exit from Update Employee");

			}
		}

		// Update employee details before Registration
		else if (UPDATEREG.equals(action)) {
			logger.info("Entry into update new Employee");
			List<String> desigList = new ArrayList<String>();
			List<String> branchList = new ArrayList<String>();
			try {
				desigList = empSer.getDesignation();
				branchList = empSer.getBranchNames();

				request.setAttribute("branchList", branchList);
				request.setAttribute("desigList", desigList);
				session = request.getSession();
				emp = (Employee) session.getAttribute("emp");

				session.setAttribute("emp", emp);

				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/UpdateRegEmployee.jsp");
				rd.forward(request, response);

			} catch (CommercialCustRegException e) {
				request.setAttribute("errMsg", e.getMessage());
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/CCRErrorPage.jsp");
				rd.forward(request, response);
			}

		}

		// Confirm Summary Details
		else if (CONFIRM.equals(action)) {
			logger.info("Entry into Confirm Register employee");
			Employee emp = new Employee();
			emp = (Employee) session.getAttribute("emp");
			try {
				flag = empSer.registerEmployee(emp);

				if (flag) {
					logger.info("Employee Register Successfully");
					msg = "Employee added successfully";
					request.setAttribute("msg", msg);
					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/EmployeePortal.jsp");
					rd.forward(request, response);

				} else {
					logger.error("Employee Registrion failed");
					msg = "Employee registration Failed";
					request.setAttribute("msg", msg);
					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/EmployeePortal.jsp");
					rd.forward(request, response);
				}
			} catch (CommercialCustRegException e) {

				request.setAttribute("errMsg", e.getMessage());
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/CCRErrorPage.jsp");
				rd.forward(request, response);

			}

			logger.info("Exit from Confirm Register Employee");
			logger.info("Exit from Register Employee");
		}

		// Confirm Update Summary Details
		else if (CONFIRMUPDATE.equals(action)) {
			Employee emp = new Employee();
			emp = (Employee) session.getAttribute("emp");
			try {
				flag = empSer.updateEmployee(emp);

				if (flag) {
					logger.info("Employee Update Successful");
					msg = "Employee updated successfully";
					request.setAttribute("msg", msg);
					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/EmployeePortal.jsp");
					rd.forward(request, response);
				} else {
					logger.error("Employee Updation failed");
					msg = "Employee updation Failed";
					request.setAttribute("msg", msg);
					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/EmployeePortal.jsp");
					rd.forward(request, response);
				}
			} catch (CommercialCustRegException e) {
				request.setAttribute("errMsg", e.getMessage());
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/CCRErrorPage.jsp");
				rd.forward(request, response);
			}

			logger.info("Exit from update new Employee");
		}

		// Deactivate Employee
		else if (DEACTIVATE.equalsIgnoreCase(action)) {
			logger.info("Entry into Deactivate Employee");
			List<String> desigList = new ArrayList<String>();
			try {
				desigList = empSer.getDesignation();
				request.setAttribute("desigList", desigList);

				session = request.getSession();

				session.setAttribute("emp", emp);

				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/DeactivateEmployee.jsp");
				rd.forward(request, response);

			} catch (CommercialCustRegException e) {
				request.setAttribute("errMsg", e.getMessage());
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/CCRErrorPage.jsp");
				rd.forward(request, response);
			}

		}

		// Submit deactivation details of Employee
		else if (DEACTIVATEEMP.equalsIgnoreCase(action)) {
			Employee emp = new Employee();
			session = request.getSession();
			emp = (Employee) session.getAttribute("emp");

			// emp.setDateOfLeave(request.getParameter("dol"));
			emp.setReasonOfLeave(request.getParameter("reasonOfLeave"));
			emp.setStatus(request.getParameter("status"));
			session.setAttribute("emp", emp);
			try {
				flag = empSer.deactivateEmp(emp);

				if (flag == true) {
					logger.info("Employee Deactivate Successful");
					msg = "Employee deactivated successfully";
					request.setAttribute("msg", msg);
					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/EmployeePortal.jsp");
					rd.forward(request, response);
				} else {
					logger.error("Employee deactivation failed");
					msg = "Employee deactivation failed";
					request.setAttribute("msg", msg);
					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/EmployeePortal.jsp");
					rd.forward(request, response);
				}

			} catch (CommercialCustRegException e) {
				request.setAttribute("errMsg", e.getMessage());
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/CCRErrorPage.jsp");
				rd.forward(request, response);
			}

			logger.info("Exit from Deactivate Employee");
		}

		// Activate Employee
		if (ACTIVATE.equalsIgnoreCase(action)) {
			logger.info("Entry into Activate Employee");
			int empId = 0;
			if (request.getParameter("empId") != null
					&& request.getParameter("empId").length() > 0) {
				empId = Integer.valueOf(request.getParameter("empId"));

			}

			try {
				flag = empSer.activateEmp(empId);

				if (flag) {
					logger.info("Employee activate Successful");
					msg = "Employee Activated Successfully";
					request.setAttribute("msg", msg);
					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/EmployeePortal.jsp");
					rd.forward(request, response);
				} else {
					logger.error("Employee Activation failed");
					msg = "Employee Activation failed";
					request.setAttribute("msg", msg);
					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/EmployeePortal.jsp");
					rd.forward(request, response);
				}

			} catch (CommercialCustRegException e) {
				request.setAttribute("errMsg", e.getMessage());
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/CCRErrorPage.jsp");
				rd.forward(request, response);
			}

			logger.info("Exit from Activate Employee");
		}

		/*
		 * // Search Employee by name or by empId if
		 * (SEARCH.equalsIgnoreCase(action)) { String name; int empId = 0;
		 * List<Employee> empList = new ArrayList<Employee>();
		 * 
		 * if (request.getParameter("name") != null) { name =
		 * request.getParameter("name"); try { empList =
		 * empSer.searchByName(name); } catch (CommercialCustRegException e) {
		 * request.setAttribute("errMsg", e.getMessage()); RequestDispatcher rd
		 * = request .getRequestDispatcher("/jsp/CCRErrorPage.jsp");
		 * rd.forward(request, response); } } else if
		 * (!request.getParameter("empId").equals(null)) { empId =
		 * Integer.parseInt(request.getParameter("empId")); try { empList =
		 * empSer.searchById(empId); } catch (CommercialCustRegException e) {
		 * 
		 * request.setAttribute("errMsg", e.getMessage()); RequestDispatcher rd
		 * = request .getRequestDispatcher("/jsp/CCRErrorPage.jsp");
		 * rd.forward(request, response); } } request.setAttribute("empList",
		 * empList); RequestDispatcher rd = request
		 * .getRequestDispatcher("/jsp/ViewEmployees.jsp"); rd.forward(request,
		 * response); }
		 */

		// Change Password
		else if (action.equalsIgnoreCase("changePwd")) {
			response.sendRedirect(request.getContextPath()
					+ "/jsp/ChangePwd.jsp");
		} else if (CANCEL.equalsIgnoreCase(action)) {
			logger
					.info("Cancelled current operation and back to Employee summary page");
			response.sendRedirect(request.getContextPath()
					+ "/jsp/ViewSummary.jsp");
		} else if (CANCELVIEW.equalsIgnoreCase(action)) {
			logger
					.info("Cancelled current operation and back to View Employees");
			response
					.sendRedirect("/CommercialCustReg/EmployeeManagementServlet?action=view");
		} else if (CANCELREG.equalsIgnoreCase(action)) {
			logger.info("Cancelled Employee Registration");
			response.sendRedirect(request.getContextPath()
					+ "/jsp/EmployeePortal.jsp");
		} else if ("generatePieCAO".equalsIgnoreCase(action)) {

			int year1 = Calendar.getInstance().get(Calendar.YEAR);
			int month1 = Calendar.getInstance().get(Calendar.MONTH) + 1;
			int day1 = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
			String[] monht = { "January", "February", "March", "April", "May",
					"June", "July", "August", "September", "October",
					"November", "December" };
			String radio = request.getParameter("chart");

			AccountServices acServices = new AccountServices();

			List<NonPersonalCustomer> npList = acServices
					.getBusinessNameAndId();
			String name = null;

			PdfPTable table = new PdfPTable(4);

			if ("first".equalsIgnoreCase(radio)) {
				response.setContentType("application/pdf");
				response.setHeader("Content-Disposition",
						" attachment; filename=\"report.pdf\"");
				Document document = new Document();
				String npName = request.getParameter("bname");
				int npId = Integer.parseInt(npName);

				for (NonPersonalCustomer npCust : npList) {
					if (npCust.getBusinessId() == npId) {
						name = npCust.getBusinessName();
					}
				}

				NonPersonalCustomer npCustomer = acServices
						.generateReportByBName(npId);
				List<NonPersonalAccount> accountList = npCustomer
						.getAccountList();

				try {
					table.setWidthPercentage(95);
					table.setWidths(new int[] { 2, 1, 1, 1 });
					PdfPCell cell;
					cell = new PdfPCell(new Phrase("Total no of accounts"));
					cell.setColspan(3);
					table.addCell(cell);

					cell = new PdfPCell(new Phrase(""
							+ npCustomer.getAccountList().size()));
					// cell.setColspan(3);
					table.addCell(cell);

					// row2
					cell = new PdfPCell(new Phrase("Current accounts"));
					cell.setRowspan(3);
					table.addCell(cell);

					table.addCell("Active");// divide this into two rows and two
					// columns
					table
							.addCell(""
									+ acServices
											.noOfCurrentActiveAccount(accountList)
									+ " ("
									+ acServices
											.percentageOfCurrentActiveAccount(accountList)
									+ "%)");

					cell = new PdfPCell(new Phrase(""
							+ acServices.noOfCurrentAccount(accountList)
							+ " ("
							+ acServices
									.percentageOfCurrentAccount(accountList)
							+ "%)"));
					cell.setRowspan(3);// last row total percentage of current
					// account
					table.addCell(cell);

					table.addCell("Inprogress");// divide this into two rows and
					// two
					// columns
					table
							.addCell(""
									+ acServices
											.noOfCurrentInProgressAccount(accountList)
									+ " ("
									+ acServices
											.percentageOfCurrentInProgressAccount(accountList)
									+ "%)");

					table.addCell("Inactive");// divide this into two rows and
					// two
					// columns
					table
							.addCell(""
									+ acServices
											.noOfCurrentInactiveAccount(accountList)
									+ " ("
									+ acServices
											.percentageOfCurrentInactiveAccount(accountList)
									+ "%)");

					// row3
					cell = new PdfPCell(new Phrase("Savings accounts"));
					cell.setRowspan(3);
					table.addCell(cell);

					table.addCell("Active");// divide this into two rows and two
					// columns
					table
							.addCell(""
									+ acServices
											.noOfSavingsActiveAccount(accountList)
									+ " ("
									+ acServices
											.percentageOfSavingActiveAccount(accountList)
									+ "%)");

					cell = new PdfPCell(new Phrase(""
							+ acServices.noOfSavingAccount(accountList) + " ("
							+ acServices.percentageOfSavingAccount(accountList)
							+ "%)"));
					cell.setRowspan(3);// last row total percentage of current
					// account
					table.addCell(cell);

					table.addCell("Inprogress");// divide this into two rows and
					// two
					// columns
					table
							.addCell(""
									+ acServices
											.noOfSavingsInProgressAccount(accountList)
									+ " ("
									+ acServices
											.percentageOfSavingInProgressAccount(accountList)
									+ "%)");

					table.addCell("Inactive");// divide this into two rows and
					// two
					// columns
					table
							.addCell(""
									+ acServices
											.noOfSavingsInactiveAccount(accountList)
									+ " ("
									+ acServices
											.percentageOfSavingInactiveAccount(accountList)
									+ "%)");

					PdfWriter.getInstance(document, response.getOutputStream()); // Code
					// 2
					document.open();
					Font fontbold = FontFactory.getFont("Arial", 35, Font.BOLD);

					Paragraph paragraph = new Paragraph("Nexus Banking Group ",
							fontbold);

					paragraph.setAlignment(Element.ALIGN_CENTER);
					paragraph.setFont(fontbold);

					document.add(paragraph);
					document.add(new Paragraph(""));
					fontbold = FontFactory.getFont("Arial", 20, Font.NORMAL);
					paragraph = new Paragraph("\n\nGeneral Report", fontbold);

					paragraph.setAlignment(Element.ALIGN_CENTER);
					document.add(paragraph);
					paragraph = new Paragraph("On", fontbold);

					paragraph.setAlignment(Element.ALIGN_CENTER);
					document.add(paragraph);

					paragraph = new Paragraph(
							"Cumulative Status of all Current and Savings Account",
							fontbold);

					paragraph.setAlignment(Element.ALIGN_CENTER);
					document.add(paragraph);

					paragraph = new Paragraph("For", fontbold);

					paragraph.setAlignment(Element.ALIGN_CENTER);
					document.add(paragraph);
					paragraph = new Paragraph(name + "(" + npId + ")", fontbold);

					paragraph.setAlignment(Element.ALIGN_CENTER);
					document.add(paragraph);
					paragraph = new Paragraph("till"+" "+day1+" "+monht[month1-1]+" "+year1, fontbold);

					paragraph.setAlignment(Element.ALIGN_CENTER);
					document.add(paragraph);
					
					document.add(new Paragraph("\n\n"));

					fontbold = FontFactory.getFont("Arial", 18, Font.BOLD);
					paragraph = new Paragraph("\nReport Generated On : " + day1
							+ " " + monht[month1-1] + " " + year1);
					paragraph.setAlignment(Element.ALIGN_LEFT);

					document.add(table);
					document.add(paragraph);

					document.close();
				} catch (DocumentException e) {
					e.printStackTrace();
				}

				session = request.getSession();

				String type = (String) session.getAttribute("type");
				session.setAttribute("type", type);
				session.setAttribute("customer", npCustomer);
			} else if ("second".equalsIgnoreCase(radio)) {

				String month = request.getParameter("month");

				NonPersonalCustomer npCustomer = acServices
						.generateReportByBNameAndMonth(month);
				List<NonPersonalAccount> accountList = npCustomer
						.getAccountList();
				if (npCustomer.getAccountList().size() != 0) {
					response.setContentType("application/pdf");
					response.setHeader("Content-Disposition",
							" attachment; filename=\"report.pdf\"");
					Document document = new Document();
					try {
						table.setWidthPercentage(95);
						table.setWidths(new int[] { 2, 1, 1, 1 });
						PdfPCell cell;
						cell = new PdfPCell(new Phrase("Total no of accounts"));
						cell.setColspan(3);
						table.addCell(cell);

						cell = new PdfPCell(new Phrase(""
								+ npCustomer.getAccountList().size()));
						// cell.setColspan(3);
						table.addCell(cell);

						// row2
						cell = new PdfPCell(new Phrase("Current accounts"));
						cell.setRowspan(3);
						table.addCell(cell);

						table.addCell("Active");// divide this into two rows and
						// two
						// columns
						table
								.addCell(""
										+ acServices
												.noOfCurrentActiveAccount(accountList)
										+ " ("
										+ acServices
												.percentageOfCurrentActiveAccount(accountList)
										+ "%)");

						cell = new PdfPCell(
								new Phrase(
										""
												+ acServices
														.noOfCurrentAccount(accountList)
												+ " ("
												+ acServices
														.percentageOfCurrentAccount(accountList)
												+ "%)"));
						cell.setRowspan(3);// last row total percentage of
						// current
						// account
						table.addCell(cell);

						table.addCell("Inprogress");// divide this into two rows
						// and
						// two
						// columns
						table
								.addCell(""
										+ acServices
												.noOfCurrentInProgressAccount(accountList)
										+ " ("
										+ acServices
												.percentageOfCurrentInProgressAccount(accountList)
										+ "%)");

						table.addCell("Inactive");// divide this into two rows
						// and
						// two
						// columns
						table
								.addCell(""
										+ acServices
												.noOfCurrentInactiveAccount(accountList)
										+ " ("
										+ acServices
												.percentageOfCurrentInactiveAccount(accountList)
										+ "%)");

						// row3
						cell = new PdfPCell(new Phrase("Savings accounts"));
						cell.setRowspan(3);
						table.addCell(cell);

						table.addCell("Active");// divide this into two rows and
						// two
						// columns
						table
								.addCell(""
										+ acServices
												.noOfSavingsActiveAccount(accountList)
										+ " ("
										+ acServices
												.percentageOfSavingActiveAccount(accountList)
										+ "%)");

						cell = new PdfPCell(new Phrase(""
								+ acServices.noOfSavingAccount(accountList)
								+ " ("
								+ acServices
										.percentageOfSavingAccount(accountList)
								+ "%)"));
						cell.setRowspan(3);// last row total percentage of
						// current
						// account
						table.addCell(cell);

						table.addCell("Inprogress");// divide this into two rows
						// and
						// two
						// columns
						table
								.addCell(""
										+ acServices
												.noOfSavingsInProgressAccount(accountList)
										+ " ("
										+ acServices
												.percentageOfSavingInProgressAccount(accountList)
										+ "%)");

						table.addCell("Inactive");// divide this into two rows
						// and
						// two
						// columns
						table
								.addCell(""
										+ acServices
												.noOfSavingsInactiveAccount(accountList)
										+ " ("
										+ acServices
												.percentageOfSavingInactiveAccount(accountList)
										+ "%)");

						PdfWriter.getInstance(document, response
								.getOutputStream()); // Code
						// 2
						document.open();
						Font fontbold = FontFactory.getFont("Arial", 35,
								Font.BOLD);

						Paragraph paragraph = new Paragraph(
								"Nexus Banking Group ", fontbold);

						paragraph.setAlignment(Element.ALIGN_CENTER);
						paragraph.setFont(fontbold);

						document.add(paragraph);
						document.add(new Paragraph(""));
						fontbold = FontFactory
								.getFont("Arial", 20, Font.NORMAL);
						paragraph = new Paragraph("\n\nGeneral Report",
								fontbold);

						paragraph.setAlignment(Element.ALIGN_CENTER);
						document.add(paragraph);
						paragraph = new Paragraph("On", fontbold);

						paragraph.setAlignment(Element.ALIGN_CENTER);
						document.add(paragraph);

						paragraph = new Paragraph(
								"Cumulative Status of all Current and Savings Account",
								fontbold);

						paragraph.setAlignment(Element.ALIGN_CENTER);

						document.add(paragraph);

						paragraph = new Paragraph("for the year" + " " + month,
								fontbold);

						paragraph.setAlignment(Element.ALIGN_CENTER);

						document.add(paragraph);

						document.add(new Paragraph("\n\n"));

						fontbold = FontFactory.getFont("Arial", 18, Font.BOLD);
						paragraph = new Paragraph("\nReport Generated On : "
								+ day1 + " " + monht[month1-1] + " " + year1);
						paragraph.setAlignment(Element.ALIGN_LEFT);

						document.add(table);
						document.add(paragraph);

						document.close();
					} catch (DocumentException e) {
						e.printStackTrace();
					}

					session = request.getSession();

					String type = (String) session.getAttribute("type");
					session.setAttribute("type", type);
					session.setAttribute("customer", npCustomer);
				} else {
					session = request.getSession();

					String type = (String) session.getAttribute("type");
					session.setAttribute("type", type);
					session.setAttribute("customer", npCustomer);
					request.setAttribute("msg", "No record found");
					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/viewChartEmp.jsp");
					rd.forward(request, response);
				}

			} else if ("third".equalsIgnoreCase(radio)) {

				String month = request.getParameter("monthY");
				int mon = Integer.parseInt(month);
				String year = request.getParameter("year");

				NonPersonalCustomer npCustomer = acServices
						.generateReportByBNameAndYEar(month, year);
				List<NonPersonalAccount> accountList = npCustomer
						.getAccountList();

				if (npCustomer.getAccountList().size() != 0) {
					response.setContentType("application/pdf");
					response.setHeader("Content-Disposition",
							" attachment; filename=\"report.pdf\"");
					Document document = new Document();
					try {
						table.setWidthPercentage(95);
						table.setWidths(new int[] { 2, 1, 1, 1 });
						PdfPCell cell;
						cell = new PdfPCell(new Phrase("Total no of accounts"));
						cell.setColspan(3);
						table.addCell(cell);

						cell = new PdfPCell(new Phrase(""
								+ npCustomer.getAccountList().size()));
						// cell.setColspan(3);
						table.addCell(cell);

						// row2
						cell = new PdfPCell(new Phrase("Current accounts"));
						cell.setRowspan(3);
						table.addCell(cell);

						table.addCell("Active");// divide this into two rows and
						// two
						// columns
						table
								.addCell(""
										+ acServices
												.noOfCurrentActiveAccount(accountList)
										+ " ("
										+ acServices
												.percentageOfCurrentActiveAccount(accountList)
										+ "%)");

						cell = new PdfPCell(
								new Phrase(
										""
												+ acServices
														.noOfCurrentAccount(accountList)
												+ " ("
												+ acServices
														.percentageOfCurrentAccount(accountList)
												+ "%)"));
						cell.setRowspan(3);// last row total percentage of
						// current
						// account
						table.addCell(cell);

						table.addCell("Inprogress");// divide this into two rows
						// and
						// two
						// columns
						table
								.addCell(""
										+ acServices
												.noOfCurrentInProgressAccount(accountList)
										+ " ("
										+ acServices
												.percentageOfCurrentInProgressAccount(accountList)
										+ "%)");

						table.addCell("Inactive");// divide this into two rows
						// and
						// two
						// columns
						table
								.addCell(""
										+ acServices
												.noOfCurrentInactiveAccount(accountList)
										+ " ("
										+ acServices
												.percentageOfCurrentInactiveAccount(accountList)
										+ "%)");

						// row3
						cell = new PdfPCell(new Phrase("Savings accounts"));
						cell.setRowspan(3);
						table.addCell(cell);

						table.addCell("Active");// divide this into two rows and
						// two
						// columns
						table
								.addCell(""
										+ acServices
												.noOfSavingsActiveAccount(accountList)
										+ " ("
										+ acServices
												.percentageOfSavingActiveAccount(accountList)
										+ "%)");

						cell = new PdfPCell(new Phrase(""
								+ acServices.noOfSavingAccount(accountList)
								+ " ("
								+ acServices
										.percentageOfSavingAccount(accountList)
								+ "%)"));
						cell.setRowspan(3);// last row total percentage of
						// current
						// account
						table.addCell(cell);

						table.addCell("Inprogress");// divide this into two rows
						// and
						// two
						// columns
						table
								.addCell(""
										+ acServices
												.noOfSavingsInProgressAccount(accountList)
										+ " ("
										+ acServices
												.percentageOfSavingInProgressAccount(accountList)
										+ "%)");

						table.addCell("Inactive");// divide this into two rows
						// and
						// two
						// columns
						table
								.addCell(""
										+ acServices
												.noOfSavingsInactiveAccount(accountList)
										+ " ("
										+ acServices
												.percentageOfSavingInactiveAccount(accountList)
										+ "%)");

						PdfWriter.getInstance(document, response
								.getOutputStream()); // Code
						// 2
						document.open();
						Font fontbold = FontFactory.getFont("Arial", 35,
								Font.BOLD);

						Paragraph paragraph = new Paragraph(
								"Nexus Banking Group ", fontbold);

						paragraph.setAlignment(Element.ALIGN_CENTER);
						paragraph.setFont(fontbold);

						document.add(paragraph);
						document.add(new Paragraph(""));
						fontbold = FontFactory
								.getFont("Arial", 20, Font.NORMAL);
						paragraph = new Paragraph("\n\nGeneral Report",
								fontbold);

						paragraph.setAlignment(Element.ALIGN_CENTER);
						document.add(paragraph);
						paragraph = new Paragraph("On", fontbold);

						paragraph.setAlignment(Element.ALIGN_CENTER);
						document.add(paragraph);

						paragraph = new Paragraph(
								"Cumulative Status of all Current and Savings Account",
								fontbold);

						paragraph.setAlignment(Element.ALIGN_CENTER);

						document.add(paragraph);

						paragraph = new Paragraph("for" + " " + monht[mon - 1]
								+ " " + year, fontbold);

						paragraph.setAlignment(Element.ALIGN_CENTER);

						document.add(paragraph);

						document.add(new Paragraph("\n\n"));

						fontbold = FontFactory.getFont("Arial", 18, Font.BOLD);
						/*
						 * SimpleDateFormat sdf=new
						 * SimpleDateFormat("yyyy/mm/dd"); paragraph = new
						 * Paragraph("\nReport Generated On : " +sdf.format(new
						 * Date()));
						 */

						/*
						 * Calendar boundryDate = Calendar.getInstance();
						 * boundryDate.set(year1, month1, day1);
						 */
						paragraph.setAlignment(Element.ALIGN_LEFT);
						paragraph = new Paragraph("\nReport Generated On : "
								+ day1 + " " + monht[month1-1] + " " + year1);
						document.add(table);
						document.add(paragraph);

						document.close();
					} catch (DocumentException e) {
						e.printStackTrace();
					}

					session = request.getSession();
					String type = (String) session.getAttribute("type");
					session.setAttribute("type", type);
					session.setAttribute("customer", npCustomer);
				} else {
					session = request.getSession();
					String type = (String) session.getAttribute("type");
					session.setAttribute("type", type);
					session.setAttribute("customer", npCustomer);
					request.setAttribute("msg", "No record found");
					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/viewChartEmp.jsp");
					rd.forward(request, response);
				}
			}

		}

	}
}
