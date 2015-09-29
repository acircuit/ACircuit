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
							<span class="body-head-text">TERMS AND CONDITIONS</span>
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
			   			
							<span class="tnc-text">Following are the Customer terms and conditions that are to be followed by the customer while using www.advisorcircuit.com (Henceforth may be referred to as 'Website' or 'AdvisorCircuit.com') and/or any of its services.<br><br>As used, Customer means an individual who uses the Website or any services offered on it.<br><br>As used, Advisor refers to a professional who is an expert in his or her field and has offered to give his or her services on the Advisor Circuit platform.</span>				    
					    <br>
					    <span class="intro-text btext">INTRODUCTION</span>
					    <span class="tnc-text">Hello! Welcome to www.advisorcircuit.com; this platform provides you with the opportunity to connect with industry experts & advisors across different fields for advice & other services. The Website is owned, managed and operated by M/s Advisor Circuit. (Henceforth referred to as 'Advisor Circuit' or 'Company').<br><br>
					    Advisor Circuit retains the right to change or terminate any or all features or services offered on the Website, customer or advisor terms and conditions. Advisor Circuit advices customers to read the following terms and conditions thoroughly from time to time so as to be informed of any change whatsoever.<br><br>
					    YOU AGREE BY USING THIS SERVICE THAT YOU ARE ABOVE 18 YEARS OF AGE AND CAN LEGALLY ENTER INTO A LEGALLY BINDING AND ENFORCEABLE CONTRACT.</span>
					    <br><br>
					    <span class="intro-text btext">Conditions of Service</span>
					    <span class="tnc-text">By subscribing to or using any of our services you agree that you have read, understood and are bound by the Terms, regardless of how you subscribe to or use the services; if you do not wish to do the same then your only option is to discontinue the use of this Site.<br><br>
					    This agreement is a contract between the Customer and Advisor Circuit for the Customer's use of the Website or any services offered by it. By using the Website you are agreeing to and accepting and getting bound by this contract; if you do not wish to do the same then your only option is to discontinue the use of this Site.<br><br>
					    www.advisorcircuit.com is a platform that connects customers to advisors for advice & other services. Advisor Circuit facilitates this interaction between customers and advisors and enables the customer to buy such services from the advisor.<br><br>
					    Advisor Circuit conducts background checks of advisors in order to make sure that the information supplied by them is correct and up to date BUT Advisor Circuit will not be held liable for and makes no representation, warranty or guarantee whatsoever of:<br><br>
					    </span>
					    <ul class="tnc-text">
					    	<li>The exactness and correctness of the information supplied by the advisor</li>
					    	<li>Ability of the expert to provide advice</li>
					    	<li>Service or advice provided by the advisor</li>
					    	<li>Satisfaction of the customer with regard to the services delivered by the advisor</li>
					    	<li>Adequate solution of customer's question, doubt or query</li>
					    	<li>Suitability of the service or advice provided by the advisor to the customer</li>
					    	<li>Communications between the customer and the advisor</li>
					    	<li>Validity, accuracy, completeness, legality, safety, quality, applicability of any content on the Website</li>
					    </ul>
					    <br>
					    <span class="tnc-text">The Customer agrees to hereby release and hold harmless Advisor Circuit and all its members & officers from any and all causes of action, claims of any nature and damages resulting from the advice of experts accessed through the Website or from the content of the Website.</span>
					    <br><br>
					    <span class="intro-text btext">User Account</span>
					    <span class="tnc-text">Each customer at the time of registration will create a personal account with Advisor Circuit. This account will be used for all further correspondence regarding the sessions. The customer will also get regular email updates on the email address they have registered with. The customer is responsible for, maintaining the security of their account on www.advisorcircuit.com and its content, and for all activities that occur under the account and any other actions taken in connection with the Website. The customer must not describe or assign content to their account in a misleading or unlawful manner, including in a manner intended to trade on the name or reputation of others, and Advisor Circuit may change or remove any data considered inappropriate or unlawful, or otherwise likely to cause the Advisor Circuit liability. The customer must immediately notify Advisor Circuit of any unauthorized uses of their account or any other breaches of security. Advisor Circuit will not be liable for any acts or omissions by the customer, including any damages of any kind incurred as a result of such acts or omissions</span>
					    <br><br>
					    <span class="intro-text btext">Terms related to professionals requiring licensure and/or certification</span>
					    <span class="tnc-text">This section contains terms that are in addition to (and not in lieu of) any other terms appearing in this Agreement.
					    <br><br>If a Customer chooses to interact with any medical professional, mental health professional, physician, attorney or any other advisor in a field requiring licensure and/or certification, the customer's relationship, as with other advisors, is strictly with the advisor. Advisor Circuit is not involved in any way with the substance of that relationship or the advice or information given therein, and Advisor Circuit does not validate the information or advice provided to you by such an advisor.
					    <br><br>The advice or services provided by all such professionals given above and other requiring lincensure and/or certification is provided for career growth, development and informational purposes only and for no other purposes.
					    <br><br>The Customer hereby releases and agrees to hold harmless Advisor Circuit and its affiliated companies and the directors, officers, employees, agents, successors, advisors, consultants, assigns etc. of any of the foregoing, from any and all causes of action and claims of any nature resulting from any act, omission, opinion, response, advice, suggestion, information and/or service of any medical professional, mental health professional, physician, attorney or any other Expert in a field requiring licensure and/or certification, who may have been accessed from the Advisor Circuit website.
					    </span>
					    <br><br>
					    <span class="intro-text btext">Additional terms related to interactions with advisors in the field of spirituality & astrology, lifestyle or life coaching</span>
					    
					    <span class="tnc-text">This section contains terms that are in addition to (and not in lieu of) any other terms appearing in this Agreement.</span>
					    <br><br>
					    <span class="tnc-text">If a Customer chooses to interact with any Advisor in the Spirituality, Astrology, Lifestyle Section or life coach the customer's relationship (as with all other advisors) is strictly with the Advisor. Any opinion, response, advice, suggestion, prediction, information and/or other service provided by any such Advisor is provided for career development, growth and information purposes only and Advisor Circuit does not validate the information or advice provided to you by such an Advisor.</span>
					    <br><br>
					    <span class="tnc-text">The Customer hereby releases and agrees to hold harmless Advisor Circuit and its affiliated companies and the directors, officers, employees, agents, successors, advisors, consultants, assigns etc. of any of the foregoing, from any and all causes of action and claims of any nature resulting from any act, omission, opinion, response, advice, suggestion, information and/or service of any medical professional, mental health professional, physician, attorney or any other Expert in a field requiring licensure and/or certification, who may have been accessed from the Advisor Circuit website.</span>
					    <br><br>
					    <span class="intro-text btext">Advisor Circuit Intellectual Property</span>
					    
					    <span class="tnc-text">Advisor Circuit Website and any offline communication to the Customer or Advisor contains copyrighted material, trade secrets and proprietary information owned by Advisor Circuit. This Agreement does not grant to the Customer any rights to patents, copyrights, trade secrets, trade names, trademarks (whether registered or unregistered), domain names or any other rights, functions or licenses in respect of the Website or any communication whatsoever; or any material or information appearing on the website or platform; or any services offered by Advisor Circuit. The Customer may not create any derivative work or technology based upon any trade secret, intellectual property, confidential or proprietary information of Advisor Circuit. Furthermore, the Customer may not sub-license, assign, transfer, sell or make any other commercial use of his or her membership in the Website.</span>
					    <br><br>
					    <span class="tnc-text">The Customer may not adapt or use any trademark, service mark, trade name, logo or domain name similar to or likely to be confused with those of Advisor Circuit, or take any other action that infringes upon or impairs Advisor Circuit's trademark or other intellectual property rights.</span>
					    <br><br>
					    <span class="tnc-text">Advisor Circuit is the sole owner of all intellectual property, and in particular the copyright, trademarks, database and patents, in the Website and in any software, application, graphics, content and other materials used therein, including the organization and selection of the materials contained therein. In addition, except as otherwise expressly set forth or provided in this Agreement, Advisor Circuit shall retain all ownership rights in and to all content displayed on the Website or communicated otherwise including copies of data transferred or received by Customer through the Website or otherwise through any offline communication. This section shall survive expiration or termination of this Agreement.</span>
					    <br><br>
					    <span class="intro-text btext">Disclaimer of Warranty</span>
					    
					    <span class="tnc-text">Advisor Circuit makes no warranty whatsoever for any services offered on the Advisor Circuit website. www.advisorcircuit.com is a service that is offered 'as is' and Advisor Circuit will not be responsible for any error in the services, categorisation of expert on the website or information provided by the advisor to the customer through the website or any other method. The customer must exercise caution in deciding to rely on information provided by the advisor. The customer's use of Advisor Circuit website for any services offered is at the customer's own risk and advisor circuit will not be responsible or liable for any delay, or interruption in or improper use by customer, its employees or its agents of the Advisor Circuit website and materials. The customer shall not have any claim against Advisor Circuit or its affiliates, officer, directors, shareholders, employees, managers, members, agents or contractors with respect to any advice or service provided by an advisor to the customer to the fullest extent of the law, Advisor Circuit expressly disclaims all warranties or any kind, express or implied, including but not limited to, warranties of merchantability, fitness for a particular purpose, non-infringement, security or accuracy. Advisor Circuit does not make any guarantees or any representation or warranty regarding the timeliness, reliability, accuracy, completeness, correctness, or usefulness of the Advisor Circuit services or the appropriateness, fitness, or suitability of any activities to which the Advisor Circuit website services relate.</span>
					    <br><br>
					    <span class="intro-text btext">Limitation of Liability</span>
					    
					    <span class="tnc-text">Advisor Circuit is not liable to customer for any direct, indirect, incidental, consequential, punitive, or exemplary damages, including but not limited to, damages for loss of profits, goodwill, use, data, compensatory, special, or other intangible losses connected with or resulting from the customer agreement or customer's (or its employees or agents) use or misuse of the Advisor Circuit website or any of its services. Under no circumstance will Advisor Circuit's total liability of all kinds arising out of or related to customer's (or its employees or agents) use or misuse of the Advisor Circuit website, regardless of the forum and regardless of whether any action or claim is based on contract, tort, or otherwise, exceed the total amount paid by the customer to the advisor in the past 2 months from the date of claim. Customer will be solely responsible for any agreement made with an advisor and Advisor Circuit shall not be liable for enforcing any such agreement. Customer hereby releases Advisor Circuit and its affiliates, and their respective officers, directors, shareholders, employees, managers, members, agents and contractors from all manner of actions, claims or demands and from any and all losses (direct, indirect, incidental or consequential), damages, costs or expenses, including, without limitation, court costs and attorney's fees, which customer may have against one or more of the above in connection with any dispute regarding any transaction customer conducted through Advisor Circuit.</span>
					    <br><br>
					    <span class="intro-text btext">Customer Conduct</span>
					   
					    <span class="tnc-text">The Customer agrees that while using the services offered on the Advisor Circuit Website, he or she will abide by the following rules and regulations:</span>
					    <br><br>
					    <ul class="tnc-text">
					    <li>The customer agrees to pay Advisor Circuit for all services rendered to him or her and abide by the pricing terms set by the advisors while using advisorcircuit.com. The customer agrees that all interactions online or offline will be billed through advisorcircuit.com</li>
					    <li>The customer agrees to not make any deal or arrangements outside of the Advisor Circuit website or platform to have contact with advisors contacted through www.advisorcircuit.com</li>
					    <li>Customer agrees to provide Advisor Circuit an unlimited, irrevocable and royalty free license to use, reproduce, transmit, create derivative works or communicate to the public for publicity purposes, any information or content that he or she posts, transmits, receives or shares on advisorcircuit.com</li>
					    <li>Customer consents to ADVISORCIRCUIT.com collecting and processing any personal information, as per the terms of ADVISOR CIRCUIT'S Privacy Policy</li>
					    <li>Customer agrees not to undertake any action to undermine the integrity of Customer Feedback & Rating system</li>
					    <li>Customer agrees to not be involved in any activity to disrupt servers or computers connected to the Website, gain unauthorized access to servers/computers connected to the Website; transmitting unlawful libelous, privacy invading, abusive, threatening, defamatory, vulgar, obscene, racist, harmful, or otherwise objectionable material of any kind</li>
					    <li>Customer will not violate any applicable local, state, national or international law</li>
					    <li>Customer will not upload, post, e-mail, transmit or otherwise make available: (A) any information or material that infringes upon a third party right, especially intellectual property rights; (B) any third party advertisements, including banner exchange services; (C) any software viruses, Trojan horses, worms or any other malicious application; or (D) any information or material which may constitute or encourage conduct that is a criminal offense, civil wrong or which otherwise violates any applicable law</li>
					    <li>Customer agrees that opening any files sent or received across the advisorcircuit.com platform is the sole risk of the customer and Advisor Circuit takes no responsibility of the material or content transferred through these files and any damage that may result from opening these files</li>
					    <li>Customer will not stalk, threaten or harass Advisors or other Customers or infringe upon or attempt to infringe upon their privacy</li>
					    <li>Customer shall be responsible for his or her own Internet access, software, and hardware necessary to conduct a consultation with an Advisor</li>
					    <li>Customer shall be on time for any consultation or meeting scheduled with an Advisor</li>
					    <li>Customer will not disobey or breach this agreement or any other instructions issues by Advisor Circuit through the website</li>
					    </ul>
					    <br>
					    <span class="intro-text btext">Advertisements</span>
					    
					    <span class="tnc-text">Advisor Circuit may include on the sites advertisements on its own behalf or paid advertisements on behalf of third parties. By clicking on the advertisements, the customer may be redirected to a web site of the advertiser or receive other messages, information or offers from the advertiser.</span>
					    <br><br>
					    <span class="tnc-text">The Customer acknowledges and agrees that Advisor Circuit is not liable or responsible for the content, products or services of such advertisers or the web sites, links, information, messages, offers or privacy practices of such advertisers. The Customer is wholly liable for all communications and transactions with advertisers.</span>
					    <br><br>
					    <span class="intro-text btext">Termination and Modification of Service</span>
					    
					    <span class="tnc-text">The customer agrees that:</span>
					    <br><br>
					    <span class="tnc-text">Advisor Circuit retains the right and sole discretion to modify from time to time or discontinue temporarily or permanently any or all services offered on the website or the website itself; with or without notice to the customer.</span>
					    <br><br>
					    <span class="tnc-text">Advisor Circuit shall not be liable to the customer or any third party for any claims or damages arising out of any termination or suspension or any other actions taken by us in connection of any service offered on the Advisor Circuit website.</span>
					    <br><br>
					    <span class="tnc-text">Advisor Circuit does not make any guarantee that services available on the website will be timely, secure, uninterrupted or error-free.</span>
					    <br><br>
					    <span class="tnc-text">Advisor Circuit may at any time, on its sole discretion for any reason deemed suitable to it or no reason at all terminate the customer's association and limit future association with www.advisorcircuit.com.</span>
					    <br><br>
					    <span class="intro-text btext">Indemnification</span>
					    
					    <span class="tnc-text">Customer shall indemnify, defend and hold harmless Advisor Circuit and its members, managers, employees, representatives, agents and affiliates against any and all losses, damages, suits, judgments, costs and expenses (including litigation costs and attorney's fees) arising out of or in connection with any claim, suit, action, or other proceeding brought against Advisor Circuit or such party, to the extent that such a claim, suit, action or other proceeding is based on or arises from:</span>
					    <br><br>
					    <ul class="tnc-text">
					    <li>Any breach of any representation, warranty, covenant or agreement to be performed by Customer according to this Agreement;</li>
					    <li>Refusal by the customer to pay for services provided by the advisor.</li>
					    <li>Any material/content shared by customer whether through www.advisorcircuit.com or otherwise.</li>
					    </ul>
					    <br>
					    <span class="intro-text btext">No Assignment</span>
					    
					    <span class="tnc-text">Customer shall not assign his or her rights and obligations according to this Agreement, in whole or in part, whether voluntarily or by operation of law, without the prior, written consent of Advisor Circuit.</span>
					    <br><br>
					    <span class="tnc-text">Any purported assignment by Customer without the appropriate prior written approval will be null and void and of no force or effect.</span>
					    <br><br>
					    <span class="intro-text btext">Fees and Payment</span>
					    
					    <span class="tnc-text">Customers will pay the fees for the Advisor Services offered through the Advisor Circuit Website as set forth on an Advisor's profile page on the Site, plus any applicable taxes. All Fees will be collected by Advisor Circuit prior to any consultation with an Advisor.</span>
					    <br><br>
					    <span class="tnc-text">Customer may be asked to provide customary billing information, such as name, billing address and credit or debit card information, either to Advisor Circuit or its third party payment processor. Customer agrees to pay Advisor Circuit for any scheduled Advisor Services by one of the methods described on the Site. Customer hereby authorizes the collection of such amounts by charging the credit or debit card provided as part of requesting the Advisor Services, whether charged directly by Advisor Circuit or indirectly, via a third party online payment processor or by any other payment method described on the website.</span>
					    <br><br>
					    <span class="intro-text btext">Modifications to this Agreement</span>
					    
					    <span class="tnc-text">Advisor Circuit may change this Agreement or any part hereof at any time according to its absolute discretion and without any prior notice. Therefore, Customer is encouraged to check the terms of this Agreement frequently. By using the service or website after any changes, Customer agrees to be bound by such changes to this Agreement.</span>
					    <br><br>
					    <span class="tnc-text">No amendment to this Agreement will be effective unless made in writing. The paragraph headings herein are solely for the sake of convenience and will not be applied in the interpretation hereof. If any provision of this Agreement is held by a court of competent jurisdiction to be illegal, invalid, unenforceable, or otherwise contrary to law, the remaining provisions of this Agreement will remain in full force and effect.</span>
					    <br><br>
					    <span class="intro-text btext">Suggestions and Complaints</span>
					    
					    <span class="tnc-text">We at AdvisorCircuit.com would be more than happy to receive your suggestions on how to improve our service as well as to cater to your complaints. We want to make sure that nothing comes in between you and a fruitful session. For any such suggestions or complaints please email us at contactus@advisorcircuit.com and we will get back to you in no time!</span>
					    
					    
					    
					    
					    
					    </div>
					    <div role="tabpanel" class="tab-pane" id="advisor" style="padding-top: 20px">
					    
					    <span class="tnc-text">Following are the Advisor terms and conditions that are to be followed by the advisor while using www.advisorcircuit.com (Henceforth may be referred to as 'Website' or 'AdvisorCircuit.com') and/or providing any service through AdvisorCircuit.com.</span>
					    <br><br>
					    <span class="tnc-text">As used, Advisor refers to a professional who is an expert in his or her field and has offered to give his or her services on the Advisor Circuit platform. As used, Customer or User refers to an individual who uses the Website or any services offered on it. As used, Session is described as an interaction between a User and an Advisor; pre-booked by the User on the Advisor Circuit website for consultation being offered by such Advisor. Said session is undertaken through one of the modes of communication with certain terms and conditions as described below.</span>
					    <br><br>
					    <span class="intro-text btext">Introduction</span>
					    
					    <span class="tnc-text">Hello! Welcome to www.advisorcircuit.com; a platform where an Advisor may present his or her advisories and give advice, consultation or counselling to interested users through Advisor Circuit or its affiliates. Advisor Circuit facilitates this interaction between users and advisors and enables the customer to buy such services from the advisor. The Website is owned, managed and operated by M/s Advisor Circuit.</span>
					    <br><br>
					    <span class="tnc-text">Advisor Circuit retains the right to change or terminate any or all features or services offered on the Website, customer or advisor terms and conditions. Advisor Circuit advices customers to read the following terms and conditions thoroughly from time to time so as to be informed of any change whatsoever.</span>
					    <br><br>
					    <span class="tnc-text">YOU AGREE BY USING THIS SERVICE THAT YOU ARE ABOVE 18 YEARS OF AGE AND CAN LEGALLY ENTER INTO A LEGALLY BINDING AND ENFORCEABLE CONTRACT.</span>
					    <br><br>
					    <span class="intro-text btext">Conditions of Service</span>
					    
					    <span class="tnc-text">By accepting to be an Advisor on Advisor Circuit you agree that you have read, understood and are bound by the Terms, regardless of how you use this platform; if you do not wish to do the same then your only option is to discontinue the use of this Website.</span>
					    <br><br>
					    <span class="tnc-text">This agreement is a contract between the Advisor and Advisor Circuit for the Advisor's use of the Website or offering any services through it.</span>
					    <br><br>
					    <span class="tnc-text">Advisor Circuit conducts no background checks on users in order to make sure that the information supplied by them is correct and up to date and Advisor Circuit will not be held liable for and makes no representation, warranty or guarantee whatsoever of:</span>
					    <br><br>
					    <ul class="tnc-text">
					    <li>The exactness and correctness of the information supplied by the user</li>
					    <li>Communications between the user and the advisor</li>
					    <li>Validity, accuracy, completeness, legality, safety, quality, applicability of any content on the Website</li>
					    </ul>
					    <br><br>
					    <span class="tnc-text">The Advisor agrees to hereby release and hold harmless Advisor Circuit and all its members & officers from any and all causes of action, claims of any nature and damages resulting from the advice of experts accessed through the Website or from the content of the Website.</span>
					    <br><br>
					    <span class="intro-text btext">Advisor Profile</span>
					    
					    <span class="tnc-text">It would be the duty of every advisor to:</span>
					    <br>
					    <ul class="tnc-text">
					    <li>Make sure that the information given in their profile is true to his or her knowledge.</li>
					    <li>Provide prompt updates to Advisor Circuit for any changes in the Advisor's Profile</li>
					    <li>Ensure that the information in his or her profile is updated as per current state of affairs.</li>
					    </ul>
					    <br>
					    <span class="intro-text btext">Pricing the Sessions</span>
					    
					    <span class="tnc-text">A price will be allotted to each advisor by the Advisor Circuit Team which can be increased over time depending on their performance on the platform. The price will depend on various factors described in the Advisor registration form.</span>
					    <br><br>
					    <span class="intro-text btext">Cancelling a Session</span>
					    
					    <span class="tnc-text">In the event of the cancellation of a confirmed session by the advisor, it is the duty of the advisor to notify the Advisor Circuit as soon as possible.</span>
					    <br><br>
					     <span class="intro-text btext">Reviews & Ratings</span>
					     
					      <span class="tnc-text">The users will have an option to review and rate an advisor post having a session with them, based on their session experience</span>
					      <br><br>
					      <span class="tnc-text">The ratings and reviews will be visible to all visitors on the online site as a means to help them select the best advisor for their doubts.</span>
					      <br><br>
					      <span class="intro-text btext">Remuneration</span>
					      
					      <span class="tnc-text">Remuneration to the advisor will include pay per minute model based price for sessions delivered minus Advisor Circuit Fee, TDS to the government and any discounts due to cancellations. Advisor Circuit will maintain a monthly tab on this due amount. Non-monetary incentives can also be offered to advisors.</span>
					      <br><br>
					      <span class="tnc-text">The amount due to the advisor will be paid on the last working day of each month through a bank transfer.</span>
					      <br><br>
					      <span class="intro-text btext">Non Availability of Advisor</span>
					      
					      <span class="tnc-text">The advisor should notify Advisor Circuit if he or she would not be available to reply to users or hold sessions for a considerable amount of time which is a period greater than 15 days.</span>
					      <br><br>
					      <span class="tnc-text">The said advisor would be obliged to hold all pending sessions in the leave duration failing which conditions of cancellation will apply. The Advisor profile would accordingly be edited to inform potential customers that the advisor is temporary unavailable.</span>
					      <br><br>
					      <span class="intro-text btext">Termination Policy</span>
					      
					      <span class="tnc-text">The Advisor can terminate his or her association with Advisor Circuit at any point of time, without any notice period, if there are no pending booked sessions that the advisor needs to deliver. If such sessions exist, then he or she will have to complete the session/sessions before terminating the agreement. If the advisor fails to do so, any amount due to him or her for previous sessions in the form of remuneration will be retained by Advisor Circuit.</span>
					      <br><br>
					      <span class="tnc-text">Advisor Circuit can terminate association with an advisor without any prior notification, notice period and reason. Any dues pending to the advisor (in the form of remuneration or any such amount) will be duly paid within one month of termination.</span>
					      <br><br>
					      <span class="tnc-text">On termination of association, the profile of the advisor will be removed from the website www.advisorcircuit.com within 7 working days.</span>
					      <br><br>
					      <span class="intro-text btext">Privacy Policy</span>
					      
					      <span class="tnc-text">At no point will the advisor's personal information (including contact number, email address and other such information) be revealed by Advisor Circuit to any third party.</span>
					      <br><br>
					      <span class="tnc-text">Official accounts assigned by Advisor Circuit shall be used for conducting of sessions and related communications.</span>
					      <br><br>
					      <span class="intro-text btext">Disclaimer of Warranty</span>
					      
					      <span class="tnc-text">Advisor Circuit and its associated vendors hereby disclaim all warranties of any kind, express or implied, including, without limitation, the warranties of merchantability, fitness for a particular purpose and non-infringement. Advisor Circuit does not make any warranty that the Website will be error free or that access thereto will be continuous or uninterrupted. Usage of the Website is at the advisor's own discretion and risk.</span>
					      <br><br>
					      <span class="intro-text btext">Limitation of Liability</span>
					      
					      <span class="tnc-text">IN NO EVENT SHALL ADVISOR CIRCUIT BE LIABLE FOR ANY DAMAGE, CLAIM OR LOSS INCURRED BY ADVISOR, INCLUDING WITHOUT LIMITATION COMPENSATORY, INCIDENTAL, DIRECT, INDIRECT, SPECIAL, CONSEQUENTIAL OR EXEMPLARY DAMAGES, IRRESPECTIVE OF WHETHER ADVISOR CIRCUIT HAVE BEEN INFORMED OF, KNEW OF, OR SHOULD HAVE KNOWN OF THE LIKELIHOOD OF SUCH DAMAGES. THIS LIMITATION APPLIES TO ALL CAUSES OF ACTION IN THE AGGREGATE INCLUDING WITHOUT LIMITATION BREACH OF CONTRACT, BREACH OF WARRANTY, DEFAMATION, NEGLIGENCE, STRICT LIABILITY, MISREPRESENTATION, AND OTHER TORTS, AS WELL AS THIRD-PARTY CLAIMS. IF THE WARRANTY EXCLUSIONS OR LIMITATIONS OF LIABILITY SET FORTH IN THIS USE AGREEMENT ARE FOR ANY REASON HELD UNENFORCEABLE OR INAPPLICABLE, THE ADVISOR AGREES THAT OUR AGGREGATE LIABILITY SHALL NOT EXCEED INR 5,000.</span>
					      <br><br>
					      <span class="intro-text btext">Indemnification</span>
					      
					      <span class="tnc-text">Advisor will indemnify, defend and hold harmless Advisor Circuit, and its members, managers, employees, representatives, agents and Affiliates against any and all losses, damages, suits, judgments, costs and expenses (including litigation costs and attorneys' fees) arising out of or in connection with any claim, suit, action, or other proceeding brought against Advisor Circuit or such party, to the extent that such claim, suit, action or other proceeding is based on or arises from: (a) any breach of any representation, warranty, covenant or agreement to be performed by Advisor according to this Agreement; (b) Advisor's provision of consultation or counselling to any third party, regardless of whether or not they are Customers of the Advisor Circuit facility; or (c) any materials that Advisor has posted to www.advisorcircuit.com and/or any content on Advisor's Website or otherwise provided to Users.</span>
					      <br><br>
					      <span class="intro-text btext">No Assignment</span>
					      
					      <span class="tnc-text">Advisor shall not assign his or her rights and obligations according to this Agreement, in whole or in part, whether voluntarily or by operation of law, without the prior, written consent of Advisor Circuit. Any purported assignment by Advisor without the appropriate prior written approval of Advisor Circuit will be null and void and of no force or effect.</span>
					      <br><br>
					      <span class="intro-text btext">Limited License</span>
					      
					      <span class="tnc-text">Advisor Circuit grants Advisor a nonexclusive, revocable right to use the Site provided that Advisor does not copy, modify, create a derivative work of, reverse engineer, disassemble or otherwise attempt to discover any source code, or breach this Agreement.</span>
					      <br><br>
					      <span class="intro-text btext">Account Terms</span>
					      
					      <span class="tnc-text">The advisor is responsible for, maintaining the security of their account on www.advisorcircuit.com and its content, and for all activities that occur under the account and any other actions taken in connection with the Website. The advisor must not describe or assign content to their account in a misleading or unlawful manner, including in a manner intended to trade on the name or reputation of others, and Advisor Circuit may change or remove any data considered inappropriate or unlawful, or otherwise likely to cause the Advisor Circuit liability. The advisor must immediately notify Advisor Circuit of any unauthorized uses of their account or any other breaches of security. Advisor Circuit will not be liable for any acts or omissions by the advisor, including any damages of any kind incurred as a result of such acts or omissions</span>
					      <br><br>
					      <span class="intro-text btext">Advisor Conduct</span>
					      
					      <span class="tnc-text">Advisor hereby agrees to:</span>
					      <br>
					      <ul class="tnc-text">
					      <li>Maintain such skills, qualifications and licenses, including remaining in good standing as licensed professional in any jurisdiction, as may be required by that jurisdiction, where Advisor practices his or her profession</li>
					      <li>Provide only true and correct information to Customers and not to mislead Customers to believe that Advisor can provide advice, consultation or counselling which is outside Advisor's field of expertise</li>
					      <li>Respond to each session request and by the customer within 48 hours of such request being submitted to the Advisor</li>
					      <li>Maintain appropriate equipment and internet connections in order to fulfil the sessions through email, audio and web chat conferences through accounts hosted by the Advisor Circuit.</li>
					      <li>Endeavour to accept as many requests for sessions as reasonably possible, provided, however, that Advisor shall not be expected to accept requests for sessions in situations that may place Advisor's business at risk, including competitive risks. Advisor Circuit will not be responsible for the verification of the identities of customers</li>
					      <li>All contact between Advisors, customers and any other users who are introduced through the Advisor Circuit website must be conducted only through Advisor Circuit. Any exchange of contact information or communication outside of the Advisor Circuit, whether via personal email, phone, in person or any other means, is strictly prohibited and is a violation of this Agreement</li>
					      <li>Advisor will not take any actions which may undermine, disrupt or manipulate the integrity of the Customer feedback (rating) system on the Site</li>
					      <li>Advisor will not violate any applicable local, state, national or international law, statute, ordinance, rule, regulation or ethical code</li>
					      <li>Advisor will not participate in Advisor Circuit in any manner that is in violation of the rules, regulations or code of conduct of his or her current employer(s), including not divulging any restricted, confidential or otherwise proprietary information of any sort</li>
					      <li>Advisor will not upload, post, e-mail, transmit or otherwise make available: (a) any information or material that infringes a third party right, especially copyright or other intellectual property rights; (b) any third party advertisements; (c) any information or material which may constitute or encourage conduct that is a criminal offense or civil wrong or otherwise violates any applicable law</li>
					      <li>Advisor will not impersonate any person or entity, or make any false statement regarding Advisor's employment, agency or affiliation with any person or entity.</li>
					      <li>Advisor will not harm, stalk, threaten or harass Customers or other Advisors or invade or attempt to invade their privacy</li>
					      <li>Advisor will not disclose any information that was provided to Advisor by a Customer and will use his or her best efforts to guard Customer's privacy</li>
					      <li>Advisor Circuit may review the Advisor's personal profile and amend any typing or spelling errors. Advisor Circuit may, in its absolute discretion, remove or refuse to post or transmit in part or full any content uploaded by the Advisor. In such case, Advisor Circuit may, but is under no obligation to, notify Advisor of such removal or refusal. Without limiting the foregoing, Advisor Circuit may remove any content violating this Agreement. The Advisor will bear all the risks associated with uploading and transmitting material utilizing the Advisor Circuit Website, including reliance on its accuracy, reliability or legality.</li>
					      </ul>
					      <br><br>
					      <span class="intro-text btext">Use of Site</span>
					      
					      <span class="tnc-text">Advisor agrees not to use the site to:</span>
					      <br>
					      <ul class="tnc-text">
					      <li>Upload, post, email, transmit or otherwise make available any Content that is unlawful, harmful, threatening, abusive, harassing, tortuous, defamatory, vulgar, obscene, libellous, invasive of another's privacy, hateful, or racially, ethnically or otherwise objectionable</li>
					      <li>Forge headers or otherwise manipulate identifiers in order to disguise the origin of any Content transmitted through the Site</li>
					      <li>Upload, post, transmit or otherwise make available any unsolicited or unauthorized advertising, promotional materials or any other form of solicitation</li>
					      <li>Upload, post, transmit or otherwise make available any material that contains software viruses or any other computer code, files or programs designed to interrupt, destroy or limit the functionality of any computer software or hardware or telecommunications equipment</li>
					      <li>Interfere with or disrupt the Site or servers or networks connected to the Site, or disobey any requirements, procedures, policies or regulations of networks connected to the Site</li>
					      <li>Collect or store personal data about other users in connection with the prohibited conduct and activities set forth above</li>
					      <li>Advisor Circuit assumes no responsibility for monitoring the Site for inappropriate Content or conduct. If at any time Advisor Circuit chooses, in its sole discretion, to monitor the Site, Advisor Circuit nonetheless assume no responsibility for \ the Content, no obligation to modify or remove any inappropriate Content, and no responsibility for the conduct of the User submitting any such Content</li>
					      <li>Advisor is solely responsible for their use of the Site, the Content that the Advisor posts on or through the Site, and any material or information that the Advisor transmits to other Members and for their interactions with other Users.</li>
					      <li>Advisor will not attempt to gain unauthorized access to other computer systems or networks connected to the Site, and will not transmit "junk mail", or any unsolicited mass distribution of e-mail or bulletin board postings.</li>
					      <li>Advisor agrees to comply with all applicable laws regarding use of this Site. Advisor may not use this Site to solicit the performance of any illegal activity or other activity which infringes the rights of Advisor Circuit or others.</li>
					      <li>Advisor agrees not to use any device, software or routine to interfere or attempt to interfere with the proper working of the Site or any other person's use of the Site</li>
					      <li>Advisor may not attempt to gain unauthorized access to any portion or feature of the Site by hacking, password "mining" or other illegitimate method of gaining access to restricted data.</li>
					      </ul>
					      <br><br>
					      <span class="intro-text btext">Advertisements</span>
					      
					      <span class="tnc-text">Advisor Circuit may include on the sites advertisements on its own behalf or paid advertisements on behalf of third parties. By clicking on the advertisements, the advisor may be redirected to a web site of the advertiser or receive other messages, information or offers from the advertiser.</span>
					      <br><br>
					      <span class="tnc-text">The advisor acknowledges and agrees that Advisor Circuit is not liable or responsible for the content, products or services of such advertisers or the web sites, links, information, messages, offers or privacy practices of such advertisers. The advisor is wholly liable for all communications and transactions with advertisers.</span>
					      <br><br>
					      <span class="intro-text btext">Exclusive Arrangement</span>
					      
					      <span class="tnc-text">Advisors will not conduct sessions or arrange consultations with customers gained through Advisor Circuit outside the purview of Advisor Circuit.</span>
					      <br><br>
					      <span class="intro-text btext">Confidential Information</span>
					      
					      <span class="tnc-text">Advisor shall not, without prior written authorization of Advisor Circuit, disclose to anyone outside Advisor Circuit or use in other than Advisor Circuit any information, documentation or materials provided by Advisor Circuit. Such materials shall be considered confidential and proprietary, including without limitation, these Advisor Terms and Conditions and any other information, documentation and materials not generally disclosed by Advisor Circuit outside the Advisor Circuit Facility. Advisor shall use information received from Advisor Circuit only to exercise rights and perform obligations under the Advisor Terms and Conditions.</span>
					      <br><br>
					      <span class="intro-text btext">Publicity</span>
					      
					      <span class="tnc-text">From time to time Advisor Circuit may produce advertising material for publication detailing the Advisor Circuit Facility and particular Advisors. This material may include a particular Advisor's full name, location, image(s) and job title/business name in conjunction with Advisor Circuit marketing materials, including www.advisorcircuit.com. Advisor hereby permits the use of such information as is reasonably necessary for these purposes and consents to the publication of relevant text and images in Advisor Circuit's materials and publicity.</span>
					      <br><br>
					      <span class="tnc-text">If Advisor fails to comply with the any of the above sections, Advisor Circuit may terminate the Advisor Agreement immediately without prior notice and withhold any payments due to such advisor.</span>
					      <br><br>
					      <span class="intro-text btext">Suggestions and Complaints</span>
					      
					      <span class="tnc-text">We at AdvisorCircuit.com would be more than happy to receive your suggestions on how to improve our service as well as to cater to your complaints. We want to make sure that nothing comes in between you and a fruitful session. For any such suggestions or complaints please email us at contactus@advisorcircuit.com and we will get back to you in no time!</span>
					      
					      
					     
					    
					    
					    			   			</div>
					    
					    
					    </div>
					    
					  </div>
   
			</div>
	 <%@include file="/footer.jsp" %>
</div>
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