package com.tvm.ilp.t154.cao.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author 668552
 * 
 */
public class CAOUtility {

	public static Date convertStringToDate(String dateStr) {
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		Date date = null;
		try {
			date = df.parse(dateStr);
		} catch (ParseException e) {

			e.printStackTrace();
		}
		return date;
	}

	public static String convertDateToString(Date date) {
		return date.toString();

	}
	
	public static java.sql.Date convertJavaDateToSqlDate(Date date){
		String dateString=date.toString();
		java.sql.Date sqlDate=java.sql.Date.valueOf(dateString);
		
		return sqlDate;
	}
	
	public static java.util.Date convertSqlDateToJavaDate(java.sql.Date date){
		
		
		return null;
	}
}
