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
                   AdvisorDTO advisorDetails = (AdvisorDTO)request.getAttribute("advisorDetails");
%>
</head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div id="wrapper">
	<div class="do-not-scroll " style="width:100%">
		  <div class="top-div">
			       <%@include file="/Header.jsp" %>
	  
	</div>
</div>
   	<div class="main-body-div container no-padding"  id="page-content-wrapper">
   	<div class="col-xs-12 body-head-div">
							<span class="body-head-text"><a href="userdashboard">Dashboard:</a> </span><span class="head-path"><a href="usersessions">Sessions </a>> Session with ${advisorDetails.getName()}</span>
	</div>
   		   <div class="col-xs-12 no-padding" style="    background-color: white;">
   		    		<div class="col-xs-12 col-sm-3  no-padding dp-container">
	   		    		<div class="col-xs-12 blueT4">
		   		    		<div class="Adp" style="text-align:center;">
								<img src="${advisorDetails.getImage()}">
							</div>
				   		</div>
				   	</div>
				   	<div class="col-xs-12 col-sm-9 right-div">
	   		    		<div class="col-xs-12 container-div-all">
		   		    		<span class="session-id">Session ID #${sessionDetails.getSessionid()}</span>
		   		    		<br>
					   		<span class="status"><i class="fa fa-check"></i> Request sent to Advisor</span>
					   		<div class="col-xs-12 no-padding session-info-div">
						   		<span class="btext name">${advisorDetails.getName()}</span> <span class="name-other-text">| User Email/summary background</span><br><br>
						   		<span class="mode">Mode</span>	<span class="mode-type"><img src="assets/img/phone.png"> Phone session</span><br>
						   		<br>
						   		<span class="mode">Duration</span>	<span class="mode-type">${sessionDetails.getDuration()} Minutes</span>
					   		</div>
					   		<div class="propsed-time-slots-div col-xs-12 no-padding">
					   		<span class="propsed-time-slots-head">Proposed Time Slots</span><br>
					   			<span class="timeslots-proposed">${sessionDetails.getDate1()}, ${sessionDetails.getTime1()}</span>
					   			<span class="timeslots-proposed">${sessionDetails.getDate2()}, ${sessionDetails.getTime2()}</span>
					   			<span class="timeslots-proposed">${sessionDetails.getDate3()}, ${sessionDetails.getTime3()}</span>
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
					   				<div class="next-step-div col-xs-12" style="margin-top: 35px;">
					   				<div class="col-xs-12">
							   			<span class="next-step-text btext">Next Steps</span>
							   		</div>
							   	
							   		<span class="step-text-no">1. Some Dummy Text as steps. Its best to number them for better understanding as steps </span><br>
							   		<span class="step-text-no">1. Some Dummy Text as steps. Its best to number them for better understanding as steps </span><br>
							   		
					   		</div>
				   		</div>
				   	</div>
				   
				   
		   	</div>
   		  
   			<div class="body-content col-xs-12 no-padding">
   			
   			</div>
   	 </div>
   	 <%@include file="/footer.jsp" %>
</div>


<script>
$(document).ready(function () {
	$('.datepicker').datepicker({
	    format: 'mm/dd/yyyy',
	    startDate: '-3d'
	});
	var i=0;
	var html=""
	for(i=0;i<25;i++){
		html='<option value="'+i+':00">'+i+':00 Hours</option>'
			+'<option value="'+i+':30">'+i+':30 Hours</option>';
		$('.inpt-mw').append(html);
	}
	starinputconversion();
});

function AcceptSession(){
	
}

</script>
</body>
</html>