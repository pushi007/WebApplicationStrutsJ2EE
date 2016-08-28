// Business Customer Business Address validation
function validateBuildingNoPermanent() {
	var sampleVar = document.regperaddress_form.bnoper.value;
	var alphaExp = /^[a-zA-Z0-9][a-zA-Z0-9\s()-]+$/;
	var alphaExp1 = /^[a-zA-Z0-9]+$/;
	var alphaExp2 = /^[a-zA-Z]+$/;
	if (sampleVar == null || sampleVar == "") {
		document.getElementById("err_bnoper").innerHTML = "Please enter building number";
		return false;
	} else if (!sampleVar.match(alphaExp) && !sampleVar.match(alphaExp1)) {
		document.getElementById("err_bnoper").innerHTML = "Please check building number";
		return false;
	} else if (sampleVar.match(alphaExp2)) {
		document.getElementById("err_bnoper").innerHTML = "Building number should contain numbers and alphabets";
		return false;
	} else if ((sampleVar.length) > 10) {
		document.getElementById("err_bnoper").innerHTML = "Please enter maximum 10 characters";
		return false;

	} else {
		document.getElementById("err_bnoper").innerHTML = "";
		return true;
	}
}

function validateBuildingNamePermanent() {
	var sampleVar = document.regperaddress_form.bnameper.value;
	var alphaExp = /^[a-zA-Z][a-zA-Z\s]+$/;
	if (sampleVar == null || sampleVar == "") {
		document.getElementById("err_bnameper").innerHTML = "Please enter building name";
		return false;
	} else if (!sampleVar.match(alphaExp)) {
		document.getElementById("err_bnameper").innerHTML = "Please check building name";
		return false;
	} else if ((sampleVar.length) < 3 || (sampleVar.length) > 30) {
		document.getElementById("err_bnameper").innerHTML = "Please enter 3-20 alphabets only";
		return false;

	} else {
		document.getElementById("err_bnameper").innerHTML = "";
		return true;
	}
}

function validateStreetNamePermanent() {
	var sampleVar = document.regperaddress_form.snameper.value;
	var alphaExp = /^[a-zA-Z][a-zA-Z\s]+$/;
	if (sampleVar == null || sampleVar == "") {
		document.getElementById("err_snameper").innerHTML = "Please enter street name";
		return false;
	} else if (!sampleVar.match(alphaExp)) {
		document.getElementById("err_snameper").innerHTML = "Please check street name";
		return false;
	} else if ((sampleVar.length) < 3 || (sampleVar.length) > 40) {
		document.getElementById("err_snameper").innerHTML = "Please enter 3-40 alphabets only";
		return false;

	} else {
		document.getElementById("err_snameper").innerHTML = "";
		return true;
	}
}

function validateCityPermanent() {
	var sampleVar = document.regperaddress_form.cityper.value;
	var alphaExp = /^[a-zA-Z][a-zA-Z\s]+$/;
	if (sampleVar == null || sampleVar == "") {
		document.getElementById("err_cityper").innerHTML = "Please enter city name";
		return false;
	} else if (!sampleVar.match(alphaExp)) {
		document.getElementById("err_cityper").innerHTML = "Please check city name";
		return false;
	} else if ((sampleVar.length) < 3 || (sampleVar.length) > 30) {
		document.getElementById("err_cityper").innerHTML = "Please enter 3-30 alphabets only";
		return false;

	} else {
		document.getElementById("err_cityper").innerHTML = "";
		return true;
	}
}

function validateTownPermanent() {
	var sampleVar = document.regperaddress_form.townper.value;
	var alphaExp = /^[a-zA-Z][a-zA-Z\s]+$/;

	if (!sampleVar.match(alphaExp) && (sampleVar.length) > 0) {
		document.getElementById("err_townper").innerHTML = "Please check town name";
		return false;
	} else if (((sampleVar.length) > 0 && (sampleVar.length) < 3)
			|| (sampleVar.length) > 30) {
		document.getElementById("err_townper").innerHTML = "Please enter 3-20 alphabets only";
		return false;

	} else {
		document.getElementById("err_townper").innerHTML = "";
		return true;
	}

}

function validateCountryPermanent() {
	var sampleVar = document.regperaddress_form.countryper.value;
	if (sampleVar == "0") {
		document.getElementById("error_country").innerHTML = "Please select country";
		return false;
	} else {
		document.getElementById("error_country").innerHTML = "";
		return true;
	}
}

function validatePostalCodePermanent() {
	var sampleVar = document.regperaddress_form.pcodeper.value;

	var alphaExp = /^[A-Z0-9][A-Z0-9\s]+$/;
	var alphaExp2 = /^[a-zA-Z]+$/;
	if (sampleVar == null || sampleVar == "") {
		document.getElementById("err_pcodeper").innerHTML = "Please enter postal code";
		return false;
	} else if ((sampleVar.length) > 10 || sampleVar.length < 6) {
		document.getElementById("err_pcodeper").innerHTML = "Please enter 6 to 10 characters.";
		return false;

	} else if (sampleVar.match(alphaExp2)) {
		document.getElementById("err_pcodeper").innerHTML = "Please check postal code.";
		return false;
	} else if (!sampleVar.match(alphaExp)) {
		document.getElementById("err_pcodeper").innerHTML = "Please check postal code";
		return false;
	} else {
		document.getElementById("err_pcodeper").innerHTML = "";
		return true;
	}

}

function validateformper() {
	if (validateBuildingNoPermanent() == false) {

		return true;
	} else if (validateBuildingNamePermanent() == false) {

		return true;
	}

	else if (validateStreetNamePermanent() == false) {

		return true;
	} else if (validateTownPermanent() == false) {

		return true;
	} else if (validateCityPermanent() == false) {

		return true;
	} else if (validateCountryPermanent() == false) {

		return true;
	} else if (validatePostalCodePermanent() == false) {

		return true;
	}
	if (document.regperaddress_form.simcheckpresent[0].checked == false
			&& document.regperaddress_form.simcheckpresent[1].checked == false) {
		document.getElementById("err_simchkpresent").innerHTML = "Please check address similarity";
		return false;
	}

	if (document.regperaddress_form.simcheckcorr[0].checked == false
			&& document.regperaddress_form.simcheckcorr[1].checked == false) {
		document.getElementById("err_simchkcorr").innerHTML = "Please check address similarity";
		return false;
	}

	document.regperaddress_form.submit();
	return true;
}

// Business Customer Registered address details validation

function validBuildingNoPresent() {
	var sampleVar = document.regpreaddress_form.bnopre.value;
	var alphaExp = /^[a-zA-Z0-9][a-zA-Z0-9\s()-]+$/;
	var alphaExp1 = /^[a-zA-Z0-9]+$/;
	var alphaExp2 = /^[a-zA-Z]+$/;
	if (sampleVar == null || sampleVar == "") {
		document.getElementById("err_bnopre").innerHTML = "Please enter building number";
		return false;
	} else if (!sampleVar.match(alphaExp) && !sampleVar.match(alphaExp1)) {
		document.getElementById("err_bnopre").innerHTML = "Please check building number";
		return false;
	} else if (sampleVar.match(alphaExp2)) {
		document.getElementById("err_bnopre").innerHTML = "Building number should contain numbers and alphabets";
		return false;
	} else if ((sampleVar.length) > 10) {
		document.getElementById("err_bnopre").innerHTML = "Please enter maximum 10 characters";
		return false;

	} else {
		document.getElementById("err_bnopre").innerHTML = "";
		return true;
	}
}

function validBuildingNamePresent() {
	var sampleVar = document.regpreaddress_form.bnamepre.value;
	var alphaExp = /^[a-zA-Z][a-zA-Z\s]+$/;
	if (sampleVar == null || sampleVar == "") {
		document.getElementById("err_bnamepre").innerHTML = "Please enter building name";
		return false;
	} else if (!sampleVar.match(alphaExp)) {
		document.getElementById("err_bnamepre").innerHTML = "Please check building name";
		return false;
	} else if ((sampleVar.length) < 3 || (sampleVar.length) > 30) {
		document.getElementById("err_bnamepre").innerHTML = "Please enter 3-20 alphabets only";
		return false;

	} else {
		document.getElementById("err_bnamepre").innerHTML = "";
		return true;
	}
}

function validStreetNamePresent() {
	var sampleVar = document.regpreaddress_form.snamepre.value;
	var alphaExp = /^[a-zA-Z][a-zA-Z\s]+$/;
	if (sampleVar == null || sampleVar == "") {
		document.getElementById("err_snamepre").innerHTML = "Please enter street name";
		return false;
	} else if (!sampleVar.match(alphaExp)) {
		document.getElementById("err_snamepre").innerHTML = "Please check street name";
		return false;
	} else if ((sampleVar.length) < 3 || (sampleVar.length) > 40) {
		document.getElementById("err_snamepre").innerHTML = "Please enter 3-40 alphabets only";
		return false;

	} else {
		document.getElementById("err_snamepre").innerHTML = "";
		return true;
	}
}

function validCityPresent() {
	var sampleVar = document.regpreaddress_form.citypre.value;
	var alphaExp = /^[a-zA-Z][a-zA-Z\s]+$/;
	if (sampleVar == null || sampleVar == "") {
		document.getElementById("err_citypre").innerHTML = "Please enter city name";
		return false;
	} else if (!sampleVar.match(alphaExp)) {
		document.getElementById("err_citypre").innerHTML = "Please check city name";
		return false;
	} else if ((sampleVar.length) < 3 || (sampleVar.length) > 30) {
		document.getElementById("err_citypre").innerHTML = "Please enter 3-30 alphabets only";
		return false;

	} else {
		document.getElementById("err_citypre").innerHTML = "";
		return true;
	}
}

function validTownPresent() {
	var sampleVar = document.regpreaddress_form.townpre.value;
	var alphaExp = /^[a-zA-Z][a-zA-Z\s]+$/;

	if (!sampleVar.match(alphaExp) && (sampleVar.length) > 0) {
		document.getElementById("err_townpre").innerHTML = "Please check town name";
		return false;
	} else if (((sampleVar.length) > 0 && (sampleVar.length) < 3)
			|| (sampleVar.length) > 30) {
		document.getElementById("err_townpre").innerHTML = "Please enter 3-20 alphabets only";
		return false;

	} else {
		document.getElementById("err_townpre").innerHTML = "";
		return true;
	}

}

function validcountryPresent() {
	var sampleVar = document.regpreaddress_form.countrypre.value;
	if (sampleVar == "0") {
		document.getElementById("error_countrypre").innerHTML = "Please select country";
		return false;
	} else {
		document.getElementById("error_countrypre").innerHTML = "";
		return true;
	}
}

function validPostalCodePresent() {
	var sampleVar = document.regpreaddress_form.pcodepre.value;

	var alphaExp = /^[A-Z0-9][A-Z0-9\s]+$/;
	var alphaExp2 = /^[a-zA-Z]+$/;
	if (sampleVar == null || sampleVar == "") {
		document.getElementById("err_pcodepre").innerHTML = "Please enter postal code.";
		return false;
	} else if ((sampleVar.length) > 10 || sampleVar.length < 6) {
		document.getElementById("err_pcodepre").innerHTML = "Please enter 6 to 10 characters.";
		return false;

	} else if (sampleVar.match(alphaExp2)) {
		document.getElementById("err_pcodepre").innerHTML = "Please check postal code.";
		return false;
	} else if (!sampleVar.match(alphaExp)) {
		document.getElementById("err_pcodepre").innerHTML = "Please check postal code.";
		return false;
	} else {
		document.getElementById("err_pcodepre").innerHTML = "";
		return true;
	}

}

function validatePresentAddres() {
	if (validBuildingNoPresent() == false) {

		return true;
	} else if (validBuildingNamePresent() == false) {

		return true;
	}

	else if (validStreetNamePresent() == false) {

		return true;
	} else if (validTownPresent() == false) {

		return true;
	} else if (validCityPresent() == false) {

		return true;
	} else if (validcountryPresent() == false) {

		return true;
	} else if (validPostalCodePresent() == false) {

		return true;
	}
if(document.getElementById("corsamereg")!=null){
	if (document.regpreaddress_form.simcheckcorr[0].checked == false
			&& document.regpreaddress_form.simcheckcorr[1].checked == false) {
		document.getElementById("err_simcheckcorr").innerHTML = "Please check address similarity";
		return false;
	}
}
	document.regpreaddress_form.submit();
	return true;
}

// Business Customer Correspondence Address validation

function validBuildingNoCorr() {
	var sampleVar = document.regcoraddress_form.bnocor.value;
	var alphaExp = /^[a-zA-Z0-9][a-zA-Z0-9\s()-]+$/;
	var alphaExp1 = /^[a-zA-Z0-9]+$/;
	var alphaExp2 = /^[a-zA-Z]+$/;
	if (sampleVar == null || sampleVar == "") {
		document.getElementById("err_bnocor").innerHTML = "Please enter building number";
		return false;
	} else if (!sampleVar.match(alphaExp) && !sampleVar.match(alphaExp1)) {
		document.getElementById("err_bnocor").innerHTML = "Please check building number";
		return false;
	} else if (sampleVar.match(alphaExp2)) {
		document.getElementById("err_bnocor").innerHTML = "Building number should contain numbers and alphabets";
		return false;
	} else if ((sampleVar.length) > 10) {
		document.getElementById("err_bnocor").innerHTML = "Please enter maximum 10 characters";
		return false;

	} else {
		document.getElementById("err_bnocor").innerHTML = "";
		return true;
	}
}

function validBuildingNameCorr() {
	var sampleVar = document.regcoraddress_form.bnamecor.value;
	var alphaExp = /^[a-zA-Z][a-zA-Z\s]+$/;
	if (sampleVar == null || sampleVar == "") {
		document.getElementById("err_bnamecor").innerHTML = "Please enter building name";
		return false;
	} else if (!sampleVar.match(alphaExp)) {
		document.getElementById("err_bnamecor").innerHTML = "Please check building name";
		return false;
	} else if ((sampleVar.length) < 3 || (sampleVar.length) > 30) {
		document.getElementById("err_bnamecor").innerHTML = "Please enter 3-20 alphabets only";
		return false;

	} else {
		document.getElementById("err_bnamecor").innerHTML = "";
		return true;
	}
}

function validStreetNameCorr() {
	var sampleVar = document.regcoraddress_form.snamecor.value;
	var alphaExp = /^[a-zA-Z][a-zA-Z\s]+$/;
	if (sampleVar == null || sampleVar == "") {
		document.getElementById("err_snamecor").innerHTML = "Please enter street name";
		return false;
	} else if (!sampleVar.match(alphaExp)) {
		document.getElementById("err_snamecor").innerHTML = "Please check street name";
		return false;
	} else if ((sampleVar.length) < 3 || (sampleVar.length) > 40) {
		document.getElementById("err_snamecor").innerHTML = "Please enter 3-40 alphabets only";
		return false;

	} else {
		document.getElementById("err_snamecor").innerHTML = "";
		return true;
	}
}

function validCityCorr() {
	var sampleVar = document.regcoraddress_form.citycor.value;
	var alphaExp = /^[a-zA-Z][a-zA-Z\s]+$/;
	if (sampleVar == null || sampleVar == "") {
		document.getElementById("err_citycor").innerHTML = "Please enter city name";
		return false;
	} else if (!sampleVar.match(alphaExp)) {
		document.getElementById("err_citycor").innerHTML = "Please check city name";
		return false;
	} else if ((sampleVar.length) < 3 || (sampleVar.length) > 30) {
		document.getElementById("err_citycor").innerHTML = "Please enter 3-30 alphabets only";
		return false;

	} else {
		document.getElementById("err_citycor").innerHTML = "";
		return true;
	}
}

function validTownCorr() {
	var sampleVar = document.regcoraddress_form.towncor.value;
	var alphaExp = /^[a-zA-Z][a-zA-Z\s]+$/;

	if (!sampleVar.match(alphaExp) && (sampleVar.length) > 0) {
		document.getElementById("err_towncor").innerHTML = "Please check town name";
		return false;
	} else if (((sampleVar.length) > 0 && (sampleVar.length) < 3)
			|| (sampleVar.length) > 30) {
		document.getElementById("err_towncor").innerHTML = "Please enter 3-20 alphabets only";
		return false;

	} else {
		document.getElementById("err_towncor").innerHTML = "";
		return true;
	}

}

function validcountryCorr() {
	var sampleVar = document.regcoraddress_form.countrycor.value;
	if (sampleVar == "0") {
		document.getElementById("error_countrycor").innerHTML = "Please select country";
		return false;
	} else {
		document.getElementById("error_countrycor").innerHTML = "";
		return true;
	}
}

function validPostalCodeCorr() {
	var sampleVar = document.regcoraddress_form.pcodecor.value;

	var alphaExp = /^[A-Z0-9][A-Z0-9\s]+$/;
	var alphaExp2 = /^[a-zA-Z]+$/;
	if (sampleVar == null || sampleVar == "") {
		document.getElementById("err_pcodecor").innerHTML = "Please enter postal code";
		return false;
	} else if ((sampleVar.length) > 10 || sampleVar.length < 6) {
		document.getElementById("err_pcodecor").innerHTML = "Please enter 6 to 10 characters.";
		return false;

	} else if (sampleVar.match(alphaExp2)) {
		document.getElementById("err_pcodecor").innerHTML = "Please check postal code.";
		return false;
	} else if (!sampleVar.match(alphaExp)) {
		document.getElementById("err_pcodecor").innerHTML = "Please check postal code";
		return false;
	} else {
		document.getElementById("err_pcodecor").innerHTML = "";
		return true;
	}

}

//

function validateCorrAddres() {
	if (validBuildingNoCorr() == false) {

		return true;
	} else if (validBuildingNameCorr() == false) {

		return true;
	}

	else if (validStreetNameCorr() == false) {

		return true;
	} else if (validTownCorr() == false) {

		return true;
	} else if (validCityCorr() == false) {

		return true;
	} else if (validcountryCorr() == false) {

		return true;
	} else if (validPostalCodeCorr() == false) {

		return true;
	}

	document.regcoraddress_form.submit();
	return true;
}

//
