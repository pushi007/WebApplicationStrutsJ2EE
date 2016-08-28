package com.tvm.ilp.t154.cao.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tvm.ilp.t154.cao.exceptions.AccountCreationException;
import com.tvm.ilp.t154.cao.model.AdditionalProduct;
import com.tvm.ilp.t154.cao.model.NonPersonalAccount;
import com.tvm.ilp.t154.cao.services.AccountServices;

import static com.tvm.ilp.t154.cao.constants.CAOConstants.*;

/**
 * Servlet implementation class AdditionalProductConfigServlet
 */
public class AdditionalProductConfigServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AccountServices accService = new AccountServices();
	private NonPersonalAccount account = new NonPersonalAccount();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdditionalProductConfigServlet() {
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

		// To search an Account Number
		if (action.equals("searchAccount")) {
			List<AdditionalProduct> pList = new ArrayList<AdditionalProduct>();
			String acc_number = request.getParameter("acc_number");
			long number = Long.parseLong(acc_number);

			try {
				account = accService.searchAccount(number);
				pList = accService.searchAdditionalProduct(account);
			} catch (AccountCreationException e) {
				String msg = e.getMessage();
				request.setAttribute("message", msg);
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/ErrorPage.jsp");
				rd.forward(request, response);
			}

			request.setAttribute("accNumber", acc_number);
			request.setAttribute("productId", account);
			request.getSession().setAttribute("productList", pList);
			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/AdditionalProductConfig.jsp");
			rd.forward(request, response);
		}
		// To get selected additional product details
		else if (action.equals("AdditionalProduct")) {
			List<AdditionalProduct> pList = new ArrayList<AdditionalProduct>();
			String acc_number = request.getParameter("account_Number");
			// long number=Long.parseLong(acc_number);
			String productId = request.getParameter("product_Id");
			String[] product = request.getParameterValues("additionalProduct");
				for (int i = 0; i < product.length; i++) {
					AdditionalProduct p = new AdditionalProduct();
					p.setName(product[i]);
					pList.add(p);
				}
				request.setAttribute("AccountNumber", acc_number);
				request.getSession().setAttribute("productName", product);
				request.getSession().setAttribute("productId", productId);
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/summaryOfAdditionalProduct.jsp");
				rd.forward(request, response);
			
			

		} else if (action.equals("editDetails")) {
			String acc_number = request.getParameter("acc_Number");
			// String productId=request.getParameter("productId");
			request.setAttribute("AccountNumber", acc_number);
			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/updateProductDetails.jsp");
			rd.forward(request, response);
		}
		else if(action.equals("UpdatedAdditionalProduct")){
			List<AdditionalProduct> pList = new ArrayList<AdditionalProduct>();
			String acc_number = request.getParameter("account_Number");
			// long number=Long.parseLong(acc_number);
			String productId = request.getParameter("product_Id");
			String[] product = request.getParameterValues("additionalProduct");
				for (int i = 0; i < product.length; i++) {
					AdditionalProduct p = new AdditionalProduct();
					p.setName(product[i]);
					pList.add(p);
				}
				request.setAttribute("AccountNumber", acc_number);
				request.getSession().setAttribute("productName", product);
				request.getSession().setAttribute("productId", productId);
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/summaryOfAdditionalProduct.jsp");
				rd.forward(request, response);
		}
		// To store assigned Additional Product
		else if (action.equals("AdditionalProductDetails")) {
			List<AdditionalProduct> pList = new ArrayList<AdditionalProduct>();
			boolean flag = false;
			int count = 0;
			String acc_number = request.getParameter("account_Number");
			long number = Long.parseLong(acc_number);
			String[] product = request.getParameterValues("additionalProduct");
				for (int i = 0; i < product.length; i++) {
					AdditionalProduct p = new AdditionalProduct();
					p.setName(product[i]);
					pList.add(p);
				}

				for (AdditionalProduct prod : pList) {
					try {
						flag = accService.addAdditionalProduct(prod.getName(),
								number);
					} catch (AccountCreationException e) {
						String msg = e.getMessage();
						request.setAttribute("message", msg);
						RequestDispatcher rd = request
								.getRequestDispatcher("/jsp/ErrorPage.jsp");
						rd.forward(request, response);
					}
					if (flag == true) {
						count++;
					}
				}
				if (count > 0) {
					String message = "Successfully applied for Additional Product";
					request.setAttribute("msg", message);
					request.getSession().removeAttribute("productName");
					request.getSession().removeAttribute("productId");
					request.getSession().removeAttribute("productList");
					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/ConfirmationPage.jsp");
					rd.forward(request, response);
				}
			

		} else if (action.equals("submitDetails")) {
			List<AdditionalProduct> pList = new ArrayList<AdditionalProduct>();
			boolean flag = false;
			int count = 0;
			String acc_number = request.getParameter("acc_Number");
			long number = Long.parseLong(acc_number);
			String[] product = (String[]) request.getSession().getAttribute(
					"productName");
			for (int i = 0; i < product.length; i++) {
				AdditionalProduct p = new AdditionalProduct();
				p.setName(product[i]);
				pList.add(p);
			}
			
			for (AdditionalProduct prod : pList) {
				try {
					flag = accService.addAdditionalProduct(prod.getName(),
							number);
					if (flag == true) {
						count++;
					}
				} catch (AccountCreationException e) {
					String msg = e.getMessage();
					request.setAttribute("message", msg);
					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/ErrorPage.jsp");
					rd.forward(request, response);
				}

			}
			if (count > 0) {
				String message = "Successfully applied for Additional Product";
				request.setAttribute("msg", message);
				request.getSession().removeAttribute("productName");
				request.getSession().removeAttribute("productId");
				request.getSession().removeAttribute("productList");
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/ConfirmationPage.jsp");
				rd.forward(request, response);
			}

		}

		else if (action.equals("applyForProduct")) {
			List<NonPersonalAccount> npaList = (List<NonPersonalAccount>) request.getSession().getAttribute("npaList");			
			boolean flag = false;
			String status = "Active";
			int count = 0;
			if(npaList!=null){
			for (NonPersonalAccount npa : npaList) {
				try {
					flag = accService.updateStatus(npa.getAccNumber(), status);
					if (flag == true) {
						count++;
					}
				} catch (AccountCreationException e) {
					String msg = e.getMessage();
					request.setAttribute("message", msg);
					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/ErrorPage.jsp");
					rd.forward(request, response);
				}
				
			}
			if (count > 0) {
				request.setAttribute("AccountList",npaList);
				RequestDispatcher rd=request.getRequestDispatcher("/jsp/WelcomeLetter.jsp");
				rd.forward(request, response);
			}
			}else{
				response.sendRedirect(request.getContextPath()+"/jsp/DefaultLetter.jsp");
			}

		}
		else if(action.equals("reject")){
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
			
			response.sendRedirect(request.getContextPath()
					+ "/jsp/RegistrationPortal.jsp");
		}
		else if(action.equals("exitProcess")){
			request.getSession().removeAttribute("npaList");
			response.sendRedirect(request.getContextPath()+"/jsp/RegistrationPortal.jsp");
		}

	}

}
