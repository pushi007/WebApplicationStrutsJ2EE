package com.tvm.ilp.t154.cao.dao;

import java.sql.SQLException;
import java.util.List;

import com.tvm.ilp.t154.cao.exceptions.AccountCreationException;
import com.tvm.ilp.t154.cao.model.AdditionalProduct;
import com.tvm.ilp.t154.cao.model.NonPersonalAccount;

public interface AdditionalProductDaoImpl {
	public NonPersonalAccount searchAccountNumber(long number)
	throws AccountCreationException, AccountCreationException;

	public List<AdditionalProduct> searchProduct(NonPersonalAccount account)
			throws AccountCreationException;

	public AdditionalProduct searchProductId(String name, long number)
	throws AccountCreationException;

	public boolean addProduct(long productId, long number)
	throws AccountCreationException;

	public boolean updateStatus(long accountNumber, String status)
	throws AccountCreationException;
}
