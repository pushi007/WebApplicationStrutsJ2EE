/**
 * 
 */
package com.tvm.ilp.t154.cao.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 597142
 *
 */
public class DateUtill {
	
	public static java.sql.Date converDate(String dateToday) {
		java.sql.Date sqldate=null;
		try{
		String str = dateToday;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
		java.util.Date dt = formatter.parse(str);
		sqldate=new java.sql.Date(dt.getTime());
		}catch(Exception e){
		e.printStackTrace(); 
		} 

		return sqldate;
	}
}
