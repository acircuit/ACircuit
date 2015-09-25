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
<link href="assets/css/become.css" rel="stylesheet">
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
   	<div class="main-body-div no-padding remove-padding" id="page-content-wrapper" >
   	
   			<div class="body-error error-div col-xs-12" style="background-color:white;padding-bottom: 65px;min-height:200px;">
   					<span class="become-head-div">Become An Advisor</span><br>
   					<span class="become-text-s">If you're successful in your field; give back, guide others & get paid for it!</span>
			</div>
			<div class="special-div col-xs-12" >
			<div class="container" >
   					<div class="col-xs-12" >
   						<div class="col-xs-6 f-div">
	   						<img src="assets/img/higher_studies.png"><br>
	   						<span class="f-dive-head">BE A GUIDE AND MENTOR</span><br>
	   						<span class="f-div-text">Make a difference by guiding others who need it. Earn respect and following as a mentor in the community</span>
   						</div>
   						<div class="col-xs-6 f-div">
	   						<img src="assets/img/higher_studies.png"><br>
	   						<span class="f-dive-head">BE A GUIDE AND MENTOR</span><br>
	   						<span class="f-div-text">Make a difference by guiding others who need it. Earn respect and following as a mentor in the community</span>
   						</div>
   						<div class="col-xs-6 f-div">
	   						<img src="assets/img/higher_studies.png"><br>
	   						<span class="f-dive-head">BE A GUIDE AND MENTOR</span><br>
	   						<span class="f-div-text">Make a difference by guiding others who need it. Earn respect and following as a mentor in the community</span>
   						</div>
   						<div class="col-xs-6 f-div">
	   						<img src="assets/img/higher_studies.png"><br>
	   						<span class="f-dive-head">BE A GUIDE AND MENTOR</span><br>
	   						<span class="f-div-text">Make a difference by guiding others who need it. Earn respect and following as a mentor in the community</span>
   						</div>
					</div>
			</div>
			</div>
			<div class="become-form-container col-xs-12">
				<div class="form-div col-xs-12">
				<div class="col-xs-12" style="text-align:center;margin-bottom: 30px;">
					<span class="form-head-text-b">Go Ahead, Become An Advisor TODAY!</span>
				</div>
					<form class="login-form col-xs-12 col-sm-4 col-sm-offset-4 no-padding" method="post" id="signupform" action="registration">
	      			<div class="option-signin-buuton col-xs-12 no-padding form-group">
					 		
						
									<button type="button" class="btn gt-started" style="background-color: #007ab9;margin-top: 0px;">Linkedin</button>
				 			
				 	</div>
				 	<input type="hidden" name="type" value="advisor">
				 	<div class="option-signin col-xs-12 no-padding form-group">
				 		<span class="import-text">We'll import your Linkedin education and employment history to speed up your registration.</span>
				 	</div>
				 	<div class="form-group login-form-el col-xs-12 no-padding">
      						  <input class="form-control" name="name" type="text" placeholder="Name" required aria-required="true">
				 	</div>
				 	<div class="form-group login-form-el col-xs-12 no-padding">
      						  <input class="form-control" placeholder="Email" type="email" name="email" required aria-required="true" autocomplete="off">
				 	</div>
				 	<div class="form-group login-form-el col-xs-12 no-padding">
      						  <input class="form-control" name="password" placeholder="Password" required type="password" autocomplete="off">
				 	</div>
				 	<div class="form-group login-form-el col-xs-12 no-padding squaredThree" style="margin-top: -22px;">
      						  <input type="checkbox" value="" id="terms" name="terms" required/>
								<label for="terms"></label>
								<span class="policy-text">By registering you accept the Terms & Conditions and Privacy Policy</span>
				 	</div>
				 	<div class="form-group login-form-el col-xs-12 no-padding">
      						<button type="submit" class="btn gt-started" >Get Started</button>
				 	</div>
				 	
      		</form>
      		<div class="col-xs-12" style="text-align:center;">
					<span class="form-footer-text-b" >To know more about our process and payments, visit the <a href="faq"><span class="btext">FAQ Section</span></a></span>
				</div>
				</div>
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