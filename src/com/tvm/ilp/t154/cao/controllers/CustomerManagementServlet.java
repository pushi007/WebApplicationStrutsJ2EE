package com.tvm.ilp.t154.cao.controllers;

import static com.tvm.ilp.t154.cao.constants.CAOConstants.*;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletOutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.tvm.ilp.t154.cao.exceptions.CommercialCustRegException;
import com.tvm.ilp.t154.cao.model.Branch;
import com.tvm.ilp.t154.cao.model.BusinessType;
import com.tvm.ilp.t154.cao.model.Country;
import com.tvm.ilp.t154.cao.model.Customers;
import com.tvm.ilp.t154.cao.model.NPAddress;
import com.tvm.ilp.t154.cao.model.NPContacts;
import com.tvm.ilp.t154.cao.model.NPProofOfDocument;
import com.tvm.ilp.t154.cao.model.NonPersonalCustomer;
import com.tvm.ilp.t154.cao.services.CustomerManagementService;

/**
 * Servlet implementation class CustomerManagementServlet
 */
public class CustomerManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger
			.getLogger(EmployeeManagementServlet.class);

	HttpSession session;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerManagementServlet() {
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
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		CustomerManagementService customerServcice = new CustomerManagementService();

		String action = request.getParameter(ACTION);

		// go to search page
		if (FIND.equalsIgnoreCase(action)) {

			logger.info("Directing to Search Business Customer page");

			List<Branch> branch = new ArrayList<Branch>();

			try {
				branch = customerServcice.getBranch();
			} catch (CommercialCustRegException e) {

				e.printStackTrace();
			}

			session = request.getSession();
			String language = (String) session.getAttribute("lang");
			if ("English".equals(language) || language == null) {
				request.getSession().setAttribute("branchList", branch);

				Locale locale = new Locale("en", "US");
				ResourceBundle rb = ResourceBundle.getBundle(
						"com.tvm.ilp.t154.cao.properties.MessagesBundle",
						locale);

				String keymyportal = rb.getString("keymyportal");
				String keysearchbusinesscustomer = rb
						.getString("keysearchbusinesscustomer");
				String keyfields = rb.getString("keyfields");
				String keymandatory = rb.getString("keymandatory");
				String keysearchby = rb.getString("keysearchby");
				String keybusinessname = rb.getString("keybusinessname");
				String keytradingname = rb.getString("keytradingname");
				String keybranch = rb.getString("keybranch");
				String keyaccountno = rb.getString("keyaccountno");
				String keysearch = rb.getString("keysearch");

				session.setAttribute("keymyportal", keymyportal);
				session.setAttribute("keysearchbusinesscustomer",
						keysearchbusinesscustomer);
				session.setAttribute("keyfields", keyfields);
				session.setAttribute("keymandatory", keymandatory);
				session.setAttribute("keysearchby", keysearchby);
				session.setAttribute("keybusinessname", keybusinessname);
				session.setAttribute("keytradingname", keytradingname);
				session.setAttribute("keybranch", keybranch);
				session.setAttribute("keyaccountno", keyaccountno);
				session.setAttribute("keysearch", keysearch);

				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/searchBusinessCustomer.jsp");
				rd.forward(request, response);

			}

			else if ("French".equals(language)) {
				request.getSession().setAttribute("branchList", branch);

				Locale locale = new Locale("fr", "FR");
				ResourceBundle rb = ResourceBundle.getBundle(
						"com.tvm.ilp.t154.cao.properties.MessagesBundle",
						locale);
				String keymyportal = rb.getString("keymyportal");
				String keysearchbusinesscustomer = rb
						.getString("keysearchbusinesscustomer");
				String keyfields = rb.getString("keyfields");
				String keymandatory = rb.getString("keymandatory");
				String keysearchby = rb.getString("keysearchby");
				String keybusinessname = rb.getString("keybusinessname");
				String keytradingname = rb.getString("keytradingname");
				String keybranch = rb.getString("keybranch");
				String keyaccountno = rb.getString("keyaccountno");
				String keysearch = rb.getString("keysearch");

				session.setAttribute("keymyportal", keymyportal);
				session.setAttribute("keysearchbusinesscustomer",
						keysearchbusinesscustomer);
				session.setAttribute("keyfields", keyfields);
				session.setAttribute("keymandatory", keymandatory);
				session.setAttribute("keysearchby", keysearchby);
				session.setAttribute("keybusinessname", keybusinessname);
				session.setAttribute("keytradingname", keytradingname);
				session.setAttribute("keybranch", keybranch);
				session.setAttribute("keyaccountno", keyaccountno);
				session.setAttribute("keysearch", keysearch);

				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/searchBusinessCustomer.jsp");
				rd.forward(request, response);

			} else if ("Spanish".equals(language)) {
				request.getSession().setAttribute("branchList", branch);

				Locale locale = new Locale("es", "ES");
				ResourceBundle rb = ResourceBundle.getBundle(
						"com.tvm.ilp.t154.cao.properties.MessagesBundle",
						locale);
				String keymyportal = rb.getString("keymyportal");
				String keysearchbusinesscustomer = rb
						.getString("keysearchbusinesscustomer");
				String keyfields = rb.getString("keyfields");
				String keymandatory = rb.getString("keymandatory");
				String keysearchby = rb.getString("keysearchby");
				String keybusinessname = rb.getString("keybusinessname");
				String keytradingname = rb.getString("keytradingname");
				String keybranch = rb.getString("keybranch");
				String keyaccountno = rb.getString("keyaccountno");
				String keysearch = rb.getString("keysearch");

				session.setAttribute("keymyportal", keymyportal);
				session.setAttribute("keysearchbusinesscustomer",
						keysearchbusinesscustomer);
				session.setAttribute("keyfields", keyfields);
				session.setAttribute("keymandatory", keymandatory);
				session.setAttribute("keysearchby", keysearchby);
				session.setAttribute("keybusinessname", keybusinessname);
				session.setAttribute("keytradingname", keytradingname);
				session.setAttribute("keybranch", keybranch);
				session.setAttribute("keyaccountno", keyaccountno);
				session.setAttribute("keysearch", keysearch);

				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/searchBusinessCustomer.jsp");
				rd.forward(request, response);

			} else if ("German".equals(language)) {
				request.getSession().setAttribute("branchList", branch);

				Locale locale = new Locale("de", "DE");
				ResourceBundle rb = ResourceBundle.getBundle(
						"com.tvm.ilp.t154.cao.properties.MessagesBundle",
						locale);
				String keymyportal = rb.getString("keymyportal");
				String keysearchbusinesscustomer = rb
						.getString("keysearchbusinesscustomer");
				String keyfields = rb.getString("keyfields");
				String keymandatory = rb.getString("keymandatory");
				String keysearchby = rb.getString("keysearchby");
				String keybusinessname = rb.getString("keybusinessname");
				String keytradingname = rb.getString("keytradingname");
				String keybranch = rb.getString("keybranch");
				String keyaccountno = rb.getString("keyaccountno");
				String keysearch = rb.getString("keysearch");

				session.setAttribute("keymyportal", keymyportal);
				session.setAttribute("keysearchbusinesscustomer",
						keysearchbusinesscustomer);
				session.setAttribute("keyfields", keyfields);
				session.setAttribute("keymandatory", keymandatory);
				session.setAttribute("keysearchby", keysearchby);
				session.setAttribute("keybusinessname", keybusinessname);
				session.setAttribute("keytradingname", keytradingname);
				session.setAttribute("keybranch", keybranch);
				session.setAttribute("keyaccountno", keyaccountno);
				session.setAttribute("keysearch", keysearch);

				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/searchBusinessCustomer.jsp");
				rd.forward(request, response);

			}

		}

		else if (ACCOUNTOPENERPORTAL.equalsIgnoreCase(action)) {

			response.sendRedirect(request.getContextPath()
					+ "/jsp/RegistrationPortal.jsp");
		}
		// Go to registration form
		else if (REGISTER.equalsIgnoreCase(action)) {
			logger.info("Entry into Register Business Customer");
			logger.info("Registration:Capturing Core Business details");
			List<Branch> branch = new ArrayList<Branch>();
			List<BusinessType> businessTypeList = new ArrayList<BusinessType>();
			List<Country> countryList = new ArrayList<Country>();

			try {
				countryList = customerServcice.getCountry();
				branch = customerServcice.getBranch();
				businessTypeList = customerServcice.getBusinessType();
			} catch (CommercialCustRegException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			session = request.getSession();

			session.setAttribute("branchList", branch);
			session.setAttribute("businessList", businessTypeList);
			session.setAttribute("countryList", countryList);
			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/registerCoreDetails.jsp");
			rd.forward(request, response);
		}
		// Go to additional details
		else if (ADD.equalsIgnoreCase(action)) {
			NonPersonalCustomer customer = new NonPersonalCustomer();

			List<Branch> branchList = (List<Branch>) session
					.getAttribute("branchList");
			// retrieving values from the form
			String bname = request.getParameter("bname");
			String trdname = request.getParameter("trdname");
			String btype = request.getParameter("btype");
			String bbname = request.getParameter("bbname");

			String startup = request.getParameter("startup");
			String dateOfEstablishment = request.getParameter("doe");
			String dateOfRegistration = request.getParameter("dor");

			// date not received as of now...

			String creg = request.getParameter("creg");
			String turnOver = request.getParameter("turnover");
			String totalCapital = request.getParameter("capital");
			double turnover = 0;
			double capital = 0;
			if (turnOver != "") {
				turnover = Double.parseDouble(turnOver);
			}
			if (totalCapital != "") {
				capital = Double.parseDouble(totalCapital);
			}

			String bstatus = request.getParameter("bstatus");
			String emp = request.getParameter("noemp");

			int noemp = 0;
			if (emp != "" && emp != null) {
				noemp = Integer.parseInt(emp);
			}
			String bdet = request.getParameter("bdet");
			String countryOfRegistration = request.getParameter("country");

			// setting the values in the customer object

			customer.setBusinessName(bname);
			customer.setTradingName(trdname);
			customer.setBusinessType(btype);
			customer.getBranch().setBranchName(bbname);
			for (Branch branch : branchList) {
				if (branch.getBranchName().equalsIgnoreCase(bbname)) {
					customer.getBranch().setBranchId(branch.getBranchId());
					customer.getBranch().setBranchAddress(
							branch.getBranchAddress());
				}
			}

			customer.setIsStartUpBusiness(startup);
			customer.setCountryOfRegistration(creg);

			customer.setExpectedAnnualTurnover(turnover);
			customer.setTotalBusinessCapital(capital);
			customer.setBusinessStatus(bstatus);
			customer.setNoOfEmployees(noemp);
			if (bdet != "" && bdet == null) {
				customer.setTellMoreAboutYourBusiness(bdet);
			} else {
				customer.setTellMoreAboutYourBusiness(" ");
			}
			customer.setCountryOfRegistration(countryOfRegistration);
			if (dateOfEstablishment != "" && dateOfEstablishment != null) {
				customer.setDateEstablished(dateOfEstablishment);
			} else {
				customer.setDateEstablished("");
			}
			if (dateOfRegistration != "" && dateOfRegistration != null) {
				customer.setDateOfRegistration(dateOfRegistration);
			} else {
				customer.setDateOfRegistration("");
			}
			session = request.getSession();
			session.setAttribute("npCustomer", customer);
			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/registerAdditionalDetails.jsp");
			rd.forward(request, response);

		}
		// Go to Permanent address
		else if (REGADD.equalsIgnoreCase(action)) {

			logger.info("Registration:Capturing Additional details");
			NonPersonalCustomer customer = (NonPersonalCustomer) session
					.getAttribute("npCustomer");
			List<Country> countryList = (List<Country>) session
					.getAttribute("countryList");
			String industrySector = request.getParameter("industrySector");
			String mainActivity = request.getParameter("mainActivity");
			String preciseActivity = request.getParameter("preciseActivity");
			String importExport = request.getParameter("importExport");
			String requireFunding = request.getParameter("requireFunding");
			String fndAmount = request.getParameter("fundAmount");
			double fundAmount = 0;
			if (fndAmount != null && fndAmount != "") {
				fundAmount = Double.parseDouble(fndAmount);
			}
			String partOfGroup = request.getParameter("partOfGroup");
			String franchiseDetails = request.getParameter("franchiseDetails");

			customer.setIndustrySector(industrySector);
			customer.setMainActivity(mainActivity);
			customer.setPreciseActivity(preciseActivity);
			customer.setImportExport(importExport);
			customer.setRequireFunding(requireFunding);
			customer.setFundAmount(fundAmount);
			customer.setPartOfGroup(partOfGroup);
			if (franchiseDetails != "" && franchiseDetails != null) {
				customer.setFranchiseDetails(franchiseDetails);
			} else {
				customer.setFranchiseDetails(" ");
			}
			session = request.getSession();
			session.setAttribute("npCustomer", customer);
			session.setAttribute("countryList", countryList);
			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/registerAddressDetails.jsp");
			rd.forward(request, response);

		}
		// Go to Present address
		else if (REGADDRPER.equalsIgnoreCase(action)) {

			logger.info("Registration:Capturing Business Address");

			NonPersonalCustomer customer = (NonPersonalCustomer) session
					.getAttribute("npCustomer");
			List<Country> countryList = (List<Country>) session
					.getAttribute("countryList");
			NPAddress npAdress = new NPAddress();

			String sameAddressPresent = request.getParameter("simcheckpresent");
			String sameAddressCorr = request.getParameter("simcheckcorr");

			String buildingNoPermanent = request.getParameter("bnoper");
			String buildingNamePermanent = request.getParameter("bnameper");
			String streetNamePermanent = request.getParameter("snameper");
			String townPermanent = request.getParameter("townper");
			String cityPermanent = request.getParameter("cityper");
			String countryPermanent = request.getParameter("countryper");
			String postalCodePermanent = null;
			String postalCode = request.getParameter("pcodeper");
			if (postalCode != null) {
				postalCodePermanent = postalCode;
			}

			npAdress.setBuildingName(buildingNamePermanent);
			npAdress.setBuildingNo(buildingNoPermanent);
			npAdress.setStreetName(streetNamePermanent);
			if (townPermanent != "" && townPermanent != null) {
				npAdress.setTown(townPermanent);
			} else {
				npAdress.setTown(" ");
			}
			npAdress.setCity(cityPermanent);
			npAdress.setCountry(countryPermanent);
			npAdress.setPostalCode(postalCodePermanent);
			npAdress.setAddressType("Business");
			customer.getNpAddressList().add(npAdress);

			session = request.getSession();

			if (sameAddressPresent.equalsIgnoreCase("no")
					&& sameAddressCorr.equalsIgnoreCase("yes")) {

				NPAddress npAdressCorr = new NPAddress();
				npAdressCorr.setBuildingName(buildingNamePermanent);
				npAdressCorr.setBuildingNo(buildingNoPermanent);
				npAdressCorr.setStreetName(streetNamePermanent);
				if (townPermanent != "" && townPermanent != null) {
					npAdressCorr.setTown(townPermanent);
				} else {
					npAdressCorr.setTown(" ");
				}
				npAdressCorr.setCity(cityPermanent);
				npAdressCorr.setCountry(countryPermanent);
				npAdressCorr.setPostalCode(postalCodePermanent);
				npAdressCorr.setAddressType("Correspondence");
				customer.getNpAddressList().add(npAdress);

				session.setAttribute("sameAddressCorr", sameAddressCorr);
				session.setAttribute("npCustomer", customer);
				session.setAttribute("countryList", countryList);
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/RegisterAddressDetailsA.jsp");
				rd.forward(request, response);
			} else if (sameAddressPresent.equalsIgnoreCase("no")
					&& sameAddressCorr.equalsIgnoreCase("no")) {
				session.setAttribute("sameAddressCorr", sameAddressCorr);
				session.setAttribute("npCustomer", customer);
				session.setAttribute("countryList", countryList);
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/RegisterAddressDetailsA.jsp");
				rd.forward(request, response);
			}

			else if (sameAddressCorr.equalsIgnoreCase("yes")
					&& sameAddressPresent.equalsIgnoreCase("yes")) {

				NPAddress npAdressCorr = new NPAddress();
				NPAddress npAdressPre = new NPAddress();
				npAdressCorr.setBuildingName(buildingNamePermanent);
				npAdressCorr.setBuildingNo(buildingNoPermanent);
				npAdressCorr.setStreetName(streetNamePermanent);
				if (townPermanent != "" && townPermanent != null) {
					npAdressCorr.setTown(townPermanent);
				} else {
					npAdressCorr.setTown(" ");
				}
				npAdressCorr.setCity(cityPermanent);
				npAdressCorr.setCountry(countryPermanent);
				npAdressCorr.setPostalCode(postalCodePermanent);
				npAdressCorr.setAddressType("Correspondence");
				customer.getNpAddressList().add(npAdressCorr);
				npAdressPre.setBuildingName(buildingNamePermanent);
				npAdressPre.setBuildingNo(buildingNoPermanent);
				npAdressPre.setStreetName(streetNamePermanent);
				npAdressPre.setTown(townPermanent);
				npAdressPre.setCity(cityPermanent);
				npAdressPre.setCountry(countryPermanent);
				npAdressPre.setPostalCode(postalCodePermanent);
				npAdressPre.setAddressType("Registered");
				customer.getNpAddressList().add(npAdressPre);

				session.setAttribute("npCustomer", customer);
				session.setAttribute("countryList", countryList);

				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/RegisterContactDetails.jsp");
				rd.forward(request, response);
			}

			else if (sameAddressPresent.equalsIgnoreCase("yes")
					&& sameAddressCorr.equalsIgnoreCase("no")) {
				NPAddress npAddressPre = new NPAddress();
				npAddressPre.setBuildingName(buildingNamePermanent);
				npAddressPre.setBuildingNo(buildingNoPermanent);
				npAddressPre.setStreetName(streetNamePermanent);
				if (townPermanent != "" && townPermanent != null) {
					npAddressPre.setTown(townPermanent);
				} else {
					npAddressPre.setTown(" ");
				}
				npAddressPre.setCity(cityPermanent);
				npAddressPre.setCountry(countryPermanent);
				npAddressPre.setPostalCode(postalCodePermanent);
				npAddressPre.setAddressType("Registered");
				customer.getNpAddressList().add(npAdress);

				session.setAttribute("npCustomer", customer);
				session.setAttribute("countryList", countryList);
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/RegisterAddressDetailsB.jsp");
				rd.forward(request, response);
			}

		}
		// Go to Correspondence address
		else if (REGADDRPRE.equalsIgnoreCase(action)) {
			logger.info("Registration:Capturing Registered Address");

			NonPersonalCustomer customer = (NonPersonalCustomer) session
					.getAttribute("npCustomer");
			List<Country> countryList = (List<Country>) session
					.getAttribute("countryList");
			String sameAddressCorrPre = (String) session
					.getAttribute("sameAddressCorr");
			NPAddress npAdress = new NPAddress();
			String buildingNoPresent = request.getParameter("bnopre");
			String buildingNamePresent = request.getParameter("bnamepre");
			String streetNamePresent = request.getParameter("snamepre");
			String townPresent = request.getParameter("townpre");
			String cityPresent = request.getParameter("citypre");
			String countryPresent = request.getParameter("countrypre");
			String sameAddressCorr = request.getParameter("simcheckcorr");
			String postalCode = request.getParameter("pcodepre");
			String postalCodePresent = null;
			if (postalCode != null) {
				postalCodePresent = postalCode;
			}
			npAdress.setBuildingNo(buildingNoPresent);
			npAdress.setBuildingName(buildingNamePresent);
			npAdress.setStreetName(streetNamePresent);
			if (townPresent != "" && townPresent != null) {
				npAdress.setTown(townPresent);
			} else {
				npAdress.setTown(" ");
			}
			npAdress.setCountry(countryPresent);
			npAdress.setCity(cityPresent);
			npAdress.setPostalCode(postalCodePresent);
			npAdress.setAddressType("Registered");
			customer.getNpAddressList().add(npAdress);
			session = request.getSession();
			if (sameAddressCorrPre.equalsIgnoreCase("yes")) {
				session.setAttribute("npCustomer", customer);
				session.setAttribute("countryList", countryList);
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/RegisterContactDetails.jsp");
				rd.forward(request, response);
			} else {

				if (sameAddressCorr.equalsIgnoreCase("no")) {

					session.setAttribute("npCustomer", customer);
					session.setAttribute("countryList", countryList);
					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/RegisterAddressDetailsB.jsp");
					rd.forward(request, response);
				} else {
					NPAddress npAdressCorr = new NPAddress();

					npAdressCorr.setBuildingNo(buildingNoPresent);
					npAdressCorr.setBuildingName(buildingNamePresent);
					npAdressCorr.setStreetName(streetNamePresent);
					if (townPresent != "" && townPresent != null) {
						npAdressCorr.setTown(townPresent);
					} else {
						npAdressCorr.setTown(" ");
					}
					npAdressCorr.setCountry(countryPresent);
					npAdressCorr.setCity(cityPresent);
					npAdressCorr.setPostalCode(postalCodePresent);
					npAdressCorr.setAddressType("Correspondence");
					customer.getNpAddressList().add(npAdress);
					session.setAttribute("npCustomer", customer);
					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/RegisterContactDetails.jsp");
					rd.forward(request, response);
				}
			}

		}
		// Go to contact details
		else if (REGADDRCORR.equalsIgnoreCase(action)) {

			logger.info("Registration:Capturing Correspondence Address");

			NonPersonalCustomer customer = (NonPersonalCustomer) session
					.getAttribute("npCustomer");
			NPAddress npAdress = new NPAddress();
			String buildingNoCorres = request.getParameter("bnocor");
			String buildingNameCorres = request.getParameter("bnamecor");
			String streetNameCorres = request.getParameter("snamecor");
			String townCorres = request.getParameter("towncor");
			String cityCorres = request.getParameter("citycor");
			String countryCorres = request.getParameter("countrycor");
			String postalCode = request.getParameter("pcodecor");
			String postalCodeCorres = null;
			if (postalCode != null) {
				postalCodeCorres = postalCode;
			}
			npAdress.setBuildingNo(buildingNoCorres);
			npAdress.setBuildingName(buildingNameCorres);
			npAdress.setStreetName(streetNameCorres);
			if (townCorres != "" && townCorres != null) {
				npAdress.setTown(townCorres);
			} else {
				npAdress.setTown(" ");
			}
			npAdress.setCity(cityCorres);
			npAdress.setCountry(countryCorres);
			npAdress.setPostalCode(postalCodeCorres);
			npAdress.setAddressType("Correspondence");
			customer.getNpAddressList().add(npAdress);
			session = request.getSession();
			session.setAttribute("npCustomer", customer);
			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/RegisterContactDetails.jsp");
			rd.forward(request, response);

		}
		// Go to summary page
		else if (REGCONTDETAIL.equalsIgnoreCase(action)) {

			logger
					.info("Registration:Capturing Contact details and proof documents");

			NonPersonalCustomer customer = (NonPersonalCustomer) session
					.getAttribute("npCustomer");
			NPContacts npContacts = new NPContacts();

			NPContacts npContactsFax = new NPContacts();

			NPProofOfDocument npProofOfDocuments = new NPProofOfDocument();
			NPProofOfDocument npProofOfDocumentsAddress = new NPProofOfDocument();

			String workContactAreaCode = request.getParameter("conareacode");
			String workContactCountryCode = request
					.getParameter("concountrycode");
			String workContactNo = request.getParameter("conno");
			String email = request.getParameter("bemail");
			customer.setEmail(email);
			npContacts.setAreaCode(workContactAreaCode);
			npContacts.setCountryCode(workContactCountryCode);
			npContacts.setContactNo(workContactNo);
			npContacts.setContactType("Work");
			customer.getNpContactList().add(npContacts);
			String faxAreaCode = request.getParameter("faxareacode");
			String faxCountryCode = request.getParameter("faxcountrycode");
			String faxContactNo = request.getParameter("faxno");

			npContactsFax.setAreaCode(faxAreaCode);
			npContactsFax.setCountryCode(faxCountryCode);
			npContactsFax.setContactNo(faxContactNo);
			npContactsFax.setContactType("Fax");
			customer.getNpContactList().add(npContactsFax);

			session = request.getSession();
			session.setAttribute("npCustomer", customer);

			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/ProofofDocuments.jsp");
			rd.forward(request, response);

		}
		// Add details to database
		else if (CONFIRM.equalsIgnoreCase(action)) {

			NonPersonalCustomer customer = new NonPersonalCustomer();
			Customers customers = new Customers();
			customers = (Customers) request.getSession().getAttribute(
					"npCustomerDetails");
			customer = (NonPersonalCustomer) session.getAttribute("npCustomer");
			boolean flag = false;
			boolean flag1 = false;
			System.out.println("5555555" + customers.getImage());

			try {
				flag = customerServcice.addCustomer(customer);
				flag1 = customerServcice.uploaddocuments(customers, customer);
			} catch (CommercialCustRegException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			logger.info("Business Customer registration successful");

			String message;
			String successMessage = "Business Customer registered successfully.";
			String failureMessage = "Business Customer registration failed.";

			if (flag == true && flag1 == true)
				message = successMessage;
			else
				message = failureMessage;
			session = request.getSession();

			session.setAttribute("message", message);
			session.setAttribute("npCustomer", customer);

			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/RegistrationSuccess.jsp");
			rd.forward(request, response);

		} else if (REGSUCCESS.equalsIgnoreCase(action)) {
			NonPersonalCustomer npCustomer = (NonPersonalCustomer) session
					.getAttribute("npCustomer");

			session = request.getSession();
			session.setAttribute("npCustomer", npCustomer);
			session.setAttribute("Bid", npCustomer.getBusinessId());
			session.setAttribute("Bname", npCustomer.getBusinessName());
			session.setAttribute("Bbranch", npCustomer.getBranch()
					.getBranchName());
			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/NonPersonalRegistraionSummary.jsp");
			rd.forward(request, response);

		}
		// Display search page
		else if (SEARCH.equalsIgnoreCase(action)) {

			logger.info("Entry into Search Business Customer page");

			String searchBy = request.getParameter("searchBy");
			Customers customers = new Customers();

			if ("businessname".equalsIgnoreCase(searchBy)) {
				String businessName = request.getParameter("businessName");
				String branch = request.getParameter("branch");
				List<NonPersonalCustomer> npList = null;

				try {
					npList = customerServcice.searchCustomerByBusinessName(
							businessName, branch);
				} catch (CommercialCustRegException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if (npList.isEmpty()) {

					String message = "No match found. Please re-enter search fields or create a new Business.";

					request.setAttribute("message", message);
					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/searchBusinessCustomer.jsp");
					rd.forward(request, response);
				} else {
					NonPersonalCustomer npcustomer = null;
					if (npList.size() == 1) {
						try {
							npcustomer = customerServcice
									.searchCustomerById((int) npList.get(0)
											.getBusinessId());
							customers = customerServcice
									.searchCustomerByNpId((int) npList.get(0)
											.getBusinessId());
						} catch (CommercialCustRegException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						session = request.getSession();
						session.setAttribute("npCustomer", npcustomer);
						session.setAttribute("Bid", npcustomer.getBusinessId());
						session.setAttribute("Bname", npcustomer
								.getBusinessName());
						session.setAttribute("Bbranch", npcustomer.getBranch()
								.getBranchName());
						session.setAttribute("CustomerId", customers);
						RequestDispatcher rd = request
								.getRequestDispatcher("/jsp/NonPersonalRegistraionSummary.jsp");
						rd.forward(request, response);

					} else {

						request.setAttribute("npList", npList);

						RequestDispatcher rd = request
								.getRequestDispatcher("/jsp/ViewNonPersonalCustomer.jsp");
						rd.forward(request, response);

					}
				}
			} else if ("tradingname".equalsIgnoreCase(searchBy)) {
				String tradeName = request.getParameter("tradeName");
				String branch = request.getParameter("branch");
				List<NonPersonalCustomer> npList = new ArrayList<NonPersonalCustomer>();
				try {
					npList = customerServcice.searchCustomerByTradeName(
							tradeName, branch);
				} catch (CommercialCustRegException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (npList.isEmpty()) {

					String message = "No match found. Please re-enter search fields or create a new Business.";
					request.setAttribute("message", message);
					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/searchBusinessCustomer.jsp");
					rd.forward(request, response);

				} else {
					NonPersonalCustomer npcustomer = null;
					if (npList.size() == 1) {
						try {
							npcustomer = customerServcice
									.searchCustomerById((int) npList.get(0)
											.getBusinessId());
							customers = customerServcice
									.searchCustomerByNpId((int) npList.get(0)
											.getBusinessId());
						} catch (CommercialCustRegException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						session = request.getSession();
						session.setAttribute("npCustomer", npcustomer);
						// session.setAttribute("npCustomer", npcustomer);
						session.setAttribute("CustomerId", customers);
						session.setAttribute("Bid", npcustomer.getBusinessId());
						session.setAttribute("Bname", npcustomer
								.getBusinessName());
						session.setAttribute("Bbranch", npcustomer.getBranch()
								.getBranchName());
						RequestDispatcher rd = request
								.getRequestDispatcher("/jsp/NonPersonalRegistraionSummary.jsp");
						rd.forward(request, response);

					} else {

						request.setAttribute("npList", npList);

						RequestDispatcher rd = request
								.getRequestDispatcher("/jsp/ViewNonPersonalCustomer.jsp");
						rd.forward(request, response);

					}
				}

			} else if ("accountNumber".equalsIgnoreCase(searchBy)) {
				String account = request.getParameter("accountNo");
				if (account.length() != 14) {

				}
				long accountNo = Long.parseLong(request
						.getParameter("accountNo"));
				NonPersonalCustomer npCustomer = null;
				try {
					npCustomer = customerServcice.searchByAccountNo(accountNo);
					
				

				if (npCustomer != null ) {
					customers = customerServcice
					.searchCustomerByNpId((int) npCustomer
							.getBusinessId());

					session = request.getSession();
					session.setAttribute("npCustomer", npCustomer);
					session.setAttribute("CustomerId", customers);
					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/NonPersonalRegistraionSummary.jsp");
					rd.forward(request, response);

				} else {

					String message = "No match found. Please re-enter search fields or create a new Business.";
					request.setAttribute("message", message);
					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/searchBusinessCustomer.jsp");
					rd.forward(request, response);
				}
				} catch (CommercialCustRegException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				logger.info("Business Customer search complete");
			}

		}
		// View all registered Business customers
		else if (VIEW.equalsIgnoreCase(action)) {

			logger
					.info("Display all Businesses that satisfy the search criteria.");

			session = request.getSession();
			List<NonPersonalCustomer> npList = new ArrayList<NonPersonalCustomer>();
			List<Branch> branch = new ArrayList<Branch>();
			try {
				branch = customerServcice.getBranch();
				npList = customerServcice.viewCustomer();
			} catch (CommercialCustRegException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			session.setAttribute("branchList", branch);
			request.setAttribute("npList", npList);
			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/ViewNonPersonalCustomer.jsp");
			rd.forward(request, response);
		}

		/*
		 * else if (CREATE.equalsIgnoreCase(action)) {
		 * 
		 * String message = "Customer not found"; request.setAttribute("msg",
		 * message); RequestDispatcher rd = request
		 * .getRequestDispatcher("/jsp/searchBusinessCustomer.jsp");
		 * rd.forward(request, response); }
		 */

		// View details of a particular registered Business Customer
		else if (VIEWDETAIL.equalsIgnoreCase(action)) {

			logger.info("Display complete summary of selected Business");

			int id = Integer.parseInt(request.getParameter("id"));

			NonPersonalCustomer npCustomer = new NonPersonalCustomer();
			Customers customers = new Customers();

			try {
				npCustomer = customerServcice.searchCustomerById(id);
				customers = customerServcice.searchCustomerByNpId(id);
			} catch (CommercialCustRegException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			session = request.getSession();
			session.setAttribute("npCustomer", npCustomer);
			session.setAttribute("CustomerId", customers);

			request.getSession()
					.setAttribute("Bid", npCustomer.getBusinessId());
			request.getSession().setAttribute("Bname",
					npCustomer.getBusinessName());
			request.getSession().setAttribute("Bbranch",
					npCustomer.getBranch().getBranchName());

			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/NonPersonalRegistraionSummary.jsp");
			rd.forward(request, response);

		}
		// Update Business customer details
		else if (UPDATECOREDETAILS.equalsIgnoreCase(action)) {

			logger.info("Update Business Customer Profile:core details");

			List<Branch> branch = new ArrayList<Branch>();
			List<BusinessType> businessTypeList = new ArrayList<BusinessType>();
			List<Country> countryList = new ArrayList<Country>();
			try {
				countryList = customerServcice.getCountry();
				businessTypeList = customerServcice.getBusinessType();
				branch = customerServcice.getBranch();
			} catch (CommercialCustRegException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			session = request.getSession();
			session.setAttribute("branchList", branch);
			session.setAttribute("businessList", businessTypeList);
			session.setAttribute("countryList", countryList);
			NonPersonalCustomer npCustomer = (NonPersonalCustomer) session
					.getAttribute("npCustomer");
			session = request.getSession();
			session.setAttribute("npCustomer", npCustomer);
			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/UpdateNPCustomer.jsp");
			rd.forward(request, response);

		} else if (UPDATEADDITIONALDETAILS.equalsIgnoreCase(action)) {

			logger.info("Update Business Customer Profile:additional details");

			NonPersonalCustomer npCustomer = (NonPersonalCustomer) session
					.getAttribute("npCustomer");
			session = request.getSession();
			session.setAttribute("npCustomer", npCustomer);
			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/UpdateAdditionalDetails.jsp");
			rd.forward(request, response);
		} else if (UPDATEADDPERMANENT.equalsIgnoreCase(action)) {

			logger.info("Update Business Customer Profile: business address");
			List<Country> countryList = new ArrayList<Country>();
			try {
				countryList = customerServcice.getCountry();

			} catch (CommercialCustRegException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			NonPersonalCustomer npCustomer = (NonPersonalCustomer) session
					.getAttribute("npCustomer");

			session = request.getSession();
			session.setAttribute("npCustomer", npCustomer);
			session.setAttribute("countryList", countryList);
			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/UpdatePermanentAddress.jsp");
			rd.forward(request, response);
		} else if (UPDATEADDPRESENT.equalsIgnoreCase(action)) {

			logger.info("Update Business Customer Profile: additional address");

			logger.info("Update Business Customer Profile:core details");

			NonPersonalCustomer npCustomer = (NonPersonalCustomer) session
					.getAttribute("npCustomer");
			List<Country> countryList = new ArrayList<Country>();
			try {
				countryList = customerServcice.getCountry();

			} catch (CommercialCustRegException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session = request.getSession();
			session.setAttribute("npCustomer", npCustomer);
			session.setAttribute("countryList", countryList);
			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/UpdatePresentAddress.jsp");
			rd.forward(request, response);
		} else if (UPDATEADDCORR.equalsIgnoreCase(action)) {

			logger
					.info("Update Business Customer Profile: correspondence address");

			NonPersonalCustomer npCustomer = (NonPersonalCustomer) session
					.getAttribute("npCustomer");
			List<Country> countryList = new ArrayList<Country>();
			try {
				countryList = customerServcice.getCountry();

			} catch (CommercialCustRegException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session = request.getSession();
			session.setAttribute("npCustomer", npCustomer);
			session.setAttribute("countryList", countryList);
			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/UpdateCorrespondenceAddress.jsp");
			rd.forward(request, response);
		} else if (UPDATECONWORK.equalsIgnoreCase(action)) {

			logger.info("Update Business Customer Profile: contact details");

			NonPersonalCustomer npCustomer = (NonPersonalCustomer) session
					.getAttribute("npCustomer");
			session = request.getSession();
			session.setAttribute("npCustomer", npCustomer);
			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/UpdateContactDetails.jsp");
			rd.forward(request, response);

		} else if (UPDATECOREDATADETAILS.equalsIgnoreCase(action)) {

			NonPersonalCustomer npUpCustomer = (NonPersonalCustomer) session
					.getAttribute("npCustomer");

			List<Branch> branchList = (List<Branch>) session
					.getAttribute("branchList");
			String bname = request.getParameter("bname");
			String trdname = request.getParameter("trdname");
			String btype = request.getParameter("btype");
			String bbname = request.getParameter("bbname");

			String startup = request.getParameter("startup");
			String dateOfEstablishment = request.getParameter("doe");
			String dateOfRegistration = request.getParameter("dor");

			// date not received as of now...

			String creg = request.getParameter("country");

			double turnover = Double.parseDouble(request
					.getParameter("turnover"));
			double capital = Double
					.parseDouble(request.getParameter("capital"));
			String bstatus = request.getParameter("bstatus");
			String noemp = request.getParameter("noemp");

			String bdet = request.getParameter("bdet");
			// String countryOfRegistration = request.getParameter("country");

			// setting the values in the customer object

			npUpCustomer.setBusinessName(bname);
			npUpCustomer.setTradingName(trdname);
			npUpCustomer.setBusinessType(btype);
			npUpCustomer.getBranch().setBranchName(bbname);
			for (Branch branch : branchList) {
				if (branch.getBranchName().equals(bbname)) {
					npUpCustomer.getBranch().setBranchId(branch.getBranchId());
					npUpCustomer.getBranch().setBranchAddress(
							branch.getBranchAddress());
				}
			}
			npUpCustomer.setIsStartUpBusiness(startup);
			npUpCustomer.setCountryOfRegistration(creg);

			npUpCustomer.setExpectedAnnualTurnover(turnover);
			npUpCustomer.setTotalBusinessCapital(capital);
			npUpCustomer.setBusinessStatus(bstatus);
			int noEmp = 0;
			if (noemp != "" && noemp != null) {

				npUpCustomer.setNoOfEmployees(Integer.parseInt(noemp));
			} else {
				npUpCustomer.setNoOfEmployees(noEmp);
			}
			if (bdet != "" && bdet != null) {
				npUpCustomer.setTellMoreAboutYourBusiness(bdet);
			} else {
				npUpCustomer.setTellMoreAboutYourBusiness(" ");
			}
			// npUpCustomer.setCountryOfRegistration(countryOfRegistration);
			if (dateOfEstablishment != null) {
				npUpCustomer.setDateEstablished(dateOfEstablishment);
			} else {
				npUpCustomer.setDateEstablished("");

			}
			if (dateOfRegistration != null) {
				npUpCustomer.setDateOfRegistration(dateOfRegistration);
			} else {
				npUpCustomer.setDateOfRegistration("");
			}
			session = request.getSession();

			session.setAttribute("npCustomer", npUpCustomer);
			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/NonPersonalRegistraionSummary.jsp");
			rd.forward(request, response);

			logger.info("Core Business details updated. ");

		} else if (UPDATEADDITIONALDATADETAILS.equalsIgnoreCase(action)) {

			NonPersonalCustomer npUpCustomer = (NonPersonalCustomer) session
					.getAttribute("npCustomer");
			String industrySector = request.getParameter("industrySector");
			String mainActivity = request.getParameter("mainActivity");
			String preciseActivity = request.getParameter("preciseActivity");
			String importExport = request.getParameter("importExport");
			String requireFunding = request.getParameter("requireFunding");
			String fndAmount = request.getParameter("fundAmount");

			String partOfGroup = request.getParameter("partOfGroup");
			String franchiseDetails = request.getParameter("franchiseDetails");

			npUpCustomer.setIndustrySector(industrySector);
			npUpCustomer.setMainActivity(mainActivity);
			npUpCustomer.setPreciseActivity(preciseActivity);
			npUpCustomer.setImportExport(importExport);
			npUpCustomer.setRequireFunding(requireFunding);
			if (fndAmount != "" && fndAmount != null) {
				npUpCustomer.setFundAmount(Double.parseDouble(fndAmount));
			} else {
				npUpCustomer.setFundAmount(0);
			}
			npUpCustomer.setPartOfGroup(partOfGroup);
			if (franchiseDetails != "" && franchiseDetails != null) {
				npUpCustomer.setFranchiseDetails(franchiseDetails);
			} else {
				npUpCustomer.setFranchiseDetails(" ");
			}
			session = request.getSession();
			session.setAttribute("npCustomer", npUpCustomer);
			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/NonPersonalRegistraionSummary.jsp");
			rd.forward(request, response);

			logger.info("Additional details updated.");

		} else if (UPDATEADDDATAPERMANENT.equalsIgnoreCase(action)) {

			NonPersonalCustomer npUpCustomer = (NonPersonalCustomer) session
					.getAttribute("npCustomer");

			String buildingNoPermanent = request.getParameter("bnoper");
			String buildingNamePermanent = request.getParameter("bnameper");
			String streetNamePermanent = request.getParameter("snameper");
			String townPermanent = request.getParameter("townper");
			String cityPermanent = request.getParameter("cityper");
			String countryPermanent = request.getParameter("countryper");

			// String sameAddressPresent =
			// request.getParameter("simcheckpresent");
			String sameAddressCorr = request.getParameter("simcheckcorr");

			String postalCodePermanent = request.getParameter("pcodeper");
			if (sameAddressCorr.equalsIgnoreCase("yes")) {

				for (NPAddress npAdress : npUpCustomer.getNpAddressList()) {
					if (npAdress.getAddressType().equalsIgnoreCase(
							"correspondence")) {

						npAdress.setBuildingName(buildingNamePermanent);
						npAdress.setBuildingNo(buildingNoPermanent);
						npAdress.setStreetName(streetNamePermanent);
						npAdress.setTown(townPermanent);
						npAdress.setCity(cityPermanent);
						npAdress.setCountry(countryPermanent);
						npAdress.setPostalCode(postalCodePermanent);
						npAdress.setAddressType("Correspondence");
					}
				}

				/*
				 * for (NPAddress npAdress : npUpCustomer.getNpAddressList()) {
				 * if (npAdress.getAddressType().equalsIgnoreCase("present")) {
				 * 
				 * npAdress.setBuildingName(buildingNamePermanent);
				 * npAdress.setBuildingNo(buildingNoPermanent);
				 * npAdress.setStreetName(streetNamePermanent);
				 * npAdress.setTown(townPermanent);
				 * npAdress.setCity(cityPermanent);
				 * npAdress.setCountry(countryPermanent);
				 * npAdress.setPostalCode(postalCodePermanent);
				 * npAdress.setAddressType("Present");
				 * 
				 * } }
				 */

			}

			// yes no
			if (sameAddressCorr.equalsIgnoreCase("no")) {

				/*
				 * for (NPAddress npAdress : npUpCustomer.getNpAddressList()) {
				 * if (npAdress.getAddressType().equalsIgnoreCase("present")) {
				 * 
				 * npAdress.setBuildingName(buildingNamePermanent);
				 * npAdress.setBuildingNo(buildingNoPermanent);
				 * npAdress.setStreetName(streetNamePermanent);
				 * npAdress.setTown(townPermanent);
				 * npAdress.setCity(cityPermanent);
				 * npAdress.setCountry(countryPermanent);
				 * npAdress.setPostalCode(postalCodePermanent);
				 * npAdress.setAddressType("Present");
				 * 
				 * } }
				 */
			}

			// no yes

			/*
			 * if (sameAddressPresent.equalsIgnoreCase("no") &&
			 * sameAddressCorr.equalsIgnoreCase("yes")) {
			 * 
			 * for (NPAddress npAdress : npUpCustomer.getNpAddressList()) { if
			 * (npAdress.getAddressType().equalsIgnoreCase( "correspondence")) {
			 * 
			 * npAdress.setBuildingName(buildingNamePermanent);
			 * npAdress.setBuildingNo(buildingNoPermanent);
			 * npAdress.setStreetName(streetNamePermanent);
			 * npAdress.setTown(townPermanent); npAdress.setCity(cityPermanent);
			 * npAdress.setCountry(countryPermanent);
			 * npAdress.setPostalCode(postalCodePermanent);
			 * npAdress.setAddressType("Correspondence");
			 * 
			 * } }
			 * 
			 * }
			 */

			for (NPAddress npAdress : npUpCustomer.getNpAddressList()) {
				if (npAdress.getAddressType().equalsIgnoreCase("business")) {

					npAdress.setBuildingName(buildingNamePermanent);
					npAdress.setBuildingNo(buildingNoPermanent);
					npAdress.setStreetName(streetNamePermanent);
					npAdress.setTown(townPermanent);
					npAdress.setCity(cityPermanent);
					npAdress.setCountry(countryPermanent);
					npAdress.setPostalCode(postalCodePermanent);
					npAdress.setAddressType("Business");

				}
			}
			session = request.getSession();
			session.setAttribute("npCustomer", npUpCustomer);

			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/NonPersonalRegistraionSummary.jsp");
			rd.forward(request, response);

			logger.info("Business address updated. ");

		} else if (UPDATEADDDATAPRESENT.equalsIgnoreCase(action)) {

			NonPersonalCustomer npUpCustomer = (NonPersonalCustomer) session
					.getAttribute("npCustomer");

			String sameAddressCorr = request.getParameter("simcheckcorr");

			String buildingNoPresent = request.getParameter("bnopre");
			String buildingNamePresent = request.getParameter("bnamepre");
			String streetNamePresent = request.getParameter("snamepre");
			String townPresent = request.getParameter("townpre");
			String cityPresent = request.getParameter("citypre");
			String countryPresent = request.getParameter("countrypre");
			String postalCodePresent = request.getParameter("pcodepre");

			if (sameAddressCorr.equalsIgnoreCase("yes")) {

				for (NPAddress npAdress : npUpCustomer.getNpAddressList()) {
					if (npAdress.getAddressType().equalsIgnoreCase(
							"correspondence")) {
						npAdress.setBuildingNo(buildingNoPresent);
						npAdress.setBuildingName(buildingNamePresent);
						npAdress.setStreetName(streetNamePresent);
						npAdress.setTown(townPresent);
						npAdress.setCountry(countryPresent);
						npAdress.setCity(cityPresent);
						npAdress.setPostalCode(postalCodePresent);
						npAdress.setAddressType("Correspondence");

					}
				}

			}

			for (NPAddress npAdress : npUpCustomer.getNpAddressList()) {
				if (npAdress.getAddressType().equalsIgnoreCase("present")) {
					npAdress.setBuildingNo(buildingNoPresent);
					npAdress.setBuildingName(buildingNamePresent);
					npAdress.setStreetName(streetNamePresent);
					npAdress.setTown(townPresent);
					npAdress.setCountry(countryPresent);
					npAdress.setCity(cityPresent);
					npAdress.setPostalCode(postalCodePresent);
					npAdress.setAddressType("Present");

				}
			}
			session = request.getSession();
			session.setAttribute("npCustomer", npUpCustomer);

			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/NonPersonalRegistraionSummary.jsp");
			rd.forward(request, response);

			logger.info("Registered address updated. ");

		} else if (UPDATEADDDATACORR.equalsIgnoreCase(action)) {
			NonPersonalCustomer npUpCustomer = (NonPersonalCustomer) session
					.getAttribute("npCustomer");

			String buildingNoCorres = request.getParameter("bnocor");
			String buildingNameCorres = request.getParameter("bnamecor");
			String streetNameCorres = request.getParameter("snamecor");
			String townCorres = request.getParameter("towncor");
			String cityCorres = request.getParameter("citycor");
			String countryCorres = request.getParameter("countrycor");
			String postalCodeCorres = request.getParameter("pcodecor");

			for (NPAddress npAdress : npUpCustomer.getNpAddressList()) {
				if (npAdress.getAddressType()
						.equalsIgnoreCase("correspondence")) {

					npAdress.setBuildingNo(buildingNoCorres);
					npAdress.setBuildingName(buildingNameCorres);
					npAdress.setStreetName(streetNameCorres);
					npAdress.setTown(townCorres);
					npAdress.setCity(cityCorres);
					npAdress.setCountry(countryCorres);
					npAdress.setPostalCode(postalCodeCorres);
					npAdress.setAddressType("Correspondence");

				}
			}

			session = request.getSession();
			session.setAttribute("npCustomer", npUpCustomer);

			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/NonPersonalRegistraionSummary.jsp");
			rd.forward(request, response);

			logger.info("Correspondence address updated. ");

		} else if (UPDATECONDATAWORK.equalsIgnoreCase(action)) {

			NonPersonalCustomer npUpCustomer = (NonPersonalCustomer) session
					.getAttribute("npCustomer");

			String workContactAreaCode = request.getParameter("conareacode");
			String workContactCountryCode = request
					.getParameter("concountrycode");
			String workContactNo = request.getParameter("conno");
			String email = request.getParameter("bemail");

			String faxAreaCode = request.getParameter("faxareacode");
			String faxCountryCode = request.getParameter("faxcountrycode");
			String faxContactNo = request.getParameter("faxno");

			// String proofOfIdPath = request.getParameter("idUpload");
			// File idProofFile = new File(proofOfIdPath);

			// String proofOfAddressPath =
			// request.getParameter("addressUpload");
			// File addressProofFile = new File(proofOfAddressPath);

			for (NPContacts npContacts : npUpCustomer.getNpContactList()) {
				if (npContacts.getContactType().equalsIgnoreCase("work")) {

					npUpCustomer.setEmail(email);
					npContacts.setAreaCode(workContactAreaCode);
					npContacts.setCountryCode(workContactCountryCode);
					npContacts.setContactNo(workContactNo);
					npContacts.setContactType("Work");
				}
			}
			for (NPContacts npContacts : npUpCustomer.getNpContactList()) {
				if (npContacts.getContactType().equalsIgnoreCase("fax")) {

					npContacts.setAreaCode(faxAreaCode);
					npContacts.setCountryCode(faxCountryCode);
					npContacts.setContactNo(faxContactNo);
					npContacts.setContactType("Fax");

				}
			}

			for (NPProofOfDocument npProofOfDocuments : npUpCustomer
					.getNpProofOfDocuments()) {
				if (npProofOfDocuments.getDocumentType().equalsIgnoreCase(
						"id proof")) {

					// npProofOfDocuments.setDocument(idProofFile);
					npProofOfDocuments.setDocumentType("ID Proof");
					npProofOfDocuments.setSubmittedDate("12/02/2012");
				}

			}

			for (NPProofOfDocument npProofOfDocuments : npUpCustomer
					.getNpProofOfDocuments()) {
				if (npProofOfDocuments.getDocumentType().equalsIgnoreCase(
						"address proof")) {
					// npProofOfDocuments.setDocument(addressProofFile);
					npProofOfDocuments.setDocumentType("Address Proof");
					npProofOfDocuments.setSubmittedDate("12/02/2012");

				}

			}
			session = request.getSession();
			session.setAttribute("npCustomer", npUpCustomer);

			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/NonPersonalRegistraionSummary.jsp");
			rd.forward(request, response);

			logger.info("Conatct details updated.");

		}

		// Changes reflected in database
		else if (UPDATE.equalsIgnoreCase(action)) {
			NonPersonalCustomer npUpCustomer = (NonPersonalCustomer) session
					.getAttribute("npCustomer");

			boolean flag = false;
			try {
				flag = customerServcice.updateNPCustomer(npUpCustomer);
			} catch (CommercialCustRegException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (flag) {
				String message = "Details updated successfuly";
				session = request.getSession();
				session.setAttribute("message", message);
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/RegistrationSuccess.jsp");
				rd.forward(request, response);

				logger.info("Updation process completed.");
			}

		}

		// Delete details of a Registered Business Customer
		else if (DELETE.equalsIgnoreCase(action)) {

			long npCustomerId = Long.parseLong(request.getParameter("id"));

			boolean flag = false;
			try {
				flag = customerServcice.deleteNPCustomer(npCustomerId);
			} catch (CommercialCustRegException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (flag) {
				String message = "Customer Profile deleted successfully.";
				session = request.getSession();
				request.setAttribute("msg", message);

				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/searchBusinessCustomer.jsp");
				rd.forward(request, response);

				logger
						.info("Business Customer's Profile deleted successfully.");

			} else {
				String message = "Customer Profile deletion failed.";
				session = request.getSession();
				request.setAttribute("msg", message);

				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/searchBusinessCustomer.jsp");
				rd.forward(request, response);

				logger.info("Business Customer Profile deletion failed. ");
			}

		} else if (VIEWIDPROOFIMAGE.equalsIgnoreCase(action)) {

			Customers cust = new Customers();
			String id = request.getParameter("id");
			long customerId = Long.parseLong(id);

			try {
				cust = customerServcice.proofofdocuments(customerId);
				ServletOutputStream sos = response.getOutputStream();
				response.setContentType("image/jpeg");
				response.setContentLength(cust.getImage().getImage().length);
				response
						.setHeader("Content-Disposition",
								"attachment; filename=" + cust.getCustomerID()
										+ ".jpg");
				sos.write(cust.getImage().getImage());
				sos.flush();
				sos.close();
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/viewImage.jsp");
				rd.forward(request, response);
			} catch (CommercialCustRegException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (VIEWADDRESSPROOFIMAGE.equalsIgnoreCase(action)) {

			System.out.println("222222222");
			Customers cust = new Customers();
			String id = request.getParameter("id");
			long customerId = Long.parseLong(id);
			System.out.println("222222222" + customerId);
			try {
				cust = customerServcice.proofofdocument(customerId);
				ServletOutputStream sos = response.getOutputStream();
				response.setContentType("image/jpeg");
				response.setContentLength(cust.getImage1().getImage1().length);
				response
						.setHeader("Content-Disposition",
								"attachment; filename=" + cust.getCustomerID()
										+ ".jpg");
				sos.write(cust.getImage1().getImage1());
				sos.flush();
				sos.close();
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/viewAddressProofImage.jsp");
				rd.forward(request, response);
			} catch (CommercialCustRegException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
