//TODO validation for Product option
function priority_on_single()
{
	document.getElementById("err_message7").innerHTML="";
	return true;
	
}

function priority_on_groups()
{
	document.getElementById("err_message7").innerHTML="";
	return true;
	
}
function validationform()
{
	if((Product.Products[0].checked==false)&&(Product.Products[1].checked==false)) 
	{
		alert("Please select any one of the options to add product(s)");
        return false;
	}
	else
	{
		
		document.Product.submit();
		return true;
	}
}


//TODO validation for AddProduct
function validateProductId(){
	var product_id=document.Add_Product.ProductId.value;
	var alphaExpample =/^[0-9]+$/;
	
	if (product_id==null || product_id=="")
	{
		document.getElementById("err_message").innerHTML="Please enter product id";
		return false; 		
	}
	else if(isNaN(product_id)){
		document.getElementById("err_message").innerHTML="Please enter only numbers for Product ID";
		return false;
	}
	else if(product_id==0)
	{
		document.getElementById("err_message").innerHTML="Please enter valid Product ID";
		return false;
		
	}
	else if(!product_id.match(alphaExpample))
	{
		document.getElementById("err_message").innerHTML="Please enter only numbers for Product ID";
		return false;
	}
	else if(product_id.length!=4){
		document.getElementById("err_message").innerHTML="Please enter 4 digit Product ID";
		return false;
	}
	else{
		document.getElementById("err_message").innerHTML="";
		return true;
	}
	
}

function validateProductName(){
	var product_name=document.Add_Product.ProductName.value;
	var alphaExp =/^[a-zA-Z][0-9a-zA-Z\s&\,\'\.]+$/;
	

	if (product_name==null || product_name=="")
	{
        document.getElementById("err_message1").innerHTML="Please enter product name";
	    return false;
	}
	
	else if((product_name.length<5)||(product_name.length>50))
	{
		document.getElementById("err_message1").innerHTML="Product Name should have minimum 5 and maximum 40 alphabets";
		return false;
	}
	else if(!product_name.match(alphaExp))
	{
		document.getElementById("err_message1").innerHTML="Product name should contain alphabets,numbers and {,'& .} characters only and strat with alphabets";
		return false;
	}
	
	else if(product_name.charAt(0)>=0&&product_name.charAt(0)<=9)
	{
		 document.getElementById("err_message1").innerHTML="Product name should start with alphapets only";
		return false;
	}	
 
	else if(product_name.indexOf(",,")>0||product_name.indexOf("&&")>0||product_name.indexOf("''")>0||product_name.indexOf("..")>0)
	{
		 document.getElementById("err_message1").innerHTML="Consecutive special characters are not allowed";
		return false;
	}
	
	
	else{
		document.getElementById("err_message1").innerHTML="";
		return true;
	}
	
}

function validateProductDescription(){
	var desc=document.Add_Product.ProductDescription.value;
	var alphaExp=/^[a-zA-Z][0-9a-zA-Z\s&\,\'\.]+$/;
	
	if (desc==null || desc=="")
	{
        document.getElementById("err_message2").innerHTML="Please enter Product Description";
	    return false;
	}
	else if(desc.length<5)
	{
		document.getElementById("err_message2").innerHTML="Please enter atleast 5 characters";
		return false;
	}
	else if(!desc.match(alphaExp))
	{
		document.getElementById("err_message2").innerHTML="Product Description should contain alphabets,numbers and {,'& .} characters only and strat with alphabets";
		return false;
	}
	else if(desc.charAt(0)>=0&&desc.charAt(0)<=9)
	{
		 document.getElementById("err_message2").innerHTML="Product Description should start with alphapets only";
		return false;
	}	
 
	else if(desc.indexOf(",,")>0||desc.indexOf("&&")>0||desc.indexOf("''")>0||desc.indexOf("..")>0)
	{
		 document.getElementById("err_message2").innerHTML="Consecutive special characters are not allowed";
		return false;
	}
	else{
		document.getElementById("err_message2").innerHTML="";
		return true;
	}
}

function validateAccountType()
{
	var account=document.Add_Product.AccoutnType.value;
	
	if(account=="select")
	{
		document.getElementById("err_message3").innerHTML="Please select Account Type";
	    return false;
	}
	else{
		document.getElementById("err_message3").innerHTML="";
		return true;
	}
}

function validateProductStatus()
{
	var status=document.Add_Product.ProductStatus.value;
	
	if(status=="select")
	{
		document.getElementById("err_message4").innerHTML="Please select Product Status";
	    return false;
	}
	else{
		document.getElementById("err_message4").innerHTML="";
		return true;
	}
}

function validateBusinessType()
{
	var businessType=document.Add_Product.BusinessType.value;
	if(businessType=="select")
	{
		document.getElementById("err_message6").innerHTML="Please select BusinessType";
	    return false;
	}
	else{
		document.getElementById("err_message6").innerHTML="";
		return true;
	}
}

function validateDate(){
	var date=document.Add_Product.ValidFrom.value;
	date= new Date(date);	
	
	var sdd=date.getDate();
	var smm=date.getMonth();
	var syy=date.getFullYear();
	
	var current_date= new Date();
	var cdd=current_date.getDate();
	var cmm=current_date.getMonth();
	var cyy=current_date.getFullYear();
	
	if(date=="NaN")
	 {
		document.getElementById("err_message5").innerHTML="Please select Date";
		return false;
	 }
	 else if(document.Add_Product.ValidFrom.value!="")
		{
		 var datediff = (cmm == smm && syy==cyy && sdd < cdd) ? 
					0 : (smm < cmm || syy < cyy) ? 0 : 1;
		 if(datediff==0){
		 document.getElementById("err_message5").innerHTML="Please enter current or future date";
			return false;
		 }
		 else
		 {
			 document.getElementById("err_message5").innerHTML="";
			 return true;
		 }
}
	else
	{
		document.getElementById("err_message5").innerHTML="";
		return true;
	}

}
function  validateform()
{
	if(validateProductId()==false)
	{
		document.Add_Product.ProductId.focus();
		return false;
	}
	else if(validateProductName()==false)
	{
		document.Add_Product.ProductName.focus();
	    return false;
	}
	else if(validateProductDescription()==false)
	{
		document.Add_Product.ProductDescription.focus();
		return false;
	}
	else if(validateAccountType()==false)
	{
		document.Add_Product.AccoutnType.focus();
		return false;
	}
	else if(validateProductStatus()==false)
	{
		document.Add_Product.ProductStatus.focus();
		return false;
	}
	else if(validateDate()==false)
	{
		document.Add_Product.ValidFrom.focus();
		return false;
	}
	
	else if(validateBusinessType()==false)
	{
		document.Add_Product.BusinessType.focus();
		return false;
	}
	
	else
	{
		document.Add_Product.submit();
		return true;
	}
}

function resetValidateProduct()
{
	document.getElementById("err_message").innerHTML="";
	document.getElementById("err_message1").innerHTML="";
	document.getElementById("err_message2").innerHTML="";
	document.getElementById("err_message3").innerHTML="";
	document.getElementById("err_message4").innerHTML="";
	document.getElementById("err_message5").innerHTML="";
	document.getElementById("err_message6").innerHTML="";
	document.Add_Product.reset();
	return true;
	
	
}

//TODO Validation of Additional Product for Add Product
function validationofAdditionalProduct()
{
	var chk=document.getElementsByName("AdditionalProduct");
	var flag=0;
	for(var i=0;i<chk.length;i++){
		if(chk[i].checked==true){
			flag=1;
			break;
		}
	}
	
	if(flag==0){
		document.getElementById("err_message7").innerHTML="Please select atleast one additional product";
		return false;
	}
	else
	{
		document.getElementById("err_message7").innerHTML="";
		return true;
	}
}
function validationofAdditional()
{
	var chk=document.getElementsByName("AProduct");
	var flag=0;
	for(var i=0;i<chk.length;i++){
		if(chk[i].checked==true){
			flag=1;
			break;
		}
	}
	if(flag==0){
		document.getElementById("err_message7").innerHTML="Please select atleast one additional product";
		return false;
	}
	else
	{
		document.getElementById("err_message7").innerHTML="";
		return true;
	}
}
function validateformation()
{
	if(validateProductName()==false)
	{
		document.Add_Product.ProductName.focus();
	    return false;
	}
	else if(validateProductDescription()==false)
	{
		document.Add_Product.ProductDescription.focus();
		return false;
	}
	else if(validateAccountType()==false)
	{
		document.Add_Product.AccoutnType.focus();
		return false;
	}
	else if(validateProductStatus()==false)
	{
		document.Add_Product.ProductStatus.focus();
		return false;
	}
	else if(validateDate()==false)
	{
		document.Add_Product.ValidFrom.focus();
		return false;
	}
	
	else if(validateBusinessType()==false)
	{
		document.Add_Product.BusinessType.focus();
		return false;
	}
	else if(validationofAdditionalProduct()==false)
	{
		document.Add_Product.AdditionalProduct.focus();
		return false;
	}
	else
	{
		document.Add_Product.submit();
		return true;
	}
}
function validateformation1()
{
	if(validateProductName()==false)
	{
		document.Add_Product.ProductName.focus();
	    return false;
	}
	else if(validateProductDescription()==false)
	{
		document.Add_Product.ProductDescription.focus();
		return false;
	}
	else if(validateAccountType()==false)
	{
		document.Add_Product.AccoutnType.focus();
		return false;
	}
	else if(validateProductStatus()==false)
	{
		document.Add_Product.ProductStatus.focus();
		return false;
	}
	else if(validateDate()==false)
	{
		document.Add_Product.ValidFrom.focus();
		return false;
	}
	
	else if(validateBusinessType()==false)
	{
		document.Add_Product.BusinessType.focus();
		return false;
	}
	else if(validationofAdditional()==false)
	{
		document.Add_Product.AProduct.focus();
		return false;
	}
	
	else
	{
		document.Add_Product.submit();
		return true;
	}
}

//TODO Additional Product Validation 
function validateAPId(){
	
	var ap_id=document.Additional_Product.AdditionalProductId.value;
	var alphaExpample =/^[0-9]+$/;
	
	if(isNaN(ap_id))
	{
		document.getElementById("err_message9").innerHTML="Please enter only numbers for Additional Product ID";
		return false;
	}
	else if(ap_id.length!=3)
	{
		document.getElementById("err_message9").innerHTML="Please enter 3 digit Additional Product ID";
		return false;
	}
	else if(ap_id==0)
	{
		document.getElementById("err_message9").innerHTML="Please enter valid Additional Product ID";
		return false;
		
	}
	else if(!ap_id.match(alphaExpample))
	{
		document.getElementById("err_message9").innerHTML="Please enter only numbers for Additional Product ID";
		return false;
	}
	else
	{
		document.getElementById("err_message9").innerHTML="";
		return true;
	}
	
}
function validateAPName(){
	
	var apName=document.Additional_Product.AdditionalProductName.value;
	var alphaExp =/^[a-zA-Z][a-zA-Z\s&]+$/;
	
	if (apName==null || apName=="")
	{
        document.getElementById("err_message10").innerHTML="Please enter Additional product name";
	    return false;
	}
	else if(!apName.match(alphaExp))
	{
		document.getElementById("err_message10").innerHTML="Please enter only alphabets for Additional Product Name";
		return false;
	}
	else if((apName.length<3)||(apName.length>20))
	{
		document.getElementById("err_message10").innerHTML="Additional Product Name should have minimum 3 and maximum 20 alphabets";
		return false;
	}
	else if(apName.charAt(0)>=0&&apName.charAt(0)<=9)
	{
		 document.getElementById("err_message10").innerHTML="Additional Product name should start with alphapets only";
		return false;
	}
	else
	{
		document.getElementById("err_message10").innerHTML="";
		return true;
	}
}

function Additional_validation()
{
    if(validateAPId()==false)
	{
		document.Additional_Product.AdditionalProductId.focus();
		return false;
	}
	else if(validateAPName()==false)
	{
		document.Additional_Product.AdditionalProductName.focus();
		return false;
	}
	else
	{
		document.Additional_Product.submit();
		return true;
	}
	
}

function resetValidateAdditionalProduct() 
{
	document.getElementById("err_message9").innerHTML="";
	document.getElementById("err_message10").innerHTML="";
	document.Additional_Product.reset();
	return true;
	
}

//Validation of Update Additional Product
function validateAPValue()
{
	var apName=document.Additionl_Product.apvalue.value;
	var alphaExp =/^[a-zA-Z][a-zA-Z\s&]+$/;
	
	
	if (apName==null || apName=="")
	{
        document.getElementById("err_message11").innerHTML="Please enter Additional product name";
	    return false;
	}
	else if (apName==null || apName=="")
	{
        document.getElementById("err_message11").innerHTML="Please enter Additional Product Name";
	    return false;
	}
	else if(!apName.match(alphaExp))
	{
		document.getElementById("err_message11").innerHTML="Please enter only alphabets for Additional Product Name";
		return false;
	}
	else if((apName.length<3)||(apName.length>20))
	{
		document.getElementById("err_message11").innerHTML="Additional Product Name should have minimum 3 and maximum 20 alphabets";
		return false;
	}
	else
	{
		document.getElementById("err_message11").innerHTML="";
		return true;
	}
	
}

function AdditionalUpdatevalidation()
{
	if(validateAPValue()==false)
	{
		document.Additionl_Product.apvalue.focus();
		return false;
	}
	else
	{
		document.Additionl_Product.submit();
		return true;
	}
	
	
}

function deleteValidationReason()
{
	var product_delete=document.Additional_Product.delreason.value;
	var alphaExp =/^[a-zA-Z][0-9a-zA-Z\s&\,\']+$/;
	if (product_delete==null || product_delete=="")
	{
        document.getElementById("err_message13").innerHTML="Please provide a summary";
	    return false;
	}
	
	else if((product_delete.length<5)||(product_delete.length>50))
	{
		document.getElementById("err_message13").innerHTML="Product deletion reason should have minimum 5 alphabets";
		return false;
	}
	else if(!product_delete.match(alphaExp))
	{
		document.getElementById("err_message13").innerHTML="Please enter valid product deletion reason";
		return false;
	}
	else{
		document.getElementById("err_message13").innerHTML="";
		return true;
	}
	
	
}

function deletevalidation()
{

	if(deleteValidationReason()==false)
	{
		document.Additional_Product.apvalue.focus();
		return false;
	}
	else
	{
		document.Additional_Product.submit();
		return true;
	}
	
	
	
}
