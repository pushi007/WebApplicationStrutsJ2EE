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

function validateCurrPwd(){
	if(isempty(document.Change_Pwd.currPwd.value))
	{
		document.getElementById("err_currPwd").innerHTML = "Please enter Current Password";
		document.Change_Pwd.currPwd.value="";
	}
	else
	{
		document.getElementById("err_currPwd").innerHTML ="";
	}
}


function validatePwd(){


var ck_password = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@!&$#%]).{1,}$/;
	
	
var password = document.Change_Pwd.newPwd.value;

if(isempty(document.Change_Pwd.newPwd.value))
{
	document.getElementById("err_newPwd").innerHTML = "Please enter New Password";
	document.Change_Pwd.newPwd.value="";
	
}
else if(!isempty(document.Change_Pwd.newPwd.value) && !(ck_password.test(password))) {
	document.getElementById("err_newPwd").innerHTML = "Password must contain atleast one capital letter,small letter,number and special character";
	document.Change_Pwd.newPwd.focus();
	document.Change_Pwd.newPwd.value="";	
}
else if(!isempty(document.Change_Pwd.newPwd.value) && (document.Change_Pwd.newPwd.value.length<6))
{
	document.getElementById("err_newPwd").innerHTML = "Please enter a minimum of 6 characters";
	document.Change_Pwd.newPwd.focus();
	document.Change_Pwd.newPwd.value="";	
}
else if(!isempty(document.Change_Pwd.newPwd.value) && (document.Change_Pwd.newPwd.value.indexOf(" ")>=0))
{
	document.getElementById("err_newPwd").innerHTML = "Space is not allowed in password";
	document.Change_Pwd.newPwd.focus();
	document.Change_Pwd.newPwd.value="";	
}

else if(!isempty(document.Change_Pwd.newPwd.value) && (document.Change_Pwd.newPwd.value.length>12))
{
	document.getElementById("err_newPwd").innerHTML = "Please enter a maximum of 12 characters";
	document.Change_Pwd.newPwd.focus();
	document.Change_Pwd.newPwd.value="";	
}
else if(!isempty(document.Change_Pwd.newPwd.value) && (document.Change_Pwd.currPwd.value==document.Change_Pwd.newPwd.value))
{
	document.getElementById("err_newPwd").innerHTML = "New Password could not be same as Current Password";
	document.Change_Pwd.newPwd.focus();
	document.Change_Pwd.newPwd.value="";	
}
else
	document.getElementById("err_newPwd").innerHTML="";
}


function validateConfPwd()
{
	var newPwd=document.Change_Pwd.newPwd.value;
	var confPwd=document.Change_Pwd.confPwd.value;
	
	if(isempty(document.Change_Pwd.confPwd.value))
	{
		document.getElementById("err_confPwd").innerHTML = "Please specify Confirm Password ";
		document.Change_Pwd.confPwd.value="";	
	}
	else if(!isempty(confPwd) && newPwd!=confPwd) 
	{
		document.getElementById("err_confPwd").innerHTML = "Confirm Password should be same as new password ";
		document.Change_Pwd.confPwd.focus();
		document.Change_Pwd.confPwd.value="";	
	}
	else
		document.getElementById("err_confPwd").innerHTML="";
}

function validateSecQ()
{
	if(document.Change_Pwd.securityQues.value=="unselected")
	{
		document.getElementById("err_ques").innerHTML = "Please select a Security Question";
		document.Change_Pwd.currPwd.value="";
	}
	else
	{
		document.getElementById("err_ques").innerHTML ="";
	}
}

function validateAnswer()
{
	var ck_answer =  /[A-Za-z0-9\s]{3,30}$/;
	var answer=document.Change_Pwd.answer.value;
	
	if(isempty(document.Change_Pwd.answer.value))
	{
		document.getElementById("err_answer").innerHTML = "Please answer Security question";
		document.Change_Pwd.answer.value="";	
	}	
	else if(!isempty(answer) && !ck_answer.test(answer)) 
	{
		document.getElementById("err_answer").innerHTML = "Answer should contain only alphabets and numbers and should be atleast 3 characters long";
		document.Change_Pwd.answer.focus();
		document.Change_Pwd.answer.value="";	
	}
	else
	{
		document.getElementById("err_answer").innerHTML ="";
	}
}


function validateform() {
	if (document.Change_Pwd.currPwd.value == "") {
		document.getElementById("err_currPwd").innerHTML= "Please enter current password";
		document.Change_Pwd.currPwd.focus();
		return false;
	}
	else
	{
		document.Change_Pwd.newPwd.focus();
		document.getElementById("err_currPwd").innerHTML="";
	}
	if (isempty(document.Change_Pwd.newPwd.value)) {
		document.getElementById("err_newPwd").innerHTML= "Please enter new password";
		document.Change_Pwd.newPwd.focus();
		return false;
	}
	else
	{
		document.Change_Pwd.confPwd.focus();
		document.getElementById("err_newPwd").innerHTML= "";
	}
	
	if (isempty(document.Change_Pwd.confPwd.value)) {
		document.getElementById("err_confPwd").innerHTML= "Please confirm password";
		document.Change_Pwd.confPwd.focus();
		return false;
	}
	else
	{
		document.Change_Pwd.securityQues.focus();
		document.getElementById("err_confPwd").innerHTML= "";
	}
	if (document.Change_Pwd.securityQues.value=="unselected") {
		document.getElementById("err_ques").innerHTML= "Please select a Security question";
		document.Change_Pwd.securityQues.focus();
		return false;
	}
	else
	{
		document.Change_Pwd.answer.focus();
		document.getElementById("err_ques").innerHTML= "";
		
	}
	if (isempty(document.Change_Pwd.answer.value)) {
		document.getElementById("err_answer").innerHTML= "Please answer Security question";
		document.Change_Pwd.answer.focus();
		return false;
	}
		
	else
	{   	
		document.Change_Pwd.submit();
		return true;
	}
}
