package com.tvm.ilp.t154.cao.services;

import java.util.ArrayList;
import java.util.List;

import com.tvm.ilp.t154.cao.dao.EmployeeDAO;
import com.tvm.ilp.t154.cao.dao.EmployeeDAOImpl;
import com.tvm.ilp.t154.cao.exceptions.CommercialCustRegException;
import com.tvm.ilp.t154.cao.model.Employee;

public class EmployeeManagementService {
	private EmployeeDAO empDao = new EmployeeDAOImpl();
	private List<Employee> empList=new ArrayList<Employee>();
	private List<String> desigList=new ArrayList<String>();
	private List<String> branchList=new ArrayList<String>();
	private EmployeeDAOImpl empDaoImpl=new EmployeeDAOImpl();
	
	boolean flag = false;
	int empId;
	String password;

	private Employee generatePassword(Employee employee) {
		password = employee.getEmpId() + "_" + employee.getDateOfBirth();
		employee.setPassword(password);
		return employee;

	}

	public boolean registerEmployee(Employee emp)throws CommercialCustRegException {
			empId = (int) empDao.addEmployee(emp);
			if (empId != 0) {
				emp.setEmpId(empId);
				emp = generatePassword(emp);
				flag = empDao.setEmpPassword(emp);
			} else
				flag = false;

		return flag;
	}

	public List<Employee> viewEmployees() throws CommercialCustRegException {
		empList=empDao.viewEmployee();
		return empList;
	}

	public Employee searchEmpDetails(int empId) throws CommercialCustRegException {
		Employee emp=new Employee();
		emp=(Employee)empDaoImpl.searchDetails(empId);
		return emp;
	}

	public List<String> getDesignation() throws CommercialCustRegException {
		desigList=empDaoImpl.getDesigFromDB();
		return desigList;
	}

	public boolean updateEmployee(Employee emp) throws CommercialCustRegException {
		flag=empDao.updateEmpInDB(emp);
		return flag;
	}

	public List<String> getBranchNames() throws CommercialCustRegException {
		
		branchList=(List<String>)empDaoImpl.getBranchFromDB();
		return branchList;
	}

	public boolean deactivateEmp(Employee emp) throws CommercialCustRegException {
		flag=empDao.deactivateEmpDB(emp);
		return flag;
	}

	public boolean activateEmp(int empId) throws CommercialCustRegException {
		flag=empDao.activate(empId);
		return flag;
	}

	/*public List<Employee> searchByName(String name) throws CommercialCustRegException {
		empList=empDaoImpl.searchByNameDB(name);
		return empList;
	}

	public List<Employee> searchById(int empId) throws CommercialCustRegException {
		empList=empDaoImpl.searchByIdDB(empId);
		return empList;
		
	}*/

	
	public boolean changePwd(Employee emp) throws CommercialCustRegException {
	 return empDaoImpl.changePasswd(emp);

	}

	public boolean resetPassword(Employee emp) throws CommercialCustRegException {
		emp=generatePassword(emp);
		return empDao.resetEmpPassword(emp);
	}

	

}
