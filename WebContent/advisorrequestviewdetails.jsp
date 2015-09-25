<%@page import="java.util.List"%>
<%@page import="ac.dto.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

  <link rel="shortcut icon" href="https://www.advisorcircuit.com/assets/img/PageTop_Logo.png"> 
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">

<!-- Bootstrap core CSS -->
<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="https//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<link href="assets/css/pannel.css" rel="stylesheet">
<link href="assets/css/star-rating.css" rel="stylesheet">
<link href="assets/css/nav-mobile.css" rel="stylesheet">
<link href="assets/css/qa.css" rel="stylesheet">
<link href="assets/css/ud.css" rel="stylesheet">
<link href="assets/css/session.css" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker.min.css" rel="stylesheet">
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<!-- Custom styles for this template https://code.jquery.com/jquery-1.11.3.min.js<link href="assets/css/main.css" rel="stylesheet">

<!-- Fonts from Google Fonts -->
<link href='https://fonts.googleapis.com/css?family=Lato:300,400,900'
    rel='stylesheet' type='text/css'>
<link href="assets/css/font-awesome.min.css" rel="stylesheet"
    type="text/css">
<%

                   SessionDTO sessionDetails = (SessionDTO)request.getAttribute("sessionDetails");
                   UserDetailsDTO userDetails = (UserDetailsDTO)request.getAttribute("userDetails");
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<style>
.r-div input {margin-right: -13px;}
</style>

<title>Insert title here</title>
<body>
 <div id="wrapper">
	<div class="do-not-scroll " style="width:100%">
		  <div class="top-div">
			       <%@include file="/Header.jsp" %>
	  
	</div>
</div>
   	<div class="main-body-div container"  id="page-content-wrapper">
   	<div class="col-xs-12 body-head-div">
							<span class="body-head-text"><a href="advisordashboard">Dashboard:</a> </span><span class="head-path"><a href="advisorsessions">Sessions</a> > Session with ${userDetails.getFullName()}</span>
	</div>
   		   <div class="col-xs-12 no-padding" style="    background-color: white;">
   		    		<div class="col-xs-12 col-sm-3  no-padding dp-container">
	   		    		<div class="col-xs-12 blueT4">
		   		    		<div class="Adp" style="text-align:center;">
								<img src="${userDetails.getImage()}">
							</div>
				   		</div>
				   	</div>
				   	<div class="col-xs-12 col-sm-9 right-div">
	   		    		<div class="col-xs-12 container-div-all">
		   		    		<span class="session-id">Session ID #${sessionDetails.getSessionid()}</span>
		   		    		<button type="button" class="btn two-buttons" style="background-color: #f2624d;color:white;" onclick="AcceptSession()">Accept Session</button>
		   		    		<a href="advisorcancelsession?sId=${sessionDetails.getSessionid()}" class="btn two-buttons" style="background-color: #6c6c6c;color:white;">Reject Session</a>
					   		<br>
					   		<span class="status"><i class="fa fa-check"></i> Request waiting for your approval</span>
					   		<div class="col-xs-12 no-padding session-info-div">
						   		<span class="btext name">${userDetails.getFullName()}</span> <span class="name-other-text">| User Email/summary background</span><br><br>
						   		<span class="mode">Mode</span>	<span class="mode-type"><img src="assets/img/phone.png"> Phone session</span><br>
						   		<br>
						   		<span class="mode">Duration</span>	<span class="mode-type">${sessionDetails.getDuration()} Minutes</span>
					   		</div>
					   		<div class="query-description-div col-xs-12 no-padding">
					   			<span class="query-description-head">Query Description</span>
					   			<p class="q-description">
					   			${sessionDetails.getQuery()}
					   			</p>
					   		</div>
					   		<div class="attached-file-div col-xs-12">
					   			<span class="attachd-text">Attached File</span>
					   			<a class="link btext" href="DownloadFile?sid=${sessionDetails.getSessionid()}">resume</a>
					   		</div>
					   		<form action="approvesession" method="post">
					   		<input type="hidden" value="${sessionDetails.getSessionid()}" name="sId">
					   		<div class="col-xs-12 no-padding">
					   		<span class="prop-time-text">Proposed Time Slots</span>
					   		</div>
					   		<div class="prop-time-div col-xs-12 no-padding ">
					   			
					   				<div class="col-xs-6 radio-button-div no-padding">
					   					<div class="r-div">
											<input type="radio" value="${sessionDetails.getDate1()}::${sessionDetails.getTime1()}" id="s1" name="date1" />
											<label for="s1"><span></span></label>
										</div>
										<span class="slot-asked-for"><span class="slot-no">Slot 1</span><span class="slot-asked-time">${sessionDetails.getDate1()}, ${sessionDetails.getTime1()}</span></span>
					   				</div>
					   				<div class="col-xs-6 radio-button-div no-padding">
					   					<div class="r-div">
											<input type="radio" value="${sessionDetails.getDate2()}::${sessionDetails.getTime2()}" id="s2" name="date1"  />
											<label for="s2"><span></span></label>
										</div>
										<span class="slot-asked-for"><span class="slot-no">Slot 2</span><span class="slot-asked-time">${sessionDetails.getDate2()}, ${sessionDetails.getTime2()}</span></span>
					   				</div>
					   				<div class="col-xs-6 radio-button-div no-padding">
					   					<div class="r-div">
											<input type="radio" value="${sessionDetails.getDate3()}::${sessionDetails.getTime3()}" id="s3" name="date1"  />
											<label for="s3"><span></span></label>
										</div>
										<span class="slot-asked-for"><span class="slot-no">Slot 3</span><span class="slot-asked-time">${sessionDetails.getDate3()}, ${sessionDetails.getTime3()}</span></span>
					   				</div>
					   				<div class="col-xs-12 radio-button-div no-padding">
					   					<div class="r-div">
											<input type="radio" value="pradio" id="p1" name="slot"  />
											<label for="p1"><span></span></label>
										</div>
										<span class="slot-asked-for"><span class="slot-no">Propose Revised Time Slots</span></span>
					   				</div>
										
					   		</div>
					   		<div class="col-xs-12 no-padding new-slotsp">
					   			<span class="prop-time-text">Propose Revised Time Slots</span>
					   		</div>
					   		<div class="prop-time-div col-xs-12 no-padding new-slotsp">
					   			<div class=" col-xs-12 no-padding">
											 	<label class="col-xs-3 no-padding form-label">Slot 1</label>
											       <div class="col-xs-9 form-group">
											       <div class="col-xs-6">
											        <input class="datepicker form-control inpt-mw" placeholder="Date" data-provide="datepicker" name="newdate1">
											       </div>
											       <div class="col-xs-6">
											        <select class="collapsed-filter-button inpt-mw" name="newtime1">
														
													</select> 
											       </div>
				                                     
											 		</div>
											 	</div>	
											 	<div class=" col-xs-12 no-padding">
											 	<label class="col-xs-3 no-padding form-label">Slot 2</label>
											       <div class="col-xs-9 form-group">
											       <div class="col-xs-6">
											        <input class="datepicker form-control inpt-mw" placeholder="Date" data-provide="datepicker" name="newdate2">
											       </div>
											       <div class="col-xs-6">
											        <select class="collapsed-filter-button inpt-mw" name="newtime2">
														
													</select> 
											       </div>
				                                     
											 		</div>
											 	</div>	
							</div>
							<div class="col-xs-12 no-padding">
					   			<span class="prop-time-text">Session Plan</span>
					   		</div>
					   			<div class="prop-time-div col-xs-12 no-padding">
					   				<textarea rows="5" cols="" class="form-control" id="sessionplan" name="sessionplan"></textarea>
					   			</div>
					   			<div class="total-cost-div">
					   				<span class="total-cost-text">Total cost</span><br>
					   				<span class="total-cost-rs">Rs ${sessionDetails.getPrice()}</span>
					   			</div>
					   			<input type="hidden" name="uid" value="${sessionDetails.getUserid()}">
					   			<div class="col-xs-12 no-padding">
					   			<button type="submit" class="btn two-buttons" style="background-color: #f2624d;color:white;">Accept Session</button>
		   		    		<button type="button" class="btn two-buttons" style="background-color: #6c6c6c;color:white;">Reject Session</button>
					   			</div>
					   			</form>
				   		</div>
				   	</div>
				   
				   
		   	</div>
   		  
   			<div class="body-content col-xs-12 no-padding">
   			
   			</div>
   	 </div>
   	 <%@include file="/footer.jsp" %>
   	 <div class="modal fade" id="booksession" tabindex="-1" role="dialog" aria-labelledby="booksession">
								  <div class="modal-dialog" role="document">
								    <div class="modal-content">
								      <div class="modal-body">
								    	<div class="modal-head-bsession">
								    		<span class="modal-head-text">Write A Note</span>
								    	</div>
								    	<form action="approvesession" method="post" id="reject-reason-form">
								    	<input type="hidden" name="sid" value="${sessionDetails.getSessionid()}">
								    	<input type="hidden" name="uid" value="${sessionDetails.getUserid()}">
								    	<div class="modal-main-body row">
								    		<textarea class="form-control reason-input" rows="5" cols="" placeholder="Write you reason" name="reason" required></textarea>
								    		<div class="col-xs-12 no-padding">
								    			<button type="submit" class="btn recharg-button" style="background-color:#f2624d;width: 120px;margin-top: 10px;float: right">Send</button>
								    		</div>
								    	</div>
								    	</form>
								      </div>
								      
								    </div>
								  </div>
								</div>
</div>


<script>
$(document).ready(function () {
	$('.datepicker').datepicker({
	    format: 'mm/dd/yyyy',
	    startDate: '-3d'
	});
	$("#reject-reason-form").validate();
	var i=0;
	var html=""
	for(i=0;i<25;i++){
		html='<option value="'+i+':00">'+i+':00 Hours</option>'
			+'<option value="'+i+':30">'+i+':30 Hours</option>';
		$('.inpt-mw').append(html);
	}
	$('input:radio[name="slot"]').change(
		    function(){
		        if ($(this).val() == 'pradio') {
		            $('.new-slotsp').slideDown();
		        }
		        else {
		        	 $('.new-slotsp').slideUp();
		        }
		    });
	
});

function AcceptSession(){
	
}

</script>
</body>
</html>