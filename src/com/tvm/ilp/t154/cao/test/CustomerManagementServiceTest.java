/**
 * 
 */
package com.tvm.ilp.t154.cao.test;

import java.util.List;

import junit.framework.TestCase;

import com.tvm.ilp.t154.cao.exceptions.CommercialCustRegException;
import com.tvm.ilp.t154.cao.model.NonPersonalCustomer;
import com.tvm.ilp.t154.cao.services.CustomerManagementService;

/**
 * @author 589964
 * 
 */
public class CustomerManagementServiceTest extends TestCase {

	/**
	 * Test method for
	 * {@link com.tvm.ilp.t154.cao.services.CustomerManagementService#searchCustomerByBusinessName(java.lang.String, java.lang.String)}
	 * .
	 */
	public void testSearchCustomerByBusinessName() {
		CustomerManagementService cmService = new CustomerManagementService();
		List<NonPersonalCustomer> npList = null;
		try {
			npList = cmService.searchCustomerByBusinessName("ts", "Derby");
		} catch (CommercialCustRegException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(npList);

	}

	/**
	 * Test method for
	 * {@link com.tvm.ilp.t154.cao.services.CustomerManagementService#searchCustomerByTradeName(java.lang.String, java.lang.String)}
	 * .
	 */
	public void testSearchCustomerByTradeName() {
		CustomerManagementService cmService = new CustomerManagementService();
		List<NonPersonalCustomer> npList = null;
		try {
			npList = cmService.searchCustomerByTradeName("ts", "Derby");
		} catch (CommercialCustRegException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(npList);
	}

	/**
	 * Test method for
	 * {@link com.tvm.ilp.t154.cao.services.CustomerManagementService#searchCustomerById(int)}
	 * .
	 */
	public void testSearchCustomerById() {
		CustomerManagementService cmService = new CustomerManagementService();
		NonPersonalCustomer npCustomer = null;
		try{
			npCustomer=cmService.searchCustomerById(200031);
		}catch (CommercialCustRegException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(npCustomer);
	}

	/**
	 * Test method for
	 * {@link com.tvm.ilp.t154.cao.services.CustomerManagementService#addCustomer(com.tvm.ilp.t154.cao.model.NonPersonalCustomer)}
	 * .
	 */
	public void testAddCustomer() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.tvm.ilp.t154.cao.services.CustomerManagementService#viewCustomer()}
	 * .
	 */
	public void testViewCustomer() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.tvm.ilp.t154.cao.services.CustomerManagementService#getBranch()}
	 * .
	 */
	public void testGetBranch() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.tvm.ilp.t154.cao.services.CustomerManagementService#getBusinessType()}
	 * .
	 */
	public void testGetBusinessType() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.tvm.ilp.t154.cao.services.CustomerManagementService#getCountry()}
	 * .
	 */
	public void testGetCountry() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.tvm.ilp.t154.cao.services.CustomerManagementService#updateNPCustomer(com.tvm.ilp.t154.cao.model.NonPersonalCustomer)}
	 * .
	 */
	public void testUpdateNPCustomer() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.tvm.ilp.t154.cao.services.CustomerManagementService#deleteNPCustomer(long)}
	 * .
	 */
	public void testDeleteNPCustomer() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.tvm.ilp.t154.cao.services.CustomerManagementService#searchByAccountNo(long)}
	 * .
	 */
	public void testSearchByAccountNo() {
		fail("Not yet implemented");
	}

}
