

function reg()
{
	if(document.getElementById("yes").checked==true)
	{
		
		document.regadditional_form.fundAmount.disabled=false;
	}
	else{
		document.regadditional_form.fundAmount.value="";
		document.regadditional_form.fundAmount.disabled=true;
	
	}


}



function setCurrentDate()
{
var today=new Date();
var dd = today.getDate(); 
var mm = today.getMonth()+1;//January is 0! 
var yyyy = today.getFullYear(); 
if(dd<10){dd='0'+dd;} 
if(mm<10){mm='0'+mm;} 
today="";
today=yyyy+"/"+mm+"/"+dd;
document.reg_form.dor.value=today;
}

function setBankId(i){
     alert("hello");
	document.reg_form.bbid.value=i;
}
//function validateform()
//{
//
//var namePattern = /^[A-Za-z][A-Za-z\s]{3,25}$/;
//{ 
//if( !namePattern.test(document.reg_form.bname.value))
//{ 
//alert("Enter Business Name");
// document.reg_form.bname.focus();
//return false;
// }
//}
//
//var namePattern = /^[A-Za-z][A-Za-z\s]{3,25}$/;
//{ 
//if( !namePattern.test(document.reg_form.trdname.value))
//{ 
//alert("Enter Trading Name");
// document.reg_form.trdname.focus();
//return false;
// }
//}
//
////STARTUP BUSINESS
//if(document.reg_form.startup[1].checked==false && document.reg_form.startup[0].checked==false )
//{
//  alert("Please Select Startup Business");
//  return false;
//}
//
//
////DATE ESTABLISHED
//if(document.reg_form.startup[0].checked==false && document.reg_form.startup[1].checked==true)
//{
//var l=document.getElementById("edate").value;
//var m=document.getElementById("emonth").value;
//var n=document.getElementById("eyear").value;
//   if(l==0 || m==0 || n==0)
//   {
//    alert("Please Enter Valid Establishment Date");
//     return false;
//   }
//}
//
////REGISTRATION DATE
//if(document.reg_form.startup[1].checked==false && document.reg_form.startup[0].checked==true)
//{
//var i=document.getElementById("rdate").value;
//var j=document.getElementById("rmonth").value;
//var k=document.getElementById("ryear").value;
//  if(i==0 || j==0 || k==0)
//  {
//  alert("Please Enter Valid Registration Date");
//  return false;
//  }
//}
//
//var m= document.reg_form.creg.value;
//  if(m==0)
//{
//    alert("Please Select Country Of Registration");
//    document.reg_form.creg.focus();
//    return  false;
//  }
//
//
//var n= document.reg_form.et.value;
//  if(n==0)
//{
//    alert("Please Select Expected Annual Turnover");
//    document.reg_form.et.focus();
//    return  false;
//  }
//
//
//if(document.reg_form.bs[0].checked==false && document.reg_form.bs[1].checked==false)
//      {
//        alert("Please Select Business Status");
//        document.reg_form.bs[0].focus();
//        return  false;
//      }
// if(document.reg_form.BDet.value=="")
//  {
//    alert("Please Tell More About Business");
//    document.reg_form.BDet.focus();
//    return  false;
//  }
//
//
//
//if(document.reg_form.fund[0].checked==false && document.reg_form.fund[1].checked==false)
//      {
//        alert("Does Your Business Require Funding ?");
//        document.reg_form.fund[0].focus();
//        return  false;
//      }
//
//
//var x = document.reg_form.Contactid.value;
//       
//      if (x==null || x=="")
// 	 {
// 		 alert("Please Enter Contact No");
//		document.reg_form.Contactid.focus();
// 		 return false;
// 	 }       
//
//       	 if(isNaN(x)|| x.indexOf(" ")!=-1)
//	{
//              			alert("Enter Numeric Value");
//			return false;
//                }
//       			 if (x.length > 10)
//			{
//                			alert("Enter 10 Characters"); 
//			document.reg_form.Contactid.focus();
//				return false;
//          			} 
//			 if (x.length < 10)
//			{
//                			alert("Enter 10 Characters"); 
//				document.reg_form.Contactid.focus();
//				return false;
//          			} 
//
//
//var y = document.reg_form.Faxid.value;
//       
//      if (y==null || y=="")
// 	 {
// 		 alert("Please Enter Fax No");
//	document.reg_form.Faxid.focus();
// 		 return false;
// 	 }       
//
//       	 if(isNaN(y)|| y.indexOf(" ")!=-1)
//	{
//              			alert("Enter numeric Value");
//			document.reg_form.Faxid.focus();
//			return false;
//                }
//       			 if (y.length > 10)
//			{
//                			alert("Enter 10 Characters");
//			document.reg_form.Faxid.focus(); 
//				return false;
//          			} 
//			 if (y.length < 10)
//			{
//                			alert("Enter 10 Characters"); 
//			document.reg_form.Faxid.focus();
//				return false;
//          			} 
//if(document.reg_form.RegBus.value=="")
//  {
//    alert("Please Mention Registered Business Address");
//    document.reg_form.RegBus.focus();
//    return  false;
//  }
//
//var email = document.getElementById('emailid');
//var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
//if (!filter.test(email.value)) 
//{
//alert('Please Enter A Valid Email Address');
//email.focus;
//return false;
//}
//
//var fup = document.getElementById("filename");
//var fileName = fup.value;
//var ext = fileName.substring(fileName.lastIndexOf('.') + 1);
//
//if(ext =="ZIP" || ext=="zip")
//          {
//               return true;
//          }
//         else 
//          {
//              alert("Please upload ZIP file");
//              return false;
//         }
//document.reg_form.submit();
//return true;
//
//
//}


//----------------------validation with inline messages-------------------------

//---------------------------------------validation for Search Customer branch------------------------------
//Validation for Account Number
function validateSearchAccountNo(){
	var a=document.reg_form.accountNo.value;
	var filter=/^[1-9][0-9]{15}$/;
	if (!filter.test(a))
	{
		document.getElementById("error_accountNo").innerHTML = "Please enter numbers only.";
		document.reg_form.businessName.focus();
		document.reg_form.businessName.value = "";
	
	}
	else if((a.length)!=15)
	{
		document.getElementById("error_accountNo").innerHTML = "Account Number should be 15 digits long.";
		document.reg_form.businessName.focus();
		document.reg_form.businessName.value = "";
	}
	}


//Validation of Business name
function validateSearchBusinessName() {
	var namePattern = /^[A-Za-z][A-Za-z\s]{3,25}$/;
	if (!namePattern.test(document.reg_form.businessName.value)) {
		document.getElementById("error_businessName").innerHTML = "Please enter alphabets only;";
		document.reg_form.businessName.focus();
		document.reg_form.businessName.value = "";
	} else if (document.reg_form.businessName.value.length > 10) {
		document.getElementById("error_businessName").innerHTML = "Business name could not have more than 30 characters.";
		document.reg_form.businessName.focus();
		document.reg_form.businessName.value = "";
	} else {
		document.getElementById("error_businessName").innerHTML= "";
	}
}

function validateSearchTradingName() {
	var namePattern = /^[A-Za-z][A-Za-z\s]{3,25}$/;
	if (!namePattern.test(document.reg_form.tradeName.value)) {
		document.getElementById("error_tradeName").innerHTML = "Please enter alphabets only;";
		document.reg_form.tradeName.focus();
		document.reg_form.tradeName.value = "";
	} else if (document.reg_form.tradeName.value.length > 30) {
		document.getElementById("error_tradeName").innerHTML = "Business name could not have more than 30 characters.";
		document.reg_form.tradeName.focus();
		document.reg_form.tradeName.value = "";
	} else {
		document.getElementById("error_tradeName").innerHTML= "";
	}
}





//-------------------------REG_FORM_PAGE1---Core Details-------------------

//1 Validate Business name
function validateBusinessName() {
	var namePattern = /^[A-Za-z][A-Za-z\s]$/;
	if (!namePattern.test(document.reg_form.bname.value)) {
		document.getElementById("error_bname").innerHTML = "Please enter alphabets only;";
		document.reg_form.bname.focus();
		document.reg_form.bname.value = "";

	} else if (document.reg_form.bname.value.length >30) {

	} else if (document.reg_form.bname.value.length > 10) {

		document.getElementById("error_bname").innerHTML = "Business name could not have more than 30 characters.";
		document.reg_form.bname.focus();
		document.reg_form.bname.value = "";
	} else {
		document.getElementById("error_bname").innerHTML= "";
	}
}

//2 Validate Trading name
function validateTradingName() {
	var namePattern = /^[A-Za-z][A-Za-z\s]$/;
	if (!namePattern.test(document.reg_form.trdname.value)) {
		document.getElementById("error_trdname").innerHTML = "Please enter alphabets only.";
		document.reg_form.trdname.focus();
		document.reg_form.trdname.value = "";
	} else if (document.reg_form.trdname_trdname.value.length > 30) {
		document.getElementById("error_trdname").innerHTML = "Trading name could not have more than 30 characters.";
		document.reg_form.trdname.focus();
		document.reg_form.trdname.value = "";
	} else {
		document.getElementById("error_trdname").innerHTML= "";
	}
}






//14 Validate No of employees
function validateNoOfEmployees (){
	var filter=/^[1-9][0-9]$/;
	if (!filter.test(a))
	{
		document.getElementById("error_noemp").innerHTML = "Please enter numbers only.";
		document.reg_form.noemp.focus();
		document.reg_form.noemp.value = "";
	
	}

	var n= document.reg_form.noemp.value;
	if(n==0)
	{
		document.getElementById("error_noemp").innerHTML = "Please check the entry in number of employees field.";
		document.reg_form.noemp.focus();
		document.getElementById("error_noemp").innerHTML= "";
	}
}


/////////////////////////////////////////REG_FORM_PAGE2A additional Details/////////////////////

//Validate main activity
function validateMainActivity() {
	var namePattern = /^[A-Za-z][A-Za-z\s]{3,25}$/;
	if (!namePattern.test(document.reg_form.mainActivity.value))
	 {
		document.getElementById("error_mainActivity").innerHTML = "Please enter alphabets only.";
		document.reg_form.mainActivity.focus();
		document.reg_form.mainActivity.value = "";
	} else if (document.reg_form.mainActivity.value.length > 20) {
		document.getElementById("error_mainActivity").innerHTML = "Main activity could not have more than 20 characters.";
		document.reg_form.mainActivity.focus();
		document.reg_form.mainActivity.value = "";
	} else {
		document.getElementById("error_mainActivity").innerHTML= "";
	}
}

//Validate precise activity
function validatePreciseActivity() {
	var namePattern = /^[A-Za-z][A-Za-z\s]{3,25}$/;
	if (!namePattern.test(document.reg_form.preciseActivity.value)) {
		document.getElementById("error_preciseActivity").innerHTML = "Please enter alphabets only.";
		document.reg_form.preciseActivity.focus();
		document.reg_form.preciseActivity.value = "";
	} else if (document.reg_form.preciseActivity.value.length > 20) {
		document.getElementById("error_preciseActivity").innerHTML = "Main activity could not have more than 20 characters.";
		document.reg_form.preciseActivity.focus();
		document.reg_form.preciseActivity.value = "";
	} else {
		document.getElementById("error_preciseActivity").innerHTML= "";
	}
}



//Validate fund amount
function validateFundAmount()
{
	
}







////////////////////////////////////REG_FORM_PAGE3 Permanent Address/////////////////////
//Validate Building Number
function validateBuildingNoPermanent()
{
	var filter=/^[1-9][0-9]$/;
	if (!filter.test(a))
	{
		document.getElementById("error_bnoper").innerHTML = "Please enter numbers only.";
		document.reg_form.bnoper.focus();
		document.reg_form.bnoper.value = "";
	
	}

	var n= document.reg_form.bnoper.value;
	if(n==0)
	{
		document.getElementById("error_bnoper").innerHTML = "Please check the entry in number of employees field.";
		document.reg_form.bnoper.focus();
		document.getElementById("error_bnoper").innerHTML= "";
	}


}

//Validate Building Name
function validateBuildingNamePermanent() {
	var namePattern = /^[A-Za-z][A-Za-z\s]{3,25}$/;
	if (!namePattern.test(document.reg_form.bnameper.value)){
		document.getElementById("error_bnameper").innerHTML = "Please enter alphabets only.";
		document.reg_form.bnameper.focus();
		document.reg_form.bnameper.value = "";
	} else if (document.reg_form.bnameper.value.length > 20) {
		document.getElementById("error_bnameper").innerHTML = "Building Name could not have more than 20 characters.";
		document.reg_form.bnameper.focus();
		document.reg_form.bnameper.value = "";
	} else {
		document.getElementById("error_bnameper").innerHTML= "";
	}
}

//Validate Street name
function validateStreetNamePermanent() {
	var namePattern = /^[A-Za-z][A-Za-z\s]{3,25}$/;
	if (!namePattern.test(document.reg_form.snameper.value)) {
		document.getElementById("error_snameper").innerHTML = "Please enter alphabets only.";
		document.reg_form.snameper.focus();
		document.reg_form.snameper.value = "";
	} else if (document.reg_form.snameper.value.length > 20) {
		document.getElementById("error_snameper").innerHTML = "Street Name could not have more than 20 characters.";
		document.reg_form.snameper.focus();
		document.reg_form.snameper.value = "";
	} else {
		document.getElementById("error_snameper").innerHTML= "";
	}
}

//Validate Town
function validateTownPermanent() {
	var namePattern = /^[A-Za-z][A-Za-z\s]{3,25}$/;
	if (!namePattern.test(document.reg_form.townper.value)) {
		document.getElementById("error_townper").innerHTML = "Please enter alphabets only.";
		document.reg_form.townper.focus();
		document.reg_form.townper.value = "";
	} else if (document.reg_form.townper.value.length > 20) {
		document.getElementById("error_townper").innerHTML = "Town Name could not have more than 20 characters.";
		document.reg_form.townper.focus();
		document.reg_form.townper.value = "";
	} else {
		document.getElementById("error_townper").innerHTML= "";
	}
}




//Validate City
function validateCityPermanent() {
	var namePattern = /^[A-Za-z][A-Za-z\s]{3,25}$/;
	if (!namePattern.test(document.reg_form.cityper.value)){
		document.getElementById("error_cityper").innerHTML = "Please enter alphabets only.";
		document.reg_form.cityper.focus();
		document.reg_form.cityper.value = "";
	} else if (document.reg_form.cityper.value.length > 20) {
		document.getElementById("error_cityper").innerHTML = "City Name could not have more than 20 characters.";
		document.reg_form.cityper.focus();
		document.reg_form.cityper.value = "";
	} else {
		document.getElementById("error_cityper").innerHTML= "";
	}
}


//Validate Country
function validateCountryPermanent() {
	var namePattern = /^[A-Za-z][A-Za-z\s]{3,25}$/;
	if (!namePattern.test(document.reg_form.countryper.value)){
		document.getElementById("error_countryper").innerHTML = "Please enter alphabets only.";
		document.reg_form.countryper.focus();
		document.reg_form.countryper.value = "";
	} else if (document.reg_form.countryper.value.length > 20) {
		document.getElementById("error_countryper").innerHTML = "Country Name could not have more than 20 characters.";
		document.reg_form.countryper.focus();
		document.reg_form.countryper.value = "";
	} else {
		document.getElementById("error_countryper").innerHTML= "";
	}
}

//Validate PostalCode
function validatePostalCodePermanent()
{
	
}




////////////////////////////////////REG_FORM_PAGE4 Present Address/////////////////////////
//Validate Building Number
function validateBuildingNoPresent()
{
	var filter=/^[1-9][0-9]$/;
	if (!filter.test(a))
	{
		document.getElementById("error_noemp").innerHTML = "Please enter numbers only.";
		document.reg_form.noemp.focus();
		document.reg_form.noemp.value = "";
	
	}

	var n= document.reg_form.noemp.value;
	if(n==0)
	{
		document.getElementById("error_noemp").innerHTML = "Please check the entry in number of employees field.";
		document.reg_form.noemp.focus();
		document.getElementById("error_noemp").innerHTML= "";
	}	
}

//Validate Building Name
function validateBuildingNamePresent() {
	var namePattern = /^[A-Za-z][A-Za-z\s]{3,25}$/;
	if (!namePattern.test(document.reg_form.bnamepre.value)) {
		document.getElementById("error_bnamepre").innerHTML = "Please enter alphabets only.";
		document.reg_form.bnamepre.focus();
		document.reg_form.bnamepre.value = "";
	} else if (document.reg_form.bnamepre.value.length > 20) {
		document.getElementById("error_bnamepre").innerHTML = "Building Name could not have more than 20 characters.";
		document.reg_form.bnamepre.focus();
		document.reg_form.bnamepre.value = "";
	} else {
		document.getElementById("error_bnamepre").innerHTML= "";
	}
}

//Validate Street name
function validateStreetNamePresent() {
	var namePattern = /^[A-Za-z][A-Za-z\s]{3,25}$/;
	if (!namePattern.test(document.reg_form.snamepre.value)) {
		document.getElementById("error_snamepre").innerHTML = "Please enter alphabets only.";
		document.reg_form.snamepre.focus();
		document.reg_form.snamepre.value = "";
	} else if (document.reg_form.snamepre.value.length > 20) {
		document.getElementById("error_snamepre").innerHTML = "Street Name  could not have more than 20 characters.";
		document.reg_form.snamepre.focus();
		document.reg_form.snamepre.value = "";
	} else {
		document.getElementById("error_snamepre").innerHTML= "";
	}
}

//Validate Town
function validateTownPresent() {
	var namePattern = /^[A-Za-z][A-Za-z\s]{3,25}$/;
	if (!namePattern.test(document.reg_form.townpre.value)) {
		document.getElementById("error_townpre").innerHTML = "Please enter alphabets only.";
		document.reg_form.townpre.focus();
		document.reg_form.townpre.value = "";
	} else if (document.reg_form.townpre.value.length > 20) {
		document.getElementById("error_townpre").innerHTML = "Town Name could not have more than 20 characters.";
		document.reg_form.townpre.focus();
		document.reg_form.townpre.value = "";
	} else {
		document.getElementById("error_townpre").innerHTML= "";
	}
}




//Validate City
function validateCityPresent() {
	var namePattern = /^[A-Za-z][A-Za-z\s]{3,25}$/;
	if (!namePattern.test(document.reg_form.citypre.value)) {
		document.getElementById("error_citypre").innerHTML = "Please enter alphabets only.";
		document.reg_form.citypre.focus();
		document.reg_form.citypre.value = "";
	} else if (document.reg_form.citypre.value.length > 20) {
		document.getElementById("error_citypre").innerHTML = "City Name  could not have more than 20 characters.";
		document.reg_form.citypre.focus();
		document.reg_form.citypre.value = "";
	} else {
		document.getElementById("error_citypre").innerHTML= "";
	}
}


//Validate Country
function validateCountryPresent() {
	var namePattern = /^[A-Za-z][A-Za-z\s]{3,25}$/;
	if (!namePattern.test(document.reg_form.countrypre.value)) {
		document.getElementById("error_countrypre").innerHTML = "Please enter alphabets only.";
		document.reg_form.countrypre.focus();
		document.reg_form.countrypre.value = "";
	} else if (document.reg_form.countrypre.value.length > 20) {
		document.getElementById("error_countrypre").innerHTML = "Country Name could not have more than 20 characters.";
		document.reg_form.countrypre.focus();
		document.reg_form.countrypre.value = "";
	} else {
		document.getElementById("error_countrypre").innerHTML= "";
	}
}



//Validate PostalCode
function validatePostalCodePresent()
{
	

}

////////////////////////////////////REG_FORM_PAGE5 Correspondence Address/////////////////
//Validate Building Number
function validateBuildingNoCorrespondence()
{
	var filter=/^[1-9][0-9]$/;
	if (!filter.test(a))
	{
		document.getElementById("error_noemp").innerHTML = "Please enter numbers only.";
		document.reg_form.noemp.focus();
		document.reg_form.noemp.value = "";
	
	}

	var n= document.reg_form.noemp.value;
	if(n==0)
	{
		document.getElementById("error_noemp").innerHTML = "Please check the entry in number of employees field.";
		document.reg_form.noemp.focus();
		document.getElementById("error_noemp").innerHTML= "";
	}
	
}

//Validate Building Name
function validateBuildingNameCorrespondence() {
	var namePattern = /^[A-Za-z][A-Za-z\s]{3,25}$/;
	if (!namePattern.test(document.reg_form.bnamecor.value)) {
		document.getElementById("error_bnamecor").innerHTML = "Please enter alphabets only.";
		document.reg_form.bnamecor.focus();
		document.reg_form.bnamecor.value = "";
	} else if (document.reg_form.bnamecor.value.length > 20) {
		document.getElementById("error_bnamecor").innerHTML = "Building Name could not have more than 20 characters.";
		document.reg_form.bnamecor.focus();
		document.reg_form.bnamecor.value = "";
	} else {
		document.getElementById("error_bnamecor").innerHTML= "";
	}
}

//Validate Street name
function validateStreetNameCorrespondence() {
	var namePattern = /^[A-Za-z][A-Za-z\s]{3,25}$/;
	if (!namePattern.test(document.reg_form.snamecor.value)) {
		document.getElementById("error_snamecor").innerHTML = "Please enter alphabets only.";
		document.reg_form.snamecor.focus();
		document.reg_form.snamecor.value = "";
	} else if (document.reg_form.snamecor.value.length > 20) {
		document.getElementById("error_snamecor").innerHTML = "Street Name  could not have more than 20 characters.";
		document.reg_form.snamecor.focus();
		document.reg_form.snamecor.value = "";
	} else {
		document.getElementById("error_snamecor").innerHTML= "";
	}
}

//Validate Town
function validateTownCorrespondence() {
	var namePattern = /^[A-Za-z][A-Za-z\s]{3,25}$/;
	if (!namePattern.test(document.reg_form.towncor.value)) {
		document.getElementById("error_towncor").innerHTML = "Please enter alphabets only.";
		document.reg_form.towncor.focus();
		document.reg_form.towncor.value = "";
	} else if (document.reg_form.towncor.value.length > 20) {
		document.getElementById("error_towncor").innerHTML = "Town Name could not have more than 20 characters.";
		document.reg_form.towncor.focus();
		document.reg_form.towncor.value = "";
	} else {
		document.getElementById("error_towncor").value.innerHTML= "";
	}
}




//Validate City
function validateCityCorrespondence() {
	var namePattern = /^[A-Za-z][A-Za-z\s]{3,25}$/;
	if (!namePattern.test(document.reg_form.citycor.value)){
		document.getElementById("error_citycor").innerHTML = "Please enter alphabets only.";
		document.reg_form.citycor.focus();
		document.reg_form.citycor.value = "";
	} else if (document.reg_form.citycor.value.length > 20) {
		document.getElementById("error_citycor").innerHTML = "City Name  could not have more than 20 characters.";
		document.reg_form.citycor.focus();
		document.reg_form.citycor.value = "";
	} else {
		document.getElementById("error_citycor").innerHTML= "";
	}
}


//Validate Country
function validateCountryCorrespondence() {
	var namePattern = /^[A-Za-z][A-Za-z\s]{3,25}$/;
	if (!namePattern.test(document.reg_form.countrycor.value)){
		document.getElementById("error_countrycor").innerHTML = "Please enter alphabets only.";
		document.reg_form.countrycor.focus();
		document.reg_form.countrycor.value = "";
	} else if (document.reg_form.countrycor.value.length > 20) {
		document.getElementById("error_countrycor").innerHTML = "Country Namecould not have more than 20 characters.";
		document.reg_form.countrycor.focus();
		document.reg_form.countrycor.value = "";
	} else {
		document.getElementById("error_countrycor").innerHTML= "";
	}
}



//Validate PostalCode
function validatePostalCodeCorrespondence()
{
	
}






////////////////////////////////////REG_FORM_PAGE5 Contact details and proofs/////////////////
//Validate  Country Code of Contact No
function validateContactNoCountryCode() 
{
	//name="concountrycode"
}

//Validate  Area Code of Contact No
function validateContactNoAreaCode() 
{
	//name="conareacode"
}

//Validate  Contact No
function validateContactNo() 
{
	
	//name="conno"
}

//Validate  Country Code of FAX No
function validateFAXNoCountryCode() 
{
	//name="concountrycode"
}

//Validate  Area Code of FAX No
function validateFAXNoAreaCode() 
{
	//name="faxareacode"
}

//Validate FAX No
function validateFAXNo() 
{
	
	//name="faxno"
}

//Validate Business Email Address
function validateBusinessEmail() 
{
	var x = document.reg_form.bemail.value;
	var atpos = x.indexOf("@");
	var dotpos = x.lastIndexOf(".");
	if (!isempty(document.Emp_Register.email.value)&& (atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= x.length)) {
		document.error_bemail.innerHTML = "Please check Business Email ID.";
		document.Emp_Register.bemail.focus();
		document.Emp_Register.bemail.value ="";
	}	
	else{
			document.error_bemail.innerHTML= "";
	}
	
	
}


















