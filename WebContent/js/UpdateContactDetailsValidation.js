function validEmail() {
	var sampleVar = document.updateContactDetails_form.bemail.value;

	var alphaExp = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	if (sampleVar == null || sampleVar == "") {
		document.getElementById("error_bemail").innerHTML = "Please enter Email address";
		return false;
	} else if (!sampleVar.match(alphaExp)) {
		document.getElementById("error_bemail").innerHTML = "Please check Email address";
	} else {
		document.getElementById("error_bemail").innerHTML = "";
		return true;
	}
}

function validWorkCountryCode() {
	var sampleVar = document.updateContactDetails_form.concountrycode.value;
	if (sampleVar == null || sampleVar == "") {
		document.getElementById("error_contact").innerHTML = "Please enter country code";
		return false;
	} else if ((sampleVar.length != 2) && (sampleVar.length != 3)) {
		document.getElementById("error_contact").innerHTML = "Country code should be of 2 or 3 digits";
		return false;
	} else if (isNaN(sampleVar.charAt(1)) || isNaN(sampleVar.charAt(2))
			|| sampleVar.charAt(1) == " " || sampleVar.charAt(2) == " ") {
		document.getElementById("error_contact").innerHTML = "Country code contains only digits";
		return false;
	} else if (sampleVar.charAt(0) != "+") {
		document.getElementById("error_contact").innerHTML = "Country code should start with +";
		return false;
	} else {
		document.getElementById("error_contact").innerHTML = "";
		return true;
	}

}

function validWorkCityCode() {
	var sampleVar = document.updateContactDetails_form.conareacode.value;
	if (sampleVar == null || sampleVar == "") {
		document.getElementById("error_contact").innerHTML = "Please enter area code";
		return false;
	} else if ((sampleVar.length != 2) && (sampleVar.length != 3)) {
		document.getElementById("error_contact").innerHTML = "Area code should be of 2 or 3 digits";
		return false;
	} else if (isNaN(sampleVar) || sampleVar <= 0 || sampleVar.charAt(0) == "+") {
		document.getElementById("error_contact").innerHTML = "Area code contains only digits";
		return false;
	} else {
		document.getElementById("error_contact").innerHTML = "";
		return true;
	}

}

function validWorkTelephoneNumber() {
	var sampleVar = document.updateContactDetails_form.conno.value;
	if (sampleVar == null || sampleVar == "") {
		document.getElementById("error_contact").innerHTML = "Please enter telephone number";
		return false;
	} else if ((sampleVar.length < 4) && (sampleVar.length > 9)) {
		document.getElementById("error_contact").innerHTML = "Contact number should be of 4 to 9 digits";
		return false;
	} else if (isNaN(sampleVar) || sampleVar <= 0 || sampleVar.charAt(0) == "+") {
		document.getElementById("error_contact").innerHTML = "Contact number contains only digits";
		return false;
	} else {
		document.getElementById("error_contact").innerHTML = "";
		return true;
	}

}

function validFaxCountryCode() {
	var sampleVar = document.updateContactDetails_form.faxcountrycode.value;
	if (sampleVar == null || sampleVar == "") {
		document.getElementById("error_fax").innerHTML = "Please enter country code";
		return false;
	} else if ((sampleVar.length != 2) && (sampleVar.length != 3)) {
		document.getElementById("error_fax").innerHTML = "Country code should be of 2 or 3 digits";
		return false;
	} else if (isNaN(sampleVar.charAt(1)) || isNaN(sampleVar.charAt(2))
			|| sampleVar.charAt(1) == " " || sampleVar.charAt(2) == " ") {
		document.getElementById("error_fax").innerHTML = "Country code contains only digits";
		return false;
	} else if (sampleVar.charAt(0) != "+") {
		document.getElementById("error_fax").innerHTML = "Country code should start with +";
		return false;
	} else {
		document.getElementById("error_fax").innerHTML = "";
		return true;
	}

}

function validFaxCityCode() {
	var sampleVar = document.updateContactDetails_form.faxareacode.value;
	if (sampleVar == null || sampleVar == "") {
		document.getElementById("error_fax").innerHTML = "Please enter area code";
		return false;
	} else if (sampleVar.length != 3) {
		document.getElementById("error_fax").innerHTML = "Area code should be of 3 digits";
		return false;
	} else if (isNaN(sampleVar) || sampleVar <= 0 || sampleVar.charAt(0) == "+") {
		document.getElementById("error_fax").innerHTML = "Area code contains only digits";
		return false;
	} else {
		document.getElementById("error_fax").innerHTML = "";
		return true;
	}

}

function validFaxTelephoneNumber() {
	var sampleVar = document.updateContactDetails_form.faxno.value;
	if (sampleVar == null || sampleVar == "") {
		document.getElementById("error_fax").innerHTML = "Please enter telephone number";
		return false;
	} else if (sampleVar.length != 7) {
		document.getElementById("error_fax").innerHTML = "Fax number should be of 7 digits";
		return false;
	} else if (isNaN(sampleVar) || sampleVar <= 0 || sampleVar.charAt(0) == "+") {
		document.getElementById("error_fax").innerHTML = "Fax number should contain only digits";
		return false;
	} else {
		document.getElementById("error_fax").innerHTML = "";
		return true;
	}
}

/*function valididprooftype() {
	var sampleVar = document.updateContactDetails_form.idprooftype.value;
	if (sampleVar == "0") {
		document.getElementById("error_idtype").innerHTML = "Please select Id proof type";
		return false;
	} else {
		document.getElementById("error_idtype").innerHTML = "";
		return true;
	}
}

function validaddressprooftype() {
	var sampleVar = document.updateContactDetails_form.addprooftype.value;
	if (sampleVar == "0") {
		document.getElementById("error_addtype").innerHTML = "Please select address proof type";
		return false;
	} else {
		document.getElementById("error_addtype").innerHTML = "";
		return true;
	}
}

function valididproof() {
	var sampleVar = document.updateContactDetails_form.idUpload.value;
	var ext = sampleVar.substring(sampleVar.lastIndexOf('.') + 1);
	if (sampleVar == "") {
		document.getElementById("error_id").innerHTML = "Please upload document";
		return false;
	} else {
		document.getElementById("error_id").innerHTML = "";

	}

	if (ext == "GIF" || ext == "gif" || ext == "PDF" || ext == "pdf"
			|| ext == "JPG" || ext == "jpg" || ext == "JPEG" || ext == "jpeg") {
		document.getElementById("error_id").innerHTML = "";
		return true;
	} else {
		document.getElementById("error_id").innerHTML = "Please check document type";
		return false;
	}

}

function validaddressproof() {
	var sampleVar = document.updateContactDetails_form.addressUpload.value;
	var ext = sampleVar.substring(sampleVar.lastIndexOf('.') + 1);
	if (sampleVar == "") {
		document.getElementById("error_address").innerHTML = "Please upload document";
		return false;
	} else {
		document.getElementById("error_address").innerHTML = "";

	}

	if (ext == "GIF" || ext == "gif" || ext == "PDF" || ext == "pdf"
			|| ext == "JPG" || ext == "jpg" || ext == "JPEG" || ext == "jpeg") {
		document.getElementById("error_address").innerHTML = "";
		return true;
	} else {
		document.getElementById("error_address").innerHTML = "Please check document type";
		return false;
	}
}*/
function validateContactDetails() {
	if (validEmail() == false) {

		return true;
	} else if (validWorkCountryCode() == false) {

		return true;
	} else if (validWorkCityCode() == false) {

		return true;
	} else if (validWorkTelephoneNumber() == false) {

		return true;
	} else if (validFaxCountryCode() == false) {

		return true;
	} else if (validFaxCityCode() == false) {

		return true;
	} else if (validFaxTelephoneNumber() == false) {

		return true;
	}
	
		document.updateContactDetails_form.submit();
		return true;
}
