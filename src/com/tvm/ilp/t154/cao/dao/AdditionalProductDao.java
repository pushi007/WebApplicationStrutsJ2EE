/**
 * 
 */
package com.tvm.ilp.t154.cao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tvm.ilp.t154.cao.exceptions.AccountCreationException;
import com.tvm.ilp.t154.cao.model.AdditionalProduct;
import com.tvm.ilp.t154.cao.model.NonPersonalAccount;
import com.tvm.ilp.t154.cao.utils.ConnectionUtil;

/**
 * @author 589768
 * 
 */
public class AdditionalProductDao implements AdditionalProductDaoImpl {

	// To search account number
	public NonPersonalAccount searchAccountNumber(long number) throws AccountCreationException
			 {
		PreparedStatement ps = null;
		Connection con = null;
		NonPersonalAccount account = new NonPersonalAccount();

		try {
			con = ConnectionUtil.getConnection();
			ps = con
					.prepareStatement("select PRODUCT_ID from NON_PERSONAL_ACCOUNT where ACCOUNT_NUMBER=?");
			ps.setLong(1, number);
			ResultSet rs = ps.executeQuery();

			while (rs.next() != false) {
				account.setProductId(rs.getLong(1));
			}
		} catch (ClassNotFoundException e) {
			throw new AccountCreationException("Account number doesn't exist");
		} catch (SQLException e) {
			throw new AccountCreationException("Account number doesn't exist");
		} catch(Exception e){
			throw new AccountCreationException("Sorry!! Session expired");
		}
		finally {
			try {
				ConnectionUtil.closeConnection(con);
				ConnectionUtil.closePreparedStatement(ps);
			} catch (SQLException e) {
				throw new AccountCreationException("Connection Problem!!");
			}
			
		}
		return account;
	}

	// To search list of additional product
	public List<AdditionalProduct> searchProduct(NonPersonalAccount account) throws AccountCreationException
		 {
		PreparedStatement ps = null;
		Connection con = null;
		List<AdditionalProduct> pList = new ArrayList<AdditionalProduct>();

		try {
			con = ConnectionUtil.getConnection();
			ps = con
					.prepareStatement("select ap.ADDITIONALPRODUCT_NAME from PRODUCT_LIST pl inner join ADDITIONAL_PRODUCT ap on pl.ADDITIONALPRODUCT_ID=ap.ADDITIONALPRODCT_ID where pl.PRODUCT_ID=?");
			ps.setLong(1, account.getProductId());
			ResultSet rs = ps.executeQuery();

			while (rs.next() != false) {
				AdditionalProduct product = new AdditionalProduct();
				product.setName(rs.getString(1));

				pList.add(product);
			}
		} catch (ClassNotFoundException e) {
			throw new AccountCreationException("No additional Product found");
			
		} catch (SQLException e) {
			throw new AccountCreationException("No additional Product found");
			
		}catch(Exception e){
			throw new AccountCreationException("Sorry!! Session expired");
		}
		finally {
			try {
				ConnectionUtil.closeConnection(con);
				ConnectionUtil.closePreparedStatement(ps);
			} catch (SQLException e) {
				throw new AccountCreationException("Connection Problem!!");
			}
			
		}
		return pList;
	}

	// To search additional product ID
	public AdditionalProduct searchProductId(String name, long number) throws AccountCreationException
			{
		PreparedStatement ps = null;
		Connection con = null;
		// boolean flag=false;
		// List<AdditionalProduct> p=new ArrayList<AdditionalProduct>();
		AdditionalProduct aProduct = new AdditionalProduct();
		try {
			con = ConnectionUtil.getConnection();
			ps = con
					.prepareStatement("select ADDITIONALPRODCT_ID from ADDITIONAL_PRODUCT where ADDITIONALPRODUCT_NAME=?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();

			while (rs.next() != false) {

				aProduct.setAdditionalProductId(rs.getLong(1));
			}

		} catch (ClassNotFoundException e) {
			throw new AccountCreationException("Connection Problem!!Products cannot be saved");
		} catch (SQLException e) {
			throw new AccountCreationException("Connection Problem!!Products cannot be saved");
		} catch(Exception e){
			throw new AccountCreationException("Sorry!! Session expired");
		}
		finally {
			try {
				ConnectionUtil.closeConnection(con);
				ConnectionUtil.closePreparedStatement(ps);
			} catch (SQLException e) {
				throw new AccountCreationException("Connection Problem!!");
			}
			
		}
		return aProduct;
	}

	// To store assigned additional product
	public boolean addProduct(long productId, long number) throws AccountCreationException
			 {
		PreparedStatement ps = null;
		Connection con = null;
		boolean flag = false;
		try {
			con = ConnectionUtil.getConnection();
			ps = con
					.prepareStatement("insert into ADDITIONAL_PRODUCT_LIST(ACCOUNT_NUMBER,ADDITIONALPRODUCT_ID) values(?,?)");
			ps.setLong(1, number);
			ps.setLong(2, productId);
			int i = ps.executeUpdate();

			if (i > 0) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (ClassNotFoundException e) {
			throw new AccountCreationException("Connection Problem!!Products cannot be saved");
		} catch (SQLException e) {
			throw new AccountCreationException("Connection Problem!!Products cannot be saved");
		}catch(Exception e){
			throw new AccountCreationException("Sorry!! Session expired");
		}
		finally {
			try {
				ConnectionUtil.closeConnection(con);
				ConnectionUtil.closePreparedStatement(ps);
			} catch (SQLException e) {
				throw new AccountCreationException("Connection Problem!!");
			}
		}
		return flag;
	}

	public boolean updateStatus(long accountNumber, String status) throws AccountCreationException
			 {
		boolean flag = false;
		PreparedStatement ps = null;
		Connection con = null;

		try {
			con = ConnectionUtil.getConnection();
			ps = con
					.prepareStatement("update NON_PERSONAL_ACCOUNT set STATUS=? where ACCOUNT_NUMBER=?");
			ps.setString(1, status);
			ps.setLong(2, accountNumber);
			int i = ps.executeUpdate();
			if (i > 0) {
				flag = true;
			} else {
				flag = false;
			}

		} catch (ClassNotFoundException e) {
			throw new AccountCreationException("Connection Problem!!Status can't be changed");
		} catch (SQLException e) {
			throw new AccountCreationException("Connection Problem!!Status can't be changed");
		}catch(Exception e){
			throw new AccountCreationException("Sorry!! Session expired");
		}
		finally {
			try {
				ConnectionUtil.closeConnection(con);
				ConnectionUtil.closePreparedStatement(ps);
			} catch (SQLException e) {
				throw new AccountCreationException("Connection Problem!!");
			}
		}
		return flag;

	}
}
