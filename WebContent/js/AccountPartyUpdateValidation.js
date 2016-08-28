function cancelPartyAddition()
{
	if(confirm("Details you entered will be lost. Do you want to continue ?")==true)
	{
		window.location.href = "/NBG/AccountPartyManagementServlet?action=Display_Business_Cust_Detail";
		return true;
	}
	else
	{
		return false;
	}
}

function cancelPartyAdditiontoBusiSummary()
{
	if(confirm("Details you entered will be lost. Do you want to continue ?")==true)
	{
		window.location.href = "./jsp/NonPersonalRegistraionSummary.jsp";
		return true;
	}
	else
	{
		return false;
	}
}

function cancelPartyAdditiontoFindCustomer()
{
	if(confirm("Details you entered will be lost. Do you want to continue ?")==true)
	{
		window.location.href = "/NBG/CustomerManagementServlet?action=find";
		return true;
	}
	else
	{
		return false;
	}
}

function cancelPartyAdditiontoMyPortal()
{
	if(confirm("Details you entered will be lost. Do you want to continue ?")==true)
	{
		window.location.href = "/NBG/CustomerManagementServlet?action=accopenerportal";
		return true;
	}
	else
	{
		return false;
	}
}

function validFName()
{
 var sampleVar=document.Account_party_core_details_update.firstName.value;
 var alphaExp =/^[a-zA-Z]+$/;
 if (sampleVar==null || sampleVar=="")
 {
    document.getElementById("err_msg2").innerHTML="Please enter first name";
    return false;
 }
 else if (!sampleVar.match(alphaExp))
 {
    document.getElementById("err_msg2").innerHTML="Please enter alphabets only";
    return false;
 }
 else if ((sampleVar.length)<2 || (sampleVar.length)>20)
 {
    document.getElementById("err_msg2").innerHTML="Please enter 2-20 alphabets only";
    return false;
 }
 else
 {
  document.getElementById("err_msg2").innerHTML="";
  return true;
 }
}

function validMName()
{
 var sampleVar=document.Account_party_core_details_update.middleName.value;
 var alphaExp =/^[a-zA-Z]+$/;
 if (!sampleVar.match(alphaExp) && (sampleVar.length)>0)
 {
    document.getElementById("err_msg3").innerHTML="Please enter alphabets only";
    return false;
 }
 else
 {
  document.getElementById("err_msg3").innerHTML="";
  return true;
 }
}

function validLName()
{
 var sampleVar=document.Account_party_core_details_update.lastName.value;
 var alphaExp =/^[a-zA-Z]+$/;
 if (sampleVar==null || sampleVar=="")
 {
    document.getElementById("err_msg4").innerHTML="Please enter last name";
    return false;
 }
 else if (!sampleVar.match(alphaExp))
 {
    document.getElementById("err_msg4").innerHTML="Please enter alphabets only";
    return false;
 }
 else
 {
  document.getElementById("err_msg4").innerHTML="";
  return true;
 }
}

function validateCoreDetailsUpdateForm()
{
	 if(validFName()==false)
	 {
		 document.Account_party_core_details_update.firstName.focus();
		 return true;
	 }
	 else if(validMName()==false)
	 {
		 document.Account_party_core_details_update.middleName.focus();
		 return true;
	 }
	 else if(validLName()==false)
	 {
		 document.Account_party_core_details_update.lastName.focus();
		 return true;
	 }
	 document.Account_party_core_details_update.submit();
 }



// Account party present address details validation

function validHouseNo()
{
	var sampleVar =document.Account_party_present_address_update.presentHouseNo.value;
	var alphaExp =/^[a-zA-Z0-9][a-zA-Z0-9\s()-]+$/;
	var alphaExp1 =/^[a-zA-Z0-9]+$/;
	var alphaExp2 =/^[a-zA-Z]+$/;
	if (sampleVar==null || sampleVar=="")
	{
	   document.getElementById("err_msg1").innerHTML="Please enter house number";
	   return false;
	}
	else if (!sampleVar.match(alphaExp) && !sampleVar.match(alphaExp1))
	{
	   document.getElementById("err_msg1").innerHTML="Please check house number";
	   return false;
	}
	else if (sampleVar.match(alphaExp2))
	{
	   document.getElementById("err_msg1").innerHTML="House number should contain digits";
	   return false;
	}
	else if ((sampleVar.length)>10)
	{
	   document.getElementById("err_msg1").innerHTML="Please enter maximum 10 characters";
	   return false;

	}
	else
	{
	  document.getElementById("err_msg1").innerHTML="";
	  return true;
	}
}


function validHouseName()
{
	var sampleVar =document.Account_party_present_address_update.presentHouseName.value;
	var alphaExp =/^[a-zA-Z][a-zA-Z\s]+$/;
	if (sampleVar==null || sampleVar=="")
	{
	   document.getElementById("err_msg2").innerHTML="Please enter house name";
	   return false;
	}
	else if ((sampleVar.length)<3 || (sampleVar.length)>30)
	{
	   document.getElementById("err_msg2").innerHTML="Please enter 3-20 alphabets only";
	   return false;
	
	}
	else if (!sampleVar.match(alphaExp))
	{
	   document.getElementById("err_msg2").innerHTML="Please check house name";
	   return false;
	}
	else
	{
	  document.getElementById("err_msg2").innerHTML="";
	  return true;
	}
}

function validpresentBuildingNo()
{
	var sampleVar =document.Account_party_present_address_update.presentBuildingNo.value;
	var alphaExp =/^[a-zA-Z0-9][a-zA-Z0-9\s()-]+$/;
	var alphaExp1 =/^[a-zA-Z0-9]+$/;
	var alphaExp2 = /^[a-zA-Z]+$/;
	
	if (sampleVar==null || sampleVar=="")
	{
	   document.getElementById("err_msg3").innerHTML="Please enter building number";
	   return false;
	}
	else if (!sampleVar.match(alphaExp) && !sampleVar.match(alphaExp1))
	{
	   document.getElementById("err_msg3").innerHTML="Please check building number";
	   return false;
	}
	else if (sampleVar.match(alphaExp2))
	{
	   document.getElementById("err_msg3").innerHTML="Building number should contain digits";
	   return false;
	}
	else if ((sampleVar.length)>10)
	{
	   document.getElementById("err_msg3").innerHTML="Please enter maximum 10 characters";
	   return false;

	}
	else
	{
	  document.getElementById("err_msg3").innerHTML="";
	  return true;
	}
}

function validpresentStreetName()
{
	var sampleVar =document.Account_party_present_address_update.presentStreet.value;	 
	var alphaExp =/^[a-zA-Z][a-zA-Z\s.]+$/;
	if (sampleVar==null || sampleVar=="")
	{
	   document.getElementById("err_msg4").innerHTML="Please enter street name";
	   return false;
	}
	else if ((sampleVar.length)<3 || (sampleVar.length)>40)
	{
	   document.getElementById("err_msg4").innerHTML="Please enter 3-40 alphabets only";
	   return false;
	}
	else if (!sampleVar.match(alphaExp))
	{
	   document.getElementById("err_msg4").innerHTML="Please check street name";
	   return false;
	}
	else
	{
	  document.getElementById("err_msg4").innerHTML="";
	  return true;
	}
}



function validpresentCity()
{
	var sampleVar =document.Account_party_present_address_update.presentCity.value;	 
	var alphaExp =/^[a-zA-Z][a-zA-Z\s]+$/;
	if (sampleVar==null || sampleVar=="")
	{
	   document.getElementById("err_msg5").innerHTML="Please enter city name";
	   return false;
	}
	else if ((sampleVar.length)<3 || (sampleVar.length)>30)
	{
	   document.getElementById("err_msg5").innerHTML="Please enter 3-30 alphabets only";
	   return false;
	
	}
	else if (!sampleVar.match(alphaExp))
	{
	   document.getElementById("err_msg5").innerHTML="Please check city name";
	   return false;
	}
	else
	{
	  document.getElementById("err_msg5").innerHTML="";
	  return true;
	}
}



function validpresentTown()
{
	var sampleVar =document.Account_party_present_address_update.presentTown.value;
	var alphaExp =/^[a-zA-Z][a-zA-Z\s]+$/;
	
	if (((sampleVar.length)>0&&(sampleVar.length)<3) || (sampleVar.length)>30)
	{
	   document.getElementById("err_msg6").innerHTML="Please enter 3-30 alphabets only";
	   return false;
	
	}
	else if (!sampleVar.match(alphaExp) && (sampleVar.length)>0)
	{
	   document.getElementById("err_msg6").innerHTML="Please check town name";
	   return false;
	}
	else
	{
	  document.getElementById("err_msg6").innerHTML="";
	  return true;
	}

}

function validPostalCode()
{
	var sampleVar=document.Account_party_present_address_update.presentPostalCode.value;
	
	var alphaExp =/^[A-Z0-9][A-Z0-9\s]+$/;
	var alphaExp2 =/^[A-Z]+$/;
	if (sampleVar==null || sampleVar=="")
	{
	   document.getElementById("err_msg8").innerHTML="Please enter postal code";
	   return false;
	}
	else if ((sampleVar.length)>10 || (sampleVar.length)<6)
	{
	   document.getElementById("err_msg8").innerHTML="Please enter 6 to 10 characters";
	   return false;
	}
	else if (sampleVar.match(alphaExp2))
	{
	   document.getElementById("err_msg8").innerHTML="Postal code should contain digits";
	   return false;
	}
	else if (!sampleVar.match(alphaExp))
	{
	   document.getElementById("err_msg8").innerHTML="Please check postal code";
	   return false;
	}
	else
	{
	  document.getElementById("err_msg8").innerHTML="";
	  return true;
	}

}

function validatePresentAddressUpdate()
{
	if(validHouseNo()==false)
	 {
		document.Account_party_present_address_update.presentHouseNo.focus();
		 return true;
	 }
	 else if(validHouseName()==false)
	 {
		 document.Account_party_present_address_update.presentHouseName.focus();
		 return true;
	 }
	 else if(validpresentBuildingNo()==false)
	 {
		 document.Account_party_present_address_update.presentBuildingNo.focus();
		 return true;
	 }
	 else if(validpresentStreetName()==false)
	 {
		 document.Account_party_present_address_update.presentStreet.focus();
		 return true;
	 }
	 else if(validpresentCity()==false)
	 {
		 document.Account_party_present_address_update.presentCity.focus();
		 return true;
	 }
	 else if(validpresentTown()==false)
	 {
		 document.Account_party_present_address_update.presentTown.focus();
		 return true;
	 }	
	 else if(validPostalCode()==false)
	 {
		 document.Account_party_present_address_update.presentPostalCode.focus();
		 return true;
	 }	
	document.Account_party_present_address_update.submit();
}

//Account party previous address details validation

function validHouseNoPr()
{
	var sampleVar =document.Update_Account_party_previous_address_details.previousHouseNo.value;
	var alphaExp =/^[a-zA-Z0-9][a-zA-Z0-9\s()-]+$/;
	var alphaExp1 = /^[a-zA-Z0-9]+$/;
	var alphaExp2 = /^[a-zA-Z]+$/;
	if (sampleVar==null || sampleVar=="")
	{
	   document.getElementById("err_msg1").innerHTML="Please enter house number";
	   return false;
	}
	else if (!sampleVar.match(alphaExp) && !sampleVar.match(alphaExp1))
	{
	   document.getElementById("err_msg1").innerHTML="Please check house number";
	   return false;
	}
	else if (sampleVar.match(alphaExp2))
	{
	   document.getElementById("err_msg1").innerHTML="House number should contain digits";
	   return false;
	}
	else if ((sampleVar.length)>10)
	{
	   document.getElementById("err_msg1").innerHTML="Please enter maximum 10 characters";
	   return false;

	}
	else
	{
	  document.getElementById("err_msg1").innerHTML="";
	  return true;
	}
}


function validHouseNamePr()
{
	var sampleVar =document.Update_Account_party_previous_address_details.previousHouseName.value;
	var alphaExp =/^[a-zA-Z][a-zA-Z\s]+$/;
	if (sampleVar==null || sampleVar=="")
	{
	   document.getElementById("err_msg2").innerHTML="Please enter house name";
	   return false;
	}
	else if ((sampleVar.length)<3 || (sampleVar.length)>30)
	{
	   document.getElementById("err_msg2").innerHTML="Please enter 3-20 alphabets only";
	   return false;
	
	}
	else if (!sampleVar.match(alphaExp))
	{
	   document.getElementById("err_msg2").innerHTML="Please check house name";
	   return false;
	}
	else
	{
	  document.getElementById("err_msg2").innerHTML="";
	  return true;
	}
}

function validBuildingNoPr()
{
	var sampleVar =document.Update_Account_party_previous_address_details.previousBuildingNo.value;
	var alphaExp =/^[a-zA-Z0-9][a-zA-Z0-9\s()-]+$/;
	var alphaExp1 =/^[a-zA-Z0-9]+$/;
	var alphaExp2 = /^[a-zA-Z]+$/;
	if (sampleVar==null || sampleVar=="")
	{
	   document.getElementById("err_msg3").innerHTML="Please enter building number";
	   return false;
	}
	else if (!sampleVar.match(alphaExp) && !sampleVar.match(alphaExp1))
	{
	   document.getElementById("err_msg3").innerHTML="Please check building number";
	   return false;
	}
	else if (sampleVar.match(alphaExp2))
	{
	   document.getElementById("err_msg3").innerHTML="Building number should contain digits";
	   return false;
	}
	else if ((sampleVar.length)>10)
	{
	   document.getElementById("err_msg3").innerHTML="Please enter maximum 10 characters";
	   return false;

	}
	else
	{
	  document.getElementById("err_msg3").innerHTML="";
	  return true;
	}
}

function validStreetNamePr()
{
	var sampleVar =document.Update_Account_party_previous_address_details.previousStreet.value;	 
	var alphaExp =/^[a-zA-Z][a-zA-Z\s.]+$/;
	if (sampleVar==null || sampleVar=="")
	{
	   document.getElementById("err_msg4").innerHTML="Please enter street name";
	   return false;
	}
	else if ((sampleVar.length)<3 || (sampleVar.length)>40)
	{
	   document.getElementById("err_msg4").innerHTML="Please enter 3-40 alphabets only";
	   return false;
	
	}
	else if (!sampleVar.match(alphaExp))
	{
	   document.getElementById("err_msg4").innerHTML="Please check street name";
	   return false;
	}
	else
	{
	  document.getElementById("err_msg4").innerHTML="";
	  return true;
	}
}



function validCityPr()
{
	var sampleVar =document.Update_Account_party_previous_address_details.previousCity.value;	 
	var alphaExp =/^[a-zA-Z][a-zA-Z\s]+$/;
	if (sampleVar==null || sampleVar=="")
	{
	   document.getElementById("err_msg5").innerHTML="Please enter city name";
	   return false;
	}
	else if ((sampleVar.length)<3 || (sampleVar.length)>30)
	{
	   document.getElementById("err_msg5").innerHTML="Please enter 3-30 alphabets only";
	   return false;
	}
	else if (!sampleVar.match(alphaExp))
	{
	   document.getElementById("err_msg5").innerHTML="Please check city name";
	   return false;
	}
	else
	{
	  document.getElementById("err_msg5").innerHTML="";
	  return true;
	}
}

function validTownPr()
{
	var sampleVar =document.Update_Account_party_previous_address_details.previousTown.value;
	var alphaExp =/^[a-zA-Z][a-zA-Z\s]+$/;
	
	if (((sampleVar.length)>0&&(sampleVar.length)<3) || (sampleVar.length)>30)
	{
	   document.getElementById("err_msg6").innerHTML="Please enter 3-20 alphabets only";
	   return false;
	}
	else if (!sampleVar.match(alphaExp) && (sampleVar.length)>0)
	{
	   document.getElementById("err_msg6").innerHTML="Please check town name";
	   return false;
	}
	else
	{
	  document.getElementById("err_msg6").innerHTML="";
	  return true;
	}

}


function validPostalCodePr()
{
	var sampleVar=document.Update_Account_party_previous_address_details.previousPostalCode.value;
	
	var alphaExp =/^[A-Z0-9][A-Z0-9\s]+$/;
	var alphaExp2 =/^[A-Z]+$/;
	if (sampleVar==null || sampleVar=="")
	{
	   document.getElementById("err_msg8").innerHTML="Please enter postal code";
	   return false;
	}
	else if ((sampleVar.length)>10 || (sampleVar.length)<6)
	{
	   document.getElementById("err_msg8").innerHTML="Please enter 6 to 10 characters";
	   return false;
	}
	else if (sampleVar.match(alphaExp2))
	{
	   document.getElementById("err_msg8").innerHTML="Postal code should contain digits";
	   return false;
	}
	else if (!sampleVar.match(alphaExp))
	{
	   document.getElementById("err_msg8").innerHTML="Please check postal code";
	   return false;
	}
	else
	{
	  document.getElementById("err_msg8").innerHTML="";
	  return true;
	}

}

function validatePreviousAddresUpdate()
{
	if(validHouseNoPr()==false)
	 {
		document.Update_Account_party_previous_address_details.previousHouseNo.focus();
		 return true;
	 }
	 else if(validHouseNamePr()==false)
	 {
		 document.Update_Account_party_previous_address_details.previoustHouseName.focus();
		 return true;
	 }
	 else if(validBuildingNoPr()==false)
	 {
		 document.Update_Account_party_previous_address_details.previousBuildingNo.focus();
		 return true;
	 }
	 else if(validStreetNamePr()==false)
	 {
		 document.Update_Account_party_previous_address_details.previousStreetName.focus();
		 return true;
	 }
	 else if(validCityPr()==false)
	 {
		 document.Update_Account_party_previous_address_details.previousCity.focus();
		 return true;
	 }
	 else if(validTownPr()==false)
	 {
		 document.Update_Account_party_previous_address_details.previousTown.focus();
		 return true;
	 }	
	
	 else if(validPostalCodePr()==false)
	 {
		 document.Update_Account_party_previous_address_details.previousPostalCode.focus();
		 return true;
	 }	
	document.Update_Account_party_previous_address_details.submit();
}

/*  Contact details validation */
function validEmail()
{
	var sampleVar=document.Update_Account_party_contact_details.eMailAddress.value;
	var alphaExp = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	if (sampleVar==null || sampleVar=="")
	{
	   document.getElementById("err_msg1").innerHTML="Please enter Email address";
	   return false;
	}
	else if(!sampleVar.match(alphaExp))
	{
		document.getElementById("err_msg1").innerHTML= "Please check Email address";
		return false;
	}	
	else{
			document.getElementById("err_msg1").innerHTML= "";
			return true;
	}
}


function validmobile1()
{
	var sampleVar=document.Update_Account_party_contact_details.mobileNo.value;
	var alphaExp =/^[+][0-9]+$/;
	if (sampleVar==null || sampleVar=="")
	{
	   document.getElementById("err_msg2").innerHTML="Please enter mobile number";
	   return false;
	}
	else if (sampleVar.charAt(0)!="+")
	{
	   document.getElementById("err_msg2").innerHTML="Mobile number should start with +";
	   return false;
	}
	else if (!sampleVar.match(alphaExp))
	{
	   document.getElementById("err_msg2").innerHTML="Mobile number should contain only digits";
	   return false;
	}
	else if (sampleVar.length!=13 || sampleVar<1)
	{
	   document.getElementById("err_msg2").innerHTML="2 digit Country code should be followed by 10 digit Mobile number";
	   return false;
	}
	else
	{
	   document.getElementById("err_msg2").innerHTML="";
	   return true;
	}
	
}

function validhomeCountryCode()
{
	var sampleVar=document.Update_Account_party_contact_details.HomeNo.value;
	var alphaExp =/^[+][0-9]+$/;
	if (sampleVar==null || sampleVar=="")
	{
	   document.getElementById("err_msg3").innerHTML="Please enter home contact number";
	   return false;
	}
	else if (sampleVar.charAt(0)!="+")
	{
	   document.getElementById("err_msg3").innerHTML="Home contact number should start with +";
	   return false;
	}
	else if (!sampleVar.match(alphaExp))
	{
	   document.getElementById("err_msg3").innerHTML="Home contact number should contain only digits";
	   return false;
	}
	else if (sampleVar.length<9  || sampleVar<1)
	{
	   document.getElementById("err_msg3").innerHTML="Country code should be followed by Area code and telephone number";
	   return false;
	}
	else
	{
	   document.getElementById("err_msg3").innerHTML="";
	   return true;
	}
}


function validofficeCountryCode()
{
	var sampleVar=document.Update_Account_party_contact_details.OfficNo.value;
	var alphaExp =/^[+][0-9]+$/;
	if (sampleVar==null || sampleVar=="")
	{
	   document.getElementById("err_msg4").innerHTML="Please enter office number";
	   return false;
	}
	else if (sampleVar.charAt(0)!="+")
	{
	   document.getElementById("err_msg4").innerHTML="Office number should start with +";
	   return false;
	}
	else if (!sampleVar.match(alphaExp))
	{
	   document.getElementById("err_msg4").innerHTML="Office number should contain only digits";
	   return false;
	}
	else if (sampleVar.length<9  || sampleVar<1)
	{
	   document.getElementById("err_msg4").innerHTML="Country code should be followed by Area code and telephone number";
	   return false;
	}
	else
	{
	   document.getElementById("err_msg4").innerHTML="";
	   return true;
	}
	
}
/*
function valididprooffile()
{
	var sampleVar=document.Update_Account_party_contact_details.idProofFile.value;
	if (sampleVar=="" || sampleVar==" ")
	{
	   document.getElementById("err_msg6").innerHTML="Please select id proof file";
	   return false;
	}
	else
	{
	   document.getElementById("err_msg6").innerHTML="";
	   return true;
	}
	
}

function validaddressprooffile()
{
	var sampleVar=document.Update_Account_party_contact_details.addressProofFile.value;
	if (sampleVar=="" || sampleVar==" ")
	{
	   document.getElementById("err_msg8").innerHTML="Please select address proof file";
	   return false;
	}
	else
	{
	   document.getElementById("err_msg8").innerHTML="";
	   return true;
	}
	
}*/

function validatePartyContactsUpdate()
{
	if(validEmail()==false)
	 {
		document.Update_Account_party_contact_details.eMailAddress.focus();
		 return true;
	 }
	 else if(validmobile1()==false)
	 {
		 document.Update_Account_party_contact_details.mobileCountryCode.focus();
		 return true;
	 }
	 else if(validhomeCountryCode()==false)
	 {
		 document.Update_Account_party_contact_details.homeCountryCode.focus();
		 return true;
	 }
	 else if(validofficeCountryCode()==false)
	 {
		 document.Update_Account_party_contact_details.officeCountryCode.focus();
		 return true;
	 }
	/* else if(valididprooffile()==false)
	 {
		 document.Update_Account_party_contact_details.idProofFile.focus();
		 return true;
	 }
	 else if(validaddressprooffile()==false)
	 {
		 document.Update_Account_party_contact_details.addressProofFile.focus();
		 return true;
	 }*/
	document.Update_Account_party_contact_details.submit();
}




