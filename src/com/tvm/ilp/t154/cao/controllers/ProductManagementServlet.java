package com.tvm.ilp.t154.cao.controllers;

import java.io.IOException;


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

import com.tvm.ilp.t154.cao.exceptions.ProductExpception;
import com.tvm.ilp.t154.cao.model.AdditionalProduct;
import com.tvm.ilp.t154.cao.model.BusinessType;
import com.tvm.ilp.t154.cao.model.NonPersonalAccount;
import com.tvm.ilp.t154.cao.model.Product;
import com.tvm.ilp.t154.cao.services.ProductManagement;

/**
 * Servlet implementation class ProductManagementServlet
 */
public class ProductManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	private ProductManagement pservice = new ProductManagement();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		String action = request.getParameter("action");

		// TODO Add Products
	if(action.equals("home"))
		{
			response
			.sendRedirect(request.getContextPath() + "/jsp/EmployeePortal.jsp");
		}
		
		

	else if (action.equals("addProduct")) {
				
				
				String language = (String) request.getSession().getAttribute("lang");

				if ("English".equals(language)||language==null) {

					Locale locale = new Locale("en", "US");
					ResourceBundle rb = ResourceBundle
							.getBundle(
									"com.tvm.ilp.t154.cao.properties.MessagesBundle",
									locale);
					
					String keyh=rb.getString("keyh");
					String keysh=rb.getString("keysh");
					String keysp=rb.getString("keysp");
					String keymp=rb.getString("keymp");
					String keysubmit=rb.getString("keysubmit");
					session=request.getSession();
					session.setAttribute("keyh" ,keyh );
					session.setAttribute("keysh" ,keysh );
					session.setAttribute("keysp",keysp );
					session.setAttribute("keymp",keymp );
					session.setAttribute("keysubmit",keysubmit );
					
					
					RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/Product.jsp");
			rd.forward(request, response);
			}
				else if ("French".equals(language)) {
					Locale locale = new Locale("fr", "FR");
					ResourceBundle rb = ResourceBundle
							.getBundle(
									"com.tvm.ilp.t154.cao.properties.MessagesBundle",
									locale);
					
					String keyh=rb.getString("keyh");
					String keysh=rb.getString("keysh");
					String keysp=rb.getString("keysp");
					String keymp=rb.getString("keymp");
					String keysubmit=rb.getString("keysubmit");
					session=request.getSession();
					session.setAttribute("keyh" ,keyh );
					session.setAttribute("keysh" ,keysh );
					session.setAttribute("keysp",keysp );
					session.setAttribute("keymp",keymp );
					session.setAttribute("keysubmit",keysubmit );
					
					
					RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/Product.jsp");
			rd.forward(request, response);
			}
				 else if ("Spanish".equals(language)) {
						Locale locale = new Locale("es", "ES");
						ResourceBundle rb = ResourceBundle
								.getBundle(
										"com.tvm.ilp.t154.cao.properties.MessagesBundle",
										locale);

						String keyh=rb.getString("keyh");
						String keysh=rb.getString("keysh");
						String keysp=rb.getString("keysp");
						String keymp=rb.getString("keymp");
						String keysubmit=rb.getString("keysubmit");
						session=request.getSession();
						session.setAttribute("keyh" ,keyh );
						session.setAttribute("keysh" ,keysh );
						session.setAttribute("keysp",keysp );
						session.setAttribute("keymp",keymp );
						session.setAttribute("keysubmit",keysubmit );
						
						
						RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/Product.jsp");
				rd.forward(request, response);
				}
				 else if ("German".equals(language)) {
						Locale locale = new Locale("de", "DE");
						ResourceBundle rb = ResourceBundle
								.getBundle(
										"com.tvm.ilp.t154.cao.properties.MessagesBundle",
										locale);
						String keyh=rb.getString("keyh");
						String keysh=rb.getString("keysh");
						String keysp=rb.getString("keysp");
						String keymp=rb.getString("keymp");
						String keysubmit=rb.getString("keysubmit");
						session=request.getSession();
						session.setAttribute("keyh" ,keyh );
						session.setAttribute("keysh" ,keysh );
						session.setAttribute("keysp",keysp );
						session.setAttribute("keymp",keymp );
						session.setAttribute("keysubmit",keysubmit );
						
						
						RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/Product.jsp");
				rd.forward(request, response);
				}
			} 

		// TODO Add single or group of products
		else if (action.equals("ProductLi")) {
			String name = request.getParameter("Products");

			if (name.equals("Single product")) {
				List<BusinessType> businessList = new ArrayList<BusinessType>();

				try {
					businessList = pservice.viewbusinesstype();
				} catch (ProductExpception e) {
					String message = e.getMessage();
					// Direct Dispatching
					request.setAttribute("msg", message);

					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/Message.jsp");
					rd.forward(request, response);

				}

				request.getSession().setAttribute("businessList", businessList);
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/AddProducts.jsp");
				rd.forward(request, response);
			} else {
				response.sendRedirect(request.getContextPath()
						+ "/jsp/GroupofProducts.jsp");

			}

		}

		//TODO Add a single product
		else if (action.equals("ProductDetails")) {
			List<AdditionalProduct> pList = new ArrayList<AdditionalProduct>();
			List<BusinessType> businessList = new ArrayList<BusinessType>();
			Product p = new Product();

			String productId = request.getParameter("ProductId");
			p.setProductID(Long.parseLong(productId));
			p.setProductName(request.getParameter("ProductName"));
			p.setProductDescription(request.getParameter("ProductDescription"));
			p.setAccountType(request.getParameter("AccoutnType"));
			p.setProductStatus(request.getParameter("ProductStatus"));
			p.setProductValidFrom(request.getParameter("ValidFrom"));
			String[] business = request.getParameterValues("BusinessType");
			for (int i = 0; i < business.length; i++) {
				BusinessType bt = new BusinessType();
				bt.setBusinessType_name(business[i]);
				businessList.add(bt);

			}
			
			

			try {
				pList = pservice.viewAdditionalProd();
			} catch (ProductExpception e) {
				String message = e.getMessage();
				// Direct Dispatching
				request.setAttribute("msg", message);

				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/Message.jsp");
				rd.forward(request, response);

			}
			request.getSession().setAttribute("product", p);
			request.getSession().setAttribute("bList", businessList);
			request.getSession().setAttribute("Additional", pList);
			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/ProdcutList.jsp");
			rd.forward(request, response);
		}

		//TODO Add Additional Product for a product
		else if (action.equals("ProductListDetails")) {
			String operationType = request.getParameter("Product");

			List<AdditionalProduct> plists = new ArrayList<AdditionalProduct>();
			String[] aproduct = request.getParameterValues("AProduct");
			for (int i = 0; i < aproduct.length; i++) {
				AdditionalProduct ap = new AdditionalProduct();
				ap.setName(aproduct[i]);
				plists.add(ap);
			}

			boolean flag = false;
			int count = 0;
			int count1 = 0;
			boolean flag1 = false;
			boolean flag2 = false;
			boolean flag3 = false;
			Product p = new Product();
			List<AdditionalProduct> productList = null;
			List<BusinessType> businessTypeList = null;

			p = (Product) request.getSession().getAttribute("product");
			businessTypeList = (ArrayList<BusinessType>) request.getSession()
					.getAttribute("bList");

			try {
				flag = pservice.addProduct(p);
				for (BusinessType bt : businessTypeList) {
					flag1 = pservice.businessproduct(bt.getBusinessType_name(),
							p.getProductID());
					if (flag1 == true) {
						count++;
					}
				}
				for (AdditionalProduct prod : plists) {
					flag2 = pservice.addProduct(prod.getName(), p
							.getProductID());
					if (flag2 == true) {
						count1++;
					}
				}
			} catch (ProductExpception e) {
				String message = e.getMessage();
				request.setAttribute("msg", message);
				RequestDispatcher rd = request.getRequestDispatcher("/jsp/AddProducts.jsp");
				rd.forward(request, response);

			}
			if((flag == true) && (count > 0) && (count1) > 0)
			{
				flag3 = true;
				
			}
			if (flag3 == true) 
			{
				String message="Product has been added successfully";
				request.setAttribute("msg", message);
				request.getSession().setAttribute("apd", plists);
				RequestDispatcher rd = request.getRequestDispatcher("/jsp/ProductSummery.jsp");
				rd.forward(request, response);

			}
		}

		//TODO Product summary
		else if (action.equalsIgnoreCase("AdditionalProductListDetails")) {

			response.sendRedirect(request.getContextPath()
					+ "/jsp/EditProduct.jsp");

		}

		//TODO Edit added product & submit
		else if (action.equalsIgnoreCase("TotalProductDetails")) {

			boolean flag = false;
			int count = 0;
			int count1 = 0;
			boolean flag1 = false;
			boolean flag2 = false;
			boolean flag3 = false;
			boolean flag4 = false;
			boolean flag5 = false;
			List<AdditionalProduct> pList = new ArrayList<AdditionalProduct>();
			ArrayList<BusinessType> businessList = new ArrayList<BusinessType>();

			String productId = request.getParameter("ProductId");
			long Productid = Long.parseLong(productId);
			String productName = request.getParameter("ProductName");
			String productDescription = request
					.getParameter("ProductDescription");
			String accountType = request.getParameter("AccoutnType");
			String productStatus = request.getParameter("ProductStatus");
			String validFrom = request.getParameter("ValidFrom");
			String[] businessTypeName = request
					.getParameterValues("BusinessType");
			String[] adproduct = request
					.getParameterValues("AdditionalProduct");
			for (int i = 0; i < businessTypeName.length; i++) {
				BusinessType b = new BusinessType();
				b.setBusinessType_name(businessTypeName[i]);
				businessList.add(b);
			}

			for (int i = 0; i < adproduct.length; i++) {
				AdditionalProduct p = new AdditionalProduct();
				p.setName(adproduct[i]);
				pList.add(p);
			}

			Product product = new Product(Productid, productName,
					productDescription, accountType, productStatus, validFrom);

			try {

				flag = pservice.addUpdatedProduct(product);
				flag1 = pservice.deleteProductList(Productid);
				for (AdditionalProduct prod : pList) {
					flag2 = pservice.addupdatedAdditionalProduct(
							prod.getName(), Productid);
					if (flag2 == true) {
						count++;
					}
				}
				flag3 = pservice.deleteBusinessType(Productid);
				for (BusinessType bt : businessList) {
					flag4 = pservice.businessproduct(bt.getBusinessType_name(),
							Productid);
					if (flag4 = true) {
						count1++;
					}

				}

			} catch (ProductExpception e) {
				String message = e.getMessage();
				// Direct Dispatching
				request.setAttribute("msg", message);

				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/Message.jsp");
				rd.forward(request, response);

			}

			if ((flag == true) && flag1 == true && (count > 0) && flag3 == true
					&& (count1 > 0)) {
				flag5 = true;
			}
			if (flag5 == true) {

				String message = "Product has been updated successfully";
				// Direct Dispatching
				request.setAttribute("msg", message);
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/messagess.jsp");
				rd.forward(request, response);

				// closeing session Add product
				request.getSession().removeAttribute("businessList");
				request.getSession().removeAttribute("product");
				request.getSession().removeAttribute("bList");
				request.getSession().removeAttribute("Additional");
				request.getSession().removeAttribute("apd");
			}

		}

		//TODO Product List
		else if (action.equals("ViewProduct")) {
			List<Product> plist = new ArrayList<Product>();

			try {
				plist = pservice.vieProductList();
			} catch (ProductExpception e) {
				String message = e.getMessage();
				// Direct Dispatching
				request.setAttribute("msg", message);
				RequestDispatcher rd = request.getRequestDispatcher("/jsp/Message.jsp");
				rd.forward(request, response);
				
			}

			request.setAttribute("plist", plist);
			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/ProductUpdate.jsp");
			rd.forward(request, response);

		}

		//TODO search product for update
		else if (action.equalsIgnoreCase("searchProductId")) {

			String productids = request.getParameter("productid");
			long productsId = Long.parseLong(productids);

			Product product = new Product();
			List<BusinessType> bList = new ArrayList<BusinessType>();
			List<AdditionalProduct> apList = new ArrayList<AdditionalProduct>();

			
			try {
				product = pservice.searchProductID(productsId);
				bList = pservice.viewbusinesstypeList(productsId);
				apList = pservice.viewAdditionalProdList(productsId);

			} catch (ProductExpception e) {
				String message = e.getMessage();
				// Direct Dispatching
				request.setAttribute("msg", message);

				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/Message.jsp");
				rd.forward(request, response);

			}

			if (product.getProductName() != null) {
				request.getSession().setAttribute("products", product);
				request.getSession().setAttribute("busines", bList);
				request.getSession().setAttribute("AddProducts", apList);
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/StaticUpdateDetails.jsp");
				rd.forward(request, response);
			} else {
				String message = "Product not found in our record.Please check the Product ID you have entered";
				request.setAttribute("msg", message);

				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/messagess.jsp");

				
				rd.forward(request, response);
			}
		}

		//TODO Summary of searched product
		else if (action.equalsIgnoreCase("updatedProductDetailsList")) {
			String productOperation = request
					.getParameter("selectedSingleProduct");
			if (productOperation.equalsIgnoreCase("updateSingleSelected")) 
			{
				List<BusinessType> bTypeList = new ArrayList<BusinessType>();
				List<AdditionalProduct> aProductsList = new ArrayList<AdditionalProduct>();
				
				try {

					bTypeList = pservice.viewbusinesstype();
					try {
						aProductsList = pservice.viewAdditionalProd();
					} catch (ProductExpception e) {
						String message = e.getMessage();
						// Direct Dispatching
						request.setAttribute("msg", message);

						RequestDispatcher rd = request
								.getRequestDispatcher("/jsp/Message.jsp");
						rd.forward(request, response);

					}

				} catch (ProductExpception e) {
					String message = e.getMessage();
					// Direct Dispatching
					request.setAttribute("msg", message);

					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/Message.jsp");
					rd.forward(request, response);

				}

				request.getSession().setAttribute("business", bTypeList);
				request.getSession().setAttribute("AddProduct", aProductsList);
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/EditedProduct.jsp");
				rd.forward(request, response);
			} 
			else if (productOperation.equalsIgnoreCase("deleteSingleSelected")) {
				boolean flag = false;
				boolean flag1 = false;
				boolean flag2 = false;
				String productid = request.getParameter("productId");
				long productId = Long.parseLong(productid);
				List<NonPersonalAccount> npaList=new ArrayList<NonPersonalAccount>();

				
				try {
					npaList=pservice.deleteSearchProducts(productId);
				} catch (ProductExpception e1) {
					String message = e1.getMessage();
					// Direct Dispatching
					request.setAttribute("msg", message);
					RequestDispatcher rd = request.getRequestDispatcher("/jsp/Message.jsp");
					rd.forward(request, response);
				}

				
				if(npaList.size()>0)
				{
					String message="Product cannot be deleted as it has been already assigned to customer.";
					request.setAttribute("msg", message);
					request.setAttribute("npList", npaList);
					RequestDispatcher rd = request.getRequestDispatcher("/jsp/Messages.jsp");
					rd.forward(request, response);
				}
			
				else
				{
				try {

					flag = pservice.deleteProductList(productId);
					flag1 = pservice.deleteBusinessType(productId);
					flag2 = pservice.deleteProducts(productId);
				} catch (ProductExpception e) {
					String message = e.getMessage();
					// Direct Dispatching
					request.setAttribute("msg", message);

					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/Message.jsp");
					rd.forward(request, response);

				}

				if (flag1 == true && flag2 == true&&flag==true) {
					String message = "Product has been deleted successfully ";
					request.setAttribute("msg", message);
					RequestDispatcher rd = request.getRequestDispatcher("/jsp/messagess.jsp");
					rd.forward(request, response);
				}

				}
			}

			}
		

		//TODO Update searched product
		else if (action.equalsIgnoreCase("updatedProductDetails")) {
			boolean flag = false;
			int count = 0;
			int count1 = 0;
			boolean flag1 = false;
			boolean flag2 = false;
			boolean flag3 = false;
			boolean flag4 = false;
			boolean flag5 = false;
			List<AdditionalProduct> pList = new ArrayList<AdditionalProduct>();
			ArrayList<BusinessType> businessList = new ArrayList<BusinessType>();

			String productId = request.getParameter("ProductId");
			long Productid = Long.parseLong(productId);
			String productName = request.getParameter("ProductName");
			String productDescription = request
					.getParameter("ProductDescription");
			String accountType = request.getParameter("AccoutnType");
			String productStatus = request.getParameter("ProductStatus");
			String validFrom = request.getParameter("ValidFrom");
			String[] businessTypeName = request
					.getParameterValues("BusinessType");
			String[] adproduct = request.getParameterValues("AProduct");
			for (int i = 0; i < businessTypeName.length; i++) {
				BusinessType b = new BusinessType();
				b.setBusinessType_name(businessTypeName[i]);
				businessList.add(b);
			}

			for (int i = 0; i < adproduct.length; i++) {
				AdditionalProduct p = new AdditionalProduct();
				p.setName(adproduct[i]);
				pList.add(p);
			}

			Product product = new Product(Productid, productName,
					productDescription, accountType, productStatus, validFrom);

			try {

				flag = pservice.addUpdatedProduct(product);
				flag1 = pservice.deleteProductList(Productid);
				for (AdditionalProduct prod : pList) {
					flag2 = pservice.addupdatedAdditionalProduct(
							prod.getName(), Productid);
					if (flag2 == true) {
						count++;
					}
				}
				flag3 = pservice.deleteBusinessType(Productid);
				for (BusinessType bt : businessList) {
					flag4 = pservice.businessproduct(bt.getBusinessType_name(),
							Productid);
					if (flag4 = true) {
						count1++;
					}

				}

			} catch (ProductExpception e) {
				String message = e.getMessage();
				// Direct Dispatching
				request.setAttribute("msg", message);

				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/Message.jsp");
				rd.forward(request, response);

			}

			if ((flag == true) && flag1 == true && (count > 0) && flag3 == true
					&& (count1 > 0)) {
				flag5 = true;
			}
			if (flag5 == true) {

				request.setAttribute("flag","true");

				if (product.getProductName() != null) {
					request.getSession().setAttribute("products", product);
					request.getSession().setAttribute("busines", businessList);
					request.getSession().setAttribute("AddProducts", pList);
					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/StaticUpdateDetails.jsp");
					rd.forward(request, response);
				} else {
					String message = "Product not found in our record.Please check the Product ID you have entered";
					request.setAttribute("msg", message);

					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/messagess.jsp");

					
					rd.forward(request, response);
				}
				
				
			}
		}
		else if("confirm".equalsIgnoreCase(action)){

			String message = "Product has been updated successfully";
			// Direct Dispatching
			request.setAttribute("msg", message);
			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/messagess.jsp");
			rd.forward(request, response);

			// closeing session search and update product
			request.getSession().removeAttribute("products");
			request.getSession().removeAttribute("busines");
			request.getSession().removeAttribute("AddProducts");
			request.getSession().removeAttribute("business");
			request.getSession().removeAttribute("AddProduct");
		}

		//TODO Multiple product list for update
		else if (action.equals("UpdateProductList")) {
			String operationType = request.getParameter("selectedProduct");

			if (operationType.equalsIgnoreCase("updateSelected")) {

				List<Product> produ = new ArrayList<Product>();
				String[] product = request.getParameterValues("ProductIdList");
				Long[] productId;
				productId = new Long[product.length];

				for (int i = 0; i < product.length; i++) {
					Product prod = new Product();
					productId[i] = Long.parseLong(product[i]);
					prod.setProductID(productId[i]);
					produ.add(prod);

				}
				if(produ.size()>1)
				{
					response.sendRedirect(request.getContextPath()+"/jsp/updateConfirmation.jsp");
					
				}
				else
				{
					
					Product products = new Product();
					List<BusinessType> bList = new ArrayList<BusinessType>();
					List<AdditionalProduct> apList = new ArrayList<AdditionalProduct>();
					List<BusinessType> businessList = new ArrayList<BusinessType>();
					List<AdditionalProduct> aProductList = new ArrayList<AdditionalProduct>();

					for(Product p:produ)
					{
						
					try {
						products = pservice.searchProductID(p.getProductID());
						bList = pservice.viewbusinesstype();
						apList = pservice.viewAdditionalProd();
						businessList = pservice.viewbusinesstypeList(p.getProductID());
						aProductList = pservice.viewAdditionalProdList(p.getProductID());

					} catch (ProductExpception e) {
						String message = e.getMessage();
						// Direct Dispatching
						request.setAttribute("msg", message);

						RequestDispatcher rd = request
								.getRequestDispatcher("/jsp/Message.jsp");
						rd.forward(request, response);

					}
					}
					request.setAttribute("product", products);
					request.setAttribute("business", bList);
					request.setAttribute("businesType", businessList);
					request.setAttribute("AddProduct", apList);
					request.setAttribute("AddProductList", aProductList);
					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/updatedProduct.jsp");
					rd.forward(request, response);

				}
			}

			else if (operationType.equalsIgnoreCase("deleteSelected")) {
				List<Product> products = new ArrayList<Product>();
				String[] product = request.getParameterValues("ProductIdList");
				Long[] productId;
				productId = new Long[product.length];
				List<NonPersonalAccount> npaList=new ArrayList<NonPersonalAccount>();
				boolean flag = false;
				boolean flag1 = false;
				boolean flag2 = false;

				for (int i = 0; i < product.length; i++) {
					Product prod = new Product();
					productId[i] = Long.parseLong(product[i]);
					prod.setProductID(productId[i]);
					products.add(prod);
					
				}
				
				for(Product p: products)
				{
					try {
						npaList=null;
						npaList=pservice.deleteSearchProducts(p.getProductID());
					} catch (ProductExpception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				
			
				if(npaList.size()>0)
				{
					List<Product> prList = new ArrayList<Product>();
					prList.add(p);
					String message="Product cannot be deleted as it has already been assigned to the customer.";
					request.setAttribute("msg", message);
				}
			
				else
				{
				
					try {
						flag = pservice.deleteProductList(p.getProductID());
						flag1 = pservice.deleteBusinessType(p.getProductID());
						flag2 = pservice.deleteProducts(p.getProductID());

					} catch (ProductExpception e) {
						String message = e.getMessage();
						// Direct Dispatching
						request.setAttribute("msg", message);

						RequestDispatcher rd = request
								.getRequestDispatcher("/jsp/Message.jsp");
						rd.forward(request, response);

					}

				}
				if (flag == true && flag1 == true&& flag2==true) {
					String message = "Product has been deleted successfully ";
					request.setAttribute("messages",message);
			
				}
				else if(flag2==true)
				{
					String message = "Product has been deleted successfully ";
					request.setAttribute("messages",message);
			
				}
				
				
			}
				
				RequestDispatcher rd = request.getRequestDispatcher("/jsp/messagess.jsp");
				rd.forward(request, response);

				
				
				}
			}

		

		//TODO Product report
		else if (action.equalsIgnoreCase("viewp")) {
			List<Product> plist = new ArrayList<Product>();
			try {
				plist = pservice.viewProduct();
			} catch (ProductExpception e) {
				String message = e.getMessage();
				// Direct Dispatching
				request.setAttribute("msg", message);

				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/Message.jsp");
				rd.forward(request, response);

			}

			request.setAttribute("plist", plist);
			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/productReport.jsp");
			rd.forward(request, response);
		}

		//TODO Add additional Product
		else if (action.equals("additionalProduct")) {
			
			response.sendRedirect(request.getContextPath()
					+ "/jsp/AddAdditionalProduct.jsp");
		}

		//TODO Enter details
		else if (action.equals("AdditionalProductDetails")) {
			String productId = request.getParameter("AdditionalProductId");
			long additionalProductid = Long.parseLong(productId);
			String additionalProductName = request
					.getParameter("AdditionalProductName");

			AdditionalProduct additionalProduct = new AdditionalProduct(
					additionalProductid, additionalProductName);

			boolean flag = false;
			try {

				flag = pservice.addAdditionalProduct(additionalProduct);

			} catch (ProductExpception e) {
				String message = e.getMessage();
				// Direct Dispatching
				request.setAttribute("msg", message);

				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/Message.jsp");
				rd.forward(request, response);

			}

			if (flag == true) {

				String message = "Additional product has been added successfully";
				request.setAttribute("msg", message);
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/Message.jsp");
				rd.forward(request, response);

			}
		}

		//TODO Search Additional Product
		else if (action.equals("uordap")) {

			response.sendRedirect(request.getContextPath()+ "/jsp/AdditionalProductSearch.jsp");
		}

		//TODO searched additional product summary
		else if (action.equals("searchap")) {
			long apId = Long.parseLong(request.getParameter("apid"));
			AdditionalProduct ap = new AdditionalProduct();

			
				try {
					ap = pservice.searchAdditionalProduct(apId);
				} catch (ProductExpception e) {
					String message = e.getMessage();
					// Direct Dispatching
					request.setAttribute("msg", message);

					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/Message.jsp");
					rd.forward(request, response);

				}
				
				if (ap.getName() != null) {
				request.setAttribute("apsearch", ap);
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/StaticDetailAp.jsp");
				rd.forward(request, response);
				} 
				else 
				{

				String message = "Additional Product not found in our record. Please check the ID you have entered. ";
				request.setAttribute("msg", message);
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/Message.jsp");
				rd.forward(request, response);
			}
		}
		//TODO update additional product
		else if (action.equals("uap")) {

			long apid = Long.parseLong(request.getParameter("apid"));
			String apname = request.getParameter("apname");
			AdditionalProduct ap = new AdditionalProduct(apid, apname);

			request.setAttribute("ap", ap);
			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/updateAdditionalProduct.jsp");
			rd.forward(request, response);

		}

		//TODO submit updated product
		else if (action.equals("updateap")) {

			String apname = request.getParameter("apvalue");
			long apid = Long.parseLong((String) request.getParameter("apid"));
			boolean flag = false;

			AdditionalProduct ap = new AdditionalProduct(apid, apname);

			try {
				flag = pservice.updateAdditionalProduct(ap);
			} catch (ProductExpception e) {
				String message = e.getMessage();
				// Direct Dispatching
				request.setAttribute("msg", message);

				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/Message.jsp");
				rd.forward(request, response);

			}

			if (flag == true) {
				String message = "Additional Product has been updated successfully";
				request.setAttribute("msg", message);
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/Message.jsp");
				rd.forward(request, response);
			}

		}

		//TODO Delete additional product
		else if (action.equals("deleteap")) {
			long apId = Long.parseLong(request.getParameter("apid"));
			boolean flag = false;
			try {
				flag = pservice.deleteAdditionalProduct(apId);
			} catch (ProductExpception e) {
				String message = e.getMessage();
				// Direct Dispatching
				request.setAttribute("msg", message);

				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/Message.jsp");
				rd.forward(request, response);

			}

			if (flag == true) {
				String message = "Additional Product has been deleted successfully";
				request.setAttribute("msg", message);
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/Message.jsp");
				rd.forward(request, response);
			}

		}

		//TODO Additional Product Report
		else if (action.equals("viewap")) {
			List<AdditionalProduct> aplist = new ArrayList<AdditionalProduct>();

			try {
				aplist = pservice.viewAdditionalProducts();
			} catch (ProductExpception e) {
				String message = e.getMessage();
				// Direct Dispatching
				request.setAttribute("msg", message);

				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/Message.jsp");
				rd.forward(request, response);

			}

			request.setAttribute("aplist", aplist);
			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/AdditionalProductReport.jsp");
			rd.forward(request, response);

		}
		else if(action.equals("reason"))
		{
			response.sendRedirect(request.getContextPath()+"/jsp/deleteSingle.jsp");
		}
		else if(action.equals("reasondel"))
		{     boolean flag = false;
		
				boolean flag1 = false;
				boolean flag2 = false;
				boolean flag3 = false;
				String reason=request.getParameter("delreason");
			long pid=Long.parseLong(request.getParameter("pid"));
				List<NonPersonalAccount> npaList=new ArrayList<NonPersonalAccount>();

				
				try {
					npaList=pservice.deleteSearchProducts(pid);
				} catch (ProductExpception e1) {
					String message = e1.getMessage();
					// Direct Dispatching
					request.setAttribute("msg", message);
					RequestDispatcher rd = request.getRequestDispatcher("/jsp/Message.jsp");
					rd.forward(request, response);
				}

				
				if(npaList.size()>0)
				{
					String message="Product cannot be deleted as it has been already assigned to customer.";
					request.setAttribute("msg", message);
					request.setAttribute("npList", npaList);
					RequestDispatcher rd = request.getRequestDispatcher("/jsp/Messages.jsp");
					rd.forward(request, response);
				}
			
				else
				{
				try {
					flag3=pservice.addReason(pid,reason);
					flag = pservice.deleteProductList(pid);
					flag1 = pservice.deleteBusinessType(pid);
					flag2 = pservice.deleteProducts(pid);
				} catch (ProductExpception e) {
					String message = e.getMessage();
					// Direct Dispatching
					request.setAttribute("msg", message);

					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/Message.jsp");
					rd.forward(request, response);

				}

				if (flag1 == true && flag2 == true&&flag==true&&flag3==true) {
					String message = "Product has been deleted successfully ";
					request.setAttribute("msg", message);
					RequestDispatcher rd = request.getRequestDispatcher("/jsp/messagess.jsp");
					rd.forward(request, response);
				}

				}
		
		
		
		}
		 
			

	}
}
