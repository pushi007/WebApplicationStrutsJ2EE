//validation for additional details form
function validateRegAdditionalForm() {
	var industrySector = document.updateAdditional_form.industrySector.value;
	var mainActivity = document.updateAdditional_form.mainActivity.value;
	var preciseActivity = document.updateAdditional_form.preciseActivity.value;
	var importExport = document.updateAdditional_form.importExport[0].checked;
	var importExportx = document.updateAdditional_form.importExport[1].checked;
	var requireFunding = document.updateAdditional_form.requireFunding[0].checked;
	var requireFunding1 = document.updateAdditional_form.requireFunding[1].checked;
	var part = document.updateAdditional_form.partOfGroup[0].checked;
	var part1 = document.updateAdditional_form.partOfGroup[1].checked;

	if (validateIndustrySec() == false) {

		return false;

	} else {

		document.getElementById("error_industrysector").innerHTML = "";
		document.updateAdditional_form.mainActivity.focus();

	}

	if (validateMainActivity() == false) {

		return false;
	} else {
		document.getElementById("error_mainActivity").innerHTML = "";
		document.updateAdditional_form.preciseActivity.focus();
	}

	if (validatePreciseActivity() == false) {

		return false;
	} else {
		document.getElementById("error_preciseActivity").innerHTML = "";

	}

	if (importExport == false && importExportx == false) {
		document.getElementById("error_importExport").innerHTML = "Please check import/export goods";
		return false;
	} else {

		document.getElementById("error_importExport").innerHTML = "";

	}
	if (requireFunding == false && requireFunding1 == false) {
		document.getElementById("error_fund").innerHTML = "Please check if funding is required";
		return false;
	} else {
		document.getElementById("error_fund").innerHTML = "";
		if(validateFundingAmount()==false){
			
			return false;
		}

	}
	if (part == false && part1 == false) {
		document.getElementById("error_part").innerHTML = "Please check are you a part of group/franchise";
		return false;
	} else {
		document.getElementById("error_part").innerHTML = "";
		if(validatePartGroup()==false){
			return false;
			
		}else{
		document.updateAdditional_form.submit();
		return true;
		}
	}

}

function validateIndustrySec() {
	var industrySector = document.updateAdditional_form.industrySector.value;

	if (industrySector == 0) {
		document.getElementById("error_industrysector").innerHTML = "Please select Industry Sector";
		return false;
	} else {
		document.getElementById("error_industrysector").innerHTML = "";

		return true;
	}

}
function validateMainActivity() {
	var mainActivity = document.updateAdditional_form.mainActivity.value;
	var alphaExp = /^[a-zA-Z]+$/;
	if (mainActivity == "" || mainActivity == null) {
		document.getElementById("error_mainActivity").innerHTML = "Please enter Main Activity";
		return false;
	} else if (!mainActivity.match(alphaExp)) {
		document.getElementById("error_mainActivity").innerHTML = "Please enter alphabets only";
		return false;
	} else if (mainActivity.length < 5 || mainActivity.length > 30) {
		document.getElementById("error_mainActivity").innerHTML = "Main activity could be 5 to 30 alphabets long";
	} else {
		document.getElementById("error_mainActivity").innerHTML = "";
		return true;

	}

}
function validatePreciseActivity() {
	var preciseActivity = document.updateAdditional_form.preciseActivity.value;
	var alphaExp = /^[a-zA-Z]+$/;
	if (preciseActivity == "" || preciseActivity == null) {
		document.getElementById("error_preciseActivity").innerHTML = "Please enter Precise Activity";
		return false;
	} else if (!preciseActivity.match(alphaExp)) {
		document.getElementById("error_preciseActivity").innerHTML = "Please enter alphabets only";
		return false;
	} else if (preciseActivity.length < 5 || preciseActivity.length > 30) {
		document.getElementById("error_preciseActivity").innerHTML = "Precise activity could be 5 to 30 alphabets long";
	} else {
		document.getElementById("error_preciseActivity").innerHTML = "";
		return true;

	}

}
function validateFunding() {
	var importExport = document.updateAdditional_form.importExport[0].checked;
	var importExportx = document.updateAdditional_form.importExport[1].checked;
	if (importExport == false && importExportx == false) {
		document.getElementById("error_fund").innerHTML = "Please check import/export goods";
		return false;
	} else {

		document.getElementById("error_fund").innerHTML = "";
		return true;

	}
}
function validateFundingAmount() {
	var fundAmount = document.updateAdditional_form.fundAmount.value;
	var digitAnnual = /^([0-9]+)(\.[0-9]{1,2})?$/;
	if (document.getElementById("yes").checked == true) {
		if (fundAmount == "" || fundAmount == 0) {
			document.getElementById("error_fundamount").innerHTML = "Please enter funding amount ";
			return false;
		} else if (!fundAmount.match(digitAnnual)) {
			document.getElementById("error_fundamount").innerHTML = "Please enter a number less than 5000";
			return false;
		}

		else {
			document.getElementById("error_fundamount").innerHTML = "";
			return true;
		}
	} else {
		document.getElementById("error_fundamount").innerHTML = "";

	}
}

function validatePartGroup() {
	var franchiseDetails = document.updateAdditional_form.franchiseDetails.value;
	if(document.getElementById("partFranchiseYes").checked==true){
	if (franchiseDetails == "" || franchiseDetails == null) {
		document.getElementById("error_groupdetails").innerHTML = "Please enter Franchise/Group details";
		return false;
	} else {
		document.getElementById("error_groupdetails").innerHTML = "";
		return true;
	}
	}else{
		document.getElementById("error_groupdetails").innerHTML = "";
	}
}

function reg() {
	if (document.getElementById("yes").checked == true) {

		document.updateAdditional_form.fundAmount.disabled = false;
	} else {
		document.updateAdditional_form.fundAmount.value = "";
		document.updateAdditional_form.fundAmount.disabled = true;

	}
	if (document.getElementById("partFranchiseYes").checked == true) {
		document.updateAdditional_form.franchiseDetails.disabled = false;

	} else {
		document.updateAdditional_form.franchiseDetails.value = "";
		document.updateAdditional_form.franchiseDetails.disabled = true;

	}

}

function  doImportExport() {
	var importExport = document.updateAdditional_form.importExport[0].checked;
	var importExportx = document.updateAdditional_form.importExport[1].checked;
	if(importExport==false&&importExportx==false){
		document.getElementById("error_importExport").innerHTML = "Please check import/export goods";
		return false;
	}else{
		document.getElementById("error_importExport").innerHTML = "";
	return true;
	}
	
	
}
function doRequireFund() {
	var requireFunding = document.updateAdditional_form.requireFunding[0].checked;
	var requireFunding1 = document.updateAdditional_form.requireFunding[1].checked;
	if(requireFunding==false&&requireFunding1==false){
		document.getElementById("error_fund").innerHTML = "Please check require funding";
		return false;
	}else{
		document.getElementById("error_fund").innerHTML = "";
		return true;
	}
}
function arePartOfGroup() {
	var part = document.updateAdditional_form.partOfGroup[0].checked;
	var part1 = document.updateAdditional_form.partOfGroup[1].checked;
	if(part==false&&part1==false){
		document.getElementById("error_part").innerHTML = "Please check are you part of group/franchise";
		return false;
		
		
	}else{
		document.getElementById("error_part").innerHTML = "";
		return true;
		
	}
	
}
