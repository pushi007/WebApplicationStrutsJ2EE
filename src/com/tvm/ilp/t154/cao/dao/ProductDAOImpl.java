package com.tvm.ilp.t154.cao.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import com.tvm.ilp.t154.cao.utils.ConnectionUtil;
import com.tvm.ilp.t154.cao.utils.DateUtill;

public class ProductDAOImpl implements ProductDAO {

	public ArrayList<BusinessType> viewbusinesstype() throws ProductExpception {

		Connection con = null;
		PreparedStatement ps = null;
		ArrayList<BusinessType> businessList = new ArrayList<BusinessType>();

		try {
			con = ConnectionUtil.getConnection();

			ps = con
					.prepareStatement("select businesstype_name from business_types");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				BusinessType businesstype = new BusinessType();
				businesstype.setBusinessType_name(rs.getString(1));
				businessList.add(businesstype);
			}
		} catch (ClassNotFoundException e) {
			throw new ProductExpception("Business Type is not present");
		} catch (SQLException e) {
			throw new ProductExpception("Business Type is not present");
		} finally {
			try {
				ConnectionUtil.closeConnection(con);
				ConnectionUtil.closePreparedStatement(ps);
			} catch (SQLException e) {

				throw new ProductExpception("Database connection problem");
			}

		}

		return businessList;

	}

	@Override
	//
	

	//
	public boolean addProduct(Product product) throws ProductExpception {
		Connection con = null;
		PreparedStatement ps = null;
		boolean flag = false;

		try {
			con = ConnectionUtil.getConnection();
			ps = con
					.prepareStatement("insert into Product (product_id,product_name,product_description,account_type,product_Status,valid_from) values(?,?,?,?,?,to_date(?,'yyyy/mm/dd'))");

			ps.setLong(1, product.getProductID());
			ps.setString(2, product.getProductName());
			ps.setString(3, product.getProductDescription());
			ps.setString(4, product.getAccountType());
			ps.setString(5, product.getProductStatus());
			ps.setString(6, product.getProductValidFrom());

			int execute = ps.executeUpdate();

			if (execute > 0) {
				flag = true;
			} else {
				flag = false;

			}
		} catch (SQLException e) {
			throw new ProductExpception("Product Id is already in use");
		} catch (ClassNotFoundException e) {
			throw new ProductExpception("Product Id is already in use");
		}

		finally {
			try {
				ConnectionUtil.closeConnection(con);
				ConnectionUtil.closePreparedStatement(ps);
			} catch (SQLException e) {

				throw new ProductExpception("Database connection problem");
			}

		}

		return flag;

	}

	public boolean businessproduct(String businessTypeName, long productid)
			throws ProductExpception {

		Connection con = null;
		PreparedStatement ps = null;
		boolean flag = false;

		try {
			con = ConnectionUtil.getConnection();
			ps = con
					.prepareStatement("insert into PRODUCT_BUSINESS values (?,?)");

			ps.setLong(1, productid);
			ps.setString(2, businessTypeName);

			int execute = ps.executeUpdate();

			if (execute > 0) {
				flag = true;
			} else {
				flag = false;

			}
		} catch (SQLException e) {
			throw new ProductExpception("Product Resgistration failed");
		} catch (ClassNotFoundException e) {
			throw new ProductExpception("Product Resgistration failed");
		}

		finally {
			try {
				ConnectionUtil.closeConnection(con);
				ConnectionUtil.closePreparedStatement(ps);
			} catch (SQLException e) {

				throw new ProductExpception("Database connection problem");
			}

		}
		return flag;
	}

	public List<AdditionalProduct> viewAdditionalProd()
			throws ProductExpception {

		Connection con = null;
		PreparedStatement ps = null;
		List<AdditionalProduct> pList = new ArrayList<AdditionalProduct>();

		try {
			con = ConnectionUtil.getConnection();

			ps = con
					.prepareStatement("select AdditionalProduct_Name from Additional_Product");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				AdditionalProduct additional = new AdditionalProduct();
				additional.setName(rs.getString(1));
				pList.add(additional);
			}
		} catch (ClassNotFoundException e) {
			throw new ProductExpception("Additional Product does not exist");
		} catch (SQLException e) {
			throw new ProductExpception("Additional Product does not exist");
		} finally {
			try {
				ConnectionUtil.closeConnection(con);
				ConnectionUtil.closePreparedStatement(ps);
			} catch (SQLException e) {

				throw new ProductExpception("Database connection problem");
			}

		}
		return pList;
	}

	public AdditionalProduct searchProductId(String name, long productId)
			throws ProductExpception {

		PreparedStatement ps = null;
		Connection con = null;

		AdditionalProduct aProduct = new AdditionalProduct();
		try {
			con = ConnectionUtil.getConnection();
			ps = con
					.prepareStatement("select AdditionalProdct_Id from Additional_Product where AdditionalProduct_Name=?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();

			while (rs.next() != false) {

				aProduct.setAdditionalProductId(rs.getLong(1));
			}

		} catch (ClassNotFoundException e) {
			throw new ProductExpception("Additional Product does not exist");
		} catch (SQLException e) {
			throw new ProductExpception("Additional Product does not exist");
		} finally {
			try {
				ConnectionUtil.closeConnection(con);
				ConnectionUtil.closePreparedStatement(ps);
			} catch (SQLException e) {

				throw new ProductExpception("Database connection problem");
			}

		}

		return aProduct;
	}

	public boolean addProduct(long productId, long AdditionalproductId)
			throws ProductExpception {

		Connection con = null;
		PreparedStatement ps = null;
		boolean flag = false;
		try {
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement("insert into Product_List values (?,?)");
			ps.setLong(1, productId);
			ps.setLong(2, AdditionalproductId);
			int i = ps.executeUpdate();

			if (i > 0) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (ClassNotFoundException e) {
			throw new ProductExpception("Product registration failed");
		} catch (SQLException e) {
			throw new ProductExpception("Product registration failed");
		} finally {
			try {
				ConnectionUtil.closeConnection(con);
				ConnectionUtil.closePreparedStatement(ps);
			} catch (SQLException e) {

				throw new ProductExpception("Database connection problem");
			}
		}

		return flag;
	}

	public boolean addAdditionalProduct(AdditionalProduct additionalProduct)
			throws ProductExpception {
		Connection con = null;
		PreparedStatement ps = null;
		boolean flag = false;

		try {
			con = ConnectionUtil.getConnection();
			ps = con
					.prepareStatement("insert into Additional_Product values(?,?)");

			ps.setLong(1, additionalProduct.getAdditionalProductId());
			ps.setString(2, additionalProduct.getName());

			int execute = ps.executeUpdate();

			if (execute > 0) {
				flag = true;
			} else {
				flag = false;

			}
		} catch (ClassNotFoundException e) {
			throw new ProductExpception(
					"Additional Product registration failed");
		} catch (SQLException e) {
			throw new ProductExpception(
					"Additional Product registration failed");
		} finally {
			try {
				ConnectionUtil.closeConnection(con);
				ConnectionUtil.closePreparedStatement(ps);
			} catch (SQLException e) {

				throw new ProductExpception("Database connection problem");
			}
		}
		return flag;

	}

	public ArrayList<Product> vieProductList() throws ProductExpception {

		PreparedStatement ps = null;
		Connection con = null;
		ArrayList<Product> plist = new ArrayList<Product>();

		try {
			con = ConnectionUtil.getConnection();
			ps = con
					.prepareStatement("select product_id,product_name,product_description,account_type,product_status from product");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product p = new Product();
				p.setProductID(rs.getLong(1));
				p.setProductName(rs.getString(2));
				p.setProductDescription(rs.getString(3));
				p.setAccountType(rs.getString(4));
				p.setProductStatus(rs.getString(5));
				plist.add(p);

			}

		} catch (ClassNotFoundException e) {
			throw new ProductExpception("Product does not exist");
		} catch (SQLException e) {
			throw new ProductExpception("Product does not exist");
		} finally {
			try {
				ConnectionUtil.closeConnection(con);
				ConnectionUtil.closePreparedStatement(ps);
			} catch (SQLException e) {

				throw new ProductExpception("Database connection problem");
			}
		}
		return plist;
	}

	public Product searchProductID(long productid) throws ProductExpception {

		PreparedStatement ps = null;
		Connection con = null;
		Product p = new Product();

		try {
			con = ConnectionUtil.getConnection();

			ps = con
					.prepareStatement("select * from PRODUCT where Product_Id=?");

			ps.setLong(1, productid);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				p.setProductID(rs.getLong(1));
				p.setProductName(rs.getString(2));
				p.setProductDescription(rs.getString(3));
				p.setAccountType(rs.getString(4));
				p.setProductStatus(rs.getString(5));
				p.setProductValidFrom(rs.getDate(6).toString().replace('-','/'));
				
			}

		} catch (ClassNotFoundException e) {
			throw new ProductExpception("Product does not exist");
		} catch (SQLException e) {
			throw new ProductExpception("Product does not exist");
		} finally {
			try {
				ConnectionUtil.closeConnection(con);
				ConnectionUtil.closePreparedStatement(ps);
			} catch (SQLException e) {

				throw new ProductExpception("Database connection problem");
			}
		}
		return p;

	}

	public ArrayList<AdditionalProduct> viewAdditionalProduct()
			throws ProductExpception {
		PreparedStatement ps = null;
		Connection con = null;
		ArrayList<AdditionalProduct> aproduct = new ArrayList<AdditionalProduct>();

		try {
			con = ConnectionUtil.getConnection();

			ps = con
					.prepareStatement("select AdditionalProduct_Name from  Additional_Product");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				AdditionalProduct ap = new AdditionalProduct();
				ap.setName(rs.getString(1));
				aproduct.add(ap);
			}

		} catch (ClassNotFoundException e) {
			throw new ProductExpception("Additional Product does not exist");
		} catch (SQLException e) {
			throw new ProductExpception("Additional Product does not exist");
		} finally {
			try {
				ConnectionUtil.closeConnection(con);
				ConnectionUtil.closePreparedStatement(ps);
			} catch (SQLException e) {

				throw new ProductExpception("Database connection problem");
			}
		}

		return aproduct;

	}

	public boolean addUpdatedProduct(Product product) throws ProductExpception {

		Connection con = null;
		PreparedStatement ps = null;
		boolean flag = false;

		try {
			con = ConnectionUtil.getConnection();
			ps = con
					.prepareStatement("update Product set Product_Name=?,Product_Description=?,Account_Type=?,Product_Status=?,Valid_From=(to_date(?,'yyyy/mm/dd')) Where Product_Id=?");

			ps.setString(1, product.getProductName());
			ps.setString(2, product.getProductDescription());
			ps.setString(3, product.getAccountType());
			ps.setString(4, product.getProductStatus());
			ps.setString(5, product.getProductValidFrom());
			ps.setLong(6, product.getProductID());

			int execute = ps.executeUpdate();

			if (execute > 0) {
				flag = true;
			} else {
				flag = false;

			}
		} catch (ClassNotFoundException e) {
			throw new ProductExpception("Product updation failed");
		} catch (SQLException e) {
			throw new ProductExpception("Product updation failed");
		} finally {
			try {
				ConnectionUtil.closeConnection(con);
				ConnectionUtil.closePreparedStatement(ps);
			} catch (SQLException e) {

				throw new ProductExpception("Database connection problem");
			}
		}
		return flag;
	}

	@Override
	public boolean deleteAdditionalProduct(long apId) throws ProductExpception {

		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		Connection con = null;
		boolean flag = false;

		try {
			con = ConnectionUtil.getConnection();
			ps = con
					.prepareStatement("delete from product_list where additionalproduct_id=?");
			ps.setLong(1, apId);
			int i = ps.executeUpdate();
			if (i > 0) {
				flag = true;
			} else {
				flag = false;
			}
			ps1 = con
					.prepareStatement("delete from additional_product where additionalprodct_id=?");
			ps1.setLong(1, apId);
			int j = ps1.executeUpdate();
			if (j > 0) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (ClassNotFoundException e) {
			throw new ProductExpception(
					"Additional Product cannot be deleted as it has been already assigned to the customer");
		} catch (SQLException e) {
			throw new ProductExpception(
					"Additional Product cannot be deleted as it has been already assigned to the customer");
		} finally {
			try {
				ConnectionUtil.closeConnection(con);
				ConnectionUtil.closePreparedStatement(ps);
			} catch (SQLException e) {

				throw new ProductExpception("Database connection problem");
			}
		}
		return flag;
	}

	@Override
	public AdditionalProduct searchAdditionalProduct(long apId)
			throws ProductExpception {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		Connection con = null;
		AdditionalProduct ap = new AdditionalProduct();

		try {
			con = ConnectionUtil.getConnection();
			ps = con
					.prepareStatement("select * from additional_product where additionalprodct_id=?");
			ps.setLong(1, apId);
			ResultSet rs = ps.executeQuery();
			while (rs.next() != false) {
				ap.setAdditionalProductId(rs.getLong(1));
				ap.setName(rs.getString(2));

			}

		} catch (ClassNotFoundException e) {
			throw new ProductExpception("Additional Product does not exist");
		} catch (SQLException e) {
			throw new ProductExpception("Additional Product does not exist");
		} finally {
			try {
				ConnectionUtil.closeConnection(con);
				ConnectionUtil.closePreparedStatement(ps);
			} catch (SQLException e) {

				throw new ProductExpception("Database connection problem");
			}
		}

		return ap;

	}

	@Override
	public boolean updateAdditionalProduct(AdditionalProduct ap)
			throws ProductExpception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		boolean flag = false;
		try {
			con = ConnectionUtil.getConnection();

			ps = con
					.prepareStatement("update additional_product set additionalproduct_name=? where additionalprodct_id=?");
			ps.setString(1, ap.getName());
			ps.setLong(2, ap.getAdditionalProductId());

			int i = ps.executeUpdate();
			if (i > 0) {
				flag = true;
			} else
				flag = false;
		} catch (ClassNotFoundException e) {
			throw new ProductExpception("Additional Product updation failed");
		} catch (SQLException e) {
			throw new ProductExpception("Additional Product updation failed");
		} finally {
			try {
				ConnectionUtil.closeConnection(con);
				ConnectionUtil.closePreparedStatement(ps);
			} catch (SQLException e) {

				throw new ProductExpception("Database connection problem");
			}
		}
		return flag;
	}

	// @Override
	public ArrayList<Product> viewProduct() throws ProductExpception {

		PreparedStatement ps = null;
		Connection con = null;
		ArrayList<Product> plist = new ArrayList<Product>();

		try {
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement("select * from product");
			ResultSet rs = ps.executeQuery();
			while (rs.next() != false) {
				Product p = new Product();
				p.setProductID(rs.getLong(1));
				p.setProductName(rs.getString(2));
				p.setProductDescription(rs.getString(3));
				p.setAccountType(rs.getString(4));
				p.setProductStatus(rs.getString(5));
				p.setProductValidFrom(rs.getDate(6).toString().toString().replace('-','/'));
				plist.add(p);

			}

		} catch (ClassNotFoundException e) {
			throw new ProductExpception(" Product does not exist");
		} catch (SQLException e) {
			throw new ProductExpception(" Product does not exist");
		} finally {
			try {
				ConnectionUtil.closeConnection(con);
				ConnectionUtil.closePreparedStatement(ps);
			} catch (SQLException e) {

				throw new ProductExpception("Database connection problem");
			}
		}
		return plist;

	}

	public boolean deleteProductList(long productid) throws ProductExpception {
		PreparedStatement ps = null;
		Connection con = null;
		boolean flag = false;

		try {
			con = ConnectionUtil.getConnection();
			ps = con
					.prepareStatement("delete from product_list where product_id=?");
			ps.setLong(1, productid);
			int i = ps.executeUpdate();
			if (i > 0) {
				flag = true;
			} else {
				flag = false;
			}

		} catch (ClassNotFoundException e) {
			throw new ProductExpception(
					"Product cannot be deleted as it has been alredy assigned to customer");
		} catch (SQLException e) {
			throw new ProductExpception(
					"Product cannot be deleted as it has been already assigned to customer");
		} finally {
			try {
				ConnectionUtil.closeConnection(con);
				ConnectionUtil.closePreparedStatement(ps);
			} catch (SQLException e) {

				throw new ProductExpception("Database connection problem");
			}
		}

		return flag;

	}

	public AdditionalProduct searchAdditionalProductId(String name)
			throws ProductExpception {

		PreparedStatement ps = null;
		Connection con = null;

		AdditionalProduct aProduct = new AdditionalProduct();
		try {
			con = ConnectionUtil.getConnection();
			ps = con
					.prepareStatement("select AdditionalProdct_Id from Additional_Product where AdditionalProduct_Name=?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();

			while (rs.next() != false) {

				aProduct.setAdditionalProductId(rs.getLong(1));
			}

		} catch (ClassNotFoundException e) {
			throw new ProductExpception("Additional Product does not exist");
		} catch (SQLException e) {
			throw new ProductExpception("Additional Product does not exist");
		} finally {
			try {
				ConnectionUtil.closeConnection(con);
				ConnectionUtil.closePreparedStatement(ps);
			} catch (SQLException e) {

				throw new ProductExpception("Database connection problem");
			}
		}
		return aProduct;

	}

	public boolean addupdatedAdditionalProduct(long productid,
			long additionalProductId) throws ProductExpception {

		Connection con = null;
		PreparedStatement ps = null;
		boolean flag = false;
		try {
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement("insert into Product_List values (?,?)");
			ps.setLong(1, productid);
			ps.setLong(2, additionalProductId);
			int i = ps.executeUpdate();

			if (i > 0) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (ClassNotFoundException e) {
			throw new ProductExpception("Product registration failed");
		} catch (SQLException e) {
			throw new ProductExpception("Product registration failed");
		} finally {
			try {
				ConnectionUtil.closeConnection(con);
				ConnectionUtil.closePreparedStatement(ps);
			} catch (SQLException e) {

				throw new ProductExpception("Database connection problem");
			}
		}
		return flag;
	}

	public ArrayList<AdditionalProduct> viewAdditionalProducts()
			throws ProductExpception {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		Connection con = null;
		ArrayList<AdditionalProduct> aplist = new ArrayList<AdditionalProduct>();
		try {
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement("select * from additional_product");
			ResultSet rs = ps.executeQuery();
			while (rs.next() != false) {
				AdditionalProduct ap = new AdditionalProduct();
				ap.setAdditionalProductId(rs.getLong(1));
				ap.setName(rs.getString(2));
				aplist.add(ap);

			}

		} catch (ClassNotFoundException e) {
			throw new ProductExpception("Additional Product does not exist");
		} catch (SQLException e) {
			throw new ProductExpception("Additional Product does not exist");
		} finally {
			try {
				ConnectionUtil.closeConnection(con);
				ConnectionUtil.closePreparedStatement(ps);
			} catch (SQLException e) {

				throw new ProductExpception("Database connection problem");
			}
		}

		return aplist;

	}

	public boolean deleteBusinessType(long productid) throws ProductExpception {

		PreparedStatement ps = null;
		Connection con = null;
		boolean flag = false;

		try {
			con = ConnectionUtil.getConnection();
			ps = con
					.prepareStatement("delete from PRODUCT_BUSINESS where product_id=?");
			ps.setLong(1, productid);
			int i = ps.executeUpdate();
			if (i > 0) {
				flag = true;
			} else {
				flag = false;
			}

		} catch (ClassNotFoundException e) {
			throw new ProductExpception("Business type deletion failed");
		} catch (SQLException e) {
			throw new ProductExpception("Business type deletion failed");
		} finally {
			try {
				ConnectionUtil.closeConnection(con);
				ConnectionUtil.closePreparedStatement(ps);
			} catch (SQLException e) {

				throw new ProductExpception("Database connection problem");
			}
		}
		return flag;

	}

	// Additional product report

	public ArrayList<AdditionalProduct> viewAdditionalProductReport()
			throws ProductExpception {

		PreparedStatement ps = null;
		Connection con = null;
		ArrayList<AdditionalProduct> aplist = new ArrayList<AdditionalProduct>();
		try {
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement("select * from additional_product");
			ResultSet rs = ps.executeQuery();
			while (rs.next() != false) {
				AdditionalProduct ap = new AdditionalProduct();
				ap.setAdditionalProductId(rs.getLong(1));
				ap.setName(rs.getString(2));
				aplist.add(ap);

			}

		} catch (ClassNotFoundException e) {
			throw new ProductExpception(
					"Additional Product report cannot be viewed");
		} catch (SQLException e) {
			throw new ProductExpception(
					"Additional Product report cannot be viewed");
		} finally {
			try {
				ConnectionUtil.closeConnection(con);
				ConnectionUtil.closePreparedStatement(ps);
			} catch (SQLException e) {

				throw new ProductExpception("Database connection problem");
			}
		}

		return aplist;

	}

	// Delete Product
	public boolean deleteProducts(long productID) throws ProductExpception {

		PreparedStatement ps = null;
		Connection con = null;
		boolean flag = false;

		try {
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement("delete from PRODUCT where product_id=?");
			ps.setLong(1, productID);
			int i = ps.executeUpdate();
			if (i > 0) {
				flag = true;
			} else {
				flag = false;
			}

		} catch (ClassNotFoundException e) {
			throw new ProductExpception(
					"Product cannot be deleted as it has already been assigned to customer.");
		} catch (SQLException e) {
			throw new ProductExpception(
					"Product cannot be deleted as it has already been assigned to customer");
		} finally {
			try {
				ConnectionUtil.closeConnection(con);
				ConnectionUtil.closePreparedStatement(ps);
			} catch (SQLException e) {

				throw new ProductExpception("Database connection problem");
			}
		}
		return flag;
	}

	// product search business type
	public ArrayList<BusinessType> viewbusinesstypeList(long productId)
			throws ProductExpception {

		PreparedStatement ps = null;
		Connection con = null;
		ArrayList<BusinessType> ablist = new ArrayList<BusinessType>();

		try {
			con = ConnectionUtil.getConnection();
			ps = con
					.prepareStatement("select businesstype_Name from PRODUCT_BUSINESS where product_id=?");

			ps.setLong(1, productId);
			ResultSet rs = ps.executeQuery();
			while (rs.next() != false) {
				BusinessType b = new BusinessType();
				b.setBusinessType_name(rs.getString(1));
				ablist.add(b);

			}

		} catch (ClassNotFoundException e) {
			throw new ProductExpception("Business type does not exist");
		} catch (SQLException e) {
			throw new ProductExpception("Business type does not exist");
		} finally {
			try {
				ConnectionUtil.closeConnection(con);
				ConnectionUtil.closePreparedStatement(ps);
			} catch (SQLException e) {

				throw new ProductExpception("Database connection problem");
			}
		}

		return ablist;

	}

	public List<AdditionalProduct> viewAdditionalProdList(long productId)
			throws ProductExpception {

		PreparedStatement ps = null;
		Connection con = null;
		ArrayList<AdditionalProduct> ablist = new ArrayList<AdditionalProduct>();

		try {
			con = ConnectionUtil.getConnection();
			ps = con
					.prepareStatement("select additionalproduct_name from PRODUCT_LIST pl inner join ADDITIONAL_PRODUCT ap on pl.additionalProduct_id=ap.additionalprodct_id where product_id=?");

			ps.setLong(1, productId);
			ResultSet rs = ps.executeQuery();
			while (rs.next() != false) {
				AdditionalProduct b = new AdditionalProduct();
				b.setName(rs.getString(1));
				ablist.add(b);

			}

		} catch (ClassNotFoundException e) {
			throw new ProductExpception("Additional Product does not exist");
		} catch (SQLException e) {
			throw new ProductExpception("Additional Product does not exist");
		} finally {
			try {
				ConnectionUtil.closeConnection(con);
				ConnectionUtil.closePreparedStatement(ps);
			} catch (SQLException e) {

				throw new ProductExpception("Database connection problem");
			}
		}

		return ablist;
	}

	@Override
	public NonPersonalAccount deleteSearchProduct(long productId) throws ProductExpception
	{
		PreparedStatement ps = null;
		Connection con = null;
		NonPersonalAccount npa = new NonPersonalAccount();

		try {
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement("select  * from NON_PERSONAL_ACCOUNT where product_id=?");

			ps.setLong(1, productId);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()!= false) 
			{
				
				npa.setAccNumber(rs.getLong(1));

			}

		} catch (ClassNotFoundException e) {
			throw new ProductExpception("Product does not exist");
		} catch (SQLException e) {
			throw new ProductExpception("Product type does not exist");
		} finally {
			try {
				ConnectionUtil.closeConnection(con);
				ConnectionUtil.closePreparedStatement(ps);
			} catch (SQLException e) {

				throw new ProductExpception("Database connection problem");
			}
		}

		return npa;

		
	}

	@Override
	public List<NonPersonalAccount> deleteSearchProducts(long productID) throws ProductExpception
	{
		PreparedStatement ps = null;
		Connection con = null;
		List<NonPersonalAccount> npaList= new  ArrayList<NonPersonalAccount>();

		try {
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement("select  * from NON_PERSONAL_ACCOUNT where product_id=?");

			ps.setLong(1, productID);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()!= false) 
			{
				NonPersonalAccount npa=new NonPersonalAccount();
				npa.setAccNumber(rs.getLong(1));
				npaList.add(npa);

			}

		} catch (ClassNotFoundException e) {
			throw new ProductExpception("Product does not exist");
		} catch (SQLException e) {
			throw new ProductExpception("Product type does not exist");
		} finally {
			try {
				ConnectionUtil.closeConnection(con);
				ConnectionUtil.closePreparedStatement(ps);
			} catch (SQLException e) {

				throw new ProductExpception("Database connection problem");
			}
		}

		return npaList;
		
	}
	public boolean addReason(long pid,String reason) throws ProductExpception {
		Connection con = null;
		PreparedStatement ps = null;
		boolean flag = false;

		try {
			con = ConnectionUtil.getConnection();
			ps = con
					.prepareStatement("insert into PRODUCT_DELETION values(?,?)");

			ps.setLong(1,pid );
			ps.setString(2, reason);

			int i = ps.executeUpdate();

			if (i > 0) {
				flag = true;
			} else {
				flag = false;

			}
		} catch (SQLException e) {
			throw new ProductExpception("Reason for deletion not captured");
		} catch (ClassNotFoundException e) {
			throw new ProductExpception("Reason for deletion not captured");
		}

		finally {
			try {
				ConnectionUtil.closeConnection(con);
				ConnectionUtil.closePreparedStatement(ps);
			} catch (SQLException e) {

				throw new ProductExpception("Database connection problem");
			}

		}

		return flag;

	}
	
	
	public boolean addProductDetails(Productdetails.Productdetail product)throws ProductExpception
	{
		Connection con =null;
		PreparedStatement ps=null;
		boolean flag=false;
		try {
			con = ConnectionUtil.getConnection();
			
			ps=con.prepareStatement("insert into Product (product_id,product_name,product_description,account_type,product_Status,valid_from) values(?,?,?,?,?,?)");
			
             
			ps.setLong(1, product.getproductid());
			
			ps.setString(2, product.getProductname());
			ps.setString(3, product.getProductdescription());
			ps.setString(4, product.getAccounttype());
			ps.setString(5, product.getProductstatus());
			
			String date=product.getValidFrom();
			java.sql.Date sqlDate=DateUtill.converDate(date);
			
			
			ps.setDate(6, sqlDate);
			int i=ps.executeUpdate();
			
			if(i>0)
			{
				flag=true;
			}
			else
			{
				flag=false;
			}
		} catch (SQLException e) {
			throw new ProductExpception("Product registration failed");
		} catch (ClassNotFoundException e) {
			throw new ProductExpception("Product registration failed");
		}
		finally {
			try {
				ConnectionUtil.closeConnection(con);
				ConnectionUtil.closePreparedStatement(ps);
			} catch (SQLException e) {

				throw new ProductExpception("Database connection problem");
			}

		}

		return flag;
	}

	@Override
	public List<NonPersonalAccountInProgress> getInProgressAccounts(long npid)
			throws ProductExpception {
		
		ArrayList<NonPersonalAccountInProgress> alnpa=new ArrayList<NonPersonalAccountInProgress>();
		Connection con =null;
		PreparedStatement ps=null;
		
		try {
			con = ConnectionUtil.getConnection();
			
			ps=con.prepareStatement("select DISTINCT ACCOUNT_NUMBER,ACCOUNTTYPE_NAME,PRODUCT_NAME,BRANCH from NON_PERSONAL_ACCOUNT join PRODUCT on  NON_PERSONAL_ACCOUNT.PRODUCT_ID=PRODUCT.PRODUCT_ID where NP_ID=? and STATUS=?");
			ps.setLong(1, npid);
			ps.setString(2, "In Progress");
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()!= false) 
			{
				NonPersonalAccountInProgress npa=new NonPersonalAccountInProgress();
				npa.setAccNumber(rs.getLong(1));
				npa.setNpId((int)npid);
				npa.setAccountType(rs.getString(2));
				npa.setProductName(rs.getString(3));
				npa.setBranch(rs.getString(4));			
				alnpa.add(npa);
			}
			
		return alnpa;
		}catch (SQLException e) {
			throw new ProductExpception("Product registration failed");
		} catch (ClassNotFoundException e) {
			throw new ProductExpception("Product registration failed");
		}
		finally {
			try {
				ConnectionUtil.closeConnection(con);
				ConnectionUtil.closePreparedStatement(ps);
			} catch (SQLException e) {

				throw new ProductExpception("Database connection problem");
			}

		}
	}

	@Override
	public boolean activateAccount(long accNo) throws ProductExpception {
		boolean flag2=false;
		
		Connection con =null;
		PreparedStatement ps=null;
		
		try {
			con = ConnectionUtil.getConnection();
			ps=con.prepareStatement("update NON_PERSONAL_ACCOUNT set STATUS=? where ACCOUNT_NUMBER=?");
			ps.setString(1, "Active");
			ps.setLong(2, accNo);
			
			int i = ps.executeUpdate();
			
			if(i>0)
			{
				flag2=true;
			}
			
		return flag2;
		}catch (SQLException e) {
			throw new ProductExpception("Product registration failed");
		} catch (ClassNotFoundException e) {
			throw new ProductExpception("Product registration failed");
		}
		finally {
			try {
				ConnectionUtil.closeConnection(con);
				ConnectionUtil.closePreparedStatement(ps);
			} catch (SQLException e) {

				throw new ProductExpception("Database connection problem");
			}

		}
	}
}
