/**
 * 
 */
package com.tvm.ilp.t154.cao.controllers;

import com.opensymphony.xwork2.ActionSupport;
import com.tvm.ilp.t154.cao.model.Employee;
import com.tvm.ilp.t154.cao.services.LoginService;

/**
 * @author 582976
 * 
 */
public class LoginAction extends ActionSupport {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	private String UID;
	private String pwd;

	public String getUID() {
		return UID;
	}

	public void setUID(String uID) {
		UID = uID;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String execute() throws Exception {
		LoginService loginSer = new LoginService();
		int empId = Integer.parseInt(UID);
		Employee emp = loginSer.getEmpDetails(empId);

		if (emp != null) {
			if (emp.getEmpId() == empId && emp.getPassword() == pwd) {
				return "success";
				
			}else{
				return "failure";
			}
		} else {
			return "failure";
		}
		
	}

}
