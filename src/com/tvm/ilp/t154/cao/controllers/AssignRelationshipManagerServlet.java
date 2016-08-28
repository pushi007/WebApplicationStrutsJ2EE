package com.tvm.ilp.t154.cao.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tvm.ilp.t154.cao.exceptions.AccountCreationException;
import com.tvm.ilp.t154.cao.model.Branch;
import com.tvm.ilp.t154.cao.model.BusinessCustomer;
import com.tvm.ilp.t154.cao.model.NonPersonalParty;
import com.tvm.ilp.t154.cao.model.RelationshipManager;
import com.tvm.ilp.t154.cao.services.AccountServices;

import static com.tvm.ilp.t154.cao.constants.CAOConstants.*;

/**
 * Servlet implementation class AssignRelationshipManagerServlet
 */
public class AssignRelationshipManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public AccountServices accountservices = new AccountServices();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AssignRelationshipManagerServlet() {
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
		HttpSession session=null;
		NonPersonalParty nonpersonal = new NonPersonalParty();
		List<NonPersonalParty> nonpersonallist = new ArrayList<NonPersonalParty>();
		List<NonPersonalParty> nlist = new ArrayList<NonPersonalParty>();
       
		if (action.equals("searchRelManger")){
			response.sendRedirect(request.getContextPath()+"/jsp/SearchRelationshipManager.jsp");
		}
			
		// Searching BusinessCustomerDetails
		if (action.equals("BusinessDetails")) {
			// Searching by BusinessName
			
			request.getSession().removeAttribute("route");
			String route="route2";
			request.getSession().setAttribute("route", route);
			
			if (request.getParameter("businessName") !=null) 
			{
				String businessName = request.getParameter("businessName");
			    String bname=businessName.concat("%");
				try {
					nonpersonallist = accountservices.searchBusinessDetails(bname);
				} catch (AccountCreationException e) {
					String msg = e.getMessage();
					request.setAttribute("message", msg);
					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/ErrorPage.jsp");
					rd.forward(request, response);
				}

				if (nonpersonallist.size() == 0 && bname!=null) {
					String message = "NO MATCH FOUND";
					request.setAttribute("msg",message);
					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/SearchRelationshipManager.jsp");
					rd.forward(request, response);
				}

				else {
					request.setAttribute("nonpersonallist", nonpersonallist);
					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/ViewNonPersonalPartyDetails.jsp");
					rd.forward(request, response);

				}
			}

			// Searching by TradingName
			else if(request.getParameter("tradingName") !="") {
			   
				String tradingName= request.getParameter("tradingName");
				String tname=tradingName.concat("%");
				try {
					nlist = accountservices.search(tname);
				} catch (AccountCreationException e) {
					String msg = e.getMessage();
					request.setAttribute("message", msg);
					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/ErrorPage.jsp");
					rd.forward(request, response);
				}

				if (nlist.size() == 0 && tname!=null)

				{
					String message = "NO MATCH FOUND";
					request.setAttribute("msg", message);
					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/SearchRelationshipManager.jsp");
					rd.forward(request, response);
				} else {
					request.setAttribute("nonpersonallist", nlist);
					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/ViewNonPersonalParty.jsp");
					rd.forward(request, response);
				}
			}
		}
		
		
		else if (action.equals("RMassign")) {
		
			
				
				BusinessCustomer bc =(BusinessCustomer) request.getSession().getAttribute("bc");
				String businessName=bc.getBusinessName();
				try {
					nonpersonallist = accountservices
							.searchBusinessDetails(businessName);
				} catch (AccountCreationException e) {
					String msg = e.getMessage();
					request.setAttribute("message", msg);
					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/ErrorPage.jsp");
					rd.forward(request, response);
				}

				if (nonpersonallist.size() == 0) {
					String message = "NO MATCH FOUND";
					request.setAttribute("msg", message);
					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/SearchRelationshipManager.jsp");
					rd.forward(request, response);
				}

				else {
					request.setAttribute("nonpersonallist", nonpersonallist);
					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/ViewNonPersonalPartyDetails.jsp");
					rd.forward(request, response);

				}
			}

			
		

	
		
		

		// Searching particular Business customer by businessName and nonpersonalid
		else if (action.equals("show")) {

			if (request.getParameter("businessName") != null
					&& request.getParameter("npid") != null &&!request.getParameter("rmid").equals("0")) {
				String rmid=request.getParameter("rmid");
				long rmId=Long.parseLong(rmid);
				if(rmId!=0)
				{
				String businessName = request.getParameter("businessName");
				String npid = request.getParameter("npid");
				
				ArrayList<RelationshipManager> rmList = new ArrayList<RelationshipManager>();
				Branch b = new Branch();
				RelationshipManager rm = new RelationshipManager();
				Branch br = new Branch();
				int npId = Integer.parseInt(npid);
				try {
					nonpersonal = accountservices.searchNPParty(businessName,
							npId);
					b = accountservices.searchBranch(nonpersonal.getBranchId());
					rmList = accountservices.listOfManager(
							"Relationship Manager", nonpersonal.getBranchId());
					rm = accountservices
							.searchName(nonpersonal.getRmAssigned());
					br = accountservices.searchBranch(rm.getBranchId());
				} catch (AccountCreationException e) {
					String msg = e.getMessage();
					request.setAttribute("message", msg);
					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/ErrorPage.jsp");
					rd.forward(request, response);
				}
				request.setAttribute("nonpersonal", nonpersonal);
				request.setAttribute("branchName", b);
				request.setAttribute("brName", br);
				request.setAttribute("RMList", rmList);
				request.setAttribute("rm", rm);
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/ShowNonPersonalParty.jsp");
				rd.forward(request, response);
			
			}
				}
			else if (request.getParameter("businessName") != null
					&& request.getParameter("npid") != null && request.getParameter("rmid").equals("0")) {
				String rmid=request.getParameter("rmid");
				long rmId=Long.parseLong(rmid);
				if(rmId==0)
					{String businessName = request.getParameter("businessName");
				String npid = request.getParameter("npid");
				ArrayList<RelationshipManager> rmList = new ArrayList<RelationshipManager>();
				Branch b = new Branch();
				RelationshipManager rm = new RelationshipManager();
				Branch br = new Branch();
				int npId = Integer.parseInt(npid);
				try {
					nonpersonal = accountservices.searchNPParty(businessName,
							npId);
					b = accountservices.searchBranch(nonpersonal.getBranchId());
					rmList = accountservices.listOfManager(
							"Relationship Manager", nonpersonal.getBranchId());
					rm = accountservices
							.searchName(nonpersonal.getRmAssigned());
					br = accountservices.searchBranch(rm.getBranchId());
				} catch (AccountCreationException e) {
					String msg = e.getMessage();
					request.setAttribute("message", msg);
					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/ErrorPage.jsp");
					rd.forward(request, response);
				}
				request.setAttribute("nonpersonal", nonpersonal);
				request.setAttribute("branchName", b);
				request.setAttribute("brName", br);
				request.setAttribute("RMList", rmList);
				request.setAttribute("rm", rm);
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/ShowBusinessParty.jsp");
				rd.forward(request, response);
			}
			}
			// Searching particular Business customer by TradingName and nonpersonalid
			else if ( request.getParameter("npid") != null && !request.getParameter("rmid").equals("0")) {
						String rmid=request.getParameter("rmid");
						long rmId=Long.parseLong(rmid);
						if(rmId!=0)
						{
				//String tradingName = request.getParameter("tradingName");
				String npid = request.getParameter("npid");
				ArrayList<RelationshipManager> rmList = new ArrayList<RelationshipManager>();
				RelationshipManager rm = new RelationshipManager();
				Branch b = new Branch();
				Branch br = new Branch();
				int npId = Integer.parseInt(npid);
				try {
					nonpersonal = accountservices.searchNP(npId);
					b = accountservices.searchBranch(nonpersonal.getBranchId());
					rmList = accountservices.listOfManager(
							"Relationship Manager", nonpersonal.getBranchId());
					rm = accountservices
							.searchName(nonpersonal.getRmAssigned());
					br = accountservices.searchBranch(rm.getBranchId());
				} catch (AccountCreationException e) {
					String msg = e.getMessage();
					request.setAttribute("message", msg);
					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/ErrorPage.jsp");
					rd.forward(request, response);
				}
				request.setAttribute("nonpersonal", nonpersonal);
				request.setAttribute("branchName", b);
				request.setAttribute("brName", br);
				request.setAttribute("RMList", rmList);
				request.setAttribute("rm", rm);
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/ShowNonPersonalParty.jsp");
				rd.forward(request, response);

						}
						}
			else if ( request.getParameter("npid") != null && request.getParameter("rmid").equals("0")) {
				
				String rmid=request.getParameter("rmid");
				long rmId=Long.parseLong(rmid);
				if(rmId==0)
					{//String tradingName = request.getParameter("tradingName");
				String npid = request.getParameter("npid");
				ArrayList<RelationshipManager> rmList = new ArrayList<RelationshipManager>();
				RelationshipManager rm = new RelationshipManager();
				Branch b = new Branch();
				Branch br = new Branch();
				int npId = Integer.parseInt(npid);
				try {
					nonpersonal = accountservices.searchNP( npId);
					b = accountservices.searchBranch(nonpersonal.getBranchId());
					rmList = accountservices.listOfManager(
							"Relationship Manager", nonpersonal.getBranchId());
					rm = accountservices
							.searchName(nonpersonal.getRmAssigned());
					br = accountservices.searchBranch(rm.getBranchId());
				} catch (AccountCreationException e) {
					String msg = e.getMessage();
					request.setAttribute("message", msg);
					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/ErrorPage.jsp");
					rd.forward(request, response);
				}
				request.setAttribute("nonpersonal", nonpersonal);
				request.setAttribute("branchName", b);
				request.setAttribute("brName", br);
				request.setAttribute("RMList", rmList);
				request.setAttribute("rm", rm);
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/ShowBusinessParty.jsp");
				rd.forward(request, response);

			}
				}
		}

		// Changing Branch
		else if (action.equals("change")) {
			String npid = request.getParameter("nonpersonalid");

			List<Branch> bList = new ArrayList<Branch>();

			try {
				bList = accountservices.getBranch();
			} catch (AccountCreationException e) {
				String msg = e.getMessage();
				request.setAttribute("message", msg);
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/ErrorPage.jsp");
				rd.forward(request, response);
			}

			request.setAttribute("npid", npid);
			request.setAttribute("bList", bList);
			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/ChangeBranch.jsp");
			rd.forward(request, response);

		}

		// Assigning Relationship Manager of the same branch
		else if (action.equals("continue")) {
			String npid = request.getParameter("nonpersonalid");
			int npId = Integer.parseInt(npid);
			String branchName = request.getParameter("branchName");
			String managerid = request.getParameter("listOfManager");
			int rmid = Integer.parseInt(managerid);
			Branch b = new Branch();
			boolean flag = false;
		
			try {
				b = accountservices.searchBranchID(branchName);

				flag = accountservices.addEntry(rmid, npId);

			} catch (AccountCreationException e) {
				String msg = e.getMessage();
				request.setAttribute("message", msg);
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/ErrorPage.jsp");
				rd.forward(request, response);
			}
			if (flag == true) {

				String msg = "Relationship Manager has been assigned";
				request.setAttribute("msg", msg);
				request.setAttribute("npid", npId);
				request.setAttribute("bname", b.getBranchId());
				request.setAttribute("rm", rmid);
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/ViewassignManager.jsp");
				rd.forward(request, response);

			} else {
				flag = false;
			}

		}

		// Assigning Relationship Manager from different branch
		else if (action.equals("static")) {
			String npid = request.getParameter("npid");
			int npId = Integer.parseInt(npid);
			Branch b = new Branch();
			String branchName = request.getParameter("branchName");

			List<RelationshipManager> rmList = new ArrayList<RelationshipManager>();
			try {

				nonpersonal = accountservices.searchNPersonal(npId);
				b = accountservices.searchBranchID(branchName);

				rmList = accountservices.listOfManager("Relationship Manager",
						b.getBranchId());

			} catch (AccountCreationException e) {
				String msg = e.getMessage();
				request.setAttribute("message", msg);
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/ErrorPage.jsp");
				rd.forward(request, response);
			}

			request.setAttribute("npid", npId);
			request.setAttribute("bname", branchName);
			request.setAttribute("rmList", rmList);
			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/assignManager.jsp");
			rd.forward(request, response);

		}

		// Relationship Manager assigned
		/*else if (action.equals("assigned")) {
			String npid = request.getParameter("nonpersonalid");
			int npId = Integer.parseInt(npid);
			String branchName = request.getParameter("branchName");
			RelationshipManager rm = new RelationshipManager();
			String rmid = request.getParameter("listOfManager");
			long rmId = Long.parseLong(rmid);

			Branch b = new Branch();
			boolean flag = false;
			try {
				b = accountservices.searchBranchID(branchName);
				//flag = accountservices.addEntry(rmId, npId);

			}

			catch (AccountCreationException e) {
				String msg = e.getMessage();
				request.setAttribute("message", msg);
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/ErrorPage.jsp");
				rd.forward(request, response);
			}
			if (flag = true) {
				
				request.setAttribute("npid", npId);
				request.setAttribute("bname", b.getBranchId());
				request.setAttribute("rm", rmId);
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/ViewassignManager.jsp");
				rd.forward(request, response);

			} else {
				flag = false;
			}

		}*/
		// Relationship Manager assigned
		else if (action.equals("complete"))
		{  
			String npid=request.getParameter("nonpersonalid");
			int npId=Integer.parseInt(npid);
			String branchName = request.getParameter("branchName");
			
			String rmID = request.getParameter("listOfManager");
			
		    long rmId=Long.parseLong(rmID);
		    
			
			
			NonPersonalParty npp=new NonPersonalParty();
			String branchid=request.getParameter("branchId");
		
			RelationshipManager rm=new RelationshipManager();
			boolean flag=false;
			try {
				
				
				flag = accountservices.addEntry(rmId, npId);
				npp=accountservices.getBusinessDetails(npId);
				rm=accountservices.searchName(rmId);
			
				
			} catch (AccountCreationException e) {
				String msg = e.getMessage();
				request.setAttribute("message", msg);
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/ErrorPage.jsp");
				rd.forward(request, response);
			}
			if(flag=true)
			{
				request.setAttribute("npid",npId);
			}
			request.setAttribute("branchName", branchName);
			request.setAttribute("managerId",rmID);
			request.getSession().setAttribute("managername",rm);
			request.setAttribute("npp", npp);
			RequestDispatcher rd=request.getRequestDispatcher("/jsp/RelationshipManagerassigned.jsp");
			rd.forward(request,response);
		}
			
			
		
		//No change if Relationship Manager already assigned
	else if(action.equals("done"))
		{
			String businessName=request.getParameter("businessName");
			
			String tradingName=request.getParameter("tradingName");
			
			NonPersonalParty npersonal = new NonPersonalParty();
			
			String branchName=request.getParameter("branchname");
			String npid=request.getParameter("nonpersonalid");
			String rmanager=request.getParameter("rmanager");
		
				
				
						try {
							npersonal=accountservices.searchTrading(businessName);
						} 
						 catch (AccountCreationException e) {
							 String msg = e.getMessage();
								request.setAttribute("message", msg);
								RequestDispatcher rd = request
										.getRequestDispatcher("/jsp/ErrorPage.jsp");
								rd.forward(request, response);
						
						} 
						
					
			 
			request.setAttribute("businessName",businessName);
            request.setAttribute("tradingName",npersonal);
    
			request.setAttribute("branchname",branchName);
			request.setAttribute("npid",npid);
			request.setAttribute("rmanager",rmanager);
			RequestDispatcher rd=request.getRequestDispatcher("/jsp/RelationshipManager.jsp");
			rd.forward(request,response);
		}
		
		else if(action.equals("termsAndConditions"))
		{
			String r;
			r=(String) request.getSession().getAttribute("route");
			if(r.equals("route1"))
			{
				
			response.sendRedirect(request.getContextPath()
					+ "/jsp/TermsAndConditions.jsp");
			}
			else if(r.equals("route2"))
			{
				
				response.sendRedirect(request.getContextPath()
						+ "/jsp/RegistrationPortal.jsp");
			}
			
			}
		
	}

	

}
