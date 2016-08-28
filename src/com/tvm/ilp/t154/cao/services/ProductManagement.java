package com.tvm.ilp.t154.cao.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.example.productdetails.Productdetails.Productdetail;

import com.tvm.ilp.t154.cao.dao.ProductDAO;
import com.tvm.ilp.t154.cao.dao.ProductDAOImpl;
import com.tvm.ilp.t154.cao.exceptions.AccountCreationException;
import com.tvm.ilp.t154.cao.exceptions.ProductExpception;
import com.tvm.ilp.t154.cao.model.AdditionalProduct;
import com.tvm.ilp.t154.cao.model.BusinessType;
import com.tvm.ilp.t154.cao.model.NonPersonalAccount;
import com.tvm.ilp.t154.cao.model.NonPersonalAccountInProgress;
import com.tvm.ilp.t154.cao.model.Product;

public class ProductManagement {

	ProductDAO productDao = new ProductDAOImpl();

	public List<BusinessType> viewbusinesstype() throws ProductExpception {

		return productDao.viewbusinesstype();
	}

	public List<AdditionalProduct> viewAdditionalProd() throws ProductExpception {
		return productDao.viewAdditionalProd();
	}

	public boolean addProduct(Product product) throws ProductExpception {
		return productDao.addProduct(product);

	}

	public boolean addProduct(String name, long productId)
			throws ProductExpception {
		boolean flag = false;
		AdditionalProduct product = new AdditionalProduct();
		
			product = productDao.searchProductId(name, productId);
			flag = productDao.addProduct(productId, product.getAdditionalProductId());
		
		return flag;

	}

	public List<Product> vieProductList() throws ProductExpception {

		return productDao.vieProductList();
	}

	// product search business type
	public Product searchProductID(long productid) throws ProductExpception{

		return productDao.searchProductID(productid);
	}

	public List<BusinessType> viewbusinesstypeList(long productId)
			throws ProductExpception {

		return productDao.viewbusinesstypeList(productId);
	}

	public List<AdditionalProduct> viewAdditionalProdList(long productId)
			throws ProductExpception {

		return productDao.viewAdditionalProdList(productId);

	}

	public boolean addUpdatedProduct(Product product) throws ProductExpception {

		return productDao.addUpdatedProduct(product);
	}

	public boolean deleteProductList(long productid)
			throws ProductExpception{

		return productDao.deleteProductList(productid);
	}

	public boolean addupdatedAdditionalProduct(String name, long productid)
			throws ProductExpception {

		boolean flag = false;
		AdditionalProduct product = new AdditionalProduct();
		
			product = productDao.searchAdditionalProductId(name);
			flag = productDao.addupdatedAdditionalProduct(productid, product
					.getAdditionalProductId());

		
		return flag;

	}

	public boolean deleteBusinessType(long productid) throws ProductExpception {

		return productDao.deleteBusinessType(productid);
	}

	public boolean businessproduct(String businessTypeName, long productid)throws ProductExpception{

		return productDao.businessproduct(businessTypeName, productid);
	}

	// delete Produt
	public boolean deleteProducts(long productID) throws ProductExpception {

		return productDao.deleteProducts(productID);
	}

	public List<Product> viewProduct() throws ProductExpception {
		return productDao.viewProduct();
	}

	public boolean addAdditionalProduct(AdditionalProduct additionalProduct)
			throws ProductExpception {

		return productDao.addAdditionalProduct(additionalProduct);
	}

	public AdditionalProduct searchAdditionalProduct(long apId)
			throws ProductExpception {
		return productDao.searchAdditionalProduct(apId);

	}

	public boolean updateAdditionalProduct(AdditionalProduct ap)
			throws ProductExpception {
		return productDao.updateAdditionalProduct(ap);

	}

	public boolean deleteAdditionalProduct(long apId)
			throws ProductExpception {
		return productDao.deleteAdditionalProduct(apId);

	}

	public List<AdditionalProduct> viewAdditionalProducts()
			throws ProductExpception {
		return productDao.viewAdditionalProducts();
	}
	
	public List<NonPersonalAccountInProgress> getInProgressAccounts(long npid) throws ProductExpception {

		return productDao.getInProgressAccounts(npid);
	}

	public NonPersonalAccount deleteSearchProduct(long productId) throws ProductExpception
	{
		return productDao.deleteSearchProduct(productId);
	}

	public List<NonPersonalAccount> deleteSearchProducts(long productID) throws ProductExpception
	{
		return productDao.deleteSearchProducts(productID);
	}
	public boolean addReason(long pid,String reason) throws ProductExpception {
		return productDao.addReason(pid,reason);
}

	public boolean addProductDetails(Productdetail productdetail) throws ProductExpception {
		return productDao.addProductDetails(productdetail);
	}
	
	public boolean activateAccount(long accNo) throws ProductExpception {
		return productDao.activateAccount(accNo);
	}
}

