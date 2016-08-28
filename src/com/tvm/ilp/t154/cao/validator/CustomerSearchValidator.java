package com.tvm.ilp.t154.cao.validator;

import java.util.HashMap;
import java.util.regex.Pattern;

import com.tvm.ilp.t154.cao.bean.CustomerBean;

public class CustomerSearchValidator {
	public static HashMap<String, String> validate(CustomerBean bean) {

		HashMap<String, String> map = new HashMap<String, String>();

		if (bean.getBusinessName() == null
				|| bean.getBusinessName().trim().length() == 0
				|| bean.getBusinessName() == "") {

			map.put("bName", "Please enter Business Name");
		} else if (bean.getBusinessName() != null) {
			Pattern pattern = Pattern.compile("([A-Za-z]{3,30})");
			boolean flag = pattern.matcher(bean.getBusinessName()).matches();
			if (flag) {

			} else {
				map.put("bName", "Please enter valid business name");

			}
		}

		if (bean.getBranchName() == null
				|| bean.getBranchName().trim().length() == 0
				|| bean.getBranchName() == "") {

			map.put("bbrName", "Please select Branch Name");
		}

		return map;

	}
}
