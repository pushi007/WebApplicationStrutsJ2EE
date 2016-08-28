
function businessNames()
{
var bname=document.BusinessCustomer.bName1.value;
	
	var alphaExp =/^[a-zA-Z]+$/;
	if (bname==null || bname=="")
	{
        document.getElementById("err_message").innerHTML="Please enter Business Name";
	    return false;
	}
	
	else if(!bname.match(alphaExp))
	{
		document.getElementById("err_message").innerHTML="Please enter valid Business Name";
		return false;
	}
	else{
		document.getElementById("err_message").innerHTML="";
		return true;
	}
	
}



function  businessName()
{
	document.BusinessCustomer.bName1.disabled=false;
	document.BusinessCustomer.bbrName.disabled=false;
	
    document.BusinessCustomer.tName1.disabled=true;
    document.BusinessCustomer.tbrName.disabled=true;
    document.BusinessCustomer.accno.disabled=true;
    
    
     return true;
}

function tradingName()
{
	document.BusinessCustomer.bName1.disabled=true;
	document.BusinessCustomer.bbrName.disabled=true;
    
	document.BusinessCustomer.tName1.disabled=false;
    document.BusinessCustomer.tbrName.disabled=false;
    
    
    document.BusinessCustomer.accno.disabled=true;
       return true;
}
function accountNumber()
{
	document.BusinessCustomer.bName1.disabled=true;
	document.BusinessCustomer.bbrName.disabled=true;
    document.BusinessCustomer.tName1.disabled=true;
    document.BusinessCustomer.tbrName.disabled=true;
 
    document.BusinessCustomer.accno.disabled=false;
     return true;
}


