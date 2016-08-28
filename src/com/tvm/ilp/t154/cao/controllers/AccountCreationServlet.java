package com.tvm.ilp.t154.cao.controllers;

import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import org.apache.catalina.util.URL;
import org.apache.log4j.Logger;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.org.apache.bcel.internal.classfile.SourceFile;
import com.tvm.ilp.t154.cao.bean.AccountcreationBean;
import com.tvm.ilp.t154.cao.exceptions.AccountCreationException;
import com.tvm.ilp.t154.cao.exceptions.ProductExpception;
import com.tvm.ilp.t154.cao.model.AddressDetails;
import com.tvm.ilp.t154.cao.model.BusinessCustomer;
import com.tvm.ilp.t154.cao.model.NonPersonalAccount;
import com.tvm.ilp.t154.cao.model.NonPersonalAccountInProgress;
import com.tvm.ilp.t154.cao.model.Product;
import com.tvm.ilp.t154.cao.services.AccountServices;
import com.tvm.ilp.t154.cao.services.ProductManagement;
import com.tvm.ilp.t154.cao.validator.AccountCreationValidator;

import static com.tvm.ilp.t154.cao.constants.CAOConstants.*;

/**
 * Servlet implementation class AccountCreationServlet
 */
public class AccountCreationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AccountServices accService = new AccountServices();
	private static Logger logger = Logger.getLogger(AccountCreationServlet.class);
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AccountCreationServlet() {
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
		HttpSession session=null;
		String action = request.getParameter(ACTION);
		boolean flag = false;
		
		if (action.equals("CreateAccountPage")) {
			
			String language = (String) request.getSession().getAttribute("lang");

			if ("English".equals(language)||language==null) {

				Locale locale = new Locale("en", "US");
				ResourceBundle rb = ResourceBundle
						.getBundle(
								"com.tvm.ilp.t154.cao.properties.MessagesBundle",
								locale);
				String keycreateh=rb.getString("keycreateh");
				String keyacctype=rb.getString("keyacctype");
				String keybtype=rb.getString("keybtype");
				String keycontinue=rb.getString("keycontinue");
				String keybusinessname=rb.getString("keybusinessname");
				 String keyfields=rb.getString("keyfields");
				 String keymandatory=rb.getString("keymandatory");
				 String keycacc=rb.getString("keycacc");
				 String keysacc=rb.getString("keysacc");
				 String keybrname=rb.getString("keybrname");
				 
				
				
				session=request.getSession();
				session.setAttribute("keycreateh",keycreateh );
				session.setAttribute("keyacctype", keyacctype);
				session.setAttribute("keybtype",keybtype );
				session.setAttribute("keycontinue",keycontinue );
session.setAttribute("keybusinessname",keybusinessname );
 session.setAttribute("keyfields",keyfields );
  session.setAttribute("keymandatory",keymandatory );
 session.setAttribute("keybrname",keybrname );
 session.setAttribute("keycacc",keycacc );
 session.setAttribute("keysacc",keysacc );
 
			
			RequestDispatcher rd = request
			.getRequestDispatcher("/jsp/CommertialAccCreation.jsp");
	rd.forward(request, response);
			
		}
			else if ("French".equals(language)) {
				Locale locale = new Locale("fr", "FR");
				ResourceBundle rb = ResourceBundle
						.getBundle(
								"com.tvm.ilp.t154.cao.properties.MessagesBundle",
								locale);
				String keycreateh=rb.getString("keycreateh");
				String keyacctype=rb.getString("keyacctype");
				String keybtype=rb.getString("keybtype");
				String keycontinue=rb.getString("keycontinue");
				String keybusinessname=rb.getString("keybusinessname");
				 String keyfields=rb.getString("keyfields");
				 String keymandatory=rb.getString("keymandatory");
				 String keycacc=rb.getString("keycacc");
				 String keysacc=rb.getString("keysacc");
				 String keybrname=rb.getString("keybrname");
				 
				
				
				session=request.getSession();
				session.setAttribute("keycreateh",keycreateh );
				session.setAttribute("keyacctype", keyacctype);
				session.setAttribute("keybtype",keybtype );
				session.setAttribute("keycontinue",keycontinue );
session.setAttribute("keybusinessname",keybusinessname );
 session.setAttribute("keyfields",keyfields );
  session.setAttribute("keymandatory",keymandatory );
 session.setAttribute("keybrname",keybrname );
 session.setAttribute("keycacc",keycacc );
 session.setAttribute("keysacc",keysacc );
 
 
				RequestDispatcher rd = request
				.getRequestDispatcher("/jsp/CommertialAccCreation.jsp");
		rd.forward(request, response);
			}
			else if ("Spanish".equals(language)) {
				Locale locale = new Locale("es", "ES");
				ResourceBundle rb = ResourceBundle
						.getBundle(
								"com.tvm.ilp.t154.cao.properties.MessagesBundle",
								locale);
				String keycreateh=rb.getString("keycreateh");
				String keyacctype=rb.getString("keyacctype");
				String keybtype=rb.getString("keybtype");
				String keycontinue=rb.getString("keycontinue");
				String keybusinessname=rb.getString("keybusinessname");
				 String keyfields=rb.getString("keyfields");
				 String keymandatory=rb.getString("keymandatory");
				 String keycacc=rb.getString("keycacc");
				 String keysacc=rb.getString("keysacc");
				 String keybrname=rb.getString("keybrname");
				 
				
				
				session=request.getSession();
				session.setAttribute("keycreateh",keycreateh );
				session.setAttribute("keyacctype", keyacctype);
				session.setAttribute("keybtype",keybtype );
				session.setAttribute("keycontinue",keycontinue );
session.setAttribute("keybusinessname",keybusinessname );
 session.setAttribute("keyfields",keyfields );
  session.setAttribute("keymandatory",keymandatory );
 session.setAttribute("keybrname",keybrname );
 session.setAttribute("keycacc",keycacc );
 session.setAttribute("keysacc",keysacc );
 

				RequestDispatcher rd = request
				.getRequestDispatcher("/jsp/CommertialAccCreation.jsp");
		rd.forward(request, response);
			}
			else if ("German".equals(language)) {
				Locale locale = new Locale("de", "DE");
				ResourceBundle rb = ResourceBundle
						.getBundle(
								"com.tvm.ilp.t154.cao.properties.MessagesBundle",
								locale);
				String keycreateh=rb.getString("keycreateh");
				String keyacctype=rb.getString("keyacctype");
				String keybtype=rb.getString("keybtype");
				String keycontinue=rb.getString("keycontinue");
				String keybusinessname=rb.getString("keybusinessname");
				 String keyfields=rb.getString("keyfields");
				 String keymandatory=rb.getString("keymandatory");
				 String keycacc=rb.getString("keycacc");
				 String keysacc=rb.getString("keysacc");
				 String keybrname=rb.getString("keybrname");
				 
				
				
				session=request.getSession();
				session.setAttribute("keycreateh",keycreateh );
				session.setAttribute("keyacctype", keyacctype);
				session.setAttribute("keybtype",keybtype );
				session.setAttribute("keycontinue",keycontinue );
session.setAttribute("keybusinessname",keybusinessname );
 session.setAttribute("keyfields",keyfields );
  session.setAttribute("keymandatory",keymandatory );
 session.setAttribute("keybrname",keybrname );
 session.setAttribute("keycacc",keycacc );
 session.setAttribute("keysacc",keysacc );
 
				RequestDispatcher rd = request
				.getRequestDispatcher("/jsp/CommertialAccCreation.jsp");
		rd.forward(request, response);
			}
		}
		else if (action.equals("CreateAccount")) {
			// Retrieving values from CommertialAccCreation.jsp

			// String AccountType = request.getParameter("AccountType");

			List<NonPersonalAccount> npaList = (List<NonPersonalAccount>) request
					.getSession().getAttribute("npaList");
			
			Product product=new Product();
			
			
			
			if (npaList == null) {
				npaList = new ArrayList<NonPersonalAccount>();
			}
			
			List<Product> pList=(List<Product>)request.getSession().getAttribute("pList");
			
			if(pList==null)
			{
				pList=new ArrayList<Product>();
			}
			String AccountType = (String) request.getSession().getAttribute(
					"AccountType");

			String productId = request.getParameter("ProductId");
			long pid = Long.parseLong(productId);

			BusinessCustomer bc = (BusinessCustomer) request.getSession()
					.getAttribute("bc");
			int npid = (int) bc.getNpId();

			long accNo=25000000;
			try {
				accNo = accService.getAccountNumber();
			} catch (AccountCreationException e) {
				String msg = e.getMessage();
				request.setAttribute("message", msg);
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/ErrorPage.jsp");
				rd.forward(request, response);
			}
			
			String branch=(String) request.getSession().getAttribute("branch");
			
			//
			NonPersonalAccount npa = new NonPersonalAccount(accNo, npid,
					AccountType, pid, "In Progress",branch);
			try {
				 product=accService.getProductName(pid);
			} catch (AccountCreationException e1) {
				String msg = e1.getMessage();
				request.setAttribute("message", msg);
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/ErrorPage.jsp");
				rd.forward(request, response);
			}
			
			
			String pName=product.getProductName();
			
			
			
			pList.add(product);
			
			
			npaList.add(npa);
			
			try {
				flag = accService.addBusinessCustAccount(npa);
			} catch (AccountCreationException e) {
				String msg = e.getMessage();
				request.setAttribute("message", msg);
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/ErrorPage.jsp");
				rd.forward(request, response);
			}

			if (flag == true) {
				
				
				request.getSession().setAttribute("pName",pName);
				request.getSession().setAttribute("pList",pList);
				request.getSession().setAttribute("npaList", npaList);
				
				
				// request.setAttribute("pList", pList);
				

				request.setAttribute("accNo", npa);

				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/AccountSummary.jsp");
				rd.forward(request, response);

				// response.sendRedirect(request.getContextPath()+"/jsp/AccountSummary.jsp");

			} else
				logger.info("Record Insertion faild");

		}

		else if (action.equals("CreateAccountNext")) {

			
			
			request.getSession().removeAttribute("route");
			String route="route1";
			request.getSession().setAttribute("route", route);
			List<Product> pList = new ArrayList<Product>();

			String AccountType = request.getParameter("AccountType");
			String branch=request.getParameter("branch");
			request.getSession().setAttribute("branch", branch);

			// String businessType = request.getParameter("businessType");
			AccountcreationBean bean = new AccountcreationBean();
			bean.setAccountType(AccountType);

			if (AccountCreationValidator.validate(bean).size() > 0) {
				request.setAttribute("errors", AccountCreationValidator
						.validate(bean));
				request.setAttribute("bean", bean);
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/CommertialAccCreation.jsp");
				rd.forward(request, response);
			} else {

				
				int count = 0;
				request.getSession().setAttribute("AccountType", AccountType);

				BusinessCustomer bc = (BusinessCustomer) request.getSession()
						.getAttribute("bc");
				
				String bName = bc.getBusinessType();

				
				try {

					// Implementing PEM
					pList = accService.sortProductPem(AccountType, bName);
				} catch (AccountCreationException e) {
					String msg = e.getMessage();
					request.setAttribute("message", msg);
					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/ErrorPage.jsp");
					rd.forward(request, response);
				}

				request.getSession().setAttribute("ProductList", pList);
				/*
				 * request.setAttribute("product", pList); RequestDispatcher
				 * rd=request.getRequestDispatcher(request.getContextPath()+
				 * "/jsp/ProductSelection.jsp"); rd.forward(request, response);
				 */
				
				//Code for country
				String country =bc.getCountry();
				long npid=bc.getNpId();
				
				if(country.equals("United Kingdom"))
				{

					response.sendRedirect(request.getContextPath()
							+ "/jsp/ProductSelection.jsp");
				}
				else
				{
					if(AccountType.equals("Savings Account"))
					{					   
						try {
							try {
								count= accService.getAccounts(AccountType, npid);
							} catch (AccountCreationException e) {
								String msg = e.getMessage();
								request.setAttribute("message", msg);
								RequestDispatcher rd = request
										.getRequestDispatcher("/jsp/ErrorPage.jsp");
								rd.forward(request, response);
							}
							if(count==0)
							{
								response.sendRedirect(request.getContextPath()
										+ "/jsp/ProductSelection.jsp");
							}
							else{
								response.sendRedirect(request.getContextPath()
										+ "/jsp/AccountLimitMessage.jsp");
								
							}
						
						} catch (SQLException e) {
							String msg = e.getMessage();
							request.setAttribute("message", msg);
							RequestDispatcher rd = request
									.getRequestDispatcher("/jsp/ErrorPage.jsp");
							rd.forward(request, response);
						}
											
					}// if savings
					
					else if(AccountType.equals("Current Account"))
					{
						
						try {
							try {
								count= accService.getAccounts(AccountType, npid);
							} catch (AccountCreationException e) {
								String msg = e.getMessage();
								request.setAttribute("message", msg);
								RequestDispatcher rd = request
										.getRequestDispatcher("/jsp/ErrorPage.jsp");
								rd.forward(request, response);
							}
							if(count==0)
							{
								response.sendRedirect(request.getContextPath()
										+ "/jsp/ProductSelection.jsp");
							}
							else{
								
							response.sendRedirect(request.getContextPath()
									+ "/jsp/AccountLimitMessage.jsp");
							}
						
						} catch (SQLException e) {
							String msg = e.getMessage();
							request.setAttribute("message", msg);
							RequestDispatcher rd = request
									.getRequestDispatcher("/jsp/ErrorPage.jsp");
							rd.forward(request, response);
						}
						
					}// else if
					
				}// UK if else
				
				
			}// CreateAccountNext
				// close session businessCust;
			
		} else if (action.equals("closeSession")) {
			System.out.println("session");

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
			request.getSession().removeAttribute("pList");
			
			
			response.sendRedirect(request.getContextPath()
					+ "/jsp/RegistrationPortal.jsp");
		}
		
		else if (action.equals("tandc")) {
			
			BusinessCustomer bc=(BusinessCustomer)request.getSession().getAttribute("bc");
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
			
			/*if(npal.size()==0)
			{
			
			}
			else
			{*/
				request.getSession().setAttribute("InProgressAccounts",npal);
								
				response.sendRedirect(request.getContextPath()+ "/jsp/TermsAndConditionsAfterRegistration.jsp");
			//}
		}

		else if (action.equals("accepttandc")) {
			List<NonPersonalAccountInProgress> npaList=(ArrayList<NonPersonalAccountInProgress>)request.getSession().getAttribute("InProgressAccounts");
			for(NonPersonalAccountInProgress n:npaList)
			{
				ProductManagement pm = new ProductManagement();
				try {
					boolean flag2= pm.activateAccount(n.getAccNumber());
				//	boolean flag2= pm.activateAccount(0);
				} catch (ProductExpception e) {
					String msg = e.getMessage();
					request.setAttribute("message", msg);
					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/ErrorPage.jsp");
					rd.forward(request, response);
				}
			}
			response.sendRedirect(request.getContextPath()+ "/jsp/WelComeLetterAfterReg.jsp");
		}
		
		else if (action.equals("rejecttandc")) {
		BusinessCustomer bc = new BusinessCustomer();
		bc=(BusinessCustomer) request.getSession().getAttribute("bc");
		
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
		
		else if (action.equals("saveaspdf")) 
		{
			List<NonPersonalAccountInProgress> npaList=(ArrayList<NonPersonalAccountInProgress>)request.getSession().getAttribute("InProgressAccounts");
            BusinessCustomer bc=(BusinessCustomer)request.getSession().getAttribute("bc"); 
            AddressDetails ad=(AddressDetails)request.getSession().getAttribute("address"); 
			
			response.setContentType("application/pdf"); 
			response.setHeader("Content-Disposition"," attachment; filename=\"example.pdf\"");
			
			Document document = new Document();
			try{
				PdfWriter.getInstance(document, 
					response.getOutputStream()); // Code 2
				document.open();
				
				
			
				Font fontbold = FontFactory.getFont("Arial", 20, Font.BOLD);
				Paragraph paragraph = new Paragraph("Welcome Letter",fontbold);
				paragraph.setAlignment(Element.ALIGN_CENTER);
				paragraph.setFont(fontbold);
				document.add(paragraph);
				
				paragraph = new Paragraph(bc.getBusinessName()+"\nCustomer ID:"+bc.getNpId()+"\nBusiness Address:"+ad.getBuildingNo()+","+ad.getBuildingName()+","+ad.getStreetName()+",\n"+ad.getTownName()+" "+ad.getCityName()+",\n"+ad.getCountry()+"-"+ad.getPostalCode()+"\nContact Number: "+ad.getCountryCode()+"-"+ad.getContactNumber()+"\n");
				paragraph.setAlignment(Element.ALIGN_LEFT);
				document.add(paragraph);
				paragraph = new Paragraph("\nThank you for choosing Nexus Banking Group for your Commercial account. We are confident that you will be satisfied with the services that we offer.The information enclosed will help you to make the most of our banking services. \n\n Account Details:\n\n");
				paragraph.setAlignment(Element.ALIGN_LEFT);

				document.add(paragraph);
	
				
				PdfPTable table = new PdfPTable(4);
				table.setWidthPercentage(90);
				table.setWidths(new int[] { 1, 1, 1, 1 });
				PdfPCell cell;
				
				cell = new PdfPCell(new Phrase("Account Number"));
				cell.setColspan(1);
				table.addCell(cell);
				cell = new PdfPCell(new Phrase("Account Type"));
				cell.setColspan(1);
				table.addCell(cell);
				cell = new PdfPCell(new Phrase("Product Name"));
				cell.setColspan(1);
				table.addCell(cell);
				cell = new PdfPCell(new Phrase("Branch "));
				cell.setColspan(1);
				table.addCell(cell);
				  
				for(NonPersonalAccountInProgress npaip:npaList)
				{
					cell = new PdfPCell(new Phrase(""+npaip.getAccNumber()));
					cell.setColspan(1);
					table.addCell(cell);
					cell = new PdfPCell(new Phrase(npaip.getAccountType()));
					cell.setColspan(1);
					table.addCell(cell);
					cell = new PdfPCell(new Phrase(npaip.getProductName()));
					cell.setColspan(1);
					table.addCell(cell);
					cell = new PdfPCell(new Phrase(npaip.getBranch()));
					cell.setColspan(1);
					table.addCell(cell);
				}
				
				
				document.add(table);	
			
				paragraph = new Paragraph("When you call us, please have it with you so that we can accelerate your requests. If your banking needs any change, we will be happy to help you assess those needs and offer you the banking services that will help you achieve your new goals. \nIf you have questions, please feel free contact us.\n\n Sincerely,\n\n\n");
				paragraph.setAlignment(Element.ALIGN_LEFT);
				document.add(paragraph);
				
		/*		String host =request.getRemoteHost();
			     String name=request.getContextPath();
			      
			     	System.out.println("link is :http://"+host+":8080/"+name+"/images/signature.png");
		      Image image = Image.getInstance(new URL("http://"+host+":8080/"+name+"/images/signature.png"));
		      image.setRotationDegrees(45f);
		      image.setWidthPercentage(30);
		      
		      document.add(image);
				  Image image = Image.getInstance("/images/signature.gif");
			      document.add(image);*/
				
				paragraph = new Paragraph("(Signature)\nMr.Andrew Brien\nBranch Manager\nNexus Banking Group");
				paragraph.setAlignment(Element.ALIGN_LEFT);
				document.add(paragraph);
				
				document.close(); 
				
			}catch(DocumentException e){
				e.printStackTrace();
			}
			
		}
	}

}