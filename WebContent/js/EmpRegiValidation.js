function isempty(s) {
	if ((s == null) || (s.length == 0))
		return true;

	return false;
}

/*function setJoiningDate() {

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
	
	document.getElementById("doj").innerHTML = today;
}*/

function ischarinbag(string, bag) {
	var i;
	for (i = 0; i < string.length; i++) {
		var charval = string.charAt(i);
		if (bag.indexOf(charval) == -1)
			return false;
	}
	return true;
}

function validateDateB()
{
	if(!isempty(document.Emp_Register.dob.value))
	{
		document.getElementById("err_dob").innerHTML ="";
	}
}

function validateDateJ()
{
	if(!isempty(document.Emp_Register.doj.value))
	{
		document.getElementById("err_doj").innerHTML ="";
	}
}

function validateAge()
{
	
if(!isempty(document.Emp_Register.dob.value))
{
	var dob=new Date(document.Emp_Register.dob.value);
	var bdd=dob.getDate();
	var bmm=dob.getMonth()+1;
	var byy=dob.getFullYear();
	
	//Today's date
	var today=new Date();
	var dd=today.getDate();
	var mm=today.getMonth()+1;
	var yy=today.getFullYear();
		
	var yearDifference = (mm == bmm && dd > bdd) ? 
			yy - byy : (mm > bmm) ? yy - byy : yy - byy-1;
	if(yearDifference<21)
	{
	 document.getElementById("err_dob1").innerHTML = "Employe's age should be greater than 21 years";
		return false;
	}
	else {
		document.getElementById("err_dob").innerHTML = "";
		document.getElementById("err_dob1").innerHTML = "";
		
		
	}

}
}

function chkLogin() {

	if (!ischarinbag(document.Login.UID.value, "0123456789")) {
		
		alert("Please enter only digits in Username");
		document.Login.UID.focus();
		document.Login.UID.value = "";
	} else if (!isempty(document.Login.UID.value)
			&& document.Login.UID.value.length < 6
			|| document.Login.UID.value.length > 6) {
		alert("Username should be 6 digits long");
		
		document.Login.UID.focus();
		document.Login.UID.value = "";
	}

}

//validate title
function validateTitle()
{
	if (document.Emp_Register.title.value == "NoTitle") {
		document.getElementById("err_title").innerHTML = "Please select title";

	}
	else
	{
		document.getElementById("err_title").innerHTML = "";
	}
}


// Validate First name
function validatefirstnm() {
	if (isempty(document.Emp_Register.firstnm.value)) {
		document.getElementById("err_firstnm").innerHTML = "Please enter First name";
		document.Emp_Register.firstnm.value = "";
	} else if (!ischarinbag(document.Emp_Register.firstnm.value,
			"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ'")) {
		document.getElementById("err_firstnm").innerHTML = "Please enter only alphabets";
		document.Emp_Register.firstnm.focus();
		document.Emp_Register.firstnm.value = "";
	} else if (document.Emp_Register.firstnm.value.length > 20) {
		document.getElementById("err_firstnm").innerHTML = "Please enter a maximum of 20 alphabets";
		document.Emp_Register.firstnm.focus();
		document.Emp_Register.firstnm.value = "";
	} else if (!isempty(document.Emp_Register.firstnm.value)
			&& (document.Emp_Register.firstnm.value.length < 2)) {
		
		document.getElementById("err_firstnm").innerHTML = "Please enter a minimum of 2 alphabets";
		document.Emp_Register.firstnm.focus();
		document.Emp_Register.firstnm.value = "";
	} else {
		document.getElementById("err_firstnm").innerHTML = "";
	}
}

// validate middle name
function validatemiddlenm() {
	if (!ischarinbag(document.Emp_Register.middlenm.value,
			"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ")) {
		document.getElementById("err_middlenm").innerHTML = "Please enter only alphabets";
		document.Emp_Register.middlenm.focus();
		document.Emp_Register.middlenm.value = "";
	} else if (document.Emp_Register.middlenm.value.length > 20) {
		document.getElementById("err_middlenm").innerHTML = "Please enter a maximum of 20 alphabets";
		document.Emp_Register.middlenm.focus();
		document.Emp_Register.middlenm.value = "";
	} else if (!isempty(document.Emp_Register.middlenm.value)
			&& (document.Emp_Register.middlenm.value.length < 2)) {
		document.getElementById("err_middlenm").innerHTML = "Please enter a minimum of 2 alphabets";
		document.Emp_Register.middlenm.focus();
		document.Emp_Register.middlenm.value = "";
	}

	else {
		document.getElementById("err_middlenm").innerHTML = "";
	}
}

// Validate Last Name
function validatelastnm() {
	if(isempty(document.Emp_Register.lastnm.value))
	{
		document.getElementById("err_lastnm").innerHTML = "Please enter Last name";
		document.Emp_Register.lastnm.value = "";
	}
	else if (!ischarinbag(document.Emp_Register.lastnm.value,
			"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ")) {
		document.getElementById("err_lastnm").innerHTML = "Please enter only alphabets";
		document.Emp_Register.lastnm.focus();
		document.Emp_Register.lastnm.value = "";

	} else if (document.Emp_Register.lastnm.value.length > 20) {
		document.getElementById("err_lastnm").innerHTML = "Please enter a maximum of 20 alphabets";
		document.Emp_Register.lastnm.focus();
		document.Emp_Register.lastnm.value = "";
	} else if (!isempty(document.Emp_Register.lastnm.value)
			&& (document.Emp_Register.lastnm.value.length < 2)) {
		document.getElementById("err_lastnm").innerHTML = "Please enter a minimum of 2 alphabets";
		document.Emp_Register.lastnm.focus();
		document.Emp_Register.lastnm.value = "";
	} else {
		document.getElementById("err_lastnm").innerHTML = "";
	}
}

//Validate Date of Birth
function validateDOB()
{
	if (isempty(document.Emp_Register.dob.value)) {
		document.getElementById("err_dob").innerHTML = "Please select Date of Birth";
	} 
	else if(!isempty(document.Emp_Register.dob.value))
	{
		document.getElementById("err_dob").innerHTML ="";
	}
}

// Validate Address

function validateAddress() {
	if (isempty(document.Emp_Register.address.value)) {
		document.getElementById("err_address").innerHTML = "Please enter Address";
		document.Emp_Register.address.value = "";
	} else if (!ischarinbag(document.Emp_Register.address.value,
			"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789. - _/',")) {
		document.getElementById("err_address").innerHTML = "Only alphabets,numbers & some special characters like . - _ , / are allowed";
		document.Emp_Register.address.focus();
		document.Emp_Register.address.value = "";
	} else if (!isempty(document.Emp_Register.address.value)
			&& document.Emp_Register.address.value.charAt(0) == " ") {
		document.getElementById("err_address").innerHTML = "Address should not start with blank space";
		document.Emp_Register.address.focus();
		document.Emp_Register.address.value = "";
	} else if (!isempty(document.Emp_Register.address.value)
			&& document.Emp_Register.address.value.length < 3) {
		document.getElementById("err_address").innerHTML = "Please enter a minimum of 2 alphabets";
		document.Emp_Register.address.focus();
		document.Emp_Register.address.value = "";
	} 
	 else if (!isempty(document.Emp_Register.address.value)
				&& document.Emp_Register.address.value.length > 50) {
			document.getElementById("err_address").innerHTML = "Please enter a maximum of 50 alphabets";
			document.Emp_Register.address.focus();
			document.Emp_Register.address.value = "";
		}
	else {
		document.getElementById("err_address").innerHTML = "";
	}
}

// Validate Contact Number
function validateContactNo() {
	if(isempty(document.Emp_Register.contactno.value))
	{
		document.getElementById("err_contact").innerHTML = "Please enter contact number";
		document.Emp_Register.contactno.value = "";
	}
	else if (!ischarinbag(document.Emp_Register.contactno.value, "0123456789")) {
		document.getElementById("err_contact").innerHTML = "Please enter only numbers";
		document.Emp_Register.contactno.focus();
		document.Emp_Register.contactno.value = "";
	} else if (!isempty(document.Emp_Register.contactno.value)
			&& (document.Emp_Register.contactno.value.length < 10 || (document
					.getElementById("contactno").value.length >= 11))) {
		document.getElementById("err_contact").innerHTML = "Please enter a 10 digit number";
		document.Emp_Register.contactno.focus();
		document.Emp_Register.contactno.value = "";
	}

	else if (!isempty(document.Emp_Register.contactno.value)
			&& document.Emp_Register.contactno.value == "0000000000") {
		document.getElementById("err_contact").innerHTML = "Please check contact number";
		document.Emp_Register.contactno.focus();
		document.Emp_Register.contactno.value = "";
	} else {
		document.getElementById("err_contact").innerHTML = "";
	}
}

// Validate Alternate Contact Number
function validateAltContact() {
	if (!ischarinbag(document.Emp_Register.altcontactno.value, "0123456789")) {
		document.getElementById("err_altcontact").innerHTML = "Please enter only numbers";
		document.Emp_Register.altcontactno.focus();
		document.Emp_Register.altcontactno.value = "";
	} else if (!isempty(document.Emp_Register.altcontactno.value)
			&& (document.Emp_Register.altcontactno.value.length < 10 || (document
					.getElementById("altcontactno").value.length >= 11))) {
		document.getElementById("err_altcontact").innerHTML = "Please enter a 10 digit number";
		document.Emp_Register.altcontactno.focus();
		document.Emp_Register.altcontactno.value = "";
	} else if (!isempty(document.Emp_Register.altcontactno.value)
			&& document.Emp_Register.altcontactno.value == "0000000000") {
		document.getElementById("err_altcontact").innerHTML = "Please check contact number";
		document.Emp_Register.altcontactno.focus();
		document.Emp_Register.altcontactno.value = "";
	} else if (!isempty(document.Emp_Register.altcontactno.value)
			&& !isempty(document.Emp_Register.contactno.value)
			&& (document.getElementById("contactno").value == document
					.getElementById("altcontactno").value)) {
		document.getElementById("err_altcontact").innerHTML = "Please enter an alternate contact number";
		document.Emp_Register.altcontactno.focus();
		document.Emp_Register.altcontactno.value = "";
	} else {
		document.getElementById("err_altcontact").innerHTML = "";
	}
}

// validate email
function validateEmail() {
	var x = document.forms["Emp_Register"]["email"].value;
	var alphaExp = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	
	if(isempty(document.Emp_Register.email.value))
	{
		document.getElementById("err_email").innerHTML = "Please enter email Id";
		document.Emp_Register.email.value = "";
	}
	else if (!isempty(document.Emp_Register.email.value)
			&& !document.Emp_Register.email.value.match(alphaExp)) {
		document.getElementById("err_email").innerHTML = "Please check email ID";
		document.Emp_Register.email.focus();
		document.Emp_Register.email.value = "";
	}  else {
		document.getElementById("err_email").innerHTML = "";
	}
}

//Validate Date of joining
function validateDOJ()
{
	if (isempty(document.Emp_Register.doj.value)) {
		document.getElementById("err_doj").innerHTML = "Please select Date of Joining";
	}
	else
	{
		document.getElementById("err_doj").innerHTML = "";
	}
}

//Validate Designation
function validateDesig()
{
	if (document.Emp_Register.designation.value == "unselected") {
		document.getElementById("err_designation").innerHTML = "Please select designation";
	}
	else
	{
		document.getElementById("err_designation").innerHTML = "";
	}
}

//Validate Branch name
function validateBranch()
{
	if (document.Emp_Register.branch_nm.value == "unselected") {
		document.getElementById("err_branchnm").innerHTML = "Please select branch name";
	}
	else
	{
		document.getElementById("err_branchnm").innerHTML = "";
	}
}

function validateform() {
	if (document.Emp_Register.title.value == "NoTitle") {
		document.getElementById("err_title").innerHTML = "Please select title";
		document.Emp_Register.title.focus();
		return false;
	} else {
		document.getElementById("err_title").innerHTML = "";
		document.Emp_Register.firstnm.focus();
	}
	if (isempty(document.Emp_Register.firstnm.value)) {
		document.getElementById("err_firstnm").innerHTML = "Please enter first name";
		document.Emp_Register.firstnm.focus();
		return false;
	} else {
		document.getElementById("err_firstnm").innerHTML = "";
		document.Emp_Register.lastnm.focus();
	}
	if (isempty(document.Emp_Register.lastnm.value)) {
		document.getElementById("err_lastnm").innerHTML = "Please enter last name";
		document.Emp_Register.lastnm.focus();
		return false;
	} else {
		document.getElementById("err_lastnm").innerHTML = "";
		document.Emp_Register.dob.focus();
	}
	if (isempty(document.Emp_Register.dob.value)) {
		document.getElementById("err_dob").innerHTML = "Please select Date of Birth";
		document.Emp_Register.dob.focus();
		return false;
	} 
	else if(!isempty(document.Emp_Register.dob.value))
	{
		var dob=new Date(document.Emp_Register.dob.value);
		var bdd=dob.getDate();
		var bmm=dob.getMonth()+1;
		var byy=dob.getFullYear();
		
		//Today's date
		var today=new Date();
		var dd=today.getDate();
		var mm=today.getMonth()+1;
		var yy=today.getFullYear();
			
		var yearDifference = (mm == bmm && dd > bdd) ? 
				yy - byy : (mm > bmm) ? yy - byy : yy - byy-1;
		if(yearDifference<21)
		{
		 document.getElementById("err_dob1").innerHTML = "Employe's age should be greater than 21 years";
			return false;
		}
		else {
			document.getElementById("err_dob").innerHTML = "";
			document.getElementById("err_dob1").innerHTML = "";
			
			document.Emp_Register.address.focus();
		}
	
	}
	
	if (isempty(document.Emp_Register.address.value)) {
		document.getElementById("err_address").innerHTML = "Please enter address";
		document.Emp_Register.address.focus();
		return false;
	} else {
		document.getElementById("err_address").innerHTML = "";
		document.Emp_Register.contactno.focus();
	}
	if (isempty(document.Emp_Register.contactno.value)) {
		document.getElementById("err_contact").innerHTML = "Please enter contact number";
		document.Emp_Register.contactno.focus();
		return false;
	} else {
		document.getElementById("err_contact").innerHTML = "";
		document.Emp_Register.email.focus();
	}
	if (isempty(document.Emp_Register.email.value)) {
		document.getElementById("err_email").innerHTML = "Please enter email address";
		document.Emp_Register.email.focus();
		return false;
	} else {
		document.getElementById("err_email").innerHTML = "";
		document.Emp_Register.designation.focus();
	}
	
	//
	if (isempty(document.Emp_Register.doj.value)) {
		document.getElementById("err_doj").innerHTML = "Please select Date of Joining";
		document.Emp_Register.doj.focus();
		return false;
	} 
	else if(!isempty(document.Emp_Register.doj.value))
	{
		var doj=new Date(document.Emp_Register.doj.value);
		var bdd=doj.getDate();
		var bmm=doj.getMonth()+1;
		var byy=doj.getFullYear();
		
		//Today's date
		var today=new Date();
		var dd=today.getDate();
		var mm=today.getMonth()+1;
		var yy=today.getFullYear();
			

	}
	else
	{
		document.getElementById("err_doj").innerHTML = "";
		document.Emp_Register.address.focus();
	}
	///
	
	
	if (document.Emp_Register.designation.value == "unselected") {
		document.getElementById("err_designation").innerHTML = "Please select designation";
		document.Emp_Register.designation.focus();
		return false;
	} else {
		document.getElementById("err_designation").innerHTML = "";
		document.Emp_Register.branch_nm.focus();
	}
	if (document.Emp_Register.branch_nm.value == "unselected") {
		document.getElementById("err_branchnm").innerHTML = "Please select branch name";
		document.Emp_Register.branch_nm.focus();
		return false;
	} else {
		document.getElementById("err_branchnm").innerHTML = "";
		document.Emp_Register.admin.focus();
	}
	if (document.Emp_Register.admin.checked == false
			&& document.getElementById("comm").checked == false
			&& document.getElementById("prod").checked == false
			&& document.getElementById("main").checked == false
			&& document.getElementById("hdesk").checked == false) {
		document.getElementById("err_groups").innerHTML = "Please select groups with respect to designation";
		document.Emp_Register.admin.focus();
		return false;
	}
	else if(document.Emp_Register.designation.value=="Admin" && ((document.getElementById("comm").checked==true ||  document.getElementById("main").checked == true || document.getElementById("hdesk").checked == true) || (document.Emp_Register.admin.checked == false || document.getElementById("prod").checked == false)))
	{
		document.getElementById("err_groups").innerHTML = "As Administrator, you may select only Admin and BB_CAO_Prod groups";
		document.getElementById("comm").checked=false;
		document.getElementById("main").checked =false;
		document.getElementById("hdesk").checked =false;
		document.getElementById("admin").focus();
	}
	else if(document.Emp_Register.designation.value=="Relationship Manager" && ((document.getElementById("comm").checked==true ||  document.getElementById("admin").checked == true || document.getElementById("hdesk").checked == true || document.getElementById("prod").checked==true) || (document.getElementById("main").checked == false)))
	{
		document.getElementById("err_groups").innerHTML = "As Relationshi Manager,you may select only BB_CAO_Main group";
		document.getElementById("comm").checked=false;
		document.getElementById("admin").checked =false;
		document.getElementById("hdesk").checked =false;
		document.getElementById("prod").checked=false;
		document.getElementById("admin").focus();
	}
	else if(document.Emp_Register.designation.value=="Commercial Account Opener" && ((document.getElementById("admin").checked == true || document.getElementById("hdesk").checked == true) || (document.getElementById("comm").checked == false ||  document.getElementById("prod").checked == false || document.getElementById("main").checked == false)))
	{
		document.getElementById("err_groups").innerHTML = "As Commercial Account Opener,you may select only BB_CAO_Main,BB_CAO_Prod and BB_CAO_Common groups";
		document.getElementById("admin").checked =false;
		document.getElementById("hdesk").checked =false;
		document.getElementById("admin").focus();
	}
	else if(document.Emp_Register.designation.value=="Back Office Employee" &&((document.getElementById("comm").checked==true ||  document.getElementById("admin").checked == true || document.getElementById("prod").checked == true) || (document.getElementById("main").checked == false || document.getElementById("hdesk").checked ==false )))
	{
		document.getElementById("err_groups").innerHTML = "As Back Office Employee,you may select only BB_CAO_Main and BB_CAO_HDesk groups";
		document.getElementById("admin").checked =false;
		document.getElementById("prod").checked =false;
		document.getElementById("comm").checked =false;
		document.getElementById("admin").focus();
	}
	else if(document.Emp_Register.designation.value=="Help Desk Employee" &&((document.getElementById("comm").checked==true ||  document.getElementById("admin").checked == true || document.getElementById("prod").checked == true || document.getElementById("main").checked == true) || (document.getElementById("hdesk").checked ==false )))
	{
		document.getElementById("err_groups").innerHTML = "As Help Desk Employee,you may select only BB_CAO_HDesk group";
		document.getElementById("admin").checked =false;
		document.getElementById("prod").checked =false;
		document.getElementById("comm").checked =false;
		document.getElementById("main").checked =false;
		document.getElementById("admin").focus();
	}
	else {
		document.getElementById("err_groups").innerHTML = "";
		document.Emp_Register.submit();
		return true;
	}
	
}


function validateReset()
{
	document.getElementById("err_title").innerHTML = "";
	document.getElementById("err_firstnm").innerHTML = "";
	document.getElementById("err_middlenm").innerHTML = "";
	document.getElementById("err_lastnm").innerHTML = "";
	document.getElementById("err_dob").innerHTML = "";
	document.getElementById("err_dob1").innerHTML = "";
	document.getElementById("err_address").innerHTML = "";
	document.getElementById("err_contact").innerHTML = "";
	document.getElementById("err_altcontact").innerHTML = "";
	document.getElementById("err_email").innerHTML = "";
	document.getElementById("err_doj").innerHTML = "";
	document.getElementById("err_designation").innerHTML = "";
	document.getElementById("err_groups").innerHTML = "";
	
	document.Emp_Register.reset();
}