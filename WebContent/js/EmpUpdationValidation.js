function isempty(s) {
	if ((s == null) || (s.length == 0))
		return true;

	return false;
}

function validateDateB()
{
	if(!isempty(document.Update_Employee.dob.value))
	{
		document.getElementById("err_dob").innerHTML ="";
	}
}

function validateAge()
{
	
if(!isempty(document.Update_Employee.dob.value))
{
	var dob=new Date(document.Update_Employee.dob.value);
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

//validate title
function validateTitle()
{
	if (document.Update_Employee.title.value == "NoTitle") {
		document.getElementById("err_title").innerHTML = "Please select title";

	}
	else
	{
		document.getElementById("err_title").innerHTML = "";
	}
}


// Validate First name
function validatefirstnm() {
	if (isempty(document.Update_Employee.firstnm.value)) {
		document.getElementById("err_firstnm").innerHTML = "Please enter First name";
		document.Update_Employee.firstnm.value = "";
	} else if (!ischarinbag(document.Update_Employee.firstnm.value,
			"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ'")) {
		document.getElementById("err_firstnm").innerHTML = "Please enter  only alphabets";
		document.Update_Employee.firstnm.focus();
		document.Update_Employee.firstnm.value = "";
	} else if (document.Update_Employee.firstnm.value.length > 20) {
		document.getElementById("err_firstnm").innerHTML = "Please enter a maximum of 20 alphabets";
		document.Update_Employee.firstnm.focus();
		document.Update_Employee.firstnm.value = "";
	} 
	else if (!isempty(document.Update_Employee.firstnm.value)
			&& (document.Update_Employee.firstnm.value.length < 2)) {
		document.getElementById("err_firstnm").innerHTML = "Please enter a minimum of 2 alphabets";
		document.Update_Employee.firstnm.focus();
		document.Update_Employee.firstnm.value = "";
	} else {
		document.getElementById("err_firstnm").innerHTML = "";
	}
}

// validate middle name
function validatemiddlenm() {
	if (!ischarinbag(document.Update_Employee.middlenm.value,
			"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ")) {
		document.getElementById("err_middlenm").innerHTML = "Please enter alphabets only";
		document.Update_Employee.middlenm.focus();
		document.Update_Employee.middlenm.value = "";
	} else if (document.Update_Employee.middlenm.value.length > 20) {
		document.getElementById("err_middlenm").innerHTML = "Please enter a maximum of 20 alphabets";
		document.Update_Employee.middlenm.focus();
		document.Update_Employee.middlenm.value = "";
	} else if (!isempty(document.Update_Employee.middlenm.value)
			&& (document.Update_Employee.middlenm.value.length < 2)) {
		document.getElementById("err_middlenm").innerHTML = "Please enter a minimum of 2 alphabets";
		document.Update_Employee.middlenm.focus();
		document.Update_Employee.middlenm.value = "";
	}

	else {
		document.getElementById("err_middlenm").innerHTML = "";
	}
}

// Validate Last Name
function validatelastnm() {
	if (isempty(document.Update_Employee.lastnm.value)) {
		document.getElementById("err_lastnm").innerHTML = "Please enter Last name";
		document.Update_Employee.lastnm.value = "";
	} else if (!ischarinbag(document.Update_Employee.lastnm.value,
			"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ")) {
		document.getElementById("err_lastnm").innerHTML = "Please enter alphabets only";
		document.Update_Employee.lastnm.focus();
		document.Update_Employee.lastnm.value = "";

	} else if (document.Update_Employee.lastnm.value.length > 20) {
		document.getElementById("err_lastnm").innerHTML = "Please enter a maximum of 20 alphabets";
		document.Update_Employee.lastnm.focus();
		document.Update_Employee.lastnm.value = "";
	} else if (!isempty(document.Update_Employee.lastnm.value)
			&& (document.Update_Employee.lastnm.value.length < 2)) {
		document.getElementById("err_lastnm").innerHTML = "Please enter a minimum of 2 alphabets";
		document.Update_Employee.lastnm.focus();
		document.Update_Employee.lastnm.value = "";
	} else {
		document.getElementById("err_lastnm").innerHTML = "";
	}
}

//Validate Date of Birth
function validateDOB()
{
	if (isempty(document.Update_Employee.dob.value)) {
		document.getElementById("err_dob").innerHTML = "Please select Date of Birth";
	} 
	else
	{
		document.getElementById("err_dob").innerHTML ="";
	}
}


// Validate Address

function validateAddress() {
	 if (isempty(document.Update_Employee.address.value)) {
		document.getElementById("err_address").innerHTML = "Please enter Address";
		document.Update_Employee.address.value = "";
	} else if (!ischarinbag(document.Update_Employee.address.value,
			"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789. - _/',")) {
		document.getElementById("err_address").innerHTML = "Please enter only alphabets,numbers or special characters like . - _ , /";
		document.Update_Employee.address.focus();
		document.Update_Employee.address.value = "";
	} else if (!isempty(document.Update_Employee.address.value)
			&& document.Update_Employee.address.value.charAt(0) == " ") {
		document.getElementById("err_address").innerHTML = "Address should not start with blank space";
		document.Update_Employee.address.focus();
		document.Update_Employee.address.value = "";
	} else if (!isempty(document.Update_Employee.address.value)
			&& document.Update_Employee.address.value.length < 3) {
		document.getElementById("err_address").innerHTML = "Please enter a minimum of 2 alphabets";
		document.Update_Employee.address.focus();
		document.Update_Employee.address.value = "";
	} 
	else if (!isempty(document.Update_Employee.address.value)
			&& document.Update_Employee.address.value.length > 50) {
		document.getElementById("err_address").innerHTML = "Please enter a maximum of 50 alphabets";
		document.Update_Employee.address.focus();
		document.Update_Employee.address.value = "";
	}
	else {
		document.getElementById("err_address").innerHTML = "";
	}
}

// Validate Contact Number
function validateContactNo() {
	if(isempty(document.Update_Employee.contactno.value))
	{
		document.getElementById("err_contact").innerHTML = "Please enter contact number";
		document.Update_Employee.contactno.value = "";
	}
	else if (!ischarinbag(document.Update_Employee.contactno.value, "0123456789")) {
		document.getElementById("err_contact").innerHTML = "Please enter only numbers";
		document.Update_Employee.contactno.focus();
		document.Update_Employee.contactno.value = "";
	} else if (!isempty(document.Update_Employee.contactno.value)
			&& (document.Update_Employee.contactno.value.length < 10 || (document
					.getElementById("contactno").value.length >= 11))) {
		document.getElementById("err_contact").innerHTML = "Please enter a 10 digit number";
		document.Update_Employee.contactno.focus();
		document.Update_Employee.contactno.value = "";
	}

	else if (!isempty(document.Update_Employee.contactno.value)
			&& document.Update_Employee.contactno.value == "0000000000") {
		document.getElementById("err_contact").innerHTML = "Please check contact number";
		document.Update_Employee.contactno.focus();
		document.Update_Employee.contactno.value = "";
	} else {
		document.getElementById("err_contact").innerHTML = "";
	}
}

// Validate Alternate Contact Number
function validateAltContact() {
	if (!ischarinbag(document.Update_Employee.altcontactno.value, "0123456789")) {
		document.getElementById("err_altcontact").innerHTML = "Please enter only digits";
		document.Update_Employee.altcontactno.focus();
		document.Update_Employee.altcontactno.value = "";
	} else if (!isempty(document.Update_Employee.altcontactno.value)
			&& (document.Update_Employee.altcontactno.value.length < 10 || (document
					.getElementById("altcontactno").value.length >= 11))) {
		document.getElementById("err_altcontact").innerHTML = "Please enter a 10 digit number";
		document.Update_Employee.altcontactno.focus();
		document.Update_Employee.altcontactno.value = "";
	} else if (!isempty(document.Update_Employee.altcontactno.value)
			&& document.Update_Employee.altcontactno.value == "0000000000") {
		document.getElementById("err_altcontact").innerHTML = "Please check contact number";
		document.Update_Employee.altcontactno.focus();
		document.Update_Employee.altcontactno.value = "";
	} else if (!isempty(document.Update_Employee.altcontactno.value)
			&& !isempty(document.Update_Employee.contactno.value)
			&& (document.getElementById("contactno").value == document
					.getElementById("altcontactno").value)) {
		document.getElementById("err_altcontact").innerHTML = "Please enter an alternate contact number";
		document.Update_Employee.altcontactno.focus();
		document.Update_Employee.altcontactno.value = "";
	} else {
		document.getElementById("err_altcontact").innerHTML = "";
	}
}

// validate email
function validateEmail() {
	var x = document.forms["Update_Employee"]["email"].value;
	var alphaExp = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	
	if(isempty(document.Update_Employee.email.value))
	{
		document.getElementById("err_email").innerHTML = "Please enter email Id";
		document.Update_Employee.email.value = "";
	}
	else if (!isempty(document.Update_Employee.email.value)
			&& !document.Update_Employee.email.value.match(alphaExp)) {
		document.getElementById("err_email").innerHTML = "Please check email ID";
		document.Update_Employee.email.focus();
		document.Update_Employee.email.value = "";
	}  else {
		document.getElementById("err_email").innerHTML = "";
	}
}

//Validate Date of joining
function validateDOJ()
{
	if (isempty(document.Update_Employee.doj.value)) {
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
	if (document.Update_Employee.designation.value == "unselected") {
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
	if (document.Update_Employee.branch_nm.value == "unselected") {
		document.getElementById("err_branchnm").innerHTML = "Please select branch name";
	}
	else
	{
		document.getElementById("err_branchnm").innerHTML = "";
	}
}


function validateform() {
	if (document.Update_Employee.title.value == "NoTitle") {
		document.getElementById("err_title").innerHTML = "Please select title";
		document.Update_Employee.title.focus();
		return false;
	} else {
		document.getElementById("err_title").innerHTML = "";
		document.Update_Employee.firstnm.focus();
	}
	if (isempty(document.Update_Employee.firstnm.value)) {
		document.getElementById("err_firstnm").innerHTML = "Please enter first name";
		document.Update_Employee.firstnm.focus();
		return false;
	} else {
		document.getElementById("err_firstnm").innerHTML = "";
		document.Update_Employee.lastnm.focus();
	}
	if (isempty(document.Update_Employee.lastnm.value)) {
		document.getElementById("err_lastnm").innerHTML = "Please enter last name";
		document.Update_Employee.lastnm.focus();
		return false;
	} else {
		document.getElementById("err_lastnm").innerHTML = "";
		document.Update_Employee.dob.focus();
	}
	if (isempty(document.Update_Employee.dob.value)) {
		document.getElementById("err_dob").innerHTML = "Please select Date of Birth";
		document.Update_Employee.dob.focus();
		return false;
	}
	else if(!isempty(document.Update_Employee.dob.value))
	{
		var dob=new Date(document.Update_Employee.dob.value);
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
			
			document.Update_Employee.address.focus();
		}
	}
	
	
	if (isempty(document.Update_Employee.address.value)) {
		document.getElementById("err_address").innerHTML = "Please enter address";
		document.Update_Employee.address.focus();
		return false;
	} else {
		document.getElementById("err_address").innerHTML = "";
		document.Update_Employee.contactno.focus();
	}
	if (isempty(document.Update_Employee.contactno.value)) {
		document.getElementById("err_contact").innerHTML = "Please enter contact number";
		document.Update_Employee.contactno.focus();
		return false;
	} else {
		document.getElementById("err_contact").innerHTML = "";
		document.Update_Employee.email.focus();
	}
	if (isempty(document.Update_Employee.email.value)) {
		document.getElementById("err_email").innerHTML = "Please enter email address";
		document.Update_Employee.email.focus();
		return false;
	} else {
		document.getElementById("err_email").innerHTML = "";
		document.Update_Employee.designation.focus();
	}
	
	//
	if (isempty(document.Update_Employee.doj.value)) {
		document.getElementById("err_doj").innerHTML = "Please select Date of Joining";
		document.Update_Employee.doj.focus();
		return false;
	} 
	else if(!isempty(document.Update_Employee.doj.value))
	{
		var doj=new Date(document.Update_Employee.doj.value);
		var bdd=doj.getDate();
		var bmm=doj.getMonth()+1;
		var byy=doj.getFullYear();
		
		//Today's date
		var today=new Date();
		var dd=today.getDate();
		var mm=today.getMonth()+1;
		var yy=today.getFullYear();
			
		/*var yearDifference = (mm == bmm && dd > bdd) ? 
				yy - byy : (mm > bmm) ? yy - byy : yy - byy-1;
		if(yearDifference<21)
		{
		 document.getElementById("err_dob1").innerHTML = "Employe's age should be greater than 21 years";
			return false;
		}
		else {
			
			
			
			document.Emp_Register.address.focus();
		}
	*/
	}
	else
	{
		document.getElementById("err_doj").innerHTML = "";
		document.Update_Employee.address.focus();
	}
	///
	
	if (document.Update_Employee.designation.value == "unselected") {
		document.getElementById("err_designation").innerHTML = "Please select designation";
		document.Update_Employee.designation.focus();
		return false;
	} else {
		document.getElementById("err_designation").innerHTML = "";
		document.Update_Employee.branch_nm.focus();
	}
	if (document.Update_Employee.branch_nm.value == "unselected") {
		document.getElementById("err_branchnm").innerHTML = "Please select branch name";
		document.Update_Employee.branch_nm.focus();
		return false;
	} else {
		document.getElementById("err_branchnm").innerHTML = "";
		document.Update_Employee.admin.focus();
	}
	if (document.Update_Employee.admin.checked == false
			&& document.getElementById("comm").checked == false
			&& document.getElementById("prod").checked == false
			&& document.getElementById("main").checked == false
			&& document.getElementById("hdesk").checked == false) {
		document.getElementById("err_groups").innerHTML = "Please select groups with respect to designation";
		document.Update_Employee.admin.focus();
		return false;
	}
	else if(document.Update_Employee.designation.value=="Admin" && ((document.getElementById("comm").checked==true ||  document.getElementById("main").checked == true || document.getElementById("hdesk").checked == true) || (document.Update_Employee.admin.checked == false || document.getElementById("prod").checked == false)))
	{
		document.getElementById("err_groups").innerHTML = "As Administrator,you may select only Admin and BB_CAO_Prod groups";
		document.getElementById("comm").checked=false;
		document.getElementById("main").checked =false;
		document.getElementById("hdesk").checked =false;
		document.getElementById("admin").focus();
	}
	else if(document.Update_Employee.designation.value=="Relationship Manager" && ((document.getElementById("comm").checked==true ||  document.getElementById("admin").checked == true || document.getElementById("hdesk").checked == true || document.getElementById("prod").checked==true) || (document.getElementById("main").checked == false)))
	{
		document.getElementById("err_groups").innerHTML = "As Relationship Manager,you may select only BB_CAO_Main group";
		document.getElementById("comm").checked=false;
		document.getElementById("admin").checked =false;
		document.getElementById("hdesk").checked =false;
		document.getElementById("prod").checked=false;
		document.getElementById("admin").focus();
	}
	else if(document.Update_Employee.designation.value=="Commercial Account Opener" && ((document.getElementById("admin").checked == true || document.getElementById("hdesk").checked == true) || (document.getElementById("comm").checked == false ||  document.getElementById("prod").checked == false || document.getElementById("main").checked == false)))
	{
		document.getElementById("err_groups").innerHTML = "As Commercial Account Opener,you may select only BB_CAO_Main,BB_CAO_Prod and BB_CAO_Common groups";
		document.getElementById("admin").checked =false;
		document.getElementById("hdesk").checked =false;
		document.getElementById("admin").focus();
	}
	else if(document.Update_Employee.designation.value=="Back Office Employee" &&((document.getElementById("comm").checked==true ||  document.getElementById("admin").checked == true || document.getElementById("prod").checked == true) || (document.getElementById("main").checked == false || document.getElementById("hdesk").checked ==false )))
	{
		document.getElementById("err_groups").innerHTML = "As Back Office Employee,you may select only BB_CAO_Main and BB_CAO_HDesk groups";
		document.getElementById("admin").checked =false;
		document.getElementById("prod").checked =false;
		document.getElementById("comm").checked =false;
		document.getElementById("admin").focus();
	}
	else if(document.Update_Employee.designation.value=="Help Desk Employee" &&((document.getElementById("comm").checked==true ||  document.getElementById("admin").checked == true || document.getElementById("prod").checked == true || document.getElementById("main").checked == true) || (document.getElementById("hdesk").checked ==false )))
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
		document.Update_Employee.submit();
		return true;
	}
}
