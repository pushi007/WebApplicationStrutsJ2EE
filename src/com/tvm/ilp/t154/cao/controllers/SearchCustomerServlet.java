package com.tvm.ilp.t154.cao.controllers;

import static com.tvm.ilp.t154.cao.constants.CAOConstants.ACTION;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tvm.ilp.t154.cao.exceptions.AccountCreationException;
import com.tvm.ilp.t154.cao.exceptions.ProductExpception;
import com.tvm.ilp.t154.cao.model.AddressDetails;
import com.tvm.ilp.t154.cao.model.Branch;
import com.tvm.ilp.t154.cao.model.BusinessCustomer;
import com.tvm.ilp.t154.cao.model.NonPersonalAccountInProgress;
import com.tvm.ilp.t154.cao.services.AccountServices;
import com.tvm.ilp.t154.cao.services.ProductManagement;

public class SearchCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<BusinessCustomer> searchList;

	AccountServices custService = new AccountServices();

	public SearchCustomerServlet() {

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		// Searching the Business Customer Details
		if (action.equals("searchCustomer")) {
			ArrayList<Branch> bList = new ArrayList<Branch>();
			try {
				bList = custService.getBranchList();
			} catch (AccountCreationException e) {
				String msg = e.getMessage();
				request.setAttribute("message", msg);
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/ErrorPage.jsp");
				rd.forward(request, response);
			} catch (SQLException e) {
				String msg = e.getMessage();
				request.setAttribute("message", msg);
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/ErrorPage.jsp");
				rd.forward(request, response);
			}

			request.getSession().setAttribute("branchList", bList);

			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/SearchCustomer.jsp");
			rd.forward(request, response);

		}

		else if (action.equalsIgnoreCase("SearchDetails")) {

			String bName = request.getParameter("bName1");
			String branch = request.getParameter("bbrName");

			String tName = request.getParameter("tName1");
			String tbranch = request.getParameter("tbrName");

			
			 String accno = request.getParameter("accno"); 
			 
			 
			 
			
			
			// By using Business name and branch
			if (bName != null && branch != "select") {
				String businessName= bName.concat("%");
				ArrayList<BusinessCustomer> blist = new ArrayList<BusinessCustomer>();
				try {
					blist = custService.searchByBusiness(businessName, branch);

				} catch (AccountCreationException e) {
					String msg = e.getMessage();
					request.setAttribute("message", msg);
					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/ErrorPage.jsp");
					rd.forward(request, response);
				}

				if (blist.size() == 0) {
					String message = "No record found";
					request.setAttribute("msg", message);
					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/SearchCustomer.jsp");
					rd.forward(request, response);

				} else if (blist.size() == 1) {
					BusinessCustomer bc = new BusinessCustomer();

					bc = blist.get(0);
					long npid = bc.getNpId();
					AddressDetails ad = new AddressDetails();
					
						try {
							ad = custService.getAddressDetails(npid);
						} catch (AccountCreationException e) {
							String msg = e.getMessage();
							request.setAttribute("message", msg);
							RequestDispatcher rd = request
									.getRequestDispatcher("/jsp/ErrorPage.jsp");
							rd.forward(request, response);
						}
					request.getSession().setAttribute("address", ad);

					List<NonPersonalAccountInProgress> npal = new ArrayList<NonPersonalAccountInProgress>();
					ProductManagement pm = new ProductManagement();
					try {
						npal = pm.getInProgressAccounts(bc.getNpId());
					} catch (ProductExpception e) {
						String msg = e.getMessage();
						request.setAttribute("message", msg);
						RequestDispatcher rd = request
								.getRequestDispatcher("/jsp/ErrorPage.jsp");
						rd.forward(request, response);
					}
					boolean AreInProgressAccounts=false;
					if(npal.size()==0)
					{
						AreInProgressAccounts=false;
					}
					else
					{
						AreInProgressAccounts=true;
					}	
					request.getSession().setAttribute("AreInProgressAccounts", AreInProgressAccounts);
					
					request.setAttribute("bc", bc);
					
					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/BusinessCustomerSummary.jsp");
					rd.forward(request, response);

				}

				else {
					request.setAttribute("blist", blist);
					/*
					 * String message="Multiple record found";
					 * request.setAttribute("msg",message);
					 */
					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/BusinessCustomerList.jsp");
					rd.forward(request, response);

				}
			}// Business name and Branch

			// search by treading name
			else if (tName != null && tbranch != "select") {
				
				String tradingName= tName.concat("%");
				ArrayList<BusinessCustomer> blist = new ArrayList<BusinessCustomer>();

				try {
					blist = custService.searchByTrading(tradingName, tbranch);
				} catch (AccountCreationException e) {
					String msg = e.getMessage();
					request.setAttribute("message", msg);
					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/ErrorPage.jsp");
					rd.forward(request, response);
				}

				if (blist.size() == 0) {
					String message = "No record found";
					request.setAttribute("msg", message);
					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/SearchCustomer.jsp");
					rd.forward(request, response);
				} else if (blist.size() == 1) {
					BusinessCustomer bc = new BusinessCustomer();

					bc = blist.get(0);

					long npid = bc.getNpId();
					AddressDetails ad = new AddressDetails();
					try {
						ad = custService.getAddressDetails(npid);
					} catch (AccountCreationException e) {
						String msg = e.getMessage();
						request.setAttribute("message", msg);
						RequestDispatcher rd = request
								.getRequestDispatcher("/jsp/ErrorPage.jsp");
						rd.forward(request, response);
					}

					List<NonPersonalAccountInProgress> npal = new ArrayList<NonPersonalAccountInProgress>();
					ProductManagement pm = new ProductManagement();
					try {
						npal = pm.getInProgressAccounts(bc.getNpId());
					} catch (ProductExpception e) {
						String msg = e.getMessage();
						request.setAttribute("message", msg);
						RequestDispatcher rd = request
								.getRequestDispatcher("/jsp/ErrorPage.jsp");
						rd.forward(request, response);
					}
					boolean AreInProgressAccounts=false;
					if(npal.size()==0)
					{
						AreInProgressAccounts=false;
					}
					else
					{
						AreInProgressAccounts=true;
					}	
					request.getSession().setAttribute("AreInProgressAccounts", AreInProgressAccounts);
					
					request.getSession().setAttribute("address", ad);

					request.setAttribute("bc", bc);
					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/BusinessCustomerSummary.jsp");
					rd.forward(request, response);

				}

				else {
					request.setAttribute("blist", blist);
					/*
					 * String message="Multiple record found";
					 * request.setAttribute("msg",message);
					 */
					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/BusinessCustomerList.jsp");
					rd.forward(request, response);

				}

			}

			else if (accno != "") {

				long accNumber = Long.parseLong(accno);
				BusinessCustomer bc = new BusinessCustomer();

				
					try {
						bc = custService.searchByAccountNo(accNumber);
					} catch (AccountCreationException e1) {
						String msg = e1.getMessage();
						request.setAttribute("message", msg);
						RequestDispatcher rd = request
								.getRequestDispatcher("/jsp/ErrorPage.jsp");
						rd.forward(request, response);
					}
				

				if (bc.getBusinessName()==null) {
					String message = "No record found";
					request.setAttribute("msg", message);
					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/SearchCustomer.jsp");
					rd.forward(request, response);
				} else  {
					
					long npid = bc.getNpId();
					AddressDetails ad = new AddressDetails();
					try {
						ad = custService.getAddressDetails(npid);
					} catch (AccountCreationException e) {
						String msg = e.getMessage();
						request.setAttribute("message", msg);
						RequestDispatcher rd = request
								.getRequestDispatcher("/jsp/ErrorPage.jsp");
						rd.forward(request, response);
					}

					List<NonPersonalAccountInProgress> npal = new ArrayList<NonPersonalAccountInProgress>();
					ProductManagement pm = new ProductManagement();
					try {
						npal = pm.getInProgressAccounts(bc.getNpId());
					} catch (ProductExpception e) {
						String msg = e.getMessage();
						request.setAttribute("message", msg);
						RequestDispatcher rd = request
								.getRequestDispatcher("/jsp/ErrorPage.jsp");
						rd.forward(request, response);
					}
					boolean AreInProgressAccounts=false;
					if(npal.size()==0)
					{
						AreInProgressAccounts=false;
					}
					else
					{
						AreInProgressAccounts=true;
					}	
					request.getSession().setAttribute("AreInProgressAccounts", AreInProgressAccounts);
					
					request.getSession().setAttribute("address", ad);

					request.setAttribute("bc", bc);
					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/BusinessCustomerSummary.jsp");
					rd.forward(request, response);

				}

			}

		}// action search details

		// Displaying Summary of Business
		else if (action.equals("bcsearch")) {
			BusinessCustomer bc = new BusinessCustomer();

			bc.setBranchName(request.getParameter("brn"));
			bc.setBusinessName(request.getParameter("bn"));
			bc.setTradingName(request.getParameter("tr"));
			bc.setEmail(request.getParameter("email"));
			bc.setBusinessType(request.getParameter("bt"));
			bc.setNpId(Long.parseLong(request.getParameter("npid")));
			bc.setCountry(request.getParameter("country"));

			long npid = bc.getNpId();
			AddressDetails ad = new AddressDetails();
			try {
				ad = custService.getAddressDetails(npid);
			} catch (AccountCreationException e) {
				String msg = e.getMessage();
				request.setAttribute("message", msg);
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/ErrorPage.jsp");
				rd.forward(request, response);
			}
			List<NonPersonalAccountInProgress> npal = new ArrayList<NonPersonalAccountInProgress>();
			ProductManagement pm = new ProductManagement();
			try {
				npal = pm.getInProgressAccounts(bc.getNpId());
			} catch (ProductExpception e) {
				String msg = e.getMessage();
				request.setAttribute("message", msg);
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/ErrorPage.jsp");
				rd.forward(request, response);
			}
			boolean AreInProgressAccounts=false;
			if(npal.size()==0)
			{
				AreInProgressAccounts=false;
			}
			else
			{
				AreInProgressAccounts=true;
			}	
			request.getSession().setAttribute("AreInProgressAccounts", AreInProgressAccounts);
			request.getSession().setAttribute("address", ad);
			// request.getSession().setAttribute("businessCust", bc);
			request.setAttribute("bc", bc);
			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/BusinessCustomerSummary.jsp");
			rd.forward(request, response);
		}

	}

}
