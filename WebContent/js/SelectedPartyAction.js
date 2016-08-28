function selectOperationView()
{	
	document.getElementById("err_msg").innerHTML="";
	var radios=document.getElementsByName('selectParty');
    for (var i=0;i<radios.length;i++) 
    {
        if(radios[i].checked) 
        {
        	document.Acc_Party_Details_Summary.selectedPartyAction.value="viewSelectedParty";
    		document.Acc_Party_Details_Summary.submit();
    		return true;
        }
    }
    document.getElementById("err_msg").innerHTML="Please select a party to view";
    return true;
}

function selectOperationUpdate()
{
	document.getElementById("err_msg").innerHTML="";
	var radios=document.getElementsByName('selectParty');
    for (var i=0;i<radios.length;i++) 
    {
        if(radios[i].checked) 
        {
        	document.Acc_Party_Details_Summary.selectedPartyAction.value="updateSelectedParty";
    		document.Acc_Party_Details_Summary.submit();
    		return true;
        }
    }
    document.getElementById("err_msg").innerHTML="Please select a party to update";
    return true;
}

function selectOperationDelete()
{
	document.getElementById("err_msg").innerHTML="";
	var radios=document.getElementsByName('selectParty');
    for (var i=0;i<radios.length;i++) 
    {
        if(radios[i].checked) 
        {
        	if(confirm("Are you sure you want to delete account party's profile ?")==true)
        	{
        		document.Acc_Party_Details_Summary.selectedPartyAction.value="deleteSelectedParty";
        		document.Acc_Party_Details_Summary.submit();
        		return true;
        	}
        	else
        	{
        		return true;
        	}
        }
    }
    document.getElementById("err_msg").innerHTML="Please select a party to delete";
    return true;
}

/*
function selectOperationUpdate()
{
		document.Acc_Party_Details_Summary.selectedPartyAction.value="updateSelectedParty";
		document.Acc_Party_Details_Summary.submit();
		return true;
}
*/


function isExistingCust()
{
	document.getElementById("accNo").disabled=false;
	document.getElementById("branchName").disabled=false;
}

function isNotExistingCust()
{
	document.getElementById("accNo").disabled=true;
	document.getElementById("branchName").disabled=true;
}

