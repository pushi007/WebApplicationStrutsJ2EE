function validEmail() {
	var sampleVar = document.reg_form.bemail.value;

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
	var sampleVar = document.reg_form.concountrycode.value;
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
	var sampleVar = document.reg_form.conareacode.value;
	if (sampleVar == null || sampleVar == "") {
		document.getElementById("error_contact").innerHTML = "Please enter area code";
		return false;
	} else if ((sampleVar.length < 2) || (sampleVar.length > 6)) {
		document.getElementById("error_contact").innerHTML = "Area code should be of 2 to 6 digits";
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
	var sampleVar = document.reg_form.conno.value;
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
	var sampleVar = document.reg_form.faxcountrycode.value;
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
	var sampleVar = document.reg_form.faxareacode.value;
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
	var sampleVar = document.reg_form.faxno.value;
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


//

function formValidator(){
	
	if(valididprooftype()==true){
		if(validaddressprooftype()==true){
			if(valididproof()==true){
				if(validaddressproof()==true){
					document.uploadImage.submit();
					return true;
				}
			}}}
	else
		
		return false;
}


function valididprooftype() {
	var sampleVar = document.uploadImage.idproof.value;
	if (sampleVar == "Select") {
		document.getElementById("error_idtype").innerHTML = "Please select Id proof type";
		return false;
	} else {
		document.getElementById("error_idtype").innerHTML = "";
		return true;
	}
}

function validaddressprooftype() {
	var sampleVar = document.uploadImage.addproof.value;
	if (sampleVar == "Select") {
		document.getElementById("error_addtype").innerHTML = "Please select address proof type";
		return false;
	} else {
		document.getElementById("error_addtype").innerHTML = "";
		return true;
	}
}

function valididproof() {
	var sampleVar = document.uploadImage.image.value;
	var ext = sampleVar.substring(sampleVar.lastIndexOf('.') + 1);

	if (sampleVar == "") {
		document.getElementById("error_id").innerHTML = "Please upload a document";
		return false;
	}

	else {
		document.getElementById("error_id").innerHTML = "";

	}
	if (ext == "JPEG" || ext == "jpeg" || ext == "JPG" || ext == "jpg") {
		document.getElementById("error_id").innerHTML = "";
		return true;
	} else {
		document.getElementById("error_id").innerHTML = "Please upload image in JPEG format";
		return false;
	}

}

function validaddressproof() {
	var sampleVar = document.uploadImage.image1.value;

	var ext = sampleVar.substring(sampleVar.lastIndexOf('.') + 1);

	if (sampleVar == "") {
		document.getElementById("error_address").innerHTML = "Please upload a document";
		return false;
	} else {
		document.getElementById("error_address").innerHTML = "";

	}

	if (ext == "JPEG" || ext == "jpeg" || ext == "JPG" || ext == "jpg") {
		document.getElementById("error_address").innerHTML = "";
		return true;
	} else {
		document.getElementById("error_address").innerHTML = "Please upload image in JPEG format";
		return false;
	}

}





function validateContactDetails() {
	if (validEmail() == false) {

		return false;
	} else if (validWorkCountryCode() == false) {

		return false;
	} else if (validWorkCityCode() == false) {

		return false;
	} else if (validWorkTelephoneNumber() == false) {

		return false;
	} else if (validFaxCountryCode() == false) {

		return false;
	} else if (validFaxCityCode() == false) {

		return false;
	} else if (validFaxTelephoneNumber() == false) {

		return false;
	} 
	document.reg_form.submit();
     return true;
}
