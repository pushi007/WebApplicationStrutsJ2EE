
$(function(){

		$('#prev').hide();
		$('#1').show();
		printRange(1);
	//	alert(perPageRecords());
	  $('#next').click(function(){			
			var pageNo = parseInt($('#pageNo').val());
			$('#prev').show();
			if(totalPages() > pageNo)
			{
				var newPageNo = pageNo+1;
				if(newPageNo==totalPages())	$('#next').hide();
				for(var i =1; i <= totalPages() ; i++ ){
					if(i == newPageNo){
						printRange(newPageNo);
		//				alert($('#'+i).attr('id'));
						$('#'+i).show();
						$('#pageNo').val(i);
						$('#range').html(from+'-'+to+' of '+$('#records').val());
					}
					else
						$('#'+i).hide();					
				}
			}			
	  });
	  
	  $('#prev').click(function(){			
			var pageNo = parseInt($('#pageNo').val());
			$('#next').show();
			if(pageNo <= totalPages())
			{
				var newPageNo = pageNo-1;
				if(newPageNo==1)	$('#prev').hide();
				for(var i =1; i <= totalPages() ; i++ ){
					if(i == newPageNo){
						printRange(newPageNo);
						$('#'+i).show();
						$('#pageNo').val(i);
					}
					else
						$('#'+i).hide();					
				}
			}			
	  });
	  function perPageRecords(){ 
			if($('.paging').attr('perPageRecords')===undefined)
				return 6;
			else	
				return $('.paging').attr('perPageRecords');
		}
	  function totalPages(){
			return Math.ceil(parseInt($('#records').val()) / perPageRecords());			
	  }
	  function printRange(newPageNo){		  	
			var from = (newPageNo - 1)*perPageRecords() + 1;
			var to = from + (newPageNo==totalPages() ? (parseInt($('#records').val()) % perPageRecords()) - 1 : perPageRecords()-1);
			$('#range').html(from+'-'+to+' of '+$('#records').val());
	//		alert(from+'-'+to+' of '+$('#records').val());
	  }
	  
});
