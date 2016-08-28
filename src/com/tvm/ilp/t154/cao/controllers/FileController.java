package com.tvm.ilp.t154.cao.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.log4j.Logger;
import org.example.productdetails.Productdetails;

import sun.security.x509.RDN;

import com.sun.org.apache.bcel.internal.generic.ALOAD;
import com.tvm.ilp.t154.cao.dao.ProductDAOImpl;
import com.tvm.ilp.t154.cao.exceptions.ProductExpception;
import com.tvm.ilp.t154.cao.services.ProductManagement;
/*
import com.tcs.ilp.tvm23.t135.otbes.bean.ConnectionBean;
import com.tcs.ilp.tvm23.t135.otbes.bean.FileBean;
import com.tcs.ilp.tvm23.t135.otbes.dao.CallDetailsDao;
import com.tcs.ilp.tvm23.t135.otbes.exception.duplicateCallDetailsException;
import com.tcs.ilp.tvm23.t135.otbes.manager.FileManager;
import com.tcs.ilp.tvm23.t135.otbes.model.Connection1;
import com.tcs.ilp.tvm23.t135.otbes.model.Customer;
import com.tcs.ilp.tvm23.t135.otbes.model.File;
import com.tcs.ilp.tvm23.t135.otbes.model.TariffPlan;
import com.tcs.ilp.tvm23.t135.otbes.util.DateUtil1;
import com.tcs.ilp.tvm23.t135.otbes.util.OTBESConstants;
import com.tcs.ilp.tvm23.t135.otbes.validator.CallDetailsSearchValidator;
import com.tcs.ilp.tvm23.t135.otbes.validator.CallDetailsValidator;
import com.tcs.ilp.tvm23.t135.otbes.validator.DeactivateConnectionValidator;
import com.tcs.ilp.tvm23.t135.otbes.validator.FileDetailsValidator;
*/
/**
 * Servlet implementation class FileController
 */
public class FileController extends HttpServlet {
	
	private static final Logger log = Logger.getLogger(FileController.class);

	private static final long serialVersionUID = 1L;
    //FileManager manager =new FileManager();  
    ProductDAOImpl pdDAO = new ProductDAOImpl(); 
    
    private ProductManagement pservice = new ProductManagement();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contextPath=request.getContextPath();
		String action =request.getParameter("action");
		HttpSession session = request.getSession();
		String role = (String) session.getAttribute("role");
		if(action.equals("uploadfile"))
		{
			/*
			HttpSession session2=request.getSession(false);
			session2.removeAttribute("list");*/
			
		response.sendRedirect(contextPath+ "");
			
		}
		else if(action.equals("submitdetails"))
		{
			boolean flag=false;
			List<Productdetails.Productdetail> list1 = (List<Productdetails.Productdetail>) request.getSession().getAttribute("list");
			
			//This method is used to add call details
			try 
			{
				for(int i=0;i<list1.size();i++)
				{
				flag=pservice.addProductDetails(list1.get(i));
				}	
			} 
			catch (ProductExpception e) 
			{

				request.setAttribute("msg",e.getMessage());
				RequestDispatcher rd=request.getRequestDispatcher("/jsp/Message.jsp");
				rd.forward(request, response);	
				
			} 
					
		
			
		
			if(flag)
			{
				RequestDispatcher rd=request.getRequestDispatcher("/jsp/Message.jsp");
				request.setAttribute("msg","Product details are added successfully." );
				rd.forward(request, response);	
			}
			
		}
		
		}
}
	


