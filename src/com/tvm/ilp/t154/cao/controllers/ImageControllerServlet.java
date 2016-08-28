package com.tvm.ilp.t154.cao.controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.tvm.ilp.t154.cao.bean.CustomerRegBean;
import com.tvm.ilp.t154.cao.model.Customers;
import com.tvm.ilp.t154.cao.model.FileDetails;

/**
 * Servlet implementation class ImageControllerServlet
 */
public class ImageControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);

		if(isMultipart)
		{
			
			DiskFileItemFactory itemfactory = new DiskFileItemFactory();
			ServletFileUpload fileupload = new ServletFileUpload(itemfactory);
			
			Map<String, Object> map = new HashMap<String, Object>();
		
			
			System.out.println("1111111111111111111111");
		

			try {
				
				
				List listitems =  fileupload.parseRequest(request);
				Iterator it = listitems.iterator();
		
		
				while(it.hasNext())
				{
					
					
					FileItem fileitem = (FileItem)it.next();
			                       
					if(fileitem.isFormField()){
					
						String name =   fileitem.getFieldName();
						String value = new String(fileitem.get());
						map.put(name, value);
		
						System.out.println("222222222222222222222222222");
					}
					else if(!fileitem.isFormField() ){
					
					
						BufferedImage bf = ImageIO.read(fileitem.getInputStream());
						    String name = fileitem.getFieldName();
						    String contenttype = fileitem.getContentType();
						    
						if(contenttype.equals("image/jpeg") || contenttype.equals("image/pjpeg"))
						{ 
							 
							    ByteArrayOutputStream bos = new ByteArrayOutputStream();
								ImageIO.write(bf, "jpeg", bos);
								byte[] image = bos.toByteArray();
								FileDetails details = new FileDetails();
								details.setContenttype(contenttype);
								details.setImage(image);
						
								map.put(name, details);
							
							
						}
					}
				}
				
				System.out.println("3333333333333333333333333");
				boolean flag=false;
                   CustomerRegBean customerbean=new CustomerRegBean();
                   BeanUtils.populate(customerbean, map);
                   
                   Customers customers=new Customers();
                   customers.setProofOfAddress(customerbean.getAddproof());
                   customers.setProofOfId(customerbean.getIdproof());
                   customers.setImage(customerbean.getImage());
                   customers.setImage1(customerbean.getImage1());
                   
                   request.getSession().setAttribute("npCustomerDetails", customers);
						
                   System.out.println("hi"+customers.getImage());
			}
			catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
			
			RequestDispatcher rd = request
			.getRequestDispatcher("/jsp/NonPersonalRegistraionSummary.jsp");
			rd.forward(request, response);

	}
		
	}
	
	}


