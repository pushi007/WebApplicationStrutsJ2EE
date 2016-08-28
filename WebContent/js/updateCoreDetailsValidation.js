function validateCoreUpdationForm() {

	var businessName = document.updateCore_form.bname.value;
	var tradingName = document.updateCore_form.trdname.value;
	var businessType = document.updateCore_form.btype.value;
	var branch = document.updateCore_form.bbname.value;
	var isStartUp = document.updateCore_form.startup[0].checked;
	var isStart = document.updateCore_form.startup[1].checked;
	var country = document.updateCore_form.country.value;
	var expectedTurnOver = document.updateCore_form.turnover.value;
	var businessCapital = document.updateCore_form.capital.value;
	var businessStatus1 = document.updateCore_form.bstatus[0].checked;
	var businessStatus2 = document.updateCore_form.bstatus[1].checked;

	if (validateBusinessName() == false) {

		return false;
	} else {
		document.getElementById("error_bname").innerHTML = "";
		document.updateCore_form.trdname.focus();

	}
	if (validateTradeName() == false) {
		
		return false;
	} else {

		document.getElementById("error_trdname").innerHTML = "";
		document.updateCore_form.btype.focus();
	}
if (validateBusinessType()==false) {
		
		return true;
	} else {
		document.getElementById("error_btype").innerHTML = "";
		document.updateCore_form.bbname.focus();
		
	}
	if (validateBankBranch()==false) {
		
		return true;
	} else {
		document.getElementById("error_branch").innerHTML = "";
	

	}

	if (isStartUpBusiness()==false) {
		
		return true;
	} else {

		document.getElementById("error_isstart").innerHTML = "";
		
	}/*if(validateDate()==false){
		return true;
		
	}else{
		document.getElementById("error_dor").innerHTML="";
		document.getElementById("error_doe").innerHTML="";
		
		
	}if(validateDateForValue()==false){
		return false;
	}else{
		document.getElementById("error_dor").innerHTML="";
		document.getElementById("error_doe").innerHTML="";
		
	}*/

	if (validateCountry()==false) {
		
		return false;
	} else {
		document.getElementById("error_country").innerHTML = "";
		document.updateCore_form.turnover.focus();

	}

	if (annualTurnOver() == false) {
		
		return false;
	} else {
		document.getElementById("error_turnover").innerHTML = "";
		document.updateCore_form.capital.focus();

	}
	if (validateBusinessCapital() == false) {
		return false;
	} else {
		document.getElementById("error_capital").innerHTML = "";
		document.updateCore_form.noemp.focus();

	}
	if (validateBStatus()==false) {
		
		return false;
	}
	if (validateNoOfEmployee() == false) {
	
		return false;
	}

	
		document.getElementById("error_bstatus").innerHTML = "";
		document.updateCore_form.submit();
		return true;

	
}



function enableDate() {
	var isstartUpYes = document.updateCore_form.startup[0].checked;
	var isstartUpNo = document.updateCore_form.startup[1].checked;
	if (isstartUpYes == true) {
		document.updateCore_form.dor.disabled = false;

		document.updateCore_form.doe.disabled = true;
		document.updateCore_form.doe.value="";
		document.getElementById("doeimage").style.display="none";
		document.getElementById("dorimage").style.display="inline";
		document.getElementById("error_dor").innerHTML="";
		document.getElementById("error_doe").innerHTML="";

	} else if (isstartUpNo == true) {

		document.updateCore_form.dor.disabled = true;

		document.updateCore_form.doe.disabled = false;
		document.updateCore_form.dor.value="";
		document.getElementById("dorimage").style.display="none";
		document.getElementById("doeimage").style.display="inline";
		document.getElementById("error_dor").innerHTML="";
		document.getElementById("error_doe").innerHTML="";


	}

}

function validateBusinessName() {
	var businessName = document.updateCore_form.bname.value;
	var alphaExp = /^([\!a-zA-Z1-9])+([a-zA-Z\&\!\#\@\$\%\.]{0,1})([\s])?([0-9]{0,2})?([\s])?([a-zA-Z0-9\!#@$%&.\s]){0,28}$/;
	if (businessName == null || businessName == "") {
		document.getElementById("error_bname").innerHTML = "Please enter business name";
		return false;
	} else if (!businessName.match(alphaExp)) {
		document.getElementById("error_bname").innerHTML = "Please check business name";
		return false;
	} else if (businessName.length < 2) {
		document.getElementById("error_bname").innerHTML = "Please enter 2 to 30 alphabets";
		return false;
	} else if (businessName.length > 30) {
		document.getElementById("error_bname").innerHTML = "Please enter 2 to 30 alphabets";
		return false;
	} else {
		document.getElementById("error_bname").innerHTML = "";
		document.updateCore_form.trdname.focus();
		return true;
	}
}

function validateTradeName() {
	var tradingName = document.updateCore_form.trdname.value;
	var alphaExp = /^([\!a-zA-Z1-9])+([a-zA-Z\&\!\#\@\$\%\.]{0,1})([\s]{0,1})([0-9]{0,2})([\s]{0,1})([a-zA-Z0-9\!#@$%&.\s]){0,28}$/;
	if (tradingName == null || tradingName =="") {
		document.getElementById("error_trdname").innerHTML = "Please enter trading name";
		return false;
	} else if (!tradingName.match(alphaExp)) {
		document.getElementById("error_trdname").innerHTML = "Please check trading name";
		return false;
	}
	if (tradingName.length < 2) {
		document.getElementById("error_trdname").innerHTML = "Please enter 2 to 20 alphabets";
		return false;
	} else if (tradingName.length > 20) {
		document.getElementById("error_trdname").innerHTML = "Please enter 2 to 20 alphabets";
		return false;
	} else {
		document.getElementById("error_trdname").innerHTML = "";
		return true;
	}

}

function annualTurnOver() {
	var expectedTurnOver = document.updateCore_form.turnover.value;
	var digitAnnual = /^([0-9]{1,2})(\.[0-9]{1,2})?$/;
	if (expectedTurnOver == "" || expectedTurnOver == 0) {
		document.getElementById("error_turnover").innerHTML = "Please enter annual turnover";
		return false;
	}else if(expectedTurnOver>99){
		document.getElementById("error_turnover").innerHTML = "Please enter a number less than 100";
		return false;
	} 
	else if (!expectedTurnOver.match(digitAnnual)) {
		document.getElementById("error_turnover").innerHTML = "Please check annual turnover";
		return false;
	}

	else {
		document.getElementById("error_turnover").innerHTML = "";
		return true;
	}
}

function validateBusinessCapital() {
	var businessCapita = document.updateCore_form.capital.value;
	var digitAnnual = /^([0-9]{1,2})(\.[0-9]{1,2})?$/;
	if (businessCapita == "" || businessCapita == 0) {
		document.getElementById("error_capital").innerHTML = "Please Enter business capital";
		return false;
	}else if(businessCapita>99){
		document.getElementById("error_capital").innerHTML = "Please enter a number less than 100";
		return false;
	} 
	else if (!businessCapita.match(digitAnnual)) {
		document.getElementById("error_capital").innerHTML = "Please check business capital";
		return false;
	}

	else {
		document.getElementById("error_capital").innerHTML = "";
		return true;
	}
}

function validateNoOfEmployee() {

	  var digitNoEmp = /^[0-9]+$/; 
	  var noOfEmployee = document.updateCore_form.noemp.value;
	  
	  if(!noOfEmployee.match(digitNoEmp)) {
	  document.getElementById("error_noemp").innerHTML = "Please enter only numbers";
	  
	 return false;
	  
	  }if(noOfEmployee==0){
		  document.getElementById("error_noemp").innerHTML = "Please check no of employees";
		  
			 return false;
	  }
	  if(noOfEmployee.length>7){
		  document.getElementById("error_noemp").innerHTML = "Please enter a maximum of 7 digits";
		  return false;
		  
	  }
	  else{  
		  document.getElementById("error_noemp").innerHTML = "";
	  return true; 
	  }
	 
return true;
}

function validateBusinessType(){
	var businessType = document.updateCore_form.btype.value;
	if(businessType==0){
		document.getElementById("error_btype").innerHTML = "Please select business type";
		return false;
		
	}else{
		document.getElementById("error_btype").innerHTML = "";
		return true;
		
	}
	
}

function validateBankBranch(){
	var branch = document.updateCore_form.bbname.value;
	if(branch==0){
		document.getElementById("error_branch").innerHTML = "Please select branch";
		return false;
		
	}else{
		document.getElementById("error_branch").innerHTML = "";
          return true;		
	}
	
	
}

function isStartUpBusiness(){
	var isStartUp = document.updateCore_form.startup[0].checked;
	var isStart = document.updateCore_form.startup[1].checked;
	if(isStartUp==false&&isStart==false){
		document.getElementById("error_isstart").innerHTML = "Please check start up business";
		return false;
	}else{
		document.getElementById("error_isstart").innerHTML = "";
		return true;
		
	}
	
}

function validateCountry(){
	
	var country = document.updateCore_form.country.value;
	if(country==0){
		document.getElementById("error_country").innerHTML = "Please select country";
		return false;
		
		
	}else{
		document.getElementById("error_country").innerHTML = "";
		return true;
		
		
	}
}
function validateBStatus(){
	var businessStatus1 = document.updateCore_form.bstatus[0].checked;
	var businessStatus2 = document.updateCore_form.bstatus[1].checked;
	if(businessStatus1==false&&businessStatus2==false){
		document.getElementById("error_bstatus").innerHTML = "Please check business status";
		return false;

		
	}else{
		document.getElementById("error_bstatus").innerHTML = "";
		return true;
		
	}
	
	
	
}

/*function validateDate(){
	var isStartup=document.getElementById("isStart").checked;
//	var dateOfReg=document.updateCore_form.dor.value;
	var dateOfEstab=document.updateCore_form.doe.value;
	if(isStartup==true){
		
		if(dateOfReg==""){
			document.getElementById("error_dor").innerHTML="Please enter date of registration";
			return false;
		}else{
			
			document.getElementById("error_dor").innerHTML="";
			return true;
		}
		
	}else{
		if(dateOfEstab==""){
			document.getElementById("error_doe").innerHTML="Please enter date of establishment";
			return false;
		}else{
			document.getElementById("error_doe").innerHTML="";
		return true;	
		}
		
	}*/
	
	
//}


/*function validateDateForValue()
{
var today=new Date();
var dd = today.getDate(); 
var mm = today.getMonth()+1;// January is 0!
var yyyy = today.getFullYear(); 
if(dd<10){dd='0'+dd;} 
if(mm<10){mm='0'+mm;} 
today="";
today=yyyy+"/"+mm+"/"+dd;

var isstartUpYes = document.updateCore_form.startup[0].checked;
var isstartUpNo = document.updateCore_form.startup[1].checked;
if (isstartUpYes == true) {
	
	if(new Date(document.updateCore_form.dor.value)<new Date(today)){
		document.getElementById("error_dor").innerHTML="Please check date of registration";
		return false;
	}else{
		document.getElementById("error_dor").innerHTML="";
		return true;
	}

} else if (isstartUpNo == true) {

	if(new Date(document.updateCore_form.doe.value)>new Date(today)){
		document.getElementById("error_doe").innerHTML="Please check date of establishment";
		return false;
	}else{
		document.getElementById("error_doe").innerHTML="";
		return true;
	}

}
}*/


/*
 * function startDate(){ var isstartUpYes =
 * document.updateCore_form.startup[0].checked; var isstartUpNo =
 * document.updateCore_form.startup[1].checked; if (isstartUpYes == true) {
 * 
 * document.updateCore_form.doe.disabled = true;
 * 
 * document.getElementById("doeimage").style.display="none";
 * 
 *  } else if (isstartUpNo == true) {
 * 
 * document.updateCore_form.dor.disabled = true;
 * 
 * 
 * 
 * document.getElementById("dorimage").style.display="none";
 * 
 * 
 *  }
 * 
 *  }
 */


