function validate(){
	var acc_number=document.search_acc_number.acc_number.value;
	
	if(acc_number==""){
		document.getElementById("err_message").innerHTML="Please enter Account Number";
		return false;
	}
	else{
		document.search_acc_number.submit();
		document.getElementById("err_message").innerHTML="";
		return true;
	}
}
function validateAdditionalProduct(){
	var chk=document.getElementsByName("additionalProduct");
	var flag=0;
	for(var i=0;i<chk.length;i++){
		if(chk[i].checked==true){
			flag=1;
			break;
		}
	}
	
	
	
	function branchName()
	{ var branch=document.contacts-form1.branchName.value;
	  if(branch=="<---------SELECT---------->")
		  document.getElementById("err_message").innerHTML="Please select proper branch";
	return false;
		
	}
	
	
	
	
	if(flag==0){
		document.getElementById("err_message").innerHTML="Please select atleast one additional product";
	}
	else{
		document.additional_product.submit();
	}
	return true;
}
function validateAccountNumber(){
	var acc_number=document.search_acc_number.acc_number.value;
	if(isNaN(acc_number)){
		document.getElementById("err_message").innerHTML="Account Number should be numeric only";
		return false;
	}
	/*else if(acc_number.length!=14){
		document.getElementById("err_message").innerHTML="Please enter 14 digit Account Number";
		return false;
	}*/
	else{
		document.getElementById("err_message").innerHTML="";
		return true;
	}
}

function business(){
	document.searchManager.tradingName.disabled=true;
	return true;
}


function npaValidate()
{
	
		if(elem.value=="0"){
			alert("Please select the product");
			elem.focus();
			return false;
		}else{
			return true;
		}
	
	
}

function validateReject(){
	if(confirm("Are you sure you want to reject Terms and Conditions?")==true){
		window.location.href("/NBG/AdditionalProductConfigServlet?action=reject");
		return true;
	}
	else{
		return false;
	}	
}



function trading(){
	document.searchManager.businessName.disabled=true;
	return true;
}

function service()
{
	var sealindex=document.account_creation.Product.selectedIndex;
	
	if(sealindex==0 )
	{
		alert("Please select Product");
		return false;
	}
	
}
function validateConfirm(){
	if(confirm("Account creation process will be terminated. Are you sure you want to exit?")==true){
		window.location.href="/NBG/AccountCreationServlet?action=closeSession";
		return true;
	}else{
		return false;
	}	
}
function bname(){
	var businessName=document.searchManager.businessName.value;
	
	if(businessName==""){
		document.getElementById("err_message").innerHTML="Please enter BusinessName";
		return false;
	}
	else{
		return true;
	}
}


function tname(){
	var tradingName=document.searchManager.tradingName.value;
	
	if(tradingName==""){
		document.getElementById("err_message1").innerHTML="Please enter TradingName";
		return false;
	}
	else{
		return true;
	}
}
