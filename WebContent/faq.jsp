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
<script src="https://cdn.jsdelivr.net/jquery.validation/1.14.0/jquery.validate.min.js"></script>
    <script src="https://cdn.jsdelivr.net/jquery.validation/1.14.0/additional-methods.min.js"></script>
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
<style>
@media (min-width: 320px) and (max-width: 762px) {
 .body-content{
	background-color: white;
	min-height: 400px;
	padding: 15px;
}
}
</style>
<title>Insert title here</title>

<body>
 <div id="wrapper">
  <%@include file="/notify.jsp" %>
 	<div class="do-not-scroll " style="width:100%">
		  <div class="top-div">
		  
			       <%@include file="/Header.jsp" %>
			       	  
	</div>
</div>
   	<div class="main-body-div container no-padding"  id="page-content-wrapper">
   	<div class="col-xs-12 body-head-div">
							<span class="body-head-text">FAQs</span>
	</div>
   		  
   			<div class="body-content faq-tabs col-xs-12">
   					 <ul class="nav nav-tabs" role="tablist">
					    <li role="presentation" class="active"><a href="#customer" aria-controls="customer" role="tab" data-toggle="tab">CUSTOMER</a></li>
					    <li role="presentation"><a href="#advisor" aria-controls="advisor" role="tab" data-toggle="tab">ADVISOR</a></li>
					    
					  </ul>
					
					  <!-- Tab panes -->
					  <div class="tab-content">
					    <div role="tabpanel" class="tab-pane active" id="customer" style="padding-top: 20px;">
					    <div class="contact-us-head-div" style="margin-top: 12px;display: none;">
			   			</div>
							<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
								  <div class="panel panel-default">
								    <div class="panel-heading" role="tab" id="headingOne">
								      <h4 class="panel-title">
								        <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                           1.	Who is an advisor on your platform? </a>
								      </h4>
								    </div>
								    <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
								      <div class="panel-body">
								       We have different people all accomplished in their own areas/ industries as advisors on our platform. The area in which they can offer advice is decided based their experience and knowledge by our team and listed on their profiles specifically. We want to ensure that our users connect with the right advisor (who has relevant knowledge) for their queries.
								      </div>
								    </div>
								  </div>
								  <div class="panel panel-default">
								    <div class="panel-heading" role="tab" id="headingTwo">
								      <h4 class="panel-title">
								        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
								          2.	How do you verify your advisors?
								        </a>
								      </h4>
								    </div>
								    <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
								      <div class="panel-body">
								      We have a strict verification system is place for recruiting advisors and a person is allowed to take sessions only after they have fulfilled the necessary criteria. We run necessary checks and take documentation to ensure their education and professional qualifications are valid. 
								      </div>
								    </div>
								  </div>
								  <div class="panel panel-default">
								    <div class="panel-heading" role="tab" id="headingThree">
								      <h4 class="panel-title">
								        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
								          3.	 How does a session work?
								        </a>
								      </h4>
								    </div>
								    <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
								      <div class="panel-body">
								        Check out our “How it Works” page for all the details.
								      </div>
								    </div>
								  </div>
								    <div class="panel panel-default">
								    <div class="panel-heading" role="tab" id="headingFour">
								      <h4 class="panel-title">
								        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
								          4.	How do I decide which advisor is suitable for me and my queries?
								        </a>
								      </h4>
								    </div>
								    <div id="collapseFour" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFour">
								      <div class="panel-body">
								     Each of our advisor profile mentions the advisor’s area of advice and where all they can specifically help you (“I can help you” with section). If you are still confused about which advisor, just drop in a message to us and we would love to help you. 
								      </div>
								    </div>
								  </div>
								  <div class="panel panel-default">
								    <div class="panel-heading" role="tab" id="headingFive">
								      <h4 class="panel-title">
								        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseFive" aria-expanded="false" aria-controls="collapseFive">
								          5.	How do I ask an advisor a question? Is it free?
								        </a>
								      </h4>
								    </div>
								    <div id="collapseFive" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFive">
								      <div class="panel-body">
								    We have a Q&A platform integrated where advisors will answer your queries for FREE. All the questions asked by our users and their answers given by our advisors can be found on our Q&A page.  You can post a question in 2 ways-
								    <li>Go to a particular advisors’ profile and send a question to them. </li>
								    <li>Go to the Q&A page and post your question to all advisors who are experts in your area of advice</li>
								      </div>
								    </div>
								  </div>
								   <div class="panel panel-default">
								    <div class="panel-heading" role="tab" id="headingSix">
								      <h4 class="panel-title">
								        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseSix" aria-expanded="false" aria-controls="collapseSix">
								          6.	What is the cost of a session? 
								        </a>
								      </h4>
								    </div>
								    <div id="collapseSix" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingSix">
								      <div class="panel-body">
								    We have a pay per minute system where you are charged for the number of minutes you talk to the advisor and nothing more! Each advisor has their own price per minute and the prices may vary. 
								      </div>
								    </div>
								  </div>
								    <div class="panel panel-default">
								    <div class="panel-heading" role="tab" id="headingSeven">
								      <h4 class="panel-title">
								        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseSeven" aria-expanded="false" aria-controls="collapseSeven">
								          7.	What is the duration of a session?
								        </a>
								      </h4>
								    </div>
								    <div id="collapseSeven" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingSeven">
								      <div class="panel-body">
								    You can talk to the advisor for as long or little as you want and cut the call whenever you are done. You will be asked to choose an approximate session duration at the time of booking so that the advisor blocks their time accordingly. However you are free to end the call if your query gets answered before time. 
								      </div>
								    </div>
								  </div>
								  <div class="panel panel-default">
								    <div class="panel-heading" role="tab" id="headingEight">
								      <h4 class="panel-title">
								        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseEight" aria-expanded="false" aria-controls="collapseEight">
								          8.	When and how do I pay for the session? What is the payment process?
								        </a>
								      </h4>
								    </div>
								    <div id="collapseEight" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingEight">
								      <div class="panel-body">
								    You only need to pay once your session request is accepted by the advisor and not at the time of booking.  
                                    We have an Advisor Circuit wallet which you need to recharge with the approximate session cost (based on the duration you select) to confirm the session. However, we have a pay per minute system where you are ultimately charged for the time you end up talking to the advisor and nothing more. So in case you have any leftover balance in your wallet post the session and want your money back, just click the refund button and we will return your money.
         
								      </div>
								    </div>
								  </div>
								  <div class="panel panel-default">
								    <div class="panel-heading" role="tab" id="headingNine">
								      <h4 class="panel-title">
								        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseNine" aria-expanded="false" aria-controls="collapseNine">
								          9.	What is the Advisor Circuit wallet and how does it work?
								        </a>
								      </h4>
								    </div>
								    <div id="collapseNine" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingNine">
								      <div class="panel-body">
								     We have integrated an online wallet for our customers through which they pay for sessions. You can recharge your wallet anytime via credit cards, debit cards, netbanking and other leading payment options provided by our CC Avenue payment gateway. All you need to do this recharge your wallet with a minimum amount (calculated basis the duration you choose and cost of advisor) before your session. You will be charged per minute basis for your call with the advisor and accordingly, money from your wallet will be deducted at the end of the session.
								     <br><br> 

The benefit of making you use a wallet is so that you are charged only for the time you actually speak to the advisor. You can refund any leftover balance instantly. This way you can be relaxed about your money and enjoy your session! So make sure you recharge enough in case you end up talking to the advisor more than you expected as you can always refund any remaining balance. 
								     
								      </div>
								    </div>
								  </div>
								  <div class="panel panel-default">
								    <div class="panel-heading" role="tab" id="headingTen">
								      <h4 class="panel-title">
								        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTen" aria-expanded="false" aria-controls="collapseTen">
								          10.	How do I decide my session dates?
								        </a>
								      </h4>
								    </div>
								    <div id="collapseTen" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTen">
								      <div class="panel-body">
								    While booking a session with an advisor, you have to select 4 Date X Time combinations (Ex: 8th October 2014 – 5:30 PM is one combination) suitable to you for the session.<br>
The advisor will then choose one of these dates or suggest 2 of their own if none sent by you are suitable. If the advisor suggests 2 of their own date-time combinations, you have an option either to select one of these dates to confirm or select none and cancel the session

								      </div>
								    </div>
								  </div>
								  <div class="panel panel-default">
								    <div class="panel-heading" role="tab" id="headingEleven">
								      <h4 class="panel-title">
								        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseEleven" aria-expanded="false" aria-controls="collapseEleven">
								          11.	Are there any technical/equipment requirements that I need for a session?
								        </a>
								      </h4>
								    </div>
								    <div id="collapseEleven" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingEleven">
								      <div class="panel-body">
								    Below is a list of system/technical requirement or equipment that are required for a smooth session:<br>
								    Mode of Communication - Phone:<br>
								    a.	Functional Mobile Phone<br>
								    b.	Strong network<br>
								    c.	Functional Laptop with swift internet connection (If you want to share files)<br>
								    <br><br>
								    Mode of Communication – Web Chat: <br>
								    a.	Functional computer with a webcam & microphone<br>
								    b.	Fast internet connection<br>
								      </div>
								    </div>
								  </div>
								  <div class="panel panel-default">
								    <div class="panel-heading" role="tab" id="headingTwelve">
								      <h4 class="panel-title">
								        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwelve" aria-expanded="false" aria-controls="collapseTwelve">
								          12.	How do your modes of communication work?
								        </a>
								      </h4>
								    </div>
								    <div id="collapseTwelve" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwelve">
								      <div class="panel-body">
								    We give our users 2 options to connect to the advisor for a session, phone and video chat. All you need to do is click on the “Join Call” button on your session page on the designated date and time of the session and you will be instantly connected by either receiving a call or directed to a video chat screen. Zero effort needed!
								      </div>
								    </div>
								  </div>
								  <div class="panel panel-default">
								    <div class="panel-heading" role="tab" id="headingThirteen">
								      <h4 class="panel-title">
								        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThirteen" aria-expanded="false" aria-controls="collapseThirteen">
                                         13.	What if my session disconnects due to connection problems?
								        </a>
								      </h4>
								    </div>
								    <div id="collapseThirteen" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThirteen">
								      <div class="panel-body">
								    If your call gets disconnected in the middle, don’t worry! You can simply click the “Join call” button again in your session window and you will be connected to the advisor. You won’t be charged for the time lost in the middle. 
								      </div>
								    </div>
								  </div>
								  <div class="panel panel-default">
								    <div class="panel-heading" role="tab" id="headingFourteen">
								      <h4 class="panel-title">
								        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseFourteen" aria-expanded="false" aria-controls="collapseFourteen">
                                         14.	Can a session be cancelled by the advisor?
								        </a>
								      </h4>
								    </div>
								    <div id="collapseFourteen" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFourteen">
								      <div class="panel-body">
								   Yes, in adverse circumstances the session can be cancelled by the advisor. However your money will be refunded and we will do our best to reschedule your session. 
								      </div>
								    </div>
								  </div>
								  <div class="panel panel-default">
								    <div class="panel-heading" role="tab" id="headingFiveteen">
								      <h4 class="panel-title">
								        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseFiveteen" aria-expanded="false" aria-controls="collapseFiveteen">
                                          15.	Does Advisor Circuit share my personal details with the Advisor?
								        </a>
								      </h4>
								    </div>
								    <div id="collapseFiveteen" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFiveteen">
								      <div class="panel-body">
                                       Not at all! We believe in complete privacy, we don’t share any of your personal details (that you don’t mention in your query) with the advisor and vice versa!<br>
                                        <br>
                                        If you have any other doubts or questions, mail us at contactus@advisorcircuit.com! We would love to solve them!
								      </div>
								    </div>
								  </div>
								  
								  
								  
								  
								</div>					    
					    </div>
					    <div role="tabpanel" class="tab-pane" id="advisor" style="padding-top: 20px">
					     	<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
								   <div class="panel panel-default">
								    <div class="panel-heading" role="tab" id="headingOne">
								      <h4 class="panel-title">
								        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#advcollapseOne" aria-expanded="false" aria-controls="collapseOne">
                                         1.	How do I know if I am suited to be an advisor?
								        </a>
								      </h4>
								    </div>
								    <div id="advcollapseOne" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne">
								      <div class="panel-body">
                                         An advisor is someone who has sufficient relevant experience in their area of advice to be able to answer questions & doubts regarding the same. The job of an advisor on Advisor Circuit is to assist in solving customer queries and help them understand their choices better. 
                                         So if you think you can fit into this role, become an advisor today! 
								      </div>
								    </div>
								  </div>
								   <div class="panel panel-default">
								    <div class="panel-heading" role="tab" id="headingTwo">
								      <h4 class="panel-title">
								        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#advcollapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                                         2.	Does Advisor Circuit do any background checks on me?
								        </a>
								      </h4>
								    </div>
								    <div id="advcollapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
								      <div class="panel-body">
                                       We have a strict verification system is place for recruiting advisors and a person is allowed to take sessions only after they have fulfilled the necessary criteria. We run necessary checks and take documentation to ensure your education and professional qualifications are valid. 
								      </div>
								    </div>
								  </div>
								  <div class="panel panel-default">
								    <div class="panel-heading" role="tab" id="headingThree">
								      <h4 class="panel-title">
								        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#advcollapseThree" aria-expanded="false" aria-controls="collapseThree">
                                         3.	How much can I charge for a session?
								        </a>
								      </h4>
								    </div>
								    <div id="advcollapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
								      <div class="panel-body">
                                         Your price per session is initially assigned to you by us basis an algorithm we have. You can increase your price over time based on your performance as an advisor on the platform. We have a pay per minute pricing model where the user pays for the total minutes they end up talking to you. 								      </div>
								    </div>
								  </div>
								  <div class="panel panel-default">
								    <div class="panel-heading" role="tab" id="headingFour">
								      <h4 class="panel-title">
								        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#advcollapseFour" aria-expanded="false" aria-controls="collapseFour">
                                         4.	When and how do I get paid for the session? 
								        </a>
								      </h4>
								    </div>
								    <div id="advcollapseFour" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFour">
								      <div class="panel-body">
                                      Total amount due to for the sessions taken will be reimbursed to you via a bank transfer at the end of each month. You will also be able to avail other incentives (Free Cab rides, discounts etc.) very soon.								    </div>
								  </div>
								  </div>
					             <div class="panel panel-default">
								    <div class="panel-heading" role="tab" id="headingFive">
								      <h4 class="panel-title">
								        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#advcollapseFive" aria-expanded="false" aria-controls="collapseFive">
                                         5.	How do I decide my session dates?
								        </a>
								      </h4>
								    </div>
								    <div id="advcollapseFive" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFive">
								      <div class="panel-body">
                                      The customer along with the session request will send you 4 Date X Time combinations (Ex: 8th October 2014 – 5:30 PM is one combination) suitable to them. <br>				
                                      We advise you to select one out of these 4 combinations to hold the session. If none are suitable then you can suggest 2 combinations of your own to the customer.<br>
                                      The customer will then select one of these combinations or cancel the request altogether.
                                    </div>
								  </div>
					     <div class="panel panel-default">
								    <div class="panel-heading" role="tab" id="headingSix">
								      <h4 class="panel-title">
								        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#advcollapseSix" aria-expanded="false" aria-controls="collapseSix">
                                         6.	How does a session work?
								        </a>
								      </h4>
								    </div>
								    <div id="advcollapseSix" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingSix">
								      <div class="panel-body">
                                      You can understand everything you need to know from our How It Works page. 
                                    </div>
								  </div>
					             <div class="panel panel-default">
								    <div class="panel-heading" role="tab" id="headingSeven">
								      <h4 class="panel-title">
								        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#advcollapseSeven" aria-expanded="false" aria-controls="collapseSeven">
                                         7.	How does the Q&A platform work?
								        </a>
								      </h4>
								    </div>
								    <div id="advcollapseSeven" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingSeven">
								      <div class="panel-body">
                                      We have a Q&A platform integrated where users can post questions to you personally or post a general question to all the advisors from your area of advice. All the questions asked by our users and their answers given by our advisors can be found on our Q&A page.  You can answer 
                                    </div>
								  </div>
					             </div>
					              <div class="panel panel-default">
								    <div class="panel-heading" role="tab" id="headingEight">
								      <h4 class="panel-title">
								        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#advcollapseEight" aria-expanded="false" aria-controls="collapseEight">
                                         8.	Are there any technical/equipment requirements that I need for a session?
								        </a>
								      </h4>
								    </div>
								    <div id="advcollapseEight" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingEight">
								      <div class="panel-body">
                                  Below is a list of system/technical requirement or equipments that are required for a smooth session:<br>
                                   Mode of Communication - Phone:<br>
                                   a.	Functional Mobile Phone<br>
                                   b.	Strong network<br>
                                   c.	Functional Laptop with swift internet connection (If you want to share files)<br>
                                   <br><br>
                                   Mode of Communication – Web Chat: <br>
                                   a.	Functional computer with a webcam & microphone<br>
                                   b.	Fast internet connection<br>
                                   
                                    </div>
								  </div>
					             </div>
					               <div class="panel panel-default">
								    <div class="panel-heading" role="tab" id="headingNine">
								      <h4 class="panel-title">
								        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#advcollapseNine" aria-expanded="false" aria-controls="collapseNine">
                                         9.	How do your modes of communication work?
								        </a>
								      </h4>
								    </div>
								    <div id="advcollapseNine" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingNine">
								      <div class="panel-body">
                                  We give our users 2 options to connect to the advisor for a session, phone and video chat. All you need to do is click on the “Join Call” button on your session page on the designated date and time of the session and you will be instantly connected or you will receive a call automatically in case of a phone session. Zero effort needed!
                                   
                                    </div>
								  </div>
					             </div>
					              <div class="panel panel-default">
								    <div class="panel-heading" role="tab" id="headingTen">
								      <h4 class="panel-title">
								        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#advcollapseTen" aria-expanded="false" aria-controls="collapseTen">
                                            10.	Will the customer have the option to review/rate me?
								        </a>
								      </h4>
								    </div>
								    <div id="advcollapseTen" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTen">
								      <div class="panel-body">
                                          Yes, the customer will get the chance to review & rate you after they have a session with you.                                   
                                    </div>
								  </div>
					             </div>
					             <div class="panel panel-default">
								    <div class="panel-heading" role="tab" id="headingEleven">
								      <h4 class="panel-title">
								        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#advcollapseEleven" aria-expanded="false" aria-controls="collapseEleven">
                                            11.	Does Advisor Circuit share my personal details with the Customer?
								        </a>
								      </h4>
								    </div>
								    <div id="advcollapseEleven" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingEleven">
								      <div class="panel-body">
                               Not at all! We believe in complete privacy, we don’t share any of your personal details (apart from the ones mentioned on your profile) with the customer and vice versa!<br>
                                     <br><br>
                                     If you have any other doubts or questions, mail us at contactus@advisorcircuit.com! We would love to solve them!
                                    </div>
								  </div>
					             </div>
					             </div>
					  </div>
   
			</div>
	 <%@include file="/footer.jsp" %>
</div>


<script>

$(document).ready(function () {
	$("#contact-form").validate();
	starinputconversion();
});
function starinputconversion(){"use strict";String.prototype.replaceAll=function(t,e){return this.split(t).join(e)};var t=0,e=5,a=.5,n=function(t,e){return null===t||void 0===t||0===t.length||e&&""===$.trim(t)},r=function(t,e){t.removeClass(e).addClass(e)},i=function(t,e,a){var r=n(t.data(e))?t.attr(e):t.data(e);return r?r:a[e]},l=function(t){var e=(""+t).match(/(?:\.(\d+))?(?:[eE]([+-]?\d+))?$/);return e?Math.max(0,(e[1]?e[1].length:0)-(e[2]?+e[2]:0)):0},o=function(t,e){return parseFloat(t.toFixed(e))},s=function(t,e){this.$element=$(t),this.init(e)};s.prototype={constructor:s,_parseAttr:function(r,l){var o=this,s=o.$element;if("range"===s.attr("type")||"number"===s.attr("type")){var c,u,g=i(s,r,l);switch(r){case"min":c=t;break;case"max":c=e;break;default:c=a}return u=n(g)?c:g,parseFloat(u)}return parseFloat(l[r])},listenClick:function(t,e){t.on("click touchstart",function(t){return t.stopPropagation(),t.preventDefault(),t.handled===!0?!1:(e(t),void(t.handled=!0))})},setDefault:function(t,e){var a=this;n(a[t])&&(a[t]=e)},getPosition:function(t){var e=t.pageX||t.originalEvent.touches[0].pageX;return e-this.$rating.offset().left},listen:function(){var t,e,a=this;a.initTouch(),a.listenClick(a.$rating,function(e){return a.inactive?!1:(t=a.getPosition(e),a.setStars(t),a.$element.trigger("change").trigger("rating.change",[a.$element.val(),a.$caption.html()]),void(a.starClicked=!0))}),a.$rating.on("mousemove",function(n){a.hoverEnabled&&!a.inactive&&(a.starClicked=!1,t=a.getPosition(n),e=a.calculate(t),a.toggleHover(e),a.$element.trigger("rating.hover",[e.val,e.caption,"stars"]))}),a.$rating.on("mouseleave",function(){!a.hoverEnabled||a.inactive||a.starClicked||(e=a.cache,a.toggleHover(e),a.$element.trigger("rating.hoverleave",["stars"]))}),a.$clear.on("mousemove",function(){if(a.hoverEnabled&&!a.inactive&&a.hoverOnClear){a.clearClicked=!1;var t='<span class="'+a.clearCaptionClass+'">'+a.clearCaption+"</span>",n=a.clearValue,r=a.getWidthFromValue(n);e={caption:t,width:r,val:n},a.toggleHover(e),a.$element.trigger("rating.hover",[n,t,"clear"])}}),a.$clear.on("mouseleave",function(){a.hoverEnabled&&!a.inactive&&!a.clearClicked&&a.hoverOnClear&&(e=a.cache,a.toggleHover(e),a.$element.trigger("rating.hoverleave",["clear"]))}),a.listenClick(a.$clear,function(){a.inactive||(a.clear(),a.clearClicked=!0)}),$(a.$element[0].form).on("reset",function(){a.inactive||a.reset()})},destroy:function(){var t=this,e=t.$element;n(t.$container)||t.$container.before(e).remove(),$.removeData(e.get(0)),e.off("rating").removeClass("hide")},create:function(t){var e=this,a=e.$element;t=t||e.options||{},e.destroy(),a.rating(t)},setTouch:function(t,e){var a=this,n="ontouchstart"in window||window.DocumentTouch&&document instanceof window.DocumentTouch;if(n&&!a.inactive){var r=t.originalEvent,i=r.touches||r.changedTouches,l=a.getPosition(i[0]);if(e)a.setStars(l),a.$element.trigger("change").trigger("rating.change",[a.$element.val(),a.$caption.html()]),a.starClicked=!0;else{var o=a.calculate(l),s=o.val<=a.clearValue?a.fetchCaption(a.clearValue):o.caption,c=a.getWidthFromValue(a.clearValue),u=o.val<=a.clearValue?a.rtl?100-c+"%":c+"%":o.width;a.$caption.html(s),a.$stars.css("width",u)}}},initTouch:function(){var t=this;t.$rating.on("touchstart touchmove touchend",function(e){var a="touchend"===e.type;t.setTouch(e,a)})},initSlider:function(r){var i=this;n(i.$element.val())&&i.$element.val(0),i.initialValue=i.$element.val(),i.setDefault("min",i._parseAttr("min",r)),i.setDefault("max",i._parseAttr("max",r)),i.setDefault("step",i._parseAttr("step",r)),(isNaN(i.min)||n(i.min))&&(i.min=t),(isNaN(i.max)||n(i.max))&&(i.max=e),(isNaN(i.step)||n(i.step)||0===i.step)&&(i.step=a),i.diff=i.max-i.min},init:function(t){var e,a,i,l=this,o=l.$element;l.options=t,$.each(t,function(t,e){l[t]=e}),l.starClicked=!1,l.clearClicked=!1,l.initSlider(t),l.checkDisabled(),l.setDefault("rtl",o.attr("dir")),l.rtl&&o.attr("dir","rtl"),e=l.glyphicon?"":"★",l.setDefault("symbol",e),l.setDefault("clearButtonBaseClass","clear-rating"),l.setDefault("clearButtonActiveClass","clear-rating-active"),l.setDefault("clearValue",l.min),r(o,"form-control hide"),l.$clearElement=n(t.clearElement)?null:$(t.clearElement),l.$captionElement=n(t.captionElement)?null:$(t.captionElement),void 0===l.$rating&&void 0===l.$container&&(l.$rating=$(document.createElement("div")).html('<div class="rating-stars"></div>'),l.$container=$(document.createElement("div")),l.$container.before(l.$rating).append(l.$rating),o.before(l.$container).appendTo(l.$rating)),l.$stars=l.$rating.find(".rating-stars"),l.generateRating(),l.$clear=n(l.$clearElement)?l.$container.find("."+l.clearButtonBaseClass):l.$clearElement,l.$caption=n(l.$captionElement)?l.$container.find(".caption"):l.$captionElement,l.setStars(),l.listen(),l.showClear&&l.$clear.attr({"class":l.getClearClass()}),a=o.val(),i=l.getWidthFromValue(a),l.cache={caption:l.$caption.html(),width:(l.rtl?100-i:i)+"%",val:a},o.removeClass("rating-loading")},checkDisabled:function(){var t=this;t.disabled=i(t.$element,"disabled",t.options),t.readonly=i(t.$element,"readonly",t.options),t.inactive=t.disabled||t.readonly},getClearClass:function(){return this.clearButtonBaseClass+" "+(this.inactive?"":this.clearButtonActiveClass)},generateRating:function(){var t=this,e=t.renderClear(),a=t.renderCaption(),i=t.rtl?"rating-container-rtl":"rating-container",l=t.getStars();i+=t.glyphicon?(""===t.symbol?" rating-gly-star":" rating-gly")+t.ratingClass:n(t.ratingClass)?" rating-uni":" "+t.ratingClass,t.$rating.attr("class",i),t.$rating.attr("data-content",l),t.$stars.attr("data-content",l),i=t.rtl?"star-rating-rtl":"star-rating",t.$container.attr("class",i+" rating-"+t.size),t.$container.removeClass("rating-active rating-disabled"),t.$container.addClass(t.inactive?"rating-disabled":"rating-active"),n(t.$caption)&&(t.rtl?t.$container.prepend(a):t.$container.append(a)),n(t.$clear)&&(t.rtl?t.$container.append(e):t.$container.prepend(e)),n(t.containerClass)||r(t.$container,t.containerClass)},getStars:function(){var t,e=this,a=e.stars,n="";for(t=1;a>=t;t++)n+=e.symbol;return n},renderClear:function(){var t,e=this;return e.showClear?(t=e.getClearClass(),n(e.$clearElement)?'<div class="'+t+'" title="'+e.clearButtonTitle+'">'+e.clearButton+"</div>":(r(e.$clearElement,t),e.$clearElement.attr({title:e.clearButtonTitle}).html(e.clearButton),"")):""},renderCaption:function(){var t,e=this,a=e.$element.val();return e.showCaption?(t=e.fetchCaption(a),n(e.$captionElement)?'<div class="caption">'+t+"</div>":(r(e.$captionElement,"caption"),e.$captionElement.attr({title:e.clearCaption}).html(t),"")):""},fetchCaption:function(t){var e,a,r,i,l,o=this,s=parseFloat(t),c=o.starCaptions,u=o.starCaptionClasses;return i="function"==typeof u?u(s):u[s],r="function"==typeof c?c(s):c[s],a=n(r)?o.defaultCaption.replaceAll("{rating}",s):r,e=n(i)?o.clearCaptionClass:i,l=s===o.clearValue?o.clearCaption:a,'<span class="'+e+'">'+l+"</span>"},getWidthFromValue:function(t){var e=this,a=e.min,n=e.max;return a>=t||a===n?0:t>=n?100:100*(t-a)/(n-a)},getValueFromPosition:function(t){var e,a,n=this,r=l(n.step),i=n.$rating.width();return a=n.diff*t/(i*n.step),a=n.rtl?Math.floor(a):Math.ceil(a),e=o(parseFloat(n.min+a*n.step),r),e=Math.max(Math.min(e,n.max),n.min),n.rtl?n.max-e:e},toggleHover:function(t){var e,a,n,r=this;r.hoverChangeCaption&&(n=t.val<=r.clearValue?r.fetchCaption(r.clearValue):t.caption,r.$caption.html(n)),r.hoverChangeStars&&(e=r.getWidthFromValue(r.clearValue),a=t.val<=r.clearValue?r.rtl?100-e+"%":e+"%":t.width,r.$stars.css("width",a))},calculate:function(t){var e=this,a=n(e.$element.val())?0:e.$element.val(),r=arguments.length?e.getValueFromPosition(t):a,i=e.fetchCaption(r),l=e.getWidthFromValue(r);return e.rtl&&(l=100-l),l+="%",{caption:i,width:l,val:r}},setStars:function(t){var e=this,a=arguments.length?e.calculate(t):e.calculate();e.$element.val(a.val),e.$stars.css("width",a.width),e.$caption.html(a.caption),e.cache=a},clear:function(){var t=this,e='<span class="'+t.clearCaptionClass+'">'+t.clearCaption+"</span>";t.$stars.removeClass("rated"),t.inactive||t.$caption.html(e),t.$element.val(t.clearValue),t.setStars(),t.$element.trigger("rating.clear")},reset:function(){var t=this;t.$element.val(t.initialValue),t.setStars(),t.$element.trigger("rating.reset")},update:function(t){var e=this;arguments.length&&(e.$element.val(t),e.setStars())},refresh:function(t){var e=this;arguments.length&&(e.$rating.off("rating"),void 0!==e.$clear&&e.$clear.off(),e.init($.extend(e.options,t)),e.showClear?e.$clear.show():e.$clear.hide(),e.showCaption?e.$caption.show():e.$caption.hide(),e.$element.trigger("rating.refresh"))}},$.fn.rating=function(t){var e=Array.apply(null,arguments);return e.shift(),this.each(function(){var a=$(this),n=a.data("rating"),r="object"==typeof t&&t;n||a.data("rating",n=new s(this,$.extend({},$.fn.rating.defaults,r,$(this).data()))),"string"==typeof t&&n[t].apply(n,e)})},$.fn.rating.defaults={stars:5,glyphicon:!0,symbol:null,ratingClass:"",disabled:!1,readonly:!1,rtl:!1,size:"md",showClear:!0,showCaption:!0,defaultCaption:"{rating} Stars",starCaptions:{.5:"Half Star",1:"One Star",1.5:"One & Half Star",2:"Two Stars",2.5:"Two & Half Stars",3:"Three Stars",3.5:"Three & Half Stars",4:"Four Stars",4.5:"Four & Half Stars",5:"Five Stars"},starCaptionClasses:{.5:"label label-danger",1:"label label-danger",1.5:"label label-warning",2:"label label-warning",2.5:"label label-info",3:"label label-info",3.5:"label label-primary",4:"label label-primary",4.5:"label label-success",5:"label label-success"},clearButton:'<i class="glyphicon glyphicon-minus-sign"></i>',clearButtonTitle:"Clear",clearButtonBaseClass:"clear-rating",clearButtonActiveClass:"clear-rating-active",clearCaption:"Not Rated",clearCaptionClass:"label label-default",clearValue:null,captionElement:null,clearElement:null,containerClass:null,hoverEnabled:!0,hoverChangeCaption:!0,hoverChangeStars:!0,hoverOnClear:!0},$.fn.rating.Constructor=s,$("input.rating").addClass("rating-loading"),$(document).ready(function(){var t=$("input.rating"),e=Object.keys(t).length;e>0&&t.rating()})}
</script>
</body>
</html>