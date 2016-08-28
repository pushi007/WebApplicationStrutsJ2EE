function pro2id_validation(tid)
{  
var c_len =tid.value.length;  

if (c_len>20)  
{  
alert("character length shold not be more than 20 characters");  


return false;  
}
  
return true;  
}

function validate_form()
{

var today = new Date();
var dd = today.getDate();
var mm = today.getMonth()+1; //January is 0!
var yyyy = today.getFullYear();
if(dd<10){dd='0'+dd} if(mm<10){mm='0'+mm} 
today = yyyy+'/'+mm+'/'+dd;

var bid = document.fname.pid;  
var tid = document.fname.pid1;  

if(bid.value.length==0)  
{  

alert("Please enter product ID!");  
bid.focus();  
return false;    
  
}   
if(tid.value.length==0)  
{  

alert("Please enter Product Name!");  
tid.focus();  
return false;    
  
}   
  
if(document.fname.status[0].checked==false && document.fname.status[1].checked==false){
alert("Please select the Status!");
document.fname.status[0].focus();
return false;
}

var validFrom=document.fname.pid3.value;
var uYY=validFrom.split("-")[2];
var uMM=validFrom.split("-")[1];
var uDD=validFrom.split("-")[0];
var userDate=uYY+"/"+uMM+"/"+uDD;
if(new Date(userDate)<new Date(today))
	{
	alert("Valid From cannot be less than today's date!");
	pid3_Object.show();
	return false;
	}
  
return true;  
}  









  