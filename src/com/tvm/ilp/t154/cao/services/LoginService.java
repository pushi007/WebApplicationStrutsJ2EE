package com.tvm.ilp.t154.cao.services;

import com.tvm.ilp.t154.cao.dao.EmployeeDAOImpl;
import com.tvm.ilp.t154.cao.exceptions.CommercialCustRegException;
import com.tvm.ilp.t154.cao.model.Employee;

public class LoginService {
	
	private EmployeeDAOImpl empDaoImpl=new EmployeeDAOImpl();
	private Employee emp=new Employee();
	
    
	public Employee getEmpDetails(int empId) throws CommercialCustRegException {
		emp=(Employee) empDaoImpl.getEmpDetailsDB(empId);
		return emp;
	}


	public Employee accessSecuQues(int empId) throws CommercialCustRegException {
		return empDaoImpl.accessSecuQuesDB(empId);
	}

}
