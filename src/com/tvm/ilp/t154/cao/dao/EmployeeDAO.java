package com.tvm.ilp.t154.cao.dao;

import java.util.List;

import com.tvm.ilp.t154.cao.exceptions.CommercialCustRegException;
import com.tvm.ilp.t154.cao.model.Employee;

public interface EmployeeDAO {
	public boolean setEmpPassword(Employee emp) throws CommercialCustRegException;
	public List<Employee> viewEmployee()throws CommercialCustRegException;
	public boolean updateEmpInDB(Employee emp) throws CommercialCustRegException ;
	public int addEmployee(Employee emp)throws CommercialCustRegException;
	public boolean deactivateEmpDB(Employee emp) throws CommercialCustRegException;
	
	boolean activate(int empId) throws CommercialCustRegException;
	public boolean resetEmpPassword(Employee emp) throws CommercialCustRegException;
	
	
}
