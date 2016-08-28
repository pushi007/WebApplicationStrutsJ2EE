/**
 * 
 */
package com.tvm.ilp.t154.cao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.jfree.data.jdbc.JDBCCategoryDataset;
import org.jfree.data.jdbc.JDBCPieDataset;

import com.itextpdf.text.log.SysoLogger;
import com.tvm.ilp.t154.cao.exceptions.CommercialCustRegException;
import com.tvm.ilp.t154.cao.model.Country;
import com.tvm.ilp.t154.cao.model.CountryReport;
import com.tvm.ilp.t154.cao.utils.ConnectionUtil;

/**
 * @author 589768
 * 
 */
public class ChartDao {

	public List<CountryReport> getCountryDetails(String month,String year)
	{
		Connection con = null;
		PreparedStatement ps=null;
		List<CountryReport> countryList=new ArrayList<CountryReport>();
		try {
			con = ConnectionUtil.getConnection();
			
		ps=con.prepareStatement("SELECT npp.COUNTRY_OF_REGISTRATION,COUNT(npp.COUNTRY_OF_REGISTRATION) FROM NON_PERSONAL_PARTY npp inner join NON_PERSONAL_ID id on npp.NP_ID=id.NPID where TO_CHAR(id.SUBMITED_DATE,'MM')="+month+ "AND TO_CHAR(id.SUBMITED_DATE,'YYYY')="+year+ "GROUP BY npp.COUNTRY_OF_REGISTRATION");					
		
		ResultSet rs=ps.executeQuery();
		
		while(rs.next())
		{
			CountryReport c=new CountryReport();
			c.setCountry(rs.getString(1));
			c.setCount(rs.getInt(2));
			countryList.add(c);
			
			
		}
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return countryList;

	}
	
	
	public JDBCPieDataset viewPie(String month,String year) {
		Connection con = null;
		JDBCPieDataset dataset = null;
		try {
			con = ConnectionUtil.getConnection();
			dataset = new JDBCPieDataset(con);
			dataset
					.executeQuery("SELECT npp.COUNTRY_OF_REGISTRATION,COUNT(npp.COUNTRY_OF_REGISTRATION) FROM NON_PERSONAL_PARTY npp inner join NON_PERSONAL_ID id on npp.NP_ID=id.NPID where TO_CHAR(id.SUBMITED_DATE,'MM')="+month+ "AND TO_CHAR(id.SUBMITED_DATE,'YYYY')="+year+ "GROUP BY npp.COUNTRY_OF_REGISTRATION");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dataset;

	}

	public JDBCCategoryDataset viewBar(String month,String year) {
		Connection con = null;
		JDBCCategoryDataset dataset = null;

		try {
			con = ConnectionUtil.getConnection();
			dataset = new JDBCCategoryDataset(con);
			dataset
					.executeQuery("SELECT npp.COUNTRY_OF_REGISTRATION,COUNT(npp.COUNTRY_OF_REGISTRATION) FROM NON_PERSONAL_PARTY npp inner join NON_PERSONAL_ID id on npp.NP_ID=id.NPID where TO_CHAR(id.SUBMITED_DATE,'MM')="+month+ "AND TO_CHAR(id.SUBMITED_DATE,'YYYY')="+year+ "GROUP BY npp.COUNTRY_OF_REGISTRATION");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataset;
	}

	public JDBCPieDataset viewPieCAO(int bid) {
		Connection con = null;
		JDBCPieDataset dataset = null;

		try {
			con = ConnectionUtil.getConnection();
			dataset = new JDBCPieDataset(con);
			
			dataset
					.executeQuery("SELECT ACCOUNTTYPE_NAME,COUNT(ACCOUNTTYPE_NAME) FROM NON_PERSONAL_ACCOUNT INNER JOIN NON_PERSONAL_PARTY ON NON_PERSONAL_ACCOUNT.NP_ID=NON_PERSONAL_PARTY.NP_ID where NON_PERSONAL_ACCOUNT.NP_ID="+bid+" GROUP BY NON_PERSONAL_ACCOUNT.ACCOUNTTYPE_NAME,NON_PERSONAL_PARTY.BUSINESS_NAME");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dataset;
	}

	public JDBCCategoryDataset viewBarCAO(int  bid) {
		Connection con = null;
		JDBCCategoryDataset dataset = null;

		try {
			con = ConnectionUtil.getConnection();
			dataset = new JDBCCategoryDataset(con);
			
			dataset
					.executeQuery("SELECT ACCOUNTTYPE_NAME,COUNT(ACCOUNTTYPE_NAME) FROM NON_PERSONAL_ACCOUNT INNER JOIN NON_PERSONAL_PARTY ON NON_PERSONAL_ACCOUNT.NP_ID=NON_PERSONAL_PARTY.NP_ID where NON_PERSONAL_ACCOUNT.NP_ID="+bid+" GROUP BY NON_PERSONAL_ACCOUNT.ACCOUNTTYPE_NAME,NON_PERSONAL_PARTY.BUSINESS_NAME");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataset;
	}
	
	public List<String> getBNames() throws CommercialCustRegException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<String> bNames = new ArrayList<String>();

		try {
			try {
				con = ConnectionUtil.getConnection();
			} catch (SQLException e) {
				throw new CommercialCustRegException("Connection Problem");
			}

			try {
				ps = con
						.prepareStatement("SELECT DISTINCT(BUSINESS_NAME) FROM NON_PERSONAL_ACCOUNT INNER JOIN NON_PERSONAL_PARTY ON NON_PERSONAL_ACCOUNT.NP_ID=NON_PERSONAL_PARTY.NP_ID GROUP BY NON_PERSONAL_ACCOUNT.ACCOUNTTYPE_NAME,NON_PERSONAL_PARTY.BUSINESS_NAME");
				rs = ps.executeQuery();

				while (rs.next()) {
					bNames.add(rs.getString(1));

				}
			} catch (SQLException e) {
				throw new CommercialCustRegException(
						"Business names not available");
			}

		} catch (ClassNotFoundException e) {
			throw new CommercialCustRegException("Connection Problem");

		} finally {
			try {
				ConnectionUtil.closePreparedStatement(ps);
				ConnectionUtil.closeConnection(con);
			} catch (SQLException e) {
				throw new CommercialCustRegException("Connection Problem");
			}

		}
		return bNames;
	}

	public JDBCPieDataset viewPieCAOMonth(String month) {
		Connection con = null;
		JDBCPieDataset dataset = null;

		try {
			con = ConnectionUtil.getConnection();
			dataset = new JDBCPieDataset(con);
							
			dataset
					.executeQuery("SELECT ACCOUNTTYPE_NAME,COUNT(ACCOUNTTYPE_NAME) FROM NON_PERSONAL_ACCOUNT INNER JOIN NON_PERSONAL_PARTY ON NON_PERSONAL_ACCOUNT.NP_ID=NON_PERSONAL_PARTY.NP_ID where TO_CHAR(ACCOUNT_OPEN_DATE,'yyyy')='"+month +"' GROUP BY ACCOUNTTYPE_NAME");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dataset;
	}

	public JDBCPieDataset viewPieCAOYear(String month, String year) {
		Connection con = null;
		JDBCPieDataset dataset = null;

		try {
			con = ConnectionUtil.getConnection();
			dataset = new JDBCPieDataset(con);
			
			dataset
			.executeQuery("SELECT ACCOUNTTYPE_NAME,COUNT(ACCOUNTTYPE_NAME) FROM NON_PERSONAL_ACCOUNT INNER JOIN NON_PERSONAL_PARTY ON NON_PERSONAL_ACCOUNT.NP_ID=NON_PERSONAL_PARTY.NP_ID where TO_CHAR(ACCOUNT_OPEN_DATE,'mm')='"+month +"' AND TO_CHAR(ACCOUNT_OPEN_DATE,'yyyy')='"+year+"' GROUP BY ACCOUNTTYPE_NAME");
			
			
			

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dataset;
	}

	public JDBCCategoryDataset viewBarCAOMonth(String month) {
		Connection con = null;
		JDBCCategoryDataset dataset = null;

		try {
			con = ConnectionUtil.getConnection();
			dataset = new JDBCCategoryDataset(con);
			
			dataset
					.executeQuery("SELECT ACCOUNTTYPE_NAME,COUNT(ACCOUNTTYPE_NAME) FROM NON_PERSONAL_ACCOUNT INNER JOIN NON_PERSONAL_PARTY ON NON_PERSONAL_ACCOUNT.NP_ID=NON_PERSONAL_PARTY.NP_ID where TO_CHAR(ACCOUNT_OPEN_DATE,'yyyy')='"+month +"' GROUP BY ACCOUNTTYPE_NAME");
						
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataset;
	}

	public JDBCCategoryDataset viewBarCAOYear(String month,
			String year) {
		Connection con = null;
		JDBCCategoryDataset dataset = null;

		try {
			con = ConnectionUtil.getConnection();
			dataset = new JDBCCategoryDataset(con);
			
			dataset
					.executeQuery("SELECT ACCOUNTTYPE_NAME,COUNT(ACCOUNTTYPE_NAME) FROM NON_PERSONAL_ACCOUNT INNER JOIN NON_PERSONAL_PARTY ON NON_PERSONAL_ACCOUNT.NP_ID=NON_PERSONAL_PARTY.NP_ID where TO_CHAR(ACCOUNT_OPEN_DATE,'mm')='"+month +"' AND TO_CHAR(ACCOUNT_OPEN_DATE,'yyyy')='"+year+"' GROUP BY  ACCOUNTTYPE_NAME");
						
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataset;
	}
}
