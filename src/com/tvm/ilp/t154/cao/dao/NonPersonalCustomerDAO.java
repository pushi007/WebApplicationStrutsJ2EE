/**
 * 
 */
package com.tvm.ilp.t154.cao.dao;

import java.util.List;

import com.tvm.ilp.t154.cao.exceptions.CommercialCustRegException;
import com.tvm.ilp.t154.cao.model.Branch;
import com.tvm.ilp.t154.cao.model.BusinessType;
import com.tvm.ilp.t154.cao.model.Country;
import com.tvm.ilp.t154.cao.model.Customers;
import com.tvm.ilp.t154.cao.model.NonPersonalCustomer;

/**
 * @author 677791
 *
 */
public interface NonPersonalCustomerDAO {
public boolean addCustomer(NonPersonalCustomer customer) throws CommercialCustRegException;
public List<NonPersonalCustomer> viewCustomer() throws CommercialCustRegException;
public boolean updateCustomer(NonPersonalCustomer npCustomer) throws CommercialCustRegException;
public boolean deleteCustomer(long customerId) throws CommercialCustRegException;
public NonPersonalCustomer searchCustomer(int customerId) throws CommercialCustRegException;
public NonPersonalCustomer searchBusinessIdName(Long businessId,String businessName,String businessBranch);
public long searchBusinessByAccountNo(long accountNo) throws CommercialCustRegException;
public List<Branch> getBranch() throws CommercialCustRegException;
public List<BusinessType> getBusinessType() throws CommercialCustRegException;
public List<Country> getCountry() throws CommercialCustRegException;
public boolean uploaddocuments(Customers customers, NonPersonalCustomer customer) throws CommercialCustRegException;
public Customers searchCustomerByNpId(int id) throws CommercialCustRegException;
public Customers viewImageBYID(long customerId) throws CommercialCustRegException;
public Customers viewImageBYCustomerID(long customerId)  throws CommercialCustRegException ;

}
