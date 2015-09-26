<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<link href="assets/css/advisor.css" rel="stylesheet">
<link href="assets/css/notification.css" rel="stylesheet">
<link href="assets/css/contact-faq.css" rel="stylesheet">
<link href="assets/css/how.css" rel="stylesheet">
<script src="http://cdn.jsdelivr.net/jquery.validation/1.14.0/jquery.validate.min.js"></script>
    <script src="http://cdn.jsdelivr.net/jquery.validation/1.14.0/additional-methods.min.js"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker.min.css" rel="stylesheet">
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<!-- Custom styles for this template https://code.jquery.com/jquery-1.11.3.min.js<link href="assets/css/main.css" rel="stylesheet">

<!-- Fonts from Google Fonts -->
<link href='https://fonts.googleapis.com/css?family=Lato:300,400,900'
    rel='stylesheet' type='text/css'>
<link href="assets/css/font-awesome.min.css" rel="stylesheet"
    type="text/css">
<%
String sessionStatus = (String)request.getParameter("session");
List<SessionDTO> sessions = (List<SessionDTO>)request.getAttribute("sessions");
List<AdvisorDTO> advisorDetails = (List<AdvisorDTO>)request.getAttribute("advisorDetails");
List<SessionDTO> pastSessions = (List<SessionDTO>)request.getAttribute("pastSessions");
List<AdvisorDTO> advisorDetails1 = (List<AdvisorDTO>)request.getAttribute("advisorDetails1");
List<ReviewsDTO> userReviews = (List<ReviewsDTO>)request.getAttribute("userReviews");
List<SessionDTO> sessionDates = (List<SessionDTO>)request.getAttribute("sessionDates");
List<AdvisorDTO> advisorsForReviews = (List<AdvisorDTO>)request.getAttribute("advisorsForReviews");
pageContext.setAttribute("sessionStatus", sessionStatus);
pageContext.setAttribute("userReviews", userReviews);
pageContext.setAttribute("sessionDates", sessionDates);
pageContext.setAttribute("advisorsForReviews", advisorsForReviews);


%>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<title>Insert title here</title>

<body>
 <div id="wrapper">
  <%@include file="/notify.jsp" %>
 	<div class="do-not-scroll " style="width:100%">
		  <div class="top-div">
		  
			       <%@include file="/Header.jsp" %>
			       	  
	</div>
</div>
   	<div class="main-body-how no-padding" id="page-content-wrapper" >
   	
   			<div class="container how-div-1">
	   			<div class="col-xs-12 col-sm-6 img-div-1">
	   				<img src="assets/img/howitworks1.png"  class="img-responsive">
	   			</div>
	   			<div class="col-xs-12 col-sm-6 text-div-1">
	   				<span class="big-red-text">How It Works</span><br>
	   				<span class="small-info-text-div1">Connect to people just like you who made it big. Discover Career Advice like never before.</span>
	   			</div>
   			</div>
   			<div class="grey-div-1 col-xs-12">
   				<div class="container">
	   				<div class="col-xs-12 col-sm-4 each-div-ingrey">
	   					<img src="assets/img/howitworks2.svg">
	   					<span class="grey-img-head">Choose your advisor</span>
	   					<span class="grey-img-info-text">Pick your advisor depending on the category of advice – Higher Studies, different Careers and Jobs or General Questions.</span>
	   				</div>
	   				<div class="col-xs-12 col-sm-4 each-div-ingrey">
	   					<img src="assets/img/howitworks3.svg">
	   					<span class="grey-img-head">Ask a question</span>
	   					<span class="grey-img-info-text">Post a question to any one or ALL advisors for FREE and get expert answers to your career queries</span>
	   				</div>
	   				<div class="col-xs-12 col-sm-4 each-div-ingrey">
	   					<img src="assets/img/howitworks4.svg">
	   					<span class="grey-img-head">Book a Session</span>
	   					<span class="grey-img-info-text">Book a one on one session within seconds and get great career advice from people who have first-hand experience with the doubts that you face</span>
	   				</div>
   				</div>
   			</div>
   			<div class="how-steps-div col-xs-12 no-padding">
   				<div class="container">
   				<div class="col-xs-12 head-div" >
   					<span class="step-conatiner-head">HOW THE <span class="head-u">SESSION</span> WORKS</span>
   				</div>
   					<div class="each-step-div col-xs-12 no-padding">
   						<div  class="col-xs-12 col-sm-7 l-div">
   							<span class="no-span">1</span>
   							<span class="step-info">Learn about advisors through their profiles. Filter via categories, industry, education,company, experience to reach the best advisor for you</span>
   						</div>
   						<div  class="col-xs-12 col-sm-5">
   							<img src="assets/img/howitworks5.png"  class="img-responsive">
   						</div>
   					</div>
   					<div class="each-step-div col-xs-12 no-padding">
   						<div  class="col-xs-12 col-sm-7">
   							<img src="assets/img/howitworks6.png"  class="img-responsive">
   						</div>
   						<div  class="col-xs-12 col-sm-5">
   							<span class="no-span">2</span>
   							<span class="step-info">Pick 3 date and time slots that work for you, choose the approx duration of the session,write down your query and send the request.</span>
   						</div>
   					</div>
   					<div class="each-step-div col-xs-12 no-padding">
   						<div  class="col-xs-12 col-sm-7">
   							<span class="no-span">3</span>
   							<span class="step-info">Get a confirmation from the advisor with the chosen date and time. Recharge your Advisor Circuit Wallet and you’re ready!</span>
   						</div>
   						<div  class="col-xs-12 col-sm-5">
   							<img src="assets/img/howitworks7.png"  class="img-responsive">
   						</div>
   					</div>
   					<div class="each-step-div col-xs-12 no-padding">
   						<div  class="col-xs-12 col-sm-7">
   							<img src="assets/img/howitworks8.png"  class="img-responsive">
   						</div>
   						<div  class="col-xs-12 col-sm-5">
   							<span class="no-span">4</span>
   							<span class="step-info">Connect conveniently via phone /video chat on the day of the session and solve away your queries.</span>
   						</div>
   					</div>
   					<div class="each-step-div col-xs-12 no-padding">
   						<div  class="col-xs-12 col-sm-7">
   							<span class="no-span">5</span>
   							<span class="step-info">Only get charged for the time that you talk to the advisor. You can even refund your leftover wallet balance post your session if you want.</span>
   						</div>
   						<div  class="col-xs-12 col-sm-5">
   							<img src="assets/img/howitworks9.png"  class="img-responsive">
   						</div>
   					</div>
   				</div>
   			</div>
   			<div class="last-div-grey col-xs-12 no-padding">
   			<div class="last-div-content">
   				<span class="how-we-help">Wondering how we can help your career?</span><br>
   				<button type="button" class="btn red-button sign-up-howp">Sign Up Now</button>
   			</div>
   			<img src="assets/img/howitworks10.png"  class="img-responsive">
   			</div>
	 <%@include file="/footer.jsp" %>
</div>
</div>

<script>

$(document).ready(function () {
	
});
</script>
</body>
</html>