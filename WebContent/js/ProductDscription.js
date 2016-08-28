function selectOperationUpdate()
{
	var chk=document.getElementsByName("ProductIdList");
	var flag=0;
	for(var i=0;i<chk.length;i++){
		if(chk[i].checked==true){
			flag=1;
			break;
		}
	}

	if(flag==1)
	{
	document.ViewProductList.selectedProduct.value="updateSelected";
	document.ViewProductList.submit();
	return true;
	}
	else if(flag==0)
	{
		alert("Please select atleast one product");
		
	}
	
}

function selectOperationDelete()
{
	var chk=document.getElementsByName("ProductIdList");
	var flag=0;
	for(var i=0;i<chk.length;i++){
		if(chk[i].checked==true){
			flag=1;
			break;
		}
	}

	if(flag==1)
	{
		if(confirm("Do you want to delete Product?")){
		document.ViewProductList.selectedProduct.value="deleteSelected";
		document.ViewProductList.submit();
		return true;
		}
		else
		{
		return false;
		}
	}
	else if(flag==0)
	{
		alert("Please select atleast one product");
		
	}
	
	
}



function selectSingleUpdate()
{
	document.singleProduct.selectedSingleProduct.value="updateSingleSelected";
	document.singleProduct.submit();
	return true;
}

function selectSingleDelete()
{
	if(confirm("Do you want to delete Product?")){
	document.singleProduct.selectedSingleProduct.value="deleteSingleSelected";
	document.singleProduct.submit();
	return true;
	}
	else
	{
	return false;
	}
}

function cancelUpdateValidation()
{
	if(confirm("Data you have entered will be lost. Are you sure you want to cancel? ")==true )
	{
		window.location.href="/NBG/ProductManagementServlet?action=ViewProduct";
		return true;
	}
	else
	{
		return false;
	}
}

function cancelEditValidation()
{
	if(confirm("Data you have entered will be lost. Are you sure you want to cancel? ")==true )
	{
		window.location.href="/NBG/ProductManagementServlet?action=home";
		return true;
	}
	else
	{
		return false;
	}
}

function addProductValidation()
{
	if(confirm("Data you have entered will be lost. Are you sure you want to exit? ")==true )
	{
		window.location.href="/NBG/ProductManagementServlet?action=addProduct";
		return true;
	}
	else
	{
		return false;
	}
	
	
}

function viewProductValidation()
{
	if(confirm("Data you have entered will be lost. Are you sure you want to exit? ")==true )
	{
		window.location.href="/NBG/ProductManagementServlet?action=ViewProduct";
		return true;
	}
	else
	{
		return false;
	}
	
}

function productReportValidation()
{

	if(confirm("Data you have entered will be lost. Are you sure you want to exit? ")==true )
	{
		window.location.href="/NBG/ProductManagementServlet?action=viewp";
		return true;
	}
	else
	{
		return false;
	}
	
	
}

function addAdditionalProductValidation()
{
	if(confirm("Data you have entered will be lost. Are you sure you want to exit? ")==true )
	{
		window.location.href="/NBG/ProductManagementServlet?action=additionalProduct";
		return true;
	}
	else
	{
		return false;
	}
	
}
		
function udAdditionalProductValidation()
{
	if(confirm("Data you have entered will be lost. Are you sure you want to exit? ")==true )
	{
		window.location.href="/NBG/ProductManagementServlet?action=uordap";
		return true;
	}
	else
	{
		return false;
	}
	
}
				
function AdditionalProductReportValidation()
{
	if(confirm("Data you have entered will be lost. Are you sure you want to exit? ")==true )
	{
		window.location.href="/NBG/ProductManagementServlet?action=viewap";
		return true;
	}
	else
	{
		return false;
	}
	
}
						
								

