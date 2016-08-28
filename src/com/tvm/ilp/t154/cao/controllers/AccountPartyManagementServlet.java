package com.tvm.ilp.t154.cao.controllers;

import static com.tvm.ilp.t154.cao.constants.CAOConstants.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.tvm.ilp.t154.cao.exceptions.CommercialCustRegException;
import com.tvm.ilp.t154.cao.model.Branch;
import com.tvm.ilp.t154.cao.model.Country;
import com.tvm.ilp.t154.cao.model.NonPersonalCustomer;
import com.tvm.ilp.t154.cao.model.PersonalParty;
import com.tvm.ilp.t154.cao.model.PersonalPartyAddress;
import com.tvm.ilp.t154.cao.model.PersonalPartyCoreAddressContactDetails;
import com.tvm.ilp.t154.cao.model.PersonnalPartyContactDetails;
import com.tvm.ilp.t154.cao.services.AccountPartyManagementService;
import com.tvm.ilp.t154.cao.services.CustomerManagementService;

import static com.tvm.ilp.t154.cao.utils.CAOUtility.convertStringToDate;

/**
 * Servlet implementation class AccountPartyManagementServlet
 */
public class AccountPartyManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(AccountPartyManagementServlet.class);
	/**
	 * @see HttpServlet#HttpServlet()
	 */

	AccountPartyManagementService apms = new AccountPartyManagementService();

	public AccountPartyManagementServlet() {
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
		long businessId = 0;
		String businessName = "";
		String businessBranch = "";
		String busiID = "";
		CustomerManagementService customerServcice = new CustomerManagementService();

		if (REGISTER.equalsIgnoreCase(action)) {
			logger.info("Entry in Business Customer Search");
			List<Branch> branchList = new ArrayList<Branch>();
			try {
				branchList = customerServcice.getBranch();
			} catch (CommercialCustRegException e) {
				request.setAttribute("errMsg", e.getMessage());
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/CCRErrorPage.jsp");
				rd.forward(request, response);
			}
			request.setAttribute("branchList", branchList);

			RequestDispatcher rd = request
					.getRequestDispatcher("jsp/CustomerBusinessSearch.jsp");
			rd.forward(request, response);
			
			logger.info("Exit from Business Customer Search");
		}

		else if ("Display_Business_Cust_Detail".equalsIgnoreCase(action)) {
			logger.info("Entry in Display Business Customer Details");
			businessId = (Long) request.getSession().getAttribute("Bid");
			businessName = (String) request.getSession().getAttribute("Bname");
			businessBranch = (String) request.getSession().getAttribute(
					"Bbranch");

			ArrayList<PersonalParty> pPartyList = new ArrayList<PersonalParty>();
			PersonalParty pParty = new PersonalParty();
			pParty.setBusinessId(businessId);
			try 
			{
				pPartyList = apms.ViewPersonalParties(pParty);
				request.setAttribute("BusinessId", businessId);
				request.setAttribute("BusinessName", businessName);
				request.setAttribute("BusinessBranch", businessBranch);
				request.setAttribute("acc_Party_List", pPartyList);
				RequestDispatcher rd = request
						.getRequestDispatcher("jsp/PersonalPartyDetailsSummary.jsp");
				rd.forward(request, response);
				logger.info("Exie from Display Business Customer Details");
			} 
			catch (CommercialCustRegException e) {
				request.setAttribute("errMsg", e.getMessage());
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/CCRErrorPage.jsp");
				rd.forward(request, response);
			}

		}

		else if ("Add_Account_Party".equalsIgnoreCase(action)) {
			logger.info("Entry in Add acoount party");
			businessId = (Long) request.getSession().getAttribute("Bid");
			businessName = (String) request.getSession().getAttribute("Bname");
			businessBranch = (String) request.getSession().getAttribute(
					"Bbranch");

			List<Branch> branchList = new ArrayList<Branch>();
			try 
			{
				branchList = customerServcice.getBranch();
				request.setAttribute("branchList", branchList);
				request.setAttribute("BusinessName", businessName);
				request.setAttribute("BusinessBranch", businessBranch);
				RequestDispatcher rd = request
						.getRequestDispatcher("jsp/PersonalPartyRegistrationFormCoreDetails.jsp");
				rd.forward(request, response);
				logger.info("Exit from Add acoount party");
			} catch (CommercialCustRegException e) {
				request.setAttribute("errMsg", e.getMessage());
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/CCRErrorPage.jsp");
				rd.forward(request, response);
			}
		}

		else if ("Account_party_core_detail".equalsIgnoreCase(action))
		{
			logger.info("Entry in Add acoount party core details");
			businessName = (String) request.getSession().getAttribute("Bname");
			businessBranch = (String) request.getSession().getAttribute(
					"Bbranch");
			long accountNumber;
			String branchName;

			String title = request.getParameter("title");
			String firstName = request.getParameter("firstName");
			String middleName = request.getParameter("middleName");
			String lastName = request.getParameter("lastName");
			String relationshipType = request.getParameter("relationshipType");
			String dateOfBirth = request.getParameter("dateOfBirth");
			String keyParty = request.getParameter("keyParty");
			String existingCustomer = request.getParameter("existingCustomer");
			if(existingCustomer.equals("Yes"))
			{
				accountNumber = Long.parseLong(request.getParameter("accountNumber"));
				branchName = request.getParameter("branchName");
				
				businessId = (Long) request.getSession().getAttribute("Bid");
				PersonalParty pParty = new PersonalParty();
				pParty.setBusinessId(businessId);
				pParty.setTitle(title);
				pParty.setFirstName(firstName);
				pParty.setMiddleName(middleName);
				pParty.setSurName(lastName);
				pParty.setRelationshipType(relationshipType);
				pParty.setDateOfBirth(dateOfBirth);
				pParty.setKeyParty(keyParty);
				pParty.setIsExistingCustomer(existingCustomer);
				pParty.setAccountNumber(accountNumber);
				pParty.setBranchId(branchName);
				request.getSession().setAttribute("PartyObject", pParty);
				PersonalPartyCoreAddressContactDetails partyDetails = new PersonalPartyCoreAddressContactDetails();
				try 
				{
					partyDetails = apms.getAccountDetails(accountNumber,branchName);
					
					if(partyDetails.getpPartyCoreDetails().getAccountNumber()==0)
					{
						List<Branch> branchList = new ArrayList<Branch>();
						branchList = customerServcice.getBranch();
						request.setAttribute("branchList", branchList);
						request.setAttribute("BusinessName", businessName);
						request.setAttribute("BusinessBranch", businessBranch);
						RequestDispatcher rd = request
								.getRequestDispatcher("jsp/PersonalPartyRegistrationFormCoreDetailsCheck.jsp");
						rd.forward(request, response);
					}
					else
					{
						partyDetails.getpPartyPreviousAddress().setAddressType("Previous");
						request.getSession().setAttribute("PartyPresentAddressObject",partyDetails.getpPartyPresentAddress());
						request.getSession().setAttribute("PartyPreviousAddressObject",partyDetails.getpPartyPreviousAddress());
						request.getSession().setAttribute("PersonalPartyContactDetails",partyDetails.getpPartyContactDetails());
						
						businessId = (Long) request.getSession().getAttribute("Bid");
						businessName = (String) request.getSession().getAttribute("Bname");
						businessBranch = (String) request.getSession().getAttribute("Bbranch");
		
						request.setAttribute("BusinessName", businessName);
						request.setAttribute("BusinessBranch", businessBranch);
		
						RequestDispatcher rd = request
								.getRequestDispatcher("jsp/PersonalPartyRegistrationSummary.jsp");
						rd.forward(request, response);
					}
					
				} 
				catch (CommercialCustRegException e) 
				{
					request.setAttribute("errMsg", e.getMessage());
					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/CCRErrorPage.jsp");
					rd.forward(request, response);
				}
			}
			else
			{
				accountNumber=0;
				branchName="";
				
				businessId = (Long) request.getSession().getAttribute("Bid");
				PersonalParty pParty = new PersonalParty();
				pParty.setBusinessId(businessId);
				pParty.setTitle(title);
				pParty.setFirstName(firstName);
				pParty.setMiddleName(middleName);
				pParty.setSurName(lastName);
				pParty.setRelationshipType(relationshipType);
				pParty.setDateOfBirth(dateOfBirth);
				pParty.setKeyParty(keyParty);
				pParty.setIsExistingCustomer(existingCustomer);
				pParty.setAccountNumber(accountNumber);
				pParty.setBranchId(branchName);

				request.getSession().setAttribute("PartyObject", pParty);

				List<Country> countryList = new ArrayList<Country>();
				try 
				{
					countryList = customerServcice.getCountry();
					request.setAttribute("BusinessName", businessName);
					request.setAttribute("BusinessBranch", businessBranch);
					request.setAttribute("countryList", countryList);

					RequestDispatcher rd = request
							.getRequestDispatcher("jsp/PersonalPartyPresentAddressDetails.jsp");
					rd.forward(request, response);
				} 
				catch (CommercialCustRegException e) 
				{
					request.setAttribute("errMsg", e.getMessage());
					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/CCRErrorPage.jsp");
					rd.forward(request, response);
				}
			}
			logger.info("Exit from Add acoount party core details");
		}

		else if ("Account_party_present_address_detail".equalsIgnoreCase(action)) {
			logger.info("Entry in Add acoount party presenr address details");
			businessName = (String) request.getSession().getAttribute("Bname");
			businessBranch = (String) request.getSession().getAttribute(
					"Bbranch");

			String presentHouseNo = request.getParameter("presentHouseNo");
			String presentHouseName = request.getParameter("presentHouseName");
			String presentBuildingNo = request
					.getParameter("presentBuildingNo");
			String presentStreet = request.getParameter("presentStreet");
			String presentCity = request.getParameter("presentCity");
			String presentTown = request.getParameter("presentTown");
			String presentCountry = request.getParameter("presentCountry");
			String presentPostalCode = request
					.getParameter("presentPostalCode");
			String presentAddressDate = request
					.getParameter("presentAddressDate");

			PersonalPartyAddress pPartyAddress = new PersonalPartyAddress();
			pPartyAddress.setHouseName(presentHouseName);
			pPartyAddress.setHouseNo(presentHouseNo);
			pPartyAddress.setBuildingNo(presentBuildingNo);
			pPartyAddress.setStreetName(presentStreet);
			pPartyAddress.setCityName(presentCity);
			pPartyAddress.setTownName(presentTown);
			pPartyAddress.setCountryName(presentCountry);
			pPartyAddress.setPostalCode(presentPostalCode);
			pPartyAddress.setAddressType("Present");

			request.getSession().setAttribute("PartyPresentAddressObject",
					pPartyAddress);

			int addressYear = Integer.parseInt(presentAddressDate.substring(0,
					4));
			int addressMonth = Integer.parseInt(presentAddressDate.substring(5,
					7));
			int addressDay = Integer.parseInt(presentAddressDate.substring(8,
					10));
			Calendar addressDate = Calendar.getInstance();
			addressDate.set(addressYear, addressMonth, addressDay);

			int year = Calendar.getInstance().get(Calendar.YEAR);
			int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
			int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
			Calendar boundryDate = Calendar.getInstance();
			boundryDate.set(year, month, day);
			boundryDate.add(Calendar.YEAR, -3);

			if (boundryDate.before(addressDate)) {
				List<Country> countryList = new ArrayList<Country>();
				try 
				{
					countryList = customerServcice.getCountry();
					request.setAttribute("BusinessName", businessName);
					request.setAttribute("BusinessBranch", businessBranch);
					request.setAttribute("countryList", countryList);

					RequestDispatcher rd = request
							.getRequestDispatcher("jsp/PersonalPartyPreviousAddressDetails.jsp");
					rd.forward(request, response);
				} 
				catch (CommercialCustRegException e) 
				{
					request.setAttribute("errMsg", e.getMessage());
					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/CCRErrorPage.jsp");
					rd.forward(request, response);
				}
			}
			else 
			{

				PersonalPartyAddress pPartyPrevAddress=new PersonalPartyAddress();
				pPartyPrevAddress=pPartyAddress;
				pPartyPrevAddress.setAddressType("Previous");
				request.getSession().setAttribute("PartyPreviousAddressObject", pPartyPrevAddress);
				request.setAttribute("BusinessName",businessName);
				request.setAttribute("BusinessBranch",businessBranch);
				RequestDispatcher rd=request.getRequestDispatcher("jsp/PersonalPartyContactDetails.jsp");
				rd.forward(request,response);

			}
			logger.info("Exit from Add acoount party present address details");
		}

		else if ("Account_party_previous_address_detail"
				.equalsIgnoreCase(action)) {
			logger.info("Entry in Add acoount party prevoius address details");
			businessName = (String) request.getSession().getAttribute("Bname");
			businessBranch = (String) request.getSession().getAttribute(
					"Bbranch");

			String previousHouseNo = request.getParameter("previousHouseNo");
			String previousHouseName = request
					.getParameter("previousHouseName");
			String previousBuildingNo = request
					.getParameter("previousBuildingNo");
			String previousStreet = request.getParameter("previousStreet");
			String previousCity = request.getParameter("previousCity");
			String previousTown = request.getParameter("previousTown");
			String previousCountry = request.getParameter("previousCountry");
			String previousPostalCode = request
					.getParameter("previousPostalCode");

			PersonalPartyAddress pPartyAddress = new PersonalPartyAddress();
			pPartyAddress.setHouseName(previousHouseName);
			pPartyAddress.setHouseNo(previousHouseNo);
			pPartyAddress.setBuildingNo(previousBuildingNo);
			pPartyAddress.setStreetName(previousStreet);
			pPartyAddress.setCityName(previousCity);
			pPartyAddress.setTownName(previousTown);
			pPartyAddress.setCountryName(previousCountry);
			pPartyAddress.setPostalCode(previousPostalCode);
			pPartyAddress.setAddressType("Previous");

			request.getSession().setAttribute("PartyPreviousAddressObject",
					pPartyAddress);

			request.setAttribute("BusinessName", businessName);
			request.setAttribute("BusinessBranch", businessBranch);

			RequestDispatcher rd = request
					.getRequestDispatcher("jsp/PersonalPartyContactDetails.jsp");
			rd.forward(request, response);
			logger.info("Exit from Add acoount party prevoius address details");
		}

		else if ("Account_party_contact_detail".equalsIgnoreCase(action)) {
			logger.info("Entry in Add acoount party contact details");
			
			String eMailAddress = request.getParameter("eMailAddress");
			String mobileNumber = request.getParameter("mobileCountryCode")+request.getParameter("mobileTelephoneNumber");
			String homeNumber = request.getParameter("homeCountryCode")
					+ request.getParameter("homeCityCode")
					+ request.getParameter("homeTelephoneNumber");
			String officeNumber = request.getParameter("officeCountryCode")
					+ request.getParameter("officeCityCode")
					+ request.getParameter("officeTelephoneNumber");
			String idProofType = request.getParameter("idProofType");
			String idProofFile = request.getParameter("idProofFile");
			String addressProofType = request.getParameter("addressProofType");
			String addressProofFile = request.getParameter("addressProofFile");

			PersonnalPartyContactDetails pPartyContactDetails = new PersonnalPartyContactDetails();

			pPartyContactDetails.seteMailAddress(eMailAddress);
			pPartyContactDetails.setMobileNumber(mobileNumber);
			pPartyContactDetails.setHomeNumber(homeNumber);
			pPartyContactDetails.setOfficeNumber(officeNumber);
			pPartyContactDetails.setIdProofType(idProofType);
			pPartyContactDetails.setIdProofFile(idProofFile);
			pPartyContactDetails.setAddressProofType(addressProofType);
			pPartyContactDetails.setAddressProofFile(addressProofFile);

			request.getSession().setAttribute("PersonalPartyContactDetails",
					pPartyContactDetails);

			businessId = (Long) request.getSession().getAttribute("Bid");
			businessName = (String) request.getSession().getAttribute("Bname");
			businessBranch = (String) request.getSession().getAttribute(
					"Bbranch");

			request.setAttribute("BusinessName", businessName);
			request.setAttribute("BusinessBranch", businessBranch);

			RequestDispatcher rd = request
					.getRequestDispatcher("jsp/PersonalPartyRegistrationSummary.jsp");
			rd.forward(request, response);
			logger.info("Exit from Add acoount party contact details");


		}

		else if ("UpadtePersonalPartyCoreDetails".equalsIgnoreCase(action)) {
			
			logger.info("Entry in update account party core details");

			businessName = (String) request.getSession().getAttribute("Bname");
			businessBranch = (String) request.getSession().getAttribute(
					"Bbranch");
			String updateType = "updateAtCreation";

			List<Branch> branchList = new ArrayList<Branch>();
			try 
			{
				branchList = customerServcice.getBranch();
				request.setAttribute("branchList", branchList);
				request.setAttribute("BusinessName", businessName);
				request.setAttribute("BusinessBranch", businessBranch);
				request.setAttribute("UpdateType", updateType);
				RequestDispatcher rd = request
						.getRequestDispatcher("jsp/UpdatePersonalPartyCoreDetails.jsp");
				rd.forward(request, response);
			} 
			catch (CommercialCustRegException e) 
			{
				request.setAttribute("errMsg", e.getMessage());
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/CCRErrorPage.jsp");
				rd.forward(request, response);
			}
		}

		else if ("Update_Account_party_core_detail_update"
				.equalsIgnoreCase(action)) {
			businessName = (String) request.getSession().getAttribute("Bname");
			businessBranch = (String) request.getSession().getAttribute(
					"Bbranch");
		//	request.getSession().removeAttribute("PartyObject");

			String title = request.getParameter("title");
			String firstName = request.getParameter("firstName");
			String middleName = request.getParameter("middleName");
			String lastName = request.getParameter("lastName");
			String relationshipType = request.getParameter("relationshipType");
			String dateOfBirth = request.getParameter("dateOfBirth");
			String keyParty = request.getParameter("keyParty");
			/*String existingCustomer = request.getParameter("existingCustomer");
			long accountNumber = Long.parseLong(request
					.getParameter("accountNumber"));
			String branchName = request.getParameter("branchName");*/
			businessId = (Long) request.getSession().getAttribute("Bid");

			PersonalParty pParty = new PersonalParty();
			pParty=(PersonalParty)request.getSession().getAttribute("PartyObject");
			pParty.setBusinessId(businessId);
			pParty.setTitle(title);
			pParty.setFirstName(firstName);
			pParty.setMiddleName(middleName);
			pParty.setSurName(lastName);
			pParty.setRelationshipType(relationshipType);
			pParty.setDateOfBirth(dateOfBirth);
			pParty.setKeyParty(keyParty);
		/*	pParty.setIsExistingCustomer(existingCustomer);
			pParty.setAccountNumber(accountNumber);
			pParty.setBranchId(branchName);
*/
			request.getSession().setAttribute("PartyObject", pParty);

			request.setAttribute("BusinessName", businessName);
			request.setAttribute("BusinessBranch", businessBranch);

			RequestDispatcher rd = request
					.getRequestDispatcher("jsp/PersonalPartyRegistrationSummary.jsp");
			rd.forward(request, response);
			logger.info("Exit from update acoount party core details");


		}

		else if ("UpadtePersonalPartyPresentAddress".equalsIgnoreCase(action)) {
			
			logger.info("Entry in update acoount party present address details");


			businessName = (String) request.getSession().getAttribute("Bname");
			businessBranch = (String) request.getSession().getAttribute(
					"Bbranch");
			String updateType = "updateAtCreation";
			List<Country> countryList = new ArrayList<Country>();
			try 
			{
				countryList = customerServcice.getCountry();
				request.setAttribute("BusinessName", businessName);
				request.setAttribute("BusinessBranch", businessBranch);
				request.setAttribute("UpdateType", updateType);
				request.setAttribute("countryList", countryList);
				RequestDispatcher rd = request
						.getRequestDispatcher("jsp/UpdatePersonalPartyPresentAddress.jsp");
				rd.forward(request, response);
			} catch (CommercialCustRegException e) {
				request.setAttribute("errMsg", e.getMessage());
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/CCRErrorPage.jsp");
				rd.forward(request, response);
			}
		}

		else if ("Update_Account_party_present_address"
				.equalsIgnoreCase(action)) {

			businessName = (String) request.getSession().getAttribute("Bname");
			businessBranch = (String) request.getSession().getAttribute(
					"Bbranch");
		//	request.getSession().removeAttribute("PartyPresentAddressObject");

			String presentHouseNo = request.getParameter("presentHouseNo");
			String presentHouseName = request.getParameter("presentHouseName");
			String presentBuildingNo = request
					.getParameter("presentBuildingNo");
			String presentStreet = request.getParameter("presentStreet");
			String presentCity = request.getParameter("presentCity");
			String presentTown = request.getParameter("presentTown");
			String presentCountry = request.getParameter("presentCountry");
			String presentPostalCode = request
					.getParameter("presentPostalCode");
	//		String presentAddressDate = request.getParameter("presentAddressDate");

			PersonalPartyAddress pPartyAddress = new PersonalPartyAddress();
			pPartyAddress.setHouseName(presentHouseName);
			pPartyAddress.setHouseNo(presentHouseNo);
			pPartyAddress.setBuildingNo(presentBuildingNo);
			pPartyAddress.setStreetName(presentStreet);
			pPartyAddress.setCityName(presentCity);
			pPartyAddress.setTownName(presentTown);
			pPartyAddress.setCountryName(presentCountry);
			pPartyAddress.setPostalCode(presentPostalCode);
		//	pPartyAddress.setPresentAddressDate(presentAddressDate);

			request.getSession().setAttribute("PartyPresentAddressObject",
					pPartyAddress);

			request.setAttribute("BusinessName", businessName);
			request.setAttribute("BusinessBranch", businessBranch);

			RequestDispatcher rd = request
					.getRequestDispatcher("jsp/PersonalPartyRegistrationSummary.jsp");
			rd.forward(request, response);

			logger.info("Exit from update acoount party present address details");


		}

		else if ("UpdatePersonalPartyPreviousAddress".equalsIgnoreCase(action)) {
			
			logger.info("Entry in update acoount party previous address details");

			businessName = (String) request.getSession().getAttribute("Bname");
			businessBranch = (String) request.getSession().getAttribute(
					"Bbranch");
			String updateType = "updateAtCreation";
			List<Country> countryList = new ArrayList<Country>();
			try {
				countryList = customerServcice.getCountry();
				request.setAttribute("BusinessName", businessName);
				request.setAttribute("BusinessBranch", businessBranch);
				request.setAttribute("UpdateType", updateType);
				request.setAttribute("countryList", countryList);
				RequestDispatcher rd = request
						.getRequestDispatcher("jsp/UpdatePersonalPartyPreviousAddress.jsp");
				rd.forward(request, response);
			} catch (CommercialCustRegException e) {
				request.setAttribute("errMsg", e.getMessage());
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/CCRErrorPage.jsp");
				rd.forward(request, response);
			}
		}

		else if ("Update_Account_party_previous_address_detail"
				.equalsIgnoreCase(action)) {
			businessName = (String) request.getSession().getAttribute("Bname");
			businessBranch = (String) request.getSession().getAttribute(
					"Bbranch");
			request.getSession().removeAttribute("PartyPreviousAddressObject");

			String previousHouseNo = request.getParameter("previousHouseNo");
			String previousHouseName = request
					.getParameter("previousHouseName");
			String previousBuildingNo = request
					.getParameter("previousBuildingNo");
			String previousStreet = request.getParameter("previousStreet");
			String previousCity = request.getParameter("previousCity");
			String previousTown = request.getParameter("previousTown");
			String previousCountry = request.getParameter("previousCountry");
			String previousPostalCode = request
					.getParameter("previousPostalCode");

			PersonalPartyAddress pPartyAddress = new PersonalPartyAddress();
			pPartyAddress.setHouseName(previousHouseName);
			pPartyAddress.setHouseNo(previousHouseNo);
			pPartyAddress.setBuildingNo(previousBuildingNo);
			pPartyAddress.setStreetName(previousStreet);
			pPartyAddress.setCityName(previousCity);
			pPartyAddress.setTownName(previousTown);
			pPartyAddress.setCountryName(previousCountry);
			pPartyAddress.setPostalCode(previousPostalCode);

			request.getSession().setAttribute("PartyPreviousAddressObject",
					pPartyAddress);

			request.setAttribute("BusinessName", businessName);
			request.setAttribute("BusinessBranch", businessBranch);

			RequestDispatcher rd = request
					.getRequestDispatcher("jsp/PersonalPartyRegistrationSummary.jsp");
			rd.forward(request, response);
			
			logger.info("Exit from update acoount party previous address details");


		}

		else if ("UpadtePersonalPartyContactDetails".equalsIgnoreCase(action)) {
			
			logger.info("Entry in update acoount party contact details");

			businessName = (String) request.getSession().getAttribute("Bname");
			businessBranch = (String) request.getSession().getAttribute(
					"Bbranch");
			String updateType = "updateAtCreation";

			request.setAttribute("BusinessName", businessName);
			request.setAttribute("BusinessBranch", businessBranch);
			request.setAttribute("UpdateType", updateType);
			RequestDispatcher rd = request
					.getRequestDispatcher("jsp/UpdatePersonalPartyContactDetails.jsp");
			rd.forward(request, response);
		}

		else if ("Update_Account_party_contact_detail".equalsIgnoreCase(action)) {
			businessName = (String) request.getSession().getAttribute("Bname");
			businessBranch = (String) request.getSession().getAttribute(
					"Bbranch");
			//request.getSession().removeAttribute("PersonalPartyContactDetails");

			String eMailAddress = request.getParameter("eMailAddress");
			String mobileNumber = request.getParameter("mobileNo");
			String homeNumber = request.getParameter("HomeNo");
			String officeNumber = request.getParameter("OfficNo");
			/*String idProofType = request.getParameter("idProofType");
			String idProofFile = request.getParameter("idProofFile");
			String addressProofType = request.getParameter("addressProofType");
			String addressProofFile = request.getParameter("addressProofFile");
*/
			PersonnalPartyContactDetails pPartyContactDetails = new PersonnalPartyContactDetails();

			pPartyContactDetails=(PersonnalPartyContactDetails)request.getSession().getAttribute("PersonalPartyContactDetails");
			pPartyContactDetails.seteMailAddress(eMailAddress);
			pPartyContactDetails.setMobileNumber(mobileNumber);
			pPartyContactDetails.setHomeNumber(homeNumber);
			pPartyContactDetails.setOfficeNumber(officeNumber);
			/*pPartyContactDetails.setIdProofType(idProofType);
			pPartyContactDetails.setIdProofFile(idProofFile);
			pPartyContactDetails.setAddressProofType(addressProofType);
			pPartyContactDetails.setAddressProofFile(addressProofFile);*/

			request.getSession().setAttribute("PersonalPartyContactDetails",
					pPartyContactDetails);

			request.setAttribute("BusinessName", businessName);
			request.setAttribute("BusinessBranch", businessBranch);

			RequestDispatcher rd = request
					.getRequestDispatcher("jsp/PersonalPartyRegistrationSummary.jsp");
			rd.forward(request, response);
			
			logger.info("Exit from update acoount party contact details");

		}

		else if ("Party_details_Summary".equalsIgnoreCase(action)) {
			
			logger.info("Entry in party details summary");
			
			PersonalParty personalPartyObject = new PersonalParty();
			personalPartyObject = (PersonalParty) request.getSession()
					.getAttribute("PartyObject");

			PersonalPartyAddress PartyPresentAddressObject = new PersonalPartyAddress();
			PartyPresentAddressObject = (PersonalPartyAddress) request
					.getSession().getAttribute("PartyPresentAddressObject");

			PersonalPartyAddress PartyPreviousAddressObject = new PersonalPartyAddress();
			PartyPreviousAddressObject = (PersonalPartyAddress) request
					.getSession().getAttribute("PartyPreviousAddressObject");


			PersonnalPartyContactDetails pPartyContactDetails = new PersonnalPartyContactDetails();
			pPartyContactDetails=(PersonnalPartyContactDetails)request.getSession().getAttribute("PersonalPartyContactDetails");
			
			boolean flag = false;
			try 
			{
				flag = apms.addPersonalParty(personalPartyObject, PartyPresentAddressObject, PartyPreviousAddressObject, pPartyContactDetails);
				if(flag==true)
				{
					
					ArrayList<PersonalParty> pPartyList = new ArrayList<PersonalParty>();
					PersonalParty pParty = new PersonalParty();
					businessId = (Long) request.getSession().getAttribute("Bid");
					pParty.setBusinessId(businessId);
					try {
						pPartyList = apms.ViewPersonalParties(pParty);
					} catch (CommercialCustRegException e) {
						request.setAttribute("errMsg", e.getMessage());
						RequestDispatcher rd = request
								.getRequestDispatcher("/jsp/CCRErrorPage.jsp");
						rd.forward(request, response);
					}
					String msg="Party added successfully";
					
					businessName = (String) request.getSession().getAttribute("Bname");
					businessBranch = (String) request.getSession().getAttribute("Bbranch");
					request.setAttribute("BusinessName", businessName);
					request.setAttribute("BusinessBranch", businessBranch);
					request.setAttribute("msg", msg);
					request.setAttribute("acc_Party_List", pPartyList);
					RequestDispatcher rd = request
							.getRequestDispatcher("jsp/PersonalPartyDetailsSummary.jsp");
					rd.forward(request, response);

					logger.info("Exit from party details summary");
				}
			} catch (CommercialCustRegException e) {
				request.setAttribute("errMsg", e.getMessage());
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/CCRErrorPage.jsp");
				rd.forward(request, response);
			}
		}

		else if ("Acc_Party_Selected_Operation".equalsIgnoreCase(action)) 
		{

			logger.info("Entry in account party selected operation");

			long selectedPartyId = Long.parseLong(request
					.getParameter("selectParty"));
			request.getSession().setAttribute("selectedPartyId", selectedPartyId);
			String operationType = request.getParameter("selectedPartyAction");

			if (operationType.equals("viewSelectedParty")) 
			{
				
				logger.info("Entry in view selected party");

				
				PersonalPartyCoreAddressContactDetails partyDetails = new PersonalPartyCoreAddressContactDetails();
				try
				{
					partyDetails = apms.viewSelectedParty(selectedPartyId);
					businessName = (String) request.getSession().getAttribute("Bname");
					businessBranch = (String) request.getSession().getAttribute("Bbranch");

					request.setAttribute("BusinessName", businessName);
					request.setAttribute("BusinessBranch", businessBranch);
					request.setAttribute("PartyDetails", partyDetails);
					RequestDispatcher rd = request
							.getRequestDispatcher("jsp/PersonalPartyDetailsView.jsp");
					rd.forward(request, response);
					
					logger.info("Exit from view selected party");
				} 
				catch (CommercialCustRegException e) 
				{
							request.setAttribute("errMsg", e.getMessage());
							RequestDispatcher rd = request
									.getRequestDispatcher("/jsp/CCRErrorPage.jsp");
							rd.forward(request, response);
				}
				
			}
				
			else if (operationType.equals("updateSelectedParty")) {
					
					logger.info("Entry in update selected party");
					
					PersonalPartyCoreAddressContactDetails partyDetails = new PersonalPartyCoreAddressContactDetails();
					try 
					{
						partyDetails = apms.viewSelectedParty(selectedPartyId);
						request.getSession().setAttribute("PartyWholeDetails", partyDetails);
						businessName = (String) request.getSession().getAttribute(
								"Bname");
						businessBranch = (String) request.getSession().getAttribute(
								"Bbranch");
						
						request.setAttribute("BusinessName", businessName);
						request.setAttribute("BusinessBranch", businessBranch);
						request.setAttribute("PartyDetails", partyDetails);
						RequestDispatcher rd = request
								.getRequestDispatcher("jsp/PersonalPartyDetailsViewForUpdate.jsp");
						rd.forward(request, response);
						
						logger.info("Exit from update selected party");
					} catch (CommercialCustRegException e) {
						request.setAttribute("errMsg", e.getMessage());
						RequestDispatcher rd = request
								.getRequestDispatcher("/jsp/CCRErrorPage.jsp");
						rd.forward(request, response);
					}
			}
				
				else if (operationType.equals("deleteSelectedParty")) {
					
					logger.info("Entry in delete selected party");

					boolean deleteFlag = false;
					try 
					{
						deleteFlag = apms.deleteSelectedParty(selectedPartyId);
						businessName=(String)request.getSession().getAttribute("Bname");
						businessBranch=(String)request.getSession().getAttribute("Bbranch");
						
						ArrayList<PersonalParty> pPartyList = new ArrayList<PersonalParty>();
						PersonalParty pParty = new PersonalParty();
						businessId = (Long) request.getSession().getAttribute("Bid");
						pParty.setBusinessId(businessId);
						
						pPartyList = apms.ViewPersonalParties(pParty);
						String msg="Party deleted successfully";
						
						request.setAttribute("BusinessName", businessName);
						request.setAttribute("BusinessBranch", businessBranch);
						request.setAttribute("acc_Party_List", pPartyList);
						request.setAttribute("msg", msg);
						RequestDispatcher rd = request
								.getRequestDispatcher("jsp/PersonalPartyDetailsSummary.jsp");
						rd.forward(request, response);
						
						logger.info("Exit from delete selected party");
					} catch (CommercialCustRegException e) {
						request.setAttribute("errMsg", e.getMessage());
						RequestDispatcher rd = request
								.getRequestDispatcher("/jsp/CCRErrorPage.jsp");
						rd.forward(request, response);
					}
					
				}
			}

		
		else if ("updatecoredetailsAfterRegistration".equalsIgnoreCase(action)) {
			
			logger.info("Entry in update core details after registration");

			PersonalPartyCoreAddressContactDetails partyDetails = new PersonalPartyCoreAddressContactDetails();
			partyDetails=(PersonalPartyCoreAddressContactDetails)request.getSession().getAttribute("PartyWholeDetails");
			
			businessName = (String) request.getSession().getAttribute("Bname");
			businessBranch = (String) request.getSession().getAttribute(
					"Bbranch");
			
			String updateType;

			PersonalParty pParty=new PersonalParty();
			pParty=partyDetails.getpPartyCoreDetails();
			
			if(pParty.getAccountNumber()>0)
			{
				updateType="AccountCreated";
			}
			else
			{
				updateType="AccountNotCreated";
			}
			
			request.setAttribute("BusinessName", businessName);
			request.setAttribute("BusinessBranch", businessBranch);
			request.setAttribute("PartyCoreDetails", pParty);
			request.setAttribute("updateType", updateType);
	
			RequestDispatcher rd = request
					.getRequestDispatcher("jsp/UpdatePersonalPartyCoreDetailsAfterReg.jsp");
			rd.forward(request, response);
			
			logger.info("Exit from update core details after registration");

		}
		
		else if ("Update_Account_party_core_detail_update_after_reg".equalsIgnoreCase(action)) {
			
			logger.info("Entry in update account party core detail after registration");

			
			businessName = (String) request.getSession().getAttribute("Bname");
			businessBranch = (String) request.getSession().getAttribute(
					"Bbranch");

			String title = request.getParameter("title");
			String firstName = request.getParameter("firstName");
			String middleName = request.getParameter("middleName");
			String lastName = request.getParameter("lastName");
			String relationshipType = request.getParameter("relationshipType");
			String dateOfBirth = request.getParameter("dateOfBirth");
			String keyParty = request.getParameter("keyParty");
			
			PersonalPartyCoreAddressContactDetails partyDetails = new PersonalPartyCoreAddressContactDetails();
			partyDetails=(PersonalPartyCoreAddressContactDetails)request.getSession().getAttribute("PartyWholeDetails");
			PersonalParty pParty=new PersonalParty();
			pParty=partyDetails.getpPartyCoreDetails();
			
			pParty.setRelationshipType(relationshipType);
			pParty.setKeyParty(keyParty);
			if(pParty.getAccountNumber()==0)
			{
				pParty.setTitle(title);
				pParty.setFirstName(firstName);
				pParty.setMiddleName(middleName);
				pParty.setSurName(lastName);
				pParty.setDateOfBirth(dateOfBirth);
			}
			
			partyDetails.setpPartyCoreDetails(pParty);
			request.getSession().setAttribute("PartyWholeDetails", partyDetails);
			
			request.setAttribute("BusinessName", businessName);
			request.setAttribute("BusinessBranch", businessBranch);
			request.setAttribute("PartyDetails", partyDetails);
			RequestDispatcher rd = request
					.getRequestDispatcher("jsp/PersonalPartyDetailsViewForUpdate.jsp");
			rd.forward(request, response);
			
			logger.info("Exit from update account party core detail after registration");

			
		}
		
		else if ("updatPresentAddressAfterRegistration".equalsIgnoreCase(action)) {
			
			logger.info("Entry in update present address details after registration");

			
			PersonalPartyCoreAddressContactDetails partyDetails = new PersonalPartyCoreAddressContactDetails();
			partyDetails=(PersonalPartyCoreAddressContactDetails)request.getSession().getAttribute("PartyWholeDetails");
			
			businessName = (String) request.getSession().getAttribute("Bname");
			businessBranch = (String) request.getSession().getAttribute(
					"Bbranch");
			

			PersonalPartyAddress pPartyAddress = new PersonalPartyAddress();
			pPartyAddress=partyDetails.getpPartyPresentAddress();
			
			List<Country> countryList = new ArrayList<Country>();
			try {
				countryList = customerServcice.getCountry();
				request.setAttribute("countryList", countryList);
				request.setAttribute("BusinessName", businessName);
				request.setAttribute("BusinessBranch", businessBranch);
				request.setAttribute("pPartyAddress", pPartyAddress);
		
				RequestDispatcher rd = request
						.getRequestDispatcher("jsp/UpdatePersonalPartyAddressAfterReg.jsp");
				rd.forward(request, response);
			} catch (CommercialCustRegException e) {
				request.setAttribute("errMsg", e.getMessage());
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/CCRErrorPage.jsp");
				rd.forward(request, response);
			}
		}
		
		else if ("Update_Account_party_present_address_after_reg".equalsIgnoreCase(action)) {
			businessName = (String) request.getSession().getAttribute("Bname");
			businessBranch = (String) request.getSession().getAttribute(
					"Bbranch");

			String presentHouseNo = request.getParameter("presentHouseNo");
			String presentHouseName = request.getParameter("presentHouseName");
			String presentBuildingNo = request
					.getParameter("presentBuildingNo");
			String presentStreet = request.getParameter("presentStreet");
			String presentCity = request.getParameter("presentCity");
			String presentTown = request.getParameter("presentTown");
			String presentCountry = request.getParameter("presentCountry");
			String presentPostalCode = request
					.getParameter("presentPostalCode");
			
			PersonalPartyCoreAddressContactDetails partyDetails = new PersonalPartyCoreAddressContactDetails();
			partyDetails=(PersonalPartyCoreAddressContactDetails)request.getSession().getAttribute("PartyWholeDetails");
			
			PersonalPartyAddress pPartyAddress = new PersonalPartyAddress();
			PersonalPartyAddress prPartyAddress = new PersonalPartyAddress();
			pPartyAddress.setHouseName(presentHouseName);
			pPartyAddress.setHouseNo(presentHouseNo);
			pPartyAddress.setBuildingNo(presentBuildingNo);
			pPartyAddress.setStreetName(presentStreet);
			pPartyAddress.setCityName(presentCity);
			pPartyAddress.setTownName(presentTown);
			pPartyAddress.setCountryName(presentCountry);
			pPartyAddress.setPostalCode(presentPostalCode);
			pPartyAddress.setAddressType("Present");
			
			prPartyAddress=partyDetails.getpPartyPresentAddress();
			prPartyAddress.setAddressType("Previous");
			partyDetails.setpPartyPresentAddress(pPartyAddress);
			partyDetails.setpPartyPreviousAddress(prPartyAddress);
			
			request.getSession().setAttribute("PartyWholeDetails", partyDetails);
			request.setAttribute("BusinessName", businessName);
			request.setAttribute("BusinessBranch", businessBranch);
			request.setAttribute("PartyDetails", partyDetails);
			RequestDispatcher rd = request
					.getRequestDispatcher("jsp/PersonalPartyDetailsViewForUpdate.jsp");
			rd.forward(request, response);
			
			logger.info("Entry in update present address details after registration");

		}

		
		else if ("updateContactAfterRegistration".equalsIgnoreCase(action)) {
			
			logger.info("Entry in update contact after registration");

			
			PersonalPartyCoreAddressContactDetails partyDetails = new PersonalPartyCoreAddressContactDetails();
			partyDetails=(PersonalPartyCoreAddressContactDetails)request.getSession().getAttribute("PartyWholeDetails");
			PersonnalPartyContactDetails pPartyContactDetails = new PersonnalPartyContactDetails();
			pPartyContactDetails=partyDetails.getpPartyContactDetails();
			businessName = (String) request.getSession().getAttribute("Bname");
			businessBranch = (String) request.getSession().getAttribute(
					"Bbranch");
			
			request.setAttribute("BusinessName", businessName);
			request.setAttribute("BusinessBranch", businessBranch);
			request.setAttribute("pPartyContactDetails", pPartyContactDetails);
	
			RequestDispatcher rd = request
					.getRequestDispatcher("jsp/UpdatePersonalPartyContactsAfterReg.jsp");
			rd.forward(request, response);

		}
		
		else if ("Update_Account_party_contact_detail_after_reg".equalsIgnoreCase(action)) {
			
			logger.info("Entry in update account party contact detail after registration");

			businessName = (String) request.getSession().getAttribute("Bname");
			businessBranch = (String) request.getSession().getAttribute(
					"Bbranch");

			String eMailAddress = request.getParameter("eMailAddress");
			String mobileNumber = request.getParameter("mobileNo");
			String homeNumber = request.getParameter("HomeNo");
			String officeNumber = request.getParameter("OfficNo");
			/*String idProofType = request.getParameter("idProofType");
			String idProofFile = request.getParameter("idProofFile");
			String addressProofType = request.getParameter("addressProofType");
			String addressProofFile = request.getParameter("addressProofFile");*/
			
			PersonalPartyCoreAddressContactDetails partyDetails = new PersonalPartyCoreAddressContactDetails();
			partyDetails=(PersonalPartyCoreAddressContactDetails)request.getSession().getAttribute("PartyWholeDetails");
			PersonnalPartyContactDetails pPartyContactDetails = new PersonnalPartyContactDetails();
			pPartyContactDetails=partyDetails.getpPartyContactDetails();
			
			/*if(!pPartyContactDetails.getIdProofType().equals(idProofType))
			{
				pPartyContactDetails.setIdProofType(idProofType);
				pPartyContactDetails.setIdProofFile(idProofFile);
			}
			if(!pPartyContactDetails.getAddressProofType().equals(addressProofType))
			{
				pPartyContactDetails.setAddressProofType(addressProofType);
				pPartyContactDetails.setAddressProofFile(addressProofFile);
			}*/
			
			pPartyContactDetails.seteMailAddress(eMailAddress);
			pPartyContactDetails.setMobileNumber(mobileNumber);
			pPartyContactDetails.setHomeNumber(homeNumber);
			pPartyContactDetails.setOfficeNumber(officeNumber);
			/*pPartyContactDetails.setAddressProofType(addressProofType);
			pPartyContactDetails.setIdProofType(idProofType);*/
			partyDetails.setpPartyContactDetails(pPartyContactDetails);
			request.getSession().setAttribute("PartyWholeDetails", partyDetails);
			
			request.setAttribute("BusinessName", businessName);
			request.setAttribute("BusinessBranch", businessBranch);
			request.setAttribute("PartyDetails", partyDetails);
			RequestDispatcher rd = request
					.getRequestDispatcher("jsp/PersonalPartyDetailsViewForUpdate.jsp");
			rd.forward(request, response);
			
			logger.info("Exit from update contact details after registration");

			

		}
		
		else if ("Update_personal_party_details_after_reg".equalsIgnoreCase(action)) {
			
			PersonalPartyCoreAddressContactDetails partyDetails = new PersonalPartyCoreAddressContactDetails();
			partyDetails=(PersonalPartyCoreAddressContactDetails)request.getSession().getAttribute("PartyWholeDetails");
			ArrayList<PersonalParty> pPartyList = new ArrayList<PersonalParty>();
			PersonalParty pParty = new PersonalParty();
			pParty.setBusinessId(businessId);
			try 
			{
				boolean flag=apms.updatePersonalParty(partyDetails);
				
				businessId = (Long) request.getSession().getAttribute("Bid");
				businessName = (String) request.getSession().getAttribute("Bname");
				businessBranch = (String) request.getSession().getAttribute("Bbranch");
				pParty.setBusinessId(businessId);
				pPartyList = apms.ViewPersonalParties(pParty);
				
				String msg="Party updated Successfully";
				request.setAttribute("msg", msg);
				request.setAttribute("BusinessId", businessId);
				request.setAttribute("BusinessName", businessName);
				request.setAttribute("BusinessBranch", businessBranch);
				request.setAttribute("acc_Party_List", pPartyList);
				RequestDispatcher rd = request
						.getRequestDispatcher("jsp/PersonalPartyDetailsSummary.jsp");
				rd.forward(request, response);
			} catch (CommercialCustRegException e) {
				request.setAttribute("errMsg", e.getMessage());
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/CCRErrorPage.jsp");
				rd.forward(request, response);
			}
		}
		
		
		
		
		else if ("Cancel_party_updation".equalsIgnoreCase(action)) {
			businessName = (String) request.getSession().getAttribute("Bname");
			businessBranch = (String) request.getSession().getAttribute(
					"Bbranch");

			request.setAttribute("BusinessName", businessName);
			request.setAttribute("BusinessBranch", businessBranch);

			RequestDispatcher rd = request
					.getRequestDispatcher("jsp/PersonalPartyRegistrationSummary.jsp");
			rd.forward(request, response);
			
			logger.info("Exit from update acoount party contact details");


		}
		
		else if ("Cancel_party_updationAftReg".equalsIgnoreCase(action)) {
			businessName = (String) request.getSession().getAttribute("Bname");
			businessBranch = (String) request.getSession().getAttribute(
					"Bbranch");

			PersonalPartyCoreAddressContactDetails partyDetails = new PersonalPartyCoreAddressContactDetails();
			partyDetails=(PersonalPartyCoreAddressContactDetails)request.getSession().getAttribute("PartyWholeDetails");

			request.setAttribute("BusinessName", businessName);
			request.setAttribute("BusinessBranch", businessBranch);
			request.setAttribute("PartyDetails", partyDetails);
			RequestDispatcher rd = request
					.getRequestDispatcher("jsp/PersonalPartyDetailsViewForUpdate.jsp");
			rd.forward(request, response);

			logger.info("Entry in update present address details after registration");
		}
		
	}
		
}

