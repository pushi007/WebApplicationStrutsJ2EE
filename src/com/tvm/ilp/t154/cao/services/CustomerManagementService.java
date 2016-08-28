/**                                                                                                                                    
 *                                                                                                                                     
 */                                                                                                                                    
package com.tvm.ilp.t154.cao.services;                                                                                                 
                                                                                                                                       
import java.util.ArrayList;                                                                                                            
import java.util.List;                                                                                                                 
                                                                                                                                       
import com.tvm.ilp.t154.cao.dao.NonPersonalCustomerDAO;                                                                                
import com.tvm.ilp.t154.cao.dao.NonPersonalCustomerDAOImpl;                                                                            
import com.tvm.ilp.t154.cao.model.Branch;                                                                                              
import com.tvm.ilp.t154.cao.model.BusinessType;                                                                                        
import com.tvm.ilp.t154.cao.model.Country;                                                                                             
import com.tvm.ilp.t154.cao.model.Customers;                                                                                           
import com.tvm.ilp.t154.cao.model.NonPersonalCustomer;                                                                                 
                                                                                                                                       
import com.tvm.ilp.t154.cao.exceptions.CommercialCustRegException;                                                                     
                                                                                                                                       
/**                                                                                                                                    
 * @author 668552                                                                                                                      
 *                                                                                                                                     
 */                                                                                                                                    
public class CustomerManagementService {                                                                                               
                                                                                                                                       
	public List<NonPersonalCustomer> searchCustomerByBusinessName(                                                                     
			String businessName, String branchName)                                                                                    
			throws CommercialCustRegException {                                                                                        
		NonPersonalCustomerDAO npCustomerDao = new NonPersonalCustomerDAOImpl();                                                       
		List<NonPersonalCustomer> customerList = null;                                                                                 
                                                                                                                                       
		customerList = npCustomerDao.viewCustomer();                                                                                   
		List<Branch> branchList = npCustomerDao.getBranch();                                                                           
		List<NonPersonalCustomer> npCustList = new ArrayList<NonPersonalCustomer>();                                                   
                                                                                                                                       
		for (NonPersonalCustomer npCustomer : customerList) {                                                                          
                                                                                                                                       
			for (Branch branch : branchList) {                                                                                         
				if (branch.getBranchId().equalsIgnoreCase(                                                                             
						npCustomer.getBranch().getBranchId())) {                                                                       
					npCustomer.getBranch()                                                                                             
							.setBranchName(branch.getBranchName());                                                                    
				}                                                                                                                      
                                                                                                                                       
			}                                                                                                                          
                                                                                                                                       
			if (npCustomer.getBusinessName().toLowerCase().contains(businessName.toLowerCase())                                        
					&& branchName.equalsIgnoreCase(npCustomer.getBranch()                                                              
							.getBranchName())) {                                                                                       
				npCustList.add(npCustomer);                                                                                            
			}                                                                                                                          
		}                                                                                                                              
		return npCustList;                                                                                                             
                                                                                                                                       
	}                                                                                                                                  
                                                                                                                                       
	public List<NonPersonalCustomer> searchCustomerByTradeName(                                                                        
			String tradeName, String branchName)                                                                                       
			throws CommercialCustRegException {                                                                                        
		NonPersonalCustomerDAO npCustomerDao = new NonPersonalCustomerDAOImpl();                                                       
		List<NonPersonalCustomer> customerList = null;                                                                                 
		customerList = npCustomerDao.viewCustomer();                                                                                   
		List<NonPersonalCustomer> npCustList = new ArrayList<NonPersonalCustomer>();                                                   
		List<Branch> branchList = npCustomerDao.getBranch();                                                                           
		for (NonPersonalCustomer npCustomer : customerList) {                                                                          
			for (Branch branch : branchList) {                                                                                         
				if (branch.getBranchId().equalsIgnoreCase(                                                                             
						npCustomer.getBranch().getBranchId())) {                                                                       
					npCustomer.getBranch()                                                                                             
							.setBranchName(branch.getBranchName());                                                                    
				}                                                                                                                      
                                                                                                                                       
			}                                                                                                                          
                                                                                                                                       
			if (npCustomer.getTradingName().toLowerCase().contains(tradeName.toLowerCase())                                            
					&& branchName.equalsIgnoreCase(npCustomer.getBranch()                                                              
							.getBranchName())) {                                                                                       
				npCustList.add(npCustomer);                                                                                            
			}                                                                                                                          
		}                                                                                                                              
		return npCustList;                                                                                                             
	}                                                                                                                                  
                                                                                                                                       
	public NonPersonalCustomer searchCustomerById(int id)                                                                              
			throws CommercialCustRegException {                                                                                        
		NonPersonalCustomerDAO npCustomerDao = new NonPersonalCustomerDAOImpl();                                                       
		NonPersonalCustomer npCustomer = npCustomerDao.searchCustomer(id);                                                             
		List<Branch> branchList = npCustomerDao.getBranch();                                                                           
		for (Branch branch : branchList) {                                                                                             
			if (branch.getBranchId().equalsIgnoreCase(npCustomer.getBranch().getBranchId())) 
			{                                                                           
				npCustomer.getBranch().setBranchName(branch.getBranchName());                                                          
				npCustomer.getBranch().setBranchAddress(branch.getBranchAddress());                                                                                    
			}                                                                                                                          
		}                                                                                                                              
		return npCustomer;                                                                                                             
	}                                                                                                                                  
                                                                                                                                       
	public boolean addCustomer(NonPersonalCustomer npCustomer)                                                                         
			throws CommercialCustRegException {                                                                                        
		NonPersonalCustomerDAO npCustomerDao = new NonPersonalCustomerDAOImpl();                                                       
		return npCustomerDao.addCustomer(npCustomer);                                                                                  
	}                                                                                                                                  
                                                                                                                                       
	public List<NonPersonalCustomer> viewCustomer()                                                                                    
			throws CommercialCustRegException {                                                                                        
		NonPersonalCustomerDAO npCustomerDao = new NonPersonalCustomerDAOImpl();                                                       
		return npCustomerDao.viewCustomer();                                                                                           
	}                                                                                                                                  
                                                                                                                                       
	public List<Branch> getBranch() throws CommercialCustRegException {                                                                
		NonPersonalCustomerDAO npCustomerDao = new NonPersonalCustomerDAOImpl();                                                       
		return npCustomerDao.getBranch();                                                                                              
	}                                                                                                                                  
                                                                                                                                       
	public List<BusinessType> getBusinessType()                                                                                        
			throws CommercialCustRegException {                                                                                        
		NonPersonalCustomerDAO npCustomerDao = new NonPersonalCustomerDAOImpl();                                                       
                                                                                                                                       
		return npCustomerDao.getBusinessType();                                                                                        
	}                                                                                                                                  
                                                                                                                                       
	public List<Country> getCountry() throws CommercialCustRegException {                                                              
                                                                                                                                       
		NonPersonalCustomerDAO npCustomerDao = new NonPersonalCustomerDAOImpl();                                                       
		return npCustomerDao.getCountry();                                                                                             
	}                                                                                                                                  
                                                                                                                                       
	public boolean updateNPCustomer(NonPersonalCustomer npCustomer)                                                                    
			throws CommercialCustRegException {                                                                                        
		return (new NonPersonalCustomerDAOImpl()).updateCustomer(npCustomer);                                                          
	}                                                                                                                                  
                                                                                                                                       
	public boolean deleteNPCustomer(long npId)                                                                                         
			throws CommercialCustRegException {                                                                                        
		return (new NonPersonalCustomerDAOImpl()).deleteCustomer(npId);                                                                
	}                                                                                                                                  
                                                                                                                                       
	public NonPersonalCustomer searchByAccountNo(long accountNo)                                                                       
			throws CommercialCustRegException {                                                                                        
		NonPersonalCustomerDAO npCustomerDao = new NonPersonalCustomerDAOImpl();                                                       
		int customerId = (int) npCustomerDao                                                                                           
				.searchBusinessByAccountNo(accountNo);                                                                                 
                                                                                                                                       
		NonPersonalCustomer npCustomer = npCustomerDao                                                                                 
				.searchCustomer(customerId);                                                                                           
                                                                                                                                       
		return npCustomer;                                                                                                             
	}                                                                                                                                  
                                                                                                                                       
	public boolean uploaddocuments(Customers customers, NonPersonalCustomer customer) throws CommercialCustRegException                
	{                                                                                                                                  
		NonPersonalCustomerDAO npCustomerDao = new NonPersonalCustomerDAOImpl();                                                       
		return npCustomerDao.uploaddocuments(customers,customer);                                                                      
		                                                                                                                               
	}                                                                                                                                  
                                                                                                                                       
	public Customers searchCustomerByNpId(int id) throws CommercialCustRegException                                                    
	{                                                                                                                                  
		NonPersonalCustomerDAO npCustomerDao = new NonPersonalCustomerDAOImpl();                                                       
		return npCustomerDao.searchCustomerByNpId(id);                                                                                 
	}                                                                                                                                  
                                                                                                                                       
	public Customers proofofdocuments(long customerId) throws CommercialCustRegException                                               
	{                                                                                                                                  
		NonPersonalCustomerDAO npCustomerDao = new NonPersonalCustomerDAOImpl();                                                       
	   		Customers cust=new Customers();                                                                                            
        		cust=npCustomerDao.viewImageBYID(customerId);                                                                          
      		if(cust==null)                                                                                                             
        		{                                                                                                                              			System.out.println("Customer not exist");                                                                                  		}                                                                                                                              		return cust;                                                                                                                   		
	}

	public Customers proofofdocument(long customerId) throws CommercialCustRegException 
	{
		NonPersonalCustomerDAO npCustomerDao = new NonPersonalCustomerDAOImpl();                                                       
   		Customers cust=new Customers();                                                                                            
    		cust=npCustomerDao.viewImageBYCustomerID(customerId);                                                                          
  		if(cust==null)                                                                                                             
    		{                                                                                                                      
    			System.out.println("Customer not exist");                                                                          
    		}                                                                                                                      
    		return cust;                                                                                                           
    		
		
	}                                                                                                                      }                                                                                                                                      