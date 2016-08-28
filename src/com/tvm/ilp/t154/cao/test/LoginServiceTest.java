/**
 * 
 */
package com.tvm.ilp.t154.cao.test;

import com.tvm.ilp.t154.cao.dao.EmployeeDAOImpl;
import com.tvm.ilp.t154.cao.exceptions.CommercialCustRegException;
import junit.framework.TestCase;

/**
 * @author 589964
 *
 */
public class LoginServiceTest extends TestCase {
	private EmployeeDAOImpl empDaoImpl=new EmployeeDAOImpl();
	/**
	 * Test method for {@link com.tvm.ilp.t154.cao.services.LoginService#getEmpDetails(int)}.
	 * @return 
	 * @throws CommercialCustRegException 
	 */
	public void testGetEmpDetails() {
		int empId=100017;
		
		try {
			assertNotNull(empDaoImpl.getEmpDetailsDB(empId));
		} catch (CommercialCustRegException e) {
			e.printStackTrace();
		}
				
	}

	/**
	 * Test method for {@link com.tvm.ilp.t154.cao.services.LoginService#accessSecuQues(int)}.
	 */
	public void testAccessSecuQues() {
		int empId=100008;
		
	/*	empExp=new Employee();
		empExp.setEmpId(100008);
		empExp.setSecurityQues("What was the last name of your third grade teacher?");
		empExp.setAnswer("abc");
		empExp.setDateOfBirth("1991/08/15");*/
		 
	try {
		assertNotNull(empDaoImpl.accessSecuQuesDB(empId));
	} catch (CommercialCustRegException e) {
		e.printStackTrace();
	}
		
		
	}

}
