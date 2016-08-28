/**
 * 
 */
package com.tvm.ilp.t154.cao.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.example.productdetails.Productdetails;

import com.tvm.ilp.t154.cao.exceptions.ProductExpception;
import com.tvm.ilp.t154.cao.model.AdditionalProduct;
import com.tvm.ilp.t154.cao.model.BusinessType;
import com.tvm.ilp.t154.cao.model.NonPersonalAccount;
import com.tvm.ilp.t154.cao.model.NonPersonalAccountInProgress;
import com.tvm.ilp.t154.cao.model.Product;

/**
 * @author 664972
 * 
 */
public interface ProductDAO {

	public List<BusinessType> viewbusinesstype() throws ProductExpception;

	public List<AdditionalProduct> viewAdditionalProd() throws ProductExpception;

	public boolean addProduct(Product product) throws ProductExpception;

	public AdditionalProduct searchProductId(String name, long productId)throws ProductExpception;

	public boolean addProduct(long productId, long AdditionalproductId)
			throws  ProductExpception;

	public List<Product> vieProductList() throws 
			 ProductExpception;

	public Product searchProductID(long productid) throws  ProductExpception;

	public List<BusinessType> viewbusinesstypeList(long productId)
			throws  ProductExpception;

	public List<AdditionalProduct> viewAdditionalProdList(long productId)
			throws  ProductExpception;

	public boolean addUpdatedProduct(Product product) throws  ProductExpception;

	public boolean deleteProductList(long productid) throws  ProductExpception;

	public AdditionalProduct searchAdditionalProductId(String name)
			throws ProductExpception;

	public boolean addupdatedAdditionalProduct(long productid,
			long additionalProductId) throws 
			 ProductExpception;

	public boolean deleteBusinessType(long productid) throws  ProductExpception;

	public boolean businessproduct(String businessTypeName, long productid)
			throws  ProductExpception;

	public boolean deleteProducts(long productID) throws  ProductExpception;

	public List<Product> viewProduct() throws  ProductExpception;

	public boolean addAdditionalProduct(AdditionalProduct additionalProduct)
			throws  ProductExpception;

	public AdditionalProduct searchAdditionalProduct(long apId)
			throws  ProductExpception;

	public boolean updateAdditionalProduct(AdditionalProduct ap)
			throws  ProductExpception;

	public boolean deleteAdditionalProduct(long apId) throws ProductExpception;

	public List<AdditionalProduct> viewAdditionalProducts()
			throws ProductExpception;

	public List<AdditionalProduct> viewAdditionalProductReport()
			throws ProductExpception;

	public NonPersonalAccount deleteSearchProduct(long productId) throws ProductExpception;

	public List<NonPersonalAccount> deleteSearchProducts(long productID) throws ProductExpception;

	public boolean addReason(long pid,String reason) throws ProductExpception;
	
	public boolean addProductDetails(Productdetails.Productdetail product)throws ProductExpception;
	
	public List<NonPersonalAccountInProgress> getInProgressAccounts(long npid) throws ProductExpception;
	
	public boolean activateAccount(long accNo) throws ProductExpception;
}
