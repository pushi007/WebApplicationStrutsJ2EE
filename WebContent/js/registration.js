//register Core details form validation 

// search business customer form validation

function validateSearchForm() {
	var searchBy = document.search_form.searchBy.value;
	if (searchBy == 0) {

		document.getElementById("error_searchby").innerHTML = "Please select search by option";

		return false;

	} else {

		document.getElementById("error_searchby").innerHTML = "";

	}
	if (searchBy == "businessName") {

		if (searchBusinessName() == false) {

			return false;

		} else {
			
			document.getElementById("error_businessName").innerHTML = "";
			
		}if(validateBranch()==false){
			return false;
		}else{
			document.getElementById("error_branch").innerHTML = "";
			document.search_form.submit();
			return true;
		}

	}
	if (searchBy == "tradingName") {

		if (searchTradeName() == false) {

			return false;

		} else {

			document.getElementById("error_tradeName").innerHTML = "";
			
		}
		if(validateBranch()==false){
			return false;
		}else{
			document.getElementById("error_branch").innerHTML = "";
			document.search_form.submit();
			return true;
		}
	}
	if (searchBy == "accountNumber") {
		var accountNo = document.search_form.accountNo.value;
		var sampleReg = /^[0-9]+$/;
		if (searchAccount() == false) {

			return false;

		}
		else {
			document.getElementById("error_account").innerHTML = "";
			document.search_form.submit();
			return true;

		}

	}

}

function searchAccount() {
	var searchBy = document.search_form.searchBy.value;
	if (searchBy == "accountNumber") {
		var accountNo = document.search_form.accountNo.value;
		var sampleReg = /^[0-9]+$/;
		if (accountNo == "") {

			document.getElementById("error_account").innerHTML = "Please enter account number.";

			return false;

		}
		if (accountNo == 0) {
			document.getElementById("error_account").innerHTML = "Please check account number.";
			return false;
		} else if (!accountNo.match(sampleReg)) {
			document.getElementById("error_account").innerHTML = "Please check account number.";
			return false;

		} else if (accountNo.length != 14) {
			document.getElementById("error_account").innerHTML = "Please enter 14 digit account number";
			return false;
		} else {
			document.getElementById("error_account").innerHTML = "";

			return true;

		}

	}

}
function searchBusinessName() {

	var searchBy = document.search_form.searchBy.value;
	if (searchBy == "businessName") {
		var businessName = document.search_form.businessName.value;

		if (businessName == "") {

			document.getElementById("error_businessName").innerHTML = "Please enter business name";

			return false;

		} else {
			document.getElementById("error_businessName").innerHTML = "";
			return true;
		}

	}

}

function searchTradeName() {
	var searchBy = document.search_form.searchBy.value;
	if (searchBy == "tradingName") {
		var tradingName = document.search_form.tradeName.value;

		if (tradingName == "") {

			document.getElementById("error_tradeName").innerHTML = "Please enter trading name";

			return false;

		} else {

			document.getElementById("error_tradeName").innerHTML = "";
			return true;
		}

	}
}

function validateBranch() {
	var branch = document.search_form.branch.value;
	if (branch == 0) {

		document.getElementById("error_branch").innerHTML = "Please select branch";

		return false;

	} else {
		document.getElementById("error_branch").innerHTML = "";

		return true;

	}
}

function f() {
	var sel = document.search_form.searchBy.value;
	if (sel != 0) {
		if (sel == "businessName") {
			document.search_form.accountNo.value="";
			document.search_form.tradeName.value="";
			document.search_form.branch.value=0;
			document.search_form.businessName.disabled = false;
			document.search_form.branch.disabled = false;
			document.search_form.tradeName.disabled = true;
			document.search_form.accountNo.disabled = true;
		}
		if (sel == "accountNumber") {
			document.search_form.businessName.value="";
			document.search_form.tradeName.value="";
			document.search_form.branch.value=0;
			document.search_form.businessName.disabled = true;
			document.search_form.branch.disabled = true;
			document.search_form.accountNo.disabled = false;
			document.search_form.tradeName.disabled = true;

		}
		if (sel == "tradingName") {
			document.search_form.accountNo.value="";
			document.search_form.businessName.value="";
			document.search_form.branch.value=0;
			document.search_form.businessName.disabled = true;
			document.search_form.branch.disabled = false;
			document.search_form.accountNo.disabled = true;
			document.search_form.tradeName.disabled = false;
		}

	}
}

function validateDelete() {

	var flag = confirm("Are you sure you want to delete \nBusiness Customer's Profile ?");

	return flag;

}


  function validateFind() {
  
	  if(confirm("Details you entered will be lost.\nDo you want to continue ?")==true)
		{
			window.location.href = "/NBG/CustomerManagementServlet?action=find";
			return true;
		}
		else
		{
			return false;
		}
  }
  
  
  function validateMyPortal() {
	  
	  if(confirm("Data will be lost.\nDo you want to continue ?")==true)
		{
			window.location.href = "/NBG/CustomerManagementServlet?action=accopenerportal";
			return true;
		}
		else
		{
			return false;
		}
  }
  
  function validateFindSummary() {
	  
	  if(confirm("Data will be lost, do you want to continue ?")==true)
		{
			window.location.href = "/NBG/CustomerManagementServlet?action=find";
			return true;
		}
		else
		{
			return false;
		}
  }