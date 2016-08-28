package com.tvm.ilp.t154.cao.controllers;

import java.io.ByteArrayInputStream;


import java.io.IOException;
import java.io.InputStream;

import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;

import org.example.productdetails.Productdetails;
import org.example.productdetails.Productdetails.Productdetail;
import org.w3c.dom.Document;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import com.tvm.ilp.t154.cao.utils.ConnectionUtil;;



/**
 * Servlet implementation class FileUploadServlet
 */
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(FileUploadServlet.class);
	
	boolean flag = true;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUploadServlet() {
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
		 boolean ismultipart = ServletFileUpload.isMultipartContent(request);
		 flag = true;
		 String contenttype = "";
		 request.getSession().removeAttribute("list");
		 byte[] bytesXml = null;
		
		 if(ismultipart){
			  
			  DiskFileItemFactory dskf = new DiskFileItemFactory();
			  ServletFileUpload sf = new ServletFileUpload(dskf);
			  
			  
			  try {
				  List<FileItem> list =   sf.parseRequest(request);
				
				  	Iterator<FileItem> it = list.iterator();
				
				  	while(it.hasNext())
				  	{
					
				  		FileItem ff = it.next();
					
				  		if(!ff.isFormField() && ff.getFieldName().equals("xml"))
				  		{
				  			contenttype = ff.getContentType();
				  			bytesXml =  ff.get();
						
				  			break;
						}
					}
				  	
				  	RequestDispatcher rd = request.getRequestDispatcher("/jsp/GroupofProducts.jsp");
					 if(bytesXml==null || 
							 (bytesXml.length==0 && !contenttype.equals("text/xml"))){
						   request.setAttribute("status", "Please upload xml file");
							rd.forward(request, response);
					 }else
					 if(!contenttype.equals("text/xml")){
						request.setAttribute("status", "Invalid file format, please upload  Xml files only");
						rd.forward(request, response);
					}else if(!validateXml(request,new ByteArrayInputStream(bytesXml))){
						request.setAttribute("status", "File contains invalid data, please verify the file");
						rd.forward(request, response);
					}else{
						/*Get the call Details in the form Call detail Object*/
						ByteArrayInputStream bis = new ByteArrayInputStream(bytesXml)	;
						
						List<Productdetail> listcalls = parseProductDetails(bis);		
						bis.close();
						request.getSession().setAttribute("list", listcalls);
						request.getSession().setAttribute("count", null);
						rd.forward(request, response);
						
						
					}
					
					 
						
			  	}
			  catch (FileUploadException e) {
				  log.error(e.getMessage());
				}
		 }
		 
		 
		 
	}
	
	
	//This method is used to parse call details
	public List<Productdetail> parseProductDetails(InputStream is)
	{
		    JAXBContext jc=null;
		    List<Productdetail> list=null;
			try {
				jc = JAXBContext.newInstance ("org.example.productdetails");
				 
				 Unmarshaller u = jc.createUnmarshaller ();
				 Productdetails element = (Productdetails) u.unmarshal (is);
		     
		         list =  element.getProductdetails();
		    
			
			} catch (JAXBException e) {
				log.error(e.getMessage());
			}
		return list;
	}
	
	//This method is used to validate XML file
	public boolean validateXml(HttpServletRequest request, InputStream is){
		 DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
		 
		 
		 
		    factory.setValidating(true);
		    factory.setNamespaceAware(true);		
		    
		    Document doc = null;  
		    factory.setAttribute(  
		    	    "http://java.sun.com/xml/jaxp/properties/schemaLanguage",  
		    	    "http://www.w3.org/2001/XMLSchema");  
		    	    factory.setAttribute(  
		    	    "http://java.sun.com/xml/jaxp/properties/schemaSource",  		    	    
		    	    "http://localhost:"+request.getLocalPort()+request.getContextPath()+"/xml/ProductDetails.xsd");  
		    	    try  
				    {  
				     
				    
				    DocumentBuilder parser = factory.newDocumentBuilder();  
				    parser.setErrorHandler(new ErrorHandler() {
						
						@Override
						public void warning(SAXParseException exception) throws SAXException {
							flag=false;
						
						}
						
						@Override
						public void fatalError(SAXParseException exception) throws SAXException {
							flag=false;
					
						}
						
						@Override
						public void error(SAXParseException exception) throws SAXException {
							flag=false;
						
						}
					});
				    doc = parser.parse(is);  
				
				    }  
		    	    catch (ParserConfigurationException e)  
				    {  flag=false;
		
				    log.info("xx"+e.getMessage());
				    }  
				    catch (SAXException e)  
				    {  flag=false;
			
				    log.info("ProductDetails.xml"+e.getMessage());
				    }  
				    catch (IOException e)  
				    {  
				    	log.info("sds"+e.getMessage());
			
				    flag=false; 
				    } 
				    log.info(flag);
		       
				    if(!flag){
				    	return false;
				    }else{
				    	return true;
				    }
	}
}

