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
                String ids = (String) request.getAttribute("ids");
                List<String> industries = (List<String>)request.getAttribute("industries");
                List<String> institutions = (List<String>)request.getAttribute("institutions");
                List<String> languages = (List<String>)request.getAttribute("languages");
                List<QuestionsDTO> questions = (List<QuestionsDTO>)request.getAttribute("questions");
                List<AnswerDTO> answers = (List<AnswerDTO>)request.getAttribute("answers");
                String[] higherStudiesSubCategory = (String[])request.getAttribute("higherStudiesSubCategory");
                List<String> industrySubCategory = (List<String>)request.getAttribute("industrySubCategory");
                List<String> optionsSubCategory = (List<String>)request.getAttribute("optionsSubCategory");
                List<QuestionsDTO> mostViewedQuestions = (List<QuestionsDTO>)request.getAttribute("mostViewedQuestions");
                List<String> popCats = (List<String>)request.getAttribute("popCats");

        		pageContext.setAttribute("ids", ids);
	

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
							<span class="body-head-text">Dashboard: </span><span class="head-path">Sessions > Session with Charlie Dixon</span>
	</div>
   		   <div class="col-xs-12 no-padding" style="    background-color: white;">
   		    		<div class="col-xs-12 col-sm-3  no-padding dp-container">
	   		    		<div class="col-xs-12 blueT4">
		   		    		<div class="Adp" style="text-align:center;">
								<img src="assets/img/Abhishek.JPG">
							</div>
				   		</div>
				   	</div>
				   	<div class="col-xs-12 col-sm-9 right-div">
	   		    		<div class="col-xs-12 container-div-all">
		   		    		<span class="session-id">Session ID #123456</span>
		   		    		<button type="button" class="btn two-buttons" style="background-color: #f2624d;color:white;">Accept Session</button>
		   		    		<button type="button" class="btn two-buttons" style="background-color: #6c6c6c;color:white;">Reject Session</button>
					   		<br>
					   		<span class="status"><i class="fa fa-check"></i> Request waiting for your approval</span>
					   		<div class="col-xs-12 no-padding session-info-div">
						   		<span class="btext name">Aasfsfd</span> <span class="name-other-text">| User Email/summary background</span><br><br>
						   		<span class="mode">Mode</span>	<span class="mode-type"><img src="assets/img/phone.png"> Phone session</span><br>
						   		<br>
						   		<span class="mode">Duration</span>	<span class="mode-type">30 Minutes</span>
					   		</div>
					   		<div class="query-description-div col-xs-12 no-padding">
					   			<span class="query-description-head">Query Description</span>
					   			<p class="q-description">
					   			Fixie tote bag ethnic keytar. Neutra vinyl American Apparel kale chips tofu art party, cardigan raw denim quinoa. Cray paleo tattooed, Truffaut skateboard street art PBR jean shorts Shoreditch farm-to-table Austin lo-fi Odd Future occupy. Chia semiotics skateboard, Schlitz messenger bag master cleanse High Life occupy vegan polaroid tote bag leggings. Single-origin coffee mumblecore deep v salvia mlkshk. Organic photo booth cray tofu, vegan fixie bitters sriracha. Blog Austin Wes Anderson, deep v pour-over trust fund vinyl mlkshk +1.
					   			</p>
					   		</div>
					   		<div class="attached-file-div col-xs-12">
					   			<span class="attachd-text">Attached File</span>
					   			<a class="link btext">resume.txt</a>
					   		</div>
					   		<div class="col-xs-12 no-padding">
					   		<span class="prop-time-text">Proposed Time Slots</span>
					   		</div>
					   		<div class="prop-time-div col-xs-12 no-padding">
					   			
					   				<div class="col-xs-6 radio-button-div no-padding">
					   					<div class="roundedOne">
											<input type="checkbox" value="" id="video" name="check" />
											<label for="video"></label>
										</div>
										<span class="slot-asked-for"><span class="slot-no">Slot 1</span><span class="slot-asked-time">23rd September 2015, 7:30 pm</span></span>
					   				</div>
					   				<div class="col-xs-6 radio-button-div no-padding">
					   					<div class="roundedOne">
											<input type="checkbox" value="" id="video" name="check" />
											<label for="video"></label>
										</div>
										<span class="slot-asked-for"><span class="slot-no">Slot 1</span><span class="slot-asked-time">23rd September 2015, 7:30 pm</span></span>
					   				</div>
					   				<div class="col-xs-6 radio-button-div no-padding">
					   					<div class="roundedOne">
											<input type="checkbox" value="" id="video" name="check" />
											<label for="video"></label>
										</div>
										<span class="slot-asked-for"><span class="slot-no">Slot 1</span><span class="slot-asked-time">23rd September 2015, 7:30 pm</span></span>
					   				</div>
					   				<div class="col-xs-6 radio-button-div no-padding">
					   					<div class="roundedOne">
											<input type="checkbox" value="" id="video" name="check" />
											<label for="video"></label>
										</div>
										<span class="slot-asked-for"><span class="slot-no">Slot 1</span><span class="slot-asked-time">23rd September 2015, 7:30 pm</span></span>
					   				</div>
					   				<div class="col-xs-6 radio-button-div no-padding">
					   					<div class="roundedOne">
											<input type="checkbox" value="" id="video" name="check" />
											<label for="video"></label>
										</div>
										<span class="slot-asked-for"><span class="slot-no">Propose Revised Time Slots</span></span>
					   				</div>
										
					   		</div>
					   		<div class="col-xs-12 no-padding">
					   			<span class="prop-time-text">Propose Revised Time Slots</span>
					   		</div>
					   		<div class="prop-time-div col-xs-12 no-padding">
					   			<div class=" col-xs-12 no-padding">
											 	<label class="col-xs-3 no-padding form-label">Slot 1</label>
											       <div class="col-xs-9 form-group">
											       <div class="col-xs-6">
											        <input class="datepicker form-control inpt-mw" placeholder="Date" data-provide="datepicker">
											       </div>
											       <div class="col-xs-6">
											        <select class="collapsed-filter-button inpt-mw">
														
													</select> 
											       </div>
				                                     
											 		</div>
											 	</div>	
											 	<div class=" col-xs-12 no-padding">
											 	<label class="col-xs-3 no-padding form-label">Slot 2</label>
											       <div class="col-xs-9 form-group">
											       <div class="col-xs-6">
											        <input class="datepicker form-control inpt-mw" placeholder="Date" data-provide="datepicker">
											       </div>
											       <div class="col-xs-6">
											        <select class="collapsed-filter-button inpt-mw">
														
													</select> 
											       </div>
				                                     
											 		</div>
											 	</div>	
							</div>
							<div class="col-xs-12 no-padding">
					   			<span class="prop-time-text">Session Plan</span>
					   		</div>
					   			<div class="prop-time-div col-xs-12 no-padding">
					   				<textarea rows="5" cols="" class="form-control"></textarea>
					   			</div>
					   			<div class="total-cost-div">
					   				<span class="total-cost-text">Total cost</span><br>
					   				<span class="total-cost-rs">Rs 500</span>
					   			</div>
					   			<div class="col-xs-12 no-padding">
					   			<button type="button" class="btn two-buttons" style="background-color: #f2624d;color:white;">Accept Session</button>
		   		    		<button type="button" class="btn two-buttons" style="background-color: #6c6c6c;color:white;">Reject Session</button>
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
	

</script>
</body>
</html>