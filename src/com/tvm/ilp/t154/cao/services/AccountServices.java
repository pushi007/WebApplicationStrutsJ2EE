/**
 * 
 */
package com.tvm.ilp.t154.cao.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.jfree.data.jdbc.JDBCCategoryDataset;
import org.jfree.data.jdbc.JDBCPieDataset;

import com.tvm.ilp.t154.cao.dao.AccountCreationDAO;
import com.tvm.ilp.t154.cao.dao.AdditionalProductDao;
import com.tvm.ilp.t154.cao.dao.ChartDao;
import com.tvm.ilp.t154.cao.dao.SearchCustomerDAO;
import com.tvm.ilp.t154.cao.dao.SearchRelationshipManagerDao;
import com.tvm.ilp.t154.cao.exceptions.AccountCreationException;
import com.tvm.ilp.t154.cao.exceptions.CommercialCustRegException;
import com.tvm.ilp.t154.cao.model.AdditionalProduct;
import com.tvm.ilp.t154.cao.model.AddressDetails;
import com.tvm.ilp.t154.cao.model.Branch;
import com.tvm.ilp.t154.cao.model.BusinessCustomer;
import com.tvm.ilp.t154.cao.model.CountryReport;
import com.tvm.ilp.t154.cao.model.NonPersonalAccount;
import com.tvm.ilp.t154.cao.model.NonPersonalAccountInProgress;
import com.tvm.ilp.t154.cao.model.NonPersonalCustomer;
import com.tvm.ilp.t154.cao.model.NonPersonalParty;
import com.tvm.ilp.t154.cao.model.Product;
import com.tvm.ilp.t154.cao.model.RelationshipManager;

public class AccountServices {
	SearchRelationshipManagerDao srmdao = new SearchRelationshipManagerDao();
	AdditionalProductDao apDao = new AdditionalProductDao();
	AccountCreationDAO acdao = new AccountCreationDAO();
	SearchCustomerDAO scdao = new SearchCustomerDAO();
	ChartDao chDao = new ChartDao();
	List<BusinessCustomer> searchList;
	List<String> branches;

	public List<NonPersonalParty> searchBusinessDetails(String businessName)
			throws AccountCreationException {

		return srmdao.searchBusinessDetails(businessName);
	}

	// NPA
	
	public List<CountryReport> getCountryDetails(String month,String year)
	{
		return chDao.getCountryDetails(month, year);
	}

	public Product getProductName(long pid) throws AccountCreationException {
		return acdao.getProductName(pid);
	}

	public int getAccounts(String AccountType, long npid) throws SQLException,
			AccountCreationException {

		return acdao.getAccounts(AccountType, npid);

	}

	public AddressDetails getAddressDetails(long npid)
			throws AccountCreationException {

		return scdao.getAddressDetails(npid);
	}

	public List<Product> sortProductPem(String AccountType, String BusinessName)
			throws AccountCreationException {

		return acdao.sortProductPem(AccountType, BusinessName);

	}

	public JDBCPieDataset viewPie(String month,String year) {
		JDBCPieDataset dataset = null;
		dataset = chDao.viewPie(month,year);
		return dataset;
	}

	public JDBCCategoryDataset viewBar(String month,String year) {
		JDBCCategoryDataset dataset = null;
		dataset = chDao.viewBar(month,year);
		return dataset;
	}

	public ArrayList<Branch> getBranchList() throws AccountCreationException,
			SQLException {

		return scdao.getBranchList();

	}

	public long getAccountNumber() throws AccountCreationException {
		return acdao.getAccountNumber();
	}

	public List<Product> getProduct() throws AccountCreationException {
		return acdao.getProduct();

	}

	/*
	 * public ArrayList<String> retrieveBranches() throws SQLException {
	 * branches=new ArrayList<String>();
	 * return((ArrayList<String>)scdao.retrieveBranches()); }
	 */

	// Search by Business Name and Branch Name
	public ArrayList<BusinessCustomer> searchByBusiness(String businessName,
			String branch) throws AccountCreationException {

		return scdao.searchByBusiness(businessName, branch);

	}

	public ArrayList<BusinessCustomer> searchByTrading(String tradingName,
			String branch) throws AccountCreationException {

		return scdao.searchByTrading(tradingName, branch);

	}

	public BusinessCustomer searchByAccountNo(long accountNo)
			throws AccountCreationException {

		return scdao.searchByAccountNo(accountNo);
	}

	public boolean addBusinessCustAccount(NonPersonalAccount npa)
			throws AccountCreationException {

		return acdao.addBusinessCustAccount(npa);

	}

	public int getProductID(String name) throws AccountCreationException {
		return acdao.getProductID(name);
	}

	public NonPersonalAccount getSummary(long accNo)
			throws AccountCreationException {
		return acdao.getSummary(accNo);
	}

	//
	public NonPersonalAccount searchAccount(long number)
			throws AccountCreationException {
		NonPersonalAccount account = new NonPersonalAccount();
		account = apDao.searchAccountNumber(number);

		return account;
	}

	public boolean updateStatus(long accountNumber, String status)
			throws AccountCreationException {
		boolean flag = false;
		flag = apDao.updateStatus(accountNumber, status);
		return flag;
	}

	public List<AdditionalProduct> searchAdditionalProduct(
			NonPersonalAccount account) throws AccountCreationException {
		List<AdditionalProduct> pList = new ArrayList<AdditionalProduct>();
		pList = apDao.searchProduct(account);
		return pList;
	}

	public boolean addAdditionalProduct(String name, long number)
			throws AccountCreationException {
		boolean flag = false;
		AdditionalProduct product = new AdditionalProduct();

		product = apDao.searchProductId(name, number);
		flag = apDao.addProduct(product.getAdditionalProductId(), number);
		return flag;

	}

	public List<NonPersonalParty> search(String tradingName)
			throws AccountCreationException {

		return srmdao.search(tradingName);

	}

	public NonPersonalParty searchNPParty(String businessName, int npId)
			throws AccountCreationException {
		return srmdao.searchNPParty(businessName, npId);

	}

	public NonPersonalParty searchNP(int npId) throws AccountCreationException {

		return srmdao.searchNP(npId);
	}

	public Branch searchBranch(String branchId) throws AccountCreationException {

		return srmdao.searchBranchName(branchId);
	}

	public ArrayList<RelationshipManager> listOfManager(String designation,
			String branchId) throws AccountCreationException {
		ArrayList<RelationshipManager> rmList = new ArrayList<RelationshipManager>();

		rmList = srmdao.listOfManager(designation, branchId);

		return rmList;
	}

	public List<Branch> getBranch() throws AccountCreationException {
		List<Branch> branchList = null;

		branchList = srmdao.getBranch();

		return branchList;
	}

	public RelationshipManager searchName(long rmassigned)
			throws AccountCreationException {
		RelationshipManager rm = null;

		rm = srmdao.searchName(rmassigned);

		return rm;
	}

	public NonPersonalParty searchNPersonal(int npId)
			throws AccountCreationException {

		return srmdao.searchNPersonal(npId);

	}

	public Branch searchBranchID(String branchName)
			throws AccountCreationException {
		Branch b = null;

		b = srmdao.searchBranchID(branchName);

		return b;
	}

	public RelationshipManager getEmployeeId(String Name)
			throws AccountCreationException {
		return srmdao.getEmployeeId(Name);

	}

	public NonPersonalParty searchTrading(String businessName)
			throws AccountCreationException {
		return srmdao.searchTrading(businessName);

	}

	public boolean addEntry(long rmassigned, int npid)
			throws AccountCreationException {
		boolean flag = false;

		flag = srmdao.addEntry(rmassigned, npid);

		return flag;
	}

	public boolean addEntries(int rmassigned, int npid, String branchID)
			throws AccountCreationException {
		boolean flag;

		flag = srmdao.addEntries(rmassigned, npid, branchID);

		return flag;

	}

	public NonPersonalParty getBusinessDetails(int npid)
			throws AccountCreationException {
		NonPersonalParty npp = null;

		npp = srmdao.getBusinessDetails(npid);

		return npp;
	}



	public List<String> getBNames() throws CommercialCustRegException {

		return chDao.getBNames();
	}

	public int noOfCurrentAccount(List<NonPersonalAccount> accountList) {
		int count = 0;
		for (NonPersonalAccount npAccount : accountList) {
			if (npAccount.getAccountType().equalsIgnoreCase("current account")) {
				count++;
			}
		}
		return count;
	}

	public int noOfSavingAccount(List<NonPersonalAccount> accountList) {
		int count = 0;
		for (NonPersonalAccount npAccount : accountList) {
			if (npAccount.getAccountType().equalsIgnoreCase("savings account")) {
				count++;
			}
		}
		return count;
	}

	public int noOfCurrentActiveAccount(List<NonPersonalAccount> accountList) {

		int count = 0;
		for (NonPersonalAccount npAccount : accountList) {
			if (npAccount.getAccountType().equalsIgnoreCase("current account")
					&& npAccount.getStatus().equalsIgnoreCase("active")) {
				count++;
			}
		}
		return count;
	}

	public int noOfCurrentInactiveAccount(List<NonPersonalAccount> accountList) {

		int count = 0;
		for (NonPersonalAccount npAccount : accountList) {
			if (npAccount.getAccountType().equalsIgnoreCase("current account")
					&& npAccount.getStatus().equalsIgnoreCase("inactive")) {
				count++;
			}
		}
		return count;
	}

	public int noOfSavingsInProgressAccount(List<NonPersonalAccount> accountList) {

		int count = 0;
		for (NonPersonalAccount npAccount : accountList) {
			if (npAccount.getAccountType().equalsIgnoreCase("savings account")
					&& npAccount.getStatus().equalsIgnoreCase("in progress")) {
				count++;
			}
		}
		return count;
	}

	public int noOfSavingsActiveAccount(List<NonPersonalAccount> accountList) {

		int count = 0;
		for (NonPersonalAccount npAccount : accountList) {
			if (npAccount.getAccountType().equalsIgnoreCase("savings account")
					&& npAccount.getStatus().equalsIgnoreCase("active")) {
				count++;
			}
		}
		return count;
	}

	public int noOfSavingsInactiveAccount(List<NonPersonalAccount> accountList) {

		int count = 0;
		for (NonPersonalAccount npAccount : accountList) {
			if (npAccount.getAccountType().equalsIgnoreCase("savings account")
					&& npAccount.getStatus().equalsIgnoreCase("inactive")) {
				count++;
			}
		}
		return count;
	}

	public int noOfCurrentInProgressAccount(List<NonPersonalAccount> accountList) {

		int count = 0;
		for (NonPersonalAccount npAccount : accountList) {
			if (npAccount.getAccountType().equalsIgnoreCase("current account")
					&& npAccount.getStatus().equalsIgnoreCase("in progress")) {
				count++;
			}
		}
		return count;
	}

	public float percentageOfCurrentAccount(List<NonPersonalAccount> accountList) {
		float count = 0;
		count = (noOfCurrentAccount(accountList) * 100)
				/ (float) accountList.size();

		return count;
	}

	public float percentageOfSavingAccount(List<NonPersonalAccount> accountList) {
		float count = 0;
		count = (noOfSavingAccount(accountList) * 100)
				/ (float) accountList.size();
		return count;
	}

	public float percentageOfCurrentActiveAccount(
			List<NonPersonalAccount> accountList) {
		float count = 0;
		count = (noOfCurrentActiveAccount(accountList) * 100)
				/ (float) accountList.size();
		return count;
	}

	public float percentageOfCurrentInactiveAccount(
			List<NonPersonalAccount> accountList) {
		float count = 0;
		count = (noOfCurrentInactiveAccount(accountList) * 100)
				/ (float) accountList.size();

		return count;
	}

	public float percentageOfCurrentInProgressAccount(
			List<NonPersonalAccount> accountList) {
		float count = 0;
		count = (noOfCurrentInProgressAccount(accountList) * 100)
				/ (float) accountList.size();
		return count;
	}

	public float percentageOfSavingActiveAccount(
			List<NonPersonalAccount> accountList) {
		float count = 0;
		count = (noOfSavingsActiveAccount(accountList) * 100)
				/ (float) accountList.size();
		return count;
	}

	public float percentageOfSavingInactiveAccount(
			List<NonPersonalAccount> accountList) {
		float count = 0;
		count = (noOfSavingsInactiveAccount(accountList) * 100)
				/ (float) accountList.size();
		return count;
	}

	public float percentageOfSavingInProgressAccount(
			List<NonPersonalAccount> accountList) {
		float count = 0;
		count = (noOfSavingsInProgressAccount(accountList) * 100)
				/ (float) accountList.size();
		return count;
	}

	public NonPersonalCustomer generateReportByBName(int npId) {
		AccountCreationDAO acDao = new AccountCreationDAO();

		return acDao.genarateReportbyBuisName(npId);
	}

	public NonPersonalCustomer generateReportByBNameAndMonth(String month) {
		AccountCreationDAO acDao = new AccountCreationDAO();

		return acDao.genarateReportbyMonthAndBuisName(month);
	}

	public NonPersonalCustomer generateReportByBNameAndYEar(String month, String year) {
		AccountCreationDAO acDao = new AccountCreationDAO();

		return acDao.genarateReportbyBuisNameAndYear(month, year);
	}

	public JDBCCategoryDataset viewBarCAO(int bid) {
		JDBCCategoryDataset dataset = null;
		dataset = chDao.viewBarCAO(bid);
		return dataset;
	}
	
	public JDBCPieDataset viewPieCAO(int bid) {
		JDBCPieDataset dataset = null;
		dataset = chDao.viewPieCAO(bid);
		return dataset;
	}

	public JDBCPieDataset viewPieCAOMonth(String month) {
		JDBCPieDataset dataset = null;
		dataset = chDao.viewPieCAOMonth(month);
		return dataset;
	}

	public JDBCPieDataset viewPieCAOYear(String month, String year) {
		JDBCPieDataset dataset = null;
		dataset = chDao.viewPieCAOYear(month, year);
		return dataset;
	}

	public JDBCCategoryDataset viewBarCAOMonth(String month) {
		JDBCCategoryDataset dataset = null;
		dataset = chDao.viewBarCAOMonth(month);
		return dataset;
	}

	public JDBCCategoryDataset viewBarCAOYear(String month, String year) {
		JDBCCategoryDataset dataset = null;
		dataset = chDao.viewBarCAOYear(month, year);
		return dataset;
	}

	public List<NonPersonalCustomer> getBusinessNameAndId() {
		return (new AccountCreationDAO()).getCustomerNameAndId();
	}

}
