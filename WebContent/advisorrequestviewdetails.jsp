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
<script src="//cdn.ckeditor.com/4.5.4/basic/ckeditor.js"></script>
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
					   		<br>
					   		<span class="status"><i class="fa fa-check"></i> Request waiting for your approval</span>
					   		<div class="col-xs-12 no-padding session-info-div">
						   		<span class="btext name">${userDetails.getFullName()}</span><br><br>
						   		<span class="mode">Mode</span>
						   		<c:choose>
						   		    <c:when test="${sessionDetails.getMode().equals('video')}">
						   		     <span class="mode-type"><img src="assets/img/video.png"> Video session</span><br>
						   		    </c:when>
						   		    <c:otherwise>
						   		      <span class="mode-type"><img src="assets/img/phone.png"> Phone session</span><br>
						   		    </c:otherwise>
						   		</c:choose>
						   		<br>
						   		<span class="mode">Duration</span>	<span class="mode-type">${sessionDetails.getDuration()} Minutes</span>
					   		</div>
					   		<div class="query-description-div col-xs-12 no-padding">
					   			<span class="query-description-head">Query Description</span>
					   			<p class="q-description">
					   			${sessionDetails.getQuery()}
					   			</p>
					   		</div>
					   		<c:if test="${!sessionDetails.getResume().equals('')}">
					   		<div class="attached-file-div col-xs-12">
					   			<span class="attachd-text">Attached File</span>
					   			<a class="link btext" href="DownloadFile?sid=${sessionDetails.getSessionid()}">resume</a>
					   		</div>
					   		</c:if>
					   		   	 <div class="notify-text-div" style="display: none" id="choosedateerror">
			<span class="notify-text" style="color: #FF0000">Error : Please select a date from the proposed time slots or choose dates of your choice .</span>
		</div>
		
		
					   		<form action="approvesession" method="post" id="approve-session">
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
					   		<div class="notify-text-div" style="display: none" id="samedateerror">
			<span class="notify-text" style="color: #FF0000">Error : Please select different date time slots of your choice .</span>
		</div>
					   		<div class="col-xs-12 no-padding new-slotsp">
					   			<span class="prop-time-text">Propose Revised Time Slots</span>
					   		</div>
					   		<div class="prop-time-div col-xs-12 no-padding new-slotsp">
					   			<div class=" col-xs-12 no-padding">
											 	<label class="col-xs-3 no-padding form-label">Slot 1</label>
											       <div class="col-xs-9 form-group">
											       <div class="col-xs-6">
											        <input class="datepicker form-control inpt-mw" id="nd1" placeholder="Date" data-provide="datepicker" name="newdate1">
											       </div>
											       <div class="col-xs-6">
											        <select class="collapsed-filter-button inpt-mw" id="newtime1" name="newtime1">
														
													</select> 
											       </div>
				                                     
											 		</div>
											 	</div>	
											 	<div class=" col-xs-12 no-padding">
											 	<label class="col-xs-3 no-padding form-label">Slot 2</label>
											       <div class="col-xs-9 form-group">
											       <div class="col-xs-6">
											        <input class="datepicker form-control inpt-mw" id="nd2" placeholder="Date" data-provide="datepicker" name="newdate2">
											       </div>
											       <div class="col-xs-6">
											        <select class="collapsed-filter-button inpt-mw" id="newtime2"  name="newtime2">
														
													</select> 
											       </div>
				                                     
											 		</div>
											 	</div>	
							</div>
							<div class="notify-text-div" style="display: none" id="sessionplanerror">
			<span class="notify-text" style="color: #FF0000">Error : Please enter a session plan .</span>
		</div>
							<div class="col-xs-12 no-padding">
					   			<span class="prop-time-text">Session Plan</span>
					   		</div>
					   			<div class="prop-time-div col-xs-12 no-padding">
					   				<textarea rows="5"  cols="" class="form-control" id="sessionplan" name="sessionplan" maxlength="8000"></textarea>
					   			</div>
					   			<div class="total-cost-div">
					   				<span class="total-cost-text">Total cost</span><br>
					   				<span class="total-cost-rs">Rs ${sessionDetails.getPrice()}</span>
					   			</div>
					   			<input type="hidden" name="uid" value="${sessionDetails.getUserid()}">
					   			<div class="col-xs-12 no-padding">
					   			<button type="submit" class="btn two-buttons accept-session-advisor" style="background-color: #f2624d;color:white;">Accept Session</button>
		   		    		<a href="advisorcancelsession?sId=${sessionDetails.getSessionid()}" type="button" class="btn two-buttons" style="background-color: #6c6c6c;color:white;">Reject Session</a>
					   			</div>
					   			</form>
					   			
					   			<div class="next-step-div col-xs-12 ">
					   				<div class="col-xs-12">
							   			<span class="next-step-text btext">Next Steps</span>
							   			<span class="step-text-no">After you submit your response; We will send your reply to the user who will now get the chance to confirm the session. <br><br>
							   		       </span>
							   		</div>
							   		
					   		</div>
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
								    		<textarea class="form-control reason-input" rows="5" id="reason" cols="" placeholder="Write you reason" name="reason" required maxlength="3000"></textarea>
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

<script type="text/javascript">
$('body').on('click', '.cross-noti', function(e){
	$('.notify-div').slideUp();
});
</script>

<script>
CKEDITOR.replace( 'sessionplan' );
CKEDITOR.replace( 'reason' );
$(document).ready(function () {

	$('.datepicker').datepicker({
	    format: 'yyyy/mm/dd',
	    startDate: '-3d'
	});
	   CKEDITOR.config.removePlugins = 'about';

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
		        if($('#p1').is(':checked')){
		        	$('input:radio[name="date1"]').prop('checked', false);
		        }
		    });
	$('input:radio[name="date1"]').change(
			
		    function(){
		        if ($('input:radio[name="date1"]').is(':checked')) {
		            $('#p1').prop('checked', false);
		            $('.new-slotsp').slideUp();
		        }
		       
		    });
	$('body').on('submit', '#approve-session', function(e){
		var sessionplan = $("#sessionplan").val();
		var isDateselected = $('input:radio[name="date1"]').is(':checked');
		var nd1 = $("#nd1").val();
		var nd2 = $("#nd2").val();
		var nt1 = document.getElementById('newtime1').value;
		var nt2 = document.getElementById('newtime2').value;
		debugger;
		if(!isDateselected && nd1 == "" && nd2 == ""){
			e.preventDefault();
			document.getElementById("choosedateerror").style.display = "block";
			document.getElementById("samedateerror").style.display = "none";
			document.getElementById("sessionplanerror").style.display = "none";

		}else if (!isDateselected && nd1 == nd2 && nt1 == nt2) {
			e.preventDefault();
			document.getElementById("samedateerror").style.display = "block";
			document.getElementById("choosedateerror").style.display = "none";
			document.getElementById("sessionplanerror").style.display = "none";

		}else if (sessionplan == "") {
			e.preventDefault();
			document.getElementById("sessionplanerror").style.display = "block";
			document.getElementById("choosedateerror").style.display = "none";
			document.getElementById("samedateerror").style.display = "none";

		}
	});
});

function AcceptSession(){
	
}

</script>
</body>
</html>