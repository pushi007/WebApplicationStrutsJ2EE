function isempty(s) {
	if ((s == null) || (s.length == 0))
		return true;

	return false;
}

function ischarinbag(string, bag) {
	var i;
	for (i = 0; i < string.length; i++) {
		var charval = string.charAt(i);
		if (bag.indexOf(charval) == -1)
			return false;
	}
	return true;
}

function setCurrentDate() {
	var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth() + 1;// January is 0!
	var yyyy = today.getFullYear();
	if (dd < 10) {
		dd = '0' + dd;
	}
	if (mm < 10) {
		mm = '0' + mm;
	}
	today = "";
	today = yyyy + "/" + mm + "/" + dd;
	document.getElementById("dol").innerHTML = today;
}

function validateStatus() {
	if (document.Deactivate_Employee.status.value == "unselected") {

		document.getElementById("err_status").innerHTML = "Please select status";

	} else {
		document.getElementById("err_status").innerHTML = "";
	}
}

function validateReason() {
	var val = document.Deactivate_Employee.reasonOfLeave.value;
	if (isempty(document.Deactivate_Employee.reasonOfLeave.value)) {
		document.getElementById("err_reasonOfLeaving").innerHTML = "Please enter reason for Deactivation";
		document.Deactivate_Employee.reasonOfLeave.value = "";

	} else if (!ischarinbag(val,
			"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 ,-_,.")) {
		document.getElementById("err_reasonOfLeaving").innerHTML = "Please enter only alphabets and numbers";
		document.Deactivate_Employee.reasonOfLeave.focus();
		document.Deactivate_Employee.reasonOfLeave.value = "";

	} 
	else if(!isempty(document.Deactivate_Employee.reasonOfLeave.value) && (document.Deactivate_Employee.reasonOfLeave.value.charAt(0)==" "))
	{
		document.getElementById("err_reasonOfLeaving").innerHTML = "First character can not be a space";
		document.Deactivate_Employee.reasonOfLeave.focus();
		document.Deactivate_Employee.reasonOfLeave.value = "";
	}
	else if (!isempty(document.Deactivate_Employee.reasonOfLeave.value) && (document.Deactivate_Employee.reasonOfLeave.value.length > 50)) {
		document.getElementById("err_reasonOfLeaving").innerHTML = "Please enter a maximum of 50 alphabets";
		document.Deactivate_Employee.reasonOfLeave.focus();
		document.Deactivate_Employee.reasonOfLeave.value = "";
	} 
	else if (!isempty(document.Deactivate_Employee.reasonOfLeave.value)
			&& (document.Deactivate_Employee.reasonOfLeave.value.length < 5)) {
		document.getElementById("err_reasonOfLeaving").innerHTML = "Please enter a minimum of 5 alphabets";
		document.Deactivate_Employee.reasonOfLeave.focus();
		document.Deactivate_Employee.reasonOfLeave.value = "";
	} else {
		document.getElementById("err_reasonOfLeaving").innerHTML = "";
	}

}

function validateform() {
	if (isempty(document.Deactivate_Employee.reasonOfLeave.value)) {
		document.getElementById("err_reasonOfLeaving").innerHTML = "Please enter reason for Deactivation";
		document.Deactivate_Employee.reasonOfLeave.focus();
		return false;
	} else {
		document.getElementById("err_reasonOfLeaving").innerHTML = "";
		document.Deactivate_Employee.status.focus();
	}
	if (document.Deactivate_Employee.status.value == "unselected") {
		document.getElementById("err_status").innerHTML = "Please select status";
		document.Deactivate_Employee.status.focus();
		return false;
	}

	else {
		document.getElementById("err_status").innerHTML = "";
		document.Deactivate_Employee.submit();
		return true;
	}
}
