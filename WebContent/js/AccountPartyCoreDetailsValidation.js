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

function validTitle()
{
 var sampleVar=document.Account_party_core_details.title.value;
 if(sampleVar=="select")
 { 
  document.getElementById("err_msg1").innerHTML="Please select title";
  return false;
 }
 else{
  document.getElementById("err_msg1").innerHTML="";
  return true;
 }
} 

function validFName()
{
 var sampleVar=document.Account_party_core_details.firstName.value;
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
 var sampleVar=document.Account_party_core_details.middleName.value;
 var alphaExp =/^[a-zA-Z]+$/;
 if (!sampleVar.match(alphaExp) && (sampleVar.length)>0)
 {
    document.getElementById("err_msg3").innerHTML="Please enter alphabets only";
    return false;
 }
/* else if ((sampleVar.length)>20)
 {
    document.getElementById("err_msg3").innerHTML="Please enter maximum 20 alphabets";
    return false;
 }*/
 else
 {
  document.getElementById("err_msg3").innerHTML="";
  return true;
 }
}

function validLName()
{
 var sampleVar=document.Account_party_core_details.lastName.value;
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
/* else if ((sampleVar.length)<2 || (sampleVar.length)>20)
 {
    document.getElementById("err_msg4").innerHTML="Please enter 2-20 alphabets only";
    return false;
 }*/
 else
 {
  document.getElementById("err_msg4").innerHTML="";
  return true;
 }
}

function validRelation()
{
 var sampleVar=document.Account_party_core_details.relationshipType.value;
 if(sampleVar=="select")
 { 
  document.getElementById("err_msg5").innerHTML="Please select relationship";
  return false;
 }
 else{
  document.getElementById("err_msg5").innerHTML="";
  return true;
 }
} 

function validAccNo()
{
	var sampleVar=document.Account_party_core_details.accountNumber.value;
	 var alphaExp =/^[0-9]+$/;
	 if (sampleVar==null || sampleVar=="")
	 {
	    document.getElementById("err_msg9").innerHTML="Please enter account number";
	    return false;
	 }
	 else if (!sampleVar.match(alphaExp))
	 {
	    document.getElementById("err_msg9").innerHTML="Please enter numbers only";
	    return false;
	 }
	 else if (sampleVar.length!=10)
	 {
	    document.getElementById("err_msg9").innerHTML="Please enter 10 digits only";
	    return false;
	 }
	 else if (sampleVar==0)
	 {
	    document.getElementById("err_msg9").innerHTML="Please check account number";
	    return false;
	 }
	 else
	 {
	  document.getElementById("err_msg9").innerHTML="";
	  return true;
	 } 
}

function validBranch()
{
	var sampleVar=document.Account_party_core_details.branchName.value;
	if(sampleVar=="select")
	{ 
		document.getElementById("err_msg10").innerHTML="Please select branch";
		return false;
	}
	else
	{
		document.getElementById("err_msg10").innerHTML="";
		return true;
	}
}

function validateCoreDetailsForm()
{
	 if(validTitle()==false)
	 {
		 document.Account_party_core_details.title.focus();
		 return true;
	 }
	 else if(validFName()==false)
	 {
		 document.Account_party_core_details.firstName.focus();
		 return true;
	 }
	 else if(validMName()==false)
	 {
		 document.Account_party_core_details.middleName.focus();
		 return true;
	 }
	 else if(validLName()==false)
	 {
		 document.Account_party_core_details.lastName.focus();
		 return true;
	 }
	 else if(validRelation()==false)
	 {
		 document.Account_party_core_details.relationshipType.focus();
		 return true;
	 }
	 if(!document.getElementById('keyYes').checked && !document.getElementById('keyNo').checked)
	 {
		 document.getElementById("err_msg7").innerHTML="Please select key party";
		 return true;
	 }
	 else
	 {
		 document.getElementById("err_msg7").innerHTML=""; 
	 }
	 if(!document.getElementById('Yes').checked && !document.getElementById('No').checked)
	 {
		 document.getElementById("err_msg8").innerHTML="Please select customer type";
		 return true;
	 }
	 else
	 {
		 document.getElementById("err_msg8").innerHTML="";
	 }
	 
	 if(document.getElementById('Yes').checked)
	 {
		 var sampleVar=document.Account_party_core_details.accountNumber.value;
		 var alphaExp =/^[0-9]+$/;
		 if (sampleVar==null || sampleVar=="")
		 {
		    document.getElementById("err_msg9").innerHTML="Please enter account number";
		    return false;
		 }
		 else if (!sampleVar.match(alphaExp))
		 {
		    document.getElementById("err_msg9").innerHTML="Please enter digits only";
		    return false;
		 }
		 else if (sampleVar.length!=10)
		 {
		    document.getElementById("err_msg9").innerHTML="Please enter 10 digits only";
		    return false;
		 }
		 else if (sampleVar==0)
		 {
		    document.getElementById("err_msg9").innerHTML="Please check account number";
		    return false;
		 }
		 else
		 {
		  document.getElementById("err_msg9").innerHTML="";
		 } 
	 }
	 if(document.getElementById('Yes').checked)
	 {
		 var sampleVar=document.Account_party_core_details.branchName.value;
		 if(sampleVar=="select")
		 { 
		  document.getElementById("err_msg10").innerHTML="Please select branch";
		  return false;
		 }
		 else
		 {
		  document.getElementById("err_msg10").innerHTML="";
		 }
	 }
	 
	 if(document.Account_party_core_details.dateOfBirth.value.length<1)
	 {
		 document.getElementById("err_msg6").innerHTML="Please select Date of Birth";
		 return false;
	 }
	 
	 var today=new Date();
	 var dd = today.getDate(); 
	 var mm = today.getMonth()+1;// January is 0!
	 var yyyy = today.getFullYear(); 
	 if(dd<10){dd='0'+dd;} 
	 if(mm<10){mm='0'+mm;} 
	 today="";
	 today=yyyy+"/"+mm+"/"+dd;
	 
	 if(new Date(document.Account_party_core_details.dateOfBirth.value)>new Date(today))
	 {
			document.getElementById("err_msg6").innerHTML="Please check date of birth";
			return false;
	 }
	 
	var dob=new Date(document.Account_party_core_details.dateOfBirth.value);
	var bdd=dob.getDate();
	var bmm=dob.getMonth()+1;
	var byy=dob.getFullYear();
		
		//Today's date
	var today1=new Date();
	var dd=today1.getDate();
	var mm=today1.getMonth()+1;
	var yy=today1.getFullYear();
			
	var yearDifference = (mm == bmm && dd > bdd) ? 
				yy - byy : (mm > bmm) ? yy - byy : yy - byy-1;
	if(yearDifference<18)
	{
		 document.getElementById("err_msg6").innerHTML = "Party's age should be greater than 18 years";
			return false;
	}
	/* var beforeDate=new Date();
	 beforedate=today;
	 beforedate.setYear(beforedate.getYear() - 18);
	 alert("ok");
	 if(new Date(document.Account_party_core_details.dateOfBirth.value)>new Date(beforedate))
	 {
		 
			document.getElementById("err_msg6").innerHTML="Not 18 years old";
			return false;
	 }*/
	 
	 
 document.Account_party_core_details.submit();
 }



function validateCoreDetailsForm1()
{
	 if(validFName()==false)
	 {
		 document.Account_party_core_details.firstName.focus();
		 return true;
	 }
	 else if(validMName()==false)
	 {
		 document.Account_party_core_details.middleName.focus();
		 return true;
	 }
	 else if(validLName()==false)
	 {
		 document.Account_party_core_details.lastName.focus();
		 return true;
	 }
 document.Account_party_core_details.submit();
}

// Account party present address details validation

function validHouseNo()
{
	var sampleVar =document.Account_party_present_address_details.presentHouseNo.value;
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
	   document.getElementById("err_msg1").innerHTML="House number should contain numbers  ";
	   return false;
	}
	else if ((sampleVar.length)>10)
	{
	   document.getElementById("err_msg1").innerHTML="Please enter maximum of 10 characters";
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
	var sampleVar =document.Account_party_present_address_details.presentHouseName.value;
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
	var sampleVar =document.Account_party_present_address_details.presentBuildingNo.value;
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
	   document.getElementById("err_msg3").innerHTML="Please enter maximum of 10 characters";
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
	var sampleVar =document.Account_party_present_address_details.presentStreetName.value;	 
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
	var sampleVar =document.Account_party_present_address_details.presentCity.value;	 
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
	var sampleVar =document.Account_party_present_address_details.presentTown.value;
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

function validcountry()
{
 var sampleVar=document.Account_party_present_address_details.presentCountry.value;
 if(sampleVar=="select")
 { 
  document.getElementById("err_msg7").innerHTML="Please select country";
  return false;
 }
 else
 {
	  document.getElementById("err_msg7").innerHTML="";
	  return true;
 }
} 

function validPostalCode()
{
	var sampleVar=document.Account_party_present_address_details.presentPostalCode.value;
	
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
	   document.getElementById("err_msg8").innerHTML="Postal code should contain digits only";
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

function validatePresentAddres()
{
	if(validHouseNo()==false)
	 {
		document.Account_party_present_address_details.presentHouseNo.focus();
		 return true;
	 }
	 else if(validHouseName()==false)
	 {
		 document.Account_party_present_address_details.presentHouseName.focus();
		 return true;
	 }
	 else if(validpresentBuildingNo()==false)
	 {
		 document.Account_party_present_address_details.presentBuildingNo.focus();
		 return true;
	 }
	 else if(validpresentStreetName()==false)
	 {
		 document.Account_party_present_address_details.presentStreetName.focus();
		 return true;
	 }
	 else if(validpresentCity()==false)
	 {
		 document.Account_party_present_address_details.presentCity.focus();
		 return true;
	 }
	 else if(validpresentTown()==false)
	 {
		 document.Account_party_present_address_details.presentTown.focus();
		 return true;
	 }	
	 else if(validcountry()==false)
	 {
		 document.Account_party_present_address_details.presentCountry.focus();
		 return true;
	 }
	 else if(validPostalCode()==false)
	 {
		 document.Account_party_present_address_details.presentPostalCode.focus();
		 return true;
	 }	
	
	 if(document.Account_party_present_address_details.presentAddressDate.value.length<1)
	 {
		 document.getElementById("err_msg9").innerHTML="Please select Date of present address";
		 return false;
	 }
	 
	 var today=new Date();
	 var dd = today.getDate(); 
	 var mm = today.getMonth()+1;// January is 0!
	 var yyyy = today.getFullYear(); 
	 if(dd<10){dd='0'+dd;} 
	 if(mm<10){mm='0'+mm;} 
	 today="";
	 today=yyyy+"/"+mm+"/"+dd;
	 
	 if(new Date(document.Account_party_present_address_details.presentAddressDate.value)>new Date(today))
	 {
			document.getElementById("err_msg9").innerHTML="Please check date of present address";
			return false;
	 }
	document.Account_party_present_address_details.submit();
}

//Account party previous address details validation

function validHouseNoPr()
{
	var sampleVar =document.Account_party_previous_address_details.previousHouseNo.value;
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
	   document.getElementById("err_msg1").innerHTML="Please enter maximum of 10 characters";
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
	var sampleVar =document.Account_party_previous_address_details.previousHouseName.value;
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
	var sampleVar =document.Account_party_previous_address_details.previousBuildingNo.value;
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
	   document.getElementById("err_msg3").innerHTML="Please enter maximum of 10 characters";
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
	var sampleVar =document.Account_party_previous_address_details.previousStreet.value;	 
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
	var sampleVar =document.Account_party_previous_address_details.previousCity.value;	 
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
	var sampleVar =document.Account_party_previous_address_details.previousTown.value;
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

function validcountryPr()
{
	var sampleVar=document.Account_party_previous_address_details.previousCountry.value;
	if(sampleVar=="select")
	{ 
	document.getElementById("err_msg7").innerHTML="Please select country";
	return false;
	}
	else
	{
		  document.getElementById("err_msg7").innerHTML="";
		  return true;
	}
} 

function validPostalCodePr()
{
	var sampleVar=document.Account_party_previous_address_details.previousPostalCode.value;
	
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
	   document.getElementById("err_msg8").innerHTML="Postal code should contain digits only";
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

function validatePreviousAddres()
{
	if(validHouseNoPr()==false)
	 {
		document.Account_party_previous_address_details.previousHouseNo.focus();
		 return true;
	 }
	 else if(validHouseNamePr()==false)
	 {
		 document.Account_party_previous_address_details.previoustHouseName.focus();
		 return true;
	 }
	 else if(validBuildingNoPr()==false)
	 {
		 document.Account_party_previous_address_details.previousBuildingNo.focus();
		 return true;
	 }
	 else if(validStreetNamePr()==false)
	 {
		 document.Account_party_previous_address_details.previousStreetName.focus();
		 return true;
	 }
	 else if(validCityPr()==false)
	 {
		 document.Account_party_previous_address_details.previousCity.focus();
		 return true;
	 }
	 else if(validTownPr()==false)
	 {
		 document.Account_party_previous_address_details.previousTown.focus();
		 return true;
	 }	
	 else if(validcountryPr()==false)
	 {
		 document.Account_party_previous_address_details.previousCountry.focus();
		 return true;
	 }
	 else if(validPostalCodePr()==false)
	 {
		 document.Account_party_previous_address_details.previousPostalCode.focus();
		 return true;
	 }	
	document.Account_party_previous_address_details.submit();
}

/*  Contact details validation */
function validEmail()
{
	var sampleVar=document.Account_party_contact_details.eMailAddress.value;
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
	var sampleVar=document.Account_party_contact_details.mobileCountryCode.value;
	if (sampleVar==null || sampleVar=="")
	{
	   document.getElementById("err_msg2").innerHTML="Please enter Country code";
	   return false;
	}
	else if (sampleVar.charAt(0)!="+")
	{
	   document.getElementById("err_msg2").innerHTML="Country code should start with +";
	   return false;
	}
	else if (isNaN(sampleVar.charAt(1)) || isNaN(sampleVar.charAt(2)))
	{
	   document.getElementById("err_msg2").innerHTML="Country code should contain digits only";
	   return false;
	}
	else if (sampleVar.length!=3)
	{
	   document.getElementById("err_msg2").innerHTML="Country code should be of 3 digits";
	   return false;
	}
	else if (sampleVar<=0 || sampleVar.charAt(1)==" " || sampleVar.charAt(2)==" ")
	{
	   document.getElementById("err_msg2").innerHTML="Please check Country code";
	   return false;
	}
	else
	{
	   document.getElementById("err_msg2").innerHTML="";
	   return true;
	}
	
}
function validmobile2()
{
	var sampleVar=document.Account_party_contact_details.mobileTelephoneNumber.value;
	var alphaExp =/^[0-9]+$/;
	if (sampleVar=="" || sampleVar==" ")
	{
	   document.getElementById("err_msg2").innerHTML="Please enter mobile number";
	   return false;
	}
	else if (!sampleVar.match(alphaExp))
	{
	   document.getElementById("err_msg2").innerHTML="Mobile number should contain digits only";
	   return false;
	}
	else if ((sampleVar.length!=10))
	{
	   document.getElementById("err_msg2").innerHTML="Mobile number should be of 10 digits";
	   return false;
	}
	else if (sampleVar==0)
	{
	   document.getElementById("err_msg2").innerHTML="Please check Mobile number";
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
	var sampleVar=document.Account_party_contact_details.homeCountryCode.value;
	if (sampleVar==null || sampleVar=="")
	{
	   document.getElementById("err_msg3").innerHTML="Please enter Country code";
	   return false;
	}
	else if (sampleVar.charAt(0)!="+")
	{
	   document.getElementById("err_msg3").innerHTML="Country code should start with +";
	   return false;
	}
	else if (isNaN(sampleVar.charAt(1)) || isNaN(sampleVar.charAt(2)))
	{
	   document.getElementById("err_msg3").innerHTML="Country code should contain digits only";
	   return false;
	}
	else if (sampleVar.length!=3)
	{
	   document.getElementById("err_msg3").innerHTML="Country code should be of 3 digits";
	   return false;
	}
	else if (sampleVar<=0 || sampleVar.charAt(1)==" " || sampleVar.charAt(2)==" ")
	{
	   document.getElementById("err_msg3").innerHTML="Please check Country code";
	   return false;
	}
	else
	{
	   document.getElementById("err_msg3").innerHTML="";
	   return true;
	}
}

function validhomeCityCode()
{
	var sampleVar=document.Account_party_contact_details.homeCityCode.value;
	var alphaExp =/^[0-9]+$/;
	if (sampleVar=="" || sampleVar==" ")
	{
	   document.getElementById("err_msg3").innerHTML="Please enter city code";
	   return false;
	}
	else if (!sampleVar.match(alphaExp))
	{
	   document.getElementById("err_msg3").innerHTML="City code should contain digit only";
	   return false;
	}
	else if ((sampleVar.length<2))
	{
	   document.getElementById("err_msg3").innerHTML="City code should be of 2 to 6 digits";
	   return false;
	}
	else
	{
	   document.getElementById("err_msg3").innerHTML="";
	   return true;
	}
	
}

function validhomeTelephoneNumber()
{
	var sampleVar=document.Account_party_contact_details.homeTelephoneNumber.value;
	var alphaExp =/^[0-9]+$/;
	if (sampleVar=="" || sampleVar==" ")
	{
	   document.getElementById("err_msg3").innerHTML="Please enter telephone number";
	   return false;
	}
	else if (!sampleVar.match(alphaExp))
	{
	   document.getElementById("err_msg3").innerHTML="Telephone number should contain only digits";
	   return false;
	}
	else if ((sampleVar.length<4))
	{
	   document.getElementById("err_msg3").innerHTML="Telephone number should be of 4 to 8 digits";
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
	var sampleVar=document.Account_party_contact_details.officeCountryCode.value;
	if (sampleVar==null || sampleVar=="")
	{
	   document.getElementById("err_msg4").innerHTML="Please enter Country code";
	   return false;
	}
	else if (sampleVar.charAt(0)!="+")
	{
	   document.getElementById("err_msg4").innerHTML="Country code should start with +";
	   return false;
	}
	else if (isNaN(sampleVar.charAt(1)) || isNaN(sampleVar.charAt(2)))
	{
	   document.getElementById("err_msg4").innerHTML="Country code should contain only digits";
	   return false;
	}
	else if (sampleVar.length!=3)
	{
	   document.getElementById("err_msg4").innerHTML="Country code should be of 3 digits";
	   return false;
	}
	else if (sampleVar<=0 || sampleVar.charAt(1)==" " || sampleVar.charAt(2)==" ")
	{
	   document.getElementById("err_msg4").innerHTML="Please check Country code";
	   return false;
	}
	else
	{
	   document.getElementById("err_msg4").innerHTML="";
	   return true;
	}
	
}

function validofficeCityCode()
{
	var sampleVar=document.Account_party_contact_details.officeCityCode.value;
	var alphaExp =/^[0-9]+$/;
	if (sampleVar=="" || sampleVar==" ")
	{
	   document.getElementById("err_msg4").innerHTML="Please enter city code";
	   return false;
	}
	else if (!sampleVar.match(alphaExp))
	{
	   document.getElementById("err_msg4").innerHTML="City code contains  digits only";
	   return false;
	}
	else if ((sampleVar.length<2))
	{
	   document.getElementById("err_msg4").innerHTML="City code should be of 2 to 6 digits";
	   return false;
	}
	else
	{
	   document.getElementById("err_msg4").innerHTML="";
	   return true;
	}
	
}

function validofficeTelephoneNumber()
{
	var sampleVar=document.Account_party_contact_details.officeTelephoneNumber.value;
	var alphaExp =/^[0-9]+$/;
	if (sampleVar=="" || sampleVar==" ")
	{
	   document.getElementById("err_msg4").innerHTML="Please enter telephone number";
	   return false;
	}
	else if (!sampleVar.match(alphaExp))
	{
	   document.getElementById("err_msg4").innerHTML="Telephone number should contain digits only";
	   return false;
	}
	else if ((sampleVar.length<4))
	{
	   document.getElementById("err_msg4").innerHTML="Telephone number should be of 4 to 8 digits";
	   return false;
	}
	else
	{
	   document.getElementById("err_msg4").innerHTML="";
	   return true;
	}
}


function valididprooftype()
{
 var sampleVar=document.Account_party_contact_details.idProofType.value;
 if(sampleVar=="select")
 { 
  document.getElementById("err_msg5").innerHTML="Please select Id proof type";
  return false;
 }
 else
 {
	  document.getElementById("err_msg5").innerHTML="";
	  return true;
 }
}
function valididprooffile()
{
	var sampleVar=document.Account_party_contact_details.idProofFile.value;
	var ext = sampleVar.substring(sampleVar.lastIndexOf('.') + 1);
	
	if (sampleVar=="" || sampleVar==" ")
	{
	   document.getElementById("err_msg6").innerHTML="Please select id proof file";
	   return false;
	}
	else if ( !(ext == "GIF" || ext == "gif" || ext == "PDF" || ext == "pdf"|| ext == "JPG" || ext == "jpg" || ext == "JPEG" || ext == "jpeg"))
	{
		document.getElementById("err_msg6").innerHTML = "Please check id proof file type";
		return false;
	}
	else
	{
	   document.getElementById("err_msg6").innerHTML="";
	   return true;
	}
	
}

function validaddressprooftype()
{
 var sampleVar=document.Account_party_contact_details.addressProofType.value;
 if(sampleVar=="select")
 { 
  document.getElementById("err_msg7").innerHTML="Please select address proof type";
  return false;
 }
 else
 {
	  document.getElementById("err_msg7").innerHTML="";
	  return true;
 }
}

function validaddressprooffile()
{
	var sampleVar=document.Account_party_contact_details.addressProofFile.value;
	var ext = sampleVar.substring(sampleVar.lastIndexOf('.') + 1);
	
	if (sampleVar=="" || sampleVar==" ")
	{
	   document.getElementById("err_msg8").innerHTML="Please select address proof file";
	   return false;
	}
	else if ( !(ext == "GIF" || ext == "gif" || ext == "PDF" || ext == "pdf"|| ext == "JPG" || ext == "jpg" || ext == "JPEG" || ext == "jpeg"))
	{
		document.getElementById("err_msg8").innerHTML = "Please check address proof file type";
		return false;
	}
	else
	{
	   document.getElementById("err_msg8").innerHTML="";
	   return true;
	}
	
}

function validateContactDetails()
{
	if(validEmail()==false)
	 {
		document.Account_party_contact_details.eMailAddress.focus();
		 return true;
	 }
	 else if(validmobile1()==false)
	 {
		 document.Account_party_contact_details.mobileCountryCode.focus();
		 return true;
	 }
	 else if(validmobile2()==false)
	 {
		 document.Account_party_contact_details.mobileTelephoneNumber.focus();
		 return true;
	 }
	 else if(validhomeCountryCode()==false)
	 {
		 document.Account_party_contact_details.homeCountryCode.focus();
		 return true;
	 }
	 else if(validhomeCityCode()==false)
	 {
		 document.Account_party_contact_details.homeCityCode.focus();
		 return true;
	 }else if(validhomeTelephoneNumber()==false)
	 {
		 document.Account_party_contact_details.homeTelephoneNumber.focus();
		 return true;
	 }
	 else if(validofficeCountryCode()==false)
	 {
		 document.Account_party_contact_details.officeCountryCode.focus();
		 return true;
	 }else if(validofficeCityCode()==false)
	 {
		 document.Account_party_contact_details.officeCityCode.focus();
		 return true;
	 }
	 else if(validofficeTelephoneNumber()==false)
	 {
		 document.Account_party_contact_details.officeTelephoneNumber.focus();
		 return true;
	 }
	 else if(valididprooftype()==false)
	 {
		 document.Account_party_contact_details.idProofType.focus();
		 return true;
	 }
	 else if(valididprooffile()==false)
	 {
		 document.Account_party_contact_details.idProofFile.focus();
		 return true;
	 }
	 else if(validaddressprooftype()==false)
	 {
		 document.Account_party_contact_details.addressProofType.focus();
		 return true;
	 }
	 else if(validaddressprooffile()==false)
	 {
		 document.Account_party_contact_details.addressProofFile.focus();
		 return true;
	 }
	document.Account_party_contact_details.submit();
}




