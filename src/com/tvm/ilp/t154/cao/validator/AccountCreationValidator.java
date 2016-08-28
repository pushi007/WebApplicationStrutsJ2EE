package com.tvm.ilp.t154.cao.validator;

import java.util.HashMap;

import com.tvm.ilp.t154.cao.bean.AccountcreationBean;

public class AccountCreationValidator {

	public static HashMap<String, String> validate(AccountcreationBean bean) {

		HashMap<String, String> map = new HashMap<String, String>();
		if (bean.getAccountType() == null) 
		{

			map.put("AccountType", "Please select the Account Type");
		}
		return map;
	}
}
